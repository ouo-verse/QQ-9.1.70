package com.tencent.biz.richframework.util;

import androidx.annotation.NonNull;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RecycleableBufferedOutputStream extends FilterOutputStream {
    private static final Object POOL_LOCK = new Object();
    private static int poolSize;
    private static RecycleableBufferedOutputStream sPool;
    protected byte[] buf;
    protected int count;
    private RecycleableBufferedOutputStream next;
    private boolean used;

    RecycleableBufferedOutputStream(@NonNull OutputStream outputStream) {
        this(outputStream, 8192);
    }

    private void checkNotClosed() throws IOException {
        if (this.used) {
        } else {
            throw new IOException("BufferedOutputStream is closed");
        }
    }

    public static void checkOffsetAndCount(int i3, int i16, int i17) {
        if ((i16 | i17) >= 0 && i16 <= i3 && i3 - i16 >= i17) {
            return;
        }
        throw new IndexOutOfBoundsException("length=" + i3 + "; regionStart=" + i16 + "; regionLength=" + i17);
    }

    private void clearForRecycle() {
        this.count = 0;
        ((FilterOutputStream) this).out = null;
        this.used = false;
    }

    private void flushInternal() throws IOException {
        int i3 = this.count;
        if (i3 > 0) {
            ((FilterOutputStream) this).out.write(this.buf, 0, i3);
            this.count = 0;
        }
    }

    public static RecycleableBufferedOutputStream obtain(@NonNull OutputStream outputStream) {
        RecycleableBufferedOutputStream recycleableBufferedOutputStream;
        synchronized (POOL_LOCK) {
            recycleableBufferedOutputStream = sPool;
            if (recycleableBufferedOutputStream != null) {
                sPool = recycleableBufferedOutputStream.next;
                recycleableBufferedOutputStream.next = null;
                poolSize--;
            } else {
                recycleableBufferedOutputStream = null;
            }
        }
        if (recycleableBufferedOutputStream != null) {
            ((FilterOutputStream) recycleableBufferedOutputStream).out = outputStream;
            recycleableBufferedOutputStream.used = true;
            return recycleableBufferedOutputStream;
        }
        return new RecycleableBufferedOutputStream(outputStream);
    }

    private void recycle() {
        clearForRecycle();
        synchronized (POOL_LOCK) {
            int i3 = poolSize;
            if (i3 < 4) {
                this.next = sPool;
                sPool = this;
                poolSize = i3 + 1;
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.used) {
            return;
        }
        try {
            flush();
            ((FilterOutputStream) this).out.close();
        } finally {
            recycle();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        checkNotClosed();
        flushInternal();
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i3) throws IOException {
        checkNotClosed();
        int i16 = this.count;
        byte[] bArr = this.buf;
        if (i16 == bArr.length) {
            ((FilterOutputStream) this).out.write(bArr, 0, i16);
            this.count = 0;
        }
        byte[] bArr2 = this.buf;
        int i17 = this.count;
        this.count = i17 + 1;
        bArr2[i17] = (byte) i3;
    }

    RecycleableBufferedOutputStream(@NonNull OutputStream outputStream, int i3) {
        super(outputStream);
        this.buf = ByteArrayPool.getGenericInstance().getBuf(i3);
        this.used = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i16) throws IOException {
        checkNotClosed();
        if (bArr != null) {
            byte[] bArr2 = this.buf;
            if (i16 >= bArr2.length) {
                flushInternal();
                ((FilterOutputStream) this).out.write(bArr, i3, i16);
                return;
            }
            checkOffsetAndCount(bArr.length, i3, i16);
            if (i16 > bArr2.length - this.count) {
                flushInternal();
            }
            System.arraycopy(bArr, i3, bArr2, this.count, i16);
            this.count += i16;
            return;
        }
        throw new NullPointerException("buffer == null");
    }
}
