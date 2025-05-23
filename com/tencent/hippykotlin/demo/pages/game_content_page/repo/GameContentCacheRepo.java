package com.tencent.hippykotlin.demo.pages.game_content_page.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeed;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeedBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.StGetFeedListRsp;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameContentCacheRepo implements IGameContentRepo {
    public final IGameContentRepo repo;
    public final String tabId;

    public GameContentCacheRepo(String str) {
        this.tabId = str;
        this.repo = GameContentRepoFactory.INSTANCE.create$qecommerce_biz_release(1, str, 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.game_content_page.repo.IGameContentRepo
    public final void requestNextPage(Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5) {
        this.repo.requestNextPage(function5);
    }

    @Override // com.tencent.hippykotlin.demo.pages.game_content_page.repo.IGameContentRepo
    public final void refreshAllPage(boolean z16, Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5) {
        StGetFeedListRsp stGetFeedListRsp;
        ArrayList<GameFeed> arrayList;
        String str;
        StGetFeedListRsp stGetFeedListRsp2;
        if (z16) {
            c cVar = c.f117352a;
            if (cVar.g().getPageData().n().j("is_tab_page") == 1) {
                String str2 = this.tabId;
                String item = Utils.INSTANCE.cacheModule("").getItem("GameContentRepoRspCache_" + str2 + util.base64_pad_url + cVar.g().getPageData().getAppVersion());
                if (item.length() > 0) {
                    try {
                        GetFeedRsp decode = new GetFeedRsp(null, null, null, null, null, null, null, 127, null).decode(new e(item));
                        GameFeedBlock gameFeedBlock = decode.gameFeedBlock;
                        boolean z17 = (gameFeedBlock == null || (stGetFeedListRsp2 = gameFeedBlock.baseFeedRsp) == null || stGetFeedListRsp2.isFinish != 1) ? false : true;
                        if (gameFeedBlock != null && (stGetFeedListRsp = gameFeedBlock.baseFeedRsp) != null && (arrayList = stGetFeedListRsp.feed) != null) {
                            Iterator<GameFeed> it = arrayList.iterator();
                            while (it.hasNext()) {
                                GameFeed next = it.next();
                                Utils utils = Utils.INSTANCE;
                                String pagerId = utils.currentBridgeModule().getPagerId();
                                if (!(pagerId.length() > 0)) {
                                    str = "";
                                } else if (c.f117352a.k(pagerId).getPageData().getIsIOS()) {
                                    str = "TNF_COMM_StFeed";
                                } else {
                                    str = "feedcloud.FeedCloudMeta$StFeed";
                                }
                                if (str.length() > 0) {
                                    utils.currentBridgeModule().preloadPB(str, next.feedPb, next.feedPbToken);
                                } else {
                                    utils.logToNative("GameContent StFeed withFeedData className error");
                                }
                            }
                        }
                        Boolean bool = Boolean.TRUE;
                        function5.invoke(bool, Boolean.valueOf(z17), new GameTab(null, null, false, 7, null), decode, bool);
                    } catch (Throwable th5) {
                        Utils utils2 = Utils.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GameContentCacheRepo, read from cache error, e = ");
                        m3.append(th5.getMessage());
                        utils2.logToNative(m3.toString());
                    }
                }
            }
        }
        this.repo.refreshAllPage(false, function5);
    }
}
