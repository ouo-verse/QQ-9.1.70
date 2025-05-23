package com.tencent.libavif;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AvifDecoder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile long f118558a;

    AvifDecoder(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.f118558a = j3;
        }
    }

    private void a() {
        if (this.f118558a != 0) {
        } else {
            throw new IllegalStateException("Native Decoder already destroyed");
        }
    }

    public static AvifDecoder c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    private static native long createDecoderByteArray0(@NonNull byte[] bArr, int i3, int i16);

    private static native long createDecoderByteBuffer0(@NonNull ByteBuffer byteBuffer, int i3, int i16);

    public static AvifDecoder d(byte[] bArr, int i3, int i16) {
        long createDecoderByteArray0 = createDecoderByteArray0(bArr, i3, i16);
        if (createDecoderByteArray0 == 0) {
            return null;
        }
        return new AvifDecoder(createDecoderByteArray0);
    }

    private static native void destroy0(long j3);

    public static AvifDecoder e(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            if (!byteBuffer.isDirect()) {
                if (byteBuffer.hasArray()) {
                    return d(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                }
                throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
            }
            long createDecoderByteBuffer0 = createDecoderByteBuffer0(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
            if (createDecoderByteBuffer0 == 0) {
                return null;
            }
            return new AvifDecoder(createDecoderByteBuffer0);
        }
        throw new IllegalArgumentException("buffer==null");
    }

    private static native long getCropedImage0(long j3, int i3, int i16, int i17, int i18);

    private static native int getDepth0(long j3);

    private static native String getDiag0(long j3);

    private static native int getFormat0(@NonNull byte[] bArr, int i3, int i16);

    private static native int getHeight0(long j3);

    private static native long getImage0(long j3);

    private static native int getImageCount0(long j3);

    private static native long getImageDuration0(long j3);

    private static native int getImageIndex0(long j3);

    private static native int getImageLimit0(long j3);

    private static native long getNthImageDuration0(long j3, int i3);

    private static native long getRectedImage0(long j3, int i3, int i16, int i17, int i18, int i19);

    private static native long getScaledImage0(long j3, int i3, int i16);

    private static native int getWidth0(long j3);

    private static native boolean hasAlpha0(long j3);

    public static boolean m(byte[] bArr) {
        if (getFormat0(bArr, 0, bArr.length) != 13) {
            return false;
        }
        return true;
    }

    private static native int nextImage0(long j3);

    private static native int nthImage0(long j3, int i3);

    private static native void reset0(long j3);

    private static native boolean scaleImage0(long j3, int i3, int i16);

    private static native void setMaxThread0(long j3, int i3);

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        synchronized (this) {
            if (this.f118558a != 0) {
                destroy0(this.f118558a);
                this.f118558a = 0L;
            }
        }
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        a();
        return getHeight0(this.f118558a);
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        try {
            b();
        } finally {
            super.finalize();
        }
    }

    @NonNull
    public AvifImage g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AvifImage) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        a();
        return new AvifImage(getImage0(this.f118558a), getImageDuration0(this.f118558a));
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        a();
        return getImageCount0(this.f118558a);
    }

    public long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        a();
        return getImageDuration0(this.f118558a);
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        a();
        return getImageIndex0(this.f118558a);
    }

    @NonNull
    public AvifImage k(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AvifImage) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        a();
        return new AvifImage(getScaledImage0(this.f118558a, i3, i16), getImageDuration0(this.f118558a));
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        a();
        return getWidth0(this.f118558a);
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        a();
        return nextImage0(this.f118558a);
    }

    public int o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        a();
        return nthImage0(this.f118558a, i3);
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            a();
            reset0(this.f118558a);
        }
    }

    public boolean q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        a();
        return scaleImage0(this.f118558a, i3, i16);
    }
}
