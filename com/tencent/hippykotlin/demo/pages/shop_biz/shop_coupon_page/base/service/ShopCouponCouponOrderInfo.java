package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponCouponOrderInfo implements ISSOModel {
    public final boolean canUse;
    public final String couponId;
    public final ShopCouponCouponShowInfo couponShowInfo;
    public final boolean isInBestOptions;
    public final boolean isUserSelect;

    public ShopCouponCouponOrderInfo() {
        this(null, null, false, false, false, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = this.couponShowInfo;
        if (shopCouponCouponShowInfo != null) {
            eVar.v("coupon_show_info", shopCouponCouponShowInfo.encode());
        }
        eVar.v("coupon_id", this.couponId);
        eVar.w("is_in_best_options", this.isInBestOptions);
        eVar.w("is_user_select", this.isUserSelect);
        eVar.w("can_use", this.canUse);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = this.couponShowInfo;
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.couponId, (shopCouponCouponShowInfo == null ? 0 : shopCouponCouponShowInfo.hashCode()) * 31, 31);
        boolean z16 = this.isInBestOptions;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (m3 + i3) * 31;
        boolean z17 = this.isUserSelect;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z18 = this.canUse;
        return i18 + (z18 ? 1 : z18 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponOrderInfo(couponShowInfo=");
        m3.append(this.couponShowInfo);
        m3.append(", couponId=");
        m3.append(this.couponId);
        m3.append(", isInBestOptions=");
        m3.append(this.isInBestOptions);
        m3.append(", isUserSelect=");
        m3.append(this.isUserSelect);
        m3.append(", canUse=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.canUse, ')');
    }

    public ShopCouponCouponOrderInfo(ShopCouponCouponShowInfo shopCouponCouponShowInfo, String str, boolean z16, boolean z17, boolean z18) {
        this.couponShowInfo = shopCouponCouponShowInfo;
        this.couponId = str;
        this.isInBestOptions = z16;
        this.isUserSelect = z17;
        this.canUse = z18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponCouponOrderInfo)) {
            return false;
        }
        ShopCouponCouponOrderInfo shopCouponCouponOrderInfo = (ShopCouponCouponOrderInfo) obj;
        return Intrinsics.areEqual(this.couponShowInfo, shopCouponCouponOrderInfo.couponShowInfo) && Intrinsics.areEqual(this.couponId, shopCouponCouponOrderInfo.couponId) && this.isInBestOptions == shopCouponCouponOrderInfo.isInBestOptions && this.isUserSelect == shopCouponCouponOrderInfo.isUserSelect && this.canUse == shopCouponCouponOrderInfo.canUse;
    }

    public /* synthetic */ ShopCouponCouponOrderInfo(ShopCouponCouponShowInfo shopCouponCouponShowInfo, String str, boolean z16, boolean z17, boolean z18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, "", false, false, false);
    }
}
