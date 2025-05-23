package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMedal implements Serializable {
    public String desc;
    public long endTime;
    long serialVersionUID;
    public long startTime;
    public String url;

    public GProMedal() {
        this.serialVersionUID = 1L;
        this.url = "";
        this.desc = "";
    }

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
        return "GProMedal{startTime=" + this.startTime + ",endTime=" + this.endTime + JefsClass.INDEX_URL + this.url + ",desc=" + this.desc + ",}";
    }

    public GProMedal(long j3, long j16, String str, String str2) {
        this.serialVersionUID = 1L;
        this.startTime = j3;
        this.endTime = j16;
        this.url = str;
        this.desc = str2;
    }
}
