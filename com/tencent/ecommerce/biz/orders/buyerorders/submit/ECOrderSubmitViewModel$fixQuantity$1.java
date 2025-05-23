package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003H\u0082@"}, d2 = {"", "quantity", "maxQuantity", "Lkotlin/coroutines/Continuation;", "continuation", "", "fixQuantity"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel", f = "ECOrderSubmitViewModel.kt", i = {0}, l = {com.tencent.luggage.wxa.gf.i.CTRL_INDEX, 495}, m = "fixQuantity", n = {"maxQuantity"}, s = {"I$0"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$fixQuantity$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$fixQuantity$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCOrderSubmitViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v2(0, 0, this);
    }
}
