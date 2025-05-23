package com.tencent.gdtad.views.image;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtCircle {
    Bitmap bitmap;
    private Paint paint;
    private int width = 0;
    private int height = 0;

    /* renamed from: cx, reason: collision with root package name */
    private float f109626cx = 0.0f;

    /* renamed from: cy, reason: collision with root package name */
    private float f109627cy = 0.0f;
    private float radius = 0.0f;

    public GdtCircle() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (this.bitmap == null) {
            this.bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.bitmap);
        drawable.setBounds(0, 0, this.width, this.height);
        drawable.draw(canvas);
        return this.bitmap;
    }

    public void draw(@Nullable Canvas canvas, @Nullable Drawable drawable) {
        if (canvas != null && drawable != null) {
            Bitmap drawableToBitamp = drawableToBitamp(drawable);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.paint.setShader(new BitmapShader(drawableToBitamp, tileMode, tileMode));
            canvas.drawCircle(this.f109626cx, this.f109627cy, this.radius, this.paint);
        }
    }

    public void setCenter(float f16, float f17) {
        this.f109626cx = f16;
        this.f109627cy = f17;
    }

    public void setRadius(float f16) {
        this.radius = f16;
    }

    public void setSize(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }
}
