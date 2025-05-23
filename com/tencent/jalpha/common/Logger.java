package com.tencent.jalpha.common;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Logger {
    static IPatchRedirector $redirector_;

    public Logger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }

    public static void i(String str, String str2) {
        Log.i(str, str2);
    }

    public static void v(String str, String str2) {
        Log.v(str, str2);
    }
}
