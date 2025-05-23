package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFetchShareUrlReq {
    public long channelId;
    public long guildId;
    public long msgSeq;
    public String feedId = "";
    public ArrayList<GProURLParam> urlParams = new ArrayList<>();
    public GProFetchShareUrlFilter filter = new GProFetchShareUrlFilter();

    public long getChannelId() {
        return this.channelId;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public GProFetchShareUrlFilter getFilter() {
        return this.filter;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public ArrayList<GProURLParam> getUrlParams() {
        return this.urlParams;
    }

    public String toString() {
        return "GProFetchShareUrlReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgSeq=" + this.msgSeq + ",feedId=" + this.feedId + ",urlParams=" + this.urlParams + ",filter=" + this.filter + ",}";
    }
}
