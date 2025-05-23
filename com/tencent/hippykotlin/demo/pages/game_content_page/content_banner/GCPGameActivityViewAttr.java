package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPGameActivityViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameActivityViewAttr.class, "dataList", "getDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPGameActivityViewAttr.class, "pageDidAppearTimes", "getPageDidAppearTimes()I", 0)};
    public GameTab gameTab;
    public final ReadWriteProperty dataList$delegate = c.b();
    public final ReadWriteProperty pageDidAppearTimes$delegate = c.a(0);

    public final com.tencent.kuikly.core.reactive.collection.c<GameCard> getDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.dataList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final int getPageDidAppearTimes() {
        return ((Number) this.pageDidAppearTimes$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }
}
