package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/l;", "Landroid/graphics/drawable/Drawable;", "", "xRegions", "yRegions", "", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "()Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "mBitmap", "c", "[B", "ninePatchChunk", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(Landroid/graphics/Bitmap;[I[I)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class l extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bitmap mBitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] ninePatchChunk;

    public l(@NotNull Bitmap bitmap, @NotNull int[] xRegions, @NotNull int[] yRegions) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(xRegions, "xRegions");
        Intrinsics.checkNotNullParameter(yRegions, "yRegions");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bitmap, xRegions, yRegions);
            return;
        }
        this.mPaint = new Paint();
        this.mBitmap = bitmap;
        this.ninePatchChunk = b(xRegions, yRegions);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
    
        if (r0 > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0071, code lost:
    
        r3 = r3 + 1;
        r2.putInt(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0075, code lost:
    
        if (r3 < r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        r8 = r2.array();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "byteBuffer.array()");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final byte[] b(int[] xRegions, int[] yRegions) {
        int length = (xRegions.length + 1) * (yRegions.length + 1);
        ByteBuffer order = ByteBuffer.allocate((xRegions.length * 4) + (yRegions.length * 4) + (length * 4) + 32).order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNullExpressionValue(order, "allocate(bufferSize).ord\u2026(ByteOrder.nativeOrder())");
        order.put((byte) 1);
        order.put((byte) xRegions.length);
        order.put((byte) yRegions.length);
        order.put((byte) length);
        int i3 = 0;
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        int length2 = xRegions.length - 1;
        if (length2 >= 0) {
            int i16 = 0;
            while (true) {
                int i17 = i16 + 1;
                order.putInt(xRegions[i16]);
                if (i17 > length2) {
                    break;
                }
                i16 = i17;
            }
        }
        int length3 = yRegions.length - 1;
        if (length3 >= 0) {
            int i18 = 0;
            while (true) {
                int i19 = i18 + 1;
                order.putInt(yRegions[i18]);
                if (i19 > length3) {
                    break;
                }
                i18 = i19;
            }
        }
    }

    @NotNull
    public final Paint a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Paint) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mPaint;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mBitmap.isRecycled()) {
            return;
        }
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mBitmap, this.ninePatchChunk, getBounds(), null);
        ninePatchDrawable.setBounds(canvas.getClipBounds());
        ninePatchDrawable.getPaint().setXfermode(this.mPaint.getXfermode());
        ninePatchDrawable.draw(canvas);
        ninePatchDrawable.getPaint().setXfermode(null);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, alpha);
        } else {
            this.mPaint.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorFilter);
        } else {
            this.mPaint.setColorFilter(colorFilter);
        }
    }
}
