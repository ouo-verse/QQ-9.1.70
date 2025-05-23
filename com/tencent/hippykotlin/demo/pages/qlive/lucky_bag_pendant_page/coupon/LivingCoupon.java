package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LivingCoupon {
    public final String couponBatchId;

    public LivingCoupon() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final int hashCode() {
        return this.couponBatchId.hashCode();
    }

    public final String toString() {
        return LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("LivingCoupon(couponBatchId="), this.couponBatchId, ')');
    }

    public LivingCoupon(String str) {
        this.couponBatchId = str;
    }

    public /* synthetic */ LivingCoupon(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LivingCoupon) && Intrinsics.areEqual(this.couponBatchId, ((LivingCoupon) obj).couponBatchId);
    }
}
