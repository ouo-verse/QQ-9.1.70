package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StBatchGetContactReq;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BatchGetContactRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.BatchGetContact";
    public static final String TAG = "VerifyPluginRequest";
    private INTERFACE$StBatchGetContactReq req;

    public BatchGetContactRequest(List<String> list) {
        INTERFACE$StBatchGetContactReq iNTERFACE$StBatchGetContactReq = new INTERFACE$StBatchGetContactReq();
        this.req = iNTERFACE$StBatchGetContactReq;
        iNTERFACE$StBatchGetContactReq.appids.set(list);
    }

    public static INTERFACE$StBatchGetContactReq onResponse(byte[] bArr) {
        INTERFACE$StBatchGetContactReq iNTERFACE$StBatchGetContactReq = new INTERFACE$StBatchGetContactReq();
        try {
            iNTERFACE$StBatchGetContactReq.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StBatchGetContactReq;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("VerifyPluginRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
