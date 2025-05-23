package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;

/* loaded from: classes31.dex */
public abstract class ProductDetailPicturesViewModel extends ProductDetailCardBaseViewModel implements IProductDetailPicturesViewModel {
    public final boolean disableNightMode;
    public final String spuId;

    public /* synthetic */ ProductDetailPicturesViewModel(String str) {
        this(str, false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public ProductDetailPicturesViewModel(String str, boolean z16) {
        super(z16);
        this.spuId = str;
        this.disableNightMode = z16;
    }
}
