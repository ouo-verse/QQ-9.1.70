package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface MediaPeriod extends SequenceableLoader {

    /* loaded from: classes2.dex */
    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    boolean continueLoading(long j3);

    void discardBuffer(long j3, boolean z16);

    long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters);

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getBufferedPositionUs();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    long getNextLoadPositionUs();

    TrackGroupArray getTrackGroups();

    void maybeThrowPrepareError() throws IOException;

    void prepare(Callback callback, long j3);

    long readDiscontinuity();

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    void reevaluateBuffer(long j3);

    long seekToUs(long j3);

    long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3);
}
