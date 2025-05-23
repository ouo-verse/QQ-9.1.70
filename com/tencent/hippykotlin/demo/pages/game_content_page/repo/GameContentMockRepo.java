package com.tencent.hippykotlin.demo.pages.game_content_page.repo;

import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPageMainViewModel$fetchNextPage$1;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTabBlock;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameContentMockRepo implements IGameContentRepo {
    public GameTab gameTab;
    public int index;
    public String tabId;

    public GameContentMockRepo(String str) {
        this.tabId = str;
    }

    public final GetFeedRsp mockData() {
        GameTabBlock gameTabBlock;
        List<GameTab> list;
        GetFeedRsp decode = new GetFeedRsp(null, null, null, null, null, null, null, 127, null).decode(new e(""));
        if (this.gameTab == null && (gameTabBlock = decode.gameTabBlock) != null && (list = gameTabBlock.gameTabs) != null) {
            if (this.tabId.length() == 0) {
                this.tabId = decode.gameTabBlock.locatedTabId;
            }
            Iterator<GameTab> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GameTab next = it.next();
                if (Intrinsics.areEqual(next.f114192id, this.tabId)) {
                    this.gameTab = next;
                    break;
                }
            }
        }
        return decode;
    }

    @Override // com.tencent.hippykotlin.demo.pages.game_content_page.repo.IGameContentRepo
    public final void requestNextPage(Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5) {
        if (this.index >= 5) {
            Boolean bool = Boolean.TRUE;
            ((GameContentPageMainViewModel$fetchNextPage$1) function5).invoke(bool, bool, this.gameTab, null, Boolean.FALSE);
            return;
        }
        GetFeedRsp mockData = mockData();
        int i3 = this.index + 1;
        this.index = i3;
        if (i3 > 5) {
            Boolean bool2 = Boolean.TRUE;
            ((GameContentPageMainViewModel$fetchNextPage$1) function5).invoke(bool2, bool2, this.gameTab, mockData, Boolean.FALSE);
        } else {
            Boolean bool3 = Boolean.TRUE;
            Boolean bool4 = Boolean.FALSE;
            ((GameContentPageMainViewModel$fetchNextPage$1) function5).invoke(bool3, bool4, this.gameTab, mockData, bool4);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.game_content_page.repo.IGameContentRepo
    public final void refreshAllPage(boolean z16, Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5) {
        this.index = 0;
        GetFeedRsp mockData = mockData();
        this.index++;
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        function5.invoke(bool, bool2, this.gameTab, mockData, bool2);
    }
}
