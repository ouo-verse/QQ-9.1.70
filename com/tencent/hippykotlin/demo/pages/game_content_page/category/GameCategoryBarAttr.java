package com.tencent.hippykotlin.demo.pages.game_content_page.category;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameCategoryBarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameCategoryBarAttr.class, "currentIndex", "getCurrentIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameCategoryBarAttr.class, "items", "getItems()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty currentIndex$delegate = c.a(0);
    public final ReadWriteProperty items$delegate = c.b();

    public final com.tencent.kuikly.core.reactive.collection.c<GameCategoryBarItem> getItems() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.items$delegate.getValue(this, $$delegatedProperties[1]);
    }
}
