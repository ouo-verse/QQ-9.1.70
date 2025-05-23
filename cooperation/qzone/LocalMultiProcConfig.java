package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class LocalMultiProcConfig {
    public static final int CLOSE = 2;
    public static final int MOBILE_AND_WIFI = 1;
    public static final int NO_INIT = -1;
    public static final int ONLY_WIFI = 0;
    public static final String PEFORMANCE_CONFIG = "QZ_Per_Config";
    private static final String PREFS_NAME_4_UIN_DEFAULT = "QZ_QQ_shared_preference";

    @Deprecated
    public static final String PREFS_NAME_LOCAL_QZ_SETTING = "QZ_setting";
    public static final String PREFS_NAME_MULTI_QZ_SETTING = "Qzone_multi_setting";
    public static final String PREFS_NAME_PHOTOPLUS_SETTING = "paster_setting";
    public static final String PREFS_NAME_QZ_QQ_SETTING = "QZ_QQ_shared_setting";
    public static final String PREFS_NAME_QZ_SETTING = "Qz_setting";
    public static final String PREFS_NAME_QZ_VIDEO_SETTING = "QZ_video_shared_setting";
    public static final String PREFS_NAME_RFW_DOWNLOAD_MEDIA_SETTING = "rfw_download_media_setting";
    public static final String QZONE_ALBUM_DLNA_SWITCH = "QZone_dlnaSwitch";
    public static final String QZONE_ALBUM_RECOMM_EXPOSE_COUNTS = "qzone_album_recomm_expose_counts";
    public static final String QZONE_ALBUM_RECOMM_GREYINFO = "qzone_album_recomm_grey_info";
    public static final String QZONE_BARRAGE_EFFECT_ENABLED = "qzone_barrage_effect_enabled";
    public static final String QZONE_BARRAGE_EFFECT_SAVE_DATA = "qzone_barrage_effect_save_data";
    public static final String QZONE_CAMPUSINFO_SCHOOLNAME = "qzone_campusInfo_name";
    public static final String QZONE_CAMPUSINFO_SCHOOL_ID = "qzone_campusInfo_school_id";
    public static final String QZONE_CAMPUSINFO_SCHOOL_IDX = "qzone_campusInfo_school_idx";
    public static final String QZONE_CAMPUSINFO_VERFYSTATUS = "qzone_campusInfo_verfyStatus";
    public static final String QZONE_CAN_USE_SHAISHAI_PUBLISH = "qzone_can_use_shaishai_publish";
    public static final String QZONE_CLEAR_CACHE_VERSION = "Qzone_clearCacheVersion";
    public static final String QZONE_CLIENT_MODE = "qzone_client_mode";
    public static final String QZONE_CUSTOM_PRAISE_ENABLED = "qzone_custom_praise_enabled";
    public static final String QZONE_DIY_JUMP_URL = "qzone_diy_page_jump_url";
    public static final String QZONE_ENABLE_FEED_TAB = "qzone_enable_feed_tab";
    public static final String QZONE_ENABLE_FPS_MONITOR = "qzone_enable_fps_monitor";
    public static final String QZONE_FEED_CUSTOM_BROWSER_DECO_SWITCH = "qzone_feed_custom_browser_deco_switch";
    public static final String QZONE_FEED_SKIN_ENABLE = "qzone_feed_skin_enable";
    public static final String QZONE_FLUTTER_PREDOWNLOAD_SUCCESS = "qzone_flutter_predownload_success";
    public static final String QZONE_FONT_ENABLED = "qzone_font_enabled";
    public static final String QZONE_FONT_RED_DOT = "qzone_font_red_dot";
    public static final String QZONE_FONT_SAVE_DATA = "qzone_font_save_data";
    public static final String QZONE_FORCE_WEISHI_LAYER = "Qzone_force_weishilayer";
    public static final String QZONE_GPS_SWITCH = "Qzone_gps_switch";
    public static final String QZONE_LARGE_FONT_SAVE_DATA = "qzone_large_font_save_data";
    public static final String QZONE_LOCAL_PHOTO_SCAN_ENABLED = "qzone_local_photo_scan_enabled_8985";
    public static final String QZONE_MOOD_SYNC_QCIRCLE_BUBBLE_SHOWN_COUNT = "qzone_mood_sync_bubble_shown_count";
    public static final String QZONE_MOOD_SYNC_QCIRCLE_SYNCED = "qzone_mood_sync_qcircle_synced";
    public static final String QZONE_PASSIVE_PRAISE_ENABLED = "qzone_passive_praise_enabled";
    public static final String QZONE_PERMISSION_PUBLIC = "qzone_permission_public";
    public static final String QZONE_PROCESS_IS_FIRST_LOGIN = "qzone_process_is_first_login";
    public static final String QZONE_SET_APM_DROP = "Qzone_setApm_drop";
    public static final String QZONE_SET_APM_IO = "Qzone_setApm_io";
    public static final String QZONE_SET_APM_MEM = "Qzone_setApm_mem";
    public static final String QZONE_SET_APM_MEMLEAK = "Qzone_setApm_MemLeak";

    @Deprecated
    public static final String QZONE_SET_GIFPLAYMODE = "Qzone_setGifplay";
    public static final String QZONE_SET_PLAYMODE = "Qzone_playMode";

    @Deprecated
    public static final String QZONE_SET_VIDEOPLAYMODE = "Qzone_setVideoplay";
    public static final String QZONE_SOUND_EFFECT_ENABLED = "qzone_sound_effect_enabled";
    public static final String QZONE_SUPER_FONT_ENABLED = "qzone_super_font_enabled";
    public static final String QZONE_SUPER_FONT_SAVE_DATA = "qzone_super_font_save_data";
    public static final String QZONE_SUPPORT_SHARPP = "qzone_support_sharpp";
    public static final String QZONE_SYNC_KUOLIE = "QZone_synckuolie";
    public static final String QZONE_TROOP_REDPOINT_PULL_AMOUNT_THRESHOLD = "qzone_troop_redpoint_pull_amount_threshold";
    public static final String QZONE_TROOP_REDPOINT_PULL_TIME_THRESHOLD = "qzone_troop_redpoint_pull_time_threshold";
    public static final String QZONE_USE_QCIRCLE_PUBLISH = "qzone_use_qcircle_publish";
    public static final String QZONE_WATER_MARK = "WaterMark";
    public static final String QZONE_WNS_NET_CLOSE = "qzone_wns_net";
    public static final String SHARPP_SO_MD5_AND_LENGTH = "sharpPSoMD5AndLength";
    public static final String SHARPP_SO_PREVIOUS_VERSION_MD5_AND_LENGTH = "sharpPSoMD5AndLength_previous";
    private static final int StateLoading = 0;
    private static final int StateNotReady = -1;
    private static final int StateReady = 1;
    private static final String TAG = "LocalMultiProcConfig";
    public static final String WIDGET_CONFIG_PREFIX = "Widget_";
    public static Map<String, ?> acountMap;
    public static Map<String, ?> defultMap;
    private static final Map<String, String> sMigrateCache = new ConcurrentHashMap();
    private static final Map<String, QZoneMMKVMigrateTask> sMigrateTask = new ConcurrentHashMap();
    public static String PROCESS_NAME = "com.tencent.mobileqq:qzone";
    private static int cacheState = -1;

    /* loaded from: classes28.dex */
    public interface Constants {
        public static final String KEY_CRASH_COUNT = "key_crash_count";
        public static final String KEY_ENABLE_DEBUG = "key_enable_debug";
        public static final String KEY_FIRST_ENTER_FRIEND_FEED = "key_first_enter_friend_feed";
        public static final String KEY_HAS_ENTER_PICTURE_VIEWER = "key_has_enter_picture_viewer";
        public static final String KEY_LAST_CRASH_INFO = "key_last_crash_info";
        public static final String KEY_PHOTO_COMMENT_DANMAKU_SWITCH = "key_photo_comment_danmaku_switch";
        public static final String KEY_QZONE_CONFIG = "qzone_config";
        public static final String KEY_RESHIP_PHOTO_ALBUM_COVER = "key_reship_photo_album_cover";
        public static final String KEY_RESHIP_PHOTO_ALBUM_ID = "key_reship_photo_album_id";
        public static final String KEY_RESHIP_PHOTO_ALBUM_NAME = "key_reship_photo_album_name";
        public static final String KEY_RESHIP_PHOTO_ALBUM_PRIVACY = "key_reship_photo_album_privacy";
        public static final String KEY_RESHIP_PHOTO_ALBUM_TYPE = "key_reship_photo_album_type";
        public static final String KEY_SERVER_ENVIRONMENT = "ServerEnvironment";
        public static final String KEY_UPLOAD_CUSTOM_SERVER_IP = "ServerUploadCustomIp";
        public static final String KEY_UPLOAD_CUSTOM_SERVER_PORT = "ServerUploadCustomPort";
        public static final String KEY_UPLOAD_KEEP_IMAGE_CACHE = "ServerKeepImageCache";
        public static final String KEY_UPLOAD_KEEP_VIDEO_CACHE = "ServerKeepVideoCache";
        public static final String KEY_UPLOAD_SERVER_ENVIRONMENT = "ServerUploadEnvironment";
        public static final String KEY_VIDEO_COMPRESS_SPEED = "key_video_compress_speed";
    }

    public static void clearAllConfig() {
        if (cacheState != 1) {
            return;
        }
        Map<String, ?> map = defultMap;
        if (map != null) {
            map.clear();
        }
        Map<String, ?> map2 = acountMap;
        if (map2 != null) {
            map2.clear();
        }
    }

    @SuppressLint({"NewApi"})
    private static void commitEditor(SharedPreferences.Editor editor) {
        editor.apply();
    }

    public static boolean containKey(String str, String str2) {
        return getPreferences(str).contains(str2);
    }

    public static boolean getBool(String str, boolean z16) {
        return getBool(PREFS_NAME_QZ_QQ_SETTING, str, z16);
    }

    public static boolean getBoolean4Uin(String str, boolean z16, long j3) {
        Map<String, ?> map = acountMap;
        if (map != null && map.containsKey(str) && (acountMap.get(str) instanceof Boolean)) {
            return ((Boolean) acountMap.get(str)).booleanValue();
        }
        return getPreferences4Uin(j3).getBoolean(str, z16);
    }

    public static int getInt(String str, String str2, int i3) {
        Map<String, ?> map = defultMap;
        if (map != null && map.containsKey(str2) && (defultMap.get(str2) instanceof Integer)) {
            return ((Integer) defultMap.get(str2)).intValue();
        }
        return getPreferences(str).getInt(str2, i3);
    }

    public static int getInt4Uin(String str, int i3, long j3) {
        Map<String, ?> map = acountMap;
        if (map != null && map.containsKey(str) && (acountMap.get(str) instanceof Integer)) {
            return ((Integer) acountMap.get(str)).intValue();
        }
        return getPreferences4Uin(j3).getInt(str, i3);
    }

    public static int getInt4UinString(String str, int i3, String str2) {
        Map<String, ?> map = acountMap;
        if (map != null && map.containsKey(str) && (acountMap.get(str) instanceof Integer)) {
            return ((Integer) acountMap.get(str)).intValue();
        }
        try {
            return getPreferences4Uin(Long.valueOf(str2).longValue()).getInt(str, i3);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public static long getLong(String str, String str2, long j3) {
        return getPreferences(str).getLong(str2, j3);
    }

    public static long getLong4Uin(String str, long j3, long j16) {
        Map<String, ?> map = acountMap;
        if (map != null && map.containsKey(str) && (acountMap.get(str) instanceof Long)) {
            return ((Long) acountMap.get(str)).longValue();
        }
        return getPreferences4Uin(j16).getLong(str, j3);
    }

    private static SharedPreferences getMMkvSp(String str, int i3) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, str, QMMKVFile.FILE_QZONE);
        Map<String, String> map = sMigrateCache;
        if (map.containsKey(str)) {
            return new QZoneSpAdapter(fromSpAdapter, str, QMMKVFile.FILE_QZONE, true);
        }
        if (fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            map.put(str, str);
            return new QZoneSpAdapter(fromSpAdapter, str, QMMKVFile.FILE_QZONE, true);
        }
        Map<String, QZoneMMKVMigrateTask> map2 = sMigrateTask;
        if (map2.get(str) == null) {
            QZoneMMKVMigrateTask qZoneMMKVMigrateTask = new QZoneMMKVMigrateTask(str, i3, QMMKVFile.FILE_QZONE);
            map2.put(str, qZoneMMKVMigrateTask);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(qZoneMMKVMigrateTask);
        }
        QLog.d(TAG, 1, "sp has not migrate to mmkv\uff0cuse old sp" + str);
        return new QZoneSpAdapter(MobileQQ.sMobileQQ.getSharedPreferences(str, i3), str, QMMKVFile.FILE_QZONE, false);
    }

    public static SharedPreferences getPreferences(@NonNull String str) {
        return getPreferences(str, 4);
    }

    private static SharedPreferences getPreferences4Uin(long j3) {
        if (j3 == 0) {
            return getPreferences(PREFS_NAME_QZ_QQ_SETTING);
        }
        return getPreferences(j3 + "_" + PREFS_NAME_4_UIN_DEFAULT);
    }

    public static String getString(String str, String str2, String str3) {
        Map<String, ?> map = defultMap;
        if (map != null && map.containsKey(str2) && (defultMap.get(str2) instanceof String)) {
            return (String) defultMap.get(str2);
        }
        return getPreferences(str).getString(str2, str3);
    }

    public static String getString4Uin(String str, String str2, long j3) {
        Map<String, ?> map = acountMap;
        if (map != null && map.containsKey(str) && (acountMap.get(str) instanceof String)) {
            return (String) acountMap.get(str);
        }
        return getPreferences4Uin(j3).getString(str, str2);
    }

    public static void loadAllConfig() {
        QLog.d(TAG, 4, "loadAllConfig");
        if (cacheState == 0) {
            return;
        }
        defultMap = getPreferences(PREFS_NAME_QZ_QQ_SETTING).getAll();
        if (!TextUtils.isEmpty(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount())) {
            acountMap = getPreferences(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount() + "_" + PREFS_NAME_4_UIN_DEFAULT).getAll();
            return;
        }
        QLog.d(TAG, 1, "uin is 0");
    }

    public static void putBool(String str, boolean z16) {
        putBool(PREFS_NAME_QZ_QQ_SETTING, str, z16);
    }

    public static void putBoolean4Uin(String str, boolean z16, long j3) {
        SharedPreferences.Editor edit = getPreferences4Uin(j3).edit();
        edit.putBoolean(str, z16);
        commitEditor(edit);
    }

    public static void putBooleanAsync(String str, boolean z16) {
        putBooleanAsync(PREFS_NAME_QZ_QQ_SETTING, str, z16);
    }

    public static void putInt(String str, String str2, int i3) {
        SharedPreferences.Editor edit = getPreferences(str).edit();
        edit.putInt(str2, i3);
        commitEditor(edit);
    }

    public static void putInt4Uin(String str, int i3, long j3) {
        SharedPreferences.Editor edit = getPreferences4Uin(j3).edit();
        edit.putInt(str, i3);
        commitEditor(edit);
    }

    public static void putLong(String str, String str2, long j3) {
        SharedPreferences.Editor edit = getPreferences(str).edit();
        edit.putLong(str2, j3);
        commitEditor(edit);
    }

    public static void putLong4Uin(String str, long j3, long j16) {
        SharedPreferences.Editor edit = getPreferences4Uin(j16).edit();
        edit.putLong(str, j3);
        commitEditor(edit);
    }

    public static void putString(String str, String str2, String str3) {
        SharedPreferences.Editor edit = getPreferences(str).edit();
        edit.putString(str2, str3);
        commitEditor(edit);
    }

    public static void putString4Uin(String str, String str2, long j3) {
        SharedPreferences.Editor edit = getPreferences4Uin(j3).edit();
        edit.putString(str, str2);
        commitEditor(edit);
    }

    public static void removeKey(String str, String str2) {
        getPreferences(str).edit().remove(str2).apply();
    }

    public static boolean getBool(String str, String str2, boolean z16) {
        Map<String, ?> map = defultMap;
        if (map != null && map.containsKey(str2) && (defultMap.get(str2) instanceof Boolean)) {
            return ((Boolean) defultMap.get(str2)).booleanValue();
        }
        return getPreferences(str).getBoolean(str2, z16);
    }

    public static long getLong(String str, long j3) {
        Map<String, ?> map = defultMap;
        if (map != null && map.containsKey(str) && (defultMap.get(str) instanceof Long)) {
            return ((Long) defultMap.get(str)).longValue();
        }
        return getPreferences(PREFS_NAME_QZ_QQ_SETTING).getLong(str, j3);
    }

    public static SharedPreferences getPreferences(@NonNull String str, int i3) {
        return getMMkvSp(str, i3);
    }

    public static void putBool(String str, String str2, boolean z16) {
        SharedPreferences.Editor edit = getPreferences(str).edit();
        edit.putBoolean(str2, z16);
        commitEditor(edit);
    }

    public static void putBooleanAsync(final String str, final String str2, final boolean z16) {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.LocalMultiProcConfig.1
            @Override // java.lang.Runnable
            public void run() {
                LocalMultiProcConfig.putBool(str, str2, z16);
            }
        }, 8, null, true);
    }

    public static void putInt(String str, int i3) {
        putInt(PREFS_NAME_QZ_QQ_SETTING, str, i3);
    }

    public static void putLong(String str, long j3) {
        putLong(PREFS_NAME_QZ_QQ_SETTING, str, j3);
    }

    public static void putString(String str, String str2) {
        putString(PREFS_NAME_QZ_QQ_SETTING, str, str2);
    }

    public static int getInt(String str, int i3) {
        return getInt(PREFS_NAME_QZ_QQ_SETTING, str, i3);
    }

    public static String getString(String str, String str2) {
        return getString(PREFS_NAME_QZ_QQ_SETTING, str, str2);
    }
}
