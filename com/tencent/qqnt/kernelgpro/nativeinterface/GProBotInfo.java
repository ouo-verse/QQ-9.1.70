package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBotInfo {
    public long appid;
    public int inlineSearch;
    public long mark;
    public String name;
    public long tinyid;
    public long uin;

    public GProBotInfo() {
        this.name = "";
    }

    public long getAppid() {
        return this.appid;
    }

    public int getInlineSearch() {
        return this.inlineSearch;
    }

    public long getMark() {
        return this.mark;
    }

    public String getName() {
        return this.name;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProBotInfo{tinyid=" + this.tinyid + ",uin=" + this.uin + ",name=" + this.name + ",inlineSearch=" + this.inlineSearch + ",appid=" + this.appid + ",mark=" + this.mark + ",}";
    }

    public GProBotInfo(long j3, long j16, String str, int i3, long j17, long j18) {
        this.tinyid = j3;
        this.uin = j16;
        this.name = str;
        this.inlineSearch = i3;
        this.appid = j17;
        this.mark = j18;
    }
}
