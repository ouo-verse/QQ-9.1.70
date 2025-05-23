package com.tencent.qqlive.tvkplayer.api;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes23.dex */
public interface ITVKPlayerEventListener {
    public static final String KEY_AD_DURATION = "adduration";
    public static final String KEY_AD_TYPE = "adtype";
    public static final String KEY_DEFINITION = "definition";
    public static final String KEY_EXTRA_PARAM_MAP = "extra_param_map";
    public static final String KEY_NET_VIDEO_INFO = "TVKNetVideoInfo";
    public static final String KEY_SKIP_END_MILSEC = "skipEndMilsec";
    public static final String KEY_START_POSITION_MILSEC = "startPositionMilsec";
    public static final String KEY_TVKPLAYERVIDEOINFO = "TVKPlayerVideoInfo";
    public static final String KEY_TVKPROPERTIES = "TVKProperties";
    public static final String KEY_URL = "url";
    public static final String KEY_USER_INFO = "userInfo";
    public static final String KEY_VIDEO_DURATION = "videoDuration";

    /* loaded from: classes23.dex */
    public enum AdType {
        AD_TYPE_UNKNOWN,
        AD_TYPE_PREAD,
        AD_TYPE_MIDAD,
        AD_TYPE_POSTAD
    }

    /* loaded from: classes23.dex */
    public enum PlayerEvent {
        PLAYER_EVENT_UNKNOWN,
        PLAYER_EVENT_OPEN_MEDIA,
        PLAYER_EVENT_AD_PREPARING,
        PLAYER_EVENT_AD_PREPARED,
        PLAYER_EVENT_AD_PLAYING,
        PLAYER_EVENT_AD_PAUSED,
        PLAYER_EVENT_AD_STOPED,
        PLAYER_EVENT_AD_COMPLETE,
        PLAYER_EVENT_AD_ERROR,
        PLAYER_EVENT_VIDEO_PREPARING,
        PLAYER_EVENT_VIDEO_PREPARED,
        PLAYER_EVENT_VIDEO_PLAYING,
        PLAYER_EVENT_VIDEO_PAUSED,
        PLAYER_EVENT_VIDEO_STOPED,
        PLAYER_EVENT_VIDEO_COMPLETE,
        PLAYER_EVENT_VIDEO_ERROR,
        PLAYER_EVENT_UPDATE_REPORT_PARAM,
        PLAYER_EVENT_CGI_RECEIVED,
        PLAYER_EVENT_FIRST_VIDEO_FRAME_RENDERED,
        PLAYER_EVENT_AUDIO_TRACK_SWITCH_END,
        PLAYER_EVENT_SWITCH_DEFINITION_END,
        PLAYER_EVENT_ADD_EXTRA_REPORT_PARAM
    }

    void onPlayerEvent(ITVKMediaPlayer iTVKMediaPlayer, PlayerEvent playerEvent, EventParams eventParams);

    /* loaded from: classes23.dex */
    public static class EventParams {
        protected long currentPosMs;
        protected long eventTime;
        protected HashMap<String, Object> extraParam;
        protected String flowId;

        public long getCurrentPos() {
            return this.currentPosMs;
        }

        public long getEventTime() {
            return this.eventTime;
        }

        public String getFlowId() {
            return this.flowId;
        }

        public Object getParamByKey(String str) {
            HashMap<String, Object> hashMap = this.extraParam;
            if (hashMap == null || hashMap.isEmpty() || TextUtils.isEmpty(str) || !this.extraParam.containsKey(str)) {
                return null;
            }
            return this.extraParam.get(str);
        }

        public Object getParamByKey(String str, Object obj) {
            HashMap<String, Object> hashMap = this.extraParam;
            return (hashMap == null || hashMap.isEmpty() || TextUtils.isEmpty(str) || !this.extraParam.containsKey(str)) ? obj : this.extraParam.get(str);
        }
    }
}
