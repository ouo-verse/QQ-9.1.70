package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;

/* loaded from: classes31.dex */
public abstract class ProductDetailTableCardViewModel extends ProductDetailCardBaseViewModel implements IProductDetailTableCardViewModel {
    public final boolean disableNightMode;

    public ProductDetailTableCardViewModel(boolean z16) {
        super(z16);
        this.disableNightMode = z16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public boolean getDisableNightMode() {
        return this.disableNightMode;
    }
}
