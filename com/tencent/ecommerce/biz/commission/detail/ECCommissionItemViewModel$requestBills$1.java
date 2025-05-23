package com.tencent.ecommerce.biz.commission.detail;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00030\u00022\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00020\u0005H\u0082@"}, d2 = {"", "cookie", "", "Lkotlin/Pair;", "list", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/biz/commission/detail/a;", "continuation", "", "requestBills"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.detail.ECCommissionItemViewModel", f = "ECCommissionItemViewModel.kt", i = {0, 1}, l = {68, 69}, m = "requestBills", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes31.dex */
public final class ECCommissionItemViewModel$requestBills$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECCommissionItemViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECCommissionItemViewModel$requestBills$1(ECCommissionItemViewModel eCCommissionItemViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCCommissionItemViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a2(null, null, this);
    }
}
