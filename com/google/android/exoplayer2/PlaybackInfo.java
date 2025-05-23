package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;

/* loaded from: classes2.dex */
final class PlaybackInfo {
    public volatile long bufferedPositionUs;
    public final long contentPositionUs;
    public final boolean isLoading;

    @Nullable
    public final Object manifest;
    public final MediaSource.MediaPeriodId periodId;
    public final int playbackState;
    public volatile long positionUs;
    public final long startPositionUs;
    public final Timeline timeline;
    public final TrackSelectorResult trackSelectorResult;

    public PlaybackInfo(Timeline timeline, long j3, TrackSelectorResult trackSelectorResult) {
        this(timeline, null, new MediaSource.MediaPeriodId(0), j3, -9223372036854775807L, 1, false, trackSelectorResult);
    }

    private static void copyMutablePositions(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2) {
        playbackInfo2.positionUs = playbackInfo.positionUs;
        playbackInfo2.bufferedPositionUs = playbackInfo.bufferedPositionUs;
    }

    public PlaybackInfo copyWithIsLoading(boolean z16) {
        PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, z16, this.trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public PlaybackInfo copyWithPeriodIndex(int i3) {
        PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId.copyWithPeriodIndex(i3), this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public PlaybackInfo copyWithPlaybackState(int i3) {
        PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, i3, this.isLoading, this.trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public PlaybackInfo copyWithTimeline(Timeline timeline, Object obj) {
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline, obj, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public PlaybackInfo copyWithTrackSelectorResult(TrackSelectorResult trackSelectorResult) {
        PlaybackInfo playbackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, trackSelectorResult);
        copyMutablePositions(this, playbackInfo);
        return playbackInfo;
    }

    public PlaybackInfo fromNewPosition(MediaSource.MediaPeriodId mediaPeriodId, long j3, long j16) {
        long j17;
        Timeline timeline = this.timeline;
        Object obj = this.manifest;
        if (mediaPeriodId.isAd()) {
            j17 = j16;
        } else {
            j17 = -9223372036854775807L;
        }
        return new PlaybackInfo(timeline, obj, mediaPeriodId, j3, j17, this.playbackState, this.isLoading, this.trackSelectorResult);
    }

    public PlaybackInfo(Timeline timeline, @Nullable Object obj, MediaSource.MediaPeriodId mediaPeriodId, long j3, long j16, int i3, boolean z16, TrackSelectorResult trackSelectorResult) {
        this.timeline = timeline;
        this.manifest = obj;
        this.periodId = mediaPeriodId;
        this.startPositionUs = j3;
        this.contentPositionUs = j16;
        this.positionUs = j3;
        this.bufferedPositionUs = j3;
        this.playbackState = i3;
        this.isLoading = z16;
        this.trackSelectorResult = trackSelectorResult;
    }
}
