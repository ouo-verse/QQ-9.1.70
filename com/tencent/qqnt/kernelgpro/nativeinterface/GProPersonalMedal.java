package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPersonalMedal implements Serializable {
    public long endTime;
    public long startTime;
    long serialVersionUID = 1;
    public String url = "";

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
        return "GProPersonalMedal{startTime=" + this.startTime + ",endTime=" + this.endTime + JefsClass.INDEX_URL + this.url + ",}";
    }
}
