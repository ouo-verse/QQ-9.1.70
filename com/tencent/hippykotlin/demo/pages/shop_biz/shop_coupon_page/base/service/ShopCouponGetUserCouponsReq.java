package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponGetUserCouponsReq implements ISSOModel {
    public final ShopCouponPageCookie cookie;
    public final int userCouponStatus;

    public ShopCouponGetUserCouponsReq() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("user_coupon_status", this.userCouponStatus);
        ShopCouponPageCookie shopCouponPageCookie = this.cookie;
        if (shopCouponPageCookie != null) {
            eVar.v("cookie", shopCouponPageCookie.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int i3 = this.userCouponStatus * 31;
        ShopCouponPageCookie shopCouponPageCookie = this.cookie;
        return i3 + (shopCouponPageCookie == null ? 0 : shopCouponPageCookie.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponGetUserCouponsReq(userCouponStatus=");
        m3.append(this.userCouponStatus);
        m3.append(", cookie=");
        m3.append(this.cookie);
        m3.append(')');
        return m3.toString();
    }

    public ShopCouponGetUserCouponsReq(int i3, ShopCouponPageCookie shopCouponPageCookie) {
        this.userCouponStatus = i3;
        this.cookie = shopCouponPageCookie;
    }

    public /* synthetic */ ShopCouponGetUserCouponsReq(int i3, ShopCouponPageCookie shopCouponPageCookie, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponGetUserCouponsReq)) {
            return false;
        }
        ShopCouponGetUserCouponsReq shopCouponGetUserCouponsReq = (ShopCouponGetUserCouponsReq) obj;
        return this.userCouponStatus == shopCouponGetUserCouponsReq.userCouponStatus && Intrinsics.areEqual(this.cookie, shopCouponGetUserCouponsReq.cookie);
    }
}
