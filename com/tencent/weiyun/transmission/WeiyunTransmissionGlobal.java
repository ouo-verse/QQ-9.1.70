package com.tencent.weiyun.transmission;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.db.OfflineFileHelper;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadType;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.utils.ILog;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class WeiyunTransmissionGlobal {
    static IPatchRedirector $redirector_ = null;
    private static final Lock LOCK;
    private static final String TAG = "WeiyunTransmissionGlobal";
    private static Singleton<WeiyunTransmissionGlobal, Void> sInstance;
    private AppInfo mAppInfo;
    private Application mContext;
    private HostInterface mHostInterface;
    private UploadManager mUploadManager;
    private PowerManager.WakeLock mWakeLock;
    private WifiManager.WifiLock mWifiLock;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class AppInfo {
        static IPatchRedirector $redirector_;
        public String appName;
        public String channelName;
        public boolean isLocal;
        public boolean isRdm;
        public String qua;
        public int versionCode;
        public String versionName;
        public int wnsAppId;

        public AppInfo(String str, int i3, String str2, String str3, int i16, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, str3, Integer.valueOf(i16), str4);
                return;
            }
            this.isRdm = false;
            this.isLocal = false;
            this.qua = str;
            this.wnsAppId = i3;
            this.appName = str2;
            this.versionName = str3;
            this.versionCode = i16;
            this.channelName = str4;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface HostInterface {
        void fetchUploadServerInfo(UploadFile uploadFile, UploadType uploadType, UploadServerInfoCallback uploadServerInfoCallback);

        int getCurrentIsp();

        String getCurrentUid();

        long getCurrentUin();

        NetworkInfo getRecentNetworkInfo();

        SharedPreferences getSharedPreferences(String str, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface UploadServerInfoCallback {
        void onResult(UploadFile uploadFile, boolean z16, int i3, String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11193);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            LOCK = new ReentrantLock();
            sInstance = new Singleton<WeiyunTransmissionGlobal, Void>() { // from class: com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.weiyun.utils.Singleton
                public WeiyunTransmissionGlobal create(Void r46) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new WeiyunTransmissionGlobal(null) : (WeiyunTransmissionGlobal) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
                }
            };
        }
    }

    /* synthetic */ WeiyunTransmissionGlobal(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) anonymousClass1);
    }

    public static WeiyunTransmissionGlobal getInstance() {
        return sInstance.get(null);
    }

    public void acquireWakeLockIfNot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        synchronized (LOCK) {
            if (this.mWakeLock == null) {
                try {
                    this.mWakeLock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, TAG);
                } catch (Throwable unused) {
                    this.mWakeLock = null;
                    TsLog.d(TAG, "Wakelock new failed :(");
                }
            }
            PowerManager.WakeLock wakeLock = this.mWakeLock;
            if (wakeLock != null) {
                wakeLock.acquire();
                TsLog.d(TAG, "Wakelock acquired :) held=" + this.mWakeLock.isHeld());
            }
            if (this.mWifiLock == null) {
                try {
                    this.mWifiLock = ((WifiManager) this.mContext.getSystemService("wifi")).createWifiLock(3, TAG);
                } catch (Throwable unused2) {
                    this.mWifiLock = null;
                    TsLog.d(TAG, "WifiLock new failed :(");
                }
            }
            WifiManager.WifiLock wifiLock = this.mWifiLock;
            if (wifiLock != null) {
                try {
                    wifiLock.acquire();
                    TsLog.d(TAG, "WifiLock acquired :) held=" + this.mWifiLock.isHeld());
                } catch (Throwable unused3) {
                    TsLog.d(TAG, "WifiLock acquire failed :( held=" + this.mWifiLock.isHeld());
                }
            }
        }
    }

    public AppInfo getAppInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AppInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mAppInfo;
    }

    public Application getApplication() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Application) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mContext;
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Context) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mContext;
    }

    public HostInterface getHostInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HostInterface) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mHostInterface;
    }

    public List<String> getOfflinePath(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, str, str2, str3);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return OfflineFileHelper.getOfflineFilePath(str, str2, str3);
        }
        return new ArrayList(0);
    }

    public UploadManager getUploadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UploadManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        UploadManager uploadManager = this.mUploadManager;
        if (uploadManager != null) {
            return uploadManager;
        }
        throw new IllegalStateException("Please call WeiyunLiteGlobal.initTransmission(...) in advance.");
    }

    public synchronized void initTransmission(AppInfo appInfo, Application application, HostInterface hostInterface, ILog iLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInfo, application, hostInterface, iLog);
            return;
        }
        if (appInfo != null && application != null && hostInterface != null) {
            this.mAppInfo = appInfo;
            this.mContext = application;
            this.mHostInterface = hostInterface;
            TsLog.setLog(iLog);
            NetworkUtils.setNetworkInfoProvider(new NetworkUtils.INetworkInfoProvider() { // from class: com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeiyunTransmissionGlobal.this);
                    }
                }

                @Override // com.tencent.weiyun.utils.NetworkUtils.INetworkInfoProvider
                public NetworkInfo getNetworkInfo(Context context) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (NetworkInfo) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context);
                    }
                    return WeiyunTransmissionGlobal.this.mHostInterface.getRecentNetworkInfo();
                }
            });
            WeiyunTransmissionStatus.getInstance().initGlobalStatus(application);
            UploadManager uploadManager = UploadManager.getInstance();
            this.mUploadManager = uploadManager;
            uploadManager.init();
            return;
        }
        throw new IllegalArgumentException("The params appInfo, context and hostInterface should be no-null.");
    }

    public boolean isNativeUpload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return UploadNative.getInstance().isLoaded();
    }

    public void releaseWakeLockIfExist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        synchronized (LOCK) {
            PowerManager.WakeLock wakeLock = this.mWakeLock;
            if (wakeLock != null) {
                try {
                    wakeLock.release();
                    TsLog.d(TAG, "Wakelock released :) held=" + this.mWakeLock.isHeld());
                } catch (Throwable unused) {
                    TsLog.d(TAG, "Wakelock release failed :( held=" + this.mWakeLock.isHeld());
                }
            }
            WifiManager.WifiLock wifiLock = this.mWifiLock;
            if (wifiLock != null) {
                try {
                    wifiLock.release();
                    TsLog.d(TAG, "WifiLock released :) held=" + this.mWifiLock.isHeld());
                } catch (Throwable unused2) {
                    TsLog.d(TAG, "WifiLock release failed :( held=" + this.mWifiLock.isHeld());
                }
            }
        }
    }

    WeiyunTransmissionGlobal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mWakeLock = null;
            this.mWifiLock = null;
        }
    }
}
