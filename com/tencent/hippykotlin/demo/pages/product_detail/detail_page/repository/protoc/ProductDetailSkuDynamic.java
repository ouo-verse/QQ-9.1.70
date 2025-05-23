package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailSkuDynamic implements ISSOModel {
    public final ProductDetailBuyLimit buyLimit;
    public final String stock;
    public final long stockNums;

    public ProductDetailSkuDynamic() {
        this(null, 0L, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("stock", this.stock);
        eVar.u("stock_nums", this.stockNums);
        ProductDetailBuyLimit productDetailBuyLimit = this.buyLimit;
        if (productDetailBuyLimit != null) {
            eVar.v("buy_limit", productDetailBuyLimit.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.stockNums, this.stock.hashCode() * 31, 31);
        ProductDetailBuyLimit productDetailBuyLimit = this.buyLimit;
        return m3 + (productDetailBuyLimit == null ? 0 : productDetailBuyLimit.userDailyLimit);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailSkuDynamic(stock=");
        m3.append(this.stock);
        m3.append(", stockNums=");
        m3.append(this.stockNums);
        m3.append(", buyLimit=");
        m3.append(this.buyLimit);
        m3.append(')');
        return m3.toString();
    }

    public ProductDetailSkuDynamic(String str, long j3, ProductDetailBuyLimit productDetailBuyLimit) {
        this.stock = str;
        this.stockNums = j3;
        this.buyLimit = productDetailBuyLimit;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailSkuDynamic)) {
            return false;
        }
        ProductDetailSkuDynamic productDetailSkuDynamic = (ProductDetailSkuDynamic) obj;
        return Intrinsics.areEqual(this.stock, productDetailSkuDynamic.stock) && this.stockNums == productDetailSkuDynamic.stockNums && Intrinsics.areEqual(this.buyLimit, productDetailSkuDynamic.buyLimit);
    }

    public /* synthetic */ ProductDetailSkuDynamic(String str, long j3, ProductDetailBuyLimit productDetailBuyLimit, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, null);
    }
}
