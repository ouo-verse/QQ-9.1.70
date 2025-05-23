package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop;

import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailBottomBarState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/c;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$initObservers$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$3$1", f = "ECShopOrderDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3$1$lambda$1 extends SuspendLambda implements Function2<ECOrderDetailBottomBarState, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3.AnonymousClass1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3$1$lambda$1(Continuation continuation, ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3.AnonymousClass1 anonymousClass1) {
        super(2, continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3$1$lambda$1 eCShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3$1$lambda$1 = new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3$1$lambda$1(continuation, this.this$0);
        eCShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3$1$lambda$1.L$0 = obj;
        return eCShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3$1$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ECOrderDetailBottomBarState eCOrderDetailBottomBarState, Continuation<? super Unit> continuation) {
        return ((ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3$1$lambda$1) create(eCOrderDetailBottomBarState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$3.this.this$0.si((ECOrderDetailBottomBarState) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
