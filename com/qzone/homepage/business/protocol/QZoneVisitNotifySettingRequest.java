package com.qzone.homepage.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_set_visitor_notify_list_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneVisitNotifySettingRequest extends QZoneRequest {
    private static final String CMD_STRING = "setVisitorNotify";

    public QZoneVisitNotifySettingRequest(long j3, int i3, String str) {
        super(CMD_STRING);
        mobile_set_visitor_notify_list_req mobile_set_visitor_notify_list_reqVar = new mobile_set_visitor_notify_list_req();
        mobile_set_visitor_notify_list_reqVar.operation = i3;
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j3));
        mobile_set_visitor_notify_list_reqVar.fuin_vec = arrayList;
        this.req = mobile_set_visitor_notify_list_reqVar;
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
