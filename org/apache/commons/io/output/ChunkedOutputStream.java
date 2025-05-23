package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ChunkedOutputStream extends FilterOutputStream {
    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private final int chunkSize;

    public ChunkedOutputStream(OutputStream outputStream, int i3) {
        super(outputStream);
        if (i3 > 0) {
            this.chunkSize = i3;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        while (i16 > 0) {
            int min = Math.min(i16, this.chunkSize);
            ((FilterOutputStream) this).out.write(bArr, i3, min);
            i16 -= min;
            i3 += min;
        }
    }

    public ChunkedOutputStream(OutputStream outputStream) {
        this(outputStream, 4096);
    }
}
