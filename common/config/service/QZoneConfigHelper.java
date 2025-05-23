package common.config.service;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.GDTReportPlugin;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneConfigHelper {

    /* renamed from: a, reason: collision with root package name */
    public static int f390035a = 180000;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        void a(int i3);
    }

    public static boolean A() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_QQ_VIDEO_SYNC_FAKE_OPERATE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int A0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_MOMENT_PUBLISH_SUCCESS_REFRESH_DELAY, 600);
    }

    public static boolean B() {
        if (Build.VERSION.SDK_INT <= 25 || QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONE_FROM_QFS, QzoneConfig.SECONDARY_KEY_QZONE_QUI_PROFILE_ENABLE, 1) != 1) {
            return false;
        }
        return true;
    }

    public static String B0() {
        return QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_DRESS_UP_GROUP_URL, "https://h5.qzone.qq.com/show/record/{uin}/{type}?_wv=2");
    }

    public static boolean C() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_RECOVERY_LAST_FEED_INDEX, 1) == 1) {
            return true;
        }
        return false;
    }

    public static long C0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_NEED_BACK_FEED_INTERVAL, 86400000L);
    }

    public static boolean D() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_SET_AVATAR_CLIP_SIZE, true);
    }

    public static int D0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_PHOTOVIEW_SHOW_LOADING_DELAY, 200);
    }

    public static boolean E() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_INTIMATE_SPACE_FRAME_ENTRANCE_OPEN, 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static String E0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_USER_HOME_SEARCH_SCHEME, QzoneConfig.DefaultValue.DEFAULT_USER_HOME_SEARCH_SCHEME);
    }

    public static boolean F() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_SHOW_MOMENT_BANNER, 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static int F0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_USER_SCROLL_THRESHOLD, 2);
    }

    public static boolean G() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_KEY_ALLOW_SCROLL_TO_RECOMMEND_WHEN_SINGLE, true);
    }

    public static String G0() {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_HOMEPAGE_BAR, QzoneConfig.SECONDARY_USERHOME_BAR_SCHEMA, "https://h5.qzone.qq.com/giftv2/vuemall?_wv=131075&_fv=0&_wwv=128&uin={UIN}");
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "getUserhomeBarSchema:" + config);
        }
        return config;
    }

    public static int H() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_ACC_REPORT_COUNT, 50);
    }

    public static int H0() {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_HOMEPAGE_BAR, QzoneConfig.SECONDARY_USERHOME_BAR_MUSIC_BAR_SHOW, 0);
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "getUserhomeMusicBarShow:" + config);
        }
        return config;
    }

    public static int I() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_ACC_REPORT_INTERVAL, 600) * 1000;
    }

    public static boolean I0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_MOOD_SCHEDULE_DELETE, 0) != 0) {
            return false;
        }
        return true;
    }

    public static int J() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_ACC_REPORT_SAMPLES, 10);
    }

    public static boolean J0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_FEEDX_CRASH_PROTECT, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int K() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_ACTIVITY_SWITCH_ACC_REPORT_SAMPLES, 10);
    }

    public static boolean K0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_NEW_ROUTER, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int L() {
        try {
            return Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ATUSER_INTERACTIVE_MAX, 10)).intValue();
        } catch (NumberFormatException unused) {
            return 10;
        }
    }

    public static boolean L0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_FEEDX_LAYER_OPEN_HOST_RECOMMEND_ALBUM_PAGE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int M() {
        try {
            return Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ATUSER_PUBLISH_UGC_MAX, 30)).intValue();
        } catch (NumberFormatException unused) {
            return 30;
        }
    }

    public static boolean M0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHARE_WHITE_LIST, QzoneConfig.DefaultValue.DEFAULT_SHARE_WHITE_LIST);
        if (!TextUtils.isEmpty(config)) {
            for (String str2 : config.split(",")) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int N() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.AVATAR_TIMEOUT, 1500);
    }

    public static boolean N0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_LOAD_FRIEND_LIST_FROMQQ_NEED_DECODE, 0) != 1) {
            return false;
        }
        return true;
    }

    public static String[] O() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, "UploadQuality", QzoneConfig.DefaultValue.QZONECOVER_UPLOADQUALITY).split(",");
    }

    public static boolean O0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_REMOVE_ALBUM_MASK_IN_NIGHT, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String[] P() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_QZONECOVER_UPLOADRESOLUTION, QzoneConfig.DefaultValue.QZONECOVER_UPLOADRESOLUTION).replace("*", ",").split(",");
    }

    public static boolean P0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_SHOULD_SCROLL_TOP_WHEN_REFRESH_FINISH, 0) != 1) {
            return false;
        }
        return true;
    }

    public static String Q() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_EVENT_TAG_MAIN_KEY, QzoneConfig.QZONE_EVENT_TAG_DEFAULT_PIC_URL, QzoneConfig.DefaultValue.QZONE_EVENT_TAG_PIC_URL_DEFAULT);
    }

    public static boolean Q0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.TEXT_CELL_LAYOUT_CAN_TRANSMIT_TOUCH_TARGET, 1) != 0) {
            return true;
        }
        return false;
    }

    public static int R() {
        try {
            return Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUSHBANNER_ACTIVEMAXCOUN, 5)).intValue();
        } catch (NumberFormatException unused) {
            return 5;
        }
    }

    public static boolean R0() {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.USE_NEW_COMMAND, 1);
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "use_new_command:" + config);
        }
        if (config != 0) {
            return true;
        }
        return false;
    }

    public static int S() {
        try {
            return Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUSHBANNER_DURATION, 7000)).intValue();
        } catch (NumberFormatException unused) {
            return 10000;
        }
    }

    public static boolean S0() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_USE_NEW_PICTURE_RULE_FOR_NEW_FEED, 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static String T() {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FEED_LOVE_DIAMOND, QzoneConfig.DEFAULT_FEED_LOVE_DIAMOND_URL);
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "getFeedLoverIconUrl:" + config);
        }
        return config;
    }

    public static String U() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.GDT_CGI_REPORT_HOST, GDTReportPlugin.GDT_CLICK_CGI_HOST);
    }

    public static String V() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_DISCONNECT_RELATION_JUMP_URL, QzoneConfig.DEFAULT_INTIMATE_SAPCE_DISBAND_PAGE);
    }

    public static String W() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_SPACE_NAME, QzoneConfig.DEFAULT_VALUE_INTIMATE_SPACE_NAME);
    }

    public static boolean X() {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PASSIVEFEED_ALERT_BUBBLE, 1);
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "getIsBubbleStyle:" + config);
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static int Y() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONESETTINGS_MAXCOMMENT_BUBBLE_TEXTCOUNT, 40);
    }

    public static int Z() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.MAX_REPORT_TASK_PENDING_DAY, 3);
    }

    private static String a(Float f16, String str) {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_HALF_SCREEN_WEB_FILTER_DEVICE, "");
        if (TextUtils.isEmpty(config)) {
            return "mqqapi://openhalfscreenweb/?height=" + f16.toString() + "&url=" + URLEncoder.encode(str);
        }
        return "mqqapi://openhalfscreenweb/?height=" + f16.toString() + "&url=" + URLEncoder.encode(str) + "&filterDevice=" + config;
    }

    public static int a0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONESETTINGS_MAXUGCTEXTCOUNT, 2000);
    }

    public static boolean b() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.CAN_FINISH_ACTIVITY_WHEN_REBOOT, 1) != 0) {
            return true;
        }
        return false;
    }

    public static int b0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONESETTINGS_MAXUGCTEXT_VISIBLELINECOUNT, 7);
    }

    public static boolean c() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_SCROLL_IDLE_END_PAUSE_VIDEO, 1) != 0) {
            return true;
        }
        return false;
    }

    public static String c0() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PASSIVEFEED_TAB_NAME, QzoneConfig.DefaultValue.DEFAULT_PASSIVE_FEED_TAB_NAME);
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "getPassiveTabName:" + config);
        }
        return config;
    }

    public static boolean d() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.CAN_REPORT_TASK_RUN_AT_FRONT, 0) == 0) {
            return false;
        }
        return true;
    }

    public static int d0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.MAX_PENDING_REPORT_TASK_NUM, 1000);
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_SHARE_STRUCT_LONG_MESSAGE, "qzone.qq.com");
        if (!TextUtils.isEmpty(config)) {
            for (String str2 : config.split(",")) {
                if (str.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String e0() {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.CUSTOM_VIP_PREVIEW, "https://h5.qzone.qq.com/personalVipStore/detail/{id}?_wv=2098179&qua={qua}&router=detail&id={id}");
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "getPersonalizePreview:" + config);
        }
        return config;
    }

    public static boolean f() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_DISABLE_CHANGE_STATUS_COLOR_OUT_QZONE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String f0() {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_PERSONALIZE_MAINPAGE, "https://h5.qzone.qq.com/show/home?_wv=131072&_fv=0&_wwv=128&_proxy=1&reddot={reddot}");
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "getPersonalizeSettingPage:" + config);
        }
        return config;
    }

    public static boolean g() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_INTIMATE_SPACE_ENABLE_APPEND_FEED_IN_TAB, 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static String g0() {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.CUSTOM_VIP_MALL, "https://h5.qzone.qq.com/personalVipStore/index?_wv=2098179&refresh=1&qua={qua}");
        if (QZLog.isColorLevel()) {
            QZLog.d(DownloadInfo.spKey_Config, 2, "getPersonalizeVipHomePage:" + config);
        }
        return config;
    }

    public static boolean h() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", QzoneConfig.QZONE_CONFIG_ENABLE_ATTACH_QFS_AV1_INFO, 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static void h0(final a aVar) {
        if (aVar != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: common.config.service.QZoneConfigHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_PHOTOVIEW_SHOWOPDELAY, 0) * 1000);
                }
            });
        }
    }

    public static boolean i() {
        if (QzoneConfig.getInstance().getConfigSync("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_AVIF_OCR, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int i0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_PHOTOVIEW_RESTRICT_BEGIN, QzoneConfig.DefaultValue.PHOTO_RESTRICT_BEGIN) * 60000;
    }

    public static boolean j() {
        if (QzoneConfig.getInstance().getConfigSync("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_AVIF_SCAN_QR_CODE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int j0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_PHOTOVIEW_RESTRICT_END, 1440) * 60000;
    }

    public static boolean k() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_BIRTHDAY_LIKE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int k0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTOVIEW, QzoneConfig.SECONDARY_PHOTOVIEW_RESTRICT_FLAG, 0);
    }

    public static boolean l() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_CHANGE_ZPLAN_CEILING_HEIGHT, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String l0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_PLUS_SIGN_IN_SCHEME, "");
    }

    public static boolean m() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_CUSTOM_LIKE, 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static int m0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_PRELOAD_ITEM_SIZE_NORMAL, 8);
    }

    public static boolean n() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_EXTEND_FEEDS, 1) == 1) {
            return true;
        }
        return false;
    }

    public static long n0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_WNS_PUBLIC_ACCOUNT_PUSH_INTERVAL, 14400);
    }

    public static boolean o() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_FIX_BAD_PARCEL_EXCEPTION, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int o0() {
        try {
            return Integer.valueOf(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QCIRCLR_ATUSER_MAX, 10)).intValue();
        } catch (NumberFormatException unused) {
            return 10;
        }
    }

    public static boolean p() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_BUGFIX_KEBOARD_HEIGHT_COMPAT, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String p0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_SPACE_DRAWER_JUMPURL, QzoneConfig.DEFAULT_INTIMATE_SPACE_MANAGER_PAGE);
    }

    public static boolean q() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_FIX_MISS_INDEX_BUG_IN_FEED_PIC_VIEWER, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String q0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QQ_VIDEO_COMMENT_PUBLIC_TIPS_CONENT, QzoneConfig.DEFAULT_VALUE_QQ_VIDEO_COMMENT_PUBLIC_TIPS_CONENT);
    }

    public static boolean r() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_BUGFIX_MOOD_LIST_NEED_REFRESH, 0) != 1) {
            return false;
        }
        return true;
    }

    public static int r0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_MOMENT_SHARE_SWITCH, 0);
    }

    public static boolean s() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_GUEST_JUMP_VISITOR_PAGE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static int s0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_MOMENT_PUBLISH_RETRY_LIMIT_TIMES, 3);
    }

    public static boolean t() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_GYROSCOPE_SENSOR, 0) != 1) {
            return false;
        }
        return true;
    }

    public static String t0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_MOMENT_PUBLISH_TIPS, "\u53d1\u8868\u6b64\u523b\u7684\u597d\u53cb\uff0c24\u5c0f\u65f6\u5185\u53ef\u89c1");
    }

    public static boolean u() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_INTERCEPT_SCROLL_HORIZONTAL_EVENT, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean u0() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_FEED_LIST_CHECK_PRELOAD_PIC_ENABLE, true);
    }

    public static boolean v() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_USE_MULTI_SELECTION_MODE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String v0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_QZONE_INTIMATE_ACTIVATE_PAGE_URL, QzoneConfig.DEFAULT_VALUE_QZONE_INTIMATE_ACTIVATE_PAGE_URL);
    }

    public static boolean w() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_SCHEMA_ENABLE_JUMP_MAIN_PAGE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String w0(String str, String str2) {
        StringBuilder sb5 = new StringBuilder(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_QZONE_INTIMATE_ACTIVATE_PAGE_URL, QzoneConfig.DEFAULT_VALUE_QZONE_INTIMATE_ACTIVATE_PAGE_URL));
        if (!TextUtils.isEmpty(str)) {
            sb5.append("&to=");
            sb5.append(str);
        }
        sb5.append("&space_type=");
        sb5.append(str2);
        return a(Float.valueOf(0.85f), sb5.toString());
    }

    public static boolean x() {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONE_FROM_QFS, QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_USE_NEW_STYLE_PUBLIC_ACCOUNT_PAGE, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String x0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_QZONE_INTIMATE_HISTORY_PAGE_URL, QzoneConfig.DEFAULT_VALUE_QZONE_INTIMATE_HISTORY_PAGE_URL);
    }

    public static boolean y() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_PRELOAD_QZONE_WHEN_HAS_RED, 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static String y0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_QZONE_INTIMATE_SPACE_BADGE_HALO_BGURL, QzoneConfig.DEFAULT_VALUE_QZONE_INTIMATE_SPACE_BADGE_HALO_BGURL);
    }

    public static boolean z() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_ENABLE_QQ_VIDEO_COMMENT_PUBLIC_TIPS, 1) == 1) {
            return true;
        }
        return false;
    }

    public static String z0() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_QZONE_INTIMATE_SPACE_BADGE_LOTTIE_URL, QzoneConfig.DEFAULT_VALUE_QZONE_INTIMATE_SPACE_BADGE_LOTTIE_URL);
    }
}
