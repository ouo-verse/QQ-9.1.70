package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelMedalInfo implements Serializable {
    public long expireTime;
    long serialVersionUID = 1;
    public String iconUrl = "";
    public String name = "";

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProChannelMedalInfo{iconUrl=" + this.iconUrl + ",name=" + this.name + ",expireTime=" + this.expireTime + ",}";
    }
}
