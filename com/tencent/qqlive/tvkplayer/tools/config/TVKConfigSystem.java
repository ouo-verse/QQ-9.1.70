package com.tencent.qqlive.tvkplayer.tools.config;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigPriorityFilter;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKJsonUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKConfigSystem {
    private static final String LOCAL_JSON_CONFIG_KEY_PLAYER_CONFIG = "player_config";
    private static final String LOG_TAG = "TVKPlayer[TVKConfigMerger]";
    public static final int REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC = 1800;
    private static HashMap<ConfigType, TVKConfigPriorityFilter.ConfigPriority> sConfigTypeToConfigPriorityMap;
    private static ArrayList<ConfigType> sLocalCacheEnabledConfigTypes;
    private final TVKConfigPriorityFilter mConfigPriorityFilter = new TVKConfigPriorityFilter();
    private boolean mIsInit = false;
    private long mLastRequestOnlineConfigTimeMs = Long.MIN_VALUE;
    private static final String CACHE_CONFIG_KEY_PREFIX = "TVK_MEDIA_CONFIG_" + TVKVersion.getPlayerVersion();
    private static final TVKConfigSystem sConfigSystem = new TVKConfigSystem();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum ConfigType {
        CONFIG_TYPE_WUJI,
        CONFIG_TYPE_APP,
        CONFIG_TYPE_TAB
    }

    static {
        HashMap<ConfigType, TVKConfigPriorityFilter.ConfigPriority> hashMap = new HashMap<>();
        sConfigTypeToConfigPriorityMap = hashMap;
        ConfigType configType = ConfigType.CONFIG_TYPE_WUJI;
        hashMap.put(configType, TVKConfigPriorityFilter.ConfigPriority.CONFIG_PRIORITY_WUJI);
        sConfigTypeToConfigPriorityMap.put(ConfigType.CONFIG_TYPE_APP, TVKConfigPriorityFilter.ConfigPriority.CONFIG_PRIORITY_APP);
        sConfigTypeToConfigPriorityMap.put(ConfigType.CONFIG_TYPE_TAB, TVKConfigPriorityFilter.ConfigPriority.CONFIG_PRIORITY_TAB);
        ArrayList<ConfigType> arrayList = new ArrayList<>();
        sLocalCacheEnabledConfigTypes = arrayList;
        arrayList.add(configType);
    }

    TVKConfigSystem() {
    }

    private boolean applyPlayerConfig(@NonNull ConfigType configType, @NonNull HashMap<String, String> hashMap) {
        TVKConfigPriorityFilter.ConfigPriority configPriority = sConfigTypeToConfigPriorityMap.get(configType);
        if (configPriority == null) {
            TVKLogUtil.w(LOG_TAG, "applyPlayerConfig, unknown config type:" + configType.name());
            return false;
        }
        HashMap<String, String> filter = this.mConfigPriorityFilter.filter(configPriority, hashMap);
        if (filter.isEmpty()) {
            return false;
        }
        TVKMediaPlayerConfig.applePlayerConfig(filter);
        return true;
    }

    private static void cacheConfig(@NonNull String str, @NonNull HashMap<String, String> hashMap) {
        String str2 = CACHE_CONFIG_KEY_PREFIX + str;
        TVKLogUtil.i(LOG_TAG, "[cacheConfig] Caching player config into local storage with key " + str2 + MsgSummary.STR_COLON + hashMap.toString());
        Context applicationContext = TVKCommParams.getApplicationContext();
        if (applicationContext == null) {
            TVKLogUtil.w(LOG_TAG, "[cacheConfig] Fails to cache player config: application context is null");
        } else {
            LocalCache.get(applicationContext).put(str2, hashMap);
        }
    }

    public static TVKConfigSystem getInstance() {
        return sConfigSystem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLocalCachedConfig(@Nullable ITVKConfigChangedListener iTVKConfigChangedListener) {
        for (ConfigType configType : ConfigType.values()) {
            if (sLocalCacheEnabledConfigTypes.contains(configType)) {
                HashMap<String, String> readCachedConfig = readCachedConfig(configType.name());
                TVKLogUtil.i(LOG_TAG, "[readCachedConfig] localCachedConfig:" + readCachedConfig);
                if (readCachedConfig == null) {
                    readCachedConfig = new HashMap<>();
                }
                applyPlayerConfig(configType, readCachedConfig);
                if (iTVKConfigChangedListener != null) {
                    iTVKConfigChangedListener.onConfigChanged();
                }
            }
        }
    }

    @Nullable
    private static HashMap<String, String> readCachedConfig(@NonNull String str) {
        String str2 = CACHE_CONFIG_KEY_PREFIX + str;
        TVKLogUtil.i(LOG_TAG, "[readCachedConfig] Reading cached player config from local storage by key:" + str);
        Context applicationContext = TVKCommParams.getApplicationContext();
        if (applicationContext == null) {
            TVKLogUtil.e(LOG_TAG, "[readCachedConfig] Fails to read cached player config: application context is null");
            return null;
        }
        Object asObject = LocalCache.get(applicationContext).getAsObject(str2);
        if (asObject == null) {
            TVKLogUtil.i(LOG_TAG, "[readCachedConfig] No cached player config found.");
            return null;
        }
        try {
            return (HashMap) asObject;
        } catch (ClassCastException unused) {
            TVKLogUtil.e(LOG_TAG, "[readCachedConfig] Fails to read cached player config: unexpected player config type.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestTabConfig(@Nullable final ITVKConfigChangedListener iTVKConfigChangedListener) {
        ITVKConfigRequester createTabConfigRequester = TVKConfigRequesterFactory.createTabConfigRequester();
        createTabConfigRequester.setRequestListener(new ITVKConfigRequester.ConfigRequestListener() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem.3
            @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester.ConfigRequestListener
            public void onError(@NonNull TVKConfigRequestException tVKConfigRequestException) {
                TVKLogUtil.e(TVKConfigSystem.LOG_TAG, tVKConfigRequestException);
            }

            @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester.ConfigRequestListener
            public void onFetched(@NonNull HashMap<String, String> hashMap, @Nullable HashMap<String, String> hashMap2) {
                TVKLogUtil.i(TVKConfigSystem.LOG_TAG, "requestTabConfig, onConfigFetched, jsonConfig:" + hashMap);
                if (hashMap2 == null) {
                    return;
                }
                String str = hashMap2.get(ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_POLICY_ID);
                String str2 = hashMap2.get(ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !hashMap.isEmpty()) {
                    TVKCommParams.setTabPolicyId(str);
                    TVKCommParams.setTabExpName(str2);
                    TVKConfigSystem.this.updateConfig(ConfigType.CONFIG_TYPE_TAB, hashMap);
                    ITVKConfigChangedListener iTVKConfigChangedListener2 = iTVKConfigChangedListener;
                    if (iTVKConfigChangedListener2 != null) {
                        iTVKConfigChangedListener2.onConfigChanged();
                    }
                }
            }
        });
        try {
            createTabConfigRequester.executeRequest();
        } catch (TVKConfigRequestException e16) {
            TVKLogUtil.e(LOG_TAG, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestWujiConfig(@Nullable final ITVKConfigChangedListener iTVKConfigChangedListener) {
        ITVKConfigRequester createWujiConfigRequester = TVKConfigRequesterFactory.createWujiConfigRequester();
        createWujiConfigRequester.setRequestListener(new ITVKConfigRequester.ConfigRequestListener() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem.2
            @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester.ConfigRequestListener
            public void onError(@NonNull TVKConfigRequestException tVKConfigRequestException) {
                TVKLogUtil.e(TVKConfigSystem.LOG_TAG, tVKConfigRequestException);
            }

            @Override // com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester.ConfigRequestListener
            public void onFetched(@NonNull HashMap<String, String> hashMap, @NonNull HashMap<String, String> hashMap2) {
                TVKLogUtil.i(TVKConfigSystem.LOG_TAG, "requestWujiConfig, onConfigFetched, jsonConfig:" + hashMap);
                TVKConfigSystem.this.updateConfig(ConfigType.CONFIG_TYPE_WUJI, hashMap);
                ITVKConfigChangedListener iTVKConfigChangedListener2 = iTVKConfigChangedListener;
                if (iTVKConfigChangedListener2 != null) {
                    iTVKConfigChangedListener2.onConfigChanged();
                }
            }
        });
        try {
            createWujiConfigRequester.executeRequest();
        } catch (TVKConfigRequestException e16) {
            TVKLogUtil.e(LOG_TAG, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean updateConfig(@NonNull ConfigType configType, @NonNull HashMap<String, String> hashMap) {
        if (sLocalCacheEnabledConfigTypes.contains(configType)) {
            cacheConfig(configType.name(), hashMap);
        }
        return applyPlayerConfig(configType, hashMap);
    }

    public synchronized void requestOnlineConfigAsync(@Nullable final ITVKConfigChangedListener iTVKConfigChangedListener) {
        TVKLogUtil.i(LOG_TAG, "requestOnlineConfigAsync enter");
        long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
        long j3 = this.mLastRequestOnlineConfigTimeMs;
        if (j3 != Long.MIN_VALUE && elapsedRealtime - j3 <= 1800000) {
            TVKLogUtil.w(LOG_TAG, "request too often, interval sec:1800");
        } else {
            this.mLastRequestOnlineConfigTimeMs = elapsedRealtime;
            TVKThreadPool.getInstance().obtainNormalPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (TVKConfigSystem.this) {
                        if (!TVKConfigSystem.this.mIsInit) {
                            TVKConfigSystem.this.mIsInit = true;
                            TVKConfigSystem.this.initLocalCachedConfig(iTVKConfigChangedListener);
                        }
                    }
                    TVKConfigSystem.this.requestWujiConfig(iTVKConfigChangedListener);
                    if (TVKMediaPlayerConfig.PlayerConfig.enable_tab_config) {
                        TVKConfigSystem.this.requestTabConfig(iTVKConfigChangedListener);
                    }
                }
            });
        }
    }

    public boolean updateConfigFromLocal(String str) {
        if (TextUtils.isEmpty(str)) {
            TVKLogUtil.w(LOG_TAG, "setConfig, config content is empty");
            return false;
        }
        try {
            return updateConfig(ConfigType.CONFIG_TYPE_APP, TVKJsonUtils.convertJsonObjectToHashMap(new JSONObject(new JSONObject(str).getString(LOCAL_JSON_CONFIG_KEY_PLAYER_CONFIG))));
        } catch (JSONException e16) {
            TVKLogUtil.e(LOG_TAG, e16);
            return false;
        }
    }
}
