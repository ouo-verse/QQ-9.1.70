package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    private static SharedPreferences a(int i3) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            if (i3 == 1) {
                return mobileQQ.getSharedPreferences("qwallet_res_down_record_utilinner", 4);
            }
            return mobileQQ.getSharedPreferences("qwallet_res_down_record_util", 4);
        }
        return null;
    }

    public static int b(String str, int i3, int i16) {
        SharedPreferences a16 = a(i16);
        if (a16 != null && !TextUtils.isEmpty(str)) {
            return a16.getInt("url_down_scene" + str, i3);
        }
        return i3;
    }

    public static void c(String str, int i3) {
        SharedPreferences a16 = a(i3);
        if (a16 != null && !TextUtils.isEmpty(str)) {
            a16.edit().remove("url_down_scene" + str).apply();
        }
    }

    public static void d(String str, int i3, int i16) {
        SharedPreferences a16 = a(i16);
        if (a16 != null && !TextUtils.isEmpty(str)) {
            a16.edit().putInt("url_down_scene" + str, i3).apply();
        }
    }
}
