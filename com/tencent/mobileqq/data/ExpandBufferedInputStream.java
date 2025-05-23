package com.tencent.mobileqq.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ExpandBufferedInputStream extends FilterInputStream {
    private static final AtomicReferenceFieldUpdater<ExpandBufferedInputStream, byte[]> bufUpdater = AtomicReferenceFieldUpdater.newUpdater(ExpandBufferedInputStream.class, byte[].class, "buf");
    private static int defaultBufferSize = 8192;
    protected volatile byte[] buf;
    protected int count;
    protected int marklimit;
    protected int markpos;
    protected int pos;

    public ExpandBufferedInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.markpos = -1;
        if (bArr != null && bArr.length > 0) {
            this.buf = bArr;
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    private void fill() throws IOException {
        byte[] bufIfOpen = getBufIfOpen();
        int i3 = this.markpos;
        if (i3 < 0) {
            this.pos = 0;
        } else {
            int i16 = this.pos;
            if (i16 >= bufIfOpen.length) {
                if (i3 > 0) {
                    int i17 = i16 - i3;
                    System.arraycopy(bufIfOpen, i3, bufIfOpen, 0, i17);
                    this.pos = i17;
                    this.markpos = 0;
                } else {
                    int length = bufIfOpen.length;
                    int i18 = this.marklimit;
                    if (length >= i18) {
                        this.markpos = -1;
                        this.pos = 0;
                    } else {
                        int i19 = i16 * 2;
                        if (i19 <= i18) {
                            i18 = i19;
                        }
                        byte[] bArr = new byte[i18];
                        System.arraycopy(bufIfOpen, 0, bArr, 0, i16);
                        if (com.google.common.util.concurrent.b.a(bufUpdater, this, bufIfOpen, bArr)) {
                            bufIfOpen = bArr;
                        } else {
                            throw new IOException("Stream closed");
                        }
                    }
                }
            }
        }
        this.count = this.pos;
        InputStream inIfOpen = getInIfOpen();
        int i26 = this.pos;
        int read = inIfOpen.read(bufIfOpen, i26, bufIfOpen.length - i26);
        if (read > 0) {
            this.count = read + this.pos;
        }
    }

    private byte[] getBufIfOpen() throws IOException {
        byte[] bArr = this.buf;
        if (bArr != null) {
            return bArr;
        }
        throw new IOException("Stream closed");
    }

    private InputStream getInIfOpen() throws IOException {
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            return inputStream;
        }
        throw new IOException("Stream closed");
    }

    private int read1(byte[] bArr, int i3, int i16) throws IOException {
        int i17 = this.count - this.pos;
        if (i17 <= 0) {
            if (i16 >= getBufIfOpen().length && this.markpos < 0) {
                return getInIfOpen().read(bArr, i3, i16);
            }
            fill();
            i17 = this.count - this.pos;
            if (i17 <= 0) {
                return -1;
            }
        }
        if (i17 < i16) {
            i16 = i17;
        }
        System.arraycopy(getBufIfOpen(), this.pos, bArr, i3, i16);
        this.pos += i16;
        return i16;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        int i3;
        int i16 = this.count - this.pos;
        int available = getInIfOpen().available();
        i3 = Integer.MAX_VALUE;
        if (i16 <= Integer.MAX_VALUE - available) {
            i3 = i16 + available;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] bArr;
        do {
            bArr = this.buf;
            if (bArr == null) {
                return;
            }
        } while (!com.google.common.util.concurrent.b.a(bufUpdater, this, bArr, null));
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        this.marklimit = i3;
        this.markpos = this.pos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.pos >= this.count) {
            fill();
            if (this.pos >= this.count) {
                return -1;
            }
        }
        byte[] bufIfOpen = getBufIfOpen();
        int i3 = this.pos;
        this.pos = i3 + 1;
        return bufIfOpen[i3] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        getBufIfOpen();
        int i3 = this.markpos;
        if (i3 >= 0) {
            this.pos = i3;
        } else {
            throw new IOException("Resetting to invalid mark");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j3) throws IOException {
        getBufIfOpen();
        if (j3 <= 0) {
            return 0L;
        }
        long j16 = this.count - this.pos;
        if (j16 <= 0) {
            if (this.markpos < 0) {
                return getInIfOpen().skip(j3);
            }
            fill();
            j16 = this.count - this.pos;
            if (j16 <= 0) {
                return 0L;
            }
        }
        if (j16 < j3) {
            j3 = j16;
        }
        this.pos = (int) (this.pos + j3);
        return j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i16) throws IOException {
        getBufIfOpen();
        int i17 = i3 + i16;
        if ((i3 | i16 | i17 | (bArr.length - i17)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i18 = 0;
        if (i16 == 0) {
            return 0;
        }
        while (true) {
            int read1 = read1(bArr, i3 + i18, i16 - i18);
            if (read1 <= 0) {
                if (i18 == 0) {
                    i18 = read1;
                }
                return i18;
            }
            i18 += read1;
            if (i18 >= i16) {
                return i18;
            }
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null && inputStream.available() <= 0) {
                return i18;
            }
        }
    }
}
