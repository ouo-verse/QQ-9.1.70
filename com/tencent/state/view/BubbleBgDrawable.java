package com.tencent.state.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/view/BubbleBgDrawable;", "Landroid/graphics/drawable/Drawable;", "color", "", "radius", "", "arrowSize", "pointX", "isCenterX", "", "(IFFLjava/lang/Integer;Z)V", "paint", "Landroid/graphics/Paint;", "Ljava/lang/Integer;", CanvasView.ACTION_RECT, "Landroid/graphics/RectF;", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "getOpacity", "setAlpha", c.f123400v, "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BubbleBgDrawable extends Drawable {
    private final float arrowSize;
    private final boolean isCenterX;
    private final Paint paint;
    private final Integer pointX;
    private final float radius;
    private final RectF rect;

    public /* synthetic */ BubbleBgDrawable(int i3, float f16, float f17, Integer num, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, f16, f17, (i16 & 8) != 0 ? null : num, (i16 & 16) != 0 ? true : z16);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float centerX;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.rect.set(getBounds());
        RectF rectF = this.rect;
        float f16 = this.radius;
        canvas.drawRoundRect(rectF, f16, f16, this.paint);
        Path path = new Path();
        if (this.isCenterX) {
            Integer num = this.pointX;
            if (num != null) {
                centerX = num.intValue();
            } else {
                centerX = this.rect.centerX();
            }
            path.moveTo(centerX, (this.rect.bottom + this.arrowSize) - 5);
            float f17 = 2;
            float f18 = 3;
            path.lineTo(((this.arrowSize * f17) / f18) + centerX, this.rect.bottom);
            path.lineTo(centerX - ((this.arrowSize * f17) / f18), this.rect.bottom);
        } else {
            float centerY = this.rect.centerY();
            path.moveTo(this.rect.left - this.arrowSize, centerY);
            float f19 = 2;
            float f26 = 3;
            path.lineTo(this.rect.left, centerY - ((this.arrowSize * f19) / f26));
            path.lineTo(this.rect.left, centerY + ((this.arrowSize * f19) / f26));
        }
        path.close();
        canvas.drawPath(path, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public BubbleBgDrawable(int i3, float f16, float f17, Integer num, boolean z16) {
        this.radius = f16;
        this.arrowSize = f17;
        this.pointX = num;
        this.isCenterX = z16;
        Paint paint = new Paint(1);
        this.paint = paint;
        this.rect = new RectF();
        paint.setColor(i3);
    }
}
