package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample;

import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.repo.buyerorder.sample.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample.ECSampleOrderDetailViewModel$fetchOrderDetailData$1", f = "ECSampleOrderDetailViewModel.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSampleOrderDetailViewModel$fetchOrderDetailData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    int label;
    final /* synthetic */ ECSampleOrderDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSampleOrderDetailViewModel$fetchOrderDetailData$1(ECSampleOrderDetailViewModel eCSampleOrderDetailViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSampleOrderDetailViewModel;
        this.$orderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSampleOrderDetailViewModel$fetchOrderDetailData$1(this.this$0, this.$orderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSampleOrderDetailViewModel$fetchOrderDetailData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.ecommerce.repo.buyerorder.sample.a aVar;
        ECOrderDetailState q26;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.x2(ECOrderSubmitViewModel.g.c.f103527a);
            aVar = this.this$0.orderRepository;
            String str = this.$orderId;
            this.label = 1;
            obj = aVar.a(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a.OrderDetailResult orderDetailResult = (a.OrderDetailResult) obj;
        this.this$0.token = orderDetailResult.token;
        this.this$0.x2(orderDetailResult.state);
        ECSampleOrderDetailViewModel eCSampleOrderDetailViewModel = this.this$0;
        q26 = eCSampleOrderDetailViewModel.q2(orderDetailResult.orderDetailState);
        eCSampleOrderDetailViewModel.v2(q26);
        this.this$0.s2(RecommendFetchType.FIRST_FETCH);
        return Unit.INSTANCE;
    }
}
