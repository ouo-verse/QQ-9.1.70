package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.AddressCheckResult;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.CalculatePriceScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitDetailInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitPriceInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common.ECOrderCommon$BriefYiFanAward;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CaptchaToken;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CommitOrderRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002./JI\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ}\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\n2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u009d\u0001\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00132\b\b\u0002\u0010*\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "simpleSku", "", "pageExt", "activityId", "groupId", "", "isBuyAll", "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$b;", "fetchOrderSubmitDetails", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orderGoodsId", "", "quantity", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;", "scene", "", "couponIds", "buyAll", "boxOrderIds", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$a;", "calculateOrderPrice", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/CalculatePriceScene;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "spuId", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/a;", "checkAddressReachable", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "orderDetail", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "orderRsp", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CaptchaToken;", "captchaToken", "adClickId", "boxId", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_common/ECOrderCommon$BriefYiFanAward;", "allAward", "aidStr", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CommitOrderRsp;", "submit", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Ljava/lang/String;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CaptchaToken;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECOrderSubmitRepo {
    Object calculateOrderPrice(String str, int i3, String str2, CalculatePriceScene calculatePriceScene, List<String> list, String str3, String str4, Boolean bool, List<String> list2, Continuation<? super ECNetworkResponse<CalculateOrderPriceResult>> continuation);

    Object checkAddressReachable(String str, ECAddress eCAddress, Continuation<? super ECNetworkResponse<AddressCheckResult>> continuation);

    Object fetchOrderSubmitDetails(SimpleSku simpleSku, String str, String str2, String str3, Boolean bool, Continuation<? super ECNetworkResponse<OrderSubmitDetailWrapper>> continuation);

    Object submit(OrderSubmitDetailInfo orderSubmitDetailInfo, ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp, ECAddress eCAddress, String str, ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken, String str2, String str3, List<String> list, String str4, Boolean bool, List<ECOrderCommon$BriefYiFanAward> list2, String str5, Continuation<? super ECNetworkResponse<ECQshopOrderSvr$CommitOrderRsp>> continuation);

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "quantity", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;", "priceInfo", "c", "maxQuantity", "d", "Z", "isExceedLimit", "e", "Ljava/lang/String;", "exceedLimitMsg", "", "f", "J", "originUnitPrice", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "g", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "orderCouponInfo", "<init>", "(ILcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;IZLjava/lang/String;JLcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class CalculateOrderPriceResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int quantity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final OrderSubmitPriceInfo priceInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int maxQuantity;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isExceedLimit;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String exceedLimitMsg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final long originUnitPrice;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECQshopOrderQuerySvr$CouponInfo orderCouponInfo;

        public CalculateOrderPriceResult(int i3, OrderSubmitPriceInfo orderSubmitPriceInfo, int i16, boolean z16, String str, long j3, ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo) {
            this.quantity = i3;
            this.priceInfo = orderSubmitPriceInfo;
            this.maxQuantity = i16;
            this.isExceedLimit = z16;
            this.exceedLimitMsg = str;
            this.originUnitPrice = j3;
            this.orderCouponInfo = eCQshopOrderQuerySvr$CouponInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.quantity * 31;
            OrderSubmitPriceInfo orderSubmitPriceInfo = this.priceInfo;
            int hashCode = (((i3 + (orderSubmitPriceInfo != null ? orderSubmitPriceInfo.hashCode() : 0)) * 31) + this.maxQuantity) * 31;
            boolean z16 = this.isExceedLimit;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            String str = this.exceedLimitMsg;
            int hashCode2 = (((i17 + (str != null ? str.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.originUnitPrice)) * 31;
            ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo = this.orderCouponInfo;
            return hashCode2 + (eCQshopOrderQuerySvr$CouponInfo != null ? eCQshopOrderQuerySvr$CouponInfo.hashCode() : 0);
        }

        public String toString() {
            return "CalculateOrderPriceResult(quantity=" + this.quantity + ", priceInfo=" + this.priceInfo + ", maxQuantity=" + this.maxQuantity + ", isExceedLimit=" + this.isExceedLimit + ", exceedLimitMsg=" + this.exceedLimitMsg + ", originUnitPrice=" + this.originUnitPrice + ", orderCouponInfo=" + this.orderCouponInfo + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CalculateOrderPriceResult)) {
                return false;
            }
            CalculateOrderPriceResult calculateOrderPriceResult = (CalculateOrderPriceResult) other;
            return this.quantity == calculateOrderPriceResult.quantity && Intrinsics.areEqual(this.priceInfo, calculateOrderPriceResult.priceInfo) && this.maxQuantity == calculateOrderPriceResult.maxQuantity && this.isExceedLimit == calculateOrderPriceResult.isExceedLimit && Intrinsics.areEqual(this.exceedLimitMsg, calculateOrderPriceResult.exceedLimitMsg) && this.originUnitPrice == calculateOrderPriceResult.originUnitPrice && Intrinsics.areEqual(this.orderCouponInfo, calculateOrderPriceResult.orderCouponInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/IECOrderSubmitRepo$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "uiData", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "b", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "originRsp", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class OrderSubmitDetailWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final OrderSubmitDetailInfo uiData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final ECQshopOrderQuerySvr$OrderPageDetailRsp originRsp;

        public OrderSubmitDetailWrapper(OrderSubmitDetailInfo orderSubmitDetailInfo, ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp) {
            this.uiData = orderSubmitDetailInfo;
            this.originRsp = eCQshopOrderQuerySvr$OrderPageDetailRsp;
        }

        public int hashCode() {
            OrderSubmitDetailInfo orderSubmitDetailInfo = this.uiData;
            int hashCode = (orderSubmitDetailInfo != null ? orderSubmitDetailInfo.hashCode() : 0) * 31;
            ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp = this.originRsp;
            return hashCode + (eCQshopOrderQuerySvr$OrderPageDetailRsp != null ? eCQshopOrderQuerySvr$OrderPageDetailRsp.hashCode() : 0);
        }

        public String toString() {
            return "OrderSubmitDetailWrapper(uiData=" + this.uiData + ", originRsp=" + this.originRsp + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OrderSubmitDetailWrapper)) {
                return false;
            }
            OrderSubmitDetailWrapper orderSubmitDetailWrapper = (OrderSubmitDetailWrapper) other;
            return Intrinsics.areEqual(this.uiData, orderSubmitDetailWrapper.uiData) && Intrinsics.areEqual(this.originRsp, orderSubmitDetailWrapper.originRsp);
        }
    }
}
