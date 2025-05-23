package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon;

import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon.ObtainCouponViewModel;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ObtainCouponViewModelKt {
    public static final ObtainCouponViewModel.PageData optPageData(ObtainCouponViewModel.PageState pageState) {
        if (pageState instanceof ObtainCouponViewModel.PageState.Loading) {
            ((ObtainCouponViewModel.PageState.Loading) pageState).getClass();
            return null;
        }
        if (pageState instanceof ObtainCouponViewModel.PageState.Succeed) {
            return ((ObtainCouponViewModel.PageState.Succeed) pageState).pageData;
        }
        return null;
    }
}
