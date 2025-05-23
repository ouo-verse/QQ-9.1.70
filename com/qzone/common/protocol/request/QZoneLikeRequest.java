package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.operation_like_req;
import com.qzone.common.account.LoginData;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneLikeRequest extends QZoneRequest {
    public static final int CMD_DEFAULT = 0;
    public static final String CMD_STRING = "like";

    public QZoneLikeRequest(int i3, String str, String str2, int i16, int i17, Map<Integer, String> map, Map<Integer, String> map2) {
        super(getCmdString(i3), true);
        operation_like_req operation_like_reqVar = new operation_like_req();
        operation_like_reqVar.uin = LoginData.getInstance().getUin();
        operation_like_reqVar.action = i16;
        operation_like_reqVar.appid = i17;
        operation_like_reqVar.curkey = str;
        operation_like_reqVar.unikey = str2;
        operation_like_reqVar.busi_param = map;
        operation_like_reqVar.extern_param = map2;
        this.req = operation_like_reqVar;
    }

    private static String getCmdString(int i3) {
        return "like";
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
        return "like";
    }

    public QZoneLikeRequest(int i3, String str, String str2, int i16, int i17, long j3, Map<Integer, String> map, Map<Integer, String> map2, Map<String, String> map3, long j16) {
        super(getCmdString(i3), true);
        operation_like_req operation_like_reqVar = new operation_like_req();
        operation_like_reqVar.uin = LoginData.getInstance().getUin();
        operation_like_reqVar.action = i16;
        operation_like_reqVar.appid = i17;
        operation_like_reqVar.curkey = str;
        operation_like_reqVar.unikey = str2;
        operation_like_reqVar.busi_param = map;
        operation_like_reqVar.extern_param = map2;
        operation_like_reqVar.bypass_param = map3;
        operation_like_reqVar.hostuin = j3;
        this.req = operation_like_reqVar;
    }

    public QZoneLikeRequest(int i3, String str, String str2, int i16, int i17, long j3, Map<Integer, String> map, Map<Integer, String> map2, Map<String, String> map3, Map<String, byte[]> map4) {
        super(getCmdString(i3), true);
        operation_like_req operation_like_reqVar = new operation_like_req();
        operation_like_reqVar.uin = LoginData.getInstance().getUin();
        operation_like_reqVar.action = i16;
        operation_like_reqVar.appid = i17;
        operation_like_reqVar.curkey = str;
        operation_like_reqVar.unikey = str2;
        operation_like_reqVar.hostuin = j3;
        operation_like_reqVar.busi_param = map;
        operation_like_reqVar.extern_param = map2;
        operation_like_reqVar.bypass_param = map3;
        operation_like_reqVar.bypass_param_binary = map4;
        this.req = operation_like_reqVar;
    }

    public QZoneLikeRequest(String str, String str2, int i3, int i16, long j3, Map<Integer, String> map, Map<String, String> map2) {
        super("like", true);
        operation_like_req operation_like_reqVar = new operation_like_req();
        operation_like_reqVar.uin = LoginData.getInstance().getUin();
        operation_like_reqVar.curkey = str;
        operation_like_reqVar.unikey = str2;
        operation_like_reqVar.action = i3;
        operation_like_reqVar.appid = i16;
        operation_like_reqVar.hostuin = j3;
        operation_like_reqVar.busi_param = map;
        operation_like_reqVar.bypass_param = map2;
        this.req = operation_like_reqVar;
    }

    public QZoneLikeRequest() {
    }
}
