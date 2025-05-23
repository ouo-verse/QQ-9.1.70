package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBatchGetFeedDetailReq {
    public int detailType;
    public int from;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public ArrayList<GProFeedParam> feedParamList = new ArrayList<>();
    public GProStChannelSign channelSign = new GProStChannelSign();

    public GProStChannelSign getChannelSign() {
        return this.channelSign;
    }

    public int getDetailType() {
        return this.detailType;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public ArrayList<GProFeedParam> getFeedParamList() {
        return this.feedParamList;
    }

    public int getFrom() {
        return this.from;
    }

    public String toString() {
        return "GProBatchGetFeedDetailReq{extInfo=" + this.extInfo + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",feedParamList=" + this.feedParamList + ",detailType=" + this.detailType + ",channelSign=" + this.channelSign + ",}";
    }
}
