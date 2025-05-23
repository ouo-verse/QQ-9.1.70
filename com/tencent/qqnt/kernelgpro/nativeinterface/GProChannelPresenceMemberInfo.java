package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelPresenceMemberInfo implements Serializable {
    public String bytesAvatarMeta;
    long serialVersionUID;
    public long tinyId;

    public GProChannelPresenceMemberInfo() {
        this.serialVersionUID = 1L;
        this.bytesAvatarMeta = "";
    }

    public String getBytesAvatarMeta() {
        return this.bytesAvatarMeta;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProChannelPresenceMemberInfo{tinyId=" + this.tinyId + ",bytesAvatarMeta=" + this.bytesAvatarMeta + ",}";
    }

    public GProChannelPresenceMemberInfo(long j3, String str) {
        this.serialVersionUID = 1L;
        this.tinyId = j3;
        this.bytesAvatarMeta = str;
    }
}
