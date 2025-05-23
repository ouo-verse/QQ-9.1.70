package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventRefreshGameRequest implements GmCgDcEventRequest {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BodyGameStartReq {
        String cmd = GmCgDcEventDefine.CMD_GAME_START;
        String gameStart = "";

        BodyGameStartReq() {
        }

        static String toJsonString() {
            return new Gson().toJson(new BodyGameStartReq());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return BodyGameStartReq.toJsonString();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_GAME_START;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
