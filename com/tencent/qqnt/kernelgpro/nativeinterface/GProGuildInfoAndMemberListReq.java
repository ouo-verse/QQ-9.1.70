package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildInfoAndMemberListReq {
    public int getNum;
    public long guildId;
    public boolean isVisitor;
    public boolean notCacheFilter;
    public long startIndex;

    public int getGetNum() {
        return this.getNum;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsVisitor() {
        return this.isVisitor;
    }

    public boolean getNotCacheFilter() {
        return this.notCacheFilter;
    }

    public long getStartIndex() {
        return this.startIndex;
    }

    public String toString() {
        return "GProGuildInfoAndMemberListReq{guildId=" + this.guildId + ",startIndex=" + this.startIndex + ",getNum=" + this.getNum + ",isVisitor=" + this.isVisitor + ",notCacheFilter=" + this.notCacheFilter + ",}";
    }
}
