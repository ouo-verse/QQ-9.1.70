package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailService;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailServiceItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes31.dex */
public final class ProductDetailShopServicesViewModel extends ProductDetailServicesViewModel {
    public final boolean disableNightMode;
    public final String spuId;

    public ProductDetailShopServicesViewModel(String str, boolean z16) {
        super(z16);
        this.spuId = str;
        this.disableNightMode = z16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopServicesView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailServicesViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailService productDetailService;
        ArrayList<ProductDetailServiceItem> arrayList;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        return (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailService = productDetailProductCardRsp.shopService) == null || (arrayList = productDetailService.services) == null || !(arrayList.isEmpty() ^ true)) ? false : true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.IProductDetailServicesViewModel
    public final void onTapEvent() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailService productDetailService;
        ProductDetailProductCardRsp productDetailProductCardRsp2;
        ProductDetailService productDetailService2;
        ArrayList<ProductDetailServiceItem> arrayList;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        if (((detailInfo == null || (productDetailProductCardRsp2 = detailInfo.detail) == null || (productDetailService2 = productDetailProductCardRsp2.shopService) == null || (arrayList = productDetailService2.services) == null) ? 0 : arrayList.size()) > 1) {
            ArrayList<ProductDetailServiceItem> arrayList2 = (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailService = productDetailProductCardRsp.shopService) == null) ? null : productDetailService.services;
            if (arrayList2 != null) {
                b bVar = new b();
                Iterator<ProductDetailServiceItem> it = arrayList2.iterator();
                while (it.hasNext()) {
                    bVar.t(it.next().encode());
                }
                Utils.INSTANCE.currentBridgeModule().openLogisticsPage(bVar);
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.IProductDetailServicesViewModel
    public final String servicesText() {
        String joinToString$default;
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailService productDetailService;
        ArrayList<ProductDetailServiceItem> arrayList;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        ArrayList arrayList2 = new ArrayList();
        if (detailInfo != null && (productDetailProductCardRsp = detailInfo.detail) != null && (productDetailService = productDetailProductCardRsp.shopService) != null && (arrayList = productDetailService.services) != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ProductDetailServiceItem) it.next()).title);
            }
        }
        if (!arrayList2.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, " \u00b7 ", null, null, 0, null, null, 62, null);
            return joinToString$default;
        }
        return "";
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.IProductDetailServicesViewModel
    public final boolean shouldShow() {
        return !servicesText().equals("");
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailServicesViewModel
    public final boolean shouldShowArrowIcon() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailService productDetailService;
        ArrayList<ProductDetailServiceItem> arrayList;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        return ((detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailService = productDetailProductCardRsp.shopService) == null || (arrayList = productDetailService.services) == null) ? 0 : arrayList.size()) > 1;
    }
}
