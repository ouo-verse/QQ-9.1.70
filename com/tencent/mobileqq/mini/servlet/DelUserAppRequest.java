package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StDelUserAppReq;
import NS_MINI_INTERFACE.INTERFACE$StDelUserAppRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DelUserAppRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.DelUserApp";
    private INTERFACE$StDelUserAppReq req;

    public DelUserAppRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, int i17, int i18) {
        INTERFACE$StDelUserAppReq iNTERFACE$StDelUserAppReq = new INTERFACE$StDelUserAppReq();
        this.req = iNTERFACE$StDelUserAppReq;
        iNTERFACE$StDelUserAppReq.appId.set(str);
        this.req.verType.set(i3);
        this.req.isRecommend.set(i16);
        this.req.source.set(i17);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
        this.req.noDelTop.set(i18);
    }

    public static INTERFACE$StDelUserAppRsp onResponse(byte[] bArr) {
        INTERFACE$StDelUserAppRsp iNTERFACE$StDelUserAppRsp = new INTERFACE$StDelUserAppRsp();
        try {
            iNTERFACE$StDelUserAppRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StDelUserAppRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
