package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37988a = "aegis";

    /* renamed from: b, reason: collision with root package name */
    private static SharedPreferences f37989b;

    public static long a(String str, long j3, Context context) {
        return b(context).getLong(str, j3);
    }

    public static synchronized SharedPreferences b(Context context) {
        SharedPreferences sharedPreferences;
        Context createDeviceProtectedStorageContext;
        synchronized (i.class) {
            if (f37989b == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                    f37989b = createDeviceProtectedStorageContext.getSharedPreferences(f37988a, 0);
                } else {
                    f37989b = context.getApplicationContext().getSharedPreferences(f37988a, 0);
                }
            }
            sharedPreferences = f37989b;
        }
        return sharedPreferences;
    }

    public static int a(String str, int i3, Context context) {
        return b(context).getInt(str, i3);
    }

    public static String a(String str, String str2, Context context) {
        return b(context).getString(str, str2);
    }

    public static void a(String str, Context context) {
        b(context).edit().remove(str).apply();
    }

    public static void a(Context context) {
        b(context).edit().clear().apply();
    }

    public static void b(String str, long j3, Context context) {
        b(context).edit().putLong(str, j3).apply();
    }

    public static void b(String str, int i3, Context context) {
        b(context).edit().putInt(str, i3).apply();
    }

    public static void b(String str, String str2, Context context) {
        b(context).edit().putString(str, str2).apply();
    }
}
