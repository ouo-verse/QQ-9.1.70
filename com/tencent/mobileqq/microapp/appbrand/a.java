package com.tencent.mobileqq.microapp.appbrand;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandServiceEventInterface;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.sdk.MiniAppException;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.sdk.widget.media.MiniAppVideoConstants;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a implements AppBrandServiceEventInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f245896a;

    /* renamed from: b, reason: collision with root package name */
    public int f245897b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.tencent.mobileqq.microapp.a.c f245898c;

    /* renamed from: d, reason: collision with root package name */
    public BaseActivity f245899d;

    /* renamed from: e, reason: collision with root package name */
    public MiniAppInterface f245900e;

    /* renamed from: f, reason: collision with root package name */
    public k f245901f;

    /* renamed from: g, reason: collision with root package name */
    public AppBrandPageContainer f245902g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.mobileqq.microapp.appbrand.a.a.f f245903h;

    /* renamed from: i, reason: collision with root package name */
    public ServiceWebview f245904i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f245905j;

    /* renamed from: k, reason: collision with root package name */
    boolean f245906k;

    /* renamed from: l, reason: collision with root package name */
    public long f245907l;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.microapp.appbrand.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC8030a {
        void a();
    }

    public a(BaseActivity baseActivity, k kVar, com.tencent.mobileqq.microapp.a.c cVar) throws MiniAppException {
        MiniAppConfig miniAppConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseActivity, kVar, cVar);
            return;
        }
        this.f245907l = -1L;
        this.f245899d = baseActivity;
        this.f245898c = cVar;
        this.f245901f = kVar;
        this.f245902g = new AppBrandPageContainer(baseActivity, this);
        AppInterface appInterface = baseActivity.getAppInterface();
        if (appInterface instanceof MiniAppInterface) {
            this.f245900e = (MiniAppInterface) appInterface;
        }
        if (this.f245900e != null && kVar != null && cVar != null && (miniAppConfig = cVar.f245825f) != null && cVar.f245821b != null) {
            this.f245897b = miniAppConfig.getRuntimeType();
            this.f245896a = cVar.f245823d;
            this.f245903h = new com.tencent.mobileqq.microapp.appbrand.a.a.f(baseActivity, this);
            com.tencent.mobileqq.microapp.appbrand.b.c.a();
            return;
        }
        throw new MiniAppException("app params error, apkgInfo=" + cVar + ",appId=" + this.f245896a + ",appInterface=" + this.f245900e + ",appBrandRuntimeContainer=" + kVar);
    }

    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "onAppCreate. fromReload=" + z16 + ",entryPath=" + str + APLogFileUtil.SEPARATOR_LOG + this);
        }
        this.f245905j = false;
        this.f245906k = false;
        this.f245903h.a();
        this.f245903h.c();
        if (!this.f245898c.k(str)) {
            str = this.f245898c.f245821b.f246134f;
        }
        ServiceWebview a16 = com.tencent.mobileqq.microapp.appbrand.b.h.a().a(this.f245896a);
        this.f245904i = a16;
        if (a16.apkgInfo$5475ea27 == null) {
            a16.apkgInfo$5475ea27 = this.f245898c;
        }
        ServiceWebview serviceWebview = this.f245904i;
        serviceWebview.appBrandEventInterface = this;
        if (!z16) {
            serviceWebview.initService$cfb2ece(this.f245898c, null);
            this.f245902g.launch(str, EventListener.APPLAUNCH);
        } else {
            serviceWebview.initService$cfb2ece(this.f245898c, new b(this, str));
        }
        com.tencent.mobileqq.microapp.app.b.a().a(MiniAppVideoConstants.NOTIFY_STATUS_RESET);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f245906k) {
            return;
        }
        this.f245906k = true;
        k kVar = this.f245901f;
        if (kVar != null) {
            int c16 = kVar.c();
            if (QLog.isColorLevel()) {
                QLog.d("AppBrandRuntime", 4, "finish. appRunTimeCount=" + c16 + APLogFileUtil.SEPARATOR_LOG + this);
            }
            if (c16 == 1) {
                this.f245901f.e();
                return;
            }
            this.f245901f.c(this);
        }
        a();
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "onPause. | " + this);
        }
        this.f245905j = true;
        this.f245903h.e();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", 1001);
            jSONObject.put("appId", this.f245896a);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        a("onAppEnterBackground", jSONObject.toString());
        e();
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("miniAppId", this.f245898c.f245823d);
            jSONObject.put("scene", this.f245898c.f245825f.launchParam.scene);
            jSONObject2.put("page", com.tencent.mobileqq.microapp.a.c.n(this.f245902g.getCurrentPage().getUrl()));
            this.f245907l = VACDReportUtil.startReport(jSONObject.toString(), "MiniAppStat", "MiniAppVisitReport", "PageVisit", jSONObject2.toString(), 0, (String) null);
        } catch (Throwable unused) {
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            VACDReportUtil.endReport(this.f245907l, "MiniAppEnd", (String) null, 0, (String) null);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            ComIPCUtils.tryUpdateMiniApp(this.f245898c.f245825f.launchParam, this.f245898c.f245825f.config.mini_version, new c(this));
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AppBrandServiceEventInterface
    public void onServiceEvent(String str, String str2, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, str2, iArr);
            return;
        }
        if ("custom_event_onAppRouteDone".equals(str)) {
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new d(this));
        }
        for (int i3 : iArr) {
            if (QLog.isColorLevel()) {
                QLog.d("AppBrandRuntime", 4, "onServiceEvent. eventName=" + str + ",jsonParams=" + str2 + ",webviewIds=" + i3 + APLogFileUtil.SEPARATOR_LOG + this);
            }
            PageWebview findPageWebView = this.f245902g.findPageWebView(i3);
            if (findPageWebView != null) {
                findPageWebView.evaluateSubcribeJSInService(str, str2, i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AppBrandServiceEventInterface
    public String onServiceNativeRequest(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, this, str, str2, Integer.valueOf(i3));
        }
        if (!"reportIDKey".equals(str) && !"reportRealtimeAction".equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("AppBrandRuntime", 4, "onServiceNativeRequest eventName=" + str + ",jsonParams=" + str2 + ",callbackId=" + i3 + APLogFileUtil.SEPARATOR_LOG + this);
            }
            if (this.f245906k) {
                return "";
            }
            try {
                if ("redirectTo".equals(str)) {
                    String optString = new JSONObject(str2).optString("url", "");
                    if (!TextUtils.isEmpty(optString)) {
                        com.tencent.mobileqq.microapp.appbrand.b.a.a(new e(this, optString));
                    }
                    return "";
                }
                if ("navigateTo".equals(str)) {
                    String optString2 = new JSONObject(str2).optString("url", "");
                    String b16 = com.tencent.mobileqq.microapp.a.c.b(optString2, "url");
                    if (QLog.isColorLevel()) {
                        QLog.i("AppBrandRuntime", 2, "forwardUrl>>>>>>>>>> " + b16);
                    }
                    if (com.tencent.mobileqq.microapp.a.c.a(this.f245898c) && optString2.startsWith("page/QQ/forward.html") && !StringUtil.isEmpty(b16)) {
                        try {
                            String str3 = new String(Base64.decode(b16, 0));
                            if (str3.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
                                MiniAppLauncher.launchMiniAppByScheme(this.f245899d, str3);
                            } else {
                                if (!str3.startsWith("http://") && !str3.startsWith("https://")) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("AppBrandRuntime", 2, "unexpected url " + str3);
                                    }
                                }
                                Intent intent = new Intent(this.f245899d, (Class<?>) QQBrowserActivity.class);
                                intent.putExtra("url", str3);
                                this.f245899d.startActivity(intent);
                            }
                        } catch (Throwable th5) {
                            if (QLog.isColorLevel()) {
                                QLog.e("AppBrandRuntime", 2, "decode forwardUrl occur an exception " + th5);
                            }
                        }
                    } else if (!TextUtils.isEmpty(optString2)) {
                        com.tencent.mobileqq.microapp.appbrand.b.a.a(new f(this, optString2));
                    }
                    return "";
                }
                if ("navigateBack".equals(str)) {
                    int optInt = new JSONObject(str2).optInt(EventListener.KEY_DELTA, 0);
                    if (optInt > 0) {
                        com.tencent.mobileqq.microapp.appbrand.b.a.a(new g(this, optInt));
                    }
                    return "";
                }
                if ("switchTab".equals(str)) {
                    String optString3 = new JSONObject(str2).optString("url", "");
                    if (!TextUtils.isEmpty(optString3)) {
                        com.tencent.mobileqq.microapp.appbrand.b.a.a(new h(this, optString3));
                    }
                    return "";
                }
                if ("reLaunch".equals(str)) {
                    String optString4 = new JSONObject(str2).optString("url", "");
                    if (!TextUtils.isEmpty(optString4)) {
                        com.tencent.mobileqq.microapp.appbrand.b.a.a(new i(this, optString4));
                    }
                    return "";
                }
                return a(str, str2, this.f245904i, i3);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return "";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "[appId=" + this.f245896a + ",versionType=" + this.f245897b + ",isPause=" + this.f245905j + ",mFinished=" + this.f245906k + "]";
    }

    public final void a(com.tencent.mobileqq.microapp.a.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "updateApkgInfo. apkgInfo=" + cVar + APLogFileUtil.SEPARATOR_LOG + this);
        }
        if (cVar != null) {
            this.f245898c = cVar;
        }
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "reload. entryPath=" + str + APLogFileUtil.SEPARATOR_LOG + this);
        }
        a();
        a(str, true);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "cleanup. | " + this);
        }
        this.f245902g.cleanup(false);
        this.f245903h.f();
        com.tencent.mobileqq.microapp.appbrand.b.h.a().a(this.f245904i, this.f245899d);
    }

    public final void a(MiniAppConfig miniAppConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) miniAppConfig);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "onResume. | " + this);
        }
        this.f245905j = false;
        this.f245903h.d();
        this.f245902g.setVisibility(0);
        this.f245902g.bringToFront();
        this.f245902g.pageLinkedList.peek();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", miniAppConfig.launchParam.scene);
            jSONObject.put("appId", this.f245896a);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        a("onAppEnterForeground", jSONObject.toString());
        this.f245898c.a(miniAppConfig);
        com.tencent.mobileqq.microapp.appbrand.b.b.a().a(this.f245898c);
        com.tencent.mobileqq.microapp.app.b.a().a(MiniAppVideoConstants.NOTIFY_STATUS_RESUME);
        f();
        d();
    }

    public void a(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "evaluateServiceSubcribeJS. eventName=" + str + ",data=" + str2 + ",webviewId=" + i3 + APLogFileUtil.SEPARATOR_LOG + this);
        }
        this.f245904i.evaluateSubcribeJS(str, str2, i3);
    }

    public void a(String str, String str2) {
        String format;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            format = String.format("WeixinJSBridge.subscribeHandler('%1$s',%2$s)", str, str2);
        } else {
            format = String.format("WeixinJSBridge.subscribeHandler('%1$s')", str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "evaluateServiceSubcribeJS. jsStr=" + format);
        }
        this.f245904i.evaluteJs(format);
    }

    public String a(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, this, str, str2, baseAppBrandWebview, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntime", 4, "handleNativeRequest. eventName=" + str + ",jsonParams=" + str2 + ",callbackId=" + i3 + ",webview=" + baseAppBrandWebview + APLogFileUtil.SEPARATOR_LOG + this);
        }
        com.tencent.mobileqq.microapp.appbrand.a.a.f fVar = this.f245903h;
        return fVar != null ? fVar.a(str, str2, baseAppBrandWebview, i3) : "";
    }

    public void a(String str, String str2, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, str3);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startShare. content=");
            str4 = str;
            sb5.append(str4);
            sb5.append(",sharePicPath=");
            str5 = str2;
            sb5.append(str5);
            sb5.append(",entryPath=");
            sb5.append(str3);
            QLog.d("AppBrandRuntime", 4, sb5.toString());
        } else {
            str4 = str;
            str5 = str2;
        }
        String str8 = this.f245898c.f245822c;
        String str9 = "[\u5206\u4eab] \u8f7b\u5e94\u7528" + this.f245898c.f245822c;
        String str10 = this.f245898c.f245824e;
        String str11 = null;
        try {
            JSONObject jSONObject = new JSONObject(this.f245898c.f245825f.config.desc_info);
            str11 = jSONObject.optString("share_low_url", "");
            if (TextUtils.isEmpty(str)) {
                str4 = jSONObject.optString(WinkDaTongReportConstant.ElementParamKey.SHARE_CONTENT);
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = jSONObject.optString("desc_info");
            }
            str7 = TextUtils.isEmpty(str2) ? jSONObject.optString("share_pic_url") : str5;
            str6 = str4;
        } catch (JSONException e16) {
            e16.printStackTrace();
            str6 = str4;
            str7 = str5;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appId", this.f245896a);
            jSONObject2.put("entryPathInConfig", this.f245898c.f245821b.f246134f);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("entryPath", str3);
                str11 = str11 + "&path=" + URLEncoder.encode(str3);
            }
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        ShareMsgHelper.f(this.f245899d, 1001, 1, "web_share", "", str10, str8, str6, str9, str11, "web", jSONObject2.toString(), "micro_app", str7, null, null, null, null, null, null, null, null, 7, null, -1L);
    }
}
