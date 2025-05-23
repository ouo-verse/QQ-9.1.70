package com.tencent.hippykotlin.demo.pages.game_content_page.repo.ext;

import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECGameTabExtKt {
    public static final boolean getShowRedPointEnable(GameTab gameTab) {
        Object obj = gameTab.getExtProps().get("showReadPointEnable");
        if (obj == null) {
            obj = Boolean.valueOf(gameTab.enableRedPoint);
        }
        return ((Boolean) obj).booleanValue();
    }
}
