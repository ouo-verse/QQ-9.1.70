package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CouponItem implements SelectCouponItemModel {
    public final CommonCouponItemModel commonCouponItem;
    public final boolean isBest;
    public final boolean isSelected;

    public CouponItem(CommonCouponItemModel commonCouponItemModel, boolean z16, boolean z17) {
        this.commonCouponItem = commonCouponItemModel;
        this.isSelected = z16;
        this.isBest = z17;
    }

    public static CouponItem copy$default(CouponItem couponItem, boolean z16) {
        return new CouponItem(couponItem.commonCouponItem, z16, couponItem.isBest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.commonCouponItem.hashCode() * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.isBest;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("CouponItem(commonCouponItem=");
        m3.append(this.commonCouponItem);
        m3.append(", isSelected=");
        m3.append(this.isSelected);
        m3.append(", isBest=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isBest, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponItem)) {
            return false;
        }
        CouponItem couponItem = (CouponItem) obj;
        return Intrinsics.areEqual(this.commonCouponItem, couponItem.commonCouponItem) && this.isSelected == couponItem.isSelected && this.isBest == couponItem.isBest;
    }
}
