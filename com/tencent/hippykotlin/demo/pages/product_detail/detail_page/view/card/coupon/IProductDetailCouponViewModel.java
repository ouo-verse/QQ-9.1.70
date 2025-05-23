package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import java.util.ArrayList;

/* loaded from: classes31.dex */
public interface IProductDetailCouponViewModel {
    ArrayList<ProductDetailLabelInfo> couponList();

    void onTap();

    boolean shouldShow();

    boolean showGetCouponBtn();
}
