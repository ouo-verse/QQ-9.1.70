package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample;

import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2;
import com.tencent.ecommerce.biz.orders.common.QShopOrderState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/sample/ECSampleOrderDetailFragment$initObservers$2$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample.ECSampleOrderDetailFragment$initObservers$2$1", f = "ECSampleOrderDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1 extends SuspendLambda implements Function2<ECOrderDetailState, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2.AnonymousClass1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1(Continuation continuation, ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2.AnonymousClass1 anonymousClass1) {
        super(2, continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1 eCSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1 = new ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1(continuation, this.this$0);
        eCSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1.L$0 = obj;
        return eCSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ECOrderDetailState eCOrderDetailState, Continuation<? super Unit> continuation) {
        return ((ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2$1$lambda$1) create(eCOrderDetailState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ECOrderDetailState eCOrderDetailState = (ECOrderDetailState) this.L$0;
            int i3 = a.f103314a[eCOrderDetailState.updateType.ordinal()];
            if (i3 == 1) {
                ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2.this.this$0.bi(eCOrderDetailState);
                if (!ECOrderDetailState.INSTANCE.a(eCOrderDetailState)) {
                    b.f103318d.b(eCOrderDetailState);
                }
            } else if (i3 == 2) {
                ECSampleOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$2.this.this$0.ai(QShopOrderState.INSTANCE.a(eCOrderDetailState.orderStateVal), eCOrderDetailState.getHeaderState());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
