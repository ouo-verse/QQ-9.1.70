package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OSAggregationCellModel {
    public String nick;
    public long setTime;
    public String uid;
    public long uin;

    public OSAggregationCellModel() {
        this.uid = "";
        this.nick = "";
    }

    public String getNick() {
        return this.nick;
    }

    public long getSetTime() {
        return this.setTime;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "OSAggregationCellModel{uin=" + this.uin + ",uid=" + this.uid + ",nick=" + this.nick + ",setTime=" + this.setTime + ",}";
    }

    public OSAggregationCellModel(long j3, String str, String str2, long j16) {
        this.uin = j3;
        this.uid = str;
        this.nick = str2;
        this.setTime = j16;
    }
}
