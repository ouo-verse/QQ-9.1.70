package com.tencent.ecommerce.repo.buyerorder;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayStatus;
import com.tencent.ecommerce.repo.buyerorder.b;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CheckUnpaidReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CheckUnpaidRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/repo/buyerorder/b$b;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.buyerorder.ECQShopOrderInfoRepository$fetchOrderPayStatus$2", f = "ECQShopOrderInfoRepository.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECQShopOrderInfoRepository$fetchOrderPayStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b.OrderPayStatusResult>, Object> {
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $payParams;
    int label;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/buyerorder/ECQShopOrderInfoRepository$fetchOrderPayStatus$2$a", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CheckUnpaidReq;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CheckUnpaidRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkPBContracts<ECQshopOrderQuerySvr$CheckUnpaidReq, ECQshopOrderQuerySvr$CheckUnpaidRsp> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQshopOrderQuerySvr$CheckUnpaidRsp decodeResponse(byte[] rsp) {
            return new ECQshopOrderQuerySvr$CheckUnpaidRsp().mergeFrom(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECQshopOrderQuerySvr$CheckUnpaidReq params, int channel, JSONObject reqExt) {
            return params.toByteArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQShopOrderInfoRepository$fetchOrderPayStatus$2(String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.$orderId = str;
        this.$payParams = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECQShopOrderInfoRepository$fetchOrderPayStatus$2(this.$orderId, this.$payParams, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super b.OrderPayStatusResult> continuation) {
        return ((ECQShopOrderInfoRepository$fetchOrderPayStatus$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        PayStatus payStatus;
        boolean isBlank;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            cg0.a.b("ECQShopOrderInfoRepository", "fetchOrderPayStatus req, orderId=" + this.$orderId + ", payParams: " + this.$payParams);
            ECQshopOrderQuerySvr$CheckUnpaidReq eCQshopOrderQuerySvr$CheckUnpaidReq = new ECQshopOrderQuerySvr$CheckUnpaidReq();
            eCQshopOrderQuerySvr$CheckUnpaidReq.order_id.set(this.$orderId);
            eCQshopOrderQuerySvr$CheckUnpaidReq.pay_url_params.set(this.$payParams);
            a aVar = new a();
            this.label = 1;
            obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr", "/trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr/CheckUnpaid", aVar, eCQshopOrderQuerySvr$CheckUnpaidReq, this);
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
        ECQshopOrderQuerySvr$CheckUnpaidRsp eCQshopOrderQuerySvr$CheckUnpaidRsp = (ECQshopOrderQuerySvr$CheckUnpaidRsp) eCNetworkResponse.b();
        String string = wg0.a.a().getString(R.string.wo9);
        cg0.a.b("ECQShopOrderInfoRepository", "fetchOrderDetail rsp, code=" + code + ", msg=" + message);
        if (code == 0 && eCQshopOrderQuerySvr$CheckUnpaidRsp != null) {
            cg0.a.b("ECQShopOrderInfoRepository", "fetchOrderDetail rsp, isUnpaid = " + eCQshopOrderQuerySvr$CheckUnpaidRsp.unpaid);
            if (eCQshopOrderQuerySvr$CheckUnpaidRsp.unpaid.get()) {
                payStatus = PayStatus.UNPAID;
            } else {
                payStatus = PayStatus.PAID;
            }
            String str = eCQshopOrderQuerySvr$CheckUnpaidRsp.alert_msg.get();
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                string = str;
            }
            return new b.OrderPayStatusResult(payStatus, string);
        }
        return new b.OrderPayStatusResult(PayStatus.UNKNOWN, string);
    }
}
