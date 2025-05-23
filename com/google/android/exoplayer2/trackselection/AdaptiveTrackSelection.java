package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.tencent.mobileqq.msf.core.s;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_INITIAL_BITRATE = 800000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public static final long DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 2000;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final int maxInitialBitrate;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private final long minTimeBetweenBufferReevaluationMs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Factory implements TrackSelection.Factory {
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final float bufferedFractionToLiveEdgeForQualityIncrease;
        private final Clock clock;
        private final int maxDurationForQualityDecreaseMs;
        private final int maxInitialBitrate;
        private final int minDurationForQualityIncreaseMs;
        private final int minDurationToRetainAfterDiscardMs;
        private final long minTimeBetweenBufferReevaluationMs;

        public Factory(BandwidthMeter bandwidthMeter) {
            this(bandwidthMeter, AdaptiveTrackSelection.DEFAULT_MAX_INITIAL_BITRATE, 10000, 25000, 25000, 0.75f, 0.75f, 2000L, Clock.DEFAULT);
        }

        public Factory(BandwidthMeter bandwidthMeter, int i3, int i16, int i17, int i18, float f16) {
            this(bandwidthMeter, i3, i16, i17, i18, f16, 0.75f, 2000L, Clock.DEFAULT);
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection.Factory
        public AdaptiveTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            return new AdaptiveTrackSelection(trackGroup, iArr, this.bandwidthMeter, this.maxInitialBitrate, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction, this.bufferedFractionToLiveEdgeForQualityIncrease, this.minTimeBetweenBufferReevaluationMs, this.clock);
        }

        public Factory(BandwidthMeter bandwidthMeter, int i3, int i16, int i17, int i18, float f16, float f17, long j3, Clock clock) {
            this.bandwidthMeter = bandwidthMeter;
            this.maxInitialBitrate = i3;
            this.minDurationForQualityIncreaseMs = i16;
            this.maxDurationForQualityDecreaseMs = i17;
            this.minDurationToRetainAfterDiscardMs = i18;
            this.bandwidthFraction = f16;
            this.bufferedFractionToLiveEdgeForQualityIncrease = f17;
            this.minTimeBetweenBufferReevaluationMs = j3;
            this.clock = clock;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter) {
        this(trackGroup, iArr, bandwidthMeter, DEFAULT_MAX_INITIAL_BITRATE, 10000L, s.G, s.G, 0.75f, 0.75f, 2000L, Clock.DEFAULT);
    }

    private int determineIdealSelectedIndex(long j3) {
        long j16;
        long bitrateEstimate = this.bandwidthMeter.getBitrateEstimate();
        if (bitrateEstimate == -1) {
            j16 = this.maxInitialBitrate;
        } else {
            j16 = ((float) bitrateEstimate) * this.bandwidthFraction;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.length; i16++) {
            if (j3 == Long.MIN_VALUE || !isBlacklisted(i16, j3)) {
                if (Math.round(getFormat(i16).bitrate * this.playbackSpeed) <= j16) {
                    return i16;
                }
                i3 = i16;
            }
        }
        return i3;
    }

    private long minDurationForQualityIncreaseUs(long j3) {
        boolean z16;
        if (j3 != -9223372036854775807L && j3 <= this.minDurationForQualityIncreaseUs) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return ((float) j3) * this.bufferedFractionToLiveEdgeForQualityIncrease;
        }
        return this.minDurationForQualityIncreaseUs;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public void enable() {
        this.lastBufferEvaluationMs = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long j3, List<? extends MediaChunk> list) {
        int i3;
        int i16;
        long elapsedRealtime = this.clock.elapsedRealtime();
        long j16 = this.lastBufferEvaluationMs;
        if (j16 != -9223372036854775807L && elapsedRealtime - j16 < this.minTimeBetweenBufferReevaluationMs) {
            return list.size();
        }
        this.lastBufferEvaluationMs = elapsedRealtime;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (Util.getPlayoutDurationForMediaDuration(list.get(size - 1).startTimeUs - j3, this.playbackSpeed) < this.minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(elapsedRealtime));
        for (int i17 = 0; i17 < size; i17++) {
            MediaChunk mediaChunk = list.get(i17);
            Format format2 = mediaChunk.trackFormat;
            if (Util.getPlayoutDurationForMediaDuration(mediaChunk.startTimeUs - j3, this.playbackSpeed) >= this.minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i3 = format2.height) != -1 && i3 < 720 && (i16 = format2.width) != -1 && i16 < 1280 && i3 < format.height) {
                return i17;
            }
        }
        return size;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public Object getSelectionData() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override // com.google.android.exoplayer2.trackselection.BaseTrackSelection, com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float f16) {
        this.playbackSpeed = f16;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelection
    public void updateSelectedTrack(long j3, long j16, long j17) {
        long elapsedRealtime = this.clock.elapsedRealtime();
        int i3 = this.selectedIndex;
        int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime);
        this.selectedIndex = determineIdealSelectedIndex;
        if (determineIdealSelectedIndex == i3) {
            return;
        }
        if (!isBlacklisted(i3, elapsedRealtime)) {
            Format format = getFormat(i3);
            Format format2 = getFormat(this.selectedIndex);
            if (format2.bitrate > format.bitrate && j16 < minDurationForQualityIncreaseUs(j17)) {
                this.selectedIndex = i3;
            } else if (format2.bitrate < format.bitrate && j16 >= this.maxDurationForQualityDecreaseUs) {
                this.selectedIndex = i3;
            }
        }
        if (this.selectedIndex != i3) {
            this.reason = 3;
        }
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, BandwidthMeter bandwidthMeter, int i3, long j3, long j16, long j17, float f16, float f17, long j18, Clock clock) {
        super(trackGroup, iArr);
        this.bandwidthMeter = bandwidthMeter;
        this.maxInitialBitrate = i3;
        this.minDurationForQualityIncreaseUs = j3 * 1000;
        this.maxDurationForQualityDecreaseUs = j16 * 1000;
        this.minDurationToRetainAfterDiscardUs = j17 * 1000;
        this.bandwidthFraction = f16;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f17;
        this.minTimeBetweenBufferReevaluationMs = j18;
        this.clock = clock;
        this.playbackSpeed = 1.0f;
        this.selectedIndex = determineIdealSelectedIndex(Long.MIN_VALUE);
        this.reason = 1;
        this.lastBufferEvaluationMs = -9223372036854775807L;
    }
}
