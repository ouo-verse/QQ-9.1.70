package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponDiscountRule implements ISSOModel {
    public final ShopCouponThresholdRule cashDiscount;
    public final ShopCouponThresholdRule fullReduction;
    public final ShopCouponThresholdRule reducedRate;
    public final int type;

    public ShopCouponDiscountRule() {
        this(0, null, null, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("type", this.type);
        ShopCouponThresholdRule shopCouponThresholdRule = this.cashDiscount;
        if (shopCouponThresholdRule != null) {
            eVar.v("cash_discount", shopCouponThresholdRule.encode());
        }
        ShopCouponThresholdRule shopCouponThresholdRule2 = this.fullReduction;
        if (shopCouponThresholdRule2 != null) {
            eVar.v("full_reduction", shopCouponThresholdRule2.encode());
        }
        ShopCouponThresholdRule shopCouponThresholdRule3 = this.reducedRate;
        if (shopCouponThresholdRule3 != null) {
            eVar.v("reduced_rate", shopCouponThresholdRule3.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int i3 = this.type * 31;
        ShopCouponThresholdRule shopCouponThresholdRule = this.cashDiscount;
        int hashCode = (i3 + (shopCouponThresholdRule == null ? 0 : shopCouponThresholdRule.hashCode())) * 31;
        ShopCouponThresholdRule shopCouponThresholdRule2 = this.fullReduction;
        int hashCode2 = (hashCode + (shopCouponThresholdRule2 == null ? 0 : shopCouponThresholdRule2.hashCode())) * 31;
        ShopCouponThresholdRule shopCouponThresholdRule3 = this.reducedRate;
        return hashCode2 + (shopCouponThresholdRule3 != null ? shopCouponThresholdRule3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponDiscountRule(type=");
        m3.append(this.type);
        m3.append(", cashDiscount=");
        m3.append(this.cashDiscount);
        m3.append(", fullReduction=");
        m3.append(this.fullReduction);
        m3.append(", reducedRate=");
        m3.append(this.reducedRate);
        m3.append(')');
        return m3.toString();
    }

    public ShopCouponDiscountRule(int i3, ShopCouponThresholdRule shopCouponThresholdRule, ShopCouponThresholdRule shopCouponThresholdRule2, ShopCouponThresholdRule shopCouponThresholdRule3) {
        this.type = i3;
        this.cashDiscount = shopCouponThresholdRule;
        this.fullReduction = shopCouponThresholdRule2;
        this.reducedRate = shopCouponThresholdRule3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponDiscountRule)) {
            return false;
        }
        ShopCouponDiscountRule shopCouponDiscountRule = (ShopCouponDiscountRule) obj;
        return this.type == shopCouponDiscountRule.type && Intrinsics.areEqual(this.cashDiscount, shopCouponDiscountRule.cashDiscount) && Intrinsics.areEqual(this.fullReduction, shopCouponDiscountRule.fullReduction) && Intrinsics.areEqual(this.reducedRate, shopCouponDiscountRule.reducedRate);
    }

    public /* synthetic */ ShopCouponDiscountRule(int i3, ShopCouponThresholdRule shopCouponThresholdRule, ShopCouponThresholdRule shopCouponThresholdRule2, ShopCouponThresholdRule shopCouponThresholdRule3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null, null, null);
    }
}
