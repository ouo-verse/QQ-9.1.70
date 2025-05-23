package com.tencent.kuikly.core.render.android.expand.component;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.util.SizeF;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.expand.component.text.j;
import com.tencent.kuikly.core.render.android.expand.component.text.m;
import com.tencent.kuikly.core.render.android.expand.component.text.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import d01.u;
import d01.w;
import d01.y;
import d01.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \r2\u00020\u0001:\u0002T[B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J*\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0003J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0002J \u0010$\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020*H\u0002J\u0018\u00100\u001a\u00020/2\u0006\u0010,\u001a\u00020&2\u0006\u0010.\u001a\u00020-H\u0016J\u001a\u00103\u001a\u0004\u0018\u00010-2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020&H\u0016J\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020-04J\u0010\u00106\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u00107\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00108R$\u0010?\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010F\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR(\u0010X\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010R8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRRichTextShadow;", "Li01/f;", "", "index", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/util/SizeF;", "constraintSize", "Lcom/tencent/kuikly/core/render/android/expand/component/KRRichTextShadow$TextMeasureMode;", "measureMode", "Lkotlin/Pair;", "Landroid/text/Layout;", "Landroid/text/SpannableStringBuilder;", "g", "i", tl.h.F, "Landroid/text/Layout$Alignment;", "r", "text", "j", "Landroid/text/StaticLayout;", "originStaticLayout", "", "originText", "desiredWidth", "Landroid/text/StaticLayout$Builder;", DomainData.DOMAIN_NAME, "", "lineBreakMargin", "y", "textSource", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "textProps", "", "k", "o", "u", "", "backgroundImage", "Lcom/tencent/kuikly/core/render/android/expand/component/text/j;", "l", "Landroid/text/TextUtils$TruncateAt;", "p", "propKey", "", "propValue", "", "b", "methodName", "params", "d", "", "v", "c", HippyTKDListViewAdapter.X, "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "Lcom/tencent/kuikly/core/render/android/expand/component/text/f;", "Lcom/tencent/kuikly/core/render/android/expand/component/text/f;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/kuikly/core/render/android/expand/component/text/f;", "setTextDrawer", "(Lcom/tencent/kuikly/core/render/android/expand/component/text/f;)V", "textDrawer", "", "Z", "w", "()Z", "setRichTextMode", "(Z)V", "isRichTextMode", "Landroid/text/TextPaint;", "e", "Lkotlin/Lazy;", "t", "()Landroid/text/TextPaint;", "textPaint", "", "Lcom/tencent/kuikly/core/render/android/expand/component/text/m;", "f", "Ljava/util/List;", "spanTextRanges", "Lcom/tencent/kuikly/core/render/android/a;", "value", "a", "()Lcom/tencent/kuikly/core/render/android/a;", "setKuiklyRenderContext", "(Lcom/tencent/kuikly/core/render/android/a;)V", "kuiklyRenderContext", "<init>", "()V", "TextMeasureMode", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRRichTextShadow extends i01.f {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private d textProps = new d(null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.kuikly.core.render.android.expand.component.text.f textDrawer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isRichTextMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy textPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<m> spanTextRanges;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRRichTextShadow$TextMeasureMode;", "", "(Ljava/lang/String;I)V", "EXACTLY", "AT_MOST", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public enum TextMeasureMode {
        EXACTLY,
        AT_MOST
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRRichTextShadow$a;", "", "", "LINE_BREAK_MAGIC_CODE", "I", "", "METHOD_GET_PLACEHOLDER_SPAN_RECT", "Ljava/lang/String;", "METHOD_IS_LINE_BREAK_MARGIN", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRRichTextShadow$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KRRichTextShadow() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextPaint>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRRichTextShadow$textPaint$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextPaint invoke() {
                d dVar;
                TextPaint textPaint = new TextPaint();
                textPaint.setAntiAlias(true);
                textPaint.setDither(true);
                textPaint.setColor(-16777216);
                com.tencent.kuikly.core.render.android.a aVar = KRRichTextShadow.this.get_kuiklyRenderContext();
                dVar = KRRichTextShadow.this.textProps;
                textPaint.setTextSize(com.tencent.kuikly.core.render.android.css.ktx.b.s(aVar, dVar.getFontSize()));
                return textPaint;
            }
        });
        this.textPaint = lazy;
        this.spanTextRanges = new ArrayList();
    }

    private final Pair<Layout, SpannableStringBuilder> g(SizeF constraintSize, TextMeasureMode measureMode) {
        SpannableStringBuilder spannableStringBuilder;
        boolean z16 = true;
        if (this.textProps.z()) {
            this.isRichTextMode = true;
            spannableStringBuilder = h();
        } else {
            if (this.textProps.getText().length() <= 0) {
                z16 = false;
            }
            if (z16) {
                this.isRichTextMode = false;
                spannableStringBuilder = i();
            } else {
                spannableStringBuilder = null;
            }
        }
        if (spannableStringBuilder == null) {
            return null;
        }
        return new Pair<>(j(spannableStringBuilder, constraintSize, measureMode), spannableStringBuilder);
    }

    private final SpannableStringBuilder h() {
        this.spanTextRanges.clear();
        return new com.tencent.kuikly.core.render.android.expand.component.text.e(get_kuiklyRenderContext()).a(this.textProps, this.spanTextRanges, new Function0<SizeF>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRRichTextShadow$buildRichText$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SizeF invoke() {
                com.tencent.kuikly.core.render.android.expand.component.text.f textDrawer = KRRichTextShadow.this.getTextDrawer();
                if ((textDrawer != null ? textDrawer.getTextLayout() : null) == null) {
                    return new SizeF(0.0f, 0.0f);
                }
                return new SizeF(r0.getWidth(), r0.getHeight());
            }
        });
    }

    private final SpannableStringBuilder i() {
        boolean z16;
        boolean z17;
        int s16;
        d01.f c16;
        String str = this.textProps.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_TEXT_DECORATION java.lang.String();
        int hashCode = str.hashCode();
        boolean z18 = true;
        if (hashCode != -1171789332) {
            if (hashCode == -1026963764 && str.equals("underline")) {
                t().setUnderlineText(true);
            }
        } else if (str.equals(PTSNodeTextBase.TEXT_DECORATION_LINE_THROUGH)) {
            t().setStrikeThruText(true);
        }
        t().setTypeface(Typeface.defaultFromStyle(this.textProps.getFontStyle()));
        if (this.textProps.getFontWeight().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            t().setStyle(Paint.Style.FILL_AND_STROKE);
            t().setStrokeWidth(com.tencent.kuikly.core.render.android.expand.component.text.b.INSTANCE.a(this.textProps.getFontWeight()));
        }
        if (this.textProps.getFontFamily().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && (c16 = u.f392615m.c()) != null) {
            c16.a(this.textProps.getFontFamily(), new Function1<Typeface, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRRichTextShadow$buildSimpleText$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Typeface typeface) {
                    invoke2(typeface);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Typeface typeface) {
                    TextPaint t16;
                    t16 = KRRichTextShadow.this.t();
                    t16.setTypeface(typeface);
                }
            });
        }
        TextPaint t16 = t();
        if (this.textProps.getUseDpFontSizeDim()) {
            s16 = com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), this.textProps.getFontSize());
        } else {
            s16 = com.tencent.kuikly.core.render.android.css.ktx.b.s(get_kuiklyRenderContext(), this.textProps.getFontSize());
        }
        t16.setTextSize(s16);
        t().setColor(this.textProps.getColor());
        t().setLetterSpacing(com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), this.textProps.getLetterSpacing()) / Math.max(t().getTextSize(), 1.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.textProps.getText());
        if (this.textProps.getLineHeight() != -1.0f) {
            spannableStringBuilder.setSpan(new com.tencent.kuikly.core.render.android.expand.component.text.c((int) this.textProps.getLineHeight()), 0, spannableStringBuilder.length(), 17);
        }
        if (this.textProps.getBackgroundImage().length() <= 0) {
            z18 = false;
        }
        if (z18) {
            spannableStringBuilder.setSpan(l(this.textProps.getBackgroundImage()), 0, spannableStringBuilder.length(), 17);
        }
        if (this.textProps.getRichTextHeadIndent() != 0) {
            spannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(this.textProps.getRichTextHeadIndent(), 0), 0, spannableStringBuilder.length(), 17);
        }
        com.tencent.kuikly.core.render.android.css.decoration.a textShadow = this.textProps.getTextShadow();
        if (textShadow != null && !textShadow.e()) {
            spannableStringBuilder.setSpan(new n(textShadow.getShadowOffsetX(), textShadow.getShadowOffsetY(), textShadow.getShadowRadius(), textShadow.getCom.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_COLOR java.lang.String()), 0, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Layout j(SpannableStringBuilder text, SizeF constraintSize, TextMeasureMode measureMode) {
        boolean z16;
        SpannableStringBuilder spannableStringBuilder;
        SizeF sizeF;
        TextMeasureMode textMeasureMode;
        CharSequence charSequence;
        boolean z17;
        int i3;
        StaticLayout staticLayout;
        int i16;
        CharSequence ellipsize;
        StaticLayout build;
        d01.m j3;
        if (this.textProps.getTextPostProcessor().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (j3 = u.f392615m.j()) != null) {
            spannableStringBuilder = text;
            z a16 = j3.a(get_kuiklyRenderContext(), new y(this.textProps.getTextPostProcessor(), spannableStringBuilder, this.textProps));
            if (a16 != null && (charSequence = a16.getText()) != null) {
                sizeF = constraintSize;
                textMeasureMode = measureMode;
                int o16 = o(charSequence, sizeF, textMeasureMode);
                float f16 = 0.0f;
                if (KRCSSViewExtensionKt.z()) {
                    StaticLayout.Builder m3 = m(charSequence, o16);
                    if (this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String() > 0 && this.textProps.getLineBreakMargin() == 0.0f) {
                        m3.setMaxLines(this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String()).setEllipsize(p());
                    }
                    if (this.textProps.getLineBreakMargin() != 0.0f && this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String() != 0) {
                        StaticLayout build2 = m3.build();
                        Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
                        if (build2.getLineCount() > this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String()) {
                            StaticLayout.Builder n3 = n(build2, charSequence, o16);
                            if (n3 == null) {
                                n3 = m(charSequence, o16);
                            }
                            n3.setMaxLines(this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String()).setEllipsize(p()).setIndents(null, k(this.textProps));
                            this.textProps.B(true);
                            build2 = n3.build();
                        }
                        Intrinsics.checkNotNullExpressionValue(build2, "if (staticLayout.lineCou\u2026cLayout\n                }");
                        return build2;
                    }
                    StaticLayout build3 = m3.build();
                    Intrinsics.checkNotNullExpressionValue(build3, "builder.build()");
                    StaticLayout.Builder n16 = n(build3, charSequence, o16);
                    if (n16 != null && (build = n16.build()) != null) {
                        return build;
                    }
                    return build3;
                }
                if (this.textProps.getLineBreakMode().length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    i3 = o16;
                    staticLayout = new StaticLayout(charSequence, 0, charSequence.length(), t(), o16, r(), 1.0f, this.textProps.getLineSpacing(), this.textProps.getIncludePadding(), p(), o16);
                } else {
                    i3 = o16;
                    staticLayout = new StaticLayout(charSequence, 0, charSequence.length(), t(), i3, r(), 1.0f, this.textProps.getLineSpacing(), this.textProps.getIncludePadding());
                }
                if (this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String() != 0 && staticLayout.getLineCount() > this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String()) {
                    int lineEnd = staticLayout.getLineEnd(staticLayout.getLineCount() - 1);
                    if (this.textProps.getLineBreakMargin() != 0.0f) {
                        this.textProps.B(true);
                        f16 = this.textProps.getLineBreakMargin();
                    }
                    float f17 = f16;
                    if (p() == TextUtils.TruncateAt.MIDDLE && this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String() >= 2) {
                        i16 = i3;
                        ellipsize = y(staticLayout, charSequence, i16, f17);
                    } else {
                        i16 = i3;
                        ellipsize = TextUtils.ellipsize(charSequence.subSequence(0, lineEnd), t(), (i16 * this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String()) - f17, p());
                    }
                    CharSequence charSequence2 = ellipsize;
                    return new StaticLayout(charSequence2, 0, charSequence2.length(), t(), i16, r(), 1.0f, this.textProps.getLineSpacing(), this.textProps.getIncludePadding());
                }
                return staticLayout;
            }
        } else {
            spannableStringBuilder = text;
        }
        sizeF = constraintSize;
        textMeasureMode = measureMode;
        charSequence = spannableStringBuilder;
        int o162 = o(charSequence, sizeF, textMeasureMode);
        float f162 = 0.0f;
        if (KRCSSViewExtensionKt.z()) {
        }
    }

    private final int[] k(d textProps) {
        int i3 = textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String();
        int[] iArr = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            if (i16 == i3 - 1) {
                iArr[i16] = (int) textProps.getLineBreakMargin();
            } else {
                iArr[i16] = 0;
            }
        }
        return iArr;
    }

    private final j l(String backgroundImage) {
        return new j(backgroundImage, new Function0<SizeF>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRRichTextShadow$createLinearGradientForegroundSpan$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SizeF invoke() {
                com.tencent.kuikly.core.render.android.expand.component.text.f textDrawer = KRRichTextShadow.this.getTextDrawer();
                if ((textDrawer != null ? textDrawer.getTextLayout() : null) == null) {
                    return new SizeF(0.0f, 0.0f);
                }
                return new SizeF(r0.getWidth(), r0.getHeight());
            }
        });
    }

    @SuppressLint({"NewApi"})
    private final StaticLayout.Builder m(CharSequence textSource, int desiredWidth) {
        StaticLayout.Builder includePad = StaticLayout.Builder.obtain(textSource, 0, textSource.length(), t(), desiredWidth).setAlignment(r()).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.textProps.getLineSpacing(), 1.0f).setIncludePad(this.textProps.getIncludePadding());
        Intrinsics.checkNotNullExpressionValue(includePad, "StaticLayout.Builder.obt\u2026textProps.includePadding)");
        return includePad;
    }

    private final StaticLayout.Builder n(StaticLayout originStaticLayout, CharSequence originText, int desiredWidth) {
        if (p() != TextUtils.TruncateAt.MIDDLE || this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String() <= 0 || originStaticLayout.getLineCount() <= this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String()) {
            return null;
        }
        return m(z(this, originStaticLayout, originText, desiredWidth, 0.0f, 8, null), desiredWidth);
    }

    private final int o(CharSequence text, SizeF constraintSize, TextMeasureMode measureMode) {
        int width;
        int i3 = b.f117815a[measureMode.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                width = u(text, constraintSize);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            width = (int) constraintSize.getWidth();
        }
        return Math.max(width, 0);
    }

    private final TextUtils.TruncateAt p() {
        String lineBreakMode = this.textProps.getLineBreakMode();
        int hashCode = lineBreakMode.hashCode();
        if (hashCode != -1074341483) {
            if (hashCode == 3552336 && lineBreakMode.equals(TextNode.MODE_TAIL)) {
                return TextUtils.TruncateAt.END;
            }
        } else if (lineBreakMode.equals("middle")) {
            return TextUtils.TruncateAt.MIDDLE;
        }
        return TextUtils.TruncateAt.END;
    }

    private final Rect q(int index) {
        Layout textLayout;
        Object obj;
        boolean z16;
        Rect rect = new Rect(0, 0, 0, 0);
        try {
            com.tencent.kuikly.core.render.android.expand.component.text.f fVar = this.textDrawer;
            if (fVar != null && (textLayout = fVar.getTextLayout()) != null) {
                Iterator<T> it = this.spanTextRanges.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((m) obj).getIndex() == index) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                m mVar = (m) obj;
                if (mVar != null) {
                    CharSequence text = textLayout.getText();
                    if (text instanceof Spanned) {
                        int start = mVar.getStart();
                        com.tencent.kuikly.core.render.android.expand.component.text.d[] dVarArr = (com.tencent.kuikly.core.render.android.expand.component.text.d[]) ((Spanned) text).getSpans(start, mVar.getEnd(), com.tencent.kuikly.core.render.android.expand.component.text.d.class);
                        if (dVarArr.length == 1) {
                            int b16 = dVarArr[0].b();
                            int a16 = dVarArr[0].a();
                            float primaryHorizontal = textLayout.getPrimaryHorizontal(start);
                            int lineForOffset = textLayout.getLineForOffset(start);
                            int lineTop = textLayout.getLineTop(lineForOffset);
                            int lineBottom = textLayout.getLineBottom(lineForOffset);
                            textLayout.getPaint().getFontMetricsInt(new Paint.FontMetricsInt());
                            int i3 = lineTop + ((lineBottom - lineTop) / 2);
                            rect.left = com.tencent.kuikly.core.render.android.css.ktx.b.z(get_kuiklyRenderContext(), primaryHorizontal);
                            rect.right = com.tencent.kuikly.core.render.android.css.ktx.b.z(get_kuiklyRenderContext(), primaryHorizontal + b16);
                            rect.top = com.tencent.kuikly.core.render.android.css.ktx.b.z(get_kuiklyRenderContext(), i3 - (a16 / 2));
                            rect.bottom = com.tencent.kuikly.core.render.android.css.ktx.b.z(get_kuiklyRenderContext(), i3 + (a16 / 2));
                            return rect;
                        }
                        return rect;
                    }
                    return rect;
                }
                return rect;
            }
            return rect;
        } catch (Throwable th5) {
            Rect rect2 = new Rect(0, 0, 0, 0);
            w.f392617a.b("KuiklyRender", "getPlaceholderSpanRect error: " + th5);
            return rect2;
        }
    }

    private final Layout.Alignment r() {
        String textAlign = this.textProps.getTextAlign();
        int hashCode = textAlign.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode == 108511772 && textAlign.equals("right")) {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
        } else if (textAlign.equals("center")) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextPaint t() {
        return (TextPaint) this.textPaint.getValue();
    }

    private final int u(CharSequence text, SizeF constraintSize) {
        int roundToInt;
        float desiredWidth = Layout.getDesiredWidth(text, t());
        if (desiredWidth < constraintSize.getWidth() || constraintSize.getWidth() == 0.0f) {
            roundToInt = MathKt__MathJVMKt.roundToInt(desiredWidth + 0.5f);
            return roundToInt;
        }
        return (int) constraintSize.getWidth();
    }

    private final CharSequence y(StaticLayout originStaticLayout, CharSequence originText, int desiredWidth, float lineBreakMargin) {
        CharSequence subSequence = originText.subSequence(0, originStaticLayout.getLineEnd(this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String() - 2));
        int lineStart = originStaticLayout.getLineStart(this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String() - 1);
        int lineEnd = originStaticLayout.getLineEnd(this.textProps.getCom.tencent.mtt.hippy.dom.node.NodeProps.NUMBER_OF_LINES java.lang.String() - 1);
        float[] fArr = {0.0f};
        float measureText = t().measureText("\u2026");
        float f16 = desiredWidth;
        CharSequence subSequence2 = originText.subSequence(lineStart, t().breakText(originText, lineStart, lineEnd, true, (f16 / 2.0f) - measureText, fArr) + lineStart);
        CharSequence subSequence3 = originText.subSequence(originText.length() - t().breakText(originText, 0, originText.length(), false, ((f16 - fArr[0]) - measureText) - lineBreakMargin, fArr), originText.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(subSequence);
        spannableStringBuilder.append(subSequence2);
        spannableStringBuilder.append((CharSequence) "\u2026");
        spannableStringBuilder.append(subSequence3);
        return spannableStringBuilder;
    }

    static /* synthetic */ CharSequence z(KRRichTextShadow kRRichTextShadow, StaticLayout staticLayout, CharSequence charSequence, int i3, float f16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            f16 = 0.0f;
        }
        return kRRichTextShadow.y(staticLayout, charSequence, i3, f16);
    }

    @Override // i01.f
    @Nullable
    /* renamed from: a */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return super.get_kuiklyRenderContext();
    }

    @Override // i01.b
    public void b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        this.textProps.D(propKey, propValue);
    }

    @Override // i01.b
    @NotNull
    public SizeF c(@NotNull SizeF constraintSize) {
        Layout layout;
        Intrinsics.checkNotNullParameter(constraintSize, "constraintSize");
        Pair<Layout, SpannableStringBuilder> g16 = g(constraintSize, TextMeasureMode.AT_MOST);
        SpannableStringBuilder spannableStringBuilder = null;
        if (g16 != null) {
            layout = g16.getFirst();
        } else {
            layout = null;
        }
        d dVar = this.textProps;
        if (g16 != null) {
            spannableStringBuilder = g16.getSecond();
        }
        this.textDrawer = new com.tencent.kuikly.core.render.android.expand.component.text.f(layout, dVar, spannableStringBuilder);
        if (layout == null) {
            return new SizeF(0.0f, 0.0f);
        }
        return new SizeF(layout.getWidth(), layout.getHeight());
    }

    @Override // i01.f, i01.b
    @Nullable
    public Object d(@NotNull String methodName, @NotNull String params) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(params, "params");
        int hashCode = methodName.hashCode();
        if (hashCode != -321292177) {
            if (hashCode == 2057048142 && methodName.equals("spanRect")) {
                Rect q16 = q(Integer.parseInt(params));
                StringBuilder sb5 = new StringBuilder();
                sb5.append(q16.left);
                sb5.append(TokenParser.SP);
                sb5.append(q16.top);
                sb5.append(TokenParser.SP);
                sb5.append(q16.width());
                sb5.append(TokenParser.SP);
                sb5.append(q16.height());
                return sb5.toString();
            }
            return null;
        }
        if (methodName.equals("isLineBreakMargin")) {
            if (this.textProps.getIsLineBreakMargin()) {
                return "1";
            }
            return "0";
        }
        return null;
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final com.tencent.kuikly.core.render.android.expand.component.text.f getTextDrawer() {
        return this.textDrawer;
    }

    @Override // i01.f, i01.b
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        super.setKuiklyRenderContext(aVar);
        this.textProps = new d(aVar);
    }

    @NotNull
    public final Map<String, Object> v() {
        SpannableStringBuilder text;
        String spannableStringBuilder;
        boolean z16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.kuikly.core.render.android.expand.component.text.f fVar = this.textDrawer;
        if (fVar != null && (text = fVar.getText()) != null && (spannableStringBuilder = text.toString()) != null) {
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "drawer.text?.toString() ?: return data");
            int i3 = 0;
            if (spannableStringBuilder.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return linkedHashMap;
            }
            Layout textLayout = fVar.getTextLayout();
            if (textLayout != null) {
                int lineCount = textLayout.getLineCount();
                ArrayList arrayList = new ArrayList();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(spannableStringBuilder);
                int i16 = lineCount - 1;
                for (int i17 = 0; i17 < i16; i17++) {
                    int lineEnd = textLayout.getLineEnd(i17);
                    if (lineEnd > 0 && lineEnd < sb5.length() && !Intrinsics.areEqual(sb5.substring(lineEnd - 1, lineEnd), "\n")) {
                        arrayList.add(Integer.valueOf(textLayout.getLineEnd(i17)));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb5.insert(((Number) it.next()).intValue() + i3, "\u0017\n");
                    i3 += 2;
                }
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
                linkedHashMap.put("text", sb6);
                linkedHashMap.put("lineBreakMagicCode", 23);
            }
        }
        return linkedHashMap;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getIsRichTextMode() {
        return this.isRichTextMode;
    }

    public final void x(@NotNull SizeF constraintSize) {
        Layout layout;
        Intrinsics.checkNotNullParameter(constraintSize, "constraintSize");
        Pair<Layout, SpannableStringBuilder> g16 = g(constraintSize, TextMeasureMode.EXACTLY);
        SpannableStringBuilder spannableStringBuilder = null;
        if (g16 != null) {
            layout = g16.getFirst();
        } else {
            layout = null;
        }
        d dVar = this.textProps;
        if (g16 != null) {
            spannableStringBuilder = g16.getSecond();
        }
        this.textDrawer = new com.tencent.kuikly.core.render.android.expand.component.text.f(layout, dVar, spannableStringBuilder);
    }
}
