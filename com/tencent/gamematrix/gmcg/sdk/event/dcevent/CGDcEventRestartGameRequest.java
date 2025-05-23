package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventRestartGameRequest implements GmCgDcEventRequest {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BodyRestartGameReq {
        String cmd = GmCgDcEventDefine.CMD_RESTART_GAME;
        String restartGame = "";

        BodyRestartGameReq() {
        }

        static String toJsonString() {
            return new Gson().toJson(new BodyRestartGameReq());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return BodyRestartGameReq.toJsonString();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_RESTART_GAME;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
