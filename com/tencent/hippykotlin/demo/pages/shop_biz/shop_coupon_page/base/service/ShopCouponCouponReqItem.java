package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponCouponReqItem implements ISSOModel {
    public final String couponBatchId;
    public final int num;

    public ShopCouponCouponReqItem() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("coupon_batch_id", this.couponBatchId);
        eVar.t(WidgetCacheConstellationData.NUM, this.num);
        return eVar;
    }

    public final int hashCode() {
        return this.num + (this.couponBatchId.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponReqItem(couponBatchId=");
        m3.append(this.couponBatchId);
        m3.append(", num=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.num, ')');
    }

    public ShopCouponCouponReqItem(String str, int i3) {
        this.couponBatchId = str;
        this.num = i3;
    }

    public /* synthetic */ ShopCouponCouponReqItem(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponCouponReqItem)) {
            return false;
        }
        ShopCouponCouponReqItem shopCouponCouponReqItem = (ShopCouponCouponReqItem) obj;
        return Intrinsics.areEqual(this.couponBatchId, shopCouponCouponReqItem.couponBatchId) && this.num == shopCouponCouponReqItem.num;
    }
}
