package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;

/* compiled from: P */
/* loaded from: classes2.dex */
final class BaseMediaChunkOutput implements ChunkExtractorWrapper.TrackOutputProvider {
    private static final String TAG = "BaseMediaChunkOutput";
    private final SampleQueue[] sampleQueues;
    private final int[] trackTypes;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.trackTypes = iArr;
        this.sampleQueues = sampleQueueArr;
    }

    public int[] getWriteIndices() {
        int[] iArr = new int[this.sampleQueues.length];
        int i3 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            if (i3 < sampleQueueArr.length) {
                SampleQueue sampleQueue = sampleQueueArr[i3];
                if (sampleQueue != null) {
                    iArr[i3] = sampleQueue.getWriteIndex();
                }
                i3++;
            } else {
                return iArr;
            }
        }
    }

    public void setSampleOffsetUs(long j3) {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue != null) {
                sampleQueue.setSampleOffsetUs(j3);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.TrackOutputProvider
    public TrackOutput track(int i3, int i16) {
        int i17 = 0;
        while (true) {
            int[] iArr = this.trackTypes;
            if (i17 < iArr.length) {
                if (i16 == iArr[i17]) {
                    return this.sampleQueues[i17];
                }
                i17++;
            } else {
                Log.e(TAG, "Unmatched track of type: " + i16);
                return new DummyTrackOutput();
            }
        }
    }
}
