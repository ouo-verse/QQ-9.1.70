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
public final class Price implements ISSOModel {
    public final long discountPrice;
    public final String discountPriceDesc;
    public final String discountPriceTxt;
    public final long offPrice;
    public final String originPriceTxt;
    public final String priceTxt;

    public Price() {
        this(null, null, null, null, 0L, 0L, 63, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("origin_price_txt", this.originPriceTxt);
        eVar.v("price_txt", this.priceTxt);
        eVar.v("discount_price_txt", this.discountPriceTxt);
        eVar.v("discount_price_desc", this.discountPriceDesc);
        eVar.u("discount_price", this.discountPrice);
        eVar.u("off_price", this.offPrice);
        return eVar;
    }

    public final int hashCode() {
        return d.a(this.offPrice) + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.discountPrice, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountPriceDesc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountPriceTxt, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.priceTxt, this.originPriceTxt.hashCode() * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Price(originPriceTxt=");
        m3.append(this.originPriceTxt);
        m3.append(", priceTxt=");
        m3.append(this.priceTxt);
        m3.append(", discountPriceTxt=");
        m3.append(this.discountPriceTxt);
        m3.append(", discountPriceDesc=");
        m3.append(this.discountPriceDesc);
        m3.append(", discountPrice=");
        m3.append(this.discountPrice);
        m3.append(", offPrice=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.offPrice, ')');
    }

    public Price(String str, String str2, String str3, String str4, long j3, long j16) {
        this.originPriceTxt = str;
        this.priceTxt = str2;
        this.discountPriceTxt = str3;
        this.discountPriceDesc = str4;
        this.discountPrice = j3;
        this.offPrice = j16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Price)) {
            return false;
        }
        Price price = (Price) obj;
        return Intrinsics.areEqual(this.originPriceTxt, price.originPriceTxt) && Intrinsics.areEqual(this.priceTxt, price.priceTxt) && Intrinsics.areEqual(this.discountPriceTxt, price.discountPriceTxt) && Intrinsics.areEqual(this.discountPriceDesc, price.discountPriceDesc) && this.discountPrice == price.discountPrice && this.offPrice == price.offPrice;
    }

    public /* synthetic */ Price(String str, String str2, String str3, String str4, long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", 0L, 0L);
    }
}
