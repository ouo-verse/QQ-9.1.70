package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.event.Event;

/* loaded from: classes31.dex */
public class ProductDetailPendantView extends ComposeView<ProductDetailPendantAttr, ProductDetailEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ProductDetailEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public ProductDetailPendantAttr createAttr() {
        return new ProductDetailPendantAttr();
    }
}
