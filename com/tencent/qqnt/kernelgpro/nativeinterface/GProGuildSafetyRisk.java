package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildSafetyRisk implements Serializable {
    public long bannedTimeLimit;
    public int riskLevel;
    long serialVersionUID = 1;

    public long getBannedTimeLimit() {
        return this.bannedTimeLimit;
    }

    public int getRiskLevel() {
        return this.riskLevel;
    }

    public String toString() {
        return "GProGuildSafetyRisk{riskLevel=" + this.riskLevel + ",bannedTimeLimit=" + this.bannedTimeLimit + ",}";
    }
}
