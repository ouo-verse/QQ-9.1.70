package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildNumInfo {
    public long leftTime;
    public String name = "";
    public int status;

    public long getLeftTime() {
        return this.leftTime;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GProGuildNumInfo{name=" + this.name + ",status=" + this.status + ",leftTime=" + this.leftTime + ",}";
    }
}
