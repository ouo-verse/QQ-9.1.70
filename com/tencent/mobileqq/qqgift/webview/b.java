package com.tencent.mobileqq.qqgift.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            callJs(str, jSONObject.toString());
        } catch (Throwable th5) {
            QLog.e("QQGiftJsPlugin", 1, "[callJsOk] callbackId:" + str + ", e:" + th5.getMessage());
        }
    }

    private void q(JSONObject jSONObject, String str) throws JSONException {
        String string = jSONObject.getString("msg");
        int i3 = jSONObject.getInt("code");
        Activity a16 = this.mRuntime.a();
        boolean z16 = false;
        int intExtra = a16.getIntent().getIntExtra("extra_web_recharge_callback_key", 0);
        int intExtra2 = a16.getIntent().getIntExtra("extra_web_open_recharge_process_id_key", 0);
        int intExtra3 = a16.getIntent().getIntExtra("extra_web_scene_id_key", 0);
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftJsPlugin", 2, "[closeChargePanel] json:" + jSONObject + ", busId:" + intExtra3 + ", process:" + intExtra2 + ", callbackKey:" + intExtra);
        }
        if (MobileQQ.sProcessId == intExtra2) {
            IQQGiftRechargeModule f16 = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(intExtra3).f();
            if (i3 == 0) {
                z16 = true;
            }
            f16.a(intExtra, z16, i3, string);
        } else {
            Bundle bundle = new Bundle();
            if (i3 == 0) {
                z16 = true;
            }
            bundle.putBoolean("params_key_success", z16);
            bundle.putInt("params_key_code", i3);
            bundle.putString("params_key_msg", string);
            bundle.putInt("params_key_business_id", intExtra3);
            bundle.putInt("params_key_callback_key", intExtra);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QQGiftServerIPCModule", "action_notify_recharge_callback", bundle);
        }
        try {
            this.mRuntime.a().finish();
        } catch (Exception e16) {
            QLog.e("QQGiftJsPlugin", 1, "mRuntime.getActivity().finish() e:" + e16.getMessage());
        }
        p(str);
    }

    private boolean r(String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        try {
            if (strArr.length > 0) {
                jSONObject = new JSONObject(strArr[0]);
            } else {
                jSONObject = new JSONObject();
            }
            String optString = jSONObject.optString("callback", "");
            if ("closeChargePanel".equals(str3)) {
                q(jSONObject, optString);
            } else if ("refreshToken".equals(str3)) {
                u(str, optString);
            } else if ("chargePageLoaded".equals(str3)) {
                t(jSONObject, optString);
            } else if ("openFullScreenUrl".equals(str3)) {
                v(jSONObject, optString);
            }
        } catch (Exception e16) {
            QLog.e("QQGiftJsPlugin", 1, "[handleJsRequest] method:" + str3 + ", e:" + e16.getMessage());
        }
        return true;
    }

    private boolean s(String str) {
        return getNameSpace().equalsIgnoreCase(str);
    }

    private void t(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGiftJsPlugin", 2, "onChargePageLoaded");
        }
    }

    private void u(String str, String str2) throws JSONException {
        String b16 = a.a().b();
        if (b16 != null) {
            a.a().c(this.mRuntime.a().getApplicationContext(), b16);
            p(str2);
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -1);
            jSONObject.put("message", "get p_skey null");
            callJs(str2, jSONObject.toString());
        }
    }

    private void v(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String stringExtra;
        String optString = jSONObject.optString("url");
        JSONObject optJSONObject = jSONObject.optJSONObject("options");
        Activity a16 = this.mRuntime.a();
        if (a16 != null) {
            Intent intent = a16.getIntent();
            Intent intent2 = new Intent(a16, (Class<?>) QQBrowserActivity.class);
            intent2.setData(Uri.parse(optString));
            intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
            String str3 = null;
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("businessId", null);
            } else {
                str2 = null;
            }
            if (str2 != null) {
                stringExtra = str2;
            } else if (intent == null) {
                stringExtra = null;
            } else {
                stringExtra = intent.getStringExtra("big_brother_source_key");
            }
            intent2.putExtra("big_brother_source_key", stringExtra);
            if (intent != null) {
                str3 = intent.getStringExtra(LaunchParam.KEY_REF_ID);
                if (TextUtils.isEmpty(str3)) {
                    str3 = intent.getStringExtra("big_brother_source_key");
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                str2 = str3;
            }
            intent2.putExtra(LaunchParam.KEY_REF_ID, str2);
            intent2.putExtra("url", optString);
            intent2.setFlags(0);
            if (optJSONObject != null && optJSONObject.optInt("target") == 1) {
                intent2.putExtra("articalChannelId", 0);
            }
            a16.startActivity(intent2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "qq_gift";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), map)).booleanValue();
        }
        if (j3 != 8589934610L && j3 != 8589934601L) {
            return super.handleEvent(str, j3, map);
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            this.mRuntime.a().finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (s(str2)) {
            return r(str, str2, str3, strArr);
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
        }
    }
}
