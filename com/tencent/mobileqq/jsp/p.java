package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class p extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private Context f238898d;

    /* renamed from: e, reason: collision with root package name */
    private String f238899e;

    private Context getCurrentContext() {
        Activity a16 = this.mRuntime.a();
        while (a16 != null && (a16 instanceof BasePluginActivity)) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private void p() {
        if (QLog.isDevelopLevel()) {
            QLog.i("MedalWallMng", 4, "clearRedPoint from web!");
        }
        com.tencent.mobileqq.campuscircle.a.c().h();
    }

    private void q(String str) {
        String str2;
        String currentAccountUin = this.mRuntime.b().getCurrentAccountUin();
        boolean z16 = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + currentAccountUin, 4).getBoolean("medal_switch_disable", false);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArr = new String[1];
        if (z16) {
            str2 = "{\"isOn\":0}";
        } else {
            str2 = "{\"isOn\":1}";
        }
        strArr[0] = str2;
        callJs(str, strArr);
    }

    private void r(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("callback");
            this.f238899e = optString;
            q(optString);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MedalApi", 2, "shareMsg error: " + e16.toString());
            }
        }
    }

    private void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f238899e = new JSONObject(str).optString("callback");
            PublicFragmentActivity.start(getContext(), new Intent(), PrivacyShowSettingFragment.class);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MedalApi", 2, "shareMsg error: " + e16.toString());
            }
        }
    }

    public Context getContext() {
        return this.f238898d;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "medalwall";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"medalwall".equals(str2)) {
            return false;
        }
        if (jsBridgeListener != null) {
            boolean z16 = jsBridgeListener.f314008c;
        }
        addOpenApiListenerIfNeeded(str3, jsBridgeListener);
        if ("getMedalSwitch".equals(str3)) {
            r(strArr[0]);
            return true;
        }
        if ("jumpToMedalSettings".equals(str3)) {
            s(strArr[0]);
            return true;
        }
        if (!"clearRedPoint".equals(str3)) {
            return true;
        }
        p();
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (b16 == 100) {
            q(this.f238899e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f238898d = getCurrentContext();
    }
}
