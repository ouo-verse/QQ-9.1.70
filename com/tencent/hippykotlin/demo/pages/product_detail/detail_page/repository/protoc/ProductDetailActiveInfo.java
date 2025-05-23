package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailActiveInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final int activeDetailStatus;
    public final int activeDiscountStatus;
    public final String activeId;
    public final ProductDetailActivePrice activePrice;
    public final int activeType;
    public final ProductDetailDetailSelling detailSelling;
    public final ProductDetailActivePrice livePrice;
    public final ProductDetailActiveSales liveSales;
    public final ProductDetailActiveStock liveStock;
    public final ProductDetailActiveTimeRange liveTimeRange;

    public ProductDetailActiveInfo() {
        this(null, 0, 0, 0, null, null, null, null, null, null, 1023, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("active_id", this.activeId);
        eVar.t("active_type", this.activeType);
        eVar.t("active_detail_status", this.activeDetailStatus);
        eVar.t("active_discount_status", this.activeDiscountStatus);
        ProductDetailActivePrice productDetailActivePrice = this.activePrice;
        if (productDetailActivePrice != null) {
            eVar.v("active_price", productDetailActivePrice.encode());
        }
        ProductDetailActivePrice productDetailActivePrice2 = this.livePrice;
        if (productDetailActivePrice2 != null) {
            eVar.v("live_price", productDetailActivePrice2.encode());
        }
        ProductDetailActiveSales productDetailActiveSales = this.liveSales;
        if (productDetailActiveSales != null) {
            eVar.v("live_sales", productDetailActiveSales.encode());
        }
        ProductDetailActiveStock productDetailActiveStock = this.liveStock;
        if (productDetailActiveStock != null) {
            eVar.v("live_stock", productDetailActiveStock.encode());
        }
        ProductDetailActiveTimeRange productDetailActiveTimeRange = this.liveTimeRange;
        if (productDetailActiveTimeRange != null) {
            eVar.v("live_time_range", productDetailActiveTimeRange.encode());
        }
        ProductDetailDetailSelling productDetailDetailSelling = this.detailSelling;
        if (productDetailDetailSelling != null) {
            eVar.v("detail_selling", productDetailDetailSelling.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.activeDiscountStatus, QQAudioParams$$ExternalSyntheticOutline0.m(this.activeDetailStatus, QQAudioParams$$ExternalSyntheticOutline0.m(this.activeType, this.activeId.hashCode() * 31, 31), 31), 31);
        ProductDetailActivePrice productDetailActivePrice = this.activePrice;
        int hashCode = (m3 + (productDetailActivePrice == null ? 0 : productDetailActivePrice.hashCode())) * 31;
        ProductDetailActivePrice productDetailActivePrice2 = this.livePrice;
        int hashCode2 = (hashCode + (productDetailActivePrice2 == null ? 0 : productDetailActivePrice2.hashCode())) * 31;
        ProductDetailActiveSales productDetailActiveSales = this.liveSales;
        int hashCode3 = (hashCode2 + (productDetailActiveSales == null ? 0 : productDetailActiveSales.hashCode())) * 31;
        ProductDetailActiveStock productDetailActiveStock = this.liveStock;
        int hashCode4 = (hashCode3 + (productDetailActiveStock == null ? 0 : productDetailActiveStock.hashCode())) * 31;
        ProductDetailActiveTimeRange productDetailActiveTimeRange = this.liveTimeRange;
        int hashCode5 = (hashCode4 + (productDetailActiveTimeRange == null ? 0 : productDetailActiveTimeRange.hashCode())) * 31;
        ProductDetailDetailSelling productDetailDetailSelling = this.detailSelling;
        return hashCode5 + (productDetailDetailSelling != null ? productDetailDetailSelling.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailActiveInfo(activeId=");
        m3.append(this.activeId);
        m3.append(", activeType=");
        m3.append(this.activeType);
        m3.append(", activeDetailStatus=");
        m3.append(this.activeDetailStatus);
        m3.append(", activeDiscountStatus=");
        m3.append(this.activeDiscountStatus);
        m3.append(", activePrice=");
        m3.append(this.activePrice);
        m3.append(", livePrice=");
        m3.append(this.livePrice);
        m3.append(", liveSales=");
        m3.append(this.liveSales);
        m3.append(", liveStock=");
        m3.append(this.liveStock);
        m3.append(", liveTimeRange=");
        m3.append(this.liveTimeRange);
        m3.append(", detailSelling=");
        m3.append(this.detailSelling);
        m3.append(')');
        return m3.toString();
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final ProductDetailActiveInfo decode(e eVar) {
            long j3;
            ProductDetailActiveSales productDetailActiveSales;
            ProductDetailActiveSales productDetailActiveSales2;
            ProductDetailActiveStock productDetailActiveStock;
            long j16;
            ProductDetailActiveTimeRange productDetailActiveTimeRange;
            String q16 = eVar.q("active_id", "");
            int k3 = eVar.k("active_type", 0);
            int k16 = eVar.k("active_detail_status", 0);
            int k17 = eVar.k("active_discount_status", 0);
            e m3 = eVar.m("active_price");
            ProductDetailActivePrice productDetailActivePrice = m3 != null ? new ProductDetailActivePrice(m3.o(Element.ELEMENT_NAME_MIN, 0L), m3.o("max", 0L), m3.o("original", 0L), m3.q("discount_price_txt", ""), m3.q("discount_price_desc", ""), m3.o("live", 0L), m3.o("live_special", 0L)) : null;
            e m16 = eVar.m("live_price");
            ProductDetailActivePrice productDetailActivePrice2 = m16 != null ? new ProductDetailActivePrice(m16.o(Element.ELEMENT_NAME_MIN, 0L), m16.o("max", 0L), m16.o("original", 0L), m16.q("discount_price_txt", ""), m16.q("discount_price_desc", ""), m16.o("live", 0L), m16.o("live_special", 0L)) : null;
            e m17 = eVar.m("live_sales");
            if (m17 != null) {
                j3 = 0;
                productDetailActiveSales = new ProductDetailActiveSales(m17.o("sale_nums", 0L), m17.q("sales_nums_txt", ""));
            } else {
                j3 = 0;
                productDetailActiveSales = null;
            }
            e m18 = eVar.m("live_stock");
            ProductDetailActiveStock productDetailActiveStock2 = m18 != null ? new ProductDetailActiveStock(m18.o("total", j3), m18.o("remain", j3), m18.o("active", j3), m18.q("remain_txt", "")) : null;
            e m19 = eVar.m("live_time_range");
            if (m19 != null) {
                j16 = 0;
                productDetailActiveSales2 = productDetailActiveSales;
                productDetailActiveStock = productDetailActiveStock2;
                productDetailActiveTimeRange = new ProductDetailActiveTimeRange(m19.o("begin", 0L), m19.o("end", 0L));
            } else {
                productDetailActiveSales2 = productDetailActiveSales;
                productDetailActiveStock = productDetailActiveStock2;
                j16 = 0;
                productDetailActiveTimeRange = null;
            }
            e m26 = eVar.m("detail_selling");
            return new ProductDetailActiveInfo(q16, k3, k16, k17, productDetailActivePrice, productDetailActivePrice2, productDetailActiveSales2, productDetailActiveStock, productDetailActiveTimeRange, m26 != null ? new ProductDetailDetailSelling(m26.q("label", ""), m26.o("time_limit", j16), m26.q("hot_icon", "")) : null);
        }
    }

    public ProductDetailActiveInfo(String str, int i3, int i16, int i17, ProductDetailActivePrice productDetailActivePrice, ProductDetailActivePrice productDetailActivePrice2, ProductDetailActiveSales productDetailActiveSales, ProductDetailActiveStock productDetailActiveStock, ProductDetailActiveTimeRange productDetailActiveTimeRange, ProductDetailDetailSelling productDetailDetailSelling) {
        this.activeId = str;
        this.activeType = i3;
        this.activeDetailStatus = i16;
        this.activeDiscountStatus = i17;
        this.activePrice = productDetailActivePrice;
        this.livePrice = productDetailActivePrice2;
        this.liveSales = productDetailActiveSales;
        this.liveStock = productDetailActiveStock;
        this.liveTimeRange = productDetailActiveTimeRange;
        this.detailSelling = productDetailDetailSelling;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailActiveInfo)) {
            return false;
        }
        ProductDetailActiveInfo productDetailActiveInfo = (ProductDetailActiveInfo) obj;
        return Intrinsics.areEqual(this.activeId, productDetailActiveInfo.activeId) && this.activeType == productDetailActiveInfo.activeType && this.activeDetailStatus == productDetailActiveInfo.activeDetailStatus && this.activeDiscountStatus == productDetailActiveInfo.activeDiscountStatus && Intrinsics.areEqual(this.activePrice, productDetailActiveInfo.activePrice) && Intrinsics.areEqual(this.livePrice, productDetailActiveInfo.livePrice) && Intrinsics.areEqual(this.liveSales, productDetailActiveInfo.liveSales) && Intrinsics.areEqual(this.liveStock, productDetailActiveInfo.liveStock) && Intrinsics.areEqual(this.liveTimeRange, productDetailActiveInfo.liveTimeRange) && Intrinsics.areEqual(this.detailSelling, productDetailActiveInfo.detailSelling);
    }

    public /* synthetic */ ProductDetailActiveInfo(String str, int i3, int i16, int i17, ProductDetailActivePrice productDetailActivePrice, ProductDetailActivePrice productDetailActivePrice2, ProductDetailActiveSales productDetailActiveSales, ProductDetailActiveStock productDetailActiveStock, ProductDetailActiveTimeRange productDetailActiveTimeRange, ProductDetailDetailSelling productDetailDetailSelling, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0, 0, null, null, null, null, null, null);
    }
}
