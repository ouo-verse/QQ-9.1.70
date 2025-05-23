package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponCouponBasicInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ShopCouponDiscountRule discountRule;
    public final ShopCouponIssuer issuer;
    public final ShopCouponApplicableTarget target;
    public final ShopCouponUseTimeRule useTimeRule;

    public ShopCouponCouponBasicInfo() {
        this(null, null, null, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        ShopCouponIssuer shopCouponIssuer = this.issuer;
        if (shopCouponIssuer != null) {
            eVar.v("issuer", shopCouponIssuer.encode());
        }
        ShopCouponApplicableTarget shopCouponApplicableTarget = this.target;
        if (shopCouponApplicableTarget != null) {
            eVar.v("target", shopCouponApplicableTarget.encode());
        }
        ShopCouponDiscountRule shopCouponDiscountRule = this.discountRule;
        if (shopCouponDiscountRule != null) {
            eVar.v("discount_rule", shopCouponDiscountRule.encode());
        }
        ShopCouponUseTimeRule shopCouponUseTimeRule = this.useTimeRule;
        if (shopCouponUseTimeRule != null) {
            eVar.v("use_time_rule", shopCouponUseTimeRule.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        ShopCouponIssuer shopCouponIssuer = this.issuer;
        int hashCode = (shopCouponIssuer == null ? 0 : shopCouponIssuer.hashCode()) * 31;
        ShopCouponApplicableTarget shopCouponApplicableTarget = this.target;
        int hashCode2 = (hashCode + (shopCouponApplicableTarget == null ? 0 : shopCouponApplicableTarget.hashCode())) * 31;
        ShopCouponDiscountRule shopCouponDiscountRule = this.discountRule;
        int hashCode3 = (hashCode2 + (shopCouponDiscountRule == null ? 0 : shopCouponDiscountRule.hashCode())) * 31;
        ShopCouponUseTimeRule shopCouponUseTimeRule = this.useTimeRule;
        return hashCode3 + (shopCouponUseTimeRule != null ? shopCouponUseTimeRule.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponBasicInfo(issuer=");
        m3.append(this.issuer);
        m3.append(", target=");
        m3.append(this.target);
        m3.append(", discountRule=");
        m3.append(this.discountRule);
        m3.append(", useTimeRule=");
        m3.append(this.useTimeRule);
        m3.append(')');
        return m3.toString();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final ShopCouponCouponBasicInfo decode(e eVar) {
            ShopCouponApplicableTarget shopCouponApplicableTarget;
            ShopCouponDiscountRule shopCouponDiscountRule;
            ArrayList arrayList;
            e m3 = eVar.m("issuer");
            ShopCouponIssuer shopCouponIssuer = m3 != null ? new ShopCouponIssuer(m3.k("type", 0), m3.q("id", ""), m3.q("name", "")) : null;
            e m16 = eVar.m("target");
            if (m16 != null) {
                int k3 = m16.k("coupon_type", 0);
                b l3 = m16.l("target");
                if (l3 != null) {
                    arrayList = new ArrayList();
                    int c16 = l3.c();
                    for (int i3 = 0; i3 < c16; i3++) {
                        Object d16 = l3.d(i3);
                        if (d16 != null) {
                            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            e eVar2 = (e) d16;
                            arrayList.add(new ShopCouponTarget(eVar2.k("id_type", 0), eVar2.q("id", ""), eVar2.q("id_name", "")));
                        }
                    }
                } else {
                    arrayList = null;
                }
                shopCouponApplicableTarget = new ShopCouponApplicableTarget(k3, arrayList);
            } else {
                shopCouponApplicableTarget = null;
            }
            e m17 = eVar.m("discount_rule");
            if (m17 != null) {
                int k16 = m17.k("type", 0);
                e m18 = m17.m("cash_discount");
                ShopCouponThresholdRule shopCouponThresholdRule = m18 != null ? new ShopCouponThresholdRule(m18.k("threshold", 0), m18.k("discount", 0)) : null;
                e m19 = m17.m("full_reduction");
                ShopCouponThresholdRule shopCouponThresholdRule2 = m19 != null ? new ShopCouponThresholdRule(m19.k("threshold", 0), m19.k("discount", 0)) : null;
                e m26 = m17.m("reduced_rate");
                shopCouponDiscountRule = new ShopCouponDiscountRule(k16, shopCouponThresholdRule, shopCouponThresholdRule2, m26 != null ? new ShopCouponThresholdRule(m26.k("threshold", 0), m26.k("discount", 0)) : null);
            } else {
                shopCouponDiscountRule = null;
            }
            e m27 = eVar.m("use_time_rule");
            return new ShopCouponCouponBasicInfo(shopCouponIssuer, shopCouponApplicableTarget, shopCouponDiscountRule, m27 != null ? new ShopCouponUseTimeRule(m27.o(QCircleLpReportDc05502.KEY_BEGIN_TIME, 0L), m27.o("end_time", 0L), m27.k("day_after_receive", 0)) : null);
        }
    }

    public ShopCouponCouponBasicInfo(ShopCouponIssuer shopCouponIssuer, ShopCouponApplicableTarget shopCouponApplicableTarget, ShopCouponDiscountRule shopCouponDiscountRule, ShopCouponUseTimeRule shopCouponUseTimeRule) {
        this.issuer = shopCouponIssuer;
        this.target = shopCouponApplicableTarget;
        this.discountRule = shopCouponDiscountRule;
        this.useTimeRule = shopCouponUseTimeRule;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponCouponBasicInfo)) {
            return false;
        }
        ShopCouponCouponBasicInfo shopCouponCouponBasicInfo = (ShopCouponCouponBasicInfo) obj;
        return Intrinsics.areEqual(this.issuer, shopCouponCouponBasicInfo.issuer) && Intrinsics.areEqual(this.target, shopCouponCouponBasicInfo.target) && Intrinsics.areEqual(this.discountRule, shopCouponCouponBasicInfo.discountRule) && Intrinsics.areEqual(this.useTimeRule, shopCouponCouponBasicInfo.useTimeRule);
    }

    public /* synthetic */ ShopCouponCouponBasicInfo(ShopCouponIssuer shopCouponIssuer, ShopCouponApplicableTarget shopCouponApplicableTarget, ShopCouponDiscountRule shopCouponDiscountRule, ShopCouponUseTimeRule shopCouponUseTimeRule, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null);
    }
}
