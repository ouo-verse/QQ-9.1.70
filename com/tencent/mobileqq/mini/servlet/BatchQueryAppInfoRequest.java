package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StBatchQueryAppInfoReq;
import NS_MINI_INTERFACE.INTERFACE$StBatchQueryAppInfoRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BatchQueryAppInfoRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.BatchQueryAppInfo";
    public static final String TAG = "BatchQueryAppInfoRequest";
    private INTERFACE$StBatchQueryAppInfoReq req;

    public BatchQueryAppInfoRequest(COMM.StCommonExt stCommonExt, List<String> list) {
        INTERFACE$StBatchQueryAppInfoReq iNTERFACE$StBatchQueryAppInfoReq = new INTERFACE$StBatchQueryAppInfoReq();
        this.req = iNTERFACE$StBatchQueryAppInfoReq;
        iNTERFACE$StBatchQueryAppInfoReq.appIds.set(list);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    public static INTERFACE$StBatchQueryAppInfoRsp onResponse(byte[] bArr) {
        INTERFACE$StBatchQueryAppInfoRsp iNTERFACE$StBatchQueryAppInfoRsp = new INTERFACE$StBatchQueryAppInfoRsp();
        try {
            iNTERFACE$StBatchQueryAppInfoRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StBatchQueryAppInfoRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
