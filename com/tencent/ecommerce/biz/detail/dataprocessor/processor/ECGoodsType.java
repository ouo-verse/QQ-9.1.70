package com.tencent.ecommerce.biz.detail.dataprocessor.processor;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/ECGoodsType;", "", "type", "", "(Ljava/lang/String;II)V", "GOODS_TYPE_UNKNOWN", "GOODS_TYPE_SAAS", "GOODS_TYPE_HONOR_KING", "GOODS_TYPE_TX_VIDEO", "GOODS_TYPE_TAOBAO_LINK", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECGoodsType {
    GOODS_TYPE_UNKNOWN(0),
    GOODS_TYPE_SAAS(1),
    GOODS_TYPE_HONOR_KING(2),
    GOODS_TYPE_TX_VIDEO(3),
    GOODS_TYPE_TAOBAO_LINK(4);

    public final int type;

    ECGoodsType(int i3) {
        this.type = i3;
    }
}
