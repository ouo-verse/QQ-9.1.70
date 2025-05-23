package com.tencent.rdelivery.reshub.processor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J'\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0010\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/h;", "Lcom/tencent/rdelivery/reshub/processor/a;", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lcom/tencent/rdelivery/reshub/processor/l;", "chain", "Llz3/b;", "k", "", "getPriority", "", "i", "Lcom/tencent/rdelivery/reshub/report/a;", "errorInfo", "l", "(Lcom/tencent/rdelivery/reshub/report/a;Lcom/tencent/rdelivery/reshub/core/k;Lcom/tencent/rdelivery/reshub/processor/l;)V", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class h extends com.tencent.rdelivery.reshub.processor.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/rdelivery/reshub/processor/h$a", "Llz3/b;", "Ljz3/e;", "resConfig", "", "b", "Lcom/tencent/rdelivery/reshub/report/a;", "error", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements lz3.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.rdelivery.reshub.core.k f364554b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f364555c;

        a(com.tencent.rdelivery.reshub.core.k kVar, l lVar) {
            this.f364554b = kVar;
            this.f364555c = lVar;
        }

        @Override // lz3.b
        public void a(@NotNull com.tencent.rdelivery.reshub.report.a error) {
            Intrinsics.checkParameterIsNotNull(error, "error");
            h.this.l(error, this.f364554b, this.f364555c);
        }

        @Override // lz3.b
        public void b(@NotNull jz3.e resConfig) {
            Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
            this.f364554b.G(resConfig);
            this.f364555c.c(this.f364554b);
        }
    }

    private final lz3.b k(com.tencent.rdelivery.reshub.core.k req, l chain) {
        return new a(req, chain);
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 100;
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public void i(@NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        com.tencent.rdelivery.reshub.processor.a.h(this, 0, req, null, 0L, 0L, 24, null);
        lz3.b k3 = k(req, chain);
        jz3.d.e("FetchConfig", "Start Fetching Res(" + req.x() + ") Config...");
        lz3.j.f415860a.b(req, k3);
    }

    public void l(@NotNull com.tencent.rdelivery.reshub.report.a errorInfo, @NotNull com.tencent.rdelivery.reshub.core.k req, @NotNull l chain) {
        Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
        Intrinsics.checkParameterIsNotNull(req, "req");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        com.tencent.rdelivery.reshub.processor.a.h(this, 1, req, errorInfo, 0L, 0L, 24, null);
        e(false, 201, req, chain, errorInfo);
    }
}
