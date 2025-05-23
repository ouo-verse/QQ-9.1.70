package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetCodeReq;
import NS_MINI_INTERFACE.INTERFACE$StGetCodeRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetLoginCodeRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_program_auth.GetCode";
    public static final String TAG = "GetLoginCodeRequest";
    private INTERFACE$StGetCodeReq req;

    public GetLoginCodeRequest(String str) {
        INTERFACE$StGetCodeReq iNTERFACE$StGetCodeReq = new INTERFACE$StGetCodeReq();
        this.req = iNTERFACE$StGetCodeReq;
        iNTERFACE$StGetCodeReq.appid.set(str);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public static INTERFACE$StGetCodeRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetCodeRsp iNTERFACE$StGetCodeRsp = new INTERFACE$StGetCodeRsp();
        try {
            iNTERFACE$StGetCodeRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetCodeRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onResponse fail." + e16);
            }
            return null;
        }
    }
}
