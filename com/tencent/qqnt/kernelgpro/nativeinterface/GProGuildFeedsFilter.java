package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildFeedsFilter {
    public boolean needAdv;
    public boolean needHasFeedFlag;
    public boolean needHeadAdv;
    public boolean needLive;
    public boolean needScheduler;
    public boolean needSum;
    public boolean needSysMsg;
    public boolean needTopInfo;
    public boolean needVoice;

    public boolean getNeedAdv() {
        return this.needAdv;
    }

    public boolean getNeedHasFeedFlag() {
        return this.needHasFeedFlag;
    }

    public boolean getNeedHeadAdv() {
        return this.needHeadAdv;
    }

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

    public boolean getNeedTopInfo() {
        return this.needTopInfo;
    }

    public boolean getNeedVoice() {
        return this.needVoice;
    }

    public String toString() {
        return "GProGuildFeedsFilter{needHeadAdv=" + this.needHeadAdv + ",needLive=" + this.needLive + ",needVoice=" + this.needVoice + ",needScheduler=" + this.needScheduler + ",needSysMsg=" + this.needSysMsg + ",needSum=" + this.needSum + ",needAdv=" + this.needAdv + ",needTopInfo=" + this.needTopInfo + ",needHasFeedFlag=" + this.needHasFeedFlag + ",}";
    }
}
