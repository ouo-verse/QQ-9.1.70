package com.tencent.ecommerce.repo.buyerorder;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailBottomUIData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.h;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayStatus;
import com.tencent.ecommerce.repo.buyerorder.ECQShopOrderInfoRepository;
import com.tencent.ecommerce.repo.buyerorder.b;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$QueryOrderDetailRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/repo/buyerorder/b$a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.buyerorder.ECQShopOrderInfoRepository$fetchOrderDetail$2", f = "ECQShopOrderInfoRepository.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {253, 262, 264}, m = "invokeSuspend", n = {"localPayStatus", "fetchTime", "localPayStatus", "fetchTime", "localPayStatus", "response", "fetchTime"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: classes31.dex */
final class ECQShopOrderInfoRepository$fetchOrderDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b.OrderDetailResult>, Object> {
    final /* synthetic */ String $orderId;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECQShopOrderInfoRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQShopOrderInfoRepository$fetchOrderDetail$2(ECQShopOrderInfoRepository eCQShopOrderInfoRepository, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCQShopOrderInfoRepository;
        this.$orderId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECQShopOrderInfoRepository$fetchOrderDetail$2(this.this$0, this.$orderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super b.OrderDetailResult> continuation) {
        return ((ECQShopOrderInfoRepository$fetchOrderDetail$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00e3 -> B:8:0x0083). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        PayStatus d16;
        ECNetworkResponse eCNetworkResponse;
        ECQShopOrderInfoRepository$fetchOrderDetail$2 eCQShopOrderInfoRepository$fetchOrderDetail$2;
        PayStatus payStatus;
        int i3;
        int code;
        boolean h16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        int i17 = 1;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            d16 = this.this$0.d(this.$orderId);
            cg0.a.b("ECQShopOrderInfoRepository", "fetchOrderDetail req, orderId = " + this.$orderId + ", fetchTime = 1");
            ECQShopOrderInfoRepository eCQShopOrderInfoRepository = this.this$0;
            String str = this.$orderId;
            this.L$0 = d16;
            this.I$0 = 1;
            this.label = 1;
            obj = eCQShopOrderInfoRepository.f(str, d16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i16 == 1) {
            i17 = this.I$0;
            d16 = (PayStatus) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i16 != 2) {
                if (i16 == 3) {
                    int i18 = this.I$0;
                    ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) this.L$1;
                    PayStatus payStatus2 = (PayStatus) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    eCNetworkResponse = eCNetworkResponse2;
                    i17 = i18;
                    d16 = payStatus2;
                    eCQShopOrderInfoRepository$fetchOrderDetail$2 = this;
                    if (eCNetworkResponse.getCode() == 0 && i17 < 10) {
                        h16 = eCQShopOrderInfoRepository$fetchOrderDetail$2.this$0.h((ECQshopOrderQuerySvr$QueryOrderDetailRsp) eCNetworkResponse.b(), d16, eCQShopOrderInfoRepository$fetchOrderDetail$2.$orderId);
                        if (h16) {
                            int i19 = i17 + 1;
                            cg0.a.b("ECQShopOrderInfoRepository", "fetchOrderDetail req, orderId = " + eCQShopOrderInfoRepository$fetchOrderDetail$2.$orderId + ", fetchTime = " + i19);
                            ECQShopOrderInfoRepository eCQShopOrderInfoRepository2 = eCQShopOrderInfoRepository$fetchOrderDetail$2.this$0;
                            String str2 = eCQShopOrderInfoRepository$fetchOrderDetail$2.$orderId;
                            eCQShopOrderInfoRepository$fetchOrderDetail$2.L$0 = d16;
                            eCQShopOrderInfoRepository$fetchOrderDetail$2.L$1 = null;
                            eCQShopOrderInfoRepository$fetchOrderDetail$2.I$0 = i19;
                            eCQShopOrderInfoRepository$fetchOrderDetail$2.label = 2;
                            obj = eCQShopOrderInfoRepository2.f(str2, d16, eCQShopOrderInfoRepository$fetchOrderDetail$2);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            payStatus = d16;
                            i3 = i19;
                            eCNetworkResponse = (ECNetworkResponse) obj;
                            eCQShopOrderInfoRepository$fetchOrderDetail$2.L$0 = payStatus;
                            eCQShopOrderInfoRepository$fetchOrderDetail$2.L$1 = eCNetworkResponse;
                            eCQShopOrderInfoRepository$fetchOrderDetail$2.I$0 = i3;
                            eCQShopOrderInfoRepository$fetchOrderDetail$2.label = 3;
                            if (DelayKt.delay(3000L, eCQShopOrderInfoRepository$fetchOrderDetail$2) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            PayStatus payStatus3 = payStatus;
                            i17 = i3;
                            d16 = payStatus3;
                            if (eCNetworkResponse.getCode() == 0) {
                                h16 = eCQShopOrderInfoRepository$fetchOrderDetail$2.this$0.h((ECQshopOrderQuerySvr$QueryOrderDetailRsp) eCNetworkResponse.b(), d16, eCQShopOrderInfoRepository$fetchOrderDetail$2.$orderId);
                                if (h16) {
                                }
                            }
                        }
                    }
                    code = eCNetworkResponse.getCode();
                    String message = eCNetworkResponse.getMessage();
                    ECQshopOrderQuerySvr$QueryOrderDetailRsp eCQshopOrderQuerySvr$QueryOrderDetailRsp = (ECQshopOrderQuerySvr$QueryOrderDetailRsp) eCNetworkResponse.b();
                    cg0.a.b("ECQShopOrderInfoRepository", "fetchOrderDetail rsp, code = " + code + ", msg = " + message);
                    if (code != 0 && eCQshopOrderQuerySvr$QueryOrderDetailRsp != null) {
                        String str3 = "fetchOrderDetail rsp, orderId = " + eCQshopOrderQuerySvr$QueryOrderDetailRsp.order_info.order_id.get() + ", state = " + eCQshopOrderQuerySvr$QueryOrderDetailRsp.order_info.state.get();
                        if (cg0.a.c()) {
                            cg0.a.b("ECQShopOrderInfoRepository", str3 + ", token = " + eCQshopOrderQuerySvr$QueryOrderDetailRsp.token.get());
                        } else {
                            cg0.a.b("ECQShopOrderInfoRepository", str3);
                        }
                        ECOrderSubmitViewModel.g.d dVar = ECOrderSubmitViewModel.g.d.f103528a;
                        String str4 = eCQshopOrderQuerySvr$QueryOrderDetailRsp.token.get();
                        ECQShopOrderInfoRepository.Companion companion = ECQShopOrderInfoRepository.INSTANCE;
                        return new b.OrderDetailResult(dVar, str4, companion.b(eCQshopOrderQuerySvr$QueryOrderDetailRsp.order_info), companion.d(eCQshopOrderQuerySvr$QueryOrderDetailRsp.order_info));
                    }
                    return new b.OrderDetailResult(new ECOrderSubmitViewModel.g.Error(code, message), "", h.a(), new ECOrderDetailBottomUIData(false, false, false, false, false, false, 63, null));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i3 = this.I$0;
            payStatus = (PayStatus) this.L$0;
            ResultKt.throwOnFailure(obj);
            eCQShopOrderInfoRepository$fetchOrderDetail$2 = this;
            eCNetworkResponse = (ECNetworkResponse) obj;
            eCQShopOrderInfoRepository$fetchOrderDetail$2.L$0 = payStatus;
            eCQShopOrderInfoRepository$fetchOrderDetail$2.L$1 = eCNetworkResponse;
            eCQShopOrderInfoRepository$fetchOrderDetail$2.I$0 = i3;
            eCQShopOrderInfoRepository$fetchOrderDetail$2.label = 3;
            if (DelayKt.delay(3000L, eCQShopOrderInfoRepository$fetchOrderDetail$2) != coroutine_suspended) {
            }
        }
        eCNetworkResponse = (ECNetworkResponse) obj;
        eCQShopOrderInfoRepository$fetchOrderDetail$2 = this;
        if (eCNetworkResponse.getCode() == 0) {
        }
        code = eCNetworkResponse.getCode();
        String message2 = eCNetworkResponse.getMessage();
        ECQshopOrderQuerySvr$QueryOrderDetailRsp eCQshopOrderQuerySvr$QueryOrderDetailRsp2 = (ECQshopOrderQuerySvr$QueryOrderDetailRsp) eCNetworkResponse.b();
        cg0.a.b("ECQShopOrderInfoRepository", "fetchOrderDetail rsp, code = " + code + ", msg = " + message2);
        if (code != 0) {
        }
        return new b.OrderDetailResult(new ECOrderSubmitViewModel.g.Error(code, message2), "", h.a(), new ECOrderDetailBottomUIData(false, false, false, false, false, false, 63, null));
    }
}
