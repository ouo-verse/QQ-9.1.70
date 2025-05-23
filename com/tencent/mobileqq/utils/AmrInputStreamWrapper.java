package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import java.io.IOException;
import java.io.PipedInputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class AmrInputStreamWrapper extends com.tencent.mobileqq.qqaudio.audioprocessor.a {
    private static boolean I = false;
    private int F;
    private long G;
    private long H;

    public AmrInputStreamWrapper(Context context) {
        super(context);
        this.F = 0;
        if (!I && SoLoadUtilNew.loadSoByName(context, "amrnb")) {
            I = true;
        }
        long CreateEncoder = CreateEncoder();
        this.G = CreateEncoder;
        long GsmAmrEncoderNew = GsmAmrEncoderNew(CreateEncoder);
        this.H = GsmAmrEncoderNew;
        GsmAmrEncoderInitialize(GsmAmrEncoderNew);
    }

    public static native int CreateDecoder();

    public static native long CreateEncoder();

    public static native void GsmAmrDecoderCleanup(long j3, long j16);

    public static native int GsmAmrDecoderDecode(long j3, long j16, byte[] bArr, int i3, byte[] bArr2, int i16) throws IOException;

    public static native void GsmAmrDecoderDelete(long j3, long j16);

    public static native void GsmAmrDecoderInitialize(long j3);

    public static native long GsmAmrDecoderNew(long j3);

    public static native void GsmAmrEncoderCleanup(long j3, long j16);

    public static native void GsmAmrEncoderDelete(long j3, long j16);

    public static native int GsmAmrEncoderEncode(long j3, long j16, int i3, byte[] bArr, int i16, byte[] bArr2, int i17) throws IOException;

    public static native void GsmAmrEncoderInitialize(long j3);

    public static native long GsmAmrEncoderNew(long j3);

    public static boolean e() {
        return I;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, com.tencent.mobileqq.qqaudio.audioprocessor.c
    public void b(int i3, int i16, int i17) throws IOException {
        super.b(i3, i16, i17);
        this.E = 320;
        this.f262203h = new byte[320];
        byte[] bArr = new byte[960];
        this.f262205m = bArr;
        this.C = new c.a(bArr, 0);
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.a, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            PipedInputStream pipedInputStream = this.f262202f;
            if (pipedInputStream != null) {
                pipedInputStream.close();
            }
            this.f262202f = null;
            try {
                long j3 = this.H;
                if (j3 != 0) {
                    GsmAmrEncoderCleanup(this.G, j3);
                }
                try {
                    long j16 = this.H;
                    if (j16 != 0) {
                        GsmAmrEncoderDelete(this.G, j16);
                    }
                } finally {
                }
            } catch (Throwable th5) {
                try {
                    long j17 = this.H;
                    if (j17 != 0) {
                        GsmAmrEncoderDelete(this.G, j17);
                    }
                    throw th5;
                } finally {
                }
            }
        } catch (Throwable th6) {
            this.f262202f = null;
            try {
                long j18 = this.H;
                if (j18 != 0) {
                    GsmAmrEncoderCleanup(this.G, j18);
                }
                try {
                    long j19 = this.H;
                    if (j19 != 0) {
                        GsmAmrEncoderDelete(this.G, j19);
                    }
                    throw th6;
                } finally {
                }
            } catch (Throwable th7) {
                try {
                    long j26 = this.H;
                    if (j26 != 0) {
                        GsmAmrEncoderDelete(this.G, j26);
                    }
                    throw th7;
                } finally {
                }
            }
        }
    }

    protected void finalize() {
        if (this.H != 0) {
            try {
                close();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (com.tencent.mobileqq.inject.a.f238063a.isDebugVersion()) {
                throw new IllegalStateException("someone forgot to close AmrInputStream");
            }
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        if (this.H != 0 && this.G != 0) {
            if (this.f262202f.read(this.f262203h, 0, this.E) == -1) {
                return -1;
            }
            long j3 = this.G;
            long j16 = this.H;
            byte[] bArr2 = this.f262203h;
            int GsmAmrEncoderEncode = GsmAmrEncoderEncode(j3, j16, 1, bArr2, 0, bArr2, 0);
            this.F = GsmAmrEncoderEncode;
            System.arraycopy(this.f262203h, 0, bArr, i3, GsmAmrEncoderEncode);
            return this.F;
        }
        throw new IllegalStateException("not open");
    }
}
