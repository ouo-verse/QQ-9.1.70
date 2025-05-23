package com.tencent.mobileqq.observer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.org.pb.oidb_0xe96$RspBody;
import com.tencent.qphone.base.util.QLog;
import face.FaceForeignIp$AvailableResponse;
import face.qqlogin.FaceCommon$EncryptContext;
import face.qqlogin.FaceSecureCheck$SecureCheckResponse;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$RspBody;
import tencent.im.oidb.oidb_0x5e1$RspBody;
import tencent.im.oidb.oidb_0x87a$RspBody;
import tencent.im.oidb.oidb_0x87c$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    private static final int CODE_IP_CANNOT_USE_FACE = 1;
    private static final String TAG = "LoginVerifyObserver";

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void checkSecureResponse(FaceSecureCheck$SecureCheckResponse faceSecureCheck$SecureCheckResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) faceSecureCheck$SecureCheckResponse);
        }
    }

    public void deleteFaceDataSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public void getAccountIdentitySuccess(cmd0x9ae$RspBody cmd0x9ae_rspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cmd0x9ae_rspbody);
        }
    }

    public void getAppConfigSuccess(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
        }
    }

    public void getEncContextSuccess(FaceCommon$EncryptContext faceCommon$EncryptContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) faceCommon$EncryptContext);
        }
    }

    public void getFaceStateSuccess(oidb_0x5e1$RspBody oidb_0x5e1_rspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) oidb_0x5e1_rspbody);
        }
    }

    public void getPhoneUnitySuccess(cmd0x9ae$RspBody cmd0x9ae_rspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cmd0x9ae_rspbody);
        }
    }

    public void getSecurePhoneSuccess(oidb_0xe96$RspBody oidb_0xe96_rspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) oidb_0xe96_rspbody);
        }
    }

    public void getTmpKeySuccess(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        }
    }

    public void ipJudgeSuccess(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str);
        }
    }

    public void onFailedResponse(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), str2);
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        String string = bundle.getString("cmd");
        if (!z16) {
            String string2 = bundle.getString(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_MSG, "");
            int i16 = bundle.getInt(MiniAppSendSmsCodeServlet.EXTRA_DATA_ERROR_CODE);
            QLog.e(TAG, 1, "LoginVerifyObserver onReceive error, code is : " + i16 + ", error msg is : " + string2 + " cmd is : " + string);
            onFailedResponse(string, i16, string2);
            return;
        }
        QLog.d(TAG, 1, "LoginVerifyObserver success, cmd is : " + string);
        byte[] byteArray = bundle.getByteArray("data");
        if (byteArray == null) {
            QLog.e(TAG, 1, "LoginVerifyObserver onReceive success but data is null");
            onFailedResponse(string, -1, "data is null");
            return;
        }
        if ("getTmpkey".equals(string)) {
            try {
                JSONObject jSONObject = new JSONObject(new String(byteArray));
                int optInt = jSONObject.optInt("ret", -1);
                if (optInt == 0) {
                    getTmpKeySuccess(jSONObject.optString("openid"), jSONObject.optString("tmpkey"));
                } else {
                    String optString = jSONObject.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG);
                    onFailedResponse(string, optInt, optString);
                    QLog.e(TAG, 1, "getTmpError, ret : " + optInt + "  error : " + optString);
                }
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "getTmpKey error : JSONException " + e16.getMessage());
                onFailedResponse(string, -1, e16.getMessage());
                return;
            }
        }
        if ("getEncContext".equals(string)) {
            try {
                JSONObject jSONObject2 = new JSONObject(new String(byteArray));
                int optInt2 = jSONObject2.optInt("ret", 0);
                if (optInt2 == 0) {
                    String optString2 = jSONObject2.optString("enc_context");
                    if (TextUtils.isEmpty(optString2)) {
                        QLog.e(TAG, 1, "getEncContext error : encContextStr is empty");
                        onFailedResponse(string, -1, "encrypt context invalid");
                        return;
                    }
                    try {
                        byte[] decode = Base64.decode(optString2, 11);
                        FaceCommon$EncryptContext faceCommon$EncryptContext = new FaceCommon$EncryptContext();
                        faceCommon$EncryptContext.mergeFrom(decode);
                        getEncContextSuccess(faceCommon$EncryptContext);
                        return;
                    } catch (Exception e17) {
                        QLog.e(TAG, 1, "getEncContext error : ", e17);
                        onFailedResponse(string, -1, e17.getMessage());
                        return;
                    }
                }
                onFailedResponse(string, optInt2, jSONObject2.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG));
                return;
            } catch (JSONException e18) {
                QLog.e(TAG, 1, "getEncContext error : JSONException " + e18.getMessage());
                onFailedResponse(string, -1, e18.getMessage());
                return;
            }
        }
        if ("getAppConfig".equals(string)) {
            try {
                JSONObject jSONObject3 = new JSONObject(new String(byteArray));
                int optInt3 = jSONObject3.optInt("ret", -1);
                if (optInt3 == 0) {
                    getAppConfigSuccess(Base64.decode(jSONObject3.optString("appconf_rsp"), 11));
                } else {
                    String optString3 = jSONObject3.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG);
                    onFailedResponse(string, optInt3, optString3);
                    QLog.e(TAG, 1, "getAppconf, ret : " + optInt3 + "  error : " + optString3);
                }
                return;
            } catch (JSONException e19) {
                QLog.e(TAG, 1, "getAppconf error : JSONException " + e19.getMessage());
                onFailedResponse(string, -1, e19.getMessage());
                return;
            }
        }
        if ("isIpForeign".equals(string)) {
            try {
                JSONObject jSONObject4 = new JSONObject(new String(byteArray));
                int optInt4 = jSONObject4.optInt("ret", -1);
                if (optInt4 == 0) {
                    byte[] decode2 = Base64.decode(jSONObject4.optString("available_rsp"), 11);
                    FaceForeignIp$AvailableResponse faceForeignIp$AvailableResponse = new FaceForeignIp$AvailableResponse();
                    faceForeignIp$AvailableResponse.mergeFrom(decode2);
                    ipJudgeSuccess(faceForeignIp$AvailableResponse.ret.get() != 1, faceForeignIp$AvailableResponse.f398125msg.get());
                    return;
                }
                String optString4 = jSONObject4.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG);
                QLog.e(TAG, 1, "IP_IS_FOREIGN_HTTPS, ret : ", Integer.valueOf(optInt4), " error : ", optString4);
                onFailedResponse(string, optInt4, optString4);
                return;
            } catch (Exception e26) {
                QLog.e(TAG, 1, "IP_IS_FOREIGN_HTTPS error : ", e26.getMessage());
                onFailedResponse(string, -1, e26.getMessage());
                return;
            }
        }
        if ("FaceRecognition.Available".equals(string)) {
            FaceForeignIp$AvailableResponse faceForeignIp$AvailableResponse2 = new FaceForeignIp$AvailableResponse();
            try {
                faceForeignIp$AvailableResponse2.mergeFrom(byteArray);
                ipJudgeSuccess(faceForeignIp$AvailableResponse2.ret.get() != 1, faceForeignIp$AvailableResponse2.f398125msg.get());
                return;
            } catch (InvalidProtocolBufferMicroException e27) {
                QLog.e(TAG, 1, "AvailableResponse merge from data error : ", e27.getMessage());
                onFailedResponse(string, -1, e27.getMessage());
                return;
            }
        }
        if ("FaceRecognition.SecureCheck".equals(string)) {
            FaceSecureCheck$SecureCheckResponse faceSecureCheck$SecureCheckResponse = new FaceSecureCheck$SecureCheckResponse();
            try {
                faceSecureCheck$SecureCheckResponse.mergeFrom(byteArray);
                int i17 = faceSecureCheck$SecureCheckResponse.uint32_errcode.get();
                if (i17 != 0) {
                    String str = faceSecureCheck$SecureCheckResponse.str_err_msg.get();
                    onFailedResponse(string, i17, str);
                    QLog.e(TAG, 1, "sso result error, ret : " + i17 + "  error : " + str);
                    return;
                }
                checkSecureResponse(faceSecureCheck$SecureCheckResponse);
                return;
            } catch (InvalidProtocolBufferMicroException e28) {
                QLog.e(TAG, 1, "SecureCheckResponse merge from data error : ", e28.getMessage());
                return;
            }
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.mergeFrom(byteArray);
            int i18 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i18 != 0) {
                String str2 = oidb_sso_oidbssopkg.str_error_msg.get();
                onFailedResponse(string, i18, str2);
                QLog.e(TAG, 1, "sso result error, ret : " + i18 + "  error : " + str2);
                return;
            }
            byte[] byteArray2 = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            if ("OidbSvc.0x5e1_295".equals(string)) {
                oidb_0x5e1$RspBody oidb_0x5e1_rspbody = new oidb_0x5e1$RspBody();
                oidb_0x5e1_rspbody.mergeFrom(byteArray2);
                getFaceStateSuccess(oidb_0x5e1_rspbody);
                return;
            }
            if ("OidbSvc.0x87c_108".equals(string)) {
                oidb_0x87c$RspBody oidb_0x87c_rspbody = new oidb_0x87c$RspBody();
                oidb_0x87c_rspbody.mergeFrom(byteArray2);
                verifySmsCodeSuccess(oidb_0x87c_rspbody);
                return;
            }
            if ("OidbSvc.0x87a_108".equals(string)) {
                oidb_0x87a$RspBody oidb_0x87a_rspbody = new oidb_0x87a$RspBody();
                oidb_0x87a_rspbody.mergeFrom(byteArray2);
                sendSmsCodeSuccess(oidb_0x87a_rspbody);
                return;
            }
            if ("OidbSvc.0x587_63".equals(string)) {
                deleteFaceDataSuccess();
                return;
            }
            if ("OidbSvc.0xe96_0".equals(string)) {
                oidb_0xe96$RspBody oidb_0xe96_rspbody = new oidb_0xe96$RspBody();
                oidb_0xe96_rspbody.mergeFrom(byteArray2);
                getSecurePhoneSuccess(oidb_0xe96_rspbody);
            } else {
                if ("OidbSvc.0xe9a_0".equals(string)) {
                    refreshPhoneSuccess();
                    return;
                }
                if (!"OidbSvc.0x9ae_13".equals(string) && !"OidbSvc.0x9ae_14".equals(string)) {
                    if ("OidbSvc.0x9ae_15".equals(string)) {
                        cmd0x9ae$RspBody cmd0x9ae_rspbody = new cmd0x9ae$RspBody();
                        cmd0x9ae_rspbody.mergeFrom(byteArray2);
                        getPhoneUnitySuccess(cmd0x9ae_rspbody);
                        return;
                    }
                    return;
                }
                cmd0x9ae$RspBody cmd0x9ae_rspbody2 = new cmd0x9ae$RspBody();
                cmd0x9ae_rspbody2.mergeFrom(byteArray2);
                getAccountIdentitySuccess(cmd0x9ae_rspbody2);
            }
        } catch (InvalidProtocolBufferMicroException e29) {
            onFailedResponse(string, -1, e29.getMessage());
        }
    }

    public void refreshPhoneSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void sendSmsCodeSuccess(oidb_0x87a$RspBody oidb_0x87a_rspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) oidb_0x87a_rspbody);
        }
    }

    public void verifySmsCodeSuccess(oidb_0x87c$RspBody oidb_0x87c_rspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) oidb_0x87c_rspbody);
        }
    }
}
