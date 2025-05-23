package com.tencent.hippykotlin.demo.pages.product_detail.detail_page;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class ProductDetailPage$pageDelegate$1 implements IProductDetailPageDelegate {
    public final /* synthetic */ ProductDetailPage $ctx;
    public final /* synthetic */ ProductDetailPage this$0;

    public ProductDetailPage$pageDelegate$1(ProductDetailPage productDetailPage, ProductDetailPage productDetailPage2) {
        this.$ctx = productDetailPage;
        this.this$0 = productDetailPage2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate
    public final void closePage(e eVar) {
        if (SchemeParamExtensionKt.schemeIsHalf(this.$ctx.getPagerData().n())) {
            this.this$0.closePageData = eVar;
            ProductDetailPage productDetailPage = this.$ctx;
            productDetailPage.isHalfAppear$delegate.setValue(productDetailPage, ProductDetailPage.$$delegatedProperties[0], Boolean.FALSE);
            return;
        }
        BridgeModule.closePage$default(Utils.INSTANCE.bridgeModule(this.this$0.getPagerId()), eVar, null, 2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate
    public final void setContentOffset(float f16, boolean z16) {
        ProductDetailView b16;
        aa<ProductDetailView> aaVar = this.$ctx.detailRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        b16.setContentOffsetY(f16, z16);
    }
}
