package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildIdentity {
    public long appid;
    public String orgID;
    public String worldID;

    public GProGuildIdentity() {
        this.orgID = "";
        this.worldID = "";
    }

    public long getAppid() {
        return this.appid;
    }

    public String getOrgID() {
        return this.orgID;
    }

    public String getWorldID() {
        return this.worldID;
    }

    public String toString() {
        return "GProGuildIdentity{appid=" + this.appid + ",orgID=" + this.orgID + ",worldID=" + this.worldID + ",}";
    }

    public GProGuildIdentity(long j3, String str, String str2) {
        this.appid = j3;
        this.orgID = str;
        this.worldID = str2;
    }
}
