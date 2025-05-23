package com.tencent.live2.impl;

import android.content.Context;
import com.tencent.liteav.LiveSettingJni;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.live.V2TXLivePremierJni;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final C5955a f119788a;

    /* renamed from: b, reason: collision with root package name */
    private static V2TXLivePremier.V2TXLivePremierObserver f119789b;

    /* compiled from: P */
    /* renamed from: com.tencent.live2.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5955a implements LiteavLog.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        V2TXLivePremier.V2TXLivePremierObserver f119790a;

        public C5955a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.liteav.base.util.LiteavLog.a
        public final void a(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                return;
            }
            V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = this.f119790a;
            if (v2TXLivePremierObserver != null) {
                v2TXLivePremierObserver.onLog(i3, str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16507);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f119788a = new C5955a();
        }
    }

    public static String a() {
        return CommonUtil.getSDKVersionStr();
    }

    public static int c(String str) {
        return V2TXLivePremierJni.callExperimentalAPI(str);
    }

    public static void a(V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver) {
        f119789b = v2TXLivePremierObserver;
        f119788a.f119790a = v2TXLivePremierObserver;
        V2TXLivePremierJni.setObserver(v2TXLivePremierObserver);
    }

    public static void b(boolean z16, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        V2TXLivePremierJni.enableAudioPlayoutObserver(z16, v2TXLiveAudioFrameObserverFormat);
    }

    public static void b(String str) {
        LiveSettingJni.setUserId(str);
    }

    public static void a(V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig) {
        LiteavLog.b bVar;
        if (v2TXLiveLogConfig != null) {
            LiteavLog.nativeSetConsoleLogEnabled(v2TXLiveLogConfig.enableConsole);
            LiteavLog.nativeSetLogToFileEnabled(v2TXLiveLogConfig.enableLogFile);
            String str = v2TXLiveLogConfig.logPath;
            if (str != null) {
                LiteavLog.nativeSetLogFilePath(str);
            }
            int i3 = v2TXLiveLogConfig.logLevel;
            if (i3 == 2) {
                bVar = LiteavLog.b.kInfo;
            } else if (i3 == 3) {
                bVar = LiteavLog.b.kWarning;
            } else if (i3 == 4) {
                bVar = LiteavLog.b.kError;
            } else if (i3 == 5) {
                bVar = LiteavLog.b.kFatal;
            } else if (i3 != 6) {
                bVar = LiteavLog.b.kAll;
            } else {
                bVar = LiteavLog.b.kNone;
            }
            LiteavLog.nativeSetLogLevel(bVar.mNativeValue);
            C5955a c5955a = f119788a;
            boolean z16 = v2TXLiveLogConfig.enableObserver;
            if (!z16) {
                c5955a = null;
            }
            LiteavLog.setCallback(c5955a);
            LiteavLog.nativeSetLogCallbackEnabled(z16);
        }
    }

    public static void a(String str) {
        CommonUtil.setGlobalEnv(str);
    }

    public static void a(Context context, String str, String str2) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        LicenseChecker.getInstance().setListener(new LicenseChecker.b() { // from class: com.tencent.live2.impl.a.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.liteav.sdk.common.LicenseChecker.b
            public final void a(int i3, String str3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = a.f119789b;
                    if (v2TXLivePremierObserver != null) {
                        v2TXLivePremierObserver.onLicenceLoaded(i3, str3);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str3);
            }
        });
        LicenseChecker.getInstance().setLicense(LicenseChecker.c.LIVE, str, str2);
    }

    public static void a(String str, int i3, String str2, String str3, V2TXLiveDef.V2TXLiveSocks5ProxyConfig v2TXLiveSocks5ProxyConfig) {
        CommonUtil.setSocks5Proxy(str, i3, str2, str3, v2TXLiveSocks5ProxyConfig.supportHttps, v2TXLiveSocks5ProxyConfig.supportTcp, v2TXLiveSocks5ProxyConfig.supportUdp);
    }

    public static void a(boolean z16, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        V2TXLivePremierJni.enableAudioCaptureObserver(z16, v2TXLiveAudioFrameObserverFormat);
    }

    public static void a(boolean z16) {
        V2TXLivePremierJni.enableVoiceEarMonitorObserver(z16);
    }
}
