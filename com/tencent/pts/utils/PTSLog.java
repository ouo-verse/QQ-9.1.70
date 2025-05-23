package com.tencent.pts.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes22.dex */
public class PTSLog {
    static IPatchRedirector $redirector_;
    private static boolean sDoNotLog;
    private static PTSLogger sPTSLogger;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41931);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sDoNotLog = false;
        }
    }

    public PTSLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        if (sDoNotLog) {
            return;
        }
        PTSLogger pTSLogger = sPTSLogger;
        if (pTSLogger != null) {
            pTSLogger.d(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (sDoNotLog) {
            return;
        }
        PTSLogger pTSLogger = sPTSLogger;
        if (pTSLogger != null) {
            pTSLogger.e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (sDoNotLog) {
            return;
        }
        PTSLogger pTSLogger = sPTSLogger;
        if (pTSLogger != null) {
            pTSLogger.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static boolean isColorLevel() {
        PTSLogger pTSLogger = sPTSLogger;
        if (pTSLogger != null) {
            return pTSLogger.isColorLevel();
        }
        return false;
    }

    public static boolean isDebug() {
        PTSLogger pTSLogger = sPTSLogger;
        if (pTSLogger != null) {
            return pTSLogger.isDebug();
        }
        return false;
    }

    public static void registerLogger(PTSLogger pTSLogger) {
        sPTSLogger = pTSLogger;
    }

    public static void w(String str, String str2) {
        if (sDoNotLog) {
            return;
        }
        PTSLogger pTSLogger = sPTSLogger;
        if (pTSLogger != null) {
            pTSLogger.w(str, str2);
        } else {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        if (sDoNotLog) {
            return;
        }
        PTSLogger pTSLogger = sPTSLogger;
        if (pTSLogger != null) {
            pTSLogger.e(str, str2, th5);
        } else {
            Log.e(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        if (sDoNotLog) {
            return;
        }
        PTSLogger pTSLogger = sPTSLogger;
        if (pTSLogger != null) {
            pTSLogger.w(str, str2, th5);
        } else {
            Log.w(str, str2, th5);
        }
    }
}
