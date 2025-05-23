package com.tencent.state.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/view/ImageCenterSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "text", "", "start", "", "end", HippyTKDListViewAdapter.X, "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ImageCenterSpan extends ImageSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCenterSpan(Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x16, int top, int y16, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i3 = (((fontMetricsInt.descent + y16) + y16) + fontMetricsInt.ascent) / 2;
        Drawable drawable = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        int i16 = i3 - (drawable.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(x16, i16);
        getDrawable().draw(canvas);
        canvas.restore();
    }
}
