package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Product;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProperty;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionTableCardViewModel extends ProductDetailTableCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailDistributionTableCardViewModel.class, "isExpandedValue", "isExpandedValue()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailDistributionTableCardViewModel.class, "tableDataList", "getTableDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final int defaultDisplayLength;
    public final boolean disableNightMode;
    public ProductDetailDistributionInfo info;
    public final ReadWriteProperty isExpandedValue$delegate;
    public final String spuId;
    public final ReadWriteProperty tableDataList$delegate;

    public ProductDetailDistributionTableCardViewModel(String str, boolean z16) {
        super(z16);
        this.spuId = str;
        this.disableNightMode = z16;
        this.isExpandedValue$delegate = c.a(Boolean.FALSE);
        this.info = ProductDetailDistributionRepository.INSTANCE.getProductInfoCache(getSpuId());
        this.tableDataList$delegate = c.b();
        this.defaultDisplayLength = 3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.IProductDetailTableCardViewModel
    public final void cellClickEvent(ProductDetailProperty productDetailProperty) {
        if (Intrinsics.areEqual(productDetailProperty.name, "\u54c1\u724c")) {
            Utils.INSTANCE.currentBridgeModule().callNativeMethod("humanVerification", new e(), null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel
    public final ComposeView<ProductDetailCardAttr, ProductDetailEvent> getCardView() {
        return new ProductDetailTableCardView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.ProductDetailTableCardViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailCardBaseViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return this.disableNightMode;
    }

    public final String getSpuId() {
        return this.spuId;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<ProductDetailProperty> getTableDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.tableDataList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.IProductDetailTableCardViewModel
    public final void initTableData() {
        SellerProductCardRsp sellerProductCardRsp;
        Product product;
        ArrayList<ProductDetailProperty> arrayList;
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (arrayList = product.properties) == null) {
            return;
        }
        this.isExpandedValue$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(arrayList.size() <= this.defaultDisplayLength));
        getTableDataList().addAll(arrayList.subList(0, Math.min(this.defaultDisplayLength, arrayList.size())));
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.IProductDetailTableCardViewModel
    public final boolean isExpanded() {
        return ((Boolean) this.isExpandedValue$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.IProductDetailTableCardViewModel
    public final void switchToFullData() {
        SellerProductCardRsp sellerProductCardRsp;
        Product product;
        ArrayList<ProductDetailProperty> arrayList;
        this.isExpandedValue$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
        getTableDataList().clear();
        ProductDetailDistributionInfo productDetailDistributionInfo = this.info;
        if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (arrayList = product.properties) == null) {
            return;
        }
        getTableDataList().addAll(arrayList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.table.IProductDetailTableCardViewModel
    public final com.tencent.kuikly.core.reactive.collection.c<ProductDetailProperty> tableData() {
        return getTableDataList();
    }
}
