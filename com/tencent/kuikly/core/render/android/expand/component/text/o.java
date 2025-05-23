package com.tencent.kuikly.core.render.android.expand.component.text;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010>\u001a\u0004\u0018\u00010<\u00a2\u0006\u0004\bC\u0010DJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0014\u0010\u0012R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u001d\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u001f\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010!\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b \u0010\rR\u0017\u0010#\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b\u0005\u0010\u0012R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u00102\u001a\u0004\b\"\u00103\"\u0004\b4\u00105R$\u0010;\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u00107\u001a\u0004\b%\u00108\"\u0004\b9\u0010:R\u0016\u0010>\u001a\u0004\u0018\u00010<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010=\u00a8\u0006E"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/o;", "Lcom/tencent/kuikly/core/render/android/expand/component/text/l;", "", "p", "", "b", "I", "c", "()I", "color", "", UserInfo.SEX_FEMALE, "e", "()F", "fontSize", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "fontFamily", tl.h.F, "fontWeight", "f", "g", "setFontVariant", "(Ljava/lang/String;)V", "fontVariant", "fontStyle", "i", NodeProps.LETTER_SPACING, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, TtmlNode.ATTR_TTS_TEXT_DECORATION, "j", NodeProps.LINE_HEIGHT, "k", "backgroundImage", "Lcom/tencent/kuikly/core/render/android/css/decoration/a;", "l", "Lcom/tencent/kuikly/core/render/android/css/decoration/a;", DomainData.DOMAIN_NAME, "()Lcom/tencent/kuikly/core/render/android/css/decoration/a;", "setTextShadow", "(Lcom/tencent/kuikly/core/render/android/css/decoration/a;)V", "textShadow", "Z", "o", "()Z", "setUseDpFontSizeDim", "(Z)V", "useDpFontSizeDim", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "setStrokeColor", "(Ljava/lang/Integer;)V", "strokeColor", "Ljava/lang/Float;", "()Ljava/lang/Float;", "setStrokeWidth", "(Ljava/lang/Float;)V", "strokeWidth", "Lcom/tencent/kuikly/core/render/android/a;", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyContext", "Lorg/json/JSONObject;", "spanValue", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "defaultProps", "<init>", "(Lorg/json/JSONObject;Lcom/tencent/kuikly/core/render/android/expand/component/d;Lcom/tencent/kuikly/core/render/android/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class o extends l {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int color;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float fontSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fontFamily;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fontWeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String fontVariant;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int fontStyle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float letterSpacing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String textDecoration;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final float lineHeight;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String backgroundImage;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.kuikly.core.render.android.css.decoration.a textShadow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean useDpFontSizeDim;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer strokeColor;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Float strokeWidth;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a kuiklyContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull JSONObject spanValue, @NotNull com.tencent.kuikly.core.render.android.expand.component.d defaultProps, @Nullable com.tencent.kuikly.core.render.android.a aVar) {
        super(spanValue);
        boolean z16;
        int color;
        int fontStyle;
        float letterSpacing;
        float lineHeight;
        Intrinsics.checkNotNullParameter(spanValue, "spanValue");
        Intrinsics.checkNotNullParameter(defaultProps, "defaultProps");
        this.kuiklyContext = aVar;
        String colorStr = spanValue.optString("color");
        Intrinsics.checkNotNullExpressionValue(colorStr, "colorStr");
        if (colorStr.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            color = com.tencent.kuikly.core.render.android.css.ktx.b.w(colorStr);
        } else {
            color = defaultProps.getColor();
        }
        this.color = color;
        if (spanValue.has("strokeColor")) {
            String optString = spanValue.optString("strokeColor");
            Intrinsics.checkNotNullExpressionValue(optString, "spanValue.optString(KRTe\u2026ps.PROP_KEY_STROKE_COLOR)");
            this.strokeColor = Integer.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.w(optString));
        }
        if (spanValue.has("strokeWidth")) {
            this.strokeWidth = Float.valueOf((float) spanValue.optDouble("strokeWidth"));
        }
        float optDouble = (float) spanValue.optDouble("fontSize", defaultProps.getFontSize() * 1.0d);
        this.fontSize = optDouble;
        String optString2 = spanValue.optString("fontFamily", defaultProps.getFontFamily());
        Intrinsics.checkNotNullExpressionValue(optString2, "spanValue.optString(KRTe\u2026 defaultProps.fontFamily)");
        this.fontFamily = optString2;
        String optString3 = spanValue.optString("fontWeight", defaultProps.getFontWeight());
        Intrinsics.checkNotNullExpressionValue(optString3, "spanValue.optString(KRTe\u2026 defaultProps.fontWeight)");
        this.fontWeight = optString3;
        if (Intrinsics.areEqual(spanValue.optString("fontStyle"), "italic")) {
            fontStyle = 2;
        } else {
            fontStyle = defaultProps.getFontStyle();
        }
        this.fontStyle = fontStyle;
        String optString4 = spanValue.optString("fontVariant");
        Intrinsics.checkNotNullExpressionValue(optString4, "spanValue.optString(KRTe\u2026ps.PROP_KEY_FONT_VARIANT)");
        this.fontVariant = optString4;
        if (spanValue.has(NodeProps.LETTER_SPACING)) {
            letterSpacing = ((float) spanValue.optDouble(NodeProps.LETTER_SPACING)) / Math.max(optDouble, 1.0f);
        } else {
            letterSpacing = defaultProps.getLetterSpacing();
        }
        this.letterSpacing = letterSpacing;
        String optString5 = spanValue.optString(TtmlNode.ATTR_TTS_TEXT_DECORATION, defaultProps.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_TEXT_DECORATION java.lang.String());
        Intrinsics.checkNotNullExpressionValue(optString5, "spanValue.optString(KRTe\u2026aultProps.textDecoration)");
        this.textDecoration = optString5;
        if (spanValue.has(NodeProps.LINE_HEIGHT)) {
            lineHeight = com.tencent.kuikly.core.render.android.css.ktx.b.I(aVar, (float) spanValue.optDouble(NodeProps.LINE_HEIGHT));
        } else {
            lineHeight = defaultProps.getLineHeight();
        }
        this.lineHeight = lineHeight;
        String optString6 = spanValue.optString("backgroundImage", defaultProps.getBackgroundImage());
        Intrinsics.checkNotNullExpressionValue(optString6, "spanValue.optString(KRTe\u2026ultProps.backgroundImage)");
        this.backgroundImage = optString6;
        String textShadowStr = spanValue.optString("textShadow", "");
        Intrinsics.checkNotNullExpressionValue(textShadowStr, "textShadowStr");
        this.textShadow = new com.tencent.kuikly.core.render.android.css.decoration.a(textShadowStr, aVar);
        this.useDpFontSizeDim = spanValue.optInt("useDpFontSizeDim") == 1;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBackgroundImage() {
        return this.backgroundImage;
    }

    /* renamed from: c, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: e, reason: from getter */
    public final float getFontSize() {
        return this.fontSize;
    }

    /* renamed from: f, reason: from getter */
    public final int getFontStyle() {
        return this.fontStyle;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getFontVariant() {
        return this.fontVariant;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: i, reason: from getter */
    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    /* renamed from: j, reason: from getter */
    public final float getLineHeight() {
        return this.lineHeight;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final Integer getStrokeColor() {
        return this.strokeColor;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getTextDecoration() {
        return this.textDecoration;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final com.tencent.kuikly.core.render.android.css.decoration.a getTextShadow() {
        return this.textShadow;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getUseDpFontSizeDim() {
        return this.useDpFontSizeDim;
    }

    public final boolean p() {
        if (this.strokeColor != null && this.strokeWidth != null) {
            return true;
        }
        return false;
    }
}
