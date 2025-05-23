package com.tencent.sqshow.zootopia.nativeui.data.cart;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/cart/PriceType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "NONE", "GOAL_FIRST", "SILVER_FIRST", "GOAL_AND_SILVER", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public enum PriceType {
    NONE("none"),
    GOAL_FIRST("\u91d1\u5e01"),
    SILVER_FIRST("\u94f6\u5e01"),
    GOAL_AND_SILVER("\u91d1\u5e01\u548c\u94f6\u5e01");

    private final String type;

    PriceType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
