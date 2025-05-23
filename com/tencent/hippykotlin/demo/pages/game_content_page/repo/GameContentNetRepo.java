package com.tencent.hippykotlin.demo.pages.game_content_page.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$7;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainViewModel$fetchNextPage$1;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTabBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeed;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeedBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.StGetFeedListRsp;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.s;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameContentNetRepo implements IGameContentRepo {
    public GameTab gameTab;
    public boolean isEnd;
    public int sourceFrom;
    public String tabId;
    public String feedAttachInfo = "";
    public String cookie = "";

    public GameContentNetRepo(String str, int i3) {
        this.tabId = str;
        this.sourceFrom = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.game_content_page.repo.IGameContentRepo
    public final void refreshAllPage(boolean z16, Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5) {
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GameContentNetRepo getFeed refreshAllPage start tab=");
        m3.append(this.tabId);
        utils.logToNative(m3.toString());
        this.cookie = "";
        this.isEnd = false;
        this.feedAttachInfo = "";
        requestData(function5);
    }

    @Override // com.tencent.hippykotlin.demo.pages.game_content_page.repo.IGameContentRepo
    public final void requestNextPage(Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5) {
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GameContentNetRepo getFeed requestNextPage start tab=");
        m3.append(this.tabId);
        utils.logToNative(m3.toString());
        if (this.isEnd) {
            utils.logToNative("GameContentNetRepo getFeed requestNextPage isEnd=true, just return");
            Boolean bool = Boolean.TRUE;
            ((GameContentPageMainViewModel$fetchNextPage$1) function5).invoke(bool, bool, this.gameTab, null, Boolean.FALSE);
            return;
        }
        requestData(function5);
    }

    public final void requestData(final Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5) {
        Object syncToNativeMethod;
        String str = this.feedAttachInfo;
        Utils utils = Utils.INSTANCE;
        String qua = utils.currentBridgeModule().getQua();
        BridgeModule currentBridgeModule = utils.currentBridgeModule();
        currentBridgeModule.getClass();
        if (c.f117352a.k(utils.currentBridgeModule().getPagerId()).getPageData().getIsIOS()) {
            syncToNativeMethod = "";
        } else {
            syncToNativeMethod = currentBridgeModule.syncToNativeMethod("getQCirclePluginQua", (e) null, (Function1<? super e, Unit>) null);
        }
        String syncToNativeMethod2 = utils.currentBridgeModule().syncToNativeMethod("getQCircleDeviceInfo", (e) null, (Function1<? super e, Unit>) null);
        int i3 = this.sourceFrom;
        Object obj = this.tabId;
        Object obj2 = this.cookie;
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        GetFeedRsp getFeedRsp = new GetFeedRsp(null, null, null, null, null, null, null, 127, null);
        Function1<GetFeedRsp, Unit> function1 = new Function1<GetFeedRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameContentNetRepo$requestData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GetFeedRsp getFeedRsp2) {
                String str2;
                StGetFeedListRsp stGetFeedListRsp;
                StGetFeedListRsp stGetFeedListRsp2;
                ArrayList<GameFeed> arrayList;
                StGetFeedListRsp stGetFeedListRsp3;
                ArrayList<GameFeed> arrayList2;
                String str3;
                Object obj3;
                StGetFeedListRsp stGetFeedListRsp4;
                ArrayList<GameFeed> arrayList3;
                StGetFeedListRsp stGetFeedListRsp5;
                List<GameTab> list;
                List<GameTab> list2;
                StGetFeedListRsp stGetFeedListRsp6;
                StGetFeedListRsp stGetFeedListRsp7;
                GetFeedRsp getFeedRsp3 = getFeedRsp2;
                GameContentNetRepo gameContentNetRepo = GameContentNetRepo.this;
                gameContentNetRepo.cookie = getFeedRsp3.cookie;
                GameFeedBlock gameFeedBlock = getFeedRsp3.gameFeedBlock;
                if (gameFeedBlock == null || (stGetFeedListRsp7 = gameFeedBlock.baseFeedRsp) == null || (str2 = stGetFeedListRsp7.feedAttchInfo) == null) {
                    str2 = "";
                }
                gameContentNetRepo.feedAttachInfo = str2;
                gameContentNetRepo.isEnd = !((gameFeedBlock == null || (stGetFeedListRsp6 = gameFeedBlock.baseFeedRsp) == null || stGetFeedListRsp6.isFinish != 0) ? false : true);
                if (gameContentNetRepo.gameTab == null) {
                    GameTabBlock gameTabBlock = getFeedRsp3.gameTabBlock;
                    if (gameTabBlock != null && (list2 = gameTabBlock.gameTabs) != null) {
                        if (gameContentNetRepo.tabId.length() == 0) {
                            gameContentNetRepo.tabId = getFeedRsp3.gameTabBlock.locatedTabId;
                        }
                        Iterator<GameTab> it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            GameTab next = it.next();
                            if (Intrinsics.areEqual(next.f114192id, gameContentNetRepo.tabId)) {
                                gameContentNetRepo.gameTab = next;
                                break;
                            }
                        }
                    }
                    if (c.f117352a.g().getPageData().n().j("is_tab_page") == 1) {
                        String str4 = GameContentNetRepo.this.tabId;
                        GetFeedRsp decode = new GetFeedRsp(null, null, null, null, null, null, null, 127, null).decode(getFeedRsp3.encode());
                        GameTabBlock gameTabBlock2 = decode.gameTabBlock;
                        if (((gameTabBlock2 == null || (list = gameTabBlock2.gameTabs) == null) ? 0 : list.size()) != 0) {
                            GameFeedBlock gameFeedBlock2 = decode.gameFeedBlock;
                            if (gameFeedBlock2 == null || (stGetFeedListRsp5 = gameFeedBlock2.baseFeedRsp) == null || (obj3 = stGetFeedListRsp5.feed) == null) {
                                obj3 = 0;
                            }
                            if (!Intrinsics.areEqual(obj3, (Object) 0)) {
                                GameFeedBlock gameFeedBlock3 = decode.gameFeedBlock;
                                if (gameFeedBlock3 != null && (stGetFeedListRsp4 = gameFeedBlock3.baseFeedRsp) != null && (arrayList3 = stGetFeedListRsp4.feed) != null && arrayList3.size() > 2) {
                                    for (int size = arrayList3.size() - 1; 1 < size; size--) {
                                        arrayList3.remove(size);
                                    }
                                }
                                Utils.INSTANCE.cacheModule("").setItem("GameContentRepoRspCache_" + str4 + util.base64_pad_url + c.f117352a.g().getPageData().getAppVersion(), decode.encode().toString());
                            }
                        }
                        c cVar = c.f117352a;
                        g pageData = cVar.g().getPageData();
                        if (Intrinsics.areEqual(pageData.n().p("anchor_tab"), GameContentNetRepo.this.tabId)) {
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("game_content_page_");
                            m3.append(d.b(d.a(pageData.n().k(MiniGamePAHippyBaseFragment.KEY_THEME, 0))));
                            m3.append(util.base64_pad_url);
                            m3.append(pageData.getAppVersion());
                            String sb5 = m3.toString();
                            Utils utils2 = Utils.INSTANCE;
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("save snapshot with tab_id:");
                            m16.append(GameContentNetRepo.this.tabId);
                            m16.append(" key:");
                            m16.append(sb5);
                            utils2.logToNative(m16.toString());
                            ((s) cVar.g().acquireModule("KRSnapshotModule")).a(sb5);
                        }
                    }
                    Utils utils3 = Utils.INSTANCE;
                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GameContentNetRepo getFeed success gameTab=");
                    m17.append(getFeedRsp3.gameTabBlock);
                    utils3.logToNative(m17.toString());
                }
                GameFeedBlock gameFeedBlock4 = getFeedRsp3.gameFeedBlock;
                if (gameFeedBlock4 != null && (stGetFeedListRsp3 = gameFeedBlock4.baseFeedRsp) != null && (arrayList2 = stGetFeedListRsp3.feed) != null) {
                    Iterator<GameFeed> it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        GameFeed next2 = it5.next();
                        Utils utils4 = Utils.INSTANCE;
                        String pagerId = utils4.currentBridgeModule().getPagerId();
                        if (!(pagerId.length() > 0)) {
                            str3 = "";
                        } else if (c.f117352a.k(pagerId).getPageData().getIsIOS()) {
                            str3 = "TNF_COMM_StFeed";
                        } else {
                            str3 = "feedcloud.FeedCloudMeta$StFeed";
                        }
                        if (str3.length() > 0) {
                            utils4.currentBridgeModule().preloadPB(str3, next2.feedPb, next2.feedPbToken);
                        } else {
                            utils4.logToNative("GameContent StFeed withFeedData className error");
                        }
                    }
                }
                Utils utils5 = Utils.INSTANCE;
                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GameContentNetRepo getFeed success gameFeeds size=");
                GameFeedBlock gameFeedBlock5 = getFeedRsp3.gameFeedBlock;
                ArrayList<GameFeed> arrayList4 = null;
                m18.append((gameFeedBlock5 == null || (stGetFeedListRsp2 = gameFeedBlock5.baseFeedRsp) == null || (arrayList = stGetFeedListRsp2.feed) == null) ? null : Integer.valueOf(arrayList.size()));
                utils5.logToNative(m18.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append("GameContentNetRepo getFeed success gameFeeds GameFeedList=");
                GameFeedBlock gameFeedBlock6 = getFeedRsp3.gameFeedBlock;
                if (gameFeedBlock6 != null && (stGetFeedListRsp = gameFeedBlock6.baseFeedRsp) != null) {
                    arrayList4 = stGetFeedListRsp.feed;
                }
                sb6.append(arrayList4);
                utils5.logToNative(sb6.toString());
                function5.invoke(Boolean.TRUE, Boolean.valueOf(GameContentNetRepo.this.isEnd), GameContentNetRepo.this.gameTab, getFeedRsp3, Boolean.FALSE);
                return Unit.INSTANCE;
            }
        };
        Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameContentNetRepo$requestData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str2) {
                int intValue = num.intValue();
                Utils.INSTANCE.logToNative("GameContentNetRepo getFeed failed errorCode=" + intValue + ", errorMsg=" + str2);
                final Function5<Boolean, Boolean, GameTab, GetFeedRsp, Boolean, Unit> function52 = function5;
                final GameContentNetRepo gameContentNetRepo = this;
                TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameContentNetRepo$requestData$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function5<Boolean, Boolean, GameTab, GetFeedRsp, Boolean, Unit> function53 = function52;
                        Boolean bool = Boolean.FALSE;
                        function53.invoke(bool, Boolean.valueOf(gameContentNetRepo.isEnd), gameContentNetRepo.gameTab, null, bool);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule2 = utils.currentBridgeModule();
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("qua", qua, "device_info", syncToNativeMethod2);
        m3.v("sw_plugin_qua", syncToNativeMethod);
        m3.t("source_from", i3);
        m3.v("game_tab_id", obj);
        m3.v("cookie", obj2);
        e eVar = new e();
        eVar.t("listNum", 5);
        eVar.t("from", 0);
        eVar.v("adres", "");
        eVar.v("adAttchInfo", "");
        eVar.v("feedAttchInfo", str);
        eVar.t("source", 0);
        eVar.v("busiReqData", "");
        eVar.v("dstUserId", "");
        eVar.w("isMiddlePage", false);
        eVar.t("subSource", 0);
        e eVar2 = new e();
        eVar2.t("load_more_type", 0);
        eVar2.v("page_up_attach_info", "");
        eVar.v("load_more_info", eVar2);
        m3.v("base_feed_req", eVar);
        currentBridgeModule2.ssoRequest("trpc.ecom.game_feed_svr.GameFeedService/GetFeed", m3, false, new NetworkUtils$requestWithCmd$7(function2, getFeedRsp, function1));
    }
}
