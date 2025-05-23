package com.tencent.hippykotlin.demo.pages.goods_center;

import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.card.banner.GoodsCenterBannerViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.card.error_view.GoodsCenterErrorViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.card.header.GoodsCenterHeaderViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.card.order.GoodsCenterOrderViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder.GoodsCenterFooterPlaceHolderViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductSkeletonViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataBackEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataSearchText;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterSearchType$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter.GoodsCenterFilterPendantViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap.GoodsCenterHeadMapViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar.GoodsCenterNavBarViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult.GoodsCenterSearchResultViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.report.GoodsCenterShowPageCostTimeCode$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsReq;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsRsp;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageCallback;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.IPageRequestLogic;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.PageRequestLogic;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GoodsCenterPageModel implements IGoodsCenterPageModel, IGoodsCenterEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(GoodsCenterPageModel.class, "cardsViewModel", "getCardsViewModel()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(GoodsCenterPageModel.class, "headersViewModel", "getHeadersViewModel()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(GoodsCenterPageModel.class, "footersViewModel", "getFootersViewModel()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(GoodsCenterPageModel.class, "frontPendantsViewModel", "getFrontPendantsViewModel()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(GoodsCenterPageModel.class, "backPendantsViewModel", "getBackPendantsViewModel()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterPageModel.class, "skeletonCardsViewModelList", "getSkeletonCardsViewModelList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterPageModel.class, "errorCardViewModel", "getErrorCardViewModel()Lcom/tencent/hippykotlin/demo/pages/goods_center/card/error_view/GoodsCenterErrorViewModel;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterPageModel.class, "footerRefreshState", "getFooterRefreshState()Lcom/tencent/kuikly/core/views/FooterRefreshState;", 0)};
    public final ReadWriteProperty backPendantsViewModel$delegate;
    public final GoodsCenterBannerViewModel bannerViewModel;
    public final IGoodsCenterPageCallback callBackToPage;
    public final ReadWriteProperty cardsViewModel$delegate;
    public float currentPageOffsetY;
    public final ReadWriteProperty errorCardViewModel$delegate;
    public final GoodsCenterFilterPendantViewModel filterPanelViewModel;
    public final GoodsCenterFooterPlaceHolderViewModel footerPlaceHolderViewModel;
    public final ReadWriteProperty footerRefreshState$delegate;
    public final ReadWriteProperty footersViewModel$delegate;
    public final ReadWriteProperty frontPendantsViewModel$delegate;
    public final GoodsCenterHeaderViewModel headerViewModel;
    public final ReadWriteProperty headersViewModel$delegate;
    public boolean isReportShowPageCostTime;
    public final GoodsCenterNavBarViewModel navBarViewModel;
    public final GoodsCenterOrderViewModel orderViewModel;
    public IPageRequestLogic<GoodsCenterSelectProductsReq, GoodsCenterSelectProductsRsp> pageReq;
    public long showPageBeginTime;
    public final ReadWriteProperty skeletonCardsViewModelList$delegate;
    public int sourceFrom;
    public int state;

    public GoodsCenterPageModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final Set<String> canHandleEventName() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"click_back", "click_search"});
        return of5;
    }

    public final c<IGoodsCenterPendantViewModel> getBackPendantsViewModel() {
        return (c) this.backPendantsViewModel$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final c<IGoodsCenterCardViewModel> getCardsViewModel() {
        return (c) this.cardsViewModel$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final GoodsCenterErrorViewModel getErrorCardViewModel() {
        return (GoodsCenterErrorViewModel) this.errorCardViewModel$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final c<IGoodsCenterCardViewModel> getFootersViewModel() {
        return (c) this.footersViewModel$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final c<IGoodsCenterPendantViewModel> getFrontPendantsViewModel() {
        return (c) this.frontPendantsViewModel$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final c<IGoodsCenterCardViewModel> getHeadersViewModel() {
        return (c) this.headersViewModel$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final c<IGoodsCenterCardViewModel> getSkeletonCardsViewModelList() {
        return (c) this.skeletonCardsViewModelList$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final boolean hasProductCard() {
        Iterator<IGoodsCenterCardViewModel> it = getCardsViewModel().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof GoodsCenterProductViewModel) {
                return true;
            }
        }
        return false;
    }

    public final void initSkeletonCardList() {
        getSkeletonCardsViewModelList().clear();
        for (int i3 = 1; i3 < 11; i3++) {
            getSkeletonCardsViewModelList().add(new GoodsCenterProductSkeletonViewModel());
        }
        getCardsViewModel().addAll(getSkeletonCardsViewModelList());
    }

    public final void loadLocalCache() {
        String cachedFromNative = Utils.INSTANCE.currentBridgeModule().getCachedFromNative(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().p("uin") + "_selectProductsFirstPageCacheKey");
        GoodsCenterSelectProductsRsp decode = cachedFromNative.length() > 0 ? GoodsCenterSelectProductsRsp.Companion.decode(new e(cachedFromNative)) : null;
        if (decode == null) {
            return;
        }
        this.orderViewModel.updateRsp(decode, true);
        this.headerViewModel.updateRsp(decode);
        processProductList(decode.productList, null, null);
        refreshState$enumunboxing$(1);
        reportShowPageCostTime$enumunboxing$(1);
    }

    public final void loadMoreData() {
        int i3 = this.state;
        if (i3 == 2 || i3 == 3 || i3 == 7) {
            return;
        }
        refreshState$enumunboxing$(3);
        IPageRequestLogic<GoodsCenterSelectProductsReq, GoodsCenterSelectProductsRsp> iPageRequestLogic = this.pageReq;
        if (iPageRequestLogic != null) {
            iPageRequestLogic.reqNextPage(new GoodsCenterPageModel$handleSelectProductsListSuccess$1(this, true), new GoodsCenterPageModel$handleSelectProductsListFailure$1(this, true));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final void onEvent(String str, Object obj) {
        String str2;
        if (Intrinsics.areEqual(str, "click_back")) {
            GoodsCenterEventDataBackEvent goodsCenterEventDataBackEvent = obj instanceof GoodsCenterEventDataBackEvent ? (GoodsCenterEventDataBackEvent) obj : null;
            boolean z16 = false;
            if (goodsCenterEventDataBackEvent != null ? Intrinsics.areEqual(goodsCenterEventDataBackEvent.isAfterSearch, Boolean.TRUE) : false) {
                return;
            }
            if (goodsCenterEventDataBackEvent != null && (str2 = goodsCenterEventDataBackEvent.lastQueryText) != null) {
                if ((str2.length() > 0) == true) {
                    z16 = true;
                }
            }
            if (z16) {
                IGoodsCenterPageCallback iGoodsCenterPageCallback = this.callBackToPage;
                if (iGoodsCenterPageCallback != null) {
                    iGoodsCenterPageCallback.scrollToSpecifiedPosition(0.0f, true);
                }
                refreshData(GoodsCenterSelectProductsReq.copy$default(pageDataFilterParams(), "", null, null, null, 0, null, 510), true);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, "click_search")) {
            GoodsCenterEventDataSearchText goodsCenterEventDataSearchText = obj instanceof GoodsCenterEventDataSearchText ? (GoodsCenterEventDataSearchText) obj : null;
            if (goodsCenterEventDataSearchText != null) {
                String str3 = goodsCenterEventDataSearchText.text;
                int i3 = goodsCenterEventDataSearchText.searchType;
                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("input_query", str3);
                m3.t("request_way", GoodsCenterSearchType$EnumUnboxingLocalUtility.getValue(i3));
                e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
                Iterator<String> c16 = m3.c();
                while (c16.hasNext()) {
                    String next = c16.next();
                    m16.v(next, m3.p(next));
                }
                Utils.INSTANCE.currentBridgeModule().reportDT("xuanpin_search_request", m16);
                refreshData(GoodsCenterSelectProductsReq.copy$default(pageDataFilterParams(), goodsCenterEventDataSearchText.text, null, null, null, 0, null, 424), true);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.IPageRequestLogic<com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsReq, com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsRsp>, com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.PageRequestLogic] */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageData
    public final GoodsCenterSelectProductsReq pageDataFilterParams() {
        GoodsCenterSelectProductsReq goodsCenterSelectProductsReq;
        ?? r06 = this.pageReq;
        return (r06 == 0 || (goodsCenterSelectProductsReq = (GoodsCenterSelectProductsReq) r06.reqModel) == null) ? new GoodsCenterSelectProductsReq(null, null, null, null, 0, null, null, null, 0L, 511, null) : goodsCenterSelectProductsReq;
    }

    public final float pageTop() {
        return (com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().getNavigationBarHeight() + 52.0f) - 45.0f;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageData
    public final void refreshData(GoodsCenterSelectProductsReq goodsCenterSelectProductsReq) {
        refreshData(goodsCenterSelectProductsReq, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r1 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshState$enumunboxing$(int i3) {
        this.state = i3;
        if (i3 != 0) {
            boolean z16 = true;
            switch (i3 - 1) {
                case 0:
                    setFooterRefreshState(FooterRefreshState.IDLE);
                    removePlaceHolderViewModel();
                    return;
                case 1:
                    resetCardsViewModel();
                    getCardsViewModel().addAll(getSkeletonCardsViewModelList());
                    scrollToCeiling(false, true, 0.0f);
                    return;
                case 2:
                    setFooterRefreshState(FooterRefreshState.REFRESHING);
                    return;
                case 3:
                    removePlaceHolderViewModel();
                    this.errorCardViewModel$delegate.setValue(this, $$delegatedProperties[6], new GoodsCenterErrorViewModel("\u6ca1\u6709\u7b26\u5408\u6761\u4ef6\u7684\u5546\u54c1", null));
                    getCardsViewModel().add(getErrorCardViewModel());
                    return;
                case 4:
                    removePlaceHolderViewModel();
                    if (this.headerViewModel.categoryViewModel.getCategoryList() != null) {
                        ArrayList<GoodsCenterCategory> categoryList = this.headerViewModel.categoryViewModel.getCategoryList();
                        if (categoryList == null || !categoryList.isEmpty()) {
                            z16 = false;
                            break;
                        }
                    }
                    getCardsViewModel().remove(this.headerViewModel);
                    this.errorCardViewModel$delegate.setValue(this, $$delegatedProperties[6], new GoodsCenterErrorViewModel(VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPageModel$refreshState$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            GoodsCenterPageModel goodsCenterPageModel = GoodsCenterPageModel.this;
                            goodsCenterPageModel.refreshData(goodsCenterPageModel.pageDataFilterParams(), true);
                            return Unit.INSTANCE;
                        }
                    }));
                    getCardsViewModel().add(getErrorCardViewModel());
                    return;
                case 5:
                    setFooterRefreshState(FooterRefreshState.FAILURE);
                    return;
                case 6:
                    removePlaceHolderViewModel();
                    setFooterRefreshState(FooterRefreshState.NONE_MORE_DATA);
                    return;
                default:
                    return;
            }
        }
        throw null;
    }

    public final void removePlaceHolderViewModel() {
        getCardsViewModel().removeAll(getSkeletonCardsViewModelList());
        getCardsViewModel().remove(getErrorCardViewModel());
    }

    public final void reportShowPageCostTime$enumunboxing$(int i3) {
        if (this.isReportShowPageCostTime) {
            return;
        }
        this.isReportShowPageCostTime = true;
        long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp() - this.showPageBeginTime;
        e eVar = new e();
        eVar.u("cost_time", currentTimeStamp);
        eVar.t("scene", 1);
        eVar.t("is_host", 1);
        eVar.t("result_code", GoodsCenterShowPageCostTimeCode$EnumUnboxingLocalUtility.getValue(i3));
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            m3.v(next, eVar.p(next));
        }
        Utils.INSTANCE.currentBridgeModule().reportDT("ec_quality_show_page_cost_time", m3);
    }

    public final void resetCardsViewModel() {
        getCardsViewModel().clear();
        this.footerPlaceHolderViewModel.ceilingOffsetY = this.headerViewModel.getCardFrameY();
        boolean z16 = this.navBarViewModel.isSearching;
        GoodsCenterHeaderViewModel goodsCenterHeaderViewModel = this.headerViewModel;
        goodsCenterHeaderViewModel.isSearching$delegate.setValue(goodsCenterHeaderViewModel, GoodsCenterHeaderViewModel.$$delegatedProperties[1], Boolean.valueOf(z16));
        if (!this.navBarViewModel.isSearching && this.sourceFrom != 1) {
            if (!getHeadersViewModel().contains(this.orderViewModel)) {
                getHeadersViewModel().add(0, this.orderViewModel);
            }
            if (!getHeadersViewModel().contains(this.bannerViewModel)) {
                getHeadersViewModel().add(1, this.bannerViewModel);
            }
            if (getFootersViewModel().contains(this.footerPlaceHolderViewModel)) {
                return;
            }
            getFootersViewModel().add(this.footerPlaceHolderViewModel);
            return;
        }
        getHeadersViewModel().remove(this.orderViewModel);
        getHeadersViewModel().remove(this.bannerViewModel);
        getFootersViewModel().remove(this.footerPlaceHolderViewModel);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageUIData
    public final void scrollToCeiling(final boolean z16, final boolean z17, final float f16) {
        TimerKt.d(1, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.GoodsCenterPageModel$scrollToCeiling$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                GoodsCenterPageModel goodsCenterPageModel;
                IGoodsCenterPageCallback iGoodsCenterPageCallback;
                if (z16) {
                    GoodsCenterPageModel goodsCenterPageModel2 = this;
                    if (goodsCenterPageModel2.currentPageOffsetY < goodsCenterPageModel2.headerViewModel.getCardFrameY()) {
                        GoodsCenterPageModel goodsCenterPageModel3 = this;
                        if (!goodsCenterPageModel3.navBarViewModel.isSearching) {
                            IGoodsCenterPageCallback iGoodsCenterPageCallback2 = goodsCenterPageModel3.callBackToPage;
                            if (iGoodsCenterPageCallback2 != null) {
                                iGoodsCenterPageCallback2.scrollToSpecifiedPosition(goodsCenterPageModel3.headerViewModel.getCardFrameY() + f16, true);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
                if (z17) {
                    GoodsCenterPageModel goodsCenterPageModel4 = this;
                    if (goodsCenterPageModel4.navBarViewModel.isSearching) {
                        IGoodsCenterPageCallback iGoodsCenterPageCallback3 = goodsCenterPageModel4.callBackToPage;
                        if (iGoodsCenterPageCallback3 != null) {
                            iGoodsCenterPageCallback3.scrollToSpecifiedPosition(0.0f, false);
                        }
                    } else if (goodsCenterPageModel4.currentPageOffsetY > goodsCenterPageModel4.headerViewModel.getCardFrameY() && (iGoodsCenterPageCallback = (goodsCenterPageModel = this).callBackToPage) != null) {
                        iGoodsCenterPageCallback.scrollToSpecifiedPosition(goodsCenterPageModel.headerViewModel.getCardFrameY() + f16, false);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void setFooterRefreshState(FooterRefreshState footerRefreshState) {
        this.footerRefreshState$delegate.setValue(this, $$delegatedProperties[7], footerRefreshState);
    }

    public GoodsCenterPageModel(g gVar, IGoodsCenterPageCallback iGoodsCenterPageCallback) {
        e n3;
        this.callBackToPage = iGoodsCenterPageCallback;
        this.cardsViewModel$delegate = c01.c.b();
        this.headersViewModel$delegate = c01.c.b();
        this.footersViewModel$delegate = c01.c.b();
        this.frontPendantsViewModel$delegate = c01.c.b();
        this.backPendantsViewModel$delegate = c01.c.b();
        GoodsCenterHeadMapViewModel goodsCenterHeadMapViewModel = new GoodsCenterHeadMapViewModel();
        GoodsCenterNavBarViewModel goodsCenterNavBarViewModel = new GoodsCenterNavBarViewModel();
        this.navBarViewModel = goodsCenterNavBarViewModel;
        GoodsCenterOrderViewModel goodsCenterOrderViewModel = new GoodsCenterOrderViewModel();
        this.orderViewModel = goodsCenterOrderViewModel;
        GoodsCenterBannerViewModel goodsCenterBannerViewModel = new GoodsCenterBannerViewModel();
        this.bannerViewModel = goodsCenterBannerViewModel;
        GoodsCenterFooterPlaceHolderViewModel goodsCenterFooterPlaceHolderViewModel = new GoodsCenterFooterPlaceHolderViewModel(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().l() - pageTop());
        this.footerPlaceHolderViewModel = goodsCenterFooterPlaceHolderViewModel;
        GoodsCenterFilterPendantViewModel goodsCenterFilterPendantViewModel = new GoodsCenterFilterPendantViewModel(this);
        this.filterPanelViewModel = goodsCenterFilterPendantViewModel;
        GoodsCenterHeaderViewModel goodsCenterHeaderViewModel = new GoodsCenterHeaderViewModel(this);
        this.headerViewModel = goodsCenterHeaderViewModel;
        this.skeletonCardsViewModelList$delegate = c01.c.b();
        this.errorCardViewModel$delegate = c01.c.a(new GoodsCenterErrorViewModel("", null));
        this.state = 1;
        this.footerRefreshState$delegate = c01.c.a(FooterRefreshState.IDLE);
        this.sourceFrom = 0;
        this.sourceFrom = (gVar == null || (n3 = gVar.n()) == null) ? 0 : n3.k("goods_center_source_from", 0);
        this.showPageBeginTime = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        goodsCenterNavBarViewModel.setSourceFrom(this.sourceFrom);
        goodsCenterHeaderViewModel.setAddProductState(this.sourceFrom == 1);
        goodsCenterHeadMapViewModel.setKeepViewInNavBar(this.sourceFrom == 1);
        getHeadersViewModel().add(goodsCenterOrderViewModel);
        getHeadersViewModel().add(goodsCenterBannerViewModel);
        getHeadersViewModel().add(goodsCenterHeaderViewModel);
        getFootersViewModel().add(goodsCenterFooterPlaceHolderViewModel);
        resetCardsViewModel();
        initSkeletonCardList();
        getFrontPendantsViewModel().add(goodsCenterNavBarViewModel);
        getFrontPendantsViewModel().add(goodsCenterFilterPendantViewModel);
        getFrontPendantsViewModel().add(goodsCenterHeaderViewModel.getCategoryViewModel());
        if (gVar != null && gVar.getIsIOS()) {
            getFrontPendantsViewModel().add(new GoodsCenterSearchResultViewModel());
        }
        getBackPendantsViewModel().add(goodsCenterHeadMapViewModel);
        refreshState$enumunboxing$(1);
        loadLocalCache();
        refreshData(pageDataFilterParams(), false);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.IPageRequestLogic<com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsReq, com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsRsp>, com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.PageRequestLogic] */
    public final void refreshData(final GoodsCenterSelectProductsReq goodsCenterSelectProductsReq, boolean z16) {
        ?? r06 = this.pageReq;
        if (r06 != 0) {
            r06.isDestroy = true;
        }
        if (z16) {
            refreshState$enumunboxing$(2);
        }
        final GoodsCenterPageModel$handleSelectProductsListSuccess$1 goodsCenterPageModel$handleSelectProductsListSuccess$1 = new GoodsCenterPageModel$handleSelectProductsListSuccess$1(this, false);
        final GoodsCenterPageModel$handleSelectProductsListFailure$1 goodsCenterPageModel$handleSelectProductsListFailure$1 = new GoodsCenterPageModel$handleSelectProductsListFailure$1(this, false);
        PageRequestLogic pageRequestLogic = new PageRequestLogic("trpc.ecom.select_product_list_svr.SelectProductListSvr/SelectProductList", goodsCenterSelectProductsReq, GoodsCenterSelectProductsRsp.Factory, 2);
        pageRequestLogic.reqFirstPage(new Function1<GoodsCenterSelectProductsRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRepository$reqSelectProductsList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GoodsCenterSelectProductsRsp goodsCenterSelectProductsRsp) {
                GoodsCenterSelectProductsRsp goodsCenterSelectProductsRsp2 = goodsCenterSelectProductsRsp;
                if (GoodsCenterRepositoryKt.access$isEmpty(GoodsCenterSelectProductsReq.this)) {
                    Utils.INSTANCE.currentBridgeModule().setCachedToNative(AgreementConsentViewKt$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n().p("uin"), "_selectProductsFirstPageCacheKey"), goodsCenterSelectProductsRsp2.encode().toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRepository$saveSelectProductsFirstPageCache$1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                            return Unit.INSTANCE;
                        }
                    });
                }
                goodsCenterPageModel$handleSelectProductsListSuccess$1.invoke(goodsCenterSelectProductsRsp2);
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRepository$reqSelectProductsList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                int intValue = num.intValue();
                goodsCenterPageModel$handleSelectProductsListFailure$1.invoke(Integer.valueOf(intValue), str);
                return Unit.INSTANCE;
            }
        });
        this.pageReq = pageRequestLogic;
    }

    public final void processProductList(ArrayList<GoodsCenterProductInfo> arrayList, List<GoodsCenterFilterCond> list, List<GoodsCenterRangeCond> list2) {
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                getCardsViewModel().add(new GoodsCenterProductViewModel((GoodsCenterProductInfo) it.next(), list == null ? new ArrayList<>() : list, list2 == null ? new ArrayList<>() : list2));
            }
        }
    }

    public /* synthetic */ GoodsCenterPageModel(g gVar, IGoodsCenterPageCallback iGoodsCenterPageCallback, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }
}
