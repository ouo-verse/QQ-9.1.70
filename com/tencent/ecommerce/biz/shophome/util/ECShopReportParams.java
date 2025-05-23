package com.tencent.ecommerce.biz.shophome.util;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/util/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "role", "b", "shopId", "c", "source", "d", "()Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.shophome.util.d, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECShopReportParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String role;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shopId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String requestId;

    public ECShopReportParams(String str, String str2, String str3, String str4) {
        this.role = str;
        this.shopId = str2;
        this.source = str3;
        this.requestId = str4;
    }

    /* renamed from: a, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        String str = this.role;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.shopId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.source;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.requestId;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ECShopReportParams(role=" + this.role + ", shopId=" + this.shopId + ", source=" + this.source + ", requestId=" + this.requestId + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECShopReportParams)) {
            return false;
        }
        ECShopReportParams eCShopReportParams = (ECShopReportParams) other;
        return Intrinsics.areEqual(this.role, eCShopReportParams.role) && Intrinsics.areEqual(this.shopId, eCShopReportParams.shopId) && Intrinsics.areEqual(this.source, eCShopReportParams.source) && Intrinsics.areEqual(this.requestId, eCShopReportParams.requestId);
    }
}
