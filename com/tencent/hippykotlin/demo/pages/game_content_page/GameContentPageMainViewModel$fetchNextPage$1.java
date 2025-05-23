package com.tencent.hippykotlin.demo.pages.game_content_page;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeed;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GameFeedBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class GameContentPageMainViewModel$fetchNextPage$1 extends Lambda implements Function5<Boolean, Boolean, GameTab, GetFeedRsp, Boolean, Unit> {
    public final /* synthetic */ Function2<Boolean, Boolean, Unit> $callback;
    public final /* synthetic */ GameContentPageMainViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GameContentPageMainViewModel$fetchNextPage$1(Function2<? super Boolean, ? super Boolean, Unit> function2, GameContentPageMainViewModel gameContentPageMainViewModel) {
        super(5);
        this.$callback = function2;
        this.this$0 = gameContentPageMainViewModel;
    }

    @Override // kotlin.jvm.functions.Function5
    public final Unit invoke(Boolean bool, Boolean bool2, GameTab gameTab, GetFeedRsp getFeedRsp, Boolean bool3) {
        GameFeedBlock gameFeedBlock;
        StGetFeedListRsp stGetFeedListRsp;
        ArrayList<GameFeed> arrayList;
        boolean booleanValue = bool.booleanValue();
        boolean booleanValue2 = bool2.booleanValue();
        GetFeedRsp getFeedRsp2 = getFeedRsp;
        bool3.booleanValue();
        if (booleanValue && getFeedRsp2 != null && (gameFeedBlock = getFeedRsp2.gameFeedBlock) != null && (stGetFeedListRsp = gameFeedBlock.baseFeedRsp) != null && (arrayList = stGetFeedListRsp.feed) != null) {
            GameContentPageMainViewModel gameContentPageMainViewModel = this.this$0;
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GameContentPageMainView fetchNextPage count: ");
            m3.append(arrayList.size());
            utils.logToNative(m3.toString());
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                gameContentPageMainViewModel.getGameFeedList().add(new GameFeedModel((GameFeed) it.next()));
            }
        }
        Function2<Boolean, Boolean, Unit> function2 = this.$callback;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2));
        }
        return Unit.INSTANCE;
    }
}
