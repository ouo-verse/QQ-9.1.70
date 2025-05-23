package com.tencent.mobileqq.jsp;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qsec.qseccodec.SecCipher;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.api.IO3ReportApi;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class u extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private String f238911d;

    private static SecCipher.SecInfo p(String str) {
        return new SecCipher().decrypt(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "PrivacyEventProtocol";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("PrivacyEventProtocol", 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (!"PrivacyEventProtocol".equals(str2)) {
            return false;
        }
        if ("getSign".equals(str3) && strArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("moudleID");
                String optString2 = jSONObject.optString("source");
                this.f238911d = jSONObject.optString("callback", null);
                byte[] q16 = q(optString, optString2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sign", HexUtil.bytes2HexStr(q16));
                callJs(this.f238911d, jSONObject2.toString());
                if (QLog.isColorLevel()) {
                    QLog.d("PrivacyEventProtocol", 2, "PrivacyEventProtocol.getSign success");
                }
            } catch (JSONException e16) {
                QLog.e("PrivacyEventProtocol", 2, "getSign error: ", e16);
            }
            return true;
        }
        if ("decrypt".equals(str3) && strArr.length > 0) {
            try {
                JSONObject jSONObject3 = new JSONObject(strArr[0]);
                String optString3 = jSONObject3.optString("salt");
                this.f238911d = jSONObject3.optString("callback", null);
                SecCipher.SecInfo p16 = p(optString3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(NotificationCompat.CATEGORY_ERROR, String.valueOf(p16.err));
                jSONObject4.put("result", p16.result.toString());
                jSONObject4.put("ver", String.valueOf(p16.ver));
                callJs(this.f238911d, jSONObject4.toString());
                if (QLog.isColorLevel()) {
                    QLog.d("PrivacyEventProtocol", 2, "PrivacyEventProtocol.decrypt success");
                }
            } catch (JSONException e17) {
                QLog.e("PrivacyEventProtocol", 2, "decrypt error: ", e17);
            }
            return true;
        }
        if ("enterScene".equals(str3) && strArr.length > 0) {
            try {
                ee2.d.a(new JSONObject(strArr[0]).optString("scene"));
                if (QLog.isColorLevel()) {
                    QLog.d("PrivacyEventProtocol", 2, "PrivacyEventProtocol.enterScene");
                }
            } catch (JSONException e18) {
                QLog.e("PrivacyEventProtocol", 2, "enterScene error: ", e18);
            }
            return true;
        }
        if ("exitScene".equals(str3) && strArr.length > 0) {
            try {
                ee2.d.b(new JSONObject(strArr[0]).optString("scene"));
                if (QLog.isColorLevel()) {
                    QLog.d("PrivacyEventProtocol", 2, "PrivacyEventProtocol.exitScene");
                }
            } catch (JSONException e19) {
                QLog.e("PrivacyEventProtocol", 2, "exitScene error: ", e19);
            }
            return true;
        }
        if ("reportEvent".equals(str3) && strArr.length > 0) {
            try {
                JSONObject jSONObject5 = new JSONObject(strArr[0]);
                ee2.c.a(jSONObject5.optString("apiName"), jSONObject5.optString("scene"), jSONObject5.optString("infoDesc"));
                if (QLog.isColorLevel()) {
                    QLog.d("PrivacyEventProtocol", 2, "PrivacyEventProtocol.reportEvent success");
                }
            } catch (JSONException e26) {
                QLog.e("PrivacyEventProtocol", 2, "reportEvent error: ", e26);
            }
            return true;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    private static byte[] q(String str, String str2) {
        byte[] bArr = new byte[1];
        if (!com.tencent.mobileqq.fe.e.b().i()) {
            return bArr;
        }
        QSec.getInstance().initSign();
        byte[] liteSign = QSec.getInstance().getLiteSign(str, HexUtil.hexStr2Bytes(str2));
        ((IO3ReportApi) QRoute.api(IO3ReportApi.class)).report("sign_point", str, HexUtil.bytes2HexStr(liteSign));
        return liteSign;
    }
}
