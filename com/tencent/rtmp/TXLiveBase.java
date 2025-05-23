package com.tencent.rtmp;

import android.content.Context;
import com.tencent.liteav.LiveSettingJni;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.HttpDnsUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TXLiveBase {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TXLiveBase";
    private static TXLiveBase instance;
    private static b networkTimeCallback;
    private static TXLiveBaseListener sListener;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class a implements LiteavLog.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.liteav.base.util.LiteavLog.a
        public final void a(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TXLiveBaseListener tXLiveBaseListener = TXLiveBase.sListener;
                if (tXLiveBaseListener != null) {
                    tXLiveBaseListener.onLog(i3, str, str2);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
        }

        /* synthetic */ a(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class b implements CommonUtil.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.liteav.base.util.CommonUtil.a
        public final void a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            } else {
                TXLiveBase.onUpdateNetworkTime(i3, str);
            }
        }

        /* synthetic */ b(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        sListener = null;
        instance = new TXLiveBase();
        networkTimeCallback = new b((byte) 0);
        if (SoLoader.loadAllLibraries()) {
            CommonUtil.setUpdateNetworkTimeCallback(networkTimeCallback);
        }
    }

    TXLiveBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void enableCustomHttpDNS(boolean z16) {
        if (z16) {
            HttpDnsUtil.enableCustomHttpDNS(true, new HttpDnsUtil.a() { // from class: com.tencent.rtmp.TXLiveBase.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.liteav.base.util.HttpDnsUtil.a
                public final void a(String str, List<String> list) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) list);
                    } else if (TXLiveBase.sListener != null) {
                        TXLiveBase.sListener.onCustomHttpDNS(str, list);
                    }
                }
            });
        } else {
            HttpDnsUtil.enableCustomHttpDNS(false, null);
        }
    }

    public static TXLiveBase getInstance() {
        return instance;
    }

    public static long getNetworkTimestamp() {
        return CommonUtil.getNetworkTimestamp();
    }

    public static String getPituSDKVersion() {
        return "";
    }

    public static String getSDKVersionStr() {
        return CommonUtil.getSDKVersionStr();
    }

    public static boolean isLibraryPathValid(String str) {
        return false;
    }

    public static void onUpdateNetworkTime(int i3, String str) {
        TXLiveBaseListener tXLiveBaseListener = sListener;
        if (tXLiveBaseListener != null) {
            tXLiveBaseListener.onUpdateNetworkTime(i3, str);
        }
    }

    public static void setAppID(String str) {
        LiveSettingJni.setAppId(str);
    }

    public static void setAppVersion(String str) {
        LiteavLog.i(TAG, "Set app version:".concat(String.valueOf(str)));
        LiveSettingJni.setAppVersion(str);
    }

    public static void setConsoleEnabled(boolean z16) {
        LiteavLog.nativeSetConsoleLogEnabled(z16);
    }

    public static boolean setExtID(String str, String str2) {
        return LiteavSystemInfo.setExtID(str, str2);
    }

    public static int setGlobalEnv(String str) {
        return CommonUtil.setGlobalEnv(str);
    }

    public static boolean setLibraryPath(String str) {
        SoLoader.setLibraryPath(str);
        boolean loadAllLibraries = SoLoader.loadAllLibraries();
        if (loadAllLibraries) {
            CommonUtil.setUpdateNetworkTimeCallback(networkTimeCallback);
        }
        return loadAllLibraries;
    }

    public static void setListener(TXLiveBaseListener tXLiveBaseListener) {
        boolean z16 = false;
        LiteavLog.setCallback(new a(0 == true ? 1 : 0));
        if (tXLiveBaseListener != null) {
            z16 = true;
        }
        LiteavLog.nativeSetLogCallbackEnabled(z16);
        sListener = tXLiveBaseListener;
    }

    public static void setLogLevel(int i3) {
        LiteavLog.b bVar;
        LiteavLog.b bVar2 = LiteavLog.b.kAll;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            bVar = LiteavLog.b.kAll;
                        } else {
                            bVar = LiteavLog.b.kNone;
                        }
                    } else {
                        bVar = LiteavLog.b.kFatal;
                    }
                } else {
                    bVar = LiteavLog.b.kError;
                }
            } else {
                bVar = LiteavLog.b.kWarning;
            }
        } else {
            bVar = LiteavLog.b.kInfo;
        }
        LiteavLog.nativeSetLogLevel(bVar.mNativeValue);
    }

    public static void setUserId(String str) {
        LiveSettingJni.setUserId(str);
    }

    public static int updateNetworkTime() {
        return CommonUtil.updateNetworkTime();
    }

    public String getLicenceInfo(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        return LicenseChecker.getInstance().getLicense(LicenseChecker.c.LIVE);
    }

    public void setLicence(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2);
            return;
        }
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        LicenseChecker.getInstance().setListener(new LicenseChecker.b() { // from class: com.tencent.rtmp.TXLiveBase.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TXLiveBase.this);
                }
            }

            @Override // com.tencent.liteav.sdk.common.LicenseChecker.b
            public final void a(int i3, String str3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TXLiveBaseListener tXLiveBaseListener = TXLiveBase.sListener;
                    if (tXLiveBaseListener != null) {
                        tXLiveBaseListener.onLicenceLoaded(i3, str3);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str3);
            }
        });
        LicenseChecker.getInstance().setLicense(LicenseChecker.c.LIVE, str, str2);
    }

    public static void setPituLicencePath(String str) {
    }
}
