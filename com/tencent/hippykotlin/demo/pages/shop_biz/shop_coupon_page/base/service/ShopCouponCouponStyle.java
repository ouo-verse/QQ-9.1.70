package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponCouponStyle implements ISSOModel {
    public final String couponId;
    public final ShopCouponCouponShowStyleInfo couponStyle;
    public final String useCouponUrl;

    public ShopCouponCouponStyle() {
        this(null, null, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("coupon_id", this.couponId);
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = this.couponStyle;
        if (shopCouponCouponShowStyleInfo != null) {
            eVar.v("coupon_style", shopCouponCouponShowStyleInfo.encode());
        }
        eVar.v("use_coupon_url", this.useCouponUrl);
        return eVar;
    }

    public final int hashCode() {
        int hashCode = this.couponId.hashCode() * 31;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = this.couponStyle;
        return this.useCouponUrl.hashCode() + ((hashCode + (shopCouponCouponShowStyleInfo == null ? 0 : shopCouponCouponShowStyleInfo.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponStyle(couponId=");
        m3.append(this.couponId);
        m3.append(", couponStyle=");
        m3.append(this.couponStyle);
        m3.append(", useCouponUrl=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.useCouponUrl, ')');
    }

    public ShopCouponCouponStyle(String str, ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo, String str2) {
        this.couponId = str;
        this.couponStyle = shopCouponCouponShowStyleInfo;
        this.useCouponUrl = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponCouponStyle)) {
            return false;
        }
        ShopCouponCouponStyle shopCouponCouponStyle = (ShopCouponCouponStyle) obj;
        return Intrinsics.areEqual(this.couponId, shopCouponCouponStyle.couponId) && Intrinsics.areEqual(this.couponStyle, shopCouponCouponStyle.couponStyle) && Intrinsics.areEqual(this.useCouponUrl, shopCouponCouponStyle.useCouponUrl);
    }

    public /* synthetic */ ShopCouponCouponStyle(String str, ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, "");
    }
}
