package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetTeenagerConfigReq;
import NS_MINI_INTERFACE.INTERFACE$StGetTeenagerConfigRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetTeenagerConfigRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetTeenagerConfig";
    public static final String TAG = "GetTeenagerConfigRequest";
    private INTERFACE$StGetTeenagerConfigReq req;

    public GetTeenagerConfigRequest(String str) {
        INTERFACE$StGetTeenagerConfigReq iNTERFACE$StGetTeenagerConfigReq = new INTERFACE$StGetTeenagerConfigReq();
        this.req = iNTERFACE$StGetTeenagerConfigReq;
        iNTERFACE$StGetTeenagerConfigReq.extInfo.set(str);
    }

    public static INTERFACE$StGetTeenagerConfigRsp onResponse(byte[] bArr) {
        INTERFACE$StGetTeenagerConfigRsp iNTERFACE$StGetTeenagerConfigRsp = new INTERFACE$StGetTeenagerConfigRsp();
        try {
            iNTERFACE$StGetTeenagerConfigRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetTeenagerConfigRsp;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
