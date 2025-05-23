package com.qzone.proxy.personalitycomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetVisitorsData {
    public long uin;
    public int today_delta = 0;
    public int today_visitor = 0;
    public int total_visitor = 0;
    public int blocked_visitor_count = 0;
    public int cachetime = 0;
    public int updatetime = 0;
    public int namePlateFlag = 0;
    public int needRedPacket = 0;
    public ArrayList<WidgetVistor> deltaList = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class WidgetVistor implements SmartParcelable {

        @NeedParcel
        public long uin = 0;

        @NeedParcel
        public int visit_time = 0;
    }

    public String toString() {
        return "today_delta = " + this.today_delta + " today_visitor = " + this.today_visitor + " total_visitor = " + this.total_visitor + " blocked_visitor_count = " + this.blocked_visitor_count;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WidgetVisitorsData)) {
            return false;
        }
        WidgetVisitorsData widgetVisitorsData = (WidgetVisitorsData) obj;
        return widgetVisitorsData.today_delta == this.today_delta && widgetVisitorsData.today_visitor == this.today_visitor && widgetVisitorsData.total_visitor == this.total_visitor && widgetVisitorsData.blocked_visitor_count == this.blocked_visitor_count && widgetVisitorsData.namePlateFlag == this.namePlateFlag && widgetVisitorsData.needRedPacket == this.needRedPacket;
    }
}
