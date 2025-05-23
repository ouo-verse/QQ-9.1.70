package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StCheckBindingStateReq;
import NS_MINI_INTERFACE.INTERFACE$StCheckBindingStateRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CheckBindingStateRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.CheckBindingState";
    private static final String TAG = "CheckBindingStateRequest";
    private INTERFACE$StCheckBindingStateReq req;

    public CheckBindingStateRequest(String str, String str2, int i3) {
        INTERFACE$StCheckBindingStateReq iNTERFACE$StCheckBindingStateReq = new INTERFACE$StCheckBindingStateReq();
        this.req = iNTERFACE$StCheckBindingStateReq;
        iNTERFACE$StCheckBindingStateReq.appId.set(str);
        this.req.uid.set(str2);
        this.req.bindType.set(i3);
    }

    public static INTERFACE$StCheckBindingStateRsp onResponse(byte[] bArr) {
        INTERFACE$StCheckBindingStateRsp iNTERFACE$StCheckBindingStateRsp = new INTERFACE$StCheckBindingStateRsp();
        try {
            iNTERFACE$StCheckBindingStateRsp.mergeFrom(bArr);
            return iNTERFACE$StCheckBindingStateRsp;
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
