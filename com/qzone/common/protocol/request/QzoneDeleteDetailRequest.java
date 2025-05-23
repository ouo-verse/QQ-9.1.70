package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.operation_delugc_req;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.common.account.LoginData;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDeleteDetailRequest extends QZoneRequest {
    public static final int CMD_DEFAULT = 0;
    private static final String CMD_STRING = "delUgc";

    public QzoneDeleteDetailRequest(int i3, int i16, long j3, String str, String str2, int i17, Map<Integer, String> map) {
        super(getCmdString(i3));
        operation_delugc_req operation_delugc_reqVar = new operation_delugc_req();
        operation_delugc_reqVar.uin = LoginData.getInstance().getUin();
        operation_delugc_reqVar.appid = i16;
        operation_delugc_reqVar.ownuin = j3;
        operation_delugc_reqVar.srcId = str;
        operation_delugc_reqVar.srcSubid = str2;
        operation_delugc_reqVar.isverified = i17;
        operation_delugc_reqVar.busi_param = map;
        this.req = operation_delugc_reqVar;
    }

    private static String getCmdString(int i3) {
        return CMD_STRING;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return "QzoneNewService.delUgc";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QzoneDeleteDetailRequest(int i3, int i16, long j3, String str, String str2, int i17, Map<Integer, String> map, String str3, Map<String, String> map2) {
        super(getCmdString(i3));
        operation_delugc_req operation_delugc_reqVar = new operation_delugc_req();
        operation_delugc_reqVar.uin = LoginData.getInstance().getUin();
        operation_delugc_reqVar.appid = i16;
        operation_delugc_reqVar.ownuin = j3;
        operation_delugc_reqVar.srcId = str;
        operation_delugc_reqVar.srcSubid = str2;
        operation_delugc_reqVar.isverified = i17;
        operation_delugc_reqVar.busi_param = map;
        if (!TextUtils.isEmpty(str3)) {
            operation_delugc_reqVar.clientKey = str3;
        }
        operation_delugc_reqVar.mapEx = map2;
        this.req = operation_delugc_reqVar;
    }

    public QzoneDeleteDetailRequest(int i3, int i16, long j3, String str, String str2, int i17, Map<Integer, String> map, Map<String, String> map2) {
        this(i3, i16, j3, str, str2, i17, map);
        JceStruct jceStruct = this.req;
        if (jceStruct instanceof operation_delugc_req) {
            ((operation_delugc_req) jceStruct).mapEx = map2;
        }
    }
}
