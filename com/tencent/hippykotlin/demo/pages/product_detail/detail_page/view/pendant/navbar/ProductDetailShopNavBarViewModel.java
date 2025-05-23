package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel;
import com.tencent.hippykotlin.demo.pages.retain.ECRetainHelper;
import com.tencent.hippykotlin.demo.pages.retain.ECRetainViewOption;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class ProductDetailShopNavBarViewModel extends ProductDetailNavBarViewModel {
    public final ProductDetailShopViewModel detailViewModel;
    public final boolean isHalf;
    public final IProductDetailPageDelegate pageDelegate;
    public final IReportParamsBuilder reportParams;
    public final String spuId;

    public ProductDetailShopNavBarViewModel(boolean z16, String str, IProductDetailPageDelegate iProductDetailPageDelegate, ProductDetailShopViewModel productDetailShopViewModel, IReportParamsBuilder iReportParamsBuilder) {
        super("\u5546\u54c1\u8be6\u60c5", z16, iProductDetailPageDelegate, productDetailShopViewModel, false);
        this.isHalf = z16;
        this.spuId = str;
        this.pageDelegate = iProductDetailPageDelegate;
        this.detailViewModel = productDetailShopViewModel;
        this.reportParams = iReportParamsBuilder;
        k.b(Utils.INSTANCE.notifyModule(BridgeManager.f117344a.u()), AgreementConsentViewKt$$ExternalSyntheticOutline0.m("ios_slide_back_retain", str), false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailShopNavBarViewModel.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                ProductDetailShopNavBarViewModel.this.popRetain();
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel
    public final void backBtnPressed() {
        popRetain();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel
    public final String backIconToken() {
        if (this.isHalf) {
            return "qecommerce_skin_icon_nav_close";
        }
        return "qecommerce_skin_icon_nav_arrow_left";
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel
    public final IProductDetailViewModel getDetailViewModel() {
        return this.detailViewModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.ProductDetailBaseViewModel
    public final boolean getDisableNightMode() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel
    public final IProductDetailPageDelegate getPageDelegate() {
        return this.pageDelegate;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel, com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel
    public final ComposeView<ProductDetailPendantAttr, ProductDetailEvent> getPendantView() {
        return new ProductDetailNavBarView(this.detailViewModel);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel
    public final String getTitle() {
        return "\u5546\u54c1\u8be6\u60c5";
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel
    public final boolean isHalf() {
        return this.isHalf;
    }

    public final void popRetain() {
        IProductDetailPageDelegate iProductDetailPageDelegate;
        String str;
        e eVar = new e();
        IReportParamsBuilder iReportParamsBuilder = this.reportParams;
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = iReportParamsBuilder instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) iReportParamsBuilder : null;
        if (eCDetailPageReportParamsBuilder != null) {
            ECDetailPageReportParamsBuilder addActivityId = eCDetailPageReportParamsBuilder.addSellerId().addShopId().addSpuId().addRole().addPriSortId().addActivityType().addActivityId();
            addActivityId.paramsMap.put("activity_state", Integer.valueOf(addActivityId.activityState));
            ECDetailPageReportParamsBuilder addContentId = addActivityId.addProgramId().addRoomId().addSourceFrom().addContentId();
            addContentId.paramsMap.put("click_id", addContentId.adClickId);
            eVar = eCDetailPageReportParamsBuilder.buildParamsJson();
        }
        ProductDetailShopViewModel productDetailShopViewModel = this.detailViewModel;
        if (((productDetailShopViewModel == null || (str = productDetailShopViewModel.retainId) == null) ? false : ECRetainHelper.INSTANCE.showRetainView(str, this.spuId, eVar, new Function1<ECRetainViewOption, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailShopNavBarViewModel$popRetain$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ECRetainViewOption eCRetainViewOption) {
                IProductDetailPageDelegate iProductDetailPageDelegate2;
                if (eCRetainViewOption == ECRetainViewOption.EXIT && (iProductDetailPageDelegate2 = ProductDetailShopNavBarViewModel.this.pageDelegate) != null) {
                    iProductDetailPageDelegate2.closePage(null);
                }
                return Unit.INSTANCE;
            }
        })) || (iProductDetailPageDelegate = this.pageDelegate) == null) {
            return;
        }
        iProductDetailPageDelegate.closePage(null);
    }
}
