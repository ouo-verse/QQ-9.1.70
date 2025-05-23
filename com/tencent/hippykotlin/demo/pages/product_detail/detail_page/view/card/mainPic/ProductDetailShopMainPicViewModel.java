package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailPendantInfo;
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
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopMainPicViewModel extends ProductDetailMainPicViewModel {
    public final String spuId;

    public ProductDetailShopMainPicViewModel(String str, boolean z16) {
        super(z16);
        this.spuId = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.IProductDetailMainPicViewModel
    public final String coverPendent() {
        ProductDetailProductCardRsp productDetailProductCardRsp;
        ProductDetailProduct productDetailProduct;
        ProductDetailPendantInfo productDetailPendantInfo;
        String str;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        return (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailPendantInfo = productDetailProduct.pendant) == null || (str = productDetailPendantInfo.coverUrl) == null) ? "" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopMainPicView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.IProductDetailMainPicViewModel
    public final List<String> picsUrl() {
        ProductDetailProduct productDetailProduct;
        ArrayList<ProductDetailPicInfo> arrayList;
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        if (detailInfo != null) {
            ArrayList arrayList2 = new ArrayList();
            ProductDetailProductCardRsp productDetailProductCardRsp = detailInfo.detail;
            if (productDetailProductCardRsp == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (arrayList = productDetailProduct.mainPics) == null) {
                return arrayList2;
            }
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ProductDetailPicInfo) it.next()).thumbnailUrl);
            }
            return arrayList2;
        }
        return new ArrayList();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.IProductDetailMainPicViewModel
    public final void showPhotoBrowser(int i3) {
        Object[] array = picsUrl().toArray(new String[0]);
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
