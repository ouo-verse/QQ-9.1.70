package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Service;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionShippingViewModel extends ProductDetailShippingViewModel {
    public final ProductDetailDistributionInfo info;
    public final String spuId;

    public ProductDetailDistributionShippingViewModel(String str) {
        super(str);
        this.spuId = str;
        this.info = ProductDetailDistributionRepository.INSTANCE.getProductInfoCache(getSpuId());
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopShippingView();
    }

    public final String getSpuId() {
        return this.spuId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.IProductDetailShippingViewModel
    public final void handleTapCard() {
        String str;
        SellerProductCardRsp sellerProductCardRsp;
        Service service;
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("title", "\u7269\u6d41");
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (service = sellerProductCardRsp.shopService) == null || (str = service.shippingTips) == null) {
            str = "";
        }
        m3.v("content", str);
        Unit unit = Unit.INSTANCE;
        BridgeModule.openPage$default(currentBridgeModule, "mqqapi://ecommerce/open?target=58&is_trans_activity=1", false, m3, null, 26);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        SellerProductCardRsp sellerProductCardRsp;
        Service service;
        String str;
        ProductDetailDistributionRepository productDetailDistributionRepository = ProductDetailDistributionRepository.INSTANCE;
        ProductDetailDistributionInfo detailInfo = ProductDetailDistributionRepository.cache.getDetailInfo(this.spuId);
        if (detailInfo == null || (sellerProductCardRsp = detailInfo.detail) == null || (service = sellerProductCardRsp.shopService) == null || (str = service.shippingTips) == null) {
            return false;
        }
        return str.length() > 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.IProductDetailShippingViewModel
    public final String shippingText() {
        SellerProductCardRsp sellerProductCardRsp;
        Service service;
        String str;
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        return (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (service = sellerProductCardRsp.shopService) == null || (str = service.shippingTips) == null) ? "" : str;
    }
}
