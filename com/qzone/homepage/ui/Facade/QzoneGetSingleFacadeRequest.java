package com.qzone.homepage.ui.Facade;

import NS_MOBILE_CUSTOM.mobile_facade_get_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetSingleFacadeRequest extends QZoneRequest {
    public static final String CMD_STRING = "Custom.getFacade";

    public QzoneGetSingleFacadeRequest(long j3, String str, Map<String, String> map) {
        super(CMD_STRING);
        mobile_facade_get_req mobile_facade_get_reqVar = new mobile_facade_get_req();
        mobile_facade_get_reqVar.lUin = j3;
        mobile_facade_get_reqVar.strId = str;
        mobile_facade_get_reqVar.mapExtInfo = map;
        this.req = mobile_facade_get_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getFacade";
    }
}
