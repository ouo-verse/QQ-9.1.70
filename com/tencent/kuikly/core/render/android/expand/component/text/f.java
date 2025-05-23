package com.tencent.kuikly.core.render.android.expand.component.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/f;", "", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "", "e", "c", "Landroid/text/SpannableStringBuilder;", "text", "d", "b", "a", "Landroid/text/Layout;", "g", "()Landroid/text/Layout;", "setTextLayout", "(Landroid/text/Layout;)V", "textLayout", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "textProps", "Landroid/text/SpannableStringBuilder;", "f", "()Landroid/text/SpannableStringBuilder;", IECSearchBar.METHOD_SET_TEXT, "(Landroid/text/SpannableStringBuilder;)V", "<init>", "(Landroid/text/Layout;Lcom/tencent/kuikly/core/render/android/expand/component/d;Landroid/text/SpannableStringBuilder;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Layout textLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.render.android.expand.component.d textProps;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SpannableStringBuilder text;

    public f(@Nullable Layout layout, @NotNull com.tencent.kuikly.core.render.android.expand.component.d textProps, @Nullable SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkNotNullParameter(textProps, "textProps");
        this.textLayout = layout;
        this.textProps = textProps;
        this.text = spannableStringBuilder;
    }

    private final void b(SpannableStringBuilder text, Layout layout, Canvas canvas) {
        Object[] spans = text.getSpans(0, text.length(), g.class);
        Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(0, text.le\u2026xtStrokeSpan::class.java)");
        for (Object obj : spans) {
            ((g) obj).b(false);
        }
        Object[] spans2 = text.getSpans(0, text.length(), KRForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "text.getSpans(0, text.le\u2026undColorSpan::class.java)");
        for (Object obj2 : spans2) {
            ((KRForegroundColorSpan) obj2).b(2);
        }
        layout.draw(canvas);
    }

    private final void c(Canvas canvas, Layout layout) {
        if (this.textProps.getNeedTextStrokeDraw()) {
            SpannableStringBuilder spannableStringBuilder = this.text;
            if (spannableStringBuilder == null) {
                spannableStringBuilder = new SpannableStringBuilder();
            }
            d(spannableStringBuilder, layout, canvas);
            b(spannableStringBuilder, layout, canvas);
            return;
        }
        layout.draw(canvas);
    }

    private final void d(SpannableStringBuilder text, Layout layout, Canvas canvas) {
        Object[] spans = text.getSpans(0, text.length(), g.class);
        Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(0, text.le\u2026xtStrokeSpan::class.java)");
        for (Object obj : spans) {
            g gVar = (g) obj;
            gVar.b(true);
            Object[] spans2 = text.getSpans(text.getSpanStart(gVar), text.getSpanEnd(gVar), KRForegroundColorSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans2, "text.getSpans(start, end\u2026undColorSpan::class.java)");
            for (Object obj2 : spans2) {
                ((KRForegroundColorSpan) obj2).b(1);
            }
        }
        Object[] spans3 = text.getSpans(0, text.length(), KRForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans3, "text.getSpans(0, text.le\u2026undColorSpan::class.java)");
        for (Object obj3 : spans3) {
            KRForegroundColorSpan kRForegroundColorSpan = (KRForegroundColorSpan) obj3;
            if (kRForegroundColorSpan.getDrawStateColor() != 1) {
                kRForegroundColorSpan.b(0);
            }
        }
        layout.draw(canvas);
    }

    private final void e(Canvas canvas, Layout layout) {
        int i3;
        float f16;
        if (this.textProps.getNeedTextStrokeDraw()) {
            TextPaint tp5 = layout.getPaint();
            Intrinsics.checkNotNullExpressionValue(tp5, "tp");
            int color = tp5.getColor();
            Paint.Style style = tp5.getStyle();
            float strokeWidth = tp5.getStrokeWidth();
            Integer textStrokeColor = this.textProps.getTextStrokeColor();
            if (textStrokeColor != null) {
                i3 = textStrokeColor.intValue();
            } else {
                i3 = 0;
            }
            tp5.setColor(i3);
            Float textStrokeWidth = this.textProps.getTextStrokeWidth();
            if (textStrokeWidth != null) {
                f16 = textStrokeWidth.floatValue();
            } else {
                f16 = 0.0f;
            }
            tp5.setStrokeWidth(f16 + strokeWidth);
            tp5.setStyle(Paint.Style.STROKE);
            layout.draw(canvas);
            tp5.setColor(color);
            tp5.setStrokeWidth(strokeWidth);
            tp5.setStyle(style);
            layout.draw(canvas);
            return;
        }
        layout.draw(canvas);
    }

    public final void a(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Layout layout = this.textLayout;
        if (layout != null) {
            if (this.textProps.z()) {
                c(canvas, layout);
            } else {
                e(canvas, layout);
            }
        }
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final SpannableStringBuilder getText() {
        return this.text;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Layout getTextLayout() {
        return this.textLayout;
    }
}
