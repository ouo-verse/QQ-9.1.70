package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UnreadTotalCntDetail {
    public int unclassifiableC2CUnreadCnt;
    public HashMap<Integer, Integer> unreadCntByType = new HashMap<>();

    public int getUnclassifiableC2CUnreadCnt() {
        return this.unclassifiableC2CUnreadCnt;
    }

    public HashMap<Integer, Integer> getUnreadCntByType() {
        return this.unreadCntByType;
    }
}
