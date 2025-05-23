package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventGameLoginStateRequest implements GmCgDcEventRequest {
    private int mCode;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BodyAndroidEvent {
        BodyGameLoginStateReq androidEvent;
        String cmd = GmCgDcEventDefine.CMD_ANDROID_EVENT;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        static class BodyGameLoginStateReq {
            String cmd = GmCgDcEventDefine.CGSDK_LOGIN_RESPONSE;
            GameLoginStateReq data;

            /* compiled from: P */
            /* loaded from: classes6.dex */
            static class GameLoginStateReq {
                int code;

                /* renamed from: msg, reason: collision with root package name */
                String f107691msg = "";

                public GameLoginStateReq(int i3) {
                    this.code = i3;
                }
            }

            BodyGameLoginStateReq(int i3) {
                this.data = new GameLoginStateReq(i3);
            }
        }

        public BodyAndroidEvent(int i3) {
            this.androidEvent = new BodyGameLoginStateReq(i3);
        }

        static String toJsonString(int i3) {
            return new Gson().toJson(new BodyAndroidEvent(i3));
        }
    }

    public CGDcEventGameLoginStateRequest(int i3) {
        this.mCode = i3;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return BodyAndroidEvent.toJsonString(this.mCode);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CGSDK_LOGIN_RESPONSE;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
