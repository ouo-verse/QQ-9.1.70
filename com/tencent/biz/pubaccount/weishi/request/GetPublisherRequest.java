package com.tencent.biz.pubaccount.weishi.request;

import UserGrowth.stPublisherReq;
import UserGrowth.stPublisherRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.util.x;

/* loaded from: classes32.dex */
public class GetPublisherRequest extends g<stPublisherRsp> {
    private static final String CMD_STRING = "Publisher";
    private static final String TAG = "GetPublisherRequest";

    public GetPublisherRequest() {
        super(CMD_STRING, 10004);
        stPublisherReq stpublisherreq = new stPublisherReq();
        this.req = stpublisherreq;
        x.b(TAG, "stSimpleGetFeedDetailReq = " + stpublisherreq.toString());
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stPublisherRsp> getRspClass() {
        return stPublisherRsp.class;
    }
}
