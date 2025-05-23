package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class ProductDetailShopRichTitleViewModel extends ProductDetailRichTitleViewModel {
    public final boolean disableNightMode;
    public final String spuId;

    public ProductDetailShopRichTitleViewModel(String str, boolean z16) {
        super(z16);
        this.spuId = str;
        this.disableNightMode = z16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopRichTitleView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailRichTitleViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }
}
