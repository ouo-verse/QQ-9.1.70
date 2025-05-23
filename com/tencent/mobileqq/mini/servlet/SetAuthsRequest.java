package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetAuthsReq;
import NS_MINI_INTERFACE.INTERFACE$StSetAuthsRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserAuthInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetAuthsRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_user_info.SetAuths";
    private INTERFACE$StSetAuthsReq req;

    public SetAuthsRequest(COMM.StCommonExt stCommonExt, String str, INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo) {
        INTERFACE$StSetAuthsReq iNTERFACE$StSetAuthsReq = new INTERFACE$StSetAuthsReq();
        this.req = iNTERFACE$StSetAuthsReq;
        iNTERFACE$StSetAuthsReq.appid.set(str);
        if (iNTERFACE$StUserAuthInfo != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iNTERFACE$StUserAuthInfo);
            this.req.auths.set(arrayList);
        }
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    public static INTERFACE$StSetAuthsRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StSetAuthsRsp iNTERFACE$StSetAuthsRsp = new INTERFACE$StSetAuthsRsp();
        try {
            iNTERFACE$StSetAuthsRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StSetAuthsRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            }
            return null;
        }
    }

    public SetAuthsRequest(COMM.StCommonExt stCommonExt, String str, List<INTERFACE$StUserAuthInfo> list) {
        INTERFACE$StSetAuthsReq iNTERFACE$StSetAuthsReq = new INTERFACE$StSetAuthsReq();
        this.req = iNTERFACE$StSetAuthsReq;
        iNTERFACE$StSetAuthsReq.appid.set(str);
        if (list != null) {
            this.req.auths.set(new ArrayList(list));
        }
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }
}
