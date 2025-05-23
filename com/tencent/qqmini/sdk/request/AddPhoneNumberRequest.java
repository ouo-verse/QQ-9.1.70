package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StAddPhoneNumberReq;
import NS_MINI_INTERFACE.INTERFACE$StAddPhoneNumberRsp;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class AddPhoneNumberRequest extends ProtoBufRequest {
    private static final String TAG = "AddPhoneNumberRequest";
    private INTERFACE$StAddPhoneNumberReq req;

    public AddPhoneNumberRequest(String str, String str2, String str3, int i3) {
        INTERFACE$StAddPhoneNumberReq iNTERFACE$StAddPhoneNumberReq = new INTERFACE$StAddPhoneNumberReq();
        this.req = iNTERFACE$StAddPhoneNumberReq;
        iNTERFACE$StAddPhoneNumberReq.purePhoneNumber.set(str2);
        this.req.countryCode.set(str3);
        this.req.isSave.set(i3);
        this.req.appId.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return new byte[0];
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "GetPhoneNumber";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) throws Exception {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StAddPhoneNumberRsp iNTERFACE$StAddPhoneNumberRsp = new INTERFACE$StAddPhoneNumberRsp();
        try {
            iNTERFACE$StAddPhoneNumberRsp.mergeFrom(bArr);
            jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StAddPhoneNumberRsp.encryptedData.get());
            jSONObject.put("iv", iNTERFACE$StAddPhoneNumberRsp.f24957iv.get());
            jSONObject.put(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, iNTERFACE$StAddPhoneNumberRsp.phoneNumberID.get());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d(TAG, "onResponse fail." + e16);
            return null;
        }
    }
}
