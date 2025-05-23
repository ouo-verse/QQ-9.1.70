package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InitCommAbilitySessionConfig {
    public String selfUid;
    public long selfUin;
    public String sysPath;

    public InitCommAbilitySessionConfig() {
        this.selfUid = "";
        this.sysPath = "";
    }

    public String getSelfUid() {
        return this.selfUid;
    }

    public long getSelfUin() {
        return this.selfUin;
    }

    public String getSysPath() {
        return this.sysPath;
    }

    public InitCommAbilitySessionConfig(long j3, String str, String str2) {
        this.selfUin = j3;
        this.selfUid = str;
        this.sysPath = str2;
    }
}
