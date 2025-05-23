package com.tencent.ecommerce.biz.detail.repo.saas;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006H\u0082@"}, d2 = {"", "service", "method", "Lorg/json/JSONObject;", "requestParams", WadlProxyConsts.EXT_JSON, "Lkotlin/coroutines/Continuation;", "", "Lcom/tencent/ecommerce/base/ui/b;", "continuation", "", "requestDataWithModel"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.saas.ECDetailHostRelatedRepo", f = "ECDetailHostRelatedRepo.kt", i = {0, 0, 0, 0, 0}, l = {89}, m = "requestDataWithModel", n = {"this", "service", "method", "requestParams", WadlProxyConsts.EXT_JSON}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes31.dex */
public final class ECDetailHostRelatedRepo$requestDataWithModel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECDetailHostRelatedRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECDetailHostRelatedRepo$requestDataWithModel$1(ECDetailHostRelatedRepo eCDetailHostRelatedRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCDetailHostRelatedRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, this);
    }
}
