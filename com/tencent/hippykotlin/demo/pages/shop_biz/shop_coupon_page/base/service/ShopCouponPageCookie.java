package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes33.dex */
public final class ShopCouponPageCookie implements ISSOModel {
    public final long index;
    public final long limit;

    public ShopCouponPageCookie() {
        this(0L, 0L, 3, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u("index", this.index);
        eVar.u("limit", this.limit);
        return eVar;
    }

    public final int hashCode() {
        return d.a(this.limit) + (d.a(this.index) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponPageCookie(index=");
        m3.append(this.index);
        m3.append(", limit=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.limit, ')');
    }

    public ShopCouponPageCookie(long j3, long j16) {
        this.index = j3;
        this.limit = j16;
    }

    public /* synthetic */ ShopCouponPageCookie(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponPageCookie)) {
            return false;
        }
        ShopCouponPageCookie shopCouponPageCookie = (ShopCouponPageCookie) obj;
        return this.index == shopCouponPageCookie.index && this.limit == shopCouponPageCookie.limit;
    }
}
