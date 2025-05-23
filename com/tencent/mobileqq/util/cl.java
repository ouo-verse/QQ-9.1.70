package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QMMKVFile;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cl {
    public static int a(Context context, String str, String str2, int i3) {
        if (context != null) {
            String string = context.getSharedPreferences(str, 4).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                return Integer.parseInt(string);
            }
        }
        return i3;
    }

    public static long b(Context context, String str, String str2, long j3) {
        if (context != null) {
            String string = context.getSharedPreferences(str, 4).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                return Long.parseLong(string);
            }
        }
        return j3;
    }

    public static Object c(Context context, String str, String str2, Object obj) {
        return com.tencent.mobileqq.utils.p.b(context, str, str2, obj);
    }

    public static String d(Context context, String str) {
        return e(context, QMMKVFile.PREFIX_2, str);
    }

    public static String e(Context context, String str, String str2) {
        return f(context, str, str2, "");
    }

    public static String f(Context context, String str, String str2, String str3) {
        if (context != null) {
            return context.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return str3;
    }

    public static void g(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(QMMKVFile.PREFIX_2, 4).edit();
            edit.remove(str);
            edit.commit();
        }
    }

    private static void h(Context context, String str, String str2) {
        i(context, QMMKVFile.PREFIX_2, str, str2);
    }

    private static void i(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public static void j(Context context, String str, String str2) {
        h(context, str, str2);
    }

    public static void k(Context context, String str, String str2, String str3) {
        i(context, str, str2, str3);
    }

    public static void l(Context context, String str, boolean z16, String str2, Object obj) {
        com.tencent.mobileqq.utils.p.g(context, str, z16, str2, obj);
    }
}
