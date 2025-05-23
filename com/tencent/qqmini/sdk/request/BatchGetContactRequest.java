package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StBatchGetContactReq;
import NS_MINI_INTERFACE.INTERFACE$StGetRobotUinRsp;
import com.tencent.qqmini.sdk.utils.GdtJsonPbUtil;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BatchGetContactRequest extends ProtoBufRequest {
    private static final String TAG = "VerifyPluginRequest";
    private INTERFACE$StBatchGetContactReq req;

    public BatchGetContactRequest(List<String> list) {
        INTERFACE$StBatchGetContactReq iNTERFACE$StBatchGetContactReq = new INTERFACE$StBatchGetContactReq();
        this.req = iNTERFACE$StBatchGetContactReq;
        iNTERFACE$StBatchGetContactReq.appids.set(list);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "BatchGetContact";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_app_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        INTERFACE$StGetRobotUinRsp iNTERFACE$StGetRobotUinRsp = new INTERFACE$StGetRobotUinRsp();
        iNTERFACE$StGetRobotUinRsp.mergeFrom(bArr);
        Object pbToJson = GdtJsonPbUtil.pbToJson(iNTERFACE$StGetRobotUinRsp);
        if (pbToJson instanceof JSONObject) {
            return (JSONObject) JSONObject.class.cast(pbToJson);
        }
        return null;
    }
}
