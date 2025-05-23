package com.qzone.business.plusunion.business.protocol;

import NS_MOBILE_EXTRA.get_app_info_list_new_req;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetAppListRequest extends QZoneRequest {
    private static final String CMD_STRING = "getOpenAppListNew";

    public QzoneGetAppListRequest(Map<Integer, Integer> map, int i3) {
        super(CMD_STRING);
        get_app_info_list_new_req get_app_info_list_new_reqVar = new get_app_info_list_new_req();
        get_app_info_list_new_reqVar.current_serial_map = map;
        get_app_info_list_new_reqVar.current_list_serial = i3;
        this.req = get_app_info_list_new_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
