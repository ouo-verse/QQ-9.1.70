package com.tencent.ecommerce.repo.buyerorder;

import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECExtraJumpInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailAccountInfoData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailBottomUIData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailGoodsOperateState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailPayInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailWidgetsVisibility;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.OrderDetailCheckValidData;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayStatus;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.d;
import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderCouponInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderPromoInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderState;
import com.tencent.ecommerce.repo.buyerorder.b;
import com.tencent.ecommerce.repo.proto.ecom.common_logistics_common.ECLogisticsCommon$LogisticsInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$OrderSku;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ProductCart;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$Promo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$ShopInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$SpuInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$TicketInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$UsedCouponItem;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$ExtraJmpPage;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$QueryOrderDetailReq;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$QueryOrderDetailRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u000eB\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001b\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/ECQShopOrderInfoRepository;", "Lcom/tencent/ecommerce/repo/buyerorder/b;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$QueryOrderDetailRsp;", "rspData", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayStatus;", "localPayStatus", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", h.F, "g", "", "i", "Lcom/tencent/ecommerce/repo/buyerorder/b$a;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/network/api/d;", "f", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payParams", "Lcom/tencent/ecommerce/repo/buyerorder/b$b;", "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "status", "c", "d", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECQShopOrderInfoRepository implements com.tencent.ecommerce.repo.buyerorder.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010\u001aJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0002H\u0002J\u0012\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0005*\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0002H\u0002J\u000e\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u0002H\u0002J\n\u0010\u000f\u001a\u00020\u000e*\u00020\u0002J\n\u0010\u0011\u001a\u00020\u0010*\u00020\u0002R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u00128\u0006X\u0087T\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u0012\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00128\u0006X\u0087T\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0014\u0012\u0004\b\u001f\u0010\u001aR\u0014\u0010 \u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0014R\u0014\u0010!\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0014R\u0014\u0010\"\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/tencent/ecommerce/repo/buyerorder/ECQShopOrderInfoRepository$a;", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$OrderInfo;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;", "c", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "e", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/a;", "f", "Lcom/tencent/ecommerce/biz/orders/common/a;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "g", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/d;", "d", "", "CHECK_UNPAID_METHOD", "Ljava/lang/String;", "", "FETCH_ORDER_RETRY_COUNT_FOR_INCONSISTENCY", "I", "QUERY_ORDER_DETAIL_METHOD", "getQUERY_ORDER_DETAIL_METHOD$annotations", "()V", "", "RETRY_DURATION_MS", "J", "SERVICE", "getSERVICE$annotations", "SP_KEY_PAY_STATUS", "TAG", "UNIT_SEC_TO_MILLIS", "<init>", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.buyerorder.ECQShopOrderInfoRepository$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        private final BulletinInfo a(ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo) {
            if (eCOrderInfo$OrderInfo.bulletin.has()) {
                return new BulletinInfo(eCOrderInfo$OrderInfo.bulletin.title.get(), eCOrderInfo$OrderInfo.bulletin.content.get());
            }
            return null;
        }

        private final ECOrderDetailGoodsOperateState c(ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo) {
            return new ECOrderDetailGoodsOperateState(eCOrderInfo$OrderInfo.order_ui_data.allow_refund_order.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_refund_detail.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_launch_after_sales.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_after_sales_detail.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_lanch_platform_service.get(), eCOrderInfo$OrderInfo.order_ui_data.apply_refund_or_after_sales_url.get(), eCOrderInfo$OrderInfo.order_ui_data.view_refund_or_after_sales_url.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_launch_after_sales.get() ? new OrderDetailCheckValidData(eCOrderInfo$OrderInfo.apply_after_sales_deadline.get() * 1000, eCOrderInfo$OrderInfo.order_ui_data.exceeded_apply_after_sales_deadline_str.get()) : null);
        }

        private final List<OrderSpuDetail> f(ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo) {
            ArrayList arrayListOf;
            List<ECOrderCommon$ProductCart> list = eCOrderInfo$OrderInfo.product_carts.get();
            if (list.isEmpty()) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.ecommerce.biz.orders.buyerorders.detail.model.b.d());
                return arrayListOf;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ECOrderCommon$OrderSku eCOrderCommon$OrderSku = ((ECOrderCommon$ProductCart) it.next()).order_sku;
                ECOrderCommon$SpuInfo eCOrderCommon$SpuInfo = eCOrderCommon$OrderSku != null ? eCOrderCommon$OrderSku.spu : null;
                if (eCOrderCommon$SpuInfo != null) {
                    arrayList.add(OrderSpuDetail.INSTANCE.a(eCOrderCommon$SpuInfo, eCOrderInfo$OrderInfo.labels.get()));
                } else {
                    arrayList.add(com.tencent.ecommerce.biz.orders.buyerorders.detail.model.b.d());
                }
            }
            return arrayList;
        }

        private final f.TicketInfoData g(ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo) {
            if (!eCOrderInfo$OrderInfo.ticket_info.has() || !(!eCOrderInfo$OrderInfo.ticket_info.ticket_sequences.get().isEmpty())) {
                return null;
            }
            ECOrderCommon$TicketInfo eCOrderCommon$TicketInfo = eCOrderInfo$OrderInfo.ticket_info.get();
            return new f.TicketInfoData(eCOrderCommon$TicketInfo.ticket_sequences.get(), new TicketDetail(eCOrderCommon$TicketInfo.name.get(), eCOrderCommon$TicketInfo.available_time.get(), eCOrderCommon$TicketInfo.precondition.get(), eCOrderCommon$TicketInfo.service_hotline.get(), eCOrderCommon$TicketInfo.announcement.get()));
        }

        public final ECOrderDetailBottomUIData d(ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo) {
            return new ECOrderDetailBottomUIData(eCOrderInfo$OrderInfo.order_ui_data.allow_pay_order.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_cancel_order.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_confirm_received.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_comment.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_comment.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_send_box.get());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<OrderSkuDetail> e(ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo) {
            ArrayList arrayListOf;
            OrderSkuDetail a16;
            List<ECOrderCommon$ProductCart> list = eCOrderInfo$OrderInfo.product_carts.get();
            ECOrderCommon$ShopInfo eCOrderCommon$ShopInfo = eCOrderInfo$OrderInfo.shop_info.get();
            if (list.isEmpty() || eCOrderCommon$ShopInfo == null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(d.a());
                return arrayListOf;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a16 = OrderSkuDetail.INSTANCE.a((ECOrderCommon$ProductCart) it.next(), eCOrderCommon$ShopInfo, eCOrderInfo$OrderInfo.free_shipping.get(), eCOrderInfo$OrderInfo.shipping_cost.get(), eCOrderInfo$OrderInfo.ori_price.get(), (r21 & 32) != 0 ? 0 : 0, (r21 & 64) != 0 ? 1 : 0, pj0.a.a(eCOrderInfo$OrderInfo));
                arrayList.add(a16);
            }
            return arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x014d A[LOOP:0: B:20:0x0147->B:22:0x014d, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x01cd A[LOOP:1: B:25:0x01c7->B:27:0x01cd, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x01fc A[LOOP:2: B:30:0x01f6->B:32:0x01fc, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0052  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ECOrderDetailState b(ECOrderInfo$OrderInfo eCOrderInfo$OrderInfo) {
            long j3;
            long j16;
            Object firstOrNull;
            ECLogisticsCommon$LogisticsInfo eCLogisticsCommon$LogisticsInfo;
            LogisticsInfo a16;
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            Iterator<T> it;
            int collectionSizeOrDefault3;
            Iterator it5;
            int i3 = eCOrderInfo$OrderInfo.state.get();
            if (i3 == QShopOrderState.PAYMENT_PENDING.value) {
                j16 = eCOrderInfo$OrderInfo.pay_deadline.get();
            } else if (i3 == QShopOrderState.DELIVERY_PENDING.value) {
                j16 = eCOrderInfo$OrderInfo.receipt_deadline.get();
            } else {
                j3 = 0;
                ECOrderDetailAccountInfoData eCOrderDetailAccountInfoData = new ECOrderDetailAccountInfoData(eCOrderInfo$OrderInfo.virtual_account.virtual_account_type.get(), eCOrderInfo$OrderInfo.virtual_account.account_name.get(), eCOrderInfo$OrderInfo.virtual_account.account.get());
                OrderDetailCheckValidData orderDetailCheckValidData = !eCOrderInfo$OrderInfo.order_ui_data.allow_update_address.get() ? new OrderDetailCheckValidData(eCOrderInfo$OrderInfo.update_address_deadline.get() * 1000, eCOrderInfo$OrderInfo.order_ui_data.exceeded_update_address_deadline_str.get()) : null;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) eCOrderInfo$OrderInfo.shipping_info.get());
                eCLogisticsCommon$LogisticsInfo = (ECLogisticsCommon$LogisticsInfo) firstOrNull;
                if (eCLogisticsCommon$LogisticsInfo == null) {
                    a16 = LogisticsInfo.INSTANCE.a(eCLogisticsCommon$LogisticsInfo);
                } else {
                    a16 = com.tencent.ecommerce.biz.orders.common.f.a();
                }
                LogisticsInfo logisticsInfo = a16;
                PayType a17 = PayType.INSTANCE.a(eCOrderInfo$OrderInfo.pay_type.get());
                long j17 = 1000;
                ECOrderDetailPayInfo eCOrderDetailPayInfo = new ECOrderDetailPayInfo(eCOrderInfo$OrderInfo.pay_url_params.get(), eCOrderInfo$OrderInfo.order_price.get(), eCOrderInfo$OrderInfo.ori_price.get(), a17, eCOrderInfo$OrderInfo.pay_time.get() * j17);
                ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility = new ECOrderDetailWidgetsVisibility(eCOrderInfo$OrderInfo.order_ui_data.allow_show_virtual_account.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_address.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_update_address.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_shipping.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_shipping_cost.get(), eCOrderInfo$OrderInfo.pay_time.get() == 0 && a17 != PayType.UNKNOWN);
                cg0.a.b("ECQShopOrderInfoRepository", "getECOrderDetailState, bulletinInfo=" + (eCOrderInfo$OrderInfo.order_ui_data.show_bulletin.has() ? new BulletinInfo(eCOrderInfo$OrderInfo.bulletin.title.get(), eCOrderInfo$OrderInfo.bulletin.content.get()) : null));
                List<ECOrderInfo$ExtraJmpPage> list = eCOrderInfo$OrderInfo.extra_jmp_pages.get();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (ECOrderInfo$ExtraJmpPage eCOrderInfo$ExtraJmpPage : list) {
                    arrayList.add(new ECExtraJumpInfo(eCOrderInfo$ExtraJmpPage.title.get(), eCOrderInfo$ExtraJmpPage.desc.get(), eCOrderInfo$ExtraJmpPage.link.get()));
                }
                String str = eCOrderInfo$OrderInfo.order_id.get();
                String str2 = eCOrderInfo$OrderInfo.order_ui_data.order_state_preferred_str.get();
                String str3 = eCOrderInfo$OrderInfo.order_ui_data.order_state_desc_str.get();
                long j18 = j17 * eCOrderInfo$OrderInfo.create_time.get();
                boolean z16 = eCOrderInfo$OrderInfo.has_comment.get();
                String str4 = eCOrderInfo$OrderInfo.remarks.get();
                String str5 = eCOrderInfo$OrderInfo.remarks_for_buyer.get();
                String str6 = null;
                ECAddress c16 = com.tencent.ecommerce.biz.orders.address.b.c(eCOrderInfo$OrderInfo.address);
                List<OrderSkuDetail> e16 = e(eCOrderInfo$OrderInfo);
                List<OrderSpuDetail> f16 = f(eCOrderInfo$OrderInfo);
                f.TicketInfoData g16 = g(eCOrderInfo$OrderInfo);
                List<ECOrderCommon$Promo> list2 = eCOrderInfo$OrderInfo.promos.get();
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(QShopOrderPromoInfo.INSTANCE.a((ECOrderCommon$Promo) it.next()));
                }
                List<ECOrderCommon$UsedCouponItem> list3 = eCOrderInfo$OrderInfo.coupon_items.get();
                collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
                for (it5 = list3.iterator(); it5.hasNext(); it5 = it5) {
                    arrayList3.add(QShopOrderCouponInfo.INSTANCE.a((ECOrderCommon$UsedCouponItem) it5.next()));
                }
                return new ECOrderDetailState(str, i3, null, str2, str3, j18, j3, z16, str4, str5, str6, eCOrderDetailAccountInfoData, logisticsInfo, c16, orderDetailCheckValidData, e16, f16, eCOrderDetailPayInfo, g16, arrayList2, arrayList3, c(eCOrderInfo$OrderInfo), null, eCOrderDetailWidgetsVisibility, null, a(eCOrderInfo$OrderInfo), arrayList, eCOrderInfo$OrderInfo.warehouse_link.get(), eCOrderInfo$OrderInfo.order_ui_data.delivery_msg.get(), 20972548, null);
            }
            j3 = j16 * 1000;
            ECOrderDetailAccountInfoData eCOrderDetailAccountInfoData2 = new ECOrderDetailAccountInfoData(eCOrderInfo$OrderInfo.virtual_account.virtual_account_type.get(), eCOrderInfo$OrderInfo.virtual_account.account_name.get(), eCOrderInfo$OrderInfo.virtual_account.account.get());
            if (!eCOrderInfo$OrderInfo.order_ui_data.allow_update_address.get()) {
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) eCOrderInfo$OrderInfo.shipping_info.get());
            eCLogisticsCommon$LogisticsInfo = (ECLogisticsCommon$LogisticsInfo) firstOrNull;
            if (eCLogisticsCommon$LogisticsInfo == null) {
            }
            LogisticsInfo logisticsInfo2 = a16;
            PayType a172 = PayType.INSTANCE.a(eCOrderInfo$OrderInfo.pay_type.get());
            long j172 = 1000;
            ECOrderDetailPayInfo eCOrderDetailPayInfo2 = new ECOrderDetailPayInfo(eCOrderInfo$OrderInfo.pay_url_params.get(), eCOrderInfo$OrderInfo.order_price.get(), eCOrderInfo$OrderInfo.ori_price.get(), a172, eCOrderInfo$OrderInfo.pay_time.get() * j172);
            ECOrderDetailWidgetsVisibility eCOrderDetailWidgetsVisibility2 = new ECOrderDetailWidgetsVisibility(eCOrderInfo$OrderInfo.order_ui_data.allow_show_virtual_account.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_address.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_update_address.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_shipping.get(), eCOrderInfo$OrderInfo.order_ui_data.allow_view_shipping_cost.get(), eCOrderInfo$OrderInfo.pay_time.get() == 0 && a172 != PayType.UNKNOWN);
            if (eCOrderInfo$OrderInfo.order_ui_data.show_bulletin.has()) {
            }
            cg0.a.b("ECQShopOrderInfoRepository", "getECOrderDetailState, bulletinInfo=" + (eCOrderInfo$OrderInfo.order_ui_data.show_bulletin.has() ? new BulletinInfo(eCOrderInfo$OrderInfo.bulletin.title.get(), eCOrderInfo$OrderInfo.bulletin.content.get()) : null));
            List<ECOrderInfo$ExtraJmpPage> list4 = eCOrderInfo$OrderInfo.extra_jmp_pages.get();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            while (r2.hasNext()) {
            }
            String str7 = eCOrderInfo$OrderInfo.order_id.get();
            String str22 = eCOrderInfo$OrderInfo.order_ui_data.order_state_preferred_str.get();
            String str32 = eCOrderInfo$OrderInfo.order_ui_data.order_state_desc_str.get();
            long j182 = j172 * eCOrderInfo$OrderInfo.create_time.get();
            boolean z162 = eCOrderInfo$OrderInfo.has_comment.get();
            String str42 = eCOrderInfo$OrderInfo.remarks.get();
            String str52 = eCOrderInfo$OrderInfo.remarks_for_buyer.get();
            String str62 = null;
            ECAddress c162 = com.tencent.ecommerce.biz.orders.address.b.c(eCOrderInfo$OrderInfo.address);
            List<OrderSkuDetail> e162 = e(eCOrderInfo$OrderInfo);
            List<OrderSpuDetail> f162 = f(eCOrderInfo$OrderInfo);
            f.TicketInfoData g162 = g(eCOrderInfo$OrderInfo);
            List<ECOrderCommon$Promo> list22 = eCOrderInfo$OrderInfo.promos.get();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list22, 10);
            ArrayList arrayList22 = new ArrayList(collectionSizeOrDefault2);
            it = list22.iterator();
            while (it.hasNext()) {
            }
            List<ECOrderCommon$UsedCouponItem> list32 = eCOrderInfo$OrderInfo.coupon_items.get();
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list32, 10);
            ArrayList arrayList32 = new ArrayList(collectionSizeOrDefault3);
            while (it5.hasNext()) {
            }
            return new ECOrderDetailState(str7, i3, null, str22, str32, j182, j3, z162, str42, str52, str62, eCOrderDetailAccountInfoData2, logisticsInfo2, c162, orderDetailCheckValidData, e162, f162, eCOrderDetailPayInfo2, g162, arrayList22, arrayList32, c(eCOrderInfo$OrderInfo), null, eCOrderDetailWidgetsVisibility2, null, a(eCOrderInfo$OrderInfo), arrayList4, eCOrderInfo$OrderInfo.warehouse_link.get(), eCOrderInfo$OrderInfo.order_ui_data.delivery_msg.get(), 20972548, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/buyerorder/ECQShopOrderInfoRepository$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$QueryOrderDetailReq;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$QueryOrderDetailRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkPBContracts<ECQshopOrderQuerySvr$QueryOrderDetailReq, ECQshopOrderQuerySvr$QueryOrderDetailRsp> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECQshopOrderQuerySvr$QueryOrderDetailRsp decodeResponse(byte[] rsp) {
            return new ECQshopOrderQuerySvr$QueryOrderDetailRsp().mergeFrom(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECQshopOrderQuerySvr$QueryOrderDetailReq params, int channel, JSONObject reqExt) {
            return params.toByteArray();
        }
    }

    public ECQShopOrderInfoRepository(CoroutineDispatcher coroutineDispatcher) {
        this.coroutineDispatcher = coroutineDispatcher;
    }

    private final String g(String orderId) {
        return "local_pay_status_" + orderId;
    }

    private final void i(String orderId) {
        ECLocalConfig.f100650f.remove(g(orderId), Boolean.TRUE);
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.b
    public Object a(String str, Continuation<? super b.OrderDetailResult> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ECQShopOrderInfoRepository$fetchOrderDetail$2(this, str, null), continuation);
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.b
    public Object b(String str, String str2, Continuation<? super b.OrderPayStatusResult> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ECQShopOrderInfoRepository$fetchOrderPayStatus$2(str, str2, null), continuation);
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.b
    public void c(String orderId, PayStatus status) {
        cg0.a.b("ECQShopOrderInfoRepository", "update order pay status: orderId = " + orderId + ", status: " + status);
        ECLocalConfig.f100650f.setInt(g(orderId), status.value, Boolean.TRUE);
    }

    @Override // com.tencent.ecommerce.repo.buyerorder.b
    public PayStatus d(String orderId) {
        PayStatus payStatus;
        int d16 = IECLocalConfig.a.d(ECLocalConfig.f100650f, g(orderId), PayStatus.UNPAID.value, null, 4, null);
        PayStatus[] values = PayStatus.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                payStatus = null;
                break;
            }
            payStatus = values[i3];
            if (payStatus.value == d16) {
                break;
            }
            i3++;
        }
        return payStatus != null ? payStatus : PayStatus.UNPAID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object f(String str, PayStatus payStatus, Continuation<? super ECNetworkResponse<ECQshopOrderQuerySvr$QueryOrderDetailRsp>> continuation) {
        ECQshopOrderQuerySvr$QueryOrderDetailReq eCQshopOrderQuerySvr$QueryOrderDetailReq = new ECQshopOrderQuerySvr$QueryOrderDetailReq();
        eCQshopOrderQuerySvr$QueryOrderDetailReq.order_id.set(str);
        eCQshopOrderQuerySvr$QueryOrderDetailReq.pay_status_from_client.set(payStatus == PayStatus.PAID ? 1 : 0);
        return com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr", "/trpc.ecom.qshop_order_query_svr.QshopOrderQuerySvr/QueryOrderDetail", new b(), eCQshopOrderQuerySvr$QueryOrderDetailReq, continuation);
    }

    public /* synthetic */ ECQShopOrderInfoRepository(CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(ECQshopOrderQuerySvr$QueryOrderDetailRsp rspData, PayStatus localPayStatus, String orderId) {
        if (rspData == null) {
            return true;
        }
        if (localPayStatus == PayStatus.UNPAID) {
            return false;
        }
        PayStatus payStatus = QShopOrderState.INSTANCE.a(rspData.order_info.state.get()).getPayStatus();
        PayStatus payStatus2 = PayStatus.PAID;
        if (localPayStatus == payStatus2 && payStatus != payStatus2) {
            return true;
        }
        if (localPayStatus == payStatus2 && payStatus == payStatus2) {
            i(orderId);
        }
        return false;
    }
}
