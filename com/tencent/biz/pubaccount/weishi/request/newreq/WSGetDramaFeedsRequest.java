package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetDramaFeedsReq;
import UserGrowth.stGetDramaFeedsRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import mz.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSGetDramaFeedsRequest extends g<stGetDramaFeedsRsp> {
    private static final String CMD_STRING = "GetDramaFeeds";
    private static final int IS_LOAD_DOWN = 0;
    private static final int IS_LOAD_UP = 1;

    public WSGetDramaFeedsRequest(c cVar, String str) {
        super(CMD_STRING);
        String d16;
        String c16;
        stGetDramaFeedsReq stgetdramafeedsreq = new stGetDramaFeedsReq();
        if (cVar.d() == null) {
            d16 = "";
        } else {
            d16 = cVar.d();
        }
        stgetdramafeedsreq.dramaID = d16;
        if (cVar.c() == null) {
            c16 = "";
        } else {
            c16 = cVar.c();
        }
        stgetdramafeedsreq.curFeedID = c16;
        stgetdramafeedsreq.refresh = !cVar.e() ? 1 : 0;
        stgetdramafeedsreq.attachInfo = str == null ? "" : str;
        this.req = stgetdramafeedsreq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetDramaFeedsRsp> getRspClass() {
        return stGetDramaFeedsRsp.class;
    }
}
