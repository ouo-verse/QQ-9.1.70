package com.tencent.smtt.utils;

import android.os.SystemProperties;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: classes25.dex */
public class PropertyUtils {

    /* renamed from: a, reason: collision with root package name */
    private static Class f369644a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f369645b;

    static {
        try {
            f369644a = SystemProperties.class;
            f369645b = SystemProperties.class.getDeclaredMethod("get", String.class, String.class);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private static String a(String str, String str2) {
        Method method;
        Class cls = f369644a;
        if (cls != null && (method = f369645b) != null) {
            try {
                return (String) method.invoke(cls, str, str2);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String getQuickly(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return a(str, str2);
    }
}
