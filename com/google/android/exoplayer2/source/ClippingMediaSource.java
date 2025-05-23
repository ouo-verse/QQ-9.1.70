package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ClippingMediaSource extends CompositeMediaSource<Void> {
    private IllegalClippingException clippingError;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private final ArrayList<ClippingMediaPeriod> mediaPeriods;
    private final MediaSource mediaSource;
    private MediaSource.Listener sourceListener;
    private final long startUs;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ClippingTimeline extends ForwardingTimeline {
        private final long endUs;
        private final long startUs;

        public ClippingTimeline(Timeline timeline, long j3, long j16) throws IllegalClippingException {
            super(timeline);
            if (timeline.getPeriodCount() == 1) {
                if (timeline.getPeriod(0, new Timeline.Period()).getPositionInWindowUs() == 0) {
                    Timeline.Window window = timeline.getWindow(0, new Timeline.Window(), false);
                    j16 = j16 == Long.MIN_VALUE ? window.durationUs : j16;
                    long j17 = window.durationUs;
                    if (j17 != -9223372036854775807L) {
                        j16 = j16 > j17 ? j17 : j16;
                        if (j3 != 0 && !window.isSeekable) {
                            throw new IllegalClippingException(2);
                        }
                        if (j3 > j16) {
                            throw new IllegalClippingException(3);
                        }
                    }
                    this.startUs = j3;
                    this.endUs = j16;
                    return;
                }
                throw new IllegalClippingException(1);
            }
            throw new IllegalClippingException(0);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i3, Timeline.Period period, boolean z16) {
            Timeline.Period period2 = this.timeline.getPeriod(0, period, z16);
            long j3 = this.endUs;
            long j16 = -9223372036854775807L;
            if (j3 != -9223372036854775807L) {
                j16 = j3 - this.startUs;
            }
            period2.durationUs = j16;
            return period2;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i3, Timeline.Window window, boolean z16, long j3) {
            long j16;
            Timeline.Window window2 = this.timeline.getWindow(0, window, z16, j3);
            long j17 = this.endUs;
            if (j17 != -9223372036854775807L) {
                j16 = j17 - this.startUs;
            } else {
                j16 = -9223372036854775807L;
            }
            window2.durationUs = j16;
            long j18 = window2.defaultPositionUs;
            if (j18 != -9223372036854775807L) {
                long max = Math.max(j18, this.startUs);
                window2.defaultPositionUs = max;
                long j19 = this.endUs;
                if (j19 != -9223372036854775807L) {
                    max = Math.min(max, j19);
                }
                window2.defaultPositionUs = max - this.startUs;
            }
            long usToMs = C.usToMs(this.startUs);
            long j26 = window2.presentationStartTimeMs;
            if (j26 != -9223372036854775807L) {
                window2.presentationStartTimeMs = j26 + usToMs;
            }
            long j27 = window2.windowStartTimeMs;
            if (j27 != -9223372036854775807L) {
                window2.windowStartTimeMs = j27 + usToMs;
            }
            return window2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 2;
        public static final int REASON_PERIOD_OFFSET_IN_WINDOW = 1;
        public static final int REASON_START_EXCEEDS_END = 3;
        public final int reason;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Reason {
        }

        public IllegalClippingException(int i3) {
            this.reason = i3;
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j3, long j16) {
        this(mediaSource, j3, j16, true);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator), this.enableInitialDiscontinuity);
        this.mediaPeriods.add(clippingMediaPeriod);
        clippingMediaPeriod.setClipping(this.startUs, this.endUs);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalClippingException;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        super.prepareSource(exoPlayer, z16, listener);
        this.sourceListener = listener;
        prepareChildSource(null, this.mediaSource);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        super.releaseSource();
        this.clippingError = null;
        this.sourceListener = null;
    }

    public ClippingMediaSource(MediaSource mediaSource, long j3, long j16, boolean z16) {
        Assertions.checkArgument(j3 >= 0);
        this.mediaSource = (MediaSource) Assertions.checkNotNull(mediaSource);
        this.startUs = j3;
        this.endUs = j16;
        this.enableInitialDiscontinuity = z16;
        this.mediaPeriods = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Void r75, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        if (this.clippingError != null) {
            return;
        }
        try {
            this.sourceListener.onSourceInfoRefreshed(this, new ClippingTimeline(timeline, this.startUs, this.endUs), obj);
            int size = this.mediaPeriods.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mediaPeriods.get(i3).setClipping(this.startUs, this.endUs);
            }
        } catch (IllegalClippingException e16) {
            this.clippingError = e16;
        }
    }
}
