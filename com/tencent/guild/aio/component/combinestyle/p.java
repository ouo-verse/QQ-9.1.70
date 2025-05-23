package com.tencent.guild.aio.component.combinestyle;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b.\u0010/J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J@\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J2\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016JP\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010)\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/p;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "", "y", "Landroid/graphics/Paint;", "paint", "", "a", "", "text", "start", "end", "baseLine", "b", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "top", "bottom", "draw", "Lcom/tencent/guild/aio/component/combinestyle/p$a;", "d", "Lcom/tencent/guild/aio/component/combinestyle/p$a;", "spanBuilder", "e", "I", "mBgColor", "f", "mMeasureTextLength", "Landroid/graphics/RectF;", tl.h.F, "Landroid/graphics/RectF;", "bgRect", "i", "textRect", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Paint$FontMetricsInt;", "fontMetrics", "Landroid/graphics/LinearGradient;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/LinearGradient;", "gradientBg", "<init>", "(Lcom/tencent/guild/aio/component/combinestyle/p$a;)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class p extends ReplacementSpan {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LinearGradient gradientBg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SpanBuilder spanBuilder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mBgColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mMeasureTextLength;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RectF bgRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RectF textRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Paint.FontMetricsInt fontMetrics;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0019\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/p$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "bgColor", "b", "f", "startColor", "c", "endColor", "d", "g", "textColor", "e", "radius", "leftMargin", "rightMargin", tl.h.F, "textSize", "<init>", "(IIIIIIII)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.component.combinestyle.p$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class SpanBuilder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bgColor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int startColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int endColor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int textColor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int radius;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int leftMargin;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int rightMargin;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int textSize;

        public SpanBuilder() {
            this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getBgColor() {
            return this.bgColor;
        }

        /* renamed from: b, reason: from getter */
        public final int getEndColor() {
            return this.endColor;
        }

        /* renamed from: c, reason: from getter */
        public final int getLeftMargin() {
            return this.leftMargin;
        }

        /* renamed from: d, reason: from getter */
        public final int getRadius() {
            return this.radius;
        }

        /* renamed from: e, reason: from getter */
        public final int getRightMargin() {
            return this.rightMargin;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpanBuilder)) {
                return false;
            }
            SpanBuilder spanBuilder = (SpanBuilder) other;
            if (this.bgColor == spanBuilder.bgColor && this.startColor == spanBuilder.startColor && this.endColor == spanBuilder.endColor && this.textColor == spanBuilder.textColor && this.radius == spanBuilder.radius && this.leftMargin == spanBuilder.leftMargin && this.rightMargin == spanBuilder.rightMargin && this.textSize == spanBuilder.textSize) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getStartColor() {
            return this.startColor;
        }

        /* renamed from: g, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        /* renamed from: h, reason: from getter */
        public final int getTextSize() {
            return this.textSize;
        }

        public int hashCode() {
            return (((((((((((((this.bgColor * 31) + this.startColor) * 31) + this.endColor) * 31) + this.textColor) * 31) + this.radius) * 31) + this.leftMargin) * 31) + this.rightMargin) * 31) + this.textSize;
        }

        @NotNull
        public String toString() {
            return "SpanBuilder(bgColor=" + this.bgColor + ", startColor=" + this.startColor + ", endColor=" + this.endColor + ", textColor=" + this.textColor + ", radius=" + this.radius + ", leftMargin=" + this.leftMargin + ", rightMargin=" + this.rightMargin + ", textSize=" + this.textSize + ")";
        }

        public SpanBuilder(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            this.bgColor = i3;
            this.startColor = i16;
            this.endColor = i17;
            this.textColor = i18;
            this.radius = i19;
            this.leftMargin = i26;
            this.rightMargin = i27;
            this.textSize = i28;
        }

        public /* synthetic */ SpanBuilder(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, DefaultConstructorMarker defaultConstructorMarker) {
            this((i29 & 1) != 0 ? 0 : i3, (i29 & 2) != 0 ? 0 : i16, (i29 & 4) != 0 ? 0 : i17, (i29 & 8) != 0 ? 0 : i18, (i29 & 16) != 0 ? 0 : i19, (i29 & 32) != 0 ? 0 : i26, (i29 & 64) != 0 ? 0 : i27, (i29 & 128) == 0 ? i28 : 0);
        }
    }

    public p(@NotNull SpanBuilder spanBuilder) {
        Intrinsics.checkNotNullParameter(spanBuilder, "spanBuilder");
        this.spanBuilder = spanBuilder;
        this.mBgColor = spanBuilder.getBgColor();
    }

    private final void a(Canvas canvas, float x16, int y16, Paint paint) {
        int i3 = this.mBgColor;
        if (i3 == 0) {
            i3 = paint.getColor();
        }
        paint.setColor(i3);
        paint.setAntiAlias(true);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        Intrinsics.checkNotNullExpressionValue(fontMetricsInt, "paint.fontMetricsInt");
        this.fontMetrics = fontMetricsInt;
        RectF rectF = this.bgRect;
        if (rectF == null) {
            float leftMargin = x16 + this.spanBuilder.getLeftMargin();
            Paint.FontMetricsInt fontMetricsInt2 = this.fontMetrics;
            if (fontMetricsInt2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
                fontMetricsInt2 = null;
            }
            float f16 = y16 + fontMetricsInt2.ascent;
            float rightMargin = (x16 + this.mMeasureTextLength) - this.spanBuilder.getRightMargin();
            Paint.FontMetricsInt fontMetricsInt3 = this.fontMetrics;
            if (fontMetricsInt3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
                fontMetricsInt3 = null;
            }
            this.bgRect = new RectF(leftMargin, f16, rightMargin, y16 + fontMetricsInt3.descent);
        } else {
            if (rectF == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgRect");
                rectF = null;
            }
            float leftMargin2 = x16 + this.spanBuilder.getLeftMargin();
            Paint.FontMetricsInt fontMetricsInt4 = this.fontMetrics;
            if (fontMetricsInt4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
                fontMetricsInt4 = null;
            }
            float f17 = y16 + fontMetricsInt4.ascent;
            float rightMargin2 = (x16 + this.mMeasureTextLength) - this.spanBuilder.getRightMargin();
            Paint.FontMetricsInt fontMetricsInt5 = this.fontMetrics;
            if (fontMetricsInt5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
                fontMetricsInt5 = null;
            }
            rectF.set(leftMargin2, f17, rightMargin2, y16 + fontMetricsInt5.descent);
        }
        paint.setStyle(Paint.Style.FILL);
        if (this.gradientBg == null && this.spanBuilder.getStartColor() != 0 && this.spanBuilder.getEndColor() != 0) {
            RectF rectF2 = this.bgRect;
            if (rectF2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgRect");
                rectF2 = null;
            }
            float f18 = rectF2.left;
            RectF rectF3 = this.bgRect;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgRect");
                rectF3 = null;
            }
            float f19 = rectF3.top;
            RectF rectF4 = this.bgRect;
            if (rectF4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgRect");
                rectF4 = null;
            }
            float f26 = rectF4.right;
            RectF rectF5 = this.bgRect;
            if (rectF5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgRect");
                rectF5 = null;
            }
            this.gradientBg = new LinearGradient(f18, f19, f26, rectF5.bottom, this.spanBuilder.getStartColor(), this.spanBuilder.getEndColor(), Shader.TileMode.CLAMP);
        }
        LinearGradient linearGradient = this.gradientBg;
        if (linearGradient != null) {
            paint.setShader(linearGradient);
        }
        RectF rectF6 = this.bgRect;
        if (rectF6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bgRect");
            rectF6 = null;
        }
        canvas.drawRoundRect(rectF6, this.spanBuilder.getRadius(), this.spanBuilder.getRadius(), paint);
        if (paint.getShader() != null) {
            paint.setShader(null);
        }
    }

    private final void b(Canvas canvas, CharSequence text, int start, int end, float x16, int baseLine, Paint paint) {
        int color;
        Number valueOf;
        if (this.spanBuilder.getTextColor() != 0) {
            color = this.spanBuilder.getTextColor();
        } else {
            color = paint.getColor();
        }
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        int rightMargin = ((this.mMeasureTextLength - this.spanBuilder.getRightMargin()) - this.spanBuilder.getLeftMargin()) / 2;
        if (this.spanBuilder.getTextSize() > 0 && this.spanBuilder.getTextSize() < paint.getTextSize()) {
            paint.setTextSize(this.spanBuilder.getTextSize());
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            Intrinsics.checkNotNullExpressionValue(fontMetricsInt, "paint.fontMetricsInt");
            this.fontMetrics = fontMetricsInt;
            RectF rectF = this.textRect;
            RectF rectF2 = null;
            if (rectF == null) {
                float leftMargin = x16 + this.spanBuilder.getLeftMargin();
                Paint.FontMetricsInt fontMetricsInt2 = this.fontMetrics;
                if (fontMetricsInt2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
                    fontMetricsInt2 = null;
                }
                float f16 = fontMetricsInt2.ascent + baseLine;
                float rightMargin2 = (x16 + this.mMeasureTextLength) - this.spanBuilder.getRightMargin();
                Paint.FontMetricsInt fontMetricsInt3 = this.fontMetrics;
                if (fontMetricsInt3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
                    fontMetricsInt3 = null;
                }
                this.textRect = new RectF(leftMargin, f16, rightMargin2, fontMetricsInt3.descent + baseLine);
            } else {
                if (rectF == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textRect");
                    rectF = null;
                }
                float leftMargin2 = x16 + this.spanBuilder.getLeftMargin();
                Paint.FontMetricsInt fontMetricsInt4 = this.fontMetrics;
                if (fontMetricsInt4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
                    fontMetricsInt4 = null;
                }
                float f17 = fontMetricsInt4.ascent + baseLine;
                float rightMargin3 = (x16 + this.mMeasureTextLength) - this.spanBuilder.getRightMargin();
                Paint.FontMetricsInt fontMetricsInt5 = this.fontMetrics;
                if (fontMetricsInt5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
                    fontMetricsInt5 = null;
                }
                rectF.set(leftMargin2, f17, rightMargin3, fontMetricsInt5.descent + baseLine);
            }
            RectF rectF3 = this.bgRect;
            if (rectF3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgRect");
                rectF3 = null;
            }
            float centerY = rectF3.centerY();
            RectF rectF4 = this.textRect;
            if (rectF4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textRect");
            } else {
                rectF2 = rectF4;
            }
            valueOf = Float.valueOf(baseLine - Math.abs(centerY - rectF2.centerY()));
        } else {
            valueOf = Integer.valueOf(baseLine);
        }
        canvas.drawText(text.subSequence(start, end).toString(), rightMargin + x16 + this.spanBuilder.getLeftMargin(), valueOf.floatValue(), paint);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @NotNull CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        a(canvas, x16, y16, paint);
        b(canvas, text, start, end, x16, y16, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NotNull Paint paint, @NotNull CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        int measureText = (int) (paint.measureText(text, start, end) + this.spanBuilder.getLeftMargin() + this.spanBuilder.getRightMargin());
        this.mMeasureTextLength = measureText;
        return measureText;
    }
}
