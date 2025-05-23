package com.tencent.hippykotlin.demo.pages.game_content_page;

import c01.c;
import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadErrorViewAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadErrorViewEvent;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerAttr;
import com.tencent.hippykotlin.demo.pages.game_content_page.banner.GCPSmallBannerView;
import com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshAttr;
import com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPRefreshView;
import com.tencent.hippykotlin.demo.pages.game_content_page.base.GCPTabLoadingView;
import com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar;
import com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarAttr;
import com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarEvent;
import com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItem;
import com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBanneAttr;
import com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPContentBannerView;
import com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarAttr;
import com.tencent.hippykotlin.demo.pages.game_content_page.game_goods.GameGoodsListBarView;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.Button;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameGoodsBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GoodsCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.NavigationBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeedBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.ext.ECGameTabExtKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardAttr;
import com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardEvent;
import com.tencent.hippykotlin.demo.pages.game_content_page.video_card.GCPVideoCardView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.RefreshView;
import com.tencent.kuikly.core.views.RefreshViewState;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ab;
import com.tencent.kuikly.core.views.ac;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.bl;
import com.tencent.kuikly.core.views.bm;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.x;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GameContentPageMainView extends ComposeView<GameContentPageMainViewAttr, GameContentPageMainViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "refreshState", "getRefreshState()Lcom/tencent/kuikly/core/views/RefreshViewState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "bigBannerBottomMargin", "getBigBannerBottomMargin()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "smallBannerOpacity", "getSmallBannerOpacity()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "smallBannerPlayIntervalTimeMs", "getSmallBannerPlayIntervalTimeMs()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, ScrollerAttr.BOUNCES_ENABLE, "getBouncesEnable()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "currentPageIndex", "getCurrentPageIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "bannerIndex", "getBannerIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "footerRefreshText", "getFooterRefreshText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "needPlayBannerVideo", "getNeedPlayBannerVideo()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "isBannerExpanding", "isBannerExpanding()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainView.class, "topTransitionPercentage", "getTopTransitionPercentage()F", 0)};
    public final ReadWriteProperty bouncesEnable$delegate;
    public final float categoryBarTopMargin;
    public aa<FooterRefreshView> footerRef;
    public final ReadWriteProperty footerRefreshText$delegate;
    public aa<aq<?, ?>> listRef;
    public final ReadWriteProperty needPlayBannerVideo$delegate;
    public float pullViewHeight;
    public boolean pullingStateFlag;
    public aa<RefreshView> refreshViewRef;
    public final ReadWriteProperty smallBannerOpacity$delegate;
    public final ReadWriteProperty smallBannerPlayIntervalTimeMs$delegate;
    public final ReadWriteProperty topTransitionPercentage$delegate;
    public boolean userScrolling;
    public final ReadWriteProperty refreshState$delegate = c.a(RefreshViewState.IDLE);
    public final ReadWriteProperty bigBannerBottomMargin$delegate = c.a(Float.valueOf(0.0f));

    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FooterRefreshState.values().length];
            try {
                iArr[FooterRefreshState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FooterRefreshState.REFRESHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GameContentPageMainView() {
        Float valueOf = Float.valueOf(1.0f);
        this.smallBannerOpacity$delegate = c.a(valueOf);
        this.smallBannerPlayIntervalTimeMs$delegate = c.a(0);
        this.bouncesEnable$delegate = c.a(Boolean.TRUE);
        c.a(0);
        c.a(0);
        this.footerRefreshText$delegate = c.a("\u4e0a\u62c9\u52a0\u8f7d\u66f4\u591a");
        Boolean bool = Boolean.FALSE;
        this.needPlayBannerVideo$delegate = c.a(bool);
        c.a(bool);
        this.topTransitionPercentage$delegate = c.a(valueOf);
        this.categoryBarTopMargin = com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().getStatusBarHeight() + 48.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$clickedCategoryBarItem(final GameContentPageMainView gameContentPageMainView, final int i3) {
        FooterRefreshView b16;
        aa<aq<?, ?>> aaVar = null;
        if (((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().tabIndex == i3) {
            aa<aq<?, ?>> aaVar2 = gameContentPageMainView.listRef;
            if (aaVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listRef");
            } else {
                aaVar = aaVar2;
            }
            aq<?, ?> b17 = aaVar.b();
            if (b17 != null) {
                ScrollerView.setContentOffset$default(b17, 0.0f, 0.0f, false, null, 8, null);
            }
            if (((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().getPageState() != PageState.REFRESHING) {
                ((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().refreshAllPage(new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$clickedCategoryBarItem$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Boolean bool, Boolean bool2) {
                        boolean booleanValue = bool.booleanValue();
                        bool2.booleanValue();
                        if (booleanValue && i3 == GameContentPageMainView.access$getAttr(gameContentPageMainView).getViewModel().tabIndex) {
                            aa<aq<?, ?>> aaVar3 = gameContentPageMainView.listRef;
                            if (aaVar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("listRef");
                                aaVar3 = null;
                            }
                            aq<?, ?> b18 = aaVar3.b();
                            if (b18 != null) {
                                ScrollerView.setContentOffset$default(b18, 0.0f, 0.0f, false, null, 8, null);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            gameContentPageMainView.emit("clickedCategoryBarItem", Integer.valueOf(i3));
            return;
        }
        gameContentPageMainView.emit("clickedCategoryBarItem", Integer.valueOf(i3));
        if (((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().getGameFeedList().size() == 0) {
            ((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().refreshAllPage(null);
        } else {
            com.tencent.kuikly.core.manager.c.f117352a.g().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$tabDidSwitch$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    GameContentPageMainView.access$scrollToLastPosition(GameContentPageMainView.this);
                    return Unit.INSTANCE;
                }
            });
        }
        aa<FooterRefreshView> aaVar3 = gameContentPageMainView.footerRef;
        if (aaVar3 != null && (b16 = aaVar3.b()) != null) {
            b16.t(FooterRefreshEndState.SUCCESS);
        }
        gameContentPageMainView.getPager().addNextTickTask(new GameContentPageMainView$reportSecondTabPageExp$1(gameContentPageMainView));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$footerStateChanged(final GameContentPageMainView gameContentPageMainView, FooterRefreshState footerRefreshState) {
        gameContentPageMainView.getClass();
        Utils.INSTANCE.logToNative("GameContentPageMainView footerStateChanged : " + footerRefreshState);
        ((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().getClass();
        int i3 = WhenMappings.$EnumSwitchMapping$0[footerRefreshState.ordinal()];
        if (i3 == 1) {
            gameContentPageMainView.setFooterRefreshText("\u4e0a\u62c9\u52a0\u8f7d\u66f4\u591a");
            return;
        }
        if (i3 == 2) {
            gameContentPageMainView.setFooterRefreshText("\u6b63\u5728\u52a0\u8f7d");
            GameContentPageMainViewModel viewModel = ((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel();
            viewModel.repo.requestNextPage(new GameContentPageMainViewModel$fetchNextPage$1(new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$footerStateChanged$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, Boolean bool2) {
                    FooterRefreshView b16;
                    FooterRefreshView b17;
                    FooterRefreshView b18;
                    boolean booleanValue = bool.booleanValue();
                    boolean booleanValue2 = bool2.booleanValue();
                    if (!booleanValue) {
                        aa<FooterRefreshView> aaVar = GameContentPageMainView.this.footerRef;
                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                            b16.t(FooterRefreshEndState.FAILURE);
                        }
                    } else if (booleanValue2) {
                        aa<FooterRefreshView> aaVar2 = GameContentPageMainView.this.footerRef;
                        if (aaVar2 != null && (b18 = aaVar2.b()) != null) {
                            b18.t(FooterRefreshEndState.NONE_MORE_DATA);
                        }
                    } else {
                        aa<FooterRefreshView> aaVar3 = GameContentPageMainView.this.footerRef;
                        if (aaVar3 != null && (b17 = aaVar3.b()) != null) {
                            b17.t(FooterRefreshEndState.SUCCESS);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, viewModel));
            return;
        }
        if (i3 == 3) {
            gameContentPageMainView.setFooterRefreshText("\u6ca1\u6709\u66f4\u591a\u4e86");
        } else {
            if (i3 != 4) {
                return;
            }
            gameContentPageMainView.setFooterRefreshText("\u7f51\u7edc\u4e0d\u7ed9\u529b,\u8bf7\u70b9\u51fb\u91cd\u8bd5");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GameContentPageMainViewAttr access$getAttr(GameContentPageMainView gameContentPageMainView) {
        return (GameContentPageMainViewAttr) gameContentPageMainView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GameContentPageMainViewEvent access$getEvent(GameContentPageMainView gameContentPageMainView) {
        return (GameContentPageMainViewEvent) gameContentPageMainView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleRefreshStateChange(GameContentPageMainView gameContentPageMainView, RefreshViewState refreshViewState) {
        gameContentPageMainView.refreshState$delegate.setValue(gameContentPageMainView, $$delegatedProperties[0], refreshViewState);
        if (refreshViewState == RefreshViewState.REFRESHING) {
            GameContentPageMainViewModel viewModel = ((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel();
            if (viewModel.getPageState() != PageState.REFRESHING) {
                viewModel.refreshAllPage(null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$scrollToLastPosition(GameContentPageMainView gameContentPageMainView) {
        aa<aq<?, ?>> aaVar = null;
        if (((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().getContentOffsetY() > 0.0f) {
            aa<aq<?, ?>> aaVar2 = gameContentPageMainView.listRef;
            if (aaVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listRef");
            } else {
                aaVar = aaVar2;
            }
            aq<?, ?> b16 = aaVar.b();
            if (b16 != null) {
                ScrollerView.setContentOffset$default(b16, 0.0f, ((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().getContentOffsetY(), false, null, 8, null);
                return;
            }
            return;
        }
        aa<aq<?, ?>> aaVar3 = gameContentPageMainView.listRef;
        if (aaVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listRef");
        } else {
            aaVar = aaVar3;
        }
        aq<?, ?> b17 = aaVar.b();
        if (b17 != null) {
            ScrollerView.setContentOffset$default(b17, 0.0f, 0.0f, false, null, 8, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$scrollViewDidScroll(GameContentPageMainView gameContentPageMainView, ScrollParams scrollParams) {
        gameContentPageMainView.getClass();
        float offsetY = scrollParams.getOffsetY();
        if (offsetY - (-gameContentPageMainView.pullViewHeight) < 1.0f) {
            gameContentPageMainView.pullingStateFlag = true;
            if (((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel().getGameFeedList().size() > 2) {
                gameContentPageMainView.bouncesEnable$delegate.setValue(gameContentPageMainView, $$delegatedProperties[4], Boolean.FALSE);
            }
            gameContentPageMainView.needPlayBannerVideo$delegate.setValue(gameContentPageMainView, $$delegatedProperties[8], Boolean.TRUE);
        }
        if (offsetY <= 0.0f) {
            float f16 = (offsetY / gameContentPageMainView.pullViewHeight) * 120.0f;
            ReadWriteProperty readWriteProperty = gameContentPageMainView.bigBannerBottomMargin$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            readWriteProperty.setValue(gameContentPageMainView, kPropertyArr[1], Float.valueOf(f16));
            gameContentPageMainView.smallBannerOpacity$delegate.setValue(gameContentPageMainView, kPropertyArr[2], Float.valueOf((offsetY / gameContentPageMainView.pullViewHeight) + 1));
        }
        if (offsetY >= 0.0f) {
            if (gameContentPageMainView.pullingStateFlag) {
                ReadWriteProperty readWriteProperty2 = gameContentPageMainView.bouncesEnable$delegate;
                KProperty<?>[] kPropertyArr2 = $$delegatedProperties;
                readWriteProperty2.setValue(gameContentPageMainView, kPropertyArr2[4], Boolean.TRUE);
                gameContentPageMainView.bigBannerBottomMargin$delegate.setValue(gameContentPageMainView, kPropertyArr2[1], Float.valueOf(0.0f));
                gameContentPageMainView.smallBannerOpacity$delegate.setValue(gameContentPageMainView, kPropertyArr2[2], Float.valueOf(1.0f));
                gameContentPageMainView.needPlayBannerVideo$delegate.setValue(gameContentPageMainView, kPropertyArr2[8], Boolean.FALSE);
            }
            gameContentPageMainView.pullingStateFlag = false;
        }
        GameContentPageMainViewModel viewModel = ((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getViewModel();
        if (viewModel != null) {
            viewModel.contentOffsetY$delegate.setValue(viewModel, GameContentPageMainViewModel.$$delegatedProperties[6], Float.valueOf(offsetY));
        }
        gameContentPageMainView.emit("scrollViewDidScroll", scrollParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$subViewExposeReportIfNeed(GameContentPageMainView gameContentPageMainView) {
        if (((GameContentPageMainViewAttr) gameContentPageMainView.getAttr()).getPageDidAppearTimes() == 1) {
            gameContentPageMainView.getPager().addNextTickTask(new GameContentPageMainView$reportSecondTabPageExp$1(gameContentPageMainView));
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.mo113backgroundColor(new h("qecommerce_skin_color_bg_backplate"));
                        return Unit.INSTANCE;
                    }
                });
                final GameContentPageMainView gameContentPageMainView = GameContentPageMainView.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        final GameContentPageMainView gameContentPageMainView2 = GameContentPageMainView.this;
                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                GameContentPageMainView.this.listRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final GameContentPageMainView gameContentPageMainView3 = GameContentPageMainView.this;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.m140flex(1.0f);
                                GameContentPageMainView gameContentPageMainView4 = GameContentPageMainView.this;
                                ScrollerAttr.bouncesEnable$default(aoVar2, ((Boolean) gameContentPageMainView4.bouncesEnable$delegate.getValue(gameContentPageMainView4, GameContentPageMainView.$$delegatedProperties[4])).booleanValue(), false, 2, null);
                                aoVar2.showScrollerIndicator(!GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().isTabPage);
                                aoVar2.marginTop(GameContentPageMainView.this.categoryBarTopMargin);
                                aoVar2.visibleAreaIgnoreBottomMargin((float) aoVar2.getPagerData().n().i("qqBottomBarHeight", 0.0d));
                                aoVar2.preloadViewDistance(GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getPageDidAppearTimes() > 0 ? aoVar2.getPagerData().l() * 1.8f : 1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GameContentPageMainView gameContentPageMainView4 = GameContentPageMainView.this;
                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ap apVar) {
                                final ap apVar2 = apVar;
                                final GameContentPageMainView gameContentPageMainView5 = GameContentPageMainView.this;
                                apVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        GameContentPageMainView.access$scrollViewDidScroll(GameContentPageMainView.this, scrollParams);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPageMainView gameContentPageMainView6 = GameContentPageMainView.this;
                                apVar2.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        GameContentPageMainView.this.userScrolling = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPageMainView gameContentPageMainView7 = GameContentPageMainView.this;
                                apVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        GameContentPageMainView.this.userScrolling = false;
                                        if (apVar2.getPager().getPageData().getIsIOS()) {
                                            GameContentPageMainViewModel viewModel = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel();
                                            KProperty<Object>[] kPropertyArr = GameContentPageMainViewModel.$$delegatedProperties;
                                            viewModel.playVideoInNextTickIfNeed(false);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GameContentPageMainView gameContentPageMainView5 = GameContentPageMainView.this;
                        bm.b(aqVar2, false, new Function1<RefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RefreshView refreshView) {
                                RefreshView refreshView2 = refreshView;
                                final GameContentPageMainView gameContentPageMainView6 = GameContentPageMainView.this;
                                refreshView2.ref(refreshView2, new Function1<aa<RefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<RefreshView> aaVar) {
                                        GameContentPageMainView.this.refreshViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPageMainView gameContentPageMainView7 = GameContentPageMainView.this;
                                refreshView2.event(new Function1<bl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(bl blVar) {
                                        final GameContentPageMainView gameContentPageMainView8 = GameContentPageMainView.this;
                                        blVar.j(new Function1<RefreshViewState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RefreshViewState refreshViewState) {
                                                GameContentPageMainView.access$handleRefreshStateChange(GameContentPageMainView.this, refreshViewState);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPageMainView gameContentPageMainView8 = GameContentPageMainView.this;
                                refreshView2.addChild(new GCPRefreshView(), new Function1<GCPRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPRefreshView gCPRefreshView) {
                                        final GameContentPageMainView gameContentPageMainView9 = GameContentPageMainView.this;
                                        gCPRefreshView.attr(new Function1<GCPRefreshAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GCPRefreshAttr gCPRefreshAttr) {
                                                GCPRefreshAttr gCPRefreshAttr2 = gCPRefreshAttr;
                                                GameContentPageMainView gameContentPageMainView10 = GameContentPageMainView.this;
                                                gCPRefreshAttr2.refreshViewState$delegate.setValue(gCPRefreshAttr2, GCPRefreshAttr.$$delegatedProperties[0], (RefreshViewState) gameContentPageMainView10.refreshState$delegate.getValue(gameContentPageMainView10, GameContentPageMainView.$$delegatedProperties[0]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }, 1, null);
                        final GameContentPageMainView gameContentPageMainView6 = GameContentPageMainView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getPageState();
                            }
                        };
                        final GameContentPageMainView gameContentPageMainView7 = GameContentPageMainView.this;
                        BindDirectivesViewKt.a(aqVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.6
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                RefreshView b16;
                                aa<RefreshView> aaVar;
                                RefreshView b17;
                                if (GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getPageState() == PageState.REFRESHING) {
                                    if ((GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameFeedList().size() != 0 || GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameGoodsBlock() != null || GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameCardBlock() != null) && (aaVar = GameContentPageMainView.this.refreshViewRef) != null && (b17 = aaVar.b()) != null) {
                                        RefreshView.l(b17, false, 1, null);
                                    }
                                } else {
                                    aa<RefreshView> aaVar2 = GameContentPageMainView.this.refreshViewRef;
                                    if (aaVar2 != null && (b16 = aaVar2.b()) != null) {
                                        b16.p();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GameContentPageMainView gameContentPageMainView8 = GameContentPageMainView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.7
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GameContentPageMainView.access$getAttr(GameContentPageMainView.this).bannerData;
                            }
                        };
                        final GameContentPageMainView gameContentPageMainView9 = GameContentPageMainView.this;
                        BindDirectivesViewKt.a(aqVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.8
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final GameContentPageMainView gameContentPageMainView10 = GameContentPageMainView.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.8.1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
                                    
                                        if ((!r0.isEmpty()) == true) goto L8;
                                     */
                                    @Override // kotlin.jvm.functions.Function0
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Object invoke() {
                                        boolean z16 = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).bannerData != null;
                                        return Boolean.valueOf(z16);
                                    }
                                };
                                final GameContentPageMainView gameContentPageMainView11 = GameContentPageMainView.this;
                                ConditionViewKt.c(bindDirectivesView, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.8.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final GameContentPageMainView gameContentPageMainView12 = GameContentPageMainView.this;
                                        conditionView.addChild(new GCPSmallBannerView(), new Function1<GCPSmallBannerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.8.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GCPSmallBannerView gCPSmallBannerView) {
                                                final GameContentPageMainView gameContentPageMainView13 = GameContentPageMainView.this;
                                                gCPSmallBannerView.attr(new Function1<GCPSmallBannerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.8.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(GCPSmallBannerAttr gCPSmallBannerAttr) {
                                                        GCPSmallBannerAttr gCPSmallBannerAttr2 = gCPSmallBannerAttr;
                                                        gCPSmallBannerAttr2.bannerData = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).bannerData;
                                                        gCPSmallBannerAttr2.marginBottom(8.0f);
                                                        gCPSmallBannerAttr2.marginTop(8.0f);
                                                        GameContentPageMainView gameContentPageMainView14 = GameContentPageMainView.this;
                                                        gCPSmallBannerAttr2.loopPlayIntervalTimeMs$delegate.setValue(gCPSmallBannerAttr2, GCPSmallBannerAttr.$$delegatedProperties[0], Integer.valueOf(((Number) gameContentPageMainView14.smallBannerPlayIntervalTimeMs$delegate.getValue(gameContentPageMainView14, GameContentPageMainView.$$delegatedProperties[3])).intValue()));
                                                        gCPSmallBannerAttr2.setKeepAlive(true);
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
                        final GameContentPageMainView gameContentPageMainView10 = GameContentPageMainView.this;
                        w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.9
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.9.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(1.0f);
                                        tVar2.marginTop(-1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPageMainView gameContentPageMainView11 = GameContentPageMainView.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.9.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.9.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                                tVar2.mo141height(10.0f);
                                                tVar2.mo113backgroundColor(h.INSTANCE.j());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameContentPageMainView gameContentPageMainView12 = GameContentPageMainView.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.9.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final GameContentPageMainView gameContentPageMainView13 = GameContentPageMainView.this;
                                                VisibilityEventKt.a(uVar, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.9.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Float f16) {
                                                        float floatValue = f16.floatValue();
                                                        GameContentPageMainView gameContentPageMainView14 = GameContentPageMainView.this;
                                                        gameContentPageMainView14.topTransitionPercentage$delegate.setValue(gameContentPageMainView14, GameContentPageMainView.$$delegatedProperties[10], Float.valueOf(floatValue));
                                                        Function1<? super Float, Unit> function1 = GameContentPageMainView.access$getEvent(GameContentPageMainView.this).topTransitionPercentageHandlerFn;
                                                        if (function1 != null) {
                                                            function1.invoke(Float.valueOf(floatValue));
                                                        }
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
                        final GameContentPageMainView gameContentPageMainView11 = GameContentPageMainView.this;
                        ac.b(aqVar2, new Function1<ab, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ab abVar) {
                                ab abVar2 = abVar;
                                abVar2.attr(new Function1<com.tencent.kuikly.core.views.aa, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.views.aa aaVar) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPageMainView gameContentPageMainView12 = GameContentPageMainView.this;
                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Integer.valueOf(GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getTabItems().size());
                                    }
                                };
                                final GameContentPageMainView gameContentPageMainView13 = GameContentPageMainView.this;
                                BindDirectivesViewKt.a(abVar2, function03, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        final GameContentPageMainView gameContentPageMainView14 = GameContentPageMainView.this;
                                        w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                final GameContentPageMainView gameContentPageMainView15 = GameContentPageMainView.this;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        GameContentPageMainView gameContentPageMainView16 = GameContentPageMainView.this;
                                                        ReadWriteProperty readWriteProperty = gameContentPageMainView16.topTransitionPercentage$delegate;
                                                        KProperty<?>[] kPropertyArr = GameContentPageMainView.$$delegatedProperties;
                                                        float floatValue = ((Number) readWriteProperty.getValue(gameContentPageMainView16, kPropertyArr[10])).floatValue() * 8.0f;
                                                        GameContentPageMainView gameContentPageMainView17 = GameContentPageMainView.this;
                                                        tVar2.borderRadius(floatValue, ((Number) gameContentPageMainView17.topTransitionPercentage$delegate.getValue(gameContentPageMainView17, kPropertyArr[10])).floatValue() * 8.0f, 0.0f, 0.0f);
                                                        tVar2.mo113backgroundColor(new h("qecommerce_skin_color_bg_default"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameContentPageMainView gameContentPageMainView16 = GameContentPageMainView.this;
                                                vVar2.addChild(new GameCategoryBar(), new Function1<GameCategoryBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(GameCategoryBar gameCategoryBar) {
                                                        GameCategoryBar gameCategoryBar2 = gameCategoryBar;
                                                        final GameContentPageMainView gameContentPageMainView17 = GameContentPageMainView.this;
                                                        gameCategoryBar2.attr(new Function1<GameCategoryBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(GameCategoryBarAttr gameCategoryBarAttr) {
                                                                GameCategoryBarAttr gameCategoryBarAttr2 = gameCategoryBarAttr;
                                                                com.tencent.kuikly.core.reactive.collection.c<GameTab> tabItems = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getTabItems();
                                                                gameCategoryBarAttr2.getItems().clear();
                                                                Iterator<GameTab> it = tabItems.iterator();
                                                                while (it.hasNext()) {
                                                                    GameTab next = it.next();
                                                                    GameCategoryBarItem gameCategoryBarItem = new GameCategoryBarItem();
                                                                    String str = next.name;
                                                                    ReadWriteProperty readWriteProperty = gameCategoryBarItem.itemText$delegate;
                                                                    KProperty<?>[] kPropertyArr = GameCategoryBarItem.$$delegatedProperties;
                                                                    readWriteProperty.setValue(gameCategoryBarItem, kPropertyArr[0], str);
                                                                    gameCategoryBarItem.setSelected(false);
                                                                    gameCategoryBarItem.showRedPoint$delegate.setValue(gameCategoryBarItem, kPropertyArr[2], Boolean.valueOf(ECGameTabExtKt.getShowRedPointEnable(next)));
                                                                    gameCategoryBarAttr2.getItems().add(gameCategoryBarItem);
                                                                }
                                                                int i3 = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().tabIndex;
                                                                if (i3 < gameCategoryBarAttr2.getItems().size()) {
                                                                    com.tencent.kuikly.core.reactive.collection.c<GameCategoryBarItem> items = gameCategoryBarAttr2.getItems();
                                                                    ReadWriteProperty readWriteProperty2 = gameCategoryBarAttr2.currentIndex$delegate;
                                                                    KProperty<?>[] kPropertyArr2 = GameCategoryBarAttr.$$delegatedProperties;
                                                                    items.get(((Number) readWriteProperty2.getValue(gameCategoryBarAttr2, kPropertyArr2[0])).intValue()).setSelected(false);
                                                                    gameCategoryBarAttr2.getItems().get(i3).setSelected(true);
                                                                    gameCategoryBarAttr2.currentIndex$delegate.setValue(gameCategoryBarAttr2, kPropertyArr2[0], Integer.valueOf(i3));
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GameContentPageMainView gameContentPageMainView18 = GameContentPageMainView.this;
                                                        gameCategoryBar2.event(new Function1<GameCategoryBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.3.1.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(GameCategoryBarEvent gameCategoryBarEvent) {
                                                                GameCategoryBarEvent gameCategoryBarEvent2 = gameCategoryBarEvent;
                                                                final GameContentPageMainView gameContentPageMainView19 = GameContentPageMainView.this;
                                                                gameCategoryBarEvent2.registerEvent("onClickCategoryItem", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.3.1.2.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        GameContentPageMainView gameContentPageMainView20 = GameContentPageMainView.this;
                                                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                                                        GameContentPageMainView.access$clickedCategoryBarItem(gameContentPageMainView20, ((Integer) obj).intValue());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final GameContentPageMainView gameContentPageMainView20 = GameContentPageMainView.this;
                                                                gameCategoryBarEvent2.didShowSelectItemHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.10.3.1.2.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj) {
                                                                        Function1<Object, Unit> function1 = GameContentPageMainView.access$getEvent(GameContentPageMainView.this).didShowSelectItemHandlerFn;
                                                                        if (function1 != null) {
                                                                            function1.invoke(obj);
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
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GameContentPageMainView gameContentPageMainView12 = GameContentPageMainView.this;
                        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.11
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                GameContentPageMainViewModel viewModel = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel();
                                return Boolean.valueOf((((NavigationBlock) viewModel.navigationBlock$delegate.getValue(viewModel, GameContentPageMainViewModel.$$delegatedProperties[2])) == null && GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameCardBlock() == null) ? false : true);
                            }
                        };
                        final GameContentPageMainView gameContentPageMainView13 = GameContentPageMainView.this;
                        ConditionViewKt.c(aqVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.12
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final GameContentPageMainView gameContentPageMainView14 = GameContentPageMainView.this;
                                conditionView.addChild(new GCPContentBannerView(), new Function1<GCPContentBannerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.12.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPContentBannerView gCPContentBannerView) {
                                        final GameContentPageMainView gameContentPageMainView15 = GameContentPageMainView.this;
                                        gCPContentBannerView.attr(new Function1<GCPContentBanneAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.12.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GCPContentBanneAttr gCPContentBanneAttr) {
                                                GCPContentBanneAttr gCPContentBanneAttr2 = gCPContentBanneAttr;
                                                GameContentPageMainViewModel viewModel = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel();
                                                NavigationBlock navigationBlock = (NavigationBlock) viewModel.navigationBlock$delegate.getValue(viewModel, GameContentPageMainViewModel.$$delegatedProperties[2]);
                                                ReadWriteProperty readWriteProperty = gCPContentBanneAttr2.entranceData$delegate;
                                                KProperty<?>[] kPropertyArr = GCPContentBanneAttr.$$delegatedProperties;
                                                readWriteProperty.setValue(gCPContentBanneAttr2, kPropertyArr[0], navigationBlock);
                                                gCPContentBanneAttr2.gameActivityData$delegate.setValue(gCPContentBanneAttr2, kPropertyArr[1], GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameCardBlock());
                                                gCPContentBanneAttr2.gameTab = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().tab;
                                                gCPContentBanneAttr2.setKeepAlive(true);
                                                gCPContentBanneAttr2.pageDidAppearTimes$delegate.setValue(gCPContentBanneAttr2, kPropertyArr[2], Integer.valueOf(GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getPageDidAppearTimes()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GameContentPageMainView gameContentPageMainView14 = GameContentPageMainView.this;
                        Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.13
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameGoodsBlock();
                            }
                        };
                        final GameContentPageMainView gameContentPageMainView15 = GameContentPageMainView.this;
                        BindDirectivesViewKt.a(aqVar2, function04, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.14
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
                            
                                if ((!r2.isEmpty()) == true) goto L10;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                final GameGoodsBlock gameGoodsBlock = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameGoodsBlock();
                                if (gameGoodsBlock != null) {
                                    final GameContentPageMainView gameContentPageMainView16 = GameContentPageMainView.this;
                                    boolean z16 = gameGoodsBlock.goodsCards != null;
                                    if (z16) {
                                        bindDirectivesView2.addChild(new GameGoodsListBarView(), new Function1<GameGoodsListBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$body$1$2$14$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GameGoodsListBarView gameGoodsListBarView) {
                                                final GameGoodsBlock gameGoodsBlock2 = GameGoodsBlock.this;
                                                final GameContentPageMainView gameContentPageMainView17 = gameContentPageMainView16;
                                                gameGoodsListBarView.attr(new Function1<GameGoodsListBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$body$1$2$14$1$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(GameGoodsListBarAttr gameGoodsListBarAttr) {
                                                        String str;
                                                        GameGoodsListBarAttr gameGoodsListBarAttr2 = gameGoodsListBarAttr;
                                                        String str2 = GameGoodsBlock.this.title;
                                                        ReadWriteProperty readWriteProperty = gameGoodsListBarAttr2.leftTitle$delegate;
                                                        KProperty<?>[] kPropertyArr = GameGoodsListBarAttr.$$delegatedProperties;
                                                        readWriteProperty.setValue(gameGoodsListBarAttr2, kPropertyArr[0], str2);
                                                        Button button = GameGoodsBlock.this.buttonMore;
                                                        if (button == null || (str = button.title) == null) {
                                                            str = "\u66f4\u591a";
                                                        }
                                                        gameGoodsListBarAttr2.rightTitle$delegate.setValue(gameGoodsListBarAttr2, kPropertyArr[1], str);
                                                        Iterator<T> it = GameGoodsBlock.this.goodsCards.iterator();
                                                        while (it.hasNext()) {
                                                            gameGoodsListBarAttr2.getGameGoodsItems().add((GoodsCard) it.next());
                                                        }
                                                        gameGoodsListBarAttr2.buttonMore$delegate.setValue(gameGoodsListBarAttr2, GameGoodsListBarAttr.$$delegatedProperties[3], GameGoodsBlock.this.buttonMore);
                                                        gameGoodsListBarAttr2.gameTab = GameContentPageMainView.access$getAttr(gameContentPageMainView17).getViewModel().tab;
                                                        gameGoodsListBarAttr2.setKeepAlive(true);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GameContentPageMainView gameContentPageMainView16 = GameContentPageMainView.this;
                        Function0<com.tencent.kuikly.core.reactive.collection.c<GameFeedModel>> function05 = new Function0<com.tencent.kuikly.core.reactive.collection.c<GameFeedModel>>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.15
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.reactive.collection.c<GameFeedModel> invoke() {
                                return GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameFeedList();
                            }
                        };
                        final GameContentPageMainView gameContentPageMainView17 = GameContentPageMainView.this;
                        LoopDirectivesViewKt.a(aqVar2, function05, new Function2<LoopDirectivesView<GameFeedModel>, GameFeedModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<GameFeedModel> loopDirectivesView, GameFeedModel gameFeedModel) {
                                final GameFeedModel gameFeedModel2 = gameFeedModel;
                                final int indexOf = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameFeedList().indexOf(gameFeedModel2);
                                final GameContentPageMainView gameContentPageMainView18 = GameContentPageMainView.this;
                                loopDirectivesView.addChild(new GCPVideoCardView(), new Function1<GCPVideoCardView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GCPVideoCardView gCPVideoCardView) {
                                        GCPVideoCardView gCPVideoCardView2 = gCPVideoCardView;
                                        final GameFeedModel gameFeedModel3 = GameFeedModel.this;
                                        final GameContentPageMainView gameContentPageMainView19 = gameContentPageMainView18;
                                        final int i3 = indexOf;
                                        gCPVideoCardView2.attr(new Function1<GCPVideoCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GCPVideoCardAttr gCPVideoCardAttr) {
                                                GCPVideoCardAttr gCPVideoCardAttr2 = gCPVideoCardAttr;
                                                gCPVideoCardAttr2.gameFeedModel = GameFeedModel.this;
                                                gCPVideoCardAttr2.mo113backgroundColor(new h("qecommerce_skin_color_bg_default"));
                                                gCPVideoCardAttr2.playControl$delegate.setValue(gCPVideoCardAttr2, GCPVideoCardAttr.$$delegatedProperties[0], GameFeedModel.this.getPlayControl());
                                                gCPVideoCardAttr2.gameTab = GameContentPageMainView.access$getAttr(gameContentPageMainView19).getViewModel().tab;
                                                gCPVideoCardAttr2.feedIndex = i3;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameFeedModel gameFeedModel4 = GameFeedModel.this;
                                        final GameContentPageMainView gameContentPageMainView20 = gameContentPageMainView18;
                                        final int i16 = indexOf;
                                        gCPVideoCardView2.event(new Function1<GCPVideoCardEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GCPVideoCardEvent gCPVideoCardEvent) {
                                                final GCPVideoCardEvent gCPVideoCardEvent2 = gCPVideoCardEvent;
                                                final GameFeedModel gameFeedModel5 = GameFeedModel.this;
                                                final GameContentPageMainView gameContentPageMainView21 = gameContentPageMainView20;
                                                gCPVideoCardEvent2.videoAppearPercentageHandlerFn = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Float f16) {
                                                        float floatValue = f16.floatValue();
                                                        GameFeedModel gameFeedModel6 = GameFeedModel.this;
                                                        gameFeedModel6.videoAppearPercentage = floatValue;
                                                        if (floatValue == 0.0f) {
                                                            QVideoPlayControl playControl = gameFeedModel6.getPlayControl();
                                                            QVideoPlayControl qVideoPlayControl = QVideoPlayControl.PAUSE;
                                                            if (playControl != qVideoPlayControl) {
                                                                GameFeedModel.this.setPlayControl(qVideoPlayControl);
                                                            }
                                                        } else if (!gCPVideoCardEvent2.getPager().getPageData().getIsIOS() || !gameContentPageMainView21.userScrolling) {
                                                            GameContentPageMainViewModel viewModel = GameContentPageMainView.access$getAttr(gameContentPageMainView21).getViewModel();
                                                            KProperty<Object>[] kPropertyArr = GameContentPageMainViewModel.$$delegatedProperties;
                                                            viewModel.playVideoInNextTickIfNeed(false);
                                                        }
                                                        if (floatValue > 0.01d) {
                                                            GameContentPageMainViewModel viewModel2 = GameContentPageMainView.access$getAttr(gameContentPageMainView21).getViewModel();
                                                            final GameFeedModel gameFeedModel7 = GameFeedModel.this;
                                                            viewModel2.getClass();
                                                            com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                            b g16 = cVar.g();
                                                            if ((g16 instanceof GameContentPage) && !((GameContentPage) g16).pageDidDisAppear && !gameFeedModel7.hasDCReported) {
                                                                gameFeedModel7.hasDCReported = true;
                                                                cVar.g().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainViewModel$videoExposeDCReportInNextTickIfNeed$1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        String str;
                                                                        GameFeedModel gameFeedModel8 = GameFeedModel.this;
                                                                        e eVar = new e();
                                                                        if (Intrinsics.areEqual(com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).getPageData().n().p("source_from"), "1")) {
                                                                            str = "97";
                                                                        } else {
                                                                            str = QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_VALUE;
                                                                        }
                                                                        eVar.v("page_id", str);
                                                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                                        String str2 = gameFeedModel8.gameFeed.feedPbToken;
                                                                        currentBridgeModule.getClass();
                                                                        e eVar2 = new e();
                                                                        eVar2.v("qCircleDCReportParam", eVar);
                                                                        eVar2.v("feedPbToken", str2);
                                                                        eVar2.t("qCircleDCReportActionType", 1);
                                                                        eVar2.t("qCircleDCReportSubActionType", 1);
                                                                        currentBridgeModule.callNativeMethod("qCircleDCReport", eVar2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final GameFeedModel gameFeedModel6 = GameFeedModel.this;
                                                final GameContentPageMainView gameContentPageMainView22 = gameContentPageMainView20;
                                                gCPVideoCardEvent2.onClickVideoHandlerFn = new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Long l3) {
                                                        GameFeedBlock gameFeedBlock;
                                                        GameFeedBlock gameFeedBlock2;
                                                        long longValue = l3.longValue();
                                                        GameFeedModel.this.videoAppearPercentage = 1.1f;
                                                        GameContentPageMainView.access$getAttr(gameContentPageMainView22).getViewModel().playVideoForFeedModel(GameFeedModel.this);
                                                        GetFeedRsp getFeedRsp = GameContentPageMainView.access$getAttr(gameContentPageMainView22).data;
                                                        int i17 = 0;
                                                        int i18 = (getFeedRsp == null || (gameFeedBlock2 = getFeedRsp.gameFeedBlock) == null) ? 0 : gameFeedBlock2.source;
                                                        GetFeedRsp getFeedRsp2 = GameContentPageMainView.access$getAttr(gameContentPageMainView22).data;
                                                        if (getFeedRsp2 != null && (gameFeedBlock = getFeedRsp2.gameFeedBlock) != null) {
                                                            i17 = gameFeedBlock.subSource;
                                                        }
                                                        BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(gCPVideoCardEvent2);
                                                        int i19 = BridgeModule.$r8$clinit;
                                                        bridgeModule.getClass();
                                                        e eVar = new e();
                                                        eVar.u("videoTag", longValue);
                                                        eVar.t("sourceType", i18);
                                                        eVar.t("subSourceType", i17);
                                                        eVar.v("pageName", "");
                                                        bridgeModule.callNativeMethod("openQQCirLayerPage", eVar, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final GameFeedModel gameFeedModel7 = GameFeedModel.this;
                                                final GameContentPageMainView gameContentPageMainView23 = gameContentPageMainView20;
                                                gCPVideoCardEvent2.onClickPlayVideoIconHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.2.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        if (GameFeedModel.this.getPlayControl() == QVideoPlayControl.PLAY) {
                                                            GameFeedModel.this.setPlayControl(QVideoPlayControl.USER_PAUSE);
                                                        }
                                                        GameContentPageMainView.access$getAttr(gameContentPageMainView23).getViewModel().playVideoForFeedModel(GameFeedModel.this);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final GameFeedModel gameFeedModel8 = GameFeedModel.this;
                                                gCPVideoCardEvent2.onClickPauseVideoIconHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.2.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        GameFeedModel.this.setPlayControl(QVideoPlayControl.USER_PAUSE);
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                final GameFeedModel gameFeedModel9 = GameFeedModel.this;
                                                FrameEventKt.d(gCPVideoCardEvent2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.2.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(d dVar) {
                                                        GameFeedModel gameFeedModel10 = GameFeedModel.this;
                                                        gameFeedModel10.feedCardHeight$delegate.setValue(gameFeedModel10, GameFeedModel.$$delegatedProperties[1], Float.valueOf(dVar.getHeight()));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameContentPageMainView gameContentPageMainView24 = gameContentPageMainView20;
                                                final GameFeedModel gameFeedModel10 = GameFeedModel.this;
                                                final int i17 = i16;
                                                VisibilityEventKt.b(gCPVideoCardEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.2.6
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        GameContentPageMainViewModel viewModel = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel();
                                                        final GameFeedModel gameFeedModel11 = gameFeedModel10;
                                                        final int i18 = i17;
                                                        viewModel.getClass();
                                                        com.tencent.kuikly.core.manager.c.f117352a.g().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainViewModel$videoCardViewDidAppear$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                Utils.INSTANCE.currentBridgeModule().qCircleDTReport(GameFeedModel.this.gameFeed.feedPbToken, "dt_imp", new e().v("eid", QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT).t("index", i18));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameContentPageMainView gameContentPageMainView25 = gameContentPageMainView20;
                                                final GameFeedModel gameFeedModel11 = GameFeedModel.this;
                                                final int i18 = i16;
                                                VisibilityEventKt.c(gCPVideoCardEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.16.1.2.7
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        GameContentPageMainViewModel viewModel = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel();
                                                        final GameFeedModel gameFeedModel12 = gameFeedModel11;
                                                        final int i19 = i18;
                                                        viewModel.getClass();
                                                        com.tencent.kuikly.core.manager.c.f117352a.g().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainViewModel$videoCardViewDidDisappear$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                Utils.INSTANCE.currentBridgeModule().qCircleDTReport(GameFeedModel.this.gameFeed.feedPbToken, "dt_imp_end", new e().v("eid", QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT).t("index", i19));
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
                        final GameContentPageMainView gameContentPageMainView18 = GameContentPageMainView.this;
                        Function0<Object> function06 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.17
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameFeedList().size() > 0);
                            }
                        };
                        final GameContentPageMainView gameContentPageMainView19 = GameContentPageMainView.this;
                        ConditionViewKt.c(aqVar2, function06, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final GameContentPageMainView gameContentPageMainView20 = GameContentPageMainView.this;
                                Function0<Object> function07 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel();
                                    }
                                };
                                final GameContentPageMainView gameContentPageMainView21 = GameContentPageMainView.this;
                                BindDirectivesViewKt.a(conditionView, function07, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        final GameContentPageMainView gameContentPageMainView22 = GameContentPageMainView.this;
                                        z.a(bindDirectivesView, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(FooterRefreshView footerRefreshView) {
                                                FooterRefreshView footerRefreshView2 = footerRefreshView;
                                                final GameContentPageMainView gameContentPageMainView23 = GameContentPageMainView.this;
                                                footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                                        GameContentPageMainView.this.footerRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameContentPageMainView gameContentPageMainView24 = GameContentPageMainView.this;
                                                footerRefreshView2.attr(new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(x xVar) {
                                                        float f16;
                                                        x xVar2 = xVar;
                                                        xVar2.alignItemsCenter();
                                                        if (GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().isTabPage) {
                                                            f16 = (xVar2.getPagerData().getIsIphoneX() ? 34.0f : 0.0f) + 134.0f;
                                                        } else {
                                                            f16 = 44.0f;
                                                        }
                                                        xVar2.mo141height(f16);
                                                        xVar2.k(xVar2.getPagerData().l());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameContentPageMainView gameContentPageMainView25 = GameContentPageMainView.this;
                                                w.a(footerRefreshView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        v vVar2 = vVar;
                                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.marginTop(10.0f);
                                                                tVar2.flexDirectionRow();
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GameContentPageMainView gameContentPageMainView26 = GameContentPageMainView.this;
                                                        Function0<Object> function08 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.2
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                GameContentPageMainView gameContentPageMainView27 = GameContentPageMainView.this;
                                                                return Boolean.valueOf(Intrinsics.areEqual((String) gameContentPageMainView27.footerRefreshText$delegate.getValue(gameContentPageMainView27, GameContentPageMainView.$$delegatedProperties[7]), "\u6b63\u5728\u52a0\u8f7d"));
                                                            }
                                                        };
                                                        final GameContentPageMainView gameContentPageMainView27 = GameContentPageMainView.this;
                                                        ConditionViewKt.c(vVar2, function08, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView2) {
                                                                final GameContentPageMainView gameContentPageMainView28 = GameContentPageMainView.this;
                                                                Function0<Object> function09 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.3.1
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        return Boolean.valueOf(GameContentPageMainView.this.getPager().isNightMode());
                                                                    }
                                                                };
                                                                final GameContentPageMainView gameContentPageMainView29 = GameContentPageMainView.this;
                                                                BindDirectivesViewKt.a(conditionView2, function09, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(BindDirectivesView bindDirectivesView2) {
                                                                        final GameContentPageMainView gameContentPageMainView30 = GameContentPageMainView.this;
                                                                        i.a(bindDirectivesView2, new Function1<com.tencent.kuikly.core.views.h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.3.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(com.tencent.kuikly.core.views.h hVar) {
                                                                                final GameContentPageMainView gameContentPageMainView31 = GameContentPageMainView.this;
                                                                                hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.3.2.1.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(f fVar) {
                                                                                        f fVar2 = fVar;
                                                                                        fVar2.h(!GameContentPageMainView.this.getPager().isNightMode());
                                                                                        fVar2.size(20.0f, 20.0f);
                                                                                        fVar2.transform(new com.tencent.kuikly.core.base.u(0.8f, 0.8f));
                                                                                        fVar2.marginRight(2.0f);
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
                                                        final GameContentPageMainView gameContentPageMainView28 = GameContentPageMainView.this;
                                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final GameContentPageMainView gameContentPageMainView29 = GameContentPageMainView.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.3.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2.fontWeight400(), 15.0f, null, 2, null);
                                                                        ceVar2.color(new h(4288256409L));
                                                                        GameContentPageMainView gameContentPageMainView30 = GameContentPageMainView.this;
                                                                        ceVar2.value((String) gameContentPageMainView30.footerRefreshText$delegate.getValue(gameContentPageMainView30, GameContentPageMainView.$$delegatedProperties[7]));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameContentPageMainView gameContentPageMainView26 = GameContentPageMainView.this;
                                                footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(y yVar) {
                                                        y yVar2 = yVar;
                                                        final GameContentPageMainView gameContentPageMainView27 = GameContentPageMainView.this;
                                                        yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                                GameContentPageMainView.access$footerStateChanged(GameContentPageMainView.this, footerRefreshState);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final GameContentPageMainView gameContentPageMainView28 = GameContentPageMainView.this;
                                                        yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.18.2.1.4.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                aa<FooterRefreshView> aaVar;
                                                                FooterRefreshView b16;
                                                                FooterRefreshView b17;
                                                                aa<FooterRefreshView> aaVar2 = GameContentPageMainView.this.footerRef;
                                                                if (((aaVar2 == null || (b17 = aaVar2.b()) == null) ? null : b17.getRefreshState()) == FooterRefreshState.FAILURE && (aaVar = GameContentPageMainView.this.footerRef) != null && (b16 = aaVar.b()) != null) {
                                                                    b16.p();
                                                                }
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
                        final GameContentPageMainView gameContentPageMainView20 = GameContentPageMainView.this;
                        Function0<Object> function07 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.19
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getPageState() == PageState.FAILURE);
                            }
                        };
                        final GameContentPageMainView gameContentPageMainView21 = GameContentPageMainView.this;
                        ConditionViewKt.c(aqVar2, function07, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.20
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final GameContentPageMainView gameContentPageMainView22 = GameContentPageMainView.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.20.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.20.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height((tVar2.getPagerData().l() - 120.0f) - 48.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameContentPageMainView gameContentPageMainView23 = GameContentPageMainView.this;
                                        vVar2.addChild(new ECLoadErrorView(), new Function1<ECLoadErrorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.20.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECLoadErrorView eCLoadErrorView) {
                                                ECLoadErrorView eCLoadErrorView2 = eCLoadErrorView;
                                                eCLoadErrorView2.attr(new Function1<ECLoadErrorViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.20.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECLoadErrorViewAttr eCLoadErrorViewAttr) {
                                                        ECLoadErrorViewAttr eCLoadErrorViewAttr2 = eCLoadErrorViewAttr;
                                                        eCLoadErrorViewAttr2.isCirStyle = true;
                                                        eCLoadErrorViewAttr2.tipsText$delegate.setValue(eCLoadErrorViewAttr2, ECLoadErrorViewAttr.$$delegatedProperties[0], "\u7f51\u7edc\u4e0d\u7ed9\u529b,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameContentPageMainView gameContentPageMainView24 = GameContentPageMainView.this;
                                                eCLoadErrorView2.event(new Function1<ECLoadErrorViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.20.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECLoadErrorViewEvent eCLoadErrorViewEvent) {
                                                        final GameContentPageMainView gameContentPageMainView25 = GameContentPageMainView.this;
                                                        eCLoadErrorViewEvent.registerEvent("onClickRetryBtn", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.20.1.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                GameContentPageMainViewModel viewModel = GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel();
                                                                KProperty<Object>[] kPropertyArr = GameContentPageMainViewModel.$$delegatedProperties;
                                                                viewModel.refreshAllPage(null);
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
                        final GameContentPageMainView gameContentPageMainView22 = GameContentPageMainView.this;
                        ConditionViewKt.c(aqVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.21
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameFeedList().size() == 0 && GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameGoodsBlock() == null && GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getViewModel().getGameCardBlock() == null);
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.22
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                conditionView.addChild(new GCPTabLoadingView(), new Function1<GCPTabLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView.body.1.2.22.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(GCPTabLoadingView gCPTabLoadingView) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GameContentPageMainView gameContentPageMainView2 = GameContentPageMainView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getPageDidAppearTimes());
                    }
                };
                final GameContentPageMainView gameContentPageMainView3 = GameContentPageMainView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        if (GameContentPageMainView.access$getAttr(GameContentPageMainView.this).getPageDidAppearTimes() > 0) {
                            Utils.INSTANCE.logToNative("GameContentPageMainView pageDidAppear");
                            GameContentPageMainView.this.getClass();
                            GameContentPageMainView gameContentPageMainView4 = GameContentPageMainView.this;
                            gameContentPageMainView4.smallBannerPlayIntervalTimeMs$delegate.setValue(gameContentPageMainView4, GameContentPageMainView.$$delegatedProperties[3], 4000);
                            GameContentPageMainView.access$subViewExposeReportIfNeed(GameContentPageMainView.this);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GameContentPageMainViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GameContentPageMainViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.pullViewHeight = ((getPagerData().m() * 900) / 750) - 120.0f;
    }

    public final void setFooterRefreshText(String str) {
        this.footerRefreshText$delegate.setValue(this, $$delegatedProperties[7], str);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
    }
}
