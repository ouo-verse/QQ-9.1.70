package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.vas.toggle.ToggleTimeout;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u6240\u6709\u7684\u5f00\u5173\u914d\u7f6e\u901a\u8fc7VasToggleFactory\u8fdb\u884c\u521b\u5efa")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0010\u0010\u0018\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0002038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00107\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00108\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0011\u0010;\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0011\u0010=\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0010\u0010?\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/vas/VasNtToggle;", "", "()V", "BUG_103285925", "Lcom/tencent/mobileqq/vas/ToggleProxy;", "getBUG_103285925", "()Lcom/tencent/mobileqq/vas/ToggleProxy;", "BUG_106298615", "getBUG_106298615", "BUG_FILE_CHECK_FOR_ANDROID_N", "getBUG_FILE_CHECK_FOR_ANDROID_N", "BUG_UNZIP_ERROR", "getBUG_UNZIP_ERROR", "FEATURE_AVIF", "FEATURE_FZ_SO_8958", "getFEATURE_FZ_SO_8958", "FEATURE_HY_SO_8953", "getFEATURE_HY_SO_8953", "FEATURE_PENDANT_SUPPORT_AVIF", "getFEATURE_PENDANT_SUPPORT_AVIF", "KING_CARD_JAR_NAME", "getKING_CARD_JAR_NAME", "TROOP_ICE_BREAK_ENABLE", "getTROOP_ICE_BREAK_ENABLE", "UPDATE_BUSINESS_EXIST", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "UPDATE_SYSTEM_CHECK_MD5", "UPDATE_SYSTEM_CUSTOM_CLEAN", "UPDATE_SYSTEM_FILE_CHECK", "UPDATE_SYSTEM_FILE_MD5_CHECK", "UPDATE_SYSTEM_FILE_MOVE", "VAS_AIO_FONT_BUG_116794049", "VAS_AIO_TEXT_COLOR_MANAGER", "VAS_BUBBLE_REPORT_SWITCH", "VAS_BUG_112173069", "VAS_BUG_112810099", "VAS_BUG_118645149", "VAS_BUG_119216554", "VAS_COMMON_EGGS_CONTROLLER_CONFIG", "VAS_DOWNLOADING_TIME_SWITCH", "VAS_DOWNLOAD_REMOVE_SAME_SWITCH_NEW", "VAS_DYNAMIC_REPORT", "VAS_FILE_CHECK_NECESSARY_LIST", "VAS_FONT_ANR_REPORT_SWITCH", "VAS_FONT_CRASH_SWITCH_DEFAULT", "VAS_FONT_DRAW_REPORT_SWITCH", "VAS_FONT_SO_NEW_SWITCH", "VAS_FREQUENCY_DATA_CHANGE_SWITCH", "VAS_KING_FEATURE_SWITCH", "VAS_LOG_REPORT_SWITCH_INTERCEPT", "VAS_LUCKY_BAG_CONFIG_SWITCH", "Lcom/tencent/mobileqq/vas/IConfigProxy;", "VAS_NEED_DELETE_UPDATE_TASK_10_COUNT_FAIL", "VAS_NEW_SVIP_ICE_BREAK_CONFIG", "VAS_NICK_COVER_ANIMATION", "VAS_PROTECT_HOLIDAYS_FESTIVALS_FREQUENCY_CONTROL", "VAS_REPORT_EVENT_NAME_BLACK_LIST", "VAS_SDCARD_DIR_MOVE", "getVAS_SDCARD_DIR_MOVE", "VAS_SPLENDID_AVATAR_CONFIG", "getVAS_SPLENDID_AVATAR_CONFIG", "VAS_TROOP_GIFT_ARK_LABLE_SHOW", "getVAS_TROOP_GIFT_ARK_LABLE_SHOW", "VAS_UPDATE_BUSINESS_INFO_OPTIMIZE", "VAS_UPDATE_BUSINESS_MIGRATION", "VAS_UPDATE_CAN_CALLBACK_FILTER_TASK", "VAS_UPDATE_TOOL_START_DOWNLOAD_THREAD", "VAS_UPDATE_USE_MMKV_REPLACE_FILE", "VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG", "VAS_VIP_PERCEPTION_CONFIG", "VIP_KING_ID_CONFIG", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasNtToggle {

    @NotNull
    public static final VasNtToggle INSTANCE = new VasNtToggle();

    @NotNull
    private static final ToggleProxy VAS_SPLENDID_AVATAR_CONFIG = new ToggleProxy("vas_splendid_avatar_config");

    @NotNull
    private static final ToggleProxy VAS_TROOP_GIFT_ARK_LABLE_SHOW = new ToggleProxy("vas_groupgift_arklabel_showtype");

    @NotNull
    private static final ToggleProxy BUG_UNZIP_ERROR = new ToggleProxy("vas_bug_unzip_error");

    @NotNull
    private static final ToggleProxy VAS_SDCARD_DIR_MOVE = new ToggleProxy("vas_sdcard_dir_move");

    @NotNull
    private static final ToggleProxy BUG_103285925 = new ToggleProxy("vas_bug_103285925");

    @NotNull
    private static final ToggleProxy BUG_106298615 = new ToggleProxy("vas_bug_106298615");

    @NotNull
    private static final ToggleProxy BUG_FILE_CHECK_FOR_ANDROID_N = new ToggleProxy("vas_file_check_for_android_n");

    @JvmField
    @NotNull
    public static final ToggleProxy FEATURE_AVIF = new ToggleProxy("vas_feature_avif");

    @NotNull
    private static final ToggleProxy TROOP_ICE_BREAK_ENABLE = new ToggleProxy("ice_break_config");

    @NotNull
    private static final ToggleProxy FEATURE_HY_SO_8953 = new ToggleProxy("vas_feature_hy_so_8953");

    @NotNull
    private static final ToggleProxy FEATURE_FZ_SO_8958 = new ToggleProxy("vas_feature_fz_so_8958");

    @NotNull
    private static final ToggleProxy KING_CARD_JAR_NAME = new ToggleProxy("vas_king_card_jar_name");

    @NotNull
    private static final ToggleProxy FEATURE_PENDANT_SUPPORT_AVIF = new ToggleProxy("vas_feature_pendant_support_avif");

    @JvmField
    @NotNull
    public static final ToggleProxy VAS_AIO_TEXT_COLOR_MANAGER = new ToggleProxy("vas_aio_text_color_manager");

    @ToggleTimeout(owner = "kenaiyu", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy UPDATE_SYSTEM_FILE_MOVE = new UnitedProxy("vas_update_system_file_move_2");

    @ToggleTimeout(owner = "kenaiyu", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy UPDATE_SYSTEM_FILE_CHECK = new UnitedProxy("vas_update_system_file_check");

    @ToggleTimeout(owner = "kenaiyu", time = "2023-07-07")
    @JvmField
    @NotNull
    public static final UnitedProxy UPDATE_SYSTEM_CUSTOM_CLEAN = new UnitedProxy("vas_update_system_custom_clean");

    @ToggleTimeout(owner = "kenaiyu", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy UPDATE_SYSTEM_FILE_MD5_CHECK = new UnitedProxy("vas_update_system_file_md5_check");

    @ToggleTimeout(owner = "kenaiyu", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy UPDATE_SYSTEM_CHECK_MD5 = new UnitedProxy("vas_update_system_check_md5");

    @ToggleTimeout(owner = "kenaiyu", time = "2023-07-28")
    @JvmField
    @NotNull
    public static final UnitedProxy UPDATE_BUSINESS_EXIST = new UnitedProxy("vas_update_business_exist");

    @ToggleTimeout(owner = "anzaihuang", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VIP_KING_ID_CONFIG = new UnitedProxy("vas_vip_king_id_config");

    @ToggleTimeout(owner = "anzaihuang", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_KING_FEATURE_SWITCH = new UnitedProxy("vas_king_feature_switch");

    @ToggleTimeout(owner = "anzaihuang", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_FREQUENCY_DATA_CHANGE_SWITCH = new UnitedProxy("vas_frequency_data_change_switch");

    @ToggleTimeout(owner = "anzaihuang", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_DOWNLOAD_REMOVE_SAME_SWITCH_NEW = new UnitedProxy("vas_download_remove_same_switch_new");

    @ToggleTimeout(owner = "anzaihuang", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_DOWNLOADING_TIME_SWITCH = new UnitedProxy("vas_downloading_time_switch");

    @ToggleTimeout(owner = "arnopeng", time = "2023-07-18")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_BUG_112810099 = new UnitedProxy("vas_bug_112810099_new");

    @ToggleTimeout(owner = "arnopeng", time = "2023-08-15")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_FONT_DRAW_REPORT_SWITCH = new UnitedProxy("vas_font_draw_report_switch");

    @ToggleTimeout(owner = "arnopeng", time = "2023-08-15")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_FONT_ANR_REPORT_SWITCH = new UnitedProxy("vas_font_anr_report_switch");

    @ToggleTimeout(owner = "arnopeng", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_BUG_112173069 = new UnitedProxy("vas_bug_112173069");

    @ToggleTimeout(owner = "arnopeng", time = "2023-07-25")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_DYNAMIC_REPORT = new UnitedProxy("vas_dynamic_report");

    @ToggleTimeout(owner = "shouyouye", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_VIP_PERCEPTION_CONFIG = new UnitedProxy("vas_graytips_config");

    @ToggleTimeout(owner = "shouyouye", time = "2023-07-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_UPDATE_BUSINESS_MIGRATION = new UnitedProxy("vas_update_business_migration_2");

    @ToggleTimeout(owner = "shouyouye", time = "2023-07-31")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_UPDATE_BUSINESS_INFO_OPTIMIZE = new UnitedProxy("vas_update_business_info_optimize");

    @ToggleTimeout(owner = "arnopeng", time = "2023-08-10")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_BUBBLE_REPORT_SWITCH = new UnitedProxy("vas_bubble_report_switch");

    @ToggleTimeout(owner = "arnopeng", time = "2023-08-18")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_FONT_SO_NEW_SWITCH = new UnitedProxy("vas_font_so_new_switch");

    @ToggleTimeout(owner = "shouyouye", time = "2023-08-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_UPDATE_CAN_CALLBACK_FILTER_TASK = new UnitedProxy("vas_update_can_callback_filter_task");

    @ToggleTimeout(owner = "shouyouye", time = "2023-08-02")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_UPDATE_USE_MMKV_REPLACE_FILE = new UnitedProxy("vas_update_use_mmkv_replace_file");

    @ToggleTimeout(owner = "shouyouye", time = "2023-08-04")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_UPDATE_TOOL_START_DOWNLOAD_THREAD = new UnitedProxy("vas_update_tool_start_download_thread");

    @ToggleTimeout(owner = "shouyouye", time = "2023-08-08")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_REPORT_EVENT_NAME_BLACK_LIST = new UnitedProxy("vas_report_event_name_black_list");

    @ToggleTimeout(owner = "shouyouye", time = "2023-08-08")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_LOG_REPORT_SWITCH_INTERCEPT = new UnitedProxy("vas_log_report_switch_intercept");

    @ToggleTimeout(owner = "shouyouye", time = "2024-02-08")
    @JvmField
    @NotNull
    public static final IConfigProxy VAS_LUCKY_BAG_CONFIG_SWITCH = new UnitedProxy("vas_lucky_bag_config_switch");

    @ToggleTimeout(owner = "anzaihuang", time = "2023-10-08")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_NEW_SVIP_ICE_BREAK_CONFIG = new UnitedProxy("vas_new_svip_ice_break_config");

    @ToggleTimeout(owner = "anzaihuang", time = "2023-11-09")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_AIO_FONT_BUG_116794049 = new UnitedProxy("vas_font_bug_116794049");

    @ToggleTimeout(owner = "shouyouye", time = "2023-11-01")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_UPLOAD_FILE_VIP_PERCEPTION_CONFIG = new UnitedProxy("vas_upload_file_vip_perception_config");

    @ToggleTimeout(owner = "anzaihuang", time = "2023-11-23")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_FONT_CRASH_SWITCH_DEFAULT = new UnitedProxy("vas_font_crash_switch_default");

    @ToggleTimeout(owner = "shouyouye", time = "2023-11-15")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_FILE_CHECK_NECESSARY_LIST = new UnitedProxy("vas_file_check_necessary_list");

    @ToggleTimeout(owner = "linkliang", time = "2023-12-14")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_NICK_COVER_ANIMATION = new UnitedProxy("vas_nick_name_cover_animation");

    @ToggleTimeout(owner = "shouyouye", time = "2023-12-25")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_BUG_118645149 = new UnitedProxy("vas_bug_118645149");

    @ToggleTimeout(owner = "shouyouye", time = "2024-01-03")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_NEED_DELETE_UPDATE_TASK_10_COUNT_FAIL = new UnitedProxy("vas_need_delete_update_task_10_count_fail");

    @ToggleTimeout(owner = "shouyouye", time = "2024-01-09")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_BUG_119216554 = new UnitedProxy("vas_bug_119216554");

    @ToggleTimeout(owner = "shouyouye", time = "2024-01-10")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_PROTECT_HOLIDAYS_FESTIVALS_FREQUENCY_CONTROL = new UnitedProxy("vas_protect_holidays_festivals_frequency_control");

    @ToggleTimeout(owner = "anzaihuang", time = "2024-05-27")
    @JvmField
    @NotNull
    public static final UnitedProxy VAS_COMMON_EGGS_CONTROLLER_CONFIG = new UnitedProxy("vas_common_eggs_controller_config");

    VasNtToggle() {
    }

    @NotNull
    public final ToggleProxy getBUG_103285925() {
        return BUG_103285925;
    }

    @NotNull
    public final ToggleProxy getBUG_106298615() {
        return BUG_106298615;
    }

    @NotNull
    public final ToggleProxy getBUG_FILE_CHECK_FOR_ANDROID_N() {
        return BUG_FILE_CHECK_FOR_ANDROID_N;
    }

    @NotNull
    public final ToggleProxy getBUG_UNZIP_ERROR() {
        return BUG_UNZIP_ERROR;
    }

    @NotNull
    public final ToggleProxy getFEATURE_FZ_SO_8958() {
        return FEATURE_FZ_SO_8958;
    }

    @NotNull
    public final ToggleProxy getFEATURE_HY_SO_8953() {
        return FEATURE_HY_SO_8953;
    }

    @NotNull
    public final ToggleProxy getFEATURE_PENDANT_SUPPORT_AVIF() {
        return FEATURE_PENDANT_SUPPORT_AVIF;
    }

    @NotNull
    public final ToggleProxy getKING_CARD_JAR_NAME() {
        return KING_CARD_JAR_NAME;
    }

    @NotNull
    public final ToggleProxy getTROOP_ICE_BREAK_ENABLE() {
        return TROOP_ICE_BREAK_ENABLE;
    }

    @NotNull
    public final ToggleProxy getVAS_SDCARD_DIR_MOVE() {
        return VAS_SDCARD_DIR_MOVE;
    }

    @NotNull
    public final ToggleProxy getVAS_SPLENDID_AVATAR_CONFIG() {
        return VAS_SPLENDID_AVATAR_CONFIG;
    }

    @NotNull
    public final ToggleProxy getVAS_TROOP_GIFT_ARK_LABLE_SHOW() {
        return VAS_TROOP_GIFT_ARK_LABLE_SHOW;
    }
}
