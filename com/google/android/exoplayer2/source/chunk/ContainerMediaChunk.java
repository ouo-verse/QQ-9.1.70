package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ContainerMediaChunk extends BaseMediaChunk {
    private volatile int bytesLoaded;
    private final int chunkCount;
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private volatile boolean loadCompleted;
    private final long sampleOffsetUs;

    public ContainerMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i3, Object obj, long j3, long j16, long j17, int i16, long j18, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, format, i3, obj, j3, j16, j17);
        this.chunkCount = i16;
        this.sampleOffsetUs = j18;
        this.extractorWrapper = chunkExtractorWrapper;
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public final long bytesLoaded() {
        return this.bytesLoaded;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public long getNextChunkIndex() {
        return this.chunkIndex + this.chunkCount;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final boolean isLoadCanceled() {
        return this.loadCanceled;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException, InterruptedException {
        DataSpec subrange = this.dataSpec.subrange(this.bytesLoaded);
        try {
            DataSource dataSource = this.dataSource;
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource, subrange.absoluteStreamPosition, dataSource.open(subrange));
            if (this.bytesLoaded == 0) {
                BaseMediaChunkOutput output = getOutput();
                output.setSampleOffsetUs(this.sampleOffsetUs);
                this.extractorWrapper.init(output);
            }
            try {
                Extractor extractor = this.extractorWrapper.extractor;
                boolean z16 = false;
                int i3 = 0;
                while (i3 == 0 && !this.loadCanceled) {
                    i3 = extractor.read(defaultExtractorInput, null);
                }
                if (i3 != 1) {
                    z16 = true;
                }
                Assertions.checkState(z16);
                Util.closeQuietly(this.dataSource);
                this.loadCompleted = true;
            } finally {
                this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
            }
        } catch (Throwable th5) {
            Util.closeQuietly(this.dataSource);
            throw th5;
        }
    }
}
