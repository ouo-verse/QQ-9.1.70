package com.qzone.cover.business.protocol;

import NS_MOBILE_WIDGET.GetWidgetReq;
import NS_MOBILE_WIDGET.GetWidgetRsp;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetWidgetInfoRequest extends QZoneRequest {
    private static final String CMD_STRING = "getWidget";

    public QzoneGetWidgetInfoRequest(int i3, String str) {
        super(CMD_STRING);
        GetWidgetReq getWidgetReq = new GetWidgetReq();
        getWidgetReq.widgetid = i3;
        getWidgetReq.attach_info = str;
        getWidgetReq.time = (int) (System.currentTimeMillis() / 1000);
        getWidgetReq.zone = TimeZone.getDefault().getRawOffset() / 3600000;
        this.req = getWidgetReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public GetWidgetRsp getResp() {
        return (GetWidgetRsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
