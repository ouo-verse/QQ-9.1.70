package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStIconInfo implements Serializable {
    long serialVersionUID = 1;
    public String iconUrl40 = "";
    public String iconUrl100 = "";
    public String iconUrl140 = "";
    public String iconUrl640 = "";
    public String iconUrl = "";
    public byte[] avatarMeta = new byte[0];

    public byte[] getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getIconUrl100() {
        return this.iconUrl100;
    }

    public String getIconUrl140() {
        return this.iconUrl140;
    }

    public String getIconUrl40() {
        return this.iconUrl40;
    }

    public String getIconUrl640() {
        return this.iconUrl640;
    }

    public String toString() {
        return "GProStIconInfo{iconUrl40=" + this.iconUrl40 + ",iconUrl100=" + this.iconUrl100 + ",iconUrl140=" + this.iconUrl140 + ",iconUrl640=" + this.iconUrl640 + ",iconUrl=" + this.iconUrl + ",avatarMeta=" + this.avatarMeta + ",}";
    }
}
