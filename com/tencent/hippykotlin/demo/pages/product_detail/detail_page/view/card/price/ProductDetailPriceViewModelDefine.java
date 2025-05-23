package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailDeliveryInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceViewModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public enum ProductDetailPriceViewModelDefine {
    /* JADX INFO: Fake field, exist only in values array */
    SHOP(new Function1<e, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceViewModel$Companion$isThePriceViewModel$1
        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Boolean invoke(e eVar) {
            return Boolean.TRUE;
        }
    }, new Function1<e, ProductDetailShopPriceViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceViewModel$Companion$newPriceViewModel$1
        @Override // kotlin.jvm.functions.Function1
        public final ProductDetailShopPriceViewModel invoke(e eVar) {
            return new ProductDetailShopPriceViewModel(eVar.p("spu_id"));
        }
    }),
    /* JADX INFO: Fake field, exist only in values array */
    PRESALE(new Function1<e, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceViewModel$Companion$isThePriceViewModel$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(e eVar) {
            ProductDetailProductCardRsp productDetailProductCardRsp;
            ProductDetailDeliveryInfo productDetailDeliveryInfo;
            e eVar2 = eVar;
            ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
            ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(eVar2.p("spu_id"));
            boolean z16 = false;
            if (((detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailDeliveryInfo = productDetailProductCardRsp.deliveryInfo) == null || productDetailDeliveryInfo.deliveryMode != 1) ? false : true) && ProductDetailPreSalePriceViewModel.Companion.access$getIsInPreSale(ProductDetailPreSalePriceViewModel.Companion, eVar2.p("spu_id"))) {
                z16 = true;
            }
            return Boolean.valueOf(z16);
        }
    }, new Function1<e, ProductDetailPreSalePriceViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailPreSalePriceViewModel$Companion$newPriceViewModel$1
        @Override // kotlin.jvm.functions.Function1
        public final ProductDetailPreSalePriceViewModel invoke(e eVar) {
            return new ProductDetailPreSalePriceViewModel(eVar.p("spu_id"));
        }
    }),
    /* JADX INFO: Fake field, exist only in values array */
    LIVE(new Function1<e, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceViewModel$Companion$isThePriceViewModel$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(e eVar) {
            ProductDetailProductCardRsp productDetailProductCardRsp;
            ProductDetailProductCardRsp productDetailProductCardRsp2;
            ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
            ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(eVar.p("spu_id"));
            Integer num = null;
            ProductDetailActiveInfo productDetailActiveInfo = (detailInfo == null || (productDetailProductCardRsp2 = detailInfo.detail) == null) ? null : productDetailProductCardRsp2.activeInfo;
            boolean z16 = false;
            int i3 = productDetailActiveInfo != null ? productDetailActiveInfo.activeDetailStatus : 0;
            Integer valueOf = productDetailActiveInfo != null ? Integer.valueOf(productDetailActiveInfo.activeType) : null;
            if (detailInfo != null && (productDetailProductCardRsp = detailInfo.detail) != null) {
                num = Integer.valueOf(productDetailProductCardRsp.status);
            }
            if (num != null && num.intValue() == 1 && valueOf != null && valueOf.intValue() == 1 && (i3 == 1 || i3 == 2)) {
                z16 = true;
            }
            return Boolean.valueOf(z16);
        }
    }, new Function1<e, ProductDetailLivePriceViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailLivePriceViewModel$Companion$newPriceViewModel$1
        @Override // kotlin.jvm.functions.Function1
        public final ProductDetailLivePriceViewModel invoke(e eVar) {
            return new ProductDetailLivePriceViewModel(eVar.p("spu_id"));
        }
    });

    public final Function1<e, Boolean> isThePriceViewModelBlock;
    public final Function1<e, IProductDetailCardViewModel> newPriceViewModelBLock;

    static {
        ProductDetailPreSalePriceViewModel.Companion.getClass();
        ProductDetailLivePriceViewModel.Companion.getClass();
    }

    ProductDetailPriceViewModelDefine(Function1 function1, Function1 function12) {
        this.isThePriceViewModelBlock = function1;
        this.newPriceViewModelBLock = function12;
    }
}
