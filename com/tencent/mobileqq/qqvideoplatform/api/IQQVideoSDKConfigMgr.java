package com.tencent.mobileqq.qqvideoplatform.api;

import com.tencent.superplayer.api.SuperPlayerSdkOption;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IQQVideoSDKConfigMgr {
    public static final String CONFIG_KEY_BUCKET = "param_bucket";
    public static final String CONFIG_KEY_BUCKET_CONFIG_VER = "param_config_ver";
    public static final String CONFIG_KEY_SUPERPLAYER_SAMPLE_CONFIG = "superplayer_sample_config";
    public static final String CONFIG_KEY_SUPERPLAYER_SO_NAMES = "superplayer_so_names";
    public static final String CONFIG_KEY_SUPERPLAYER_USER_CONFIG = "superplayer_user_config";
    public static final int DEAFULT_CONFIG_PROXY_MAX_MEMORY_SIZE = 100;
    public static final int DEFAULT_CONFIG_BACKGROUND_ALIVE_TIME = 30;
    public static final int DEFAULT_CONFIG_ENABLE = 1;
    public static final int DEFAULT_CONFIG_QUICK_DEINIT_TIME = 5;
    public static final int DEFAULT_CONFIG_REQUEST_INTERVAL_IN_HOUR = 12;
    public static final int DEFAULT_CONFIG_UPDATE_PLAYER_INFO_INTERVAL = 1000;

    boolean enableInitDownloadOnly();

    boolean enableInitSDKWithoutWait();

    boolean getAliveEnable();

    ConcurrentHashMap<String, String> getCommonReportMap();

    void initConfig(SuperPlayerSdkOption superPlayerSdkOption) throws JSONException;

    void saveConfigToMMKV() throws JSONException;
}
