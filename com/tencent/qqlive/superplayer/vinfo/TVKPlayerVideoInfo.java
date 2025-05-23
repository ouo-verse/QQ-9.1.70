package com.tencent.qqlive.superplayer.vinfo;

import android.text.TextUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public class TVKPlayerVideoInfo implements Serializable {
    public static final String PLAYER_CFG_KEY_ACCURATE_START_POS = "accurate_start_pos";
    public static final String PLAYER_CFG_KEY_AD_CLOSE = "ad_close";
    public static final String PLAYER_CFG_KEY_AUDIO_FRAME_OUTPUT = "audio_frame_output";
    public static final String PLAYER_CFG_KEY_DECREASE_DEF = "decrease_def";
    public static final String PLAYER_CFG_KEY_DOLBYAUDIO_TRACK = "track";
    public static final String PLAYER_CFG_KEY_DRM = "vinfo_key_drm";
    public static final String PLAYER_CFG_KEY_ENCODE_FORCETYPE = "encode_forcetype";
    public static final String PLAYER_CFG_KEY_ENTER_DETAIL_PAGE_TIMESTAMP = "enter_detail_page_timestamp";
    public static final String PLAYER_CFG_KEY_ENTER_MIN_BUFFER_MODE = "min_buffer_mode";
    public static final String PLAYER_CFG_KEY_ENTER_SYSPLAYER_HEVC_CAP = "sysplayer_hevc_cap";
    public static final String PLAYER_CFG_KEY_FILE_TYPE = "file_type";
    public static final String PLAYER_CFG_KEY_FROM_PLATFORM = "vinfo_key_from_platform";
    public static final String PLAYER_CFG_KEY_HISTORY_VID = "historyVid";
    public static final String PLAYER_CFG_KEY_ISFORCEONLINE = "isForceOnline";
    public static final String PLAYER_CFG_KEY_KEEP_LAST_FRAME = "keep_last_frame";
    public static final String PLAYER_CFG_KEY_LIVE_PLAYBACKTIME = "live_playbacktime";
    public static final String PLAYER_CFG_KEY_LIVE_TYPE = "live_type";
    public static final String PLAYER_CFG_KEY_NEXT_CID = "next_cid";
    public static final String PLAYER_CFG_KEY_NEXT_VID = "next_vid";
    public static final String PLAYER_CFG_KEY_PAYTYPE = "paytype";
    public static final String PLAYER_CFG_KEY_PLAYER_FORCETYPE = "player_forcetype";
    public static final String PLAYER_CFG_KEY_PLAYMODE = "playmode";
    public static final String PLAYER_CFG_KEY_PLAY_WINDOW = "play_window";
    public static final String PLAYER_CFG_KEY_PREVID = "vinfo_key_previd";
    public static final String PLAYER_CFG_KEY_SKIP_START_END = "skip_start_end";
    public static final String PLAYER_CFG_KEY_SPAUDIO = "vinfo_key_spaudio";
    public static final String PLAYER_CFG_KEY_SPTEST = "vinfo_key_sptest";
    public static final String PLAYER_CFG_KEY_SPVIDEO = "vinfo_key_spvideo";
    public static final String PLAYER_CFG_KEY_SWITCH_PLAYER = "switch_player";
    public static final String PLAYER_CFG_KEY_TOUSHE = "vinfo_key_toushe";
    public static final String PLAYER_CFG_KEY_USECACHEFLAG = "usecacheflag";
    public static final String PLAYER_CFG_KEY_VIDEO_FRAME_OUTPUT = "video_frame_output";
    public static final String PLAYER_CFG_KEY_VR_VIDEO = "vr_video";
    public static final String PLAYER_CFG_LEY_FLOWID = "flowid";
    public static final String PLAYER_REQ_KEY_DEFN_SRC = "defnsrc";
    public static final String PLAYER_REQ_KEY_LIVEQUEUE = "livequeue";
    public static final String PLAYER_REQ_KEY_LIVE_PID = "livepid";
    public static final String PLAYER_REQ_KEY_MECHINE_ID = "viewid";
    public static final String PLAYER_REQ_KEY_PAGE_ID = "pageId";
    public static final String PLAYER_REQ_KEY_PREVID = "previd";
    public static final String PLAYER_REQ_KEY_PRIVATE_DATA = "extra_data";
    public static final String PLAYER_REQ_KEY_REFER_PAGE_ID = "refer_pageId";
    public static final String PLAYER_REQ_KEY_WAITSECRETKEY = "waitSecretKey";
    public static final String PLAYER_REQ_SCENE_INFORMATION = "scene";
    public static final String PLAYER_SELF_ADAPTIVE_ID = "self_adaptive";
    public static final String PLAYER_SUBTITLE_LANGUANGE_ID = "subtitle_language";
    public static final String QUICK_SWITCH_SURFACE_VIEW = "quick_switch_surface_view";
    private static final long serialVersionUID = -374236133868823816L;
    private int bizId;

    /* renamed from: d, reason: collision with root package name */
    private transient Map<String, Object> f345517d;

    /* renamed from: e, reason: collision with root package name */
    private transient WeakReference<Object> f345518e;
    private Map<String, String> mAdReportInfoMap;
    private Map<String, String> mAdRequestParamMap;
    public int mBusiPlatform;
    private String mCid;
    private Map<String, String> mConfigMap;
    private Map<String, String> mExtraRequestParamsMap;
    private boolean mIsNeedCharge;
    private int mPlayType;
    private Map<String, String> mProxyExtraMap;
    private Map<String, String> mReportInfoMap;
    private String mVid;
    private long mVideoDuration;
    private Map<Integer, Integer> mVideoEditParametersMap;
    private String sessionId;

    public TVKPlayerVideoInfo(int i3, String str, String str2) {
        this.mIsNeedCharge = false;
        this.bizId = 0;
        this.mPlayType = i3;
        this.mVid = str;
        this.mCid = str2;
        a();
    }

    private void a() {
        this.mIsNeedCharge = false;
        this.mAdRequestParamMap = new HashMap();
        this.mExtraRequestParamsMap = new HashMap();
        this.mConfigMap = new HashMap();
        this.mReportInfoMap = new HashMap();
        this.mAdReportInfoMap = new HashMap();
        this.mProxyExtraMap = new HashMap();
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

    public void addProxyExtraMap(String str, String str2) {
        this.mProxyExtraMap.put(str, str2);
    }

    public void addReportInfoMap(String str, String str2) {
        this.mReportInfoMap.put(str, str2);
    }

    public boolean configMapContainsKey(String str) {
        return this.mConfigMap.containsKey(str);
    }

    public Map<String, Object> getAdParamsMap() {
        return this.f345517d;
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

    public int getBizId() {
        return this.bizId;
    }

    public String getCid() {
        return this.mCid;
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

    public Object getExtraObject() {
        WeakReference<Object> weakReference = this.f345518e;
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

    public int getPlatform() {
        return this.mBusiPlatform;
    }

    public int getPlayType() {
        return this.mPlayType;
    }

    public Map<String, String> getProxyExtraMap() {
        return this.mProxyExtraMap;
    }

    public Map<String, String> getReportInfoMap() {
        return this.mReportInfoMap;
    }

    public String getReportInfoValue(String str, String str2) {
        String str3 = this.mReportInfoMap.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getVid() {
        return this.mVid;
    }

    public long getVideoDuration() {
        return this.mVideoDuration;
    }

    public Map<Integer, Integer> getVideoEditParametersMap() {
        return this.mVideoEditParametersMap;
    }

    public boolean isNeedCharge() {
        return this.mIsNeedCharge;
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

    public void removeReportInfoMap(String str) {
        this.mReportInfoMap.remove(str);
    }

    public void setAdParamsMap(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        this.f345517d = map;
    }

    public void setBizId(int i3) {
        this.bizId = i3;
    }

    public void setCid(String str) {
        this.mCid = str;
    }

    public void setExtraObject(Object obj) {
        this.f345518e = null;
        if (obj != null) {
            this.f345518e = new WeakReference<>(obj);
        }
    }

    public void setNeedCharge(boolean z16) {
        this.mIsNeedCharge = z16;
    }

    public void setPid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mPlayType == 1) {
            this.mExtraRequestParamsMap.put("livepid", str);
        }
        if (this.mPlayType == 1) {
            this.mAdRequestParamMap.put("livepid", str);
        }
    }

    public void setPlatform(int i3) {
        this.mBusiPlatform = i3;
    }

    public void setPlayType(int i3) {
        this.mPlayType = i3;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setVid(String str) {
        this.mVid = str;
    }

    public void setVideoDuration(long j3) {
        this.mVideoDuration = j3;
    }

    public void setVideoEditParametersMap(Map<Integer, Integer> map) {
        this.mVideoEditParametersMap = map;
    }

    public void addAdReportInfoMap(Map<String, String> map) {
        this.mAdReportInfoMap.putAll(map);
    }

    public void addAdRequestParamMap(String str, String str2) {
        this.mAdRequestParamMap.put(str, str2);
    }

    public void addReportInfoMap(Map<String, String> map) {
        this.mReportInfoMap.putAll(map);
    }

    public TVKPlayerVideoInfo() {
        this.mIsNeedCharge = false;
        this.bizId = 0;
        this.mVid = "";
        this.mCid = "";
        this.mPlayType = 5;
        a();
    }
}
