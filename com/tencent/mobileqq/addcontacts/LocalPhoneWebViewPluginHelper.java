package com.tencent.mobileqq.addcontacts;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginregister.ILocalPhoneHttpModuleApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.login.GetLocalPhone$EncryptPhoneData;
import tencent.im.login.GetLocalPhone$MaskPhoneData;

/* loaded from: classes33.dex */
public class LocalPhoneWebViewPluginHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements ILocalPhoneHttpModuleApi.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JsBridgeListener f187253a;

        a(JsBridgeListener jsBridgeListener) {
            this.f187253a = jsBridgeListener;
        }

        private void c(JsBridgeListener jsBridgeListener, String str) {
            LocalPhoneWebViewPluginHelper.h(jsBridgeListener, false, "", "", str);
        }

        @Override // com.tencent.mobileqq.loginregister.ILocalPhoneHttpModuleApi.a
        public void a(int i3, Exception exc) {
            QLog.e("LocalPhoneWebViewPluginHelper", 1, "getMaskPhone onException ", exc);
            c(this.f187253a, "getMaskPhone catch exception. code: " + i3);
        }

        @Override // com.tencent.mobileqq.loginregister.ILocalPhoneHttpModuleApi.a
        public void b(GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData) {
            if (getLocalPhone$MaskPhoneData != null) {
                String str = getLocalPhone$MaskPhoneData.str_mask_phone.get();
                String str2 = getLocalPhone$MaskPhoneData.str_terms_wording.get();
                QLog.i("LocalPhoneWebViewPluginHelper", 2, "getMaskPhoneSuccess maskPhone: " + str + ", terms: " + str2);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    LocalPhoneWebViewPluginHelper.h(this.f187253a, true, str, str2, "");
                    return;
                }
            }
            c(this.f187253a, "getMaskPhone return empty data");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b implements ILocalPhoneHttpModuleApi.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JsBridgeListener f187254a;

        b(JsBridgeListener jsBridgeListener) {
            this.f187254a = jsBridgeListener;
        }

        private void c(JsBridgeListener jsBridgeListener, String str) {
            LocalPhoneWebViewPluginHelper.i(jsBridgeListener, false, "", str, 0);
        }

        @Override // com.tencent.mobileqq.loginregister.ILocalPhoneHttpModuleApi.b
        public void a(int i3, Exception exc) {
            QLog.e("LocalPhoneWebViewPluginHelper", 1, "getPhoneToken onException ", exc);
            c(this.f187254a, "getPhoneToken catch exception. code: " + i3);
        }

        @Override // com.tencent.mobileqq.loginregister.ILocalPhoneHttpModuleApi.b
        public void b(GetLocalPhone$EncryptPhoneData getLocalPhone$EncryptPhoneData) {
            if (getLocalPhone$EncryptPhoneData != null) {
                String str = getLocalPhone$EncryptPhoneData.str_encypt_phone.get();
                int i3 = getLocalPhone$EncryptPhoneData.compare_mibao_state.get();
                QLog.i("LocalPhoneWebViewPluginHelper", 2, "getPhoneNumSuccess phoneToken: " + str + ", compareMibaoState:" + i3);
                if (!TextUtils.isEmpty(str)) {
                    LocalPhoneWebViewPluginHelper.i(this.f187254a, true, str, "", i3);
                    return;
                }
            }
            QLog.e("LocalPhoneWebViewPluginHelper", 1, "getPhoneNumSuccess phoneData is null");
            c(this.f187254a, "getPhoneToken return null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return new String(Base64.encode(str.getBytes("utf-8"), 2), "utf-8");
            } catch (Exception e16) {
                QLog.e("LocalPhoneWebViewPluginHelper", 1, "base64Encode exception ", e16);
            }
        }
        return "";
    }

    public static void e(JsBridgeListener jsBridgeListener, String[] strArr) {
        int k3 = k(strArr);
        if (k3 < 0) {
            h(jsBridgeListener, false, "", "", "serviceType error");
        } else {
            ((ILocalPhoneHttpModuleApi) QRoute.api(ILocalPhoneHttpModuleApi.class)).getMaskPhoneNum(k3, new a(jsBridgeListener));
        }
    }

    public static void f(JsBridgeListener jsBridgeListener, String[] strArr) {
        int k3 = k(strArr);
        if (k3 < 0) {
            i(jsBridgeListener, false, "", "serviceType error", 0);
            return;
        }
        Bundle j3 = j(strArr);
        QLog.d("LocalPhoneWebViewPluginHelper", 1, "handleGetPhoneToken extras: " + j3);
        ((ILocalPhoneHttpModuleApi) QRoute.api(ILocalPhoneHttpModuleApi.class)).getPhoneToken(k3, j3, new b(jsBridgeListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(final JsBridgeListener jsBridgeListener, final boolean z16, final String str, final String str2, final String str3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.addcontacts.LocalPhoneWebViewPluginHelper.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("mask_phone", str);
                    jSONObject.put("terms_wording", str2);
                    jSONObject.put("result", z16 ? 0 : -1);
                    jSONObject.put("error_msg", str3);
                    jsBridgeListener.d(jSONObject);
                } catch (Exception e16) {
                    QLog.e("LocalPhoneWebViewPluginHelper", 1, "getMaskPhoneSuccess catch exception.", e16);
                    jsBridgeListener.e("notifyGetMaskPhoneResult onComplete catch jsonException. msg:" + str3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(final JsBridgeListener jsBridgeListener, final boolean z16, final String str, final String str2, final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.addcontacts.LocalPhoneWebViewPluginHelper.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("phone_token", LocalPhoneWebViewPluginHelper.d(str));
                    jSONObject.put("result", z16 ? 0 : -1);
                    jSONObject.put("error_msg", str2);
                    jSONObject.put("compare_mibao_state", i3);
                    jsBridgeListener.d(jSONObject);
                } catch (Exception e16) {
                    QLog.e("LocalPhoneWebViewPluginHelper", 1, "getPhoneToken onFail exception.", e16);
                    jsBridgeListener.e("onComplete catch jsonException. msg:" + str2);
                }
            }
        });
    }

    private static Bundle j(String[] strArr) {
        Bundle bundle = new Bundle();
        JSONObject l3 = l(strArr);
        if (l3 != null) {
            try {
                QLog.d("LocalPhoneWebViewPluginHelper", 4, "parseParamsToBundle json: " + l3);
                boolean optBoolean = l3.optBoolean("bool_compare_mibao");
                QLog.i("LocalPhoneWebViewPluginHelper", 1, "parseParamsToBundle needCompareMibao: " + optBoolean);
                bundle.putBoolean("bool_compare_mibao", optBoolean);
                String optString = l3.optString("logout_uin");
                if (!TextUtils.isEmpty(optString)) {
                    bundle.putString("uin", optString);
                }
                if (l3.has("sig_type") && l3.has("str_sig")) {
                    int optInt = l3.optInt("sig_type", -1);
                    String optString2 = l3.optString("str_sig", "");
                    bundle.putInt("sig_type", optInt);
                    bundle.putString("str_sig", optString2);
                }
            } catch (Exception e16) {
                QLog.e("LocalPhoneWebViewPluginHelper", 1, "parseParamsToBundle exception. ", e16);
            }
        }
        return bundle;
    }

    private static int k(String[] strArr) {
        int i3;
        JSONObject l3 = l(strArr);
        if (l3 == null) {
            QLog.e("LocalPhoneWebViewPluginHelper", 1, "parseServiceTypeFromArgs parseToJson error");
            return -1;
        }
        try {
            i3 = l3.getInt("service_type");
        } catch (JSONException e16) {
            QLog.e("LocalPhoneWebViewPluginHelper", 1, "parseServiceTypeFromArgs catch jsonException", e16);
        }
        if (i3 >= 0) {
            return i3;
        }
        QLog.e("LocalPhoneWebViewPluginHelper", 1, "parseServiceTypeFromArgs serviceType error. serviceType: " + i3);
        return -1;
    }

    private static JSONObject l(String[] strArr) {
        Object valueOf;
        if (strArr != null && strArr.length != 0) {
            String str = strArr[0];
            if (str != null && !str.isEmpty()) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e16) {
                    QLog.e("LocalPhoneWebViewPluginHelper", 1, "parseToJsonObj exception. " + str, e16);
                    return null;
                }
            }
            QLog.e("LocalPhoneWebViewPluginHelper", 1, "parseServiceTypeFromArgs error. str: " + str);
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("parseToJSONObj args: ");
        if (strArr == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(strArr.length);
        }
        sb5.append(valueOf);
        QLog.e("LocalPhoneWebViewPluginHelper", 1, sb5.toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (jsBridgeListener == null) {
            return;
        }
        if ("maskPhone".equalsIgnoreCase(str3)) {
            e(jsBridgeListener, strArr);
        } else if (BaseConstants.ATTR_KET_PHONE_TOKEN.equalsIgnoreCase(str3)) {
            f(jsBridgeListener, strArr);
        }
    }
}
