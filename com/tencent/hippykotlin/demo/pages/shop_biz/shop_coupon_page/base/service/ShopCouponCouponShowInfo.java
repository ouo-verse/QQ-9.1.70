package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponCouponShowInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final ShopCouponCouponBasicInfo basicInfo;
    public final String couponBatchId;
    public final ShopCouponCouponShowStyleInfo couponListStyle;
    public final int couponRemainNum;
    public final long createTime;
    public final ShopCouponIssueRule issueRule;
    public final long modifyTime;
    public final ShopCouponCouponShowLimit showLimit;
    public final ShopCouponUserCouponUse userCouponUse;

    public ShopCouponCouponShowInfo() {
        this(null, null, null, null, 0L, 0L, 0, null, null, 511, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("coupon_batch_id", this.couponBatchId);
        ShopCouponCouponBasicInfo shopCouponCouponBasicInfo = this.basicInfo;
        if (shopCouponCouponBasicInfo != null) {
            eVar.v("basic_info", shopCouponCouponBasicInfo.encode());
        }
        ShopCouponIssueRule shopCouponIssueRule = this.issueRule;
        if (shopCouponIssueRule != null) {
            eVar.v("issue_rule", shopCouponIssueRule.encode());
        }
        ShopCouponUserCouponUse shopCouponUserCouponUse = this.userCouponUse;
        if (shopCouponUserCouponUse != null) {
            eVar.v("user_coupon_use", shopCouponUserCouponUse.encode());
        }
        eVar.u(AlbumCacheData.CREATE_TIME, this.createTime);
        eVar.u("modify_time", this.modifyTime);
        eVar.t("coupon_remain_num", this.couponRemainNum);
        ShopCouponCouponShowLimit shopCouponCouponShowLimit = this.showLimit;
        if (shopCouponCouponShowLimit != null) {
            eVar.v("show_limit", shopCouponCouponShowLimit.encode());
        }
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = this.couponListStyle;
        if (shopCouponCouponShowStyleInfo != null) {
            eVar.v("coupon_list_style", shopCouponCouponShowStyleInfo.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int hashCode = this.couponBatchId.hashCode() * 31;
        ShopCouponCouponBasicInfo shopCouponCouponBasicInfo = this.basicInfo;
        int hashCode2 = (hashCode + (shopCouponCouponBasicInfo == null ? 0 : shopCouponCouponBasicInfo.hashCode())) * 31;
        ShopCouponIssueRule shopCouponIssueRule = this.issueRule;
        int hashCode3 = (hashCode2 + (shopCouponIssueRule == null ? 0 : shopCouponIssueRule.hashCode())) * 31;
        ShopCouponUserCouponUse shopCouponUserCouponUse = this.userCouponUse;
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.couponRemainNum, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.modifyTime, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.createTime, (hashCode3 + (shopCouponUserCouponUse == null ? 0 : shopCouponUserCouponUse.hashCode())) * 31, 31), 31), 31);
        ShopCouponCouponShowLimit shopCouponCouponShowLimit = this.showLimit;
        int i3 = (m3 + (shopCouponCouponShowLimit == null ? 0 : shopCouponCouponShowLimit.limit)) * 31;
        ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo = this.couponListStyle;
        return i3 + (shopCouponCouponShowStyleInfo != null ? shopCouponCouponShowStyleInfo.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponShowInfo(couponBatchId=");
        m3.append(this.couponBatchId);
        m3.append(", basicInfo=");
        m3.append(this.basicInfo);
        m3.append(", issueRule=");
        m3.append(this.issueRule);
        m3.append(", userCouponUse=");
        m3.append(this.userCouponUse);
        m3.append(", createTime=");
        m3.append(this.createTime);
        m3.append(", modifyTime=");
        m3.append(this.modifyTime);
        m3.append(", couponRemainNum=");
        m3.append(this.couponRemainNum);
        m3.append(", showLimit=");
        m3.append(this.showLimit);
        m3.append(", couponListStyle=");
        m3.append(this.couponListStyle);
        m3.append(')');
        return m3.toString();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final ShopCouponCouponShowInfo decode(e eVar) {
            ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo;
            String q16 = eVar.q("coupon_batch_id", "");
            e m3 = eVar.m("basic_info");
            ShopCouponCouponBasicInfo decode = m3 != null ? ShopCouponCouponBasicInfo.Companion.decode(m3) : null;
            e m16 = eVar.m("issue_rule");
            ShopCouponIssueRule shopCouponIssueRule = m16 != null ? new ShopCouponIssueRule(m16.k("max_coupons", 0), m16.k("max_coupon_per_user", 0), m16.o(QCircleLpReportDc05502.KEY_BEGIN_TIME, 0L), m16.o("end_time", 0L)) : null;
            e m17 = eVar.m("user_coupon_use");
            ShopCouponUserCouponUse shopCouponUserCouponUse = m17 != null ? new ShopCouponUserCouponUse(m17.q("user_id", ""), m17.k("has_num", 0), m17.k("remain_num", 0)) : null;
            long o16 = eVar.o(AlbumCacheData.CREATE_TIME, 0L);
            long o17 = eVar.o("modify_time", 0L);
            int k3 = eVar.k("coupon_remain_num", 0);
            e m18 = eVar.m("show_limit");
            ShopCouponCouponShowLimit shopCouponCouponShowLimit = m18 != null ? new ShopCouponCouponShowLimit(m18.k("limit", 0)) : null;
            e m19 = eVar.m("coupon_list_style");
            if (m19 != null) {
                String q17 = m19.q("coupon_type_name", "");
                String q18 = m19.q("coupon_issuer_name", "");
                String q19 = m19.q("coupon_usable_range", "");
                String q26 = m19.q("coupon_use_rule", "");
                String q27 = m19.q("coupon_time_scope", "");
                e m26 = m19.m("coupon_show_discount");
                shopCouponCouponShowStyleInfo = new ShopCouponCouponShowStyleInfo(q17, q18, q19, q26, q27, m26 != null ? new ShopCouponShowDiscount(m26.q("discount_amount", ""), m26.q("discount_threshold", ""), m26.q("discount_simple_lable", ""), m26.k("type", 0)) : null);
            } else {
                shopCouponCouponShowStyleInfo = null;
            }
            return new ShopCouponCouponShowInfo(q16, decode, shopCouponIssueRule, shopCouponUserCouponUse, o16, o17, k3, shopCouponCouponShowLimit, shopCouponCouponShowStyleInfo);
        }
    }

    public ShopCouponCouponShowInfo(String str, ShopCouponCouponBasicInfo shopCouponCouponBasicInfo, ShopCouponIssueRule shopCouponIssueRule, ShopCouponUserCouponUse shopCouponUserCouponUse, long j3, long j16, int i3, ShopCouponCouponShowLimit shopCouponCouponShowLimit, ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo) {
        this.couponBatchId = str;
        this.basicInfo = shopCouponCouponBasicInfo;
        this.issueRule = shopCouponIssueRule;
        this.userCouponUse = shopCouponUserCouponUse;
        this.createTime = j3;
        this.modifyTime = j16;
        this.couponRemainNum = i3;
        this.showLimit = shopCouponCouponShowLimit;
        this.couponListStyle = shopCouponCouponShowStyleInfo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponCouponShowInfo)) {
            return false;
        }
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = (ShopCouponCouponShowInfo) obj;
        return Intrinsics.areEqual(this.couponBatchId, shopCouponCouponShowInfo.couponBatchId) && Intrinsics.areEqual(this.basicInfo, shopCouponCouponShowInfo.basicInfo) && Intrinsics.areEqual(this.issueRule, shopCouponCouponShowInfo.issueRule) && Intrinsics.areEqual(this.userCouponUse, shopCouponCouponShowInfo.userCouponUse) && this.createTime == shopCouponCouponShowInfo.createTime && this.modifyTime == shopCouponCouponShowInfo.modifyTime && this.couponRemainNum == shopCouponCouponShowInfo.couponRemainNum && Intrinsics.areEqual(this.showLimit, shopCouponCouponShowInfo.showLimit) && Intrinsics.areEqual(this.couponListStyle, shopCouponCouponShowInfo.couponListStyle);
    }

    public /* synthetic */ ShopCouponCouponShowInfo(String str, ShopCouponCouponBasicInfo shopCouponCouponBasicInfo, ShopCouponIssueRule shopCouponIssueRule, ShopCouponUserCouponUse shopCouponUserCouponUse, long j3, long j16, int i3, ShopCouponCouponShowLimit shopCouponCouponShowLimit, ShopCouponCouponShowStyleInfo shopCouponCouponShowStyleInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, null, null, 0L, 0L, 0, null, null);
    }
}
