package com.tencent.ntcompose.material;

import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.material.h;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/t;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class t implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final t f339446a = new t();

    t() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0032. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        DeclarativeBaseView<?, ?> b16 = view.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ImageView");
        com.tencent.kuikly.core.views.af afVar = (com.tencent.kuikly.core.views.af) ((ImageView) b16).getViewAttr();
        switch (propKey.hashCode()) {
            case -1744640143:
                if (propKey.equals("placeholderSrc")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                    afVar.n((String) propArg0);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    ImageEvent imageEvent = (ImageEvent) ((ImageView) view.b()).getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.LoadFailureParams, kotlin.Unit>");
                    imageEvent.h((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1470711613:
                if (propKey.equals("imageAlpha")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    afVar.m147opacity(((Float) propArg0).floatValue());
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1428201511:
                if (propKey.equals("blurRadius")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    afVar.h(((Float) propArg0).floatValue());
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1285866623:
                if (propKey.equals("maskLinearGradient")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.MaskLinearGradient");
                    y yVar = (y) propArg0;
                    Direction direction = yVar.getDirection();
                    Object[] array = yVar.a().toArray(new com.tencent.kuikly.core.base.j[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    com.tencent.kuikly.core.base.j[] jVarArr = (com.tencent.kuikly.core.base.j[]) array;
                    afVar.l(direction, (com.tencent.kuikly.core.base.j[]) Arrays.copyOf(jVarArr, jVarArr.length));
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1222667916:
                if (propKey.equals("drawableRawData")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.ByteArray");
                    afVar.s((byte[]) propArg0);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -801413749:
                if (propKey.equals("painter")) {
                    bool = propArg1 instanceof Boolean ? (Boolean) propArg1 : null;
                    boolean booleanValue = bool != null ? bool.booleanValue() : false;
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                    afVar.e((String) propArg0, booleanValue);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -545672654:
                if (propKey.equals("loadResolution")) {
                    ImageEvent imageEvent2 = (ImageEvent) ((ImageView) view.b()).getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.LoadResolutionParams, kotlin.Unit>");
                    imageEvent2.i((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 114148:
                if (propKey.equals("src")) {
                    String str = propArg0 instanceof String ? (String) propArg0 : null;
                    com.tencent.kuikly.core.base.attr.e eVar = propArg1 instanceof com.tencent.kuikly.core.base.attr.e ? (com.tencent.kuikly.core.base.attr.e) propArg1 : null;
                    bool = propArg2 instanceof Boolean ? (Boolean) propArg2 : null;
                    if (eVar != null) {
                        afVar.b(eVar, bool != null ? bool.booleanValue() : false);
                        return;
                    } else {
                        if (str != null) {
                            afVar.e(str, bool != null ? bool.booleanValue() : false);
                            return;
                        }
                        return;
                    }
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 599691451:
                if (propKey.equals(CustomAnimation.KeyPath.COLOR_FILTER)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.ui.graphics.ColorMatrix");
                    afVar.i(((zo3.c) propArg0).getValues());
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 820234321:
                if (propKey.equals("contentScale")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.ContentScale");
                    int value = ((h) propArg0).getValue();
                    h.Companion companion = h.INSTANCE;
                    if (value == companion.c()) {
                        afVar.o();
                        return;
                    }
                    if (value == companion.a()) {
                        afVar.p();
                        return;
                    } else if (value == companion.b()) {
                        afVar.q();
                        return;
                    } else {
                        afVar.p();
                        return;
                    }
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 1041505806:
                if (propKey.equals("customCacheKey")) {
                    com.tencent.kuikly.core.views.af afVar2 = (com.tencent.kuikly.core.views.af) ((ImageView) view.b()).getViewAttr();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                    ImageKt.b(afVar2, (String) propArg0);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 1327599912:
                if (propKey.equals("tintColor")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color");
                    afVar.t((com.tencent.kuikly.core.base.h) propArg0);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 1649792478:
                if (propKey.equals("httpHeaders")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                    afVar.k((Map) propArg0);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    ImageEvent imageEvent3 = (ImageEvent) ((ImageView) view.b()).getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.LoadSuccessParams, kotlin.Unit>");
                    imageEvent3.j((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            default:
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
        }
    }
}
