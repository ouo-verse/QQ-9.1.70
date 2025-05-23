package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel;

import java.util.ArrayList;

/* loaded from: classes33.dex */
public final class MyCouponListPageViewModel {
    public final String pagerId;
    public ArrayList<IMyCouponListViewModel> tabPageViewModels = new ArrayList<>();

    public MyCouponListPageViewModel(String str) {
        this.pagerId = str;
        for (MyCouponTabPageType myCouponTabPageType : MyCouponTabPageType.values()) {
            ArrayList<IMyCouponListViewModel> arrayList = this.tabPageViewModels;
            MyCouponListViewModel myCouponListViewModel = new MyCouponListViewModel(this.pagerId);
            myCouponListViewModel.setPageType(myCouponTabPageType);
            myCouponListViewModel.setBShowCount(myCouponTabPageType.bShowCount);
            myCouponListViewModel.setShow(myCouponTabPageType.ordinal() == 0);
            myCouponListViewModel.setTabTitle(myCouponTabPageType.title);
            arrayList.add(myCouponListViewModel);
        }
    }
}
