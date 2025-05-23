package com.tencent.hippykotlin.demo.pages.game_content_page;

import com.qzone.reborn.intimate.request.QZoneIntimateBaseRequest;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QVideoPlayControl;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameContentRepoFactory;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.IGameContentRepo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCardBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameGoodsBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.NavigationBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeed;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeedBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.StGetFeedListRsp;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.FooterRefreshState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GameContentPageMainViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewModel.class, "dataRsp", "getDataRsp()Lcom/tencent/hippykotlin/demo/pages/game_content_page/repo/data/gamefeed/GetFeedRsp;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewModel.class, "gameFeedList", "getGameFeedList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewModel.class, "navigationBlock", "getNavigationBlock()Lcom/tencent/hippykotlin/demo/pages/game_content_page/repo/data/game/NavigationBlock;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewModel.class, "gameCardBlock", "getGameCardBlock()Lcom/tencent/hippykotlin/demo/pages/game_content_page/repo/data/game/GameCardBlock;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewModel.class, "gameGoodsBlock", "getGameGoodsBlock()Lcom/tencent/hippykotlin/demo/pages/game_content_page/repo/data/game/GameGoodsBlock;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewModel.class, "isEnd", "isEnd()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewModel.class, "contentOffsetY", "getContentOffsetY()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageMainViewModel.class, "pageState", "getPageState()Lcom/tencent/hippykotlin/demo/pages/game_content_page/PageState;", 0)};
    public final ReadWriteProperty contentOffsetY$delegate;
    public final ReadWriteProperty dataRsp$delegate;
    public final ReadWriteProperty gameCardBlock$delegate;
    public final ReadWriteProperty gameFeedList$delegate;
    public final ReadWriteProperty gameGoodsBlock$delegate;
    public boolean isFirstRequest;
    public boolean isTabPage;
    public final ReadWriteProperty navigationBlock$delegate;
    public boolean needPlayVideo;
    public final ReadWriteProperty pageState$delegate;
    public IGameContentRepo repo;
    public final GameTab tab;
    public int tabIndex;

    public GameContentPageMainViewModel(GameTab gameTab) {
        this.tab = gameTab;
        c cVar = c.f117352a;
        this.repo = GameContentRepoFactory.INSTANCE.create$qecommerce_biz_release(2, gameTab.f114192id, cVar.g().getPageData().n().j("source_from"));
        this.dataRsp$delegate = c01.c.a(null);
        this.gameFeedList$delegate = c01.c.b();
        this.navigationBlock$delegate = c01.c.a(null);
        this.gameCardBlock$delegate = c01.c.a(null);
        this.gameGoodsBlock$delegate = c01.c.a(null);
        c01.c.a(Boolean.FALSE);
        this.contentOffsetY$delegate = c01.c.a(Float.valueOf(0.0f));
        this.pageState$delegate = c01.c.a(PageState.NORMAL);
        FooterRefreshState footerRefreshState = FooterRefreshState.IDLE;
        this.isFirstRequest = true;
        this.isTabPage = cVar.g().getPageData().n().j("is_tab_page") == 1;
    }

    public final void cleanPB() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<GameFeedModel> it = getGameFeedList().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().gameFeed.feedPbToken);
        }
        Utils.INSTANCE.currentBridgeModule().cleanPB(arrayList);
    }

    public final float getContentOffsetY() {
        return ((Number) this.contentOffsetY$delegate.getValue(this, $$delegatedProperties[6])).floatValue();
    }

    public final GameCardBlock getGameCardBlock() {
        return (GameCardBlock) this.gameCardBlock$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<GameFeedModel> getGameFeedList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.gameFeedList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final GameGoodsBlock getGameGoodsBlock() {
        return (GameGoodsBlock) this.gameGoodsBlock$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final PageState getPageState() {
        return (PageState) this.pageState$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final void playVideoForFeedModel(final GameFeedModel gameFeedModel) {
        boolean z16;
        QVideoPlayControl playControl = gameFeedModel.getPlayControl();
        QVideoPlayControl qVideoPlayControl = QVideoPlayControl.PLAY;
        int i3 = 0;
        if (playControl != qVideoPlayControl) {
            gameFeedModel.setPlayControl(qVideoPlayControl);
            c.f117352a.g().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainViewModel$videoPlayDCReport$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    String str;
                    GameFeedModel gameFeedModel2 = GameFeedModel.this;
                    e eVar = new e();
                    if (Intrinsics.areEqual(c.f117352a.k(BridgeManager.f117344a.u()).getPageData().n().p("source_from"), "1")) {
                        str = "97";
                    } else {
                        str = QZoneIntimateBaseRequest.QZONE_INTIMATE_REQUEST_CLOUD_APP_ID_VALUE;
                    }
                    eVar.v("page_id", str);
                    BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                    String str2 = gameFeedModel2.gameFeed.feedPbToken;
                    currentBridgeModule.getClass();
                    e eVar2 = new e();
                    eVar2.v("qCircleDCReportParam", eVar);
                    eVar2.v("feedPbToken", str2);
                    eVar2.t("qCircleDCReportActionType", 2);
                    eVar2.t("qCircleDCReportSubActionType", 4);
                    currentBridgeModule.callNativeMethod("qCircleDCReport", eVar2, null);
                    return Unit.INSTANCE;
                }
            });
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<GameFeedModel> it = getGameFeedList().iterator();
        while (it.hasNext()) {
            GameFeedModel next = it.next();
            if (!Intrinsics.areEqual(next, gameFeedModel)) {
                QVideoPlayControl playControl2 = next.getPlayControl();
                QVideoPlayControl qVideoPlayControl2 = QVideoPlayControl.STOP;
                if (playControl2 != qVideoPlayControl2 && next.getPlayControl() != QVideoPlayControl.PREPLAY && next.getPlayControl() != QVideoPlayControl.NONE) {
                    next.setPlayControl(qVideoPlayControl2);
                }
            } else if (Intrinsics.areEqual(next, gameFeedModel) && z16) {
                i3 = 3;
            }
            if (i3 > 0 && !Intrinsics.areEqual(next, gameFeedModel)) {
                i3--;
                arrayList.add(next.gameFeed.feedPbToken);
            }
        }
        if ((!arrayList.isEmpty()) && AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a)) {
            Utils.INSTANCE.currentBridgeModule().qCirclePreloadFeeds(arrayList);
        }
    }

    public final void playVideoInNextTickIfNeed(final boolean z16) {
        c cVar = c.f117352a;
        b g16 = cVar.g();
        if (!(g16 instanceof GameContentPage) || ((GameContentPage) g16).pageDidDisAppear || this.needPlayVideo) {
            return;
        }
        this.needPlayVideo = true;
        cVar.g().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainViewModel$playVideoInNextTickIfNeed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Object first;
                GameContentPageMainViewModel gameContentPageMainViewModel = GameContentPageMainViewModel.this;
                if (gameContentPageMainViewModel.needPlayVideo) {
                    gameContentPageMainViewModel.needPlayVideo = false;
                    Iterator<GameFeedModel> it = gameContentPageMainViewModel.getGameFeedList().iterator();
                    GameFeedModel gameFeedModel = null;
                    while (it.hasNext()) {
                        GameFeedModel next = it.next();
                        if (gameFeedModel == null || next.videoAppearPercentage > gameFeedModel.videoAppearPercentage) {
                            gameFeedModel = next;
                        }
                    }
                    if ((gameFeedModel != null ? gameFeedModel.videoAppearPercentage : 0.0f) > 0.0f) {
                        Intrinsics.checkNotNull(gameFeedModel);
                        QVideoPlayControl playControl = gameFeedModel.getPlayControl();
                        QVideoPlayControl qVideoPlayControl = QVideoPlayControl.USER_PAUSE;
                        if (playControl != qVideoPlayControl) {
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) GameContentPageMainViewModel.this.getGameFeedList());
                            if (!Intrinsics.areEqual(gameFeedModel, first) || gameFeedModel.videoAppearPercentage >= 0.95f) {
                                if (z16 && gameFeedModel.getPlayControl() == QVideoPlayControl.PLAY) {
                                    gameFeedModel.setPlayControl(qVideoPlayControl);
                                }
                                GameContentPageMainViewModel.this.playVideoForFeedModel(gameFeedModel);
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void refreshAllPage(final Function2<? super Boolean, ? super Boolean, Unit> function2) {
        Utils.INSTANCE.logToNative("GameContentPageMainView refreshAllPage");
        setPageState(PageState.REFRESHING);
        this.repo.refreshAllPage(this.isFirstRequest, new Function5<Boolean, Boolean, GameTab, GetFeedRsp, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainViewModel$refreshAllPage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(Boolean bool, Boolean bool2, GameTab gameTab, GetFeedRsp getFeedRsp, Boolean bool3) {
                PageState pageState;
                StGetFeedListRsp stGetFeedListRsp;
                ArrayList<GameFeed> arrayList;
                boolean booleanValue = bool.booleanValue();
                boolean booleanValue2 = bool2.booleanValue();
                GetFeedRsp getFeedRsp2 = getFeedRsp;
                boolean booleanValue3 = bool3.booleanValue();
                if (booleanValue && getFeedRsp2 != null) {
                    GameContentPageMainViewModel gameContentPageMainViewModel = GameContentPageMainViewModel.this;
                    if (booleanValue3) {
                        pageState = PageState.REFRESHING;
                    } else {
                        pageState = PageState.SUCCESS;
                    }
                    gameContentPageMainViewModel.setPageState(pageState);
                    gameContentPageMainViewModel.dataRsp$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[0], getFeedRsp2);
                    gameContentPageMainViewModel.cleanPB();
                    gameContentPageMainViewModel.getGameFeedList().clear();
                    GameFeedBlock gameFeedBlock = getFeedRsp2.gameFeedBlock;
                    if (gameFeedBlock != null && (stGetFeedListRsp = gameFeedBlock.baseFeedRsp) != null && (arrayList = stGetFeedListRsp.feed) != null) {
                        Iterator<T> it = arrayList.iterator();
                        while (it.hasNext()) {
                            gameContentPageMainViewModel.getGameFeedList().add(new GameFeedModel((GameFeed) it.next()));
                        }
                    }
                    NavigationBlock navigationBlock = getFeedRsp2.navigationBlock;
                    if (navigationBlock != null) {
                        gameContentPageMainViewModel.navigationBlock$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[2], navigationBlock);
                    }
                    GameCardBlock gameCardBlock = getFeedRsp2.gameCardBlock;
                    if (gameCardBlock != null) {
                        gameContentPageMainViewModel.gameCardBlock$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[3], gameCardBlock);
                    }
                    GameGoodsBlock gameGoodsBlock = getFeedRsp2.gameGoodsBlock;
                    if (gameGoodsBlock != null) {
                        gameContentPageMainViewModel.gameGoodsBlock$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[4], gameGoodsBlock);
                    }
                } else if (GameContentPageMainViewModel.this.getGameFeedList().size() > 0) {
                    GameContentPageMainViewModel.this.setPageState(PageState.NORMAL);
                    Utils.INSTANCE.currentBridgeModule().toast("\u7f51\u7edc\u4e0d\u7ed9\u529b,\u8bf7\u68c0\u67e5\u7f51\u7edc");
                } else {
                    GameContentPageMainViewModel.this.setPageState(PageState.FAILURE);
                }
                Function2<Boolean, Boolean, Unit> function22 = function2;
                if (function22 != null) {
                    function22.invoke(Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2));
                }
                return Unit.INSTANCE;
            }
        });
        this.isFirstRequest = false;
    }

    public final void setPageState(PageState pageState) {
        this.pageState$delegate.setValue(this, $$delegatedProperties[7], pageState);
    }
}
