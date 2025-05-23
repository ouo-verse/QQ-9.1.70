package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import cooperation.pluginbridge.BridgeHelper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AbsBaseWebViewActivityImpl implements com.tencent.mobileqq.webview.swift.injector.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected volatile boolean f314004a;

    public AbsBaseWebViewActivityImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314004a = false;
        }
    }

    private void f(Activity activity) {
        if (!this.f314004a) {
            this.f314004a = true;
            String stringExtra = activity.getIntent().getStringExtra("url");
            if (com.tencent.mobileqq.webview.webso.e.E(stringExtra)) {
                ThreadManagerV2.postImmediately(new Runnable(stringExtra) { // from class: com.tencent.mobileqq.webview.swift.AbsBaseWebViewActivityImpl.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f314005d;

                    {
                        this.f314005d = stringExtra;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsBaseWebViewActivityImpl.this, (Object) stringExtra);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            WebSoService.j().E(this.f314005d, null);
                        }
                    }
                }, null, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.a
    public void a(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity);
            return;
        }
        String a16 = BridgeHelper.b(qBaseActivity, qBaseActivity.getAppRuntime().getAccount()).a("buscard_registerNFC");
        if (TextUtils.isEmpty(a16) || "true".equals(a16)) {
            ActivityLifecycle.onPause(qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.a
    public WebResourceResponse b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (WebResourceResponse) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return (WebResourceResponse) ((IPublicAccountH5AbilityPlugin) QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebResponse(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.a
    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && str.startsWith(IPublicAccountH5AbilityPlugin.LOCALID_HEAD)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.a
    public void d(int i3, int i16, Intent intent, TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), intent, touchWebView);
            return;
        }
        if (i16 == -1 && touchWebView != null) {
            switch (i3) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    if (intent == null) {
                        return;
                    }
                    touchWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + intent.getStringExtra("callbackSn") + "',{'r':0,'result':" + intent.getStringExtra("result") + "});");
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.a
    public void e(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity);
            return;
        }
        Intent intent = new Intent("tencent.notify.foreground");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra("selfuin", qBaseActivity.getAppRuntime().getAccount());
        intent.putExtra("AccountInfoSync", AppConstants.SYNCWEB);
        intent.putExtra("classname", getClass().getName());
        qBaseActivity.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        String a16 = BridgeHelper.b(qBaseActivity, qBaseActivity.getAppRuntime().getAccount()).a("buscard_registerNFC");
        if (TextUtils.isEmpty(a16) || "true".equals(a16)) {
            ActivityLifecycle.onResume(qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.a
    public void onCreate(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            f(activity);
        }
    }
}
