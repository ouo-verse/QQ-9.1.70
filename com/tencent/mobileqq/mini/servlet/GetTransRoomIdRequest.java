package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_MISC.MISC$StTrans4RoomidReq;
import NS_MINI_INTERFACE.INTERFACE$StTrans4TinyidRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetTransRoomIdRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_misc.Trans4Roomid";
    public static final String TAG = "GetTransRoomIdRequest";
    private MISC$StTrans4RoomidReq req;

    public GetTransRoomIdRequest(String str, String str2) {
        MISC$StTrans4RoomidReq mISC$StTrans4RoomidReq = new MISC$StTrans4RoomidReq();
        this.req = mISC$StTrans4RoomidReq;
        mISC$StTrans4RoomidReq.appid.set(str);
        this.req.groupid.set(str2);
    }

    public static INTERFACE$StTrans4TinyidRsp onResponse(byte[] bArr) {
        INTERFACE$StTrans4TinyidRsp iNTERFACE$StTrans4TinyidRsp = new INTERFACE$StTrans4TinyidRsp();
        try {
            iNTERFACE$StTrans4TinyidRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StTrans4TinyidRsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
