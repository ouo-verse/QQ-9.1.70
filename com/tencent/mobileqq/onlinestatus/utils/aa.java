package com.tencent.mobileqq.onlinestatus.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class aa {
    public static void a(AppRuntime appRuntime) {
        SharedPreferences.Editor edit = ((IOnlineStatusService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).getSharedPreference().edit();
        edit.remove(AppConstants.Preferences.IS_DIY_STATUS_CHANGE);
        edit.remove(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_DESC);
        edit.remove(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_EMO_TYPE);
        edit.remove(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_EMO_ID);
        edit.apply();
        QLog.d("OnlineStatusSPUtil", 1, "clear DiyStatusInfo");
    }

    public static int b(Context context) {
        int i3 = PreferenceManager.getDefaultSharedPreferences(context).getInt("BatteryCapacity", 0);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusSPUtil", 2, "getBatteryCapacity", Integer.valueOf(i3));
        }
        return i3;
    }

    public static SharedPreferences c(Context context) {
        return context.getSharedPreferences("sp_online_status", 0);
    }

    public static DiyStatusEmoInfo d() {
        SharedPreferences sharedPreference = ((IOnlineStatusService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).getSharedPreference();
        long j3 = sharedPreference.getLong(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_EMO_ID, -1L);
        int i3 = sharedPreference.getInt(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_EMO_TYPE, -1);
        String string = sharedPreference.getString(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_DESC, "");
        if (!TextUtils.isEmpty(string) && j3 > 0 && i3 > 0) {
            return new DiyStatusEmoInfo(i3, j3, string);
        }
        return null;
    }

    public static boolean e(Context context, String str) {
        boolean z16 = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("key_has_show_olympic_status_rank_dialog_" + str, false);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusSPUtil", 2, "getHasShowOlympicStatusRankDialog hasShow: " + z16);
        }
        return z16;
    }

    public static boolean f() {
        return ((IOnlineStatusService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).getSharedPreference().getBoolean(AppConstants.Preferences.IS_DIY_STATUS_CHANGE, false);
    }

    public static int g(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("key_online_status_olympic_medal_egg_event_id", 0);
    }

    public static void h(Context context, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusSPUtil", 2, "putHasSetOlympicStatus");
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("key_has_show_olympic_status_rank_dialog_" + str, z16);
        edit.apply();
    }

    public static void i(long j3, int i3, String str, AppRuntime appRuntime) {
        SharedPreferences.Editor edit = ((IOnlineStatusService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "")).getSharedPreference().edit();
        edit.putBoolean(AppConstants.Preferences.IS_DIY_STATUS_CHANGE, true);
        edit.putString(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_DESC, str);
        edit.putInt(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_EMO_TYPE, i3);
        edit.putLong(AppConstants.Preferences.GET_ONLINE_DIY_STATUS_INFO_EMO_ID, j3);
        edit.apply();
        QLog.d("OnlineStatusSPUtil", 1, "set DiyStatusInfo");
    }

    public static void j(Context context, int i3, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("BatteryCapacity", i3);
        edit.apply();
        if (QLog.isColorLevel() && z16) {
            QLog.d("OnlineStatusSPUtil", 2, "updateBatteryCapacity", Integer.valueOf(i3));
        }
    }

    public static void k(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("key_online_status_olympic_medal_egg_event_id", i3);
        edit.commit();
    }

    public static void l(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("PowerConnectStatus", i3);
        edit.apply();
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusSPUtil", 2, "updatePowerConnectStatus", Integer.valueOf(i3));
        }
    }
}
