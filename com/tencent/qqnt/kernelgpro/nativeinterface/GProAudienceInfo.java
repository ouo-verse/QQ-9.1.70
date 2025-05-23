package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAudienceInfo implements Serializable {
    public long uin;
    long serialVersionUID = 1;
    public String icon = "";
    public String avatarMeta = "";

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getIcon() {
        return this.icon;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GProAudienceInfo{uin=" + this.uin + ",icon=" + this.icon + ",avatarMeta=" + this.avatarMeta + ",}";
    }
}
