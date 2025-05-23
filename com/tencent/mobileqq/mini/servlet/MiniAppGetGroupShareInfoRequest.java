package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_SHARE.MiniProgramShare$StGetGroupShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare$StGetGroupShareInfoRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetGroupShareInfoRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_share.GetGroupShareInfo";
    public static final String TAG = "MiniAppGetGroupShareInfoRequest";
    private static final String unikey = "MiniAppGetGroupShareInfoRequest";
    private MiniProgramShare$StGetGroupShareInfoReq req;

    public MiniAppGetGroupShareInfoRequest(COMM.StCommonExt stCommonExt, String str, String str2) {
        MiniProgramShare$StGetGroupShareInfoReq miniProgramShare$StGetGroupShareInfoReq = new MiniProgramShare$StGetGroupShareInfoReq();
        this.req = miniProgramShare$StGetGroupShareInfoReq;
        if (stCommonExt != null) {
            miniProgramShare$StGetGroupShareInfoReq.extInfo.set(stCommonExt);
        }
        this.req.appid.set(str);
        this.req.shareTicket.set(str2);
    }

    public static MiniProgramShare$StGetGroupShareInfoRsp onResponse(byte[] bArr) {
        MiniProgramShare$StGetGroupShareInfoRsp miniProgramShare$StGetGroupShareInfoRsp = new MiniProgramShare$StGetGroupShareInfoRsp();
        try {
            miniProgramShare$StGetGroupShareInfoRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniProgramShare$StGetGroupShareInfoRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("MiniAppGetGroupShareInfoRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
