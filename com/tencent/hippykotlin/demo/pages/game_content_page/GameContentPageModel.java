package com.tencent.hippykotlin.demo.pages.game_content_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$7;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameContentRepoFactory;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.IGameContentRepo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.ECGameClearRedPointRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.AdBannerBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCardBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameGoodsBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTabBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.NavigationBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.TopBannerItem;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeed;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeedBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.StGetFeedListRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.ext.ECGameTabExtKt;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GameContentPageModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageModel.class, "mainViewModels", "getMainViewModels()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageModel.class, "currentTabIndex", "getCurrentTabIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageModel.class, "isEnd", "isEnd()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageModel.class, "adBannerBlock", "getAdBannerBlock()Lcom/tencent/hippykotlin/demo/pages/game_content_page/repo/data/game/AdBannerBlock;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageModel.class, "gameTabList", "getGameTabList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameContentPageModel.class, "pageState", "getPageState()Lcom/tencent/hippykotlin/demo/pages/game_content_page/PageState;", 0)};
    public final ReadWriteProperty adBannerBlock$delegate;
    public long enterPageTimeMs;
    public final ReadWriteProperty gameTabList$delegate;
    public boolean hasLoadFromCache;
    public boolean isFirstRequest;
    public boolean isTabPage;
    public final ReadWriteProperty pageState$delegate;
    public final String pagerId;
    public int qqCirTabIndexWhenAppear;
    public int qqCirTabIndexWhenDisappear;
    public IGameContentRepo repo;
    public final ReadWriteProperty mainViewModels$delegate = c.b();
    public final ReadWriteProperty currentTabIndex$delegate = c.a(0);

    public GameContentPageModel(String str) {
        this.pagerId = str;
        c.a(Boolean.FALSE);
        this.adBannerBlock$delegate = c.a(null);
        this.gameTabList$delegate = c.b();
        this.pageState$delegate = c.a(PageState.SUCCESS);
        this.qqCirTabIndexWhenDisappear = -1;
        this.isFirstRequest = true;
        e n3 = com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().n();
        this.isTabPage = n3.j("is_tab_page") == 1;
        int j3 = n3.j("source_from");
        String p16 = n3.p("anchor_tab");
        Utils.INSTANCE.logToNative("GameContentPage sourceForm:" + j3 + "anchorTabId:" + p16);
        this.repo = GameContentRepoFactory.INSTANCE.create$qecommerce_biz_release(2, p16, j3);
        refreshAllPage();
    }

    public final GameContentPageMainViewModel curTabViewModel() {
        if (getCurrentTabIndex() >= 0 && getCurrentTabIndex() < getMainViewModels().size()) {
            return getMainViewModels().get(getCurrentTabIndex());
        }
        return new GameContentPageMainViewModel(new GameTab(null, null, false, 7, null));
    }

    public final int getCurrentTabIndex() {
        return ((Number) this.currentTabIndex$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<GameTab> getGameTabList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.gameTabList$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<GameContentPageMainViewModel> getMainViewModels() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.mainViewModels$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void refreshAllPage() {
        setPageState(PageState.LOADING);
        this.repo.refreshAllPage(this.isFirstRequest, new Function5<Boolean, Boolean, GameTab, GetFeedRsp, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageModel$refreshAllPage$1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(Boolean bool, Boolean bool2, GameTab gameTab, GetFeedRsp getFeedRsp, Boolean bool3) {
                List<GameTab> list;
                char c16;
                StGetFeedListRsp stGetFeedListRsp;
                ArrayList<GameFeed> arrayList;
                e object;
                b l3;
                Object d16;
                String str;
                TopBannerItem topBannerItem;
                List<GameTab> list2;
                boolean booleanValue = bool.booleanValue();
                bool2.booleanValue();
                GameTab gameTab2 = gameTab;
                GetFeedRsp getFeedRsp2 = getFeedRsp;
                boolean booleanValue2 = bool3.booleanValue();
                if (booleanValue && getFeedRsp2 != null) {
                    if (booleanValue2) {
                        GameContentPageModel.this.hasLoadFromCache = true;
                    }
                    GameContentPageModel.this.setPageState(PageState.SUCCESS);
                    GameContentPageModel gameContentPageModel = GameContentPageModel.this;
                    gameContentPageModel.getClass();
                    char c17 = 3;
                    gameContentPageModel.adBannerBlock$delegate.setValue(gameContentPageModel, GameContentPageModel.$$delegatedProperties[3], getFeedRsp2.adBannerBlock);
                    gameContentPageModel.getGameTabList().clear();
                    GameTabBlock gameTabBlock = getFeedRsp2.gameTabBlock;
                    if (gameTabBlock != null && (list2 = gameTabBlock.gameTabs) != null) {
                        gameContentPageModel.getGameTabList().addAll(list2);
                    }
                    GameTabBlock gameTabBlock2 = getFeedRsp2.gameTabBlock;
                    if (gameTabBlock2 != null && (list = gameTabBlock2.gameTabs) != null) {
                        int i3 = 0;
                        for (Object obj : list) {
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            GameTab gameTab3 = (GameTab) obj;
                            GameContentPageMainViewModel gameContentPageMainViewModel = new GameContentPageMainViewModel(gameTab3);
                            if (i3 < gameContentPageModel.getMainViewModels().size()) {
                                gameContentPageModel.getMainViewModels().set(i3, gameContentPageMainViewModel);
                            } else {
                                gameContentPageModel.getMainViewModels().add(gameContentPageMainViewModel);
                            }
                            gameContentPageMainViewModel.tabIndex = i3;
                            if (Intrinsics.areEqual(gameTab3.f114192id, gameTab2 != null ? gameTab2.f114192id : null)) {
                                gameContentPageMainViewModel.setPageState(booleanValue2 ? PageState.REFRESHING : PageState.NORMAL);
                                gameContentPageMainViewModel.isFirstRequest = false;
                                gameContentPageMainViewModel.dataRsp$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[0], getFeedRsp2);
                                AdBannerBlock adBannerBlock = getFeedRsp2.adBannerBlock;
                                if (adBannerBlock != null) {
                                    List<TopBannerItem> list3 = adBannerBlock.bannerList;
                                    if ((list3 != null ? list3.size() : 0) > 0 && (object = Utils.INSTANCE.cacheModule(gameContentPageModel.pagerId).getObject("GAME_TAB_BANNER_ID_CACHE_KEY1")) != null && (l3 = object.l("BANNER_IDS")) != null) {
                                        int c18 = l3.c();
                                        for (int i17 = 0; i17 < c18; i17++) {
                                            if (BooleanCompanionObject.INSTANCE instanceof String) {
                                                d16 = Boolean.valueOf(l3.e(i17));
                                            } else if (IntCompanionObject.INSTANCE instanceof String) {
                                                d16 = Integer.valueOf(l3.i(i17));
                                            } else if (LongCompanionObject.INSTANCE instanceof String) {
                                                d16 = Long.valueOf(l3.m(i17));
                                            } else if (StringCompanionObject.INSTANCE instanceof String) {
                                                d16 = l3.o(i17);
                                            } else if (DoubleCompanionObject.INSTANCE instanceof String) {
                                                d16 = Double.valueOf(l3.g(i17));
                                            } else {
                                                d16 = l3.d(i17);
                                            }
                                            if (d16 != null) {
                                                String str2 = (String) d16;
                                                List<TopBannerItem> list4 = adBannerBlock.bannerList;
                                                if (list4 == null || (topBannerItem = list4.get(0)) == null || (str = topBannerItem.bannerId) == null) {
                                                    str = "0";
                                                }
                                                Intrinsics.areEqual(str2, str);
                                            } else {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                            }
                                        }
                                    }
                                }
                                NavigationBlock navigationBlock = getFeedRsp2.navigationBlock;
                                if (navigationBlock != null) {
                                    gameContentPageMainViewModel.navigationBlock$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[2], navigationBlock);
                                }
                                GameCardBlock gameCardBlock = getFeedRsp2.gameCardBlock;
                                if (gameCardBlock != null) {
                                    c16 = 3;
                                    gameContentPageMainViewModel.gameCardBlock$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[3], gameCardBlock);
                                } else {
                                    c16 = 3;
                                }
                                GameGoodsBlock gameGoodsBlock = getFeedRsp2.gameGoodsBlock;
                                if (gameGoodsBlock != null) {
                                    gameContentPageMainViewModel.gameGoodsBlock$delegate.setValue(gameContentPageMainViewModel, GameContentPageMainViewModel.$$delegatedProperties[4], gameGoodsBlock);
                                }
                                ArrayList arrayList2 = new ArrayList();
                                GameFeedBlock gameFeedBlock = getFeedRsp2.gameFeedBlock;
                                if (gameFeedBlock != null && (stGetFeedListRsp = gameFeedBlock.baseFeedRsp) != null && (arrayList = stGetFeedListRsp.feed) != null) {
                                    Iterator<T> it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        arrayList2.add(new GameFeedModel((GameFeed) it.next()));
                                    }
                                }
                                gameContentPageMainViewModel.getGameFeedList().clear();
                                gameContentPageMainViewModel.getGameFeedList().addAll(arrayList2);
                                gameContentPageModel.updateCurrentTabIndex(i3);
                            } else {
                                c16 = c17;
                            }
                            i3 = i16;
                            c17 = c16;
                        }
                    }
                } else {
                    GameContentPageModel gameContentPageModel2 = GameContentPageModel.this;
                    if (gameContentPageModel2.hasLoadFromCache) {
                        if (!gameContentPageModel2.getMainViewModels().isEmpty()) {
                            GameContentPageModel.this.getMainViewModels().get(0).setPageState(PageState.NORMAL);
                        }
                        Utils.INSTANCE.currentBridgeModule().toast("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc");
                    } else {
                        gameContentPageModel2.setPageState(PageState.FAILURE);
                    }
                }
                return Unit.INSTANCE;
            }
        });
        this.isFirstRequest = false;
    }

    public final void setPageState(PageState pageState) {
        this.pageState$delegate.setValue(this, $$delegatedProperties[5], pageState);
    }

    public final void updateCurrentTabIndex(int i3) {
        if (getGameTabList().size() > i3) {
            GameTab gameTab = getGameTabList().get(i3);
            if (ECGameTabExtKt.getShowRedPointEnable(gameTab)) {
                gameTab.getExtProps().put("showReadPointEnable", Boolean.FALSE);
                String str = gameTab.f114192id;
                ECGameClearRedPointRsp eCGameClearRedPointRsp = new ECGameClearRedPointRsp();
                Utils utils = Utils.INSTANCE;
                utils.logToNative("GameClearPointNetRepo start request clear red point with tagId " + str);
                NetworkUtils networkUtils = NetworkUtils.INSTANCE;
                utils.currentBridgeModule().ssoRequest("trpc.ecom.game_feed_svr.GameFeedService/ClearRedPoint", AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("located_tab_id", str), false, new NetworkUtils$requestWithCmd$7(new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameClearPointNetRepo$request$2
                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Integer num, String str2) {
                        int intValue = num.intValue();
                        Utils.INSTANCE.logToNative("GameClearPointNetRepo response errorCode:" + intValue + ", errorMsg:" + str2);
                        return Unit.INSTANCE;
                    }
                }, eCGameClearRedPointRsp, new Function1<ECGameClearRedPointRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameClearPointNetRepo$request$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECGameClearRedPointRsp eCGameClearRedPointRsp2) {
                        Utils.INSTANCE.logToNative("GameClearPointNetRepo response success");
                        return Unit.INSTANCE;
                    }
                }));
            }
        }
        this.currentTabIndex$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }
}
