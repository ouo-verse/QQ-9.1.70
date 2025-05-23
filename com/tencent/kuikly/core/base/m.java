package com.tencent.kuikly.core.base;

import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.layout.StyleSpace;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\u0005\u001a\u00020\u0000J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\t\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000J\u0010\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u0015\u001a\u00020\u0000J\u0006\u0010\u0016\u001a\u00020\u0000J\u0006\u0010\u0017\u001a\u00020\u0000J\u0006\u0010\u0018\u001a\u00020\u0000J\u0006\u0010\u0019\u001a\u00020\u0000J(\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001aJ\u0012\u0010(\u001a\u00020'2\b\b\u0002\u0010&\u001a\u00020%H\u0016J+\u0010/\u001a\u00020'2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110*\u00a2\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020'0)H\u0016R\u0014\u00102\u001a\u00020*8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/kuikly/core/base/m;", "Lcom/tencent/kuikly/core/base/Attr;", "Lcom/tencent/kuikly/core/base/attr/a;", "Lcom/tencent/kuikly/core/layout/FlexDirection;", NodeProps.FLEX_DIRECTION, "flexDirectionColumn", "flexDirectionRow", "Lcom/tencent/kuikly/core/layout/FlexWrap;", NodeProps.FLEX_WRAP, "flexWrapNoWrap", "flexWrapWrap", "Lcom/tencent/kuikly/core/layout/FlexJustifyContent;", NodeProps.JUSTIFY_CONTENT, "justifyContentCenter", "justifyContentFlexStart", "justifyContentFlexEnd", "justifyContentSpaceAround", "justifyContentSpaceEvenly", "justifyContentSpaceBetween", "Lcom/tencent/kuikly/core/layout/FlexAlign;", NodeProps.ALIGN_ITEMS, "alignItemsCenter", "alignItemsFlexStart", "alignItemsFlexEnd", "alignItemsStretch", "allCenter", "", "top", "left", "bottom", "right", "padding", "all", NodeProps.PADDING_TOP, NodeProps.PADDING_BOTTOM, NodeProps.PADDING_LEFT, NodeProps.PADDING_RIGHT, "Lcom/tencent/kuikly/core/base/h;", "color", "", "highlightBackgroundColor", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isHighlight", "callback", "highlightCallback", "isHorizontalDirection$core_release", "()Z", "isHorizontalDirection", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class m extends Attr implements com.tencent.kuikly.core.base.attr.a {
    public final m alignItemsCenter() {
        alignItems(FlexAlign.CENTER);
        return this;
    }

    public final m alignItemsFlexEnd() {
        alignItems(FlexAlign.FLEX_END);
        return this;
    }

    public final m alignItemsFlexStart() {
        alignItems(FlexAlign.FLEX_START);
        return this;
    }

    public final m alignItemsStretch() {
        alignItems(FlexAlign.STRETCH);
        return this;
    }

    public final m allCenter() {
        alignItems(FlexAlign.CENTER);
        justifyContent(FlexJustifyContent.CENTER);
        return this;
    }

    public final m flexDirectionColumn() {
        flexDirection(FlexDirection.COLUMN);
        return this;
    }

    public m flexDirectionRow() {
        flexDirection(FlexDirection.ROW);
        return this;
    }

    public final m flexWrapNoWrap() {
        flexWrap(FlexWrap.NOWRAP);
        return this;
    }

    public final m flexWrapWrap() {
        flexWrap(FlexWrap.WRAP);
        return this;
    }

    public void highlightBackgroundColor(h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        PagerNotFoundExceptionKt.a("\u5f53\u524d\u7ec4\u4ef6" + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "\u4e0d\u652f\u6301highlightBackgroundColor");
    }

    public void highlightCallback(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        PagerNotFoundExceptionKt.a("\u5f53\u524d\u7ec4\u4ef6" + Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + "\u4e0d\u652f\u6301highlightBackgroundColor");
    }

    public final boolean isHorizontalDirection$core_release() {
        FlexNode flexNode = getFlexNode();
        if ((flexNode != null ? flexNode.j() : null) != FlexDirection.ROW) {
            FlexNode flexNode2 = getFlexNode();
            if ((flexNode2 != null ? flexNode2.j() : null) != FlexDirection.ROW_REVERSE) {
                return false;
            }
        }
        return true;
    }

    public final m justifyContentCenter() {
        justifyContent(FlexJustifyContent.CENTER);
        return this;
    }

    public final m justifyContentFlexEnd() {
        justifyContent(FlexJustifyContent.FLEX_END);
        return this;
    }

    public final m justifyContentFlexStart() {
        justifyContent(FlexJustifyContent.FLEX_START);
        return this;
    }

    public final m justifyContentSpaceAround() {
        justifyContent(FlexJustifyContent.SPACE_AROUND);
        return this;
    }

    public final m justifyContentSpaceBetween() {
        justifyContent(FlexJustifyContent.SPACE_BETWEEN);
        return this;
    }

    public final m justifyContentSpaceEvenly() {
        justifyContent(FlexJustifyContent.SPACE_EVENLY);
        return this;
    }

    public m alignItems(FlexAlign alignItems) {
        Intrinsics.checkNotNullParameter(alignItems, "alignItems");
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            flexNode.k0(alignItems);
        }
        return this;
    }

    @Override // 
    public m flexDirection(FlexDirection flexDirection) {
        Intrinsics.checkNotNullParameter(flexDirection, "flexDirection");
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            flexNode.n0(flexDirection);
        }
        return this;
    }

    public m flexWrap(FlexWrap flexWrap) {
        Intrinsics.checkNotNullParameter(flexWrap, "flexWrap");
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            flexNode.p0(flexWrap);
        }
        return this;
    }

    public m justifyContent(FlexJustifyContent justifyContent) {
        Intrinsics.checkNotNullParameter(justifyContent, "justifyContent");
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            flexNode.q0(justifyContent);
        }
        return this;
    }

    @Override // com.tencent.kuikly.core.base.attr.a
    public m padding(float top, float left, float bottom, float right) {
        FlexNode flexNode;
        FlexNode flexNode2;
        FlexNode flexNode3;
        FlexNode flexNode4;
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(top) || Float.isNaN(Float.NaN) ? Float.isNaN(top) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - top) < 1.0E-5f) && (flexNode4 = getFlexNode()) != null) {
            flexNode4.G0(StyleSpace.Type.TOP, top);
        }
        if (!(Float.isNaN(bottom) || Float.isNaN(Float.NaN) ? Float.isNaN(bottom) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - bottom) < 1.0E-5f) && (flexNode3 = getFlexNode()) != null) {
            flexNode3.G0(StyleSpace.Type.BOTTOM, bottom);
        }
        if (!(Float.isNaN(right) || Float.isNaN(Float.NaN) ? Float.isNaN(right) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - right) < 1.0E-5f) && (flexNode2 = getFlexNode()) != null) {
            flexNode2.G0(StyleSpace.Type.RIGHT, right);
        }
        if (Float.isNaN(left) || Float.isNaN(Float.NaN) ? !Float.isNaN(left) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - left) >= 1.0E-5f) {
            z16 = false;
        }
        if (!z16 && (flexNode = getFlexNode()) != null) {
            flexNode.G0(StyleSpace.Type.LEFT, left);
        }
        return this;
    }

    public static /* synthetic */ void highlightBackgroundColor$default(m mVar, h hVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                hVar = h.INSTANCE.a(0.15f);
            }
            mVar.highlightBackgroundColor(hVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: highlightBackgroundColor");
    }

    public final m paddingRight(float right) {
        a.C5863a.a(this, 0.0f, 0.0f, 0.0f, right, 7, null);
        return this;
    }

    public final m paddingBottom(float bottom) {
        a.C5863a.a(this, 0.0f, 0.0f, bottom, 0.0f, 11, null);
        return this;
    }

    public final m paddingLeft(float left) {
        a.C5863a.a(this, 0.0f, left, 0.0f, 0.0f, 13, null);
        return this;
    }

    public final m paddingTop(float top) {
        a.C5863a.a(this, top, 0.0f, 0.0f, 0.0f, 14, null);
        return this;
    }

    public final m padding(float all) {
        padding(all, all, all, all);
        return this;
    }
}
