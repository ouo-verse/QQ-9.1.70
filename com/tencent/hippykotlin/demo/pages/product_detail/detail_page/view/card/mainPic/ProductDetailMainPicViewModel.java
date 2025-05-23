package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;

/* loaded from: classes31.dex */
public abstract class ProductDetailMainPicViewModel extends ProductDetailCardBaseViewModel implements IProductDetailMainPicViewModel {
    public final boolean disableNightMode;

    public /* synthetic */ ProductDetailMainPicViewModel(String str) {
        this(false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public ProductDetailMainPicViewModel(boolean z16) {
        super(z16);
        this.disableNightMode = z16;
    }
}
