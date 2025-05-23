package com.tencent.ecommerce.biz.submitsucceed;

import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt__SetsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/submitsucceed/SubmitSucceedFrom;", "", "(Ljava/lang/String;I)V", "getRecommendScene", "Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "isQShopOrderScene", "", "PAY_IN_SUBMIT_ORDER", "PAY_IN_ORDER_LIST", "PAY_IN_ORDER_DETAIL", "WRITE_COMMENT", "APPLY_SAMPLE_ORDER", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum SubmitSucceedFrom {
    PAY_IN_SUBMIT_ORDER,
    PAY_IN_ORDER_LIST,
    PAY_IN_ORDER_DETAIL,
    WRITE_COMMENT,
    APPLY_SAMPLE_ORDER;

    public final ECShopRecommendScene getRecommendScene() {
        int i3 = d.f104811a[ordinal()];
        if (i3 == 1) {
            return ECShopRecommendScene.QQ_SHOP_ORDER_FINISH_DETAIL;
        }
        if (i3 == 2) {
            return ECShopRecommendScene.QQ_SHOP_ORDER_FINISH_DETAIL;
        }
        if (i3 == 3) {
            return ECShopRecommendScene.QQ_SHOP_ORDER_FINISH_DETAIL;
        }
        if (i3 == 4) {
            return ECShopRecommendScene.QQ_SHOP_COMMENT_FINISH_DETAIL;
        }
        if (i3 == 5) {
            return ECShopRecommendScene.QQ_SHOP_APPLY_SAMPLE_ORDER_FINISH_DETAIL;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isQShopOrderScene() {
        Set of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new SubmitSucceedFrom[]{PAY_IN_SUBMIT_ORDER, PAY_IN_ORDER_LIST, PAY_IN_ORDER_DETAIL});
        return of5.contains(this);
    }
}
