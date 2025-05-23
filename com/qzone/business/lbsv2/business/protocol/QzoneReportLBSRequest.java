package com.qzone.business.lbsv2.business.protocol;

import LBS_V2_PROTOCOL.ReportLBSInfo;
import LBS_V2_PROTOCOL.ReportLBSReq;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.util.l;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneReportLBSRequest extends QZoneRequest {
    private static final String CMD_STRING = "reportUserPoiAct";

    public QzoneReportLBSRequest(String str, long j3, String str2, int i3, int i16, String str3, int i17, int i18, String str4, String str5, String str6, String str7) {
        super(CMD_STRING);
        ReportLBSReq reportLBSReq = new ReportLBSReq();
        ReportLBSInfo reportLBSInfo = new ReportLBSInfo();
        reportLBSInfo.request_id = str;
        reportLBSInfo.time = j3;
        reportLBSInfo.data_id = str2;
        reportLBSInfo.idx = i3;
        reportLBSInfo.ref = i16;
        reportLBSInfo.ref_ver = str3;
        reportLBSInfo.iLat = i17;
        reportLBSInfo.iLon = i18;
        reportLBSInfo.dev = str4;
        reportLBSInfo.f24909os = str5;
        reportLBSInfo.os_ver = str6;
        reportLBSInfo.lang = str7;
        reportLBSInfo.other = l.a(R.string.s7t);
        reportLBSReq.stReportInfo = reportLBSInfo;
        this.req = reportLBSReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getRequestCmd();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
