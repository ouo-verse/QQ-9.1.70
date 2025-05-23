package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButtonItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailShop;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailShopDynamic;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;

/* loaded from: classes31.dex */
public final class ProductDetailShopCardViewModel extends ProductDetailNameCardViewModel {
    public final e params;
    public IReportParamsBuilder reportParams;
    public final String spuId;
    public ProductDetailInfo info = ProductDetailShopRepository.INSTANCE.getProductInfoCache(getSpuId());
    public final String CLICKID_PARAMS = "qz_gdt";

    public ProductDetailShopCardViewModel(String str, e eVar, IReportParamsBuilder iReportParamsBuilder) {
        this.spuId = str;
        this.params = eVar;
        this.reportParams = iReportParamsBuilder;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final String buttonText() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailShop productDetailShop;
        ProductDetailButtonItem productDetailButtonItem;
        String str;
        ProductDetailInfo productDetailInfo = this.info;
        return (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailShop = productDetailProductCardRsp.shop) == null || (productDetailButtonItem = productDetailShop.button) == null || (str = productDetailButtonItem.txt) == null) ? "" : str;
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
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailShop productDetailShop;
        ProductDetailButtonItem productDetailButtonItem;
        boolean contains$default;
        ProductDetailInfo productDetailInfo = this.info;
        if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailShop = productDetailProductCardRsp.shop) == null || (productDetailButtonItem = productDetailShop.button) == null) {
            return;
        }
        Utils utils = Utils.INSTANCE;
        BridgeModule currentBridgeModule = utils.currentBridgeModule();
        String str = productDetailButtonItem.jumpUrl;
        if (SchemeParamExtensionKt.schemeAmsClickID(this.params).length() > 0) {
            String str2 = this.CLICKID_PARAMS;
            String schemeAmsClickID = SchemeParamExtensionKt.schemeAmsClickID(this.params);
            if (!(str2.length() == 0)) {
                if (!(schemeAmsClickID.length() == 0)) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
                    if (!contains$default) {
                        str = str + Typography.amp + str2 + '=' + schemeAmsClickID;
                    }
                }
            }
        }
        BridgeModule.openPage$default(currentBridgeModule, str, false, null, null, 30);
        IReportParamsBuilder iReportParamsBuilder = this.reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            eCDetailPageReportParamsBuilder.addPageStateType().addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_store_info_ck", "[ProductDetailReporter] reportStoreInfoClk, event cod = qstore_prd_detail_pg_store_info_ck, data = "), utils);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final String imageUrl() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailShop productDetailShop;
        String str;
        ProductDetailInfo productDetailInfo = this.info;
        return (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailShop = productDetailProductCardRsp.shop) == null || (str = productDetailShop.icon) == null) ? "" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final String subTitle() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailShop productDetailShop;
        ProductDetailShopDynamic productDetailShopDynamic;
        String str;
        ProductDetailInfo productDetailInfo = this.info;
        return (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailShop = productDetailProductCardRsp.shop) == null || (productDetailShopDynamic = productDetailShop.dynamic) == null || (str = productDetailShopDynamic.sales) == null) ? "" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shopCard.IProductDetailShopCardViewModel
    public final String title() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailShop productDetailShop;
        String str;
        ProductDetailInfo productDetailInfo = this.info;
        return (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailShop = productDetailProductCardRsp.shop) == null || (str = productDetailShop.name) == null) ? "" : str;
    }
}
