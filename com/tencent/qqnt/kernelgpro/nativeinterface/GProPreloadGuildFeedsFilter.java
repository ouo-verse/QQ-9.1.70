package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPreloadGuildFeedsFilter {
    public boolean needLive;
    public boolean needScheduler;
    public boolean needSum;
    public boolean needSysMsg;
    public boolean needVoice;

    public boolean getNeedLive() {
        return this.needLive;
    }

    public boolean getNeedScheduler() {
        return this.needScheduler;
    }

    public boolean getNeedSum() {
        return this.needSum;
    }

    public boolean getNeedSysMsg() {
        return this.needSysMsg;
    }

    public boolean getNeedVoice() {
        return this.needVoice;
    }

    public String toString() {
        return "GProPreloadGuildFeedsFilter{needLive=" + this.needLive + ",needVoice=" + this.needVoice + ",needScheduler=" + this.needScheduler + ",needSysMsg=" + this.needSysMsg + ",needSum=" + this.needSum + ",}";
    }
}
