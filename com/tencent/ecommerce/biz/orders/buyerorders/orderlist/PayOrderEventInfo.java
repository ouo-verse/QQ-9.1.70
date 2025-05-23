package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "payParams", "b", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "c", "J", "priceInFen", "", "d", "Ljava/util/List;", "()Ljava/util/List;", "spuIds", "e", "I", "productType", "f", "payTypeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;II)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.i, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class PayOrderEventInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String payParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String orderId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long priceInFen;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> spuIds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final int productType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final int payTypeId;

    public PayOrderEventInfo(String str, String str2, long j3, List<String> list, int i3, int i16) {
        this.payParams = str;
        this.orderId = str2;
        this.priceInFen = j3;
        this.spuIds = list;
        this.productType = i3;
        this.payTypeId = i16;
    }

    public final List<String> a() {
        return this.spuIds;
    }

    public int hashCode() {
        String str = this.payParams;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderId;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.priceInFen)) * 31;
        List<String> list = this.spuIds;
        return ((((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.productType) * 31) + this.payTypeId;
    }

    public String toString() {
        return "PayOrderEventInfo(payParams=" + this.payParams + ", orderId=" + this.orderId + ", priceInFen=" + this.priceInFen + ", spuIds=" + this.spuIds + ", productType=" + this.productType + ", payTypeId=" + this.payTypeId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PayOrderEventInfo)) {
            return false;
        }
        PayOrderEventInfo payOrderEventInfo = (PayOrderEventInfo) other;
        return Intrinsics.areEqual(this.payParams, payOrderEventInfo.payParams) && Intrinsics.areEqual(this.orderId, payOrderEventInfo.orderId) && this.priceInFen == payOrderEventInfo.priceInFen && Intrinsics.areEqual(this.spuIds, payOrderEventInfo.spuIds) && this.productType == payOrderEventInfo.productType && this.payTypeId == payOrderEventInfo.payTypeId;
    }
}
