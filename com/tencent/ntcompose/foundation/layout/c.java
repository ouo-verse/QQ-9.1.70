package com.tencent.ntcompose.foundation.layout;

import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.ModifiersKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\f\u0010\u0007\u001a\u00020\u0003*\u00020\u0003H\u0017JJ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/c;", "Lcom/tencent/ntcompose/foundation/layout/b;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/i;", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "alignment", "a", "b", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c implements b, com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final c f339282a = new c();

    c() {
    }

    @Override // com.tencent.ntcompose.foundation.layout.b
    public com.tencent.ntcompose.core.i a(com.tencent.ntcompose.core.i iVar, Alignment alignment) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return ModifiersKt.c(iVar, "align", alignment, null, null, null, null, this, 60, null);
    }

    @Override // com.tencent.ntcompose.foundation.layout.b
    public com.tencent.ntcompose.core.i b(com.tencent.ntcompose.core.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "matchParentMaxSize", null, null, null, null, null, this, 60, null);
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.kuikly.core.base.Attr, java.lang.Object] */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        ?? viewAttr = view.b().getViewAttr();
        int hashCode = propKey.hashCode();
        if (hashCode == -408189590) {
            if (propKey.equals("contentAlignment")) {
                Intrinsics.checkNotNull(viewAttr, "null cannot be cast to non-null type com.tencent.kuikly.core.base.ContainerAttr");
                Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.layout.base.Alignment");
                com.tencent.ntcompose.foundation.layout.base.b.j((com.tencent.kuikly.core.base.m) viewAttr, (Alignment) propArg0);
                return;
            }
            return;
        }
        if (hashCode != 92903173) {
            if (hashCode == 2039620022 && propKey.equals("matchParentMaxSize")) {
                com.tencent.ntcompose.foundation.layout.base.b.i(viewAttr, false, 1, null);
                return;
            }
            return;
        }
        if (propKey.equals("align")) {
            Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.layout.base.Alignment");
            com.tencent.ntcompose.foundation.layout.base.b.a(viewAttr, (Alignment) propArg0);
        }
    }
}
