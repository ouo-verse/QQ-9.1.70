package com.tencent.ecommerce.biz.detail.dataprocessor.processor;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/ECBizType;", "", "type", "", "(Ljava/lang/String;II)V", "BIZ_TYPE_UNKNOWN", "BIZ_TYPE_SHOP", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECBizType {
    BIZ_TYPE_UNKNOWN(0),
    BIZ_TYPE_SHOP(1);

    public final int type;

    ECBizType(int i3) {
        this.type = i3;
    }
}
