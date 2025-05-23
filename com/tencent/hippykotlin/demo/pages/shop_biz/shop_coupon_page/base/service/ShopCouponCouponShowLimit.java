package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponCouponShowLimit implements ISSOModel {
    public final int limit;

    public ShopCouponCouponShowLimit() {
        this(0, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("limit", this.limit);
        return eVar;
    }

    public final int hashCode() {
        return this.limit;
    }

    public final String toString() {
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponShowLimit(limit="), this.limit, ')');
    }

    public ShopCouponCouponShowLimit(int i3) {
        this.limit = i3;
    }

    public /* synthetic */ ShopCouponCouponShowLimit(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShopCouponCouponShowLimit) && this.limit == ((ShopCouponCouponShowLimit) obj).limit;
    }
}
