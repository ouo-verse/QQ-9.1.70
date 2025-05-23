package com.qq.e.comm.plugin.base.ad.b.b;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.base.ad.b.b.a;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.r;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends a {
    private ValueCallback<Uri> A;
    private volatile boolean B;
    private volatile boolean C;
    private volatile boolean D;
    private volatile boolean E;

    /* renamed from: w, reason: collision with root package name */
    private IInnerWebView f38462w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f38463x;

    /* renamed from: y, reason: collision with root package name */
    private com.qq.e.comm.plugin.n.a.a f38464y;

    /* renamed from: z, reason: collision with root package name */
    private ValueCallback<Uri[]> f38465z;

    public f(a.b bVar) {
        super(bVar);
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void a(int i3, int i16, Intent intent) {
        Uri[] uriArr;
        Uri data;
        Uri uri;
        if (1 == i3) {
            try {
                if (this.f38465z != null) {
                    if (i16 == -1 && intent != null && (data = intent.getData()) != null) {
                        uriArr = new Uri[]{data};
                    } else {
                        uriArr = null;
                    }
                    this.f38465z.onReceiveValue(uriArr);
                    this.f38465z = null;
                    return;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                return;
            }
        }
        if (2 == i3 && this.A != null) {
            if (i16 == -1 && intent != null) {
                uri = intent.getData();
            } else {
                uri = null;
            }
            this.A.onReceiveValue(uri);
            this.A = null;
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void b() {
        if (!a()) {
            a.InterfaceC0278a interfaceC0278a = this.f38386b;
            if (interfaceC0278a != null) {
                interfaceC0278a.b();
                return;
            }
            return;
        }
        super.b();
        StatTracer.trackEvent(4003050, 0, this.f38391g);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.f38400p) {
            d();
            c();
            layoutParams.topMargin = this.f38402r;
        }
        String stringExtra = this.f38385a.getIntent().getStringExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f38464y = new com.qq.e.comm.plugin.n.a.a(stringExtra, this.f38397m);
        }
        com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_WEBVIEW_INIT_START, this.f38397m, this.f38394j);
        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_INITIALIZE_START, 0, z.a(this.f38391g, null, this.f38397m));
        IInnerWebView buildInnerWebView = ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).buildInnerWebView(this.f38385a, this.f38390f.v());
        this.f38462w = buildInnerWebView;
        if (buildInnerWebView != null && buildInnerWebView.getView() != null) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_INITIALIZE_SUCCESS, 0, z.a(this.f38391g, null, this.f38397m));
            this.f38387c.addView(this.f38462w.getView(), layoutParams);
            this.f38386b.a(this.f38387c);
            this.f38462w.setInnerWebViewListener(this);
            com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_WEBVIEW_INIT_FINISH, this.f38397m, this.f38394j);
            if (com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(this.f38392h)) {
                com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_CGI_REQUEST_START, this.f38397m, this.f38394j);
                StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_START, 0, z.a(this.f38391g, null, this.f38397m));
            } else {
                StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_LOAD_URL_START, 0, z.a(this.f38391g, null, this.f38397m));
                r.a(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_LOAD_URL_START, this.f38390f.f(), this.f38390f.y(), this.f38403s, this.f38404t);
            }
            this.f38462w.loadUrl(this.f38392h);
            if (this.f38462w.getView() != null) {
                this.f38462w.getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.f.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        f.this.f38386b.a();
                        return false;
                    }
                });
            }
            if (this.f38399o) {
                au.a(ProfileContants.FIELD_NEW_PROFILE_MODIFIED_FLAG, 0, this.f38391g, null, 0);
                ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).addHandler(com.qq.e.comm.plugin.n.c.f39695a, this.f38462w, "feedbackService", this.f38385a);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void e() {
        IInnerWebView iInnerWebView = this.f38462w;
        if (iInnerWebView != null) {
            iInnerWebView.reload();
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public boolean f() {
        GDTLogger.d("WebviewLandingPageView onBackPressed");
        IInnerWebView iInnerWebView = this.f38462w;
        if (iInnerWebView != null && iInnerWebView.canGoBack()) {
            this.f38462w.goBack();
            return true;
        }
        com.qq.e.comm.plugin.n.a.a aVar = this.f38464y;
        if (aVar != null && !this.f38399o) {
            aVar.a(this.f38392h, com.qq.e.comm.plugin.n.a.a.f39669e);
        }
        g();
        return false;
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void g() {
        if (!this.C) {
            this.C = true;
            com.qq.e.comm.plugin.n.a.b.f39676a.a(this.f38462w, this.f38394j, this.f38391g);
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public int h() {
        return 1;
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void i() {
        GDTLogger.d("WebviewLandingPageView onResume");
        try {
            if (this.f38463x) {
                IInnerWebView iInnerWebView = this.f38462w;
                if (iInnerWebView != null && iInnerWebView.getView() != null) {
                    this.f38462w.getView().getClass().getMethod("onResume", new Class[0]).invoke(this.f38462w.getView(), null);
                }
                this.f38463x = false;
            }
        } catch (RuntimeException unused) {
            GDTLogger.e("WebviewLandingPageView InnerBrowser onResume err");
        } catch (Exception unused2) {
            GDTLogger.e("WebviewLandingPageView InnerBrowser onResume err");
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void j() {
        GDTLogger.d("WebviewLandingPageView onPause");
        com.qq.e.comm.plugin.n.a.a aVar = this.f38464y;
        if (aVar != null && !this.f38399o) {
            aVar.a(this.f38392h, com.qq.e.comm.plugin.n.a.a.f39670f);
        }
        try {
            IInnerWebView iInnerWebView = this.f38462w;
            if (iInnerWebView != null && iInnerWebView.getView() != null) {
                this.f38462w.getView().getClass().getMethod(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Class[0]).invoke(this.f38462w.getView(), null);
                this.f38463x = true;
            }
        } catch (RuntimeException e16) {
            GDTLogger.e("WebviewLandingPageView InnerBrowser onPause err" + e16);
        } catch (Exception e17) {
            GDTLogger.e("WebviewLandingPageView InnerBrowser onPause err" + e17);
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.b.b.a
    public void k() {
        GDTLogger.d("WebviewLandingPageView onDestroy");
        com.qq.e.comm.plugin.n.a.a aVar = this.f38464y;
        if (aVar != null && !this.f38399o) {
            aVar.a(this.f38392h, com.qq.e.comm.plugin.n.a.a.f39671g);
        }
        if (!this.C) {
            this.C = true;
            com.qq.e.comm.plugin.n.a.b.f39676a.a(this.f38462w, this.f38394j, this.f38391g);
        }
        IInnerWebView iInnerWebView = this.f38462w;
        if (iInnerWebView != null) {
            iInnerWebView.destroySafely();
        }
    }
}
