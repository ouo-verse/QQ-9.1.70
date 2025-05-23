package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionInfo {
    public final ProductReviewGetsRsp comment;
    public final SellerProductCardRsp detail;

    public ProductDetailDistributionInfo(SellerProductCardRsp sellerProductCardRsp, ProductReviewGetsRsp productReviewGetsRsp) {
        this.detail = sellerProductCardRsp;
        this.comment = productReviewGetsRsp;
    }

    public final boolean isValid() {
        return this.detail.spuId.length() > 0;
    }
}
