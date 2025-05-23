package com.tencent.hippykotlin.demo.pages.game_content_page.repo;

import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.GetFeedRsp;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;

/* compiled from: P */
/* loaded from: classes31.dex */
public interface IGameContentRepo {
    void refreshAllPage(boolean z16, Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5);

    void requestNextPage(Function5<? super Boolean, ? super Boolean, ? super GameTab, ? super GetFeedRsp, ? super Boolean, Unit> function5);
}
