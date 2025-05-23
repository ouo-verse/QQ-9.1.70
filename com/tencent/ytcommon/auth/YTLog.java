package com.tencent.ytcommon.auth;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class YTLog {
    static IPatchRedirector $redirector_;

    public YTLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, Object obj) {
        if (Config.DEBUG) {
            Log.d(str, String.valueOf(obj));
        }
    }

    public static void e(String str, String str2) {
        if (Config.DEBUG) {
            Log.e(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (Config.DEBUG) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th5) {
        if (Config.DEBUG) {
            Log.d(str, str2, th5);
        }
    }
}
