package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;

/* loaded from: classes31.dex */
public interface IProductDetailPageUIData {
    ProductDetailPageState detailState();

    float detailViewTopOffset();

    void refreshData();

    void setPageDelegate(IProductDetailPageDelegate iProductDetailPageDelegate);
}
