package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class MessageRoamJsPlugin extends VasWebviewJsPlugin {
    public static final String ACTION = "action";
    public static final String DATA = "data";
    public static final String DEVLOCKISOPEN = "devlockIsOpen";
    public static final String DEVLOCKSTATUS = "devLockStatus";
    public static final String ERROEMESSAGE = "errorMessage";
    public static final String ISSETPASSWORD = "isSetPassword";
    public static final int NOT_VERIFY_PASSWORD = 3000;
    public static final String PKGNAME = "msgRoam";
    public static final String RESULT = "result";
    public static final int RESULT_CODE = 2000;
    public static final String SECURITYPHONENUMBER = "hasSecurityPhoneNumber";
    private static final String TAG = "MessageRoamJsPlugin";
    public static final String TYPE = "type";
    public static final String USERTYPE = "userType";
    public static final String VERIFICATION = "verification";
    public static final String listenPswEventUrl = "http://clientui.3g.qq.com/mqqapi/im/roam";
    public String listenCallback = null;
    Context context = null;
    BrowserAppInterface browserAppInterface = null;
    Activity browserActivity = null;

    private boolean handleAddListenPswEvent(String str) {
        this.listenCallback = str;
        return true;
    }

    private boolean handleGetRoam(String str) throws JSONException {
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("getRoam", str, this.mOnRemoteResp.key, new Bundle()), false, false);
        return true;
    }

    private boolean handleRemoveListenPswEvent(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", "0");
            jSONObject.put("errorMessage", "success");
        } catch (JSONException e16) {
            try {
                jSONObject.put("result", "-1");
                jSONObject.put("errorMessage", "handleRemoveListenPswEvent , JSONException,encode json is error");
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            e16.printStackTrace();
        }
        callJs(str, jSONObject.toString());
        return true;
    }

    private boolean handleSetRoam(int i3, String str) throws JSONException {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleSetRoam messageRoamType: " + i3);
        }
        int i16 = -1;
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
            log("messageRoamType is error , = " + i3);
            str2 = "messageRoamType is error";
        } else {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences("vip_message_roam_banner_file", 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putInt("message_roam_flag" + this.browserAppInterface.getCurrentAccountUin(), i3).commit();
                str2 = "success";
                i16 = 0;
            } else {
                str2 = "SharedPreferences is null";
                log("SharedPreferences is null");
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", i16);
        jSONObject.put("errorMessage", str2);
        callJs(str, jSONObject.toString());
        return true;
    }

    private void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    private void setAuthMode(String str, int i3) throws JSONException {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setAuthMode mode: " + i3);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", -1);
        if (i3 != 1 && i3 != 0) {
            jSONObject.put("errorMessage", "authmode illeage");
        } else {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences("vip_message_roam_banner_file", 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putInt("auth_mode_" + this.browserAppInterface.getCurrentAccountUin(), i3).commit();
                jSONObject.put("result", 0);
            }
        }
        callJs(str, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        Intent intent;
        CharSequence charSequenceExtra;
        if (j3 == 8589934600L) {
            if (((Integer) map.get(QzoneIPCModule.RESULT_CODE)).intValue() != 2000 || (intent = (Intent) map.get("data")) == null || (charSequenceExtra = intent.getCharSequenceExtra("result")) == null) {
                return false;
            }
            log("listenCallback = " + this.listenCallback + "result = " + charSequenceExtra.toString());
            callJs(this.listenCallback, charSequenceExtra.toString().trim());
            return true;
        }
        if (j3 == 8589934601L && (str.contains("mapp.3g.qq.com/touch/psw/create.jsp") || str.contains("mapp.3g.qq.com/touch/psw/verify.jsp"))) {
            this.browserActivity.setResult(3000);
            this.browserActivity.finish();
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return PKGNAME;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        String optString;
        if (str2 != null && str2.equalsIgnoreCase(PKGNAME)) {
            try {
                jSONObject = new JSONObject(strArr[0]);
            } catch (JSONException e16) {
                log("failed to parse json str,json=" + ((Object) null));
                e16.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject == null) {
                return false;
            }
            try {
                optString = jSONObject.optString("callback");
                log("handleJsRequest:method:" + str3 + ",callback" + optString + ", json:" + jSONObject.toString());
            } catch (Exception e17) {
                log("handleJsRequest exception:" + e17.toString());
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", -1);
                    jSONObject2.put("errorMessage", "exception");
                    callJs(null, jSONObject2.toString());
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
            if (str3.equals("setRoam")) {
                return handleSetRoam(jSONObject.getInt("type"), optString);
            }
            if (str3.equals("getRoam")) {
                handleGetRoam(optString);
            } else if (str3.equals("addListenPswEvent")) {
                handleAddListenPswEvent(optString);
            } else if (str3.equals("removeListenPswEvent")) {
                handleRemoveListenPswEvent(optString);
            } else if ("setAuthMode".equals(str3)) {
                String string = jSONObject.getString("authMode");
                if ("devlock".equals(string)) {
                    setAuthMode(optString, 1);
                } else if (NotificationActivity.PASSWORD.equals(string)) {
                    setAuthMode(optString, 0);
                }
            } else {
                log("unimplement method" + str3);
            }
            return true;
        }
        log("handleJsRequest returned, pkgName=" + str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i3 = 0;
        if (!str.startsWith(listenPswEventUrl)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            str3 = parse.getQueryParameter(ISchemeApi.KEY_IOS_SRC_TYPE);
            str5 = parse.getQueryParameter("version");
            str6 = parse.getQueryParameter("action");
            str4 = parse.getQueryParameter("pwd");
        } catch (Exception e16) {
            e16.printStackTrace();
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        log("srcType = " + str3 + " , version = " + str5 + " , action = " + str6);
        if (str3 == null || str5 == null || str6 == null) {
            return false;
        }
        if (!str6.equals("open") && !str6.equals("reset") && !str6.equals("close") && !str6.equals("history")) {
            str7 = "action is not open,reset,close";
            log("action is not open,reset,close");
            i3 = -1;
        } else {
            notifyGetMsgRoam(str4);
            if (str6.equals("reset")) {
                this.context.getSharedPreferences("vip_message_roam_banner_file", 4).edit().putInt("message_roam_is_set_password" + this.browserAppInterface.getCurrentAccountUin(), 1).commit();
            }
            str7 = "success";
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("action", str6);
            jSONObject.putOpt("data", jSONObject2);
            jSONObject.put("result", i3);
            jSONObject.put("errorMessage", str7);
        } catch (JSONException e17) {
            try {
                jSONObject.put("result", "-1");
                jSONObject.put("errorMessage", "JSONException,encode json is error");
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
            e17.printStackTrace();
        }
        Intent intent = new Intent();
        intent.putExtra("result", jSONObject.toString());
        this.browserActivity.setResult(2000, intent);
        this.browserActivity.finish();
        return true;
    }

    public void notifyGetMsgRoam(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("pwd", str);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("notifyGetMsgRoam", "notifyGetMsgRoam", this.mOnRemoteResp.key, bundle), true, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (this.mRuntime.b() != null && (this.mRuntime.b() instanceof BrowserAppInterface)) {
            this.browserAppInterface = (BrowserAppInterface) this.mRuntime.b();
        }
        this.browserActivity = this.mRuntime.a();
        this.context = this.mRuntime.a().getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        this.context = null;
        this.browserActivity = null;
        this.browserAppInterface = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
                    String string = bundle.getString("cmd");
                    String string2 = bundle.getString("callbackid");
                    Bundle bundle2 = bundle.getBundle("response");
                    log("onResponse,callback=" + string2 + ",cmd=" + string + ",respbundle=" + bundle2);
                    if (string != null && "getRoam".equals(string)) {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        if (bundle2 == null) {
                            jSONObject.put("result", -1);
                            jSONObject.put("errorMessage", "invalid data, response data is null");
                        } else {
                            jSONObject2.put("type", bundle2.getInt("type"));
                            jSONObject2.put(USERTYPE, bundle2.getInt(USERTYPE));
                            jSONObject2.put(ISSETPASSWORD, bundle2.getInt(ISSETPASSWORD));
                            jSONObject2.put(DEVLOCKISOPEN, bundle2.getBoolean(DEVLOCKISOPEN));
                            jSONObject2.put(VERIFICATION, bundle2.getString(VERIFICATION));
                            jSONObject2.put(SECURITYPHONENUMBER, bundle2.getBoolean(SECURITYPHONENUMBER));
                            jSONObject.putOpt("data", jSONObject2);
                            jSONObject.put("result", bundle2.getInt("result"));
                            jSONObject.put("errorMessage", bundle2.getString("errorMessage"));
                        }
                        log("onResponse, callJs: " + jSONObject.toString());
                        callJs(string2, jSONObject.toString());
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
