package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon.SelectCouponViewModel;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class SelectCouponViewModelKt {
    public static final SelectCouponViewModel.PageData optPageData(SelectCouponViewModel.PageState pageState) {
        if (pageState instanceof SelectCouponViewModel.PageState.Loading) {
            return ((SelectCouponViewModel.PageState.Loading) pageState).oldPageData;
        }
        if (pageState instanceof SelectCouponViewModel.PageState.Succeed) {
            return ((SelectCouponViewModel.PageState.Succeed) pageState).pageData;
        }
        return null;
    }
}
