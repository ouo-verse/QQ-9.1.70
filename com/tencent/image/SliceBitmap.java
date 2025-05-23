package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.DisplayMetrics;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SliceBitmap {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_TEXTURE_BITMAP_SIZE = 2048;
    public static final int DENSITY_NONE = 0;
    private static final int SLICE_SIZE = 2048;
    public static final String TAG_REPORT_TEXTURE_MAX_SIZE = "texture_max_size";
    public static int gl_max_texture_size;
    boolean hasAlpha;
    Bitmap[] mBitmaps;
    int mChangingConfigurations;
    int mColumnCount;
    int mDensity;
    int mHeight;
    int mRowCount;
    int mWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11497);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            gl_max_texture_size = 0;
        }
    }

    public SliceBitmap(Bitmap bitmap) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmap);
            return;
        }
        if (needSlice(bitmap)) {
            this.mWidth = bitmap.getWidth();
            this.mHeight = bitmap.getHeight();
            this.mDensity = bitmap.getDensity();
            this.hasAlpha = bitmap.hasAlpha();
            int i17 = ((this.mWidth + 2048) - 1) / 2048;
            this.mRowCount = i17;
            int i18 = ((this.mHeight + 2048) - 1) / 2048;
            this.mColumnCount = i18;
            Bitmap[] bitmapArr = new Bitmap[i17 * i18];
            int i19 = 0;
            for (int i26 = 0; i26 < this.mRowCount; i26++) {
                for (int i27 = 0; i27 < this.mColumnCount; i27++) {
                    int i28 = i26 * 2048;
                    int i29 = i27 * 2048;
                    int i36 = i28 + 2048;
                    int i37 = this.mWidth;
                    if (i36 > i37) {
                        i3 = i37 - i28;
                    } else {
                        i3 = 2048;
                    }
                    int i38 = i29 + 2048;
                    int i39 = this.mHeight;
                    if (i38 > i39) {
                        i16 = i39 - i29;
                    } else {
                        i16 = 2048;
                    }
                    bitmapArr[i19] = Bitmap.createBitmap(bitmap, i28, i29, i3, i16);
                    i19++;
                }
            }
            this.mBitmaps = bitmapArr;
            return;
        }
        throw new IllegalArgumentException("the bitmap no need to Slice");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getTextureBitmapMaxSize() {
        EGLDisplay eGLDisplay;
        EGLSurface eGLSurface;
        EGLContext eGLContext;
        EGLDisplay eglGetDisplay;
        EGLContext eglCreateContext;
        int i3 = 2048;
        try {
            eglGetDisplay = EGL14.eglGetDisplay(0);
        } catch (Throwable th5) {
            th = th5;
            eGLDisplay = null;
        }
        try {
            int[] iArr = new int[2];
            EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            EGL14.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
            if (iArr2[0] == 0) {
                if (eglGetDisplay != null) {
                    EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eglGetDisplay, eGLSurface2, eGLSurface2, EGL14.EGL_NO_CONTEXT);
                    EGL14.eglTerminate(eglGetDisplay);
                }
                return 2048;
            }
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, 64, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, 64, 12344}, 0);
            try {
                eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
            } catch (Throwable th6) {
                th = th6;
                eGLSurface = eglCreatePbufferSurface;
                eGLDisplay = eglGetDisplay;
                eGLContext = null;
                try {
                    th.printStackTrace();
                    if (eGLDisplay != null) {
                    }
                    return 2048;
                } finally {
                }
            }
            try {
                EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
                int[] iArr3 = new int[1];
                GLES20.glGetIntegerv(3379, iArr3, 0);
                int i16 = iArr3[0];
                if (i16 > 2048) {
                    i3 = i16;
                }
                if (eglGetDisplay != null) {
                    EGLSurface eGLSurface3 = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eglGetDisplay, eGLSurface3, eGLSurface3, EGL14.EGL_NO_CONTEXT);
                    if (eglCreatePbufferSurface != null) {
                        EGL14.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
                    }
                    if (eglCreateContext != null) {
                        EGL14.eglDestroyContext(eglGetDisplay, eglCreateContext);
                    }
                    EGL14.eglTerminate(eglGetDisplay);
                }
                return i3;
            } catch (Throwable th7) {
                th = th7;
                eGLContext = eglCreateContext;
                eGLSurface = eglCreatePbufferSurface;
                eGLDisplay = eglGetDisplay;
                th.printStackTrace();
                if (eGLDisplay != null) {
                    EGLSurface eGLSurface4 = EGL14.EGL_NO_SURFACE;
                    EGL14.eglMakeCurrent(eGLDisplay, eGLSurface4, eGLSurface4, EGL14.EGL_NO_CONTEXT);
                    if (eGLSurface != null) {
                        EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
                    }
                    if (eGLContext != null) {
                        EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                    }
                    EGL14.eglTerminate(eGLDisplay);
                }
                return 2048;
            }
        } catch (Throwable th8) {
            th = th8;
            eGLDisplay = eglGetDisplay;
            eGLSurface = null;
            eGLContext = null;
            th.printStackTrace();
            if (eGLDisplay != null) {
            }
            return 2048;
        }
    }

    public static boolean needSlice(Bitmap bitmap) {
        if (bitmap.getWidth() <= 2048 && bitmap.getHeight() <= 2048) {
            return false;
        }
        return true;
    }

    public static boolean needSliceBitmap(Bitmap bitmap) {
        if (gl_max_texture_size == 0) {
            gl_max_texture_size = getTextureBitmapMaxSize();
            ReportBean reportBean = new ReportBean(TAG_REPORT_TEXTURE_MAX_SIZE);
            reportBean.size = gl_max_texture_size;
            URLDrawable.depImp.mReport.report(reportBean);
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.i(URLDrawable.TAG, 2, "init TextureBitmapMaxSize:" + gl_max_texture_size);
            }
        }
        if (bitmap.getWidth() <= gl_max_texture_size && bitmap.getHeight() <= gl_max_texture_size) {
            return false;
        }
        return true;
    }

    public static int scaleFromDensity(int i3, int i16, int i17) {
        if (i16 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void draw(Canvas canvas, Rect rect, Paint paint) {
        int save = canvas.save();
        boolean isHardwareAccelerated = canvas.isHardwareAccelerated();
        int density = canvas.getDensity();
        canvas.translate(rect.left, rect.top);
        if (rect.width() != this.mWidth || rect.height() != this.mHeight) {
            canvas.scale(rect.width() / this.mWidth, rect.height() / this.mHeight);
        }
        if (!isHardwareAccelerated) {
            canvas.setDensity(this.mDensity);
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.mRowCount; i16++) {
            for (int i17 = 0; i17 < this.mColumnCount; i17++) {
                Bitmap bitmap = this.mBitmaps[i3];
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, i16 * 2048, i17 * 2048, paint);
                }
                i3++;
            }
        }
        if (!isHardwareAccelerated) {
            canvas.setDensity(density);
        }
        canvas.restoreToCount(save);
    }

    public Bitmap getBitmap(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Bitmap) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        Bitmap[] bitmapArr = this.mBitmaps;
        if (bitmapArr != null && bitmapArr.length > i3) {
            return bitmapArr[i3];
        }
        return null;
    }

    public final int getByteCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        int i3 = 0;
        for (Bitmap bitmap : this.mBitmaps) {
            i3 += Utils.getBitmapSize(bitmap);
        }
        return i3;
    }

    public int getColumnCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mColumnCount;
    }

    public final int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    public int getRowCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mRowCount;
    }

    public int getScaledHeight(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? scaleFromDensity(getHeight(), this.mDensity, canvas.getDensity()) : ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas)).intValue();
    }

    public int getScaledWidth(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? scaleFromDensity(getWidth(), this.mDensity, canvas.getDensity()) : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas)).intValue();
    }

    public final int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    public final boolean hasAlpha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.hasAlpha;
    }

    public void recyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        for (Bitmap bitmap : this.mBitmaps) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    public int getScaledHeight(DisplayMetrics displayMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? scaleFromDensity(getHeight(), this.mDensity, displayMetrics.densityDpi) : ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) displayMetrics)).intValue();
    }

    public int getScaledWidth(DisplayMetrics displayMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? scaleFromDensity(getWidth(), this.mDensity, displayMetrics.densityDpi) : ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) displayMetrics)).intValue();
    }

    public int getScaledHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? scaleFromDensity(getHeight(), this.mDensity, i3) : ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
    }

    public int getScaledWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? scaleFromDensity(getWidth(), this.mDensity, i3) : ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
    }
}
