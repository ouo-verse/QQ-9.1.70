package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.IMidasLogCallback;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes34.dex */
public class CloudGamePlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private a f347327d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f347336a;

        /* renamed from: b, reason: collision with root package name */
        String f347337b;

        /* renamed from: c, reason: collision with root package name */
        String f347338c;

        /* renamed from: d, reason: collision with root package name */
        String f347339d;

        /* renamed from: e, reason: collision with root package name */
        String f347340e;

        a() {
        }
    }

    /* loaded from: classes34.dex */
    public static class b implements IMidasLogCallback {
        @Override // com.tencent.midas.api.IMidasLogCallback
        public void onLogging(int i3, String str, String str2) {
            String str3 = "CloudGamePlugin_" + str;
            if (i3 == 3) {
                QLog.i(str3, 2, str2);
                return;
            }
            if (i3 == 4) {
                QLog.w(str3, 1, str2);
            } else if (i3 != 5) {
                QLog.d(str3, 4, str2);
            } else {
                QLog.e(str3, 1, str2);
            }
        }
    }

    private void e(sd2.a aVar) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            return;
        }
        ((IPskeyManager) runtime.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{"q.qq.com"}, aVar);
    }

    private void f(Activity activity, RequestEvent requestEvent, a aVar) {
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        aPMidasGameRequest.setOfferId(aVar.f347338c);
        aPMidasGameRequest.setOpenId(aVar.f347339d);
        aPMidasGameRequest.setOpenKey(aVar.f347340e);
        aPMidasGameRequest.setSessionId("uin");
        aPMidasGameRequest.setSessionType("pskey_750");
        aPMidasGameRequest.setZoneId("1");
        aPMidasGameRequest.reserv = String.format("linkid=%s&cloud_platform=client", aVar.f347337b);
        APMidasPayAPI.setLogEnable(true);
        APMidasPayAPI.setLogCallback(b.class);
        APMidasPayAPI.init(activity, aPMidasGameRequest);
        if (requestEvent != null) {
            requestEvent.ok();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(RequestEvent requestEvent, EIPCResult eIPCResult) {
        if (eIPCResult.isSuccess()) {
            try {
                requestEvent.ok(new JSONObject(eIPCResult.data.getString("BundleData")));
                return;
            } catch (JSONException e16) {
                QLog.e("CloudGamePlugin", 1, "getDynamicYmzxRedDotInfo: parse redInfo failed.", e16);
                requestEvent.fail("parse redInfo failed.");
                return;
            }
        }
        requestEvent.fail("get redDotInfo failed, code=" + eIPCResult.code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(a aVar, RequestEvent requestEvent) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext == null) {
            requestEvent.fail();
            return;
        }
        Activity attachActivity = iMiniAppContext.getAttachActivity();
        if (attachActivity == null) {
            requestEvent.fail();
        } else {
            this.f347327d = aVar;
            f(attachActivity, requestEvent, aVar);
        }
    }

    @JsEvent({"getCloudGamePayOpenId"})
    public void getCloudGamePayOpenId(RequestEvent requestEvent) {
        QLog.i("CloudGamePlugin", 1, "getCloudGamePayOpenId: call");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            requestEvent.fail("get failed, try it later.");
            QLog.e("CloudGamePlugin", 1, "getCloudGamePayOpenId: appRuntime is null.");
            return;
        }
        String account = runtime.getAccount();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payOpenId", account);
            requestEvent.evaluateCallbackJs(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("CloudGamePlugin", 1, "getCloudGamePayOpenId: error.", e16);
        }
    }

    @JsEvent({"getDynamicYmzxRedDotInfo"})
    public void getDynamicYmzxRedDotInfo(final RequestEvent requestEvent) {
        final EIPCResultCallback eIPCResultCallback = new EIPCResultCallback() { // from class: com.tencent.qqmini.proxyimpl.r
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                CloudGamePlugin.g(RequestEvent.this, eIPCResult);
            }
        };
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.CloudGamePlugin.2
            @Override // java.lang.Runnable
            public void run() {
                QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_LETS_GO_RED_INFO, null, eIPCResultCallback);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.f347327d = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onStart() {
        a aVar;
        a aVar2;
        super.onStart();
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo != null && (aVar2 = this.f347327d) != null && !miniAppInfo.appId.equals(aVar2.f347336a)) {
            this.f347327d = null;
            return;
        }
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity == null || (aVar = this.f347327d) == null) {
            return;
        }
        f(attachActivity, null, aVar);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onStop() {
        a aVar;
        super.onStop();
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity == null || (aVar = this.f347327d) == null) {
            return;
        }
        h(attachActivity, aVar);
    }

    @JsEvent({"requestCloudGamePay"})
    public void requestCloudGamePay(final RequestEvent requestEvent) {
        QLog.i("CloudGamePlugin", 1, "requestCloudGamePay: call");
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("linkid");
            final String optString2 = jSONObject.optString("offerid");
            final String optString3 = jSONObject.optString("openid");
            if (this.mMiniAppContext.getAttachActivity() == null) {
                requestEvent.fail("activity is null");
                QLog.e("CloudGamePlugin", 1, "requestCloudGamePay: activity is null.");
            } else {
                e(new sd2.a() { // from class: com.tencent.qqmini.proxyimpl.CloudGamePlugin.1
                    @Override // sd2.a
                    public void onFail(String str) {
                        QLog.e("CloudGamePlugin", 1, "getPskey: failed, errMsg=" + str);
                        requestEvent.fail("getPskey failed:" + str);
                    }

                    @Override // sd2.a
                    public void onSuccess(Map<String, String> map) {
                        String str = map.get("q.qq.com");
                        if (TextUtils.isEmpty(str)) {
                            requestEvent.fail("getPskey empty.");
                            return;
                        }
                        if (QLog.isDebugVersion()) {
                            QLog.d("CloudGamePlugin", 4, "getPskey success=" + str);
                        }
                        final a aVar = new a();
                        aVar.f347336a = ((BaseJsPlugin) CloudGamePlugin.this).mMiniAppInfo.appId;
                        aVar.f347337b = optString;
                        aVar.f347338c = optString2;
                        aVar.f347339d = optString3;
                        aVar.f347340e = str;
                        com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.CloudGamePlugin.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                CloudGamePlugin.this.i(aVar, requestEvent);
                            }
                        });
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("CloudGamePlugin", 1, "cloudGamePay: parse error, param=" + requestEvent.jsonParams, e16);
            requestEvent.fail("param error.");
        }
    }

    private void h(Activity activity, a aVar) {
        APMidasPayAPI.setLongConnection(activity, false);
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        aPMidasGameRequest.setOpenId(aVar.f347339d);
        aPMidasGameRequest.setOpenKey(aVar.f347340e);
        aPMidasGameRequest.setSessionId("uin");
        aPMidasGameRequest.setSessionType("pskey_750");
        aPMidasGameRequest.reserv = null;
        APMidasPayAPI.init(activity, aPMidasGameRequest);
    }
}
