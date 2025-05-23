package com.tencent.mobileqq.qwallet.hb.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006\u00a2\u0006\u0004\b)\u0010*JR\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J4\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/view/d;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "text", "", "start", "end", "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "Landroid/graphics/Paint;", "paint", "", "draw", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "d", "I", "getBgColor", "()I", "bgColor", "e", "getTextColor", "textColor", "f", "getTextSize", "textSize", h.F, "getRadius", "radius", "i", "RECT_PADDING_LEFT", "Landroid/graphics/RectF;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/RectF;", "rectF", "<init>", "(IIII)V", "qqpay-ui_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends ReplacementSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int bgColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int textColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int textSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int radius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int RECT_PADDING_LEFT = ViewUtils.dip2px(6.0f);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF rectF = new RectF();

    public d(int i3, int i16, int i17, int i18) {
        this.bgColor = i3;
        this.textColor = i16;
        this.textSize = i17;
        this.radius = i18;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int color = paint.getColor();
        int alpha = paint.getAlpha();
        paint.setColor(this.bgColor);
        paint.setTextSize(this.textSize);
        RectF rectF = this.rectF;
        rectF.left = x16;
        rectF.top = top;
        rectF.right = ((int) paint.measureText(text, start, end)) + x16 + (this.RECT_PADDING_LEFT * 2);
        RectF rectF2 = this.rectF;
        rectF2.bottom = bottom;
        int i3 = this.radius;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        paint.setColor(this.textColor);
        paint.setAlpha(alpha);
        paint.setFakeBoldText(false);
        Intrinsics.checkNotNull(text);
        canvas.drawText(text, start, end, x16 + this.RECT_PADDING_LEFT, y16, paint);
        paint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return ((int) paint.measureText(text, start, end)) + this.RECT_PADDING_LEFT;
    }
}
