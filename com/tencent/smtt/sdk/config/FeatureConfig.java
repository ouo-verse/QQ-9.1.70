package com.tencent.smtt.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FeatureConfig {
    public static final String CORE_FEATURE_METHOD_PRIVATE_IMAGE_FORMAT = "setPrivateImageFormatEnable";
    public static final String CORE_FEATURE_PRIVATE_IMAGE_FORMAT = "setPrivateImageFormatEnable";
    public static final String CORE_FEATURE_TRANSLATE_SEARCH_IMAGEBROWSER = "setTranslateSearchImagebrowserEnable";

    /* renamed from: a, reason: collision with root package name */
    private static boolean f369288a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f369289b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f369290c = true;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f369291d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f369292e = true;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f369293f = true;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f369294g = true;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f369295h = true;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f369296i = true;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f369297j = true;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f369298k = true;

    /* renamed from: l, reason: collision with root package name */
    private static Map<String, Boolean> f369299l;

    FeatureConfig() {
    }

    public static Map<String, Boolean> getCoreFeatureMethodToSetMap() {
        return f369299l;
    }

    public static boolean isBeaconInitEnable(Context context) {
        if (context == null) {
            return true;
        }
        boolean z16 = context.getSharedPreferences("feature_config_settings", 0).getBoolean("beacon_init_enable", true);
        f369295h = z16;
        return z16;
    }

    public static boolean isDebugtmfEnable() {
        return f369289b;
    }

    public static boolean isFingerSearchEnable(Context context) {
        if (context == null) {
            return true;
        }
        boolean z16 = context.getSharedPreferences("feature_config_settings", 0).getBoolean("finger_search_enable", true);
        f369293f = z16;
        return z16;
    }

    @Deprecated
    public static boolean isGetIMEIEnable(Context context) {
        return false;
    }

    @Deprecated
    public static boolean isGetMacAddressEnable(Context context) {
        return false;
    }

    public static boolean isLoadGuidFromHostAppResEnable(Context context) {
        if (context == null) {
            return true;
        }
        boolean z16 = context.getSharedPreferences("feature_config_settings", 0).getBoolean("load_guid_from_host_app_res_enable", true);
        f369296i = z16;
        return z16;
    }

    public static boolean isNetworkInterceptEnable() {
        return f369288a;
    }

    public static boolean isOpenFileByQBEnable() {
        return f369290c;
    }

    public static boolean isRecordFilePositionEnabled(Context context) {
        if (context == null) {
            return true;
        }
        boolean recordFilePositionEnabled = QbSdk.recordFilePositionEnabled(context);
        f369291d = recordFilePositionEnabled;
        return recordFilePositionEnabled;
    }

    public static boolean isVideoDownloadShareBtnEnable(Context context) {
        if (context == null) {
            return true;
        }
        boolean z16 = context.getSharedPreferences("feature_config_settings", 0).getBoolean("video_download_share_btn_enable", true);
        f369294g = z16;
        return z16;
    }

    public static boolean isWUPEnable(Context context) {
        if (context == null) {
            return true;
        }
        boolean z16 = context.getSharedPreferences("feature_config_settings", 0).getBoolean("wup_enable", true);
        f369292e = z16;
        return z16;
    }

    public static void setBeaconInitEnable(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        f369295h = z16;
        SharedPreferences.Editor edit = context.getSharedPreferences("feature_config_settings", 0).edit();
        edit.putBoolean("beacon_init_enable", z16);
        edit.commit();
    }

    public static void setCoreFeatureCommonMethod(String str, boolean z16) {
        if (f369299l == null) {
            f369299l = new HashMap();
        }
        f369299l.put(str, Boolean.valueOf(z16));
    }

    public static void setDebugtmfEnable(Context context, boolean z16) {
        f369289b = z16;
    }

    public static void setFingerSearchEnable(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        f369293f = z16;
        SharedPreferences.Editor edit = context.getSharedPreferences("feature_config_settings", 0).edit();
        edit.putBoolean("finger_search_enable", z16);
        edit.commit();
    }

    public static void setLoadGuidFromHostAppResEnable(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        f369296i = z16;
        SharedPreferences.Editor edit = context.getSharedPreferences("feature_config_settings", 0).edit();
        edit.putBoolean("load_guid_from_host_app_res_enable", z16);
        edit.commit();
    }

    public static void setNetworkInterceptEnable(Context context, boolean z16) {
        f369288a = z16;
    }

    public static void setOpenFileByQBEnable(Context context, boolean z16) {
        f369290c = z16;
    }

    public static void setRecordFilePositionEnabled(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        f369291d = z16;
        QbSdk.setRecordFilePositionEnabled(context, z16);
    }

    public static void setVideoDownloadShareBtnEnable(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        f369294g = z16;
        SharedPreferences.Editor edit = context.getSharedPreferences("feature_config_settings", 0).edit();
        edit.putBoolean("video_download_share_btn_enable", z16);
        edit.commit();
    }

    public static void setWUPEnable(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        f369292e = z16;
        SharedPreferences.Editor edit = context.getSharedPreferences("feature_config_settings", 0).edit();
        edit.putBoolean("wup_enable", z16);
        edit.commit();
    }

    @Deprecated
    public static void setGetIMEIEnable(Context context, boolean z16) {
    }

    @Deprecated
    public static void setGetMacAddressEnable(Context context, boolean z16) {
    }
}
