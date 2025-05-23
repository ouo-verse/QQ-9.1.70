package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    float f258677a;

    /* renamed from: b, reason: collision with root package name */
    int f258678b;

    /* renamed from: c, reason: collision with root package name */
    int f258679c;

    /* renamed from: d, reason: collision with root package name */
    boolean f258680d;

    /* renamed from: e, reason: collision with root package name */
    int f258681e;

    /* renamed from: f, reason: collision with root package name */
    boolean f258682f;

    /* renamed from: g, reason: collision with root package name */
    boolean f258683g;

    public b(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f258682f = false;
        this.f258683g = false;
        this.f258678b = i3;
        this.f258679c = i16;
        this.f258677a = i3 / i16;
        this.f258681e = i17;
        if (i17 != 0 && i17 % 90 == 0) {
            this.f258680d = true;
        }
    }

    private boolean d(Bitmap bitmap) {
        if (e(bitmap)) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i3 = this.f258678b;
            if (width > i3 || height > i3) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean e(Bitmap bitmap) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float f16 = this.f258677a;
        if (width <= height * f16 && height <= width * f16) {
            return false;
        }
        return true;
    }

    private Bitmap f(Bitmap bitmap, int i3, int i16) {
        int i17;
        int i18;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (this.f258680d) {
            matrix.postRotate(this.f258681e, width >> 1, height >> 1);
            try {
                if (width > bitmap.getWidth()) {
                    i17 = bitmap.getWidth();
                } else {
                    i17 = width;
                }
                if (height > bitmap.getHeight()) {
                    i18 = bitmap.getHeight();
                } else {
                    i18 = height;
                }
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, i17, i18, matrix, true);
            } catch (OutOfMemoryError e16) {
                bitmap.recycle();
                e16.printStackTrace();
                h("keepShortSideAndClipLongSide rotate", "cut createBitmap OutOfMemoryError");
                return null;
            }
        }
        this.f258682f = true;
        int i19 = (int) (i16 * this.f258677a);
        if (width > height) {
            i19 = i16;
            i16 = i19;
        }
        try {
            if ((this.f258681e / 90) % 2 != 0) {
                int i26 = i19;
                i19 = i16;
                i16 = i26;
            }
            if (i16 > bitmap.getWidth()) {
                i16 = bitmap.getWidth();
            }
            if (i19 > bitmap.getHeight()) {
                i19 = bitmap.getHeight();
            }
            return Bitmap.createBitmap(bitmap, 0, 0, i16, i19);
        } catch (OutOfMemoryError e17) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            e17.printStackTrace();
            h("keepShortSideAndClipLongSide clip", "cut createBitmap OutOfMemoryError");
            return null;
        }
    }

    private Bitmap g(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (this.f258680d) {
            matrix.postRotate(this.f258681e, width >> 1, height >> 1);
            try {
                if (width > bitmap.getWidth()) {
                    width = bitmap.getWidth();
                }
                int i3 = width;
                if (height > bitmap.getHeight()) {
                    height = bitmap.getHeight();
                }
                return Bitmap.createBitmap(bitmap, 0, 0, i3, height, matrix, true);
            } catch (OutOfMemoryError e16) {
                bitmap.recycle();
                e16.printStackTrace();
                h("keepSide", "createBitmap OutOfMemoryError");
                return null;
            }
        }
        return bitmap;
    }

    public Bitmap a(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (d(bitmap) && (bitmap = b(bitmap)) != null) {
            width = bitmap.getWidth();
            height = bitmap.getHeight();
        }
        if (width <= height) {
            int i3 = height;
            height = width;
            width = i3;
        }
        if (e(bitmap)) {
            return f(bitmap, width, height);
        }
        if (width > this.f258678b) {
            return c(bitmap, width, height);
        }
        return g(bitmap);
    }

    Bitmap b(Bitmap bitmap) {
        int i3;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > height) {
            i3 = height;
        } else {
            i3 = width;
        }
        int i16 = (int) (i3 * this.f258677a);
        if (width > height) {
            i16 = i3;
            i3 = i16;
        }
        try {
            if (i3 > bitmap.getWidth()) {
                i3 = bitmap.getWidth();
            }
            if (i16 > bitmap.getHeight()) {
                i16 = bitmap.getHeight();
            }
            return Bitmap.createBitmap(bitmap, 0, 0, i3, i16);
        } catch (OutOfMemoryError e16) {
            bitmap.recycle();
            e16.printStackTrace();
            h("clipBigImg", "createBitmap OutOfMemoryError");
            return null;
        }
    }

    Bitmap c(Bitmap bitmap, int i3, int i16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        this.f258683g = true;
        float f16 = this.f258678b / (i3 * 1.0f);
        if (this.f258680d) {
            matrix.postRotate(this.f258681e, width >> 1, height >> 1);
        }
        matrix.postScale(f16, f16);
        try {
            if (width > bitmap.getWidth()) {
                width = bitmap.getWidth();
            }
            int i17 = width;
            if (height > bitmap.getHeight()) {
                height = bitmap.getHeight();
            }
            return Bitmap.createBitmap(bitmap, 0, 0, i17, height, matrix, true);
        } catch (OutOfMemoryError e16) {
            bitmap.recycle();
            e16.printStackTrace();
            h("clipLongSide", "createBitmap OutOfMemoryError");
            return null;
        }
    }

    void h(String str, String str2) {
        com.tencent.mobileqq.pic.f.d("ClipStrategy", str, str2);
    }
}
