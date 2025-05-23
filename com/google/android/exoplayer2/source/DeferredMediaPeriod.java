package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class DeferredMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;

    /* renamed from: id, reason: collision with root package name */
    private final MediaSource.MediaPeriodId f32946id;

    @Nullable
    private PrepareErrorListener listener;
    private MediaPeriod mediaPeriod;
    public final MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionUs;

    /* loaded from: classes2.dex */
    public interface PrepareErrorListener {
        void onPrepareError(IOException iOException);
    }

    public DeferredMediaPeriod(MediaSource mediaSource, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        this.f32946id = mediaPeriodId;
        this.allocator = allocator;
        this.mediaSource = mediaSource;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        MediaPeriod mediaPeriod = this.mediaPeriod;
        if (mediaPeriod != null && mediaPeriod.continueLoading(j3)) {
            return true;
        }
        return false;
    }

    public void createPeriod() {
        MediaPeriod createPeriod = this.mediaSource.createPeriod(this.f32946id, this.allocator);
        this.mediaPeriod = createPeriod;
        if (this.callback != null) {
            createPeriod.prepare(this, this.preparePositionUs);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j3, boolean z16) {
        this.mediaPeriod.discardBuffer(j3, z16);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters) {
        return this.mediaPeriod.getAdjustedSeekPositionUs(j3, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.mediaPeriod.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.mediaPeriod;
            if (mediaPeriod != null) {
                mediaPeriod.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (IOException e16) {
            PrepareErrorListener prepareErrorListener = this.listener;
            if (prepareErrorListener != null) {
                if (!this.notifiedPrepareError) {
                    this.notifiedPrepareError = true;
                    prepareErrorListener.onPrepareError(e16);
                    return;
                }
                return;
            }
            throw e16;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        this.callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j3) {
        this.callback = callback;
        this.preparePositionUs = j3;
        MediaPeriod mediaPeriod = this.mediaPeriod;
        if (mediaPeriod != null) {
            mediaPeriod.prepare(this, j3);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return this.mediaPeriod.readDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j3) {
        this.mediaPeriod.reevaluateBuffer(j3);
    }

    public void releasePeriod() {
        MediaPeriod mediaPeriod = this.mediaPeriod;
        if (mediaPeriod != null) {
            this.mediaSource.releasePeriod(mediaPeriod);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j3) {
        return this.mediaPeriod.seekToUs(j3);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        return this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j3);
    }

    public void setPrepareErrorListener(PrepareErrorListener prepareErrorListener) {
        this.listener = prepareErrorListener;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }
}
