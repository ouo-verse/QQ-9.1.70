package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSearchGetFeedCalendarRsp {
    public ArrayList<GProGuildSearchGetFeedCalendarRspFeedCalendarEntry> feedCalendarList = new ArrayList<>();

    public ArrayList<GProGuildSearchGetFeedCalendarRspFeedCalendarEntry> getFeedCalendarList() {
        return this.feedCalendarList;
    }

    public String toString() {
        return "GProGuildSearchGetFeedCalendarRsp{feedCalendarList=" + this.feedCalendarList + ",}";
    }
}
