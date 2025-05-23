package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0082@"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/j$b;", "productType", "", "isUserAction", "hasDoubleCheckVirtualProductAccount", "Lkotlin/coroutines/Continuation;", "continuation", "", "doVirtualAccountVerification"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel", f = "ECOrderSubmitViewModel.kt", i = {1}, l = {com.tencent.luggage.wxa.gf.e.CTRL_INDEX, com.tencent.luggage.wxa.uf.n.CTRL_INDEX, 796, 803}, m = "doVirtualAccountVerification", n = {"this"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$doVirtualAccountVerification$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$doVirtualAccountVerification$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCOrderSubmitViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.s2(null, false, false, this);
    }
}
