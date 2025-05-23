package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetSimpleCommentListReq;
import UserGrowth.stGetSimpleCommentListRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSScrollCommentRequest extends g<stGetSimpleCommentListRsp> {
    private static final String CMD_STRING = "GetSimpleCommentList";

    public WSScrollCommentRequest(String str, String str2) {
        super(CMD_STRING);
        this.req = new stGetSimpleCommentListReq(str, str2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetSimpleCommentListRsp> getRspClass() {
        return stGetSimpleCommentListRsp.class;
    }
}
