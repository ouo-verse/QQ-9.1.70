package com.tencent.mobileqq.zplan.setting;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes34.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f335448a;

    public static boolean a() {
        return h(SwitchSetting.CMSHOW_MONTH_USER_SETTING);
    }

    public static boolean b() {
        SwitchSetting switchSetting = SwitchSetting.DRAWER_SETTING;
        return c(switchSetting.getKey(), switchSetting.getOnValue()) == switchSetting.getOnValue();
    }

    public static int c(String str, int i3) {
        if (m(str)) {
            return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getInt(d(str), i3);
        }
        SharedPreferences f16 = f();
        if (f16 == null) {
            QLog.w("SettingDataRepository", 1, "get " + str + " fail, return default value:" + i3);
            return i3;
        }
        return f16.getInt(str, i3);
    }

    public static boolean e() {
        return h(SwitchSetting.MASTER_SETTING);
    }

    private static SharedPreferences f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("SettingDataRepository", 1, "appRuntime == null");
            return null;
        }
        f335448a = "zplan_setting_sp_config_" + peekAppRuntime.getCurrentAccountUin();
        return peekAppRuntime.getApplication().getSharedPreferences(f335448a, 4);
    }

    public static String g(String str, String str2) {
        if (m(str)) {
            return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(d(str), str2);
        }
        SharedPreferences f16 = f();
        if (f16 == null) {
            QLog.w("SettingDataRepository", 1, "get " + str + " fail, return default value:" + str2);
            return str2;
        }
        return f16.getString(str, str2);
    }

    public static boolean h(SwitchSetting switchSetting) {
        return c(switchSetting.getKey(), switchSetting.getOffValue()) == switchSetting.getOnValue();
    }

    private static String i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentUin();
        }
        return null;
    }

    public static boolean j() {
        return c("key_view_contract", 0) == 1;
    }

    public static void k(String str, int i3) {
        if (m(str)) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt(d(str), i3);
            return;
        }
        SharedPreferences f16 = f();
        if (f16 == null) {
            return;
        }
        f16.edit().putInt(str, i3).commit();
    }

    public static void l(String str, String str2) {
        if (m(str)) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(d(str), str2);
            return;
        }
        SharedPreferences f16 = f();
        if (f16 == null) {
            return;
        }
        f16.edit().putString(str, str2).commit();
    }

    private static boolean m(String str) {
        return SwitchSetting.MASTER_SETTING.getKey().equals(str) || SwitchSetting.DRAWER_SETTING.getKey().equals(str);
    }

    public static void n(boolean z16) {
        o(SwitchSetting.MASTER_SETTING, z16);
    }

    public static void o(SwitchSetting switchSetting, boolean z16) {
        k(switchSetting.getKey(), switchSetting.getSwitchValue(z16));
    }

    private static String d(String str) {
        if (str == null) {
            return null;
        }
        return i() + "_" + str;
    }
}
