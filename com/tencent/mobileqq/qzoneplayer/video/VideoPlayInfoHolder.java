package com.tencent.mobileqq.qzoneplayer.video;

/* loaded from: classes35.dex */
public class VideoPlayInfoHolder {
    public static final int ERR_TYPE_DOWNLOAD = 1;
    public static final int ERR_TYPE_NOERR = -1;
    public static final int ERR_TYPE_PLAYER = 0;
    public long _livePlayStalledDurationMills;
    public long _livePlayStartTimestamp;
    public int bufferedPercent;
    public long currentPositionMills;
    public long currentPositionMillsOrigStream;
    public long currentPositionSec;
    public boolean isLightspot;
    public long lastValidPositionMills;
    public long livePlayDurationMills;
    public long totalDurationMills;
    public long totalDurationSec;
    public String videoId;
    public long hadPlayedRounds = 0;
    public long startPlayingPositionMills = 0;
    public boolean isNeverPlayed = true;
    public long errorType = -1;
    public String errorDetail = "";

    public static VideoPlayInfoHolder shallowCopy(VideoPlayInfoHolder videoPlayInfoHolder) {
        if (videoPlayInfoHolder == null) {
            return null;
        }
        VideoPlayInfoHolder videoPlayInfoHolder2 = new VideoPlayInfoHolder();
        videoPlayInfoHolder2.currentPositionMills = videoPlayInfoHolder.currentPositionMills;
        videoPlayInfoHolder2.currentPositionSec = videoPlayInfoHolder.currentPositionSec;
        videoPlayInfoHolder2.totalDurationMills = videoPlayInfoHolder.totalDurationMills;
        videoPlayInfoHolder2.bufferedPercent = videoPlayInfoHolder.bufferedPercent;
        videoPlayInfoHolder2.totalDurationSec = videoPlayInfoHolder.totalDurationSec;
        videoPlayInfoHolder2.hadPlayedRounds = videoPlayInfoHolder.hadPlayedRounds;
        videoPlayInfoHolder2.lastValidPositionMills = videoPlayInfoHolder.lastValidPositionMills;
        videoPlayInfoHolder2.startPlayingPositionMills = videoPlayInfoHolder.startPlayingPositionMills;
        videoPlayInfoHolder2.isNeverPlayed = videoPlayInfoHolder.isNeverPlayed;
        videoPlayInfoHolder2.videoId = videoPlayInfoHolder.videoId;
        return videoPlayInfoHolder2;
    }
}
