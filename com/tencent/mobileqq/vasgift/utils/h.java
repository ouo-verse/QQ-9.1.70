package com.tencent.mobileqq.vasgift.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h {
    public static String a(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftSpUtil", 2, "getString " + str);
        }
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences("qq_gift_sp", 4).getString(str, "");
    }

    public static void b(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftSpUtil", 2, "remove " + str);
        }
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("qq_gift_sp", 4).edit();
            edit.remove(str);
            edit.apply();
        }
    }

    public static void c(Context context, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGiftSpUtil", 2, "saveString " + str + "_" + str2);
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("qq_gift_sp", 4).edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
