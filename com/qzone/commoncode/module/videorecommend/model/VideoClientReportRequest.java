package com.qzone.commoncode.module.videorecommend.model;

import NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_REQ;
import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoClientReportRequest extends QZoneRequest {
    private static final String CMD = "update.ClientReport";
    private static final String UNI_KEY = "ClientReport";

    public VideoClientReportRequest(int i3, Map<String, String> map, ArrayList<REPORT_INFO> arrayList) {
        super(CMD);
        this.req = new CLIENT_REPORT_REQ(i3, null, map, arrayList);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return CMD;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "ClientReport";
    }

    public VideoClientReportRequest(int i3, ArrayList<Map<String, String>> arrayList, Map<String, String> map) {
        super(CMD);
        this.req = new CLIENT_REPORT_REQ(i3, arrayList, map, null);
    }

    public VideoClientReportRequest(ArrayList<Map<String, String>> arrayList, int i3) {
        super(CMD);
        CLIENT_REPORT_REQ client_report_req = new CLIENT_REPORT_REQ();
        client_report_req.type = i3;
        client_report_req.info = arrayList;
        this.req = client_report_req;
    }
}
