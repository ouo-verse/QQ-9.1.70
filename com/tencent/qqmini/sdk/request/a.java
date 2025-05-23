package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE$StGetPhoneNumberReq;
import NS_MINI_INTERFACE.INTERFACE$StGetPhoneNumberRsp;
import NS_MINI_INTERFACE.INTERFACE$StPhoneNumber;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a extends ProtoBufRequest {

    /* renamed from: a, reason: collision with root package name */
    private INTERFACE$StGetPhoneNumberReq f348332a;

    public a(String str) {
        INTERFACE$StGetPhoneNumberReq iNTERFACE$StGetPhoneNumberReq = new INTERFACE$StGetPhoneNumberReq();
        this.f348332a = iNTERFACE$StGetPhoneNumberReq;
        iNTERFACE$StGetPhoneNumberReq.appId.set(str);
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected byte[] getBusiBuf() {
        return this.f348332a.toByteArray();
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getCmdName() {
        return "AddPhoneNumber";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    protected String getModule() {
        return "mini_user_info";
    }

    @Override // com.tencent.qqmini.sdk.request.ProtoBufRequest
    public JSONObject getResponse(byte[] bArr, JSONObject jSONObject) {
        if (bArr == null) {
            return null;
        }
        INTERFACE$StGetPhoneNumberRsp iNTERFACE$StGetPhoneNumberRsp = new INTERFACE$StGetPhoneNumberRsp();
        try {
            iNTERFACE$StGetPhoneNumberRsp.mergeFrom(bArr);
            List<INTERFACE$StPhoneNumber> list = iNTERFACE$StGetPhoneNumberRsp.phoneLists.get();
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (INTERFACE$StPhoneNumber iNTERFACE$StPhoneNumber : list) {
                    if (iNTERFACE$StPhoneNumber != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("phoneType", iNTERFACE$StPhoneNumber.phoneType.get());
                        jSONObject2.put("purePhoneNumber", iNTERFACE$StPhoneNumber.purePhoneNumber.get());
                        jSONObject2.put("countryCode", iNTERFACE$StPhoneNumber.countryCode.get());
                        jSONObject2.put("iv", iNTERFACE$StPhoneNumber.f24964iv.get());
                        jSONObject2.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StPhoneNumber.encryptedData.get());
                        jSONObject2.put(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, iNTERFACE$StPhoneNumber.phoneNumberID.get());
                        jSONArray.mo162put(jSONObject2);
                    }
                }
            }
            jSONObject.put("countryCode", iNTERFACE$StGetPhoneNumberRsp.countryCode.get());
            jSONObject.put("purePhoneNumber", iNTERFACE$StGetPhoneNumberRsp.purePhoneNumber.get());
            jSONObject.put("iv", iNTERFACE$StGetPhoneNumberRsp.f24960iv.get());
            jSONObject.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StGetPhoneNumberRsp.encryptedData.get());
            jSONObject.put("cloudID", "");
            jSONObject.put("phoneLists", jSONArray);
            jSONObject.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("getPhoneNumberRequest", "onResponse fail." + e16);
            return null;
        }
    }
}
