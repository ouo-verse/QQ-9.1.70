package com.tencent.ntcompose.material.base;

import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.x;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.views.internal.GroupAttr;
import com.tencent.kuikly.core.views.internal.HitTestMode;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.f;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/base/e;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public static final e f339411a = new e();

    e() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.kuikly.core.base.Attr, com.tencent.kuikly.core.base.Props] */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        ?? viewAttr = view.b().getViewAttr();
        switch (propKey.hashCode()) {
            case -1904297048:
                if (propKey.equals("autoDarkEnable")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.autoDarkEnable(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case -1775507384:
                if (propKey.equals("keepAlive")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.keepAlive(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case -1720398780:
                if (propKey.equals("flattenDisable")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Int");
                    viewAttr.setProp("flattenDisable", (Integer) propArg0);
                    return;
                }
                return;
            case -1652093432:
                if (propKey.equals("hitTestMode")) {
                    GroupAttr groupAttr = viewAttr instanceof GroupAttr ? (GroupAttr) viewAttr : null;
                    if (groupAttr != null) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.views.internal.HitTestMode");
                        groupAttr.hitTestMode((HitTestMode) propArg0);
                        return;
                    }
                    return;
                }
                return;
            case -1543783876:
                if (propKey.equals("modifierRef")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.base.ModifierRefImp");
                    ((c) propArg0).b(view);
                    return;
                }
                return;
            case -1383304148:
                if (propKey.equals("border") && (propArg0 instanceof com.tencent.kuikly.core.base.e)) {
                    viewAttr.m136border((com.tencent.kuikly.core.base.e) propArg0);
                    return;
                }
                return;
            case -1332194002:
                if (propKey.equals("background")) {
                    if (propArg0 instanceof h) {
                        viewAttr.mo113backgroundColor((h) propArg0);
                        return;
                    }
                    if (propArg0 instanceof zo3.e) {
                        zo3.e eVar = (zo3.e) propArg0;
                        Direction b16 = eVar.b();
                        Object[] array = eVar.a().toArray(new j[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        j[] jVarArr = (j[]) array;
                        viewAttr.mo135backgroundLinearGradient(b16, (j[]) Arrays.copyOf(jVarArr, jVarArr.length));
                        return;
                    }
                    if (propArg0 instanceof Direction) {
                        Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.kuikly.core.base.ColorStop>");
                        Object[] array2 = ((List) propArg1).toArray(new j[0]);
                        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        j[] jVarArr2 = (j[]) array2;
                        viewAttr.mo135backgroundLinearGradient((Direction) propArg0, (j[]) Arrays.copyOf(jVarArr2, jVarArr2.length));
                        return;
                    }
                    return;
                }
                return;
            case -1254643132:
                if (propKey.equals("shouldRasterize")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.shouldRasterize(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case -731417480:
                if (propKey.equals(NodeProps.Z_INDEX)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.zIndexF(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -213139122:
                if (propKey.equals("accessibility")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                    viewAttr.accessibility((String) propArg0);
                    return;
                }
                return;
            case -101359900:
                if (propKey.equals("accessibilityRole")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.base.attr.AccessibilityRole");
                    viewAttr.accessibilityRole((AccessibilityRole) propArg0);
                    return;
                }
                return;
            case 3056464:
                if (propKey.equals("clip")) {
                    if (propArg0 instanceof uo3.a) {
                        uo3.a aVar = (uo3.a) propArg0;
                        viewAttr.borderRadius(aVar.getTopStart(), aVar.getTopEnd(), aVar.getBottomStart(), aVar.getBottomEnd());
                        return;
                    } else {
                        if (propArg0 instanceof com.tencent.kuikly.core.base.f) {
                            viewAttr.m137borderRadius((com.tencent.kuikly.core.base.f) propArg0);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 92909918:
                if (propKey.equals(com.tencent.luggage.wxa.c8.c.f123400v)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    viewAttr.m147opacity(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 299594153:
                if (propKey.equals("lazyLoadViewDisable")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.lazyLoadViewDisable(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case 399627231:
                if (propKey.equals("turboDisplayAutoUpdateEnable")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.turboDisplayAutoUpdateEnable(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case 466743410:
                if (propKey.equals(NodeProps.VISIBLE)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.m152visibility(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case 556426234:
                if (propKey.equals("cipToBounds")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.overflow(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case 743055051:
                if (propKey.equals("boxShadow") && (propArg0 instanceof g)) {
                    viewAttr.mo139boxShadow((g) propArg0);
                    return;
                }
                return;
            case 1052666732:
                if (propKey.equals("transform")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Rotate");
                    Intrinsics.checkNotNull(propArg1, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Scale");
                    Intrinsics.checkNotNull(propArg2, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Translate");
                    Intrinsics.checkNotNull(propArg3, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Anchor");
                    Intrinsics.checkNotNull(propArg4, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Skew");
                    viewAttr.transform((t) propArg0, (u) propArg1, (y) propArg2, (com.tencent.kuikly.core.base.a) propArg3, (x) propArg4);
                    return;
                }
                return;
            case 1126933377:
                if (propKey.equals("highlightBackgroundColor")) {
                    GroupAttr groupAttr2 = viewAttr instanceof GroupAttr ? (GroupAttr) viewAttr : null;
                    if (groupAttr2 != null) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color");
                        groupAttr2.highlightBackgroundColor((h) propArg0);
                        return;
                    }
                    return;
                }
                return;
            case 1221467417:
                if (propKey.equals("highlightCallback")) {
                    GroupAttr groupAttr3 = viewAttr instanceof GroupAttr ? (GroupAttr) viewAttr : null;
                    if (groupAttr3 != null) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
                        groupAttr3.highlightCallback((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                        return;
                    }
                    return;
                }
                return;
            case 1280722338:
                if (propKey.equals("touchEnable")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    viewAttr.m151touchEnable(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case 1824869424:
                if (propKey.equals("borderRect")) {
                    if (viewAttr instanceof GroupAttr) {
                        GroupAttr groupAttr4 = (GroupAttr) viewAttr;
                        com.tencent.kuikly.core.base.e eVar2 = propArg0 instanceof com.tencent.kuikly.core.base.e ? (com.tencent.kuikly.core.base.e) propArg0 : null;
                        if (eVar2 != null) {
                            groupAttr4.borderTop(eVar2);
                        }
                        com.tencent.kuikly.core.base.e eVar3 = propArg1 instanceof com.tencent.kuikly.core.base.e ? (com.tencent.kuikly.core.base.e) propArg1 : null;
                        if (eVar3 != null) {
                            groupAttr4.borderBottom(eVar3);
                        }
                        com.tencent.kuikly.core.base.e eVar4 = propArg2 instanceof com.tencent.kuikly.core.base.e ? (com.tencent.kuikly.core.base.e) propArg2 : null;
                        if (eVar4 != null) {
                            groupAttr4.borderLeft(eVar4);
                        }
                        com.tencent.kuikly.core.base.e eVar5 = propArg3 instanceof com.tencent.kuikly.core.base.e ? (com.tencent.kuikly.core.base.e) propArg3 : null;
                        if (eVar5 != null) {
                            groupAttr4.borderRight(eVar5);
                            return;
                        }
                        return;
                    }
                    PagerNotFoundExceptionKt.a("Border\u72ec\u7acb\u8fb9\u8bbe\u7f6e\u4ec5\u652f\u6301\u5bb9\u5668\u7c7b\u8282\u70b9\uff0c\u5982Box\uff0cColumn\uff0cRow\u7b49");
                    return;
                }
                return;
            default:
                return;
        }
    }
}
