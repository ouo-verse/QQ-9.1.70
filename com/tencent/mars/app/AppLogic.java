package com.tencent.mars.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AppLogic {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "mars.app.NativeAppJni$C2Java";
    private static ICallBack callBack;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class DeviceInfo {
        static IPatchRedirector $redirector_;
        public String devicename;
        public String devicetype;

        public DeviceInfo(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.devicename = str;
                this.devicetype = str2;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface ICallBack {
        AccountInfo getAccountInfo();

        String getAppFilePath();

        int getClientVersion();

        String getCurLanguage();

        DeviceInfo getDeviceType();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public AppLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static AccountInfo getAccountInfo() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.getAccountInfo();
    }

    public static String getAppFilePath() {
        ICallBack iCallBack = callBack;
        if (iCallBack != null) {
            return iCallBack.getAppFilePath();
        }
        return null;
    }

    private static int getClientVersion() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return 0;
        }
        return iCallBack.getClientVersion();
    }

    private static String getCurLanguage() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.getCurLanguage();
    }

    private static DeviceInfo getDeviceType() {
        ICallBack iCallBack = callBack;
        if (iCallBack == null) {
            return null;
        }
        return iCallBack.getDeviceType();
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class AccountInfo {
        static IPatchRedirector $redirector_;
        public long uin;
        public String userName;

        public AccountInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.uin = 0L;
                this.userName = "";
            }
        }

        public AccountInfo(long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str);
            } else {
                this.uin = j3;
                this.userName = str;
            }
        }
    }
}
