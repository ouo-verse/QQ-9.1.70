package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_STORE_APP_SEARCH.MiniAppSearch$StSearchAppReq;
import NS_STORE_APP_SEARCH.MiniAppSearch$StSearchAppRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SearchAppRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.store_app_search.SearchApp";
    private static final String TAG = "SearchAppRequest";
    private MiniAppSearch$StSearchAppReq req;

    public SearchAppRequest(COMM.StCommonExt stCommonExt, String str, int i3) {
        MiniAppSearch$StSearchAppReq miniAppSearch$StSearchAppReq = new MiniAppSearch$StSearchAppReq();
        this.req = miniAppSearch$StSearchAppReq;
        if (stCommonExt != null) {
            miniAppSearch$StSearchAppReq.extInfo.set(stCommonExt);
        }
        this.req.query.set(str);
        this.req.from.set(i3);
    }

    public static MiniAppSearch$StSearchAppRsp onResponse(byte[] bArr) {
        MiniAppSearch$StSearchAppRsp miniAppSearch$StSearchAppRsp = new MiniAppSearch$StSearchAppRsp();
        try {
            miniAppSearch$StSearchAppRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return miniAppSearch$StSearchAppRsp;
        } catch (Exception e16) {
            QLog.e(TAG, 2, "onResponse fail." + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }
}
