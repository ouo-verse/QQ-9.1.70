package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponUserCouponUse implements ISSOModel {
    public final int hasNum;
    public final int remainNum;
    public final String userId;

    public ShopCouponUserCouponUse() {
        this(null, 0, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("user_id", this.userId);
        eVar.t("has_num", this.hasNum);
        eVar.t("remain_num", this.remainNum);
        return eVar;
    }

    public final int hashCode() {
        return this.remainNum + QQAudioParams$$ExternalSyntheticOutline0.m(this.hasNum, this.userId.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponUserCouponUse(userId=");
        m3.append(this.userId);
        m3.append(", hasNum=");
        m3.append(this.hasNum);
        m3.append(", remainNum=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.remainNum, ')');
    }

    public ShopCouponUserCouponUse(String str, int i3, int i16) {
        this.userId = str;
        this.hasNum = i3;
        this.remainNum = i16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponUserCouponUse)) {
            return false;
        }
        ShopCouponUserCouponUse shopCouponUserCouponUse = (ShopCouponUserCouponUse) obj;
        return Intrinsics.areEqual(this.userId, shopCouponUserCouponUse.userId) && this.hasNum == shopCouponUserCouponUse.hasNum && this.remainNum == shopCouponUserCouponUse.remainNum;
    }

    public /* synthetic */ ShopCouponUserCouponUse(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, 0);
    }
}
