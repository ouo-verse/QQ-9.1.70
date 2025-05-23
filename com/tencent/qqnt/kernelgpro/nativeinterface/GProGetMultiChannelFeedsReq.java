package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetMultiChannelFeedsReq {
    public String feedAttachInfo = "";
    public GProGetMultiChannelFeedsFilter filterCondition = new GProGetMultiChannelFeedsFilter();
    public int limit;

    public String getFeedAttachInfo() {
        return this.feedAttachInfo;
    }

    public GProGetMultiChannelFeedsFilter getFilterCondition() {
        return this.filterCondition;
    }

    public int getLimit() {
        return this.limit;
    }

    public String toString() {
        return "GProGetMultiChannelFeedsReq{limit=" + this.limit + ",feedAttachInfo=" + this.feedAttachInfo + ",filterCondition=" + this.filterCondition + ",}";
    }
}
