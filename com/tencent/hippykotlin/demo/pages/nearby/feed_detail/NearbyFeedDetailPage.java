package com.tencent.hippykotlin.demo.pages.nearby.feed_detail;

import c01.c;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PageLoadTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyRefreshView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterAttr;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarEvent;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPNavBarView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPTipSplitBarView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPTipSplitBarViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsAttr;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsCardViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyUserFeedsEvent;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$initFromData$1;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$initFromData$2;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$initFromData$3;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$initFromData$4;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$insertFeedFromPublish$insertPublishCardModel$1;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$pageOnCreate$firstCardModel$1;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedTimelineItemViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.RefreshView;
import com.tencent.kuikly.core.views.RefreshViewState;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.TransitionType;
import com.tencent.kuikly.core.views.TransitionView;
import com.tencent.kuikly.core.views.TransitionViewKt;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.be;
import com.tencent.kuikly.core.views.bf;
import com.tencent.kuikly.core.views.bk;
import com.tencent.kuikly.core.views.bl;
import com.tencent.kuikly.core.views.bm;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ci;
import com.tencent.kuikly.core.views.cj;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.x;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import com.tencent.map.lib.models.AccessibleTouchItem;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import n25.l;
import o25.f;
import r25.e;
import v25.a;
import v25.i;
import v25.p;

/* loaded from: classes31.dex */
public final class NearbyFeedDetailPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "footerRefreshText", "getFooterRefreshText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "popAnimation", "getPopAnimation()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "navBgGradientPercentage", "getNavBgGradientPercentage()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "isScrolling", "isScrolling()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "didSelectFollowingPage", "getDidSelectFollowingPage()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "refreshState", "getRefreshState()Lcom/tencent/kuikly/core/views/RefreshViewState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "followingRefreshState", "getFollowingRefreshState()Lcom/tencent/kuikly/core/views/RefreshViewState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "followingFootRefreshState", "getFollowingFootRefreshState()Lcom/tencent/kuikly/core/views/FooterRefreshState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedDetailPage.class, "pageScrollParams", "getPageScrollParams()Lcom/tencent/kuikly/core/views/ScrollParams;", 0)};
    public int didClickPublishBtnFlag;
    public boolean didClosePage;
    public final ReadWriteProperty didSelectFollowingPage$delegate;
    public int feedsPageIndex;
    public final ReadWriteProperty followingFootRefreshState$delegate;
    public final ReadWriteProperty followingRefreshState$delegate;
    public final ReadWriteProperty footerRefreshText$delegate;
    public aa<NearbyFDPListFooterView> footerRefreshViewRef;
    public boolean fromMap;
    public boolean hasHeadRefreshDisplayed;
    public final ReadWriteProperty isScrolling$delegate;
    public int lastPageIndex;
    public String mainPageCloseNotifyRef;
    public final ReadWriteProperty navBgGradientPercentage$delegate;
    public String openType = "";
    public aa<aq<?, ?>> pageListViewRef;
    public PageLoadTechReporter pageLoadReporter;
    public final Lazy pageModel$delegate;
    public final ReadWriteProperty pageScrollParams$delegate;
    public final ReadWriteProperty popAnimation$delegate;
    public String publishFeedFinishNotifyRef;
    public aa<PageListView<?, ?>> recFollPageListRef;
    public aa<RefreshView> refreshFollowingViewRef;
    public final ReadWriteProperty refreshState$delegate;
    public aa<RefreshView> refreshViewRef;
    public String tempAIOWillAppearNotifyRef;
    public String tempAIOWillDisappearNotifyRef;

    public NearbyFeedDetailPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NearbyFDPageViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$pageModel$2
            @Override // kotlin.jvm.functions.Function0
            public final NearbyFDPageViewModel invoke() {
                return new NearbyFDPageViewModel();
            }
        });
        this.pageModel$delegate = lazy;
        this.footerRefreshText$delegate = c.a("\u52a0\u8f7d\u4e2d");
        Boolean bool = Boolean.FALSE;
        this.popAnimation$delegate = c.a(bool);
        this.navBgGradientPercentage$delegate = c.a(Float.valueOf(0.0f));
        this.isScrolling$delegate = c.a(bool);
        this.didSelectFollowingPage$delegate = c.a(bool);
        RefreshViewState refreshViewState = RefreshViewState.IDLE;
        this.refreshState$delegate = c.a(refreshViewState);
        this.followingRefreshState$delegate = c.a(refreshViewState);
        this.followingFootRefreshState$delegate = c.a(FooterRefreshState.IDLE);
        this.lastPageIndex = 1;
        this.pageScrollParams$delegate = c.a(null);
    }

    public static final ScrollParams access$getPageScrollParams(NearbyFeedDetailPage nearbyFeedDetailPage) {
        return (ScrollParams) nearbyFeedDetailPage.pageScrollParams$delegate.getValue(nearbyFeedDetailPage, $$delegatedProperties[8]);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(h.INSTANCE.j());
                        return Unit.INSTANCE;
                    }
                });
                TransitionType transitionType = TransitionType.DIRECTION_FROM_RIGHT;
                final NearbyFeedDetailPage nearbyFeedDetailPage = NearbyFeedDetailPage.this;
                TransitionViewKt.a(viewContainer2, transitionType, new Function1<TransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TransitionView transitionView) {
                        TransitionView transitionView2 = transitionView;
                        final NearbyFeedDetailPage nearbyFeedDetailPage2 = NearbyFeedDetailPage.this;
                        transitionView2.attr(new Function1<ci, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ci ciVar) {
                                b j3;
                                ci ciVar2 = ciVar;
                                ciVar2.size(ciVar2.getPagerData().m(), ciVar2.getPagerData().l());
                                NearbyFeedDetailPage nearbyFeedDetailPage3 = NearbyFeedDetailPage.this;
                                ciVar2.r(!((Boolean) nearbyFeedDetailPage3.popAnimation$delegate.getValue(nearbyFeedDetailPage3, NearbyFeedDetailPage.$$delegatedProperties[1])).booleanValue());
                                if (ciVar2.getPagerData().getIsIOS()) {
                                    j3 = b.Companion.r(b.INSTANCE, 0.3f, 1.0f, 0.95f, null, 8, null);
                                } else {
                                    j3 = b.Companion.j(b.INSTANCE, 0.25f, null, 2, null);
                                }
                                ciVar2.h(j3);
                                return Unit.INSTANCE;
                            }
                        });
                        transitionView2.event(new Function1<cj, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cj cjVar) {
                                cjVar.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        boolean booleanValue = bool.booleanValue();
                                        KLog kLog = KLog.INSTANCE;
                                        NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                        CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("transitionFinish ", booleanValue, kLog, "feed_detail_page");
                                        if (!booleanValue) {
                                            kLog.i("feed_detail_page", "pop NearbyFeedDetailPage when transitionFinish");
                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.closePage$default();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedDetailPage nearbyFeedDetailPage3 = NearbyFeedDetailPage.this;
                        bf.a(transitionView2, new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PageListView<?, ?> pageListView) {
                                PageListView<?, ?> pageListView2 = pageListView;
                                pageListView2.attr(new Function1<be, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(be beVar) {
                                        be beVar2 = beVar;
                                        beVar2.pageItemWidth(beVar2.getPagerData().m());
                                        beVar2.pageItemHeight(beVar2.getPagerData().l());
                                        beVar2.defaultPageIndex(1);
                                        beVar2.pageDirection(true);
                                        ScrollerAttr.bouncesEnable$default(beVar2, false, false, 2, null);
                                        beVar2.showScrollerIndicator(false);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFeedDetailPage nearbyFeedDetailPage4 = NearbyFeedDetailPage.this;
                                pageListView2.event(new Function1<PageListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PageListEvent pageListEvent) {
                                        final NearbyFeedDetailPage nearbyFeedDetailPage5 = NearbyFeedDetailPage.this;
                                        pageListEvent.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                ScrollParams scrollParams2 = scrollParams;
                                                int i3 = scrollParams2.getOffsetX() > scrollParams2.getViewWidth() - ((float) 10) ? 1 : 0;
                                                NearbyFeedDetailPage nearbyFeedDetailPage6 = NearbyFeedDetailPage.this;
                                                if (i3 != nearbyFeedDetailPage6.lastPageIndex) {
                                                    nearbyFeedDetailPage6.lastPageIndex = i3;
                                                    nearbyFeedDetailPage6.hideMainMapForegroundUIIfNeed(i3 == 1);
                                                }
                                                if (scrollParams2.getOffsetX() < scrollParams2.getViewWidth() / 8) {
                                                    NearbyFeedDetailPage.this.closePage(false);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(pageListView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.mo113backgroundColor(h.INSTANCE.j());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFeedDetailPage nearbyFeedDetailPage5 = NearbyFeedDetailPage.this;
                                w.a(pageListView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.mo113backgroundColor(h.INSTANCE.j());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFeedDetailPage nearbyFeedDetailPage6 = NearbyFeedDetailPage.this;
                                        vVar2.addChild(new NearbyFDPNavBarView(), new Function1<NearbyFDPNavBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NearbyFDPNavBarView nearbyFDPNavBarView) {
                                                NearbyFDPNavBarView nearbyFDPNavBarView2 = nearbyFDPNavBarView;
                                                final NearbyFeedDetailPage nearbyFeedDetailPage7 = NearbyFeedDetailPage.this;
                                                nearbyFDPNavBarView2.attr(new Function1<NearbyFDPNavBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NearbyFDPNavBarAttr nearbyFDPNavBarAttr) {
                                                        NearbyFDPNavBarAttr nearbyFDPNavBarAttr2 = nearbyFDPNavBarAttr;
                                                        NearbyFeedDetailPage nearbyFeedDetailPage8 = NearbyFeedDetailPage.this;
                                                        float floatValue = nearbyFeedDetailPage8.fromMap ? ((Number) nearbyFeedDetailPage8.navBgGradientPercentage$delegate.getValue(nearbyFeedDetailPage8, NearbyFeedDetailPage.$$delegatedProperties[2])).floatValue() : 1.0f;
                                                        ReadWriteProperty readWriteProperty = nearbyFDPNavBarAttr2.bgGradientPercentage$delegate;
                                                        KProperty<?>[] kPropertyArr = NearbyFDPNavBarAttr.$$delegatedProperties;
                                                        readWriteProperty.setValue(nearbyFDPNavBarAttr2, kPropertyArr[0], Float.valueOf(floatValue));
                                                        NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                                                        nearbyFDPNavBarAttr2.navTitle$delegate.setValue(nearbyFDPNavBarAttr2, kPropertyArr[1], (String) pageModel.navTitle$delegate.getValue(pageModel, NearbyFDPageViewModel.$$delegatedProperties[5]));
                                                        nearbyFDPNavBarAttr2.themeId$delegate.setValue(nearbyFDPNavBarAttr2, kPropertyArr[2], NearbyFeedDetailPage.this.getPageModel().themeId);
                                                        nearbyFDPNavBarAttr2.scrollParams$delegate.setValue(nearbyFDPNavBarAttr2, kPropertyArr[3], NearbyFeedDetailPage.access$getPageScrollParams(NearbyFeedDetailPage.this));
                                                        nearbyFDPNavBarAttr2.dtReporter = NearbyFeedDetailPage.this.getPageModel().dtReporter;
                                                        NearbyFeedDetailPage nearbyFeedDetailPage9 = NearbyFeedDetailPage.this;
                                                        nearbyFDPNavBarAttr2.isFollowingPage$delegate.setValue(nearbyFDPNavBarAttr2, kPropertyArr[4], Boolean.valueOf(((Boolean) nearbyFeedDetailPage9.didSelectFollowingPage$delegate.getValue(nearbyFeedDetailPage9, NearbyFeedDetailPage.$$delegatedProperties[4])).booleanValue()));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFeedDetailPage nearbyFeedDetailPage8 = NearbyFeedDetailPage.this;
                                                nearbyFDPNavBarView2.event(new Function1<NearbyFDPNavBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NearbyFDPNavBarEvent nearbyFDPNavBarEvent) {
                                                        NearbyFDPNavBarEvent nearbyFDPNavBarEvent2 = nearbyFDPNavBarEvent;
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage9 = NearbyFeedDetailPage.this;
                                                        nearbyFDPNavBarEvent2.clickBackBtnHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NearbyFeedDetailPage nearbyFeedDetailPage10 = NearbyFeedDetailPage.this;
                                                                KProperty<Object>[] kPropertyArr = NearbyFeedDetailPage.$$delegatedProperties;
                                                                nearbyFeedDetailPage10.closePage(true);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage10 = NearbyFeedDetailPage.this;
                                                        nearbyFDPNavBarEvent2.clickPublishBtnHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.2.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                NearbyFeedDetailPage.this.didClickPublishBtnFlag++;
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage11 = NearbyFeedDetailPage.this;
                                                        nearbyFDPNavBarEvent2.clickTabHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.2.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                PageListView<?, ?> b16;
                                                                int parseInt = Integer.parseInt(String.valueOf(obj));
                                                                aa<PageListView<?, ?>> aaVar = NearbyFeedDetailPage.this.recFollPageListRef;
                                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                    b16.scrollToPageIndex(parseInt, true);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFeedDetailPage nearbyFeedDetailPage7 = NearbyFeedDetailPage.this;
                                        bf.a(vVar2, new Function1<PageListView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(PageListView<?, ?> pageListView3) {
                                                PageListView<?, ?> pageListView4 = pageListView3;
                                                final NearbyFeedDetailPage nearbyFeedDetailPage8 = NearbyFeedDetailPage.this;
                                                pageListView4.ref(pageListView4, new Function1<aa<PageListView<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<PageListView<?, ?>> aaVar) {
                                                        NearbyFeedDetailPage.this.recFollPageListRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFeedDetailPage nearbyFeedDetailPage9 = NearbyFeedDetailPage.this;
                                                pageListView4.attr(new Function1<be, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(be beVar) {
                                                        be beVar2 = beVar;
                                                        beVar2.mo153width(beVar2.getPagerData().m());
                                                        beVar2.pageItemWidth(beVar2.getPagerData().m());
                                                        beVar2.pageItemHeight(beVar2.getPagerData().l());
                                                        beVar2.defaultPageIndex(NearbyFeedDetailPage.this.feedsPageIndex);
                                                        beVar2.pageDirection(true);
                                                        ScrollerAttr.bouncesEnable$default(beVar2, false, false, 2, null);
                                                        beVar2.showScrollerIndicator(false);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFeedDetailPage nearbyFeedDetailPage10 = NearbyFeedDetailPage.this;
                                                pageListView4.event(new Function1<PageListEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(PageListEvent pageListEvent) {
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage11 = NearbyFeedDetailPage.this;
                                                        pageListEvent.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ScrollParams scrollParams) {
                                                                NearbyFeedDetailPage nearbyFeedDetailPage12 = NearbyFeedDetailPage.this;
                                                                nearbyFeedDetailPage12.pageScrollParams$delegate.setValue(nearbyFeedDetailPage12, NearbyFeedDetailPage.$$delegatedProperties[8], scrollParams);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFeedDetailPage nearbyFeedDetailPage11 = NearbyFeedDetailPage.this;
                                                ar.a(pageListView4, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aq<?, ?> aqVar) {
                                                        aq<?, ?> aqVar2 = aqVar;
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage12 = NearbyFeedDetailPage.this;
                                                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                                NearbyFeedDetailPage.this.pageListViewRef = aaVar;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage13 = NearbyFeedDetailPage.this;
                                                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.2
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
                                                            /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            /*
                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                            */
                                                            public final Unit invoke(ao aoVar) {
                                                                boolean z16;
                                                                ao aoVar2 = aoVar;
                                                                aoVar2.m140flex(1.0f);
                                                                aoVar2.mo153width(aoVar2.getPagerData().m());
                                                                ScrollParams access$getPageScrollParams = NearbyFeedDetailPage.access$getPageScrollParams(NearbyFeedDetailPage.this);
                                                                if (!Intrinsics.areEqual(access$getPageScrollParams != null ? Float.valueOf(access$getPageScrollParams.getOffsetX()) : null, 0.0f)) {
                                                                    ScrollParams access$getPageScrollParams2 = NearbyFeedDetailPage.access$getPageScrollParams(NearbyFeedDetailPage.this);
                                                                    if ((access$getPageScrollParams2 != null ? Float.valueOf(access$getPageScrollParams2.getOffsetX()) : null) != null) {
                                                                        z16 = false;
                                                                        aoVar2.showScrollerIndicator(z16);
                                                                        aoVar2.paddingBottom(!aoVar2.getPagerData().getIsIphoneX() ? 30.0f : 5.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }
                                                                z16 = true;
                                                                aoVar2.showScrollerIndicator(z16);
                                                                aoVar2.paddingBottom(!aoVar2.getPagerData().getIsIphoneX() ? 30.0f : 5.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage14 = NearbyFeedDetailPage.this;
                                                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ap apVar) {
                                                                ap apVar2 = apVar;
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage15 = NearbyFeedDetailPage.this;
                                                                apVar2.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                                        NearbyFeedDetailPage.this.setScrolling(true);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage16 = NearbyFeedDetailPage.this;
                                                                apVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                                        NearbyFeedDetailPage.this.setScrolling(false);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage17 = NearbyFeedDetailPage.this;
                                                                apVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.3.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ScrollParams scrollParams) {
                                                                        NearbyFeedDetailPage.access$updateNavBgGradientPercentage(NearbyFeedDetailPage.this, scrollParams.getOffsetY());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage18 = NearbyFeedDetailPage.this;
                                                                VisibilityEventKt.b(apVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.3.4
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        NearbyFeedDetailPage nearbyFeedDetailPage19 = NearbyFeedDetailPage.this;
                                                                        nearbyFeedDetailPage19.didSelectFollowingPage$delegate.setValue(nearbyFeedDetailPage19, NearbyFeedDetailPage.$$delegatedProperties[4], Boolean.FALSE);
                                                                        NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                                                                        KProperty<Object>[] kPropertyArr = NearbyFDPageViewModel.$$delegatedProperties;
                                                                        pageModel.dtReportPageExposure(true, false);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage19 = NearbyFeedDetailPage.this;
                                                                VisibilityEventKt.c(apVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.3.5
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                                                                        KProperty<Object>[] kPropertyArr = NearbyFDPageViewModel.$$delegatedProperties;
                                                                        pageModel.dtReportPageExposure(false, false);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage15 = NearbyFeedDetailPage.this;
                                                        bm.b(aqVar2, false, new Function1<RefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RefreshView refreshView) {
                                                                RefreshView refreshView2 = refreshView;
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage16 = NearbyFeedDetailPage.this;
                                                                refreshView2.ref(refreshView2, new Function1<aa<RefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(aa<RefreshView> aaVar) {
                                                                        NearbyFeedDetailPage.this.refreshViewRef = aaVar;
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage17 = NearbyFeedDetailPage.this;
                                                                refreshView2.attr(new Function1<bk, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.4.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(bk bkVar) {
                                                                        bk bkVar2 = bkVar;
                                                                        bkVar2.j(!NearbyFeedDetailPage.this.getPageModel().getMainFeedsCardList().isEmpty());
                                                                        bkVar2.m152visibility(!NearbyFeedDetailPage.this.getPageModel().getMainFeedsCardList().isEmpty());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage18 = NearbyFeedDetailPage.this;
                                                                refreshView2.addChild(new NearbyRefreshView(), new Function1<NearbyRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.4.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NearbyRefreshView nearbyRefreshView) {
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage19 = NearbyFeedDetailPage.this;
                                                                        nearbyRefreshView.attr(new Function1<NearbyRefreshAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.4.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(NearbyRefreshAttr nearbyRefreshAttr) {
                                                                                NearbyRefreshAttr nearbyRefreshAttr2 = nearbyRefreshAttr;
                                                                                NearbyFeedDetailPage nearbyFeedDetailPage20 = NearbyFeedDetailPage.this;
                                                                                nearbyRefreshAttr2.refreshState$delegate.setValue(nearbyRefreshAttr2, NearbyRefreshAttr.$$delegatedProperties[0], (RefreshViewState) nearbyFeedDetailPage20.refreshState$delegate.getValue(nearbyFeedDetailPage20, NearbyFeedDetailPage.$$delegatedProperties[5]));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage19 = NearbyFeedDetailPage.this;
                                                                refreshView2.event(new Function1<bl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.4.4
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(bl blVar) {
                                                                        final bl blVar2 = blVar;
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage20 = NearbyFeedDetailPage.this;
                                                                        blVar2.j(new Function1<RefreshViewState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.4.4.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(RefreshViewState refreshViewState) {
                                                                                NearbyFeedDetailPage nearbyFeedDetailPage21 = NearbyFeedDetailPage.this;
                                                                                ReadWriteProperty readWriteProperty = nearbyFeedDetailPage21.refreshState$delegate;
                                                                                KProperty<?>[] kPropertyArr = NearbyFeedDetailPage.$$delegatedProperties;
                                                                                readWriteProperty.setValue(nearbyFeedDetailPage21, kPropertyArr[5], refreshViewState);
                                                                                NearbyFeedDetailPage nearbyFeedDetailPage22 = NearbyFeedDetailPage.this;
                                                                                if (((RefreshViewState) nearbyFeedDetailPage22.refreshState$delegate.getValue(nearbyFeedDetailPage22, kPropertyArr[5])) == RefreshViewState.REFRESHING) {
                                                                                    final NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                                                                                    final NearbyFeedDetailPage nearbyFeedDetailPage23 = NearbyFeedDetailPage.this;
                                                                                    final bl blVar3 = blVar2;
                                                                                    final Function2<String, Boolean, Unit> function2 = new Function2<String, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.4.4.1.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(2);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function2
                                                                                        public final Unit invoke(String str, Boolean bool) {
                                                                                            QToastMode qToastMode;
                                                                                            aa<NearbyFDPListFooterView> aaVar;
                                                                                            NearbyFDPListFooterView b16;
                                                                                            aa<FooterRefreshView> aaVar2;
                                                                                            FooterRefreshView b17;
                                                                                            RefreshView b18;
                                                                                            String str2 = str;
                                                                                            boolean booleanValue = bool.booleanValue();
                                                                                            aa<RefreshView> aaVar3 = NearbyFeedDetailPage.this.refreshViewRef;
                                                                                            if (aaVar3 != null && (b18 = aaVar3.b()) != null) {
                                                                                                b18.p();
                                                                                            }
                                                                                            if (booleanValue && (aaVar = NearbyFeedDetailPage.this.footerRefreshViewRef) != null && (b16 = aaVar.b()) != null && (aaVar2 = b16.refreshViewRef) != null && (b17 = aaVar2.b()) != null) {
                                                                                                b17.t(FooterRefreshEndState.SUCCESS);
                                                                                            }
                                                                                            if (str2.length() > 0) {
                                                                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(blVar3);
                                                                                                if (booleanValue) {
                                                                                                    qToastMode = QToastMode.Success;
                                                                                                } else {
                                                                                                    qToastMode = QToastMode.Info;
                                                                                                }
                                                                                                bridgeModule.qToast(str2, qToastMode);
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    };
                                                                                    pageModel.getClass();
                                                                                    NearbyFDPageViewModel.fetchFeedsFromServerForCache$default(pageModel, false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$headerRefresh$1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                                        {
                                                                                            super(2);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function2
                                                                                        public final Unit invoke(Boolean bool, Boolean bool2) {
                                                                                            Object firstOrNull;
                                                                                            Object firstOrNull2;
                                                                                            NearbyFDPUserFeedTimelineItemViewModel contentModel;
                                                                                            boolean booleanValue = bool.booleanValue();
                                                                                            bool2.booleanValue();
                                                                                            NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                                                                                            if (nearbyFDPageViewModel.fetchingState == 4) {
                                                                                                function2.invoke("\u5237\u65b0\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc", Boolean.FALSE);
                                                                                            } else if (booleanValue) {
                                                                                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) nearbyFDPageViewModel.localFeedsFromServe);
                                                                                                FeedCache feedCache = (FeedCache) firstOrNull;
                                                                                                String str = feedCache != null ? feedCache.feedId : null;
                                                                                                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) NearbyFDPageViewModel.this.getMainFeedsCardList());
                                                                                                NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = (NearbyFDPUserFeedsCardViewModel) firstOrNull2;
                                                                                                if (Intrinsics.areEqual(str, (nearbyFDPUserFeedsCardViewModel == null || (contentModel = nearbyFDPUserFeedsCardViewModel.getContentModel()) == null) ? null : contentModel.getFid())) {
                                                                                                    NearbyFDPageViewModel nearbyFDPageViewModel2 = NearbyFDPageViewModel.this;
                                                                                                    nearbyFDPageViewModel2.lastLocalFeedsIndex = 0;
                                                                                                    com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel> mainFeedsCardList = nearbyFDPageViewModel2.getMainFeedsCardList();
                                                                                                    final NearbyFDPageViewModel nearbyFDPageViewModel3 = NearbyFDPageViewModel.this;
                                                                                                    CollectionsKt__MutableCollectionsKt.retainAll((List) mainFeedsCardList, (Function1) new Function1<NearbyFDPUserFeedsCardViewModel, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$headerRefresh$1.1
                                                                                                        {
                                                                                                            super(1);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Boolean invoke(NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2) {
                                                                                                            Object first;
                                                                                                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) NearbyFDPageViewModel.this.getMainFeedsCardList());
                                                                                                            return Boolean.valueOf(Intrinsics.areEqual(nearbyFDPUserFeedsCardViewModel2, first));
                                                                                                        }
                                                                                                    });
                                                                                                } else {
                                                                                                    NearbyFDPageViewModel nearbyFDPageViewModel4 = NearbyFDPageViewModel.this;
                                                                                                    nearbyFDPageViewModel4.lastLocalFeedsIndex = -1;
                                                                                                    nearbyFDPageViewModel4.getMainFeedsCardList().clear();
                                                                                                }
                                                                                                NearbyFDPageViewModel.this.loadNextFeedsListFromLocalForDisplay(null);
                                                                                                function2.invoke("\u5df2\u66f4\u65b0\u63a8\u8350\u5185\u5bb9", Boolean.TRUE);
                                                                                            } else {
                                                                                                function2.invoke("\u9644\u8fd1\u6ca1\u6709\u65b0\u52a8\u6001\u5566", Boolean.FALSE);
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }, 2);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 1, null);
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage16 = NearbyFeedDetailPage.this;
                                                        Function0<com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.5
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel> invoke() {
                                                                return NearbyFeedDetailPage.this.getPageModel().getMainFeedsCardList();
                                                            }
                                                        };
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage17 = NearbyFeedDetailPage.this;
                                                        LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<NearbyFDPUserFeedsCardViewModel>, NearbyFDPUserFeedsCardViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(LoopDirectivesView<NearbyFDPUserFeedsCardViewModel> loopDirectivesView, NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel) {
                                                                final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 = nearbyFDPUserFeedsCardViewModel;
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage18 = NearbyFeedDetailPage.this;
                                                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        v vVar4 = vVar3;
                                                                        final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel3 = NearbyFDPUserFeedsCardViewModel.this;
                                                                        ConditionViewKt.c(vVar4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6.1.1
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Object invoke() {
                                                                                NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel4 = NearbyFDPUserFeedsCardViewModel.this;
                                                                                return Boolean.valueOf(((Boolean) nearbyFDPUserFeedsCardViewModel4.showOtherCityTipBar$delegate.getValue(nearbyFDPUserFeedsCardViewModel4, NearbyFDPUserFeedsCardViewModel.$$delegatedProperties[4])).booleanValue());
                                                                            }
                                                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6.1.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ConditionView conditionView) {
                                                                                conditionView.addChild(new NearbyFDPTipSplitBarView(), new Function1<NearbyFDPTipSplitBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6.1.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(NearbyFDPTipSplitBarView nearbyFDPTipSplitBarView) {
                                                                                        nearbyFDPTipSplitBarView.attr(new Function1<NearbyFDPTipSplitBarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6.1.2.1.1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(NearbyFDPTipSplitBarViewAttr nearbyFDPTipSplitBarViewAttr) {
                                                                                                NearbyFDPTipSplitBarViewAttr nearbyFDPTipSplitBarViewAttr2 = nearbyFDPTipSplitBarViewAttr;
                                                                                                nearbyFDPTipSplitBarViewAttr2.text$delegate.setValue(nearbyFDPTipSplitBarViewAttr2, NearbyFDPTipSplitBarViewAttr.$$delegatedProperties[0], "\u9644\u8fd1\u6682\u65e0\u52a8\u6001\uff0c\u4e3a\u4f60\u6f2b\u6e38\u5230\u5468\u8fb9\u57ce\u5e02");
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel4 = NearbyFDPUserFeedsCardViewModel.this;
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage19 = nearbyFeedDetailPage18;
                                                                        NearbyUserFeedsCardViewKt.NearbyUserFeedsCard(vVar4, new Function1<NearbyUserFeedsCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6.1.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(NearbyUserFeedsCardView nearbyUserFeedsCardView) {
                                                                                NearbyUserFeedsCardView nearbyUserFeedsCardView2 = nearbyUserFeedsCardView;
                                                                                final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel5 = NearbyFDPUserFeedsCardViewModel.this;
                                                                                final NearbyFeedDetailPage nearbyFeedDetailPage20 = nearbyFeedDetailPage19;
                                                                                nearbyUserFeedsCardView2.attr(new Function1<NearbyUserFeedsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6.1.3.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(NearbyUserFeedsAttr nearbyUserFeedsAttr) {
                                                                                        NearbyUserFeedsAttr nearbyUserFeedsAttr2 = nearbyUserFeedsAttr;
                                                                                        nearbyUserFeedsAttr2.viewModel = NearbyFDPUserFeedsCardViewModel.this;
                                                                                        nearbyUserFeedsAttr2.dtReporter = nearbyFeedDetailPage20.getPageModel().dtReporter;
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                nearbyUserFeedsCardView2.event(new Function1<NearbyUserFeedsEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.6.1.3.2
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final /* bridge */ /* synthetic */ Unit invoke(NearbyUserFeedsEvent nearbyUserFeedsEvent) {
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
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage18 = NearbyFeedDetailPage.this;
                                                        aqVar2.addChild(new NearbyFDPListFooterView(), new Function1<NearbyFDPListFooterView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.7
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NearbyFDPListFooterView nearbyFDPListFooterView) {
                                                                NearbyFDPListFooterView nearbyFDPListFooterView2 = nearbyFDPListFooterView;
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage19 = NearbyFeedDetailPage.this;
                                                                nearbyFDPListFooterView2.ref(nearbyFDPListFooterView2, new Function1<aa<NearbyFDPListFooterView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.7.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(aa<NearbyFDPListFooterView> aaVar) {
                                                                        NearbyFeedDetailPage.this.footerRefreshViewRef = aaVar;
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage20 = NearbyFeedDetailPage.this;
                                                                nearbyFDPListFooterView2.attr(new Function1<NearbyFDPListFooterAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.4.7.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(NearbyFDPListFooterAttr nearbyFDPListFooterAttr) {
                                                                        nearbyFDPListFooterAttr.viewModel = NearbyFeedDetailPage.this.getPageModel();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyFeedDetailPage nearbyFeedDetailPage12 = NearbyFeedDetailPage.this;
                                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.5
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        boolean z16 = true;
                                                        if (!NearbyFeedDetailPage.this.getPageModel().currentTheme.H) {
                                                            if (!(NearbyFeedDetailPage.this.getPageModel().themeId.length() == 0)) {
                                                                z16 = false;
                                                            }
                                                        }
                                                        return Boolean.valueOf(z16);
                                                    }
                                                };
                                                final NearbyFeedDetailPage nearbyFeedDetailPage13 = NearbyFeedDetailPage.this;
                                                ConditionViewKt.c(pageListView4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final NearbyFeedDetailPage nearbyFeedDetailPage14 = NearbyFeedDetailPage.this;
                                                        ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(aq<?, ?> aqVar) {
                                                                aq<?, ?> aqVar2 = aqVar;
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage15 = NearbyFeedDetailPage.this;
                                                                aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                                        NearbyFeedDetailPage nearbyFeedDetailPage16 = NearbyFeedDetailPage.this;
                                                                        KProperty<Object>[] kPropertyArr = NearbyFeedDetailPage.$$delegatedProperties;
                                                                        nearbyFeedDetailPage16.getClass();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ao aoVar) {
                                                                        ao aoVar2 = aoVar;
                                                                        aoVar2.m140flex(1.0f);
                                                                        aoVar2.mo153width(aoVar2.getPagerData().m());
                                                                        aoVar2.paddingBottom(aoVar2.getPagerData().getIsIphoneX() ? 30.0f : 5.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage16 = NearbyFeedDetailPage.this;
                                                                aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ap apVar) {
                                                                        ap apVar2 = apVar;
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage17 = NearbyFeedDetailPage.this;
                                                                        apVar2.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ScrollParams scrollParams) {
                                                                                NearbyFeedDetailPage.this.setScrolling(true);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage18 = NearbyFeedDetailPage.this;
                                                                        apVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.3.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ScrollParams scrollParams) {
                                                                                NearbyFeedDetailPage.this.setScrolling(false);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage19 = NearbyFeedDetailPage.this;
                                                                        apVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.3.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ScrollParams scrollParams) {
                                                                                NearbyFeedDetailPage.access$updateNavBgGradientPercentage(NearbyFeedDetailPage.this, scrollParams.getOffsetY());
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage20 = NearbyFeedDetailPage.this;
                                                                        VisibilityEventKt.b(apVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.3.4
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                List asReversedMutable;
                                                                                NearbyFeedDetailPage nearbyFeedDetailPage21 = NearbyFeedDetailPage.this;
                                                                                nearbyFeedDetailPage21.didSelectFollowingPage$delegate.setValue(nearbyFeedDetailPage21, NearbyFeedDetailPage.$$delegatedProperties[4], Boolean.TRUE);
                                                                                if (NearbyFeedDetailPage.this.getPageModel().isFistTimeOpenFollowingPage) {
                                                                                    NearbyFeedDetailPage.this.getPageModel().isFistTimeOpenFollowingPage = false;
                                                                                    NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                                                                                    final NearbyFeedDetailPage nearbyFeedDetailPage22 = NearbyFeedDetailPage.this;
                                                                                    pageModel.fetchFollowList(new Function2<String, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.3.4.1
                                                                                        {
                                                                                            super(2);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function2
                                                                                        public final Unit invoke(String str, Boolean bool) {
                                                                                            boolean booleanValue = bool.booleanValue();
                                                                                            KLog kLog = KLog.INSTANCE;
                                                                                            NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                                                                            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("fetchFollowList feeds callback resultText: ", str, kLog, "feed_detail_page");
                                                                                            if (!booleanValue) {
                                                                                                NearbyFeedDetailPage.this.getPageModel().followingFootRefresh();
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                }
                                                                                if (NearbyFeedDetailPage.this.getPageModel().needToRemoveFollowingFeeds) {
                                                                                    NearbyFDPageViewModel pageModel2 = NearbyFeedDetailPage.this.getPageModel();
                                                                                    pageModel2.getClass();
                                                                                    KLog kLog = KLog.INSTANCE;
                                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("homepage changed followStatus id:");
                                                                                    m3.append(pageModel2.accountId);
                                                                                    m3.append(", doFollow: ");
                                                                                    AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(m3, pageModel2.doFollow, kLog, "NearbyFDPUserFeedsCardViewModel");
                                                                                    if (!pageModel2.doFollow) {
                                                                                        ArrayList arrayList = new ArrayList();
                                                                                        int size = pageModel2.getFollowFeedsCardList().size();
                                                                                        for (int i3 = 0; i3 < size; i3++) {
                                                                                            if (Intrinsics.areEqual(String.valueOf(pageModel2.getFollowFeedsCardList().get(i3).getTinyId()), pageModel2.accountId)) {
                                                                                                arrayList.add(Integer.valueOf(i3));
                                                                                            }
                                                                                        }
                                                                                        asReversedMutable = CollectionsKt__ReversedViewsKt.asReversedMutable(arrayList);
                                                                                        Iterator it = asReversedMutable.iterator();
                                                                                        while (it.hasNext()) {
                                                                                            pageModel2.getFollowFeedsCardList().remove(((Number) it.next()).intValue());
                                                                                        }
                                                                                        if (pageModel2.getFollowFeedsCardList().size() == 0) {
                                                                                            pageModel2.hasLoadAllFollowingFeeds = true;
                                                                                            pageModel2.followingFootRefresh();
                                                                                        }
                                                                                    }
                                                                                }
                                                                                NearbyFeedDetailPage.this.getPageModel().dtReportPageExposure(true, true);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage21 = NearbyFeedDetailPage.this;
                                                                        VisibilityEventKt.c(apVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.3.5
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                NearbyFeedDetailPage.this.getPageModel().dtReportPageExposure(false, true);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage17 = NearbyFeedDetailPage.this;
                                                                bm.b(aqVar2, false, new Function1<RefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.4
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(RefreshView refreshView) {
                                                                        RefreshView refreshView2 = refreshView;
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage18 = NearbyFeedDetailPage.this;
                                                                        refreshView2.ref(refreshView2, new Function1<aa<RefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.4.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(aa<RefreshView> aaVar) {
                                                                                NearbyFeedDetailPage.this.refreshFollowingViewRef = aaVar;
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage19 = NearbyFeedDetailPage.this;
                                                                        refreshView2.attr(new Function1<bk, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.4.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(bk bkVar) {
                                                                                bk bkVar2 = bkVar;
                                                                                bkVar2.j(!NearbyFeedDetailPage.this.getPageModel().getFollowFeedsCardList().isEmpty());
                                                                                bkVar2.m152visibility(!NearbyFeedDetailPage.this.getPageModel().getFollowFeedsCardList().isEmpty());
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage20 = NearbyFeedDetailPage.this;
                                                                        refreshView2.addChild(new NearbyRefreshView(), new Function1<NearbyRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.4.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(NearbyRefreshView nearbyRefreshView) {
                                                                                final NearbyFeedDetailPage nearbyFeedDetailPage21 = NearbyFeedDetailPage.this;
                                                                                nearbyRefreshView.attr(new Function1<NearbyRefreshAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.4.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(NearbyRefreshAttr nearbyRefreshAttr) {
                                                                                        NearbyRefreshAttr nearbyRefreshAttr2 = nearbyRefreshAttr;
                                                                                        NearbyFeedDetailPage nearbyFeedDetailPage22 = NearbyFeedDetailPage.this;
                                                                                        nearbyRefreshAttr2.refreshState$delegate.setValue(nearbyRefreshAttr2, NearbyRefreshAttr.$$delegatedProperties[0], (RefreshViewState) nearbyFeedDetailPage22.followingRefreshState$delegate.getValue(nearbyFeedDetailPage22, NearbyFeedDetailPage.$$delegatedProperties[6]));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage21 = NearbyFeedDetailPage.this;
                                                                        refreshView2.event(new Function1<bl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.4.4
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(bl blVar) {
                                                                                final bl blVar2 = blVar;
                                                                                final NearbyFeedDetailPage nearbyFeedDetailPage22 = NearbyFeedDetailPage.this;
                                                                                blVar2.j(new Function1<RefreshViewState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.4.4.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(RefreshViewState refreshViewState) {
                                                                                        NearbyFeedDetailPage nearbyFeedDetailPage23 = NearbyFeedDetailPage.this;
                                                                                        ReadWriteProperty readWriteProperty = nearbyFeedDetailPage23.followingRefreshState$delegate;
                                                                                        KProperty<?>[] kPropertyArr = NearbyFeedDetailPage.$$delegatedProperties;
                                                                                        readWriteProperty.setValue(nearbyFeedDetailPage23, kPropertyArr[6], refreshViewState);
                                                                                        NearbyFeedDetailPage nearbyFeedDetailPage24 = NearbyFeedDetailPage.this;
                                                                                        if (((RefreshViewState) nearbyFeedDetailPage24.followingRefreshState$delegate.getValue(nearbyFeedDetailPage24, kPropertyArr[6])) == RefreshViewState.REFRESHING) {
                                                                                            NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                                                                                            final NearbyFeedDetailPage nearbyFeedDetailPage25 = NearbyFeedDetailPage.this;
                                                                                            final bl blVar3 = blVar2;
                                                                                            pageModel.fetchFollowList(new Function2<String, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.4.4.1.1
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(2);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                                public final Unit invoke(String str, Boolean bool) {
                                                                                                    FooterRefreshView b16;
                                                                                                    RefreshView b17;
                                                                                                    boolean booleanValue = bool.booleanValue();
                                                                                                    aa<RefreshView> aaVar = NearbyFeedDetailPage.this.refreshFollowingViewRef;
                                                                                                    if (aaVar != null && (b17 = aaVar.b()) != null) {
                                                                                                        b17.p();
                                                                                                    }
                                                                                                    if (booleanValue) {
                                                                                                        aa<FooterRefreshView> aaVar2 = NearbyFeedDetailPage.this.getPageModel().followingFooterRefreshViewRef;
                                                                                                        if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                                                                                            b16.t(FooterRefreshEndState.SUCCESS);
                                                                                                        }
                                                                                                        NearbyFeedDetailPage nearbyFeedDetailPage26 = NearbyFeedDetailPage.this;
                                                                                                        if (!nearbyFeedDetailPage26.hasHeadRefreshDisplayed) {
                                                                                                            nearbyFeedDetailPage26.hasHeadRefreshDisplayed = true;
                                                                                                            IPagerIdKtxKt.getBridgeModule(blVar3).qToast("\u5df2\u52a0\u8f7d\u5168\u90e8\u5173\u6ce8\u5e16\u5b50", QToastMode.Success);
                                                                                                        }
                                                                                                    }
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }, 1, null);
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage18 = NearbyFeedDetailPage.this;
                                                                ConditionViewKt.c(aqVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.5
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                                                                        return Boolean.valueOf(!((Boolean) pageModel.isLoadingFollowingFeeds$delegate.getValue(pageModel, NearbyFDPageViewModel.$$delegatedProperties[6])).booleanValue() && NearbyFeedDetailPage.this.getPageModel().getFollowFeedsCardList().size() == 0);
                                                                    }
                                                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.6
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ConditionView conditionView2) {
                                                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.6.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar3) {
                                                                                v vVar4 = vVar3;
                                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.6.1.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.alignItemsCenter();
                                                                                        tVar2.flexDirectionRow();
                                                                                        tVar2.paddingTop(12.0f);
                                                                                        tVar2.paddingBottom(12.0f);
                                                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.6.1.2
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ImageView imageView) {
                                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.6.1.2.1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(af afVar) {
                                                                                                af afVar2 = afVar;
                                                                                                afVar2.marginLeft(16.0f);
                                                                                                afVar2.size(24.0f, 24.0f);
                                                                                                b.a.b(afVar2, QUIToken.INSTANCE.image(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, QUIToken.color$default("icon_secondary")), false, 2, null);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.6.1.3
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.6.1.3.1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                                ceVar2.fontWeight400();
                                                                                                ceVar2.text("\u8bd5\u8bd5\u5173\u6ce8\u4ee5\u4e0b\u7684\u4eba\uff0c\u83b7\u53d6\u66f4\u591a\u6709\u8da3\u5185\u5bb9");
                                                                                                ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                                                ceVar2.marginLeft(10.0f);
                                                                                                ceVar2.marginRight(10.0f);
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
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage19 = NearbyFeedDetailPage.this;
                                                                Function0<com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.7
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel> invoke() {
                                                                        return NearbyFeedDetailPage.this.getPageModel().getFollowFeedsCardList();
                                                                    }
                                                                };
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage20 = NearbyFeedDetailPage.this;
                                                                LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<NearbyFDPUserFeedsCardViewModel>, NearbyFDPUserFeedsCardViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.8
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Unit invoke(LoopDirectivesView<NearbyFDPUserFeedsCardViewModel> loopDirectivesView, NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel) {
                                                                        final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 = nearbyFDPUserFeedsCardViewModel;
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage21 = NearbyFeedDetailPage.this;
                                                                        NearbyUserFeedsCardViewKt.NearbyUserFeedsCard(loopDirectivesView, new Function1<NearbyUserFeedsCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.8.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(NearbyUserFeedsCardView nearbyUserFeedsCardView) {
                                                                                NearbyUserFeedsCardView nearbyUserFeedsCardView2 = nearbyUserFeedsCardView;
                                                                                final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel3 = NearbyFDPUserFeedsCardViewModel.this;
                                                                                final NearbyFeedDetailPage nearbyFeedDetailPage22 = nearbyFeedDetailPage21;
                                                                                nearbyUserFeedsCardView2.attr(new Function1<NearbyUserFeedsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.8.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(NearbyUserFeedsAttr nearbyUserFeedsAttr) {
                                                                                        NearbyUserFeedsAttr nearbyUserFeedsAttr2 = nearbyUserFeedsAttr;
                                                                                        nearbyUserFeedsAttr2.viewModel = NearbyFDPUserFeedsCardViewModel.this;
                                                                                        nearbyUserFeedsAttr2.dtReporter = nearbyFeedDetailPage22.getPageModel().dtReporter;
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                nearbyUserFeedsCardView2.event(new Function1<NearbyUserFeedsEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.8.1.2
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final /* bridge */ /* synthetic */ Unit invoke(NearbyUserFeedsEvent nearbyUserFeedsEvent) {
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage21 = NearbyFeedDetailPage.this;
                                                                Function0<com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel>> function03 = new Function0<com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.9
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final com.tencent.kuikly.core.reactive.collection.c<NearbyFDPUserFeedsCardViewModel> invoke() {
                                                                        return NearbyFeedDetailPage.this.getPageModel().getRecommList();
                                                                    }
                                                                };
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage22 = NearbyFeedDetailPage.this;
                                                                LoopDirectivesViewKt.b(aqVar2, function03, new Function4<LoopDirectivesView<NearbyFDPUserFeedsCardViewModel>, NearbyFDPUserFeedsCardViewModel, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.10
                                                                    {
                                                                        super(4);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function4
                                                                    public final Unit invoke(LoopDirectivesView<NearbyFDPUserFeedsCardViewModel> loopDirectivesView, NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel, Integer num, Integer num2) {
                                                                        final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 = nearbyFDPUserFeedsCardViewModel;
                                                                        final int intValue = num.intValue();
                                                                        num2.intValue();
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage23 = NearbyFeedDetailPage.this;
                                                                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.10.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar3) {
                                                                                v vVar4 = vVar3;
                                                                                if (intValue == 0 && (!nearbyFeedDetailPage23.getPageModel().getFollowFeedsCardList().isEmpty())) {
                                                                                    vVar4.addChild(new NearbyFDPTipSplitBarView(), new Function1<NearbyFDPTipSplitBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.10.1.1
                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(NearbyFDPTipSplitBarView nearbyFDPTipSplitBarView) {
                                                                                            nearbyFDPTipSplitBarView.attr(new Function1<NearbyFDPTipSplitBarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.10.1.1.1
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(NearbyFDPTipSplitBarViewAttr nearbyFDPTipSplitBarViewAttr) {
                                                                                                    NearbyFDPTipSplitBarViewAttr nearbyFDPTipSplitBarViewAttr2 = nearbyFDPTipSplitBarViewAttr;
                                                                                                    nearbyFDPTipSplitBarViewAttr2.text$delegate.setValue(nearbyFDPTipSplitBarViewAttr2, NearbyFDPTipSplitBarViewAttr.$$delegatedProperties[0], "\u5173\u6ce8\u5185\u5bb9\u5df2\u770b\u5b8c\uff0c\u770b\u770b\u4ee5\u4e0b\u63a8\u8350\u5185\u5bb9\u5427");
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                }
                                                                                final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel3 = nearbyFDPUserFeedsCardViewModel2;
                                                                                final NearbyFeedDetailPage nearbyFeedDetailPage24 = nearbyFeedDetailPage23;
                                                                                NearbyUserFeedsCardViewKt.NearbyUserFeedsCard(vVar4, new Function1<NearbyUserFeedsCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.10.1.2
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(NearbyUserFeedsCardView nearbyUserFeedsCardView) {
                                                                                        NearbyUserFeedsCardView nearbyUserFeedsCardView2 = nearbyUserFeedsCardView;
                                                                                        final NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel4 = NearbyFDPUserFeedsCardViewModel.this;
                                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage25 = nearbyFeedDetailPage24;
                                                                                        nearbyUserFeedsCardView2.attr(new Function1<NearbyUserFeedsAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.10.1.2.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(NearbyUserFeedsAttr nearbyUserFeedsAttr) {
                                                                                                NearbyUserFeedsAttr nearbyUserFeedsAttr2 = nearbyUserFeedsAttr;
                                                                                                nearbyUserFeedsAttr2.viewModel = NearbyFDPUserFeedsCardViewModel.this;
                                                                                                nearbyUserFeedsAttr2.dtReporter = nearbyFeedDetailPage25.getPageModel().dtReporter;
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        nearbyUserFeedsCardView2.event(new Function1<NearbyUserFeedsEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.10.1.2.2
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final /* bridge */ /* synthetic */ Unit invoke(NearbyUserFeedsEvent nearbyUserFeedsEvent) {
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
                                                                final NearbyFeedDetailPage nearbyFeedDetailPage23 = NearbyFeedDetailPage.this;
                                                                z.a(aqVar2, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(FooterRefreshView footerRefreshView) {
                                                                        FooterRefreshView footerRefreshView2 = footerRefreshView;
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage24 = NearbyFeedDetailPage.this;
                                                                        footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                                                                NearbyFeedDetailPage.this.getPageModel().followingFooterRefreshViewRef = aaVar;
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        footerRefreshView2.attr(new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(x xVar) {
                                                                                x xVar2 = xVar;
                                                                                xVar2.mo141height(150.0f);
                                                                                xVar2.k(1000.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage25 = NearbyFeedDetailPage.this;
                                                                        footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(y yVar) {
                                                                                y yVar2 = yVar;
                                                                                final NearbyFeedDetailPage nearbyFeedDetailPage26 = NearbyFeedDetailPage.this;
                                                                                yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        FooterRefreshView b16;
                                                                                        aa<FooterRefreshView> aaVar = NearbyFeedDetailPage.this.getPageModel().followingFooterRefreshViewRef;
                                                                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                                            b16.p();
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final NearbyFeedDetailPage nearbyFeedDetailPage27 = NearbyFeedDetailPage.this;
                                                                                yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.3.2

                                                                                    /* renamed from: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$body$1$2$3$4$3$6$1$11$3$2$WhenMappings */
                                                                                    /* loaded from: classes31.dex */
                                                                                    public /* synthetic */ class WhenMappings {
                                                                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                                                        static {
                                                                                            int[] iArr = new int[FooterRefreshState.values().length];
                                                                                            try {
                                                                                                iArr[FooterRefreshState.FAILURE.ordinal()] = 1;
                                                                                            } catch (NoSuchFieldError unused) {
                                                                                            }
                                                                                            try {
                                                                                                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 2;
                                                                                            } catch (NoSuchFieldError unused2) {
                                                                                            }
                                                                                            try {
                                                                                                iArr[FooterRefreshState.IDLE.ordinal()] = 3;
                                                                                            } catch (NoSuchFieldError unused3) {
                                                                                            }
                                                                                            try {
                                                                                                iArr[FooterRefreshState.REFRESHING.ordinal()] = 4;
                                                                                            } catch (NoSuchFieldError unused4) {
                                                                                            }
                                                                                            $EnumSwitchMapping$0 = iArr;
                                                                                        }
                                                                                    }

                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                                                        FooterRefreshState footerRefreshState2 = footerRefreshState;
                                                                                        NearbyFeedDetailPage nearbyFeedDetailPage28 = NearbyFeedDetailPage.this;
                                                                                        nearbyFeedDetailPage28.followingFootRefreshState$delegate.setValue(nearbyFeedDetailPage28, NearbyFeedDetailPage.$$delegatedProperties[7], footerRefreshState2);
                                                                                        int i3 = WhenMappings.$EnumSwitchMapping$0[footerRefreshState2.ordinal()];
                                                                                        if (i3 == 1) {
                                                                                            r5.footerRefreshText$delegate.setValue(NearbyFeedDetailPage.this, NearbyFeedDetailPage.$$delegatedProperties[0], "\u52a0\u8f7d\u5931\u8d25");
                                                                                        } else if (i3 == 2) {
                                                                                            r5.footerRefreshText$delegate.setValue(NearbyFeedDetailPage.this, NearbyFeedDetailPage.$$delegatedProperties[0], "\u5df2\u52a0\u8f7d\u5168\u90e8\u5173\u6ce8\u5e16\u5b50");
                                                                                        } else if (i3 == 3) {
                                                                                            r5.footerRefreshText$delegate.setValue(NearbyFeedDetailPage.this, NearbyFeedDetailPage.$$delegatedProperties[0], "\u5df2\u52a0\u8f7d\u5168\u90e8\u5173\u6ce8\u5e16\u5b50");
                                                                                        } else if (i3 == 4) {
                                                                                            NearbyFeedDetailPage.this.getPageModel().followingFootRefresh();
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage26 = NearbyFeedDetailPage.this;
                                                                        w.a(footerRefreshView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.4
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar3) {
                                                                                v vVar4 = vVar3;
                                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.4.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.mo141height(35.0f);
                                                                                        tVar2.allCenter();
                                                                                        tVar2.flexDirectionRow();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final NearbyFeedDetailPage nearbyFeedDetailPage27 = NearbyFeedDetailPage.this;
                                                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.4.2
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(TextView textView) {
                                                                                        final NearbyFeedDetailPage nearbyFeedDetailPage28 = NearbyFeedDetailPage.this;
                                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.2.3.4.3.6.1.11.4.2.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                NearbyFeedDetailPage nearbyFeedDetailPage29 = NearbyFeedDetailPage.this;
                                                                                                ceVar2.text((String) nearbyFeedDetailPage29.footerRefreshText$delegate.getValue(nearbyFeedDetailPage29, NearbyFeedDetailPage.$$delegatedProperties[0]));
                                                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                                                ceVar2.color(4289111718L);
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
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFeedDetailPage nearbyFeedDetailPage2 = NearbyFeedDetailPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                        return Boolean.valueOf(((Boolean) pageModel.showMoreActionSheet$delegate.getValue(pageModel, NearbyFDPageViewModel.$$delegatedProperties[4])).booleanValue());
                    }
                };
                final NearbyFeedDetailPage nearbyFeedDetailPage3 = NearbyFeedDetailPage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NearbyFeedDetailPage nearbyFeedDetailPage4 = NearbyFeedDetailPage.this;
                        NBPFeedActionSheetViewKt.NBPFeedActionSheet(conditionView, new Function1<NBPFeedActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedActionSheetView nBPFeedActionSheetView) {
                                NBPFeedActionSheetView nBPFeedActionSheetView2 = nBPFeedActionSheetView;
                                final NearbyFeedDetailPage nearbyFeedDetailPage5 = NearbyFeedDetailPage.this;
                                nBPFeedActionSheetView2.attr(new Function1<NBPFeedActionSheetViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:32:0x0090, code lost:
                                    
                                        if (((r2 == null || (r2 = r2.f418093e) == null || r2.f430610d != r3.getUserSelfInfo().tid) ? false : true) == false) goto L41;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(NBPFeedActionSheetViewAttr nBPFeedActionSheetViewAttr) {
                                        String str;
                                        String str2;
                                        String str3;
                                        List<String> list;
                                        e eVar;
                                        e eVar2;
                                        NBPFeedActionSheetViewAttr nBPFeedActionSheetViewAttr2 = nBPFeedActionSheetViewAttr;
                                        l lVar = NearbyFeedDetailPage.this.getPageModel().currentSelectFeed;
                                        if (lVar == null || (str = lVar.f418092d) == null) {
                                            str = "";
                                        }
                                        UserDataManager userDataManager = UserDataManager.INSTANCE;
                                        String valueOf = String.valueOf(userDataManager.getUserSelfInfo().tid);
                                        l lVar2 = NearbyFeedDetailPage.this.getPageModel().currentSelectFeed;
                                        if (lVar2 == null || (eVar2 = lVar2.f418093e) == null || (str2 = Long.valueOf(eVar2.f430610d).toString()) == null) {
                                            str2 = "";
                                        }
                                        l lVar3 = NearbyFeedDetailPage.this.getPageModel().currentSelectFeed;
                                        if (lVar3 == null || (eVar = lVar3.f418093e) == null || (str3 = Long.valueOf(eVar.f430610d).toString()) == null) {
                                            str3 = "";
                                        }
                                        l lVar4 = NearbyFeedDetailPage.this.getPageModel().currentSelectFeed;
                                        boolean z16 = true;
                                        if ((lVar4 == null || (list = lVar4.P) == null || list.isEmpty()) ? false : true) {
                                            l lVar5 = NearbyFeedDetailPage.this.getPageModel().currentSelectFeed;
                                        }
                                        z16 = false;
                                        nBPFeedActionSheetViewAttr2.params(2, str, valueOf, str2, str3, z16);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFeedDetailPage nearbyFeedDetailPage6 = NearbyFeedDetailPage.this;
                                nBPFeedActionSheetView2.event(new Function1<NBPFeedActionSheetViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPFeedActionSheetViewEvent nBPFeedActionSheetViewEvent) {
                                        final NearbyFeedDetailPage nearbyFeedDetailPage7 = NearbyFeedDetailPage.this;
                                        nBPFeedActionSheetViewEvent.closedActionSheet(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage.body.1.4.1.2.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NearbyFDPageViewModel pageModel = NearbyFeedDetailPage.this.getPageModel();
                                                pageModel.currentSelectFeed = null;
                                                pageModel.showMoreActionSheet$delegate.setValue(pageModel, NearbyFDPageViewModel.$$delegatedProperties[4], Boolean.FALSE);
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

    public final void checkIfNeedClose() {
        if (!Intrinsics.areEqual(this.openType, "3") || NearbyProUtilsKt.isInNBPMain()) {
            return;
        }
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.closePage$default();
    }

    public final void closePage(boolean z16) {
        if (this.didClosePage) {
            return;
        }
        this.didClosePage = true;
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        kLog.i("feed_detail_page", "click closeFeedDetailPage");
        com.tencent.kuikly.core.pager.b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
        NearbyFeedDetailPage nearbyFeedDetailPage = g16 instanceof NearbyFeedDetailPage ? (NearbyFeedDetailPage) g16 : null;
        if (nearbyFeedDetailPage != null) {
            CategoryListFooterKt$CategoryListFooter$1$1$$ExternalSyntheticOutline0.m("popPageWithAnimation ", z16, kLog, "feed_detail_page");
            if (z16) {
                ReadWriteProperty readWriteProperty = nearbyFeedDetailPage.popAnimation$delegate;
                KProperty<?>[] kPropertyArr = $$delegatedProperties;
                if (!((Boolean) readWriteProperty.getValue(nearbyFeedDetailPage, kPropertyArr[1])).booleanValue()) {
                    nearbyFeedDetailPage.popAnimation$delegate.setValue(nearbyFeedDetailPage, kPropertyArr[1], Boolean.TRUE);
                }
            } else {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
            }
        }
        hideMainMapForegroundUIIfNeed(false);
    }

    public final NearbyFDPageViewModel getPageModel() {
        return (NearbyFDPageViewModel) this.pageModel$delegate.getValue();
    }

    public final void hideMainMapForegroundUIIfNeed(boolean z16) {
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("hideMainMapForegroundUIIfNeed: hide=");
        sb5.append(z16);
        sb5.append(", fromMap=");
        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(sb5, this.fromMap, kLog, "feed_detail_page");
        if (this.fromMap) {
            k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar.w("nearbyData", z16);
            Unit unit = Unit.INSTANCE;
            k.d(kVar, "update_map_concise_action", eVar, false, 4, null);
        }
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            getPageModel().pageWillDestroy = true;
            closePage(true);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        hideMainMapForegroundUIIfNeed(true);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$pageDidAppear$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                if (com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode()) {
                    IPagerIdKtxKt.getBridgeModule(NearbyFeedDetailPage.this).setWhiteStatusBarStyle();
                } else {
                    IPagerIdKtxKt.getBridgeModule(NearbyFeedDetailPage.this).setBlackStatusBarStyle();
                }
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 0, function0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        NearbyFDPageViewModel pageModel = getPageModel();
        pageModel.getClass();
        com.tencent.kuikly.core.pager.b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.BasePager");
        k notifyModule = IPagerIdKtxKt.getNotifyModule((BasePager) g16);
        String str = pageModel.commentNotifyRef;
        if (str != null) {
            notifyModule.e("onNearbyProFeedCommentCountChange", str);
        }
        String str2 = pageModel.likeNotifyRef;
        if (str2 != null) {
            notifyModule.e("NearbyFeedLikeStatusChangedEvent", str2);
        }
        String str3 = pageModel.cameraPositionRspNotifyRef;
        if (str3 != null) {
            notifyModule.e("NEARBY_MAP_CAMERA_POSITION_RSP_EVENT", str3);
        }
        hideMainMapForegroundUIIfNeed(false);
        String str4 = this.tempAIOWillAppearNotifyRef;
        if (str4 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("QQNearbyProTempAIOWillAppear", str4);
        }
        String str5 = this.tempAIOWillDisappearNotifyRef;
        if (str5 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("QQNearbyProTempAIOWillDisappear", str5);
        }
        String str6 = this.mainPageCloseNotifyRef;
        if (str6 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("NEARBY_MAIN_PAGER_CLOSE_EVENT", str6);
        }
        String str7 = this.publishFeedFinishNotifyRef;
        if (str7 != null) {
            IPagerIdKtxKt.getNotifyModule(this).e("onPublishFeedFinish", str7);
        }
    }

    public final void setScrolling(boolean z16) {
        this.isScrolling$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z16));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        PageLoadTechReporter pageLoadTechReporter = this.pageLoadReporter;
        if (pageLoadTechReporter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLoadReporter");
            pageLoadTechReporter = null;
        }
        pageLoadTechReporter.report();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0066, code lost:
    
        if (r7 == null) goto L15;
     */
    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void created() {
        f fVar;
        int i3;
        int i16;
        l lVar;
        f mapThemeFromCache;
        boolean contains$default;
        String m3;
        List<f> list;
        Object obj;
        super.created();
        PageLoadTechReporter pageLoadTechReporter = new PageLoadTechReporter((String) null, 3);
        this.pageLoadReporter = pageLoadTechReporter;
        pageLoadTechReporter.reset();
        this.openType = getPageData().n().q(QCircleSchemeAttr.WebView.OPEN_TYPE, "0");
        String q16 = getPageData().n().q("theme_id", "");
        final NearbyFDPageViewModel pageModel = getPageModel();
        String str = this.openType;
        pageModel.themeId = q16;
        i cachedMapThemeList = NearbyProUtilsKt.getCachedMapThemeList();
        if (cachedMapThemeList != null && (list = cachedMapThemeList.f440858e) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((f) obj).f421849d, q16)) {
                        break;
                    }
                }
            }
            fVar = (f) obj;
        }
        fVar = new f(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null);
        pageModel.currentTheme = fVar;
        QQNearbyModule.Companion companion = QQNearbyModule.Companion;
        final Object[] sharePenetratePageData = companion.getInstance().getSharePenetratePageData();
        if (sharePenetratePageData == null) {
            KLog kLog = KLog.INSTANCE;
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            kLog.e("feed_detail_page", "NearbyFDPageViewModel error: pageDataArray == null || pageDataArray.size < 3");
        } else {
            pageModel.fromPerson = (p) NearbyFDPageViewModel.initFromData$decodeFromPageDataArray(sharePenetratePageData, 0, new NearbyFDPageViewModel$initFromData$1(new p(0L, null, null, null, null, 2047)));
            pageModel.fromStatusFeed = (l) NearbyFDPageViewModel.initFromData$decodeFromPageDataArray(sharePenetratePageData, 1, new NearbyFDPageViewModel$initFromData$2(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151)));
            pageModel.fromFeed = (a) NearbyFDPageViewModel.initFromData$decodeFromPageDataArray(sharePenetratePageData, 2, new NearbyFDPageViewModel$initFromData$3(new a(null, 0L, null, null, null, null, 0, 0, null, null, null, null, 0, null, null, null, 4194303)));
            pageModel.fromFeedPoi = (n25.k) NearbyFDPageViewModel.initFromData$decodeFromPageDataArray(sharePenetratePageData, 3, new NearbyFDPageViewModel$initFromData$4(new n25.k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)));
            TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$initFromData$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<v25.a>, java.util.ArrayList] */
                /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
                /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                    Object[] objArr = sharePenetratePageData;
                    nearbyFDPageViewModel.getClass();
                    if (objArr.length > 4) {
                        ArrayList arrayList = new ArrayList();
                        try {
                            int length = objArr.length;
                            for (int i17 = 4; i17 < length; i17++) {
                                NearbyFDPageViewModel$initExtraFeeds$1 nearbyFDPageViewModel$initExtraFeeds$1 = new NearbyFDPageViewModel$initExtraFeeds$1(new a(null, 0L, null, null, null, null, 0, 0, null, null, null, null, 0, null, null, null, 4194303));
                                Object obj2 = objArr[i17];
                                byte[] bArr = obj2 instanceof byte[] ? (byte[]) obj2 : null;
                                if (bArr == null) {
                                    bArr = new byte[0];
                                }
                                if (!(!(bArr.length == 0))) {
                                    bArr = null;
                                }
                                a aVar = (a) (bArr != null ? nearbyFDPageViewModel$initExtraFeeds$1.invoke(bArr) : null);
                                if (aVar != null) {
                                    KLog kLog2 = KLog.INSTANCE;
                                    NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                                    kLog2.d("feed_detail_page", "initHeadExtraFeedModels " + aVar.f440824d);
                                    arrayList.add(aVar);
                                }
                            }
                        } catch (Throwable th5) {
                            KLog kLog3 = KLog.INSTANCE;
                            NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("initHeadExtraFeedModels failed ", th5, kLog3, "feed_detail_page");
                        }
                        if (!arrayList.isEmpty()) {
                            nearbyFDPageViewModel.fromExtraFeeds = arrayList;
                        }
                        ?? r06 = nearbyFDPageViewModel.fromExtraFeeds;
                        if (r06 != 0) {
                            Iterator it5 = r06.iterator();
                            while (it5.hasNext()) {
                                a aVar2 = (a) it5.next();
                                nearbyFDPageViewModel.firstExtraFeedIds.add(aVar2.f440824d);
                                nearbyFDPageViewModel.localFeedsFromServe.add(new FeedCache(aVar2.f440824d, null, aVar2));
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, 1, null);
        }
        if (pageModel.fromPerson == null && pageModel.fromFeed == null && pageModel.fromStatusFeed == null) {
            i3 = 2;
        } else {
            i3 = 2;
            NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = new NearbyFDPUserFeedsCardViewModel(pageModel.fromPerson, pageModel.fromFeed, pageModel.fromStatusFeed, pageModel.getHostUser(), q16, false, false, new NearbyFDPageViewModel$pageOnCreate$firstCardModel$1(pageModel), 96);
            pageModel.firstCardModel = nearbyFDPUserFeedsCardViewModel;
            pageModel.getMainFeedsCardList().add(nearbyFDPUserFeedsCardViewModel);
        }
        if ((q16.length() > 0) && (mapThemeFromCache = NearbyProUtilsKt.getMapThemeFromCache(q16)) != null) {
            String str2 = mapThemeFromCache.f421850e;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) AccessibleTouchItem.MAP_DEFAULT_CONTENT_DESCRIPTION, false, i3, (Object) null);
            if (contains$default) {
                m3 = StringsKt__StringsJVMKt.replace$default(str2, AccessibleTouchItem.MAP_DEFAULT_CONTENT_DESCRIPTION, "\u5e7f\u573a", false, 4, (Object) null);
            } else {
                m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(str2, "\u5e7f\u573a");
            }
            pageModel.navTitle$delegate.setValue(pageModel, NearbyFDPageViewModel.$$delegatedProperties[5], m3);
        }
        TimerKt.d(500, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$pageOnCreate$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NearbyFDPageViewModel nearbyFDPageViewModel = NearbyFDPageViewModel.this;
                nearbyFDPageViewModel.getClass();
                com.tencent.kuikly.core.pager.b g16 = com.tencent.kuikly.core.manager.c.f117352a.g();
                Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.BasePager");
                k notifyModule = IPagerIdKtxKt.getNotifyModule((BasePager) g16);
                nearbyFDPageViewModel.commentNotifyRef = k.b(notifyModule, "onNearbyProFeedCommentCountChange", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$addNotifications$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        List listOf;
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                        NearbyFDPageViewModel nearbyFDPageViewModel2 = NearbyFDPageViewModel.this;
                        Intrinsics.checkNotNull(eVar2, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        nearbyFDPageViewModel2.getClass();
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                        kLog2.e("feed_detail_page", "received comment count notify with data: " + eVar2);
                        String p16 = eVar2.p("feedId");
                        if (p16 == null) {
                            p16 = "";
                        }
                        int k3 = eVar2.k("commentCount", 0);
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.kuikly.core.reactive.collection.c[]{nearbyFDPageViewModel2.getMainFeedsCardList(), nearbyFDPageViewModel2.getFollowFeedsCardList()});
                        Iterator it5 = listOf.iterator();
                        while (it5.hasNext()) {
                            Iterator it6 = ((com.tencent.kuikly.core.reactive.collection.c) it5.next()).iterator();
                            while (it6.hasNext()) {
                                NearbyFDPUserFeedTimelineItemViewModel contentModel = ((NearbyFDPUserFeedsCardViewModel) it6.next()).getContentModel();
                                if (contentModel != null && Intrinsics.areEqual(contentModel.getFid(), p16)) {
                                    KLog kLog3 = KLog.INSTANCE;
                                    NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                                    kLog3.e("feed_detail_page", "did update comment count " + k3);
                                    NearbyFDPStatusContentViewModel statusContentViewModel = contentModel.getStatusContentViewModel();
                                    if (statusContentViewModel != null) {
                                        statusContentViewModel.updateCommentCount(k3);
                                    }
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nearbyFDPageViewModel.likeNotifyRef = k.b(notifyModule, "NearbyFeedLikeStatusChangedEvent", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$addNotifications$1$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        List listOf;
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                        NearbyFDPageViewModel nearbyFDPageViewModel2 = NearbyFDPageViewModel.this;
                        Intrinsics.checkNotNull(eVar2, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        nearbyFDPageViewModel2.getClass();
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
                        kLog2.e("feed_detail_page", "received like status changed notify with data: " + eVar2);
                        String p16 = eVar2.p("feedId");
                        if (p16 == null) {
                            p16 = "";
                        }
                        int k3 = eVar2.k("count", 0);
                        int k16 = eVar2.k("isLike", 0);
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.kuikly.core.reactive.collection.c[]{nearbyFDPageViewModel2.getMainFeedsCardList(), nearbyFDPageViewModel2.getFollowFeedsCardList()});
                        Iterator it5 = listOf.iterator();
                        while (it5.hasNext()) {
                            Iterator it6 = ((com.tencent.kuikly.core.reactive.collection.c) it5.next()).iterator();
                            while (it6.hasNext()) {
                                NearbyFDPUserFeedTimelineItemViewModel contentModel = ((NearbyFDPUserFeedsCardViewModel) it6.next()).getContentModel();
                                if (contentModel != null && Intrinsics.areEqual(contentModel.getFid(), p16)) {
                                    KLog kLog3 = KLog.INSTANCE;
                                    NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("did update feedID:");
                                    sb5.append(p16);
                                    sb5.append(" isLike:");
                                    sb5.append(k16);
                                    sb5.append(" count:");
                                    DatalineDetailViewModel$$ExternalSyntheticOutline0.m(sb5, k3, kLog3, "feed_detail_page");
                                    boolean z16 = k16 == 1;
                                    NearbyFDPStatusContentViewModel statusContentViewModel = contentModel.getStatusContentViewModel();
                                    if (statusContentViewModel != null && statusContentViewModel.likeData.getIcon().isLiked != z16) {
                                        statusContentViewModel.likeData.updateLiked(z16);
                                        NBPLikeData nBPLikeData = statusContentViewModel.likeData;
                                        nBPLikeData.updateNumber(d.b(nBPLikeData.getIcon().isLiked) + statusContentViewModel.unSelfLikeCount);
                                    }
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nearbyFDPageViewModel.cameraPositionRspNotifyRef = k.b(notifyModule, "NEARBY_MAP_CAMERA_POSITION_RSP_EVENT", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$addNotifications$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                        if (eVar2 != null) {
                            NearbyFDPageViewModel nearbyFDPageViewModel2 = NearbyFDPageViewModel.this;
                            double i17 = eVar2.i(QCircleSchemeAttr.Polymerize.LAT, 0.0d);
                            double i18 = eVar2.i("lng", 0.0d);
                            if (!(i17 == 0.0d)) {
                                if (!(i18 == 0.0d)) {
                                    nearbyFDPageViewModel2.getClass();
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                k.b(notifyModule, "NEARBY_HOMEPAGE_FOLLOW_STATUS_CHANGED", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel$addNotifications$1$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                        if (eVar2 != null) {
                            NearbyFDPageViewModel.this.accountId = eVar2.p("accountId");
                            NearbyFDPageViewModel.this.doFollow = eVar2.f("doFollow");
                            NearbyFDPageViewModel.this.needToRemoveFollowingFeeds = !r3.doFollow;
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m(Utils.INSTANCE.notifyModule(""), "NEARBY_MAP_CAMERA_POSITION_REQ_EVENT", false, 4, null);
                return Unit.INSTANCE;
            }
        });
        if (Intrinsics.areEqual(str, "2") && (lVar = pageModel.fromStatusFeed) != null) {
            QQNearbyModule.openFeedShare$default(companion.getInstance(), 2, 1, lVar, null, false, null, 56);
        }
        checkIfNeedClose();
        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$created$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                final NearbyFeedDetailPage nearbyFeedDetailPage = NearbyFeedDetailPage.this;
                nearbyFeedDetailPage.hideMainMapForegroundUIIfNeed(true);
                nearbyFeedDetailPage.tempAIOWillAppearNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nearbyFeedDetailPage), "QQNearbyProTempAIOWillAppear", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$initAfterFirstScreenLoad$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).callNativeMethod("setNativeRootViewHidden", null);
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                        kLog2.i("feed_detail_page", "QQNearbyProTempAIOWillAppear did setNativeRootViewHidden");
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nearbyFeedDetailPage.tempAIOWillDisappearNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nearbyFeedDetailPage), "QQNearbyProTempAIOWillDisappear", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$initAfterFirstScreenLoad$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        ((QQKuiklyPlatformApi) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).callNativeMethod("setNativeRootViewVisible", null);
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                        kLog2.i("feed_detail_page", "QQNearbyProTempAIODidDisappear did setNativeRootViewVisible");
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nearbyFeedDetailPage.mainPageCloseNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nearbyFeedDetailPage), "NEARBY_MAIN_PAGER_CLOSE_EVENT", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$initAfterFirstScreenLoad$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        NearbyFeedDetailPage.this.checkIfNeedClose();
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                nearbyFeedDetailPage.publishFeedFinishNotifyRef = k.b(IPagerIdKtxKt.getNotifyModule(nearbyFeedDetailPage), "onPublishFeedFinish", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$addPublishFeedFinishNotify$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        final com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                        final NearbyFeedDetailPage nearbyFeedDetailPage2 = NearbyFeedDetailPage.this;
                        Function0<l> function02 = new Function0<l>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$addPublishFeedFinishNotify$1$insert$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final l invoke() {
                                aq<?, ?> b16;
                                String p16;
                                com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = com.tencent.kuikly.core.nvi.serialization.json.e.this;
                                l statusFeed = (eVar3 == null || (p16 = eVar3.p("statusFeed")) == null) ? null : NearbyProUtilsKt.toStatusFeed(p16);
                                if (statusFeed == null) {
                                    return null;
                                }
                                NearbyFeedDetailPage nearbyFeedDetailPage3 = nearbyFeedDetailPage2;
                                KLog kLog2 = KLog.INSTANCE;
                                NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("on feed publish finish with fid: ");
                                m16.append(statusFeed.f418092d);
                                kLog2.i("feed_detail_page", m16.toString());
                                NearbyFDPageViewModel pageModel2 = nearbyFeedDetailPage3.getPageModel();
                                pageModel2.getClass();
                                pageModel2.getMainFeedsCardList().add(0, new NearbyFDPUserFeedsCardViewModel(null, null, statusFeed, pageModel2.getHostUser(), pageModel2.themeId, false, false, new NearbyFDPageViewModel$insertFeedFromPublish$insertPublishCardModel$1(pageModel2), 96));
                                aa<aq<?, ?>> aaVar = nearbyFeedDetailPage3.pageListViewRef;
                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                    ScrollerView.setContentOffset$default(b16, 0.0f, 0.0f, true, null, 8, null);
                                }
                                return statusFeed;
                            }
                        };
                        if (NearbyFeedDetailPage.this.didClickPublishBtnFlag != 0) {
                            function02.invoke();
                        } else {
                            KLog kLog2 = KLog.INSTANCE;
                            NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                            kLog2.i("feed_detail_page", "received publish feed but not click publish btn");
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                k.b(IPagerIdKtxKt.getNotifyModule(nearbyFeedDetailPage), "NBPFeedDeleteEvent", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$addPublishFeedFinishNotify$2
                    {
                        super(1);
                    }

                    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.FeedCache>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        String str3;
                        List<NearbyFDPUserFeedsCardViewModel> list2;
                        List<FeedCache> list3;
                        String str4;
                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                        if (eVar2 == null || (str3 = eVar2.p("feedId")) == null) {
                            str3 = "";
                        }
                        NearbyFDPageViewModel pageModel2 = NearbyFeedDetailPage.this.getPageModel();
                        pageModel2.getClass();
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyConst nearbyConst3 = NearbyConst.INSTANCE;
                        kLog2.e("feed_detail_page", "onFeedDelete with feed id: " + str3);
                        list2 = CollectionsKt___CollectionsKt.toList(pageModel2.getMainFeedsCardList());
                        for (NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel2 : list2) {
                            NearbyFDPUserFeedTimelineItemViewModel contentModel = nearbyFDPUserFeedsCardViewModel2.getContentModel();
                            if (Intrinsics.areEqual(contentModel != null ? contentModel.getFid() : null, str3)) {
                                pageModel2.getMainFeedsCardList().remove(nearbyFDPUserFeedsCardViewModel2);
                                KLog kLog3 = KLog.INSTANCE;
                                NearbyConst nearbyConst4 = NearbyConst.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("did delete feed with feed id: ");
                                NearbyFDPUserFeedTimelineItemViewModel contentModel2 = nearbyFDPUserFeedsCardViewModel2.getContentModel();
                                if (contentModel2 == null || (str4 = contentModel2.getFid()) == null) {
                                    str4 = "";
                                }
                                m16.append(str4);
                                kLog3.e("feed_detail_page", m16.toString());
                            }
                        }
                        list3 = CollectionsKt___CollectionsKt.toList(pageModel2.localFeedsFromServe);
                        for (FeedCache feedCache : list3) {
                            if (Intrinsics.areEqual(feedCache.feedId, str3)) {
                                pageModel2.localFeedsFromServe.remove(feedCache);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                k.b(IPagerIdKtxKt.getNotifyModule(nearbyFeedDetailPage), "NBPNotifyPublishCloseEvent", false, new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$addPublishFeedFinishNotify$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                        final NearbyFeedDetailPage nearbyFeedDetailPage2 = NearbyFeedDetailPage.this;
                        final int i17 = nearbyFeedDetailPage2.didClickPublishBtnFlag;
                        if (i17 != 0) {
                            Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage$addPublishFeedFinishNotify$3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    int i18 = i17;
                                    NearbyFeedDetailPage nearbyFeedDetailPage3 = nearbyFeedDetailPage2;
                                    if (i18 == nearbyFeedDetailPage3.didClickPublishBtnFlag) {
                                        nearbyFeedDetailPage3.didClickPublishBtnFlag = 0;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                            TimerKt.e(nearbyFeedDetailPage2.getPagerId(), 1000, function02);
                        }
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 16, function0);
        if (Intrinsics.areEqual(this.openType, "1") || Intrinsics.areEqual(this.openType, "2") || Intrinsics.areEqual(this.openType, "3")) {
            i16 = 1;
            this.fromMap = true;
        } else {
            i16 = 1;
        }
        if (Intrinsics.areEqual(this.openType, "8")) {
            this.feedsPageIndex = i16;
        }
    }

    public static final void access$updateNavBgGradientPercentage(NearbyFeedDetailPage nearbyFeedDetailPage, float f16) {
        float f17 = f16 > 20.0f ? 1.0f : f16 < 0.0f ? 0.0f : f16 / 20.0f;
        ReadWriteProperty readWriteProperty = nearbyFeedDetailPage.navBgGradientPercentage$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        if (f17 == ((Number) readWriteProperty.getValue(nearbyFeedDetailPage, kPropertyArr[2])).floatValue()) {
            return;
        }
        nearbyFeedDetailPage.navBgGradientPercentage$delegate.setValue(nearbyFeedDetailPage, kPropertyArr[2], Float.valueOf(f17));
    }
}
