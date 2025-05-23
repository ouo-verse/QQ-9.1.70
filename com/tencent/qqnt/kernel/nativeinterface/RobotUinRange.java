package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotUinRange {
    public long maxUin;
    public long minUin;

    public RobotUinRange() {
    }

    public long getMaxUin() {
        return this.maxUin;
    }

    public long getMinUin() {
        return this.minUin;
    }

    public String toString() {
        return "RobotUinRange{minUin=" + this.minUin + ",maxUin=" + this.maxUin + ",}";
    }

    public RobotUinRange(long j3, long j16) {
        this.minUin = j3;
        this.maxUin = j16;
    }
}
