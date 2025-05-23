package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventObtainMidasConfigRequest implements GmCgDcEventRequest {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BodyObtainMidasConfigReq {
        String cmd = GmCgDcEventDefine.CMD_OBTAIN_MIDAS_CONFIG;

        BodyObtainMidasConfigReq() {
        }

        static String toJsonString() {
            return new Gson().toJson(new BodyObtainMidasConfigReq());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return BodyObtainMidasConfigReq.toJsonString();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_OBTAIN_MIDAS_CONFIG;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
