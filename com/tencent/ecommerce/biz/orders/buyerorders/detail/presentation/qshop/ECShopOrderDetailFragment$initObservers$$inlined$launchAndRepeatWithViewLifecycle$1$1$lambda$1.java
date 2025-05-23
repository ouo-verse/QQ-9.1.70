package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop;

import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECShopOrderDetailFragment$initObservers$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECShopOrderDetailFragment$initObservers$1$1", f = "ECShopOrderDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 extends SuspendLambda implements Function2<ECOrderSubmitViewModel.g, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.AnonymousClass1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1(Continuation continuation, ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.AnonymousClass1 anonymousClass1) {
        super(2, continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 eCShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 = new ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1(continuation, this.this$0);
        eCShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1.L$0 = obj;
        return eCShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ECOrderSubmitViewModel.g gVar, Continuation<? super Unit> continuation) {
        return ((ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1) create(gVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        k kVar;
        k kVar2;
        k kVar3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ECOrderSubmitViewModel.g gVar = (ECOrderSubmitViewModel.g) this.L$0;
            if (Intrinsics.areEqual(gVar, ECOrderSubmitViewModel.g.c.f103527a)) {
                IStateCenterView.a.c(ECShopOrderDetailFragment.Rh(ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0), null, 1, null);
            } else if (Intrinsics.areEqual(gVar, ECOrderSubmitViewModel.g.d.f103528a)) {
                ECShopOrderDetailFragment.Rh(ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0).setSucceededState();
                kVar3 = ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.showCostTimeReporter;
                k.c(kVar3, 2, null, 2, null);
            } else if (gVar instanceof ECOrderSubmitViewModel.g.Empty) {
                IStateCenterView.a.a(ECShopOrderDetailFragment.Rh(ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0), ((ECOrderSubmitViewModel.g.Empty) gVar).msg, null, 0, 6, null);
                kVar2 = ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.showCostTimeReporter;
                k.c(kVar2, 2, null, 2, null);
            } else if (gVar instanceof ECOrderSubmitViewModel.g.Error) {
                ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.ei((ECOrderSubmitViewModel.g.Error) gVar);
                kVar = ECShopOrderDetailFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1.this.this$0.showCostTimeReporter;
                k.c(kVar, 3, null, 2, null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
