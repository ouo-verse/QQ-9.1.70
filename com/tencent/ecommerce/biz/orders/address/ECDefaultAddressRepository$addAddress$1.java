package com.tencent.ecommerce.biz.orders.address;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002H\u0096@"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "Lkotlin/coroutines/Continuation;", "continuation", "", "addAddress"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.ECDefaultAddressRepository", f = "ECDefaultAddressRepository.kt", i = {0}, l = {53}, m = "addAddress", n = {"address"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECDefaultAddressRepository$addAddress$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECDefaultAddressRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECDefaultAddressRepository$addAddress$1(ECDefaultAddressRepository eCDefaultAddressRepository, Continuation continuation) {
        super(continuation);
        this.this$0 = eCDefaultAddressRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addAddress(null, this);
    }
}
