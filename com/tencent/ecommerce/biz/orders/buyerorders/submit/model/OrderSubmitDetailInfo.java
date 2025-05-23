package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$LabelInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B\u00a9\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\b\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b9\u0010:J\u00b7\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u001c\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u00d6\u0001J\u0013\u0010 \u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010*R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010!R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010!R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010!R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\b8\u0006\u00a2\u0006\f\n\u0004\b6\u0010'\u001a\u0004\b&\u0010)R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b$\u0010)R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010!\u00a8\u0006;"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/f;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "orderSkusDetail", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "supportPayType", "selectedPayType", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;", "priceInfo", "Lcom/tencent/ecommerce/biz/orders/common/a;", "bulletinInfo", "", "enableCoupon", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "couponInfo", "blindBoxAgreementVersion", "qShopProductAgreementVersion", "qShopPrivacyAgreementVersion", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$LabelInfo;", "goodsLabelInfoList", "boxOrderIds", "deliveryMessage", "a", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "b", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "d", "Ljava/util/List;", "e", "()Ljava/util/List;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "f", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;", "g", "Lcom/tencent/ecommerce/biz/orders/common/a;", tl.h.F, "Z", "i", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;Ljava/util/List;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/h;Lcom/tencent/ecommerce/biz/orders/common/a;ZLcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.f, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OrderSubmitDetailInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECAddress address;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final OrderSkuDetail orderSkusDetail;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<PayType> supportPayType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final PayType selectedPayType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final OrderSubmitPriceInfo priceInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final BulletinInfo bulletinInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableCoupon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECQshopOrderQuerySvr$CouponInfo couponInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final String blindBoxAgreementVersion;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final String qShopProductAgreementVersion;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    public final String qShopPrivacyAgreementVersion;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ECOrderInfo$LabelInfo> goodsLabelInfoList;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> boxOrderIds;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    public final String deliveryMessage;

    /* JADX WARN: Multi-variable type inference failed */
    public OrderSubmitDetailInfo(String str, ECAddress eCAddress, OrderSkuDetail orderSkuDetail, List<? extends PayType> list, PayType payType, OrderSubmitPriceInfo orderSubmitPriceInfo, BulletinInfo bulletinInfo, boolean z16, ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo, String str2, String str3, String str4, List<ECOrderInfo$LabelInfo> list2, List<String> list3, String str5) {
        this.orderId = str;
        this.address = eCAddress;
        this.orderSkusDetail = orderSkuDetail;
        this.supportPayType = list;
        this.selectedPayType = payType;
        this.priceInfo = orderSubmitPriceInfo;
        this.bulletinInfo = bulletinInfo;
        this.enableCoupon = z16;
        this.couponInfo = eCQshopOrderQuerySvr$CouponInfo;
        this.blindBoxAgreementVersion = str2;
        this.qShopProductAgreementVersion = str3;
        this.qShopPrivacyAgreementVersion = str4;
        this.goodsLabelInfoList = list2;
        this.boxOrderIds = list3;
        this.deliveryMessage = str5;
    }

    public static /* synthetic */ OrderSubmitDetailInfo b(OrderSubmitDetailInfo orderSubmitDetailInfo, String str, ECAddress eCAddress, OrderSkuDetail orderSkuDetail, List list, PayType payType, OrderSubmitPriceInfo orderSubmitPriceInfo, BulletinInfo bulletinInfo, boolean z16, ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo, String str2, String str3, String str4, List list2, List list3, String str5, int i3, Object obj) {
        return orderSubmitDetailInfo.a((i3 & 1) != 0 ? orderSubmitDetailInfo.orderId : str, (i3 & 2) != 0 ? orderSubmitDetailInfo.address : eCAddress, (i3 & 4) != 0 ? orderSubmitDetailInfo.orderSkusDetail : orderSkuDetail, (i3 & 8) != 0 ? orderSubmitDetailInfo.supportPayType : list, (i3 & 16) != 0 ? orderSubmitDetailInfo.selectedPayType : payType, (i3 & 32) != 0 ? orderSubmitDetailInfo.priceInfo : orderSubmitPriceInfo, (i3 & 64) != 0 ? orderSubmitDetailInfo.bulletinInfo : bulletinInfo, (i3 & 128) != 0 ? orderSubmitDetailInfo.enableCoupon : z16, (i3 & 256) != 0 ? orderSubmitDetailInfo.couponInfo : eCQshopOrderQuerySvr$CouponInfo, (i3 & 512) != 0 ? orderSubmitDetailInfo.blindBoxAgreementVersion : str2, (i3 & 1024) != 0 ? orderSubmitDetailInfo.qShopProductAgreementVersion : str3, (i3 & 2048) != 0 ? orderSubmitDetailInfo.qShopPrivacyAgreementVersion : str4, (i3 & 4096) != 0 ? orderSubmitDetailInfo.goodsLabelInfoList : list2, (i3 & 8192) != 0 ? orderSubmitDetailInfo.boxOrderIds : list3, (i3 & 16384) != 0 ? orderSubmitDetailInfo.deliveryMessage : str5);
    }

    public final OrderSubmitDetailInfo a(String orderId, ECAddress address, OrderSkuDetail orderSkusDetail, List<? extends PayType> supportPayType, PayType selectedPayType, OrderSubmitPriceInfo priceInfo, BulletinInfo bulletinInfo, boolean enableCoupon, ECQshopOrderQuerySvr$CouponInfo couponInfo, String blindBoxAgreementVersion, String qShopProductAgreementVersion, String qShopPrivacyAgreementVersion, List<ECOrderInfo$LabelInfo> goodsLabelInfoList, List<String> boxOrderIds, String deliveryMessage) {
        return new OrderSubmitDetailInfo(orderId, address, orderSkusDetail, supportPayType, selectedPayType, priceInfo, bulletinInfo, enableCoupon, couponInfo, blindBoxAgreementVersion, qShopProductAgreementVersion, qShopPrivacyAgreementVersion, goodsLabelInfoList, boxOrderIds, deliveryMessage);
    }

    public final List<String> c() {
        return this.boxOrderIds;
    }

    public final List<ECOrderInfo$LabelInfo> d() {
        return this.goodsLabelInfoList;
    }

    public final List<PayType> e() {
        return this.supportPayType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.orderId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ECAddress eCAddress = this.address;
        int hashCode2 = (hashCode + (eCAddress != null ? eCAddress.hashCode() : 0)) * 31;
        OrderSkuDetail orderSkuDetail = this.orderSkusDetail;
        int hashCode3 = (hashCode2 + (orderSkuDetail != null ? orderSkuDetail.hashCode() : 0)) * 31;
        List<PayType> list = this.supportPayType;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        PayType payType = this.selectedPayType;
        int hashCode5 = (hashCode4 + (payType != null ? payType.hashCode() : 0)) * 31;
        OrderSubmitPriceInfo orderSubmitPriceInfo = this.priceInfo;
        int hashCode6 = (hashCode5 + (orderSubmitPriceInfo != null ? orderSubmitPriceInfo.hashCode() : 0)) * 31;
        BulletinInfo bulletinInfo = this.bulletinInfo;
        int hashCode7 = (hashCode6 + (bulletinInfo != null ? bulletinInfo.hashCode() : 0)) * 31;
        boolean z16 = this.enableCoupon;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode7 + i3) * 31;
        ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo = this.couponInfo;
        int hashCode8 = (i16 + (eCQshopOrderQuerySvr$CouponInfo != null ? eCQshopOrderQuerySvr$CouponInfo.hashCode() : 0)) * 31;
        String str2 = this.blindBoxAgreementVersion;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.qShopProductAgreementVersion;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.qShopPrivacyAgreementVersion;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<ECOrderInfo$LabelInfo> list2 = this.goodsLabelInfoList;
        int hashCode12 = (hashCode11 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.boxOrderIds;
        int hashCode13 = (hashCode12 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str5 = this.deliveryMessage;
        return hashCode13 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "OrderSubmitDetailInfo(orderId=" + this.orderId + ", address=" + this.address + ", orderSkusDetail=" + this.orderSkusDetail + ", supportPayType=" + this.supportPayType + ", selectedPayType=" + this.selectedPayType + ", priceInfo=" + this.priceInfo + ", bulletinInfo=" + this.bulletinInfo + ", enableCoupon=" + this.enableCoupon + ", couponInfo=" + this.couponInfo + ", blindBoxAgreementVersion=" + this.blindBoxAgreementVersion + ", qShopProductAgreementVersion=" + this.qShopProductAgreementVersion + ", qShopPrivacyAgreementVersion=" + this.qShopPrivacyAgreementVersion + ", goodsLabelInfoList=" + this.goodsLabelInfoList + ", boxOrderIds=" + this.boxOrderIds + ", deliveryMessage=" + this.deliveryMessage + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderSubmitDetailInfo)) {
            return false;
        }
        OrderSubmitDetailInfo orderSubmitDetailInfo = (OrderSubmitDetailInfo) other;
        return Intrinsics.areEqual(this.orderId, orderSubmitDetailInfo.orderId) && Intrinsics.areEqual(this.address, orderSubmitDetailInfo.address) && Intrinsics.areEqual(this.orderSkusDetail, orderSubmitDetailInfo.orderSkusDetail) && Intrinsics.areEqual(this.supportPayType, orderSubmitDetailInfo.supportPayType) && Intrinsics.areEqual(this.selectedPayType, orderSubmitDetailInfo.selectedPayType) && Intrinsics.areEqual(this.priceInfo, orderSubmitDetailInfo.priceInfo) && Intrinsics.areEqual(this.bulletinInfo, orderSubmitDetailInfo.bulletinInfo) && this.enableCoupon == orderSubmitDetailInfo.enableCoupon && Intrinsics.areEqual(this.couponInfo, orderSubmitDetailInfo.couponInfo) && Intrinsics.areEqual(this.blindBoxAgreementVersion, orderSubmitDetailInfo.blindBoxAgreementVersion) && Intrinsics.areEqual(this.qShopProductAgreementVersion, orderSubmitDetailInfo.qShopProductAgreementVersion) && Intrinsics.areEqual(this.qShopPrivacyAgreementVersion, orderSubmitDetailInfo.qShopPrivacyAgreementVersion) && Intrinsics.areEqual(this.goodsLabelInfoList, orderSubmitDetailInfo.goodsLabelInfoList) && Intrinsics.areEqual(this.boxOrderIds, orderSubmitDetailInfo.boxOrderIds) && Intrinsics.areEqual(this.deliveryMessage, orderSubmitDetailInfo.deliveryMessage);
    }
}
