package com.qzone.common.protocol.request;

import NS_MOBILE_FEEDS.operation_click_button_req;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneClickBookButtonRequest extends QZoneRequest {
    private static final String CMD_STRING = "Feeds.operaClickButton";
    private static final String UNI_KEY = "operaClickButton";

    public QzoneClickBookButtonRequest(Map<String, String> map) {
        super(CMD_STRING);
        operation_click_button_req operation_click_button_reqVar = new operation_click_button_req();
        operation_click_button_reqVar.busi_param = map;
        this.req = operation_click_button_reqVar;
    }

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
        return UNI_KEY;
    }
}
