package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailPrice;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class ProductDetailShopPriceViewModel implements IProductDetailCardViewModel {
    public final ProductDetailInfo info;

    public ProductDetailShopPriceViewModel(String str) {
        this.info = ProductDetailShopRepository.INSTANCE.getProductInfoCache(str);
    }

    public final String couponPrice() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailProduct productDetailProduct;
        ProductDetailPrice productDetailPrice;
        ProductDetailProductCardRsp productDetailProductCardRsp2;
        ProductDetailProduct productDetailProduct2;
        ProductDetailPrice productDetailPrice2;
        String str;
        ProductDetailInfo productDetailInfo = this.info;
        boolean z16 = false;
        if (productDetailInfo != null && (productDetailProductCardRsp2 = productDetailInfo.detail) != null && (productDetailProduct2 = productDetailProductCardRsp2.product) != null && (productDetailPrice2 = productDetailProduct2.price) != null && (str = productDetailPrice2.discountPriceTxt) != null) {
            if (str.length() == 0) {
                z16 = true;
            }
        }
        if (z16) {
            return "";
        }
        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('\u00a5');
        ProductDetailInfo productDetailInfo2 = this.info;
        m3.append((productDetailInfo2 == null || (productDetailProductCardRsp = productDetailInfo2.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailPrice = productDetailProduct.price) == null) ? null : productDetailPrice.discountPriceTxt);
        String sb5 = m3.toString();
        return sb5 == null ? "" : sb5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopPriceView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        return true;
    }
}
