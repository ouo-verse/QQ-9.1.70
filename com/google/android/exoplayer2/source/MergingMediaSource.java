package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    private static final int PERIOD_COUNT_UNSET = -1;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaSource.Listener listener;
    private final MediaSource[] mediaSources;
    private IllegalMergeException mergeError;
    private final ArrayList<MediaSource> pendingTimelineSources;
    private int periodCount;
    private Object primaryManifest;
    private Timeline primaryTimeline;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface Reason {
        }

        public IllegalMergeException(int i3) {
            this.reason = i3;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    private IllegalMergeException checkTimelineMerges(Timeline timeline) {
        if (this.periodCount == -1) {
            this.periodCount = timeline.getPeriodCount();
            return null;
        }
        if (timeline.getPeriodCount() != this.periodCount) {
            return new IllegalMergeException(0);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        int length = this.mediaSources.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        for (int i3 = 0; i3 < length; i3++) {
            mediaPeriodArr[i3] = this.mediaSources[i3].createPeriod(mediaPeriodId, allocator);
        }
        return new MergingMediaPeriod(this.compositeSequenceableLoaderFactory, mediaPeriodArr);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.mergeError;
        if (illegalMergeException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalMergeException;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        super.prepareSource(exoPlayer, z16, listener);
        this.listener = listener;
        for (int i3 = 0; i3 < this.mediaSources.length; i3++) {
            prepareChildSource(Integer.valueOf(i3), this.mediaSources[i3]);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i3 = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (i3 < mediaSourceArr.length) {
                mediaSourceArr[i3].releasePeriod(mergingMediaPeriod.periods[i3]);
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        super.releaseSource();
        this.listener = null;
        this.primaryTimeline = null;
        this.primaryManifest = null;
        this.periodCount = -1;
        this.mergeError = null;
        this.pendingTimelineSources.clear();
        Collections.addAll(this.pendingTimelineSources, this.mediaSources);
    }

    public MergingMediaSource(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.mediaSources = mediaSourceArr;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.pendingTimelineSources = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.periodCount = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Integer num, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        if (this.mergeError == null) {
            this.mergeError = checkTimelineMerges(timeline);
        }
        if (this.mergeError != null) {
            return;
        }
        this.pendingTimelineSources.remove(mediaSource);
        if (mediaSource == this.mediaSources[0]) {
            this.primaryTimeline = timeline;
            this.primaryManifest = obj;
        }
        if (this.pendingTimelineSources.isEmpty()) {
            this.listener.onSourceInfoRefreshed(this, this.primaryTimeline, this.primaryManifest);
        }
    }
}
