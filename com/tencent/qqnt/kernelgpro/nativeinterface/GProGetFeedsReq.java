package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetFeedsReq {
    public ArrayList<String> feedIds = new ArrayList<>();

    public ArrayList<String> getFeedIds() {
        return this.feedIds;
    }

    public String toString() {
        return "GProGetFeedsReq{feedIds=" + this.feedIds + ",}";
    }
}
