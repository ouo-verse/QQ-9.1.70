package com.tencent.mobileqq.webview;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.webview.util.m f313992a;

    /* renamed from: b, reason: collision with root package name */
    public long f313993b;

    /* renamed from: c, reason: collision with root package name */
    public long f313994c;

    /* renamed from: d, reason: collision with root package name */
    public long f313995d;

    /* renamed from: e, reason: collision with root package name */
    public long f313996e;

    /* renamed from: f, reason: collision with root package name */
    public long f313997f;

    /* renamed from: g, reason: collision with root package name */
    public long f313998g;

    public m(com.tencent.mobileqq.webview.util.m mVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mVar);
            return;
        }
        this.f313993b = 0L;
        this.f313994c = 0L;
        this.f313995d = 0L;
        this.f313996e = 0L;
        this.f313997f = 0L;
        this.f313998g = 0L;
        this.f313992a = mVar;
    }

    public void a(Bundle bundle, AppRuntime appRuntime, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bundle, appRuntime, intent);
            return;
        }
        if (intent != null && intent.getBooleanExtra("pre_init_webview_plugin", true)) {
            this.f313992a.preInitWebviewPlugin();
        }
        if (intent != null && intent.getBooleanExtra("pre_get_key", true)) {
            WebAccelerateHelper.getInstance().preGetKey(intent, appRuntime);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f313992a.buildLayout();
        long currentTimeMillis2 = System.currentTimeMillis();
        this.f313994c = currentTimeMillis2 - currentTimeMillis;
        this.f313992a.buildContentView(bundle);
        long currentTimeMillis3 = System.currentTimeMillis();
        this.f313997f = currentTimeMillis3 - currentTimeMillis2;
        this.f313992a.buildTitleBar();
        long currentTimeMillis4 = System.currentTimeMillis();
        this.f313995d = currentTimeMillis4 - currentTimeMillis3;
        this.f313992a.buildBottomBar();
        long currentTimeMillis5 = System.currentTimeMillis();
        this.f313996e = currentTimeMillis5 - currentTimeMillis4;
        this.f313992a.buildWebView(appRuntime);
        long currentTimeMillis6 = System.currentTimeMillis();
        this.f313993b = currentTimeMillis6 - currentTimeMillis5;
        this.f313992a.buildData();
        this.f313998g = System.currentTimeMillis() - currentTimeMillis6;
        if (QLog.isColorLevel()) {
            QLog.i("WebViewDirector", 2, "buildLayoutTime : " + this.f313994c + ", buildContentTime " + this.f313997f + ", buildTitleTime " + this.f313995d + ", buildWebViewTime " + this.f313993b + ", buildBottomTime " + this.f313996e + ", buildDataTime " + this.f313998g);
        }
    }
}
