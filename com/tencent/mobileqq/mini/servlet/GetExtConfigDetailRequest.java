package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StExtConfigInfo;
import NS_MINI_INTERFACE.INTERFACE$StGetExtConfigDetailReq;
import NS_MINI_INTERFACE.INTERFACE$StGetExtConfigDetailRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetExtConfigDetailRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_info.GetExtConfigDetail";
    private static final String TAG = "GetExtConfigDetailRequest";
    private INTERFACE$StGetExtConfigDetailReq req;

    public GetExtConfigDetailRequest(COMM.StCommonExt stCommonExt, List<INTERFACE$StExtConfigInfo> list) {
        INTERFACE$StGetExtConfigDetailReq iNTERFACE$StGetExtConfigDetailReq = new INTERFACE$StGetExtConfigDetailReq();
        this.req = iNTERFACE$StGetExtConfigDetailReq;
        iNTERFACE$StGetExtConfigDetailReq.extInfo = stCommonExt;
        iNTERFACE$StGetExtConfigDetailReq.configs.set(list);
    }

    public static INTERFACE$StGetExtConfigDetailRsp onResponse(byte[] bArr) {
        INTERFACE$StGetExtConfigDetailRsp iNTERFACE$StGetExtConfigDetailRsp = new INTERFACE$StGetExtConfigDetailRsp();
        try {
            iNTERFACE$StGetExtConfigDetailRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return iNTERFACE$StGetExtConfigDetailRsp;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onResponse fail.", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
