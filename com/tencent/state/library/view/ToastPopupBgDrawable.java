package com.tencent.state.library.view;

import android.content.Context;
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
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/library/view/ToastPopupBgDrawable;", "Landroid/graphics/drawable/Drawable;", "color", "", "radius", "", "position", "Lcom/tencent/state/library/view/ToastPopupPosition;", "offset", "(IFLcom/tencent/state/library/view/ToastPopupPosition;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "paint", "Landroid/graphics/Paint;", CanvasView.ACTION_RECT, "Landroid/graphics/RectF;", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "getOpacity", "setAlpha", c.f123400v, "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class ToastPopupBgDrawable extends Drawable {
    private final Integer offset;
    private final Paint paint;
    private final ToastPopupPosition position;
    private final float radius;
    private final RectF rect;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToastPopupPosition.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ToastPopupPosition.Above.ordinal()] = 1;
            iArr[ToastPopupPosition.Below.ordinal()] = 2;
        }
    }

    public /* synthetic */ ToastPopupBgDrawable(int i3, float f16, ToastPopupPosition toastPopupPosition, Integer num, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, f16, toastPopupPosition, (i16 & 8) != 0 ? null : num);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float centerX;
        float centerX2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.rect.set(getBounds());
        RectF rectF = this.rect;
        float f16 = this.radius;
        canvas.drawRoundRect(rectF, f16, f16, this.paint);
        Path path = new Path();
        int dip = ViewExtensionsKt.dip((Context) SquareBase.INSTANCE.getApp(), 5);
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.position.ordinal()];
        if (i3 == 1) {
            Integer num = this.offset;
            if (num != null) {
                centerX = num.intValue();
            } else {
                centerX = this.rect.centerX();
            }
            float f17 = dip;
            path.moveTo(centerX, this.rect.bottom + f17);
            path.lineTo(centerX + f17, this.rect.bottom);
            path.lineTo(centerX - f17, this.rect.bottom);
        } else if (i3 == 2) {
            Integer num2 = this.offset;
            if (num2 != null) {
                centerX2 = num2.intValue();
            } else {
                centerX2 = this.rect.centerX();
            }
            float f18 = dip;
            path.moveTo(centerX2, this.rect.top - f18);
            path.lineTo(centerX2 + f18, this.rect.top);
            path.lineTo(centerX2 - f18, this.rect.top);
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

    public ToastPopupBgDrawable(int i3, float f16, ToastPopupPosition position, Integer num) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.radius = f16;
        this.position = position;
        this.offset = num;
        Paint paint = new Paint(1);
        this.paint = paint;
        this.rect = new RectF();
        paint.setColor(i3);
    }
}
