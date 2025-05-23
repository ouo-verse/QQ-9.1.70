package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: d, reason: collision with root package name */
    private volatile byte[] f31793d;

    /* renamed from: e, reason: collision with root package name */
    private int f31794e;

    /* renamed from: f, reason: collision with root package name */
    private int f31795f;

    /* renamed from: h, reason: collision with root package name */
    private int f31796h;

    /* renamed from: i, reason: collision with root package name */
    private int f31797i;

    /* renamed from: m, reason: collision with root package name */
    private final r.b f31798m;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull r.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i3 = this.f31796h;
        if (i3 != -1) {
            int i16 = this.f31797i - i3;
            int i17 = this.f31795f;
            if (i16 < i17) {
                if (i3 == 0 && i17 > bArr.length && this.f31794e == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i17) {
                        i17 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f31798m.b(i17, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f31793d = bArr2;
                    this.f31798m.put(bArr);
                    bArr = bArr2;
                } else if (i3 > 0) {
                    System.arraycopy(bArr, i3, bArr, 0, bArr.length - i3);
                }
                int i18 = this.f31797i - this.f31796h;
                this.f31797i = i18;
                this.f31796h = 0;
                this.f31794e = 0;
                int read = inputStream.read(bArr, i18, bArr.length - i18);
                int i19 = this.f31797i;
                if (read > 0) {
                    i19 += read;
                }
                this.f31794e = i19;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f31796h = -1;
            this.f31797i = 0;
            this.f31794e = read2;
        }
        return read2;
    }

    private static IOException e() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f31793d != null && inputStream != null) {
        } else {
            throw e();
        }
        return (this.f31794e - this.f31797i) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f31793d != null) {
            this.f31798m.put(this.f31793d);
            this.f31793d = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void d() {
        this.f31795f = this.f31793d.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        this.f31795f = Math.max(this.f31795f, i3);
        this.f31796h = this.f31797i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f31793d;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f31797i >= this.f31794e && a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.f31793d && (bArr = this.f31793d) == null) {
                throw e();
            }
            int i3 = this.f31794e;
            int i16 = this.f31797i;
            if (i3 - i16 <= 0) {
                return -1;
            }
            this.f31797i = i16 + 1;
            return bArr[i16] & 255;
        }
        throw e();
    }

    public synchronized void release() {
        if (this.f31793d != null) {
            this.f31798m.put(this.f31793d);
            this.f31793d = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f31793d != null) {
            int i3 = this.f31796h;
            if (-1 != i3) {
                this.f31797i = i3;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f31797i + " markLimit: " + this.f31795f);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j3) throws IOException {
        if (j3 < 1) {
            return 0L;
        }
        byte[] bArr = this.f31793d;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i3 = this.f31794e;
                int i16 = this.f31797i;
                if (i3 - i16 >= j3) {
                    this.f31797i = (int) (i16 + j3);
                    return j3;
                }
                long j16 = i3 - i16;
                this.f31797i = i3;
                if (this.f31796h != -1 && j3 <= this.f31795f) {
                    if (a(inputStream, bArr) == -1) {
                        return j16;
                    }
                    int i17 = this.f31794e;
                    int i18 = this.f31797i;
                    if (i17 - i18 >= j3 - j16) {
                        this.f31797i = (int) ((i18 + j3) - j16);
                        return j3;
                    }
                    long j17 = (j16 + i17) - i18;
                    this.f31797i = i17;
                    return j17;
                }
                long skip = inputStream.skip(j3 - j16);
                if (skip > 0) {
                    this.f31796h = -1;
                }
                return j16 + skip;
            }
            throw e();
        }
        throw e();
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull r.b bVar, int i3) {
        super(inputStream);
        this.f31796h = -1;
        this.f31798m = bVar;
        this.f31793d = (byte[]) bVar.b(i3, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i3, int i16) throws IOException {
        int i17;
        int i18;
        byte[] bArr2 = this.f31793d;
        if (bArr2 == null) {
            throw e();
        }
        if (i16 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i19 = this.f31797i;
            int i26 = this.f31794e;
            if (i19 < i26) {
                int i27 = i26 - i19 >= i16 ? i16 : i26 - i19;
                System.arraycopy(bArr2, i19, bArr, i3, i27);
                this.f31797i += i27;
                if (i27 == i16 || inputStream.available() == 0) {
                    return i27;
                }
                i3 += i27;
                i17 = i16 - i27;
            } else {
                i17 = i16;
            }
            while (true) {
                if (this.f31796h == -1 && i17 >= bArr2.length) {
                    i18 = inputStream.read(bArr, i3, i17);
                    if (i18 == -1) {
                        return i17 != i16 ? i16 - i17 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i17 != i16 ? i16 - i17 : -1;
                    }
                    if (bArr2 != this.f31793d && (bArr2 = this.f31793d) == null) {
                        throw e();
                    }
                    int i28 = this.f31794e;
                    int i29 = this.f31797i;
                    i18 = i28 - i29 >= i17 ? i17 : i28 - i29;
                    System.arraycopy(bArr2, i29, bArr, i3, i18);
                    this.f31797i += i18;
                }
                i17 -= i18;
                if (i17 == 0) {
                    return i16;
                }
                if (inputStream.available() == 0) {
                    return i16 - i17;
                }
                i3 += i18;
            }
        } else {
            throw e();
        }
    }
}
