package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventSwitchInfoLayerRequest implements GmCgDcEventRequest {
    private String mPackageName;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BodySwitchInfoLayerReq {
        String cmd = GmCgDcEventDefine.CMD_SWITCH_INFO_LAYER;
        SwitchInfoLayerReq switchInfoLayerReq;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        static class SwitchInfoLayerReq {
            String packageName;

            SwitchInfoLayerReq() {
            }
        }

        BodySwitchInfoLayerReq(String str) {
            SwitchInfoLayerReq switchInfoLayerReq = new SwitchInfoLayerReq();
            this.switchInfoLayerReq = switchInfoLayerReq;
            switchInfoLayerReq.packageName = str;
        }

        static String toJsonString(String str) {
            return new Gson().toJson(new BodySwitchInfoLayerReq(str));
        }
    }

    public CGDcEventSwitchInfoLayerRequest(String str) {
        this.mPackageName = str;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return BodySwitchInfoLayerReq.toJsonString(this.mPackageName);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_SWITCH_INFO_LAYER;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
