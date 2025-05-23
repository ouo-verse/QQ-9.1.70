package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGetFeedCalendarRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGetFeedCalendarRspFeedCalendarEntry;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildSearchGetFeedCalendarRsp implements IGProGuildSearchGetFeedCalendarRsp {
    public final GProGuildSearchGetFeedCalendarRsp mInfo;

    public GGProGuildSearchGetFeedCalendarRsp(GProGuildSearchGetFeedCalendarRsp gProGuildSearchGetFeedCalendarRsp) {
        this.mInfo = gProGuildSearchGetFeedCalendarRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGetFeedCalendarRsp
    public ArrayList<IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry> getFeedCalendarList() {
        ArrayList<GProGuildSearchGetFeedCalendarRspFeedCalendarEntry> feedCalendarList = this.mInfo.getFeedCalendarList();
        ArrayList<IGProGuildSearchGetFeedCalendarRspFeedCalendarEntry> arrayList = new ArrayList<>();
        Iterator<GProGuildSearchGetFeedCalendarRspFeedCalendarEntry> it = feedCalendarList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildSearchGetFeedCalendarRspFeedCalendarEntry(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGetFeedCalendarRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
