package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes2.dex */
public abstract class SafePrintException {
    private static boolean a(String str) {
        String[] strArr = {"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"};
        for (int i3 = 0; i3 < 10; i3++) {
            if (str.contains(strArr[i3])) {
                return true;
            }
        }
        return false;
    }

    public static String getStackTrace(String str, Throwable th5) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
            sb5.append(" ");
        }
        sb5.append("Exception: ");
        sb5.append(th5.getClass().getName());
        sb5.append('\n');
        if (!a(th5.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th5.getStackTrace();
            if (stackTrace == null) {
                sb5.append("Stack trace is NULL!");
                sb5.append('\n');
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb5.append(stackTraceElement.toString());
                    sb5.append('\n');
                }
            }
        }
        return sb5.toString();
    }

    public static void print(String str, String str2, Throwable th5) {
        if (th5 == null) {
            return;
        }
        Log.w(str, getStackTrace(str2, th5));
    }
}
