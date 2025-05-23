package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ae {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static ae f307401a = new ae();
    }

    ae() {
    }

    public static ae a() {
        return a.f307401a;
    }

    public int b(Context context) {
        int i3 = context.getSharedPreferences(AppConstants.Preferences.SUBACCOUNT_SP_FILENAME, 0).getInt(AppConstants.Preferences.SUBACCOUNT_SP_VERSION, 0);
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getSubAccountVersion() ver=" + i3);
        }
        return i3;
    }

    public void c(Context context, String str, boolean z16) {
        context.getSharedPreferences(AppConstants.Preferences.SUBACCOUNT_SP_FILENAME, 0).edit().putBoolean(str + AppConstants.Preferences.SUBACCOUNT_SHOW_IN_RECENTLIST_FIRST, z16).commit();
    }

    public void d(Context context) {
        int a16 = com.tencent.mobileqq.cooperation.a.a(context);
        context.getSharedPreferences(AppConstants.Preferences.SUBACCOUNT_SP_FILENAME, 0).edit().putInt(AppConstants.Preferences.SUBACCOUNT_SP_VERSION, a16).commit();
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "setSubAccountVersion() ver=" + a16);
        }
    }

    public boolean e(Context context, String str) {
        return context.getSharedPreferences(AppConstants.Preferences.SUBACCOUNT_SP_FILENAME, 0).getBoolean(str + AppConstants.Preferences.SUBACCOUNT_SHOW_IN_RECENTLIST_FIRST, false);
    }

    public boolean f(Context context, String str) {
        boolean z16 = false;
        if (str == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(AppConstants.Preferences.SUBACCOUNT_SP_FILENAME, 0);
        String str2 = str + AppConstants.Preferences.SUBACCOUNT_SHOW_IN_RECENTLIST_FIRST;
        if (sharedPreferences.getBoolean(str2, false)) {
            sharedPreferences.edit().remove(str2).commit();
            sharedPreferences2.edit().putBoolean(str2, true).commit();
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() update showedBefore:=true");
            }
        }
        if (sharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false)) {
            z16 = sharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false);
            sharedPreferences.edit().remove("subaccount_is_top_in_recentlist").commit();
            if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() remove isTopRU=" + z16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() isTop=" + z16);
        }
        return z16;
    }
}
