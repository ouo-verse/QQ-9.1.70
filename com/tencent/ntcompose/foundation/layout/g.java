package com.tencent.ntcompose.foundation.layout;

import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.core.ComposeRenderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/g;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final g f339285a = new g();

    g() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.tencent.kuikly.core.base.Attr] */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        ?? viewAttr = view.b().getViewAttr();
        switch (propKey.hashCode()) {
            case -1383228885:
                if (propKey.equals("bottom")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m138bottom(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -1375815020:
                if (propKey.equals(NodeProps.MIN_WIDTH)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m146minWidth(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -1063257157:
                if (propKey.equals(NodeProps.ALIGN_ITEMS) && (viewAttr instanceof com.tencent.kuikly.core.base.m)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.layout.FlexAlign");
                    ((com.tencent.kuikly.core.base.m) viewAttr).alignItems((FlexAlign) propArg0);
                    return;
                }
                return;
            case -975171706:
                if (propKey.equals(NodeProps.FLEX_DIRECTION) && (viewAttr instanceof com.tencent.kuikly.core.base.m)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.layout.FlexDirection");
                    ((com.tencent.kuikly.core.base.m) viewAttr).flexDirection((FlexDirection) propArg0);
                    return;
                }
                return;
            case -906066005:
                if (propKey.equals(NodeProps.MAX_HEIGHT)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m143maxHeight(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -133587431:
                if (propKey.equals(NodeProps.MIN_HEIGHT)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m145minHeight(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 115029:
                if (propKey.equals("top")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m150top(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 3145721:
                if (propKey.equals(NodeProps.FLEX)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m140flex(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 3317767:
                if (propKey.equals("left")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m142left(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 34070531:
                if (propKey.equals("positionType")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.layout.FlexPositionType");
                    viewAttr.m148positionType((FlexPositionType) propArg0);
                    return;
                }
                return;
            case 108511772:
                if (propKey.equals("right")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m149right(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 400381634:
                if (propKey.equals(NodeProps.MAX_WIDTH)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m144maxWidth(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1744216035:
                if (propKey.equals(NodeProps.FLEX_WRAP) && (viewAttr instanceof com.tencent.kuikly.core.base.m)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.layout.FlexWrap");
                    ((com.tencent.kuikly.core.base.m) viewAttr).flexWrap((FlexWrap) propArg0);
                    return;
                }
                return;
            case 1767100401:
                if (propKey.equals(NodeProps.ALIGN_SELF)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.layout.FlexAlign");
                    viewAttr.m133alignSelf((FlexAlign) propArg0);
                    return;
                }
                return;
            case 1809884096:
                if (propKey.equals("absolutePosition")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue = ((Float) propArg0).floatValue();
                    Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue2 = ((Float) propArg1).floatValue();
                    Intrinsics.checkNotNull(propArg2, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue3 = ((Float) propArg2).floatValue();
                    Intrinsics.checkNotNull(propArg3, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.absolutePosition(floatValue, floatValue2, floatValue3, ((Float) propArg3).floatValue());
                    return;
                }
                return;
            case 1860657097:
                if (propKey.equals(NodeProps.JUSTIFY_CONTENT) && (viewAttr instanceof com.tencent.kuikly.core.base.m)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.layout.FlexJustifyContent");
                    ((com.tencent.kuikly.core.base.m) viewAttr).justifyContent((FlexJustifyContent) propArg0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
