package org.jf.dexlib2.writer.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MemoryDataStore implements DexDataStore {
    private byte[] buf;
    private int size;

    public MemoryDataStore() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void growBufferIfNeeded(int i3) {
        if (i3 > this.size) {
            byte[] bArr = this.buf;
            if (i3 > bArr.length) {
                int newBufferSize = getNewBufferSize(bArr.length, i3);
                if (newBufferSize >= i3) {
                    this.buf = Arrays.copyOf(this.buf, newBufferSize);
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            this.size = i3;
        }
    }

    public byte[] getBuffer() {
        return this.buf;
    }

    public byte[] getData() {
        return Arrays.copyOf(this.buf, this.size);
    }

    protected int getNewBufferSize(int i3, int i16) {
        return Math.max(i16 + (i16 >> 2), i3 + 262144);
    }

    public int getSize() {
        return this.size;
    }

    @Override // org.jf.dexlib2.writer.io.DexDataStore
    @Nonnull
    public OutputStream outputAt(int i3) {
        if (i3 >= 0) {
            return new OutputStream(i3) { // from class: org.jf.dexlib2.writer.io.MemoryDataStore.1
                private int position;
                final /* synthetic */ int val$offset;

                {
                    this.val$offset = i3;
                    this.position = i3;
                }

                @Override // java.io.OutputStream
                public void write(int i16) throws IOException {
                    MemoryDataStore.this.growBufferIfNeeded(this.position + 1);
                    byte[] bArr = MemoryDataStore.this.buf;
                    int i17 = this.position;
                    this.position = i17 + 1;
                    bArr[i17] = (byte) i16;
                }

                @Override // java.io.OutputStream
                public void write(byte[] bArr) throws IOException {
                    MemoryDataStore.this.growBufferIfNeeded(this.position + bArr.length);
                    System.arraycopy(bArr, 0, MemoryDataStore.this.buf, this.position, bArr.length);
                    this.position += bArr.length;
                }

                @Override // java.io.OutputStream
                public void write(byte[] bArr, int i16, int i17) throws IOException {
                    MemoryDataStore.this.growBufferIfNeeded(this.position + i17);
                    System.arraycopy(bArr, i16, MemoryDataStore.this.buf, this.position, i17);
                    this.position += i17;
                }
            };
        }
        throw new IllegalArgumentException();
    }

    @Override // org.jf.dexlib2.writer.io.DexDataStore
    @Nonnull
    public InputStream readAt(int i3) {
        if (i3 >= 0) {
            return new InputStream(i3) { // from class: org.jf.dexlib2.writer.io.MemoryDataStore.2
                private int mark;
                private int position;
                final /* synthetic */ int val$offset;

                {
                    this.val$offset = i3;
                    this.position = i3;
                    this.mark = i3;
                }

                @Override // java.io.InputStream
                public int available() throws IOException {
                    return Math.max(0, MemoryDataStore.this.size - this.position);
                }

                @Override // java.io.InputStream
                public void mark(int i16) {
                    this.mark = this.position;
                }

                @Override // java.io.InputStream
                public boolean markSupported() {
                    return true;
                }

                @Override // java.io.InputStream
                public int read() throws IOException {
                    if (this.position >= MemoryDataStore.this.size) {
                        return -1;
                    }
                    byte[] bArr = MemoryDataStore.this.buf;
                    int i16 = this.position;
                    this.position = i16 + 1;
                    return bArr[i16];
                }

                @Override // java.io.InputStream
                public void reset() throws IOException {
                    this.position = this.mark;
                }

                @Override // java.io.InputStream
                public long skip(long j3) throws IOException {
                    int max = (int) Math.max(0L, Math.min(j3, MemoryDataStore.this.size - this.position));
                    this.position += max;
                    return max;
                }

                @Override // java.io.InputStream
                public int read(byte[] bArr) throws IOException {
                    int min = Math.min(bArr.length, MemoryDataStore.this.size - this.position);
                    if (min <= 0) {
                        return this.position >= MemoryDataStore.this.size ? -1 : 0;
                    }
                    System.arraycopy(MemoryDataStore.this.buf, this.position, bArr, 0, min);
                    this.position += min;
                    return min;
                }

                @Override // java.io.InputStream
                public int read(byte[] bArr, int i16, int i17) throws IOException {
                    int min = Math.min(i17, MemoryDataStore.this.size - this.position);
                    if (min <= 0) {
                        return this.position >= MemoryDataStore.this.size ? -1 : 0;
                    }
                    System.arraycopy(MemoryDataStore.this.buf, this.position, bArr, i16, min);
                    this.position += min;
                    return min;
                }
            };
        }
        throw new IllegalArgumentException();
    }

    public MemoryDataStore(int i3) {
        this.size = 0;
        this.buf = new byte[i3];
    }

    @Override // org.jf.dexlib2.writer.io.DexDataStore
    public void close() throws IOException {
    }
}
