package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stGetCollectionReq;
import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSCollectionRequest extends g<stGetCollectionRsp> {
    private static final String CMD_STRING = "GetCollection";

    public WSCollectionRequest(String str, String str2, String str3, int i3, int i16) {
        super(CMD_STRING, i3);
        stGetCollectionReq stgetcollectionreq = new stGetCollectionReq();
        stgetcollectionreq.cid = str;
        stgetcollectionreq.attachInfo = str3;
        stgetcollectionreq.scene = i3;
        stgetcollectionreq.feedId = str2;
        stgetcollectionreq.pageOrder = i16;
        this.req = stgetcollectionreq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stGetCollectionRsp> getRspClass() {
        return stGetCollectionRsp.class;
    }
}
