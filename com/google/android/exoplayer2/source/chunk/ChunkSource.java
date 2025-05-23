package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.SeekParameters;
import java.io.IOException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ChunkSource {
    long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters);

    void getNextChunk(MediaChunk mediaChunk, long j3, long j16, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j3, List<? extends MediaChunk> list);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z16, Exception exc);
}
