package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class ProductDetailShopHostBottomViewModel implements IProductDetailPendantViewModel {
    public final String spuId;

    public ProductDetailShopHostBottomViewModel(String str) {
        this.spuId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new ProductDetailShopHostBottomView();
    }
}
