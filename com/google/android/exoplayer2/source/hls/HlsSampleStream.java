package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
final class HlsSampleStream implements SampleStream {
    private int sampleQueueIndex = -1;
    private final HlsSampleStreamWrapper sampleStreamWrapper;
    private final int trackGroupIndex;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i3) {
        this.sampleStreamWrapper = hlsSampleStreamWrapper;
        this.trackGroupIndex = i3;
    }

    private boolean ensureBoundSampleQueue() {
        if (this.sampleQueueIndex != -1) {
            return true;
        }
        int bindSampleQueueToSampleStream = this.sampleStreamWrapper.bindSampleQueueToSampleStream(this.trackGroupIndex);
        this.sampleQueueIndex = bindSampleQueueToSampleStream;
        if (bindSampleQueueToSampleStream != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        if (ensureBoundSampleQueue() && this.sampleStreamWrapper.isReady(this.sampleQueueIndex)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        if (!ensureBoundSampleQueue() && this.sampleStreamWrapper.isMappingFinished()) {
            throw new SampleQueueMappingException(this.sampleStreamWrapper.getTrackGroups().get(this.trackGroupIndex).getFormat(0).sampleMimeType);
        }
        this.sampleStreamWrapper.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
        if (!ensureBoundSampleQueue()) {
            return -3;
        }
        return this.sampleStreamWrapper.readData(this.sampleQueueIndex, formatHolder, decoderInputBuffer, z16);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j3) {
        if (!ensureBoundSampleQueue()) {
            return 0;
        }
        return this.sampleStreamWrapper.skipData(this.sampleQueueIndex, j3);
    }

    public void unbindSampleQueue() {
        if (this.sampleQueueIndex != -1) {
            this.sampleStreamWrapper.unbindSampleQueue(this.trackGroupIndex);
            this.sampleQueueIndex = -1;
        }
    }
}
