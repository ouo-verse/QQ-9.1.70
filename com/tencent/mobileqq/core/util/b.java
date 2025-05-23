package com.tencent.mobileqq.core.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.p;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static Object a(String str, Object obj) {
        return p.b(BaseApplication.getContext(), MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), str, obj);
    }

    public static boolean b(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("emotion_edit_guide_switch_" + str, true);
    }

    public static int c(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_rich_text_last_tab", -1);
    }

    public static void d(String str, Object obj) {
        p.g(BaseApplication.getContext(), MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), true, str, obj);
    }

    public static void e(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("emotion_edit_guide_switch_" + str, z16);
        edit.commit();
    }

    public static void f(Context context, String str, long j3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("sticker_remove_emoticon_package_time_" + str, j3);
        edit.apply();
    }

    public static void g(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_rich_text_last_tab", i3);
        edit.commit();
    }
}
