package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.operation_delcomment_req;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneDeleteCommentRequest extends QZoneRequest {
    public static final int CMD_DEFAULT = 0;
    private static final String COMMENT_CMD_STRING = "delComment";

    public QzoneDeleteCommentRequest(int i3, long j3, long j16, String str, long j17, String str2, int i16, Map<Integer, String> map, Map<String, String> map2) {
        this(i3, j3, j16, str, j17, str2, i16, map);
        JceStruct jceStruct = this.req;
        if (jceStruct instanceof operation_delcomment_req) {
            ((operation_delcomment_req) jceStruct).bypass_param = map2;
        }
    }

    private static String getCmdString(int i3) {
        return COMMENT_CMD_STRING;
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
        return COMMENT_CMD_STRING;
    }

    public QzoneDeleteCommentRequest(int i3, long j3, long j16, String str, long j17, String str2, int i16, Map<Integer, String> map) {
        super(getCmdString(i3));
        operation_delcomment_req operation_delcomment_reqVar = new operation_delcomment_req();
        operation_delcomment_reqVar.iAppID = j3;
        operation_delcomment_reqVar.iSrcUin = j16;
        operation_delcomment_reqVar.strSrcID = str;
        operation_delcomment_reqVar.iCommentUin = j17;
        operation_delcomment_reqVar.strCommentID = TextUtils.isEmpty(str2) ? "" : str2;
        operation_delcomment_reqVar.iDelSource = i16;
        operation_delcomment_reqVar.mapBusiParam = map;
        this.req = operation_delcomment_reqVar;
    }
}
