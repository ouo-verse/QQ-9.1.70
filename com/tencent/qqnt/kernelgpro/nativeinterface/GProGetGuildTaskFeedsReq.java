package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetGuildTaskFeedsReq {
    public String attachInfo = "";
    public int count;
    public long guildId;
    public int sortOption;

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public int getCount() {
        return this.count;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getSortOption() {
        return this.sortOption;
    }

    public String toString() {
        return "GProGetGuildTaskFeedsReq{guildId=" + this.guildId + ",count=" + this.count + ",sortOption=" + this.sortOption + ",attachInfo=" + this.attachInfo + ",}";
    }
}
