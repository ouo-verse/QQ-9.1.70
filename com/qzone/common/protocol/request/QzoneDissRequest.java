package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.operation_like_req;
import com.qzone.common.account.LoginData;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDissRequest extends QZoneRequest {
    public static final String CMD_STRING = "diss";

    public QzoneDissRequest(String str, String str2, int i3, int i16, Map<Integer, String> map, Map<Integer, String> map2) {
        super(CMD_STRING, true);
        operation_like_req operation_like_reqVar = new operation_like_req();
        operation_like_reqVar.uin = LoginData.getInstance().getUin();
        operation_like_reqVar.action = i3;
        operation_like_reqVar.appid = i16;
        operation_like_reqVar.curkey = str;
        operation_like_reqVar.unikey = str2;
        operation_like_reqVar.busi_param = map;
        operation_like_reqVar.extern_param = map2;
        this.req = operation_like_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getRequestType() {
        return com.qzone.app.a.b(((operation_like_req) this.req).appid);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QzoneDissRequest(String str, String str2, int i3, int i16, long j3, Map<Integer, String> map, Map<Integer, String> map2, Map<String, String> map3) {
        super(CMD_STRING, true);
        operation_like_req operation_like_reqVar = new operation_like_req();
        operation_like_reqVar.uin = LoginData.getInstance().getUin();
        operation_like_reqVar.action = i3;
        operation_like_reqVar.appid = i16;
        operation_like_reqVar.curkey = str;
        operation_like_reqVar.unikey = str2;
        operation_like_reqVar.hostuin = j3;
        operation_like_reqVar.busi_param = map;
        operation_like_reqVar.extern_param = map2;
        operation_like_reqVar.bypass_param = map3;
        this.req = operation_like_reqVar;
    }

    public QzoneDissRequest() {
    }
}
