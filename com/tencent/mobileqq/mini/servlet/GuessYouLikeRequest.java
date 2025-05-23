package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StGetGuessYouLikeReq;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StGetGuessYouLikeRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuessYouLikeRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.store_app_search.GetGuessYouLike";
    private static final String TAG = "GuessYouLikeRequest";
    private STORE_APP_CLIENT$StGetGuessYouLikeReq req;

    public GuessYouLikeRequest(COMM.StCommonExt stCommonExt, int i3) {
        STORE_APP_CLIENT$StGetGuessYouLikeReq sTORE_APP_CLIENT$StGetGuessYouLikeReq = new STORE_APP_CLIENT$StGetGuessYouLikeReq();
        this.req = sTORE_APP_CLIENT$StGetGuessYouLikeReq;
        if (stCommonExt != null) {
            sTORE_APP_CLIENT$StGetGuessYouLikeReq.extInfo.set(stCommonExt);
        }
        this.req.count.set(i3);
    }

    public static STORE_APP_CLIENT$StGetGuessYouLikeRsp onResponse(byte[] bArr) {
        STORE_APP_CLIENT$StGetGuessYouLikeRsp sTORE_APP_CLIENT$StGetGuessYouLikeRsp = new STORE_APP_CLIENT$StGetGuessYouLikeRsp();
        try {
            sTORE_APP_CLIENT$StGetGuessYouLikeRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return sTORE_APP_CLIENT$StGetGuessYouLikeRsp;
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
