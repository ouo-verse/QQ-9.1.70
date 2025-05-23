package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class LoopingMediaSource extends CompositeMediaSource<Void> {
    private int childPeriodCount;
    private final MediaSource childSource;
    private MediaSource.Listener listener;
    private final int loopCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getNextWindowIndex(int i3, int i16, boolean z16) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i3, i16, z16);
            if (nextWindowIndex == -1) {
                return getFirstWindowIndex(z16);
            }
            return nextWindowIndex;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getPreviousWindowIndex(int i3, int i16, boolean z16) {
            int previousWindowIndex = this.timeline.getPreviousWindowIndex(i3, i16, z16);
            if (previousWindowIndex == -1) {
                return getLastWindowIndex(z16);
            }
            return previousWindowIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        public LoopingTimeline(Timeline timeline, int i3) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i3));
            this.childTimeline = timeline;
            int periodCount = timeline.getPeriodCount();
            this.childPeriodCount = periodCount;
            this.childWindowCount = timeline.getWindowCount();
            this.loopCount = i3;
            if (periodCount > 0) {
                Assertions.checkState(i3 <= Integer.MAX_VALUE / periodCount, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByChildUid(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByPeriodIndex(int i3) {
            return i3 / this.childPeriodCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByWindowIndex(int i3) {
            return i3 / this.childWindowCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected Object getChildUidByChildIndex(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstPeriodIndexByChildIndex(int i3) {
            return i3 * this.childPeriodCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstWindowIndexByChildIndex(int i3) {
            return i3 * this.childWindowCount;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected Timeline getTimelineByChildIndex(int i3) {
            return this.childTimeline;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }
    }

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        if (this.loopCount != Integer.MAX_VALUE) {
            return this.childSource.createPeriod(mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex % this.childPeriodCount), allocator);
        }
        return this.childSource.createPeriod(mediaPeriodId, allocator);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        super.prepareSource(exoPlayer, z16, listener);
        this.listener = listener;
        prepareChildSource(null, this.childSource);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.childSource.releasePeriod(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        super.releaseSource();
        this.listener = null;
        this.childPeriodCount = 0;
    }

    public LoopingMediaSource(MediaSource mediaSource, int i3) {
        Assertions.checkArgument(i3 > 0);
        this.childSource = mediaSource;
        this.loopCount = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Void r16, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        this.childPeriodCount = timeline.getPeriodCount();
        this.listener.onSourceInfoRefreshed(this, this.loopCount != Integer.MAX_VALUE ? new LoopingTimeline(timeline, this.loopCount) : new InfinitelyLoopingTimeline(timeline), obj);
    }
}
