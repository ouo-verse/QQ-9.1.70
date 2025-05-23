package com.qzone.misc.network.report;

import NS_MOBILE_EXTRA.mobile_visit_report_req;
import NS_MOBILE_EXTRA.s_visit_record;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneFeedVisitorRptRequest extends QZoneRequest {
    public static final String CMD_STRING = "visitReport";

    public QzoneFeedVisitorRptRequest(ArrayList<s_visit_record> arrayList) {
        super(CMD_STRING);
        this.req = new mobile_visit_report_req(arrayList);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return CMD_STRING;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
