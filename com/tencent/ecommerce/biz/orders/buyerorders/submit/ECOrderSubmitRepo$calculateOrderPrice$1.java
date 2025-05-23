package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u00072\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0096@"}, d2 = {"", "orderGoodsId", "", "quantity", "pageExt", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;", "scene", "", "couponIds", "activityId", "groupId", "", "buyAll", "boxOrderIds", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$a;", "continuation", "", "calculateOrderPrice"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitRepo", f = "ECOrderSubmitRepo.kt", i = {}, l = {98}, m = "calculateOrderPrice", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECOrderSubmitRepo$calculateOrderPrice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECOrderSubmitRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitRepo$calculateOrderPrice$1(ECOrderSubmitRepo eCOrderSubmitRepo, Continuation continuation) {
        super(continuation);
        this.this$0 = eCOrderSubmitRepo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.calculateOrderPrice(null, 0, null, null, null, null, null, null, null, this);
    }
}
