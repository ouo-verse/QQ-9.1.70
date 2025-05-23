package com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.a;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.helper.CGNestedJsonBuilder;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventKingsHonorMidAckRequest implements GmCgDcEventRequest {
    private final CGKingsHonorMidAckMessage mAck;

    public CGDcEventKingsHonorMidAckRequest(CGKingsHonorMidAckMessage cGKingsHonorMidAckMessage) {
        this.mAck = cGKingsHonorMidAckMessage;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return new CGNestedJsonBuilder().put("event", this.mAck.toJson()).wrapUp("data", false).put("cmd", GmCgDcEventDefine.HK_EVENT_CLIENT_NOTIFY).wrapUp("androidEvent", false).put("cmd", GmCgDcEventDefine.CMD_ANDROID_EVENT).build().toString();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_ANDROID_EVENT;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return a.a(this);
    }
}
