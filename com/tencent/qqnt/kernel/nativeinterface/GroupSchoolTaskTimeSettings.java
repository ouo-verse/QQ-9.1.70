package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolTaskTimeSettings {
    public int checkinWeekdays;
    public int cycle;

    public GroupSchoolTaskTimeSettings() {
    }

    public int getCheckinWeekdays() {
        return this.checkinWeekdays;
    }

    public int getCycle() {
        return this.cycle;
    }

    public String toString() {
        return "GroupSchoolTaskTimeSettings{cycle=" + this.cycle + ",checkinWeekdays=" + this.checkinWeekdays + ",}";
    }

    public GroupSchoolTaskTimeSettings(int i3, int i16) {
        this.cycle = i3;
        this.checkinWeekdays = i16;
    }
}
