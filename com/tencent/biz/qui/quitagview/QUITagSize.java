package com.tencent.biz.qui.quitagview;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qui/quitagview/QUITagSize;", "", "(Ljava/lang/String;I)V", "getCornerRadius", "", "getCornerRadius$QUITagView_debug", "BIG", "MIDDLE", "SMALL", "QUITagView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public enum QUITagSize {
    BIG,
    MIDDLE,
    SMALL;

    public final float getCornerRadius$QUITagView_debug() {
        if (this == SMALL) {
            return 4.0f;
        }
        return 6.0f;
    }
}
