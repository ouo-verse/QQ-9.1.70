package com.tencent.ecommerce.repo.blindbox;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0096@"}, d2 = {"", "", "orderIds", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/repo/blindbox/a;", "continuation", "", "checkYiFanLottery"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.blindbox.ECBlindBoxRepo", f = "ECBlindBoxRepo.kt", i = {}, l = {109}, m = "checkYiFanLottery", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECBlindBoxRepo$checkYiFanLottery$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECBlindBoxRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECBlindBoxRepo$checkYiFanLottery$1(ECBlindBoxRepo eCBlindBoxRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCBlindBoxRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
