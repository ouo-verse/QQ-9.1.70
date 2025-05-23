package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Product;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import java.util.ArrayList;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionCouponViewModel extends ProductDetailCardBaseViewModel implements IProductDetailCouponViewModel {
    public final ProductDetailDistributionInfo info;

    public ProductDetailDistributionCouponViewModel(String str, boolean z16) {
        super(z16);
        this.info = ProductDetailDistributionRepository.INSTANCE.getProductInfoCache(str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.IProductDetailCouponViewModel
    public final ArrayList<ProductDetailLabelInfo> couponList() {
        SellerProductCardRsp sellerProductCardRsp;
        ArrayList<ProductDetailLabelInfo> arrayList;
        ArrayList<ProductDetailLabelInfo> arrayList2 = new ArrayList<>();
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        return (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (arrayList = sellerProductCardRsp.prodTags) == null) ? arrayList2 : arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopCouponView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.IProductDetailCouponViewModel
    public final boolean shouldShow() {
        SellerProductCardRsp sellerProductCardRsp;
        Product product;
        ArrayList<ProductDetailLabelInfo> arrayList;
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        return (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (arrayList = product.prodTags) == null || !(arrayList.isEmpty() ^ true)) ? false : true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.IProductDetailCouponViewModel
    public final boolean showGetCouponBtn() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.IProductDetailCouponViewModel
    public final void onTap() {
    }
}
