package com.qq.e.comm.util;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.tencent.ams.fusion.service.kv.b;
import java.util.Set;

/* loaded from: classes3.dex */
public class SharedPreferencedUtil {
    public static final String KEY_APP_STATUS_UPDATE_TIME = "appStatusUpdateTime";
    public static final String KEY_APP_STATUS_WHITE_LIST = "appStatusWhiteList";
    public static final String KEY_CPM_PRIORITY_EXP = "155376";
    public static final String KEY_HIPPY_SO_LOCAL_PATH = "HippySoLocalPath";
    public static final String KEY_LAST_DOWNLOAD_HIPPY_SO_URL = "lastDownloadHippySoUrl";
    public static final String KEY_LAST_OAID = "lod";
    public static final String KEY_LAST_TAID = "ltd";
    public static final String KEY_PAGE_PERFORMANCE_SCRIPT = "pagePerformanceScript";
    public static final String KEY_PREODER_APP_CALLBACK_NUM_PREFIX = "preoder_app_callback_num_";
    public static final String KEY_PREODER_APP_CALLBACK_TIME_PREFIX = "preoder_app_callback_time_";
    public static final String KEY_PREODER_APP_INFO_PREFIX = "preoder_app_info_";
    public static final String KEY_QIMEI_TIME = "qimeiReportTime";
    public static final String KEY_SPLASH_FIRST_PLAY_DATE = "first_play_date";
    public static final String KEY_SPLASH_HOT_START_PLAYROUND_PREFIX = "splashHotStartPlayround";
    public static final String KEY_SPLASH_LAST_UPDATE_TIME = "splash_last_update_time";
    public static final String KEY_SPLASH_MATERIAL_CHECK_ON_THE_DAY = "splashMaterialCheckOnTheDay";
    public static final String KEY_SPLASH_PLAYROUND_PREFIX = "splashPlayround";
    public static final String KEY_USER_AD_INTEREST_LABEL = "ad_interest_label";
    public static final String KEY_USER_AD_RECOMMEND_STATUS = "ad_recommend_status";
    public static final String KEY_USER_NOLOGIN_AD_RECOMMEND_STATUS = "no_login_ad_recommend_status";
    public static final String SP_NAME_CONFIG = "com.qq.e.sdkconfig";
    public static final int KEY_SPLASH_PLAYROUND_DEFAULT = (int) (Math.random() * 10000.0d);
    public static final int KEY_SPLASH_HOT_PLAYROUND_DEFAULT = (int) (Math.random() * 10000.0d);

    /* loaded from: classes3.dex */
    public interface Key {
        public static final String INVALID_PLUGIN_MSG = "invalidPluginMsg";
        public static final String INVALID_PLUGIN_SIG = "invalidPluginSig";
        public static final String INVALID_PLUGIN_VERSION = "invalidPluginVersion";
        public static final String KEY_LAST_OAID = "lod";
        public static final String KEY_LAST_TAID = "ltd";
        public static final String KEY_QIMEI_TIME = "qimeiReportTime";
        public static final String KEY_SPLASH_FIRST_PLAY_DATE = "first_play_date";
        public static final int KEY_SPLASH_PLAYROUND_DEFAULT = (int) (Math.random() * 10000.0d);
        public static final String KEY_SPLASH_PLAYROUND_PREFIX = "splashPlayround";
    }

    public static int getInt(String str, int i3) {
        if (b.b().g()) {
            return b.b().c(SP_NAME_CONFIG, str, i3);
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                return GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).getInt(str, i3);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        return 0;
    }

    public static long getLong(String str, long j3) {
        if (b.b().g()) {
            return b.b().d(SP_NAME_CONFIG, str, j3);
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                return GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).getLong(str, j3);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
                return 0L;
            }
        }
        return 0L;
    }

    public static String getString(String str, String str2) {
        GDTLogger.i(" getString isValid :" + b.b().g());
        if (b.b().g()) {
            return b.b().e(SP_NAME_CONFIG, str, str2);
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                return GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).getString(str, str2);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static Set<String> getStringSet(String str, Set<String> set) {
        if (b.b().g()) {
            return b.b().f(SP_NAME_CONFIG, str, set);
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                return GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).getStringSet(str, set);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void putInt(String str, int i3) {
        if (b.b().g()) {
            b.b().h(SP_NAME_CONFIG, str, i3);
            return;
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).edit();
                edit.putInt(str, i3);
                edit.apply();
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }

    public static void putLong(String str, long j3) {
        if (b.b().g()) {
            b.b().i(SP_NAME_CONFIG, str, j3);
            return;
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).edit();
                edit.putLong(str, j3);
                edit.apply();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public static void putString(String str, String str2) {
        if (b.b().g()) {
            b.b().j(SP_NAME_CONFIG, str, str2);
            return;
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).edit();
                edit.putString(str, str2);
                edit.apply();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public static void putStringSet(String str, Set<String> set) {
        if (b.b().g()) {
            b.b().k(SP_NAME_CONFIG, str, set);
            return;
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).edit();
                edit.putStringSet(str, set);
                edit.apply();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public static void remove(String str) {
        if (b.b().g()) {
            b.b().l(SP_NAME_CONFIG, str);
            return;
        }
        if (GDTADManager.getInstance().getAppContext() != null) {
            try {
                SharedPreferences.Editor edit = GDTADManager.getInstance().getAppContext().getSharedPreferences(SP_NAME_CONFIG, 0).edit();
                edit.remove(str);
                edit.apply();
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }

    public static int getInt(String str, String str2, int i3) {
        if (b.b().g()) {
            return b.b().c(SP_NAME_CONFIG, str2, i3);
        }
        if (GDTADManager.getInstance().getAppContext() != null && !TextUtils.isEmpty(str)) {
            try {
                return GDTADManager.getInstance().getAppContext().getSharedPreferences(str, 0).getInt(str2, i3);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        return i3;
    }
}
