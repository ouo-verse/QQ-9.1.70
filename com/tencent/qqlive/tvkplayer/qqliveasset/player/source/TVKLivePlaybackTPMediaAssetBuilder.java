package com.tencent.qqlive.tvkplayer.qqliveasset.player.source;

import android.os.SystemClock;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKSeekForLiveUtil;

/* loaded from: classes23.dex */
public class TVKLivePlaybackTPMediaAssetBuilder extends TVKLiveTPMediaAssetBuilder {
    private long mElapsedRealTimeOnGetCgiPlaybackUrlMs = 0;
    private long mPlaybackPositionSec = 0;

    protected TVKLivePlaybackTPMediaAssetBuilder() {
    }

    public static TVKLivePlaybackTPMediaAssetBuilder newBuilder() {
        return new TVKLivePlaybackTPMediaAssetBuilder();
    }

    public TVKLivePlaybackTPMediaAssetBuilder elapsedRealTimeOnGetCgiPlaybackUrlMs(long j3) {
        this.mElapsedRealTimeOnGetCgiPlaybackUrlMs = j3;
        return this;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.TVKLiveTPMediaAssetBuilder
    protected void initPlayableUrls() {
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mElapsedRealTimeOnGetCgiPlaybackUrlMs) / 1000;
        this.mPlayableUrl = TVKSeekForLiveUtil.generateUrl(this.mLiveVideoInfo.getPlayUrl(), elapsedRealtime, this.mPlaybackPositionSec, this.mLiveVideoInfo.getPlayBackTimeSec());
        this.mPlayableBackupUrls = TVKSeekForLiveUtil.generateUrls(this.mLiveVideoInfo.getBackPlayUrl(), elapsedRealtime, this.mPlaybackPositionSec, this.mLiveVideoInfo.getPlayBackTimeSec());
    }

    public TVKLivePlaybackTPMediaAssetBuilder playbackPositionSec(long j3) {
        this.mPlaybackPositionSec = j3;
        return this;
    }
}
