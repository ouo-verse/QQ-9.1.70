package com.tencent.ecommerce.biz.detail.utils;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B\u00a9\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0015\u0012\u0006\u0010*\u001a\u00020\u0015\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u0012\u0006\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0004\u00a2\u0006\u0004\b6\u00107J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0018\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0014\u0010 \u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\rR\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\rR\u0014\u0010$\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\rR\u0014\u0010&\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\rR\u0014\u0010(\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u0017R\u0014\u0010*\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u0017R\u0014\u0010,\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\rR\u0014\u0010.\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\rR\u0014\u00100\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\rR\u0014\u00102\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\rR\u0017\u00105\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b3\u0010\n\u001a\u0004\b\t\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/utils/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "pgType", "b", "Ljava/lang/String;", "shopId", "c", "spuId", "d", "roomId", "e", "busId", "", "f", "J", "uin", "g", "sellerId", h.F, "buyerId", "i", "duration", "j", "sassId", "k", "productId", "l", "productName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "priSortId", DomainData.DOMAIN_NAME, "productPrice", "o", "productSales", "p", GetAdInfoRequest.SOURCE_FROM, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "contendId", "r", "sealTransfer", ReportConstant.COSTREPORT_PREFIX, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "t", "()I", "role", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.detail.utils.a, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECDetailPageDuration {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int pgType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String spuId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String busId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final long uin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sellerId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final String buyerId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final String duration;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sassId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    public final String productName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final String priSortId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    public final long productPrice;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    public final long productSales;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sourceFrom;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    public final String contendId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sealTransfer;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    public final String requestId;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private final int role;

    public ECDetailPageDuration(int i3, String str, String str2, String str3, String str4, long j3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j16, long j17, String str12, String str13, String str14, String str15, int i16) {
        this.pgType = i3;
        this.shopId = str;
        this.spuId = str2;
        this.roomId = str3;
        this.busId = str4;
        this.uin = j3;
        this.sellerId = str5;
        this.buyerId = str6;
        this.duration = str7;
        this.sassId = str8;
        this.productId = str9;
        this.productName = str10;
        this.priSortId = str11;
        this.productPrice = j16;
        this.productSales = j17;
        this.sourceFrom = str12;
        this.contendId = str13;
        this.sealTransfer = str14;
        this.requestId = str15;
        this.role = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getRole() {
        return this.role;
    }

    public int hashCode() {
        int i3 = this.pgType * 31;
        String str = this.shopId;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.spuId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.roomId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.busId;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.uin)) * 31;
        String str5 = this.sellerId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.buyerId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.duration;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.sassId;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.productId;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.productName;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.priSortId;
        int hashCode11 = (((((hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.productPrice)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.productSales)) * 31;
        String str12 = this.sourceFrom;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.contendId;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.sealTransfer;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.requestId;
        return ((hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31) + this.role;
    }

    public String toString() {
        return "ECDetailPageDuration(pgType=" + this.pgType + ", shopId=" + this.shopId + ", spuId=" + this.spuId + ", roomId=" + this.roomId + ", busId=" + this.busId + ", uin=" + this.uin + ", sellerId=" + this.sellerId + ", buyerId=" + this.buyerId + ", duration=" + this.duration + ", sassId=" + this.sassId + ", productId=" + this.productId + ", productName=" + this.productName + ", priSortId=" + this.priSortId + ", productPrice=" + this.productPrice + ", productSales=" + this.productSales + ", sourceFrom=" + this.sourceFrom + ", contendId=" + this.contendId + ", sealTransfer=" + this.sealTransfer + ", requestId=" + this.requestId + ", role=" + this.role + ")";
    }

    public /* synthetic */ ECDetailPageDuration(int i3, String str, String str2, String str3, String str4, long j3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j16, long j17, String str12, String str13, String str14, String str15, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, str3, str4, j3, str5, str6, str7, str8, str9, str10, str11, j16, j17, str12, str13, str14, str15, (i17 & 524288) != 0 ? 1 : i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECDetailPageDuration)) {
            return false;
        }
        ECDetailPageDuration eCDetailPageDuration = (ECDetailPageDuration) other;
        return this.pgType == eCDetailPageDuration.pgType && Intrinsics.areEqual(this.shopId, eCDetailPageDuration.shopId) && Intrinsics.areEqual(this.spuId, eCDetailPageDuration.spuId) && Intrinsics.areEqual(this.roomId, eCDetailPageDuration.roomId) && Intrinsics.areEqual(this.busId, eCDetailPageDuration.busId) && this.uin == eCDetailPageDuration.uin && Intrinsics.areEqual(this.sellerId, eCDetailPageDuration.sellerId) && Intrinsics.areEqual(this.buyerId, eCDetailPageDuration.buyerId) && Intrinsics.areEqual(this.duration, eCDetailPageDuration.duration) && Intrinsics.areEqual(this.sassId, eCDetailPageDuration.sassId) && Intrinsics.areEqual(this.productId, eCDetailPageDuration.productId) && Intrinsics.areEqual(this.productName, eCDetailPageDuration.productName) && Intrinsics.areEqual(this.priSortId, eCDetailPageDuration.priSortId) && this.productPrice == eCDetailPageDuration.productPrice && this.productSales == eCDetailPageDuration.productSales && Intrinsics.areEqual(this.sourceFrom, eCDetailPageDuration.sourceFrom) && Intrinsics.areEqual(this.contendId, eCDetailPageDuration.contendId) && Intrinsics.areEqual(this.sealTransfer, eCDetailPageDuration.sealTransfer) && Intrinsics.areEqual(this.requestId, eCDetailPageDuration.requestId) && this.role == eCDetailPageDuration.role;
    }
}
