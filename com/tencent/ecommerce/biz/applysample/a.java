package com.tencent.ecommerce.biz.applysample;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.b;
import com.tencent.ecommerce.biz.common.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/a;", "", "Lcom/tencent/ecommerce/biz/applysample/a$a;", "productData", "", "b", "", "reasonId", "", "addedInfo", "", "hasUploadPhoto", "c", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "isConfirmBtnClick", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f101341a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\t\u0010\u0005\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/applysample/a$a;", "", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "shopId", "b", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "c", "spuId", "d", "skuId", "e", "productName", "f", "priSortId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.applysample.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ProductData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String shopId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String orderId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String spuId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String skuId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final String productName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final String priSortId;

        public ProductData(String str, String str2, String str3, String str4, String str5, String str6) {
            this.shopId = str;
            this.orderId = str2;
            this.spuId = str3;
            this.skuId = str4;
            this.productName = str5;
            this.priSortId = str6;
        }

        public int hashCode() {
            String str = this.shopId;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.orderId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.spuId;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.skuId;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.productName;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.priSortId;
            return hashCode5 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            return "ProductData(shopId=" + this.shopId + ", orderId=" + this.orderId + ", spuId=" + this.spuId + ", skuId=" + this.skuId + ", productName=" + this.productName + ", priSortId=" + this.priSortId + ")";
        }

        public final Map<String, String> a() {
            Map<String, String> mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("shop_id", this.shopId), TuplesKt.to("order_id", this.orderId), TuplesKt.to("spu_id", this.spuId), TuplesKt.to("sku_id", this.skuId), TuplesKt.to("product_name", this.productName), TuplesKt.to("pri_sort_id", this.priSortId));
            return mapOf;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProductData)) {
                return false;
            }
            ProductData productData = (ProductData) other;
            return Intrinsics.areEqual(this.shopId, productData.shopId) && Intrinsics.areEqual(this.orderId, productData.orderId) && Intrinsics.areEqual(this.spuId, productData.spuId) && Intrinsics.areEqual(this.skuId, productData.skuId) && Intrinsics.areEqual(this.productName, productData.productName) && Intrinsics.areEqual(this.priSortId, productData.priSortId);
        }
    }

    a() {
    }

    public final void a(String orderId, boolean isConfirmBtnClick) {
        String str;
        e b16 = new e().b("order_id", orderId);
        if (isConfirmBtnClick) {
            str = "1";
        } else {
            str = "0";
        }
        IECDataReport.a.a(b.f100913b, "sample_order_close_popup_clk", b16.b("option", str).f(), false, 4, null);
    }

    public final void b(ProductData productData) {
        IECDataReport.a.a(b.f100913b, "sample_order_close_page_exp", new e().c(productData.a()).f(), false, 4, null);
    }

    public final void c(ProductData productData, int reasonId, String addedInfo, boolean hasUploadPhoto) {
        String str;
        e b16 = new e().c(productData.a()).b("reason", String.valueOf(reasonId)).b("added_info", addedInfo);
        if (hasUploadPhoto) {
            str = "1";
        } else {
            str = "0";
        }
        IECDataReport.a.a(b.f100913b, "sample_order_close_submit", b16.b("is_photo", str).f(), false, 4, null);
    }
}
