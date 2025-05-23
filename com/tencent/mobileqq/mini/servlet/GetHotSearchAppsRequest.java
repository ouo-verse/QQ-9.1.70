package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_STORE_APP_SEARCH.MiniAppSearch$StGetHotSearchAppsReq;
import NS_STORE_APP_SEARCH.MiniAppSearch$StGetHotSearchAppsRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetHotSearchAppsRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.store_app_search.GetHotSearchApps";
    private static final String TAG = "GetHotSearchAppsRequest";
    private MiniAppSearch$StGetHotSearchAppsReq req;

    public GetHotSearchAppsRequest(COMM.StCommonExt stCommonExt) {
        MiniAppSearch$StGetHotSearchAppsReq miniAppSearch$StGetHotSearchAppsReq = new MiniAppSearch$StGetHotSearchAppsReq();
        this.req = miniAppSearch$StGetHotSearchAppsReq;
        if (stCommonExt != null) {
            miniAppSearch$StGetHotSearchAppsReq.extInfo.set(stCommonExt);
        }
        this.req.from.set(1);
    }

    public static MiniAppSearch$StGetHotSearchAppsRsp onResponse(byte[] bArr) {
        MiniAppSearch$StGetHotSearchAppsRsp miniAppSearch$StGetHotSearchAppsRsp = new MiniAppSearch$StGetHotSearchAppsRsp();
        try {
            miniAppSearch$StGetHotSearchAppsRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppSearch$StGetHotSearchAppsRsp;
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
