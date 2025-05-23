package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;

/* compiled from: P */
/* loaded from: classes20.dex */
public class z {
    public static long a(Context context, String str) {
        return context.getSharedPreferences("mobileQQ", 0).getLong("pref_last_req_x_man_scene_2_time_prefix_" + str, 0L);
    }

    public static long b(Context context, String str) {
        return context.getSharedPreferences("mobileQQ", 0).getLong("pref_req_x_man_prefix" + str, 0L);
    }

    public static long c(Context context, String str) {
        return context.getSharedPreferences("mobileQQ", 0).getLong("pref_req_self_level_time" + str, 0L);
    }

    public static boolean d(Context context, String str) {
        return context.getSharedPreferences(str, 0).getBoolean("fl_show_pc_icon", false);
    }

    public static boolean e(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        long j3 = sharedPreferences.getLong("fl_pre_get_last_login_info", 0L);
        long j16 = sharedPreferences.getLong("fl_get_last_login_info_time_period", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 < currentTimeMillis && currentTimeMillis < j3 + j16) {
            return false;
        }
        return true;
    }

    public static void f(Context context, String str, int i3) {
        context.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0).edit().putInt(str, i3).commit();
    }

    public static void g(Context context, String str, long j3) {
        context.getSharedPreferences("mobileQQ", 0).edit().putLong("pref_last_req_x_man_scene_2_time_prefix_" + str, j3).commit();
    }

    public static void h(Context context, String str, long j3) {
        context.getSharedPreferences("mobileQQ", 0).edit().putLong("pref_req_x_man_prefix" + str, j3).commit();
    }

    public static void i(Context context, String str, long j3) {
        context.getSharedPreferences("mobileQQ", 0).edit().putLong("pref_req_self_level_time" + str, System.currentTimeMillis()).commit();
    }

    public static void j(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean("fl_show_pc_icon", z16);
        edit.commit();
    }

    public static void k(Context context, String str, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong("fl_pre_get_last_login_info", currentTimeMillis);
        edit.putLong("fl_get_last_login_info_time_period", i3 * 60 * 1000);
        edit.commit();
    }
}
