package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CustomWithdrawConfig {
    public int configVersion;
    public long msgBegin;
    public long msgEnd;
    public long withdrawBegin;
    public long withdrawEnd;

    public CustomWithdrawConfig() {
    }

    public int getConfigVersion() {
        return this.configVersion;
    }

    public long getMsgBegin() {
        return this.msgBegin;
    }

    public long getMsgEnd() {
        return this.msgEnd;
    }

    public long getWithdrawBegin() {
        return this.withdrawBegin;
    }

    public long getWithdrawEnd() {
        return this.withdrawEnd;
    }

    public String toString() {
        return "CustomWithdrawConfig{withdrawBegin=" + this.withdrawBegin + ",withdrawEnd=" + this.withdrawEnd + ",msgBegin=" + this.msgBegin + ",msgEnd=" + this.msgEnd + ",configVersion=" + this.configVersion + ",}";
    }

    public CustomWithdrawConfig(long j3, long j16, long j17, long j18, int i3) {
        this.withdrawBegin = j3;
        this.withdrawEnd = j16;
        this.msgBegin = j17;
        this.msgEnd = j18;
        this.configVersion = i3;
    }
}
