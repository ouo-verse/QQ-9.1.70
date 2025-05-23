package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.module.AddWindowModule;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.cache.ProductDetailDistributionCache;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Product;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DetailDistributionBottomViewModel implements IProductDetailPendantViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DetailDistributionBottomViewModel.class, "addWindowBtnState", "getAddWindowBtnState()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DetailDistributionBottomViewModel.class, "isSample", "isSample()Z", 0)};
    public final ReadWriteProperty addWindowBtnState$delegate;
    public final ReadWriteProperty isSample$delegate;
    public final e params;

    public DetailDistributionBottomViewModel(e eVar) {
        SellerProductCardRsp sellerProductCardRsp;
        SellerProductCardRsp sellerProductCardRsp2;
        this.params = eVar;
        Boolean bool = Boolean.FALSE;
        this.addWindowBtnState$delegate = c.a(bool);
        this.isSample$delegate = c.a(bool);
        final ProductDetailDistributionInfo productInfoCache = ProductDetailDistributionRepository.INSTANCE.getProductInfoCache(SchemeParamExtensionKt.schemeSpuId(eVar));
        boolean z16 = false;
        setAddWindowBtnState((productInfoCache == null || (sellerProductCardRsp2 = productInfoCache.detail) == null || !sellerProductCardRsp2.isAdd) ? false : true);
        if (productInfoCache != null && (sellerProductCardRsp = productInfoCache.detail) != null && sellerProductCardRsp.isSample) {
            z16 = true;
        }
        setSample(z16);
        k.b((k) com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).acquireModule("KRNotifyModule"), "ECWindowAddNotification", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomViewModel.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                boolean equals$default;
                SellerProductCardRsp sellerProductCardRsp3;
                Product product;
                e eVar3 = eVar2;
                String p16 = eVar3 != null ? eVar3.p("productID") : null;
                DetailDistributionBottomViewModel detailDistributionBottomViewModel = DetailDistributionBottomViewModel.this;
                ProductDetailDistributionInfo productDetailDistributionInfo = productInfoCache;
                equals$default = StringsKt__StringsJVMKt.equals$default(p16, (productDetailDistributionInfo == null || (sellerProductCardRsp3 = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp3.product) == null) ? null : product.spuId, false, 2, null);
                detailDistributionBottomViewModel.addWindowBtnState$delegate.setValue(detailDistributionBottomViewModel, DetailDistributionBottomViewModel.$$delegatedProperties[0], Boolean.valueOf(equals$default));
                ProductDetailDistributionInfo productDetailDistributionInfo2 = productInfoCache;
                SellerProductCardRsp sellerProductCardRsp4 = productDetailDistributionInfo2 != null ? productDetailDistributionInfo2.detail : null;
                if (sellerProductCardRsp4 != null) {
                    sellerProductCardRsp4.isAdd = DetailDistributionBottomViewModel.this.getAddWindowBtnState();
                }
                ProductDetailDistributionInfo productDetailDistributionInfo3 = productInfoCache;
                if (productDetailDistributionInfo3 != null) {
                    DetailDistributionBottomViewModel.this.getClass();
                    ProductDetailDistributionCache productDetailDistributionCache = new ProductDetailDistributionCache();
                    SellerProductCardRsp sellerProductCardRsp5 = productDetailDistributionInfo3.detail;
                    productDetailDistributionCache.updateDetailCache(sellerProductCardRsp5.spuId, sellerProductCardRsp5);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    public final ButtonInfo currentButtonInfo() {
        boolean addWindowBtnState = getAddWindowBtnState();
        if (addWindowBtnState) {
            return new ButtonInfo("\u5df2\u6dfb\u52a0", new j[]{new j(new h("qecommerce_skin_color_btn_gradient01_disable"), 0.0f), new j(new h("qecommerce_skin_color_btn_gradient02_disable"), 1.0f)}, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomViewModel$currentButtonInfo$1
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    return Unit.INSTANCE;
                }
            });
        }
        if (!addWindowBtnState) {
            return new ButtonInfo("\u52a0\u6a71\u7a97", new j[]{new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f)}, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomViewModel$currentButtonInfo$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    DetailDistributionBottomViewModel detailDistributionBottomViewModel = DetailDistributionBottomViewModel.this;
                    detailDistributionBottomViewModel.getClass();
                    ((AddWindowModule) com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).acquireModule("HRAddWindowModule")).addProductToWindow(detailDistributionBottomViewModel.params.p("spu_id"), "", 101);
                    return Unit.INSTANCE;
                }
            });
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getAddWindowBtnState() {
        return ((Boolean) this.addWindowBtnState$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new DetailDistributionBottomView();
    }

    public final void setAddWindowBtnState(boolean z16) {
        this.addWindowBtnState$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final void setSample(boolean z16) {
        this.isSample$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }
}
