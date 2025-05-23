package com.tencent.ecommerce.repo.buyerorder.orderlist;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.repo.buyerorder.orderlist.e;
import com.tencent.ecommerce.repo.buyerorder.orderlist.f;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$ConfirmReceiptReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$ConfirmReceiptRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$OrderChangeRefreshMsg;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/f;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.buyerorder.orderlist.ECOrderOperateRepository$confirmReceive$2", f = "ECOrderOperateRepository.kt", i = {1, 1}, l = {114, 121}, m = "invokeSuspend", n = {"response", "reqInfo"}, s = {"L$0", "L$1"})
/* loaded from: classes31.dex */
final class ECOrderOperateRepository$confirmReceive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f>, Object> {
    final /* synthetic */ boolean $needLatestOrder;
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $token;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECOrderOperateRepository this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/buyerorder/orderlist/ECOrderOperateRepository$confirmReceive$2$a", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$ConfirmReceiptReq;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$ConfirmReceiptRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkPBContracts<ECQshopOrderSvr$ConfirmReceiptReq, ECQshopOrderSvr$ConfirmReceiptRsp> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQshopOrderSvr$ConfirmReceiptRsp decodeResponse(byte[] rsp) {
            return new ECQshopOrderSvr$ConfirmReceiptRsp().mergeFrom(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECQshopOrderSvr$ConfirmReceiptReq params, int channel, JSONObject reqExt) {
            return params.toByteArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderOperateRepository$confirmReceive$2(ECOrderOperateRepository eCOrderOperateRepository, String str, String str2, boolean z16, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderOperateRepository;
        this.$orderId = str;
        this.$token = str2;
        this.$needLatestOrder = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderOperateRepository$confirmReceive$2(this.this$0, this.$orderId, this.$token, this.$needLatestOrder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super f> continuation) {
        return ((ECOrderOperateRepository$confirmReceive$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ECNetworkResponse<?> eCNetworkResponse;
        int code;
        String str;
        MutableSharedFlow mutableSharedFlow;
        ECOrderSpan.OrderRequestInfo orderRequestInfo;
        ECQshopOrderSvr$OrderChangeRefreshMsg eCQshopOrderSvr$OrderChangeRefreshMsg;
        PBStringField pBStringField;
        ECQshopOrderSvr$OrderChangeRefreshMsg eCQshopOrderSvr$OrderChangeRefreshMsg2;
        PBUInt32Field pBUInt32Field;
        Integer boxInt;
        ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (cg0.a.c()) {
                cg0.a.b("ECOrderOperateRepository", "confirmReceive req, orderId=" + this.$orderId + ", token=" + this.$token);
            } else {
                cg0.a.b("ECOrderOperateRepository", "confirmReceive req, orderId=" + this.$orderId);
            }
            ECQshopOrderSvr$ConfirmReceiptReq eCQshopOrderSvr$ConfirmReceiptReq = new ECQshopOrderSvr$ConfirmReceiptReq();
            eCQshopOrderSvr$ConfirmReceiptReq.order_id.set(this.$orderId);
            eCQshopOrderSvr$ConfirmReceiptReq.token.set(this.$token);
            eCQshopOrderSvr$ConfirmReceiptReq.need_latest_order.set(this.$needLatestOrder);
            a aVar = new a();
            this.label = 1;
            obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_order_svr.QshopOrderSvr", "/trpc.ecom.qshop_order_svr.QshopOrderSvr/ConfirmReceipt", aVar, eCQshopOrderSvr$ConfirmReceiptReq, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    orderRequestInfo = (ECOrderSpan.OrderRequestInfo) this.L$1;
                    eCNetworkResponse = (ECNetworkResponse) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ECQshopOrderSvr$ConfirmReceiptRsp eCQshopOrderSvr$ConfirmReceiptRsp = (ECQshopOrderSvr$ConfirmReceiptRsp) eCNetworkResponse.b();
                    return new f.Succeed(orderRequestInfo, (eCQshopOrderSvr$ConfirmReceiptRsp != null || (eCOrderInfo$OrderInfo = eCQshopOrderSvr$ConfirmReceiptRsp.order_info) == null) ? null : eCOrderInfo$OrderInfo.get());
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        eCNetworkResponse = (ECNetworkResponse) obj;
        ECQshopOrderSvr$ConfirmReceiptRsp eCQshopOrderSvr$ConfirmReceiptRsp2 = (ECQshopOrderSvr$ConfirmReceiptRsp) eCNetworkResponse.b();
        if (eCQshopOrderSvr$ConfirmReceiptRsp2 != null && (eCQshopOrderSvr$OrderChangeRefreshMsg2 = eCQshopOrderSvr$ConfirmReceiptRsp2.order_change_refresh_msg) != null && (pBUInt32Field = eCQshopOrderSvr$OrderChangeRefreshMsg2.err_code) != null && (boxInt = Boxing.boxInt(pBUInt32Field.get())) != null) {
            code = boxInt.intValue();
        } else {
            code = eCNetworkResponse.getCode();
        }
        int i16 = code;
        ECQshopOrderSvr$ConfirmReceiptRsp eCQshopOrderSvr$ConfirmReceiptRsp3 = (ECQshopOrderSvr$ConfirmReceiptRsp) eCNetworkResponse.b();
        if (eCQshopOrderSvr$ConfirmReceiptRsp3 == null || (eCQshopOrderSvr$OrderChangeRefreshMsg = eCQshopOrderSvr$ConfirmReceiptRsp3.order_change_refresh_msg) == null || (pBStringField = eCQshopOrderSvr$OrderChangeRefreshMsg.f105255msg) == null || (str = pBStringField.get()) == null) {
            str = this.this$0.defaultErrTips;
        }
        String str2 = str;
        cg0.a.b("ECOrderOperateRepository", "confirmReceive rsp, code=" + i16 + ", msg=" + str2);
        ECOrderSpan.OrderRequestInfo d16 = ECOrderSpan.f103884c.d(eCNetworkResponse);
        if (i16 == 0) {
            mutableSharedFlow = this.this$0._orderListOperateEvent;
            e.b bVar = e.b.f105012a;
            this.L$0 = eCNetworkResponse;
            this.L$1 = d16;
            this.label = 2;
            if (mutableSharedFlow.emit(bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            orderRequestInfo = d16;
            ECQshopOrderSvr$ConfirmReceiptRsp eCQshopOrderSvr$ConfirmReceiptRsp4 = (ECQshopOrderSvr$ConfirmReceiptRsp) eCNetworkResponse.b();
            return new f.Succeed(orderRequestInfo, (eCQshopOrderSvr$ConfirmReceiptRsp4 != null || (eCOrderInfo$OrderInfo = eCQshopOrderSvr$ConfirmReceiptRsp4.order_info) == null) ? null : eCOrderInfo$OrderInfo.get());
        }
        return new f.Failed(i16, str2, d16, null, 8, null);
    }
}
