package com.tencent.midas.comm.log.util.compressor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CachedByteArrayStream extends OutputStream {
    private final int BUFFER_SIZE;
    private final byte[] _bytes;
    protected byte[] buf;
    protected int count;

    public CachedByteArrayStream() {
        this.BUFFER_SIZE = 512;
        byte[] bArr = new byte[512];
        this._bytes = bArr;
        this.buf = bArr;
    }

    private static void checkOffsetAndCount(int i3, int i16, int i17) {
        if ((i16 | i17) >= 0 && i16 <= i3 && i3 - i16 >= i17) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("arrayLength: " + i3 + ", offset: " + i16 + ", count: " + i17);
    }

    private void expand(int i3) {
        int i16 = this.count;
        int i17 = i16 + i3;
        byte[] bArr = this.buf;
        if (i17 <= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[(i3 + i16) * 2];
        System.arraycopy(bArr, 0, bArr2, 0, i16);
        this.buf = bArr2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
    }

    public synchronized void reset() {
        this.buf = this._bytes;
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        byte[] bArr;
        int i3 = this.count;
        bArr = new byte[i3];
        System.arraycopy(this.buf, 0, bArr, 0, i3);
        return bArr;
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i16) {
        checkOffsetAndCount(bArr.length, i3, i16);
        if (i16 == 0) {
            return;
        }
        expand(i16);
        System.arraycopy(bArr, i3, this.buf, this.count, i16);
        this.count += i16;
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.buf, 0, this.count);
    }

    @Deprecated
    public String toString(int i3) {
        int size = size();
        char[] cArr = new char[size];
        for (int i16 = 0; i16 < size; i16++) {
            cArr[i16] = (char) (((i3 & 255) << 8) | (this.buf[i16] & 255));
        }
        return new String(cArr);
    }

    public CachedByteArrayStream(int i3) {
        this.BUFFER_SIZE = 512;
        this._bytes = new byte[512];
        if (i3 >= 0) {
            this.buf = new byte[i3];
            return;
        }
        throw new IllegalArgumentException("size < 0");
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.buf, 0, this.count, str);
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i3) {
        if (this.count == this.buf.length) {
            expand(1);
        }
        byte[] bArr = this.buf;
        int i16 = this.count;
        this.count = i16 + 1;
        bArr[i16] = (byte) i3;
    }
}
