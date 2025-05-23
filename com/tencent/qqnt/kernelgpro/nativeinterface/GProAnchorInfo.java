package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAnchorInfo implements Serializable {
    public long idVerifyTimestamp;
    public long tinyId;
    long serialVersionUID = 1;
    public String anchorName = "";
    public String anchorIcon = "";
    public String avatarMeta = "";

    public String getAnchorIcon() {
        return this.anchorIcon;
    }

    public String getAnchorName() {
        return this.anchorName;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public long getIdVerifyTimestamp() {
        return this.idVerifyTimestamp;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProAnchorInfo{anchorName=" + this.anchorName + ",anchorIcon=" + this.anchorIcon + ",idVerifyTimestamp=" + this.idVerifyTimestamp + ",tinyId=" + this.tinyId + ",avatarMeta=" + this.avatarMeta + ",}";
    }
}
