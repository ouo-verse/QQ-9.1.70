package com.tencent.oskplayer.support.util;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OskDebug {
    public static String getPrintableStackTrace(Throwable th5) {
        return getPrintableStackTrace(th5, false);
    }

    public static String getStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringWriter stringWriter = new StringWriter();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringWriter.write(stackTraceElement.toString());
            stringWriter.write("\n");
        }
        stringWriter.flush();
        return stringWriter.toString();
    }

    private static String getPrintableStackTrace(Throwable th5, boolean z16) {
        if (th5 == null) {
            return "";
        }
        Thread currentThread = Thread.currentThread();
        StringBuilder sb5 = new StringBuilder();
        if (!z16) {
            sb5.append("Exception in thread \"");
            sb5.append(currentThread.getName());
            sb5.append("\"");
            sb5.append(th5.toString());
        }
        for (StackTraceElement stackTraceElement : th5.getStackTrace()) {
            sb5.append("\tat ");
            sb5.append(stackTraceElement);
            sb5.append("\n");
        }
        Throwable targetException = th5 instanceof InvocationTargetException ? ((InvocationTargetException) th5).getTargetException() : th5.getCause();
        if (targetException != null) {
            sb5.append("caused by: ");
            sb5.append(targetException.toString());
            sb5.append("\n");
            sb5.append(getPrintableStackTrace(targetException, true));
        }
        return sb5.toString();
    }
}
