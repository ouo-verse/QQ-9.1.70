package com.tencent.ntcompose.material;

import com.tencent.kuikly.core.views.ck;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.material.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/v;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class v implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final v f339448a = new v();

    v() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Object viewAttr = view.b().getViewAttr();
        Intrinsics.checkNotNull(viewAttr, "null cannot be cast to non-null type com.tencent.kuikly.core.views.WaterfallListAttr");
        ck ckVar = (ck) viewAttr;
        switch (propKey.hashCode()) {
            case -1231798328:
                if (propKey.equals("listWidth")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    ckVar.w(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -1158683606:
                if (propKey.equals("rowsSpacing")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    ckVar.u(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -218919981:
                if (propKey.equals("gridLayoutMode")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.GridLayoutMode");
                    ckVar.r(((GridLayoutMode) propArg0) == GridLayoutMode.PLAIN);
                    return;
                }
                return;
            case 35962725:
                if (propKey.equals("listHeight")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    ckVar.v(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 949721053:
                if (propKey.equals("columns")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.GridCells");
                    r rVar = (r) propArg0;
                    if (!(ckVar instanceof ck)) {
                        ckVar = null;
                    }
                    if (!(rVar instanceof r.a) || ckVar == null) {
                        return;
                    }
                    ckVar.h(((r.a) rVar).getCount());
                    return;
                }
                return;
            case 1563017638:
                if (propKey.equals("columnsSpacing")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    ckVar.t(((Float) propArg0).floatValue());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
