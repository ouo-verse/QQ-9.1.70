package com.tencent.mobileqq.troop.honor;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.troop.b f297529d = null;

    private void init() {
        if (this.f297529d != null) {
            unInit();
        }
        if (this.f297529d == null) {
            com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
            this.f297529d = A;
            A.p();
        }
    }

    private void p(boolean z16, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopInteractionIconPlugin", 2, "getIsQunLevelGray value" + (z16 ? 1 : 0));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", z16 ? 1 : 0);
            callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("TroopInteractionIconPlugin", 1, "[callback] getTroopLevelGraySwitch exception.", e16);
        }
    }

    private boolean q(JSONObject jSONObject) {
        String optString = jSONObject.optString("callback");
        String optString2 = jSONObject.optString("gc");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            p(true, optString);
            return true;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d("TroopInteractionIconPlugin", 2, "callback : " + optString + ",troopUin : " + optString2);
        return false;
    }

    private boolean r(JSONObject jSONObject) {
        String optString = jSONObject.optString("gc");
        if (TextUtils.isEmpty(optString)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopInteractionIconPlugin", 2, "goToChat troopUin : " + optString);
            }
            return false;
        }
        Activity a16 = this.mRuntime.a();
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a16), new int[]{2});
        m3.addFlags(4194304);
        m3.putExtra("uin", optString);
        m3.putExtra("uintype", 1);
        a16.startActivity(m3);
        a16.overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        return true;
    }

    private boolean s(JSONObject jSONObject) {
        String optString = jSONObject.optString("gc");
        if (TextUtils.isEmpty(optString)) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("TroopInteractionIconPlugin", 2, "goToSign troopUin : " + optString);
            return false;
        }
        Intent intent = new Intent(this.mRuntime.a(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://qun.qq.com/qqweb/m/qun/checkin/index.html?_bid=2485&_wv=67108867&gc=" + optString + "&state=1");
        this.mRuntime.a().startActivity(intent);
        return true;
    }

    private boolean t(JSONObject jSONObject) {
        Activity a16;
        String optString = jSONObject.optString("gc");
        if (TextUtils.isEmpty(optString)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopInteractionIconPlugin", 2, "gotoClockIn troopUin : " + optString);
            }
            return false;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || (a16 = bVar.a()) == null) {
            return false;
        }
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a16), new int[]{2});
        m3.addFlags(4194304);
        m3.putExtra("uin", optString);
        m3.putExtra("uintype", 1);
        m3.putExtra(AppConstants.Key.KEY_OPEN_TOGETHER_PANEL, true);
        a16.startActivity(m3);
        a16.overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        return true;
    }

    private boolean u(JSONObject jSONObject) {
        String optString = jSONObject.optString("callback");
        String optString2 = jSONObject.optString("grayType");
        String optString3 = jSONObject.optString("gc");
        if (!optString2.equals("dragonPrivilege")) {
            return false;
        }
        x51.a aVar = (x51.a) am.s().x(609);
        int i3 = (aVar == null || !aVar.a(optString3)) ? 0 : 1;
        if (QLog.isColorLevel()) {
            QLog.d("TroopInteractionIconPlugin", 2, "value" + i3);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(optString2, i3);
            callJs(optString, jSONObject2.toString());
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private void unInit() {
        com.tencent.biz.troop.b bVar = this.f297529d;
        if (bVar != null) {
            bVar.q();
            this.f297529d = null;
        }
    }

    private boolean v(JSONObject jSONObject) {
        String optString = jSONObject.optString("gc");
        String optString2 = jSONObject.optString("text");
        Activity a16 = this.mRuntime.a();
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(a16), new int[]{2});
        m3.addFlags(4194304);
        m3.putExtra("uin", optString);
        m3.putExtra("uintype", 1);
        m3.putExtra("chat_inputBarContent", optString2);
        a16.startActivity(m3);
        a16.overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "groupInteractionIcon";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"groupInteractionIcon".equals(str2)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            if (str3.equals("getGroupGrayFlag")) {
                return u(jSONObject);
            }
            if (str3.equals("jumpToAIOAndFillText")) {
                return v(jSONObject);
            }
            if (str3.equals("isQunLevelGray")) {
                return q(jSONObject);
            }
            if (str3.equals("gotoChat")) {
                return r(jSONObject);
            }
            if (str3.equals("gotoSign")) {
                return s(jSONObject);
            }
            if (str3.equals("gotoYQHEntranceSign")) {
                return t(jSONObject);
            }
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        unInit();
        super.onDestroy();
    }
}
