package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetTCBTicketReq;
import NS_MINI_INTERFACE.INTERFACE$StGetTCBTicketRsp;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetTcbTicketRequest extends ProtoBufRequest {
    private static final String TAG = "GetTcbTicketRequest";
    private INTERFACE$StGetTCBTicketReq req;

    public GetTcbTicketRequest(COMM.StCommonExt stCommonExt, String str, String str2) {
        INTERFACE$StGetTCBTicketReq iNTERFACE$StGetTCBTicketReq = new INTERFACE$StGetTCBTicketReq();
        this.req = iNTERFACE$StGetTCBTicketReq;
        iNTERFACE$StGetTCBTicketReq.appid.set(str);
        this.req.envId.set(str2);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetTCBTicket";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetTCBTicketRsp iNTERFACE$StGetTCBTicketRsp = new INTERFACE$StGetTCBTicketRsp();
        try {
            iNTERFACE$StGetTCBTicketRsp.mergeFrom(bArr);
            jSONObject.put("ticket", iNTERFACE$StGetTCBTicketRsp.ticket.get());
            jSONObject.put(WadlProxyConsts.CREATE_TIME, iNTERFACE$StGetTCBTicketRsp.createTime.get());
            jSONObject.put("period", iNTERFACE$StGetTCBTicketRsp.period.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("GetTcbTicketRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
