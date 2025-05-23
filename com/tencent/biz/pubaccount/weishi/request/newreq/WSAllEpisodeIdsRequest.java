package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetAllFeedsByDramaIDReq;
import UserGrowth.stGetAllFeedsByDramaIDRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSAllEpisodeIdsRequest extends g<stGetAllFeedsByDramaIDRsp> {
    private static final String CMD_STRING = "GetAllFeedsByDramaID";

    public WSAllEpisodeIdsRequest(String str) {
        super(CMD_STRING);
        stGetAllFeedsByDramaIDReq stgetallfeedsbydramaidreq = new stGetAllFeedsByDramaIDReq();
        stgetallfeedsbydramaidreq.dramaID = str;
        this.req = stgetallfeedsbydramaidreq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetAllFeedsByDramaIDRsp> getRspClass() {
        return stGetAllFeedsByDramaIDRsp.class;
    }
}
