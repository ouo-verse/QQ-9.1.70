package com.qq.e.comm.plugin.base.ad.clickcomponent.e;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.m;
import com.qq.e.comm.plugin.k.n;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.r;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import com.qq.e.comm.plugin.webview.inner.InnerWebViewListener;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.nativ.MediaView;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.ams.pcad.landingpage.DynamicAd;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements ACTD, com.qq.e.comm.plugin.base.ad.clickcomponent.e.a, f, InnerWebViewListener {

    /* renamed from: o, reason: collision with root package name */
    private static int f38640o;
    private int B;
    private long F;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private int M;
    private int N;
    private String O;
    private com.qq.e.comm.plugin.n.a.a P;
    private com.qq.e.comm.plugin.base.ad.b.b.a.c Q;
    private JSONObject R;
    private float S;
    private boolean T;
    private DynamicAd U;

    /* renamed from: a, reason: collision with root package name */
    private Activity f38641a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f38642b;

    /* renamed from: c, reason: collision with root package name */
    private ScrollView f38643c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f38644d;

    /* renamed from: e, reason: collision with root package name */
    private IInnerWebView f38645e;

    /* renamed from: f, reason: collision with root package name */
    private long f38646f;

    /* renamed from: g, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.model.f f38647g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f38648h;

    /* renamed from: i, reason: collision with root package name */
    private g f38649i;

    /* renamed from: j, reason: collision with root package name */
    private h f38650j;

    /* renamed from: k, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.c f38651k;

    /* renamed from: l, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.widget.d f38652l;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f38653m;

    /* renamed from: r, reason: collision with root package name */
    private int f38657r;

    /* renamed from: s, reason: collision with root package name */
    private e f38658s;

    /* renamed from: t, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.b.b.a.b f38659t;

    /* renamed from: z, reason: collision with root package name */
    private int f38665z;

    /* renamed from: n, reason: collision with root package name */
    private int f38654n = 1;

    /* renamed from: p, reason: collision with root package name */
    private int f38655p = 607;

    /* renamed from: q, reason: collision with root package name */
    private int f38656q = 1920;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f38660u = false;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f38661v = false;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f38662w = false;

    /* renamed from: x, reason: collision with root package name */
    private long f38663x = -1;

    /* renamed from: y, reason: collision with root package name */
    private long f38664y = 0;
    private a A = new a();
    private com.qq.e.comm.plugin.stat.b C = new com.qq.e.comm.plugin.stat.b();
    private com.qq.e.comm.plugin.stat.c D = new com.qq.e.comm.plugin.stat.c();
    private boolean E = false;
    private boolean G = false;
    private volatile boolean V = false;
    private volatile boolean W = false;
    private volatile boolean X = false;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class a implements com.qq.e.comm.plugin.base.media.video.a {
        a() {
        }

        @Override // com.qq.e.comm.plugin.base.media.video.a
        public void a(boolean z16) {
        }

        @Override // com.qq.e.comm.plugin.base.media.video.a
        public void b() {
            if (d.this.B == 4) {
                d.this.f38641a.setRequestedOrientation(1);
                return;
            }
            if (d.this.f38658s != null && d.this.f38658s.f38687a == 0) {
                if (!d.this.V && d.this.a() != null) {
                    d.this.V = true;
                    com.qq.e.comm.plugin.n.a.b.f39676a.a(d.this.a(), d.this.I, d.this.R);
                }
                d.this.n();
            }
        }

        @Override // com.qq.e.comm.plugin.base.media.video.a
        public void a() {
            d.this.f38641a.setRequestedOrientation(d.this.B == 4 ? 1 : 0);
            StatTracer.trackEvent(30262, d.this.B, d.this.C, d.this.D);
        }

        @Override // com.qq.e.comm.plugin.base.media.video.a
        public void c() {
        }
    }

    public d(Activity activity) {
        this.f38641a = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        int i3;
        if (this.f38647g == null) {
            n();
            return;
        }
        e();
        g gVar = this.f38649i;
        if (gVar != null) {
            this.f38651k = gVar.r();
        }
        if (m()) {
            i3 = 4;
        } else {
            i3 = 3;
        }
        this.B = i3;
        this.f38641a.getIntent().getStringExtra("as");
        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXTENSIONS_LOAD_START, 0, z.a(this.C, this.R, this.f38646f));
        g();
        g gVar2 = this.f38649i;
        if (gVar2 != null && gVar2.e()) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXTENSIONS_VIDEO_PLAY_START, 0, z.a(this.C, this.R, this.f38646f));
        }
        i();
        d(this.f38658s.e());
        if (!this.f38644d.isHardwareAccelerated()) {
            GDTLogger.e("Hardware acceleration is off");
            StatTracer.trackEvent(ErrorCode.SRERR_INVALID_BITS_PER_SAMPLE, 2, this.C, this.D);
        }
        d();
        com.qq.e.comm.plugin.base.ad.model.f fVar = this.f38647g;
        if (fVar != null && this.T && fVar.R()) {
            f();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        com.qq.e.comm.plugin.base.media.video.b bVar;
        GDTLogger.d("VideoCeilingActivityDelegate onBackPressed");
        com.qq.e.comm.plugin.n.a.a aVar = this.P;
        if (aVar != null) {
            aVar.a(this.H, com.qq.e.comm.plugin.n.a.a.f39669e);
        }
        if (!this.V) {
            this.V = true;
            IInnerWebView a16 = a();
            if (a16 != null) {
                com.qq.e.comm.plugin.n.a.b.f39676a.a(a16, this.I, this.R);
            }
        }
        if (m()) {
            this.f38641a.setRequestedOrientation(1);
            return;
        }
        GDTLogger.d("NativeAdDetailPageActivityDelegate onBackPressed");
        if (this.f38649i.f38706d != null && this.f38649i.f38706d.c() && (bVar = this.f38649i.f38705c) != null) {
            bVar.d();
        }
        n();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        int i3;
        GDTLogger.d("handleJump video ceiling onBeforeCreate");
        this.f38641a.setTheme(R.style.Theme.Black.NoTitleBar.Fullscreen);
        this.E = this.f38641a.getIntent().getBooleanExtra(WadlProxyConsts.VIA_AUTO_DOWNLOAD, false);
        this.H = this.f38641a.getIntent().getStringExtra("dstlink");
        this.M = this.f38641a.getIntent().getIntExtra("clickViewTag", -1);
        this.f38648h = this.f38641a.getIntent().getBooleanExtra("shouldReportClick", true);
        boolean booleanExtra = this.f38641a.getIntent().getBooleanExtra("useVelen", false);
        c();
        this.I = this.f38641a.getIntent().getStringExtra("posId");
        com.qq.e.comm.plugin.base.ad.model.f fVar = this.f38647g;
        if (fVar == null) {
            n();
            return;
        }
        this.K = fVar.y();
        this.J = this.f38647g.f();
        this.N = this.f38641a.getIntent().getIntExtra("destType", -1);
        this.O = this.f38641a.getIntent().getStringExtra("mqqLandingPage");
        this.C.a(this.I);
        this.C.c(this.K);
        this.C.b(this.J);
        JSONObject jSONObject = new JSONObject();
        this.R = jSONObject;
        try {
            jSONObject.putOpt("pid", this.I);
            this.R.putOpt("aid", this.J);
            this.R.putOpt("traceid", this.K);
            this.R.putOpt("wv_progress", 1);
            this.R.putOpt("lp_type", 4);
            JSONObject jSONObject2 = this.R;
            if (booleanExtra) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            jSONObject2.putOpt("is_offline", Integer.valueOf(i3));
        } catch (JSONException e16) {
            GDTLogger.e(e16.getMessage());
        }
        this.f38646f = System.currentTimeMillis();
        String r16 = this.f38647g.r();
        if (!StringUtil.isEmpty(r16)) {
            this.P = new com.qq.e.comm.plugin.n.a.a(r16, this.f38646f);
        }
        this.D.a("cost_time", Long.valueOf(System.currentTimeMillis() - this.f38646f));
        com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_WEBVIEW_INIT_START, this.f38646f, this.I);
        StatTracer.trackEvent(30222, 1, this.C, this.D);
        if (this.f38647g.isAppAd() && com.qq.e.comm.plugin.c.a.a() && com.qq.e.comm.plugin.c.a.b().isCanvas(this.f38647g.v())) {
            if (com.qq.e.comm.plugin.c.a.c()) {
                StatTracer.trackEvent(133019, 0, (com.qq.e.comm.plugin.stat.b) null);
            } else {
                this.f38653m = com.qq.e.comm.plugin.c.a.b().getCanvasView(this.f38641a, this.f38647g.v(), this.E, false);
            }
        }
        if (this.f38653m == null) {
            StatTracer.trackEvent(4003001, 0, z.a(this.C, this.R, this.f38646f));
            r.a(4003001, this.J, this.K, this.O, this.N);
        } else {
            StatTracer.trackEvent(4003001, 0, z.a(this.C, (JSONObject) null));
            r.a(4003001, this.J, this.K, this.O, this.N);
        }
        this.f38665z = (int) (Math.min(ak.b(this.f38641a), ak.c(this.f38641a)) * this.S);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
        b(m());
        a(m());
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        GDTLogger.d("VideoCeilingActivityDelegate onDestroy");
        k();
        com.qq.e.comm.plugin.n.a.a aVar = this.P;
        if (aVar != null) {
            aVar.a(this.H, com.qq.e.comm.plugin.n.a.a.f39671g);
        }
        e eVar = this.f38658s;
        if (eVar != null && eVar.e() == 2 && !this.f38662w && this.f38648h) {
            com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.a(this.f38647g.n(), this.I, this.C, this.f38646f);
        }
        if (!this.V) {
            this.V = true;
            IInnerWebView a16 = a();
            if (a16 != null) {
                com.qq.e.comm.plugin.n.a.b.f39676a.a(a16, this.I, this.R);
            }
        }
        h hVar = this.f38650j;
        if (hVar != null && hVar.a()) {
            StatTracer.trackEvent(gdt_analysis_event.EVENT_OLYMPIC_INTER_PAGE_CLOSE, 0, this.C, (com.qq.e.comm.plugin.stat.c) null);
        }
        e eVar2 = this.f38658s;
        if (eVar2 != null) {
            eVar2.d();
        }
        DynamicAd dynamicAd = this.U;
        if (dynamicAd != null) {
            dynamicAd.clear();
        }
        g gVar = this.f38649i;
        if (gVar != null) {
            gVar.s();
            StatTracer.trackEvent(30222, 2, this.C, this.D);
        }
        if (!this.f38662w) {
            if (this.f38653m == null) {
                StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_BEFORE_LOAD_SUCCESS, 0, z.a(this.C, this.R, this.f38646f));
                r.a(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_BEFORE_LOAD_SUCCESS, this.J, this.K, this.O, this.N);
            }
        } else {
            e eVar3 = this.f38658s;
            if (eVar3 != null && eVar3.e() != 2) {
                if (!this.f38660u) {
                    StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_WITHOUT_ACTION, 0, z.a(this.C, this.R, this.f38646f + this.f38664y));
                    r.a(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_WITHOUT_ACTION, this.J, this.K, this.O, this.N);
                } else {
                    StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_AFTER_LOAD_SUCCESS, 0, z.a(this.C, this.R, this.f38646f + this.f38664y));
                    r.a(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_AFTER_LOAD_SUCCESS, this.J, this.K, this.O, this.N);
                }
            }
        }
        StatTracer.instantReport(this.I);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        this.f38663x = System.currentTimeMillis();
        j();
        e eVar = this.f38658s;
        if (eVar != null) {
            eVar.c();
        }
        DynamicAd dynamicAd = this.U;
        if (dynamicAd != null) {
            dynamicAd.pauseAd();
        }
        com.qq.e.comm.plugin.n.a.a aVar = this.P;
        if (aVar != null) {
            aVar.a(this.H, com.qq.e.comm.plugin.n.a.a.f39670f);
        }
        if (this.f38649i.f38706d != null && this.f38649i.f38706d.c()) {
            g gVar = this.f38649i;
            if (!gVar.f38723u) {
                gVar.c();
                this.f38649i.v();
            }
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        if (this.f38663x != -1) {
            this.f38664y += System.currentTimeMillis() - this.f38663x;
        }
        e eVar = this.f38658s;
        if (eVar != null) {
            eVar.b();
        }
        DynamicAd dynamicAd = this.U;
        if (dynamicAd != null) {
            dynamicAd.resumeAd();
        }
        if (this.f38649i != null) {
            GDTLogger.d("onResume setVideoPlayStartTime:" + this.f38649i.u());
            g gVar = this.f38649i;
            gVar.a(gVar.u());
            this.f38649i.t();
            this.f38649i.a(this.A);
        }
    }

    private void d() {
        g gVar = this.f38649i;
        if (gVar != null) {
            gVar.c(7);
            this.f38649i.a(0);
            this.f38649i.f(11);
        }
    }

    private void e() {
        this.f38642b = new RelativeLayout(this.f38641a);
        ScrollView scrollView = new ScrollView(this.f38641a) { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.1
            @Override // android.widget.ScrollView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return false;
            }
        };
        this.f38643c = scrollView;
        scrollView.setVerticalScrollBarEnabled(false);
        this.f38644d = new RelativeLayout(this.f38641a) { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.8
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                d.this.a(motionEvent);
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        f38640o = n.a(this.f38641a, 750, 88);
        this.f38656q = ak.c(this.f38641a);
        int min = (int) Math.min(ak.c(this.f38641a), ak.b(this.f38641a) * this.S);
        this.f38655p = min;
        g gVar = this.f38649i;
        if (gVar != null) {
            gVar.b(min);
        }
        this.f38657r = this.f38656q - this.f38655p;
        e eVar = new e(this.f38641a);
        this.f38658s = eVar;
        eVar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (d.this.f38650j != null) {
                    if (d.this.f38658s != null && d.this.f38658s.getTop() <= d.f38640o) {
                        d.this.f38650j.a(10);
                    } else {
                        d.this.f38650j.a(11);
                    }
                }
            }
        });
        boolean z16 = GDTADManager.getInstance().getSM().getInteger("video_ceiling_can_scroll_landing_view", 0) == 1;
        this.T = z16;
        if (!z16) {
            this.f38658s.a(true);
        }
        this.f38643c.addView(this.f38644d, new FrameLayout.LayoutParams(-1, -1));
        this.f38642b.addView(this.f38643c);
        this.f38642b.setFitsSystemWindows(true);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = this.f38641a.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 2;
            this.f38641a.getWindow().setAttributes(attributes);
        }
        this.f38641a.setContentView(this.f38642b);
        this.f38641a.setRequestedOrientation(1);
        g gVar2 = this.f38649i;
        if (gVar2 != null) {
            gVar2.g(3);
        }
        com.qq.e.comm.plugin.base.ad.b.b.a.c cVar = new com.qq.e.comm.plugin.base.ad.b.b.a.c(this.f38641a, this.f38645e);
        this.Q = cVar;
        this.f38642b.addView(cVar.a(), new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(this.f38641a, 108), ak.a(this.f38641a, 108));
        layoutParams.addRule(15);
        layoutParams.addRule(14);
        this.f38642b.addView(this.Q.b(), layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        this.f38642b.addView(this.Q.c(), layoutParams2);
    }

    private void f() {
        if (this.f38650j == null) {
            this.f38650j = new h(this.f38641a, this.f38642b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ak.a(this.f38641a, o() ? 80 : 142), ak.a(this.f38641a, o() ? 142 : 80));
            layoutParams.topMargin = ak.a(this.f38641a, 64);
            layoutParams.rightMargin = ak.a(this.f38641a, 12);
            layoutParams.addRule(11);
            this.f38642b.addView(this.f38650j, layoutParams);
            this.f38650j.a(this.f38649i);
            this.f38650j.a(this.C);
            this.f38650j.setVisibility(8);
        }
    }

    @TargetApi(14)
    private void g() {
        g gVar = this.f38649i;
        if (gVar == null) {
            GDTLogger.e("handleMediaViewOutSideJump error");
            n();
            return;
        }
        gVar.a(false);
        if (this.f38649i.f38706d != null) {
            this.f38649i.f38706d.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXTENSIONS_LOAD_SUCCESS, 0, z.a(d.this.C, d.this.R, d.this.f38646f));
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
            this.f38649i.f38706d.b(com.qq.e.comm.plugin.j.c.a(this.I, "videoCeilingMediaCyclePlay", 0, 1));
            this.f38649i.f38706d.c(false);
        }
        if (!this.f38649i.f38722t) {
            GDTLogger.e("handleMediaViewOutSideJump error");
            n();
        } else {
            h();
        }
    }

    private void h() {
        com.qq.e.comm.plugin.base.widget.d dVar = this.f38649i.f38708f;
        this.f38652l = dVar;
        if (dVar != null) {
            dVar.c();
            this.f38652l.b().setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    d.this.l();
                    GDTLogger.d("NativeAd EndCard onCloseButtonClicked");
                    d.this.n();
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            this.f38649i.a(this);
        }
    }

    private void i() {
        if (this.f38647g.isAppAd() && a(this.f38647g.v(), this.f38665z)) {
            return;
        }
        e(this.f38665z);
    }

    private void j() {
        g gVar;
        if (SDKStatus.getSDKVersionCode() < 120) {
            GDTLogger.e("not support below 120 versionCode");
            return;
        }
        Bundle extras = this.f38641a.getIntent().getExtras();
        if (extras != null) {
            ResultReceiver resultReceiver = (ResultReceiver) extras.getParcelable("key_result_receiver");
            Bundle bundle = new Bundle();
            if (resultReceiver == null || (gVar = this.f38649i) == null) {
                return;
            }
            int u16 = gVar.u();
            if (u16 <= 0) {
                u16 = (int) this.F;
            }
            bundle.putLong("key_video_position", u16);
            resultReceiver.send(-1, bundle);
        }
    }

    private void k() {
        if (this.f38649i == null || this.f38641a == null) {
            return;
        }
        Intent intent = new Intent(this.f38649i.d());
        int u16 = this.f38649i.u();
        if (u16 <= 0) {
            u16 = (int) this.F;
        }
        intent.putExtra("key_video_position", u16);
        this.f38641a.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        g gVar = this.f38649i;
        gVar.f38723u = true;
        if (gVar.f38706d != null) {
            this.f38649i.f38706d.a(true);
        }
    }

    private boolean m() {
        return "l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        StatTracer.instantReport(this.I);
        this.f38641a.finish();
    }

    private boolean o() {
        com.qq.e.comm.plugin.base.ad.model.f fVar = this.f38647g;
        return fVar != null && fVar.K() == 4;
    }

    private void c() {
        this.F = this.f38641a.getIntent().getLongExtra("detailPagePlayTime", 0L);
        String stringExtra = this.f38641a.getIntent().getStringExtra("data");
        this.I = this.f38641a.getIntent().getStringExtra("posId");
        String stringExtra2 = this.f38641a.getIntent().getStringExtra("adThreadId");
        this.L = this.f38641a.getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(this.L)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                com.qq.e.comm.plugin.base.ad.model.f fVar = new com.qq.e.comm.plugin.base.ad.model.f(GDTADManager.getInstance().getAppStatus().getAPPID(), this.I, stringExtra2, com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD);
                this.f38647g = fVar;
                fVar.e(jSONObject);
                this.S = d(o());
                if (this.f38649i == null) {
                    g gVar = new g(this.f38641a, this.f38647g);
                    this.f38649i = gVar;
                    gVar.a(this.R, this.f38646f);
                }
            } catch (Throwable th5) {
                GDTLogger.e("handleCreateFromOutClickEvent", th5);
            }
            if (this.f38649i == null) {
                n();
                return;
            }
            JSONObject a16 = m.a(this.D.a(), this.f38641a, this.f38649i);
            StatTracer.trackEvent(30292, 2, this.C, new com.qq.e.comm.plugin.stat.c(a16));
            GDTLogger.i("before: " + a16.toString());
            this.f38641a.getWindow().setFlags(16777216, 16777216);
            return;
        }
        n();
    }

    private void b(boolean z16) {
        MediaView mediaView;
        if (this.f38658s == null) {
            return;
        }
        g gVar = this.f38649i;
        if (gVar != null && (mediaView = gVar.f38703a) != null) {
            if (z16) {
                mediaView.setLayoutParams(gVar.f38725w);
                this.f38649i.c(4);
            } else {
                mediaView.setLayoutParams(gVar.f38724v);
                d();
            }
        }
        if (z16) {
            f(4);
            this.f38658s.setVisibility(8);
        } else {
            f(3);
            this.f38658s.setVisibility(0);
        }
    }

    private void a(boolean z16) {
        if (this.f38652l != null) {
            if (z16) {
                this.f38649i.d(3);
            } else {
                this.f38649i.d(2);
            }
        }
    }

    private void d(int i3) {
        if (this.f38659t == null) {
            com.qq.e.comm.plugin.base.ad.b.b.a.b bVar = new com.qq.e.comm.plugin.base.ad.b.b.a.b(this.f38641a.getApplicationContext());
            this.f38659t = bVar;
            bVar.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            this.f38659t.a(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.11
                @Override // android.view.View.OnClickListener
                @SuppressLint({"WrongConstant"})
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    if (!d.this.f38658s.f()) {
                        d.this.n();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            this.f38659t.b(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IInnerWebView a16 = d.this.a();
                    if (!d.this.V && a16 != null) {
                        d.this.V = true;
                        com.qq.e.comm.plugin.n.a.b.f39676a.a(a16, d.this.I, d.this.R);
                    }
                    d.this.n();
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            this.f38659t.c(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    if (d.this.Q != null) {
                        d.this.Q.c().setVisibility(0);
                        d.this.Q.a().setVisibility(0);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            this.f38659t.b();
            if (i3 == 0) {
                this.f38659t.c();
            } else {
                this.f38659t.a();
            }
            this.f38659t.a(this.f38647g.g());
            this.f38659t.setBackgroundColor(-1);
            this.f38642b.addView(this.f38659t, new RelativeLayout.LayoutParams(-1, f38640o));
            this.f38659t.setVisibility(4);
        }
    }

    private boolean a(JSONObject jSONObject, int i3) {
        try {
            this.R.putOpt(LinkReportConstant$BizKey.CLICK_REQ_TYPE, 2);
            if (!com.qq.e.comm.plugin.c.a.a() || !com.qq.e.comm.plugin.c.a.b().isCanvas(this.f38647g.v()) || this.f38653m == null) {
                return false;
            }
            if (this.f38648h) {
                com.qq.e.comm.plugin.base.ad.clickcomponent.d.d.a(this.f38647g.n(), this.I, this.C, this.f38646f);
            }
            int i16 = this.f38657r;
            if (i16 < 0) {
                i16 = -1;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i16);
            layoutParams.topMargin = i3;
            this.f38658s.a(this, this.f38653m);
            this.f38644d.addView(this.f38658s, layoutParams);
            this.f38658s.post(new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.5
                @Override // java.lang.Runnable
                public void run() {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.f38658s.getLayoutParams();
                    layoutParams2.height = d.this.f38656q - d.this.f38655p;
                    d.this.f38658s.setLayoutParams(layoutParams2);
                }
            });
            return true;
        } catch (Throwable th5) {
            GDTLogger.e("VideoCeilingActivityDelegate", th5);
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.e.f
    public void b(int i3) {
        e eVar = this.f38658s;
        if (eVar == null || this.f38659t == null) {
            return;
        }
        int top = eVar.getTop();
        if (i3 <= 0 || top < this.f38655p) {
            int top2 = this.f38658s.getTop() + ((int) (i3 + 0.5f));
            int i16 = this.f38655p;
            if (top2 > i16 || top2 < (i16 = f38640o)) {
                top2 = i16;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f38658s.getLayoutParams();
            layoutParams.topMargin = top2;
            layoutParams.height = this.f38656q - f38640o;
            this.f38658s.setLayoutParams(layoutParams);
            g(i3);
        }
    }

    private void f(int i3) {
        this.B = i3;
        g gVar = this.f38649i;
        if (gVar != null) {
            gVar.c(i3);
        }
    }

    private void g(int i3) {
        e eVar = this.f38658s;
        if (eVar == null || this.f38659t == null) {
            return;
        }
        int top = eVar.getTop();
        int i16 = f38640o;
        int i17 = i16 * 2;
        int i18 = this.f38655p - i16;
        if (i3 < 0) {
            if (top <= i17) {
                this.f38659t.setVisibility(0);
                this.f38659t.setAlpha(((i17 - top) * 1.0f) / f38640o);
            }
        } else if (top >= i16) {
            this.f38659t.setAlpha(((r3 - top) * 1.0f) / i18);
        }
        if (this.f38659t.getAlpha() > 0.0d) {
            c(false);
        } else {
            c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            GDTLogger.d("video ceiling touch down");
            this.f38651k.a().m();
            this.f38651k.a().a(motionEvent.getX());
            this.f38651k.a().b(motionEvent.getY());
            this.f38651k.a().c(System.currentTimeMillis());
            return;
        }
        if (action != 1) {
            if (action != 2) {
                return;
            }
            this.f38651k.a().a(true);
        } else {
            GDTLogger.d("video ceiling touch up");
            this.f38651k.a().c(motionEvent.getX());
            this.f38651k.a().d(motionEvent.getY());
            this.f38651k.a().d(System.currentTimeMillis());
        }
    }

    private float d(boolean z16) {
        if (z16) {
            String a16 = com.qq.e.comm.plugin.j.c.a(this.I, "portraitTopVideoPlayerLayoutScale", "");
            if (TextUtils.isEmpty(a16)) {
                return 0.5625f;
            }
            try {
                String[] split = a16.split(":");
                if (split.length == 2 && Integer.parseInt(split[0]) != 0) {
                    return Integer.parseInt(split[1]) / Integer.parseInt(split[0]);
                }
            } catch (Exception unused) {
            }
        }
        return 0.5625f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z16) {
        com.qq.e.comm.plugin.base.media.video.b bVar;
        g gVar = this.f38649i;
        if (gVar == null || (bVar = gVar.f38705c) == null) {
            return;
        }
        if (z16) {
            bVar.setVisibility(0);
        } else {
            bVar.setVisibility(8);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.e.f
    public void c(int i3) {
        int i16;
        boolean z16;
        e eVar = this.f38658s;
        if (eVar == null || this.f38659t == null) {
            return;
        }
        int i17 = this.f38655p;
        int i18 = (int) (i17 * 0.2f);
        int i19 = i17 - i18;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) eVar.getLayoutParams();
        int i26 = layoutParams.topMargin;
        boolean z17 = true;
        if (i3 == 0) {
            if (i26 <= i19) {
                this.f38658s.f38687a = 2;
                i16 = -i26;
                z16 = false;
                z17 = false;
            } else {
                i16 = this.f38655p - i26;
                z17 = this.f38654n == 1;
                z16 = true;
            }
        } else if (i26 >= i18) {
            this.f38658s.f38687a = 0;
            i16 = this.f38655p - i26;
            z16 = false;
        } else {
            i16 = -i26;
            z16 = true;
            z17 = false;
        }
        int top = this.f38658s.getTop();
        int i27 = f38640o;
        if (top <= i27) {
            e eVar2 = this.f38658s;
            eVar2.f38687a = 2;
            layoutParams.topMargin = i27;
            layoutParams.height = this.f38656q - i27;
            eVar2.setLayoutParams(layoutParams);
            c(false);
            return;
        }
        if (Math.abs(i16) > 0) {
            a(i16, z17, z16);
        } else {
            a(layoutParams, z17);
        }
    }

    public IInnerWebView a() {
        e eVar = this.f38658s;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.e.f
    public void a(int i3) {
        if (this.f38649i.f38706d != null) {
            this.f38654n = this.f38649i.f38706d.c() ? 1 : 2;
        }
        if (this.f38649i.f38706d != null) {
            this.f38649i.f38706d.b();
        }
    }

    public void a(final int i3, final boolean z16, boolean z17) {
        com.qq.e.comm.plugin.base.ad.b.b.a.b bVar;
        if (this.f38658s == null || (bVar = this.f38659t) == null) {
            return;
        }
        final float alpha = bVar.getAlpha();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f38658s.getLayoutParams();
        final int i16 = layoutParams.topMargin;
        int i17 = this.f38655p;
        final double d16 = 0.2d * i17;
        final double d17 = i17 * 0.8d;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams;
                int i18 = i16;
                int i19 = i3;
                layoutParams2.topMargin = i18 + ((int) (i19 * floatValue));
                if (i19 < 0 && d.this.f38658s.getTop() <= d.f38640o) {
                    layoutParams.topMargin = d.f38640o;
                }
                if ((layoutParams.topMargin <= d.f38640o || layoutParams.topMargin >= d.this.f38655p) && d.this.f38658s.f38688b) {
                    d.this.a(layoutParams, z16);
                    return;
                }
                if (d.this.f38658s != null && d.this.f38659t != null) {
                    d.this.f38658s.setLayoutParams(layoutParams);
                    int i26 = i16;
                    if (i26 > d16 && i26 < d17) {
                        try {
                            if (d.this.f38659t.getVisibility() == 4) {
                                d.this.f38659t.setVisibility(0);
                            }
                            if (d.this.f38658s.f38687a == 0) {
                                d.this.f38659t.setAlpha(alpha - floatValue);
                            } else {
                                d.this.f38659t.setAlpha(alpha + floatValue);
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.f38658s == null) {
                    return;
                }
                if (d.this.f38658s.f38687a == 0) {
                    d.this.f38659t.setVisibility(8);
                    d.this.c(true);
                } else {
                    d.this.f38659t.setAlpha(1.0f);
                    d.this.c(false);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.c(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofFloat.setDuration(300L);
        this.f38658s.f38688b = true;
        ofFloat.start();
    }

    private void e(int i3) {
        try {
            this.R.putOpt(LinkReportConstant$BizKey.CLICK_REQ_TYPE, Integer.valueOf(com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(this.L) ? 1 : 2));
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        if (com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(this.L)) {
            com.qq.e.comm.plugin.base.ad.clickcomponent.c.c.a(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_START, (ClickInfo) null, this.R, this.f38646f, 3);
        }
        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_INITIALIZE_START, 0, z.a(this.C, this.R, this.f38646f));
        this.f38645e = ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).buildInnerWebView(this.f38641a, this.f38647g.v());
        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_INITIALIZE_SUCCESS, 0, z.a(this.C, this.R, this.f38646f));
        IInnerWebView iInnerWebView = this.f38645e;
        if (iInnerWebView != null) {
            iInnerWebView.setInnerWebViewListener(this);
        }
        if (iInnerWebView != null && iInnerWebView.getView() != null) {
            iInnerWebView.getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.d.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    d.this.f38660u = true;
                    return false;
                }
            });
        }
        int i16 = this.f38657r;
        if (i16 < 0) {
            i16 = -1;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i16);
        layoutParams.topMargin = i3;
        this.f38658s.a(this, iInnerWebView);
        this.f38644d.addView(this.f38658s, layoutParams);
        com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_WEBVIEW_INIT_FINISH, this.f38646f, this.I);
        if (!TextUtils.isEmpty(this.L)) {
            if (com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(this.L)) {
                if (this.E) {
                    this.L = ay.c(this.L, "_autodownload", "1");
                }
                com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_REPORT_CGI_REQUEST_START, this.f38646f, this.I);
            } else {
                StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_LOAD_URL_START, 0, z.a(this.C, this.R, this.f38646f));
                r.a(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_LOAD_URL_START, this.J, this.K, this.O, this.N);
            }
            if (iInnerWebView != null) {
                iInnerWebView.loadUrl(this.L);
            }
        }
        com.qq.e.comm.plugin.base.ad.b.b.a.c cVar = new com.qq.e.comm.plugin.base.ad.b.b.a.c(this.f38641a, iInnerWebView);
        this.Q = cVar;
        this.f38642b.addView(cVar.a(), new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ak.a(this.f38641a, 108), ak.a(this.f38641a, 108));
        layoutParams2.addRule(15);
        layoutParams2.addRule(14);
        this.f38642b.addView(this.Q.b(), layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.f38642b.addView(this.Q.c(), layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RelativeLayout.LayoutParams layoutParams, boolean z16) {
        g gVar;
        if (this.f38658s == null) {
            return;
        }
        g gVar2 = this.f38649i;
        if (gVar2 != null) {
            gVar2.g(3);
            g gVar3 = this.f38649i;
            gVar3.a(gVar3.u());
            if (z16) {
                this.f38649i.f(11);
            }
        }
        if (this.f38658s.f38687a == 0) {
            layoutParams.height = this.f38656q - this.f38655p;
            c(true);
        } else {
            layoutParams.height = this.f38656q - f38640o;
        }
        e eVar = this.f38658s;
        eVar.f38688b = false;
        eVar.setLayoutParams(layoutParams);
        com.qq.e.comm.plugin.base.ad.b.b.a.b bVar = this.f38659t;
        if (bVar != null) {
            bVar.setVisibility(4);
        }
        if (!z16 || (gVar = this.f38649i) == null || gVar.f38706d == null) {
            return;
        }
        this.f38649i.f38706d.a();
        com.qq.e.comm.plugin.base.media.video.b bVar2 = this.f38649i.f38705c;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
