package com.tencent.qqmini.sdk.request;

import NS_MINI_APP_MISC.MISC$StTrans4RoomidReq;
import NS_MINI_APP_MISC.MISC$StTrans4RoomidRsp;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetTransRoomIdRequest extends ProtoBufRequest {
    private static final String TAG = "GetTransRoomIdRequest";
    private MISC$StTrans4RoomidReq req;

    public GetTransRoomIdRequest(String str, String str2) {
        MISC$StTrans4RoomidReq mISC$StTrans4RoomidReq = new MISC$StTrans4RoomidReq();
        this.req = mISC$StTrans4RoomidReq;
        mISC$StTrans4RoomidReq.appid.set(str);
        this.req.groupid.set(str2);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "Trans4Roomid";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_misc";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        MISC$StTrans4RoomidRsp mISC$StTrans4RoomidRsp = new MISC$StTrans4RoomidRsp();
        try {
            mISC$StTrans4RoomidRsp.mergeFrom(bArr);
            jSONObject.put("openId", mISC$StTrans4RoomidRsp.openid.get());
            jSONObject.put("tinyId", mISC$StTrans4RoomidRsp.tinyid.get());
            jSONObject.put("roomId", mISC$StTrans4RoomidRsp.roomid.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("GetTransRoomIdRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
