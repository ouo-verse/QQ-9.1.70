package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0082@"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "orderDetail", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/a;", "continuation", "", "checkAddress"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel", f = "ECOrderSubmitViewModel.kt", i = {0, 0, 1, 1, 1}, l = {864, com.tencent.luggage.wxa.q2.d.CTRL_INDEX}, m = "checkAddress", n = {"this", "orderDetail", "orderDetail", "rsp", "addressValid"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$checkAddress$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$checkAddress$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCOrderSubmitViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p2(null, null, this);
    }
}
