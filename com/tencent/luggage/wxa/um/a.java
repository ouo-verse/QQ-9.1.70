package com.tencent.luggage.wxa.um;

import com.tencent.luggage.wxa.lm.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements IDataSource {

    /* renamed from: e, reason: collision with root package name */
    private static final String f142821e = "MicroMsg.Audio.InputStreamByteBufferDataSource";

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f142822a;

    /* renamed from: b, reason: collision with root package name */
    private long f142823b;

    /* renamed from: c, reason: collision with root package name */
    private Object f142824c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private String f142825d;

    public a(ByteBuffer byteBuffer, String str) {
        this.f142822a = byteBuffer;
        this.f142825d = str;
    }

    public boolean a() {
        return i.o().k().c(this.f142825d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f142824c) {
            this.f142822a = null;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() throws IOException {
        if (this.f142822a == null) {
            return AudioFormat.AudioType.UNSUPPORT;
        }
        return FormatDetector.getAudioFormat((IDataSource) this, false);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() throws IOException {
        synchronized (this.f142824c) {
            synchronized (i.o().U) {
                if (this.f142822a != null && a()) {
                    return this.f142822a.limit();
                }
                return -1L;
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() throws IOException {
        synchronized (this.f142824c) {
            synchronized (i.o().U) {
                ByteBuffer byteBuffer = this.f142822a;
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                }
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        if (this.f142822a == null) {
            w.b(f142821e, "buffer is null");
            return -1;
        }
        if (getSize() <= 0) {
            w.b(f142821e, "getSize <= 0");
            return -1;
        }
        if (bArr != null && bArr.length > 0) {
            if (j3 >= 0 && i3 >= 0 && i16 > 0) {
                if (i3 + i16 > bArr.length) {
                    w.b(f142821e, "offset:%d, size:%d, bytes.length:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(bArr.length));
                    return -1;
                }
                if (i16 + j3 > getSize()) {
                    w.b(f142821e, "position:%d, size:%d, getSize():%d", Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(getSize()));
                }
                if (this.f142823b == 0) {
                    this.f142823b = getSize();
                }
                long j16 = this.f142823b;
                if (j16 > 0 && j3 > j16 && i16 > 0) {
                    return -1;
                }
                synchronized (this.f142824c) {
                    synchronized (i.o().U) {
                        if (this.f142822a == null || !a()) {
                            return -1;
                        }
                        this.f142822a.position((int) j3);
                        if (!this.f142822a.hasRemaining()) {
                            w.b(f142821e, "no remaining");
                            return -1;
                        }
                        int min = Math.min(i16, this.f142822a.remaining());
                        if (a()) {
                            this.f142822a.get(bArr, i3, min);
                        }
                        return min;
                    }
                }
            }
            w.b(f142821e, "position:%d, offset:%d, size:%d", Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return -1;
        }
        w.b(f142821e, "bytes is null");
        return -1;
    }
}
