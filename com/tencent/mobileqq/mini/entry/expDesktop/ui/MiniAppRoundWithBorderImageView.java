package com.tencent.mobileqq.mini.entry.expDesktop.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/ui/MiniAppRoundWithBorderImageView;", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBorderPaint", "Landroid/graphics/Paint;", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "setBorderPaint", "color", "style", "Landroid/graphics/Paint$Style;", "strokeWidth", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRoundWithBorderImageView extends RoundRectImageView {
    private final Paint mBorderPaint;

    public MiniAppRoundWithBorderImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mBorderPaint = new Paint(1);
    }

    @Override // com.tencent.qqnt.base.widget.RoundRectImageView, android.view.View
    public void draw(Canvas canvas) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getMRoundMode() != 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(getWidth(), getHeight());
            super.draw(canvas);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (coerceAtMost / 2.0f) - (this.mBorderPaint.getStrokeWidth() / 2), this.mBorderPaint);
            return;
        }
        super.draw(canvas);
    }

    public final void setBorderPaint(int color, Paint.Style style, float strokeWidth) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.mBorderPaint.setColor(color);
        this.mBorderPaint.setStyle(style);
        this.mBorderPaint.setStrokeWidth(strokeWidth);
    }
}
