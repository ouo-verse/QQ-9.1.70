package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponIssueRule implements ISSOModel {
    public final long beginTime;
    public final long endTime;
    public final int maxCouponPerUser;
    public final int maxCoupons;

    public ShopCouponIssueRule() {
        this(0, 0, 0L, 0L, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("max_coupons", this.maxCoupons);
        eVar.t("max_coupon_per_user", this.maxCouponPerUser);
        eVar.u(QCircleLpReportDc05502.KEY_BEGIN_TIME, this.beginTime);
        eVar.u("end_time", this.endTime);
        return eVar;
    }

    public final int hashCode() {
        return d.a(this.endTime) + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.beginTime, QQAudioParams$$ExternalSyntheticOutline0.m(this.maxCouponPerUser, this.maxCoupons * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponIssueRule(maxCoupons=");
        m3.append(this.maxCoupons);
        m3.append(", maxCouponPerUser=");
        m3.append(this.maxCouponPerUser);
        m3.append(", beginTime=");
        m3.append(this.beginTime);
        m3.append(", endTime=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.endTime, ')');
    }

    public ShopCouponIssueRule(int i3, int i16, long j3, long j16) {
        this.maxCoupons = i3;
        this.maxCouponPerUser = i16;
        this.beginTime = j3;
        this.endTime = j16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponIssueRule)) {
            return false;
        }
        ShopCouponIssueRule shopCouponIssueRule = (ShopCouponIssueRule) obj;
        return this.maxCoupons == shopCouponIssueRule.maxCoupons && this.maxCouponPerUser == shopCouponIssueRule.maxCouponPerUser && this.beginTime == shopCouponIssueRule.beginTime && this.endTime == shopCouponIssueRule.endTime;
    }

    public /* synthetic */ ShopCouponIssueRule(int i3, int i16, long j3, long j16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, 0L, 0L);
    }
}
