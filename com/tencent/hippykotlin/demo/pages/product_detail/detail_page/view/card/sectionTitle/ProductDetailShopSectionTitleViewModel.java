package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public final class ProductDetailShopSectionTitleViewModel extends ProductDetailSectionTitleViewModel {
    public final boolean disableNightMode;
    public final String frameChangeEventName;
    public final boolean isGradientBackgroundValue;
    public final String titleText;

    public /* synthetic */ ProductDetailShopSectionTitleViewModel(String str, String str2, String str3, boolean z16, boolean z17, int i3) {
        this(str, str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? false : z17);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailSectionTitleViewModel
    public final String cardFrameChangeEventName() {
        return this.frameChangeEventName;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailShopSectionTitleView(this.titleText);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailSectionTitleViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailSectionTitleViewModel
    public final boolean isGradientBackground() {
        return this.isGradientBackgroundValue;
    }

    public ProductDetailShopSectionTitleViewModel(String str, String str2, String str3, boolean z16, boolean z17) {
        super(str, str2, z17);
        this.titleText = str2;
        this.frameChangeEventName = str3;
        this.isGradientBackgroundValue = z16;
        this.disableNightMode = z17;
    }
}
