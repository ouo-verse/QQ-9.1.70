package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetSimpleRecommendDramaReq;
import UserGrowth.stGetSimpleRecommendDramaRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSDramaRequest extends g<stGetSimpleRecommendDramaRsp> {
    private static final String CMD_STRING = "GetSimpleRecommendDrama";

    public WSDramaRequest(String str) {
        super(CMD_STRING, 10012);
        stGetSimpleRecommendDramaReq stgetsimplerecommenddramareq = new stGetSimpleRecommendDramaReq();
        stgetsimplerecommenddramareq.enterDramaID = str;
        this.req = stgetsimplerecommenddramareq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetSimpleRecommendDramaRsp> getRspClass() {
        return stGetSimpleRecommendDramaRsp.class;
    }
}
