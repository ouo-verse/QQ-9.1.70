package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StTrans4TinyidReq;
import NS_MINI_INTERFACE.INTERFACE$StTrans4TinyidRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetTinyIdRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.Trans4Tinyid";
    public static final String TAG = "GetTinyIdRequest";
    private INTERFACE$StTrans4TinyidReq req;

    public GetTinyIdRequest(String str) {
        INTERFACE$StTrans4TinyidReq iNTERFACE$StTrans4TinyidReq = new INTERFACE$StTrans4TinyidReq();
        this.req = iNTERFACE$StTrans4TinyidReq;
        iNTERFACE$StTrans4TinyidReq.appids.set(Collections.singletonList(str));
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
