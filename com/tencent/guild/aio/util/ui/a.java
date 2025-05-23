package com.tencent.guild.aio.util.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/aio/util/ui/a;", "Landroid/graphics/drawable/BitmapDrawable;", "", "density", "", "setTargetDensity", "getIntrinsicWidth", "getIntrinsicHeight", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "a", "I", "mBitmapWidthWithMargin", "b", "mBitmapHeightWithMargin", "c", "mBackgroundColor", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "", "e", UserInfo.SEX_FEMALE, "roundCorner", "f", "mTargetRoundCorner", "Landroid/content/res/Resources;", "res", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "bitmapWidthWithMargin", "bitmapHeightWithMargin", "backgroudColor", "<init>", "(Landroid/content/res/Resources;Landroid/graphics/Bitmap;IIIF)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends BitmapDrawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mBitmapWidthWithMargin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mBitmapHeightWithMargin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mBackgroundColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float roundCorner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mTargetRoundCorner;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Resources res, @Nullable Bitmap bitmap, int i3, int i16, int i17, float f16) {
        super(res, bitmap);
        Intrinsics.checkNotNullParameter(res, "res");
        this.mPaint = new Paint();
        this.roundCorner = 12.0f;
        this.mTargetRoundCorner = 12.0f * 160;
        this.mBitmapWidthWithMargin = i3;
        this.mBitmapHeightWithMargin = i16;
        this.mBackgroundColor = i17;
        this.mTargetRoundCorner = f16 * (res.getDisplayMetrics().densityDpi / 160.0f);
        setGravity(17);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i3 = this.mBackgroundColor;
        if ((i3 >>> 24) != 0) {
            this.mPaint.setColor(i3);
            RectF rectF = new RectF(getBounds());
            float f16 = this.mTargetRoundCorner;
            canvas.drawRoundRect(rectF, f16, f16, this.mPaint);
        }
        super.draw(canvas);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i3 = this.mBitmapHeightWithMargin;
        if (i3 <= 0) {
            return super.getIntrinsicHeight();
        }
        return i3;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i3 = this.mBitmapWidthWithMargin;
        if (i3 <= 0) {
            return super.getIntrinsicWidth();
        }
        return i3;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (alpha != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(alpha);
        }
        super.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.BitmapDrawable
    public void setTargetDensity(int density) {
        this.mTargetRoundCorner = this.roundCorner * (density / 160.0f);
        super.setTargetDensity(density);
    }
}
