package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetNewBaseLibReq;
import NS_MINI_INTERFACE.INTERFACE$StGetNewBaseLibRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetNewBaseLibRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetNewBaseLib";
    public static final String unikey = "GetNewBaseLib";
    private INTERFACE$StGetNewBaseLibReq req;

    public GetNewBaseLibRequest(long j3, String str, int i3) {
        INTERFACE$StGetNewBaseLibReq iNTERFACE$StGetNewBaseLibReq = new INTERFACE$StGetNewBaseLibReq();
        this.req = iNTERFACE$StGetNewBaseLibReq;
        iNTERFACE$StGetNewBaseLibReq.curVersion.set(str);
        this.req.type.set(i3);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public static INTERFACE$StGetNewBaseLibRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetNewBaseLibRsp iNTERFACE$StGetNewBaseLibRsp = new INTERFACE$StGetNewBaseLibRsp();
        try {
            iNTERFACE$StGetNewBaseLibRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetNewBaseLibRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            }
            return null;
        }
    }
}
