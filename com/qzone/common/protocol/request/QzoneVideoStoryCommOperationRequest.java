package com.qzone.common.protocol.request;

import NS_MOBILE_OPERATION.operation_comm_req;
import com.qzone.common.account.LoginData;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneVideoStoryCommOperationRequest extends QZoneRequest {
    private static final String CMD_STRING = "Operation.commOperation";

    public QzoneVideoStoryCommOperationRequest(int i3, byte[] bArr, Map<String, String> map) {
        super(CMD_STRING, true);
        operation_comm_req operation_comm_reqVar = new operation_comm_req();
        operation_comm_reqVar.appid = i3;
        operation_comm_reqVar.opuin = LoginData.getInstance().getUin();
        operation_comm_reqVar.message = bArr;
        operation_comm_reqVar.mapEx = map;
        this.req = operation_comm_reqVar;
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
        return "commOperation";
    }
}
