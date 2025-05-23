package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_profile_calendar;
import NS_MOBILE_FEEDS.s_profile_timeline;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ProfileCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes39.dex */
public class ProfileTimeLine implements Serializable {
    public HashMap<Integer, ArrayList<Integer>> timeLines;

    public static ProfileTimeLine createFromPb(com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ProfileTimeLine profileTimeLine) {
        Map<Integer, ProfileCalendar> map;
        ProfileTimeLine profileTimeLine2 = new ProfileTimeLine();
        profileTimeLine2.timeLines = new HashMap<>();
        if (profileTimeLine != null && (map = profileTimeLine.mapTimeline) != null) {
            for (Integer num : map.keySet()) {
                if (num != null) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.addAll(profileTimeLine.mapTimeline.get(num).month);
                    profileTimeLine2.timeLines.put(num, arrayList);
                }
            }
        }
        return profileTimeLine2;
    }

    public static ProfileTimeLine createFromResponse(s_profile_timeline s_profile_timelineVar) {
        Map<Integer, ArrayList<s_profile_calendar>> map;
        ProfileTimeLine profileTimeLine = new ProfileTimeLine();
        profileTimeLine.timeLines = new HashMap<>();
        if (s_profile_timelineVar != null && (map = s_profile_timelineVar.map_timeline) != null) {
            for (Integer num : map.keySet()) {
                if (num != null) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    ArrayList<s_profile_calendar> arrayList2 = s_profile_timelineVar.map_timeline.get(num);
                    if (arrayList2 != null) {
                        Iterator<s_profile_calendar> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            s_profile_calendar next = it.next();
                            if (next != null) {
                                arrayList.add(Integer.valueOf(next.month));
                            }
                        }
                    }
                    profileTimeLine.timeLines.put(num, arrayList);
                }
            }
        }
        return profileTimeLine;
    }
}
