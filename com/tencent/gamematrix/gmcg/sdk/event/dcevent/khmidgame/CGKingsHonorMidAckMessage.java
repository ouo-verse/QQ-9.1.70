package com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame;

import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGKingsHonorMidAckMessage {
    public long ack;
    public int retry_times;
    public String type = GmCgDcEventDefine.HK_EVENT_MIDGAME_ACK;
    public long seq = 0;

    public CGKingsHonorMidAckMessage(long j3, int i3) {
        this.ack = j3;
        this.retry_times = i3;
    }

    public String toJson() {
        return CGJsonUtil.toJson(this);
    }
}
