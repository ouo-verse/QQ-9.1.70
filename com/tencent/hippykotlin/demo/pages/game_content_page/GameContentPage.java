package com.tencent.hippykotlin.demo.pages.game_content_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule$getQQCirCurrentTabIndex$1;
import com.tencent.hippykotlin.demo.pages.base.ECLoadErrorView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadErrorViewAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadErrorViewEvent;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.game_content_page.base.ECCircleLoadingView;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.InteractViewModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.AdBannerBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.Like;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.Share;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.ext.ECGameTabExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GameContentPage extends BasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPage.class, "pageDidAppearTimes", "getPageDidAppearTimes()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPage.class, "topMaskAlpha", "getTopMaskAlpha()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPage.class, "topTransitionPercentage", "getTopTransitionPercentage()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPage.class, "isUserSetupDefaultMuted", "isUserSetupDefaultMuted()Z", 0)};
    public aa<GameContentPageMainView> mainViewRef;
    public GameContentPageModel pageModel;
    public final ReadWriteProperty pageDidAppearTimes$delegate = c.a(0);
    public final ReadWriteProperty topMaskAlpha$delegate = c.a(Float.valueOf(0.6f));
    public final ReadWriteProperty topTransitionPercentage$delegate = c.a(Float.valueOf(1.0f));
    public final ReadWriteProperty isUserSetupDefaultMuted$delegate = c.a(Boolean.FALSE);
    public boolean pageDidDisAppear = true;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GameContentPage gameContentPage = GameContentPage.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        GameContentPageModel gameContentPageModel = GameContentPage.this.pageModel;
                        if (gameContentPageModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                            gameContentPageModel = null;
                        }
                        if (!gameContentPageModel.isTabPage) {
                            EcommerceExtKt.vr$default(mVar2, "pg_xsj_game_tab_page", null, null, null, null, false, 56);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final GameContentPage gameContentPage2 = GameContentPage.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GameContentPageModel gameContentPageModel = GameContentPage.this.pageModel;
                        if (gameContentPageModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                            gameContentPageModel = null;
                        }
                        return Boolean.valueOf(gameContentPageModel.getMainViewModels().size() > 0);
                    }
                };
                final GameContentPage gameContentPage3 = GameContentPage.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GameContentPage gameContentPage4 = GameContentPage.this;
                        conditionView.addChild(new GameContentPageMainView(), new Function1<GameContentPageMainView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GameContentPageMainView gameContentPageMainView) {
                                GameContentPageMainView gameContentPageMainView2 = gameContentPageMainView;
                                final GameContentPage gameContentPage5 = GameContentPage.this;
                                gameContentPageMainView2.ref(gameContentPageMainView2, new Function1<aa<GameContentPageMainView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<GameContentPageMainView> aaVar) {
                                        GameContentPage.this.mainViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPage gameContentPage6 = GameContentPage.this;
                                gameContentPageMainView2.attr(new Function1<GameContentPageMainViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GameContentPageMainViewAttr gameContentPageMainViewAttr) {
                                        GameContentPageMainViewAttr gameContentPageMainViewAttr2 = gameContentPageMainViewAttr;
                                        GameContentPageModel gameContentPageModel = GameContentPage.this.pageModel;
                                        GameContentPageModel gameContentPageModel2 = null;
                                        if (gameContentPageModel == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                            gameContentPageModel = null;
                                        }
                                        GameContentPageMainViewModel curTabViewModel = gameContentPageModel.curTabViewModel();
                                        ReadWriteProperty readWriteProperty = gameContentPageMainViewAttr2.viewModel$delegate;
                                        KProperty<?>[] kPropertyArr = GameContentPageMainViewAttr.$$delegatedProperties;
                                        readWriteProperty.setValue(gameContentPageMainViewAttr2, kPropertyArr[1], curTabViewModel);
                                        GameContentPageModel gameContentPageModel3 = GameContentPage.this.pageModel;
                                        if (gameContentPageModel3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                            gameContentPageModel3 = null;
                                        }
                                        GameContentPageMainViewModel curTabViewModel2 = gameContentPageModel3.curTabViewModel();
                                        gameContentPageMainViewAttr2.data = (GetFeedRsp) curTabViewModel2.dataRsp$delegate.getValue(curTabViewModel2, GameContentPageMainViewModel.$$delegatedProperties[0]);
                                        GameContentPageModel gameContentPageModel4 = GameContentPage.this.pageModel;
                                        if (gameContentPageModel4 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                            gameContentPageModel4 = null;
                                        }
                                        gameContentPageMainViewAttr2.tabItems$delegate.setValue(gameContentPageMainViewAttr2, kPropertyArr[0], gameContentPageModel4.getGameTabList());
                                        GameContentPageModel gameContentPageModel5 = GameContentPage.this.pageModel;
                                        if (gameContentPageModel5 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                            gameContentPageModel5 = null;
                                        }
                                        AdBannerBlock adBannerBlock = (AdBannerBlock) gameContentPageModel5.adBannerBlock$delegate.getValue(gameContentPageModel5, GameContentPageModel.$$delegatedProperties[3]);
                                        gameContentPageMainViewAttr2.bannerData = adBannerBlock != null ? adBannerBlock.bannerList : null;
                                        gameContentPageMainViewAttr2.pageDidAppearTimes$delegate.setValue(gameContentPageMainViewAttr2, kPropertyArr[2], Integer.valueOf(GameContentPage.this.getPageDidAppearTimes()));
                                        GameContentPageModel gameContentPageModel6 = GameContentPage.this.pageModel;
                                        if (gameContentPageModel6 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                        } else {
                                            gameContentPageModel2 = gameContentPageModel6;
                                        }
                                        gameContentPageMainViewAttr2.currentTabIndex$delegate.setValue(gameContentPageMainViewAttr2, kPropertyArr[3], Integer.valueOf(gameContentPageModel2.getCurrentTabIndex()));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPage gameContentPage7 = GameContentPage.this;
                                gameContentPageMainView2.event(new Function1<GameContentPageMainViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GameContentPageMainViewEvent gameContentPageMainViewEvent) {
                                        GameContentPageMainViewEvent gameContentPageMainViewEvent2 = gameContentPageMainViewEvent;
                                        final GameContentPage gameContentPage8 = GameContentPage.this;
                                        gameContentPageMainViewEvent2.registerEvent("clickedCategoryBarItem", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                float f16;
                                                Object first;
                                                GameContentPage gameContentPage9 = GameContentPage.this;
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue = ((Integer) obj).intValue();
                                                GameContentPageModel gameContentPageModel = gameContentPage9.pageModel;
                                                GameContentPageModel gameContentPageModel2 = null;
                                                if (gameContentPageModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                    gameContentPageModel = null;
                                                }
                                                if (gameContentPageModel.getCurrentTabIndex() != intValue) {
                                                    GameContentPageModel gameContentPageModel3 = gameContentPage9.pageModel;
                                                    if (gameContentPageModel3 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                        gameContentPageModel3 = null;
                                                    }
                                                    Iterator<GameFeedModel> it = gameContentPageModel3.curTabViewModel().getGameFeedList().iterator();
                                                    while (true) {
                                                        f16 = 0.0f;
                                                        if (!it.hasNext()) {
                                                            break;
                                                        }
                                                        GameFeedModel next = it.next();
                                                        QVideoPlayControl playControl = next.getPlayControl();
                                                        QVideoPlayControl qVideoPlayControl = QVideoPlayControl.STOP;
                                                        if (playControl != qVideoPlayControl) {
                                                            next.setPlayControl(qVideoPlayControl);
                                                        }
                                                        next.videoAppearPercentage = 0.0f;
                                                    }
                                                    GameContentPageModel gameContentPageModel4 = gameContentPage9.pageModel;
                                                    if (gameContentPageModel4 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                        gameContentPageModel4 = null;
                                                    }
                                                    gameContentPageModel4.getClass();
                                                    ArrayList arrayList = new ArrayList();
                                                    ArrayList<String> arrayList2 = new ArrayList<>();
                                                    arrayList.addAll(gameContentPageModel4.getMainViewModels().get(intValue).getGameFeedList());
                                                    if (arrayList.size() > 40) {
                                                        int size = arrayList.size();
                                                        for (int i3 = 0; i3 < size && i3 <= arrayList.size() - 20; i3++) {
                                                            GameFeedModel gameFeedModel = (GameFeedModel) arrayList.get(i3);
                                                            f16 += ((Number) gameFeedModel.feedCardHeight$delegate.getValue(gameFeedModel, GameFeedModel.$$delegatedProperties[1])).floatValue();
                                                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) gameContentPageModel4.getMainViewModels().get(intValue).getGameFeedList());
                                                            arrayList2.add(((GameFeedModel) first).gameFeed.feedPbToken);
                                                            CollectionsKt__MutableCollectionsKt.removeFirst(gameContentPageModel4.getMainViewModels().get(intValue).getGameFeedList());
                                                        }
                                                        Utils.INSTANCE.currentBridgeModule().cleanPB(arrayList2);
                                                        GameContentPageMainViewModel gameContentPageMainViewModel = gameContentPageModel4.getMainViewModels().get(intValue);
                                                        gameContentPageMainViewModel.contentOffsetY$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[6], Float.valueOf(gameContentPageMainViewModel.getContentOffsetY() - f16));
                                                    }
                                                }
                                                GameContentPageModel gameContentPageModel5 = gameContentPage9.pageModel;
                                                if (gameContentPageModel5 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                    gameContentPageModel5 = null;
                                                }
                                                if (gameContentPageModel5.getGameTabList().size() > intValue) {
                                                    GameContentPageModel gameContentPageModel6 = gameContentPage9.pageModel;
                                                    if (gameContentPageModel6 == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                        gameContentPageModel6 = null;
                                                    }
                                                    GameTab gameTab = gameContentPageModel6.getGameTabList().get(intValue);
                                                    e eVar = new e();
                                                    eVar.v("second_tab_name", gameTab.name);
                                                    eVar.t("is_red_spot", ECGameTabExtKt.getShowRedPointEnable(gameTab) ? 1 : 2);
                                                    Utils.INSTANCE.logToNative("GameContentPageReporter EVENT_CODE_SECOND_TAB_CLK");
                                                    e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, "source_from"), "bus_id", 2);
                                                    Iterator<String> c16 = eVar.c();
                                                    while (c16.hasNext()) {
                                                        String next2 = c16.next();
                                                        m3.v(next2, eVar.p(next2));
                                                    }
                                                    Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_second_tab_clk", m3);
                                                }
                                                GameContentPageModel gameContentPageModel7 = gameContentPage9.pageModel;
                                                if (gameContentPageModel7 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                } else {
                                                    gameContentPageModel2 = gameContentPageModel7;
                                                }
                                                gameContentPageModel2.updateCurrentTabIndex(intValue);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        gameContentPageMainViewEvent2.registerEvent("scrollViewDidScroll", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameContentPage gameContentPage9 = GameContentPage.this;
                                        gameContentPageMainViewEvent2.registerEvent("bannerDidExpand", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GameContentPage gameContentPage10 = GameContentPage.this;
                                                gameContentPage10.topMaskAlpha$delegate.setValue(gameContentPage10, GameContentPage.$$delegatedProperties[1], Float.valueOf(0.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameContentPage gameContentPage10 = GameContentPage.this;
                                        gameContentPageMainViewEvent2.registerEvent("bannerDidClose", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GameContentPage gameContentPage11 = GameContentPage.this;
                                                gameContentPage11.topMaskAlpha$delegate.setValue(gameContentPage11, GameContentPage.$$delegatedProperties[1], Float.valueOf(0.6f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameContentPage gameContentPage11 = GameContentPage.this;
                                        gameContentPageMainViewEvent2.didShowSelectItemHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.3.5
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GameContentPageModel gameContentPageModel = GameContentPage.this.pageModel;
                                                if (gameContentPageModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                    gameContentPageModel = null;
                                                }
                                                gameContentPageModel.getClass();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        final GameContentPage gameContentPage12 = GameContentPage.this;
                                        gameContentPageMainViewEvent2.topTransitionPercentageHandlerFn = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.3.1.3.6
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Float f16) {
                                                float floatValue = f16.floatValue();
                                                GameContentPage gameContentPage13 = GameContentPage.this;
                                                gameContentPage13.topTransitionPercentage$delegate.setValue(gameContentPage13, GameContentPage.$$delegatedProperties[2], Float.valueOf(floatValue));
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
                final GameContentPage gameContentPage4 = GameContentPage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GameContentPageModel gameContentPageModel = GameContentPage.this.pageModel;
                        if (gameContentPageModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                            gameContentPageModel = null;
                        }
                        return Boolean.valueOf(((PageState) gameContentPageModel.pageState$delegate.getValue(gameContentPageModel, GameContentPageModel.$$delegatedProperties[5])) == PageState.LOADING);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.5
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        conditionView.addChild(new ECCircleLoadingView(), new Function1<ECCircleLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ECCircleLoadingView eCCircleLoadingView) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GameContentPage gameContentPage5 = GameContentPage.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GameContentPageModel gameContentPageModel = GameContentPage.this.pageModel;
                        if (gameContentPageModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                            gameContentPageModel = null;
                        }
                        return Boolean.valueOf(((PageState) gameContentPageModel.pageState$delegate.getValue(gameContentPageModel, GameContentPageModel.$$delegatedProperties[5])) == PageState.FAILURE);
                    }
                };
                final GameContentPage gameContentPage6 = GameContentPage.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GameContentPage gameContentPage7 = GameContentPage.this;
                        conditionView.addChild(new ECLoadErrorView(), new Function1<ECLoadErrorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.7.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECLoadErrorView eCLoadErrorView) {
                                ECLoadErrorView eCLoadErrorView2 = eCLoadErrorView;
                                eCLoadErrorView2.attr(new Function1<ECLoadErrorViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.7.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadErrorViewAttr eCLoadErrorViewAttr) {
                                        ECLoadErrorViewAttr eCLoadErrorViewAttr2 = eCLoadErrorViewAttr;
                                        eCLoadErrorViewAttr2.isCirStyle = true;
                                        eCLoadErrorViewAttr2.tipsText$delegate.setValue(eCLoadErrorViewAttr2, ECLoadErrorViewAttr.$$delegatedProperties[0], "\u7f51\u7edc\u4e0d\u7ed9\u529b,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameContentPage gameContentPage8 = GameContentPage.this;
                                eCLoadErrorView2.event(new Function1<ECLoadErrorViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.7.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadErrorViewEvent eCLoadErrorViewEvent) {
                                        final GameContentPage gameContentPage9 = GameContentPage.this;
                                        eCLoadErrorViewEvent.registerEvent("onClickRetryBtn", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.7.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                GameContentPageModel gameContentPageModel = GameContentPage.this.pageModel;
                                                if (gameContentPageModel == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                                                    gameContentPageModel = null;
                                                }
                                                gameContentPageModel.refreshAllPage();
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
                final GameContentPage gameContentPage7 = GameContentPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final GameContentPage gameContentPage8 = GameContentPage.this;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.8.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 4, null);
                                tVar2.mo141height(tVar2.getPagerData().getStatusBarHeight() + 48.0f);
                                tVar2.mo113backgroundColor(new h("qecommerce_skin_color_bg_default"));
                                GameContentPage gameContentPage9 = GameContentPage.this;
                                tVar2.m147opacity(1 - ((Number) gameContentPage9.topTransitionPercentage$delegate.getValue(gameContentPage9, GameContentPage.$$delegatedProperties[2])).floatValue());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GameContentPage gameContentPage8 = GameContentPage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.9
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        GameContentPageModel gameContentPageModel = GameContentPage.this.pageModel;
                        if (gameContentPageModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                            gameContentPageModel = null;
                        }
                        return Boolean.valueOf(!gameContentPageModel.isTabPage);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1.10
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), 48.0f);
                                        Attr.absolutePosition$default(tVar2, tVar2.getPagerData().getStatusBarHeight(), 0.0f, 0.0f, 0.0f, 12, null);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                Attr.absolutePosition$default(tVar2, 0.0f, 5.5f, 0.0f, 0.0f, 12, null);
                                                tVar2.size(48.0f, 48.0f);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final u uVar2 = uVar;
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        BridgeModule.closePage$default(IPagerIdKtxKt.getBridgeModule(u.this), null, null, 3);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(28.0f, 28.0f);
                                                        b.a.b(afVar2, "qecommerce_skin_icon_nav_arrow_left", false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage.body.1.10.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2.fontWeight500(), 18.0f, null, 2, null);
                                                ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
                                                ceVar2.value("\u6e38\u620f");
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

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.pageModel = new GameContentPageModel(getPagerId());
    }

    public final int getPageDidAppearTimes() {
        return ((Number) this.pageDidAppearTimes$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        GameContentPageMainView b16;
        super.onReceivePagerEvent(str, eVar);
        Utils.INSTANCE.currentBridgeModule().log("GameContentPage pagerEvent:" + str + ", eventData:" + eVar);
        int hashCode = str.hashCode();
        GameContentPageModel gameContentPageModel = null;
        if (hashCode == -647710516) {
            if (str.equals("qq_cir_tab_click")) {
                aa<GameContentPageMainView> aaVar = this.mainViewRef;
                if (aaVar != null && (b16 = aaVar.b()) != null) {
                    aa<aq<?, ?>> aaVar2 = b16.listRef;
                    if (aaVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("listRef");
                        aaVar2 = null;
                    }
                    aq<?, ?> b17 = aaVar2.b();
                    if (b17 != null) {
                        ScrollerView.setContentOffset$default(b17, 0.0f, 0.0f, false, null, 8, null);
                    }
                }
                GameContentPageModel gameContentPageModel2 = this.pageModel;
                if (gameContentPageModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                    gameContentPageModel2 = null;
                }
                if (gameContentPageModel2.getMainViewModels().isEmpty()) {
                    gameContentPageModel2.refreshAllPage();
                    return;
                }
                GameContentPageMainViewModel curTabViewModel = gameContentPageModel2.curTabViewModel();
                if (curTabViewModel.getPageState() != PageState.REFRESHING) {
                    curTabViewModel.refreshAllPage(null);
                    return;
                }
                return;
            }
            return;
        }
        if (hashCode != 1047634014) {
            if (hashCode == 1897731079 && str.equals("event_praise_update")) {
                String p16 = eVar.p("feed_id");
                int j3 = eVar.j("praised_count");
                int j16 = eVar.j("praised_status");
                p16.length();
                GameContentPageModel gameContentPageModel3 = this.pageModel;
                if (gameContentPageModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                } else {
                    gameContentPageModel = gameContentPageModel3;
                }
                Iterator<GameContentPageMainViewModel> it = gameContentPageModel.getMainViewModels().iterator();
                while (it.hasNext()) {
                    com.tencent.kuikly.core.reactive.collection.c<GameFeedModel> gameFeedList = it.next().getGameFeedList();
                    ArrayList arrayList = new ArrayList();
                    Iterator<GameFeedModel> it5 = gameFeedList.iterator();
                    while (it5.hasNext()) {
                        GameFeedModel next = it5.next();
                        if (Intrinsics.areEqual(p16, next.gameFeed.f114193id)) {
                            arrayList.add(next);
                        }
                    }
                    Iterator it6 = arrayList.iterator();
                    while (it6.hasNext()) {
                        GameFeedModel gameFeedModel = (GameFeedModel) it6.next();
                        Like like = gameFeedModel.gameFeed.like;
                        if (like != null) {
                            like.count = j3;
                            like.status = j16;
                        }
                        gameFeedModel.interactViewModel.setLikeStatus(j16);
                        if (j3 > 0) {
                            gameFeedModel.interactViewModel.setLikeCountTxt(Utils.INSTANCE.formatCountNumber(j3));
                        } else {
                            gameFeedModel.interactViewModel.setLikeCountTxt("\u8d5e");
                        }
                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("GameContentPage handlePraiseUpdateEvent, feedId:");
                        sb5.append(p16);
                        sb5.append(" praisedStatus:");
                        sb5.append(j16);
                        sb5.append(" praisedCount:");
                        sb5.append(j3);
                        sb5.append(" interactViewModel.likeCountTxt:");
                        InteractViewModel interactViewModel = gameFeedModel.interactViewModel;
                        sb5.append((String) interactViewModel.likeCountTxt$delegate.getValue(interactViewModel, InteractViewModel.$$delegatedProperties[0]));
                        currentBridgeModule.log(sb5.toString());
                    }
                }
                return;
            }
            return;
        }
        if (str.equals("event_comment_count_update")) {
            String p17 = eVar.p("feed_id");
            int j17 = eVar.j("comment_count");
            p17.length();
            GameContentPageModel gameContentPageModel4 = this.pageModel;
            if (gameContentPageModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageModel");
            } else {
                gameContentPageModel = gameContentPageModel4;
            }
            Iterator<GameContentPageMainViewModel> it7 = gameContentPageModel.getMainViewModels().iterator();
            while (it7.hasNext()) {
                com.tencent.kuikly.core.reactive.collection.c<GameFeedModel> gameFeedList2 = it7.next().getGameFeedList();
                ArrayList arrayList2 = new ArrayList();
                Iterator<GameFeedModel> it8 = gameFeedList2.iterator();
                while (it8.hasNext()) {
                    GameFeedModel next2 = it8.next();
                    if (Intrinsics.areEqual(p17, next2.gameFeed.f114193id)) {
                        arrayList2.add(next2);
                    }
                }
                Iterator it9 = arrayList2.iterator();
                while (it9.hasNext()) {
                    GameFeedModel gameFeedModel2 = (GameFeedModel) it9.next();
                    Share share = gameFeedModel2.gameFeed.share;
                    if (share != null) {
                        share.count = j17;
                    }
                    if (j17 > 0) {
                        gameFeedModel2.interactViewModel.setCommentCountTxt(Utils.INSTANCE.formatCountNumber(j17));
                    } else {
                        gameFeedModel2.interactViewModel.setCommentCountTxt("\u8bc4\u8bba");
                    }
                    BridgeModule currentBridgeModule2 = Utils.INSTANCE.currentBridgeModule();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("GameContentPage handleCommentCountUpdateEvent, feedId:");
                    sb6.append(p17);
                    sb6.append(" commentCount:");
                    sb6.append(j17);
                    sb6.append(" interactViewModel.commentCountTxt:");
                    InteractViewModel interactViewModel2 = gameFeedModel2.interactViewModel;
                    sb6.append((String) interactViewModel2.commentCountTxt$delegate.getValue(interactViewModel2, InteractViewModel.$$delegatedProperties[2]));
                    currentBridgeModule2.log(sb6.toString());
                }
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        this.pageDidDisAppear = false;
        IPagerIdKtxKt.getBridgeModule(this).setBlackStatusBarStyle();
        GameContentPageModel gameContentPageModel = this.pageModel;
        GameContentPageModel gameContentPageModel2 = null;
        if (gameContentPageModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
            gameContentPageModel = null;
        }
        gameContentPageModel.curTabViewModel().playVideoInNextTickIfNeed(true);
        this.pageDidAppearTimes$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(getPageDidAppearTimes() + 1));
        GameContentPageModel gameContentPageModel3 = this.pageModel;
        if (gameContentPageModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
            gameContentPageModel3 = null;
        }
        if (gameContentPageModel3.curTabViewModel().isTabPage) {
            TimerKt.e(getPagerId(), 1, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$updateUserSetupDefaultMuted$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    boolean areEqual = Intrinsics.areEqual(IPagerIdKtxKt.getBridgeModule(GameContentPage.this).syncToNativeMethod("getQCircleVideoMuteValue", (e) null, (Function1<? super e, Unit>) null), "1");
                    GameContentPage gameContentPage = GameContentPage.this;
                    ReadWriteProperty readWriteProperty = gameContentPage.isUserSetupDefaultMuted$delegate;
                    KProperty<?>[] kPropertyArr = GameContentPage.$$delegatedProperties;
                    if (((Boolean) readWriteProperty.getValue(gameContentPage, kPropertyArr[3])).booleanValue() != areEqual) {
                        Utils.INSTANCE.logToNative("userSetupDefaultMuted:" + areEqual);
                        GameContentPage gameContentPage2 = GameContentPage.this;
                        gameContentPage2.isUserSetupDefaultMuted$delegate.setValue(gameContentPage2, kPropertyArr[3], Boolean.valueOf(areEqual));
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        GameContentPageModel gameContentPageModel4 = this.pageModel;
        if (gameContentPageModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
            gameContentPageModel4 = null;
        }
        Utils utils = Utils.INSTANCE;
        gameContentPageModel4.enterPageTimeMs = utils.currentBridgeModule().currentTimeStamp();
        BridgeModule currentBridgeModule = utils.currentBridgeModule();
        Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$pageDidAppear$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                GameContentPageModel gameContentPageModel5 = GameContentPage.this.pageModel;
                if (gameContentPageModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                    gameContentPageModel5 = null;
                }
                gameContentPageModel5.qqCirTabIndexWhenAppear = intValue;
                return Unit.INSTANCE;
            }
        };
        currentBridgeModule.getClass();
        currentBridgeModule.callNativeMethod("getQQCirCurrentTabIndex", null, new BridgeModule$getQQCirCurrentTabIndex$1(function1));
        GameContentPageModel gameContentPageModel5 = this.pageModel;
        if (gameContentPageModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
            gameContentPageModel5 = null;
        }
        if (gameContentPageModel5.isTabPage) {
            GameContentPageModel gameContentPageModel6 = this.pageModel;
            if (gameContentPageModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                gameContentPageModel6 = null;
            }
            int i3 = gameContentPageModel6.qqCirTabIndexWhenAppear;
            GameContentPageModel gameContentPageModel7 = this.pageModel;
            if (gameContentPageModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageModel");
            } else {
                gameContentPageModel2 = gameContentPageModel7;
            }
            if (i3 != gameContentPageModel2.qqCirTabIndexWhenDisappear) {
                e eVar = new e();
                utils.logToNative("GameContentPageReporter EVENT_CODE_PAGE_EXP");
                e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, "source_from"), "bus_id", 2);
                Iterator<String> c16 = eVar.c();
                while (c16.hasNext()) {
                    String next = c16.next();
                    m3.v(next, eVar.p(next));
                }
                Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_exp", m3);
                return;
            }
            return;
        }
        if (getPageDidAppearTimes() == 1) {
            e eVar2 = new e();
            utils.logToNative("GameContentPageReporter EVENT_CODE_PAGE_EXP");
            e m16 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, "source_from"), "bus_id", 2);
            Iterator<String> c17 = eVar2.c();
            while (c17.hasNext()) {
                String next2 = c17.next();
                m16.v(next2, eVar2.p(next2));
            }
            Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_exp", m16);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        GameContentPageMainView b16;
        super.pageDidDisappear();
        if (this.pageDidDisAppear) {
            return;
        }
        this.pageDidDisAppear = true;
        GameContentPageModel gameContentPageModel = this.pageModel;
        GameContentPageModel gameContentPageModel2 = null;
        if (gameContentPageModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
            gameContentPageModel = null;
        }
        GameContentPageMainViewModel curTabViewModel = gameContentPageModel.curTabViewModel();
        Iterator<GameFeedModel> it = curTabViewModel.getGameFeedList().iterator();
        while (it.hasNext()) {
            GameFeedModel next = it.next();
            if (next.getPlayControl() == QVideoPlayControl.PLAY) {
                next.setPlayControl(QVideoPlayControl.PAUSE);
            }
        }
        curTabViewModel.needPlayVideo = false;
        aa<GameContentPageMainView> aaVar = this.mainViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            Utils.INSTANCE.logToNative("GameContentPageMainView pageDidDisappear");
            b16.smallBannerPlayIntervalTimeMs$delegate.setValue(b16, GameContentPageMainView.$$delegatedProperties[3], 0);
        }
        Utils utils = Utils.INSTANCE;
        BridgeModule currentBridgeModule = utils.currentBridgeModule();
        Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$pageDidDisappear$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int intValue = num.intValue();
                GameContentPageModel gameContentPageModel3 = GameContentPage.this.pageModel;
                if (gameContentPageModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageModel");
                    gameContentPageModel3 = null;
                }
                gameContentPageModel3.qqCirTabIndexWhenDisappear = intValue;
                return Unit.INSTANCE;
            }
        };
        currentBridgeModule.getClass();
        currentBridgeModule.callNativeMethod("getQQCirCurrentTabIndex", null, new BridgeModule$getQQCirCurrentTabIndex$1(function1));
        long currentTimeStamp = utils.currentBridgeModule().currentTimeStamp();
        e eVar = new e();
        GameContentPageModel gameContentPageModel3 = this.pageModel;
        if (gameContentPageModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
        } else {
            gameContentPageModel2 = gameContentPageModel3;
        }
        e u16 = eVar.u("duration", currentTimeStamp - gameContentPageModel2.enterPageTimeMs);
        utils.logToNative("GameContentPageReporter EVENT_CODE_PAGE_DURATION");
        e m3 = AdelieAudioRecordManager$endRecord$1$$ExternalSyntheticOutline0.m("source_from", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, "source_from"), "bus_id", 2);
        if (u16 != null) {
            Iterator<String> c16 = u16.c();
            while (c16.hasNext()) {
                String next2 = c16.next();
                m3.v(next2, u16.p(next2));
            }
        }
        Utils.INSTANCE.currentBridgeModule().reportDT("youxi_page_duration", m3);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        GameContentPageModel gameContentPageModel = this.pageModel;
        if (gameContentPageModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageModel");
            gameContentPageModel = null;
        }
        Iterator<GameContentPageMainViewModel> it = gameContentPageModel.getMainViewModels().iterator();
        while (it.hasNext()) {
            it.next().cleanPB();
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        if (getPagerData().getIsIOS()) {
            Utils.INSTANCE.currentBridgeModule().callNativeMethod("qCircleGameContentInit", null, null);
        }
    }
}
