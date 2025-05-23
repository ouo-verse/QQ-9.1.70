package com.tencent.mtt.hippy.adapter.image;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ByteBufferInputStream extends InputStream {
    private final ByteBuffer byteBuffer;
    private int markPos = -1;

    ByteBufferInputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        byteBuffer.flip();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.byteBuffer.remaining();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i3) {
        this.markPos = this.byteBuffer.position();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.byteBuffer.hasRemaining()) {
            return this.byteBuffer.get();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        int i3 = this.markPos;
        if (i3 != -1) {
            this.byteBuffer.position(i3);
        } else {
            throw new IOException("Cannot reset to unset mark position");
        }
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        if (!this.byteBuffer.hasRemaining()) {
            return -1L;
        }
        long min = Math.min(j3, available());
        this.byteBuffer.position((int) (r0.position() + min));
        return min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) {
        if (!this.byteBuffer.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i16, available());
        this.byteBuffer.get(bArr, i3, min);
        return min;
    }
}
