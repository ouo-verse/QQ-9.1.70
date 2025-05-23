package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ExtractorMediaSource implements MediaSource, ExtractorMediaPeriod.Listener {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_LIVE = 6;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_ON_DEMAND = 3;
    public static final int MIN_RETRY_COUNT_DEFAULT_FOR_MEDIA = -1;
    private final int continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final DataSource.Factory dataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final ExtractorsFactory extractorsFactory;
    private final int minLoadableRetryCount;
    private MediaSource.Listener sourceListener;
    private long timelineDurationUs;
    private boolean timelineIsSeekable;
    private final Uri uri;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface EventListener {
        void onLoadError(IOException iOException);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Factory implements AdsMediaSource.MediaSourceFactory {

        @Nullable
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;

        @Nullable
        private ExtractorsFactory extractorsFactory;
        private boolean isCreateCalled;
        private int minLoadableRetryCount = -1;
        private int continueLoadingCheckIntervalBytes = 1048576;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public Factory setContinueLoadingCheckIntervalBytes(int i3) {
            Assertions.checkState(!this.isCreateCalled);
            this.continueLoadingCheckIntervalBytes = i3;
            return this;
        }

        public Factory setCustomCacheKey(String str) {
            Assertions.checkState(!this.isCreateCalled);
            this.customCacheKey = str;
            return this;
        }

        public Factory setExtractorsFactory(ExtractorsFactory extractorsFactory) {
            Assertions.checkState(!this.isCreateCalled);
            this.extractorsFactory = extractorsFactory;
            return this;
        }

        public Factory setMinLoadableRetryCount(int i3) {
            Assertions.checkState(!this.isCreateCalled);
            this.minLoadableRetryCount = i3;
            return this;
        }

        public ExtractorMediaSource createMediaSource(Uri uri) {
            return createMediaSource(uri, (Handler) null, (MediaSourceEventListener) null);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public ExtractorMediaSource createMediaSource(Uri uri, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            this.isCreateCalled = true;
            if (this.extractorsFactory == null) {
                this.extractorsFactory = new DefaultExtractorsFactory();
            }
            return new ExtractorMediaSource(uri, this.dataSourceFactory, this.extractorsFactory, this.minLoadableRetryCount, handler, mediaSourceEventListener, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
        }
    }

    private void notifySourceInfoRefreshed(long j3, boolean z16) {
        this.timelineDurationUs = j3;
        this.timelineIsSeekable = z16;
        this.sourceListener.onSourceInfoRefreshed(this, new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false), null);
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
        return new ExtractorMediaPeriod(this.uri, this.dataSourceFactory.createDataSource(), this.extractorsFactory.createExtractors(), this.minLoadableRetryCount, this.eventDispatcher, this, allocator, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }

    @Override // com.google.android.exoplayer2.source.ExtractorMediaPeriod.Listener
    public void onSourceInfoRefreshed(long j3, boolean z16) {
        if (j3 == -9223372036854775807L) {
            j3 = this.timelineDurationUs;
        }
        if (this.timelineDurationUs == j3 && this.timelineIsSeekable == z16) {
            return;
        }
        notifySourceInfoRefreshed(j3, z16);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        this.sourceListener = listener;
        notifySourceInfoRefreshed(-9223372036854775807L, false);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((ExtractorMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        this.sourceListener = null;
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener) {
        this(uri, factory, extractorsFactory, handler, eventListener, null);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, Handler handler, EventListener eventListener, String str) {
        this(uri, factory, extractorsFactory, -1, handler, eventListener, str, 1048576);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, int i3, Handler handler, EventListener eventListener, String str, int i16) {
        this(uri, factory, extractorsFactory, i3, handler, eventListener == null ? null : new EventListenerWrapper(eventListener), str, i16);
    }

    ExtractorMediaSource(Uri uri, DataSource.Factory factory, ExtractorsFactory extractorsFactory, int i3, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener, @Nullable String str, int i16) {
        this.uri = uri;
        this.dataSourceFactory = factory;
        this.extractorsFactory = extractorsFactory;
        this.minLoadableRetryCount = i3;
        this.eventDispatcher = new MediaSourceEventListener.EventDispatcher(handler, mediaSourceEventListener);
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = i16;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class EventListenerWrapper implements MediaSourceEventListener {
        private final EventListener eventListener;

        public EventListenerWrapper(EventListener eventListener) {
            this.eventListener = (EventListener) Assertions.checkNotNull(eventListener);
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19, IOException iOException, boolean z16) {
            this.eventListener.onLoadError(iOException);
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
