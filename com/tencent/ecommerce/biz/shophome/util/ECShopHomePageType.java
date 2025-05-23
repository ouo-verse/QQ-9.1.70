package com.tencent.ecommerce.biz.shophome.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomePageType;", "", "", "typeValue", "I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "PAGE_TYPE_ALL", "PAGE_TYPE_ONE_LEVE_CATEGORY", "PAGE_TYPE_TWO_LEVE_CATEGORY", "PAGE_TYPE_SEARCH_RESULT", "PAGE_TYPE_SEARCH_RESULT_RECOMMEND", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECShopHomePageType {
    PAGE_TYPE_ALL(1),
    PAGE_TYPE_ONE_LEVE_CATEGORY(2),
    PAGE_TYPE_TWO_LEVE_CATEGORY(3),
    PAGE_TYPE_SEARCH_RESULT(4),
    PAGE_TYPE_SEARCH_RESULT_RECOMMEND(5);

    public final int typeValue;

    ECShopHomePageType(int i3) {
        this.typeValue = i3;
    }
}
