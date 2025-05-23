package com.tencent.hippykotlin.demo.pages.game_content_page.category;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameCategoryBarItemAttr extends k {
    public GameCategoryBarItem item;

    public final GameCategoryBarItem getItem() {
        GameCategoryBarItem gameCategoryBarItem = this.item;
        if (gameCategoryBarItem != null) {
            return gameCategoryBarItem;
        }
        Intrinsics.throwUninitializedPropertyAccessException(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
        return null;
    }
}
