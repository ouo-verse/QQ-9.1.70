package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel;

/* loaded from: classes31.dex */
public abstract class ProductDetailSectionTitleViewModel extends ProductDetailCardBaseViewModel {
    public final boolean disableNightMode;

    public /* synthetic */ ProductDetailSectionTitleViewModel(String str, String str2, boolean z16) {
        this(z16);
    }

    public String cardFrameChangeEventName() {
        return null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public boolean isGradientBackground() {
        return false;
    }

    public ProductDetailSectionTitleViewModel(boolean z16) {
        super(z16);
        this.disableNightMode = z16;
    }
}
