package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailServiceItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Service;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionServicesViewModel extends ProductDetailServicesViewModel {
    public final ProductDetailDistributionInfo info;
    public final String spuId;

    public ProductDetailDistributionServicesViewModel(String str) {
        super(str);
        this.spuId = str;
        this.info = ProductDetailDistributionRepository.INSTANCE.getProductInfoCache(getSpuId());
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopServicesView();
    }

    public final String getSpuId() {
        return this.spuId;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.IProductDetailServicesViewModel
    public final void onTapEvent() {
        SellerProductCardRsp sellerProductCardRsp;
        Service service;
        SellerProductCardRsp sellerProductCardRsp2;
        Service service2;
        ArrayList<ProductDetailServiceItem> arrayList;
        ProductDetailDistributionRepository productDetailDistributionRepository = ProductDetailDistributionRepository.INSTANCE;
        ProductDetailDistributionInfo detailInfo = ProductDetailDistributionRepository.cache.getDetailInfo(this.spuId);
        if (((detailInfo == null || (sellerProductCardRsp2 = detailInfo.detail) == null || (service2 = sellerProductCardRsp2.shopService) == null || (arrayList = service2.services) == null) ? 0 : arrayList.size()) > 1) {
            ArrayList<ProductDetailServiceItem> arrayList2 = (detailInfo == null || (sellerProductCardRsp = detailInfo.detail) == null || (service = sellerProductCardRsp.shopService) == null) ? null : service.services;
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
        SellerProductCardRsp sellerProductCardRsp;
        Service service;
        ArrayList<ProductDetailServiceItem> arrayList;
        ArrayList arrayList2 = new ArrayList();
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        if (productDetailDistributionInfo != null && (sellerProductCardRsp = productDetailDistributionInfo.detail) != null && (service = sellerProductCardRsp.shopService) != null && (arrayList = service.services) != null) {
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
        SellerProductCardRsp sellerProductCardRsp;
        Service service;
        ArrayList<ProductDetailServiceItem> arrayList;
        ProductDetailDistributionRepository productDetailDistributionRepository = ProductDetailDistributionRepository.INSTANCE;
        ProductDetailDistributionInfo detailInfo = ProductDetailDistributionRepository.cache.getDetailInfo(this.spuId);
        return ((detailInfo == null || (sellerProductCardRsp = detailInfo.detail) == null || (service = sellerProductCardRsp.shopService) == null || (arrayList = service.services) == null) ? 0 : arrayList.size()) > 1;
    }
}
