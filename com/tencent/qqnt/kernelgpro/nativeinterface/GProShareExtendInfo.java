package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProShareExtendInfo {
    public long feedNum;
    public long guildMemberNum;
    public String shareCopywriting;

    public GProShareExtendInfo() {
        this.shareCopywriting = "";
    }

    public long getFeedNum() {
        return this.feedNum;
    }

    public long getGuildMemberNum() {
        return this.guildMemberNum;
    }

    public String getShareCopywriting() {
        return this.shareCopywriting;
    }

    public String toString() {
        return "GProShareExtendInfo{shareCopywriting=" + this.shareCopywriting + ",guildMemberNum=" + this.guildMemberNum + ",feedNum=" + this.feedNum + ",}";
    }

    public GProShareExtendInfo(String str) {
        this.shareCopywriting = str;
    }
}
