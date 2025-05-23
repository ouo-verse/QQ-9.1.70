package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "enableShowApplyRefund", "b", "enableShowRefundDetail", "c", "enableShowApplyAfterSales", "d", "enableShowAfterSalesDetail", "e", "enableShowPlatformService", "f", "Ljava/lang/String;", "applyRefundOrAfterSalesLink", "g", "goToRefundOrAfterSalesDetailLink", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", tl.h.F, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;", "applyAfterSalesValidInfo", "<init>", "(ZZZZZLjava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/k;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.e, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECOrderDetailGoodsOperateState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableShowApplyRefund;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableShowRefundDetail;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableShowApplyAfterSales;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableShowAfterSalesDetail;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableShowPlatformService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String applyRefundOrAfterSalesLink;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String goToRefundOrAfterSalesDetailLink;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final OrderDetailCheckValidData applyAfterSalesValidInfo;

    public ECOrderDetailGoodsOperateState() {
        this(false, false, false, false, false, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.enableShowApplyRefund;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        ?? r26 = this.enableShowRefundDetail;
        int i16 = r26;
        if (r26 != 0) {
            i16 = 1;
        }
        int i17 = (i3 + i16) * 31;
        ?? r27 = this.enableShowApplyAfterSales;
        int i18 = r27;
        if (r27 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        ?? r28 = this.enableShowAfterSalesDetail;
        int i26 = r28;
        if (r28 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        boolean z17 = this.enableShowPlatformService;
        int i28 = (i27 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        String str = this.applyRefundOrAfterSalesLink;
        int hashCode = (i28 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.goToRefundOrAfterSalesDetailLink;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        OrderDetailCheckValidData orderDetailCheckValidData = this.applyAfterSalesValidInfo;
        return hashCode2 + (orderDetailCheckValidData != null ? orderDetailCheckValidData.hashCode() : 0);
    }

    public String toString() {
        return "ECOrderDetailGoodsOperateState(enableShowApplyRefund=" + this.enableShowApplyRefund + ", enableShowRefundDetail=" + this.enableShowRefundDetail + ", enableShowApplyAfterSales=" + this.enableShowApplyAfterSales + ", enableShowAfterSalesDetail=" + this.enableShowAfterSalesDetail + ", enableShowPlatformService=" + this.enableShowPlatformService + ", applyRefundOrAfterSalesLink=" + this.applyRefundOrAfterSalesLink + ", goToRefundOrAfterSalesDetailLink=" + this.goToRefundOrAfterSalesDetailLink + ", applyAfterSalesValidInfo=" + this.applyAfterSalesValidInfo + ")";
    }

    public ECOrderDetailGoodsOperateState(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, String str, String str2, OrderDetailCheckValidData orderDetailCheckValidData) {
        this.enableShowApplyRefund = z16;
        this.enableShowRefundDetail = z17;
        this.enableShowApplyAfterSales = z18;
        this.enableShowAfterSalesDetail = z19;
        this.enableShowPlatformService = z26;
        this.applyRefundOrAfterSalesLink = str;
        this.goToRefundOrAfterSalesDetailLink = str2;
        this.applyAfterSalesValidInfo = orderDetailCheckValidData;
    }

    public /* synthetic */ ECOrderDetailGoodsOperateState(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, String str, String str2, OrderDetailCheckValidData orderDetailCheckValidData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18, (i3 & 8) != 0 ? false : z19, (i3 & 16) == 0 ? z26 : false, (i3 & 32) != 0 ? "" : str, (i3 & 64) == 0 ? str2 : "", (i3 & 128) != 0 ? null : orderDetailCheckValidData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECOrderDetailGoodsOperateState)) {
            return false;
        }
        ECOrderDetailGoodsOperateState eCOrderDetailGoodsOperateState = (ECOrderDetailGoodsOperateState) other;
        return this.enableShowApplyRefund == eCOrderDetailGoodsOperateState.enableShowApplyRefund && this.enableShowRefundDetail == eCOrderDetailGoodsOperateState.enableShowRefundDetail && this.enableShowApplyAfterSales == eCOrderDetailGoodsOperateState.enableShowApplyAfterSales && this.enableShowAfterSalesDetail == eCOrderDetailGoodsOperateState.enableShowAfterSalesDetail && this.enableShowPlatformService == eCOrderDetailGoodsOperateState.enableShowPlatformService && Intrinsics.areEqual(this.applyRefundOrAfterSalesLink, eCOrderDetailGoodsOperateState.applyRefundOrAfterSalesLink) && Intrinsics.areEqual(this.goToRefundOrAfterSalesDetailLink, eCOrderDetailGoodsOperateState.goToRefundOrAfterSalesDetailLink) && Intrinsics.areEqual(this.applyAfterSalesValidInfo, eCOrderDetailGoodsOperateState.applyAfterSalesValidInfo);
    }
}
