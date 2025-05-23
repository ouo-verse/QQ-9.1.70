package com.tencent.live2;

import android.content.Context;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.impl.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class V2TXLivePremier {
    static IPatchRedirector $redirector_;

    /* loaded from: classes7.dex */
    public static abstract class V2TXLivePremierObserver {
        static IPatchRedirector $redirector_;

        public V2TXLivePremierObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void onCaptureAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) v2TXLiveAudioFrame);
            }
        }

        public void onLicenceLoaded(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            }
        }

        public void onLog(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            }
        }

        public void onPlayoutAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) v2TXLiveAudioFrame);
            }
        }

        public void onVoiceEarMonitorAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) v2TXLiveAudioFrame);
            }
        }
    }

    public V2TXLivePremier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int callExperimentalAPI(String str) {
        return a.c(str);
    }

    public static void enableAudioCaptureObserver(boolean z16, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        a.a(z16, v2TXLiveAudioFrameObserverFormat);
    }

    public static void enableAudioPlayoutObserver(boolean z16, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        a.b(z16, v2TXLiveAudioFrameObserverFormat);
    }

    public static void enableVoiceEarMonitorObserver(boolean z16) {
        a.a(z16);
    }

    public static String getSDKVersionStr() {
        return a.a();
    }

    public static void setEnvironment(String str) {
        a.a(str);
    }

    public static void setLicence(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static void setLogConfig(V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig) {
        a.a(v2TXLiveLogConfig);
    }

    public static void setObserver(V2TXLivePremierObserver v2TXLivePremierObserver) {
        a.a(v2TXLivePremierObserver);
    }

    public static void setSocks5Proxy(String str, int i3, String str2, String str3, V2TXLiveDef.V2TXLiveSocks5ProxyConfig v2TXLiveSocks5ProxyConfig) {
        a.a(str, i3, str2, str3, v2TXLiveSocks5ProxyConfig);
    }

    public static void setUserId(String str) {
        a.b(str);
    }
}
