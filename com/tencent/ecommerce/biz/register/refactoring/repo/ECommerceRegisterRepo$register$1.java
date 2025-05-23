package com.tencent.ecommerce.biz.register.refactoring.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0086@"}, d2 = {"", "userName", "idCardNum", "phoneNum", "sessionId", "", "isFollow", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "continuation", "", "register"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo", f = "ECommerceRegisterRepo.kt", i = {0}, l = {246}, m = "register", n = {"reqParams"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECommerceRegisterRepo$register$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECommerceRegisterRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECommerceRegisterRepo$register$1(ECommerceRegisterRepo eCommerceRegisterRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCommerceRegisterRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, null, false, this);
    }
}
