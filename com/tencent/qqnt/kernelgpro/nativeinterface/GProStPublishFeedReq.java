package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStPublishFeedReq {
    public int from;
    public boolean needCreateOwnGuild;
    public boolean needSyncGroup;
    public int src;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStFeed feed = new GProStFeed();
    public byte[] busiReqData = new byte[0];
    public ArrayList<GProFeedEntry> storeFeedExtInfoList = new ArrayList<>();
    public String jsonFeed = "";
    public GProStClientContent clientContent = new GProStClientContent();
    public GProHttpReqInfo httpReqInfo = new GProHttpReqInfo();

    public byte[] getBusiReqData() {
        return this.busiReqData;
    }

    public GProStClientContent getClientContent() {
        return this.clientContent;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProStFeed getFeed() {
        return this.feed;
    }

    public int getFrom() {
        return this.from;
    }

    public GProHttpReqInfo getHttpReqInfo() {
        return this.httpReqInfo;
    }

    public String getJsonFeed() {
        return this.jsonFeed;
    }

    public boolean getNeedCreateOwnGuild() {
        return this.needCreateOwnGuild;
    }

    public boolean getNeedSyncGroup() {
        return this.needSyncGroup;
    }

    public int getSrc() {
        return this.src;
    }

    public ArrayList<GProFeedEntry> getStoreFeedExtInfoList() {
        return this.storeFeedExtInfoList;
    }

    public String toString() {
        return "GProStPublishFeedReq{extInfo=" + this.extInfo + ",feed=" + this.feed + ",busiReqData=" + this.busiReqData + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",src=" + this.src + ",storeFeedExtInfoList=" + this.storeFeedExtInfoList + ",jsonFeed=" + this.jsonFeed + ",clientContent=" + this.clientContent + ",needSyncGroup=" + this.needSyncGroup + ",needCreateOwnGuild=" + this.needCreateOwnGuild + ",httpReqInfo=" + this.httpReqInfo + ",}";
    }
}
