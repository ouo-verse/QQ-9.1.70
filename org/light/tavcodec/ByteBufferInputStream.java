package org.light.tavcodec;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes29.dex */
class ByteBufferInputStream extends InputStream {
    ByteBuffer buffer;

    public ByteBufferInputStream(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.buffer.hasRemaining()) {
            return this.buffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (!this.buffer.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i16, this.buffer.remaining());
        this.buffer.get(bArr, i3, min);
        return min;
    }
}
