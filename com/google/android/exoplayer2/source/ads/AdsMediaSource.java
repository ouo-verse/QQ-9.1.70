package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.DeferredMediaPeriod;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final String TAG = "AdsMediaSource";
    private long[][] adDurationsUs;
    private MediaSource[][] adGroupMediaSources;
    private final MediaSourceFactory adMediaSourceFactory;
    private AdPlaybackState adPlaybackState;
    private final ViewGroup adUiViewGroup;
    private final AdsLoader adsLoader;
    private ComponentListener componentListener;
    private Object contentManifest;
    private final MediaSource contentMediaSource;
    private Timeline contentTimeline;
    private final Map<MediaSource, List<DeferredMediaPeriod>> deferredMediaPeriodByAdMediaSource;

    @Nullable
    private final Handler eventHandler;

    @Nullable
    private final EventListener eventListener;
    private MediaSource.Listener listener;
    private final Handler mainHandler;
    private final Timeline.Period period;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class AdPrepareErrorListener implements DeferredMediaPeriod.PrepareErrorListener {
        private final int adGroupIndex;
        private final int adIndexInAdGroup;

        public AdPrepareErrorListener(int i3, int i16) {
            this.adGroupIndex = i3;
            this.adIndexInAdGroup = i16;
        }

        @Override // com.google.android.exoplayer2.source.DeferredMediaPeriod.PrepareErrorListener
        public void onPrepareError(final IOException iOException) {
            AdsMediaSource.this.mainHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.AdPrepareErrorListener.1
                @Override // java.lang.Runnable
                public void run() {
                    AdsMediaSource.this.adsLoader.handlePrepareError(AdPrepareErrorListener.this.adGroupIndex, AdPrepareErrorListener.this.adIndexInAdGroup, iOException);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class ComponentListener implements AdsLoader.EventListener {
        private final Handler playerHandler = new Handler();
        private volatile boolean released;

        public ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdClicked() {
            if (!this.released && AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.eventListener.onAdClicked();
                        }
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdLoadError(final IOException iOException) {
            if (this.released) {
                return;
            }
            Log.w(AdsMediaSource.TAG, "Ad load error", iOException);
            if (AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.eventListener.onAdLoadError(iOException);
                        }
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdPlaybackState(final AdPlaybackState adPlaybackState) {
            if (this.released) {
                return;
            }
            this.playerHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ComponentListener.this.released) {
                        AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
                    }
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onAdTapped() {
            if (!this.released && AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.eventListener.onAdTapped();
                        }
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.source.ads.AdsLoader.EventListener
        public void onInternalAdLoadError(final RuntimeException runtimeException) {
            if (this.released) {
                return;
            }
            Log.w(AdsMediaSource.TAG, "Internal ad load error", runtimeException);
            if (AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.ComponentListener.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.eventListener.onInternalAdLoadError(runtimeException);
                        }
                    }
                });
            }
        }

        public void release() {
            this.released = true;
            this.playerHandler.removeCallbacksAndMessages(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface EventListener extends MediaSourceEventListener {
        void onAdClicked();

        void onAdLoadError(IOException iOException);

        void onAdTapped();

        void onInternalAdLoadError(RuntimeException runtimeException);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface MediaSourceFactory {
        MediaSource createMediaSource(Uri uri, @Nullable Handler handler, @Nullable MediaSourceEventListener mediaSourceEventListener);

        int[] getSupportedTypes();
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader, ViewGroup viewGroup) {
        this(mediaSource, factory, adsLoader, viewGroup, (Handler) null, (EventListener) null);
    }

    private void maybeUpdateSourceInfo() {
        Timeline singlePeriodAdTimeline;
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        if (adPlaybackState != null && this.contentTimeline != null) {
            AdPlaybackState withAdDurationsUs = adPlaybackState.withAdDurationsUs(this.adDurationsUs);
            this.adPlaybackState = withAdDurationsUs;
            if (withAdDurationsUs.adGroupCount == 0) {
                singlePeriodAdTimeline = this.contentTimeline;
            } else {
                singlePeriodAdTimeline = new SinglePeriodAdTimeline(this.contentTimeline, this.adPlaybackState);
            }
            this.listener.onSourceInfoRefreshed(this, singlePeriodAdTimeline, this.contentManifest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        if (this.adPlaybackState == null) {
            MediaSource[][] mediaSourceArr = new MediaSource[adPlaybackState.adGroupCount];
            this.adGroupMediaSources = mediaSourceArr;
            Arrays.fill(mediaSourceArr, new MediaSource[0]);
            long[][] jArr = new long[adPlaybackState.adGroupCount];
            this.adDurationsUs = jArr;
            Arrays.fill(jArr, new long[0]);
        }
        this.adPlaybackState = adPlaybackState;
        maybeUpdateSourceInfo();
    }

    private void onAdSourceInfoRefreshed(MediaSource mediaSource, int i3, int i16, Timeline timeline) {
        boolean z16 = true;
        if (timeline.getPeriodCount() != 1) {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        this.adDurationsUs[i3][i16] = timeline.getPeriod(0, this.period).getDurationUs();
        if (this.deferredMediaPeriodByAdMediaSource.containsKey(mediaSource)) {
            List<DeferredMediaPeriod> list = this.deferredMediaPeriodByAdMediaSource.get(mediaSource);
            for (int i17 = 0; i17 < list.size(); i17++) {
                list.get(i17).createPeriod();
            }
            this.deferredMediaPeriodByAdMediaSource.remove(mediaSource);
        }
        maybeUpdateSourceInfo();
    }

    private void onContentSourceInfoRefreshed(Timeline timeline, Object obj) {
        this.contentTimeline = timeline;
        this.contentManifest = obj;
        maybeUpdateSourceInfo();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        if (this.adPlaybackState.adGroupCount > 0 && mediaPeriodId.isAd()) {
            int i3 = mediaPeriodId.adGroupIndex;
            int i16 = mediaPeriodId.adIndexInAdGroup;
            if (this.adGroupMediaSources[i3].length <= i16) {
                MediaSource createMediaSource = this.adMediaSourceFactory.createMediaSource(this.adPlaybackState.adGroups[i3].uris[i16], this.eventHandler, this.eventListener);
                MediaSource[][] mediaSourceArr = this.adGroupMediaSources;
                int length = mediaSourceArr[mediaPeriodId.adGroupIndex].length;
                if (i16 >= length) {
                    int i17 = i16 + 1;
                    mediaSourceArr[i3] = (MediaSource[]) Arrays.copyOf(mediaSourceArr[i3], i17);
                    long[][] jArr = this.adDurationsUs;
                    jArr[i3] = Arrays.copyOf(jArr[i3], i17);
                    Arrays.fill(this.adDurationsUs[i3], length, i17, -9223372036854775807L);
                }
                this.adGroupMediaSources[i3][i16] = createMediaSource;
                this.deferredMediaPeriodByAdMediaSource.put(createMediaSource, new ArrayList());
                prepareChildSource(mediaPeriodId, createMediaSource);
            }
            MediaSource mediaSource = this.adGroupMediaSources[i3][i16];
            DeferredMediaPeriod deferredMediaPeriod = new DeferredMediaPeriod(mediaSource, new MediaSource.MediaPeriodId(0, mediaPeriodId.windowSequenceNumber), allocator);
            deferredMediaPeriod.setPrepareErrorListener(new AdPrepareErrorListener(i3, i16));
            List<DeferredMediaPeriod> list = this.deferredMediaPeriodByAdMediaSource.get(mediaSource);
            if (list == null) {
                deferredMediaPeriod.createPeriod();
            } else {
                list.add(deferredMediaPeriod);
            }
            return deferredMediaPeriod;
        }
        DeferredMediaPeriod deferredMediaPeriod2 = new DeferredMediaPeriod(this.contentMediaSource, mediaPeriodId, allocator);
        deferredMediaPeriod2.createPeriod();
        return deferredMediaPeriod2;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void prepareSource(final ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        super.prepareSource(exoPlayer, z16, listener);
        Assertions.checkArgument(z16);
        final ComponentListener componentListener = new ComponentListener();
        this.listener = listener;
        this.componentListener = componentListener;
        prepareChildSource(new MediaSource.MediaPeriodId(0), this.contentMediaSource);
        this.mainHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.1
            @Override // java.lang.Runnable
            public void run() {
                AdsMediaSource.this.adsLoader.attachPlayer(exoPlayer, componentListener, AdsMediaSource.this.adUiViewGroup);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        DeferredMediaPeriod deferredMediaPeriod = (DeferredMediaPeriod) mediaPeriod;
        List<DeferredMediaPeriod> list = this.deferredMediaPeriodByAdMediaSource.get(deferredMediaPeriod.mediaSource);
        if (list != null) {
            list.remove(deferredMediaPeriod);
        }
        deferredMediaPeriod.releasePeriod();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void releaseSource() {
        super.releaseSource();
        this.componentListener.release();
        this.componentListener = null;
        this.deferredMediaPeriodByAdMediaSource.clear();
        this.contentTimeline = null;
        this.contentManifest = null;
        this.adPlaybackState = null;
        this.adGroupMediaSources = new MediaSource[0];
        this.adDurationsUs = new long[0];
        this.listener = null;
        this.mainHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.ads.AdsMediaSource.2
            @Override // java.lang.Runnable
            public void run() {
                AdsMediaSource.this.adsLoader.detachPlayer();
            }
        });
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader, ViewGroup viewGroup, @Nullable Handler handler, @Nullable EventListener eventListener) {
        this(mediaSource, new ExtractorMediaSource.Factory(factory), adsLoader, viewGroup, handler, eventListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, Timeline timeline, @Nullable Object obj) {
        if (mediaPeriodId.isAd()) {
            onAdSourceInfoRefreshed(mediaSource, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, timeline);
        } else {
            onContentSourceInfoRefreshed(timeline, obj);
        }
    }

    public AdsMediaSource(MediaSource mediaSource, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader, ViewGroup viewGroup, @Nullable Handler handler, @Nullable EventListener eventListener) {
        this.contentMediaSource = mediaSource;
        this.adMediaSourceFactory = mediaSourceFactory;
        this.adsLoader = adsLoader;
        this.adUiViewGroup = viewGroup;
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.deferredMediaPeriodByAdMediaSource = new HashMap();
        this.period = new Timeline.Period();
        this.adGroupMediaSources = new MediaSource[0];
        this.adDurationsUs = new long[0];
        adsLoader.setSupportedContentTypes(mediaSourceFactory.getSupportedTypes());
    }
}
