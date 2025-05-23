package com.tencent.biz.pubaccount.weishi.request;

import UserGrowth.stSimpleGetFeedDetailReq;
import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GetFeedDetailRequest extends g<stSimpleGetFeedDetailRsp> {
    private static final String CMD_STRING = "SimpleGetFeedDetail";
    private static final String TAG = "SimpleGetFeedDetailRequest";

    public GetFeedDetailRequest(String str, int i3, Map<String, Integer> map) {
        super(CMD_STRING, i3);
        stSimpleGetFeedDetailReq stsimplegetfeeddetailreq = new stSimpleGetFeedDetailReq();
        stsimplegetfeeddetailreq.feedid = str;
        stsimplegetfeeddetailreq.scene = i3;
        stsimplegetfeeddetailreq.feedsVideoType = map;
        this.req = stsimplegetfeeddetailreq;
        x.b(TAG, "stSimpleGetFeedDetailReq = " + stsimplegetfeeddetailreq.toString());
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stSimpleGetFeedDetailRsp> getRspClass() {
        return stSimpleGetFeedDetailRsp.class;
    }
}
