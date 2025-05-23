package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LiveCouponRspModel {
    public final int couponNum;
    public final ArrayList<LivingCoupon> coupons;
    public final String discountPrice;
    public final long lastPickupTs;

    public LiveCouponRspModel() {
        this(0, 0L, null, null, 15, null);
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountPrice, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.lastPickupTs, this.couponNum * 31, 31), 31);
        ArrayList<LivingCoupon> arrayList = this.coupons;
        return m3 + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("LiveCouponRspModel(couponNum=");
        m3.append(this.couponNum);
        m3.append(", lastPickupTs=");
        m3.append(this.lastPickupTs);
        m3.append(", discountPrice=");
        m3.append(this.discountPrice);
        m3.append(", coupons=");
        m3.append(this.coupons);
        m3.append(')');
        return m3.toString();
    }

    public LiveCouponRspModel(int i3, long j3, String str, ArrayList<LivingCoupon> arrayList) {
        this.couponNum = i3;
        this.lastPickupTs = j3;
        this.discountPrice = str;
        this.coupons = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveCouponRspModel)) {
            return false;
        }
        LiveCouponRspModel liveCouponRspModel = (LiveCouponRspModel) obj;
        return this.couponNum == liveCouponRspModel.couponNum && this.lastPickupTs == liveCouponRspModel.lastPickupTs && Intrinsics.areEqual(this.discountPrice, liveCouponRspModel.discountPrice) && Intrinsics.areEqual(this.coupons, liveCouponRspModel.coupons);
    }

    public /* synthetic */ LiveCouponRspModel(int i3, long j3, String str, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0L, "", null);
    }
}
