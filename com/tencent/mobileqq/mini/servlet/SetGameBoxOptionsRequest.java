package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_BOX.MINI_GAME_BOX$SetBoxDisplayOptionReq;
import NS_MINI_GAME_BOX.MINI_GAME_BOX$SetBoxDisplayOptionRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetGameBoxOptionsRequest extends ProtoBufRequest {
    public static final String TAG = "SetGameBoxOptionsRequest";
    private MINI_GAME_BOX$SetBoxDisplayOptionReq req;

    public SetGameBoxOptionsRequest(String str, boolean z16) {
        MINI_GAME_BOX$SetBoxDisplayOptionReq mINI_GAME_BOX$SetBoxDisplayOptionReq = new MINI_GAME_BOX$SetBoxDisplayOptionReq();
        this.req = mINI_GAME_BOX$SetBoxDisplayOptionReq;
        mINI_GAME_BOX$SetBoxDisplayOptionReq.appid.set(str);
        this.req.allow_display.set(z16);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.pb.MessageMicro, NS_MINI_GAME_BOX.MINI_GAME_BOX$SetBoxDisplayOptionRsp] */
    public static MINI_GAME_BOX$SetBoxDisplayOptionRsp onResponse(byte[] bArr) {
        try {
            ?? r06 = new MessageMicro<MINI_GAME_BOX$SetBoxDisplayOptionRsp>() { // from class: NS_MINI_GAME_BOX.MINI_GAME_BOX$SetBoxDisplayOptionRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MINI_GAME_BOX$SetBoxDisplayOptionRsp.class);
            };
            r06.mergeFrom(bArr);
            return r06;
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
