package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$LabelInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/o;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "b", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;", "orderGoodInfo", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "c", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "couponInfo", "", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_order_info/ECOrderInfo$LabelInfo;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "goodsLabelInfoList", "e", "Ljava/lang/String;", "deliveryMessage", "f", "Z", "isBuyAll", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/c;Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;Ljava/util/List;Ljava/lang/String;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.o, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class OrderItemData extends p {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final OrderSkuDetail orderGoodInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final ECQshopOrderQuerySvr$CouponInfo couponInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ECOrderInfo$LabelInfo> goodsLabelInfoList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String deliveryMessage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isBuyAll;

    public /* synthetic */ OrderItemData(OrderSkuDetail orderSkuDetail, ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo, List list, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(orderSkuDetail, (i3 & 2) != 0 ? null : eCQshopOrderQuerySvr$CouponInfo, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? false : z16);
    }

    public final List<ECOrderInfo$LabelInfo> a() {
        return this.goodsLabelInfoList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        OrderSkuDetail orderSkuDetail = this.orderGoodInfo;
        int hashCode = (orderSkuDetail != null ? orderSkuDetail.hashCode() : 0) * 31;
        ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo = this.couponInfo;
        int hashCode2 = (hashCode + (eCQshopOrderQuerySvr$CouponInfo != null ? eCQshopOrderQuerySvr$CouponInfo.hashCode() : 0)) * 31;
        List<ECOrderInfo$LabelInfo> list = this.goodsLabelInfoList;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.deliveryMessage;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z16 = this.isBuyAll;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public String toString() {
        return "OrderItemData(orderGoodInfo=" + this.orderGoodInfo + ", couponInfo=" + this.couponInfo + ", goodsLabelInfoList=" + this.goodsLabelInfoList + ", deliveryMessage=" + this.deliveryMessage + ", isBuyAll=" + this.isBuyAll + ")";
    }

    public OrderItemData(OrderSkuDetail orderSkuDetail, ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo, List<ECOrderInfo$LabelInfo> list, String str, boolean z16) {
        super(2, null);
        this.orderGoodInfo = orderSkuDetail;
        this.couponInfo = eCQshopOrderQuerySvr$CouponInfo;
        this.goodsLabelInfoList = list;
        this.deliveryMessage = str;
        this.isBuyAll = z16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderItemData)) {
            return false;
        }
        OrderItemData orderItemData = (OrderItemData) other;
        return Intrinsics.areEqual(this.orderGoodInfo, orderItemData.orderGoodInfo) && Intrinsics.areEqual(this.couponInfo, orderItemData.couponInfo) && Intrinsics.areEqual(this.goodsLabelInfoList, orderItemData.goodsLabelInfoList) && Intrinsics.areEqual(this.deliveryMessage, orderItemData.deliveryMessage) && this.isBuyAll == orderItemData.isBuyAll;
    }
}
