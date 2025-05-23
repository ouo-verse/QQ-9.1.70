package com.tencent.ecommerce.base.report.service;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/i;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "productId", "b", "saasType", "c", "I", "price", "d", "commission", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.base.report.service.i, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class ECRealtimeReportProductModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String productId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String saasType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int price;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int commission;

    public ECRealtimeReportProductModel(String str, String str2, int i3, int i16) {
        this.productId = str;
        this.saasType = str2;
        this.price = i3;
        this.commission = i16;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportDataBuilder.KEY_PRODUCT_ID, this.productId);
        jSONObject.put("saas_type", this.saasType);
        jSONObject.put("price", this.price);
        jSONObject.put("commission", this.commission);
        return jSONObject;
    }

    public int hashCode() {
        String str = this.productId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.saasType;
        return ((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.price) * 31) + this.commission;
    }

    public String toString() {
        return "ECRealtimeReportProductModel(productId=" + this.productId + ", saasType=" + this.saasType + ", price=" + this.price + ", commission=" + this.commission + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECRealtimeReportProductModel)) {
            return false;
        }
        ECRealtimeReportProductModel eCRealtimeReportProductModel = (ECRealtimeReportProductModel) other;
        return Intrinsics.areEqual(this.productId, eCRealtimeReportProductModel.productId) && Intrinsics.areEqual(this.saasType, eCRealtimeReportProductModel.saasType) && this.price == eCRealtimeReportProductModel.price && this.commission == eCRealtimeReportProductModel.commission;
    }
}
