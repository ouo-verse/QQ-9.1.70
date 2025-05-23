package com.qzone.publish.business.protocol;

import NS_MOBILE_FEEDS.mobile_detail_actshuoshuo_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetOperationMoodContentRequest extends QZoneRequest {
    private static final String FIELD_CMD = "getShuoshuoActInfo";

    public QZoneGetOperationMoodContentRequest(String str, String str2) {
        super(FIELD_CMD);
        mobile_detail_actshuoshuo_req mobile_detail_actshuoshuo_reqVar = new mobile_detail_actshuoshuo_req();
        mobile_detail_actshuoshuo_reqVar.act_id = str;
        mobile_detail_actshuoshuo_reqVar.busi_param = str2;
        this.req = mobile_detail_actshuoshuo_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return FIELD_CMD;
    }
}
