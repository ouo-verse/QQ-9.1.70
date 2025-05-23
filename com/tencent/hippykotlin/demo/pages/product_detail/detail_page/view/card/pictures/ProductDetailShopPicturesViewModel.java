package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailPicInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopPicturesViewModel extends ProductDetailPicturesViewModel {
    public IReportParamsBuilder reportParams;

    public ProductDetailShopPicturesViewModel(String str, boolean z16, IReportParamsBuilder iReportParamsBuilder) {
        super(str, z16);
        this.reportParams = iReportParamsBuilder;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailPicturesView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.IProductDetailPicturesViewModel
    public final ArrayList<ProductDetailPicInfo> getDetailPicArray() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailProduct productDetailProduct;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        if (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null) {
            return null;
        }
        return productDetailProduct.detailPictures;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.pictures.IProductDetailPicturesViewModel
    public final void showPhotoBrowser(int i3) {
        IReportParamsBuilder iReportParamsBuilder = this.reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            eCDetailPageReportParamsBuilder.addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addRoomId().addSourceFrom().addContentId();
            Utils utils = Utils.INSTANCE;
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder, utils.currentBridgeModule(), "qstore_prd_detail_pg_detail_ck", "[ProductDetailReporter] reportProductPicClk, event cod = qstore_prd_detail_pg_detail_ck, data = "), utils);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<ProductDetailPicInfo> detailPicArray = getDetailPicArray();
        if (detailPicArray != null) {
            Iterator<T> it = detailPicArray.iterator();
            while (it.hasNext()) {
                arrayList.add(((ProductDetailPicInfo) it.next()).url);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e eVar = new e();
        b bVar = new b();
        for (String str : (String[]) array) {
            bVar.t(str);
        }
        eVar.v("photosUrl", bVar);
        eVar.t("photosIndex", i3);
        currentBridgeModule.showPhotoBrowser(eVar);
    }
}
