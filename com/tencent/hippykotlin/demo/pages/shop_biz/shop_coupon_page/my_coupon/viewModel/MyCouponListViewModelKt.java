package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponBasicInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponCouponShowInfo;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponUseTimeRule;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service.ShopCouponUserCouponInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MyCouponListViewModelKt {
    public static final boolean access$isFutureCoupon(ShopCouponUserCouponInfo shopCouponUserCouponInfo, String str) {
        ShopCouponCouponBasicInfo shopCouponCouponBasicInfo;
        ShopCouponUseTimeRule shopCouponUseTimeRule;
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = shopCouponUserCouponInfo.couponShowInfo;
        return Utils.INSTANCE.bridgeModule(str).currentTimeStamp() < ((shopCouponCouponShowInfo == null || (shopCouponCouponBasicInfo = shopCouponCouponShowInfo.basicInfo) == null || (shopCouponUseTimeRule = shopCouponCouponBasicInfo.useTimeRule) == null) ? 0L : shopCouponUseTimeRule.beginTime);
    }
}
