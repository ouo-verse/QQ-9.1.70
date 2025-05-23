package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponThresholdRule implements ISSOModel {
    public final int discount;
    public final int threshold;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShopCouponThresholdRule() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("threshold", this.threshold);
        eVar.t("discount", this.discount);
        return eVar;
    }

    public final int hashCode() {
        return this.discount + (this.threshold * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponThresholdRule(threshold=");
        m3.append(this.threshold);
        m3.append(", discount=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.discount, ')');
    }

    public ShopCouponThresholdRule(int i3, int i16) {
        this.threshold = i3;
        this.discount = i16;
    }

    public /* synthetic */ ShopCouponThresholdRule(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponThresholdRule)) {
            return false;
        }
        ShopCouponThresholdRule shopCouponThresholdRule = (ShopCouponThresholdRule) obj;
        return this.threshold == shopCouponThresholdRule.threshold && this.discount == shopCouponThresholdRule.discount;
    }
}
