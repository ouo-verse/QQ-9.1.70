package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductReviewGetsRsp;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailInfo {
    public ProductReviewGetsRsp comment;
    public final ProductDetailProductCardRsp detail;

    public ProductDetailInfo(ProductDetailProductCardRsp productDetailProductCardRsp, ProductReviewGetsRsp productReviewGetsRsp) {
        this.detail = productDetailProductCardRsp;
        this.comment = productReviewGetsRsp;
    }

    public final int hashCode() {
        int hashCode = this.detail.hashCode() * 31;
        ProductReviewGetsRsp productReviewGetsRsp = this.comment;
        return hashCode + (productReviewGetsRsp == null ? 0 : productReviewGetsRsp.hashCode());
    }

    public final boolean isValid() {
        return this.detail.spuId.length() > 0;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailInfo(detail=");
        m3.append(this.detail);
        m3.append(", comment=");
        m3.append(this.comment);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailInfo)) {
            return false;
        }
        ProductDetailInfo productDetailInfo = (ProductDetailInfo) obj;
        return Intrinsics.areEqual(this.detail, productDetailInfo.detail) && Intrinsics.areEqual(this.comment, productDetailInfo.comment);
    }
}
