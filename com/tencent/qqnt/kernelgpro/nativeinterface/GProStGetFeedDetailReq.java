package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProStGetFeedDetailReq {
    public int contentType;
    public long createTime;
    public int detailType;
    public boolean disableReport;
    public int from;
    public boolean needExternalComment;
    public boolean notReportReadCnt;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public String userId = "";
    public String feedId = "";
    public GProStChannelSign channelSign = new GProStChannelSign();

    public GProStChannelSign getChannelSign() {
        return this.channelSign;
    }

    public int getContentType() {
        return this.contentType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getDetailType() {
        return this.detailType;
    }

    public boolean getDisableReport() {
        return this.disableReport;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getFrom() {
        return this.from;
    }

    public boolean getNeedExternalComment() {
        return this.needExternalComment;
    }

    public boolean getNotReportReadCnt() {
        return this.notReportReadCnt;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "GProStGetFeedDetailReq{extInfo=" + this.extInfo + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",userId=" + this.userId + ",feedId=" + this.feedId + ",createTime=" + this.createTime + ",detailType=" + this.detailType + ",channelSign=" + this.channelSign + ",disableReport=" + this.disableReport + ",contentType=" + this.contentType + ",needExternalComment=" + this.needExternalComment + ",notReportReadCnt=" + this.notReportReadCnt + ",}";
    }
}
