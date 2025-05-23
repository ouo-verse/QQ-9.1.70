package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class FunnyPicJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "qutu";
    public static final String TAG = "FunnyPicJsPlugin";
    public Bundle mReqBundle;

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return BUSINESS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        this.mRuntime.b();
        this.mReqBundle = new Bundle();
        super.onCreate();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResponse(Bundle bundle) {
        String str;
        JSONObject jSONObject;
        boolean z16;
        Activity a16;
        JSONObject jSONObject2;
        String str2;
        String string;
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string2 = bundle.getString("cmd");
            String string3 = bundle.getString("callbackid");
            if (string2 != null) {
                if ("ipc_funnypic_add".equals(string2)) {
                    try {
                        int i3 = bundle.getInt("result", 0);
                        jSONObject = new JSONObject();
                        jSONObject.put("result", i3);
                        String string4 = bundle.getString("data");
                        str = TAG;
                        if (string4 != null) {
                            try {
                                jSONObject.put("data", new JSONObject(string4));
                            } catch (Exception e16) {
                                e = e16;
                                if (QLog.isColorLevel()) {
                                }
                            }
                        }
                        if (i3 != 0 && (string = bundle.getString("message")) != null) {
                            jSONObject.put("message", string);
                        }
                        z16 = bundle.getBoolean("openManagerActivity", false);
                        a16 = this.mRuntime.a();
                    } catch (Exception e17) {
                        e = e17;
                        str = TAG;
                    }
                    try {
                        if (z16 && a16 != null) {
                            try {
                                if (!this.isDestroy && !a16.isFinishing()) {
                                    ArrayList<String> stringArrayList = bundle.getStringArrayList("extra_key_pkgids");
                                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList("extra_key_paths");
                                    ArrayList<String> stringArrayList3 = bundle.getStringArrayList("extra_key_md5s");
                                    int i16 = bundle.getInt("extra_key_over_num");
                                    int i17 = bundle.getInt("extra_key_faile_count");
                                    str2 = ");";
                                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(a16, RouterConstants.UI_ROUTE_FAV_EMOSM_ACTVITY);
                                    activityURIRequest.setFlags(268435456);
                                    jSONObject2 = jSONObject;
                                    activityURIRequest.extra().putBoolean("extra_key_from_web", true);
                                    activityURIRequest.extra().putStringArrayList("extra_key_pkgids", stringArrayList);
                                    activityURIRequest.extra().putStringArrayList("extra_key_paths", stringArrayList2);
                                    activityURIRequest.extra().putStringArrayList("extra_key_md5s", stringArrayList3);
                                    activityURIRequest.extra().putInt("extra_key_faile_count", i17);
                                    activityURIRequest.extra().putInt("extra_key_over_num", i16);
                                    QRoute.startUri(activityURIRequest);
                                    super.callJs(string3 + "(" + jSONObject2.toString() + str2);
                                    return;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                if (QLog.isColorLevel()) {
                                }
                            }
                        }
                        super.callJs(string3 + "(" + jSONObject2.toString() + str2);
                        return;
                    } catch (Exception e19) {
                        e = e19;
                        if (QLog.isColorLevel()) {
                            QLog.i(str, 2, e.getMessage());
                            return;
                        }
                        return;
                    }
                    jSONObject2 = jSONObject;
                    str2 = ");";
                } else {
                    if ("ipc_funnypic_query_info".equals(string2)) {
                        try {
                            int i18 = bundle.getInt("result", 0);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("result", i18);
                            if (i18 == 0) {
                                String string5 = bundle.getString("data");
                                if (string5 != null) {
                                    jSONObject3.put("data", new JSONObject(string5));
                                }
                            } else {
                                String string6 = bundle.getString("message");
                                if (string6 != null) {
                                    jSONObject3.put("data", new JSONObject(string6));
                                }
                            }
                            super.callJs(string3 + "(" + jSONObject3.toString() + ");");
                            return;
                        } catch (Exception e26) {
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, e26.getMessage());
                                return;
                            }
                            return;
                        }
                    }
                    super.onResponse(bundle);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        String str5;
        final JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !BUSINESS_NAME.equals(str2) || str3 == null) {
            return false;
        }
        String str6 = null;
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Throwable th5) {
            th = th5;
            str4 = TAG;
        }
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        final String optString = jsonFromJSBridge.optString("callback");
        try {
        } catch (Throwable th6) {
            th = th6;
            str4 = TAG;
        }
        if (TextUtils.isEmpty(optString)) {
            QLog.e(TAG, 1, "callback id is null, so return");
            return true;
        }
        VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
        if ("getCurrentPkgInfo".equals(str3)) {
            this.mReqBundle.clear();
            this.mReqBundle.putString("jsonContent", jsonFromJSBridge.toString());
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_funnypic_query_info", optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        } else if ("addQutu".equals(str3)) {
            Activity a16 = this.mRuntime.a();
            if (a16 != null && !NetworkUtil.isNetworkAvailable(a16)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", 1);
                super.callJs(optString + "(" + jSONObject.toString() + ");");
                return true;
            }
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.mvd), 0).show();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", 1);
                super.callJs(optString + "(" + jSONObject2.toString() + ");");
                return true;
            }
            final int i3 = jsonFromJSBridge.getInt("action");
            JSONArray jSONArray = jsonFromJSBridge.getJSONArray("uids");
            int i16 = jSONArray.length() > 0 ? ((JSONObject) jSONArray.get(0)).getInt("pkgid") : -1;
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            PBInt64Field pBInt64Field = webSSOAgent$UniSsoServerReqComm.platform;
            str4 = TAG;
            try {
                pBInt64Field.set(109L);
                webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
                webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
                WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
                webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("appid", "10");
                final String valueOf = String.valueOf(i16);
                jSONObject3.put("itemid", valueOf);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.mo162put(jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("itemlist", jSONArray2);
                jSONObject4.put("authType", "1");
                webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject4.toString());
                BusinessObserver businessObserver = new BusinessObserver() { // from class: com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin.1
                    @Override // mqq.observer.BusinessObserver
                    public void onReceive(int i17, boolean z16, Bundle bundle) {
                        if (z16) {
                            try {
                                byte[] byteArray = bundle.getByteArray("extra_data");
                                if (byteArray != null) {
                                    WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                                    webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                                    if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
                                        JSONArray jSONArray3 = new JSONObject(webSSOAgent$UniSsoServerRsp.rspdata.get()).getJSONArray("rstList");
                                        if (jSONArray3.length() > 0) {
                                            JSONObject jSONObject5 = jSONArray3.getJSONObject(0);
                                            String optString2 = jSONObject5.optString("appid");
                                            String optString3 = jSONObject5.optString("itemid");
                                            String optString4 = jSONObject5.optString("authRst");
                                            if ("0".equals(optString4) && "10".equals(optString2) && valueOf.equals(optString3)) {
                                                FunnyPicJsPlugin.this.mReqBundle.clear();
                                                FunnyPicJsPlugin.this.mReqBundle.putString("jsonContent", jsonFromJSBridge.toString());
                                                FunnyPicJsPlugin.this.mReqBundle.putInt("action", i3);
                                                String str7 = optString;
                                                FunnyPicJsPlugin funnyPicJsPlugin = FunnyPicJsPlugin.this;
                                                FunnyPicJsPlugin.super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_funnypic_add", str7, funnyPicJsPlugin.mOnRemoteResp.key, funnyPicJsPlugin.mReqBundle), true, true);
                                                if (QLog.isColorLevel()) {
                                                    QLog.i(FunnyPicJsPlugin.TAG, 2, "authRst->" + jSONObject5);
                                                    return;
                                                }
                                                return;
                                            }
                                            JSONObject jSONObject6 = new JSONObject();
                                            jSONObject6.put("result", 1);
                                            jSONObject6.put("authRst", optString4);
                                            FunnyPicJsPlugin.super.callJs(optString + "(" + jSONObject6.toString() + ");");
                                            return;
                                        }
                                    }
                                }
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(FunnyPicJsPlugin.TAG, 2, e16.getMessage());
                                    return;
                                }
                                return;
                            }
                        }
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("result", 1);
                        FunnyPicJsPlugin.super.callJs(optString + "(" + jSONObject7.toString() + ");");
                    }
                };
                AppInterface b16 = this.mRuntime.b();
                if (b16 != null) {
                    NewIntent newIntent = new NewIntent(this.mRuntime.b().getApp(), am.class);
                    newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "AuthProxy.check");
                    newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
                    newIntent.setObserver(businessObserver);
                    b16.startServlet(newIntent);
                }
            } catch (Throwable th7) {
                th = th7;
                str6 = optString;
                if (QLog.isColorLevel()) {
                    str5 = str4;
                    QLog.e(str5, 2, th.getMessage());
                } else {
                    str5 = str4;
                }
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("result", 1);
                    jSONObject5.put("message", th.getMessage());
                    super.callJs(str6 + "(" + jSONObject5.toString() + ");");
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e(str5, 2, th.getMessage());
                    }
                }
                return true;
            }
        }
        return true;
    }
}
