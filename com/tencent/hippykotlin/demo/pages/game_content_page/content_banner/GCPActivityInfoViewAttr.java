package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GCPActivityInfoViewAttr extends k {
    public GameCard data;
    public GameTab gameTab;
    public boolean isBigStyle;
    public boolean showGameIcon;

    public final GameCard getData() {
        GameCard gameCard = this.data;
        if (gameCard != null) {
            return gameCard;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
