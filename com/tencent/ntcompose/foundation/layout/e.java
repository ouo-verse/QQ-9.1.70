package com.tencent.ntcompose.foundation.layout;

import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.ModifiersKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0017JJ\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/e;", "Lcom/tencent/ntcompose/foundation/layout/d;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/i;", "", "weight", "a", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "alignment", "b", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements d, com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final e f339283a = new e();

    e() {
    }

    @Override // com.tencent.ntcompose.foundation.layout.d
    public com.tencent.ntcompose.core.i a(com.tencent.ntcompose.core.i iVar, float f16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return ModifiersKt.c(iVar, "weight", Float.valueOf(f16), null, null, null, null, this, 60, null);
    }

    @Override // com.tencent.ntcompose.foundation.layout.d
    public com.tencent.ntcompose.core.i b(com.tencent.ntcompose.core.i iVar, Alignment.Horizontal alignment) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return ModifiersKt.c(iVar, "align", alignment, null, null, null, null, this, 60, null);
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
        if (hashCode == -1916016876) {
            if (propKey.equals("verticalArrangement_horizontalAlignment")) {
                Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Pair<com.tencent.ntcompose.foundation.layout.base.Arrangement.Vertical, com.tencent.ntcompose.foundation.layout.base.Alignment.Horizontal>");
                Pair pair = (Pair) propArg0;
                Intrinsics.checkNotNull(viewAttr, "null cannot be cast to non-null type com.tencent.kuikly.core.base.ContainerAttr");
                com.tencent.ntcompose.foundation.layout.base.b.k((com.tencent.kuikly.core.base.m) viewAttr, (a.k) pair.getFirst(), (Alignment.Horizontal) pair.getSecond());
                return;
            }
            return;
        }
        if (hashCode != -791592328) {
            if (hashCode == 92903173 && propKey.equals("align")) {
                Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.layout.base.Alignment.Horizontal");
                com.tencent.ntcompose.foundation.layout.base.b.b(viewAttr, (Alignment.Horizontal) propArg0);
                return;
            }
            return;
        }
        if (propKey.equals("weight")) {
            Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
            viewAttr.m140flex(((Float) propArg0).floatValue());
        }
    }
}
