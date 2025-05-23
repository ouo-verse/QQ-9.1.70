package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dx {
    public static int a() {
        return BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getInt("key_dialog_versioncode", 0);
    }

    public static boolean b() {
        return BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getBoolean("key_predownload_success_key", false);
    }

    public static boolean c() {
        return BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getBoolean("key_has_show_upgrade_dialog", false);
    }

    public static int d() {
        return BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getInt(DeviceProfileManager.KEY_VERSIONCODE, 0);
    }

    public static boolean e(int i3) {
        if (BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).getInt("key_normal_upgrade_version", 0) != i3) {
            return true;
        }
        return !r0.getBoolean("key_normal_upgrade", false);
    }

    public static void f(int i3) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
        edit.putInt("key_dialog_versioncode", i3);
        edit.apply();
    }

    public static void g(boolean z16) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
        edit.putBoolean("key_normal_upgrade", z16);
        edit.apply();
    }

    public static void h(int i3) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
        edit.putInt("key_normal_upgrade_version", i3);
        edit.apply();
    }

    public static void i(boolean z16) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
        edit.putBoolean("key_predownload_success_key", z16);
        edit.apply();
    }

    public static void j(boolean z16) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
        edit.putBoolean("key_has_show_upgrade_dialog", z16);
        edit.apply();
    }

    public static void k(int i3) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("new_phone_assistant_settings", 0).edit();
        edit.putInt(DeviceProfileManager.KEY_VERSIONCODE, i3);
        edit.apply();
    }
}
