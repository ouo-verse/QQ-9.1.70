package com.tencent.hippykotlin.demo.pages.qplus_traffic;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$7;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusTrafficHomeDataViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.IQPlusTrafficHomePageDelegate;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository$reqCirWithCmd$1;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$requestWithCmd$1;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.IQPlusTrafficCache;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.QPlusTrafficCache;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStFeed;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStGetFeedDetailRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStGetMainPageCommDataRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusDateIndex;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetLiveAnchorRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetOverviewRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusIndex;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusLiveAnchorsKV;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusLiveStatus;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusOverviewData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusViewTab;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.QPlusTrafficHomeCardAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBar;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDNavigationBarKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.NavBarAttr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.c;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomePage extends BasePager implements c {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomePage.class, "bShowLoading", "getBShowLoading()Z", 0)};
    public final Lazy viewModel$delegate;
    public final QPlusTrafficHomePage$pageDelegate$1 pageDelegate = (QPlusTrafficHomePage$pageDelegate$1) pageDelegate();
    public final ReadWriteProperty bShowLoading$delegate = c01.c.a(Boolean.FALSE);

    public QPlusTrafficHomePage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficHomeViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$viewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficHomeViewModel invoke() {
                return new QPlusTrafficHomeViewModel(QPlusTrafficHomePage.this.pageDelegate);
            }
        });
        this.viewModel$delegate = lazy;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QPlusTrafficHomePage qPlusTrafficHomePage = QPlusTrafficHomePage.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        String str;
                        String str2;
                        m mVar2 = mVar;
                        QPlusTrafficHomePage qPlusTrafficHomePage2 = QPlusTrafficHomePage.this;
                        KProperty<Object>[] kPropertyArr = QPlusTrafficHomePage.$$delegatedProperties;
                        String p16 = qPlusTrafficHomePage2.getPageData().n().p("uin");
                        if (qPlusTrafficHomePage2.getPagerData().getIsIOS()) {
                            str = "ios_session";
                        } else {
                            str = "android_session";
                        }
                        e eVar = new e();
                        if (qPlusTrafficHomePage2.getPagerData().getIsIOS()) {
                            str2 = "00000QG6YX3H5PLX";
                        } else {
                            str2 = "00000QG6YX3X0LZH";
                        }
                        eVar.v(DTParamKey.REPORT_KEY_APPKEY, str2);
                        eVar.v("xsj_session_id", str + util.base64_pad_url + p16 + util.base64_pad_url + Utils.INSTANCE.currentBridgeModule().serverTimeMillis() + util.base64_pad_url + Random.INSTANCE.nextInt(0, 100));
                        EcommerceExtKt.pageVR(mVar2, "pg_xsj_product_popularize_home_page", eVar);
                        return Unit.INSTANCE;
                    }
                });
                ASDNavigationBarKt.NavBar(viewContainer2, new Function1<ASDNavigationBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ASDNavigationBar aSDNavigationBar) {
                        aSDNavigationBar.attr(new Function1<NavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NavBarAttr navBarAttr) {
                                navBarAttr.setNavTitle("\u4f5c\u54c1\u63a8\u5e7f");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPlusTrafficHomePage qPlusTrafficHomePage2 = QPlusTrafficHomePage.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                h hVar;
                                ao aoVar2 = aoVar;
                                aoVar2.mo153width(aoVar2.getPagerData().m()).mo141height(aoVar2.getPagerData().l() - aoVar2.getPagerData().getNavigationBarHeight());
                                hVar = IPagerIdKtxKt.getSkinColor(aoVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                aoVar2.mo113backgroundColor(hVar);
                                aoVar2.showScrollerIndicator(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPlusTrafficHomePage qPlusTrafficHomePage3 = QPlusTrafficHomePage.this;
                        KProperty<Object>[] kPropertyArr = QPlusTrafficHomePage.$$delegatedProperties;
                        qPlusTrafficHomePage3.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$bodyWithCards$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final QPlusTrafficHomePage qPlusTrafficHomePage4 = QPlusTrafficHomePage.this;
                                LoopDirectivesViewKt.a(viewContainer3, new Function0<com.tencent.kuikly.core.reactive.collection.c<IQPlusTrafficCardHomeViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$bodyWithCards$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<IQPlusTrafficCardHomeViewModel> invoke() {
                                        QPlusTrafficHomePage qPlusTrafficHomePage5 = QPlusTrafficHomePage.this;
                                        KProperty<Object>[] kPropertyArr2 = QPlusTrafficHomePage.$$delegatedProperties;
                                        return qPlusTrafficHomePage5.getViewModel().getCards();
                                    }
                                }, new Function2<LoopDirectivesView<IQPlusTrafficCardHomeViewModel>, IQPlusTrafficCardHomeViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$bodyWithCards$1.2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<IQPlusTrafficCardHomeViewModel> loopDirectivesView, IQPlusTrafficCardHomeViewModel iQPlusTrafficCardHomeViewModel) {
                                        final IQPlusTrafficCardHomeViewModel iQPlusTrafficCardHomeViewModel2 = iQPlusTrafficCardHomeViewModel;
                                        loopDirectivesView.addChild(iQPlusTrafficCardHomeViewModel2.getCardView(), new Function1<QPlusTrafficHomeCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage.bodyWithCards.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPlusTrafficHomeCardView qPlusTrafficHomeCardView) {
                                                final IQPlusTrafficCardHomeViewModel iQPlusTrafficCardHomeViewModel3 = IQPlusTrafficCardHomeViewModel.this;
                                                qPlusTrafficHomeCardView.attr(new Function1<QPlusTrafficHomeCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage.bodyWithCards.1.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(QPlusTrafficHomeCardAttr qPlusTrafficHomeCardAttr) {
                                                        qPlusTrafficHomeCardAttr.viewModel = IQPlusTrafficCardHomeViewModel.this;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(aqVar2);
                        return Unit.INSTANCE;
                    }
                });
                final QPlusTrafficHomePage qPlusTrafficHomePage3 = QPlusTrafficHomePage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QPlusTrafficHomePage qPlusTrafficHomePage4 = QPlusTrafficHomePage.this;
                        return Boolean.valueOf(((Boolean) qPlusTrafficHomePage4.bShowLoading$delegate.getValue(qPlusTrafficHomePage4, QPlusTrafficHomePage.$$delegatedProperties[0])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$body$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ECLoadingViewKt.ECLoading(conditionView, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                eCLoadingView.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(l lVar) {
                                        lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage.body.1.5.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    public final QPlusTrafficHomeViewModel getViewModel() {
        return (QPlusTrafficHomeViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_DID_APPEAR)) {
            QPlusTrafficHomeViewModel viewModel = getViewModel();
            QPlusTrafficUIState uiState = viewModel.orderViewModel.getUiState();
            QPlusTrafficUIState qPlusTrafficUIState = QPlusTrafficUIState.LOADING;
            if (uiState != qPlusTrafficUIState) {
                viewModel.orderViewModel.refresh();
            }
            if (viewModel.accountViewModel.getUiState() != qPlusTrafficUIState) {
                viewModel.accountViewModel.refresh();
            }
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    public final IQPlusTrafficHomePageDelegate pageDelegate() {
        return new IQPlusTrafficHomePageDelegate() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomePage$pageDelegate$1
            @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.IQPlusTrafficHomePageDelegate
            public final void showLoading(boolean z16) {
                QPlusTrafficHomePage qPlusTrafficHomePage = QPlusTrafficHomePage.this;
                qPlusTrafficHomePage.bShowLoading$delegate.setValue(qPlusTrafficHomePage, QPlusTrafficHomePage.$$delegatedProperties[0], Boolean.valueOf(z16));
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        removePagerEventObserver(this);
        super.viewDestroyed();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewWillLoad() {
        ArrayList arrayListOf;
        super.viewWillLoad();
        QPlusTrafficHomeViewModel viewModel = getViewModel();
        final QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel = (QPlusTrafficHomeVideoViewModel) viewModel.videoViewModel$delegate.getValue();
        String str = qPlusTrafficHomeVideoViewModel.uin;
        QPlusCirFeedRepository qPlusCirFeedRepository = QPlusCirFeedRepository.INSTANCE;
        QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp = (QPlusCirStGetMainPageCommDataRsp) IQPlusTrafficCache.DefaultImpls.getCache$default((QPlusTrafficCache) QPlusCirFeedRepository.videoCache$delegate.getValue(), str, false, 2, null);
        if (qPlusCirStGetMainPageCommDataRsp != null && qPlusCirStGetMainPageCommDataRsp.feedCount > 0) {
            qPlusTrafficHomeVideoViewModel.getListViewModel().resetVideo(qPlusCirStGetMainPageCommDataRsp);
            QPlusTrafficUIState qPlusTrafficUIState = QPlusTrafficUIState.COMPLETED;
            qPlusTrafficHomeVideoViewModel.checkAllDataReady(qPlusTrafficUIState, qPlusTrafficUIState, qPlusTrafficHomeVideoViewModel.initFeedState);
        }
        final String str2 = qPlusTrafficHomeVideoViewModel.initSelectFeedId;
        if (!(str2.length() == 0)) {
            QPlusCirStFeed qPlusCirStFeed = (QPlusCirStFeed) IQPlusTrafficCache.DefaultImpls.getCache$default((QPlusTrafficCache) QPlusCirFeedRepository.feedCache$delegate.getValue(), str2, false, 2, null);
            if (qPlusCirStFeed == null) {
                final String str3 = qPlusTrafficHomeVideoViewModel.uin;
                final Function1<QPlusCirStFeed, Unit> function1 = new Function1<QPlusCirStFeed, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$handleFeedInfoReqSuccess$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPlusCirStFeed qPlusCirStFeed2) {
                        QPlusCirStFeed qPlusCirStFeed3 = qPlusCirStFeed2;
                        if (qPlusCirStFeed3 != null) {
                            QPlusTrafficHomeVideoListViewModel listViewModel = QPlusTrafficHomeVideoViewModel.this.getListViewModel();
                            listViewModel.initSelectFeed = qPlusCirStFeed3;
                            listViewModel.addFeedAtFirst(qPlusCirStFeed3);
                            listViewModel.selectFeed(qPlusCirStFeed3.feedId);
                        }
                        QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel2 = QPlusTrafficHomeVideoViewModel.this;
                        qPlusTrafficHomeVideoViewModel2.checkAllDataReady(qPlusTrafficHomeVideoViewModel2.feedState, qPlusTrafficHomeVideoViewModel2.liveState, QPlusTrafficUIState.COMPLETED);
                        return Unit.INSTANCE;
                    }
                };
                final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$refreshInitSelectFeed$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Integer num, String str4) {
                        num.intValue();
                        QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel2 = QPlusTrafficHomeVideoViewModel.this;
                        qPlusTrafficHomeVideoViewModel2.checkAllDataReady(qPlusTrafficHomeVideoViewModel2.feedState, qPlusTrafficHomeVideoViewModel2.liveState, QPlusTrafficUIState.FAILURE);
                        return Unit.INSTANCE;
                    }
                };
                QPlusCirStGetFeedDetailRsp qPlusCirStGetFeedDetailRsp = new QPlusCirStGetFeedDetailRsp(null);
                Function4<QPlusCirStGetFeedDetailRsp, String, Integer, String, Unit> function4 = new Function4<QPlusCirStGetFeedDetailRsp, String, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusCirFeedRepository$reqCirFeedInfo$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(QPlusCirStGetFeedDetailRsp qPlusCirStGetFeedDetailRsp2, String str4, Integer num, String str5) {
                        QPlusCirStGetFeedDetailRsp qPlusCirStGetFeedDetailRsp3 = qPlusCirStGetFeedDetailRsp2;
                        int intValue = num.intValue();
                        String str6 = str5;
                        if (intValue == 0) {
                            if ((qPlusCirStGetFeedDetailRsp3 != null ? qPlusCirStGetFeedDetailRsp3.feed : null) != null) {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("cir feed info req success, [uin:");
                                m3.append(str3);
                                m3.append(" feedId:");
                                m3.append(str2);
                                m3.append(']');
                                kLog.i("QPlus", m3.toString());
                                QPlusTrafficCache qPlusTrafficCache = (QPlusTrafficCache) QPlusCirFeedRepository.feedCache$delegate.getValue();
                                String str7 = str2;
                                QPlusCirStFeed qPlusCirStFeed2 = qPlusCirStGetFeedDetailRsp3.feed;
                                qPlusTrafficCache.saveCache(str7, qPlusCirStFeed2, qPlusCirStFeed2.encode().toString());
                                function1.invoke(qPlusCirStGetFeedDetailRsp3.feed);
                            } else {
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("cir feed info req success, bus the feed is invalid. [uin:");
                                m16.append(str3);
                                m16.append(" feedId:");
                                m16.append(str2);
                                m16.append(']');
                                kLog2.i("QPlus", m16.toString());
                                function2.invoke(-1, "feed is invalid");
                            }
                        } else {
                            KLog kLog3 = KLog.INSTANCE;
                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("cir feed info req failure, [uin:");
                            m17.append(str3);
                            m17.append(" feedId:");
                            StringBuilder m18 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m17, str2, " code:", intValue, " msg :");
                            m18.append(str6);
                            m18.append(']');
                            kLog3.i("QPlus", m18.toString());
                            function2.invoke(Integer.valueOf(intValue), str6);
                        }
                        return Unit.INSTANCE;
                    }
                };
                BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                e eVar = new e();
                eVar.t("from", 0);
                eVar.v("userId", str3);
                eVar.v("feedId", str2);
                eVar.u(WadlProxyConsts.CREATE_TIME, 0L);
                e eVar2 = new e();
                QPlusCirFeedRepository$reqCirWithCmd$1 qPlusCirFeedRepository$reqCirWithCmd$1 = new QPlusCirFeedRepository$reqCirWithCmd$1(qPlusCirStGetFeedDetailRsp, function4);
                currentBridgeModule.getClass();
                e eVar3 = new e();
                eVar3.v("cmd", "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail");
                eVar3.v("reqParam", eVar);
                eVar3.v("rspProtoc", eVar2);
                currentBridgeModule.callNativeMethod("cirRequest", eVar3, qPlusCirFeedRepository$reqCirWithCmd$1);
            } else {
                new Function1<QPlusCirStFeed, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$handleFeedInfoReqSuccess$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPlusCirStFeed qPlusCirStFeed2) {
                        QPlusCirStFeed qPlusCirStFeed3 = qPlusCirStFeed2;
                        if (qPlusCirStFeed3 != null) {
                            QPlusTrafficHomeVideoListViewModel listViewModel = QPlusTrafficHomeVideoViewModel.this.getListViewModel();
                            listViewModel.initSelectFeed = qPlusCirStFeed3;
                            listViewModel.addFeedAtFirst(qPlusCirStFeed3);
                            listViewModel.selectFeed(qPlusCirStFeed3.feedId);
                        }
                        QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel2 = QPlusTrafficHomeVideoViewModel.this;
                        qPlusTrafficHomeVideoViewModel2.checkAllDataReady(qPlusTrafficHomeVideoViewModel2.feedState, qPlusTrafficHomeVideoViewModel2.liveState, QPlusTrafficUIState.COMPLETED);
                        return Unit.INSTANCE;
                    }
                }.invoke(qPlusCirStFeed);
            }
        }
        qPlusCirFeedRepository.reqCirFeedList(qPlusTrafficHomeVideoViewModel.uin, "", new Function1<QPlusCirStGetMainPageCommDataRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$handleFeedListReqSuccess$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp2) {
                QPlusCirStGetMainPageCommDataRsp qPlusCirStGetMainPageCommDataRsp3 = qPlusCirStGetMainPageCommDataRsp2;
                if (qPlusCirStGetMainPageCommDataRsp3 != null) {
                    QPlusTrafficHomeVideoViewModel.this.getListViewModel().resetVideo(qPlusCirStGetMainPageCommDataRsp3);
                }
                QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel2 = QPlusTrafficHomeVideoViewModel.this;
                qPlusTrafficHomeVideoViewModel2.checkAllDataReady(QPlusTrafficUIState.COMPLETED, qPlusTrafficHomeVideoViewModel2.liveState, qPlusTrafficHomeVideoViewModel2.initFeedState);
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$refresh$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str4) {
                num.intValue();
                Utils.INSTANCE.currentBridgeModule().toast("\u6570\u636e\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel2 = QPlusTrafficHomeVideoViewModel.this;
                qPlusTrafficHomeVideoViewModel2.checkAllDataReady(QPlusTrafficUIState.FAILURE, qPlusTrafficHomeVideoViewModel2.liveState, qPlusTrafficHomeVideoViewModel2.initFeedState);
                return Unit.INSTANCE;
            }
        });
        final String str4 = qPlusTrafficHomeVideoViewModel.uin;
        QPlusTrafficRepository qPlusTrafficRepository = QPlusTrafficRepository.INSTANCE;
        final Function1<QPlusLiveStatus, Unit> function12 = new Function1<QPlusLiveStatus, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$handleLiveReqSuccess$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusLiveStatus qPlusLiveStatus) {
                QPlusLiveStatus qPlusLiveStatus2 = qPlusLiveStatus;
                QPlusTrafficHomeVideoViewModel.this.setUiState(QPlusTrafficUIState.LOADING);
                if (qPlusLiveStatus2 != null) {
                    QPlusTrafficHomeVideoListViewModel listViewModel = QPlusTrafficHomeVideoViewModel.this.getListViewModel();
                    if (listViewModel.hasLiveItem()) {
                        CollectionsKt__MutableCollectionsKt.removeFirst(listViewModel.getFeeds());
                    }
                    listViewModel.liveStatus = qPlusLiveStatus2;
                    QPlusTrafficHomeVideoItemModel createLiveItemModel = listViewModel.createLiveItemModel(qPlusLiveStatus2);
                    listViewModel.getFeeds().add(0, createLiveItemModel);
                    QPlusCirStFeed qPlusCirStFeed2 = listViewModel.initSelectFeed;
                    if (qPlusCirStFeed2 != null) {
                        Intrinsics.checkNotNull(qPlusCirStFeed2);
                        listViewModel.initSelectFeed = qPlusCirStFeed2;
                        listViewModel.addFeedAtFirst(qPlusCirStFeed2);
                        listViewModel.selectFeed(qPlusCirStFeed2.feedId);
                    } else {
                        listViewModel.selectFeed(createLiveItemModel.info.feedId);
                        listViewModel.initSelectFeed = null;
                    }
                }
                QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel2 = QPlusTrafficHomeVideoViewModel.this;
                qPlusTrafficHomeVideoViewModel2.checkAllDataReady(qPlusTrafficHomeVideoViewModel2.feedState, QPlusTrafficUIState.COMPLETED, qPlusTrafficHomeVideoViewModel2.initFeedState);
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function22 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$refreshLiveAnchor$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str5) {
                num.intValue();
                QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel2 = QPlusTrafficHomeVideoViewModel.this;
                qPlusTrafficHomeVideoViewModel2.checkAllDataReady(qPlusTrafficHomeVideoViewModel2.feedState, QPlusTrafficUIState.FAILURE, qPlusTrafficHomeVideoViewModel2.initFeedState);
                return Unit.INSTANCE;
            }
        };
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(Long.parseLong(str4)));
        QPlusGetLiveAnchorRsp qPlusGetLiveAnchorRsp = new QPlusGetLiveAnchorRsp(null);
        Function1<QPlusGetLiveAnchorRsp, Unit> function13 = new Function1<QPlusGetLiveAnchorRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqLiveAnchor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusGetLiveAnchorRsp qPlusGetLiveAnchorRsp2) {
                QPlusLiveAnchorsKV qPlusLiveAnchorsKV;
                Object first;
                QPlusGetLiveAnchorRsp qPlusGetLiveAnchorRsp3 = qPlusGetLiveAnchorRsp2;
                ArrayList<QPlusLiveAnchorsKV> arrayList = qPlusGetLiveAnchorRsp3.liveAnchors;
                boolean z16 = false;
                if (arrayList != null && (arrayList.isEmpty() ^ true)) {
                    ArrayList<QPlusLiveAnchorsKV> arrayList2 = qPlusGetLiveAnchorRsp3.liveAnchors;
                    if (arrayList2 != null) {
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                        qPlusLiveAnchorsKV = (QPlusLiveAnchorsKV) first;
                    } else {
                        qPlusLiveAnchorsKV = null;
                    }
                    if (qPlusLiveAnchorsKV != null && qPlusLiveAnchorsKV.key == Long.parseLong(str4)) {
                        z16 = true;
                    }
                    if (z16) {
                        KLog.INSTANCE.i("QPlus", str4 + " it's live");
                        function12.invoke(qPlusLiveAnchorsKV != null ? qPlusLiveAnchorsKV.value : null);
                    } else {
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("it's live, bus not the same person, [reqUin:");
                        m3.append(str4);
                        m3.append(" rspUin:");
                        m3.append(qPlusLiveAnchorsKV != null ? Long.valueOf(qPlusLiveAnchorsKV.key) : null);
                        m3.append(']');
                        kLog.i("QPlus", m3.toString());
                        function12.invoke(null);
                    }
                } else {
                    KLog.INSTANCE.i("QPlus", str4 + " it not live");
                    function12.invoke(null);
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule2 = Utils.INSTANCE.currentBridgeModule();
        e eVar4 = new e();
        b bVar = new b();
        if (arrayListOf != null) {
            Iterator it = arrayListOf.iterator();
            while (it.hasNext()) {
                bVar.s(((Number) it.next()).longValue());
            }
        }
        eVar4.v("uins", bVar);
        currentBridgeModule2.ssoRequest("trpc.ecom.talent_search_svr.TalentSearchSvr/GetLiveAnchor", eVar4, false, new NetworkUtils$requestWithCmd$7(function22, qPlusGetLiveAnchorRsp, function13));
        final QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel = viewModel.dataViewModel;
        qPlusTrafficHomeDataViewModel.getClass();
        qPlusTrafficHomeDataViewModel.refreshData((QPlusGetOverviewRsp) IQPlusTrafficCache.DefaultImpls.getCache$default((QPlusTrafficCache) QPlusTrafficRepository.overviewCache$delegate.getValue(), null, false, 3, null));
        final Function1<QPlusGetOverviewRsp, Unit> function14 = new Function1<QPlusGetOverviewRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusTrafficHomeDataViewModel$refresh$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusGetOverviewRsp qPlusGetOverviewRsp) {
                QPlusTrafficHomeDataViewModel.this.refreshData(qPlusGetOverviewRsp);
                return Unit.INSTANCE;
            }
        };
        final Function2<Integer, String, Unit> function23 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusTrafficHomeDataViewModel$handleReqFailure$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str5) {
                ArrayList arrayListOf2;
                ArrayList arrayListOf3;
                ArrayList arrayListOf4;
                ArrayList arrayListOf5;
                num.intValue();
                QPlusTrafficHomeDataViewModel.this.categoryTitles.clear();
                QPlusTrafficHomeDataViewModel.this.categoryTitles.add("\u4f5c\u54c1\u6570\u636e");
                QPlusIndex qPlusIndex = new QPlusIndex("\u64ad\u653e\u91cf", -1);
                QPlusIndex qPlusIndex2 = new QPlusIndex("\u70b9\u8d5e\u91cf", -1);
                QPlusIndex qPlusIndex3 = new QPlusIndex("\u8bc4\u8bba\u91cf", -1);
                QPlusIndex qPlusIndex4 = new QPlusIndex("\u5173\u6ce8\u91cf", -1);
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(qPlusIndex, qPlusIndex2, qPlusIndex3, qPlusIndex4);
                QPlusDateIndex qPlusDateIndex = new QPlusDateIndex(1, arrayListOf2);
                arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(qPlusIndex, qPlusIndex2, qPlusIndex3, qPlusIndex4);
                QPlusDateIndex qPlusDateIndex2 = new QPlusDateIndex(2, arrayListOf3);
                arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(qPlusIndex, qPlusIndex2, qPlusIndex3, qPlusIndex4);
                QPlusDateIndex qPlusDateIndex3 = new QPlusDateIndex(3, arrayListOf4);
                ArrayList<QPlusOverviewData> arrayList = QPlusTrafficHomeDataViewModel.this.tabItems;
                QPlusViewTab qPlusViewTab = new QPlusViewTab(0, "\u4f5c\u54c1\u6570\u636e");
                arrayListOf5 = CollectionsKt__CollectionsKt.arrayListOf(qPlusDateIndex, qPlusDateIndex2, qPlusDateIndex3);
                arrayList.add(new QPlusOverviewData(qPlusViewTab, arrayListOf5));
                QPlusTrafficHomeDataViewModel.this.selectTabIndex(0);
                QPlusTrafficHomeDataViewModel.this.setUiState(QPlusTrafficUIState.FAILURE);
                return Unit.INSTANCE;
            }
        };
        Utils.INSTANCE.currentBridgeModule().ssoRequest("trpc.ecom.qplus_deliver_access_svr.QplusAccessSvr/GetOverview", new e(), false, new QPlusTrafficRepository$requestWithCmd$1(new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqOverviewInfo$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str5) {
                int intValue = num.intValue();
                function23.invoke(Integer.valueOf(intValue), str5);
                return Unit.INSTANCE;
            }
        }, new QPlusGetOverviewRsp(null), new Function2<QPlusGetOverviewRsp, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository$reqOverviewInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(QPlusGetOverviewRsp qPlusGetOverviewRsp, String str5) {
                QPlusGetOverviewRsp qPlusGetOverviewRsp2 = qPlusGetOverviewRsp;
                ((QPlusTrafficCache) QPlusTrafficRepository.overviewCache$delegate.getValue()).saveCache("", qPlusGetOverviewRsp2, str5);
                function14.invoke(qPlusGetOverviewRsp2);
                return Unit.INSTANCE;
            }
        }));
        viewModel.orderViewModel.refresh();
        viewModel.accountViewModel.refresh();
        addPagerEventObserver(this);
    }
}
