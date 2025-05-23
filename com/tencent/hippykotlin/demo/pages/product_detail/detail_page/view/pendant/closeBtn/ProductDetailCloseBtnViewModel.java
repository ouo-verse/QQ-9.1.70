package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.kuikly.core.base.ComposeView;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class ProductDetailCloseBtnViewModel implements IProductDetailPendantViewModel {
    public final IProductDetailViewModel detailViewModel;
    public final IProductDetailPageDelegate pageDelegate;

    public ProductDetailCloseBtnViewModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new ProductDetailCloseBtnView();
    }

    public ProductDetailCloseBtnViewModel(IProductDetailViewModel iProductDetailViewModel, IProductDetailPageDelegate iProductDetailPageDelegate) {
        this.detailViewModel = iProductDetailViewModel;
        this.pageDelegate = iProductDetailPageDelegate;
    }

    public /* synthetic */ ProductDetailCloseBtnViewModel(IProductDetailViewModel iProductDetailViewModel, IProductDetailPageDelegate iProductDetailPageDelegate, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }
}
