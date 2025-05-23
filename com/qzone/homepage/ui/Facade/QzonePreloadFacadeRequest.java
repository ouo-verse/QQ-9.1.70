package com.qzone.homepage.ui.Facade;

import NS_MOBILE_CUSTOM.mobile_facade_pre_get_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QzonePreloadFacadeRequest extends QZoneRequest {
    public static final String CMD_STRING = "Custom.preGetFacade";

    public QzonePreloadFacadeRequest(long j3, ArrayList<Long> arrayList, Map<String, String> map) {
        super(CMD_STRING);
        mobile_facade_pre_get_req mobile_facade_pre_get_reqVar = new mobile_facade_pre_get_req();
        mobile_facade_pre_get_reqVar.vecReqUin = arrayList;
        mobile_facade_pre_get_reqVar.lLastFetchTimestamp = j3;
        mobile_facade_pre_get_reqVar.mapExtInfo = map;
        this.req = mobile_facade_pre_get_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "preGetFacade";
    }
}
