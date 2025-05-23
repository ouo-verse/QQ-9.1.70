package com.tencent.libavif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AvifImage {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile long f118559a;

    /* renamed from: b, reason: collision with root package name */
    private long f118560b;

    public AvifImage(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.f118559a = j3;
            this.f118560b = j16;
        }
    }

    private static native int convertToNV21Data0(long j3, byte[] bArr);

    private static native void destroy0(long j3);

    private static native void getBitmap0(long j3, @NonNull Bitmap bitmap, boolean z16);

    private static native int getDepth0(long j3);

    private static native int getHeight0(long j3);

    private static native int getWidth0(long j3);

    private static native int getYuvFormat0(long j3);

    private static native int getYuvRange0(long j3);

    private static native boolean hasAlpha0(long j3);

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        byte[] bArr = new byte[(h() * g()) + (((h() + 1) / 2) * ((g() + 1) / 2) * 2)];
        convertToNV21Data0(this.f118559a, bArr);
        return bArr;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        synchronized (this) {
            if (this.f118559a != 0) {
                destroy0(this.f118559a);
                this.f118559a = 0L;
            }
        }
    }

    @NonNull
    public Bitmap c(Bitmap bitmap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bitmap) iPatchRedirector.redirect((short) 10, this, bitmap, Boolean.valueOf(z16));
        }
        getBitmap0(this.f118559a, bitmap, z16);
        return bitmap;
    }

    @NonNull
    public Bitmap d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
        Bitmap createBitmap = Bitmap.createBitmap(h(), g(), Bitmap.Config.ARGB_8888);
        getBitmap0(this.f118559a, createBitmap, z16);
        return createBitmap;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return getDepth0(this.f118559a);
    }

    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.f118560b;
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            b();
        } finally {
            super.finalize();
        }
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return getHeight0(this.f118559a);
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return getWidth0(this.f118559a);
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return getYuvFormat0(this.f118559a);
    }
}
