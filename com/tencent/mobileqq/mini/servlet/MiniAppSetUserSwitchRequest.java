package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetUserSwitchReq;
import NS_MINI_INTERFACE.INTERFACE$StSetUserSwitchRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSetUserSwitchRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.SetUserSwitch";
    public static final String TAG = "MiniAppSetUserSwitchRequest";
    private static final String unikey = "MiniAppSetUserSwitchRequest";
    private INTERFACE$StSetUserSwitchReq req;

    public MiniAppSetUserSwitchRequest(COMM.StCommonExt stCommonExt, String str, int i3) {
        INTERFACE$StSetUserSwitchReq iNTERFACE$StSetUserSwitchReq = new INTERFACE$StSetUserSwitchReq();
        this.req = iNTERFACE$StSetUserSwitchReq;
        if (stCommonExt != null) {
            iNTERFACE$StSetUserSwitchReq.extInfo.set(stCommonExt);
        }
        this.req.key.set(str);
        this.req.value.set(i3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [NS_MINI_INTERFACE.INTERFACE$StSetUserSwitchRsp, com.tencent.mobileqq.pb.MessageMicro] */
    public static INTERFACE$StSetUserSwitchRsp onResponse(byte[] bArr) {
        ?? r06 = new MessageMicro<INTERFACE$StSetUserSwitchRsp>() { // from class: NS_MINI_INTERFACE.INTERFACE$StSetUserSwitchRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, INTERFACE$StSetUserSwitchRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
        };
        try {
            r06.mergeFrom(ProtoBufRequest.decode(bArr));
            return r06;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("MiniAppSetUserSwitchRequest", 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
