package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StBatchGetUserInfoReq;
import NS_MINI_INTERFACE.INTERFACE$StBatchGetUserInfoRsp;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BatchGetUserInfoRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.BatchGetUserInfo";
    private static final String TAG = "BatchGetUserInfoRequest";
    private static final String unikey = "BatchGetUserInfo";
    private INTERFACE$StBatchGetUserInfoReq req;

    public BatchGetUserInfoRequest(String str, String str2, String[] strArr) {
        INTERFACE$StBatchGetUserInfoReq iNTERFACE$StBatchGetUserInfoReq = new INTERFACE$StBatchGetUserInfoReq();
        this.req = iNTERFACE$StBatchGetUserInfoReq;
        iNTERFACE$StBatchGetUserInfoReq.appid.set(str);
        if (!TextUtils.isEmpty(str2)) {
            this.req.lang.set(str2);
        }
        for (String str3 : strArr) {
            this.req.openIds.add(str3);
        }
    }

    public static INTERFACE$StBatchGetUserInfoRsp onResponse(byte[] bArr) {
        INTERFACE$StBatchGetUserInfoRsp iNTERFACE$StBatchGetUserInfoRsp = new INTERFACE$StBatchGetUserInfoRsp();
        try {
            iNTERFACE$StBatchGetUserInfoRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StBatchGetUserInfoRsp;
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
