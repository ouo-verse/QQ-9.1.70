package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.QQECShopProductCard;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class ProductDetailShopRecommendViewModel implements IProductDetailCardViewModel {
    public final QQECShopProductCard info;
    public IReportParamsBuilder reportParams;

    public ProductDetailShopRecommendViewModel(QQECShopProductCard qQECShopProductCard, IReportParamsBuilder iReportParamsBuilder) {
        this.info = qQECShopProductCard;
        this.reportParams = iReportParamsBuilder;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopRecommendView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        return true;
    }
}
