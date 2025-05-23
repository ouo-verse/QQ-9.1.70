package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScheduleListItem {
    public GProScheduleInfo schedule = new GProScheduleInfo();
    public int seq;
    public int totalDays;

    public GProScheduleInfo getSchedule() {
        return this.schedule;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public String toString() {
        return "GProScheduleListItem{schedule=" + this.schedule + ",seq=" + this.seq + ",totalDays=" + this.totalDays + ",}";
    }
}
