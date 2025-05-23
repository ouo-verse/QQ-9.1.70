package com.tencent.ecommerce.biz.shophome.model;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/model/ECSearchScene;", "", "type", "", "(Ljava/lang/String;II)V", "SEARCH_UNKNOWN_TYPE", "SEARCH_SCENE_QQ_SHOP_INSIDE", "SEARCH_SCENE_QQ_SHOP_PRODUCT_DETAIL", "SEARCH_SCENE_QQ_SHOP_ORDER_DETAIL", "SEARCH_SCENE_QQ_SHOP_COMMENT_FINISH_DETAIL", "SEARCH_SCENE_QQ_SHOP_ORDER_FINISH_DETAIL", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECSearchScene {
    SEARCH_UNKNOWN_TYPE(0),
    SEARCH_SCENE_QQ_SHOP_INSIDE(1),
    SEARCH_SCENE_QQ_SHOP_PRODUCT_DETAIL(2),
    SEARCH_SCENE_QQ_SHOP_ORDER_DETAIL(3),
    SEARCH_SCENE_QQ_SHOP_COMMENT_FINISH_DETAIL(4),
    SEARCH_SCENE_QQ_SHOP_ORDER_FINISH_DETAIL(5);

    public final int type;

    ECSearchScene(int i3) {
        this.type = i3;
    }
}
