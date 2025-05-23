package com.tencent.mobileqq.qqlive.webview;

import android.app.Activity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.gamedownloader.GameDistributeDoActionEvent;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qqlive.widget.verify.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes17.dex */
public class QQLiveJsPlugin extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IAegisLogApi f273487d;

    public QQLiveJsPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273487d = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        }
    }

    private void p(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
            callJs(str, jSONObject.toString());
        } catch (Throwable th5) {
            this.f273487d.e("QQLiveJsPlugin", 1, "[callJsOk] callbackId:" + str + ", e:" + th5.getMessage());
        }
    }

    private boolean q(String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        try {
            if (strArr.length > 0) {
                jSONObject = new JSONObject(strArr[0]);
            } else {
                jSONObject = new JSONObject();
            }
            String optString = jSONObject.optString("callback", "");
            if ("updateIdResult".equals(str3)) {
                v(jSONObject, optString);
            } else if ("refreshToken".equals(str3)) {
                u(str, optString);
            } else if ("hideLotteryWidget".equals(str3)) {
                t(jSONObject);
            } else if ("openProfileCard".equals(str3)) {
                w(str, jSONObject, optString);
            } else if ("doAction".equals(str3)) {
                s(str, jSONObject);
            }
        } catch (Exception e16) {
            this.f273487d.e("QQLiveJsPlugin", 1, "[handleJsRequest] method:" + str3 + ", e:" + e16.getMessage());
        }
        return true;
    }

    private boolean r(String str) {
        return getNameSpace().equalsIgnoreCase(str);
    }

    private void s(String str, JSONObject jSONObject) {
        if (QLog.isDevelopLevel()) {
            this.f273487d.d("QQLiveJsPlugin", "onGameCardDoAction json:" + jSONObject);
        }
        SimpleEventBus.getInstance().dispatchEvent(new GameDistributeDoActionEvent(jSONObject.optString(VirtualAppProxy.KEY_GAME_ID), jSONObject.optInt("actionId")));
    }

    private void t(JSONObject jSONObject) throws JSONException {
        IQQLiveLotteryService lotteryService;
        String string = jSONObject.getString("lotteryId");
        String string2 = jSONObject.getString("roomId");
        String string3 = jSONObject.getString("programId");
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(jSONObject.getString("busId"));
        if (sDKImpl != null && (lotteryService = sDKImpl.getLotteryService()) != null) {
            lotteryService.notifyHideLotteryResult(string, string2, string3);
        }
    }

    private void u(String str, String str2) throws JSONException {
        com.tencent.mobileqq.qqlive.widget.a.b().g(this.mRuntime.a().getApplicationContext(), null, str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 0);
        jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        callJs(str2, jSONObject.toString());
    }

    private void v(JSONObject jSONObject, String str) throws JSONException {
        Activity a16 = this.mRuntime.a();
        if (a16 == null) {
            this.f273487d.e("QQLiveJsPlugin", 1, "onVerifiedResult activity is null!");
            return;
        }
        String stringExtra = a16.getIntent().getStringExtra("extra_web_verify_app_id");
        if (QLog.isColorLevel()) {
            this.f273487d.d("QQLiveJsPlugin", "[onVerifiedResult] json:" + jSONObject + ", appId:" + stringExtra);
        }
        try {
            l.f274086a.g(jSONObject.getInt("code"), jSONObject.getString("msg"));
            p(str);
            ThreadManager.getUIHandler().postDelayed(new Runnable(a16) { // from class: com.tencent.mobileqq.qqlive.webview.QQLiveJsPlugin.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f273488d;

                {
                    this.f273488d = a16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveJsPlugin.this, (Object) a16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Activity activity = this.f273488d;
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }, 3000L);
        } catch (Throwable th5) {
            this.f273487d.e("QQLiveJsPlugin", 1, th5 + "");
        }
    }

    private void w(String str, JSONObject jSONObject, String str2) {
        if (QLog.isDevelopLevel()) {
            this.f273487d.d("QQLiveJsPlugin", "openProfileCard json:" + jSONObject);
        }
        long optLong = jSONObject.optLong("uid", 0L);
        String optString = jSONObject.optString("header", "");
        String optString2 = jSONObject.optString("nick", "");
        int optInt = jSONObject.optInt("gender", 0);
        long optLong2 = jSONObject.optLong("roomid", 0L);
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.e() != null && this.mRuntime.a() != null) {
            LiveUserInfo liveUserInfo = new LiveUserInfo(optLong, optString, optString2, optInt);
            if (optLong2 <= 0) {
                optLong2 = c.f272176a.p();
            }
            kk4.a.g(this.mRuntime.a(), c.f272176a.k(optLong2, 0), liveUserInfo, 5, false);
            return;
        }
        this.f273487d.e("QQLiveJsPlugin", "mRuntime is null");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "qq_livestream";
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
        this.mRuntime.a().finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (r(str2)) {
            return q(str, str2, str3, strArr);
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }
}
