package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ChunkedWriter extends FilterWriter {
    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private final int chunkSize;

    public ChunkedWriter(Writer writer, int i3) {
        super(writer);
        if (i3 > 0) {
            this.chunkSize = i3;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i3, int i16) throws IOException {
        while (i16 > 0) {
            int min = Math.min(i16, this.chunkSize);
            ((FilterWriter) this).out.write(cArr, i3, min);
            i16 -= min;
            i3 += min;
        }
    }

    public ChunkedWriter(Writer writer) {
        this(writer, 4096);
    }
}
