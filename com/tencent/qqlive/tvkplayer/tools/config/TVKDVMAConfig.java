package com.tencent.qqlive.tvkplayer.tools.config;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDVMAConfig {
    private static final String KEY_CONFIG_FETCHED = "config_fetched";
    private static final String KEY_DVMA_CONFIG_STORAGE = "TVK_DVMA_CONFIG_STORAGE";
    private static final String KEY_PREVIOUS_REQUEST_TIME = "previous_request_time";
    private static final String TAG = "TVKPlayer[TVKDVMAConfig]";
    private static boolean sConfigFetched = false;
    private static long sPreRequestTimeMs;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DvmaConfig {
        public static String config_file = "";
    }

    static {
        loadAndApplyConfigPrivate();
    }

    public static long getPreRequestTimeMs() {
        return sPreRequestTimeMs;
    }

    public static boolean isConfigFetched() {
        return sConfigFetched;
    }

    public static boolean isSupportDolbyVisionSoftRender() {
        if (TVKMediaPlayerConfig.PlayerConfig.enable_dvma_softrender && sConfigFetched && !TextUtils.isEmpty(DvmaConfig.config_file)) {
            return true;
        }
        return false;
    }

    private static void loadAndApplyConfigPrivate() {
        HashMap<String, String> readDvmaConfigFromCache = readDvmaConfigFromCache();
        if (readDvmaConfigFromCache == null) {
            TVKLogUtil.i(TAG, "(dvma) loadAndApplyConfig done: no cache.");
            return;
        }
        loadConfigFetched(readDvmaConfigFromCache);
        TVKConfigFieldSetter.setTVKConfigFields(DvmaConfig.class, readDvmaConfigFromCache);
        TVKLogUtil.i(TAG, "(dvma) loadAndApplyConfig done. isSupportDolbyVisionSoftRender:" + isSupportDolbyVisionSoftRender());
    }

    private static void loadConfigFetched(HashMap<String, String> hashMap) {
        boolean z16;
        long parseLong;
        if (hashMap.get(KEY_CONFIG_FETCHED) != null && Boolean.parseBoolean(hashMap.get(KEY_CONFIG_FETCHED))) {
            z16 = true;
        } else {
            z16 = false;
        }
        sConfigFetched = z16;
        String str = hashMap.get(KEY_PREVIOUS_REQUEST_TIME);
        if (str != null) {
            try {
                parseLong = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                TVKLogUtil.e(TAG, "[loadConfigFetched] parseLong Failed: " + str);
                return;
            }
        } else {
            parseLong = 0;
        }
        sPreRequestTimeMs = parseLong;
    }

    @Nullable
    private static HashMap<String, String> readDvmaConfigFromCache() {
        Object asObject;
        Context applicationContext = TVKCommParams.getApplicationContext();
        if (applicationContext == null || (asObject = LocalCache.get(applicationContext).getAsObject(KEY_DVMA_CONFIG_STORAGE)) == null) {
            return null;
        }
        try {
            return (HashMap) asObject;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public static void saveAndApplyConfig(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        setConfigFetched(hashMap);
        writeDvmaConfigToCache(hashMap);
        TVKConfigFieldSetter.setTVKConfigFields(DvmaConfig.class, hashMap);
        TVKLogUtil.i(TAG, "(dvma) saveAndApplyConfig done. isSupportDolbyVisionSoftRender:" + isSupportDolbyVisionSoftRender());
    }

    private static void setConfigFetched(HashMap<String, String> hashMap) {
        sConfigFetched = true;
        sPreRequestTimeMs = SystemClock.elapsedRealtime();
        hashMap.put(KEY_CONFIG_FETCHED, String.valueOf(sConfigFetched));
        hashMap.put(KEY_PREVIOUS_REQUEST_TIME, String.valueOf(sPreRequestTimeMs));
    }

    private static void writeDvmaConfigToCache(@NonNull HashMap<String, String> hashMap) {
        Context applicationContext = TVKCommParams.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        LocalCache.get(applicationContext).put(KEY_DVMA_CONFIG_STORAGE, hashMap);
    }

    public static void loadAndApplyConfig() {
    }
}
