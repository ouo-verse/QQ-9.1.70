package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.kuikly.core.base.ComposeView;

/* loaded from: classes31.dex */
public interface IProductDetailCardViewModel {
    ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView();

    boolean isShowCard();
}
