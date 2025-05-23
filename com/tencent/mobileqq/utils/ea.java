package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ea extends p {

    /* renamed from: a, reason: collision with root package name */
    protected static List<String> f307691a;

    public static boolean A(Context context, String str, String str2, boolean z16) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + "_" + str;
        }
        return defaultSharedPreferences.getBoolean(str2, z16);
    }

    public static int A0(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + str2 + "_" + AppConstants.Preferences.MSG_BOX_DELETE_MSG_TAB_FLAG, 0);
    }

    public static long A1(Context context, String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return 0L;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(AppConstants.Preferences.REACTIVE_WILL_DOWNGRADE_TIPS_TIME + str + "_" + str2, 0L);
    }

    public static void A2(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.BLESS_SPECIAL_PENDANT_CONFIG_VERSION, i3);
        edit.commit();
    }

    public static void A3(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(AppConstants.Preferences.BULUO_ENTER_URL_CONFIG, 4).edit();
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(str + "_" + AppConstants.Preferences.BULUO_ENTER_URL_CONFIG, str2);
        } else {
            edit.remove(str + "_" + AppConstants.Preferences.BULUO_ENTER_URL_CONFIG);
        }
        edit.commit();
    }

    public static void A4(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.PUSHBANNER_AD_VERSION_CODE, i3);
        edit.commit();
    }

    public static String B(Context context, String str, String str2, String str3) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(String.format(Locale.getDefault(), "%s_%s_sharedpreutil", str, str2), str3);
    }

    public static int B0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.CAPTURE_FACEU_TEMPLATE_CONFIG_VERSION, 0);
    }

    public static int B1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.SPLASH_VERSION_CODE, 0);
    }

    public static void B2(String str, Object obj) {
        p.g(BaseApplication.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), false, str, obj);
    }

    public static void B3(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("buluo_red_dot_config_version_" + str, i3);
        edit.commit();
    }

    public static void B4(Context context, String str, int i3, Object obj) {
        boolean z16;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String format = String.format(Locale.getDefault(), "%s_%s_%s", str, "push_recommend_shield_config", Integer.valueOf(i3));
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 && (obj instanceof String)) {
                defaultSharedPreferences.edit().putString(format, (String) obj).apply();
                z16 = true;
            }
            z16 = false;
        } else {
            if (obj instanceof Integer) {
                defaultSharedPreferences.edit().putInt(format, ((Integer) obj).intValue()).apply();
                z16 = true;
            }
            z16 = false;
        }
        if (!z16 && QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, String.format(Locale.getDefault(), "updatePushRecommendShield [uin: %s, type: %d, value: %s, key: %s ret: %s]", str, Integer.valueOf(i3), obj, format, Boolean.valueOf(z16)));
        }
    }

    public static int C(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(String.format(Locale.getDefault(), "%s_%s_appid", str, str2), 0);
    }

    public static int C0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.NEARBY_CHAT_GRAY_TIPS_CONFIG_VERSION, 0);
    }

    public static String C1(String str) {
        return (String) j(str, "");
    }

    public static void C2(Context context, String str, int i3, boolean z16) {
        String str2 = "key_cloud_file_guide_banner&" + str + ContainerUtils.FIELD_DELIMITER + i3;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str2, z16);
        edit.commit();
    }

    public static void C3(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str + "_" + AppConstants.Preferences.BULUO_PROFILE_SUMMARY_URL_CONFIG, str2);
        edit.commit();
    }

    public static void C4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("qq_pre_down_yyb_ver_" + str, i3);
        edit.commit();
    }

    public static String D(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(String.format(Locale.getDefault(), "%s_%s_config_content", str, str2), "");
    }

    public static int D0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.NEARBY_HOTCHAT_V_LIST_CONFIG_VERSION, 0);
    }

    public static int D1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.SUBSCRIPT_RECOMMEND_CONFIG_VERSION + "_" + AppSetting.f99554n, 0);
    }

    public static void D2(Context context, String str, String str2, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + "_" + str;
        }
        edit.putBoolean(str2, z16);
        edit.commit();
    }

    public static void D3(Context context, String str, long j3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(str + "_" + AppConstants.Preferences.GRAYTIPS_CALL_LAST_ALERTTIME, j3);
        edit.commit();
    }

    public static void D4(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + AppConstants.Preferences.QAV_ANYCHAT_TIME_LIMIT_CONFIG_VERSION_CODE, i3);
        edit.commit();
    }

    public static SharedPreferences E(String str, String str2) {
        return BaseApplication.getContext().getSharedPreferences(str2 + str, 0);
    }

    public static int E0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("hot_friend_new_boat_config_" + str, 0);
    }

    public static int E1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_CONFIG_APPID, 0);
    }

    public static void E2(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.DOCS_IMPORT_FILE_WEB_URL, str);
        edit.apply();
    }

    public static void E3(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.CAMERA_COMPATIBLE_LIST_VERSION, i3);
        edit.commit();
    }

    public static void E4(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + AppConstants.Preferences.QAV_UPGRADE_CONFIG_VERSION_CODE, i3);
        edit.commit();
    }

    public static int F(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(String.format(Locale.getDefault(), "%s_%s_version", str, str2), 0);
    }

    public static int F0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.NOW_DOWNLOAD_ENGINE_CMD_VERSION, 0);
    }

    public static int F1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_CONFIG_VERSION, 0);
    }

    public static void F2(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("docs_structing_msg_gray_tips_group_showed_count_" + str, i3);
        edit.apply();
    }

    public static void F3(Context context, int i3, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("classic_head_activity_config_version_" + str, i3);
        edit.putString("classic_head_activity_config_" + str, str2);
        edit.commit();
    }

    public static void F4(Context context, String str, int i3, int i16, int i17, String str2, String str3, String str4, String str5, boolean z16, int i18) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_CONFIG_VERSION, i3);
        edit.putInt(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_AVATAR_SWITCH, i16);
        edit.putInt(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_TITLE_BG_SWITCH, i17);
        edit.putInt(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_BUBBLE_SWITCH, i18);
        edit.putString(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_RESOURCE_URL, str2);
        edit.putString(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_RESOURCE_MD5, str3);
        edit.putString(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_QIM_WEBSITE, str4);
        edit.putString(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_ONLINE_WORDING, str5);
        edit.putBoolean(AppConstants.Preferences.QIM_USER_SPECIAL_FORCE_DOWDLORD, z16);
        edit.commit();
    }

    public static SharedPreferences G(String str) {
        return BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.CONTACT_RECOMMEND_SP + str, 0);
    }

    public static int G0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.NOW_TAB_CONFIG_CMD_VERSION, 0);
    }

    public static boolean G1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str + "_" + AppConstants.Preferences.TROOP_EFFECT_PIC_GUIDE, false);
    }

    public static void G2(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("docs_structing_msg_gray_tips_remain_count_" + str, i3);
        edit.apply();
    }

    public static void G3(String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putLong(str + "_" + AppConstants.Preferences.CLEAN_DISKCACHE_TIME, NetConnInfoCenter.getServerTime() / 3600);
        edit.commit();
    }

    public static void G4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_CONFIG_APPID, i3);
        edit.commit();
    }

    public static int H(Context context, String str) {
        int i3 = PreferenceManager.getDefaultSharedPreferences(context).getInt("contact_recommend_tab_config_version_" + str, 0);
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 1, "getContactRecommendTabConfigVersion version:" + i3);
        }
        return i3;
    }

    public static int H0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.PA_SUBSCRIBE_CONFIG_VERSION, 0);
    }

    public static int H1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("troop_gift_url_config_version_" + str, 0);
    }

    public static void H2(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.DOODLE_TEMPLATE_CONFIG_VERSION, i3);
        edit.commit();
    }

    public static void H3(Context context, String str, int i3, int i16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_CONFIG_VERSION, i3);
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_COMBO_TIME, i16);
        edit.commit();
    }

    public static void H4(Context context, String str, boolean z16) {
        String str2;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (QQAppInterface.class.isInstance(runtime)) {
            str2 = ((QQAppInterface) runtime).getCurrentUin();
        } else {
            str2 = "";
        }
        edit.putBoolean(str + "_" + AppConstants.Preferences.QIM_VIDEO_COMBOL_LOCK_INFO + "_" + str2, z16);
        edit.commit();
    }

    public static boolean I(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("conversation_unfollow_public_acc_switch_" + str, false);
    }

    public static int I0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.PASSWD_RED_BAG_SETTING_VERSION, 0);
    }

    public static int I1(Context context, String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("troop_pobing_config_version_" + str, 0);
    }

    public static void I2(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "setDownloadDialogShownTimes: invoked. ", " times: ", Integer.valueOf(i3), " uin: ", str);
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("download_dialog_shown_times_" + str, i3);
        edit.apply();
    }

    public static void I3(Context context, String str, String str2, boolean z16) {
        String format = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", str, str2);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(format, z16);
        edit.apply();
    }

    public static void I4(Context context, String str, String str2, int i3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + AppConstants.Preferences.AIO_CONFIG, 0).edit();
        edit.putInt(str2, i3);
        edit.apply();
    }

    public static boolean J(Context context, String str, String str2) {
        return QMMKV.from(context, "common_mmkv_configurations").decodeBool(str + AppConstants.Preferences.PUBLIC_ACCOUNT_UNFOLLOW_COVERSATION_SWITCH + str2, false);
    }

    public static int J0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.PHOTO_PLUS_STICKER_VERSION + str, 0);
    }

    public static int J1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.TROOP_RANK_MAP_CONFIG_VERSION, 0);
    }

    public static void J2(Context context, String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "setDownloadDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(j3), " uin: ", str);
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("download_dialog_shown_timestamp_" + str, j3);
        edit.apply();
    }

    public static void J3(Context context, String str, String str2, String str3) {
        String format = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", str, str2);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(format, str3);
        edit.apply();
    }

    public static void J4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + AppConstants.Preferences.AIO_CONFIG, 0).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.RECEIPT_CONFIG_VERSION_CODE, i3);
        edit.commit();
    }

    public static int K(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("conversation_unfollow_public_acc_version_" + str, 0);
    }

    public static int K0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.PRE_DOWNLOAD_DIALOG_VERSION + str, 0);
    }

    public static boolean K1() {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        String str = "troop_smart_manager_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
        boolean z16 = sharedPreferences.getBoolean(str, false);
        if (QLog.isColorLevel()) {
            QLog.d("TroopSmartManager", 2, "getTroopSmartManagerSwitch, key: " + str + " ,isOn: " + z16);
        }
        return z16;
    }

    public static void K2(boolean z16) {
        SharedPreferences.Editor edit = R0().edit();
        QLog.i("SharedPreUtils", 1, "setEnableDoubleAIDenoise = " + z16);
        edit.putBoolean(AppConstants.Preferences.KEY_ENABLE_DOUBLE_AI_DENOIDE, z16);
        edit.commit();
    }

    public static void K3(Context context, String str, String str2, int i3) {
        String format = String.format(Locale.getDefault(), "%s_%s_appid", str, str2);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(format, i3);
        edit.apply();
    }

    public static void K4(Context context, String str, int i3, boolean z16, int i16, boolean z17, boolean z18) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.REDBAG_FOLD_MSG_CONFIG_VERSION, i3);
        edit.putBoolean(str + "_" + AppConstants.Preferences.REDBAG_FOLD_MSG_SWITCH, z16);
        edit.putInt(str + "_" + AppConstants.Preferences.REDBAG_FOLD_MSG_NUM, i16);
        edit.putBoolean(str + "_" + AppConstants.Preferences.REDBAG_FOLD_INDEX_SWITCH, z17);
        edit.putBoolean(str + "_" + AppConstants.Preferences.REDBAG_FOLD_INDEX_WITH_REDBAGID, z18);
        edit.commit();
    }

    public static int L(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.DOODLE_TEMPLATE_CONFIG_VERSION, 0);
    }

    public static String L0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.PUBLIC_ACCOUNT_CONFIG_DATA, null);
    }

    public static int L1(Context context, String str) {
        int i3 = PreferenceManager.getDefaultSharedPreferences(context).getInt("upgrade_appid_" + str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "getUpgradeAppid: invoked. ", " appid: ", Integer.valueOf(i3), " uin: ", str);
        }
        return i3;
    }

    public static void L2(boolean z16) {
        SharedPreferences.Editor edit = R0().edit();
        QLog.i("SharedPreUtils", 1, "setEnableGroupAIDenoise = " + z16);
        edit.putBoolean(AppConstants.Preferences.KEY_ENABLE_GROUP_AI_DENOIDE, z16);
        edit.commit();
    }

    public static void L3(Context context, String str, String str2, String str3) {
        String format = String.format(Locale.getDefault(), "%s_%s_config_content", str, str2);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(format, str3);
        edit.apply();
    }

    public static void L4(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(str + "_" + AppConstants.Preferences.RICH_TEXT_CHAT_CONFIG_CONTENT, str2);
        }
        edit.commit();
    }

    public static String M(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.DOCS_IMPORT_FILE_WEB_URL, "");
    }

    public static int M0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.PUBLIC_ACCOUNT_CONFIG_VERSION, 0);
    }

    public static int M1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.UPGRADE_TIM_VERSION + str, 0);
    }

    public static void M2(Context context, String str, int i3, String str2) {
        if (str != null && str.length() != 0 && context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("SharedPreUtils_preference" + str, 4).edit();
            edit.putInt(str2, i3);
            edit.commit();
        }
    }

    public static void M3(Context context, String str, String str2, int i3) {
        String format = String.format(Locale.getDefault(), "%s_%s_version", str, str2);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(format, i3);
        edit.apply();
    }

    public static void M4(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str + "_rich_text_first_time_tab_showed", z16);
        edit.commit();
    }

    public static int N(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("docs_structing_msg_gray_tips_group_showed_count_" + str, 0);
    }

    public static int N0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.PUSHBANNER_AD_VERSION_CODE, 0);
    }

    public static String N1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.BIRTHDAY_USER, "");
    }

    public static void N2(int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putBoolean("hasClicked" + i3 + str, true);
        edit.commit();
    }

    public static void N3(Context context, String str, String str2) {
        String str3;
        SharedPreferences.Editor edit = G(str).edit();
        String str4 = "contact_recommend_tab_config_json_" + str;
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2;
        }
        edit.putString(str4, str3);
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("boundaryFriendsCount")) {
                    edit.putInt("boundaryFriendsCount", jSONObject.optInt("boundaryFriendsCount"));
                }
            }
        } catch (Exception e16) {
            QLog.e("SharedPreUtils", 1, "updateContactRecommendTabConfigJson error:" + e16.getMessage());
        }
        edit.commit();
    }

    public static void N4(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("rich_text_chat_config_settting_switch_" + str, z16);
        edit.apply();
    }

    public static int O(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("docs_structing_msg_gray_tips_remain_count_" + str, 0);
    }

    public static long O0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("key_notification_push_gray_tips_time_millis_today_zero_" + str, 0L);
    }

    public static boolean O1(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(AppConstants.Preferences.LOGIN_UNVERIFIED_PHONE_SHOW_RED_DOT + str + str2, false);
    }

    public static void O2(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "setHasShowZplanAvatarEntryBubble: " + z16);
        }
        QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QAV).encodeBool("key_has_show_zplan_avatar_bubble_" + str, z16);
    }

    public static void O3(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("contact_recommend_tab_config_version_" + str, i3);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 1, "updateContactRecommendTabConfigVersion version:" + i3);
        }
    }

    public static void O4(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.SV_DYNAMIC_ADJUSTMENT, i3);
        edit.commit();
    }

    public static int P(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.DOODLE_TEMPLATE_CONFIG_VERSION, 0);
    }

    public static int P0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("key_notification_push_gray_tips_today_count_" + str, 0);
    }

    public static int P1(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str2 + "_" + str, 0);
    }

    public static void P2(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "setHasShowZplanAvatarTryTips: " + z16);
        }
        QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QAV).encodeBool("key_has_show_zplan_avatar_try_tips_" + str, z16);
    }

    public static void P3(Context context, String str, String str2, boolean z16) {
        QMMKV.from(context, "common_mmkv_configurations").encodeBool(str + AppConstants.Preferences.PUBLIC_ACCOUNT_UNFOLLOW_COVERSATION_SWITCH + str2, z16);
    }

    public static void P4(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.SCRIBBLE_CONFIG_VERSION, i3);
        edit.commit();
    }

    public static int Q(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.QIM_FACEU_CONFIG_VERSION, 0);
    }

    public static Object Q0(Context context, String str, int i3) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String format = String.format(Locale.getDefault(), "%s_%s_%s", str, "push_recommend_shield_config", Integer.valueOf(i3));
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                return null;
            }
            return defaultSharedPreferences.getString(format, "");
        }
        return Integer.valueOf(defaultSharedPreferences.getInt(format, 0));
    }

    public static String Q1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.VIDEODOWN_CT_WHITELIST, null);
    }

    public static void Q2(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.iAsync("SharedPreUtils", 2, "setInSpringWhiteList isInSpringWhiteList : " + z16);
        }
        V0(BaseApplication.getContext(), str).edit().putBoolean(AppConstants.Preferences.QAV_IS_IN_SPRING_WHITE_LIST, z16).apply();
    }

    public static void Q3(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("conversation_unfollow_public_acc_version_" + str, i3);
        edit.apply();
    }

    public static void Q4(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.SCRIBBLE_GIF_CONFIG, str);
        edit.commit();
    }

    public static int R(Context context, String str) {
        int i3 = PreferenceManager.getDefaultSharedPreferences(context).getInt("download_dialog_shown_times_" + str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "getDownloadDialogShownTimes: invoked. ", " times: ", Integer.valueOf(i3), " uin: ", str);
        }
        return i3;
    }

    public static SharedPreferences R0() {
        return vu.a.h(AppConstants.Preferences.QAV_AI_DENOISE, 4);
    }

    public static int R1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.VIDEODOWN_CT_WHITELIST_VERSION, 0);
    }

    public static void R2(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "setInstallDialogShownTimes: invoked. ", " times: ", Integer.valueOf(i3), " uin: ", str);
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("install_dialog_shown_times_" + str, i3);
        edit.apply();
    }

    public static void R3(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.CREATE_TROOP_MAX_INVITE_NUM, i3);
        edit.commit();
    }

    public static void R4(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.SCRIBBLE_GIF_VERSION, str);
        edit.commit();
    }

    public static long S(Context context, String str) {
        long j3 = PreferenceManager.getDefaultSharedPreferences(context).getLong("download_dialog_shown_timestamp_" + str, 0L);
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "getDownloadDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(j3), " uin: ", str);
        }
        return j3;
    }

    public static SharedPreferences S0(String str) {
        return BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.QAV_ANYCHAT_TIME_LIMIT + str, 0);
    }

    public static int S1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("video_redbag_config_version_" + str, 0);
    }

    public static void S2(Context context, String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "setInstallDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(j3), " uin: ", str);
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("install_dialog_shown_timestamp_" + str, j3);
        edit.apply();
    }

    public static void S3(Context context, int i3, int i16, int i17, int i18, String str, String str2, String str3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_VERSION, i3);
        edit.putInt(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_PLAY_TIMES, i16);
        edit.putInt(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_PLAY_INTERVAL, i17);
        edit.putInt(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_TOTAL_SHOW_TIMES, i18);
        edit.putString(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_MD5, str);
        edit.putString(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_EFFECTIVE_TIME, str2);
        edit.putString(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_ZIP_URL, str3);
        edit.commit();
    }

    public static void S4(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.SCRIBBLE_PAINT_CONFIG, str);
        edit.commit();
    }

    public static int T(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.DYNAMIC_SPLASH_CONFIG_VERSION, 0);
    }

    public static SharedPreferences T0(Context context) {
        return vu.a.h("qav_business", 4);
    }

    public static String T1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("video_redbag_res_md5_" + str, "");
    }

    public static void T2(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("docs_export_file_is_first_" + str, z16);
        edit.apply();
    }

    public static void T3(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("emotion_edit_guide_pop_switch_" + str, z16);
        edit.commit();
    }

    public static void T4(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.SCRIBBLE_PAINT_VERSION, str);
        edit.commit();
    }

    public static int U(BaseApplication baseApplication) {
        return PreferenceManager.getDefaultSharedPreferences(baseApplication.getApplicationContext()).getInt(AppConstants.Preferences.QIM_DYNAMIC_CONFIG_VERSION, 0);
    }

    public static SharedPreferences U0(Context context) {
        return vu.a.h("qav_SP", 4);
    }

    public static String U1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("video_redbag_res_url_" + str, "");
    }

    public static void U2(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.LAST_LOGINUIN_FOR_BIRTHDAY_SPALSH, str);
        edit.commit();
    }

    public static void U3(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("entry_config_verion_code_" + str, i3);
        edit.commit();
    }

    public static void U4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.SEND_BLESS_VERSION_CODE + str, i3);
        edit.commit();
    }

    public static boolean V(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("emotion_edit_guide_pop_switch_" + str, true);
    }

    public static SharedPreferences V0(Context context, String str) {
        return vu.a.h("qav_SP_" + str, 4);
    }

    public static SharedPreferences V1(String str) {
        return BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.AV_WEAK_NET_VIDEO_CONFIG_VERSION + str, 0);
    }

    public static void V2(long j3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).edit();
        edit.putLong("monitorStartTime", j3);
        edit.apply();
    }

    public static void V3(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("eqq-config-data", str);
        edit.commit();
    }

    public static void V4(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.SHORTVIDEO_PROGRESSIVE_BLACKLIST_VERSION, i3);
        edit.commit();
    }

    public static int W(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("entry_config_verion_code_" + str, 0);
    }

    public static SharedPreferences W0(String str) {
        return vu.a.h(AppConstants.Preferences.QAV_SCORE + str, 4);
    }

    public static int W1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("zhitu_config_version_" + str, 0);
    }

    public static void W2(long j3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).edit();
        edit.putLong("peakThreadCount", j3);
        edit.apply();
    }

    public static void W3(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("eqq_config_version_code", i3);
        edit.commit();
    }

    public static void W4(Context context, String str, boolean z16, boolean z17, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str + "_" + AppConstants.Preferences.SHOW_HOT_FRIEND_DAYS_CONTACT, z16);
        edit.putBoolean(str + "_" + AppConstants.Preferences.SHOW_HOT_FRIEND_DAYS_CHAT, z17);
        edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_DAYS_SETTING, str2);
        edit.commit();
    }

    public static String X(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("eqq-config-data", null);
    }

    public static SharedPreferences X0(String str) {
        return BaseApplication.getContext().getSharedPreferences(AppConstants.Preferences.QAV_UPGRADE_INVITE + str, 0);
    }

    public static int X1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("zhitu_config_page_len_" + str, 8);
    }

    public static void X2(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "setMobileNetSupport isSupport : " + z16);
        }
        V0(BaseApplication.getContext(), str).edit().putBoolean(AppConstants.Preferences.QAV_MOBILE_NET_SUPPORT, z16).apply();
    }

    public static void X3(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("hot_friend_chat_config_" + str, i3);
        edit.commit();
    }

    public static void X4(Context context, int i3, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.SPLASH_VERSION_CODE, i3);
        edit.putString(AppConstants.Preferences.SPLASH_EFFECTIVE_TIME, str);
        edit.putString(AppConstants.Preferences.SPLASH_MD5VALUE, str2);
        edit.commit();
    }

    public static int Y(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("eqq_config_version_code", 0);
    }

    public static int Y0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.QIM_MUSIC_CONFIG_VERSION, 0);
    }

    public static int Y1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("zhitu_safegate_request_interval_" + str, 0);
    }

    public static void Y2(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.CAPTURE_FACEU_TEMPLATE_CONFIG_VERSION, i3);
        edit.commit();
    }

    public static void Y3(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("general_configs_version_code_" + str, i3);
        edit.commit();
    }

    public static void Y4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.SUBSCRIPT_RECOMMEND_CONFIG_VERSION + "_" + AppSetting.f99554n, i3);
        edit.commit();
    }

    public static boolean Z(Context context, String str, int i3, String str2) {
        if (str == null || str.length() == 0 || context == null) {
            return false;
        }
        if (i3 <= context.getSharedPreferences("SharedPreUtils_preference" + str, 4).getInt(str2, 0)) {
            return false;
        }
        return true;
    }

    public static int Z0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.QIM_STICKER_CONFIG_VERSION, 0);
    }

    public static long Z1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("zhitu_safegate_request_time_" + str, 0L);
    }

    public static void Z2(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.NEARBY_CHAT_GRAY_TIPS_CONFIG_VERSION, i3);
        edit.commit();
    }

    public static void Z3(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.GREEN_VIDEO_CONFIG_APPID, i3);
        edit.commit();
    }

    public static void Z4(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "updateSupportFriendshipReactive code: " + i3);
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_SUPPORT_KEY, i3);
        edit.commit();
    }

    public static int a0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("general_configs_version_code_" + str, 0);
    }

    public static int[] a1() {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4);
        return new int[]{sharedPreferences.getInt("filter_download", 0), sharedPreferences.getInt("filter_total", 0)};
    }

    public static boolean a2(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("zhitu_safegate_switch_" + str, false);
    }

    public static void a3(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.NOW_DOWNLOAD_ENGINE_CMD_VERSION, i3);
        edit.commit();
    }

    public static void a4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("green_video_config_version_" + str, i3);
        edit.commit();
    }

    public static void a5(Context context, String str, int i3, int i16, int i17, String str2, String str3, String str4, String str5, boolean z16, int i18) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_CONFIG_VERSION, i3);
        edit.putInt(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_AVATAR_SWITCH, i16);
        edit.putInt(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_TITLE_BG_SWITCH, i17);
        edit.putInt(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_BUBBLE_SWITCH, i18);
        edit.putString(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_RESOURCE_URL, str2);
        edit.putString(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_RESOURCE_MD5, str3);
        edit.putString(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_TIM_WEBSITE, str4);
        edit.putString(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_ONLINE_WORDING, str5);
        edit.putBoolean(AppConstants.Preferences.TIM_USER_SPECIAL_FORCE_DOWDLORD, z16);
        edit.commit();
    }

    public static int b0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.GREEN_VIDEO_CONFIG_APPID, 0);
    }

    public static boolean b1() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 0).getBoolean("qq_filter_flag", false);
    }

    public static boolean b2(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("zhitu_config_save_share_switch_" + str, false);
    }

    public static void b3(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.NOW_TAB_CONFIG_CMD_VERSION, i3);
        edit.commit();
    }

    public static void b4(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.GREEN_VIDEO_LIST, str);
        edit.commit();
    }

    public static void b5(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_CONFIG_APPID, i3);
        edit.commit();
    }

    public static int c0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("green_video_config_version_" + str, 0);
    }

    public static long c1() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).getLong("filter_spacing", 0L);
    }

    public static boolean c2(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("zhitu_setting_switch_" + str, true);
    }

    public static void c3(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "setOnlinePreviewSupport isSupport : " + z16);
        }
        QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeBool("key_use_online_preview_" + str, z16);
    }

    public static void c4(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("group_video_version_code_" + str, i3);
        edit.commit();
    }

    public static void c5(Context context, String str, int i3, int i16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_CONFIG_VERSION, i3);
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_TOUCH_EFFECT_APPLY, i16);
        edit.commit();
    }

    public static String d0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.GREEN_VIDEO_LIST, "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24");
    }

    public static int d1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.QQHOTSPOT_CONFIG_VERSION_CODE, 0);
    }

    public static boolean d2(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("zhitu_config_switch_" + str, false);
    }

    public static void d3(Context context, String str, long j3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("key_notification_push_gray_tips_time_millis_today_zero_" + str, j3).apply();
    }

    public static void d4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.QQHEAD_SYNCQZONE_CHECKEDSTATE, i3);
        edit.commit();
    }

    public static void d5(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str + "_" + AppConstants.Preferences.TROOP_EFFECT_PIC_GUIDE, true);
        edit.commit();
    }

    public static int e0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("group_video_version_code_" + str, 0);
    }

    public static String e1(Context context, String str) {
        return context.getSharedPreferences(AppConstants.Preferences.QQ_PRE_DOWN_YYB_CONFIG, 0).getString(str, "");
    }

    public static int e2(String str, int i3) {
        int decodeInt = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QAV).decodeInt("key_zplan_avatar_easter_egg_tips_time_" + str, i3);
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "getZplanAvatarEasterEggTipsTimes : " + decodeInt);
        }
        return decodeInt;
    }

    public static void e3(Context context, String str, int i3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("key_notification_push_gray_tips_today_count_" + str, i3).apply();
    }

    public static void e4(Context context, String str, int i3, boolean z16, boolean z17) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.HEADS_UP_NOTIFY_VERSION, i3);
        if (z16) {
            edit.putBoolean(str + "_" + AppConstants.Preferences.HEADS_UP_NOTIFY_SWITCH, z17);
        }
        edit.commit();
    }

    public static void e5(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("troop_gift_url_config_version_" + str, i3);
        edit.commit();
    }

    public static int f0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.QQHEAD_SYNCQZONE_CHECKEDSTATE, -1);
    }

    public static int f1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("qq_pre_down_yyb_ver_" + str, 0);
    }

    public static int f2(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.SEND_BLESS_VERSION_CODE + str, 0);
    }

    public static void f3(int i3, int i16) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).edit();
        edit.putInt("filter_download", i3);
        edit.putInt("filter_total", i16);
        edit.commit();
    }

    public static void f4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.QQHEAD_HISTORY_NUMFLAG, i3);
        edit.commit();
    }

    public static void f5(Context context, String str) {
        boolean z16;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        String str2 = "troop_smart_manager_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
        if (!TextUtils.isEmpty(str) && str.equals("on")) {
            z16 = true;
        } else {
            z16 = false;
        }
        sharedPreferences.edit().putBoolean(str2, z16).apply();
        if (QLog.isColorLevel()) {
            QLog.d("TroopSmartManager", 2, "updateTroopSmartManagerSwitch, key: " + str2 + " ,isOn: " + z16);
        }
    }

    public static int g0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.HEADS_UP_NOTIFY_VERSION, 0);
    }

    public static int g1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.QWALLET_SETTING_VERSION, 0);
    }

    public static boolean g2(int i3, String str) {
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean("hasClicked" + i3 + str, false);
    }

    public static void g3() {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 0).edit();
        edit.putBoolean("qq_filter_flag", true);
        edit.commit();
    }

    public static void g4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.HOT_CHAT_AIO_POST_TAB_PLUGIN, i3);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.AIO_POST_LIST_PLUGIN, 2, "updateHotChatAIOPluginFlag,re:" + i3);
        }
        edit.commit();
    }

    public static void g5(String str, String[] strArr) {
        StringBuilder sb5 = new StringBuilder("");
        if (strArr != null && strArr.length > 0) {
            for (int i3 = 0; i3 < strArr.length - 1; i3++) {
                sb5.append(strArr[i3]);
                sb5.append("_");
            }
            sb5.append(strArr[strArr.length - 1]);
        }
        PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putString("pref_tag_unify_hotword_title_list" + str, sb5.toString()).commit();
    }

    public static void h(Context context, String str, String str2) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        String str3 = str + "_" + AppConstants.Preferences.LOCAL_SET_TOP_TROOP_UPLOADED_IGNORE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(defaultSharedPreferences.getString(str + "_" + AppConstants.Preferences.LOCAL_SET_TOP_TROOP_UPLOADED_IGNORE, ""));
        sb5.append("_");
        sb5.append(str2);
        edit.putString(str3, sb5.toString());
        edit.commit();
        if (f307691a == null) {
            f307691a = t0(context, str);
        }
        f307691a.add(str2);
    }

    public static int h0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.QQHEAD_HISTORY_NUMFLAG, -1);
    }

    public static int h1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + AppConstants.Preferences.QAV_ANYCHAT_TIME_LIMIT_CONFIG_VERSION_CODE, 0);
    }

    public static boolean h2(String str) {
        boolean decodeBool = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QAV).decodeBool("key_has_show_zplan_avatar_bubble_" + str, false);
        if (QLog.isColorLevel()) {
            QLog.iAsync("SharedPreUtils", 2, "hasShowZplanAvatarEntryBubble : " + decodeBool);
        }
        return decodeBool;
    }

    public static void h3(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstants.Preferences.QQ_PRE_DOWN_YYB_CONFIG, 0);
        sharedPreferences.edit().putString(str, str2);
        sharedPreferences.edit().commit();
    }

    public static void h4(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str + "_" + AppConstants.Preferences.HOT_CHAT_LINK, str2);
        edit.commit();
    }

    public static void h5(Context context, String str, int i3, int i16, int i17) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_CONFIG_VERSION, i3);
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_UNIQUE_POKE_SHOW, i16);
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_UNIQUE_POKE_TYPE, i17);
        edit.commit();
    }

    @TargetApi(9)
    public static void i(SharedPreferences.Editor editor) {
        editor.apply();
    }

    public static int i0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.HOTCHAT_CLASSIFY_VERSION_CODE, 0);
    }

    public static int i1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + AppConstants.Preferences.QAV_UPGRADE_CONFIG_VERSION_CODE, 0);
    }

    public static boolean i2(String str) {
        boolean decodeBool = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QAV).decodeBool("key_has_show_zplan_avatar_try_tips_" + str, false);
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "hasShowZplanAvatarTryTips : " + decodeBool);
        }
        return decodeBool;
    }

    public static void i3(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.REACTIVE_NOTIFICATION_TIME + str + "_" + str3, str2);
        edit.apply();
    }

    public static void i4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.MSG_BOX_INTER_FOLLOW_UNREAD_COUNT, i3);
        edit.commit();
    }

    public static void i5(Context context, String str, long j3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(AppConstants.Preferences.UPGRADE_QQ_TIME + str, j3);
        edit.commit();
    }

    public static Object j(String str, Object obj) {
        return p.b(BaseApplication.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), str, obj);
    }

    public static int j0(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.HOTCHAT_SCENE_CONFIG_VERSION, 0);
    }

    public static int j1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_CONFIG_APPID, 0);
    }

    public static boolean j2(Context context, String str, int i3) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("key_cloud_file_guide_banner&" + str + ContainerUtils.FIELD_DELIMITER + i3, true);
    }

    public static void j3(Context context, String str, String str2, long j3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(AppConstants.Preferences.REACTIVE_WILL_DOWNGRADE_TIPS_TIME + str + "_" + str2, j3);
        edit.apply();
    }

    public static void j4(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str + "_" + AppConstants.Preferences.BULUO_IS_SHOW_NUM_RED_DOT, z16);
        edit.commit();
    }

    public static void j5(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.UPGRADE_TIM_VERSION + str, i3);
        edit.commit();
    }

    public static int k(Context context, String str) {
        return BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + AppConstants.Preferences.AIO_CONFIG, 0).getInt(str + "_" + AppConstants.Preferences.AIO_CONFIG_VERSION_CODE, 0);
    }

    public static int k0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("individuation_abtest_code_" + str, 0);
    }

    public static int k1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_CONFIG_VERSION, 0);
    }

    public static boolean k2() {
        boolean z16 = R0().getBoolean(AppConstants.Preferences.KEY_ENABLE_DOUBLE_AI_DENOIDE, false);
        QLog.iAsync("SharedPreUtils", 1, "currentDoubleAIDenoiseStatus = " + z16);
        return z16;
    }

    public static void k3(Context context, String str, String str2, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(AppConstants.Preferences.HAS_SHOW_ROBOT_CHAT_WARING_BANNER + str + "_" + str2, z16);
        edit.apply();
    }

    public static void k4(String str, long j3) {
        BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("last_close_noti_guid_banner_ts_" + str, j3).apply();
    }

    public static void k5(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.BIRTHDAY_USER, str);
        edit.commit();
    }

    public static int[] l() {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4);
        return new int[]{sharedPreferences.getInt("av_pendant_download", 0), sharedPreferences.getInt("av_pendant_total", 0)};
    }

    public static int l0(Context context, String str) {
        int i3 = PreferenceManager.getDefaultSharedPreferences(context).getInt("install_dialog_shown_times_" + str, 0);
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "getInstallDialogShownTimes: invoked. ", " times: ", Integer.valueOf(i3), " uin: ", str);
        }
        return i3;
    }

    public static int l1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.READINJOY_LOCAL_CHANNEL_CONFIG_VERSION, 0);
    }

    public static boolean l2() {
        boolean z16 = R0().getBoolean(AppConstants.Preferences.KEY_ENABLE_GROUP_AI_DENOIDE, true);
        QLog.i("SharedPreUtils", 1, "currentGroupAIDenoiseStatus = " + z16);
        return z16;
    }

    public static void l3(boolean z16) {
        SharedPreferences.Editor edit = R0().edit();
        edit.putBoolean(AppConstants.Preferences.KEY_SUPPORT_AI_DENOIDE, z16);
        edit.commit();
    }

    public static void l4(String str, String str2, long j3) {
        BaseApplicationImpl.getApplication().getSharedPreferences(str + "_qqstory_feed_sp", 0).edit().putLong("key_latest_q_zone_feed_second_" + str2, j3).apply();
    }

    public static void l5(Context context, String str, String str2, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str2 + "_" + str, i3);
        edit.commit();
    }

    public static boolean m() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 0).getBoolean("av_pendant_flag", false);
    }

    public static long m0(Context context, String str) {
        long j3 = PreferenceManager.getDefaultSharedPreferences(context).getLong("install_dialog_shown_timestamp_" + str, 0L);
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "getInstallDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(j3), " uin: ", str);
        }
        return j3;
    }

    public static int m1(Context context, String str) {
        return BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + AppConstants.Preferences.AIO_CONFIG, 0).getInt(str + "_" + AppConstants.Preferences.RECEIPT_CONFIG_VERSION_CODE, 0);
    }

    public static boolean m2(String str) {
        boolean z16 = V0(BaseApplication.getContext(), str).getBoolean(AppConstants.Preferences.QAV_IS_IN_SPRING_WHITE_LIST, false);
        if (QLog.isColorLevel()) {
            QLog.iAsync("SharedPreUtils", 2, "isInSpringWhiteList : " + z16);
        }
        return z16;
    }

    public static void m3(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "setSupportAudioBackgroundFloatWindow isSupport : " + z16);
        }
        V0(BaseApplication.getContext(), str).edit().putBoolean(AppConstants.Preferences.QAV_SUPPORT_AUDIO_BACKGROUND_FLOAT_WINDOW, z16).apply();
    }

    public static void m4(String str, String str2, long j3) {
        BaseApplicationImpl.getApplication().getSharedPreferences(str + "_qqstory_feed_sp", 0).edit().putLong("key_latest_signature_feed_second_" + str2, j3).apply();
    }

    public static void m5(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.VIDEODOWN_CT_WHITELIST_VERSION, i3);
        edit.putString(AppConstants.Preferences.VIDEODOWN_CT_WHITELIST, str);
        edit.commit();
    }

    public static long n() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).getLong("av_pendant_spacing", 0L);
    }

    public static int n0(String str) {
        return ((Integer) j(str, 0)).intValue();
    }

    public static int n1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.REDBAG_FOLD_MSG_CONFIG_VERSION, 0);
    }

    public static boolean n2(String str) {
        boolean z16 = V0(BaseApplication.getContext(), str).getBoolean(AppConstants.Preferences.QAV_MOBILE_NET_SUPPORT, true);
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "isMobileNetSupport isSupport : " + z16);
        }
        return z16;
    }

    public static void n3(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "setSupportVideoBackgroundFloatWindow isSupport : " + z16);
        }
        V0(BaseApplication.getContext(), str).edit().putBoolean(AppConstants.Preferences.QAV_SUPPORT_VIDEO_BACKGROUND_FLOAT_WINDOW, z16).apply();
    }

    public static void n4(Context context, String str, int i3, boolean z16, boolean z17) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.LONG_TEXT_MSG_CONFIG_VERSION, i3);
        edit.putBoolean(str + "_" + AppConstants.Preferences.LONG_TEXT_MSG_SWITCH, z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_msfpull_filter_switch");
        edit.putBoolean(sb5.toString(), z17);
        edit.commit();
    }

    public static void n5(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("zhitu_config_version_" + str, i3);
        edit.apply();
    }

    public static int o(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("general_android_configs_version_code_" + str, 0);
    }

    public static int o0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.MSG_BOX_INTER_FOLLOW_UNREAD_COUNT, 0);
    }

    public static boolean o1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str + "_rich_text_first_time_tab_showed", false);
    }

    public static boolean o2(Context context, String str) {
        return !TextUtils.equals(PreferenceManager.getDefaultSharedPreferences(context).getString("config_app_version_" + str, ""), AppSetting.f99551k);
    }

    public static void o3(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppConstants.Preferences.TROOP_GIFT_URL_CONFIG, 0);
        sharedPreferences.edit().putString(str, str2);
        sharedPreferences.edit().commit();
    }

    public static void o4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_show", i3);
        edit.commit();
    }

    public static void o5(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("zhitu_config_page_len_" + str, i3);
        edit.apply();
    }

    public static int p(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("app_guide_tips_config_version_" + str, 0);
    }

    public static boolean p0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("docs_export_file_is_first_" + str, true);
    }

    public static boolean p1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("rich_text_chat_config_settting_switch_" + str, true);
    }

    public static boolean p2(String str) {
        boolean decodeBool = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeBool("key_use_online_preview_" + str, true);
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "isOnlinePreviewSupport isSupport : " + decodeBool);
        }
        return decodeBool;
    }

    public static void p3(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.TROOP_RANK_MAP_CONFIG_VERSION, i3);
        edit.commit();
    }

    public static void p4(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("medal_config_" + str, i3);
        edit.commit();
    }

    public static void p5(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("zhitu_safegate_request_interval_" + str, i3);
        edit.apply();
    }

    public static int q(Context context) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static long q0(String str) {
        return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getLong("last_close_noti_guid_banner_ts_" + str, -1L);
    }

    public static int q1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.SV_DYNAMIC_ADJUSTMENT, 0);
    }

    public static boolean q2(Context context, String str) {
        String str2;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (QQAppInterface.class.isInstance(runtime)) {
            str2 = ((QQAppInterface) runtime).getCurrentUin();
        } else {
            str2 = "";
        }
        return defaultSharedPreferences.getBoolean(str + "_" + AppConstants.Preferences.QIM_VIDEO_COMBOL_LOCK_INFO + "_" + str2, true);
    }

    public static void q3(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("SharedPreUtils", 2, "setUpgradeAppid: invoked. ", " id: ", Integer.valueOf(i3), " uin: ", str);
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("upgrade_appid_" + str, i3);
        edit.apply();
    }

    public static void q4(Context context, String str, int i3, int i16) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(String.format(Locale.getDefault(), "%s_%s_%s", str, AppConstants.Preferences.MEDAL_STRONG_REMINDER_CONFIG, Integer.valueOf(i3)), i16).apply();
    }

    public static void q5(Context context, String str, long j3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("zhitu_safegate_request_time_" + str, j3);
        edit.apply();
    }

    public static int r(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.AV_WEAK_NET_VIDEO_CONFIG_VERSION, 0);
    }

    public static long r0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str + "_req_troop_effect_config", 0L);
    }

    public static int r1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.SCRIBBLE_CONFIG_VERSION, 0);
    }

    public static boolean r2() {
        return R0().getBoolean(AppConstants.Preferences.KEY_SUPPORT_AI_DENOIDE, false);
    }

    public static void r3(Context context, String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str2)) {
            QLog.i("SharedPreUtils", 1, "setVerifiedPhoneShowRedDot phone is empty");
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(AppConstants.Preferences.LOGIN_UNVERIFIED_PHONE_SHOW_RED_DOT + str + str2, z16);
        edit.apply();
    }

    public static void r4(Context context, String str, String str2, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + str2 + "_" + AppConstants.Preferences.MSG_BOX_DELETE_MSG_TAB_FLAG, i3);
        edit.commit();
    }

    public static void r5(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("zhitu_safegate_switch_" + str, z16);
        edit.apply();
    }

    public static int s(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.BIRTHDAY_SPLASH_VERSION_CODE, 0);
    }

    public static int s0(int i3, String str) {
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getInt("lastSeq" + i3 + str, 0);
    }

    public static String s1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.SCRIBBLE_GIF_CONFIG, null);
    }

    public static boolean s2(String str) {
        boolean z16 = V0(BaseApplication.getContext(), str).getBoolean(AppConstants.Preferences.QAV_SUPPORT_AUDIO_BACKGROUND_FLOAT_WINDOW, false);
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "isSupportAudioBackgroundFloatWindow isSupport : " + z16);
        }
        return z16;
    }

    public static void s3(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "setZplanAvatarEasterEggTipsTimes: " + i3);
        }
        QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QAV).encodeInt("key_zplan_avatar_easter_egg_tips_time_" + str, i3);
    }

    public static void s4(Context context, String str, JSONObject jSONObject) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str + "_" + AppConstants.Preferences.NEARBY_CONFIG_INFO, jSONObject.toString());
        edit.commit();
    }

    public static void s5(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("zhitu_config_save_share_switch_" + str, z16);
        edit.apply();
    }

    public static int t(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.BLESS_SPECIAL_PENDANT_CONFIG_VERSION, 0);
    }

    public static List<String> t0(Context context, String str) {
        List<String> list = f307691a;
        if (list != null) {
            return list;
        }
        f307691a = new ArrayList();
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str + "_" + AppConstants.Preferences.LOCAL_SET_TOP_TROOP_UPLOADED_IGNORE, null);
        if (TextUtils.isEmpty(string)) {
            return f307691a;
        }
        String[] split = string.split("_");
        if (split == null && split.length == 0) {
            return f307691a;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2)) {
                f307691a.add(str2);
            }
        }
        return f307691a;
    }

    public static String t1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.SCRIBBLE_GIF_VERSION, "");
    }

    public static boolean t2(String str) {
        boolean z16 = V0(BaseApplication.getContext(), str).getBoolean(AppConstants.Preferences.QAV_SUPPORT_VIDEO_BACKGROUND_FLOAT_WINDOW, true);
        if (QLog.isColorLevel()) {
            QLog.i("SharedPreUtils", 2, "isSupportVideoBackgroundFloatWindow isSupport : " + z16);
        }
        return z16;
    }

    public static void t3(Context context, String str, int i3) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("troop_pobing_config_version_" + str, i3);
    }

    public static void t4(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("hot_friend_new_boat_config_" + str, i3);
        edit.commit();
    }

    public static void t5(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("zhitu_config_switch_" + str, z16);
        edit.apply();
    }

    public static int u(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("buluo_red_dot_config_version_" + str, 0);
    }

    public static int u0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_" + AppConstants.Preferences.LONG_TEXT_MSG_CONFIG_VERSION, 0);
    }

    public static String u1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.SCRIBBLE_PAINT_CONFIG, null);
    }

    public static void u2(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("config_app_version_" + str, AppSetting.f99551k);
        edit.commit();
    }

    public static void u3(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + AppConstants.Preferences.AIO_CONFIG, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static void u4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.PASSWD_RED_BAG_SETTING_VERSION, i3);
        edit.commit();
    }

    public static long v(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str + "_" + AppConstants.Preferences.GRAYTIPS_CALL_LAST_ALERTTIME, 0L);
    }

    public static long v0() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).getLong("monitorStartTime", 0L);
    }

    public static String v1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.SCRIBBLE_PAINT_VERSION, "");
    }

    public static void v2(Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove(AppConstants.Preferences.GREEN_VIDEO_LIST);
        edit.commit();
    }

    public static void v3(Context context, String str, int i3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(str + "_" + AppConstants.Preferences.AIO_CONFIG, 0).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.AIO_CONFIG_VERSION_CODE, i3);
        edit.commit();
    }

    public static void v4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.PHOTO_PLUS_STICKER_VERSION + str, i3);
        edit.commit();
    }

    public static int w(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.CAMERA_COMPATIBLE_LIST_VERSION, 0);
    }

    public static long w0() {
        return BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).getLong("peakThreadCount", 0L);
    }

    public static boolean w1(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("scribble_switch_conf_" + str, false);
    }

    public static void w2(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove(str2 + "_" + str);
        edit.commit();
    }

    public static void w3(Context context, int i3, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("general_android_configs_version_code_" + str, i3);
        edit.commit();
    }

    public static void w4(Context context, String str, int i3, boolean z16, int i16, int i17, int i18, int i19) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_CONFIG_VERSION, i3);
        if (z16) {
            edit.putInt(str + "_" + AppConstants.Preferences.POKE_BAR_SWITCH, i16);
            edit.putInt(str + "_" + AppConstants.Preferences.POKE_PAD_SWITCH, i17);
            edit.putInt(str + "_" + AppConstants.Preferences.POKE_SEND_COUNTS_LIMITED, i18);
            edit.putInt(str + "_" + AppConstants.Preferences.POKE_SEND_TIME_LIMITED, i19);
        }
        edit.commit();
    }

    public static String x(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("classic_head_activity_config_" + str, "");
    }

    public static int x0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str + "_show", 0);
    }

    public static int x1(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(AppConstants.Preferences.SHORTVIDEO_PROGRESSIVE_BLACKLIST_VERSION, 0);
    }

    public static void x2(int i3, int i16, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putInt("lastSeq" + i3 + str, i16);
        edit.commit();
    }

    public static void x3(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("app_guide_tips_config_version_" + str, i3);
        edit.commit();
    }

    public static void x4(Context context, String str, int i3, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str + "_" + AppConstants.Preferences.POKE_CONFIG_VERSION, i3);
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(str + "_" + AppConstants.Preferences.POKE_PANEL_PLACE_CONFIG, str2);
        }
        edit.commit();
    }

    public static int y(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("classic_head_activity_config_version_" + str, 0);
    }

    public static int y0(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("medal_config_" + str, 0);
    }

    public static String y1(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(AppConstants.Preferences.SHOW_HOT_FRIEND_DAYS_SETTING, "3|30|3|30|3|30|3|30|5|7|30|7|30");
        if (QLog.isColorLevel()) {
            QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "result=" + string);
        }
        return string;
    }

    public static void y2(String str, Object obj) {
        p.g(BaseApplication.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), true, str, obj);
    }

    public static void y3(Context context, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.AV_WEAK_NET_VIDEO_CONFIG_VERSION, i3);
        edit.commit();
    }

    public static void y4(Context context, String str, int i3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(AppConstants.Preferences.PRE_DOWNLOAD_DIALOG_VERSION + str, i3);
        edit.commit();
    }

    public static long z(String str) {
        return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(str + "_" + AppConstants.Preferences.CLEAN_DISKCACHE_TIME, 0L);
    }

    public static int z0(Context context, String str, int i3) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(String.format(Locale.getDefault(), "%s_%s_%s", str, AppConstants.Preferences.MEDAL_STRONG_REMINDER_CONFIG, Integer.valueOf(i3)), 0);
    }

    public static boolean z1(Context context, String str, int i3) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean z16 = false;
        if (i3 == 0) {
            z16 = defaultSharedPreferences.getBoolean(str + "_" + AppConstants.Preferences.SHOW_HOT_FRIEND_DAYS_CONTACT, false);
        } else if (i3 == 1) {
            z16 = defaultSharedPreferences.getBoolean(str + "_" + AppConstants.Preferences.SHOW_HOT_FRIEND_DAYS_CHAT, false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "type= " + i3 + ",result=" + z16);
        }
        return z16;
    }

    public static void z2() {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 0).edit();
        edit.putBoolean("av_pendant_flag", true);
        edit.commit();
    }

    public static void z3(Context context, int i3, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str2 + "_" + AppConstants.Preferences.BIRTHDAY_SPLASH_VERSION_CODE, i3);
        edit.putString(AppConstants.Preferences.BIRTHDAY_SPLASH_MD5VALUE, str);
        edit.commit();
    }

    public static void z4(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(AppConstants.Preferences.PUBLIC_ACCOUNT_CONFIG_DATA, str);
        edit.commit();
    }
}
