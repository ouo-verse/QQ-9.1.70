package com.tencent.qqlive.tvkplayer.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public class TVKPlayerVideoInfo implements Serializable, Cloneable {
    public static final String PLAYER_CFG_AUDIO_FRAME_CALLBACK_CHANNEL_LAYOUT = "audio_frame_callback_channel_layout";
    public static final String PLAYER_CFG_AUDIO_FRAME_CALLBACK_SAMPLE_FORMAT = "audio_frame_callback_sample_format";
    public static final String PLAYER_CFG_AUDIO_FRAME_CALLBACK_SAMPLE_RATE_HZ = "audio_frame_callback_sample_rate_hz";
    public static final String PLAYER_CFG_AUDIO_FRAME_CALLBACK_SIZE_BYTE = "audio_frame_callback_size_byte";
    public static final String PLAYER_CFG_ENABLE_AUDIO_FRAME_CALLBACK = "enable_audio_frame_callback";
    public static final String PLAYER_CFG_KEY_AD_CLOSE = "ad_close";
    public static final String PLAYER_CFG_KEY_APP_TESTID = "app_testid";
    public static final String PLAYER_CFG_KEY_CACHE_COPY_FIRST = "cache_copy_first";
    public static final String PLAYER_CFG_KEY_COMPATIBLE_MODE = "compatible_mode";
    public static final String PLAYER_CFG_KEY_CUSTOMIZED_SEI_LIST = "customized_sei_list";
    public static final String PLAYER_CFG_KEY_DECREASE_DEF = "decrease_def";
    public static final String PLAYER_CFG_KEY_DISABLE_SOFT_SUBTITLE = "disable_soft_subtitle";
    public static final String PLAYER_CFG_KEY_DISABLE_START_POSITION_CORRECTION = "disable_start_position_correction";
    public static final String PLAYER_CFG_KEY_DLNA_DEVICE_HEVC_LEVEL = "dlna_device_hevc_level";
    public static final String PLAYER_CFG_KEY_DOLBYAUDIO_TRACK = "track";
    public static final String PLAYER_CFG_KEY_DOWNLOAD_PROXY_BIZ_ID = "download_proxy_biz_id";
    public static final String PLAYER_CFG_KEY_DRM = "vinfo_key_drm";
    public static final String PLAYER_CFG_KEY_EFFECT_ENABLE_OPERATION = "effect_enable_operation";
    public static final String PLAYER_CFG_KEY_EFFECT_USER_ENABLE_OPERATION = "effect_user_enabled";
    public static final String PLAYER_CFG_KEY_ENABLE_VOD_AUDIO_VIVID_AND_AAC51 = "enable_vod_audio_vivid_and_aac51";
    public static final String PLAYER_CFG_KEY_ENABLE_VOD_INTERNAL_AUDIO_TRACK = "enable_vod_internal_audio_track";
    public static final String PLAYER_CFG_KEY_ENABLE_VOD_UHD_DEFINITION = "enable_vod_uhd_definition";
    public static final String PLAYER_CFG_KEY_ENCODE_FORCETYPE = "encode_forcetype";

    @Deprecated
    public static final String PLAYER_CFG_KEY_ENTER_DETAIL_PAGE_TIMESTAMP = "enter_detail_page_timestamp";
    public static final String PLAYER_CFG_KEY_ENTER_MIN_BUFFER_MODE = "min_buffer_mode";
    public static final String PLAYER_CFG_KEY_FIRST_BOOT_FROM_OTHER_APP = "first_boot_from_other_app";
    public static final String PLAYER_CFG_KEY_FORCE_USE_APP_SKIP_START_END = "force_use_app_skip_start_end";
    public static final String PLAYER_CFG_KEY_FRAME_RATE = "vinfo_key_request_frame_rate";
    public static final String PLAYER_CFG_KEY_FROM_PLATFORM = "vinfo_key_from_platform";
    public static final String PLAYER_CFG_KEY_HISTORY_VID = "historyVid";
    public static final String PLAYER_CFG_KEY_LIVE_PLAYBACKTIME_MS = "live_playbacktime_ms";
    public static final String PLAYER_CFG_KEY_LOW_DEFINITION_OPEN = "low_definition_open";
    public static final String PLAYER_CFG_KEY_NEED_CACHE = "need_cache";
    public static final String PLAYER_CFG_KEY_NEXT_CID = "next_cid";
    public static final String PLAYER_CFG_KEY_NEXT_VID = "next_vid";
    public static final String PLAYER_CFG_KEY_PCDN_CHARGE_ID = "pcdn_charge_id";
    public static final String PLAYER_CFG_KEY_PLAYER_FORCETYPE = "player_forcetype";
    public static final String PLAYER_CFG_KEY_PLAYMODE = "playmode";
    public static final String PLAYER_CFG_KEY_PREVIEW_ACCURATE_START = "preview_accurate_start";
    public static final String PLAYER_CFG_KEY_REAL_USER_PLAY = "real_user_play";
    public static final String PLAYER_CFG_KEY_SAVE_PATH = "cache_save_path";
    public static final String PLAYER_CFG_KEY_SCENE_ID = "scene_id";
    public static final String PLAYER_CFG_KEY_SCENE_PAGE_ID = "scene_page_id";
    public static final String PLAYER_CFG_KEY_SKIP_START_END = "skip_start_end";
    public static final String PLAYER_CFG_KEY_SPAUDIO = "vinfo_key_spaudio";
    public static final String PLAYER_CFG_KEY_SPTEST = "vinfo_key_sptest";
    public static final String PLAYER_CFG_KEY_SPVIDEO = "vinfo_key_spvideo";
    public static final String PLAYER_CFG_KEY_SUBTITLE_LANGUAGE_ID = "subtitle_language_id";
    public static final String PLAYER_CFG_KEY_SWITCH_PLAYER = "switch_player";
    public static final String PLAYER_CFG_KEY_TOUSHE = "vinfo_key_toushe";
    public static final String PLAYER_CFG_KEY_URL_FLV_VIDEO_SIZE_CHANGED = "url_flv_video_size_changed";
    public static final String PLAYER_CFG_KEY_VIDEO_TRACK_ENABLE_PRELOAD = "video_track_enable_preload";
    public static final String PLAYER_CFG_KEY_VIDEO_TRACK_INSERT_POSITION_MS = "video_track_insert_position_ms";
    public static final String PLAYER_CFG_KEY_VIDEO_TRACK_PLAY_DURATION_MS = "video_track_play_duration_ms";
    public static final String PLAYER_CFG_KEY_VIDEO_TRACK_START_POSITION_MS = "video_track_start_position_ms";
    public static final String PLAYER_CFG_KEY_VIP_EFFECT_USER_ENABLE_OPERATION = "vip_effect_user_enabled";
    public static final String PLAYER_CFG_KEY_VR_VIDEO = "vr_video";
    public static final String PLAYER_CFG_XP2P_KEY = "xp2p_key";
    public static final String PLAYER_REQ_KEY_COUNTRY_CODE = "country_code";
    public static final String PLAYER_REQ_KEY_DEFN_SRC = "defnsrc";
    public static final String PLAYER_REQ_KEY_LANG_CODE = "lang_code";
    public static final String PLAYER_REQ_KEY_LIVEQUEUE = "livequeue";
    public static final String PLAYER_REQ_KEY_MECHINE_ID = "viewid";
    public static final String PLAYER_REQ_KEY_NET_LOGO = "net_logo";
    public static final String PLAYER_REQ_KEY_PAGE_ID = "pageId";
    public static final String PLAYER_REQ_KEY_PRIVATE_DATA = "extra_data";
    public static final String PLAYER_REQ_KEY_REFER_PAGE_ID = "refer_pageId";
    public static final String PLAYER_REQ_KEY_WAITSECRETKEY = "waitSecretKey";
    public static final String PLAYER_REQ_PARAM_DISABLE_COOKIE = "disable_cookie";
    public static final String PLAYER_REQ_PARAM_DISABLE_DRM = "disable_drm";
    public static final String PLAYER_REQ_SCENE_INFORMATION = "scene";
    private static final long serialVersionUID = -374236133868823816L;
    private transient Map<String, Object> mAdParamsMap;
    private Map<String, String> mAdReportInfoMap;
    private Map<String, String> mAdRequestParamMap;
    private ITVKAsset mAsset;
    private int mBizId;
    private Map<String, String> mConfigMap;
    private String mDefinition;
    private transient WeakReference<Object> mExtraObject;
    private Map<String, String> mExtraRequestParamsMap;
    private Map<String, String> mExtraVinfoRequestHeadersMap;
    private boolean mIsNeedCharge;
    private int mPlayType;
    private Map<String, String> mProxyExtraMap;
    private TVKProperties mReportInfoProperties;
    private long mSkipEndPositionMs;
    private long mSkipStartPositionMs;
    private long mVideoDuration;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface PlayType {
    }

    public TVKPlayerVideoInfo(@NonNull ITVKAsset iTVKAsset) {
        this.mPlayType = -1;
        this.mDefinition = "";
        this.mSkipStartPositionMs = 0L;
        this.mSkipEndPositionMs = 0L;
        this.mIsNeedCharge = false;
        this.mBizId = 0;
        this.mAsset = iTVKAsset;
        initParam();
    }

    private void initParam() {
        this.mIsNeedCharge = false;
        this.mAdRequestParamMap = new HashMap();
        this.mExtraRequestParamsMap = new HashMap();
        this.mExtraVinfoRequestHeadersMap = new HashMap();
        this.mConfigMap = new HashMap();
        this.mReportInfoProperties = new TVKProperties();
        this.mAdReportInfoMap = new HashMap();
        this.mProxyExtraMap = new HashMap();
        this.mAdParamsMap = new HashMap();
    }

    public void addAdParamsMap(Map<String, Object> map) {
        this.mAdParamsMap.putAll(map);
    }

    public void addAdReportInfoMap(String str, String str2) {
        this.mAdReportInfoMap.put(str, str2);
    }

    public void addAdRequestParamMap(Map<String, String> map) {
        this.mAdRequestParamMap.putAll(map);
    }

    public void addConfigMap(String str, String str2) {
        this.mConfigMap.put(str, str2);
    }

    public void addExtraRequestParamsMap(String str, String str2) {
        this.mExtraRequestParamsMap.put(str, str2);
    }

    public void addExtraVinfoRequestHeadersMap(String str, String str2) {
        this.mExtraVinfoRequestHeadersMap.put(str, str2);
    }

    public void addProxyExtraMap(String str, String str2) {
        this.mProxyExtraMap.put(str, str2);
    }

    public boolean configMapContainsKey(String str) {
        return this.mConfigMap.containsKey(str);
    }

    public Map<String, Object> getAdParamsMap() {
        return this.mAdParamsMap;
    }

    public Map<String, String> getAdReportInfoMap() {
        return this.mAdReportInfoMap;
    }

    public String getAdReportInfoValue(String str, String str2) {
        String str3 = this.mAdReportInfoMap.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public Map<String, String> getAdRequestParamMap() {
        return this.mAdRequestParamMap;
    }

    public ITVKAsset getAsset() {
        return this.mAsset;
    }

    public int getBizId() {
        return this.mBizId;
    }

    public Map<String, String> getConfigMap() {
        return this.mConfigMap;
    }

    public String getConfigMapValue(String str, String str2) {
        String str3 = this.mConfigMap.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public String getDefinition() {
        return this.mDefinition;
    }

    public Object getExtraObject() {
        WeakReference<Object> weakReference = this.mExtraObject;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getExtraRequestParamValue(String str, String str2) {
        String str3 = this.mExtraRequestParamsMap.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public Map<String, String> getExtraRequestParamsMap() {
        return this.mExtraRequestParamsMap;
    }

    public Map<String, String> getExtraVinfoRequestHeadersMap() {
        return this.mExtraVinfoRequestHeadersMap;
    }

    public String getExtraVinfoRequestHeadersValue(String str, String str2) {
        String str3 = this.mExtraVinfoRequestHeadersMap.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public int getPlayType() {
        return this.mPlayType;
    }

    public Map<String, String> getProxyExtraMap() {
        return this.mProxyExtraMap;
    }

    public TVKProperties getReportInfoProperties() {
        return this.mReportInfoProperties;
    }

    public long getSkipEndPositionMs() {
        return this.mSkipEndPositionMs;
    }

    public long getSkipStartPositionMs() {
        return this.mSkipStartPositionMs;
    }

    public long getVideoDuration() {
        return this.mVideoDuration;
    }

    public boolean isAssetValid() {
        return TVKAssetUtils.isValidAsset(this.mAsset);
    }

    public boolean isLivePlay() {
        return TVKAssetUtils.isLiveAsset(this.mAsset);
    }

    public boolean isNeedCharge() {
        return this.mIsNeedCharge;
    }

    public boolean isQQLiveAssetPlay() {
        return TVKAssetUtils.isQQLiveAsset(this.mAsset);
    }

    public boolean isVideoCacheRecord() {
        return "cache_record_video".equals(getConfigMapValue(PLAYER_CFG_KEY_COMPATIBLE_MODE, ""));
    }

    public boolean isVideoCaptureMode() {
        return "video_capture".equals(getConfigMapValue("playmode", ""));
    }

    public boolean isVodPlay() {
        return TVKAssetUtils.isVodAsset(this.mAsset);
    }

    public void removeAdReportInfoMap(String str) {
        this.mAdReportInfoMap.remove(str);
    }

    public void removeConfigMap(String str) {
        this.mConfigMap.remove(str);
    }

    public void removeProxyExtraMap(String str) {
        this.mProxyExtraMap.remove(str);
    }

    public void setAsset(@NonNull ITVKAsset iTVKAsset) {
        this.mAsset = iTVKAsset;
    }

    public void setBizId(int i3) {
        this.mBizId = i3;
    }

    public void setDefinition(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.mDefinition = str;
    }

    public void setExtraObject(Object obj) {
        this.mExtraObject = null;
        if (obj != null) {
            this.mExtraObject = new WeakReference<>(obj);
        }
    }

    public void setNeedCharge(boolean z16) {
        this.mIsNeedCharge = z16;
    }

    public void setPlayType(int i3) {
        this.mPlayType = i3;
    }

    public void setReportInfoProperties(TVKProperties tVKProperties) {
        if (tVKProperties == null) {
            this.mReportInfoProperties = new TVKProperties();
        } else {
            this.mReportInfoProperties = tVKProperties;
        }
    }

    public void setSkipEndPositionMs(long j3) {
        this.mSkipEndPositionMs = j3;
    }

    public void setSkipStartPositionMs(long j3) {
        this.mSkipStartPositionMs = j3;
    }

    public void setVideoDuration(long j3) {
        this.mVideoDuration = j3;
    }

    public void addAdParamsMap(String str, Object obj) {
        this.mAdParamsMap.put(str, obj);
    }

    public void addAdReportInfoMap(Map<String, String> map) {
        this.mAdReportInfoMap.putAll(map);
    }

    public void addAdRequestParamMap(String str, String str2) {
        this.mAdRequestParamMap.put(str, str2);
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TVKPlayerVideoInfo m239clone() throws CloneNotSupportedException {
        return (TVKPlayerVideoInfo) super.clone();
    }

    public TVKPlayerVideoInfo(@NonNull ITVKAsset iTVKAsset, String str, long j3, long j16) {
        this.mPlayType = -1;
        this.mIsNeedCharge = false;
        this.mBizId = 0;
        this.mAsset = iTVKAsset;
        this.mDefinition = str;
        this.mSkipStartPositionMs = j3;
        this.mSkipEndPositionMs = j16;
        initParam();
    }
}
