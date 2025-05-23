package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveTimeRange;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component.RemainingTime;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailLivePriceViewModel implements IProductDetailCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailLivePriceViewModel.class, "remainingTime", "getRemainingTime()Lcom/tencent/hippykotlin/demo/pages/product_detail/detail_page/view/card/price/component/RemainingTime;", 0)};
    public static final Companion Companion = new Companion();
    public final ProductDetailInfo info;
    public final ReadWriteProperty remainingTime$delegate = c.a(null);

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public ProductDetailLivePriceViewModel(String str) {
        this.info = ProductDetailShopRepository.INSTANCE.getProductInfoCache(str);
    }

    public final void countDown() {
        long serverTimeMillis = Utils.INSTANCE.currentBridgeModule().serverTimeMillis() / 1000;
        if (serverTimeMillis > getLiveEndTime()) {
            return;
        }
        long liveEndTime = getLiveEndTime() - serverTimeMillis;
        long j3 = 86400;
        long j16 = liveEndTime / j3;
        long j17 = liveEndTime % j3;
        long j18 = 3600;
        long j19 = j17 / j18;
        long j26 = j17 % j18;
        long j27 = 60;
        this.remainingTime$delegate.setValue(this, $$delegatedProperties[0], new RemainingTime(j16, j19, j26 / j27, j26 % j27));
        TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceViewModel$countDown$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ProductDetailLivePriceViewModel.this.countDown();
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailLivePriceView();
    }

    public final long getLiveEndTime() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailActiveInfo productDetailActiveInfo;
        ProductDetailActiveTimeRange productDetailActiveTimeRange;
        ProductDetailInfo productDetailInfo = this.info;
        if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailActiveInfo = productDetailProductCardRsp.activeInfo) == null || (productDetailActiveTimeRange = productDetailActiveInfo.liveTimeRange) == null) {
            return 0L;
        }
        return productDetailActiveTimeRange.end;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        return true;
    }
}
