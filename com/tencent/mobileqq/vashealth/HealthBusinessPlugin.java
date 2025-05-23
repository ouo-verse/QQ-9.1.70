package com.tencent.mobileqq.vashealth;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$RetInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class HealthBusinessPlugin extends WebViewPlugin {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f312119d;

        a(String str) {
            this.f312119d = str;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("HealthBusinessPlugin", 2, "[followUin] onReceive, isSuccess=", Boolean.valueOf(z16));
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (!z16) {
                    QLog.e("HealthBusinessPlugin", 1, "[followUin] onReceive isSuccess=false");
                    jSONObject.put("code", -1);
                } else {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        mobileqq_mp$FollowResponse mobileqq_mp_followresponse = new mobileqq_mp$FollowResponse();
                        mobileqq_mp_followresponse.mergeFrom(byteArray);
                        mobileqq_mp$RetInfo mobileqq_mp_retinfo = mobileqq_mp_followresponse.ret_info.get();
                        int i16 = mobileqq_mp_retinfo.ret_code.get();
                        String str = mobileqq_mp_retinfo.err_info.get();
                        jSONObject.put("code", 0);
                        JSONObject jSONObject2 = new JSONObject();
                        if (i16 == 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("HealthBusinessPlugin", 2, "[followUin] onReceive, follow success");
                            }
                            jSONObject2.put("follow", true);
                        } else {
                            QLog.e("HealthBusinessPlugin", 1, "[followUin] onReceive, follow failed, retCode=", Integer.valueOf(i16), ", errInfo=", str);
                            jSONObject2.put("follow", false);
                        }
                        jSONObject.put("response", jSONObject2);
                    } else {
                        QLog.e("HealthBusinessPlugin", 1, "[followUin] data null");
                        jSONObject.put("code", -1);
                    }
                }
                HealthBusinessPlugin.this.callJs(this.f312119d, jSONObject.toString());
            } catch (Exception e16) {
                QLog.e("HealthBusinessPlugin", 1, "[followUin] parse data error=", e16);
            }
        }
    }

    private void p(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("uin");
            String optString2 = jSONObject.optString("callback");
            NewIntent newIntent = new NewIntent(this.mRuntime.b().getApplication(), ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).getServletClass());
            q(optString);
            newIntent.putExtra("cmd", "PubAccountFollowSvc.follow");
            mobileqq_mp$FollowRequest mobileqq_mp_followrequest = new mobileqq_mp$FollowRequest();
            mobileqq_mp_followrequest.uin.set((int) Long.parseLong(optString));
            mobileqq_mp_followrequest.type.set(-1);
            mobileqq_mp_followrequest.ext.set(String.valueOf(0));
            newIntent.setObserver(new a(optString2));
            newIntent.putExtra("data", mobileqq_mp_followrequest.toByteArray());
            this.mRuntime.b().startServlet(newIntent);
        } catch (Exception e16) {
            QLog.e("HealthBusinessPlugin", 1, "[followUin] error=", e16);
        }
    }

    public static void q(final String str) {
        if (QLog.isColorLevel()) {
            QLog.d("HealthBusinessPlugin", 2, "report  Click On HealthBusinessPluginFollow , UIN=", str);
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.vashealth.HealthBusinessPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                ReportController.o(null, "dc00898", "", str, "0X8009EB7", "0X8009EB7", 0, 0, "", "", "", "-1");
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "healthSport";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public Object handleEvent(String str, long j3) {
        if (this.mRuntime.e().getUrl().contains("qq.com") && !TextUtils.isEmpty(str) && j3 == 8 && ((str.startsWith("http://qqsport/") || str.startsWith("https://qqsport/")) && str.length() > 16)) {
            try {
                File file = new File(URLDecoder.decode(str.substring(15), "utf-8"));
                if (!file.exists() && !file.isFile()) {
                    return null;
                }
                return new WebResourceResponse("image/*", "utf-8", new FileInputStream(file));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        try {
            String optString = new JSONObject(strArr[0]).optString("callback");
            if ("wifiStatus".equals(str3)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retCode", NetworkUtil.isWifiConnected(this.mRuntime.a()));
                callJs(optString, jSONObject.toString());
            }
            if ("followUin".equals(str3)) {
                p(strArr[0]);
            }
        } catch (Exception e16) {
            QLog.e("HealthBusinessPlugin", 1, "[handleJsRequest] error=", e16);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        if (QLog.isColorLevel()) {
            QLog.d("HealthBusinessPlugin", 2, "onCreate");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        AVBizModuleFactory.removeModuleByName(Constants.Business.QQ_HEALTH);
        QLog.d("HealthBusinessPlugin", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        if (QLog.isColorLevel()) {
            QLog.d("HealthBusinessPlugin", 2, "onWebViewCreated");
        }
    }
}
