package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMedalInfo implements Serializable {
    public long expireTime;
    public String iconUrl;
    public String name;
    public GProOfficialMedalInfoExt officialMedalInfoExt;
    long serialVersionUID;

    public GProMedalInfo() {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
        this.name = "";
        this.officialMedalInfoExt = new GProOfficialMedalInfoExt();
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public GProOfficialMedalInfoExt getOfficialMedalInfoExt() {
        return this.officialMedalInfoExt;
    }

    public String toString() {
        return "GProMedalInfo{iconUrl=" + this.iconUrl + ",name=" + this.name + ",expireTime=" + this.expireTime + ",officialMedalInfoExt=" + this.officialMedalInfoExt + ",}";
    }

    public GProMedalInfo(String str, String str2, long j3, GProOfficialMedalInfoExt gProOfficialMedalInfoExt) {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
        this.name = "";
        new GProOfficialMedalInfoExt();
        this.iconUrl = str;
        this.name = str2;
        this.expireTime = j3;
        this.officialMedalInfoExt = gProOfficialMedalInfoExt;
    }
}
