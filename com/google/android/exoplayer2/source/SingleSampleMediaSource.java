package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SingleSampleMediaSource implements MediaSource {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final Format format;
    private final int minLoadableRetryCount;
    private final Timeline timeline;
    private final boolean treatLoadErrorsAsEndOfStream;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface EventListener {
        void onLoadError(int i3, IOException iOException);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Factory {
        private final DataSource.Factory dataSourceFactory;
        private boolean isCreateCalled;
        private int minLoadableRetryCount = 3;
        private boolean treatLoadErrorsAsEndOfStream;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = (DataSource.Factory) Assertions.checkNotNull(factory);
        }

        public SingleSampleMediaSource createMediaSource(Uri uri, Format format, long j3) {
            return createMediaSource(uri, format, j3, null, null);
        }

        public Factory setMinLoadableRetryCount(int i3) {
            Assertions.checkState(!this.isCreateCalled);
            this.minLoadableRetryCount = i3;
            return this;
        }

        public Factory setTreatLoadErrorsAsEndOfStream(boolean z16) {
            Assertions.checkState(!this.isCreateCalled);
            this.treatLoadErrorsAsEndOfStream = z16;
            return this;
        }

        public SingleSampleMediaSource createMediaSource(Uri uri, Format format, long j3, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            this.isCreateCalled = true;
            return new SingleSampleMediaSource(uri, this.dataSourceFactory, format, j3, this.minLoadableRetryCount, handler, mediaSourceEventListener, this.treatLoadErrorsAsEndOfStream);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        boolean z16;
        if (mediaPeriodId.periodIndex == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        return new SingleSampleMediaPeriod(this.dataSpec, this.dataSourceFactory, this.format, this.durationUs, this.minLoadableRetryCount, this.eventDispatcher, this.treatLoadErrorsAsEndOfStream);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        listener.onSourceInfoRefreshed(this, this.timeline, null);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).release();
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j3) {
        this(uri, factory, format, j3, 3);
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j3, int i3) {
        this(uri, factory, format, j3, i3, null, null, false);
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j3, int i3, Handler handler, EventListener eventListener, int i16, boolean z16) {
        this(uri, factory, format, j3, i3, handler, eventListener == null ? null : new EventListenerWrapper(eventListener, i16), z16);
    }

    SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format, long j3, int i3, Handler handler, MediaSourceEventListener mediaSourceEventListener, boolean z16) {
        this.dataSourceFactory = factory;
        this.format = format;
        this.durationUs = j3;
        this.minLoadableRetryCount = i3;
        this.treatLoadErrorsAsEndOfStream = z16;
        this.eventDispatcher = new MediaSourceEventListener.EventDispatcher(handler, mediaSourceEventListener);
        this.dataSpec = new DataSpec(uri);
        this.timeline = new SinglePeriodTimeline(j3, true, false);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class EventListenerWrapper implements MediaSourceEventListener {
        private final EventListener eventListener;
        private final int eventSourceId;

        public EventListenerWrapper(EventListener eventListener, int i3) {
            this.eventListener = (EventListener) Assertions.checkNotNull(eventListener);
            this.eventSourceId = i3;
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19, IOException iOException, boolean z16) {
            this.eventListener.onLoadError(this.eventSourceId, iOException);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int i3, long j3, long j16) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17) {
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int i3, Format format, int i16, Object obj, long j3) {
        }
    }
}
