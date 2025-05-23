package com.tencent.biz.pubaccount.weishi.request;

import UserGrowth.stRedDotReq;
import UserGrowth.stRedDotRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RedDotRequest extends g<stRedDotRsp> {
    private static final String CMD_STRING = "RedDot";
    public static final int REQUEST_GET_REDDOT = 1001;

    public RedDotRequest() {
        super("RedDot", 10001);
        this.req = new stRedDotReq(111, 1, null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean canRequestRetry() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stRedDotRsp> getRspClass() {
        return stRedDotRsp.class;
    }
}
