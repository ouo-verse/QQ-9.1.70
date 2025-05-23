package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSetGlobalPermissionReq {
    public int authType;
    public long guildId;
    public int value;

    public int getAuthType() {
        return this.authType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "GProSetGlobalPermissionReq{guildId=" + this.guildId + ",authType=" + this.authType + ",value=" + this.value + ",}";
    }
}
