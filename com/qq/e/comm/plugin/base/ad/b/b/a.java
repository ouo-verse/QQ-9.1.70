package com.qq.e.comm.plugin.base.ad.b.b;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.y;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected Activity f38385a;

    /* renamed from: b, reason: collision with root package name */
    protected InterfaceC0278a f38386b;

    /* renamed from: c, reason: collision with root package name */
    protected ViewGroup f38387c;

    /* renamed from: d, reason: collision with root package name */
    protected com.qq.e.comm.plugin.base.ad.b.b.a.b f38388d;

    /* renamed from: e, reason: collision with root package name */
    protected com.qq.e.comm.plugin.base.ad.b.b.a.c f38389e;

    /* renamed from: f, reason: collision with root package name */
    protected com.qq.e.comm.plugin.base.ad.model.f f38390f;

    /* renamed from: h, reason: collision with root package name */
    protected String f38392h;

    /* renamed from: i, reason: collision with root package name */
    protected String f38393i;

    /* renamed from: j, reason: collision with root package name */
    protected String f38394j;

    /* renamed from: k, reason: collision with root package name */
    protected String f38395k;

    /* renamed from: l, reason: collision with root package name */
    protected String f38396l;

    /* renamed from: m, reason: collision with root package name */
    protected long f38397m;

    /* renamed from: n, reason: collision with root package name */
    protected long f38398n;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f38400p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f38401q;

    /* renamed from: r, reason: collision with root package name */
    protected int f38402r;

    /* renamed from: s, reason: collision with root package name */
    protected String f38403s;

    /* renamed from: t, reason: collision with root package name */
    protected int f38404t;

    /* renamed from: g, reason: collision with root package name */
    protected com.qq.e.comm.plugin.stat.b f38391g = new com.qq.e.comm.plugin.stat.b();

    /* renamed from: o, reason: collision with root package name */
    protected boolean f38399o = false;

    /* renamed from: u, reason: collision with root package name */
    protected volatile boolean f38405u = false;

    /* renamed from: v, reason: collision with root package name */
    protected volatile boolean f38406v = false;

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.base.ad.b.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0278a {
        void a();

        void a(View view);

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Activity f38422a;

        /* renamed from: b, reason: collision with root package name */
        private InterfaceC0278a f38423b;

        /* renamed from: c, reason: collision with root package name */
        private com.qq.e.comm.plugin.base.ad.model.f f38424c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f38425d;

        public void a(Activity activity) {
            this.f38422a = activity;
        }

        public com.qq.e.comm.plugin.base.ad.model.f b() {
            return this.f38424c;
        }

        public InterfaceC0278a c() {
            return this.f38423b;
        }

        public boolean d() {
            return this.f38425d;
        }

        public Activity a() {
            return this.f38422a;
        }

        public void a(com.qq.e.comm.plugin.base.ad.model.f fVar) {
            this.f38424c = fVar;
        }

        public void a(InterfaceC0278a interfaceC0278a) {
            this.f38423b = interfaceC0278a;
        }

        public void a(boolean z16) {
            this.f38425d = z16;
        }
    }

    public a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f38385a = bVar.a();
        this.f38386b = bVar.c();
        this.f38390f = bVar.b();
        this.f38400p = bVar.d();
        this.f38397m = System.currentTimeMillis();
        this.f38398n = SystemClock.elapsedRealtime();
    }

    public abstract void a(int i3, int i16, Intent intent);

    public boolean a() {
        com.qq.e.comm.plugin.base.ad.model.f fVar;
        Activity activity = this.f38385a;
        if (activity != null && activity.getIntent() != null && this.f38386b != null && (fVar = this.f38390f) != null && y.a(fVar.v())) {
            return true;
        }
        return false;
    }

    public void b() {
        int i3;
        this.f38387c = new FrameLayout(this.f38385a);
        int i16 = 1;
        this.f38402r = (int) TypedValue.applyDimension(1, 45.0f, this.f38385a.getResources().getDisplayMetrics());
        this.f38392h = this.f38385a.getIntent().getStringExtra("url");
        this.f38394j = this.f38385a.getIntent().getStringExtra("posId");
        this.f38393i = this.f38385a.getIntent().getStringExtra("clickurl");
        this.f38399o = this.f38385a.getIntent().getBooleanExtra("fromFeedback", false);
        boolean booleanExtra = this.f38385a.getIntent().getBooleanExtra("useVelen", false);
        this.f38401q = this.f38385a.getIntent().getBooleanExtra("shouldReportClick", true);
        this.f38396l = this.f38390f.G();
        this.f38395k = this.f38390f.y();
        this.f38391g.a("pid", this.f38394j);
        this.f38391g.a("aid", this.f38390f.f());
        this.f38391g.a("traceid", this.f38390f.y());
        this.f38391g.a("wv_progress", 1);
        this.f38391g.a("lp_type", h());
        this.f38403s = y.e(this.f38390f.v(), "mqq_landing_page");
        this.f38404t = this.f38390f.P();
        if (h() == 3) {
            this.f38391g.a(LinkReportConstant$BizKey.CLICK_REQ_TYPE, 2);
        } else if (h() == 1) {
            com.qq.e.comm.plugin.stat.b bVar = this.f38391g;
            if (com.qq.e.comm.plugin.base.ad.clickcomponent.d.c.a(this.f38392h)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            bVar.a(LinkReportConstant$BizKey.CLICK_REQ_TYPE, i3);
        } else if (h() == 2) {
            this.f38391g.a(LinkReportConstant$BizKey.CLICK_REQ_TYPE, 3);
        }
        com.qq.e.comm.plugin.stat.b bVar2 = this.f38391g;
        if (!booleanExtra) {
            i16 = 2;
        }
        bVar2.a("is_offline", i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.f38388d = new com.qq.e.comm.plugin.base.ad.b.b.a.b(this.f38385a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f38402r);
        layoutParams.gravity = 48;
        this.f38388d.setLayoutParams(layoutParams);
        this.f38388d.setBackgroundColor(-1);
        this.f38388d.a(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (!a.this.f()) {
                    a.this.f38385a.finish();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f38388d.b(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                a.this.g();
                a.this.f38385a.setResult(1);
                a.this.f38385a.finish();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f38388d.c(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.b.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                com.qq.e.comm.plugin.base.ad.b.b.a.c cVar = a.this.f38389e;
                if (cVar != null) {
                    if (cVar.c() != null) {
                        a.this.f38389e.c().setVisibility(0);
                    }
                    if (a.this.f38389e.a() != null) {
                        a.this.f38389e.a().setVisibility(0);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f38388d.b();
        if (!this.f38399o && h() != 3) {
            this.f38388d.c();
        } else {
            this.f38388d.a();
        }
        this.f38387c.addView(this.f38388d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        com.qq.e.comm.plugin.base.ad.b.b.a.c cVar = new com.qq.e.comm.plugin.base.ad.b.b.a.c(this.f38385a, this);
        this.f38389e = cVar;
        this.f38387c.addView(cVar.a(), new ViewGroup.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(this.f38385a, 108), ak.a(this.f38385a, 108));
        layoutParams.gravity = 17;
        this.f38387c.addView(this.f38389e.b(), layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.f38387c.addView(this.f38389e.c(), layoutParams2);
    }

    public abstract void e();

    public abstract boolean f();

    public abstract void g();

    public abstract int h();

    public abstract void i();

    public abstract void j();

    public abstract void k();
}
