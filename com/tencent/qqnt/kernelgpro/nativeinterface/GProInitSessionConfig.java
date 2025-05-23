package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProInitSessionConfig {

    /* renamed from: a2, reason: collision with root package name */
    public String f359293a2;
    public String clientVer;

    /* renamed from: d2, reason: collision with root package name */
    public String f359294d2;
    public String d2Key;
    public String gproDBName;
    public String selfUid;
    public long selfUin;

    public GProInitSessionConfig() {
        this.selfUid = "";
        this.clientVer = "";
        this.f359293a2 = "";
        this.f359294d2 = "";
        this.d2Key = "";
    }

    public String getA2() {
        return this.f359293a2;
    }

    public String getClientVer() {
        return this.clientVer;
    }

    public String getD2() {
        return this.f359294d2;
    }

    public String getD2Key() {
        return this.d2Key;
    }

    public String getGproDBName() {
        return this.gproDBName;
    }

    public String getSelfUid() {
        return this.selfUid;
    }

    public long getSelfUin() {
        return this.selfUin;
    }

    public String toString() {
        return "GProInitSessionConfig{selfUin=" + this.selfUin + ",selfUid=" + this.selfUid + ",gproDBName=" + this.gproDBName + ",clientVer=" + this.clientVer + ",a2=" + this.f359293a2 + ",d2=" + this.f359294d2 + ",d2Key=" + this.d2Key + ",}";
    }

    public GProInitSessionConfig(long j3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.selfUin = j3;
        this.selfUid = str;
        this.gproDBName = str2;
        this.clientVer = str3;
        this.f359293a2 = str4;
        this.f359294d2 = str5;
        this.d2Key = str6;
    }
}
