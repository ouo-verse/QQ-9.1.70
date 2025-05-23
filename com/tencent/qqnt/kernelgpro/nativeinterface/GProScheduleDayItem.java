package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProScheduleDayItem {
    public long dateMs;
    public ArrayList<GProScheduleListItem> scheduleListItems = new ArrayList<>();

    public long getDateMs() {
        return this.dateMs;
    }

    public ArrayList<GProScheduleListItem> getScheduleListItems() {
        return this.scheduleListItems;
    }

    public String toString() {
        return "GProScheduleDayItem{dateMs=" + this.dateMs + ",scheduleListItems=" + this.scheduleListItems + ",}";
    }
}
