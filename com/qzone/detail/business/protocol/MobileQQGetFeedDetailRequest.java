package com.qzone.detail.business.protocol;

import NS_MOBILE_FEEDS.mobile_detail_mqq_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MobileQQGetFeedDetailRequest extends QZoneRequest {
    private static final String CMD_STRING = "getDetailMqq";

    public MobileQQGetFeedDetailRequest(Map<String, String> map) {
        super(CMD_STRING);
        mobile_detail_mqq_req mobile_detail_mqq_reqVar = new mobile_detail_mqq_req();
        mobile_detail_mqq_reqVar.mqqinfo = map;
        this.req = mobile_detail_mqq_reqVar;
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
