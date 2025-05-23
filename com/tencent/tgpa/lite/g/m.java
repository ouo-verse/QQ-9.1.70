package com.tencent.tgpa.lite.g;

import android.annotation.SuppressLint;
import android.os.SystemProperties;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f375981a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f375982b;

    @SuppressLint({"PrivateApi"})
    public static String a(String str) {
        try {
            if (f375981a == null) {
                f375981a = SystemProperties.class;
            }
            if (f375982b == null) {
                f375982b = f375981a.getMethod("get", String.class, String.class);
            }
            return (String) f375982b.invoke(null, str, null);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String a(String str, String str2) {
        String a16 = a(str);
        return l.a(a16) ? str2 : a16;
    }
}
