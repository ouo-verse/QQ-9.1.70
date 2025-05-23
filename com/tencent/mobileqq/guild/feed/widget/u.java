package com.tencent.mobileqq.guild.feed.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.dom.node.ImageNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J4\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016JR\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/u;", "Landroid/text/style/ImageSpan;", "", "leftPadding", "rightPadding", "", "a", "Landroid/graphics/Paint;", "paint", "", "text", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "draw", "d", "I", "mLeftPadding", "e", "mRightPadding", "Landroid/graphics/drawable/Drawable;", "drawable", ImageNode.PROP_VERTICAL_ALIGNMENT, "<init>", "(Landroid/graphics/drawable/Drawable;I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class u extends ImageSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mLeftPadding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mRightPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(@NotNull Drawable drawable, int i3) {
        super(drawable, i3);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    public final void a(int leftPadding, int rightPadding) {
        this.mLeftPadding = leftPadding;
        this.mRightPadding = rightPadding;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i3 = fontMetricsInt.descent;
        int i16 = fontMetricsInt.ascent;
        canvas.translate(x16 + this.mLeftPadding, ((y16 + i16) + ((i3 - i16) / 2)) - (drawable.getBounds().height() / 2));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Rect bounds = getDrawable().getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
        if (fm5 != null) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i3 = fontMetricsInt.descent;
            int i16 = fontMetricsInt.ascent;
            int i17 = i16 + ((i3 - i16) / 2);
            int height = bounds.height() / 2;
            int i18 = i17 - height;
            fm5.ascent = i18;
            int i19 = i17 + height;
            fm5.descent = i19;
            fm5.top = i18;
            fm5.bottom = i19;
        }
        return bounds.width() + this.mLeftPadding + this.mRightPadding;
    }
}
