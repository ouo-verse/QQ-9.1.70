package com.tencent.android.gldrawable.api.base;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Gravity;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.android.gldrawable.api.IGLDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J0\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH&J&\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/ScaleTypeDrawable;", "Lcom/tencent/android/gldrawable/api/IGLDrawable;", "()V", "clipArea", "Landroid/graphics/RectF;", "drawRect", "Landroid/graphics/Rect;", "forceLockWH", "", "viewRect", "calculateClipArea", "dstBounds", "calculateLockWH", "width", "", "height", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "onDraw", "left", "top", "right", "bottom", "setDrawArea", "x0", "", "y0", "x1", "y1", "setLockWH", "b", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public abstract class ScaleTypeDrawable extends IGLDrawable {
    private RectF clipArea;
    private boolean forceLockWH;
    private final Rect drawRect = new Rect();
    private final Rect viewRect = new Rect();

    @NotNull
    public final Rect calculateClipArea(@NotNull Rect dstBounds) {
        Intrinsics.checkNotNullParameter(dstBounds, "dstBounds");
        RectF rectF = this.clipArea;
        if (rectF != null) {
            float width = rectF.width();
            float width2 = dstBounds.width() / width;
            float height = dstBounds.height() / rectF.height();
            Rect rect = this.drawRect;
            rect.left = (int) (dstBounds.left - (rectF.left * width2));
            rect.right = (int) (dstBounds.right + (width2 * (1.0f - rectF.right)));
            rect.top = (int) (dstBounds.top - (rectF.top * height));
            rect.bottom = (int) (dstBounds.bottom + (height * (1.0f - rectF.bottom)));
        }
        return this.drawRect;
    }

    @NotNull
    public final Rect calculateLockWH(int width, int height, @NotNull Rect dstBounds) {
        Intrinsics.checkNotNullParameter(dstBounds, "dstBounds");
        this.drawRect.set(0, 0, width, height);
        float width2 = dstBounds.width() / this.drawRect.width();
        float height2 = dstBounds.height() / this.drawRect.height();
        if (width2 > height2) {
            this.drawRect.right = dstBounds.width();
            this.drawRect.bottom = (int) (r4.bottom * width2);
        } else {
            this.drawRect.bottom = dstBounds.height();
            this.drawRect.right = (int) (r3.right * height2);
        }
        Gravity.apply(17, this.drawRect.width(), this.drawRect.height(), dstBounds, this.drawRect);
        return this.drawRect;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        if (bounds.isEmpty()) {
            this.viewRect.set(0, 0, canvas.getWidth(), canvas.getHeight());
        } else {
            this.viewRect.set(bounds);
        }
        if (this.viewRect.isEmpty()) {
            return;
        }
        if (getIntrinsicHeight() > 0 && getIntrinsicWidth() > 0) {
            if (this.forceLockWH) {
                Rect calculateLockWH = calculateLockWH(getIntrinsicWidth(), getIntrinsicHeight(), this.viewRect);
                onDraw(canvas, calculateLockWH.left, calculateLockWH.top, calculateLockWH.right, calculateLockWH.bottom);
                return;
            } else if (this.clipArea != null) {
                Rect calculateClipArea = calculateClipArea(this.viewRect);
                onDraw(canvas, calculateClipArea.left, calculateClipArea.top, calculateClipArea.right, calculateClipArea.bottom);
                return;
            } else {
                Rect rect = this.viewRect;
                onDraw(canvas, rect.left, rect.top, rect.right, rect.bottom);
                return;
            }
        }
        Rect rect2 = this.viewRect;
        onDraw(canvas, rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    public abstract void onDraw(@NotNull Canvas canvas, int left, int top, int right, int bottom);

    @Override // com.tencent.android.gldrawable.api.IGLDrawable
    public final void setDrawArea(float x06, float y06, float x16, float y16) {
        if (x06 < 0.0f || y06 < 0.0f || x16 < 0.0f || y16 < 0.0f || x06 > 1.0f || y06 > 1.0f || x16 > 1.0f || y16 > 1.0f) {
            this.clipArea = null;
        }
        this.clipArea = new RectF(x06, y06, x16, y16);
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawable
    public final void setLockWH(boolean b16) {
        this.forceLockWH = b16;
    }
}
