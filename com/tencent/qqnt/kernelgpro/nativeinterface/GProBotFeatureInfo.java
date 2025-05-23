package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProBotFeatureInfo {
    public String availableRangeDesc;
    public String desc;

    /* renamed from: id, reason: collision with root package name */
    public int f359282id;
    public long mark;
    public String name;
    public int status;
    public int type;
    public String url;

    public GProBotFeatureInfo() {
        this.name = "";
        this.desc = "";
        this.url = "";
        this.availableRangeDesc = "";
    }

    public String getAvailableRangeDesc() {
        return this.availableRangeDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getId() {
        return this.f359282id;
    }

    public long getMark() {
        return this.mark;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProBotFeatureInfo{id=" + this.f359282id + ",name=" + this.name + ",desc=" + this.desc + ",status=" + this.status + JefsClass.INDEX_URL + this.url + ",type=" + this.type + ",availableRangeDesc=" + this.availableRangeDesc + ",mark=" + this.mark + ",}";
    }

    public GProBotFeatureInfo(int i3, String str, String str2, int i16, String str3, int i17, String str4, long j3) {
        this.f359282id = i3;
        this.name = str;
        this.desc = str2;
        this.status = i16;
        this.url = str3;
        this.type = i17;
        this.availableRangeDesc = str4;
        this.mark = j3;
    }
}
