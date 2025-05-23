package com.qzone.common.protocol.request;

import NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_REQ;
import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtDcReportRequest extends QZoneRequest {
    private static final String CMD = "update.ClientReport";
    private static final String UNI_KEY = "ClientReport";

    public GdtDcReportRequest(ArrayList<REPORT_INFO> arrayList, int i3) {
        super(CMD);
        CLIENT_REPORT_REQ client_report_req = new CLIENT_REPORT_REQ();
        client_report_req.type = i3;
        client_report_req.multi_info = arrayList;
        this.req = client_report_req;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return CMD;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "ClientReport";
    }
}
