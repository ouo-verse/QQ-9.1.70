package com.qzone.common.protocol.request;

import ADV_REPORT.mobile_adv_report_req;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAdvReportRequest extends QZoneRequest {
    private static final String CMD_STRING = "advReport";

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QZoneAdvReportRequest(Map<Integer, String> map, int i3, int i16, int i17, int i18, int i19, boolean z16, boolean z17, String str, String str2, long j3, boolean z18, boolean z19, String str3, boolean z26, long j16, long j17) {
        super(CMD_STRING, true);
        mobile_adv_report_req mobile_adv_report_reqVar = new mobile_adv_report_req();
        mobile_adv_report_reqVar.cookie = map;
        mobile_adv_report_reqVar.report_posi = i3;
        mobile_adv_report_reqVar.feed_index = i17;
        mobile_adv_report_reqVar.write_return_code = i16;
        mobile_adv_report_reqVar.client_time = System.currentTimeMillis();
        mobile_adv_report_reqVar.action_type = i18;
        mobile_adv_report_reqVar.action_expectation = i19;
        mobile_adv_report_reqVar.is_impression = z16;
        mobile_adv_report_reqVar.is_installed = z17;
        mobile_adv_report_reqVar.antispam_info = str;
        mobile_adv_report_reqVar.video_playinfo = str2;
        mobile_adv_report_reqVar.stay_time = j3;
        mobile_adv_report_reqVar.is_repeated = z18;
        mobile_adv_report_reqVar.is_filter = z19;
        mobile_adv_report_reqVar.feeds_click_attachinfo = str3;
        mobile_adv_report_reqVar.is_trace = z26;
        mobile_adv_report_reqVar.cost_time = j16;
        mobile_adv_report_reqVar.error_code = j17;
        this.req = mobile_adv_report_reqVar;
    }
}
