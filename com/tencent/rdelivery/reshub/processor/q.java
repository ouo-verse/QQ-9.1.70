package com.tencent.rdelivery.reshub.processor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/q;", "Lcom/tencent/rdelivery/reshub/processor/a;", "", "getPriority", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "i", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class q extends a {
    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 1000;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig == null) {
            j(chain, req, 206);
            return;
        }
        req.P(resConfig);
        com.tencent.rdelivery.reshub.util.c cVar = new com.tencent.rdelivery.reshub.util.c(req);
        cVar.b();
        a.f(this, true, 102, req, chain, null, 16, null);
        cVar.c();
    }
}
