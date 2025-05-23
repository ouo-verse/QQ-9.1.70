package com.tencent.mtt.hippy.dom.node;

import android.text.TextUtils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.flex.j;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.smtt.flexbox.FlexNodeStyle;
import java.util.Locale;
import kotlin.jvm.internal.DoubleCompanionObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class StyleNode extends b {
    @HippyControllerProps(name = NodeProps.ALIGN_ITEMS)
    public void setAlignItems(String str) {
        com.tencent.mtt.hippy.dom.flex.a valueOf;
        if (str == null) {
            valueOf = com.tencent.mtt.hippy.dom.flex.a.STRETCH;
        } else {
            valueOf = com.tencent.mtt.hippy.dom.flex.a.valueOf(str.toUpperCase(Locale.US).replace("-", "_"));
        }
        setAlignItems(valueOf);
    }

    @HippyControllerProps(name = NodeProps.ALIGN_SELF)
    public void setAlignSelf(String str) {
        com.tencent.mtt.hippy.dom.flex.a valueOf;
        if (str == null) {
            valueOf = com.tencent.mtt.hippy.dom.flex.a.AUTO;
        } else {
            valueOf = com.tencent.mtt.hippy.dom.flex.a.valueOf(str.toUpperCase(Locale.US).replace("-", "_"));
        }
        setAlignSelf(valueOf);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_WIDTH)
    public void setBorderWidths(float f16) {
        setBorder(8, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_BOTTOM_WIDTH)
    public void setBottomBorderWidths(float f16) {
        setBorder(3, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = "bottom")
    public void setBottomPositionValues(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPosition(3, f16);
    }

    @HippyControllerProps(defaultString = "ltr", defaultType = HippyControllerProps.STRING, name = "direction")
    public void setDirection(String str) {
        com.tencent.mtt.hippy.dom.flex.d dVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (!str.equals("rtl")) {
            if (!str.equals("inherit")) {
                dVar = com.tencent.mtt.hippy.dom.flex.d.LTR;
            } else {
                dVar = com.tencent.mtt.hippy.dom.flex.d.INHERIT;
            }
        } else {
            dVar = com.tencent.mtt.hippy.dom.flex.d.RTL;
        }
        setDirection(dVar);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "display")
    public void setDisplay(String str) {
        FlexNodeStyle.a aVar = FlexNodeStyle.a.DISPLAY_FLEX;
        str.hashCode();
        if (str.equals("none")) {
            aVar = FlexNodeStyle.a.DISPLAY_NONE;
        }
        setDisplay(aVar);
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.FLEX)
    public void setFlex(float f16) {
        super.setFlex(f16);
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = NodeProps.FLEX_BASIS)
    public void setFlexBasis(float f16) {
        super.setFlexBasis(f16);
    }

    @HippyControllerProps(name = NodeProps.FLEX_DIRECTION)
    public void setFlexDirection(String str) {
        com.tencent.mtt.hippy.dom.flex.b valueOf;
        if (str == null) {
            valueOf = com.tencent.mtt.hippy.dom.flex.b.COLUMN;
        } else {
            valueOf = com.tencent.mtt.hippy.dom.flex.b.valueOf(str.toUpperCase(Locale.US).replace("-", "_"));
        }
        setFlexDirection(valueOf);
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.FLEX_GROW)
    public void setFlexGrow(float f16) {
        super.setFlexGrow(f16);
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.FLEX_SHRINK)
    public void setFlexShrink(float f16) {
        super.setFlexShrink(f16);
    }

    @HippyControllerProps(name = NodeProps.FLEX_WRAP)
    public void setFlexWrap(String str) {
        j valueOf;
        if (str == null) {
            valueOf = j.NOWRAP;
        } else {
            valueOf = j.valueOf(str.toUpperCase(Locale.US).replace("-", "_"));
        }
        setWrap(valueOf);
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = "height")
    public void setHeight(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setStyleHeight(f16);
    }

    @HippyControllerProps(name = NodeProps.JUSTIFY_CONTENT)
    public void setJustifyContent(String str) {
        com.tencent.mtt.hippy.dom.flex.e valueOf;
        if (str == null) {
            valueOf = com.tencent.mtt.hippy.dom.flex.e.FLEX_START;
        } else {
            valueOf = com.tencent.mtt.hippy.dom.flex.e.valueOf(str.toUpperCase(Locale.US).replace("-", "_"));
        }
        setJustifyContent(valueOf);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_LEFT_WIDTH)
    public void setLeftBorderWidths(float f16) {
        setBorder(0, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = "left")
    public void setLeftPositionValues(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPosition(0, f16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "margin")
    public void setMargin(float f16) {
        setMargin(8, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.MARGIN_BOTTOM)
    public void setMarginBottom(float f16) {
        setMargin(3, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.MARGIN_HORIZONTAL)
    public void setMarginHoriziontal(float f16) {
        setMargin(6, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.MARGIN_LEFT)
    public void setMarginLeft(float f16) {
        setMargin(0, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.MARGIN_RIGHT)
    public void setMarginRight(float f16) {
        setMargin(2, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.MARGIN_TOP)
    public void setMarginTop(float f16) {
        setMargin(1, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.MARGIN_VERTICAL)
    public void setMarginVertical(float f16) {
        setMargin(7, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = NodeProps.MAX_HEIGHT)
    public void setMaxHeight(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setStyleMaxHeight(f16);
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = NodeProps.MAX_WIDTH)
    public void setMaxWidth(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setStyleMaxWidth(f16);
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = NodeProps.MIN_HEIGHT)
    public void setMinHeight(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setStyleMinHeight(f16);
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = NodeProps.MIN_WIDTH)
    public void setMinWidth(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setStyleMinWidth(f16);
    }

    @HippyControllerProps(name = "overflow")
    public void setOverflow(String str) {
        com.tencent.mtt.hippy.dom.flex.h valueOf;
        if (str == null) {
            valueOf = com.tencent.mtt.hippy.dom.flex.h.VISIBLE;
        } else {
            valueOf = com.tencent.mtt.hippy.dom.flex.h.valueOf(str.toUpperCase(Locale.US).replace("-", "_"));
        }
        setOverflow(valueOf);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "padding")
    public void setPadding(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPadding(8, f16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.PADDING_BOTTOM)
    public void setPaddingBottom(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPadding(3, f16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.PADDING_HORIZONTAL)
    public void setPaddingHorizontal(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPadding(6, f16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.PADDING_LEFT)
    public void setPaddingLeft(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPadding(0, f16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.PADDING_RIGHT)
    public void setPaddingRight(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPadding(2, f16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.PADDING_TOP)
    public void setPaddingTop(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPadding(1, f16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.PADDING_VERTICAL)
    public void setPaddingVertical(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPadding(7, f16);
    }

    @HippyControllerProps(name = "position")
    public void setPosition(String str) {
        com.tencent.mtt.hippy.dom.flex.i valueOf;
        if (str == null) {
            valueOf = com.tencent.mtt.hippy.dom.flex.i.RELATIVE;
        } else {
            valueOf = com.tencent.mtt.hippy.dom.flex.i.valueOf(str.toUpperCase(Locale.US));
        }
        setPositionType(valueOf);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_RIGHT_WIDTH)
    public void setRightBorderWidths(float f16) {
        setBorder(2, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = "right")
    public void setRightPositionValues(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPosition(2, f16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.SHADOW_RADIUS)
    public void setShadowRadius(float f16) {
        if (f16 > 0.0f) {
            setDirection(com.tencent.mtt.hippy.dom.flex.d.LTR);
        }
    }

    @Override // com.tencent.mtt.hippy.dom.node.b
    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z16) {
        super.setShouldNotifyOnLayout(z16);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = NodeProps.BORDER_TOP_WIDTH)
    public void setTopBorderWidths(float f16) {
        setBorder(1, PixelUtil.dp2px(f16));
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = "top")
    public void setTopPositionValues(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setPosition(1, f16);
    }

    @HippyControllerProps(defaultNumber = DoubleCompanionObject.NaN, defaultType = "number", name = "width")
    public void setWidth(float f16) {
        if (!com.tencent.mtt.hippy.dom.flex.c.a(f16)) {
            f16 = PixelUtil.dp2px(f16);
        }
        setStyleWidth(f16);
    }
}
