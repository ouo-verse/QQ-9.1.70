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
public final class GameGoodsListBarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameGoodsListBarAttr.class, "leftTitle", "getLeftTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameGoodsListBarAttr.class, "rightTitle", "getRightTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameGoodsListBarAttr.class, "gameGoodsItems", "getGameGoodsItems()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameGoodsListBarAttr.class, "buttonMore", "getButtonMore()Lcom/tencent/hippykotlin/demo/pages/game_content_page/repo/data/game/Button;", 0)};
    public GameTab gameTab;
    public final ReadWriteProperty leftTitle$delegate = c.a("");
    public final ReadWriteProperty rightTitle$delegate = c.a("");
    public final ReadWriteProperty gameGoodsItems$delegate = c.b();
    public final ReadWriteProperty buttonMore$delegate = c.a(null);

    public final com.tencent.kuikly.core.reactive.collection.c<GoodsCard> getGameGoodsItems() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.gameGoodsItems$delegate.getValue(this, $$delegatedProperties[2]);
    }
}
