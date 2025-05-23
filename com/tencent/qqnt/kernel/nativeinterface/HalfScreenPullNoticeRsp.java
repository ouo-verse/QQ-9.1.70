package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class HalfScreenPullNoticeRsp {
    public HalfScreenNotice halfScreenNotice = new HalfScreenNotice();
    public long nextIntervalTs;

    public HalfScreenNotice getHalfScreenNotice() {
        return this.halfScreenNotice;
    }

    public long getNextIntervalTs() {
        return this.nextIntervalTs;
    }

    public String toString() {
        return "HalfScreenPullNoticeRsp{nextIntervalTs=" + this.nextIntervalTs + ",halfScreenNotice=" + this.halfScreenNotice + ",}";
    }
}
