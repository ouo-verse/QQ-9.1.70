package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082@"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "handlePayResultForBlindBox"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitFragment$dealWithSubmitSucceedResult$1", f = "ECOrderSubmitFragment.kt", i = {0, 0, 0, 0}, l = {997}, m = "handlePayResultForBlindBox", n = {"this", "payResult", "loadingDialog", "showRefundDialog"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECOrderSubmitFragment$dealWithSubmitSucceedResult$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitFragment$dealWithSubmitSucceedResult$1$handlePayResultForBlindBox$1(ECOrderSubmitFragment$dealWithSubmitSucceedResult$1 eCOrderSubmitFragment$dealWithSubmitSucceedResult$1, Continuation continuation) {
        super(continuation);
        this.this$0 = eCOrderSubmitFragment$dealWithSubmitSucceedResult$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
