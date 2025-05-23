package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStAlterFeedReq {
    public int from;
    public long mBitmap;
    public int src;
    public int updateTopStatus;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStFeed feed = new GProStFeed();
    public byte[] busiReqData = new byte[0];
    public ArrayList<GProFeedEntry> alterFeedExtInfoList = new ArrayList<>();
    public String jsonFeed = "";
    public GProStClientContent clientContent = new GProStClientContent();
    public GProHttpReqInfo httpReqInfo = new GProHttpReqInfo();

    public ArrayList<GProFeedEntry> getAlterFeedExtInfoList() {
        return this.alterFeedExtInfoList;
    }

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

    public long getMBitmap() {
        return this.mBitmap;
    }

    public int getSrc() {
        return this.src;
    }

    public int getUpdateTopStatus() {
        return this.updateTopStatus;
    }

    public String toString() {
        return "GProStAlterFeedReq{extInfo=" + this.extInfo + ",feed=" + this.feed + ",busiReqData=" + this.busiReqData + ",mBitmap=" + this.mBitmap + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",src=" + this.src + ",alterFeedExtInfoList=" + this.alterFeedExtInfoList + ",jsonFeed=" + this.jsonFeed + ",clientContent=" + this.clientContent + ",updateTopStatus=" + this.updateTopStatus + ",httpReqInfo=" + this.httpReqInfo + ",}";
    }
}
