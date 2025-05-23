package com.tencent.mobileqq.guild.discover.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 -2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/discover/widget/c;", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "context", "", "drawableId", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "getIntrinsicWidth", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "b", "Landroid/graphics/Bitmap;", "getMHolderBitmap", "()Landroid/graphics/Bitmap;", "setMHolderBitmap", "(Landroid/graphics/Bitmap;)V", "mHolderBitmap", "Landroid/graphics/Rect;", "c", "Landroid/graphics/Rect;", "getMHoldRect", "()Landroid/graphics/Rect;", "setMHoldRect", "(Landroid/graphics/Rect;)V", "mHoldRect", "d", "getMShowRect", "setMShowRect", "mShowRect", "<init>", "()V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends Drawable {

    /* renamed from: f, reason: collision with root package name */
    private static int f216575f = 996;

    /* renamed from: g, reason: collision with root package name */
    private static float f216576g = 124.0f;

    /* renamed from: h, reason: collision with root package name */
    private static float f216577h = 113.0f;

    /* renamed from: i, reason: collision with root package name */
    private static int f216578i = Color.parseColor("#E3E3E3");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint = new Paint();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Bitmap mHolderBitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Rect mHoldRect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Rect mShowRect;

    public c() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        this.mHolderBitmap = a(context, R.drawable.guild_rec_cover_place_holder);
        this.mHoldRect = new Rect();
        this.mShowRect = new Rect();
    }

    private final Bitmap a(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.bitmap");
                return bitmap;
            }
            Bitmap bitmap2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap2);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
            return bitmap2;
        }
        throw new IllegalArgumentException("[GuildSearchRecHolderVie] [getBitmapFromDrawable] unsupported drawable type".toString());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawColor(f216578i);
        int width = canvas.getClipBounds().width();
        int height = canvas.getClipBounds().height();
        float f16 = width;
        float f17 = (1.0f * f16) / f216575f;
        float f18 = f216576g * f17;
        float f19 = f216577h * f17;
        float f26 = 2;
        canvas.translate((f16 - f18) / f26, (height - f19) / f26);
        this.mHoldRect.set(0, 0, this.mHolderBitmap.getWidth(), this.mHolderBitmap.getHeight());
        this.mShowRect.set(0, 0, (int) f18, (int) f19);
        canvas.drawBitmap(this.mHolderBitmap, this.mHoldRect, this.mShowRect, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return f216575f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (this.mPaint.getAlpha() == alpha) {
            return;
        }
        this.mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
