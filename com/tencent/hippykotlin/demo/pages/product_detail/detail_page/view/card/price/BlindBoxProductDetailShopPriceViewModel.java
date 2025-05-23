package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailPrice;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailShopPriceViewModel extends ProductDetailCardBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailShopPriceViewModel.class, "shouldShowCountDown", "getShouldShowCountDown()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(BlindBoxProductDetailShopPriceViewModel.class, "countdownSec", "getCountdownSec()J", 0)};
    public final ReadWriteProperty countdownSec$delegate;
    public final boolean disableNightMode;
    public final ProductDetailInfo info;
    public final ReadWriteProperty shouldShowCountDown$delegate;

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new BlindBoxProductDetailShopPriceView();
    }

    public final long getCountdownSec() {
        return ((Number) this.countdownSec$delegate.getValue(this, $$delegatedProperties[1])).longValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public final boolean getShouldShowCountDown() {
        return ((Boolean) this.shouldShowCountDown$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final String priceTxt() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailProduct productDetailProduct;
        ProductDetailPrice productDetailPrice;
        String str;
        ProductDetailInfo productDetailInfo = this.info;
        return (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailPrice = productDetailProduct.price) == null || (str = productDetailPrice.priceTxt) == null) ? "" : str;
    }

    public BlindBoxProductDetailShopPriceViewModel(String str) {
        super(true);
        this.disableNightMode = true;
        this.shouldShowCountDown$delegate = c.a(Boolean.FALSE);
        this.countdownSec$delegate = c.a(0L);
        this.info = ProductDetailShopRepository.INSTANCE.getProductInfoCache(str);
    }
}
