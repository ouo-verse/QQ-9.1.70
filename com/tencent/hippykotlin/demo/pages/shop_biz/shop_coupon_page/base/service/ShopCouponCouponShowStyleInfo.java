package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponCouponShowStyleInfo implements ISSOModel {
    public final String couponIssuerName;
    public final ShopCouponShowDiscount couponShowDiscount;
    public final String couponTimeScope;
    public final String couponTypeName;
    public final String couponUsableRange;
    public final String couponUseRule;

    public ShopCouponCouponShowStyleInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("coupon_type_name", this.couponTypeName);
        eVar.v("coupon_issuer_name", this.couponIssuerName);
        eVar.v("coupon_usable_range", this.couponUsableRange);
        eVar.v("coupon_use_rule", this.couponUseRule);
        eVar.v("coupon_time_scope", this.couponTimeScope);
        ShopCouponShowDiscount shopCouponShowDiscount = this.couponShowDiscount;
        if (shopCouponShowDiscount != null) {
            eVar.v("coupon_show_discount", shopCouponShowDiscount.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.couponTimeScope, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.couponUseRule, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.couponUsableRange, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.couponIssuerName, this.couponTypeName.hashCode() * 31, 31), 31), 31), 31);
        ShopCouponShowDiscount shopCouponShowDiscount = this.couponShowDiscount;
        return m3 + (shopCouponShowDiscount == null ? 0 : shopCouponShowDiscount.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponShowStyleInfo(couponTypeName=");
        m3.append(this.couponTypeName);
        m3.append(", couponIssuerName=");
        m3.append(this.couponIssuerName);
        m3.append(", couponUsableRange=");
        m3.append(this.couponUsableRange);
        m3.append(", couponUseRule=");
        m3.append(this.couponUseRule);
        m3.append(", couponTimeScope=");
        m3.append(this.couponTimeScope);
        m3.append(", couponShowDiscount=");
        m3.append(this.couponShowDiscount);
        m3.append(')');
        return m3.toString();
    }

    public ShopCouponCouponShowStyleInfo(String str, String str2, String str3, String str4, String str5, ShopCouponShowDiscount shopCouponShowDiscount) {
        this.couponTypeName = str;
        this.couponIssuerName = str2;
        this.couponUsableRange = str3;
        this.couponUseRule = str4;
        this.couponTimeScope = str5;
        this.couponShowDiscount = shopCouponShowDiscount;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponCouponShowStyleInfo)) {
            return false;
        }
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = (ShopCouponCouponShowStyleInfo) obj;
        return Intrinsics.areEqual(this.couponTypeName, shopCouponCouponShowStyleInfo.couponTypeName) && Intrinsics.areEqual(this.couponIssuerName, shopCouponCouponShowStyleInfo.couponIssuerName) && Intrinsics.areEqual(this.couponUsableRange, shopCouponCouponShowStyleInfo.couponUsableRange) && Intrinsics.areEqual(this.couponUseRule, shopCouponCouponShowStyleInfo.couponUseRule) && Intrinsics.areEqual(this.couponTimeScope, shopCouponCouponShowStyleInfo.couponTimeScope) && Intrinsics.areEqual(this.couponShowDiscount, shopCouponCouponShowStyleInfo.couponShowDiscount);
    }

    public /* synthetic */ ShopCouponCouponShowStyleInfo(String str, String str2, String str3, String str4, String str5, ShopCouponShowDiscount shopCouponShowDiscount, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "", null);
    }
}
