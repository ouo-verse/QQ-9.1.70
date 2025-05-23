package com.tencent.camerasdk.avreport;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AVRLogUtils {
    static IPatchRedirector $redirector_;
    private static volatile LogProxy logProxy;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface LogProxy {
        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th5);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th5);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12589);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            logProxy = null;
        }
    }

    public AVRLogUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        if (logProxy != null) {
            logProxy.d(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void setProxy(LogProxy logProxy2) {
        if (logProxy == null) {
            synchronized (LogProxy.class) {
                if (logProxy != null) {
                    return;
                }
                logProxy = logProxy2;
            }
        }
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th5) {
        if (th5 == null) {
            if (logProxy != null) {
                logProxy.e(str, str2);
                return;
            } else {
                Log.e(str, str2);
                return;
            }
        }
        if (logProxy != null) {
            logProxy.e(str, str2, th5);
        } else {
            Log.e(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        if (th5 == null) {
            if (logProxy != null) {
                logProxy.w(str, str2);
                return;
            } else {
                Log.w(str, str2);
                return;
            }
        }
        if (logProxy != null) {
            logProxy.w(str, str2, th5);
        } else {
            Log.w(str, str2, th5);
        }
    }
}
