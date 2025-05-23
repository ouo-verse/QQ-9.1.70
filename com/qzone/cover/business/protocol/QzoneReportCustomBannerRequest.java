package com.qzone.cover.business.protocol;

import NS_MOBILE_MATERIAL.material_report_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneReportCustomBannerRequest extends QZoneRequest {
    private static final String CMD_STRING = "Material.Report";
    private static final String UNIKEY = "Report";

    public QzoneReportCustomBannerRequest(long j3, int i3, int i16, int i17, String str) {
        super(CMD_STRING);
        material_report_req material_report_reqVar = new material_report_req();
        material_report_reqVar.lUin = j3;
        material_report_reqVar.iOperType = i16;
        material_report_reqVar.iBannerType = i3;
        material_report_reqVar.iSource = i17;
        material_report_reqVar.strQbossTraceinfo = String.valueOf(str);
        this.req = material_report_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "Report";
    }
}
