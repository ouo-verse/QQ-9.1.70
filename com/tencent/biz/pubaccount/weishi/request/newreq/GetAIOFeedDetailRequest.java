package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetAIOFeedDetailReq;
import UserGrowth.stGetAIOFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GetAIOFeedDetailRequest extends g<stGetAIOFeedDetailRsp> {
    private static final String CMD = "GetAIOFeedDetail";

    public GetAIOFeedDetailRequest() {
        super(CMD, 10008);
        this.req = new stGetAIOFeedDetailReq();
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetAIOFeedDetailRsp> getRspClass() {
        return stGetAIOFeedDetailRsp.class;
    }
}
