package com.tencent.mobileqq.vipgift;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c extends VasWebviewJsPlugin {
    private void openUrl(String str) {
        int i3;
        int i16;
        Activity a16 = this.mRuntime.a();
        if (a16 == null || this.mRuntime.e() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            JSONObject optJSONObject = jSONObject.optJSONObject("options");
            if (optJSONObject != null) {
                i16 = optJSONObject.optInt("style");
                i3 = optJSONObject.optInt("animation");
            } else {
                i3 = 0;
                i16 = 0;
            }
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Bundle extras = a16.getIntent().getExtras();
            extras.putString(AppConstants.LeftViewText.LEFTVIEWTEXT, "");
            if (i16 == 0) {
                extras.putBoolean("hide_more_button", false);
                extras.putBoolean("hide_operation_bar", true);
            } else if (i16 == 1) {
                extras.putBoolean("hide_more_button", true);
                extras.putBoolean("hide_operation_bar", true);
            } else if (i16 == 2) {
                extras.putBoolean("hide_more_button", false);
                extras.putBoolean("hide_operation_bar", false);
                extras.putString("webStyle", "");
            } else if (i16 == 3) {
                extras.putBoolean("hide_more_button", true);
                extras.putBoolean("hide_operation_bar", false);
                extras.putString("webStyle", "");
            }
            Intent intent = new Intent(a16, (Class<?>) QQBrowserActivity.class);
            intent.putExtras(extras);
            intent.putExtra("url", optString);
            intent.setFlags(0);
            a16.startActivityForResult(intent, 100);
            if (i3 == 1) {
                a16.overridePendingTransition(0, 0);
            } else {
                if (i3 != 2) {
                    return;
                }
                a16.overridePendingTransition(R.anim.f155030h6, 0);
            }
        } catch (JSONException unused) {
        }
    }

    private void p() {
        Activity a16 = this.mRuntime.a();
        if (a16 != null) {
            a16.finish();
        }
    }

    public void callPJs(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("VipGiftPlugin", 2, "method:" + str + ", json:" + str2);
        }
        callJs(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return QCircleDaTongConstant.ElementParamValue.GIFT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!QCircleDaTongConstant.ElementParamValue.GIFT.equals(str2)) {
            return false;
        }
        if ("openUrl".equals(str3) && strArr.length == 1) {
            openUrl(strArr[0]);
            p();
        } else if ("close".equals(str3) && strArr.length == 1) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String string = jSONObject.getString("callback");
                long j3 = jSONObject.getLong("version");
                Bundle bundle = new Bundle();
                bundle.putLong("version", j3);
                sendRemoteReq(com.tencent.mobileqq.emosm.a.a("close_version", string, this.mOnRemoteResp.key, bundle), false, false);
            } catch (Exception unused) {
            }
        } else if ("isFlowerVisible".equals(str3)) {
            try {
                sendRemoteReq(com.tencent.mobileqq.emosm.a.a("getFlowerVisibility", new JSONObject(strArr[0]).optString("callback"), this.mOnRemoteResp.key, new Bundle()), false, false);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } else if ("setFlowerVisibility".equals(str3)) {
            String str4 = null;
            try {
                JSONObject jSONObject2 = new JSONObject(strArr[0]);
                str4 = jSONObject2.optString("callback");
                int i3 = jSONObject2.getInt("isVisible");
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("isVisible", i3 == 1);
                sendRemoteReq(com.tencent.mobileqq.emosm.a.a("setFlowerVisibility", str4, this.mOnRemoteResp.key, bundle2), false, false);
            } catch (JSONException e17) {
                if (!TextUtils.isEmpty(str4)) {
                    callJs(str4, String.format("{\"result\": -2, \"message\":\"%s\"}", e17));
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        String format;
        if (bundle == null || bundle.getInt("respkey", 0) != this.mOnRemoteResp.key) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        String string = bundle.getString("cmd");
        String string2 = bundle.getString("callbackid");
        Bundle bundle2 = bundle.getBundle("response");
        if (string != null) {
            if ("close_version".equals(string)) {
                try {
                    jSONObject.put("result", bundle2.getInt("result"));
                    callPJs(string2, jSONObject.toString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                p();
                return;
            }
            if ("getFlowerVisibility".equals(string)) {
                callJs(string2, String.format("{\"result\":0, \"data\":{\"isVisible\":%d}}", Integer.valueOf(bundle2.getBoolean("result") ? 1 : 0)));
                return;
            }
            if ("setFlowerVisibility".equals(string)) {
                int i3 = bundle2.getInt("result");
                if (i3 == 0) {
                    format = "{\"result\":0}";
                } else {
                    format = String.format("{\"result\": %d, \"message\":\"Unknown error\"}", Integer.valueOf(i3));
                }
                callJs(string2, format);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        Activity a16;
        if (j3 == 8589934595L && (a16 = this.mRuntime.a()) != null && a16.getClass().getSimpleName().equals("VipGiftBrowserActivity")) {
            a16.finish();
        }
        return false;
    }
}
