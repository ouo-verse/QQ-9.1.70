package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponShowDiscount implements ISSOModel {
    public final String discountAmount;
    public final String discountSimpleLable;
    public final String discountThreshold;
    public final int type;

    public ShopCouponShowDiscount() {
        this(null, null, null, 0, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("discount_amount", this.discountAmount);
        eVar.v("discount_threshold", this.discountThreshold);
        eVar.v("discount_simple_lable", this.discountSimpleLable);
        eVar.t("type", this.type);
        return eVar;
    }

    public final int hashCode() {
        return this.type + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountSimpleLable, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountThreshold, this.discountAmount.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponShowDiscount(discountAmount=");
        m3.append(this.discountAmount);
        m3.append(", discountThreshold=");
        m3.append(this.discountThreshold);
        m3.append(", discountSimpleLable=");
        m3.append(this.discountSimpleLable);
        m3.append(", type=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.type, ')');
    }

    public ShopCouponShowDiscount(String str, String str2, String str3, int i3) {
        this.discountAmount = str;
        this.discountThreshold = str2;
        this.discountSimpleLable = str3;
        this.type = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponShowDiscount)) {
            return false;
        }
        ShopCouponShowDiscount shopCouponShowDiscount = (ShopCouponShowDiscount) obj;
        return Intrinsics.areEqual(this.discountAmount, shopCouponShowDiscount.discountAmount) && Intrinsics.areEqual(this.discountThreshold, shopCouponShowDiscount.discountThreshold) && Intrinsics.areEqual(this.discountSimpleLable, shopCouponShowDiscount.discountSimpleLable) && this.type == shopCouponShowDiscount.type;
    }

    public /* synthetic */ ShopCouponShowDiscount(String str, String str2, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", 0);
    }
}
