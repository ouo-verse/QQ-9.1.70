package com.tencent.ecommerce.biz.register.network;

import com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import cooperation.qzone.remote.ServiceConst;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/register/network/i;", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "Lcom/tencent/ecommerce/biz/register/network/j;", "Lcom/tencent/ecommerce/biz/register/network/k;", "params", "Lorg/json/JSONObject;", "b", "", "rsp", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i implements IECNetworkJsonContracts<ECVerifyFaceReqParam, ECVerifyFaceResp> {
    @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ECVerifyFaceResp decodeResponse(byte[] rsp) {
        JSONObject c16 = com.tencent.ecommerce.base.network.api.c.c(rsp);
        return new ECVerifyFaceResp(c16.optBoolean("result", false), 0, c16.optString(ServiceConst.PARA_SESSION_ID, ""));
    }

    @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject encodeRequestParams(ECVerifyFaceReqParam params) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("skey_type", 7);
        jSONObject.put("app_id", params.appId);
        jSONObject.put("open_id", params.openId);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id_card_num", params.idCardNum);
        jSONObject2.put("cer_name", params.cerName);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("login_info", jSONObject);
        jSONObject3.put("cert_info", jSONObject2);
        jSONObject3.put(RemoteCommand.RESULT_KEY, params.idKey);
        jSONObject3.put("nonce", params.nonce);
        jSONObject3.put(ServiceConst.PARA_SESSION_ID, params.getSessionId());
        return jSONObject3;
    }
}
