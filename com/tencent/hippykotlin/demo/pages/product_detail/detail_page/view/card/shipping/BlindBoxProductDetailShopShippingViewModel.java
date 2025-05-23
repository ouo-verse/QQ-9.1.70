package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailService;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailShopShippingViewModel extends ProductDetailShippingViewModel {
    public final String spuId;

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopShippingView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShippingViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.IProductDetailShippingViewModel
    public final void handleTapCard() {
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("title", "\u7269\u6d41");
        m3.v("content", shippingText());
        Unit unit = Unit.INSTANCE;
        BridgeModule.openPage$default(currentBridgeModule, "mqqapi://ecommerce/open?target=58&is_trans_activity=1", false, m3, null, 26);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailService productDetailService;
        String str;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        if (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailService = productDetailProductCardRsp.shopService) == null || (str = productDetailService.shippingTips) == null) {
            return false;
        }
        return str.length() > 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.IProductDetailShippingViewModel
    public final String shippingText() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailService productDetailService;
        String str;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        return (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailService = productDetailProductCardRsp.shopService) == null || (str = productDetailService.shippingTips) == null) ? "" : str;
    }

    public BlindBoxProductDetailShopShippingViewModel(String str) {
        super(true);
        this.spuId = str;
    }
}
