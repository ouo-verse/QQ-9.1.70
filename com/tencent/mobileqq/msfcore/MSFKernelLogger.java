package com.tencent.mobileqq.msfcore;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFKernelLogger {
    static IPatchRedirector $redirector_;
    private static ILogger LOGGER;

    public MSFKernelLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        ILogger iLogger = LOGGER;
        if (iLogger != null) {
            iLogger.d(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        ILogger iLogger = LOGGER;
        if (iLogger != null) {
            iLogger.e(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        ILogger iLogger = LOGGER;
        if (iLogger != null) {
            iLogger.i(str, str2);
        } else {
            Log.i(str, str2);
        }
    }

    public static void setLogger(ILogger iLogger) {
        LOGGER = iLogger;
    }

    private static String stackTraceToString(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void e(String str, String str2, Throwable th5) {
        ILogger iLogger = LOGGER;
        if (iLogger != null) {
            iLogger.e(str, str2 + ", " + stackTraceToString(th5));
            return;
        }
        Log.e(str, str2, th5);
    }
}
