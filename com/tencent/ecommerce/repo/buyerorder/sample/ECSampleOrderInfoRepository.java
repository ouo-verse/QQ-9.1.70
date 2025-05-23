package com.tencent.ecommerce.repo.buyerorder.sample;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailPayInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailWidgetsVisibility;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.OrderDetailCheckValidData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.SampleOrderState;
import com.tencent.ecommerce.biz.orders.common.f;
import com.tencent.ecommerce.repo.buyerorder.sample.a;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$OrderDetail;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$QueryOrderDetailReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$QueryOrderDetailRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$Logistics;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ProductSnapshot;
import com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data.ECSampleData$ShopSnapshot;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/sample/ECSampleOrderInfoRepository;", "Lcom/tencent/ecommerce/repo/buyerorder/sample/a;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/repo/buyerorder/sample/a$a;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$QueryOrderDetailRsp;", "c", "Ljava/lang/String;", "errorMsg", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSampleOrderInfoRepository implements a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String errorMsg;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0002J\n\u0010\b\u001a\u00020\u0007*\u00020\u0002R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/sample/ECSampleOrderInfoRepository$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$OrderDetail;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "a", "", "QUERY_ORDER_DETAIL_METHOD", "Ljava/lang/String;", "SERVICE", "TAG", "", "UNIT_SEC_TO_MILLIS", "I", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.buyerorder.sample.ECSampleOrderInfoRepository$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        private final OrderSkuDetail b(ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail) {
            ECSampleData$ProductSnapshot eCSampleData$ProductSnapshot = eCQshopSampleSvr$OrderDetail.product.get();
            ECSampleData$ShopSnapshot eCSampleData$ShopSnapshot = eCQshopSampleSvr$OrderDetail.shop.get();
            if (eCSampleData$ProductSnapshot != null && eCSampleData$ShopSnapshot != null) {
                return OrderSkuDetail.INSTANCE.c(eCSampleData$ProductSnapshot, eCSampleData$ShopSnapshot);
            }
            return d.a();
        }

        private final OrderSpuDetail c(ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail) {
            ECSampleData$ProductSnapshot eCSampleData$ProductSnapshot = eCQshopSampleSvr$OrderDetail.product.get();
            if (eCSampleData$ProductSnapshot != null) {
                return OrderSpuDetail.INSTANCE.b(eCSampleData$ProductSnapshot);
            }
            return com.tencent.ecommerce.biz.orders.buyerorders.detail.model.b.d();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ECOrderDetailState a(ECQshopSampleSvr$OrderDetail eCQshopSampleSvr$OrderDetail) {
            LogisticsInfo a16;
            ArrayList arrayListOf;
            ArrayList arrayListOf2;
            int i3 = eCQshopSampleSvr$OrderDetail.order.order_status.get();
            long j3 = i3 == SampleOrderState.FULFILLING.value ? eCQshopSampleSvr$OrderDetail.order.fulfil_expire_time.get() * 1000 : 0L;
            OrderDetailCheckValidData orderDetailCheckValidData = eCQshopSampleSvr$OrderDetail.ui_data.allow_modify_address.get() ? new OrderDetailCheckValidData(eCQshopSampleSvr$OrderDetail.ui_data.show_info.modify_expire_time.get() * 1000, "\u4f60\u5df2\u8d85\u8fc7\u4fee\u6539\u5730\u5740\u65f6\u6548") : null;
            ECSampleData$Logistics eCSampleData$Logistics = eCQshopSampleSvr$OrderDetail.logistics.get();
            if (eCSampleData$Logistics != null) {
                a16 = LogisticsInfo.INSTANCE.b(eCSampleData$Logistics);
            } else {
                a16 = f.a();
            }
            LogisticsInfo logisticsInfo = a16;
            ECOrderDetailPayInfo eCOrderDetailPayInfo = new ECOrderDetailPayInfo("", eCQshopSampleSvr$OrderDetail.product.total_amount.get(), eCQshopSampleSvr$OrderDetail.product.total_amount.get(), PayType.UNKNOWN, 0L);
            ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility = new ECOrderDetailWidgetsVisibility(false, true, eCQshopSampleSvr$OrderDetail.ui_data.allow_modify_address.get(), eCQshopSampleSvr$OrderDetail.ui_data.allow_logistics_detail.get(), true, false);
            long j16 = 1000;
            ECAddress c16 = com.tencent.ecommerce.biz.orders.address.b.c(eCQshopSampleSvr$OrderDetail.creative.address);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(b(eCQshopSampleSvr$OrderDetail));
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(c(eCQshopSampleSvr$OrderDetail));
            return new ECOrderDetailState(eCQshopSampleSvr$OrderDetail.order.order_id.get(), i3, null, null, eCQshopSampleSvr$OrderDetail.ui_data.show_info.sub_title.get(), j16 * eCQshopSampleSvr$OrderDetail.order.create_time.get(), j3, false, eCQshopSampleSvr$OrderDetail.order.cooperation_notes.get(), null, eCQshopSampleSvr$OrderDetail.creative.contact_details.get(), null, logisticsInfo, c16, orderDetailCheckValidData, arrayListOf, arrayListOf2, eCOrderDetailPayInfo, null, null, null, null, null, eCOrderDetailWidgetsVisibility, null, null, null, null, null, 526125580, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/buyerorder/sample/ECSampleOrderInfoRepository$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$QueryOrderDetailReq;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_sample_svr/ECQshopSampleSvr$QueryOrderDetailRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkPBContracts<ECQshopSampleSvr$QueryOrderDetailReq, ECQshopSampleSvr$QueryOrderDetailRsp> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQshopSampleSvr$QueryOrderDetailRsp decodeResponse(byte[] rsp) {
            return new ECQshopSampleSvr$QueryOrderDetailRsp().mergeFrom(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECQshopSampleSvr$QueryOrderDetailReq params, int channel, JSONObject reqExt) {
            return params.toByteArray();
        }
    }

    public ECSampleOrderInfoRepository(CoroutineDispatcher coroutineDispatcher) {
        this.coroutineDispatcher = coroutineDispatcher;
        this.errorMsg = wg0.a.a().getString(R.string.wo9);
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.sample.a
    public Object a(String str, Continuation<? super a.OrderDetailResult> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ECSampleOrderInfoRepository$fetchOrderDetail$2(this, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object c(String str, Continuation<? super ECNetworkResponse<ECQshopSampleSvr$QueryOrderDetailRsp>> continuation) {
        ECQshopSampleSvr$QueryOrderDetailReq eCQshopSampleSvr$QueryOrderDetailReq = new ECQshopSampleSvr$QueryOrderDetailReq();
        eCQshopSampleSvr$QueryOrderDetailReq.order_id.set(str);
        return com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_sample_svr.CreativeSvr", "/trpc.ecom.qshop_sample_svr.CreativeSvr/QueryOrderDetail", new b(), eCQshopSampleSvr$QueryOrderDetailReq, continuation);
    }

    public /* synthetic */ ECSampleOrderInfoRepository(CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
