package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.FilterInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdInputStreamNoFinalizer extends FilterInputStream {
    private static final int F;
    private boolean C;
    private boolean D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private final long f32900d;

    /* renamed from: e, reason: collision with root package name */
    private long f32901e;

    /* renamed from: f, reason: collision with root package name */
    private long f32902f;

    /* renamed from: h, reason: collision with root package name */
    private long f32903h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32904i;

    /* renamed from: m, reason: collision with root package name */
    private final byte[] f32905m;

    static {
        Native.load();
        F = (int) recommendedDInSize();
    }

    private static native long createDStream();

    private native int decompressStream(long j3, byte[] bArr, int i3, byte[] bArr2, int i16);

    private static native int freeDStream(long j3);

    private native int initDStream(long j3);

    public static native long recommendedDInSize();

    public static native long recommendedDOutSize();

    int a(byte[] bArr, int i3, int i16) throws IOException {
        long j3;
        if (!this.E) {
            if (i3 >= 0 && i16 <= bArr.length - i3) {
                int i17 = i3 + i16;
                long j16 = i3;
                this.f32901e = j16;
                long j17 = -1;
                while (true) {
                    j3 = this.f32901e;
                    long j18 = i17;
                    if (j3 >= j18 || j17 >= j3) {
                        break;
                    }
                    boolean z16 = false;
                    if (this.f32904i && (((FilterInputStream) this).in.available() > 0 || this.f32901e == j16)) {
                        long read = ((FilterInputStream) this).in.read(this.f32905m, 0, F);
                        this.f32903h = read;
                        this.f32902f = 0L;
                        if (read < 0) {
                            this.f32903h = 0L;
                            if (this.D) {
                                return -1;
                            }
                            if (this.C) {
                                long j19 = (int) (this.f32901e - j16);
                                this.f32903h = j19;
                                if (j19 <= 0) {
                                    return -1;
                                }
                                return (int) j19;
                            }
                            throw new ZstdIOException(Zstd.errCorruptionDetected(), "Truncated source");
                        }
                        this.D = false;
                    }
                    long j26 = this.f32901e;
                    int decompressStream = decompressStream(this.f32900d, bArr, i17, this.f32905m, (int) this.f32903h);
                    long j27 = decompressStream;
                    if (!Zstd.isError(j27)) {
                        if (decompressStream == 0) {
                            this.D = true;
                            if (this.f32902f == this.f32903h) {
                                z16 = true;
                            }
                            this.f32904i = z16;
                            return (int) (this.f32901e - j16);
                        }
                        if (this.f32901e < j18) {
                            z16 = true;
                        }
                        this.f32904i = z16;
                        j17 = j26;
                    } else {
                        throw new ZstdIOException(j27);
                    }
                }
                return (int) (j3 - j16);
            }
            throw new IndexOutOfBoundsException("Requested length " + i16 + " from offset " + i3 + " in buffer of size " + bArr.length);
        }
        throw new IOException("Stream closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        if (!this.E) {
            if (!this.f32904i) {
                return 1;
            }
            return ((FilterInputStream) this).in.available();
        }
        throw new IOException("Stream closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.E) {
            this.E = true;
            throw null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i16) throws IOException {
        if (i3 >= 0) {
            if (i16 <= bArr.length - i3) {
                int i17 = 0;
                if (i16 == 0) {
                    return 0;
                }
                while (i17 == 0) {
                    i17 = a(bArr, i3, i16);
                }
                return i17;
            }
        }
        throw new IndexOutOfBoundsException("Requested length " + i16 + " from offset " + i3 + " in buffer of size " + bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        throw null;
     */
    @Override // java.io.FilterInputStream, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized long skip(long j3) throws IOException {
        if (!this.E) {
            if (j3 > 0) {
                int recommendedDOutSize = (int) recommendedDOutSize();
                if (recommendedDOutSize > j3) {
                    recommendedDOutSize = (int) j3;
                }
                byte[] array = Zstd.g(null, recommendedDOutSize).array();
                while (j3 > 0) {
                    int read = read(array, 0, (int) Math.min(recommendedDOutSize, j3));
                    if (read >= 0) {
                        j3 -= read;
                    } else {
                        throw null;
                    }
                }
                throw null;
            }
        } else {
            throw new IOException("Stream closed");
        }
        return 0L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = new byte[1];
        int i3 = 0;
        while (i3 == 0) {
            i3 = a(bArr, 0, 1);
        }
        if (i3 != 1) {
            return -1;
        }
        return bArr[0] & 255;
    }
}
