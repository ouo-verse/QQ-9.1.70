package com.qzone.homepage.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_setspecial_req;
import NS_MOBILE_MAIN_PAGE.s_special;
import NS_MOBILE_MAIN_PAGE.s_user;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneSetSpecialCareRequest extends QZoneRequest {
    private static final String CMD_STRING = "setCareList";

    public QZoneSetSpecialCareRequest(long j3, int i3) {
        super(CMD_STRING);
        mobile_sub_setspecial_req mobile_sub_setspecial_reqVar = new mobile_sub_setspecial_req();
        s_user s_userVar = new s_user();
        s_userVar.uin = j3;
        s_special s_specialVar = new s_special();
        s_specialVar.allnum = 1;
        ArrayList<s_user> arrayList = new ArrayList<>();
        s_specialVar.datalist = arrayList;
        arrayList.add(s_userVar);
        mobile_sub_setspecial_reqVar.action = i3;
        mobile_sub_setspecial_reqVar.special = s_specialVar;
        this.req = mobile_sub_setspecial_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
