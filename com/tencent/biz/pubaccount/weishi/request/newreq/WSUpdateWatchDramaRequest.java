package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stUpdateWatchDramaReq;
import UserGrowth.stUpdateWatchDramaRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSUpdateWatchDramaRequest extends g<stUpdateWatchDramaRsp> {
    private static final String CMD_STRING = "UpdateWatchDrama";

    public WSUpdateWatchDramaRequest(String str, String str2, int i3, int i16) {
        super(CMD_STRING);
        stUpdateWatchDramaReq stupdatewatchdramareq = new stUpdateWatchDramaReq();
        stupdatewatchdramareq.dramaID = str;
        stupdatewatchdramareq.feedNum = i3;
        stupdatewatchdramareq.feedSecond = i16;
        stupdatewatchdramareq.feedID = str2;
        this.req = stupdatewatchdramareq;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stUpdateWatchDramaRsp> getRspClass() {
        return stUpdateWatchDramaRsp.class;
    }
}
