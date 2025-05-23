package com.tencent.superplayer.config;

import android.content.SharedPreferences;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.config.DataHandler;
import com.tencent.superplayer.config.PullConfigRequest;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ConfigManager {
    private static String GROUP_SEPARATOR = ".";
    public static final String RAIN_BOW_KEY = "07d79ecd-33f9-4b90-80cb-e12359816b34";
    private static String SP_FILE_NAME = "superPlayer-config";
    private static String SP_KEY_LAST_REQUEST_TIME = "last_request_time";
    private static final String TAG = "ConfigManager";
    private static ConfigManager mInstance = new ConfigManager();
    private OnConfigCallback mCallback;
    private SharedPreferences mSharedPreferences;
    private DataHandler mDataHandler = new DataHandler();
    private CacheManager mCacheManager = new CacheManager();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnConfigCallback {
        void onConfigPulled();
    }

    ConfigManager() {
        this.mDataHandler.setCallback(new DataHandler.ConfigGroupParseCallback() { // from class: com.tencent.superplayer.config.ConfigManager.1
            @Override // com.tencent.superplayer.config.DataHandler.ConfigGroupParseCallback
            public void onConfigGroupParsed(CacheContent cacheContent, String str) {
                ConfigManager.this.mCacheManager.save(cacheContent, str);
                ThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.superplayer.config.ConfigManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ConfigManager.this.mCallback != null) {
                            ConfigManager.this.mCallback.onConfigPulled();
                        }
                    }
                });
            }
        });
    }

    public static ConfigManager get() {
        return mInstance;
    }

    public static String groupName2OriginGroupName(String str) {
        return RequestRootGroup.getRequestRootGroup() + GROUP_SEPARATOR + str;
    }

    public static boolean needLoadConfig(int i3) {
        if (SuperPlayerSDKMgr.getContext() == null) {
            LogUtil.w(TAG, "needLoadConfig false for context is null");
            return false;
        }
        if (SuperPlayerSDKMgr.getPlatform() == 170303 && i3 != 104) {
            return false;
        }
        return true;
    }

    private boolean needRequest() {
        if (!CommonUtil.m()) {
            LogUtil.w(TAG, "This process is not main, not request.");
            return false;
        }
        if (!RequestRootGroup.needRequest()) {
            LogUtil.w(TAG, "Your app is not need to Request.");
            return false;
        }
        long currentTimeMillis = ((System.currentTimeMillis() - this.mSharedPreferences.getLong(SP_KEY_LAST_REQUEST_TIME, 0L)) / 1000) / 60;
        long j3 = SuperPlayerSDKMgr.getSdkOption().configRequestIntervalInHour * 60;
        if (currentTimeMillis < j3) {
            LogUtil.w(TAG, "Your app is not need to Request. currentIntervalInMinute\uff1a" + currentTimeMillis + ",    configRequestIntervalInMinute\uff1a" + j3);
            return false;
        }
        return true;
    }

    private void pullConfigFromServer() {
        new PullConfigRequest().executeRequest(RequestRootGroup.getRequestRootGroup(), new PullConfigRequest.PullConfigCallback() { // from class: com.tencent.superplayer.config.ConfigManager.2
            @Override // com.tencent.superplayer.config.PullConfigRequest.PullConfigCallback
            public void onConfigPulled(final String str) {
                ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.config.ConfigManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigManager.this.mDataHandler.parseServerResult(str);
                    }
                });
            }
        });
    }

    public CacheContent getCacheByOriginGroupName(String str) {
        return this.mCacheManager.get(str);
    }

    public CacheContent getConfig(String str) {
        return this.mCacheManager.get(groupName2OriginGroupName(str));
    }

    public void init() {
        if (SuperPlayerSDKMgr.getContext() == null) {
            return;
        }
        this.mSharedPreferences = SuperPlayerSDKMgr.getContext().getSharedPreferences(SP_FILE_NAME, 0);
        if (SuperPlayerSDKMgr.getSdkOption().serverConfigEnable && needRequest()) {
            this.mSharedPreferences.edit().putLong(SP_KEY_LAST_REQUEST_TIME, System.currentTimeMillis()).apply();
            LogUtil.d(TAG, "PullConfigFromServer from rainbow.");
            pullConfigFromServer();
        }
    }

    public void setCallback(OnConfigCallback onConfigCallback) {
        this.mCallback = onConfigCallback;
    }
}
