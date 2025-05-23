package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_lbs_event;
import NS_MOBILE_FEEDS.s_gps;
import NS_MOBILE_FEEDS.s_user;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellLBSEvent implements SmartParcelable {

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public long eventId;

    @NeedParcel
    public s_gps gpsInfo;

    @NeedParcel
    public String actionurl = "";

    @NeedParcel
    public ArrayList<User> userInfoList = null;

    @NeedParcel
    public String desc = "";

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellLBSEvent {\n");
        sb5.append("actiontype: ");
        sb5.append(this.actiontype);
        sb5.append("\n");
        sb5.append("actionurl: ");
        sb5.append(this.actionurl);
        sb5.append("\n");
        ArrayList<User> arrayList = this.userInfoList;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < this.userInfoList.size(); i3++) {
                sb5.append("userInfoList[");
                sb5.append(i3);
                sb5.append("]: ");
                sb5.append(this.userInfoList.get(i3).toString());
                sb5.append("\n");
            }
        }
        sb5.append("gpsInfo: ");
        sb5.append(this.gpsInfo);
        sb5.append("\n");
        sb5.append("eventId: ");
        sb5.append(this.eventId);
        sb5.append("\n");
        sb5.append("desc: ");
        sb5.append(this.desc);
        sb5.append("\n");
        sb5.append("}");
        return sb5.toString();
    }

    public static CellLBSEvent create(l lVar) {
        if (lVar == null || lVar.U == null) {
            return null;
        }
        CellLBSEvent cellLBSEvent = new CellLBSEvent();
        cell_lbs_event cell_lbs_eventVar = lVar.U;
        cellLBSEvent.actiontype = cell_lbs_eventVar.actiontype;
        cellLBSEvent.actionurl = cell_lbs_eventVar.actionurl;
        ArrayList<s_user> arrayList = cell_lbs_eventVar.usersinfo;
        if (arrayList != null && arrayList.size() > 0) {
            cellLBSEvent.userInfoList = new ArrayList<>();
            for (int i3 = 0; i3 < lVar.U.usersinfo.size(); i3++) {
                User q16 = com.qzone.proxy.feedcomponent.util.e.q(lVar.U.usersinfo.get(i3));
                com.qzone.proxy.feedcomponent.util.e.c(lVar, q16);
                cellLBSEvent.userInfoList.add(q16);
            }
        }
        cell_lbs_event cell_lbs_eventVar2 = lVar.U;
        cellLBSEvent.gpsInfo = cell_lbs_eventVar2.gpsinfo;
        cellLBSEvent.eventId = cell_lbs_eventVar2.event_id;
        cellLBSEvent.desc = cell_lbs_eventVar2.desc;
        return cellLBSEvent;
    }
}
