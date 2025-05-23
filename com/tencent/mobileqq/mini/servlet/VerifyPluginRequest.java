package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StPlugin;
import NS_MINI_INTERFACE.INTERFACE$StVerifyPluginReq;
import NS_MINI_INTERFACE.INTERFACE$StVerifyPluginRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* loaded from: classes33.dex */
public class VerifyPluginRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.VerifyPlugin";
    public static final String TAG = "VerifyPluginRequest";
    private INTERFACE$StVerifyPluginReq req;

    public VerifyPluginRequest(String str, List<INTERFACE$StPlugin> list) {
        INTERFACE$StVerifyPluginReq iNTERFACE$StVerifyPluginReq = new INTERFACE$StVerifyPluginReq();
        this.req = iNTERFACE$StVerifyPluginReq;
        iNTERFACE$StVerifyPluginReq.appid.set(str);
        this.req.plugins.set(list);
    }

    public static INTERFACE$StVerifyPluginRsp onResponse(byte[] bArr) {
        INTERFACE$StVerifyPluginRsp iNTERFACE$StVerifyPluginRsp = new INTERFACE$StVerifyPluginRsp();
        try {
            iNTERFACE$StVerifyPluginRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StVerifyPluginRsp;
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
