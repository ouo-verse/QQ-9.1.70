package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/av/ui/w;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", "getIntrinsicWidth", "getIntrinsicHeight", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", "cf", "setColorFilter", "getOpacity", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "mPaint", "b", "I", "mWidth", "c", "mHeight", "", "d", UserInfo.SEX_FEMALE, "mRadius", "Landroid/graphics/Bitmap;", "mBitmap", "radius", "width", "height", "<init>", "(Landroid/graphics/Bitmap;FII)V", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class w extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int mHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float mRadius;

    public w(@NotNull Bitmap mBitmap, float f16, int i3, int i16) {
        Intrinsics.checkNotNullParameter(mBitmap, "mBitmap");
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(mBitmap, tileMode, tileMode);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        this.mWidth = i3;
        this.mHeight = i16;
        this.mRadius = f16;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float f16 = this.mWidth;
        float f17 = this.mHeight;
        float f18 = this.mRadius;
        canvas.drawRoundRect(0.0f, 0.0f, f16, f17, f18, f18, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter cf5) {
        this.mPaint.setColorFilter(cf5);
    }
}
