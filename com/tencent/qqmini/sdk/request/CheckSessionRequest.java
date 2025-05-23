package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StCheckSessionReq;
import NS_MINI_INTERFACE.INTERFACE$StCheckSessionRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CheckSessionRequest extends ProtoBufRequest {
    private INTERFACE$StCheckSessionReq req;

    public CheckSessionRequest(String str) {
        INTERFACE$StCheckSessionReq iNTERFACE$StCheckSessionReq = new INTERFACE$StCheckSessionReq();
        this.req = iNTERFACE$StCheckSessionReq;
        iNTERFACE$StCheckSessionReq.appid.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "CheckSession";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_program_auth";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        try {
            new MessageMicro<INTERFACE$StCheckSessionRsp>() { // from class: NS_MINI_INTERFACE.INTERFACE$StCheckSessionRsp
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, INTERFACE$StCheckSessionRsp.class);
                public COMM.StCommonExt extInfo = new COMM.StCommonExt();
            }.mergeFrom(bArr);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("ProtoBufRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
