package com.tencent.opentelemetry.api.logging;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class DefaultPrintLogger {
    static IPatchRedirector $redirector_;
    private static IPrinterLogger printLogger;

    public DefaultPrintLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        IPrinterLogger iPrinterLogger = printLogger;
        if (iPrinterLogger != null) {
            iPrinterLogger.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        IPrinterLogger iPrinterLogger = printLogger;
        if (iPrinterLogger != null) {
            iPrinterLogger.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        IPrinterLogger iPrinterLogger = printLogger;
        if (iPrinterLogger != null) {
            iPrinterLogger.i(str, str2);
        }
    }

    public static boolean isColorLevel() {
        IPrinterLogger iPrinterLogger = printLogger;
        if (iPrinterLogger != null) {
            return iPrinterLogger.isColorLevel();
        }
        return false;
    }

    public static boolean isDebug() {
        IPrinterLogger iPrinterLogger = printLogger;
        if (iPrinterLogger != null) {
            return iPrinterLogger.isDebug();
        }
        return false;
    }

    public static void registerLogger(IPrinterLogger iPrinterLogger) {
        printLogger = iPrinterLogger;
    }

    public static void w(String str, String str2) {
        IPrinterLogger iPrinterLogger = printLogger;
        if (iPrinterLogger != null) {
            iPrinterLogger.w(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        IPrinterLogger iPrinterLogger = printLogger;
        if (iPrinterLogger != null) {
            iPrinterLogger.e(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        IPrinterLogger iPrinterLogger = printLogger;
        if (iPrinterLogger != null) {
            iPrinterLogger.w(str, str2, th5);
        }
    }
}
