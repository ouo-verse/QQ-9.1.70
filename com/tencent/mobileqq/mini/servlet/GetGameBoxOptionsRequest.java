package com.tencent.mobileqq.mini.servlet;

import NS_MINI_GAME_BOX.MINI_GAME_BOX$QueryBoxOptionReq;
import NS_MINI_GAME_BOX.MINI_GAME_BOX$QueryBoxOptionRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetGameBoxOptionsRequest extends ProtoBufRequest {
    public static final String TAG = "GetGameBoxOptionsRequest";
    private MINI_GAME_BOX$QueryBoxOptionReq req;

    public GetGameBoxOptionsRequest(String str) {
        MINI_GAME_BOX$QueryBoxOptionReq mINI_GAME_BOX$QueryBoxOptionReq = new MINI_GAME_BOX$QueryBoxOptionReq();
        this.req = mINI_GAME_BOX$QueryBoxOptionReq;
        mINI_GAME_BOX$QueryBoxOptionReq.app_id.set(str);
    }

    public static MINI_GAME_BOX$QueryBoxOptionRsp onResponse(byte[] bArr) {
        try {
            MINI_GAME_BOX$QueryBoxOptionRsp mINI_GAME_BOX$QueryBoxOptionRsp = new MINI_GAME_BOX$QueryBoxOptionRsp();
            mINI_GAME_BOX$QueryBoxOptionRsp.mergeFrom(bArr);
            return mINI_GAME_BOX$QueryBoxOptionRsp;
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
