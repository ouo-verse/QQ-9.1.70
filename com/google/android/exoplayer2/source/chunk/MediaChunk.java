package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class MediaChunk extends Chunk {
    public final long chunkIndex;

    public MediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i3, Object obj, long j3, long j16, long j17) {
        super(dataSource, dataSpec, 1, format, i3, obj, j3, j16);
        Assertions.checkNotNull(format);
        this.chunkIndex = j17;
    }

    public long getNextChunkIndex() {
        return this.chunkIndex + 1;
    }

    public abstract boolean isLoadCompleted();
}
