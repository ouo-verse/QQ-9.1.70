package com.tencent.mobileqq.applets;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        SharedPreferences b16 = b();
        if (b16 == null) {
            return false;
        }
        return b16.getBoolean("applets_setting_main_switch", false);
    }

    private static SharedPreferences b() {
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return null;
            }
            return QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(peekAppRuntime.getApp(), "AppletsFolderManager" + peekAppRuntime.getCurrentAccountUin(), 0);
        } catch (Throwable th5) {
            QLog.e("AppletsFolderManager", 2, "getSharedPreferences error!: ", th5);
            return null;
        }
    }

    public static void c(boolean z16) {
        SharedPreferences b16 = b();
        if (b16 == null) {
            return;
        }
        b16.edit().putBoolean("applets_setting_main_switch", z16).apply();
    }
}
