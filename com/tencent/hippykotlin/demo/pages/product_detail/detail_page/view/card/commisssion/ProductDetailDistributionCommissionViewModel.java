package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionCommissionViewModel implements IProductDetailCardViewModel {
    public final ProductDetailDistributionInfo info;

    public ProductDetailDistributionCommissionViewModel(String str) {
        this.info = ProductDetailDistributionRepository.INSTANCE.getProductInfoCache(str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailDistributionCommissionView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        return true;
    }
}
