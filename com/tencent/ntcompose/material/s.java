package com.tencent.ntcompose.material;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.ntcompose.core.ComposeRenderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/s;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class s implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final s f339445a = new s();

    s() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        DeclarativeBaseView<?, ?> b16 = view.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.HoverView");
        com.tencent.kuikly.core.views.aa aaVar = (com.tencent.kuikly.core.views.aa) ((com.tencent.kuikly.core.views.ab) b16).getViewAttr();
        int hashCode = propKey.hashCode();
        if (hashCode == -1797588384) {
            if (propKey.equals("bringIndex")) {
                Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Int");
                aaVar.h(((Integer) propArg0).intValue());
                return;
            }
            return;
        }
        if (hashCode != -940758241) {
            if (hashCode == 2028386027 && propKey.equals("hoverMarginTop")) {
                Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                aaVar.j(((Float) propArg0).floatValue());
                return;
            }
            return;
        }
        if (propKey.equals("hoverMaxMarginTop")) {
            Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
            aaVar.k(((Float) propArg0).floatValue());
        }
    }
}
