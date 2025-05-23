package com.tencent.ecommerce.biz.detail.repo.saas;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005H\u0082@"}, d2 = {"", "service", "method", "Lorg/json/JSONObject;", "requestParams", "Lkotlin/coroutines/Continuation;", "", "Lcom/tencent/ecommerce/base/ui/b;", "continuation", "", "requestDataWithModel"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo", f = "ECDetailCustomRepo.kt", i = {0, 0}, l = {327}, m = "requestDataWithModel", n = {"this", "requestParams"}, s = {"L$0", "L$1"})
/* loaded from: classes31.dex */
public final class ECDetailCustomRepo$requestDataWithModel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECDetailCustomRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECDetailCustomRepo$requestDataWithModel$1(ECDetailCustomRepo eCDetailCustomRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCDetailCustomRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.t(null, null, null, this);
    }
}
