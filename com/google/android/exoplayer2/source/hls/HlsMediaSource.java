package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HlsMediaSource implements MediaSource, HlsPlaylistTracker.PrimaryPlaylistListener {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private final boolean allowChunklessPreparation;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final Uri manifestUri;
    private final int minLoadableRetryCount;
    private final ParsingLoadable.Parser<HlsPlaylist> playlistParser;
    private HlsPlaylistTracker playlistTracker;
    private MediaSource.Listener sourceListener;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Factory implements AdsMediaSource.MediaSourceFactory {
        private boolean allowChunklessPreparation;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private HlsExtractorFactory extractorFactory;
        private final HlsDataSourceFactory hlsDataSourceFactory;
        private boolean isCreateCalled;
        private int minLoadableRetryCount;

        @Nullable
        private ParsingLoadable.Parser<HlsPlaylist> playlistParser;

        public Factory(DataSource.Factory factory) {
            this(new DefaultHlsDataSourceFactory(factory));
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        public Factory setAllowChunklessPreparation(boolean z16) {
            Assertions.checkState(!this.isCreateCalled);
            this.allowChunklessPreparation = z16;
            return this;
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            Assertions.checkState(!this.isCreateCalled);
            this.compositeSequenceableLoaderFactory = (CompositeSequenceableLoaderFactory) Assertions.checkNotNull(compositeSequenceableLoaderFactory);
            return this;
        }

        public Factory setExtractorFactory(HlsExtractorFactory hlsExtractorFactory) {
            Assertions.checkState(!this.isCreateCalled);
            this.extractorFactory = (HlsExtractorFactory) Assertions.checkNotNull(hlsExtractorFactory);
            return this;
        }

        public Factory setMinLoadableRetryCount(int i3) {
            Assertions.checkState(!this.isCreateCalled);
            this.minLoadableRetryCount = i3;
            return this;
        }

        public Factory setPlaylistParser(ParsingLoadable.Parser<HlsPlaylist> parser) {
            Assertions.checkState(!this.isCreateCalled);
            this.playlistParser = (ParsingLoadable.Parser) Assertions.checkNotNull(parser);
            return this;
        }

        public Factory(HlsDataSourceFactory hlsDataSourceFactory) {
            this.hlsDataSourceFactory = (HlsDataSourceFactory) Assertions.checkNotNull(hlsDataSourceFactory);
            this.extractorFactory = HlsExtractorFactory.DEFAULT;
            this.minLoadableRetryCount = 3;
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
        }

        public HlsMediaSource createMediaSource(Uri uri) {
            return createMediaSource(uri, (Handler) null, (MediaSourceEventListener) null);
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.MediaSourceFactory
        public HlsMediaSource createMediaSource(Uri uri, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener) {
            this.isCreateCalled = true;
            if (this.playlistParser == null) {
                this.playlistParser = new HlsPlaylistParser();
            }
            return new HlsMediaSource(uri, this.hlsDataSourceFactory, this.extractorFactory, this.compositeSequenceableLoaderFactory, this.minLoadableRetryCount, handler, mediaSourceEventListener, this.playlistParser, this.allowChunklessPreparation);
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
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
        return new HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.minLoadableRetryCount, this.eventDispatcher, allocator, this.compositeSequenceableLoaderFactory, this.allowChunklessPreparation);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener
    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist) {
        long j3;
        long j16;
        long j17;
        SinglePeriodTimeline singlePeriodTimeline;
        long j18;
        long j19;
        long j26;
        if (hlsMediaPlaylist.hasProgramDateTime) {
            j3 = C.usToMs(hlsMediaPlaylist.startTimeUs);
        } else {
            j3 = -9223372036854775807L;
        }
        int i3 = hlsMediaPlaylist.playlistType;
        if (i3 != 2 && i3 != 1) {
            j16 = -9223372036854775807L;
        } else {
            j16 = j3;
        }
        long j27 = hlsMediaPlaylist.startOffsetUs;
        if (this.playlistTracker.isLive()) {
            long initialStartTimeUs = hlsMediaPlaylist.startTimeUs - this.playlistTracker.getInitialStartTimeUs();
            if (hlsMediaPlaylist.hasEndTag) {
                j18 = initialStartTimeUs + hlsMediaPlaylist.durationUs;
            } else {
                j18 = -9223372036854775807L;
            }
            List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.segments;
            if (j27 == -9223372036854775807L) {
                if (list.isEmpty()) {
                    j26 = 0;
                } else {
                    j26 = list.get(Math.max(0, list.size() - 3)).relativeStartTimeUs;
                }
                j19 = j26;
            } else {
                j19 = j27;
            }
            singlePeriodTimeline = new SinglePeriodTimeline(j16, j3, j18, hlsMediaPlaylist.durationUs, initialStartTimeUs, j19, true, !hlsMediaPlaylist.hasEndTag);
        } else {
            if (j27 == -9223372036854775807L) {
                j17 = 0;
            } else {
                j17 = j27;
            }
            long j28 = hlsMediaPlaylist.durationUs;
            singlePeriodTimeline = new SinglePeriodTimeline(j16, j3, j28, j28, 0L, j17, true, false);
        }
        this.sourceListener.onSourceInfoRefreshed(this, singlePeriodTimeline, new HlsManifest(this.playlistTracker.getMasterPlaylist(), hlsMediaPlaylist));
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        this.sourceListener = listener;
        HlsPlaylistTracker hlsPlaylistTracker = new HlsPlaylistTracker(this.manifestUri, this.dataSourceFactory, this.eventDispatcher, this.minLoadableRetryCount, this, this.playlistParser);
        this.playlistTracker = hlsPlaylistTracker;
        hlsPlaylistTracker.start();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((HlsMediaPeriod) mediaPeriod).release();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        HlsPlaylistTracker hlsPlaylistTracker = this.playlistTracker;
        if (hlsPlaylistTracker != null) {
            hlsPlaylistTracker.release();
            this.playlistTracker = null;
        }
        this.sourceListener = null;
    }

    @Deprecated
    public HlsMediaSource(Uri uri, DataSource.Factory factory, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this(uri, factory, 3, handler, mediaSourceEventListener);
    }

    @Deprecated
    public HlsMediaSource(Uri uri, DataSource.Factory factory, int i3, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this(uri, new DefaultHlsDataSourceFactory(factory), HlsExtractorFactory.DEFAULT, i3, handler, mediaSourceEventListener, new HlsPlaylistParser());
    }

    @Deprecated
    public HlsMediaSource(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, int i3, Handler handler, MediaSourceEventListener mediaSourceEventListener, ParsingLoadable.Parser<HlsPlaylist> parser) {
        this(uri, hlsDataSourceFactory, hlsExtractorFactory, new DefaultCompositeSequenceableLoaderFactory(), i3, handler, mediaSourceEventListener, parser, false);
    }

    HlsMediaSource(Uri uri, HlsDataSourceFactory hlsDataSourceFactory, HlsExtractorFactory hlsExtractorFactory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, int i3, Handler handler, MediaSourceEventListener mediaSourceEventListener, ParsingLoadable.Parser<HlsPlaylist> parser, boolean z16) {
        this.manifestUri = uri;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.extractorFactory = hlsExtractorFactory;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.minLoadableRetryCount = i3;
        this.playlistParser = parser;
        this.allowChunklessPreparation = z16;
        this.eventDispatcher = new MediaSourceEventListener.EventDispatcher(handler, mediaSourceEventListener);
    }
}
