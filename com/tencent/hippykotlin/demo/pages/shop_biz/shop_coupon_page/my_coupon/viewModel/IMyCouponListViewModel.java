package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel;

import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.reactive.collection.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IMyCouponListViewModel {
    MyCouponDataStatus getCouponDataStatus();

    String getDisplayTabTitle();

    c<IMyCouponListItemViewModel> getList();

    boolean isLoadFinishing();

    boolean isShow();

    boolean isShowLoadMore();

    void reqFirstPage();

    void reqNextPage();

    void setShow(boolean z16);

    h textColor();
}
