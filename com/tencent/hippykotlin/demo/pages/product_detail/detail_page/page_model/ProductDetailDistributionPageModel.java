package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ProductDetailReporter;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.ProductDetailDistributionRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailDistributionViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionPageModel implements IProductDetailPageModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailDistributionPageModel.class, "pageState", "getPageState()Lcom/tencent/hippykotlin/demo/pages/product_detail/detail_page/define/ProductDetailPageState;", 0)};
    public static final Companion Companion = new Companion();
    public final Lazy bottomViewModel$delegate;
    public final ProductDetailDistributionViewModel detailViewModel;
    public final boolean isHalf;
    public IProductDetailPageDelegate pageDelegate;
    public final ReadWriteProperty pageState$delegate;
    public final e params;
    public final Lazy reportParams$delegate;
    public final String spuId;

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public ProductDetailDistributionPageModel(e eVar) {
        Lazy lazy;
        Lazy lazy2;
        this.params = eVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECDetailPageReportParamsBuilder>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$reportParams$2
            @Override // kotlin.jvm.functions.Function0
            public final ECDetailPageReportParamsBuilder invoke() {
                return new ECDetailPageReportParamsBuilder();
            }
        });
        this.reportParams$delegate = lazy;
        String schemeSpuId = SchemeParamExtensionKt.schemeSpuId(eVar);
        this.spuId = schemeSpuId;
        this.pageState$delegate = c.a(ProductDetailPageState.LOADING);
        this.detailViewModel = new ProductDetailDistributionViewModel(schemeSpuId, getReportParams());
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DetailDistributionBottomViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailDistributionPageModel$bottomViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final DetailDistributionBottomViewModel invoke() {
                return new DetailDistributionBottomViewModel(ProductDetailDistributionPageModel.this.params);
            }
        });
        this.bottomViewModel$delegate = lazy2;
        this.isHalf = SchemeParamExtensionKt.schemeIsHalf(eVar);
        ProductDetailDistributionRepository productDetailDistributionRepository = ProductDetailDistributionRepository.INSTANCE;
        ProductDetailDistributionInfo productInfoCache = productDetailDistributionRepository.getProductInfoCache(SchemeParamExtensionKt.schemeSpuId(eVar));
        if (productInfoCache != null && productInfoCache.isValid()) {
            ((ProductDetailDistributionPageModel$handleReqSuccess$1) handleReqSuccess()).invoke(productInfoCache);
        }
        productDetailDistributionRepository.reqProductFullInfo(SchemeParamExtensionKt.schemeSpuId(eVar), handleReqSuccess(), handleReqFailure());
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final ProductDetailPageState detailState() {
        return (ProductDetailPageState) this.pageState$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubViewModel
    public final IProductDetailViewModel detailViewModel() {
        return this.detailViewModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final float detailViewTopOffset() {
        return IProductDetailPageModel.DefaultImpls.detailViewTopOffset();
    }

    public final IReportParamsBuilder getReportParams() {
        return (IReportParamsBuilder) this.reportParams$delegate.getValue();
    }

    public final Function2<Integer, String, Unit> handleReqFailure() {
        return new ProductDetailDistributionPageModel$handleReqFailure$1(this);
    }

    public final Function1 handleReqSuccess() {
        return new ProductDetailDistributionPageModel$handleReqSuccess$1(this);
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final void refreshData() {
        ProductDetailDistributionRepository.INSTANCE.reqProductFullInfo(this.params.p("spu_id"), new ProductDetailDistributionPageModel$handleReqSuccess$1(this), new ProductDetailDistributionPageModel$handleReqFailure$1(this));
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageReport
    public final void reportPageExit() {
        ProductDetailReporter productDetailReporter = ProductDetailReporter.INSTANCE;
        productDetailReporter.reportDetailPageDuration(getReportParams());
        productDetailReporter.reportDetailPageExpDepth(getReportParams());
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageReport
    public final void reportPageExp() {
        IReportParamsBuilder reportParams = getReportParams();
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = reportParams instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) reportParams : null;
        if (eCDetailPageReportParamsBuilder != null) {
            eCDetailPageReportParamsBuilder.startTime = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        }
        IReportParamsBuilder reportParams2 = getReportParams();
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder2 = reportParams2 instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) reportParams2 : null;
        if (eCDetailPageReportParamsBuilder2 != null) {
            eCDetailPageReportParamsBuilder2.addPageStateType().addBuiId().addSellerId().addShopId().addSpuId().addRole().addPriSortId().addActivityType().addActivityId().addPageStateType().addProgramId().addRoomId().addSourceFrom().addContentId();
            Utils utils = Utils.INSTANCE;
            ProductDetailDistributionPageModel$$ExternalSyntheticOutline1.m(eCDetailPageReportParamsBuilder2, ProductDetailDistributionPageModel$$ExternalSyntheticOutline0.m(eCDetailPageReportParamsBuilder2, utils.currentBridgeModule(), "qstore_prd_detail_pg_exp", "[ProductDetailReporter] reportDetailPageExp, event cod = qstore_prd_detail_pg_exp, data = "), utils);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final void setPageDelegate(IProductDetailPageDelegate iProductDetailPageDelegate) {
        this.pageDelegate = iProductDetailPageDelegate;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubViewModel
    public final IProductDetailPendantViewModel[] detailPendantsViewModel() {
        return new IProductDetailPendantViewModel[]{new ProductDetailNavBarViewModel("\u5546\u54c1\u8be6\u60c5", this.isHalf, this.pageDelegate, this.detailViewModel, false), (DetailDistributionBottomViewModel) this.bottomViewModel$delegate.getValue(), new ProductDetailCategoryViewModel(this.isHalf, this.pageDelegate, getReportParams())};
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageLifeCycle
    public final void onDetailPageDestroy() {
    }
}
