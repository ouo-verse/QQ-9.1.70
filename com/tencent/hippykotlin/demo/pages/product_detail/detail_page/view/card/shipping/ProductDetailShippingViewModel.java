package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;

/* loaded from: classes31.dex */
public abstract class ProductDetailShippingViewModel extends ProductDetailCardBaseViewModel implements IProductDetailShippingViewModel {
    public final boolean disableNightMode;

    public /* synthetic */ ProductDetailShippingViewModel(String str) {
        this(false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public ProductDetailShippingViewModel(boolean z16) {
        super(z16);
        this.disableNightMode = z16;
    }
}
