package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.operation_delreply_req;
import com.qq.taf.jce.JceStruct;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDeleteReplyRequest extends QZoneRequest {
    public static final int CMD_DEFAULT = 0;
    private static final String CMD_STRING = "delReply";

    public QzoneDeleteReplyRequest(int i3, long j3, long j16, String str, long j17, String str2, long j18, String str3, int i16, Map<Integer, String> map) {
        super(getStringCmd(i3));
        operation_delreply_req operation_delreply_reqVar = new operation_delreply_req();
        operation_delreply_reqVar.iAppID = j3;
        operation_delreply_reqVar.iSrcUin = j16;
        operation_delreply_reqVar.strSrcID = str;
        operation_delreply_reqVar.iCommentUin = j17;
        operation_delreply_reqVar.strCommentID = str2;
        operation_delreply_reqVar.iReplyUin = j18;
        operation_delreply_reqVar.strReplyID = str3;
        operation_delreply_reqVar.iDelSource = i16;
        operation_delreply_reqVar.mapBusiParam = map;
        this.req = operation_delreply_reqVar;
    }

    private static String getStringCmd(int i3) {
        return CMD_STRING;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public boolean isWriteOperation() {
        return true;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }

    public QzoneDeleteReplyRequest(int i3, long j3, long j16, String str, long j17, String str2, long j18, String str3, int i16, Map<Integer, String> map, Map<String, String> map2) {
        this(i3, j3, j16, str, j17, str2, j18, str3, i16, map);
        JceStruct jceStruct = this.req;
        if (jceStruct instanceof operation_delreply_req) {
            ((operation_delreply_req) jceStruct).bypass_param = map2;
        }
    }
}
