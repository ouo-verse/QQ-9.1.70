package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class ProductDetailEmptyViewModel extends ProductDetailCardBaseViewModel {
    public final boolean disableNightMode;
    public float height;

    public ProductDetailEmptyViewModel() {
        this(0.0f, false, 3, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new EmptyView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public /* synthetic */ ProductDetailEmptyViewModel(float f16, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0.0f, false);
    }

    public ProductDetailEmptyViewModel(float f16, boolean z16) {
        super(z16);
        this.height = f16;
        this.disableNightMode = z16;
    }
}
