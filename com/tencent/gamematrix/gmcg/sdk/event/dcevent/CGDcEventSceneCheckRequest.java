package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventSceneCheckRequest implements GmCgDcEventRequest {
    private String mModeId;
    private String mPackageName;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BodySceneCheckReq {
        String cmd = GmCgDcEventDefine.CMD_SCENE_CHECK_REQ;
        SceneCheckReq sceneCheckReq;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        static class SceneCheckReq {
            String modeId;
            String packageName;

            SceneCheckReq() {
            }
        }

        BodySceneCheckReq(String str, String str2) {
            SceneCheckReq sceneCheckReq = new SceneCheckReq();
            this.sceneCheckReq = sceneCheckReq;
            sceneCheckReq.packageName = str;
            sceneCheckReq.modeId = str2;
        }

        static String toJsonString(String str, String str2) {
            return new Gson().toJson(new BodySceneCheckReq(str, str2));
        }
    }

    public CGDcEventSceneCheckRequest(String str, String str2) {
        this.mPackageName = str;
        this.mModeId = str2;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return BodySceneCheckReq.toJsonString(this.mPackageName, this.mModeId);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_SCENE_CHECK_REQ;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
