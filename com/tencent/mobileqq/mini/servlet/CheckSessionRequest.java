package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StCheckSessionReq;
import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CheckSessionRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_program_auth.CheckSession";
    private INTERFACE$StCheckSessionReq req;

    public CheckSessionRequest(long j3, String str) {
        INTERFACE$StCheckSessionReq iNTERFACE$StCheckSessionReq = new INTERFACE$StCheckSessionReq();
        this.req = iNTERFACE$StCheckSessionReq;
        iNTERFACE$StCheckSessionReq.appid.set(str);
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public static PROTOCAL.StQWebRsp onResponse(byte[] bArr, int[] iArr) {
        if (bArr == null) {
            return null;
        }
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        try {
            stQWebRsp.mergeFrom(bArr);
            return stQWebRsp;
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
            }
            return null;
        }
    }
}
