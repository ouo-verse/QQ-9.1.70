package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProDoFeedPreferReq {
    public int action;
    public long channelId;
    public int from;
    public long guildId;
    public String feedId = "";
    public GProStCommonExt extInfo = new GProStCommonExt();

    public int getAction() {
        return this.action;
    }

    public long getChannelId() {
        return this.channelId;
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

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProDoFeedPreferReq{feedId=" + this.feedId + ",action=" + this.action + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",extInfo=" + this.extInfo + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",}";
    }
}
