package com.hihonor.push.sdk;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {
    public static void a(String str, String str2, Throwable th5) {
        if (str2.length() > 4000) {
            int i3 = 0;
            while (i3 < str2.length()) {
                int i16 = i3 + 4000;
                if (str2.length() > i16) {
                    str2.substring(i3, i16);
                } else {
                    str2.substring(i3);
                }
                i3 = i16;
            }
        }
    }

    public static void a(String str) {
        String str2;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i3 = 2;
        while (true) {
            if (i3 >= stackTrace.length) {
                str2 = "";
                break;
            } else {
                if (!stackTrace[i3].getClass().equals(c.class)) {
                    String className = stackTrace[i3].getClassName();
                    str2 = className.substring(className.lastIndexOf(46) + 1);
                    break;
                }
                i3++;
            }
        }
        a("HonorPush_" + str2, str, null);
    }
}
