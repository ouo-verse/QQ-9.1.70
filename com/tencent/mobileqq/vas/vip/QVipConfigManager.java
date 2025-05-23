package com.tencent.mobileqq.vas.vip;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QVipConfigManager {
    public static final String KEY_BOOLEAN_HAVE_ADD_PTT_GRAY_MSG = "have_add_ptt_gray_msg";
    public static final String KEY_BOOLEAN_HAVE_ADD_PTT_SVIP_GRAY_MSG = "have_add_ptt_svip_gray_msg";
    public static final String KEY_BOOLEAN_HAVE_SHOW_OPEN_SVIP_GRAY_MSG = "have_show_open_svip_gray_msg";
    public static final String KEY_BOOLEAN_HAVE_SHOW_PTT_TIP = "have_show_ptt_tip";
    public static final String KEY_BOOLEAN_HIDE_DIY_TEMPLATE_GUIDE = "hide_diy_template_guide";
    public static final String KEY_BOOLEAN_KEYWORD_GUIDE_CLICKED = "troop_keyword_guide_clicked";
    public static final String KEY_BOOLEAN_KEYWORD_SCROLLED = "troop_keyword_scrolled";
    public static final String KEY_BOOLEAN_QID_KEYWORD_OPEN = "qid_keyword_open";
    public static final String KEY_BOOLEAN_TROOP_KEYWORD_LAST_PULL_TIMESTAMP = "troop_keyword_last_pull_timestamp";
    public static final String KEY_BOOLEAN_TROOP_KEYWORD_OPEN = "troop_keyword_open";
    public static final String KEY_INTEGER_SETTING_ME_VIP_SYNC_FREQ = "setting_me_vip_sync_freq";
    public static final String KEY_INTEGER_SHOW_DIY_TEMPLATE_GUIDE_FOR_GUEST_TIME = "show_diy_template_guide_for_guest_time";
    public static final String KEY_LONG_LAST_PULL_PAY_RULE = "last_pull_pay_rule";
    public static final String KEY_LONG_NAME_PLATE_CONFIG_VERSION = "name_plate_config_version";
    public static final String KEY_LONG_SETTING_ME_GET_VIP_INFO_SEQUENCE = "setting_me_get_vip_info_sequence";
    public static final String KEY_LONG_SETTING_ME_LAST_REQUEST_SUCCESS_TIME = "setting_me_last_request_success_time";
    public static final String KEY_LONG_SETTING_ME_VIP_MEDAL_LIST_RECORD = "key_long_setting_me_vip_medal_list_record";
    public static final String KEY_STRING_LAST_TROOP_KEYWORD_EXPIRE_LIST = "troop_keyword_expire_list_";
    public static final String KEY_STRING_LOGIN_QID_INFO = "qid_info_login";
    public static final String MAIN_KEY_QQ_SETTING = "qqsetting";
    public static final String PREFERENCE_NAME = "qq_vip_configs";
    public static final String SECONDARY_KEY_PROFILE_MEDAL_ICON = "usersummarycardmedalicon";
    public static final String TAG = "QVip.ConfigManager";

    public static boolean getBoolean(@NonNull AppRuntime appRuntime, @NonNull String str, boolean z16) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences(PREFERENCE_NAME, 0);
        String str2 = str + "_" + appRuntime.getCurrentAccountUin();
        boolean z17 = sharedPreferences.getBoolean(str2, z16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "get sp key:" + str2 + " value=" + z17);
        }
        return z17;
    }

    public static int getInteger(@NonNull AppRuntime appRuntime, @NonNull String str, int i3) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences(PREFERENCE_NAME, 0);
        String str2 = str + "_" + appRuntime.getCurrentAccountUin();
        int i16 = sharedPreferences.getInt(str2, i3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "get sp key:" + str2 + " value=" + i16);
        }
        return i16;
    }

    public static long getLong(@NonNull AppRuntime appRuntime, @NonNull String str, long j3) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences(PREFERENCE_NAME, 0);
        String str2 = str + "_" + appRuntime.getCurrentAccountUin();
        long j16 = sharedPreferences.getLong(str2, j3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "get sp key:" + str2 + " value=" + j16);
        }
        return j16;
    }

    public static String getString(@NonNull AppRuntime appRuntime, @NonNull String str, String str2) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences(PREFERENCE_NAME, 0);
        String str3 = str + "_" + appRuntime.getCurrentAccountUin();
        String string = sharedPreferences.getString(str3, str2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "get sp key:" + str3 + " value=" + string);
        }
        return string;
    }

    public static boolean setBoolean(@NonNull AppRuntime appRuntime, @NonNull String str, boolean z16) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences(PREFERENCE_NAME, 0);
        String str2 = str + "_" + appRuntime.getCurrentAccountUin();
        boolean commit = sharedPreferences.edit().putBoolean(str2, z16).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "set sp key:" + str2 + " value=" + commit);
        }
        return commit;
    }

    public static boolean setInteger(@NonNull AppRuntime appRuntime, @NonNull String str, int i3) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences(PREFERENCE_NAME, 0);
        String str2 = str + "_" + appRuntime.getCurrentAccountUin();
        boolean commit = sharedPreferences.edit().putInt(str2, i3).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "set sp key:" + str2 + " value=" + commit);
        }
        return commit;
    }

    public static boolean setLong(@NonNull AppRuntime appRuntime, @NonNull String str, long j3) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences(PREFERENCE_NAME, 0);
        String str2 = str + "_" + appRuntime.getCurrentAccountUin();
        boolean commit = sharedPreferences.edit().putLong(str2, j3).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "set sp key:" + str2 + " value=" + commit);
        }
        return commit;
    }

    public static boolean setString(@NonNull AppRuntime appRuntime, @NonNull String str, String str2) {
        SharedPreferences sharedPreferences = appRuntime.getApp().getSharedPreferences(PREFERENCE_NAME, 0);
        String str3 = str + "_" + appRuntime.getCurrentAccountUin();
        boolean commit = sharedPreferences.edit().putString(str3, str2).commit();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "set sp key:" + str3 + " value=" + str2);
        }
        return commit;
    }
}
