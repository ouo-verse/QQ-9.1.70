package com.qq.e.comm.plugin.base.ad.clickcomponent.e;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.b;
import com.qq.e.comm.plugin.base.media.video.GDTVideoView;
import com.qq.e.comm.plugin.base.media.video.b;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.ao;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.webview.bridge.GDTJSEvent;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import com.qq.e.comm.plugin.webview.inner.InnerWebViewListener;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.highway.transaction.Tracker;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<GDTVideoView> f38622a;

    /* renamed from: b, reason: collision with root package name */
    private IInnerWebView f38623b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f38624c;

    /* renamed from: d, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.model.f f38625d;

    /* renamed from: e, reason: collision with root package name */
    private long f38626e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<g> f38627f;

    /* renamed from: g, reason: collision with root package name */
    private Pair<String, String> f38628g;

    /* renamed from: h, reason: collision with root package name */
    private String f38629h;

    /* renamed from: i, reason: collision with root package name */
    private com.qq.e.comm.plugin.n.a.a f38630i;

    /* renamed from: j, reason: collision with root package name */
    private String f38631j;

    /* renamed from: k, reason: collision with root package name */
    private String f38632k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f38633l;

    /* renamed from: m, reason: collision with root package name */
    private long f38634m;

    /* renamed from: n, reason: collision with root package name */
    private String f38635n;

    public c(Context context) {
        super(context);
        this.f38626e = 0L;
        Activity activity = (Activity) context;
        this.f38634m = activity.getIntent().getLongExtra("clickStartTime", System.currentTimeMillis());
        this.f38635n = activity.getIntent().getStringExtra("posId");
        this.f38629h = activity.getIntent().getStringExtra("as");
        com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_WEBVIEW_INIT_START, this.f38634m, this.f38635n);
        a(context);
    }

    private void d() {
        com.qq.e.comm.plugin.base.ad.model.f fVar = this.f38625d;
        if (fVar != null && com.qq.e.comm.plugin.k.d.a(fVar.v())) {
            String g16 = g();
            if (!TextUtils.isEmpty(g16)) {
                a(((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getStatus(g16), ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getProgress(GDTADManager.getInstance().getAppContext(), g16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (f()) {
            a(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        boolean z16;
        if (this.f38625d == null) {
            return false;
        }
        int status = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getStatus(g());
        boolean a16 = com.qq.e.comm.plugin.k.d.a(this.f38625d.v());
        if (GDTADManager.getInstance().getDeviceStatus().getNetworkType() == NetworkType.WIFI) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!a16 || !z16 || !ao.f(status) || !com.qq.e.comm.plugin.j.c.a(this.f38635n, "appLandingPageWifiAutoDownload", 1, 1)) {
            return false;
        }
        return true;
    }

    private String g() {
        com.qq.e.comm.plugin.base.ad.model.f fVar = this.f38625d;
        if (fVar != null) {
            return com.qq.e.comm.plugin.k.d.c(fVar.v()).b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClickInfo b(int i3) {
        if (this.f38625d == null) {
            GDTLogger.e("NativeWebVideoDetailViewgetClickInfo is null");
            return null;
        }
        com.qq.e.comm.plugin.base.ad.clickcomponent.e eVar = new com.qq.e.comm.plugin.base.ad.clickcomponent.e(new WeakReference(this));
        eVar.b(-1);
        eVar.a(this.f38629h);
        return new ClickInfo.b().a(this.f38625d).a(new ClickInfo.c(this.f38625d.u(), this.f38625d.t(), this.f38625d.s())).a(eVar).a(new ClickInfo.d(this.f38628g, i3)).a();
    }

    public void c() {
        WeakReference<Context> weakReference = this.f38624c;
        if (weakReference != null) {
            weakReference.clear();
            this.f38624c = null;
        }
        if (this.f38622a != null) {
            this.f38622a = null;
        }
        com.qq.e.comm.plugin.n.a.a aVar = this.f38630i;
        if (aVar != null) {
            aVar.a(this.f38631j, com.qq.e.comm.plugin.n.a.a.f39669e);
        }
    }

    public void a(g gVar) {
        this.f38627f = new WeakReference<>(gVar);
    }

    private void a(Context context) {
        if (context == null) {
            GDTLogger.e("NativeWebVideoDetailView initView failed context is null");
            return;
        }
        this.f38633l = false;
        this.f38624c = new WeakReference<>(context);
        IInnerWebView buildInnerWebView = ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).buildInnerWebView(context, null);
        this.f38623b = buildInnerWebView;
        if (buildInnerWebView == null || buildInnerWebView.getView() == null) {
            return;
        }
        this.f38623b.getView().setBackgroundColor(0);
        com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_WEBVIEW_INIT_FINISH, this.f38634m, this.f38635n);
        this.f38623b.setInnerWebViewListener(new InnerWebViewListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.c.1
        });
    }

    public void b() {
        WeakReference<GDTVideoView> weakReference = this.f38622a;
        if (weakReference != null && weakReference.get() != null && this.f38622a.get().c()) {
            this.f38622a.get().b();
            WeakReference<g> weakReference2 = this.f38627f;
            if (weakReference2 != null && weakReference2.get() != null) {
                this.f38627f.get().a(this.f38627f.get().u());
                this.f38627f.get().i();
            }
        }
        com.qq.e.comm.plugin.n.a.a aVar = this.f38630i;
        if (aVar != null) {
            aVar.a(this.f38631j, com.qq.e.comm.plugin.n.a.a.f39670f);
        }
    }

    public void a(final GDTVideoView gDTVideoView, com.qq.e.comm.plugin.base.media.video.b bVar, com.qq.e.comm.plugin.base.ad.model.f fVar, boolean z16) {
        WeakReference<Context> weakReference;
        FrameLayout.LayoutParams layoutParams;
        if (gDTVideoView == null || bVar == null || fVar == null || (weakReference = this.f38624c) == null || weakReference.get() == null || this.f38623b == null) {
            return;
        }
        this.f38625d = fVar;
        ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).addHandler(com.qq.e.comm.plugin.n.c.f39696b, this.f38623b, "videoService", fVar.v(), this);
        if (fVar.v() != null) {
            this.f38630i = new com.qq.e.comm.plugin.n.a.a(fVar.v().optString("landing_page_report_url"), this.f38634m);
        }
        ViewParent parent = gDTVideoView.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(gDTVideoView);
        }
        this.f38622a = new WeakReference<>(gDTVideoView);
        Context context = this.f38624c.get();
        a(context, fVar, z16);
        if (z16) {
            this.f38622a.get().b(2);
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            this.f38622a.get().b(1);
            layoutParams = new FrameLayout.LayoutParams(ak.b(context), a(context, fVar));
        }
        layoutParams.gravity = 17;
        ViewParent parent2 = bVar.getParent();
        if (parent2 != null) {
            ((ViewGroup) parent2).removeView(bVar);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        bVar.b();
        addView(this.f38622a.get(), 0, layoutParams2);
        addView(bVar, 1, layoutParams);
        if (this.f38623b.getView() != null) {
            addView(this.f38623b.getView(), 2, new FrameLayout.LayoutParams(-1, -1));
        }
        bVar.a(new b.c() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.c.2
            @Override // com.qq.e.comm.plugin.base.media.video.b.c
            public void a() {
                c.this.a(gDTVideoView.j());
            }
        });
        GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.c.3
            @Override // java.lang.Runnable
            public void run() {
                ClickInfo b16 = c.this.b(0);
                if (b16 != null && b16.i() != null) {
                    c.this.f38628g = b16.i().a(b16);
                    if (c.this.f38628g != null && c.this.f()) {
                        c.this.e();
                    }
                }
            }
        });
    }

    private void a(Context context, com.qq.e.comm.plugin.base.ad.model.f fVar, boolean z16) {
        int b16 = ak.b(context);
        int c16 = ak.c(context);
        if (!z16) {
            c16 = a(context, fVar);
        }
        this.f38632k = a(a(fVar), b16, c16);
        GDTLogger.i("NativeWebVideoDetailViewloadWebView url :" + this.f38632k);
        String str = this.f38632k;
        this.f38631j = str;
        if (com.qq.e.comm.plugin.n.a.a.a(str)) {
            com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_CGI_REQUEST_START, this.f38634m, this.f38635n);
        }
        this.f38623b.loadUrl(this.f38632k);
    }

    private int a(Context context, com.qq.e.comm.plugin.base.ad.model.f fVar) {
        return fVar.A() > 0 ? (int) ((fVar.B() * r6) / (fVar.A() * 1.0d)) : (int) ((ak.b(context) * 1.0d) / 0.5625d);
    }

    private String a(String str, int i3, int i16) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("NativeWebVideoDetailViewaddWebUrlParams url is null ");
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", i3);
            jSONObject.put("height", i16);
            if (!jSONObject.toString().isEmpty()) {
                str2 = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            }
        } catch (Throwable th5) {
            GDTLogger.e("NativeWebVideoDetailViewaddWebUrlParams error :", th5);
        }
        return !TextUtils.isEmpty(str2) ? ay.c(str, "params", str2) : str;
    }

    private void a(int i3) {
        ClickInfo b16 = b(i3);
        if (this.f38628g == null) {
            return;
        }
        new b.a().a(b16).a().a().a();
    }

    public void a(int i3, int i16) {
        IInnerWebView iInnerWebView;
        com.qq.e.comm.plugin.base.ad.model.f fVar = this.f38625d;
        if (fVar == null || !com.qq.e.comm.plugin.k.d.a(fVar.v()) || (iInnerWebView = this.f38623b) == null || iInnerWebView == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("status", Integer.valueOf(i3));
            jSONObject.putOpt("progress", Integer.valueOf(i16));
            ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).fireJSEvent(this.f38623b, new GDTJSEvent("onAPKStatusUpdate", jSONObject));
            GDTLogger.d(String.format("jsbridge.dispatch updateAppDownloadStatus\uff08%d,%d\uff09", Integer.valueOf(i3), Integer.valueOf(i16)));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z16) {
        WeakReference<GDTVideoView> weakReference;
        String str;
        if (this.f38623b != null && (weakReference = this.f38622a) != null && weakReference.get() != null) {
            GDTVideoView gDTVideoView = this.f38622a.get();
            int f16 = gDTVideoView.f();
            if (this.f38626e == 0) {
                this.f38626e = gDTVideoView.e();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("isMute", Boolean.valueOf(gDTVideoView.d()));
                jSONObject.putOpt("totalDuration", Long.valueOf(this.f38626e));
                jSONObject.putOpt("currentPosition", Integer.valueOf(f16));
                if (!gDTVideoView.c() && !z16) {
                    str = gDTVideoView.f() < gDTVideoView.e() ? Tracker.PAUSE : "COMPLETE";
                    jSONObject.putOpt("status", str);
                    ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).fireJSEvent(this.f38623b, new GDTJSEvent("getVideoStatus", jSONObject));
                    return;
                }
                str = "PLAYING";
                jSONObject.putOpt("status", str);
                ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).fireJSEvent(this.f38623b, new GDTJSEvent("getVideoStatus", jSONObject));
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return;
            }
        }
        GDTLogger.e("NativeWebVideoDetailViewupdateVideoStatusToJsBridge mInnerWebView or mVideoView is null mVideoView:" + this.f38622a);
    }

    private String a(com.qq.e.comm.plugin.base.ad.model.f fVar) {
        if (fVar == null || fVar.v() == null) {
            return null;
        }
        return fVar.v().optString("bottom_card_url");
    }

    public void a() {
        WeakReference<GDTVideoView> weakReference = this.f38622a;
        if (weakReference != null && weakReference.get() != null && !this.f38622a.get().c()) {
            this.f38622a.get().a();
            a(true);
        }
        d();
    }
}
