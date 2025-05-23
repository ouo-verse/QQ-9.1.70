package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.l;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.s;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.net.URLDecoder;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class MQPSecJsPlugin extends VasWebviewJsPlugin implements l {
    public static final String KEY_FROM = "keyFrom";
    public static final String KEY_RANDSTR = "randstr";
    public static final String NAMESPACE_DEV_LOCK = "EquipLockManager";
    public static final String NAMESPACE_PUZZLE_VERIFY_CODE = "CAPTCHA";
    public static final String NAMESPACE_SET_PWD = "SetPwdJsInterface";
    private static final String tag = "MQPSecJsPlugin";
    boolean isSubaccount;
    boolean needResult;
    String resultMobileMask;
    String resultUin;
    String subAccountUin;
    String tagRequest;
    protected Activity activity = null;
    private QQProgressDialog progressDialog = null;
    private boolean waittingResponse = false;
    String resultSppkey = null;
    int resultState = 1;
    boolean resultSetMobile = false;
    private boolean mOpenDevlockCalled = false;
    private boolean mIsCloseWeb = true;

    private void hideProgressDialog() {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MQPSecJsPlugin.this.progressDialog != null && MQPSecJsPlugin.this.progressDialog.isShowing()) {
                        MQPSecJsPlugin.this.progressDialog.dismiss();
                        MQPSecJsPlugin.this.progressDialog.cancel();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                MQPSecJsPlugin.this.progressDialog = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onBackEvent() {
        if (this.resultState == 2 && !TextUtils.isEmpty(this.resultSppkey) && !this.mOpenDevlockCalled) {
            this.mOpenDevlockCalled = true;
            openEquipmentLock(this.resultUin, this.resultMobileMask, this.resultSppkey);
        } else if (!this.waittingResponse) {
            closeWeb(true);
            return false;
        }
        return true;
    }

    private void showProgressDialog() {
        this.mRuntime.a().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                s g16;
                try {
                    if (MQPSecJsPlugin.this.progressDialog == null && !MQPSecJsPlugin.this.activity.isFinishing() && (g16 = MQPSecJsPlugin.this.mRuntime.g()) != null && g16.getWebTitleBarInterface() != null) {
                        MQPSecJsPlugin.this.progressDialog = new QQProgressDialog(MQPSecJsPlugin.this.activity, g16.getWebTitleBarInterface().getTitleBarHeight());
                        MQPSecJsPlugin.this.progressDialog.setCancelable(false);
                        MQPSecJsPlugin.this.progressDialog.setMessage(R.string.cpr);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (MQPSecJsPlugin.this.progressDialog != null && !MQPSecJsPlugin.this.progressDialog.isShowing()) {
                    MQPSecJsPlugin.this.progressDialog.show();
                }
            }
        });
    }

    public void changeEquipLockMobile(String str, String str2, String str3) {
        this.resultState = 3;
        this.resultUin = str;
        this.resultMobileMask = str2;
        this.resultSppkey = str3;
        closeWeb(false);
    }

    public void closeWeb(boolean z16) {
        if (this.needResult) {
            Intent intent = new Intent();
            intent.putExtra("resultMobileMask", this.resultMobileMask);
            intent.putExtra("resultUin", this.resultUin);
            intent.putExtra("resultSppkey", this.resultSppkey);
            intent.putExtra("resultState", this.resultState);
            if (this.resultState == 2) {
                intent.putExtra("resultSetMobile", this.resultSetMobile);
            }
            if (z16) {
                this.activity.setResult(0, intent);
            } else {
                this.activity.setResult(-1, intent);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "close Web");
        }
        hideProgressDialog();
        this.activity.finish();
    }

    @Override // com.tencent.mobileqq.webview.swift.l
    public String[] getMultiNameSpace() {
        return new String[]{NAMESPACE_SET_PWD, NAMESPACE_DEV_LOCK, NAMESPACE_PUZZLE_VERIFY_CODE};
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2149629952L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!NAMESPACE_DEV_LOCK.equalsIgnoreCase(str2) && !NAMESPACE_SET_PWD.equalsIgnoreCase(str2) && !NAMESPACE_PUZZLE_VERIFY_CODE.equalsIgnoreCase(str2)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "pkg: " + str2 + ", method: " + str3 + ", url: " + URLDecoder.decode(str));
        }
        if ("openDevLock".equals(str3)) {
            JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
            }
            try {
                String optString = jsonFromJSBridge.optString("callback");
                String optString2 = jsonFromJSBridge.optString("devlockOpenSource");
                boolean optBoolean = jsonFromJSBridge.optBoolean("showAuthDevList");
                String string = jsonFromJSBridge.getString("title");
                String string2 = jsonFromJSBridge.getString("wording");
                String string3 = jsonFromJSBridge.getString("button");
                String string4 = jsonFromJSBridge.getString("jumpText");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("title", string);
                jSONObject.put("wording", string2);
                jSONObject.put("image_res_id", R.drawable.ers);
                jSONObject.put("btn_text", string3);
                jSONObject.put("jump_text", string4);
                jSONObject.put("jump_url", "");
                openDevLock(optBoolean, optString2, jSONObject.toString(), optString);
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(tag, 2, "openDevLock parse url param failed" + e16.getMessage());
                }
                return true;
            }
        }
        return call(str3, Arrays.asList(strArr));
    }

    public void handleWebError(String str, String str2, String str3) {
        this.resultState = 1;
        this.resultUin = str;
        this.resultMobileMask = str2;
        this.resultSppkey = str3;
        closeWeb(false);
    }

    public void isNotNet() {
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "SetPwdJsPlugin isNotNet ");
        }
        new Handler(this.activity.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                s g16 = MQPSecJsPlugin.this.mRuntime.g();
                if (g16 != null && g16.getWebTitleBarInterface() != null) {
                    Activity activity = MQPSecJsPlugin.this.activity;
                    QQToast.makeText(activity, activity.getString(R.string.b3j), 0).show(g16.getWebTitleBarInterface().getTitleBarHeight());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    void onBindedToClient() {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        Intent intent = activity.getIntent();
        if ((intent.getLongExtra("business", 0L) & 32768) != 0) {
            String stringExtra = intent.getStringExtra("uin");
            Bundle bundle = new Bundle();
            bundle.putString("uin", stringExtra);
            sendRemoteReq(com.tencent.mobileqq.emosm.a.a("getA2", "", this.mOnRemoteResp.key, bundle), true, false);
            hideProgressDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.f)) {
            this.activity = this.mRuntime.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        hideProgressDialog();
    }

    public void onLoadIsSetPsw(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "SetPwdJsPlugin onLoadIsSetPsw isSet =" + str);
        }
        if (str != null && str.equals("1")) {
            sendRemoteReq(com.tencent.mobileqq.emosm.a.a("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("cmd");
            if (TextUtils.isEmpty(string)) {
                if (QLog.isColorLevel()) {
                    QLog.i(tag, 2, "cmd is empty.");
                    return;
                }
                return;
            }
            Bundle bundle2 = bundle.getBundle("response");
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, "response:" + string);
            }
            if (string.equalsIgnoreCase("openEquipmentLock")) {
                if (bundle2.getInt("checkDevLockSms_ret") < 0) {
                    hideProgressDialog();
                    closeWeb(false);
                    return;
                }
                return;
            }
            if (string.equalsIgnoreCase("setWaitingResponse")) {
                boolean z16 = bundle2.getBoolean("isWaiting", false);
                this.waittingResponse = z16;
                if (!z16) {
                    hideProgressDialog();
                    return;
                }
                return;
            }
            if (string.equalsIgnoreCase("setMobileResult")) {
                this.resultSetMobile = bundle2.getBoolean("setMobileResult", false);
                return;
            }
            if (string.equalsIgnoreCase("closeWeb") && this.mIsCloseWeb) {
                closeWeb(bundle2.getBoolean("isBack"));
                return;
            }
            if (string.equalsIgnoreCase("getA2")) {
                String string2 = bundle2.getString(NowProxyConstants.AccountInfoKey.A2);
                if (TextUtils.isEmpty(string2)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(tag, 2, "a2 is empty.");
                        return;
                    }
                    return;
                }
                String stringExtra = this.activity.getIntent().getStringExtra("url");
                if (TextUtils.isEmpty(stringExtra)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(tag, 2, "url is empty.");
                        return;
                    }
                    return;
                }
                String i3 = com.tencent.mobileqq.webview.util.s.i(stringExtra);
                if (TextUtils.isEmpty(i3)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(tag, 2, "domain is empty.");
                        return;
                    }
                    return;
                } else {
                    CookieSyncManager.createInstance(this.mRuntime.e().getContext());
                    CookieManager cookieManager = CookieManager.getInstance();
                    cookieManager.setAcceptCookie(true);
                    cookieManager.setCookie(stringExtra, String.format("A2=%1$s; domain=%2$s; path=/", string2, i3));
                    CookieSyncManager.getInstance().sync();
                    return;
                }
            }
            if (string.equalsIgnoreCase("openDevLock")) {
                boolean z17 = bundle2.getBoolean(AuthDevOpenUgActivity.KEY_AUTH_DEV_OPEN);
                byte[] byteArray = bundle2.getByteArray("devlock_roam_sig");
                String string3 = bundle.getString("callbackid");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("result", 0);
                    jSONObject.put(MessageRoamJsPlugin.DEVLOCKISOPEN, z17);
                    jSONObject.put("sigDA2", HexUtil.bytes2HexStr(byteArray));
                    if (QLog.isColorLevel()) {
                        QLog.i(tag, 2, "openDevLock callJS: " + jSONObject.toString());
                    }
                    super.callJs(string3, jSONObject.toString());
                } catch (Exception unused) {
                }
            }
        }
    }

    public void onTimeOut() {
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "SetPwdJsPlugin onTimeOut");
        }
        hideProgressDialog();
    }

    public void onVerifyCAPTCHA(String str) {
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (Integer.parseInt(jSONObject.getString("result")) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            String string = jSONObject.getString("ticket");
            String optString = jSONObject.optString(KEY_RANDSTR);
            String optString2 = jSONObject.optString("appid");
            Bundle bundle = new Bundle();
            bundle.putBoolean("result", z16);
            bundle.putString("ticket", string);
            bundle.putString(KEY_RANDSTR, optString);
            bundle.putString("appid", optString2);
            WebViewBridge.f().j(this.activity, "verifyCompleted", bundle);
            QLog.i(tag, 1, "onVerifyCAPTCHA");
            Activity activity = this.activity;
            if (activity != null) {
                activity.setResult(-1);
                this.activity.finish();
            }
        } catch (Throwable th5) {
            QLog.e(tag, 1, "onVerifyCAPTCHA error:", th5);
        }
    }

    public void onWebMakeSureBack() {
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "SetPwdJsPlugin onWebMakeSureBack");
        }
        showProgressDialog();
    }

    public void onWebMakeSureFinishBack(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "SetPwdJsPlugin onWebMakeSureFinishBack isSuccess =" + str);
        }
        if (str != null && str.equals("1")) {
            sendRemoteReq(com.tencent.mobileqq.emosm.a.a("setHasSetPwd", "", this.mOnRemoteResp.key, new Bundle()), true, false);
        }
        hideProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        Activity activity = this.activity;
        if (activity != null) {
            Intent intent = activity.getIntent();
            if ((intent.getLongExtra("business", 0L) & 16384) != 0) {
                this.tagRequest = intent.getStringExtra("tag");
                this.needResult = intent.getBooleanExtra("needResult", false);
                boolean booleanExtra = intent.getBooleanExtra("isSubaccount", false);
                this.isSubaccount = booleanExtra;
                if (booleanExtra) {
                    this.subAccountUin = intent.getStringExtra("subAccountUin");
                }
                TextView textView = (TextView) this.activity.findViewById(R.id.ivTitleBtnLeft);
                if (textView != null) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            MQPSecJsPlugin.this.onBackEvent();
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                }
            }
        }
    }

    public void openDevLock(boolean z16, String str, String str2, String str3) {
        this.mIsCloseWeb = false;
        Bundle bundle = new Bundle();
        bundle.putString("devlock_guide_config", str2);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("devlock_open_source", str);
        } else {
            bundle.putString("devlock_open_source", "Unknown");
        }
        bundle.putBoolean("devlock_show_auth_dev_list", z16);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("openDevLock", str3, this.mOnRemoteResp.key, bundle), true, false);
    }

    public void openEquipmentLock(String str, String str2, String str3) {
        byte[] bArr;
        this.resultState = 2;
        this.resultUin = str;
        this.resultMobileMask = str2;
        this.resultSppkey = str3;
        showProgressDialog();
        if (str3 != null) {
            bArr = str3.getBytes();
        } else {
            bArr = null;
        }
        this.waittingResponse = true;
        Bundle bundle = new Bundle();
        bundle.putString("uin", str);
        bundle.putString("mobileMask", str2);
        bundle.putByteArray("sppkey", bArr);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("openEquipmentLock", "", this.mOnRemoteResp.key, bundle), true, false);
    }

    public void pushMobileReturn() {
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "SetPwdJsPlugin pushMobileReturn");
        }
        this.activity.finish();
    }

    public void updateResult(String str, String str2, String str3, String str4) {
        int i3;
        this.resultUin = str;
        try {
            i3 = Integer.parseInt(str3);
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        this.resultMobileMask = str2;
        this.resultSppkey = str4;
        if (i3 != -4) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            this.resultState = 1;
                            return;
                        } else {
                            this.resultState = 5;
                            return;
                        }
                    }
                    this.resultState = 4;
                    return;
                }
                this.resultState = 3;
                return;
            }
            this.resultState = 2;
            return;
        }
        this.resultState = 6;
    }
}
