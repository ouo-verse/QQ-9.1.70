package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.advertising_attribution.AdAttributionReporter;
import com.tencent.hippykotlin.demo.pages.advertising_attribution.AdAttributionReporter$shopDetailExpReport$1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.UtilsKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ECDetailPageReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.IReportParamsBuilder;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.report.ProductDetailReporter;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailCategory;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailUserRight;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailShopNavBarViewModel;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailShopPageModel implements IProductDetailPageModel, IProductDetailEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailShopPageModel.class, "pageState", "getPageState()Lcom/tencent/hippykotlin/demo/pages/product_detail/detail_page/define/ProductDetailPageState;", 0)};
    public static final Companion Companion = new Companion();
    public final String activeId;
    public final String amsClickId;
    public final Lazy bottomViewModel$delegate;
    public final boolean buyNow;
    public final ProductDetailShopViewModel detailViewModel;
    public final boolean hideLiveIcon;
    public final boolean isHalf;
    public final String littleWorldFeedId;
    public final ProductDetailIconViewModel liveIconViewModel;
    public IProductDetailPageDelegate pageDelegate;
    public final ReadWriteProperty pageState$delegate;
    public final e params;
    public final Lazy reportParams$delegate;
    public final long roomId;
    public final String spuId;

    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailShopPageModel$1", f = "ProductDetailShopPageModel.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailShopPageModel$1, reason: invalid class name */
    /* loaded from: classes31.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                ProductDetailShopPageModel productDetailShopPageModel = ProductDetailShopPageModel.this;
                ProductDetailShopViewModel productDetailShopViewModel = productDetailShopPageModel.detailViewModel;
                String str = productDetailShopPageModel.spuId;
                this.label = 1;
                if (productDetailShopViewModel.refreshPageRetainInfo(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
    }

    public ProductDetailShopPageModel(e eVar) {
        Lazy lazy;
        Lazy lazy2;
        this.params = eVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECDetailPageReportParamsBuilder>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailShopPageModel$reportParams$2
            @Override // kotlin.jvm.functions.Function0
            public final ECDetailPageReportParamsBuilder invoke() {
                return new ECDetailPageReportParamsBuilder();
            }
        });
        this.reportParams$delegate = lazy;
        String schemeSpuId = SchemeParamExtensionKt.schemeSpuId(eVar);
        this.spuId = schemeSpuId;
        boolean schemeIsHalf = SchemeParamExtensionKt.schemeIsHalf(eVar);
        this.isHalf = schemeIsHalf;
        long schemeRoomId = SchemeParamExtensionKt.schemeRoomId(eVar);
        this.roomId = schemeRoomId;
        this.hideLiveIcon = SchemeParamExtensionKt.schemeHideIcon(eVar);
        String schemeActiveId = SchemeParamExtensionKt.schemeActiveId(eVar);
        this.activeId = schemeActiveId;
        this.buyNow = SchemeParamExtensionKt.schemeBuyNow(eVar);
        this.amsClickId = SchemeParamExtensionKt.schemeAmsClickID(eVar);
        String valueFromParams = UtilsKt.getValueFromParams(eVar, "little_world_feed_id");
        this.littleWorldFeedId = valueFromParams;
        this.pageState$delegate = c.a(ProductDetailPageState.LOADING);
        ProductDetailShopViewModel productDetailShopViewModel = new ProductDetailShopViewModel(eVar, getReportParams());
        this.detailViewModel = productDetailShopViewModel;
        this.liveIconViewModel = new ProductDetailIconViewModel(schemeSpuId, schemeRoomId);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IProductDetailPendantViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model.ProductDetailShopPageModel$bottomViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final IProductDetailPendantViewModel invoke() {
                if (ProductDetailShopPageModel.this.params.k("is_select", 0) != 0) {
                    return new ProductDetailShopHostBottomViewModel(ProductDetailShopPageModel.this.spuId);
                }
                ProductDetailShopPageModel productDetailShopPageModel = ProductDetailShopPageModel.this;
                return new ProductDetailShopBottomViewModel(productDetailShopPageModel.spuId, productDetailShopPageModel.params, productDetailShopPageModel.getReportParams());
            }
        });
        this.bottomViewModel$delegate = lazy2;
        productDetailShopViewModel.setHeight((com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).getPageData().l() - detailViewTopOffset()) - 80.0f);
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo productInfoCache = productDetailShopRepository.getProductInfoCache(schemeSpuId);
        initReportParams();
        if (productInfoCache != null && productInfoCache.isValid()) {
            KLog.INSTANCE.i("ProductDetail", "use cache data, spuId:[" + schemeSpuId + ']');
            ((ProductDetailShopPageModel$handleReqSuccess$1) handleReqSuccess$enumunboxing$(1)).invoke(productInfoCache, ProductDetailInfoType.DETAIL);
        }
        if (!Intrinsics.areEqual(schemeActiveId, "")) {
            productDetailShopRepository.reqLiveProductFullInfo(schemeSpuId, schemeActiveId, handleReqSuccess$enumunboxing$(2), handleReqFailure());
        } else {
            productDetailShopRepository.reqProductFullInfo(schemeSpuId, handleReqSuccess$enumunboxing$(2), handleReqFailure());
        }
        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AnonymousClass1(null), 3, null);
        if (schemeIsHalf) {
            Utils.INSTANCE.currentBridgeModule().sendQCirclePanelStateEvent(valueFromParams, true);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent
    public final Set<String> canHandleEventName() {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf("refresh_detail_page");
        return mutableSetOf;
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
        return new ProductDetailShopPageModel$handleReqFailure$1(this);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;)Lkotlin/jvm/functions/Function2<Lcom/tencent/hippykotlin/demo/pages/product_detail/detail_page/repository/shop/model/ProductDetailInfo;Lcom/tencent/hippykotlin/demo/pages/product_detail/detail_page/page_model/ProductDetailInfoType;Lkotlin/Unit;>; */
    public final Function2 handleReqSuccess$enumunboxing$(int i3) {
        return new ProductDetailShopPageModel$handleReqSuccess$1(this, i3);
    }

    public final void initReportParams() {
        int i3;
        ProductDetailCategory productDetailCategory;
        String str;
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[ProductDetailShopPageModel] [initReportParams] params = ");
        m3.append(this.params);
        utils.logToNative(m3.toString());
        IReportParamsBuilder reportParams = getReportParams();
        ECDetailPageReportParamsBuilder eCDetailPageReportParamsBuilder = reportParams instanceof ECDetailPageReportParamsBuilder ? (ECDetailPageReportParamsBuilder) reportParams : null;
        if (eCDetailPageReportParamsBuilder == null) {
            return;
        }
        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(this.spuId);
        int i16 = 0;
        String str2 = "";
        if (detailInfo != null) {
            ProductDetailProductCardRsp productDetailProductCardRsp = detailInfo.detail;
            ProductDetailProduct productDetailProduct = productDetailProductCardRsp.product;
            ProductDetailUserRight productDetailUserRight = productDetailProductCardRsp.userRight;
            i3 = productDetailUserRight != null ? productDetailUserRight.roleId : 1;
            if (productDetailProduct != null && (productDetailCategory = productDetailProduct.category) != null && (str = productDetailCategory.firstCatId) != null) {
                str2 = str;
            }
            ProductDetailActiveInfo productDetailActiveInfo = productDetailProductCardRsp.activeInfo;
            if (productDetailActiveInfo != null) {
                i16 = productDetailActiveInfo.activeType;
            }
        } else {
            i3 = 1;
        }
        Intrinsics.areEqual(UtilsKt.getValueFromParams(this.params, "is_select"), "1");
        eCDetailPageReportParamsBuilder.pgStateType = this.isHalf ? 1 : 2;
        eCDetailPageReportParamsBuilder.contentId = UtilsKt.getValueFromParams(this.params, "little_world_feed_id");
        eCDetailPageReportParamsBuilder.sellerId = UtilsKt.getValueFromParams(this.params, "seller_id");
        eCDetailPageReportParamsBuilder.shopId = UtilsKt.getValueFromParams(this.params, "shop_id");
        eCDetailPageReportParamsBuilder.spuId = this.spuId;
        eCDetailPageReportParamsBuilder.role = i3;
        eCDetailPageReportParamsBuilder.priSortId = str2;
        eCDetailPageReportParamsBuilder.sourceFrom = UtilsKt.getValueFromParams(this.params, "source_from");
        eCDetailPageReportParamsBuilder.roomId = String.valueOf(this.roomId);
        UtilsKt.getValueFromParams(this.params, "product_type");
        eCDetailPageReportParamsBuilder.activityId = this.activeId;
        eCDetailPageReportParamsBuilder.activityState = this.liveIconViewModel.liveStatus;
        eCDetailPageReportParamsBuilder.programId = UtilsKt.getValueFromParams(this.params, "qqlive_session_id");
        eCDetailPageReportParamsBuilder.activityType = i16;
        UtilsKt.getValueFromParams(this.params, "request_id");
        UtilsKt.getValueFromParams(this.params, QCircleLpReportDc05507.KEY_SEAL_TRANSFER);
        eCDetailPageReportParamsBuilder.adClickId = UtilsKt.getValueFromParams(this.params, "qz_gdt");
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageLifeCycle
    public final void onDetailPageDestroy() {
        if (this.isHalf) {
            Utils.INSTANCE.currentBridgeModule().sendQCirclePanelStateEvent(this.littleWorldFeedId, false);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent
    public final void onEvent(String str, Object obj) {
        if (Intrinsics.areEqual(str, "refresh_detail_page")) {
            ProductDetailShopRepository.INSTANCE.reqProductFullInfo(this.spuId, new ProductDetailShopPageModel$handleReqSuccess$1(this, 2), new ProductDetailShopPageModel$handleReqFailure$1(this));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final void refreshData() {
        ProductDetailShopRepository.INSTANCE.reqProductFullInfo(this.spuId, new ProductDetailShopPageModel$handleReqSuccess$1(this, 2), new ProductDetailShopPageModel$handleReqFailure$1(this));
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
        AdAttributionReporter adAttributionReporter = AdAttributionReporter.INSTANCE;
        String str = this.amsClickId;
        if (str != null) {
            if (str.length() == 0) {
                return;
            }
            BuildersKt.e((com.tencent.kuikly.core.coroutines.e) AdAttributionReporter.viewModelScope$delegate.getValue(), null, null, new AdAttributionReporter$shopDetailExpReport$1(adAttributionReporter.combineReportData(str, "PRODUCT_VIEW"), null), 3, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageUIData
    public final void setPageDelegate(IProductDetailPageDelegate iProductDetailPageDelegate) {
        this.pageDelegate = iProductDetailPageDelegate;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubViewModel
    public final IProductDetailPendantViewModel[] detailPendantsViewModel() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ProductDetailShopNavBarViewModel(this.isHalf, this.spuId, this.pageDelegate, this.detailViewModel, getReportParams()), (IProductDetailPendantViewModel) this.bottomViewModel$delegate.getValue(), new ProductDetailCategoryViewModel(this.isHalf, this.pageDelegate, getReportParams()));
        if (!this.hideLiveIcon) {
            arrayListOf.add(this.liveIconViewModel);
        }
        if (this.isHalf) {
            arrayListOf.add(new ProductDetailCloseBtnViewModel(this.detailViewModel, this.pageDelegate));
        }
        Object[] array = arrayListOf.toArray(new IProductDetailPendantViewModel[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (IProductDetailPendantViewModel[]) array;
    }
}
