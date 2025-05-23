package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ConcatenatingMediaSource extends CompositeMediaSource<Integer> {
    private final boolean isAtomic;
    private MediaSource.Listener listener;
    private final Object[] manifests;
    private final MediaSource[] mediaSources;
    private final ShuffleOrder shuffleOrder;
    private final Map<MediaPeriod, Integer> sourceIndexByMediaPeriod;
    private ConcatenatedTimeline timeline;
    private final Timeline[] timelines;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        private final int[] sourcePeriodOffsets;
        private final int[] sourceWindowOffsets;
        private final Timeline[] timelines;

        public ConcatenatedTimeline(Timeline[] timelineArr, boolean z16, ShuffleOrder shuffleOrder) {
            super(z16, shuffleOrder);
            boolean z17;
            int[] iArr = new int[timelineArr.length];
            int[] iArr2 = new int[timelineArr.length];
            long j3 = 0;
            int i3 = 0;
            for (int i16 = 0; i16 < timelineArr.length; i16++) {
                Timeline timeline = timelineArr[i16];
                j3 += timeline.getPeriodCount();
                if (j3 <= TTL.MAX_VALUE) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                Assertions.checkState(z17, "ConcatenatingMediaSource children contain too many periods");
                iArr[i16] = (int) j3;
                i3 += timeline.getWindowCount();
                iArr2[i16] = i3;
            }
            this.timelines = timelineArr;
            this.sourcePeriodOffsets = iArr;
            this.sourceWindowOffsets = iArr2;
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
            return Util.binarySearchFloor(this.sourcePeriodOffsets, i3 + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getChildIndexByWindowIndex(int i3) {
            return Util.binarySearchFloor(this.sourceWindowOffsets, i3 + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected Object getChildUidByChildIndex(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstPeriodIndexByChildIndex(int i3) {
            if (i3 == 0) {
                return 0;
            }
            return this.sourcePeriodOffsets[i3 - 1];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected int getFirstWindowIndexByChildIndex(int i3) {
            if (i3 == 0) {
                return 0;
            }
            return this.sourceWindowOffsets[i3 - 1];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.sourcePeriodOffsets[r0.length - 1];
        }

        @Override // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        protected Timeline getTimelineByChildIndex(int i3) {
            return this.timelines[i3];
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.sourceWindowOffsets[r0.length - 1];
        }
    }

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private static boolean[] buildDuplicateFlags(MediaSource[] mediaSourceArr) {
        boolean[] zArr = new boolean[mediaSourceArr.length];
        IdentityHashMap identityHashMap = new IdentityHashMap(mediaSourceArr.length);
        for (int i3 = 0; i3 < mediaSourceArr.length; i3++) {
            MediaSource mediaSource = mediaSourceArr[i3];
            if (!identityHashMap.containsKey(mediaSource)) {
                identityHashMap.put(mediaSource, null);
            } else {
                zArr[i3] = true;
            }
        }
        return zArr;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        int childIndexByPeriodIndex = this.timeline.getChildIndexByPeriodIndex(mediaPeriodId.periodIndex);
        MediaPeriod createPeriod = this.mediaSources[childIndexByPeriodIndex].createPeriod(mediaPeriodId.copyWithPeriodIndex(mediaPeriodId.periodIndex - this.timeline.getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex)), allocator);
        this.sourceIndexByMediaPeriod.put(createPeriod, Integer.valueOf(childIndexByPeriodIndex));
        return createPeriod;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        super.prepareSource(exoPlayer, z16, listener);
        this.listener = listener;
        boolean[] buildDuplicateFlags = buildDuplicateFlags(this.mediaSources);
        if (this.mediaSources.length == 0) {
            listener.onSourceInfoRefreshed(this, Timeline.EMPTY, null);
            return;
        }
        for (int i3 = 0; i3 < this.mediaSources.length; i3++) {
            if (!buildDuplicateFlags[i3]) {
                prepareChildSource(Integer.valueOf(i3), this.mediaSources[i3]);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        int intValue = this.sourceIndexByMediaPeriod.get(mediaPeriod).intValue();
        this.sourceIndexByMediaPeriod.remove(mediaPeriod);
        this.mediaSources[intValue].releasePeriod(mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        super.releaseSource();
        this.listener = null;
        this.timeline = null;
    }

    public ConcatenatingMediaSource(boolean z16, MediaSource... mediaSourceArr) {
        this(z16, new ShuffleOrder.DefaultShuffleOrder(mediaSourceArr.length), mediaSourceArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Integer num, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        this.timelines[num.intValue()] = timeline;
        this.manifests[num.intValue()] = obj;
        int intValue = num.intValue();
        while (true) {
            intValue++;
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (intValue >= mediaSourceArr.length) {
                break;
            } else if (mediaSourceArr[intValue] == mediaSource) {
                this.timelines[intValue] = timeline;
                this.manifests[intValue] = obj;
            }
        }
        for (Timeline timeline2 : this.timelines) {
            if (timeline2 == null) {
                return;
            }
        }
        ConcatenatedTimeline concatenatedTimeline = new ConcatenatedTimeline((Timeline[]) this.timelines.clone(), this.isAtomic, this.shuffleOrder);
        this.timeline = concatenatedTimeline;
        this.listener.onSourceInfoRefreshed(this, concatenatedTimeline, this.manifests.clone());
    }

    public ConcatenatingMediaSource(boolean z16, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        for (MediaSource mediaSource : mediaSourceArr) {
            Assertions.checkNotNull(mediaSource);
        }
        Assertions.checkArgument(shuffleOrder.getLength() == mediaSourceArr.length);
        this.mediaSources = mediaSourceArr;
        this.isAtomic = z16;
        this.shuffleOrder = shuffleOrder;
        this.timelines = new Timeline[mediaSourceArr.length];
        this.manifests = new Object[mediaSourceArr.length];
        this.sourceIndexByMediaPeriod = new HashMap();
    }
}
