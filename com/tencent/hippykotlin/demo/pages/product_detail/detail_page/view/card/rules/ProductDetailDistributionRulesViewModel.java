package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.rules;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionRulesViewModel extends ProductDetailCardBaseViewModel {
    public final String spuId;

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailDistributionRulesView();
    }

    public ProductDetailDistributionRulesViewModel(String str) {
        super(false, 1, null);
        this.spuId = str;
    }
}
