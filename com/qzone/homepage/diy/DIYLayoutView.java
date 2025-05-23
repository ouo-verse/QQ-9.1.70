package com.qzone.homepage.diy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b7.a;
import b7.b;
import b7.c;
import b7.d;
import b7.f;
import com.qzone.common.account.LoginData;
import com.qzone.homepage.diy.protocol.QzoneDIYData;
import com.qzone.homepage.diy.util.QzoneDIYService;
import com.qzone.util.ao;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.MonitorManager;
import e15.f;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DIYLayoutView implements z6.a {

    /* renamed from: a, reason: collision with root package name */
    private f f47487a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f47488b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f47489c;

    /* renamed from: d, reason: collision with root package name */
    private ViewGroup f47490d;

    /* renamed from: e, reason: collision with root package name */
    private QzoneDIYData f47491e;

    /* renamed from: f, reason: collision with root package name */
    private Context f47492f;

    /* renamed from: g, reason: collision with root package name */
    private d f47493g;

    /* renamed from: h, reason: collision with root package name */
    private a.C0103a f47494h;

    /* renamed from: i, reason: collision with root package name */
    private f.b f47495i;

    /* renamed from: j, reason: collision with root package name */
    private d.b f47496j;

    /* renamed from: k, reason: collision with root package name */
    private b.a f47497k;

    /* renamed from: l, reason: collision with root package name */
    private c.b f47498l;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f47499m;

    /* renamed from: p, reason: collision with root package name */
    private Timer f47502p;

    /* renamed from: q, reason: collision with root package name */
    private TimerTask f47503q;

    /* renamed from: n, reason: collision with root package name */
    private volatile int f47500n = 0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f47501o = true;

    /* renamed from: r, reason: collision with root package name */
    private boolean f47504r = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        private float f47506d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        private float f47507e = 0.0f;

        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f47506d = motionEvent.getX();
                this.f47507e = motionEvent.getY();
            } else if (action != 1) {
                if (action == 2 && ((this.f47506d != x16 || this.f47507e != y16) && y16 < this.f47507e - ViewConfiguration.getTouchSlop() && DIYLayoutView.this.f47504r)) {
                    DIYLayoutView.this.u();
                }
            } else if (Math.abs(this.f47506d - x16) <= ViewConfiguration.getTouchSlop() && Math.abs(this.f47507e - y16) <= ViewConfiguration.getTouchSlop()) {
                String K = QzoneDIYService.L().K();
                QZLog.i("QzoneDIYLayoutView", 4, "on DIY page click url = " + K);
                if (!TextUtils.isEmpty(K)) {
                    yo.d.d(K, DIYLayoutView.this.f47492f, null);
                    com.qzone.homepage.diy.util.a.d(DIYLayoutView.this.f47491e.uin == LoginData.getInstance().getUin() ? 3 : 4);
                }
                DIYLayoutView.this.f47490d.playSoundEffect(0);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DIYLayoutView.this.u();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (DIYLayoutView.this.f47493g != null) {
                DIYLayoutView.this.f47493g.u9();
            }
            DIYLayoutView.this.f47490d.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (DIYLayoutView.this.f47496j != null) {
                DIYLayoutView.this.f47496j.D();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface d {
        void u9();
    }

    public DIYLayoutView(Context context, QzoneDIYData qzoneDIYData, ViewGroup viewGroup) {
        this.f47492f = context;
        this.f47491e = qzoneDIYData;
        this.f47499m = viewGroup;
        p();
        q();
    }

    private void l() {
        ImageView imageView = new ImageView(this.f47492f);
        imageView.setImageResource(R.drawable.g0c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ar.e(17.0f), ar.e(28.0f));
        layoutParams.addRule(14);
        layoutParams.topMargin = ar.k() - ar.e(56.0f);
        imageView.setLayoutParams(layoutParams);
        this.f47490d.addView(imageView);
        imageView.setOnClickListener(new b());
    }

    private void p() {
        e15.f g16 = d15.a.b(this.f47492f).g(this.f47491e.layout, new a7.c());
        this.f47487a = g16;
        if (g16 == null) {
            MonitorManager.f().h(24, 4, "parse DIY json layout fail json = " + this.f47491e.layout, false);
            QZLog.e("QzoneDIYLayoutView", 1, " diy json inflate error");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) g16.i();
        this.f47488b = viewGroup;
        if (viewGroup.getChildCount() != 2) {
            QZLog.e("QzoneDIYLayoutView", 1, " diy json getChildCount != 2");
            MonitorManager.f().h(24, 4, "parse DIY json layout ChildCount != 2 , json = " + this.f47491e.layout, false);
            return;
        }
        this.f47489c = (ViewGroup) this.f47488b.getChildAt(0);
        this.f47490d = (ViewGroup) this.f47488b.getChildAt(1);
        this.f47489c.setBackgroundResource(R.color.f158017al3);
        this.f47490d.setClickable(true);
        this.f47490d.setFocusable(true);
        l();
        w();
    }

    private void q() {
        e15.f fVar = this.f47487a;
        if (fVar == null) {
            return;
        }
        a.C0103a c0103a = (a.C0103a) fVar.j("qzone_avatar_view");
        this.f47494h = c0103a;
        if (c0103a != null) {
            c0103a.I(this);
        }
        this.f47495i = (f.b) this.f47487a.j("vip_widget_view");
        this.f47496j = (d.b) this.f47487a.j("player_view");
        this.f47497k = (b.a) this.f47487a.j("intimacy_view");
        this.f47498l = (c.b) this.f47487a.j("navigation_view");
        com.qzone.homepage.diy.util.a.d(this.f47491e.uin == LoginData.getInstance().getUin() ? 1 : 2);
    }

    private void w() {
        this.f47490d.setOnTouchListener(new a());
    }

    private void x() {
        y();
        this.f47502p = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.qzone.homepage.diy.DIYLayoutView.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (DIYLayoutView.this.m()) {
                    return;
                }
                if (QZLog.isColorLevel()) {
                    QZLog.i("QzoneDIYLayoutView", 2, "run mCurrentCountTime: " + DIYLayoutView.this.f47500n);
                }
                DIYLayoutView.this.f47500n++;
                if (DIYLayoutView.this.f47500n > 5) {
                    QZLog.i("QzoneDIYLayoutView", "start scroll next");
                    ((Activity) DIYLayoutView.this.f47492f).runOnUiThread(new Runnable() { // from class: com.qzone.homepage.diy.DIYLayoutView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DIYLayoutView.this.f47501o = false;
                            DIYLayoutView.this.u();
                        }
                    });
                }
            }
        };
        this.f47503q = timerTask;
        this.f47502p.schedule(timerTask, 0L, 1000L);
    }

    private void y() {
        TimerTask timerTask = this.f47503q;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.f47502p;
        if (timer != null) {
            timer.cancel();
        }
        this.f47502p = null;
        this.f47503q = null;
        this.f47500n = 0;
    }

    @Override // z6.a
    public void a() {
        t();
    }

    @Override // z6.a
    public void b() {
        s();
    }

    public boolean m() {
        return this.f47487a == null || this.f47488b == null || this.f47489c == null || this.f47490d == null;
    }

    public ViewGroup n() {
        return this.f47488b;
    }

    public c.a o() {
        c.b bVar = this.f47498l;
        if (bVar != null) {
            return bVar.B();
        }
        return null;
    }

    public void r() {
        e15.f fVar = this.f47487a;
        if (fVar != null) {
            fVar.l();
        }
    }

    public void s() {
        y();
        e15.f fVar = this.f47487a;
        if (fVar == null || !this.f47504r) {
            return;
        }
        fVar.n();
    }

    public void t() {
        if (this.f47501o) {
            x();
        }
        e15.f fVar = this.f47487a;
        if (fVar == null || !this.f47504r) {
            return;
        }
        fVar.o();
    }

    public void u() {
        if (this.f47504r && ao.b(500)) {
            y();
            this.f47487a.n();
            this.f47504r = false;
            this.f47501o = false;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47490d, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat.setDuration(500L);
            ofFloat.addListener(new c());
            ofFloat.start();
        }
    }

    public void v(d dVar) {
        this.f47493g = dVar;
    }

    public void z(long j3, x6.a aVar, com.qzone.reborn.feedx.widget.header.c cVar) {
        if (m()) {
            return;
        }
        a.C0103a c0103a = this.f47494h;
        if (c0103a != null) {
            c0103a.G(cVar);
            this.f47494h.z(j3, aVar);
        }
        f.b bVar = this.f47495i;
        if (bVar != null) {
            bVar.z(j3, aVar);
        }
        d.b bVar2 = this.f47496j;
        if (bVar2 != null) {
            bVar2.z(j3, aVar);
            this.f47496j.B(this.f47499m);
        }
        b.a aVar2 = this.f47497k;
        if (aVar2 != null) {
            aVar2.z(j3, aVar);
        }
    }
}
