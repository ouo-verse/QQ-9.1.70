package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStGetChannelFeedsReq {
    public int contentType;
    public int count;
    public int from;
    public boolean needChannelList;
    public int sortOption;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStChannelSign channelSign = new GProStChannelSign();
    public String feedAttchInfo = "";
    public ArrayList<byte[]> groupTransDataList = new ArrayList<>();

    public GProStChannelSign getChannelSign() {
        return this.channelSign;
    }

    public int getContentType() {
        return this.contentType;
    }

    public int getCount() {
        return this.count;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public String getFeedAttchInfo() {
        return this.feedAttchInfo;
    }

    public int getFrom() {
        return this.from;
    }

    public ArrayList<byte[]> getGroupTransDataList() {
        return this.groupTransDataList;
    }

    public boolean getNeedChannelList() {
        return this.needChannelList;
    }

    public int getSortOption() {
        return this.sortOption;
    }

    public String toString() {
        return "GProStGetChannelFeedsReq{extInfo=" + this.extInfo + ",count=" + this.count + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",channelSign=" + this.channelSign + ",feedAttchInfo=" + this.feedAttchInfo + ",sortOption=" + this.sortOption + ",groupTransDataList=" + this.groupTransDataList + ",needChannelList=" + this.needChannelList + ",contentType=" + this.contentType + ",}";
    }
}
