package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DummyTrackOutput implements TrackOutput {
    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i3, boolean z16) throws IOException, InterruptedException {
        int skip = extractorInput.skip(i3);
        if (skip != -1) {
            return skip;
        }
        if (z16) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i3) {
        parsableByteArray.skipBytes(i3);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j3, int i3, int i16, int i17, TrackOutput.CryptoData cryptoData) {
    }
}
