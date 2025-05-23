package com.tencent.biz.pubaccount.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.RecentShopParcel;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PublicAccountWebviewPluginImpl extends WebViewPlugin implements IPublicAccountWebviewPlugin {
    public static final String TAG = "PublicAccountWebviewPlugin";
    private static final String URL_FOR_REPORT = "/report?";
    public Bundle mReqBundle;

    private void doReport(String str) {
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        String string = getString(argumentsFromURL, "sub_action", "");
        String string2 = getString(argumentsFromURL, "action_name", "");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            ReportController.o(null, getString(argumentsFromURL, "tag", "P_CliOper"), getString(argumentsFromURL, "main_action", IPublicAccountHandler.MAIN_ACTION), getString(argumentsFromURL, "to_uin", ""), string, string2, getInt(argumentsFromURL, "from_type", 0), getInt(argumentsFromURL, "result", 0), getString(argumentsFromURL, "r2", ""), getString(argumentsFromURL, "r3", ""), getString(argumentsFromURL, "r4", ""), getString(argumentsFromURL, "r5", ""));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "subAction[" + string + "] or actionName[" + string2 + "] null");
        }
    }

    private int getInt(Map<String, String> map, String str, int i3) {
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2)) {
            return i3;
        }
        try {
            return Integer.parseInt(str2);
        } catch (Exception unused) {
            return i3;
        }
    }

    private String getString(Map<String, String> map, String str, String str2) {
        String str3 = map.get(str);
        return str3 == null ? str2 : str3;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return IPublicAccountWebviewPlugin.NAME_SPACE;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 4L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        try {
            if ("setShopFolderMsg".equals(str3)) {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString("msg");
                int optInt = jSONObject.optInt("type");
                Intent intent = new Intent("action_folder_msg_change");
                intent.putExtra("msg", optString);
                intent.putExtra("type", optInt);
                this.mRuntime.a().sendBroadcast(intent);
            } else if ("onShopMsgClick".equals(str3)) {
                JSONObject jSONObject2 = new JSONObject(strArr[0]);
                String optString2 = jSONObject2.optString("callback");
                String optString3 = jSONObject2.optString("uin");
                Activity a16 = this.mRuntime.a();
                if ((a16 instanceof EcshopWebActivity) && !TextUtils.isEmpty(optString2)) {
                    ((EcshopWebActivity) a16).I2(optString3);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("ret", 0);
                    callJs(optString2, jSONObject3.toString());
                }
            } else if ("getShopFirstMsg".equals(str3)) {
                String string = new JSONObject(strArr[0]).getString("callback");
                Activity a17 = this.mRuntime.a();
                if ((a17 instanceof EcshopWebActivity) && !TextUtils.isEmpty(string)) {
                    EcshopWebActivity ecshopWebActivity = (EcshopWebActivity) a17;
                    JSONObject jSONObject4 = new JSONObject();
                    List<RecentShopParcel> list = ecshopWebActivity.f79598b0;
                    if (list != null && !list.isEmpty()) {
                        RecentShopParcel recentShopParcel = ecshopWebActivity.f79598b0.get(0);
                        JSONObject jSONObject5 = new JSONObject();
                        if (recentShopParcel != null && recentShopParcel.C > 0) {
                            long j3 = recentShopParcel.F;
                            if (j3 >= ecshopWebActivity.f79603g0 && j3 > recentShopParcel.G) {
                                jSONObject5.put("uin", recentShopParcel.f79609d);
                                jSONObject5.put("msg", recentShopParcel.f79612h);
                                jSONObject5.put("nick", recentShopParcel.f79610e);
                                jSONObject4.put("data", jSONObject5);
                            }
                        }
                    }
                    callJs(string, jSONObject4.toString());
                }
            } else if (TextUtils.equals("socialize_feeds_update", str3)) {
                try {
                    this.mReqBundle.clear();
                    JSONObject jSONObject6 = new JSONObject(strArr[0]);
                    String string2 = jSONObject6.getString("feeds_id");
                    String optString4 = jSONObject6.optString("feeds_type", "1");
                    this.mReqBundle.putLong("feeds_id", Long.valueOf(string2).longValue());
                    this.mReqBundle.putInt("feeds_type", Integer.valueOf(optString4).intValue());
                    sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_kandian_socialfeeds_update", "", -1, this.mReqBundle), false, false);
                } catch (Exception e16) {
                    QLog.d(TAG, 1, "handle socialize_feeds_update response failed ", e16);
                }
            } else if ("toggleFolderList".equals(str3)) {
                try {
                    JSONObject jSONObject7 = new JSONObject(strArr[0]);
                    int optInt2 = jSONObject7.optInt("y_offset");
                    boolean optBoolean = jSONObject7.optBoolean("show_list");
                    Activity a18 = this.mRuntime.a();
                    if (a18 instanceof EcshopWebActivity) {
                        WebViewFragment currentWebViewFragment = ((EcshopWebActivity) a18).getCurrentWebViewFragment();
                        if (currentWebViewFragment instanceof ShopWebViewFragment) {
                            if (optBoolean) {
                                ((ShopWebViewFragment) currentWebViewFragment).wh(1, optInt2);
                            } else {
                                ((ShopWebViewFragment) currentWebViewFragment).wh(0, 0);
                            }
                        }
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            } else if ("showRedDot".equals(str3)) {
                try {
                    int optInt3 = new JSONObject(strArr[0]).optInt("reddot");
                    Activity a19 = this.mRuntime.a();
                    if (a19 instanceof EcshopWebActivity) {
                        WebViewFragment currentWebViewFragment2 = ((EcshopWebActivity) a19).getCurrentWebViewFragment();
                        if (currentWebViewFragment2 instanceof ShopWebViewFragment) {
                            ((ShopWebViewFragment) currentWebViewFragment2).vh(optInt3);
                        }
                    }
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
            } else if ("getShopPushInfo".equals(str3)) {
                try {
                    String string3 = new JSONObject(strArr[0]).getString("callback");
                    Activity a26 = this.mRuntime.a();
                    if (a26 instanceof EcshopWebActivity) {
                        Bundle bundleExtra = a26.getIntent().getBundleExtra("bundle");
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, bundleExtra.getInt("PUSH_TASK_ID"));
                        jSONObject8.put("folderMsg", bundleExtra.getString("str_ecshop_diy"));
                        jSONObject8.put("taskType", bundleExtra.getInt("PUSH_TASK_TYPE"));
                        jSONObject8.put("taskInfo", bundleExtra.getString("PUSH_TASK_INFO"));
                        jSONObject8.put("receiveTs", bundleExtra.getLong("PUSH_RECEIVE_TIME"));
                        callJs(string3, jSONObject8.toString());
                    }
                } catch (Exception e19) {
                    QLog.e(TAG, 1, "getShopPushInfo error:", e19);
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.equals(IPublicAccountWebviewPlugin.SCHEME) || str == null || !str.contains(URL_FOR_REPORT)) {
            return false;
        }
        doReport(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.mReqBundle = new Bundle();
    }

    protected void sendRemoteReq(Bundle bundle, boolean z16, boolean z17) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            if (z17) {
                QLog.d(TAG, 1, "is binding service client");
            }
        } else if (z16) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(bundle);
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(bundle);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin
    public WebViewPlugin getWebViewPlugin() {
        return this;
    }
}
