package com.tencent.ecommerce.biz.recommend.models;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "", "value", "", "(Ljava/lang/String;II)V", "UNKNOWN_TYPE", "QQ_SHOP_HOMEPAGE", "QQ_SHOP_PRODUCT_DETAIL", "QQ_SHOP_ORDER_DETAIL", "QQ_SHOP_COMMENT_FINISH_DETAIL", "QQ_SHOP_ORDER_FINISH_DETAIL", "QQ_SHOP_APPLY_SAMPLE_ORDER_DETAIL", "QQ_SHOP_APPLY_SAMPLE_ORDER_FINISH_DETAIL", "QQ_SHOP_WEB_PRODUCT_DETAIL", "QQ_OFF_SALE_SCENE", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECShopRecommendScene {
    UNKNOWN_TYPE(0),
    QQ_SHOP_HOMEPAGE(1),
    QQ_SHOP_PRODUCT_DETAIL(2),
    QQ_SHOP_ORDER_DETAIL(3),
    QQ_SHOP_COMMENT_FINISH_DETAIL(4),
    QQ_SHOP_ORDER_FINISH_DETAIL(5),
    QQ_SHOP_APPLY_SAMPLE_ORDER_DETAIL(6),
    QQ_SHOP_APPLY_SAMPLE_ORDER_FINISH_DETAIL(7),
    QQ_SHOP_WEB_PRODUCT_DETAIL(8),
    QQ_OFF_SALE_SCENE(9);

    public final int value;

    ECShopRecommendScene(int i3) {
        this.value = i3;
    }
}
