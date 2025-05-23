package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProGetProfileFeedsReq {
    public int count;
    public String feedAttchInfo = "";
    public int from;
    public long guildId;
    public int listType;
    public long uid;
    public long uin;

    public int getCount() {
        return this.count;
    }

    public String getFeedAttchInfo() {
        return this.feedAttchInfo;
    }

    public int getFrom() {
        return this.from;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getListType() {
        return this.listType;
    }

    public long getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProGetProfileFeedsReq{count=" + this.count + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",feedAttchInfo=" + this.feedAttchInfo + ",listType=" + this.listType + ",guildId=" + this.guildId + ",uid=" + this.uid + ",uin=" + this.uin + ",}";
    }
}
