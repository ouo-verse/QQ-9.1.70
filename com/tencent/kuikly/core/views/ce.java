package com.tencent.kuikly.core.views;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.module.FontModule;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0016J#\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0000H\u0016J\b\u0010\u0011\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\b\u0010\u0016\u001a\u00020\u0000H\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\b\u0010\u0018\u001a\u00020\u0000H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\u0000H\u0016J\b\u0010\u001e\u001a\u00020\u0000H\u0016J\b\u0010\u001f\u001a\u00020\u0000H\u0016J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\b\u0010\"\u001a\u00020\u0000H\u0016J\b\u0010#\u001a\u00020\u0000H\u0016J\b\u0010$\u001a\u00020\u0000H\u0016J\b\u0010%\u001a\u00020\u0000H\u0016J\u0010\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\fH\u0016J\u0010\u0010*\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\u0000H\u0016J\b\u0010-\u001a\u00020\u0000H\u0016J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\nH\u0016J\u0010\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004H\u0016J\u0012\u00103\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\fH\u0016J(\u00107\u001a\u00020\u00002\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u00109\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u00108\u001a\u00020\nH\u0016J+\u0010?\u001a\u00020\u00012\u0006\u0010;\u001a\u00020:2\u0012\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0<\"\u00020=H\u0016\u00a2\u0006\u0004\b?\u0010@R\"\u0010A\u001a\u00020\f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010*\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010G\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR$\u0010&\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010G\u001a\u0004\bN\u0010I\"\u0004\bO\u0010K\u00a8\u0006R"}, d2 = {"Lcom/tencent/kuikly/core/views/ce;", "Lcom/tencent/kuikly/core/base/Attr;", "", "updateLineHeightIfNeed", "", "value", "text", "", "color", "Lcom/tencent/kuikly/core/base/h;", "", "size", "", "scaleFontSizeEnable", "fontSize", "(FLjava/lang/Boolean;)Lcom/tencent/kuikly/core/views/ce;", "fontWeightNormal", "fontWeightBold", "fontWeightMedium", "fontWeightSemisolid", "fontWeight300", "fontWeight400", "fontWeight500", "fontWeight600", "fontWeight700", "fontFamily", "", "lines", "lineBreakMargin", "textOverFlowTail", "textOverFlowClip", "textOverFlowMiddle", "textOverFlowWordWrapping", "textDecorationUnderLine", "textDecorationLineThrough", "textAlignCenter", "textAlignLeft", "textAlignRight", NodeProps.LINE_HEIGHT, "lineSpacing", "include", "includePadding", NodeProps.LETTER_SPACING, "paragraphSpacing", "fontStyleNormal", "fontStyleItalic", "headIndent", "firstLineHeadIndent", "processorName", "textPostProcessor", "useDp", "useDpFontSizeDim", "offsetX", "offsetY", "radius", "textShadow", "width", "textStroke", "Lcom/tencent/kuikly/core/base/Direction;", "direction", "", "Lcom/tencent/kuikly/core/base/j;", "colorStops", "backgroundLinearGradient", "(Lcom/tencent/kuikly/core/base/Direction;[Lcom/tencent/kuikly/core/base/j;)Lcom/tencent/kuikly/core/base/Attr;", "didSetTextGradient", "Z", "getDidSetTextGradient$core_release", "()Z", "setDidSetTextGradient$core_release", "(Z)V", "Ljava/lang/Float;", "getLetterSpacing$core_release", "()Ljava/lang/Float;", "setLetterSpacing$core_release", "(Ljava/lang/Float;)V", "getFontSize$core_release", "setFontSize$core_release", "getLineHeight$core_release", "setLineHeight$core_release", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ce extends Attr {
    private boolean didSetTextGradient;
    private Float fontSize;
    private Float letterSpacing;
    private Float lineHeight;

    private final void updateLineHeightIfNeed() {
        Float f16;
        if (this.fontSize == null || (f16 = this.lineHeight) == null) {
            return;
        }
        Intrinsics.checkNotNull(f16);
        float floatValue = f16.floatValue();
        Float f17 = this.fontSize;
        Intrinsics.checkNotNull(f17);
        if (floatValue < f17.floatValue()) {
            Float f18 = this.fontSize;
            Intrinsics.checkNotNull(f18);
            this.lineHeight = f18;
            Float f19 = this.fontSize;
            Intrinsics.checkNotNull(f19);
            with(NodeProps.LINE_HEIGHT, f19);
        }
    }

    public ce color(long color) {
        with("color", new com.tencent.kuikly.core.base.h(color).toString());
        return this;
    }

    public void firstLineHeadIndent(float headIndent) {
        with("headIndent", Float.valueOf(headIndent));
    }

    public ce fontFamily(String fontFamily) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        with("fontFamily", fontFamily);
        return this;
    }

    public ce fontSize(float size, Boolean scaleFontSizeEnable) {
        float a16 = FontModule.INSTANCE.a(size, scaleFontSizeEnable);
        with("fontSize", Float.valueOf(a16));
        Float f16 = this.letterSpacing;
        if (f16 != null) {
            letterSpacing(f16.floatValue());
        }
        this.fontSize = Float.valueOf(a16);
        updateLineHeightIfNeed();
        return this;
    }

    public ce fontStyleItalic() {
        with("fontStyle", "italic");
        return this;
    }

    public ce fontStyleNormal() {
        with("fontStyle", "normal");
        return this;
    }

    public ce fontWeight300() {
        with("fontWeight", IndividuationPlugin.Business_Font);
        return this;
    }

    public ce fontWeight400() {
        return fontWeightNormal();
    }

    public ce fontWeight500() {
        return fontWeightMedium();
    }

    public ce fontWeight600() {
        return fontWeightSemisolid();
    }

    public ce fontWeight700() {
        return fontWeightBold();
    }

    public ce fontWeightBold() {
        with("fontWeight", IndividuationPlugin.Business_Profilecard);
        return this;
    }

    public ce fontWeightMedium() {
        with("fontWeight", "500");
        return this;
    }

    public ce fontWeightNormal() {
        with("fontWeight", IndividuationPlugin.Business_Pendant);
        return this;
    }

    public ce fontWeightSemisolid() {
        with("fontWeight", IndividuationPlugin.Business_Theme);
        return this;
    }

    /* renamed from: getDidSetTextGradient$core_release, reason: from getter */
    public final boolean getDidSetTextGradient() {
        return this.didSetTextGradient;
    }

    /* renamed from: getFontSize$core_release, reason: from getter */
    public final Float getFontSize() {
        return this.fontSize;
    }

    /* renamed from: getLetterSpacing$core_release, reason: from getter */
    public final Float getLetterSpacing() {
        return this.letterSpacing;
    }

    /* renamed from: getLineHeight$core_release, reason: from getter */
    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public ce includePadding(boolean include) {
        with("includePadding", Integer.valueOf(com.tencent.kuikly.core.base.d.b(include)));
        return this;
    }

    public ce letterSpacing(float value) {
        float f16;
        if (getPagerData().getIsAndroid() && getPagerData().getNativeBuild() < 4) {
            Object prop = getProp("fontSize");
            Float f17 = prop instanceof Float ? (Float) prop : null;
            if (f17 != null && f17.floatValue() > 0.0f) {
                f16 = (value / f17.floatValue()) / 3.0f;
                this.letterSpacing = Float.valueOf(value);
                with(NodeProps.LETTER_SPACING, Float.valueOf(f16));
                return this;
            }
        }
        f16 = value;
        this.letterSpacing = Float.valueOf(value);
        with(NodeProps.LETTER_SPACING, Float.valueOf(f16));
        return this;
    }

    public ce lineBreakMargin(float lineBreakMargin) {
        with("lineBreakMargin", Float.valueOf(lineBreakMargin));
        return this;
    }

    public ce lineHeight(float lineHeight) {
        this.lineHeight = Float.valueOf(lineHeight);
        with(NodeProps.LINE_HEIGHT, Float.valueOf(lineHeight));
        updateLineHeightIfNeed();
        return this;
    }

    public ce lineSpacing(float value) {
        with("lineSpacing", Float.valueOf(value));
        return this;
    }

    public ce lines(int lines) {
        with(NodeProps.NUMBER_OF_LINES, Integer.valueOf(lines));
        return this;
    }

    public ce paragraphSpacing(float value) {
        with("paragraphSpacing", Float.valueOf(value));
        return this;
    }

    public final void setDidSetTextGradient$core_release(boolean z16) {
        this.didSetTextGradient = z16;
    }

    public final void setFontSize$core_release(Float f16) {
        this.fontSize = f16;
    }

    public final void setLetterSpacing$core_release(Float f16) {
        this.letterSpacing = f16;
    }

    public final void setLineHeight$core_release(Float f16) {
        this.lineHeight = f16;
    }

    public ce text(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        with("text", text);
        return this;
    }

    public ce textAlignCenter() {
        with("textAlign", "center");
        return this;
    }

    public ce textAlignLeft() {
        with("textAlign", "left");
        return this;
    }

    public ce textAlignRight() {
        with("textAlign", "right");
        return this;
    }

    public ce textDecorationLineThrough() {
        with(TtmlNode.ATTR_TTS_TEXT_DECORATION, PTSNodeTextBase.TEXT_DECORATION_LINE_THROUGH);
        return this;
    }

    public ce textDecorationUnderLine() {
        with(TtmlNode.ATTR_TTS_TEXT_DECORATION, "underline");
        return this;
    }

    public ce textOverFlowClip() {
        with("lineBreakMode", "clip");
        return this;
    }

    public ce textOverFlowMiddle() {
        with("lineBreakMode", "middle");
        return this;
    }

    public ce textOverFlowTail() {
        with("lineBreakMode", TextNode.MODE_TAIL);
        return this;
    }

    public ce textOverFlowWordWrapping() {
        with("lineBreakMode", "wordWrapping");
        return this;
    }

    public ce textPostProcessor(String processorName) {
        Intrinsics.checkNotNullParameter(processorName, "processorName");
        with("textPostProcessor", processorName);
        return this;
    }

    public ce textShadow(float offsetX, float offsetY, float radius, com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("textShadow", new com.tencent.kuikly.core.base.g(offsetX, offsetY, radius, color).toString());
        return this;
    }

    public ce textStroke(com.tencent.kuikly.core.base.h color, float width) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("strokeColor", color.toString());
        with("strokeWidth", Float.valueOf(width));
        return this;
    }

    public ce useDpFontSizeDim(boolean useDp) {
        with("useDpFontSizeDim", Integer.valueOf(com.tencent.kuikly.core.base.d.b(useDp)));
        return this;
    }

    public ce value(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        with("text", value);
        return this;
    }

    @Override // com.tencent.kuikly.core.base.Attr
    /* renamed from: backgroundLinearGradient */
    public Attr mo135backgroundLinearGradient(Direction direction, com.tencent.kuikly.core.base.j... colorStops) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        this.didSetTextGradient = true;
        return super.mo135backgroundLinearGradient(direction, (com.tencent.kuikly.core.base.j[]) Arrays.copyOf(colorStops, colorStops.length));
    }

    public ce color(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("color", color.toString());
        return this;
    }

    public static /* synthetic */ ce fontSize$default(ce ceVar, float f16, Boolean bool, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                bool = null;
            }
            return ceVar.fontSize(f16, bool);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fontSize");
    }

    public static /* synthetic */ ce useDpFontSizeDim$default(ce ceVar, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            return ceVar.useDpFontSizeDim(z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: useDpFontSizeDim");
    }

    public static /* synthetic */ ce textStroke$default(ce ceVar, com.tencent.kuikly.core.base.h hVar, float f16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                f16 = 2.0f;
            }
            return ceVar.textStroke(hVar, f16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: textStroke");
    }
}
