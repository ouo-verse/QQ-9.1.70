package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasToggle {
    public static final String APNG_SO = "vas_apng_use_cloud_so";
    public static final String FD_BUG_FIX = "vas_fd_bug_fix";
    public static final String FZ_FONT_SO = "vas_fz_font_use_so_manager";
    public static final String GLDRAWABLE = "vas_gldrawable";
    public static final String LOTTIE_IGNORE_SYSTEM_SETTINGS = "vas_lottie_ignore_sys_settings";
    public static final String LOTTIE_SOFTWARE_RENDER = "vas_lottie_software_render";
    public static final String PAGVIEW_ASYNC = "vas_pagview_async";
    public static final String PER_DIALOG_HANDLE = "vas_per_dialog_handle";
    public static final String TAG = "VasToggle";
    public static final String UEC_REPORT = "vas_uec_report";
    public static final String VAS_FUN_CALL_VIDEO_MODE = "vas_fun_call_video_mode";
    public static final String VAS_GIFT_PACKAGE_ENABLE = "vas_gift_package_enable";
    public static final String VAS_GUIDE_TIME_INTERVAL = "vas_guide_time_interval";
    public static final String VAS_QQLIVE_HIGH_SSO_REPORT = "qqlive_high_sso_report";
    public static final String VAS_QQLIVE_SAMPLING_REPORT_ENABLE = "qq_live_sampling_report_enable";
    public static final String XA_DYNAMIC_ENABLE = "vas_xa_dynamic_enable";
    public static final ToggleProxy APNG_SO_LOCAL = new ToggleProxy("vas_apng_local");
    public static final ToggleProxy NAMEPLATE_URL = new ToggleProxy("vas_nameplate_url");
    public static final ToggleProxy VAS_QQVIP_SUBSCRIPTION_CONFIG = new ToggleProxy("vas_qqvip_subscription_config");
    public static final ToggleProxy AVATAR_STORE_AD_URL = new ToggleProxy("vas_avatar_store_ad_url");
    public static final ToggleProxy VAS_QZONE_NAMEPLATE = new ToggleProxy("vas_qzone_active_head_nameplate");
    public static final ToggleProxy VAS_AVATAR_CONFIG = new ToggleProxy("vas_avatar_config");
    public static final ToggleProxy VIP_PERSONAL_CARD_CONFIG = new ToggleProxy("vip_personal_card_config");
    public static final ToggleProxy FEATURE_879381431 = new ToggleProxy("vas_game_nameplate_title");
    public static final ToggleProxy FEATURE_SPECIALCARE_CONFIG = new ToggleProxy("vas_specialcare_config");
    public static final ToggleProxy FEATURE_PROFILE_CARD_LABEL_CONFIG = new ToggleProxy("vas_profile_card_label_config");
    public static final ToggleProxy FEATURE_PROFILE_CARD_TEMPLATE_CONFIG = new ToggleProxy("vas_profile_card_template_config");
    public static final ToggleProxy VAS_AIO_TEXT_COLOR_MANAGER = new ToggleProxy("vas_aio_text_color_manager");
    public static final ToggleProxy VAS_AVATAR_SHEET = new ToggleProxy("vas_avatar_sheet");
    public static final ToggleProxy VAS_SPLENDID_AVATAR_CONFIG = new ToggleProxy("vas_splendid_avatar_config");
    public static final ToggleProxy APP_ICON_BLACK_LIST = new ToggleProxy("vas_app_icon_black_list");
    public static final ToggleProxy RECHARGE_MAX_PAY_NUM = new ToggleProxy("vas_recharge_max_pay_num");
    public static final ToggleProxy FEATURE_AVIF = new ToggleProxy("vas_feature_avif");
    public static final ToggleProxy THEME_ENGINE_CACHE_TASK = new ToggleProxy("vas_theme_engine_cache_task", false, true);
    public static final ToggleProxy THEME_FILE_CHECK_NEW_ENABLE = new ToggleProxy("vas_theme_file_check_new_switch");
    public static final ToggleProxy VAS_GUILD_GIFT_DOWNLOAD_CONFIG = new ToggleProxy("vas_gift_download_config");
    public static final ToggleProxy VAS_LIKE_AREA_ENTRY = new ToggleProxy("vas_like_area_entry");
    public static final ToggleProxy VAS_NOVEL_SPECIES = new ToggleProxy("vas_novel_species");
    public static final ToggleProxy VAS_NOVEL_SPECIES_NEW = new ToggleProxy("vas_novel_species_new");
    public static final ToggleProxy VAS_LOVE_FLASH_ENTRY_NEW = new ToggleProxy("vas_love_flash_entry_new");
    public static final ToggleProxy VAS_YELLOW_VIP_CONFIG = new ToggleProxy("vas_yellow_vip_config");
    public static final ToggleProxy VAS_QZONE_LV_10_COLOR_NAME = new ToggleProxy("vas_qzvip_lv10_config");
    public static final ToggleProxy VAS_FRESHELEMENT_EMOJI = new ToggleProxy("vas_freshelement_emoji");
    public static final ToggleProxy VAS_AIO_LEFT_RED_POINT_CONFIG = new ToggleProxy("vas_love_special_word_red_point");
    public static final ToggleProxy VIP_PENDANT = new ToggleProxy("vas_vipaddon_config");
    public static final ToggleProxy VIP_COLORFUL_NAME = new ToggleProxy("vas_colorfulnick_config");
    public static final ToggleProxy VAS_LIVE_GIFT_TIME_CONFIG = new ToggleProxy("vas_live_gift_time_config");
    public static final ToggleProxy VAS_GIFT_PRELOAD_SCENE_CONFIG = new ToggleProxy("vas_qqgift_preload_exclude_scene");
    public static final ToggleProxy VAS_QQLINE_GIFT_PRELOAD_CONFIG = new ToggleProxy("vas_qqgift_preload_qlive_config");
    public static final ToggleProxy VAS_PROFILE_CARD_SPRING2023 = new ToggleProxy("vas_vipaddon_config");
    public static final ToggleProxy VAS_PROFILE_CARD_SPRING_COMPAT = new ToggleProxy("vas_profile_card_spring_compat");
    public static final ToggleProxy VAS_PROFILE_CARD_CUSTOM_RETRY = new ToggleProxy("vas_profile_card_spring_retry");
    public static final ToggleProxy VAS_RECHARGE_AUTH_ENABLE = new ToggleProxy("vas_recharge_auth_module_config");
    public static final ToggleProxy VAS_SEND_GIFT_AUTH_ENABLE = new ToggleProxy("vas_send_gift_auth_module_config");
    public static final ToggleProxy THEME_VIEDO_PLAYER_ENABLE = new ToggleProxy("vas_theme_video_player_enable3", false, true);
    public static final ToggleProxy VAS_THEME_CHAT_BG_CLOSE_WEB = new ToggleProxy("vas_theme_chat_bg_close_web");
    public static final ToggleProxy FEATURE_THEME_REQUEST = new ToggleProxy("vas_feature_theme_request");
    public static final ToggleProxy FEATURE_DONWLOADER = new ToggleProxy("vas_feature_downloader");
    public static final ToggleProxy FEATURE_HTTPDNS = new ToggleProxy("vas_feature_httpdns");
    public static final ToggleProxy FEATURE_BATCH_UPDATE = new ToggleProxy("vas_feature_batch_update");
    public static final ToggleProxy FEATURE_PENDANT_SUPPORT_AVIF = new ToggleProxy("vas_feature_pendant_support_avif");
    public static final ToggleProxy FEATURE_TEST_PENDANT_ID = new ToggleProxy("vas_feature_test_pendant_id");
    public static final ToggleProxy FEATURE_HY_SO_8953 = new ToggleProxy("vas_feature_hy_so_8953");
    public static final ToggleProxy FEATURE_THEME_VIP_SPLASH = new ToggleProxy("vas_feature_vip_splash", false, true);
    public static final ToggleProxy FEATURE_THEME_VIP_ANIMATION = new ToggleProxy("vas_feature_theme_vip_animation", false, true);
    public static final ToggleProxy FEATURE_VAS_HIPPY_SKIP_AUTH = new ToggleProxy("vas_feature_hippy_domain_auth");
    public static final ToggleProxy FEATURE_VAS_HIPPY_JS_ARGS = new ToggleProxy("vas_feature_hippy_js_args");
    public static final ToggleProxy FEATURE_VAS_RENEWAL_PAGE = new ToggleProxy("vas_feature_renewal_page");
    public static final ToggleProxy NT_NEW_AVATAR_AIO = new ToggleProxy("vas_nt_new_avatar_aio");
    public static final ToggleProxy BUG_109812534 = new ToggleProxy("vas_bug_109812534");
    public static final ToggleProxy BUG_108742548 = new ToggleProxy("vas_bug_108742548");
    public static final ToggleProxy BUG_TASK_861918821 = new ToggleProxy("vas_task_861918821");
    public static final ToggleProxy BUG_104253873 = new ToggleProxy("vas_bug_104253873");
    public static final ToggleProxy BUG_103890873 = new ToggleProxy("vas_bug_103890873");
    public static final ToggleProxy BUG_103762681 = new ToggleProxy("vas_bug_103762681");
    public static final ToggleProxy BUG_103479615 = new ToggleProxy("vas_bug_103479615");
    public static final ToggleProxy BUG_102399939 = new ToggleProxy("vas_bug_102399939");
    public static final ToggleProxy BUG_102518313 = new ToggleProxy("vas_bug_102518313");
    public static final ToggleProxy BUG_31032000175 = new ToggleProxy("vas_bug_31032000175");
    public static final ToggleProxy BUG_82840110 = new ToggleProxy("vas_bug_82840110");
    public static final ToggleProxy BUG_YUNYING = new ToggleProxy("vas_bug_yunying");
    public static final ToggleProxy BUG_108446460 = new ToggleProxy("vas_bug_108446460");
    public static final ToggleProxy BUG_102297741 = new ToggleProxy("vas_bug_102297741");
    public static final ToggleProxy BUG_103247711 = new ToggleProxy("vas_bug_103247711");
    public static final ToggleProxy BUG_103313061 = new ToggleProxy("vas_bug_103313061");
    public static final ToggleProxy BUG_104286245 = new ToggleProxy("vas_bug_104286245");
    public static final ToggleProxy BUG_103975707 = new ToggleProxy("vas_bug_103975707");
    public static final ToggleProxy BUG_105410810 = new ToggleProxy("vas_bug_105410810");
    public static final ToggleProxy BUG_108919712 = new ToggleProxy("vas_bug_108919712");
    public static final ToggleProxy BUG_108571707 = new ToggleProxy("vas_bug_108571707");
    public static final ToggleProxy BUG_108571707_2 = new ToggleProxy("vas_bug_108571707_2");
    public static final ToggleProxy BUG_108571707_3 = new ToggleProxy("vas_bug_108571707_3");
    public static final ToggleProxy BUG_104274963 = new ToggleProxy("vas_bug_104274963");
    public static final ToggleProxy BUG_105413094 = new ToggleProxy("vas_bug_105413094");
    public static final ToggleProxy BUG_105841927 = new ToggleProxy("vas_bug_105841927");
    public static final ToggleProxy BUG_CLEAR_DNS_CACHE = new ToggleProxy("vas_clear_dns_cache");
    public static final ToggleProxy BUG_IP_TO_CACHE = new ToggleProxy("vas_httpdns_ip_to_cache");
    public static final ToggleProxy BUG_110439111 = new ToggleProxy("vas_bug_110439111");
    public static final ToggleProxy BUG_110903221 = new ToggleProxy("vas_bug_110903221");
    public static final ToggleProxy BUG_PROFILE_CARD_107225761 = new ToggleProxy("vas_bug_107225761");
    public static final ToggleProxy BUG_107543533 = new ToggleProxy("vas_bug_107543533");
    public static final ToggleProxy BUG_109805691 = new ToggleProxy("vas_bug_109805691", false, true);
    public static final ToggleProxy MINISDK_TIANJIGE = new ToggleProxy("qqlive_tianjige_sdk_init_and", true);
    public static final ToggleProxy QQLIVE_MULTI_CHAT_UPDATE_LOOP_CONFIG = new ToggleProxy("enable_update_multi_chat_loop");
    public static final ToggleProxy QQLIVE_ENTRANCE = new ToggleProxy("qqlive_main_entrance_switch", true);
    public static final ToggleProxy QQLIVE_ROOM_PRELOAD_CONFIG = new ToggleProxy("qqlive_room_preload_config", true);
    public static final ToggleProxy QQLIVE_PLAYER_NETWORK_STRATEGY = new ToggleProxy("qqlive_player_network_strategy", true);
    public static final ToggleProxy QQLIVE_PLAYER_DEFINITION_TIPS_STRATEGY = new ToggleProxy("qqlive_player_definition_tips_strategy", true);
    public static final ToggleProxy QQLIVE_ROOM_ANNOUNCE_CONFIG = new ToggleProxy("qqlive_room_announce_config", true);
    public static final ToggleProxy QQLIVE_SUPER_PLAYER_CONFIG = new ToggleProxy("qqlive_super_player_config");
    public static final ToggleProxy QQLIVE_START_LIVE_CONFIG = new ToggleProxy("android_qq_start_live_params_config");
    public static final ToggleProxy QQLIVE_ENABLE_QCIRCLE_RETRY_PLAYER = new ToggleProxy("enable_qcircle_qqlive_feed_retry_player", true);
    public static final ToggleProxy QZONE_FEED_SKIN_FORCE_REQ = new ToggleProxy("qzone_feed_skin_force_req", true);
    public static final ToggleProxy QQLIVE_SUPER_PLAYER_QUIC_CONFIG = new ToggleProxy("qqlive_super_player_quic_config");
    public static final ToggleProxy HIPPY_PRELOAD_PRIVILEGE = new ToggleProxy("hippy_preload_privilege");
    public static final ToggleProxy HIPPY_SSR_COMMON_JS = new ToggleProxy(MMKVCommonFileKeys.SSR_COMMON_JS_VERSION);
    public static final ToggleProxy MINI_GAME_CHANGE_SCENE = new ToggleProxy("minigame_recentscene_map");

    public static <T> T getBean(String str, Class<T> cls, @Nullable T t16) {
        Object obj = null;
        try {
            obj = new Gson().fromJson(getStringData(str, null), (Class<Object>) cls);
        } catch (Exception e16) {
            QLog.e("VasToggle", 1, "getBean toggleName=" + str + ",clazz=" + cls + ",e=" + e16);
        }
        if (obj != null) {
            return (T) obj;
        }
        return t16;
    }

    public static boolean getBooleanDataSet(String str, String str2, boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return z16;
        }
        Map<String, String> isEnabledWithDataSet = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isEnabledWithDataSet(str, "");
        if (isEnabledWithDataSet == null) {
            return z16;
        }
        if (isEnabledWithDataSet.containsKey(str2)) {
            return isEnabledWithDataSet.get(str2).equals("true");
        }
        return z16;
    }

    public static String getStringData(String str, String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return str2;
        }
        String string = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getString(str, str2);
        if (TextUtils.isEmpty(string)) {
            return str2;
        }
        return string;
    }

    public static String getStringDataSet(String str, String str2, String str3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return str3;
        }
        Map<String, String> isEnabledWithDataSet = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isEnabledWithDataSet(str, "");
        if (isEnabledWithDataSet == null) {
            return str3;
        }
        if (isEnabledWithDataSet.containsKey(str2)) {
            return isEnabledWithDataSet.get(str2);
        }
        return str3;
    }

    public static boolean isEnable(String str, boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return z16;
        }
        return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(str, z16);
    }
}
