package com.qzone.common.protocol.request;

import NS_MOBILE_MAIN_PAGE.mobile_sub_concern_req;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAutherRequest extends QZoneRequest {
    public static final String CMD_STRING_AUTHER = "concern";
    public static final int ENUM_AUTHER_CARE = 1;
    public static final int ENUM_AUTHER_NOTCARE = 0;
    public static final int ENUM_SPECIAL_CARE = 3;
    public static final int ENUM_SPECIAL_NOTCARE = 2;

    public QZoneAutherRequest(long j3, int i3, int i16, Map<Integer, String> map) {
        super(CMD_STRING_AUTHER);
        mobile_sub_concern_req mobile_sub_concern_reqVar = new mobile_sub_concern_req();
        mobile_sub_concern_reqVar.objuin = j3;
        mobile_sub_concern_reqVar.isconcern = i3;
        mobile_sub_concern_reqVar.source = i16;
        mobile_sub_concern_reqVar.map_ext = map;
        this.req = mobile_sub_concern_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING_AUTHER;
    }
}
