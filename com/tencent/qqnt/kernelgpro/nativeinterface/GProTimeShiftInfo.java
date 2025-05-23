package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTimeShiftInfo {
    public Long curPlaybackDuration;
    public Long liveBeginTimeStamp;
    public Long maxPlaybackDuration;
    public Long playbackDistance;
    public String url;

    public Long getCurPlaybackDuration() {
        return this.curPlaybackDuration;
    }

    public Long getLiveBeginTimeStamp() {
        return this.liveBeginTimeStamp;
    }

    public Long getMaxPlaybackDuration() {
        return this.maxPlaybackDuration;
    }

    public Long getPlaybackDistance() {
        return this.playbackDistance;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProTimeShiftInfo{url=" + this.url + ",playbackDistance=" + this.playbackDistance + ",maxPlaybackDuration=" + this.maxPlaybackDuration + ",curPlaybackDuration=" + this.curPlaybackDuration + ",liveBeginTimeStamp=" + this.liveBeginTimeStamp + ",}";
    }
}
