package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProperty;
import com.tencent.kuikly.core.reactive.collection.c;

/* loaded from: classes31.dex */
public interface IProductDetailTableCardViewModel {
    void cellClickEvent(ProductDetailProperty productDetailProperty);

    void initTableData();

    boolean isExpanded();

    void switchToFullData();

    c<ProductDetailProperty> tableData();
}
