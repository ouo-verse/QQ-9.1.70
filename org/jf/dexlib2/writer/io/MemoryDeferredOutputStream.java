package org.jf.dexlib2.writer.io;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MemoryDeferredOutputStream extends DeferredOutputStream {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final List<byte[]> buffers;
    private byte[] currentBuffer;
    private int currentPosition;

    public MemoryDeferredOutputStream() {
        this(16384);
    }

    @Nonnull
    public static DeferredOutputStreamFactory getFactory() {
        return getFactory(16384);
    }

    private int remaining() {
        return this.currentBuffer.length - this.currentPosition;
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        if (remaining() == 0) {
            this.buffers.add(this.currentBuffer);
            this.currentBuffer = new byte[this.currentBuffer.length];
            this.currentPosition = 0;
        }
        byte[] bArr = this.currentBuffer;
        int i16 = this.currentPosition;
        this.currentPosition = i16 + 1;
        bArr[i16] = (byte) i3;
    }

    @Override // org.jf.dexlib2.writer.io.DeferredOutputStream
    public void writeTo(OutputStream outputStream) throws IOException {
        Iterator<byte[]> it = this.buffers.iterator();
        while (it.hasNext()) {
            outputStream.write(it.next());
        }
        int i3 = this.currentPosition;
        if (i3 > 0) {
            outputStream.write(this.currentBuffer, 0, i3);
        }
        this.buffers.clear();
        this.currentPosition = 0;
    }

    public MemoryDeferredOutputStream(int i3) {
        this.buffers = Lists.h();
        this.currentBuffer = new byte[i3];
    }

    @Nonnull
    public static DeferredOutputStreamFactory getFactory(final int i3) {
        return new DeferredOutputStreamFactory() { // from class: org.jf.dexlib2.writer.io.MemoryDeferredOutputStream.1
            @Override // org.jf.dexlib2.writer.io.DeferredOutputStreamFactory
            public DeferredOutputStream makeDeferredOutputStream() {
                return new MemoryDeferredOutputStream(i3);
            }
        };
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        int remaining = remaining();
        int i17 = 0;
        while (true) {
            int i18 = i16 - i17;
            if (i18 <= 0) {
                return;
            }
            int min = Math.min(remaining, i18);
            System.arraycopy(bArr, i3 + i17, this.currentBuffer, this.currentPosition, min);
            i17 += min;
            this.currentPosition += min;
            remaining = remaining();
            if (remaining == 0) {
                this.buffers.add(this.currentBuffer);
                byte[] bArr2 = new byte[this.currentBuffer.length];
                this.currentBuffer = bArr2;
                this.currentPosition = 0;
                remaining = bArr2.length;
            }
        }
    }
}
