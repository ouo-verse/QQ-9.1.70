package com.tencent.ecommerce.biz.orders.address;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u0096@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_address_svr/ECQshopAddressSvr$HotItem;", "continuation", "", "getHotCity"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECDefaultAddressRepository", f = "ECDefaultAddressRepository.kt", i = {}, l = {161}, m = "getHotCity", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECDefaultAddressRepository$getHotCity$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECDefaultAddressRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECDefaultAddressRepository$getHotCity$1(ECDefaultAddressRepository eCDefaultAddressRepository, Continuation continuation) {
        super(continuation);
        this.this$0 = eCDefaultAddressRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getHotCity(this);
    }
}
