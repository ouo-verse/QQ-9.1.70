package com.tencent.soter.core.sotercore;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.model.ConstantsSoter;
import com.tencent.soter.core.model.ISoterExParameters;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SReporter;
import com.tencent.soter.core.model.SoterCoreResult;
import com.tencent.soter.core.model.SoterDelegate;
import com.tencent.soter.core.model.SoterErrCode;
import com.tencent.soter.core.model.SoterExParametersTrebleImpl;
import com.tencent.soter.core.model.SoterPubKeyModel;
import com.tencent.soter.soterserver.ISoterService;
import com.tencent.soter.soterserver.SoterExtraParam;
import com.tencent.soter.soterserver.SoterSessionResult;
import com.tencent.soter.soterserver.SoterSignResult;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SoterCoreTreble extends SoterCoreBase implements ConstantsSoter, SoterErrCode {
    static IPatchRedirector $redirector_ = null;
    private static final int CONNECTED = 2;
    private static final int CONNECTING = 1;
    protected static final int DEFAULT_BLOCK_TIME = 3000;
    private static final int DELAY_THRESHOLD = 30;
    private static final int DISCONNECT = 0;
    private static final int INITIAL_FIB_VALUE = 3;
    public static final String TAG = "Soter.SoterCoreTreble";
    private static int connectState;
    private static boolean isInitializeSuccessed;
    private static boolean isInitializing;
    private static final Object lock;
    protected static ISoterService mSoterService;
    private static SyncJob syncJob;
    public static int uid;
    private boolean canRetry;
    private int disconnectCount;
    private boolean hasBind;
    private long lastBindTime;
    private Context mContext;
    private IBinder.DeathRecipient mDeathRecipient;
    private Handler mMainLooperHandler;
    private ServiceConnection mServiceConnection;
    private int noResponseCount;
    private Runnable retryFunc;
    private SoterCoreTrebleServiceListener serviceListener;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17748);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
            return;
        }
        connectState = 0;
        isInitializing = false;
        isInitializeSuccessed = false;
        lock = new Object();
        syncJob = new SyncJob();
        uid = 0;
    }

    public SoterCoreTreble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.canRetry = true;
        this.disconnectCount = 0;
        this.noResponseCount = 3;
        this.lastBindTime = 0L;
        this.hasBind = false;
        this.mMainLooperHandler = new Handler(Looper.getMainLooper());
        this.mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterCoreTreble.this);
                }
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                SLogger.i(SoterCoreTreble.TAG, "soter: binder died", new Object[0]);
                ISoterService iSoterService = SoterCoreTreble.mSoterService;
                if (iSoterService != null && iSoterService.asBinder() != null) {
                    SoterCoreTreble.mSoterService.asBinder().unlinkToDeath(SoterCoreTreble.this.mDeathRecipient, 0);
                    SoterCoreTreble.mSoterService = null;
                    if (SoterCoreTreble.this.serviceListener != null) {
                        SoterCoreTreble.this.serviceListener.onServiceBinderDied();
                    }
                    synchronized (SoterCoreTreble.lock) {
                        int unused = SoterCoreTreble.connectState = 0;
                        SoterCoreTreble.this.unbindService();
                        SoterCoreTreble.this.rebindService();
                    }
                }
            }
        };
        this.mServiceConnection = new ServiceConnection() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterCoreTreble.this);
                }
            }

            @Override // android.content.ServiceConnection
            public void onBindingDied(ComponentName componentName) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) componentName);
                    return;
                }
                SLogger.i(SoterCoreTreble.TAG, "soter: binding died", new Object[0]);
                int unused = SoterCoreTreble.connectState = 0;
                SoterCoreTreble.mSoterService = null;
                if (SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount) > 30) {
                    SLogger.i(SoterCoreTreble.TAG, "soter: rest fib, now is delay %dS", Long.valueOf(SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount)));
                    SoterCoreTreble.this.noResponseCount = 3;
                    SoterCoreTreble.this.mMainLooperHandler.removeCallbacks(SoterCoreTreble.this.retryFunc);
                }
                SoterCoreTreble.this.unbindService();
                SoterCoreTreble.this.rebindService();
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                    return;
                }
                SLogger.i(SoterCoreTreble.TAG, "soter: onServiceConnected", new Object[0]);
                synchronized (SoterCoreTreble.lock) {
                    int unused = SoterCoreTreble.connectState = 2;
                }
                SoterCoreTreble.this.noResponseCount = 3;
                SoterCoreTreble.this.mMainLooperHandler.removeCallbacks(SoterCoreTreble.this.retryFunc);
                try {
                    iBinder.linkToDeath(SoterCoreTreble.this.mDeathRecipient, 0);
                    SoterCoreTreble.mSoterService = ISoterService.Stub.asInterface(iBinder);
                } catch (RemoteException e16) {
                    SLogger.e(SoterCoreTreble.TAG, "soter: Binding deathRecipient is error - RemoteException" + e16.toString(), new Object[0]);
                    SReporter.reportError(101, "SoterService interface: ISoterService.Stub.asInterface.", e16);
                }
                if (SoterCoreTreble.this.serviceListener != null) {
                    SoterCoreTreble.this.serviceListener.onServiceConnected();
                }
                SLogger.i(SoterCoreTreble.TAG, "soter: Binding is done - Service connected", new Object[0]);
                long elapsedRealtime = SystemClock.elapsedRealtime() - SoterCoreTreble.this.lastBindTime;
                if (elapsedRealtime > 3000) {
                    SReporter.reportError(105, "bind SoterService out time: " + elapsedRealtime);
                }
                SoterCoreTreble.syncJob.countDown();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    synchronized (SoterCoreTreble.lock) {
                        SLogger.i(SoterCoreTreble.TAG, "soter: unBinding is done - Service disconnected", new Object[0]);
                        int unused = SoterCoreTreble.connectState = 0;
                        SoterCoreTreble.mSoterService = null;
                        if (SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount) > 30) {
                            SLogger.i(SoterCoreTreble.TAG, "soter: rest fib, now is delay %dS", Long.valueOf(SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount)));
                            SoterCoreTreble.this.noResponseCount = 3;
                            SoterCoreTreble.this.mMainLooperHandler.removeCallbacks(SoterCoreTreble.this.retryFunc);
                        }
                        if (SoterCoreTreble.this.serviceListener != null) {
                            SoterCoreTreble.this.serviceListener.onServiceDisconnected();
                        }
                        SoterCoreTreble.this.rebindService();
                        SoterCoreTreble.syncJob.countDown();
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 3, (Object) this, (Object) componentName);
            }
        };
        this.retryFunc = new Runnable() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterCoreTreble.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (SoterCoreTreble.this.canRetry && SoterCoreTreble.isInitializeSuccessed) {
                    SoterCoreTreble.access$508(SoterCoreTreble.this);
                    if (SoterCoreTreble.connectState != 2) {
                        SLogger.i(SoterCoreTreble.TAG, "soter: retryFunc bindservice no response: %d delay: %d", Integer.valueOf(SoterCoreTreble.this.noResponseCount), Long.valueOf(SoterCoreTreble.getFib(SoterCoreTreble.this.noResponseCount)));
                        SoterCoreTreble.this.bindService(true);
                        return;
                    } else {
                        SLogger.i(SoterCoreTreble.TAG, "soter: retryFunc stop, CONNECTED", new Object[0]);
                        return;
                    }
                }
                SLogger.i(SoterCoreTreble.TAG, "soter: retryFunc stop, canRetry:%b isInitializeSuccessed:%b", Boolean.valueOf(SoterCoreTreble.this.canRetry), Boolean.valueOf(SoterCoreTreble.isInitializeSuccessed));
            }
        };
    }

    static /* synthetic */ int access$508(SoterCoreTreble soterCoreTreble) {
        int i3 = soterCoreTreble.noResponseCount;
        soterCoreTreble.noResponseCount = i3 + 1;
        return i3;
    }

    private boolean checkIfServiceNull() {
        if (mSoterService != null) {
            return false;
        }
        SLogger.w(TAG, "soter: soter service not found", new Object[0]);
        SoterCoreTrebleServiceListener soterCoreTrebleServiceListener = this.serviceListener;
        if (soterCoreTrebleServiceListener != null) {
            soterCoreTrebleServiceListener.onNoServiceWhenCalling();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getFib(long j3) {
        long j16 = 0;
        if (j3 < 0) {
            return -1L;
        }
        if (j3 == 0) {
            return 0L;
        }
        long j17 = 1;
        if (j3 == 1 || j3 == 2) {
            return 1L;
        }
        int i3 = 3;
        long j18 = 1;
        while (i3 <= j3) {
            j16 = j17 + j18;
            i3++;
            j17 = j18;
            j18 = j16;
        }
        return j16;
    }

    public static boolean isInitializing() {
        return isInitializing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rebindService() {
        if (!this.canRetry) {
            return;
        }
        this.disconnectCount++;
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.lastBindTime) / 1000;
        long fib = getFib(this.disconnectCount);
        long j3 = fib - elapsedRealtime;
        SLogger.i(TAG, "fib: %s, rebind delay: %sS", Long.valueOf(fib), Long.valueOf(j3));
        if (j3 <= 0) {
            bindService();
        } else {
            this.mMainLooperHandler.postDelayed(new Runnable() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SoterCoreTreble.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        SoterCoreTreble.this.bindServiceIfNeeded();
                    }
                }
            }, j3 * 1000);
        }
    }

    private void resetDisconnectCount() {
        this.disconnectCount = 0;
    }

    private void scheduleTimeoutTask(boolean z16) {
        long fib = getFib(this.noResponseCount);
        SLogger.i(TAG, "soter: scheduleTimeoutTask isCycle:%b noResponseCount:%d checkDelay:%d ", Boolean.valueOf(z16), Integer.valueOf(this.noResponseCount), Long.valueOf(fib));
        if (z16 || this.noResponseCount <= 3) {
            this.mMainLooperHandler.postDelayed(this.retryFunc, fib * 1000);
        }
    }

    public void bindService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            bindService(false);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void bindServiceIfNeeded() {
        ISoterService iSoterService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            if (connectState == 2 && (iSoterService = mSoterService) != null && iSoterService.asBinder() != null && mSoterService.asBinder().isBinderAlive() && mSoterService.asBinder().pingBinder()) {
                SLogger.i(TAG, "no need rebind", new Object[0]);
                return;
            }
            SLogger.i(TAG, "soter: bindServiceIfNeeded try to bind", new Object[0]);
            bindService();
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: bindServiceIfNeeded fail: ");
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public byte[] finishSign(long j3) throws Exception {
        SoterSignResult finishSign;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (byte[]) iPatchRedirector.redirect((short) 24, (Object) this, j3);
        }
        SLogger.i(TAG, "soter: finishSign in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return null;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return null;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        byte[] bArr = new byte[0];
        try {
            finishSign = mSoterService.finishSign(j3);
            bArr = finishSign.exportData;
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: finishSign fail: ");
            SReporter.reportError(101, "SoterService aidl: finishSign.", e16);
        }
        if (finishSign.resultCode != 0) {
            SReporter.reportError(102, "SoterService aidl: finishSign. Result.resultCode is not 0");
            throw new Exception("finishSign error");
        }
        return bArr;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult generateAppGlobalSecureKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        SLogger.i(TAG, "soter: generateAppSecureKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return new SoterCoreResult(4);
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return new SoterCoreResult(4);
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            return new SoterCoreResult(4);
        }
        try {
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: generateAppSecureKey fail: ");
            SReporter.reportError(101, "SoterService aidl: generateAppSecureKey.", e16);
        }
        if (mSoterService.generateAppSecureKey(uid) == 0) {
            return new SoterCoreResult(0);
        }
        SReporter.reportError(102, "SoterService aidl: generateAppSecureKey. Return is not 0");
        return new SoterCoreResult(4);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult generateAuthKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        SLogger.i(TAG, "soter: generateAuthKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return new SoterCoreResult(6);
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return new SoterCoreResult(6);
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return new SoterCoreResult(6);
        }
        try {
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: generateAuthKey fail: ");
            SReporter.reportError(101, "SoterService aidl: generateAuthKey.", e16);
        }
        if (mSoterService.generateAuthKey(uid, str) == 0) {
            return new SoterCoreResult(0);
        }
        SReporter.reportError(102, "SoterService aidl: generateAuthKey. Return is not 0");
        return new SoterCoreResult(6);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterPubKeyModel getAppGlobalSecureKeyModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (SoterPubKeyModel) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        SLogger.i(TAG, "soter: getAppGlobalSecureKeyModel in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return null;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return null;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            byte[] bArr = mSoterService.getAppSecureKey(uid).exportData;
            if (bArr != null && bArr.length > 0) {
                return SoterCoreBase.retrieveJsonFromExportedData(bArr);
            }
            SLogger.e(TAG, "soter: soter: key can not be retrieved", new Object[0]);
            SReporter.reportError(102, "SoterService aidl: getAppSecureKey. Result.exportData is null");
            return null;
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: getAppGlobalSecureKeyModel fail: ");
            SReporter.reportError(101, "SoterService aidl: getAppSecureKey.", e16);
            return null;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public Signature getAuthInitAndSign(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Signature) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        }
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterPubKeyModel getAuthKeyModel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (SoterPubKeyModel) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        SLogger.i(TAG, "soter: getAuthKeyModel in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return null;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return null;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            byte[] bArr = mSoterService.getAuthKey(uid, str).exportData;
            if (bArr != null && bArr.length > 0) {
                return SoterCoreBase.retrieveJsonFromExportedData(bArr);
            }
            SLogger.e(TAG, "soter: key can not be retrieved", new Object[0]);
            SReporter.reportError(102, "SoterService aidl: getAuthKey. Result.exportData is null");
            return null;
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: getAuthKeyModel fail: ");
            SReporter.reportError(101, "SoterService aidl: getAuthKey.", e16);
            return null;
        }
    }

    public int getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        SLogger.i(TAG, "soter: getVersion in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return 0;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return 0;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return 0;
        }
        try {
            return mSoterService.getVersion();
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: getVersion fail: ");
            SReporter.reportError(101, "SoterService aidl: getVersion.", e16);
            return 0;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean hasAppGlobalSecureKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        SLogger.i(TAG, "soter: hasAppGlobalSecureKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return false;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return false;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return false;
        }
        try {
            return mSoterService.hasAskAlready(uid);
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: hasAppGlobalSecureKey fail: ");
            SReporter.reportError(101, "SoterService aidl: hasAskAlready.", e16);
            return false;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean hasAuthKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).booleanValue();
        }
        SLogger.i(TAG, "soter: hasAuthKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return false;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return false;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return false;
        }
        try {
            return mSoterService.hasAuthKey(uid, str);
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: hasAuthKey fail: ");
            SReporter.reportError(101, "SoterService aidl: hasAuthKey.", e16);
            return false;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public Signature initAuthKeySignature(String str) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Signature) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        }
        return null;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterSessionResult initSigh(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (SoterSessionResult) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2);
        }
        SLogger.i(TAG, "soter: initSigh in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return null;
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return null;
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            return mSoterService.initSigh(uid, str, str2);
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: initSigh fail: ");
            SReporter.reportError(101, "SoterService aidl: initSigh.", e16);
            return null;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean initSoter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context)).booleanValue();
        }
        this.mContext = context;
        SLogger.i(TAG, "soter: initSoter in", new Object[0]);
        isInitializing = true;
        syncJob.doAsSyncJob(3000L, new Runnable() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterCoreTreble.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    SoterCoreTreble.this.bindServiceIfNeeded();
                    SLogger.i(SoterCoreTreble.TAG, "soter: initSoter binding", new Object[0]);
                }
            }
        });
        isInitializing = false;
        if (connectState == 2) {
            SLogger.i(TAG, "soter: initSoter finish", new Object[0]);
            isInitializeSuccessed = true;
            return true;
        }
        connectState = 0;
        SLogger.e(TAG, "soter: initSoter error", new Object[0]);
        SReporter.reportError(102, "bind SoterService fail: DISCONNECT");
        return false;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isAppGlobalSecureKeyValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        SLogger.i(TAG, "soter: isAppGlobalSecureKeyValid in", new Object[0]);
        if (!hasAppGlobalSecureKey() || getAppGlobalSecureKeyModel() == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isAuthKeyValid(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        SLogger.i(TAG, "soter: isAuthKeyValid in", new Object[0]);
        if (hasAuthKey(str) && getAuthKeyModel(str) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isNativeSupportSoter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (SoterDelegate.isTriggeredOOM()) {
            SLogger.w(TAG, "soter: the device has already triggered OOM. mark as not support", new Object[0]);
            return false;
        }
        return true;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public boolean isTrebleServiceConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (connectState == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public void releaseTrebleServiceConnection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.canRetry = false;
            unbindService();
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult removeAppGlobalSecureKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        SLogger.i(TAG, "soter: removeAppGlobalSecureKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return new SoterCoreResult(5);
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return new SoterCoreResult(5);
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return new SoterCoreResult(5);
        }
        try {
            if (mSoterService.removeAllAuthKey(uid) == 0) {
                return new SoterCoreResult(0);
            }
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: removeAppGlobalSecureKey fail: ");
        }
        return new SoterCoreResult(5);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public SoterCoreResult removeAuthKey(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (SoterCoreResult) iPatchRedirector.redirect((short) 17, this, str, Boolean.valueOf(z16));
        }
        SLogger.i(TAG, "soter: removeAuthKey in", new Object[0]);
        if (!isNativeSupportSoter()) {
            return new SoterCoreResult(7);
        }
        if (this.mContext == null) {
            SLogger.w(TAG, "soter: context is null", new Object[0]);
            return new SoterCoreResult(7);
        }
        bindServiceIfNeeded();
        if (checkIfServiceNull()) {
            SLogger.w(TAG, "soter: soter service not found", new Object[0]);
            return new SoterCoreResult(7);
        }
        try {
            if (mSoterService.removeAuthKey(uid, str) == 0) {
                if (z16) {
                    if (mSoterService.removeAllAuthKey(uid) == 0) {
                        return new SoterCoreResult(0);
                    }
                    return new SoterCoreResult(5);
                }
                return new SoterCoreResult(0);
            }
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: removeAuthKey fail: ");
        }
        return new SoterCoreResult(7);
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public void setTrebleServiceListener(SoterCoreTrebleServiceListener soterCoreTrebleServiceListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) soterCoreTrebleServiceListener);
        } else {
            this.serviceListener = soterCoreTrebleServiceListener;
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public void triggerTrebleServiceConnecting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            resetDisconnectCount();
            bindServiceIfNeeded();
        }
    }

    public void unbindService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.hasBind) {
            try {
                try {
                    this.mContext.unbindService(this.mServiceConnection);
                } catch (Exception e16) {
                    SLogger.printErrStackTrace(TAG, e16, "");
                }
            } finally {
                this.hasBind = false;
            }
        }
    }

    @Override // com.tencent.soter.core.sotercore.SoterCoreBase
    public void updateExtraParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        try {
            new BaseThread(new Runnable() { // from class: com.tencent.soter.core.sotercore.SoterCoreTreble.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SoterCoreTreble.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        ISoterService iSoterService = SoterCoreTreble.mSoterService;
                        if (iSoterService == null) {
                            SLogger.e(SoterCoreTreble.TAG, "soter: updateExtraParam fail, mSoterService is null", new Object[0]);
                            return;
                        }
                        SoterExtraParam extraParam = iSoterService.getExtraParam(ISoterExParameters.FINGERPRINT_TYPE);
                        if (extraParam != null) {
                            Object obj = extraParam.result;
                            if (obj instanceof Integer) {
                                SLogger.i(SoterCoreTreble.TAG, "soter: updateExtraParam finger type:%s", (Integer) obj);
                                SoterExParametersTrebleImpl.setParam(ISoterExParameters.FINGERPRINT_TYPE, extraParam.result);
                            }
                        }
                        SoterExtraParam extraParam2 = SoterCoreTreble.mSoterService.getExtraParam(ISoterExParameters.FINGERPRINT_HARDWARE_POSITION);
                        if (extraParam2 != null) {
                            Object obj2 = extraParam2.result;
                            if (obj2 instanceof Integer[]) {
                                SLogger.i(SoterCoreTreble.TAG, "soter: updateExtraParam finger pos:%s", Arrays.toString((Integer[]) obj2));
                                SoterExParametersTrebleImpl.setParam(ISoterExParameters.FINGERPRINT_HARDWARE_POSITION, extraParam2.result);
                            }
                        }
                    } catch (Exception e16) {
                        SLogger.printErrStackTrace(SoterCoreTreble.TAG, e16, "soter: getExtraParam fail1");
                        SReporter.reportError(101, "SoterService aidl: getExtraParam.", e16);
                    }
                }
            }).start();
        } catch (Exception e16) {
            SLogger.printErrStackTrace(TAG, e16, "soter: getExtraParam fail2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService(boolean z16) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.soter.soterserver.ISoterService");
        intent.setPackage("com.tencent.soter.soterserver");
        if (this.mContext == null) {
            SLogger.e(TAG, "soter: bindService context is null ", new Object[0]);
            return;
        }
        connectState = 1;
        SoterCoreTrebleServiceListener soterCoreTrebleServiceListener = this.serviceListener;
        if (soterCoreTrebleServiceListener != null) {
            soterCoreTrebleServiceListener.onStartServiceConnecting();
        }
        SLogger.i(TAG, "soter: bindService binding is start ", new Object[0]);
        this.lastBindTime = SystemClock.elapsedRealtime();
        this.hasBind = this.mContext.bindService(intent, this.mServiceConnection, 1);
        scheduleTimeoutTask(z16);
    }
}
