package com.tencent.mobileqq.icgame.api.room;

import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AudienceRoomConfig {
    public static final int ROOM_TYPE_GAME = 1;
    public static final int ROOM_TYPE_OD = 2;
    public static final int ROOM_TYPE_YULE = 0;
    public String appId;
    public long maxPlayPreloadDuration;
    public PlayerConfig playerConfig;
    public final IcgRoomPlayerConfig preloadPlayParams;
    public int roomType;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public enum LiveLatencyStrategy {
        NONE(0),
        SPEED_UP(1),
        SKIP_FRAME(2);

        public int action;

        LiveLatencyStrategy(int i3) {
            this.action = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public enum VideoFormat {
        OPENSDK("opensdk"),
        TRTC("trtc"),
        RTMP("rtmp"),
        FLV("flv"),
        HLS(TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS),
        MP4("mp4"),
        FMP4("fmp4"),
        _265("_265"),
        _100("_100");

        public String value;

        VideoFormat(String str) {
            this.value = str;
        }
    }

    public AudienceRoomConfig() {
        this.playerConfig = new PlayerConfig();
        this.maxPlayPreloadDuration = 0L;
        this.roomType = 0;
        this.appId = "-1";
        this.preloadPlayParams = new IcgRoomPlayerConfig();
    }

    public String toString() {
        return "AudienceRoomConfig{, + playerConfig=" + this.playerConfig + ", + maxPlayPreloadDuration=" + this.maxPlayPreloadDuration + ", + roomType=" + this.roomType + ", + appId='" + this.appId + "', + preloadPlayParams=" + this.preloadPlayParams + '}';
    }

    public AudienceRoomConfig(AudienceRoomConfig audienceRoomConfig) {
        this.playerConfig = new PlayerConfig();
        this.maxPlayPreloadDuration = 0L;
        this.roomType = 0;
        this.appId = "-1";
        IcgRoomPlayerConfig icgRoomPlayerConfig = new IcgRoomPlayerConfig();
        this.preloadPlayParams = icgRoomPlayerConfig;
        this.playerConfig = new PlayerConfig(audienceRoomConfig.playerConfig);
        this.maxPlayPreloadDuration = audienceRoomConfig.maxPlayPreloadDuration;
        this.roomType = audienceRoomConfig.roomType;
        icgRoomPlayerConfig.copyFrom(audienceRoomConfig.preloadPlayParams);
    }
}
