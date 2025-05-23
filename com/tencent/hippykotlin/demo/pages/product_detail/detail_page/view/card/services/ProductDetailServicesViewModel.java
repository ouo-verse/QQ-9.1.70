package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;

/* loaded from: classes31.dex */
public abstract class ProductDetailServicesViewModel extends ProductDetailCardBaseViewModel implements IProductDetailServicesViewModel {
    public final boolean disableNightMode;

    public /* synthetic */ ProductDetailServicesViewModel(String str) {
        this(false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public boolean shouldShowArrowIcon() {
        return false;
    }

    public ProductDetailServicesViewModel(boolean z16) {
        super(z16);
        this.disableNightMode = z16;
    }
}
