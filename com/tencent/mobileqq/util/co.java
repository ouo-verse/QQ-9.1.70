package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class co {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f306666a = new a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements DownloadParams.DecodeHandler {
        a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            int i3;
            int i16;
            if (bitmap == null) {
                return null;
            }
            if (downloadParams != null && (i3 = downloadParams.reqWidth) >= 0 && (i16 = downloadParams.reqHeight) >= 0) {
                return co.e(bitmap, i3, i16);
            }
            return co.d(bitmap);
        }
    }

    @NonNull
    private static Matrix a(int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        Matrix matrix = new Matrix();
        if (i3 == i17 && i16 == i18) {
            return matrix;
        }
        float f18 = 0.0f;
        if (i3 * i18 > i17 * i16) {
            f17 = i18 / i16;
            float f19 = (i17 - (i3 * f17)) * 0.5f;
            f16 = 0.0f;
            f18 = f19;
        } else {
            float f26 = i17 / i3;
            f16 = (i18 - (i16 * f26)) * 0.5f;
            f17 = f26;
        }
        matrix.setScale(f17, f17);
        matrix.postTranslate(Math.round(f18), Math.round(f16));
        return matrix;
    }

    @NonNull
    public static Path b(int i3, int i16) {
        Path path = new Path();
        if (i3 > 0 && i16 > 0) {
            float f16 = i3;
            float f17 = i16;
            float min = Math.min(f16 * 0.0618f, 0.0618f * f17);
            float f18 = f16 / 2.0f;
            float f19 = f17 / 2.0f;
            path.moveTo(0.0f, f19);
            path.cubicTo(0.0f, min, min, 0.0f, f18, 0.0f);
            float f26 = f16 - min;
            path.cubicTo(f26, 0.0f, f16, min, f16, f19);
            float f27 = f17 - min;
            path.cubicTo(f16, f27, f26, f17, f18, f17);
            path.cubicTo(min, f17, 0.0f, f27, 0.0f, f19);
        }
        return path;
    }

    public static Bitmap c(int i3, int i16, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i3, i16, config);
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap d(@NonNull Bitmap bitmap) {
        return e(bitmap, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap e(@NonNull Bitmap bitmap, int i3, int i16) {
        Bitmap c16;
        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            if ((i3 > 0 || i16 > 0) && (c16 = c(i3, i16, Bitmap.Config.ARGB_8888)) != null) {
                return f(bitmap, c16, i3, i16);
            }
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap f(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            bitmap2.setDensity((int) ViewUtils.getDensityDpi());
            Canvas canvas = new Canvas(bitmap2);
            Path b16 = b(i3, i16);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(a(bitmap.getWidth(), bitmap.getHeight(), i3, i16));
            Paint paint = new Paint();
            paint.setShader(bitmapShader);
            paint.setAntiAlias(true);
            canvas.drawPath(b16, paint);
            return bitmap2;
        }
        return bitmap;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends Drawable {

        /* renamed from: a, reason: collision with root package name */
        private Path f306667a;

        /* renamed from: b, reason: collision with root package name */
        private Paint f306668b;

        /* renamed from: c, reason: collision with root package name */
        private int f306669c;

        /* renamed from: d, reason: collision with root package name */
        private int f306670d;

        /* renamed from: e, reason: collision with root package name */
        private int f306671e;

        public b(int i3, int i16, int i17) {
            if (i16 > 0 && i17 > 0) {
                this.f306670d = i16;
                this.f306671e = i17;
                this.f306667a = co.b(i16, i17);
            }
            this.f306669c = i3;
            Paint paint = new Paint();
            this.f306668b = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f306668b.setAntiAlias(true);
            this.f306668b.setColor(this.f306669c);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            Rect bounds = getBounds();
            int i3 = bounds.right - bounds.left;
            int i16 = bounds.bottom - bounds.top;
            if (i3 != this.f306670d && i16 != this.f306671e) {
                this.f306670d = i3;
                this.f306671e = i16;
                this.f306667a = co.b(i3, i16);
            }
            canvas.save();
            canvas.translate(bounds.left, bounds.top);
            canvas.drawPath(this.f306667a, this.f306668b);
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            int i3 = this.f306669c >>> 24;
            if (i3 != 0) {
                if (i3 != 255) {
                    return -3;
                }
                return -1;
            }
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }
}
