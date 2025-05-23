package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_SHARE.MiniProgramShare$StSendArkMsgReq;
import NS_MINI_SHARE.MiniProgramShare$StSendArkMsgRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSendArkMsgRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_share.SendArkMsg";
    public static final String TAG = "MiniAppSendArkMsgRequest";
    private static final String unikey = "MiniAppSendArkMsgRequest";
    private MiniProgramShare$StSendArkMsgReq req;

    public MiniAppSendArkMsgRequest(COMM.StCommonExt stCommonExt, String str, String str2, String str3, String str4) {
        MiniProgramShare$StSendArkMsgReq miniProgramShare$StSendArkMsgReq = new MiniProgramShare$StSendArkMsgReq();
        this.req = miniProgramShare$StSendArkMsgReq;
        if (stCommonExt != null) {
            miniProgramShare$StSendArkMsgReq.extInfo.set(stCommonExt);
        }
        this.req.appId.set(str);
        this.req.openId.set(str2);
        this.req.arkJson.set(str3);
        this.req.apiName.set(str4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, NS_MINI_SHARE.MiniProgramShare$StSendArkMsgRsp] */
    public static MiniProgramShare$StSendArkMsgRsp onResponse(byte[] bArr) {
        ?? r06 = new MessageMicro<MiniProgramShare$StSendArkMsgRsp>() { // from class: NS_MINI_SHARE.MiniProgramShare$StSendArkMsgRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, MiniProgramShare$StSendArkMsgRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
        };
        try {
            r06.mergeFrom(ProtoBufRequest.decode(bArr));
            return r06;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("MiniAppSendArkMsgRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
