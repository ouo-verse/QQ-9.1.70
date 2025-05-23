package com.tencent.ecommerce.repo.commission.subsidy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@"}, d2 = {"Lkotlin/coroutines/Continuation;", "Ltj0/b;", "continuation", "", "requestIncomeInfo"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.commission.subsidy.ECSubsidyRepo", f = "ECSubsidyRepo.kt", i = {}, l = {45}, m = "requestIncomeInfo", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSubsidyRepo$requestIncomeInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECSubsidyRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSubsidyRepo$requestIncomeInfo$1(ECSubsidyRepo eCSubsidyRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCSubsidyRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
