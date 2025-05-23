package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import com.tencent.hippykotlin.demo.pages.game_content_page.repo.GameFeedModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GCPBaseInfoAttr extends k {
    public GameFeedModel gameFeedModel;

    public final GameFeedModel getGameFeedModel() {
        GameFeedModel gameFeedModel = this.gameFeedModel;
        if (gameFeedModel != null) {
            return gameFeedModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameFeedModel");
        return null;
    }
}
