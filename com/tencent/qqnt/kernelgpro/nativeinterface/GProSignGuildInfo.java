package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* loaded from: classes24.dex */
public final class GProSignGuildInfo {
    public long endTime;
    public long guildId;
    public long startTime;
    public String guildName = "";
    public String url = "";
    public String desc = "";

    public String getDesc() {
        return this.desc;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProSignGuildInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",startTime=" + this.startTime + ",endTime=" + this.endTime + JefsClass.INDEX_URL + this.url + ",desc=" + this.desc + ",}";
    }
}
