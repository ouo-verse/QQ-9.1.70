package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class JoinGroupVerifyRsp {
    public int highRiskGroup;
    public int noVerify;

    public int getHighRiskGroup() {
        return this.highRiskGroup;
    }

    public int getNoVerify() {
        return this.noVerify;
    }

    public String toString() {
        return "JoinGroupVerifyRsp{noVerify=" + this.noVerify + ",highRiskGroup=" + this.highRiskGroup + ",}";
    }
}
