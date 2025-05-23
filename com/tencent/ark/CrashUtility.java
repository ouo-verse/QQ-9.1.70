package com.tencent.ark;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CrashUtility {
    public static String getExceptionInfo(Throwable th5) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Exception: ");
        sb5.append(th5.getMessage());
        sb5.append('\n');
        sb5.append("Stack trace:");
        sb5.append("\n");
        sb5.append(stackTraceToString(th5.getStackTrace()));
        Throwable cause = th5.getCause();
        if (cause != null) {
            sb5.append("Cause: ");
            sb5.append(cause.getMessage());
            sb5.append('\n');
            sb5.append("Stack trace:");
            sb5.append("\n");
            sb5.append(stackTraceToString(cause.getStackTrace()));
        }
        return sb5.toString();
    }

    static String stackTraceToString(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            StringBuilder sb5 = new StringBuilder(stackTraceElementArr.length * 50);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                sb5.append(stackTraceElement.getClassName());
                sb5.append('.');
                sb5.append(stackTraceElement.getMethodName());
                sb5.append('(');
                sb5.append(stackTraceElement.getFileName());
                sb5.append(':');
                sb5.append(stackTraceElement.getLineNumber());
                sb5.append(')');
                sb5.append('\n');
            }
            return sb5.toString();
        }
        return "(empty stack trace)";
    }
}
