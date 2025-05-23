package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailActiveSku implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ProductDetailBuyLimit activeLimit;
    public final ProductDetailActivePrice activePrice;
    public final ProductDetailActiveStock activeStock;
    public final ProductDetailBuyLimit liveLimit;
    public final ProductDetailActivePrice livePrice;
    public final ProductDetailActiveStock liveStock;

    public ProductDetailActiveSku() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        ProductDetailActivePrice productDetailActivePrice = this.livePrice;
        if (productDetailActivePrice != null) {
            eVar.v("live_price", productDetailActivePrice.encode());
        }
        ProductDetailActiveStock productDetailActiveStock = this.liveStock;
        if (productDetailActiveStock != null) {
            eVar.v("live_stock", productDetailActiveStock.encode());
        }
        ProductDetailBuyLimit productDetailBuyLimit = this.liveLimit;
        if (productDetailBuyLimit != null) {
            eVar.v("live_limit", productDetailBuyLimit.encode());
        }
        ProductDetailActivePrice productDetailActivePrice2 = this.activePrice;
        if (productDetailActivePrice2 != null) {
            eVar.v("active_price", productDetailActivePrice2.encode());
        }
        ProductDetailBuyLimit productDetailBuyLimit2 = this.activeLimit;
        if (productDetailBuyLimit2 != null) {
            eVar.v("active_limit", productDetailBuyLimit2.encode());
        }
        ProductDetailActiveStock productDetailActiveStock2 = this.activeStock;
        if (productDetailActiveStock2 != null) {
            eVar.v("active_stock", productDetailActiveStock2.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        ProductDetailActivePrice productDetailActivePrice = this.livePrice;
        int hashCode = (productDetailActivePrice == null ? 0 : productDetailActivePrice.hashCode()) * 31;
        ProductDetailActiveStock productDetailActiveStock = this.liveStock;
        int hashCode2 = (hashCode + (productDetailActiveStock == null ? 0 : productDetailActiveStock.hashCode())) * 31;
        ProductDetailBuyLimit productDetailBuyLimit = this.liveLimit;
        int hashCode3 = (hashCode2 + (productDetailBuyLimit == null ? 0 : productDetailBuyLimit.hashCode())) * 31;
        ProductDetailActivePrice productDetailActivePrice2 = this.activePrice;
        int hashCode4 = (hashCode3 + (productDetailActivePrice2 == null ? 0 : productDetailActivePrice2.hashCode())) * 31;
        ProductDetailBuyLimit productDetailBuyLimit2 = this.activeLimit;
        int hashCode5 = (hashCode4 + (productDetailBuyLimit2 == null ? 0 : productDetailBuyLimit2.hashCode())) * 31;
        ProductDetailActiveStock productDetailActiveStock2 = this.activeStock;
        return hashCode5 + (productDetailActiveStock2 != null ? productDetailActiveStock2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailActiveSku(livePrice=");
        m3.append(this.livePrice);
        m3.append(", liveStock=");
        m3.append(this.liveStock);
        m3.append(", liveLimit=");
        m3.append(this.liveLimit);
        m3.append(", activePrice=");
        m3.append(this.activePrice);
        m3.append(", activeLimit=");
        m3.append(this.activeLimit);
        m3.append(", activeStock=");
        m3.append(this.activeStock);
        m3.append(')');
        return m3.toString();
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final ProductDetailActiveSku decode(e eVar) {
            e m3 = eVar.m("live_price");
            ProductDetailActivePrice productDetailActivePrice = m3 != null ? new ProductDetailActivePrice(m3.o(Element.ELEMENT_NAME_MIN, 0L), m3.o("max", 0L), m3.o("original", 0L), m3.q("discount_price_txt", ""), m3.q("discount_price_desc", ""), m3.o("live", 0L), m3.o("live_special", 0L)) : null;
            e m16 = eVar.m("live_stock");
            ProductDetailActiveStock productDetailActiveStock = m16 != null ? new ProductDetailActiveStock(m16.o("total", 0L), m16.o("remain", 0L), m16.o("active", 0L), m16.q("remain_txt", "")) : null;
            e m17 = eVar.m("live_limit");
            ProductDetailBuyLimit productDetailBuyLimit = m17 != null ? new ProductDetailBuyLimit(m17.k("user_daily_limit", 0)) : null;
            e m18 = eVar.m("active_price");
            ProductDetailActivePrice productDetailActivePrice2 = m18 != null ? new ProductDetailActivePrice(m18.o(Element.ELEMENT_NAME_MIN, 0L), m18.o("max", 0L), m18.o("original", 0L), m18.q("discount_price_txt", ""), m18.q("discount_price_desc", ""), m18.o("live", 0L), m18.o("live_special", 0L)) : null;
            e m19 = eVar.m("active_limit");
            ProductDetailBuyLimit productDetailBuyLimit2 = m19 != null ? new ProductDetailBuyLimit(m19.k("user_daily_limit", 0)) : null;
            e m26 = eVar.m("active_stock");
            return new ProductDetailActiveSku(productDetailActivePrice, productDetailActiveStock, productDetailBuyLimit, productDetailActivePrice2, productDetailBuyLimit2, m26 != null ? new ProductDetailActiveStock(m26.o("total", 0L), m26.o("remain", 0L), m26.o("active", 0L), m26.q("remain_txt", "")) : null);
        }
    }

    public ProductDetailActiveSku(ProductDetailActivePrice productDetailActivePrice, ProductDetailActiveStock productDetailActiveStock, ProductDetailBuyLimit productDetailBuyLimit, ProductDetailActivePrice productDetailActivePrice2, ProductDetailBuyLimit productDetailBuyLimit2, ProductDetailActiveStock productDetailActiveStock2) {
        this.livePrice = productDetailActivePrice;
        this.liveStock = productDetailActiveStock;
        this.liveLimit = productDetailBuyLimit;
        this.activePrice = productDetailActivePrice2;
        this.activeLimit = productDetailBuyLimit2;
        this.activeStock = productDetailActiveStock2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailActiveSku)) {
            return false;
        }
        ProductDetailActiveSku productDetailActiveSku = (ProductDetailActiveSku) obj;
        return Intrinsics.areEqual(this.livePrice, productDetailActiveSku.livePrice) && Intrinsics.areEqual(this.liveStock, productDetailActiveSku.liveStock) && Intrinsics.areEqual(this.liveLimit, productDetailActiveSku.liveLimit) && Intrinsics.areEqual(this.activePrice, productDetailActiveSku.activePrice) && Intrinsics.areEqual(this.activeLimit, productDetailActiveSku.activeLimit) && Intrinsics.areEqual(this.activeStock, productDetailActiveSku.activeStock);
    }

    public /* synthetic */ ProductDetailActiveSku(ProductDetailActivePrice productDetailActivePrice, ProductDetailActiveStock productDetailActiveStock, ProductDetailBuyLimit productDetailBuyLimit, ProductDetailActivePrice productDetailActivePrice2, ProductDetailBuyLimit productDetailBuyLimit2, ProductDetailActiveStock productDetailActiveStock2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, null);
    }
}
