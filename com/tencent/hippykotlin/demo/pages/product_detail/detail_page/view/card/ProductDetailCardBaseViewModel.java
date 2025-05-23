package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public abstract class ProductDetailCardBaseViewModel extends ProductDetailBaseViewModel implements IProductDetailCardViewModel {
    public final boolean disableNightMode;

    public /* synthetic */ ProductDetailCardBaseViewModel(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public boolean isShowCard() {
        return true;
    }

    public ProductDetailCardBaseViewModel(boolean z16) {
        this.disableNightMode = z16;
    }
}
