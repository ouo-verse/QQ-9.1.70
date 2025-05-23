package com.tencent.mobileqq.msf.core.wtlogin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.IWtloginService;
import com.tencent.qphone.base.remote.IWtloginServiceCallbacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfWtloginHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String WTSERVICENAME = "com.tencent.mobileqq.msf.core.wtlogin.WtLoginService";
    private static AtomicInteger helperSeq = null;
    private static final String tag = "MsfWtloginHelper";
    protected volatile IWtloginService _baseService;
    protected ServiceConnection conn;
    String helperTag;
    private WtloginHelper localWtloginHelper;
    String processName;
    IWtloginServiceCallbacker subRemoteWtloginListener;
    WtServiceBindListener wtServiceBindListener;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BaseThread {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfWtloginHelper.this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                MsfWtloginHelper.this.bindWtLoginService(MsfWtloginHelper.WTSERVICENAME);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements ServiceConnection {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfWtloginHelper.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            QLog.d(MsfWtloginHelper.tag, 2, " onServiceConnected service:" + componentName);
            MsfWtloginHelper.this._baseService = IWtloginService.Stub.asInterface(iBinder);
            MsfWtloginHelper.this.onWtloginServiceConnected();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            QLog.d(MsfWtloginHelper.tag, 2, " onServiceDisconnected " + componentName);
            MsfWtloginHelper.this._baseService = null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17209);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            helperSeq = new AtomicInteger(new Random().nextInt(100000));
        }
    }

    public MsfWtloginHelper(Context context, IWtloginServiceCallbacker iWtloginServiceCallbacker, WtServiceBindListener wtServiceBindListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, iWtloginServiceCallbacker, wtServiceBindListener);
            return;
        }
        this.processName = "";
        this.conn = new b();
        this.subRemoteWtloginListener = iWtloginServiceCallbacker;
        this.processName = MsfSdkUtils.getProcessName(context);
        this.helperTag = this.processName + "_" + helperSeq.incrementAndGet();
        this.localWtloginHelper = new WtloginHelper(context, (PrivacyListener) MsfWtloginPrivacyListenerImpl.getSingleton());
        this.wtServiceBindListener = wtServiceBindListener;
        new a().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWtloginServiceConnected() {
        WtServiceBindListener wtServiceBindListener = this.wtServiceBindListener;
        if (wtServiceBindListener != null) {
            wtServiceBindListener.onBindFinished();
        }
    }

    public int CheckPictureAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, str, bArr, wUserSigInfo)).intValue();
        }
        return this._baseService.CheckPictureAndGetSt(this.helperTag, str, bArr, wUserSigInfo, this.subRemoteWtloginListener);
    }

    public int CheckSMSAndGetSt(String str, byte[] bArr, WUserSigInfo wUserSigInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, this, str, bArr, wUserSigInfo)).intValue();
        }
        return this._baseService.CheckSMSAndGetSt(this.helperTag, str, bArr, wUserSigInfo, this.subRemoteWtloginListener);
    }

    public Boolean ClearUserFastLoginData(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Boolean) iPatchRedirector.redirect((short) 21, this, str, Long.valueOf(j3));
        }
        return this.localWtloginHelper.ClearUserLoginData(str, j3);
    }

    public int CloseCode(String str, long j3, byte[] bArr, int i3, List list, WUserSigInfo wUserSigInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, this, str, Long.valueOf(j3), bArr, Integer.valueOf(i3), list, wUserSigInfo)).intValue();
        }
        return this._baseService.CloseCode(this.helperTag, str, j3, bArr, i3, list, wUserSigInfo, this.subRemoteWtloginListener);
    }

    public int GetA1WithA1(String str, long j3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, this, str, Long.valueOf(j3), Long.valueOf(j16), bArr, Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), bArr2, bArr3, wUserSigInfo, wFastLoginInfo)).intValue();
        }
        return this._baseService.GetA1WithA1(this.helperTag, str, j3, j16, bArr, j17, j18, j19, bArr2, bArr3, wUserSigInfo, wFastLoginInfo, this.subRemoteWtloginListener);
    }

    public List<WloginLoginInfo> GetAllLoginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.localWtloginHelper.GetAllLoginInfo();
    }

    public Boolean GetBasicUserInfo(String str, WloginSimpleInfo wloginSimpleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) wloginSimpleInfo);
        }
        return this.localWtloginHelper.GetBasicUserInfo(str, wloginSimpleInfo);
    }

    public DevlockInfo GetDevLockInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.localWtloginHelper.GetDevLockInfo(str) : (DevlockInfo) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
    }

    public WUserSigInfo GetLocalSig(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (WUserSigInfo) iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3));
        }
        return this.localWtloginHelper.GetLocalSig(str, j3);
    }

    public int GetStWithPasswd(String str, long j3, String str2, WUserSigInfo wUserSigInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, this, str, Long.valueOf(j3), str2, wUserSigInfo)).intValue();
        }
        return this._baseService.GetStWithPasswd(this.helperTag, str, j3, str2, wUserSigInfo, this.subRemoteWtloginListener);
    }

    public int GetStWithoutPasswd(String str, long j3, long j16, WUserSigInfo wUserSigInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3), Long.valueOf(j16), wUserSigInfo)).intValue();
        }
        return this._baseService.GetStWithoutPasswd(this.helperTag, str, j3, j16, wUserSigInfo, this.subRemoteWtloginListener);
    }

    public boolean IsNeedLoginWithPasswd(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3)).booleanValue();
        }
        return this.localWtloginHelper.IsNeedLoginWithPasswd(str, i3).booleanValue();
    }

    public boolean IsUserHaveA1(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Long.valueOf(j3))).booleanValue();
        }
        return this.localWtloginHelper.IsUserHaveA1(str, j3).booleanValue();
    }

    public boolean IsWtLoginUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        return this.localWtloginHelper.IsWtLoginUrl(str);
    }

    public int RefreshPictureData(String str, WUserSigInfo wUserSigInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) wUserSigInfo)).intValue();
        }
        return this._baseService.RefreshPictureData(this.helperTag, str, wUserSigInfo, this.subRemoteWtloginListener);
    }

    public int RefreshSMSData(String str, WUserSigInfo wUserSigInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) wUserSigInfo)).intValue();
        }
        return this._baseService.RefreshSMSData(this.helperTag, str, wUserSigInfo, this.subRemoteWtloginListener);
    }

    public void SetTestHost(int i3, String str) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3, (Object) str);
        } else {
            this._baseService.setTestHost(this.helperTag, i3, str, this.subRemoteWtloginListener);
        }
    }

    public int VerifyCode(String str, long j3, boolean z16, byte[] bArr, int[] iArr, int i3, WUserSigInfo wUserSigInfo) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, str, Long.valueOf(j3), Boolean.valueOf(z16), bArr, iArr, Integer.valueOf(i3), wUserSigInfo)).intValue();
        }
        return this._baseService.VerifyCode(this.helperTag, str, j3, z16, bArr, iArr, i3, wUserSigInfo, this.subRemoteWtloginListener);
    }

    public boolean bindWtLoginService(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), str);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.processName);
            z16 = BaseApplication.getContext().bindService(intent, this.conn, 1);
            QLog.d(tag, 2, " bind " + str + " service finished " + z16);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return z16;
    }

    public String getHelperTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.helperTag;
    }

    public byte[] getPkgSigFromApkName(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) str);
        }
        return util.getPkgSigFromApkName(context, str);
    }

    public void refreLocalHelper(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) context);
        } else {
            this.localWtloginHelper = new WtloginHelper(context, (PrivacyListener) MsfWtloginPrivacyListenerImpl.getSingleton());
        }
    }

    public void setHelperTag(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
        } else {
            this.helperTag = str;
        }
    }

    public void unBindWtLoginService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            this._baseService.removeRemoteHelper(this.helperTag);
            BaseApplication.getContext().unbindService(this.conn);
            this._baseService = null;
            QLog.d(tag, 2, " unbindService service finished");
        } catch (Exception e16) {
            QLog.d(tag, 2, " unbindService service error " + e16);
        }
    }

    public DevlockInfo GetDevLockInfo(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this.localWtloginHelper.GetDevLockInfo(str, j3) : (DevlockInfo) iPatchRedirector.redirect((short) 13, this, str, Long.valueOf(j3));
    }
}
