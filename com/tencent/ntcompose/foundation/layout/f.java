package com.tencent.ntcompose.foundation.layout;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.ntcompose.core.ComposeRenderView;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J8\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002JJ\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/f;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/kuikly/core/base/Attr;", "attr", "", "propArg0", "propArg1", "", "c", "a", "propArg2", "propArg3", "b", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "propArg4", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f339284a = new f();

    f() {
    }

    private final void a(Attr attr, Object propArg0, Object propArg1) {
        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) propArg0).floatValue();
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(floatValue) || Float.isNaN(Float.NaN) ? Float.isNaN(floatValue) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue) < 1.0E-5f)) {
            attr.m145minHeight(floatValue);
        }
        Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Float");
        float floatValue2 = ((Float) propArg1).floatValue();
        if (Float.isNaN(floatValue2) || Float.isNaN(Float.NaN) ? !Float.isNaN(floatValue2) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue2) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        attr.m143maxHeight(floatValue2);
    }

    private final void b(Attr attr, Object propArg0, Object propArg1, Object propArg2, Object propArg3) {
        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) propArg0).floatValue();
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(floatValue) || Float.isNaN(Float.NaN) ? Float.isNaN(floatValue) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue) < 1.0E-5f)) {
            attr.m146minWidth(floatValue);
        }
        Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Float");
        float floatValue2 = ((Float) propArg1).floatValue();
        if (!(Float.isNaN(floatValue2) || Float.isNaN(Float.NaN) ? Float.isNaN(floatValue2) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue2) < 1.0E-5f)) {
            attr.m145minHeight(floatValue2);
        }
        Intrinsics.checkNotNull(propArg2, "null cannot be cast to non-null type kotlin.Float");
        float floatValue3 = ((Float) propArg2).floatValue();
        if (!(Float.isNaN(floatValue3) || Float.isNaN(Float.NaN) ? Float.isNaN(floatValue3) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue3) < 1.0E-5f)) {
            attr.m144maxWidth(floatValue3);
        }
        Intrinsics.checkNotNull(propArg3, "null cannot be cast to non-null type kotlin.Float");
        float floatValue4 = ((Float) propArg3).floatValue();
        if (Float.isNaN(floatValue4) || Float.isNaN(Float.NaN) ? !Float.isNaN(floatValue4) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue4) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        attr.m143maxHeight(floatValue4);
    }

    private final void c(Attr attr, Object propArg0, Object propArg1) {
        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) propArg0).floatValue();
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(floatValue) || Float.isNaN(Float.NaN) ? Float.isNaN(floatValue) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue) < 1.0E-5f)) {
            attr.m146minWidth(floatValue);
        }
        Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Float");
        float floatValue2 = ((Float) propArg1).floatValue();
        if (Float.isNaN(floatValue2) || Float.isNaN(Float.NaN) ? !Float.isNaN(floatValue2) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - floatValue2) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        attr.m144maxWidth(floatValue2);
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        FlexNode flexNode;
        FlexNode flexNode2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Attr viewAttr = view.b().getViewAttr();
        switch (propKey.hashCode()) {
            case -2092291620:
                if (propKey.equals("wrap_content_size")) {
                    com.tencent.ntcompose.foundation.layout.base.b.n(viewAttr);
                    return;
                }
                return;
            case -1221029593:
                if (propKey.equals("height")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.mo141height(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -1081309778:
                if (propKey.equals("margin")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue = ((Float) propArg0).floatValue();
                    Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue2 = ((Float) propArg1).floatValue();
                    Intrinsics.checkNotNull(propArg2, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue3 = ((Float) propArg2).floatValue();
                    Intrinsics.checkNotNull(propArg3, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.margin(floatValue, floatValue2, floatValue3, ((Float) propArg3).floatValue());
                    return;
                }
                return;
            case -1019779949:
                if (propKey.equals("offset")) {
                    FlexNode flexNode3 = viewAttr.getFlexNode();
                    Float styleOffsetX = flexNode3 != null ? flexNode3.getStyleOffsetX() : null;
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    Float f16 = (Float) propArg0;
                    if (!Intrinsics.areEqual(styleOffsetX, f16.floatValue()) && (flexNode2 = viewAttr.getFlexNode()) != null) {
                        flexNode2.Q0(f16);
                    }
                    FlexNode flexNode4 = viewAttr.getFlexNode();
                    Float styleOffsetY = flexNode4 != null ? flexNode4.getStyleOffsetY() : null;
                    Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Float");
                    Float f17 = (Float) propArg1;
                    if (Intrinsics.areEqual(styleOffsetY, f17.floatValue()) || (flexNode = viewAttr.getFlexNode()) == null) {
                        return;
                    }
                    flexNode.R0(f17);
                    return;
                }
                return;
            case -966668222:
                if (propKey.equals("wrap_content_height")) {
                    com.tencent.ntcompose.foundation.layout.base.b.m(viewAttr);
                    return;
                }
                return;
            case -901911290:
                if (propKey.equals("sizeIn")) {
                    b(viewAttr, propArg0, propArg1, propArg2, propArg3);
                    return;
                }
                return;
            case -883364692:
                if (propKey.equals("heightIn")) {
                    a(viewAttr, propArg0, propArg1);
                    return;
                }
                return;
            case -874270562:
                if (propKey.equals("fill_max_height")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    com.tencent.ntcompose.foundation.layout.base.b.d(viewAttr, ((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -806339567:
                if (propKey.equals("padding")) {
                    if (view.b() instanceof ViewContainer) {
                        com.tencent.kuikly.core.base.m mVar = (com.tencent.kuikly.core.base.m) ((ViewContainer) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Float");
                        float floatValue4 = ((Float) propArg1).floatValue();
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                        float floatValue5 = ((Float) propArg0).floatValue();
                        Intrinsics.checkNotNull(propArg3, "null cannot be cast to non-null type kotlin.Float");
                        float floatValue6 = ((Float) propArg3).floatValue();
                        Intrinsics.checkNotNull(propArg2, "null cannot be cast to non-null type kotlin.Float");
                        mVar.padding(floatValue4, floatValue5, floatValue6, ((Float) propArg2).floatValue());
                        return;
                    }
                    Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue7 = ((Float) propArg1).floatValue();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue8 = ((Float) propArg0).floatValue();
                    Intrinsics.checkNotNull(propArg3, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue9 = ((Float) propArg3).floatValue();
                    Intrinsics.checkNotNull(propArg2, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.margin(floatValue7, floatValue8, floatValue9, ((Float) propArg2).floatValue());
                    return;
                }
                return;
            case -432857269:
                if (propKey.equals("wrap_content_width")) {
                    com.tencent.ntcompose.foundation.layout.base.b.o(viewAttr);
                    return;
                }
                return;
            case -115006108:
                if (propKey.equals("aspect_ratio")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    float floatValue10 = ((Float) propArg0).floatValue();
                    Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.aspectFitLayout(floatValue10, ((Boolean) propArg1).booleanValue());
                    return;
                }
                return;
            case 3530753:
                if (propKey.equals("size") && (propArg0 instanceof Float) && (propArg1 instanceof Float)) {
                    viewAttr.size(((Number) propArg0).floatValue(), ((Number) propArg1).floatValue());
                    return;
                }
                return;
            case 113126854:
                if (propKey.equals("width")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.mo153width(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 759198008:
                if (propKey.equals("fill_max_size")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    com.tencent.ntcompose.foundation.layout.base.b.e(viewAttr, ((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1340726667:
                if (propKey.equals("widthIn")) {
                    c(viewAttr, propArg0, propArg1);
                    return;
                }
                return;
            case 2063975279:
                if (propKey.equals("fill_max_width")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    com.tencent.ntcompose.foundation.layout.base.b.f(viewAttr, ((Float) propArg0).floatValue());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
