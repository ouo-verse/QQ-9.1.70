package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGetFeedCalendarRspFeedCalendarEntry;

/* loaded from: classes17.dex */
public class GGProGuildSearchGetFeedCalendarRspFeedCalendarEntry implements IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry {
    public final GProGuildSearchGetFeedCalendarRspFeedCalendarEntry mInfo;

    public GGProGuildSearchGetFeedCalendarRspFeedCalendarEntry(GProGuildSearchGetFeedCalendarRspFeedCalendarEntry gProGuildSearchGetFeedCalendarRspFeedCalendarEntry) {
        this.mInfo = gProGuildSearchGetFeedCalendarRspFeedCalendarEntry;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry
    public String getDate() {
        return this.mInfo.getDate();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry
    public int getFeedCount() {
        return this.mInfo.getFeedCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry
    public String toString() {
        return this.mInfo.toString();
    }
}
