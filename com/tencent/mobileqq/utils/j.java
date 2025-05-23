package com.tencent.mobileqq.utils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class j {
    public static void a(boolean z16) {
        if (!z16) {
            hd0.c.g("Q.qqstory.AssertUtils", "assertTrue failed:" + c(4));
        }
    }

    public static <T> T b(T t16) {
        if (t16 == null) {
            hd0.c.g("Q.qqstory.AssertUtils", "checkNotNull failed:" + c(2));
        }
        return t16;
    }

    public static String c(int i3) {
        try {
            StackTraceElement[] stackTrace = new RuntimeException("getStackTrace").getStackTrace();
            StringBuilder sb5 = new StringBuilder();
            if (stackTrace.length <= i3) {
                i3 = stackTrace.length;
            }
            for (int i16 = 2; i16 < i3; i16++) {
                sb5.append("\n" + stackTrace[i16].toString());
            }
            return sb5.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
