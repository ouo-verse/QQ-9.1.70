package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPGameActivityCardAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameActivityCardAttr.class, "pageDidAppearTimes", "getPageDidAppearTimes()I", 0)};
    public GameCard activityData;
    public float cardHeight;
    public GameTab gameTab;
    public int index;
    public int listSize;
    public final ReadWriteProperty pageDidAppearTimes$delegate = c.a(0);

    public final GameCard getActivityData() {
        GameCard gameCard = this.activityData;
        if (gameCard != null) {
            return gameCard;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activityData");
        return null;
    }
}
