package com.tencent.hippykotlin.demo.pages.retain.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CouponLabelInfo implements ISSOModel {
    public final ShopCouponCouponShowInfo couponShowInfo;

    public CouponLabelInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = this.couponShowInfo;
        if (shopCouponCouponShowInfo != null) {
            eVar.v("coupon_show_info", shopCouponCouponShowInfo.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = this.couponShowInfo;
        if (shopCouponCouponShowInfo == null) {
            return 0;
        }
        return shopCouponCouponShowInfo.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CouponLabelInfo(couponShowInfo=");
        m3.append(this.couponShowInfo);
        m3.append(')');
        return m3.toString();
    }

    public CouponLabelInfo(ShopCouponCouponShowInfo shopCouponCouponShowInfo) {
        this.couponShowInfo = shopCouponCouponShowInfo;
    }

    public /* synthetic */ CouponLabelInfo(ShopCouponCouponShowInfo shopCouponCouponShowInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CouponLabelInfo) && Intrinsics.areEqual(this.couponShowInfo, ((CouponLabelInfo) obj).couponShowInfo);
    }
}
