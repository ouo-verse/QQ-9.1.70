package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public class ProductDetailNavBarViewModel extends ProductDetailBaseViewModel implements IProductDetailPendantViewModel {
    public final IProductDetailViewModel detailViewModel;
    public final boolean disableNightMode;
    public final boolean isHalf;
    public final IProductDetailPageDelegate pageDelegate;
    public final String title;

    public ProductDetailNavBarViewModel(String str, boolean z16, IProductDetailPageDelegate iProductDetailPageDelegate, IProductDetailViewModel iProductDetailViewModel, boolean z17) {
        this.title = str;
        this.isHalf = z16;
        this.pageDelegate = iProductDetailPageDelegate;
        this.detailViewModel = iProductDetailViewModel;
        this.disableNightMode = z17;
    }

    public void backBtnPressed() {
        IProductDetailPageDelegate pageDelegate = getPageDelegate();
        if (pageDelegate != null) {
            pageDelegate.closePage(null);
        }
    }

    public String backIconToken() {
        if (isHalf()) {
            if (getDisableNightMode()) {
                return "qecommerce_white_icon_general_close_primary";
            }
            return "qecommerce_skin_icon_nav_close";
        }
        return "qecommerce_skin_icon_nav_arrow_left";
    }

    public IProductDetailViewModel getDetailViewModel() {
        return this.detailViewModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public IProductDetailPageDelegate getPageDelegate() {
        return this.pageDelegate;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new ProductDetailNavBarView(getDetailViewModel());
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isHalf() {
        return this.isHalf;
    }
}
