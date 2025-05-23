package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class DataChunk extends Chunk {
    private static final int READ_GRANULARITY = 16384;
    private byte[] data;
    private int limit;
    private volatile boolean loadCanceled;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i3, Format format, int i16, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i3, format, i16, obj, -9223372036854775807L, -9223372036854775807L);
        this.data = bArr;
    }

    private void maybeExpandData() {
        byte[] bArr = this.data;
        if (bArr == null) {
            this.data = new byte[16384];
        } else if (bArr.length < this.limit + 16384) {
            this.data = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public long bytesLoaded() {
        return this.limit;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    protected abstract void consume(byte[] bArr, int i3) throws IOException;

    public byte[] getDataHolder() {
        return this.data;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final boolean isLoadCanceled() {
        return this.loadCanceled;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public final void load() throws IOException, InterruptedException {
        try {
            this.dataSource.open(this.dataSpec);
            int i3 = 0;
            this.limit = 0;
            while (i3 != -1 && !this.loadCanceled) {
                maybeExpandData();
                i3 = this.dataSource.read(this.data, this.limit, 16384);
                if (i3 != -1) {
                    this.limit += i3;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, this.limit);
            }
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }
}
