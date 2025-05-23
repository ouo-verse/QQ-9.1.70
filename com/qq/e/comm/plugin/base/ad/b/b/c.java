package com.qq.e.comm.plugin.base.ad.b.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.base.ad.b.b.a;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.r;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes3.dex */
public class c implements ACTD {

    /* renamed from: a, reason: collision with root package name */
    private Activity f38444a;

    /* renamed from: b, reason: collision with root package name */
    private String f38445b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f38446c;

    /* renamed from: e, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.model.f f38448e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f38449f;

    /* renamed from: g, reason: collision with root package name */
    private View f38450g;

    /* renamed from: h, reason: collision with root package name */
    private List<com.qq.e.comm.plugin.base.ad.b.b.a> f38451h;

    /* renamed from: i, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.b.b.a f38452i;

    /* renamed from: j, reason: collision with root package name */
    private int f38453j;

    /* renamed from: m, reason: collision with root package name */
    private long f38456m;

    /* renamed from: d, reason: collision with root package name */
    private com.qq.e.comm.plugin.stat.b f38447d = new com.qq.e.comm.plugin.stat.b();

    /* renamed from: k, reason: collision with root package name */
    private long f38454k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f38455l = -1;

    /* renamed from: n, reason: collision with root package name */
    private boolean f38457n = false;

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f38458o = false;

    public c(Activity activity) {
        this.f38444a = activity;
        this.f38445b = activity.getIntent().getStringExtra("posId");
        GDTLogger.d("GDTInnerBrowserActivityDelegate posId =" + this.f38445b);
        this.f38446c = activity.getIntent().getBooleanExtra("fromFeedback", false);
        String stringExtra = activity.getIntent().getStringExtra("adInfo");
        JSONObject jSONObject = null;
        try {
            if (!TextUtils.isEmpty(stringExtra)) {
                jSONObject = new JSONObject(stringExtra);
            }
        } catch (Exception e16) {
            GDTLogger.e(" Parse adinfo failed:" + e16.getMessage());
        }
        if (!y.a(jSONObject)) {
            GDTLogger.e("GDTInnerBrowserActivityDelegateadInfo is null");
            activity.finish();
            return;
        }
        com.qq.e.comm.plugin.base.ad.model.f fVar = new com.qq.e.comm.plugin.base.ad.model.f();
        this.f38448e = fVar;
        fVar.e(jSONObject);
        this.f38447d.a(this.f38445b);
        this.f38447d.b(this.f38448e.f());
        this.f38447d.c(this.f38448e.p());
        this.f38447d.c(this.f38448e.y());
        this.f38447d.d(this.f38448e.K());
        this.f38447d.a("wv_progress", 1);
    }

    public void a() {
        this.f38457n = true;
    }

    public void b() {
        int i3 = this.f38453j + 1;
        this.f38453j = i3;
        com.qq.e.comm.plugin.base.ad.b.b.a a16 = e.a(this.f38451h, i3);
        this.f38452i = a16;
        if (a16 == null) {
            this.f38444a.finish();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i3, int i16, Intent intent) {
        com.qq.e.comm.plugin.base.ad.b.b.a aVar = this.f38452i;
        if (aVar != null) {
            aVar.a(i3, i16, intent);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        int i3 = 1;
        if (com.qq.e.comm.plugin.j.c.a("landingPageActivityBackground", 1, 1)) {
            this.f38444a.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        }
        this.f38449f = new FrameLayout(this.f38444a);
        if (com.qq.e.comm.plugin.j.c.a("SplashFitStatusBar", 1, 1)) {
            this.f38449f.setFitsSystemWindows(true);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = this.f38444a.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 2;
            this.f38444a.getWindow().setAttributes(attributes);
        }
        try {
            this.f38444a.setContentView(this.f38449f, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th5) {
            th5.printStackTrace();
            this.f38444a.finish();
        }
        String stringExtra = this.f38444a.getIntent().getStringExtra("adInfo");
        JSONObject jSONObject = null;
        if (stringExtra != null) {
            try {
                jSONObject = new JSONObject(stringExtra);
            } catch (Exception e16) {
                GDTLogger.e("GDTInnerBrowserActivityDelegate Parse adinfo failed:" + e16.getMessage());
            }
        }
        int intExtra = this.f38444a.getIntent().getIntExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, 0);
        if (jSONObject != null && intExtra == com.qq.e.comm.plugin.base.ad.b.REWARDVIDEOAD.b()) {
            int optInt = jSONObject.optInt("landingpage_ori");
            GDTLogger.d("GDTInnerBrowserActivityDelegate InnerBrowser landingpagePort ==" + optInt);
            if (optInt == 1) {
                try {
                    this.f38444a.setRequestedOrientation(1);
                } catch (Throwable th6) {
                    GDTLogger.e("GDTInnerBrowserActivityDelegateonAfterCreate", th6);
                }
            }
            if (optInt == 2) {
                this.f38444a.setRequestedOrientation(0);
            }
        }
        a.b bVar = new a.b();
        bVar.a(this.f38444a);
        bVar.a(this.f38448e);
        bVar.a(new a(this));
        bVar.a(true);
        if (this.f38446c) {
            i3 = 2;
        }
        List<com.qq.e.comm.plugin.base.ad.b.b.a> a16 = e.a(i3, bVar);
        this.f38451h = a16;
        if (a16 != null && a16.size() > 0) {
            this.f38453j = 0;
            com.qq.e.comm.plugin.base.ad.b.b.a a17 = e.a(this.f38451h, 0);
            this.f38452i = a17;
            if (a17 == null) {
                this.f38444a.finish();
                return;
            }
            return;
        }
        this.f38444a.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        com.qq.e.comm.plugin.base.ad.b.b.a aVar = this.f38452i;
        if (aVar != null) {
            aVar.f();
        }
        if (SDKStatus.getSDKVersionCode() >= 9) {
            this.f38444a.finish();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.f38444a.requestWindowFeature(1);
        long longExtra = this.f38444a.getIntent().getLongExtra("clickStartTime", System.currentTimeMillis());
        this.f38454k = longExtra;
        StatTracer.trackEvent(4003001, 0, z.a(this.f38447d, null, longExtra));
        r.a(4003001, this.f38448e.f(), this.f38448e.y(), y.e(this.f38448e.v(), "mqq_landing_page"), this.f38448e.P());
        this.f38454k = System.currentTimeMillis();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        com.qq.e.comm.plugin.base.ad.b.b.a aVar = this.f38452i;
        if (aVar == null) {
            StatTracer.instantReport(this.f38445b);
            return;
        }
        aVar.k();
        if (this.f38452i.h() == 2) {
            return;
        }
        if (!this.f38458o) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_BEFORE_LOAD_SUCCESS, 0, z.a(this.f38452i.f38391g, null, this.f38454k));
            r.a(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_BEFORE_LOAD_SUCCESS, this.f38448e.f(), this.f38448e.y(), y.e(this.f38448e.v(), "mqq_landing_page"), this.f38448e.P());
        } else if (!this.f38457n) {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_WITHOUT_ACTION, 0, z.a(this.f38452i.f38391g, null, this.f38454k + this.f38456m));
            r.a(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_WITHOUT_ACTION, this.f38448e.f(), this.f38448e.y(), y.e(this.f38448e.v(), "mqq_landing_page"), this.f38448e.P());
        } else {
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_AFTER_LOAD_SUCCESS, 0, z.a(this.f38452i.f38391g, null, this.f38454k + this.f38456m));
            r.a(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_AFTER_LOAD_SUCCESS, this.f38448e.f(), this.f38448e.y(), y.e(this.f38448e.v(), "mqq_landing_page"), this.f38448e.P());
        }
        this.f38452i = null;
        StatTracer.instantReport(this.f38445b);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        this.f38455l = System.currentTimeMillis();
        com.qq.e.comm.plugin.base.ad.b.b.a aVar = this.f38452i;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        GDTLogger.d("GDTInnerBrowserActivityDelegate onResume");
        if (this.f38455l != -1) {
            this.f38456m += System.currentTimeMillis() - this.f38455l;
        }
        com.qq.e.comm.plugin.base.ad.b.b.a aVar = this.f38452i;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void a(View view) {
        if (this.f38452i == null) {
            return;
        }
        View view2 = this.f38450g;
        if (view2 != null) {
            this.f38449f.removeView(view2);
        }
        this.f38450g = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view3 = this.f38450g;
        if (view3 != null) {
            if (view3.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f38450g.getParent()).removeView(this.f38450g);
            }
            this.f38449f.addView(this.f38450g, layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class a implements a.InterfaceC0278a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<c> f38459a;

        public a(c cVar) {
            if (cVar == null) {
                return;
            }
            this.f38459a = new WeakReference<>(cVar);
        }

        @Override // com.qq.e.comm.plugin.base.ad.b.b.a.InterfaceC0278a
        public void a() {
            WeakReference<c> weakReference = this.f38459a;
            c cVar = weakReference != null ? weakReference.get() : null;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // com.qq.e.comm.plugin.base.ad.b.b.a.InterfaceC0278a
        public void b() {
            c cVar;
            WeakReference<c> weakReference = this.f38459a;
            if (weakReference != null) {
                cVar = weakReference.get();
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // com.qq.e.comm.plugin.base.ad.b.b.a.InterfaceC0278a
        public void a(View view) {
            WeakReference<c> weakReference = this.f38459a;
            c cVar = weakReference != null ? weakReference.get() : null;
            if (cVar != null) {
                cVar.a(view);
            }
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }
}
