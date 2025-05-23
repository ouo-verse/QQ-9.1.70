package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailPrice implements ISSOModel {
    public final long discountPrice;
    public final String discountPriceDesc;
    public final String discountPriceTxt;
    public final String originPriceTxt;
    public final String priceTxt;

    public ProductDetailPrice() {
        this(null, null, null, 0L, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("origin_price_txt", this.originPriceTxt);
        eVar.v("discount_price_txt", this.discountPriceTxt);
        eVar.v("price_txt", this.priceTxt);
        eVar.u("discount_price", this.discountPrice);
        eVar.v("discount_price_desc", this.discountPriceDesc);
        return eVar;
    }

    public final int hashCode() {
        return this.discountPriceDesc.hashCode() + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.discountPrice, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.priceTxt, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountPriceTxt, this.originPriceTxt.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailPrice(originPriceTxt=");
        m3.append(this.originPriceTxt);
        m3.append(", discountPriceTxt=");
        m3.append(this.discountPriceTxt);
        m3.append(", priceTxt=");
        m3.append(this.priceTxt);
        m3.append(", discountPrice=");
        m3.append(this.discountPrice);
        m3.append(", discountPriceDesc=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.discountPriceDesc, ')');
    }

    public ProductDetailPrice(String str, String str2, String str3, long j3, String str4) {
        this.originPriceTxt = str;
        this.discountPriceTxt = str2;
        this.priceTxt = str3;
        this.discountPrice = j3;
        this.discountPriceDesc = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailPrice)) {
            return false;
        }
        ProductDetailPrice productDetailPrice = (ProductDetailPrice) obj;
        return Intrinsics.areEqual(this.originPriceTxt, productDetailPrice.originPriceTxt) && Intrinsics.areEqual(this.discountPriceTxt, productDetailPrice.discountPriceTxt) && Intrinsics.areEqual(this.priceTxt, productDetailPrice.priceTxt) && this.discountPrice == productDetailPrice.discountPrice && Intrinsics.areEqual(this.discountPriceDesc, productDetailPrice.discountPriceDesc);
    }

    public /* synthetic */ ProductDetailPrice(String str, String str2, String str3, long j3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", 0L, "");
    }
}
