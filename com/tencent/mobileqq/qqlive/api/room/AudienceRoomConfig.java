package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.tavcut.core.render.exporter.MovieExporter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AudienceRoomConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int ROOM_TYPE_GAME = 1;
    public static final int ROOM_TYPE_OD = 2;
    public static final int ROOM_TYPE_YULE = 0;
    public String appId;
    public boolean isNeedPlayer;
    public long maxPlayPreloadDuration;
    public PlayerConfig playerConfig;
    public long roomId;
    public int roomType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class LiveLatencyStrategy {
        private static final /* synthetic */ LiveLatencyStrategy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final LiveLatencyStrategy NONE;
        public static final LiveLatencyStrategy SKIP_FRAME;
        public static final LiveLatencyStrategy SPEED_UP;
        public int action;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46260);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            LiveLatencyStrategy liveLatencyStrategy = new LiveLatencyStrategy("NONE", 0, 0);
            NONE = liveLatencyStrategy;
            LiveLatencyStrategy liveLatencyStrategy2 = new LiveLatencyStrategy("SPEED_UP", 1, 1);
            SPEED_UP = liveLatencyStrategy2;
            LiveLatencyStrategy liveLatencyStrategy3 = new LiveLatencyStrategy("SKIP_FRAME", 2, 2);
            SKIP_FRAME = liveLatencyStrategy3;
            $VALUES = new LiveLatencyStrategy[]{liveLatencyStrategy, liveLatencyStrategy2, liveLatencyStrategy3};
        }

        LiveLatencyStrategy(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.action = i16;
            }
        }

        public static LiveLatencyStrategy valueOf(String str) {
            return (LiveLatencyStrategy) Enum.valueOf(LiveLatencyStrategy.class, str);
        }

        public static LiveLatencyStrategy[] values() {
            return (LiveLatencyStrategy[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class VideoFormat {
        private static final /* synthetic */ VideoFormat[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final VideoFormat FLV;
        public static final VideoFormat FMP4;
        public static final VideoFormat HLS;
        public static final VideoFormat MP4;
        public static final VideoFormat OPENSDK;
        public static final VideoFormat RTMP;
        public static final VideoFormat TRTC;
        public static final VideoFormat _100;
        public static final VideoFormat _265;
        public String value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46261);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            VideoFormat videoFormat = new VideoFormat("OPENSDK", 0, "opensdk");
            OPENSDK = videoFormat;
            VideoFormat videoFormat2 = new VideoFormat("TRTC", 1, "trtc");
            TRTC = videoFormat2;
            VideoFormat videoFormat3 = new VideoFormat("RTMP", 2, "rtmp");
            RTMP = videoFormat3;
            VideoFormat videoFormat4 = new VideoFormat("FLV", 3, "flv");
            FLV = videoFormat4;
            VideoFormat videoFormat5 = new VideoFormat("HLS", 4, TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS);
            HLS = videoFormat5;
            VideoFormat videoFormat6 = new VideoFormat(MovieExporter.FILE_TYPE, 5, "mp4");
            MP4 = videoFormat6;
            VideoFormat videoFormat7 = new VideoFormat("FMP4", 6, "fmp4");
            FMP4 = videoFormat7;
            VideoFormat videoFormat8 = new VideoFormat("_265", 7, "_265");
            _265 = videoFormat8;
            VideoFormat videoFormat9 = new VideoFormat("_100", 8, "_100");
            _100 = videoFormat9;
            $VALUES = new VideoFormat[]{videoFormat, videoFormat2, videoFormat3, videoFormat4, videoFormat5, videoFormat6, videoFormat7, videoFormat8, videoFormat9};
        }

        VideoFormat(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.value = str2;
            }
        }

        public static VideoFormat valueOf(String str) {
            return (VideoFormat) Enum.valueOf(VideoFormat.class, str);
        }

        public static VideoFormat[] values() {
            return (VideoFormat[]) $VALUES.clone();
        }
    }

    public AudienceRoomConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isNeedPlayer = true;
        this.playerConfig = new PlayerConfig();
        this.maxPlayPreloadDuration = 0L;
        this.roomType = 0;
        this.appId = "-1";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AudienceRoomConfig{isNeedPlayer=" + this.isNeedPlayer + ", playerConfig=" + this.playerConfig + ", maxPlayPreloadDuration=" + this.maxPlayPreloadDuration + ", roomId=" + this.roomId + ", roomType=" + this.roomType + '}';
    }

    public AudienceRoomConfig(AudienceRoomConfig audienceRoomConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) audienceRoomConfig);
            return;
        }
        this.isNeedPlayer = true;
        this.playerConfig = new PlayerConfig();
        this.maxPlayPreloadDuration = 0L;
        this.roomType = 0;
        this.appId = "-1";
        this.isNeedPlayer = audienceRoomConfig.isNeedPlayer;
        this.playerConfig = new PlayerConfig(audienceRoomConfig.playerConfig);
        this.maxPlayPreloadDuration = audienceRoomConfig.maxPlayPreloadDuration;
        this.roomType = audienceRoomConfig.roomType;
        this.roomId = audienceRoomConfig.roomId;
    }
}
