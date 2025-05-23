package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE$StGetAppInfoByLinkRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetAppInfoByLinkRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetAppInfoByLink";
    private static final String unikey = "GetAppInfoByLink";
    private INTERFACE$StGetAppInfoByLinkReq req;

    public GetAppInfoByLinkRequest(String str, int i3) {
        INTERFACE$StGetAppInfoByLinkReq iNTERFACE$StGetAppInfoByLinkReq = new INTERFACE$StGetAppInfoByLinkReq();
        this.req = iNTERFACE$StGetAppInfoByLinkReq;
        iNTERFACE$StGetAppInfoByLinkReq.link.set(str);
        this.req.linkType.set(i3);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public static INTERFACE$StGetAppInfoByLinkRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetAppInfoByLinkRsp iNTERFACE$StGetAppInfoByLinkRsp = new INTERFACE$StGetAppInfoByLinkRsp();
        try {
            iNTERFACE$StGetAppInfoByLinkRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetAppInfoByLinkRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            }
            return null;
        }
    }
}
