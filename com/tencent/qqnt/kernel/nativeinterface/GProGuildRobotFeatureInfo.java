package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotFeatureInfo {
    public String availableRangeDesc;
    public String desc;

    /* renamed from: id, reason: collision with root package name */
    public int f359174id;
    public String name;
    public int status;

    public GProGuildRobotFeatureInfo() {
        this.name = "";
        this.desc = "";
        this.availableRangeDesc = "";
    }

    public String getAvailableRangeDesc() {
        return this.availableRangeDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getId() {
        return this.f359174id;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GProGuildRobotFeatureInfo{id=" + this.f359174id + ",name=" + this.name + ",desc=" + this.desc + ",status=" + this.status + ",availableRangeDesc=" + this.availableRangeDesc + ",}";
    }

    public GProGuildRobotFeatureInfo(int i3, String str, String str2, int i16, String str3) {
        this.f359174id = i3;
        this.name = str;
        this.desc = str2;
        this.status = i16;
        this.availableRangeDesc = str3;
    }
}
