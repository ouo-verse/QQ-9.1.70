package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class BaseMediaChunk extends MediaChunk {
    private int[] firstSampleIndices;
    private BaseMediaChunkOutput output;

    public BaseMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i3, Object obj, long j3, long j16, long j17) {
        super(dataSource, dataSpec, format, i3, obj, j3, j16, j17);
    }

    public final int getFirstSampleIndex(int i3) {
        return this.firstSampleIndices[i3];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseMediaChunkOutput getOutput() {
        return this.output;
    }

    public void init(BaseMediaChunkOutput baseMediaChunkOutput) {
        this.output = baseMediaChunkOutput;
        this.firstSampleIndices = baseMediaChunkOutput.getWriteIndices();
    }
}
