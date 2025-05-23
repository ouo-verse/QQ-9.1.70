package com.tencent.weiyun.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WyLog {
    static IPatchRedirector $redirector_ = null;
    private static final String GLOBAL_TAG = "Weiyun_Cmd";
    private static ILog sLog;

    public WyLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str) {
        d(GLOBAL_TAG, str, null);
    }

    public static void e(String str) {
        e(GLOBAL_TAG, str, null);
    }

    private static int getLogLevel() {
        ILog iLog = sLog;
        if (iLog != null) {
            return iLog.getLogLevel();
        }
        return 1;
    }

    public static void i(String str) {
        i(GLOBAL_TAG, str, null);
    }

    public static void setLog(ILog iLog) {
        sLog = iLog;
    }

    public static void v(String str) {
        v(GLOBAL_TAG, str, null);
    }

    public static void w(String str) {
        w(GLOBAL_TAG, str, null);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void d(String str, Throwable th5) {
        d(GLOBAL_TAG, str, th5);
    }

    public static void e(String str, Throwable th5) {
        e(GLOBAL_TAG, str, th5);
    }

    public static void i(String str, Throwable th5) {
        i(GLOBAL_TAG, str, th5);
    }

    public static void v(String str, Throwable th5) {
        v(GLOBAL_TAG, str, th5);
    }

    public static void w(String str, Throwable th5) {
        w(GLOBAL_TAG, str, th5);
    }

    public static void d(String str, String str2, Throwable th5) {
        if (2 >= getLogLevel()) {
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.d(str, str2, th5);
            } else {
                Log.d(str, str2, th5);
            }
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        if (5 >= getLogLevel()) {
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.e(str, str2, th5);
            } else {
                Log.e(str, str2, th5);
            }
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        if (3 >= getLogLevel()) {
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.i(str, str2, th5);
            } else {
                Log.i(str, str2, th5);
            }
        }
    }

    public static void v(String str, String str2, Throwable th5) {
        if (1 >= getLogLevel()) {
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.v(str, str2, th5);
            } else {
                Log.v(str, str2, th5);
            }
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        if (4 >= getLogLevel()) {
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.w(str, str2, th5);
            } else {
                Log.w(str, str2, th5);
            }
        }
    }
}
