package com.tencent.mobileqq.vas.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010$\u001a\u00020\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/image/e;", "Landroid/graphics/drawable/Drawable;", "", "xRegions", "yRegions", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "getClipRect", "()Landroid/graphics/Rect;", "clipRect", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "mBitmap", "d", "[B", "ninePatchChunk", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(Landroid/graphics/Bitmap;[I[ILandroid/graphics/Rect;)V", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e extends Drawable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Rect clipRect;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bitmap mBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] ninePatchChunk;

    public e(@NotNull Bitmap bitmap, @NotNull int[] xRegions, @NotNull int[] yRegions, @Nullable Rect rect) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(xRegions, "xRegions");
        Intrinsics.checkNotNullParameter(yRegions, "yRegions");
        this.clipRect = rect;
        this.mPaint = new Paint();
        this.mBitmap = bitmap;
        this.ninePatchChunk = a(xRegions, yRegions);
    }

    private final byte[] a(int[] xRegions, int[] yRegions) {
        int length = (xRegions.length + 1) * (yRegions.length + 1);
        ByteBuffer order = ByteBuffer.allocate((xRegions.length * 4) + (yRegions.length * 4) + (length * 4) + 32).order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNullExpressionValue(order, "allocate(bufferSize).ord\u2026(ByteOrder.nativeOrder())");
        order.put((byte) 1);
        order.put((byte) xRegions.length);
        order.put((byte) yRegions.length);
        order.put((byte) length);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        for (int i3 : xRegions) {
            order.putInt(i3);
        }
        for (int i16 : yRegions) {
            order.putInt(i16);
        }
        for (int i17 = 0; i17 < length; i17++) {
            order.putInt(1);
        }
        byte[] array = order.array();
        Intrinsics.checkNotNullExpressionValue(array, "byteBuffer.array()");
        return array;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mBitmap.isRecycled()) {
            return;
        }
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mBitmap, this.ninePatchChunk, getBounds(), null);
        Rect clipBounds = canvas.getClipBounds();
        Intrinsics.checkNotNullExpressionValue(clipBounds, "canvas.clipBounds");
        Rect rect = this.clipRect;
        if (rect != null) {
            clipBounds = new Rect(clipBounds.left - rect.left, clipBounds.top - rect.top, clipBounds.right - rect.right, clipBounds.bottom - rect.bottom);
        }
        ninePatchDrawable.setBounds(clipBounds);
        ninePatchDrawable.getPaint().setXfermode(this.mPaint.getXfermode());
        ninePatchDrawable.draw(canvas);
        ninePatchDrawable.getPaint().setXfermode(null);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
