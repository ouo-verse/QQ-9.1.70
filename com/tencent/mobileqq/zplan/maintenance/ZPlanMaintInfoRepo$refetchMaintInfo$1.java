package com.tencent.mobileqq.zplan.maintenance;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.maintenance.ZPlanMaintInfoRepo", f = "ZPlanMaintInfoRepo.kt", i = {0, 0}, l = {68}, m = "refetchMaintInfo", n = {"this", "type"}, s = {"L$0", "L$1"})
/* loaded from: classes34.dex */
public final class ZPlanMaintInfoRepo$refetchMaintInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanMaintInfoRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMaintInfoRepo$refetchMaintInfo$1(ZPlanMaintInfoRepo zPlanMaintInfoRepo, Continuation<? super ZPlanMaintInfoRepo$refetchMaintInfo$1> continuation) {
        super(continuation);
        this.this$0 = zPlanMaintInfoRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
