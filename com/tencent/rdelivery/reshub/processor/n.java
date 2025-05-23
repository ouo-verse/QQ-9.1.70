package com.tencent.rdelivery.reshub.processor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/n;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Ljz3/e;", "resConfig", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "", "k", "l", "", "getPriority", "i", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class n extends a {
    private final void k(com.tencent.rdelivery.reshub.core.k req, jz3.e resConfig, l chain) {
        com.tencent.rdelivery.reshub.core.e.f364425b.b(req, resConfig);
        chain.b();
    }

    private final void l(com.tencent.rdelivery.reshub.core.k req) {
        com.tencent.rdelivery.reshub.report.a aVar = new com.tencent.rdelivery.reshub.report.a();
        aVar.e(1004);
        a.h(this, 1, req, aVar, 0L, 0L, 24, null);
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 200;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        jz3.e resConfig = req.getResConfig();
        if (resConfig == null) {
            l(req);
            k(req, null, chain);
        } else {
            a.h(this, 1, req, null, 0L, 0L, 24, null);
            resConfig.G = "";
            k(req, resConfig, chain);
        }
    }
}
