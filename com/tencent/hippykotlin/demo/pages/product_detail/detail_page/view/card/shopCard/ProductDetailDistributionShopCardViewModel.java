package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ButtonItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Shop;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ShopDynamic;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionShopCardViewModel extends ProductDetailNameCardViewModel {
    public final ProductDetailDistributionInfo info = ProductDetailDistributionRepository.INSTANCE.getProductInfoCache(getSpuId());
    public IReportParamsBuilder reportParams;
    public final String spuId;

    public ProductDetailDistributionShopCardViewModel(String str, IReportParamsBuilder iReportParamsBuilder) {
        this.spuId = str;
        this.reportParams = iReportParamsBuilder;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final String buttonText() {
        SellerProductCardRsp sellerProductCardRsp;
        Shop shop;
        ButtonItem buttonItem;
        String str;
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        return (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (shop = sellerProductCardRsp.shop) == null || (buttonItem = shop.button) == null || (str = buttonItem.txt) == null) ? "" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopCardView();
    }

    public final String getSpuId() {
        return this.spuId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final void handleTapCard() {
        SellerProductCardRsp sellerProductCardRsp;
        Shop shop;
        ButtonItem buttonItem;
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (shop = sellerProductCardRsp.shop) == null || (buttonItem = shop.button) == null) {
            return;
        }
        Utils utils = Utils.INSTANCE;
        BridgeModule.openPage$default(utils.currentBridgeModule(), buttonItem.jumpUrl, false, null, null, 30);
        IReportParamsBuilder iReportParamsBuilder = this.reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            eCDetailPageReportParamsBuilder.addPageStateType().addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_store_info_ck", "[ProductDetailReporter] reportStoreInfoClk, event cod = qstore_prd_detail_pg_store_info_ck, data = "), utils);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final String imageUrl() {
        SellerProductCardRsp sellerProductCardRsp;
        Shop shop;
        String str;
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        return (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (shop = sellerProductCardRsp.shop) == null || (str = shop.icon) == null) ? "" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final String subTitle() {
        SellerProductCardRsp sellerProductCardRsp;
        Shop shop;
        ShopDynamic shopDynamic;
        String str;
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        return (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (shop = sellerProductCardRsp.shop) == null || (shopDynamic = shop.dynamic) == null || (str = shopDynamic.sales) == null) ? "" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final String title() {
        SellerProductCardRsp sellerProductCardRsp;
        Shop shop;
        String str;
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        return (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (shop = sellerProductCardRsp.shop) == null || (str = shop.name) == null) ? "" : str;
    }
}
