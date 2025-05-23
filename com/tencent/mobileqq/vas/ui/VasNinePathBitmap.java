package com.tencent.mobileqq.vas.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J2\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/VasNinePathBitmap;", "Lcom/tencent/mobileqq/vas/ui/INinePathBitmap;", "()V", "mBitmap", "Landroid/graphics/Bitmap;", "mNinePatch", "Landroid/graphics/NinePatch;", "tempBounds", "Landroid/graphics/Rect;", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "src", "bounds", "paint", "Landroid/graphics/Paint;", "drawBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "drawNinePath", "ninePath", "getBitmap", "getHeight", "", "getNinePatchChunk", "", "getWidth", "isEmpty", "", "next", "cache", "recycle", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasNinePathBitmap implements INinePathBitmap {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Bitmap mBitmap;

    @Nullable
    private NinePatch mNinePatch;

    @NotNull
    private Rect tempBounds = new Rect();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/VasNinePathBitmap$Companion;", "", "()V", "calculateScale", "Lkotlin/Triple;", "", "", "width", "", "height", "canvasRect", "Landroid/graphics/Rect;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Triple<Boolean, Boolean, Float> calculateScale(int width, int height, @NotNull Rect canvasRect) {
            boolean z16;
            Intrinsics.checkNotNullParameter(canvasRect, "canvasRect");
            boolean z17 = true;
            if (canvasRect.width() < width) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (canvasRect.height() >= height) {
                z17 = false;
            }
            if (!z16 && !z17) {
                return new Triple<>(Boolean.valueOf(z16), Boolean.valueOf(z17), Float.valueOf(1.0f));
            }
            return new Triple<>(Boolean.valueOf(z16), Boolean.valueOf(z17), Float.valueOf(Math.max(height / canvasRect.height(), width / canvasRect.width())));
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final Triple<Boolean, Boolean, Float> calculateScale(int i3, int i16, @NotNull Rect rect) {
        return INSTANCE.calculateScale(i3, i16, rect);
    }

    private final void drawBitmap(Bitmap bitmap, Canvas canvas, Rect src, Rect bounds, Paint paint) {
        if (src == null) {
            this.tempBounds.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        } else {
            this.tempBounds.set(src);
        }
        canvas.drawBitmap(bitmap, this.tempBounds, bounds, paint);
    }

    private final void drawNinePath(NinePatch ninePath, Canvas canvas, Rect bounds, Paint paint) {
        boolean z16;
        this.tempBounds.set(bounds);
        int width = ninePath.getWidth();
        int height = ninePath.getHeight();
        Triple<Boolean, Boolean, Float> calculateScale = INSTANCE.calculateScale(width, height, bounds);
        boolean booleanValue = calculateScale.component1().booleanValue();
        boolean booleanValue2 = calculateScale.component2().booleanValue();
        float floatValue = calculateScale.component3().floatValue();
        if (!booleanValue && !booleanValue2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            canvas.save();
            if (booleanValue) {
                float f16 = 1 / floatValue;
                canvas.scale(f16, f16);
                this.tempBounds.set(bounds.left, bounds.top, (int) (bounds.right + (bounds.width() * (floatValue - 1.0f))), bounds.top + height);
            } else {
                float f17 = 1 / floatValue;
                canvas.scale(f17, f17);
                this.tempBounds.set(bounds.left, bounds.top, (int) (bounds.right + (bounds.width() * (floatValue - 1.0f))), bounds.top + height);
            }
        }
        ninePath.draw(canvas, this.tempBounds, paint);
        if (z16) {
            canvas.restore();
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.INinePathBitmap
    public void draw(@NotNull Canvas canvas, @Nullable Rect src, @NotNull Rect bounds, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (bounds.height() == 0) {
            recycle();
            return;
        }
        NinePatch ninePatch = this.mNinePatch;
        if (ninePatch != null) {
            Intrinsics.checkNotNull(ninePatch);
            drawNinePath(ninePatch, canvas, bounds, paint);
            return;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            drawBitmap(bitmap, canvas, src, bounds, paint);
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.INinePathBitmap
    @Nullable
    /* renamed from: getBitmap, reason: from getter */
    public Bitmap getMBitmap() {
        return this.mBitmap;
    }

    public final int getHeight() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return 0;
    }

    @Nullable
    public final byte[] getNinePatchChunk() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getNinePatchChunk();
        }
        return null;
    }

    public final int getWidth() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return 0;
    }

    public final boolean isEmpty() {
        if (this.mBitmap == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.ui.INinePathBitmap
    public void next(@Nullable Bitmap cache) {
        if (cache == null) {
            return;
        }
        this.mBitmap = cache;
        byte[] ninePatchChunk = cache.getNinePatchChunk();
        NinePatch ninePatch = null;
        if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            ninePatch = new NinePatch(this.mBitmap, ninePatchChunk, null);
        }
        this.mNinePatch = ninePatch;
    }

    @Override // com.tencent.mobileqq.vas.ui.INinePathBitmap
    public void recycle() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mBitmap = null;
    }
}
