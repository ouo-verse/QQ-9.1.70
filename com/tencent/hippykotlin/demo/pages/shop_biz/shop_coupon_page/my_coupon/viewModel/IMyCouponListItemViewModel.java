package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel;

import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemModel;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IMyCouponListItemViewModel {
    void clickItem();

    CommonCouponItemModel couponItemModel();

    boolean isCanUseCoupon();

    boolean isInvalidSkeleton();

    String itemText();

    String itemTextToken();
}
