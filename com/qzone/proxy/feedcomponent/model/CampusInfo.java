package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_campus_info;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CampusInfo implements SmartParcelable {

    @NeedParcel
    public int eVerfyStatus;

    @NeedParcel
    public String strSchoolName;

    public static CampusInfo create(s_campus_info s_campus_infoVar) {
        if (s_campus_infoVar == null) {
            return null;
        }
        CampusInfo campusInfo = new CampusInfo();
        campusInfo.strSchoolName = s_campus_infoVar.strSchoolName;
        campusInfo.eVerfyStatus = s_campus_infoVar.eVerfyStatus;
        return campusInfo;
    }
}
