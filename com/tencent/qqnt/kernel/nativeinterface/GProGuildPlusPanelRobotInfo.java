package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildPlusPanelRobotInfo {
    public long appid;
    public String avatar;
    public int inlineSearch;
    public long mark;
    public String name;
    public long tinyid;
    public String uid;
    public long uin;

    public GProGuildPlusPanelRobotInfo() {
        this.name = "";
        this.uid = "";
        this.avatar = "";
    }

    public long getAppid() {
        return this.appid;
    }

    public String getAvatar() {
        return this.avatar;
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

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProGuildPlusPanelRobotInfo{tinyid=" + this.tinyid + ",uin=" + this.uin + ",name=" + this.name + ",inlineSearch=" + this.inlineSearch + ",appid=" + this.appid + ",mark=" + this.mark + ",uid=" + this.uid + ",avatar=" + this.avatar + ",}";
    }

    public GProGuildPlusPanelRobotInfo(long j3, long j16, String str, int i3, long j17, long j18, String str2, String str3) {
        this.tinyid = j3;
        this.uin = j16;
        this.name = str;
        this.inlineSearch = i3;
        this.appid = j17;
        this.mark = j18;
        this.uid = str2;
        this.avatar = str3;
    }
}
