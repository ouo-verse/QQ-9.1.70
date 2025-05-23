package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;

/* loaded from: classes33.dex */
public final class MyCouponSwitchTabPageEvent {
    public final int newIndex;
    public final int oldIndex;

    public MyCouponSwitchTabPageEvent(int i3, int i16) {
        this.oldIndex = i3;
        this.newIndex = i16;
    }

    public final int hashCode() {
        return this.newIndex + (this.oldIndex * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("MyCouponSwitchTabPageEvent(oldIndex=");
        m3.append(this.oldIndex);
        m3.append(", newIndex=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.newIndex, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyCouponSwitchTabPageEvent)) {
            return false;
        }
        MyCouponSwitchTabPageEvent myCouponSwitchTabPageEvent = (MyCouponSwitchTabPageEvent) obj;
        return this.oldIndex == myCouponSwitchTabPageEvent.oldIndex && this.newIndex == myCouponSwitchTabPageEvent.newIndex;
    }
}
