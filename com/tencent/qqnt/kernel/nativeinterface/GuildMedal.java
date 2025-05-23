package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GuildMedal {
    public long endTime;
    public long startTime;
    public String url = "";
    public String desc = "";

    public String getDesc() {
        return this.desc;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GuildMedal{startTime=" + this.startTime + ",endTime=" + this.endTime + JefsClass.INDEX_URL + this.url + ",desc=" + this.desc + ",}";
    }
}
