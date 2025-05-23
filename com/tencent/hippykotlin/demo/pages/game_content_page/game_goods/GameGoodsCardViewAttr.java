package com.tencent.hippykotlin.demo.pages.game_content_page.game_goods;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GoodsCard;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameGoodsCardViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameGoodsCardViewAttr.class, "goodsCardData", "getGoodsCardData()Lcom/tencent/hippykotlin/demo/pages/game_content_page/repo/data/game/GoodsCard;", 0)};
    public GameTab gameTab;
    public final ReadWriteProperty goodsCardData$delegate = c.a(null);

    public final GoodsCard getGoodsCardData() {
        return (GoodsCard) this.goodsCardData$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
