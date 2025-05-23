package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_STORE_APP_SEARCH.MiniAppSearch$StGetHotSearchAppsV2Req;
import NS_STORE_APP_SEARCH.MiniAppSearch$StGetHotSearchAppsV2Rsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetHotSearchAppsV2Request extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.store_app_search.GetHotSearchAppsV2";
    private static final String TAG = "GetHotSearchAppsV2Request";
    private MiniAppSearch$StGetHotSearchAppsV2Req req;

    public GetHotSearchAppsV2Request(COMM.StCommonExt stCommonExt) {
        MiniAppSearch$StGetHotSearchAppsV2Req miniAppSearch$StGetHotSearchAppsV2Req = new MiniAppSearch$StGetHotSearchAppsV2Req();
        this.req = miniAppSearch$StGetHotSearchAppsV2Req;
        if (stCommonExt != null) {
            miniAppSearch$StGetHotSearchAppsV2Req.extInfo.set(stCommonExt);
        }
    }

    public static MiniAppSearch$StGetHotSearchAppsV2Rsp onResponse(byte[] bArr) {
        try {
            MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp = new MiniAppSearch$StGetHotSearchAppsV2Rsp();
            miniAppSearch$StGetHotSearchAppsV2Rsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppSearch$StGetHotSearchAppsV2Rsp;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "onResponse fail.", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
