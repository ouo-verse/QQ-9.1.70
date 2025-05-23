package com.tencent.hippykotlin.demo.pages.game_content_page.video_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GameInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed.AdCard;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes31.dex */
public final class GCPGameCardViewAttr extends k {
    public AdCard adCard;
    public GameTab gameTab;
    public int uiType = 1;

    static {
        Reflection.mutableProperty1(new MutablePropertyReference1Impl(GCPGameCardViewAttr.class, "buttonText", "getButtonText()Ljava/lang/String;", 0));
    }

    public GCPGameCardViewAttr() {
        c.a("\u9884\u7ea6");
    }

    public final AdCard getAdCard() {
        AdCard adCard = this.adCard;
        if (adCard != null) {
            return adCard;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adCard");
        return null;
    }

    public final boolean getShowGameMetaInfoView() {
        if (!getPagerData().getIsIOS()) {
            GameInfo gameInfo = getAdCard().gameInfo;
            if ((gameInfo != null ? gameInfo.privilege : null) != null) {
                return true;
            }
        }
        return false;
    }
}
