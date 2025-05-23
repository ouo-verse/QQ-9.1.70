package com.qzone.publish.business.protocol;

import NS_MOBILE_EXTRA.mobile_ss_recom_pic_report_req;
import NS_MOBILE_EXTRA.mobile_ss_recom_pic_report_rsp;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneReportMoodEggOprationRequest extends QZoneRequest {
    private static final String CMD_STRING = "Extra.reportSSRecomPicOp";
    private static final String UNIKEY = "reportSSRecomPicOp";

    public QZoneReportMoodEggOprationRequest(long j3, byte b16) {
        super(CMD_STRING);
        this.req = new mobile_ss_recom_pic_report_req(j3, b16);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public mobile_ss_recom_pic_report_rsp getRsp() {
        return (mobile_ss_recom_pic_report_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    protected boolean needAppendGdtInfo() {
        return false;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNIKEY;
    }
}
