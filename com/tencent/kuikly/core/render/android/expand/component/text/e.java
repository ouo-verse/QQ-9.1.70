package com.tencent.kuikly.core.render.android.expand.component.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.SizeF;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J,\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/e;", "", "Lorg/json/JSONObject;", "spanValue", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "defaultTextProps", "Lcom/tencent/kuikly/core/render/android/expand/component/text/l;", "e", "", "d", "spanProps", "", "index", "Lkotlin/Function0;", "Landroid/util/SizeF;", "layoutSizeGetter", "", "b", "Lcom/tencent/kuikly/core/render/android/expand/component/text/o;", "c", "textProps", "", "Lcom/tencent/kuikly/core/render/android/expand/component/text/m;", "spanTextRanges", "Landroid/text/SpannableStringBuilder;", "a", "Lcom/tencent/kuikly/core/render/android/a;", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyContext", "<init>", "(Lcom/tencent/kuikly/core/render/android/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a kuiklyContext;

    public e(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        this.kuiklyContext = aVar;
    }

    private final List<Object> b(l spanProps, int index, Function0<SizeF> layoutSizeGetter) {
        ArrayList arrayList = new ArrayList();
        if (spanProps instanceof o) {
            arrayList.addAll(c((o) spanProps, index, layoutSizeGetter));
        } else if (spanProps instanceof k) {
            arrayList.add(new d((k) spanProps));
        }
        return arrayList;
    }

    private final List<Object> c(o spanProps, int index, Function0<SizeF> layoutSizeGetter) {
        boolean z16;
        boolean z17;
        boolean z18;
        int s16;
        ArrayList arrayList = new ArrayList();
        boolean z19 = false;
        if (spanProps.getFontSize() > 0) {
            if (spanProps.getUseDpFontSizeDim()) {
                s16 = com.tencent.kuikly.core.render.android.css.ktx.b.K(this.kuiklyContext, spanProps.getFontSize());
            } else {
                s16 = com.tencent.kuikly.core.render.android.css.ktx.b.s(this.kuiklyContext, spanProps.getFontSize());
            }
            arrayList.add(new AbsoluteSizeSpan(s16));
        }
        b bVar = new b(spanProps.getFontWeight(), index);
        arrayList.add(bVar);
        arrayList.add(new StyleSpan(spanProps.getFontStyle()));
        if (spanProps.getFontVariant().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            arrayList.add(new a(spanProps.getFontVariant()));
        }
        if (spanProps.getFontFamily().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            arrayList.add(new FontFamilySpan(spanProps.getFontFamily()));
        }
        if (spanProps.getStrokeWidth() != null && spanProps.getStrokeColor() != null) {
            arrayList.add(new g(spanProps.getStrokeWidth(), spanProps.getStrokeColor(), bVar.getStrokeWidth(), false, 8, null));
        }
        arrayList.add(new KRForegroundColorSpan(spanProps.getColor()));
        if (spanProps.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_TEXT_DECORATION java.lang.String().length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            if (Intrinsics.areEqual(spanProps.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_TEXT_DECORATION java.lang.String(), PTSNodeTextBase.TEXT_DECORATION_LINE_THROUGH)) {
                arrayList.add(new StrikethroughSpan());
            } else {
                arrayList.add(new UnderlineSpan());
            }
        }
        if (spanProps.getBackgroundImage().length() > 0) {
            z19 = true;
        }
        if (z19) {
            arrayList.add(new j(spanProps.getBackgroundImage(), layoutSizeGetter));
        }
        com.tencent.kuikly.core.render.android.css.decoration.a textShadow = spanProps.getTextShadow();
        if (textShadow != null && !textShadow.e()) {
            arrayList.add(new n(textShadow.getShadowOffsetX(), textShadow.getShadowOffsetY(), textShadow.getShadowRadius(), textShadow.getCom.tencent.mtt.hippy.dom.node.NodeProps.SHADOW_COLOR java.lang.String()));
        }
        if (spanProps.getLetterSpacing() != 0.0f) {
            arrayList.add(new h(spanProps.getLetterSpacing()));
        }
        if (spanProps.getLineHeight() != -1.0f) {
            arrayList.add(new c((int) spanProps.getLineHeight()));
        }
        return arrayList;
    }

    private final boolean d(JSONObject spanValue) {
        if (spanValue.opt("placeholderWidth") != null && spanValue.opt("placeholderHeight") != null) {
            return true;
        }
        return false;
    }

    private final l e(JSONObject spanValue, com.tencent.kuikly.core.render.android.expand.component.d defaultTextProps) {
        if (d(spanValue)) {
            return new k(spanValue, this.kuiklyContext);
        }
        return new o(spanValue, defaultTextProps, this.kuiklyContext);
    }

    @Nullable
    public final SpannableStringBuilder a(@NotNull com.tencent.kuikly.core.render.android.expand.component.d textProps, @NotNull List<m> spanTextRanges, @NotNull Function0<SizeF> layoutSizeGetter) {
        Intrinsics.checkNotNullParameter(textProps, "textProps");
        Intrinsics.checkNotNullParameter(spanTextRanges, "spanTextRanges");
        Intrinsics.checkNotNullParameter(layoutSizeGetter, "layoutSizeGetter");
        JSONArray values = textProps.getValues();
        if (values != null && values.length() != 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int length = values.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = values.optJSONObject(i3);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                l e16 = e(optJSONObject, textProps);
                if ((e16 instanceof o) && !textProps.getNeedTextStrokeDraw()) {
                    textProps.C(((o) e16).p());
                }
                List<Object> b16 = b(e16, i3, layoutSizeGetter);
                if (!b16.isEmpty()) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    spanTextRanges.add(new m(i3, spannableStringBuilder.length(), spannableStringBuilder.length() + e16.getText().length()));
                    int length2 = spannableStringBuilder2.length();
                    spannableStringBuilder2.append((CharSequence) e16.getText());
                    Iterator<Object> it = b16.iterator();
                    while (it.hasNext()) {
                        spannableStringBuilder2.setSpan(it.next(), length2, spannableStringBuilder2.length(), 17);
                    }
                    Unit unit = Unit.INSTANCE;
                    spannableStringBuilder.append((CharSequence) new SpannedString(spannableStringBuilder2));
                }
            }
            if (textProps.getRichTextHeadIndent() != 0) {
                spannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(textProps.getRichTextHeadIndent(), 0), 0, spannableStringBuilder.length(), 17);
            }
            return spannableStringBuilder;
        }
        return null;
    }
}
