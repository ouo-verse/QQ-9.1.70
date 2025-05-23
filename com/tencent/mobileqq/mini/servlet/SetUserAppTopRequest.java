package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppTopReq;
import NS_MINI_INTERFACE.INTERFACE$StSetUserAppTopRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetUserAppTopRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.SetUserAppTop";
    private INTERFACE$StSetUserAppTopReq req;

    public SetUserAppTopRequest(COMM.StCommonExt stCommonExt, String str, int i3, int i16, int i17, int i18, int i19) {
        INTERFACE$StSetUserAppTopReq iNTERFACE$StSetUserAppTopReq = new INTERFACE$StSetUserAppTopReq();
        this.req = iNTERFACE$StSetUserAppTopReq;
        iNTERFACE$StSetUserAppTopReq.appId.set(str);
        this.req.verType.set(i16);
        this.req.putTop.set(i3);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
        this.req.oldIdx.set(i17);
        this.req.newIdx.set(i18);
        this.req.fromNewDownload.set(i19);
    }

    public static INTERFACE$StSetUserAppTopRsp onResponse(byte[] bArr) {
        INTERFACE$StSetUserAppTopRsp iNTERFACE$StSetUserAppTopRsp = new INTERFACE$StSetUserAppTopRsp();
        try {
            iNTERFACE$StSetUserAppTopRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StSetUserAppTopRsp;
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
