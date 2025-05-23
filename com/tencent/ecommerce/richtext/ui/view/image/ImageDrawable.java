package com.tencent.ecommerce.richtext.ui.view.image;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.tencent.ecommerce.richtext.utils.e;
import fk0.d;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageDrawable extends PaintDrawable {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f105429a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f105430b = new float[8];

    /* renamed from: c, reason: collision with root package name */
    private float f105431c;

    /* renamed from: d, reason: collision with root package name */
    private int f105432d;

    /* renamed from: e, reason: collision with root package name */
    private int f105433e;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(Drawable drawable, String str);
    }

    ImageDrawable() {
    }

    public static void d(final Drawable drawable, final ImageView.ScaleType scaleType, final String str, final int i3, final int i16, final int i17, final int i18, final a aVar, final boolean z16) {
        if (drawable != null && i3 >= 0 && i16 >= 0) {
            if (p()) {
                d.c().d(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageDrawable.m(drawable, scaleType, str, i3, i16, i17, i18, aVar, z16);
                    }
                });
            } else {
                m(drawable, scaleType, str, i3, i16, i17, i18, aVar, z16);
            }
        }
    }

    private static ImageDrawable e(Bitmap bitmap, ImageView.ScaleType scaleType, int i3, int i16) {
        ImageDrawable imageDrawable = new ImageDrawable();
        imageDrawable.f105433e = bitmap.getWidth();
        imageDrawable.f105432d = bitmap.getHeight();
        imageDrawable.q(bitmap);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        s(scaleType, i3, i16, imageDrawable, bitmapShader);
        imageDrawable.getPaint().setShader(bitmapShader);
        return imageDrawable;
    }

    public static ImageDrawable f(Drawable drawable, ImageView.ScaleType scaleType, int i3, int i16, boolean z16) {
        Bitmap k3;
        if (drawable == null) {
            return null;
        }
        if (z16) {
            k3 = l(drawable);
            if (k3 == null) {
                k3 = k(drawable, i3, i16, scaleType);
            }
        } else {
            k3 = k(drawable, i3, i16, scaleType);
        }
        if (k3 == null) {
            return null;
        }
        ImageDrawable imageDrawable = new ImageDrawable();
        imageDrawable.f105433e = k3.getWidth();
        imageDrawable.f105432d = k3.getHeight();
        imageDrawable.q(k3);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(k3, tileMode, tileMode);
        s(scaleType, i3, i16, imageDrawable, bitmapShader);
        imageDrawable.getPaint().setShader(bitmapShader);
        return imageDrawable;
    }

    public static void g(final Drawable drawable, final ImageView.ScaleType scaleType, final int i3, final int i16, final String str, final a aVar, final boolean z16) {
        if (drawable != null && i3 >= 0 && i16 >= 0) {
            if (p()) {
                d.c().d(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageDrawable.n(drawable, scaleType, i3, i16, str, aVar, z16);
                    }
                });
            } else {
                n(drawable, scaleType, i3, i16, str, aVar, z16);
            }
        }
    }

    public static void h(final Drawable drawable, final ImageView.ScaleType scaleType, final String str, final int i3, final int i16, final int i17, final int i18, final a aVar, final boolean z16) {
        if (drawable != null && i16 >= 0 && i17 >= 0) {
            if (p()) {
                d.c().d(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageDrawable.o(drawable, scaleType, str, i3, i16, i17, i18, aVar, z16);
                    }
                });
            } else {
                o(drawable, scaleType, str, i3, i16, i17, i18, aVar, z16);
            }
        }
    }

    private static Bitmap i(Drawable drawable, int i3, int i16, ImageView.ScaleType scaleType, int i17, boolean z16) {
        Bitmap k3;
        if (z16) {
            k3 = l(drawable);
            if (k3 == null) {
                k3 = k(drawable, i3, i16, scaleType);
            }
        } else {
            k3 = k(drawable, i3, i16, scaleType);
        }
        if (k3 != null && i3 != 0 && i16 != 0) {
            int i18 = i3 / i17;
            int i19 = i16 / i17;
            if (i18 == 0) {
                i18 = 40;
            }
            if (i19 == 0) {
                i19 = 40;
            }
            return Bitmap.createScaledBitmap(k3, i18, i19, false);
        }
        return null;
    }

    @NonNull
    private static Matrix j(@NonNull ImageView.ScaleType scaleType, int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18;
        if (i17 * i16 > i18 * i3) {
            f16 = i16 / i18;
            f18 = (i3 - (i17 * f16)) * 0.5f;
            f17 = 0.0f;
        } else {
            f16 = i3 / i17;
            f17 = (i16 - (i18 * f16)) * 0.5f;
            f18 = 0.0f;
        }
        Matrix matrix = new Matrix();
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            matrix.setScale(i3 / i17, i16 / i18);
        } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, i17, i18), new RectF(0.0f, 0.0f, i3, i16), Matrix.ScaleToFit.CENTER);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            matrix.setScale(f16, f16);
            matrix.postTranslate(f18 + 0.5f, f17 + 0.5f);
        }
        return matrix;
    }

    public static Bitmap k(Drawable drawable, int i3, int i16, ImageView.ScaleType scaleType) {
        Bitmap.Config config;
        try {
            if (drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    i3 = drawable.getIntrinsicWidth();
                    i16 = drawable.getIntrinsicHeight();
                } else {
                    if (i3 > drawable.getIntrinsicWidth()) {
                        i3 = drawable.getIntrinsicWidth();
                    }
                    if (i16 > drawable.getIntrinsicHeight()) {
                        i16 = drawable.getIntrinsicHeight();
                    }
                }
            }
            if (drawable.getOpacity() != -1) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, i3, i16);
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private static Bitmap l(Drawable drawable) {
        dk0.d a16 = d.c().a();
        if (a16 == null) {
            return null;
        }
        return a16.e(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(final Drawable drawable, ImageView.ScaleType scaleType, final String str, int i3, int i16, int i17, int i18, final a aVar, boolean z16) {
        try {
            final Bitmap i19 = i(drawable, i3, i16, scaleType, i18, z16);
            if (i19 != null) {
                e.d(i19, i17);
                d.c().e(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.a(new BitmapDrawable(i19), str);
                    }
                });
            }
        } catch (Throwable unused) {
            d.c().e(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(drawable, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(Drawable drawable, ImageView.ScaleType scaleType, int i3, int i16, final String str, final a aVar, boolean z16) {
        final ImageDrawable f16 = f(drawable, scaleType, i3, i16, z16);
        d.c().e(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(f16, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(final Drawable drawable, ImageView.ScaleType scaleType, final String str, int i3, int i16, int i17, int i18, final a aVar, boolean z16) {
        final ImageDrawable imageDrawable;
        try {
            Bitmap i19 = i(drawable, i16, i17, scaleType, i18, z16);
            if (i19 != null) {
                e.d(i19, i3);
                imageDrawable = e(i19, scaleType, i16, i17);
            } else {
                imageDrawable = null;
            }
            d.c().e(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(imageDrawable, str);
                }
            });
        } catch (Throwable unused) {
            d.c().e(new Runnable() { // from class: com.tencent.ecommerce.richtext.ui.view.image.ImageDrawable.8
                @Override // java.lang.Runnable
                public void run() {
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a(drawable, str);
                    }
                }
            });
        }
    }

    public static boolean p() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    private static void r(@NonNull ImageView.ScaleType scaleType, int i3, int i16, int i17, int i18, ImageDrawable imageDrawable, BitmapShader bitmapShader) {
        Matrix j3 = j(scaleType, i3, i16, i17, i18);
        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            RectF rectF = new RectF(0.0f, 0.0f, imageDrawable.f105433e, imageDrawable.f105432d);
            RectF rectF2 = new RectF();
            j3.mapRect(rectF2, rectF);
            i3 = (int) rectF2.width();
            i16 = (int) rectF2.height();
            j3 = j(scaleType, i3, i16, imageDrawable.f105433e, imageDrawable.f105432d);
        }
        imageDrawable.setIntrinsicWidth(i3);
        imageDrawable.setIntrinsicHeight(i16);
        bitmapShader.setLocalMatrix(j3);
    }

    private static void s(@NonNull ImageView.ScaleType scaleType, int i3, int i16, ImageDrawable imageDrawable, BitmapShader bitmapShader) {
        r(scaleType, i3, i16, imageDrawable.f105433e, imageDrawable.f105432d, imageDrawable, bitmapShader);
    }

    @Override // android.graphics.drawable.ShapeDrawable
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        super.onDraw(shape, canvas, paint);
    }

    public void q(Bitmap bitmap) {
        this.f105429a = bitmap;
    }

    @Override // android.graphics.drawable.PaintDrawable
    public void setCornerRadii(float[] fArr) {
        this.f105430b = fArr;
        super.setCornerRadii(fArr);
    }

    @Override // android.graphics.drawable.PaintDrawable
    public void setCornerRadius(float f16) {
        this.f105431c = f16;
        super.setCornerRadius(f16);
    }
}
