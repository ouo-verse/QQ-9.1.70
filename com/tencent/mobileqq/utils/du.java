package com.tencent.mobileqq.utils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class du {
    public static String a(Throwable th5, int i3) {
        if (th5 == null) {
            return "";
        }
        StackTraceElement[] stackTrace = th5.getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < stackTrace.length && i16 < i3; i16++) {
            sb5.append(stackTrace[i16]);
            sb5.append("\n");
        }
        return sb5.toString();
    }
}
