package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProGuildRobotPlusPanelFeatureInfo {
    public String availableRangeDesc;
    public String desc;
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    public int f359176id;
    public long mark;
    public String name;
    public String schemaUrl;
    public int status;
    public int type;
    public String url;

    public GProGuildRobotPlusPanelFeatureInfo() {
        this.name = "";
        this.desc = "";
        this.url = "";
        this.availableRangeDesc = "";
        this.icon = "";
        this.schemaUrl = "";
    }

    public String getAvailableRangeDesc() {
        return this.availableRangeDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.f359176id;
    }

    public long getMark() {
        return this.mark;
    }

    public String getName() {
        return this.name;
    }

    public String getSchemaUrl() {
        return this.schemaUrl;
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
        return "GProGuildRobotPlusPanelFeatureInfo{id=" + this.f359176id + ",name=" + this.name + ",desc=" + this.desc + ",status=" + this.status + JefsClass.INDEX_URL + this.url + ",type=" + this.type + ",availableRangeDesc=" + this.availableRangeDesc + ",mark=" + this.mark + ",icon=" + this.icon + ",schemaUrl=" + this.schemaUrl + ",}";
    }

    public GProGuildRobotPlusPanelFeatureInfo(int i3, String str, String str2, int i16, String str3, int i17, String str4, long j3, String str5, String str6) {
        this.f359176id = i3;
        this.name = str;
        this.desc = str2;
        this.status = i16;
        this.url = str3;
        this.type = i17;
        this.availableRangeDesc = str4;
        this.mark = j3;
        this.icon = str5;
        this.schemaUrl = str6;
    }
}
