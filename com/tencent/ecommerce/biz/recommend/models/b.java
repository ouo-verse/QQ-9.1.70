package com.tencent.ecommerce.biz.recommend.models;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {
    public static final String a(ECShopRecommendScene eCShopRecommendScene) {
        if (eCShopRecommendScene != ECShopRecommendScene.QQ_SHOP_APPLY_SAMPLE_ORDER_DETAIL && eCShopRecommendScene != ECShopRecommendScene.QQ_SHOP_APPLY_SAMPLE_ORDER_FINISH_DETAIL) {
            return "shop_home_product_card";
        }
        return "apply_sample_recommend_card";
    }
}
