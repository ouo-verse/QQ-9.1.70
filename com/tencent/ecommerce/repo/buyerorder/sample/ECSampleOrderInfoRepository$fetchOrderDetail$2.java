package com.tencent.ecommerce.repo.buyerorder.sample;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.h;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.repo.buyerorder.sample.a;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$QueryOrderDetailRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/repo/buyerorder/sample/a$a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.buyerorder.sample.ECSampleOrderInfoRepository$fetchOrderDetail$2", f = "ECSampleOrderInfoRepository.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECSampleOrderInfoRepository$fetchOrderDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a.OrderDetailResult>, Object> {
    final /* synthetic */ String $orderId;
    int label;
    final /* synthetic */ ECSampleOrderInfoRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSampleOrderInfoRepository$fetchOrderDetail$2(ECSampleOrderInfoRepository eCSampleOrderInfoRepository, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSampleOrderInfoRepository;
        this.$orderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSampleOrderInfoRepository$fetchOrderDetail$2(this.this$0, this.$orderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super a.OrderDetailResult> continuation) {
        return ((ECSampleOrderInfoRepository$fetchOrderDetail$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            cg0.a.b("ECSampleOrderInfoRepository", "fetchOrderDetail req, orderId = " + this.$orderId);
            ECSampleOrderInfoRepository eCSampleOrderInfoRepository = this.this$0;
            String str2 = this.$orderId;
            this.label = 1;
            obj = eCSampleOrderInfoRepository.c(str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        int code = eCNetworkResponse.getCode();
        String message = eCNetworkResponse.getMessage();
        ECQshopSampleSvr$QueryOrderDetailRsp eCQshopSampleSvr$QueryOrderDetailRsp = (ECQshopSampleSvr$QueryOrderDetailRsp) eCNetworkResponse.b();
        cg0.a.b("ECSampleOrderInfoRepository", "fetchOrderDetail rsp, orderId = " + this.$orderId + ", code = " + code + ", msg = " + message);
        if (code != 0 || eCQshopSampleSvr$QueryOrderDetailRsp == null) {
            str = this.this$0.errorMsg;
            return new a.OrderDetailResult(new ECOrderSubmitViewModel.g.Error(code, str), "", h.a());
        }
        String str3 = eCQshopSampleSvr$QueryOrderDetailRsp.token.get();
        if (cg0.a.c()) {
            cg0.a.b("ECSampleOrderInfoRepository", "token = " + str3);
        }
        return new a.OrderDetailResult(ECOrderSubmitViewModel.g.d.f103528a, str3, ECSampleOrderInfoRepository.INSTANCE.a(eCQshopSampleSvr$QueryOrderDetailRsp.order_detail));
    }
}
