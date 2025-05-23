package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class SilkCodecWrapper extends com.tencent.mobileqq.qqaudio.audioprocessor.a {
    private static boolean L = false;
    private int F;
    long G;
    boolean H;
    long I;
    int J;
    long K;

    public SilkCodecWrapper(Context context, boolean z16) {
        super(context);
        this.F = 0;
        e(z16);
    }

    private void e(boolean z16) {
        if (!L) {
            com.tencent.mobileqq.qqaudio.silk.a.c(this.f262200d, "codecsilk");
            L = true;
        }
        this.H = z16;
        this.I = 0L;
        this.J = 0;
        this.K = 0L;
    }

    public static boolean h() {
        return L;
    }

    public native long SilkDecoderNew(int i3, int i16);

    public native long SilkEncoderNew(int i3, int i16);

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public c.a a(byte[] bArr, int i3, int i16) throws IOException {
        long uptimeMillis = SystemClock.uptimeMillis();
        c.a a16 = super.a(bArr, i3, i16);
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (uptimeMillis2 > this.K) {
            this.K = uptimeMillis2;
        }
        this.I += uptimeMillis2;
        this.J++;
        return a16;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void b(int i3, int i16, int i17) throws IOException {
        super.b(i3, i16, i17);
        try {
            if (this.H) {
                this.G = SilkEncoderNew(i3, i16);
            } else {
                this.G = SilkDecoderNew(i3, i16);
            }
        } catch (UnsatisfiedLinkError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SilkCodecWrapper", 2, "init silk codec =" + e16.toString());
            }
            this.G = 0L;
            L = false;
        }
        int c16 = QQAudioUtils.c(i3);
        this.E = c16;
        this.f262203h = new byte[c16];
        this.f262204i = new byte[c16];
        byte[] bArr = new byte[c16];
        this.f262205m = bArr;
        this.C = new c.a(bArr, 0);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        g();
    }

    public native int decode(long j3, byte[] bArr, byte[] bArr2, int i3, int i16);

    public native void deleteCodec(long j3);

    public native int encode(long j3, byte[] bArr, byte[] bArr2, int i3);

    public int f(byte[] bArr, byte[] bArr2, int i3, int i16) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = this.G;
        if (j3 == 0) {
            if (!com.tencent.mobileqq.inject.a.f238063a.isDebugVersion()) {
                return 0;
            }
            throw new IllegalStateException("not open");
        }
        try {
            int decode = decode(j3, bArr, bArr2, i3, i16);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            this.I += uptimeMillis2;
            if (uptimeMillis2 > this.K) {
                this.K = uptimeMillis2;
            }
            this.J++;
            return decode;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }

    public void g() {
        int i3;
        long j3 = this.G;
        if (j3 != 0) {
            deleteCodec(j3);
            long j16 = this.I;
            if (j16 > 0 && (i3 = this.J) > 0) {
                if (this.H) {
                    com.tencent.mobileqq.qqaudio.b.d(j16, i3, this.K, 0);
                } else {
                    com.tencent.mobileqq.qqaudio.b.d(j16, i3, this.K, 1);
                }
            }
        }
        this.G = 0L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (this.G == 0) {
            if (!com.tencent.mobileqq.inject.a.f238063a.isDebugVersion()) {
                return 0;
            }
            throw new IllegalStateException("not open");
        }
        if (this.f262202f.read(this.f262203h, 0, this.E) == -1) {
            return -1;
        }
        if (this.H) {
            this.F = encode(this.G, this.f262203h, this.f262204i, this.E);
        }
        QQAudioUtils.g(this.F, bArr, i3);
        System.arraycopy(this.f262204i, 0, bArr, i3 + 2, this.F);
        return this.F + 2;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void release() throws IOException {
        super.release();
        g();
    }

    public SilkCodecWrapper(Context context) {
        super(context);
        this.F = 0;
        e(true);
    }
}
