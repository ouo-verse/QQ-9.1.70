package com.tencent.ecommerce.biz.register.refactoring.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0086@"}, d2 = {"", "psKey", "userName", "idCardNum", "phoneNum", "captcha", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "continuation", "", "realNameVerify"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo", f = "ECommerceRegisterRepo.kt", i = {0}, l = {287}, m = "realNameVerify", n = {"reqParams"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECommerceRegisterRepo$realNameVerify$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECommerceRegisterRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECommerceRegisterRepo$realNameVerify$1(ECommerceRegisterRepo eCommerceRegisterRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCommerceRegisterRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, null, null, this);
    }
}
