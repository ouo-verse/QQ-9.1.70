package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GuildClientIdentity {
    public int clientId;
    public String desc;
    public GuildClientIdentityBytes identityBytes;

    public GuildClientIdentity() {
        this.desc = "";
        this.identityBytes = new GuildClientIdentityBytes();
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getDesc() {
        return this.desc;
    }

    public GuildClientIdentityBytes getIdentityBytes() {
        return this.identityBytes;
    }

    public String toString() {
        return "GuildClientIdentity{clientId=" + this.clientId + ",desc=" + this.desc + ",identityBytes=" + this.identityBytes + ",}";
    }

    public GuildClientIdentity(int i3, String str, GuildClientIdentityBytes guildClientIdentityBytes) {
        this.desc = "";
        new GuildClientIdentityBytes();
        this.clientId = i3;
        this.desc = str;
        this.identityBytes = guildClientIdentityBytes;
    }
}
