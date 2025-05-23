package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailSpuDynamic implements ISSOModel {
    public final ProductDetailBuyLimit buyLimit;
    public final String sales;
    public final long salesNum;
    public final String stock;
    public final long stockNum;

    public ProductDetailSpuDynamic() {
        this(null, null, null, 0L, 0L, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("stock", this.stock);
        ProductDetailBuyLimit productDetailBuyLimit = this.buyLimit;
        if (productDetailBuyLimit != null) {
            eVar.v("buy_limit", productDetailBuyLimit.encode());
        }
        eVar.v("sales", this.sales);
        eVar.u("stock_num", this.stockNum);
        eVar.u("sales_num", this.salesNum);
        return eVar;
    }

    public final int hashCode() {
        int hashCode = this.stock.hashCode() * 31;
        ProductDetailBuyLimit productDetailBuyLimit = this.buyLimit;
        return d.a(this.salesNum) + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.stockNum, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.sales, (hashCode + (productDetailBuyLimit == null ? 0 : productDetailBuyLimit.userDailyLimit)) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailSpuDynamic(stock=");
        m3.append(this.stock);
        m3.append(", buyLimit=");
        m3.append(this.buyLimit);
        m3.append(", sales=");
        m3.append(this.sales);
        m3.append(", stockNum=");
        m3.append(this.stockNum);
        m3.append(", salesNum=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.salesNum, ')');
    }

    public ProductDetailSpuDynamic(String str, ProductDetailBuyLimit productDetailBuyLimit, String str2, long j3, long j16) {
        this.stock = str;
        this.buyLimit = productDetailBuyLimit;
        this.sales = str2;
        this.stockNum = j3;
        this.salesNum = j16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailSpuDynamic)) {
            return false;
        }
        ProductDetailSpuDynamic productDetailSpuDynamic = (ProductDetailSpuDynamic) obj;
        return Intrinsics.areEqual(this.stock, productDetailSpuDynamic.stock) && Intrinsics.areEqual(this.buyLimit, productDetailSpuDynamic.buyLimit) && Intrinsics.areEqual(this.sales, productDetailSpuDynamic.sales) && this.stockNum == productDetailSpuDynamic.stockNum && this.salesNum == productDetailSpuDynamic.salesNum;
    }

    public /* synthetic */ ProductDetailSpuDynamic(String str, ProductDetailBuyLimit productDetailBuyLimit, String str2, long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, "", 0L, 0L);
    }
}
