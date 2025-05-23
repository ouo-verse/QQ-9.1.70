package com.tencent.mobileqq.guild.share.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J4\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016JR\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/h;", "Landroid/text/style/ImageSpan;", "", "leftPadding", "rightPadding", "", "b", "width", "height", "a", "Landroid/graphics/Paint;", "paint", "", "text", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "draw", "d", "I", "mLeftPadding", "e", "mRightPadding", "f", "mWidth", tl.h.F, "mHeight", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends ImageSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mLeftPadding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mRightPadding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    public final void a(int width, int height) {
        this.mWidth = width;
        this.mHeight = height;
    }

    public final void b(int leftPadding, int rightPadding) {
        this.mLeftPadding = leftPadding;
        this.mRightPadding = rightPadding;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        int i3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        int i16 = this.mWidth;
        if (i16 > 0 && (i3 = this.mHeight) > 0) {
            drawable.setBounds(0, 0, i16, i3);
        }
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i17 = fontMetricsInt.descent;
        int i18 = fontMetricsInt.ascent;
        canvas.translate(x16 + this.mLeftPadding, ((y16 + i18) + ((i17 - i18) / 2)) - (drawable.getBounds().height() / 2));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        int i3;
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        int i16 = this.mWidth;
        if (i16 > 0 && (i3 = this.mHeight) > 0) {
            drawable.setBounds(0, 0, i16, i3);
        }
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
        if (fm5 != null) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i17 = fontMetricsInt.descent;
            int i18 = fontMetricsInt.ascent;
            int i19 = i18 + ((i17 - i18) / 2);
            int height = bounds.height() / 2;
            int i26 = i19 - height;
            fm5.ascent = i26;
            int i27 = i19 + height;
            fm5.descent = i27;
            fm5.top = i26;
            fm5.bottom = i27;
        }
        return bounds.width() + this.mLeftPadding + this.mRightPadding;
    }
}
