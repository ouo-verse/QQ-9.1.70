package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetWeixinSDKAppInfoReq;
import NS_MINI_INTERFACE.INTERFACE$StGetWeixinSDKAppInfoRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetWeixinSDKAppInfoRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_weixin_sdk_qrcode.GetWeixinSDKAppInfo";
    public static final String TAG = "GetWeixinSDKAppInfoRequest";
    private INTERFACE$StGetWeixinSDKAppInfoReq req;

    public GetWeixinSDKAppInfoRequest(String str) {
        INTERFACE$StGetWeixinSDKAppInfoReq iNTERFACE$StGetWeixinSDKAppInfoReq = new INTERFACE$StGetWeixinSDKAppInfoReq();
        this.req = iNTERFACE$StGetWeixinSDKAppInfoReq;
        iNTERFACE$StGetWeixinSDKAppInfoReq.code.set(str);
    }

    public static INTERFACE$StGetWeixinSDKAppInfoRsp onResponse(byte[] bArr) {
        INTERFACE$StGetWeixinSDKAppInfoRsp iNTERFACE$StGetWeixinSDKAppInfoRsp = new INTERFACE$StGetWeixinSDKAppInfoRsp();
        try {
            iNTERFACE$StGetWeixinSDKAppInfoRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetWeixinSDKAppInfoRsp;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
