package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponUseTimeRule implements ISSOModel {
    public final long beginTime;
    public final int dayAfterReceive;
    public final long endTime;

    public ShopCouponUseTimeRule() {
        this(0L, 0L, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u(QCircleLpReportDc05502.KEY_BEGIN_TIME, this.beginTime);
        eVar.u("end_time", this.endTime);
        eVar.t("day_after_receive", this.dayAfterReceive);
        return eVar;
    }

    public final int hashCode() {
        return this.dayAfterReceive + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.endTime, d.a(this.beginTime) * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponUseTimeRule(beginTime=");
        m3.append(this.beginTime);
        m3.append(", endTime=");
        m3.append(this.endTime);
        m3.append(", dayAfterReceive=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.dayAfterReceive, ')');
    }

    public ShopCouponUseTimeRule(long j3, long j16, int i3) {
        this.beginTime = j3;
        this.endTime = j16;
        this.dayAfterReceive = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponUseTimeRule)) {
            return false;
        }
        ShopCouponUseTimeRule shopCouponUseTimeRule = (ShopCouponUseTimeRule) obj;
        return this.beginTime == shopCouponUseTimeRule.beginTime && this.endTime == shopCouponUseTimeRule.endTime && this.dayAfterReceive == shopCouponUseTimeRule.dayAfterReceive;
    }

    public /* synthetic */ ShopCouponUseTimeRule(long j3, long j16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0);
    }
}
