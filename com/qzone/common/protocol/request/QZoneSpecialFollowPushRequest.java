package com.qzone.common.protocol.request;

import NS_MOBILE_MAIN_PAGE.mobile_sub_concern_push_req;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneSpecialFollowPushRequest extends QZoneRequest {
    public static final String CMD_STRING = "concernPush";
    public static final int ENUM_SPECIAL_FOLLOW_NO_PUSH = 0;
    public static final int ENUM_SPECIAL_FOLLOW_PUSH = 1;

    public QZoneSpecialFollowPushRequest(long j3, int i3, Map<Integer, String> map) {
        super(CMD_STRING);
        mobile_sub_concern_push_req mobile_sub_concern_push_reqVar = new mobile_sub_concern_push_req();
        mobile_sub_concern_push_reqVar.objuin = j3;
        mobile_sub_concern_push_reqVar.push_type = i3;
        mobile_sub_concern_push_reqVar.map_ext = map;
        this.req = mobile_sub_concern_push_reqVar;
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
