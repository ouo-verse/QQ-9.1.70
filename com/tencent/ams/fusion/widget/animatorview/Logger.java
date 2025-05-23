package com.tencent.ams.fusion.widget.animatorview;

import android.util.Log;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Logger {
    static IPatchRedirector $redirector_;
    private static final DefaultLogger sDefaultLogger;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DefaultLogger implements AnimatorConfig.LogSupport {
        static IPatchRedirector $redirector_;

        DefaultLogger() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorConfig.LogSupport
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.d(str, str2);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorConfig.LogSupport
        public void e(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, str2, th5);
            } else {
                Log.e(str, str2, th5);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorConfig.LogSupport
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.i(str, str2);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorConfig.LogSupport
        public void v(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.v(str, str2);
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.AnimatorConfig.LogSupport
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.w(str, str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51816);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sDefaultLogger = new DefaultLogger();
        }
    }

    public Logger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        logSupport().d(str, str2);
    }

    public static void e(String str, String str2, Throwable th5) {
        logSupport().e(str, str2, th5);
    }

    public static void i(String str, String str2) {
        logSupport().i(str, str2);
    }

    private static AnimatorConfig.LogSupport logSupport() {
        AnimatorConfig.LogSupport logSupport = AnimatorConfig.getLogSupport();
        if (logSupport != null) {
            return logSupport;
        }
        return sDefaultLogger;
    }

    public static void v(String str, String str2) {
        logSupport().v(str, str2);
    }

    public static void w(String str, String str2) {
        logSupport().w(str, str2);
    }

    public static void e(String str, String str2) {
        logSupport().e(str, str2, null);
    }
}
