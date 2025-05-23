package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetProfileReq;
import NS_MINI_INTERFACE.INTERFACE$StGetProfileRsp;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class GetProfileRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.GetProfile";
    private static final String unikey = "GetProfile";
    private INTERFACE$StGetProfileReq req;

    public GetProfileRequest(String str, boolean z16, String str2) {
        INTERFACE$StGetProfileReq iNTERFACE$StGetProfileReq = new INTERFACE$StGetProfileReq();
        this.req = iNTERFACE$StGetProfileReq;
        iNTERFACE$StGetProfileReq.appid.set(str);
        this.req.withCredentials.set(z16 ? 1 : 0);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.req.lang.set(str2);
    }

    public static INTERFACE$StGetProfileRsp onResponse(byte[] bArr) {
        INTERFACE$StGetProfileRsp iNTERFACE$StGetProfileRsp = new INTERFACE$StGetProfileRsp();
        try {
            iNTERFACE$StGetProfileRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetProfileRsp;
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
