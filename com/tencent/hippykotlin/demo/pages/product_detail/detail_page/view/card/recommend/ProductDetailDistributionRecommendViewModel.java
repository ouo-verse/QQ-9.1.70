package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.QQECShopProductCard;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionRecommendViewModel implements IProductDetailCardViewModel {
    public final QQECShopProductCard info;
    public IReportParamsBuilder reportParams;

    public ProductDetailDistributionRecommendViewModel(QQECShopProductCard qQECShopProductCard, IReportParamsBuilder iReportParamsBuilder) {
        this.info = qQECShopProductCard;
        this.reportParams = iReportParamsBuilder;
    }

    public final ProductDetailLabelInfo[] couponList() {
        ArrayList<ProductDetailLabelInfo> arrayList = this.info.prodTags;
        if (arrayList != null) {
            Object[] array = arrayList.toArray(new ProductDetailLabelInfo[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            ProductDetailLabelInfo[] productDetailLabelInfoArr = (ProductDetailLabelInfo[]) array;
            if (productDetailLabelInfoArr != null) {
                return productDetailLabelInfoArr;
            }
        }
        return new ProductDetailLabelInfo[0];
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailDistributionRecommendView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final boolean isShowCard() {
        return true;
    }
}
