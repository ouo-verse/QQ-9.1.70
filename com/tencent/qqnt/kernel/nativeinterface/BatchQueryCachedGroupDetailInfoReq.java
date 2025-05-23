package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchQueryCachedGroupDetailInfoReq {
    public ArrayList<Long> groupCodes = new ArrayList<>();

    public ArrayList<Long> getGroupCodes() {
        return this.groupCodes;
    }

    public String toString() {
        return "BatchQueryCachedGroupDetailInfoReq{groupCodes=" + this.groupCodes + ",}";
    }
}
