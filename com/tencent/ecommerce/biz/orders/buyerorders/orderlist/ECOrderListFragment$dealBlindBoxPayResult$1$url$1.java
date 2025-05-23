package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECBlindBoxViewModel;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment$dealBlindBoxPayResult$1$url$1", f = "ECOrderListFragment.kt", i = {}, l = {309}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECOrderListFragment$dealBlindBoxPayResult$1$url$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ ECOrderListFragment$dealBlindBoxPayResult$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderListFragment$dealBlindBoxPayResult$1$url$1(ECOrderListFragment$dealBlindBoxPayResult$1 eCOrderListFragment$dealBlindBoxPayResult$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderListFragment$dealBlindBoxPayResult$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderListFragment$dealBlindBoxPayResult$1$url$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((ECOrderListFragment$dealBlindBoxPayResult$1$url$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ECBlindBoxViewModel di5;
        List<String> listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            di5 = this.this$0.this$0.di();
            ECOrderListFragment$dealBlindBoxPayResult$1 eCOrderListFragment$dealBlindBoxPayResult$1 = this.this$0;
            IECPayApi.PayResult payResult = eCOrderListFragment$dealBlindBoxPayResult$1.$payResult;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(eCOrderListFragment$dealBlindBoxPayResult$1.$orderId);
            String str = this.this$0.$spuId;
            ECOrderSpanScene eCOrderSpanScene = ECOrderSpanScene.OrderList;
            this.label = 1;
            obj = di5.L1(payResult, listOf, str, eCOrderSpanScene, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
