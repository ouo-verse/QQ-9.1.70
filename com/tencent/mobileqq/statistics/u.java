package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class u {
    static IPatchRedirector $redirector_;

    public static void a(Context context, String str, String str2) {
        String str3 = str + str2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mobileQQ", 0);
        sharedPreferences.edit().putInt(str3, sharedPreferences.getInt(str3, 0) + 1).commit();
    }

    public static void b(Context context, String str) {
        a(context, str, "grp_setting_asst");
    }

    public static int c(Context context, String str, String str2) {
        return context.getSharedPreferences("mobileQQ", 0).getInt(str + str2, 0);
    }

    public static int d(Context context, String str) {
        return c(context, str, "Click_grp_asst");
    }

    public static int e(Context context, String str) {
        return c(context, str, "grp_setting_asst");
    }

    public static int f(Context context, String str) {
        return c(context, str, "grp_setting_msg");
    }

    public static int g(Context context, String str) {
        return c(context, str, "grp_msg_dec");
    }

    public static int h(Context context, String str) {
        return c(context, str, "grp_msg_inc");
    }

    public static int i(Context context, String str) {
        return c(context, str, "grp_msg_equ");
    }

    public static void j(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mobileQQ", 0).edit();
        edit.putInt(str + "Click_grp_asst", 0);
        edit.putInt(str + "grp_setting_asst", 0);
        edit.putInt(str + "grp_setting_msg", 0);
        edit.putInt(str + "grp_msg_equ", 0);
        edit.putInt(str + "grp_msg_dec", 0);
        edit.putInt(str + "grp_msg_inc", 0);
        edit.commit();
    }
}
