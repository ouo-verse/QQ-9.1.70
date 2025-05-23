package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailDeliveryInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.cache.ProductDetailShopCache;
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
public final class ProductDetailPreSalePriceViewModel implements IProductDetailCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailPreSalePriceViewModel.class, "remainingTime", "getRemainingTime()Lcom/tencent/hippykotlin/demo/pages/product_detail/detail_page/view/card/price/component/RemainingTime;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailPreSalePriceViewModel.class, "isInPreSale", "isInPreSale()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailPreSalePriceViewModel.class, "sendCountDownEndEvent", "getSendCountDownEndEvent()Ljava/lang/Boolean;", 0)};
    public static final Companion Companion = new Companion();
    public final ProductDetailInfo info;
    public long endTime = getPreSaleEndTime();
    public final ReadWriteProperty remainingTime$delegate = c.a(null);
    public final ReadWriteProperty isInPreSale$delegate = c.a(Boolean.valueOf(getIsInPreSale()));
    public final ReadWriteProperty sendCountDownEndEvent$delegate = c.a(null);

    /* loaded from: classes31.dex */
    public static final class Companion {
        public static final boolean access$getIsInPreSale(Companion companion, String str) {
            ProductDetailProductCardRsp productDetailProductCardRsp;
            ProductDetailDeliveryInfo productDetailDeliveryInfo;
            ProductDetailProductCardRsp productDetailProductCardRsp2;
            ProductDetailDeliveryInfo productDetailDeliveryInfo2;
            ProductDetailProductCardRsp productDetailProductCardRsp3;
            ProductDetailDeliveryInfo productDetailDeliveryInfo3;
            companion.getClass();
            ProductDetailShopCache productDetailShopCache = ProductDetailShopRepository.cache;
            ProductDetailInfo detailInfo = productDetailShopCache.getDetailInfo(str);
            if ((detailInfo == null || (productDetailProductCardRsp3 = detailInfo.detail) == null || (productDetailDeliveryInfo3 = productDetailProductCardRsp3.deliveryInfo) == null || productDetailDeliveryInfo3.deliveryMode != 1) ? false : true) {
                ProductDetailInfo detailInfo2 = productDetailShopCache.getDetailInfo(str);
                if (!((detailInfo2 == null || (productDetailProductCardRsp2 = detailInfo2.detail) == null || (productDetailDeliveryInfo2 = productDetailProductCardRsp2.deliveryInfo) == null) ? false : productDetailDeliveryInfo2.hasEndTime)) {
                    return true;
                }
                ProductDetailInfo detailInfo3 = productDetailShopCache.getDetailInfo(str);
                if (((detailInfo3 == null || (productDetailProductCardRsp = detailInfo3.detail) == null || (productDetailDeliveryInfo = productDetailProductCardRsp.deliveryInfo) == null) ? 0L : productDetailDeliveryInfo.presaleEndTime) >= Utils.INSTANCE.currentBridgeModule().serverTimeMillis() / 1000) {
                    return true;
                }
            }
            return false;
        }
    }

    public ProductDetailPreSalePriceViewModel(String str) {
        this.info = ProductDetailShopRepository.INSTANCE.getProductInfoCache(str);
    }

    public final void countDown() {
        long serverTimeMillis = Utils.INSTANCE.currentBridgeModule().serverTimeMillis() / 1000;
        long j3 = this.endTime;
        if (serverTimeMillis > j3) {
            ReadWriteProperty readWriteProperty = this.isInPreSale$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            readWriteProperty.setValue(this, kPropertyArr[1], Boolean.FALSE);
            this.sendCountDownEndEvent$delegate.setValue(this, kPropertyArr[2], Boolean.TRUE);
            return;
        }
        long j16 = j3 - serverTimeMillis;
        long j17 = 86400;
        long j18 = j16 / j17;
        long j19 = j16 % j17;
        long j26 = 3600;
        long j27 = j19 / j26;
        long j28 = j19 % j26;
        long j29 = 60;
        this.remainingTime$delegate.setValue(this, $$delegatedProperties[0], new RemainingTime(j18, j27, j28 / j29, j28 % j29));
        TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceViewModel$countDown$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ProductDetailPreSalePriceViewModel.this.countDown();
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailPreSalePriceView();
    }

    public final boolean getIsInPreSale() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailDeliveryInfo productDetailDeliveryInfo;
        ProductDetailProductCardRsp productDetailProductCardRsp2;
        ProductDetailDeliveryInfo productDetailDeliveryInfo2;
        ProductDetailProductCardRsp productDetailProductCardRsp3;
        ProductDetailDeliveryInfo productDetailDeliveryInfo3;
        ProductDetailInfo productDetailInfo = this.info;
        if (!((productDetailInfo == null || (productDetailProductCardRsp3 = productDetailInfo.detail) == null || (productDetailDeliveryInfo3 = productDetailProductCardRsp3.deliveryInfo) == null || productDetailDeliveryInfo3.deliveryMode != 1) ? false : true)) {
            return false;
        }
        if ((productDetailInfo == null || (productDetailProductCardRsp2 = productDetailInfo.detail) == null || (productDetailDeliveryInfo2 = productDetailProductCardRsp2.deliveryInfo) == null) ? false : productDetailDeliveryInfo2.hasEndTime) {
            return ((productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailDeliveryInfo = productDetailProductCardRsp.deliveryInfo) == null) ? 0L : productDetailDeliveryInfo.presaleEndTime) >= Utils.INSTANCE.currentBridgeModule().serverTimeMillis() / ((long) 1000);
        }
        return true;
    }

    public final long getPreSaleEndTime() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailDeliveryInfo productDetailDeliveryInfo;
        ProductDetailInfo productDetailInfo = this.info;
        if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailDeliveryInfo = productDetailProductCardRsp.deliveryInfo) == null) {
            return 0L;
        }
        return productDetailDeliveryInfo.presaleEndTime;
    }

    public final Boolean getSendCountDownEndEvent() {
        return (Boolean) this.sendCountDownEndEvent$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        return true;
    }
}
