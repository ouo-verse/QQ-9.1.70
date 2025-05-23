package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
final class MediaPeriodQueue {
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private Timeline timeline;
    private final Timeline.Period period = new Timeline.Period();
    private final Timeline.Window window = new Timeline.Window();

    private boolean canKeepMediaPeriodHolder(MediaPeriodHolder mediaPeriodHolder, MediaPeriodInfo mediaPeriodInfo) {
        MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.info;
        if (mediaPeriodInfo2.startPositionUs == mediaPeriodInfo.startPositionUs && mediaPeriodInfo2.endPositionUs == mediaPeriodInfo.endPositionUs && mediaPeriodInfo2.f32937id.equals(mediaPeriodInfo.f32937id)) {
            return true;
        }
        return false;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.periodId, playbackInfo.contentPositionUs, playbackInfo.startPositionUs);
    }

    @Nullable
    private MediaPeriodInfo getFollowingMediaPeriodInfo(MediaPeriodHolder mediaPeriodHolder, long j3) {
        int i3;
        long j16;
        long j17;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            int nextPeriodIndex = this.timeline.getNextPeriodIndex(mediaPeriodInfo.f32937id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i16 = this.timeline.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
            Object obj = this.period.uid;
            long j18 = mediaPeriodInfo.f32937id.windowSequenceNumber;
            long j19 = 0;
            if (this.timeline.getWindow(i16, this.window).firstPeriodIndex == nextPeriodIndex) {
                Pair<Integer, Long> periodPosition = this.timeline.getPeriodPosition(this.window, this.period, i16, -9223372036854775807L, Math.max(0L, (mediaPeriodHolder.getRendererOffset() + mediaPeriodInfo.durationUs) - j3));
                if (periodPosition == null) {
                    return null;
                }
                int intValue = ((Integer) periodPosition.first).intValue();
                long longValue = ((Long) periodPosition.second).longValue();
                MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder.next;
                if (mediaPeriodHolder2 != null && mediaPeriodHolder2.uid.equals(obj)) {
                    j17 = mediaPeriodHolder.next.info.f32937id.windowSequenceNumber;
                } else {
                    j17 = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + j17;
                }
                j19 = longValue;
                j16 = j17;
                i3 = intValue;
            } else {
                i3 = nextPeriodIndex;
                j16 = j18;
            }
            long j26 = j19;
            return getMediaPeriodInfo(resolveMediaPeriodIdForAds(i3, j26, j16), j26, j19);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f32937id;
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (mediaPeriodId.isAd()) {
            int i17 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i17);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i17, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay < adCountInAdGroup) {
                if (!this.period.isAdAvailable(i17, nextAdIndexToPlay)) {
                    return null;
                }
                return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i17, nextAdIndexToPlay, mediaPeriodInfo.contentPositionUs, mediaPeriodId.windowSequenceNumber);
            }
            return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, mediaPeriodInfo.contentPositionUs, mediaPeriodId.windowSequenceNumber);
        }
        long j27 = mediaPeriodInfo.endPositionUs;
        if (j27 != Long.MIN_VALUE) {
            int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j27);
            if (adGroupIndexForPositionUs == -1) {
                return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, mediaPeriodInfo.endPositionUs, mediaPeriodId.windowSequenceNumber);
            }
            int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs);
            if (!this.period.isAdAvailable(adGroupIndexForPositionUs, firstAdIndexToPlay)) {
                return null;
            }
            return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, adGroupIndexForPositionUs, firstAdIndexToPlay, mediaPeriodInfo.endPositionUs, mediaPeriodId.windowSequenceNumber);
        }
        int adGroupCount = this.period.getAdGroupCount();
        if (adGroupCount == 0) {
            return null;
        }
        int i18 = adGroupCount - 1;
        if (this.period.getAdGroupTimeUs(i18) != Long.MIN_VALUE || this.period.hasPlayedAdGroup(i18)) {
            return null;
        }
        int firstAdIndexToPlay2 = this.period.getFirstAdIndexToPlay(i18);
        if (!this.period.isAdAvailable(i18, firstAdIndexToPlay2)) {
            return null;
        }
        return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, i18, firstAdIndexToPlay2, this.period.getDurationUs(), mediaPeriodId.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j3, long j16) {
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (mediaPeriodId.isAd()) {
            if (!this.period.isAdAvailable(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup)) {
                return null;
            }
            return getMediaPeriodInfoForAd(mediaPeriodId.periodIndex, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, j3, mediaPeriodId.windowSequenceNumber);
        }
        return getMediaPeriodInfoForContent(mediaPeriodId.periodIndex, j16, mediaPeriodId.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(int i3, int i16, int i17, long j3, long j16) {
        long j17;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i3, i16, i17, j16);
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, Long.MIN_VALUE);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        long adDurationUs = this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        if (i17 == this.period.getFirstAdIndexToPlay(i16)) {
            j17 = this.period.getAdResumePositionUs();
        } else {
            j17 = 0;
        }
        return new MediaPeriodInfo(mediaPeriodId, j17, Long.MIN_VALUE, j3, adDurationUs, isLastInPeriod, isLastInTimeline);
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(int i3, long j3, long j16) {
        long adGroupTimeUs;
        long j17;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(i3, j16);
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j3);
        if (adGroupIndexAfterPositionUs == -1) {
            adGroupTimeUs = Long.MIN_VALUE;
        } else {
            adGroupTimeUs = this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
        }
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, adGroupTimeUs);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        if (adGroupTimeUs == Long.MIN_VALUE) {
            j17 = this.period.getDurationUs();
        } else {
            j17 = adGroupTimeUs;
        }
        return new MediaPeriodInfo(mediaPeriodId, j3, adGroupTimeUs, -9223372036854775807L, j17, isLastInPeriod, isLastInTimeline);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId, long j3) {
        boolean z16;
        int adGroupCount = this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).getAdGroupCount();
        if (adGroupCount == 0) {
            return true;
        }
        int i3 = adGroupCount - 1;
        boolean isAd = mediaPeriodId.isAd();
        if (this.period.getAdGroupTimeUs(i3) != Long.MIN_VALUE) {
            if (!isAd && j3 == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }
        int adCountInAdGroup = this.period.getAdCountInAdGroup(i3);
        if (adCountInAdGroup == -1) {
            return false;
        }
        if (isAd && mediaPeriodId.adGroupIndex == i3 && mediaPeriodId.adIndexInAdGroup == adCountInAdGroup - 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (!isAd && this.period.getFirstAdIndexToPlay(i3) == adCountInAdGroup) {
            return true;
        }
        return false;
    }

    private boolean isLastInTimeline(MediaSource.MediaPeriodId mediaPeriodId, boolean z16) {
        if (!this.timeline.getWindow(this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period).windowIndex, this.window).isDynamic && this.timeline.isLastPeriod(mediaPeriodId.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z16) {
            return true;
        }
        return false;
    }

    private long resolvePeriodIndexToWindowSequenceNumber(int i3) {
        Object obj = this.timeline.getPeriod(i3, this.period, true).uid;
        for (MediaPeriodHolder frontPeriod = getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            if (frontPeriod.uid.equals(obj)) {
                return frontPeriod.info.f32937id.windowSequenceNumber;
            }
        }
        int i16 = this.period.windowIndex;
        for (MediaPeriodHolder frontPeriod2 = getFrontPeriod(); frontPeriod2 != null; frontPeriod2 = frontPeriod2.next) {
            int indexOfPeriod = this.timeline.getIndexOfPeriod(frontPeriod2.uid);
            if (indexOfPeriod != -1 && this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i16) {
                return frontPeriod2.info.f32937id.windowSequenceNumber;
            }
        }
        long j3 = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j3;
        return j3;
    }

    private boolean updateForPlaybackModeChange() {
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder frontPeriod = getFrontPeriod();
        if (frontPeriod == null) {
            return true;
        }
        while (true) {
            int nextPeriodIndex = this.timeline.getNextPeriodIndex(frontPeriod.info.f32937id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (true) {
                mediaPeriodHolder = frontPeriod.next;
                if (mediaPeriodHolder == null || frontPeriod.info.isLastInTimelinePeriod) {
                    break;
                }
                frontPeriod = mediaPeriodHolder;
            }
            if (nextPeriodIndex == -1 || mediaPeriodHolder == null || mediaPeriodHolder.info.f32937id.periodIndex != nextPeriodIndex) {
                break;
            }
            frontPeriod = mediaPeriodHolder;
        }
        boolean removeAfter = removeAfter(frontPeriod);
        MediaPeriodInfo mediaPeriodInfo = frontPeriod.info;
        frontPeriod.info = getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.f32937id);
        if (!removeAfter || !hasPlayingPeriod()) {
            return true;
        }
        return false;
    }

    public MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder != null) {
            if (mediaPeriodHolder == this.reading) {
                this.reading = mediaPeriodHolder.next;
            }
            mediaPeriodHolder.release();
            this.playing = this.playing.next;
            int i3 = this.length - 1;
            this.length = i3;
            if (i3 == 0) {
                this.loading = null;
            }
        } else {
            MediaPeriodHolder mediaPeriodHolder2 = this.loading;
            this.playing = mediaPeriodHolder2;
            this.reading = mediaPeriodHolder2;
        }
        return this.playing;
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        boolean z16;
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        if (mediaPeriodHolder != null && mediaPeriodHolder.next != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        MediaPeriodHolder mediaPeriodHolder2 = this.reading.next;
        this.reading = mediaPeriodHolder2;
        return mediaPeriodHolder2;
    }

    public void clear() {
        MediaPeriodHolder frontPeriod = getFrontPeriod();
        if (frontPeriod != null) {
            frontPeriod.release();
            removeAfter(frontPeriod);
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
    }

    public MediaPeriod enqueueNextMediaPeriod(RendererCapabilities[] rendererCapabilitiesArr, long j3, TrackSelector trackSelector, Allocator allocator, MediaSource mediaSource, Object obj, MediaPeriodInfo mediaPeriodInfo) {
        long rendererOffset;
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            rendererOffset = mediaPeriodInfo.startPositionUs + j3;
        } else {
            rendererOffset = mediaPeriodHolder.getRendererOffset() + this.loading.info.durationUs;
        }
        MediaPeriodHolder mediaPeriodHolder2 = new MediaPeriodHolder(rendererCapabilitiesArr, rendererOffset, trackSelector, allocator, mediaSource, obj, mediaPeriodInfo);
        if (this.loading != null) {
            Assertions.checkState(hasPlayingPeriod());
            this.loading.next = mediaPeriodHolder2;
        }
        this.loading = mediaPeriodHolder2;
        this.length++;
        return mediaPeriodHolder2.mediaPeriod;
    }

    public MediaPeriodHolder getFrontPeriod() {
        if (hasPlayingPeriod()) {
            return this.playing;
        }
        return this.loading;
    }

    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    @Nullable
    public MediaPeriodInfo getNextMediaPeriodInfo(long j3, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(mediaPeriodHolder, j3);
    }

    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, int i3) {
        return getUpdatedMediaPeriodInfo(mediaPeriodInfo, mediaPeriodInfo.f32937id.copyWithPeriodIndex(i3));
    }

    public TrackSelectorResult handleLoadingPeriodPrepared(float f16) throws ExoPlaybackException {
        return this.loading.handlePrepared(f16);
    }

    public boolean hasPlayingPeriod() {
        if (this.playing != null) {
            return true;
        }
        return false;
    }

    public boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod) {
            return true;
        }
        return false;
    }

    public void reevaluateBuffer(long j3) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(j3);
        }
    }

    public boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        boolean z16;
        boolean z17 = false;
        if (mediaPeriodHolder != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.loading = mediaPeriodHolder;
        while (true) {
            mediaPeriodHolder = mediaPeriodHolder.next;
            if (mediaPeriodHolder != null) {
                if (mediaPeriodHolder == this.reading) {
                    this.reading = this.playing;
                    z17 = true;
                }
                mediaPeriodHolder.release();
                this.length--;
            } else {
                this.loading.next = null;
                return z17;
            }
        }
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(int i3, long j3) {
        return resolveMediaPeriodIdForAds(i3, j3, resolvePeriodIndexToWindowSequenceNumber(i3));
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null && (mediaPeriodHolder.info.isFinal || !mediaPeriodHolder.isFullyBuffered() || this.loading.info.durationUs == -9223372036854775807L || this.length >= 100)) {
            return false;
        }
        return true;
    }

    public boolean updateQueuedPeriods(MediaSource.MediaPeriodId mediaPeriodId, long j3) {
        int i3 = mediaPeriodId.periodIndex;
        MediaPeriodHolder mediaPeriodHolder = null;
        int i16 = i3;
        for (MediaPeriodHolder frontPeriod = getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.next) {
            if (mediaPeriodHolder == null) {
                frontPeriod.info = getUpdatedMediaPeriodInfo(frontPeriod.info, i16);
            } else if (i16 != -1 && frontPeriod.uid.equals(this.timeline.getPeriod(i16, this.period, true).uid)) {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(mediaPeriodHolder, j3);
                if (followingMediaPeriodInfo == null) {
                    return true ^ removeAfter(mediaPeriodHolder);
                }
                frontPeriod.info = getUpdatedMediaPeriodInfo(frontPeriod.info, i16);
                if (!canKeepMediaPeriodHolder(frontPeriod, followingMediaPeriodInfo)) {
                    return true ^ removeAfter(mediaPeriodHolder);
                }
            } else {
                return true ^ removeAfter(mediaPeriodHolder);
            }
            if (frontPeriod.info.isLastInTimelinePeriod) {
                i16 = this.timeline.getNextPeriodIndex(i16, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            }
            mediaPeriodHolder = frontPeriod;
        }
        return true;
    }

    public boolean updateRepeatMode(int i3) {
        this.repeatMode = i3;
        return updateForPlaybackModeChange();
    }

    public boolean updateShuffleModeEnabled(boolean z16) {
        this.shuffleModeEnabled = z16;
        return updateForPlaybackModeChange();
    }

    private MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(int i3, long j3, long j16) {
        this.timeline.getPeriod(i3, this.period);
        int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(j3);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(i3, j16);
        }
        return new MediaSource.MediaPeriodId(i3, adGroupIndexForPositionUs, this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j16);
    }

    private MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo mediaPeriodInfo, MediaSource.MediaPeriodId mediaPeriodId) {
        long j3;
        long durationUs;
        long j16 = mediaPeriodInfo.startPositionUs;
        long j17 = mediaPeriodInfo.endPositionUs;
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId, j17);
        boolean isLastInTimeline = isLastInTimeline(mediaPeriodId, isLastInPeriod);
        this.timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        if (mediaPeriodId.isAd()) {
            durationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else if (j17 == Long.MIN_VALUE) {
            durationUs = this.period.getDurationUs();
        } else {
            j3 = j17;
            return new MediaPeriodInfo(mediaPeriodId, j16, j17, mediaPeriodInfo.contentPositionUs, j3, isLastInPeriod, isLastInTimeline);
        }
        j3 = durationUs;
        return new MediaPeriodInfo(mediaPeriodId, j16, j17, mediaPeriodInfo.contentPositionUs, j3, isLastInPeriod, isLastInTimeline);
    }
}
