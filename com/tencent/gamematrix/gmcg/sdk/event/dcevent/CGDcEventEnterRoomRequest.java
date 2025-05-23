package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.google.gson.Gson;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGDcEventEnterRoomRequest implements GmCgDcEventRequest {
    private String mRoomId;
    private String mRoomPwd;
    private String mRoomT;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static class BodyEnterRoomReq {
        String cmd = GmCgDcEventDefine.CMD_ROOM_ENTER;
        EnterRoomReq enterRoomReq;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        static class EnterRoomReq {
            String roomId;
            String roomPwd;
            String roomT;

            EnterRoomReq() {
            }
        }

        BodyEnterRoomReq(String str, String str2, String str3) {
            EnterRoomReq enterRoomReq = new EnterRoomReq();
            this.enterRoomReq = enterRoomReq;
            enterRoomReq.roomId = str;
            enterRoomReq.roomPwd = str2;
            enterRoomReq.roomT = str3;
        }

        static String toJsonString(String str, String str2, String str3) {
            return new Gson().toJson(new BodyEnterRoomReq(str, str2, str3));
        }
    }

    public CGDcEventEnterRoomRequest(String str, String str2, String str3) {
        this.mRoomId = str;
        this.mRoomPwd = str2;
        this.mRoomT = str3;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String generateDcEventDataToSend() {
        return BodyEnterRoomReq.toJsonString(this.mRoomId, this.mRoomPwd, this.mRoomT);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_ROOM_ENTER;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest
    public /* synthetic */ int provideDcEventSeq() {
        return com.tencent.gamematrix.gmcg.api.a.a(this);
    }
}
