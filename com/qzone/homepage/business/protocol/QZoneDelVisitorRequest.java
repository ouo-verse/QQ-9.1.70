package com.qzone.homepage.business.protocol;

import NS_MOBILE_MAIN_PAGE.mobile_sub_del_visit_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneDelVisitorRequest extends QZoneRequest {
    private static final String DEL_CMD = "delMainVisit";

    public QZoneDelVisitorRequest(long j3, long j16, byte b16, long j17, byte b17) {
        super(DEL_CMD);
        mobile_sub_del_visit_req mobile_sub_del_visit_reqVar = new mobile_sub_del_visit_req();
        mobile_sub_del_visit_reqVar.uin = j3;
        mobile_sub_del_visit_reqVar.hostUin = j16;
        mobile_sub_del_visit_reqVar.source = b16;
        mobile_sub_del_visit_reqVar.vtime = j17;
        mobile_sub_del_visit_reqVar.mod = b17;
        this.req = mobile_sub_del_visit_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return DEL_CMD;
    }

    public QZoneDelVisitorRequest(long j3, long j16, byte b16, long j17, byte b17, String str, boolean z16) {
        super(DEL_CMD);
        mobile_sub_del_visit_req mobile_sub_del_visit_reqVar = new mobile_sub_del_visit_req();
        mobile_sub_del_visit_reqVar.uin = j3;
        mobile_sub_del_visit_reqVar.hostUin = j16;
        mobile_sub_del_visit_reqVar.source = b16;
        mobile_sub_del_visit_reqVar.vtime = j17;
        mobile_sub_del_visit_reqVar.mod = b17;
        mobile_sub_del_visit_reqVar.contentid = str;
        mobile_sub_del_visit_reqVar.add_to_hidelist = z16;
        this.req = mobile_sub_del_visit_reqVar;
    }

    public QZoneDelVisitorRequest() {
    }
}
