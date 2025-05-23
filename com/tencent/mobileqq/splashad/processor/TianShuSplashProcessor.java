package com.tencent.mobileqq.splashad.processor;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.basics.adshake.OnShakeListener;
import com.tencent.gdtad.basics.twist.TwistView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splash.c;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.splashad.SplashWidget;
import com.tencent.mobileqq.splashad.n;
import com.tencent.mobileqq.splashad.o;
import com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor;
import com.tencent.mobileqq.splashad.slopeslide.SlopeSlideView;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.vip.VasC2SReporter;
import cooperation.vip.ad.w;
import cooperation.vip.tianshu.TianShuManager;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import o43.b;

/* loaded from: classes18.dex */
public class TianShuSplashProcessor implements com.tencent.mobileqq.splashad.processor.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f288791a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f288792b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o43.a f288812d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c.a f288813e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ o43.b f288814f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ SplashADView f288815h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Activity f288816i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f288817m;

        a(o43.a aVar, c.a aVar2, o43.b bVar, SplashADView splashADView, Activity activity, String str) {
            this.f288812d = aVar;
            this.f288813e = aVar2;
            this.f288814f = bVar;
            this.f288815h = splashADView;
            this.f288816i = activity;
            this.f288817m = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, aVar, aVar2, bVar, splashADView, activity, str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            String str;
            String str2;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 == R.id.dzp) {
                    o43.a aVar = this.f288812d;
                    if (aVar != null) {
                        if (aVar.e()) {
                            SetSplash.i(true);
                        }
                        if (this.f288812d.f()) {
                            o43.a aVar2 = this.f288812d;
                            w.r(aVar2.f421925b, 122, aVar2.f421950o);
                        } else {
                            o43.a aVar3 = this.f288812d;
                            w.o(aVar3.f421925b, 122, aVar3.f421950o);
                        }
                    }
                    this.f288813e.a(0L);
                } else if (id5 == R.id.f75503z5 || id5 == R.id.f87394u9 || id5 == R.id.f87354u5) {
                    o43.a aVar4 = this.f288812d;
                    if (aVar4 != null && aVar4.e()) {
                        TianShuSplashProcessor.this.j(this.f288813e);
                    } else {
                        o43.b bVar = this.f288814f;
                        if (bVar == null || ((i3 = bVar.f422011j) != 2 && i3 != 3)) {
                            TianShuSplashProcessor.this.l(this.f288815h, this.f288812d, this.f288813e, this.f288817m, 102, 0);
                        } else {
                            com.tencent.mobileqq.vassplash.common.c.f312375c = false;
                            SplashADView splashADView = this.f288815h;
                            if (splashADView.V && splashADView.W) {
                                TianShuSplashProcessor.r(bVar.f422003b, splashADView);
                            }
                            if (!TextUtils.isEmpty(this.f288814f.f422006e)) {
                                o43.a aVar5 = this.f288812d;
                                if (aVar5 == null) {
                                    str = "";
                                } else {
                                    str = aVar5.f421950o;
                                }
                                if (aVar5 == null) {
                                    str2 = "";
                                } else {
                                    str2 = aVar5.f421925b;
                                }
                                TianShuManager.setLastClickAdTraceInfo(str2, str);
                            }
                            o43.a aVar6 = this.f288812d;
                            if (aVar6 != null) {
                                if (aVar6.f()) {
                                    o43.a aVar7 = this.f288812d;
                                    w.r(aVar7.f421925b, 102, aVar7.f421950o);
                                } else {
                                    o43.a aVar8 = this.f288812d;
                                    w.o(aVar8.f421925b, 102, aVar8.f421950o);
                                }
                            }
                            c15.a.b(this.f288816i, this.f288814f.f422012k);
                            o43.a aVar9 = this.f288812d;
                            if (aVar9 != null && aVar9.f() && !this.f288812d.a()) {
                                com.tencent.mobileqq.vassplash.common.c.c(this.f288817m + "");
                            }
                            this.f288815h.G();
                            QLog.i("TianShuSplashProcessor", 1, "cover_layer =2000");
                            com.tencent.mobileqq.vassplash.common.c.v(this.f288812d);
                            com.tencent.mobileqq.vassplash.common.c.u(this.f288812d);
                            this.f288813e.a((long) 2000);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b implements SplashADView.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.a f288818a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o43.a f288819b;

        b(c.a aVar, o43.a aVar2) {
            this.f288818a = aVar;
            this.f288819b = aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, aVar, aVar2);
            }
        }

        @Override // com.tencent.mobileqq.splashad.SplashADView.g
        public void onPlayError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("TianShuSplashProcessor", 1, "splash_logoerro+ errotype");
            this.f288818a.a(0L);
            o43.a aVar = this.f288819b;
            w.q(aVar.f421925b, 157, aVar.f421950o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c implements SplashADView.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.a f288821a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o43.a f288822b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ o43.a f288823c;

        c(c.a aVar, o43.a aVar2, o43.a aVar3) {
            this.f288821a = aVar;
            this.f288822b = aVar2;
            this.f288823c = aVar3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, aVar, aVar2, aVar3);
            }
        }

        @Override // com.tencent.mobileqq.splashad.SplashADView.f
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("TianShuSplashProcessor", 1, "video finish");
            this.f288821a.a(0L);
            o43.a aVar = this.f288822b;
            if (aVar != null && aVar.f()) {
                TianShuManager.getInstance().clearAdShowStatus(510);
            } else {
                TianShuManager.getInstance().clearAdShowStatus(716);
            }
            o43.a aVar2 = this.f288823c;
            w.q(aVar2.f421925b, 159, aVar2.f421950o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class d implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SplashADView f288825d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o43.a f288826e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c.a f288827f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f288828h;

        /* loaded from: classes18.dex */
        class a implements OnShakeListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // com.tencent.gdtad.basics.adshake.OnShakeListener
            public void onShakeComplete(double d16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
                    return;
                }
                d.this.f288825d.G();
                d dVar = d.this;
                TianShuSplashProcessor.this.l(dVar.f288825d, dVar.f288826e, dVar.f288827f, dVar.f288828h, 138, 0L);
            }

            @Override // com.tencent.gdtad.basics.adshake.OnShakeListener
            public void onShaking(double d16, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), Integer.valueOf(i3));
                }
            }
        }

        d(SplashADView splashADView, o43.a aVar, c.a aVar2, String str) {
            this.f288825d = splashADView;
            this.f288826e = aVar;
            this.f288827f = aVar2;
            this.f288828h = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, splashADView, aVar, aVar2, str);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                this.f288825d.setOnShakeListener(new a());
                this.f288825d.T();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                this.f288825d.setOnShakeListener(null);
                QLog.i("TianShuSplashProcessor", 1, "splash view disappear");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class e implements n {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o43.b f288831a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SplashADView f288832b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ o43.a f288833c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.a f288834d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f288835e;

        e(o43.b bVar, SplashADView splashADView, o43.a aVar, c.a aVar2, String str) {
            this.f288831a = bVar;
            this.f288832b = splashADView;
            this.f288833c = aVar;
            this.f288834d = aVar2;
            this.f288835e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, bVar, splashADView, aVar, aVar2, str);
            }
        }

        @Override // com.tencent.mobileqq.splashad.n
        public void a(float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            QLog.i("TianShuSplashProcessor", 1, "onTrack startY " + f17 + " endY " + f19);
            int screenHeight = ViewUtils.getScreenHeight();
            if (f17 - f19 > ViewUtils.dpToPx(this.f288831a.f422021t) && screenHeight - ViewUtils.dpToPx(this.f288831a.f422020s) < f17) {
                TianShuSplashProcessor.this.l(this.f288832b, this.f288833c, this.f288834d, this.f288835e, 118, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class f implements SlopeSlideView.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SplashADView f288837a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o43.b f288838b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ o43.a f288839c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.a f288840d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f288841e;

        f(SplashADView splashADView, o43.b bVar, o43.a aVar, c.a aVar2, String str) {
            this.f288837a = splashADView;
            this.f288838b = bVar;
            this.f288839c = aVar;
            this.f288840d = aVar2;
            this.f288841e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, splashADView, bVar, aVar, aVar2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(SplashADView splashADView, o43.a aVar, c.a aVar2, String str) {
            TianShuSplashProcessor.this.l(splashADView, aVar, aVar2, str, 118, 500L);
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.SlopeSlideView.c
        public void onAnimatorFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.SlopeSlideView.c
        public void onAnimatorStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.SlopeSlideView.c
        public void onInteractFinish(int i3, boolean z16, Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), point);
            }
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.SlopeSlideView.c
        public void onInteractResult(int i3, boolean z16, int i16, Point point, float f16) {
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), point, Float.valueOf(f16));
                return;
            }
            QLog.d("TianShuSplashProcessor", 1, "onInteractResult type:" + i3 + " result:" + z16 + ", reason: " + i16 + ", point: " + point + ", angle: " + f16);
            if (z16) {
                Vibrator vibrator = (Vibrator) this.f288837a.getContext().getApplicationContext().getSystemService("vibrator");
                if (vibrator != null) {
                    vibrator.vibrate(500L);
                }
                if (this.f288838b.B == 9) {
                    if (i3 == 3) {
                        i17 = 118;
                    } else {
                        i17 = 138;
                    }
                    TianShuSplashProcessor.this.l(this.f288837a, this.f288839c, this.f288840d, this.f288841e, i17, 0L);
                    return;
                }
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final SplashADView splashADView = this.f288837a;
                final o43.a aVar = this.f288839c;
                final c.a aVar2 = this.f288840d;
                final String str = this.f288841e;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.splashad.processor.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        TianShuSplashProcessor.f.this.b(splashADView, aVar, aVar2, str);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.SlopeSlideView.c
        public void onInteractStart(int i3, Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) point);
            }
        }

        @Override // com.tencent.mobileqq.splashad.slopeslide.SlopeSlideView.c
        public void onSensorError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class g extends com.tencent.mobileqq.splash.c {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        WeakReference<SplashADView> f288843c;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<ImageView> f288844d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<ImageView> f288845e;

        /* renamed from: f, reason: collision with root package name */
        WeakReference<AppActivity> f288846f;

        /* renamed from: g, reason: collision with root package name */
        boolean f288847g;

        /* renamed from: h, reason: collision with root package name */
        private o f288848h;

        protected g(Object obj, SplashADView splashADView, ImageView imageView, ImageView imageView2, AppActivity appActivity, boolean z16) {
            super(obj);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, obj, splashADView, imageView, imageView2, appActivity, Boolean.valueOf(z16));
                return;
            }
            this.f288848h = null;
            this.f288843c = new WeakReference<>(splashADView);
            this.f288844d = new WeakReference<>(imageView);
            this.f288845e = new WeakReference<>(imageView2);
            this.f288846f = new WeakReference<>(appActivity);
            this.f288847g = z16;
        }

        private void d(AppActivity appActivity) {
            QLog.d("TianShuSplashProcessor", 1, "initSplashAnim UnionBannerSplash animation");
            if (e()) {
                try {
                    View findViewById = appActivity.findViewById(R.id.j0l);
                    if (findViewById != null && (findViewById.getParent() instanceof ViewGroup)) {
                        ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(findViewById);
                        }
                        ((ViewGroup) appActivity.getWindow().getDecorView()).addView(findViewById);
                        SetSplash.q(findViewById);
                        ei.a(null, "splashCost");
                    }
                    QLog.d("TianShuSplashProcessor", 1, "show UnionBannerSplash animation");
                } catch (Exception e16) {
                    QLog.e("TianShuSplashProcessor", 1, "show Splash anim  error ", e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.splash.c
        public void a(c.a aVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            if (this.f288711b == null) {
                return;
            }
            SplashADView splashADView = this.f288843c.get();
            ImageView imageView = this.f288844d.get();
            ImageView imageView2 = this.f288845e.get();
            AppActivity appActivity = this.f288846f.get();
            if (splashADView != null && appActivity != null) {
                o43.a aVar2 = (o43.a) this.f288711b;
                try {
                    if (appActivity.getResources().getConfiguration().orientation == 2) {
                        QLog.i("TianShuSplashProcessor", 1, "SCREEN_ORIENTATION_PORTRAIT " + appActivity.getRequestedOrientation());
                        aVar.onDurationUpdate(0L);
                        w.q(aVar2.f421925b, 155, aVar2.f421950o);
                        return;
                    }
                    QLog.i("TianShuSplashProcessor", 1, "bindView");
                    SplashADUtil.f288715b = System.currentTimeMillis();
                    if (!splashADView.V) {
                        aVar.onDurationUpdate(0L);
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) appActivity.findViewById(R.id.j0l);
                    if (viewGroup == null) {
                        QLog.i("TianShuSplashProcessor", 1, "bindView fail, root is null");
                        aVar.onDurationUpdate(0L);
                        return;
                    }
                    if (GuardManager.sInstance != null) {
                        o oVar = new o("tianshu", aVar2.f421925b, this.f288847g);
                        this.f288848h = oVar;
                        GuardManager.sInstance.registerCallBack(oVar);
                    }
                    appActivity.setRequestedOrientation(1);
                    viewGroup.addView(splashADView, 0);
                    int i3 = aVar2.f421931e;
                    if (i3 != 0) {
                        long j3 = 10000;
                        if (i3 != 2) {
                            if (i3 == 3) {
                                QLog.i("TianShuSplashProcessor", 1, "show pag");
                                splashADView.L();
                                splashADView.o();
                                aVar.onDurationUpdate(10000L);
                            }
                        } else {
                            QLog.i("TianShuSplashProcessor", 1, "show video");
                            splashADView.M();
                            splashADView.o();
                            if (splashADView.z()) {
                                j3 = PeakConstants.SHORT_VIDEO_DURATION_UPPER_BOUND;
                            }
                            aVar.onDurationUpdate(j3);
                        }
                    } else {
                        if (imageView != null && imageView2 != null) {
                            imageView.setVisibility(8);
                            imageView2.setVisibility(8);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("TianShuSplashProcessor", 2, "show pic splash duration:" + aVar2.U);
                        }
                        long j16 = aVar2.U;
                        if (j16 > 0) {
                            aVar.onDurationUpdate(j16);
                        } else {
                            aVar.onDurationUpdate(3000L);
                        }
                    }
                    splashADView.I();
                    long i16 = SplashADUtil.i(BaseApplicationImpl.getApplication());
                    ImmersiveUtils.clearCoverForStatus(appActivity.getWindow(), true);
                    for (int i17 = 0; i17 < aVar2.T.size(); i17++) {
                        if (!TextUtils.isEmpty(aVar2.T.get(i17))) {
                            if (i17 == 0) {
                                str = aVar2.f421925b;
                            } else {
                                str = aVar2.f421925b + i17;
                            }
                            VasC2SReporter.f().a(str, aVar2.T.get(i17));
                        }
                    }
                    if (aVar2.f()) {
                        QLog.d("TianShuSplashProcessor", 1, "show UnionBannerSplash ");
                        d(appActivity);
                        com.tencent.mobileqq.vassplash.common.c.r(aVar2.f421925b, i16 + "");
                        w.r(aVar2.f421925b, 101, aVar2.f421950o);
                    } else {
                        w.o(aVar2.f421925b, 101, aVar2.f421950o);
                    }
                    ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("tianshu", "splash", "expo", aVar2.f421925b, i16 + "");
                    if (this.f288847g) {
                        w.o(aVar2.f421925b, 143, aVar2.f421950o);
                    }
                    if (aVar2.e()) {
                        SetSplash.k(true);
                    }
                    com.tencent.mobileqq.vassplash.common.c.s(aVar2.f421925b, i16, false);
                    cooperation.vip.ad.license.g.g().d(aVar2.f421925b, 101);
                    com.tencent.mobileqq.splashad.l.f288780d.g(1);
                } catch (Exception e16) {
                    QLog.e("TianShuSplashProcessor", 1, "show SplashAd bindView error ", e16);
                    w.q(aVar2.f421925b, 158, aVar2.f421950o);
                }
            }
        }

        @Override // com.tencent.mobileqq.splash.c
        public void b() {
            GuardManager guardManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            try {
                o43.a aVar = (o43.a) this.f288711b;
                this.f288710a = true;
                SplashADView splashADView = this.f288843c.get();
                if (splashADView == null) {
                    return;
                }
                splashADView.W = false;
                TianShuSplashProcessor.r(aVar.f421931e, splashADView);
                splashADView.G();
                o oVar = this.f288848h;
                if (oVar != null && (guardManager = GuardManager.sInstance) != null) {
                    guardManager.unregisterCallback(oVar);
                    this.f288848h = null;
                }
            } catch (Exception e16) {
                QLog.e("TianShuSplashProcessor", 1, "show SplashAd end() error ", e16);
            }
        }

        @Override // com.tencent.mobileqq.splash.c
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            boolean z16 = BaseApplicationImpl.getApplication().getSharedPreferences(AppConstants.BANNER_AND_SPLASH, 0).getBoolean("splashAnim", true);
            QLog.d("TianShuSplashProcessor", 1, "isEnableSplashAnim:", Boolean.valueOf(z16));
            return z16;
        }
    }

    public TianShuSplashProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288791a = false;
            this.f288792b = false;
        }
    }

    private void i(SplashADView splashADView) {
        if (splashADView == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(splashADView) { // from class: com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SplashADView f288793d;

            {
                this.f288793d = splashADView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TianShuSplashProcessor.this, (Object) splashADView);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                this.f288793d.setOnClickListener(null);
                this.f288793d.setOnShakeListener(null);
                this.f288793d.setOnGestureTrackListener(null);
                this.f288793d.setOnSlopeSlideInteractListener(null);
                this.f288793d.setTwistInteractListener(null);
                this.f288793d.setFlipCardInteractListener(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final c.a aVar) {
        if (this.f288792b) {
            return;
        }
        this.f288792b = true;
        QQAppInterface k3 = k();
        if (k3 != null && !k3.isRingerSilent()) {
            try {
                ((Vibrator) BaseApplication.getContext().getSystemService("vibrator")).vibrate(1500L);
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.splashad.processor.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        TianShuSplashProcessor.this.n(aVar);
                    }
                }, 1500L);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.splashad.processor.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        TianShuSplashProcessor.this.p();
                    }
                }, 16, null, false);
                return;
            } catch (Throwable th5) {
                QLog.e("TianShuSplashProcessor", 1, "emitVibration e:", th5);
                return;
            }
        }
        n(aVar);
        QLog.i("TianShuSplashProcessor", 1, "emitVibration is silent mode");
    }

    private QQAppInterface k() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.i("TianShuSplashProcessor", 1, "getQQAppInterface appRuntime isn't QQAppInterface");
            return null;
        }
        return (QQAppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(SplashADView splashADView, o43.a aVar, c.a aVar2, String str, int i3, long j3) {
        com.tencent.mobileqq.vassplash.common.c.f312375c = true;
        com.tencent.mobileqq.vassplash.common.c.f312378f = i3;
        i(splashADView);
        if (QLog.isDebugVersion()) {
            QLog.i("TianShuSplashProcessor", 1, "shake complete, load landing page");
        }
        if (aVar != null && aVar.f() && !aVar.a()) {
            com.tencent.mobileqq.vassplash.common.c.c(str);
        }
        com.tencent.mobileqq.vassplash.common.c.v(aVar);
        com.tencent.mobileqq.vassplash.common.c.u(aVar);
        aVar2.a(j3);
    }

    private SplashADView m(Activity activity, o43.b bVar, o43.a aVar, c.a aVar2) {
        SplashADView n3 = SplashADView.n(bVar, activity);
        o43.a aVar3 = com.tencent.mobileqq.vassplash.common.c.f312380h;
        String str = SplashADUtil.i(BaseApplicationImpl.getApplication()) + "";
        n3.setOnClickListener(new a(aVar3, aVar2, bVar, n3, activity, str));
        int i3 = bVar.f422003b;
        if (i3 == 2 || i3 == 3) {
            n3.setOnErrorListener(new b(aVar2, aVar));
            n3.setOnCompletionListener(new c(aVar2, aVar3, aVar));
            n3.setPresenter(new SplashADView.e((ImageView) activity.findViewById(R.id.j0m), (ImageView) activity.findViewById(R.id.j0p), aVar, n3) { // from class: com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor.4
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ImageView f288794a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ ImageView f288795b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ o43.a f288796c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ SplashADView f288797d;

                {
                    this.f288794a = r6;
                    this.f288795b = r7;
                    this.f288796c = aVar;
                    this.f288797d = n3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, r6, r7, aVar, n3);
                    }
                }

                @Override // com.tencent.mobileqq.splashad.SplashADView.e
                public void a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ImageView imageView = this.f288794a;
                    if (imageView != null && this.f288795b != null) {
                        imageView.setVisibility(8);
                        this.f288795b.setVisibility(8);
                    }
                    o43.a aVar4 = this.f288796c;
                    w.q(aVar4.f421925b, 156, aVar4.f421950o);
                    ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass4.this.f288797d.R();
                            }
                        }
                    }, 50L);
                }
            });
        }
        if (bVar.E == 1) {
            n3.addOnAttachStateChangeListener(new d(n3, aVar3, aVar2, str));
        }
        if (bVar.B == 4) {
            n3.setOnGestureTrackListener(new e(bVar, n3, aVar3, aVar2, str));
        }
        int i16 = bVar.B;
        if (i16 == 6 || i16 == 9) {
            n3.setOnSlopeSlideInteractListener(new f(n3, bVar, aVar3, aVar2, str));
        }
        if (bVar.B == 7) {
            n3.setTwistInteractListener(new TwistView.b(n3, aVar3, aVar2, str) { // from class: com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor.8
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ SplashADView f288800a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ o43.a f288801b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ c.a f288802c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f288803d;

                {
                    this.f288800a = n3;
                    this.f288801b = aVar3;
                    this.f288802c = aVar2;
                    this.f288803d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, n3, aVar3, aVar2, str);
                    }
                }

                @Override // com.tencent.gdtad.basics.twist.TwistView.b
                public void onBackInteractProgress(float f16, int i17) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Integer.valueOf(i17));
                    }
                }

                @Override // com.tencent.gdtad.basics.twist.TwistView.b
                public void onInteractProgress(float f16, int i17) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Integer.valueOf(i17));
                    }
                }

                @Override // com.tencent.gdtad.basics.twist.TwistView.b
                public void onInteractResult(boolean z16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, z16);
                    } else if (z16) {
                        Vibrator vibrator = (Vibrator) this.f288800a.getContext().getApplicationContext().getSystemService("vibrator");
                        if (vibrator != null) {
                            vibrator.vibrate(500L);
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor.8.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                    TianShuSplashProcessor.this.l(anonymousClass8.f288800a, anonymousClass8.f288801b, anonymousClass8.f288802c, anonymousClass8.f288803d, 138, 0L);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.gdtad.basics.twist.TwistView.b
                public void onInteractStart() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        if (bVar.B == 8) {
            n3.setFlipCardInteractListener(new com.tencent.gdtad.basics.flip.c(n3, aVar3, aVar2, str) { // from class: com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor.9
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ SplashADView f288806a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ o43.a f288807b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ c.a f288808c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f288809d;

                {
                    this.f288806a = n3;
                    this.f288807b = aVar3;
                    this.f288808c = aVar2;
                    this.f288809d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, TianShuSplashProcessor.this, n3, aVar3, aVar2, str);
                    }
                }

                @Override // com.tencent.gdtad.basics.flip.c
                public void onBackInteractProgress(float f16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
                    }
                }

                @Override // com.tencent.gdtad.basics.flip.c
                public void onInteractProgress(float f16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
                    }
                }

                @Override // com.tencent.gdtad.basics.flip.c
                public void onInteractResult(int i17, boolean z16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i17), Boolean.valueOf(z16));
                    } else if (z16) {
                        Vibrator vibrator = (Vibrator) this.f288806a.getContext().getApplicationContext().getSystemService("vibrator");
                        if (vibrator != null) {
                            vibrator.vibrate(500L);
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor.9.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                    TianShuSplashProcessor.this.l(anonymousClass9.f288806a, anonymousClass9.f288807b, anonymousClass9.f288808c, anonymousClass9.f288809d, 138, 0L);
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.gdtad.basics.flip.c
                public void onInteractStart(int i17) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i17);
                    }
                }
            });
        }
        return n3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void n(c.a aVar) {
        SplashADView n3 = SplashADView.n(null, null);
        if (n3 != null && !n3.f288719a0) {
            SetSplash.i(false);
            aVar.a(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        QQAppInterface k3 = k();
        if (k3 != null && k3.isLogin()) {
            ((com.tencent.mobileqq.springhb.config.g) k3.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).f(k3, 4);
        } else {
            QLog.i("TianShuSplashProcessor", 1, "reqShuaYiShuaConfig isn't login");
        }
    }

    private boolean q(AppActivity appActivity, ImageView imageView, ImageView imageView2, c.a aVar) {
        long i3 = SplashADUtil.i(BaseApplicationImpl.getApplication());
        if (!com.tencent.mobileqq.vassplash.common.c.m(i3)) {
            QLog.i("TianShuSplashProcessor", 1, "don't show splash");
            return false;
        }
        o43.a aVar2 = com.tencent.mobileqq.vassplash.common.c.f312380h;
        if (aVar2 == null) {
            QLog.i("TianShuSplashProcessor", 1, "splashItem  == null");
            return false;
        }
        QLog.i("TianShuSplashProcessor", 1, "[setupVasSplash]   start vas splash launch check");
        if (SafeModeHelper.f(BaseApplicationImpl.getApplication())) {
            com.tencent.mobileqq.vassplash.common.c.b(BaseApplicationImpl.getApplication(), i3, true);
            cooperation.vip.ad.license.g.g().f();
            QLog.e("TianShuSplashProcessor", 1, "[setupVasSplash]  start safeMode");
            w.q(aVar2.f421925b, 154, aVar2.f421950o);
            return false;
        }
        if (aVar2.f421931e == 1) {
            com.tencent.mobileqq.vassplash.common.c.s(aVar2.f421925b, i3, false);
            return false;
        }
        com.tencent.mobileqq.startup.a.f289662c = 0L;
        com.tencent.mobileqq.startup.a.f289663d = 0L;
        QLog.i("TianShuSplashProcessor", 1, "ready show Splash");
        com.tencent.mobileqq.splashad.l.o();
        if (!SplashADUtil.v(appActivity)) {
            w.q(aVar2.f421925b, 152, aVar2.f421950o);
            return false;
        }
        QLog.i("QSplash@", 1, "show Splash AD, uin = " + (i3 % 10000) + "\uff0cadId:" + aVar2.f421925b);
        int i16 = aVar2.f421935g;
        if (i16 == 1 || i16 == 5) {
            QLog.i("TianShuSplashProcessor", 1, "preLoad web");
            ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(36, null);
            com.tencent.mobileqq.vassplash.common.c.f312376d = true;
        }
        if (aVar2.f421935g == 2) {
            c15.a.a();
            ((ISplashMiniGameStarterService) QRoute.api(ISplashMiniGameStarterService.class)).preloadProcess();
        }
        if (aVar2.f421935g == 3) {
            c15.a.a();
            ((ISplashMiniGameStarterService) QRoute.api(ISplashMiniGameStarterService.class)).preloadGameProcess();
        }
        b.a aVar3 = new b.a();
        aVar3.c(aVar2.f421931e).b(aVar2.f421955t).w(aVar2.f421945l).U(aVar2.f421945l).D(aVar2.f421952q).I(1).V(aVar2.f421950o).u(aVar2.f421935g).v(aVar2.f421937h).t(aVar2.f421939i).k(aVar2.f421956u).l(aVar2.f421957v).e(aVar2.f421958w).m(aVar2.G).g(aVar2.H).f(aVar2.I).h(aVar2.J).j(aVar2.K).i(aVar2.L).y(aVar2.M).x(aVar2.N).z(aVar2.O).A(aVar2.P).B(aVar2.Q).C(aVar2.R).J(aVar2.f421924a0).K(aVar2.f421928c0).M(aVar2.f421926b0).L(aVar2.f421930d0).O(aVar2.W).N(aVar2.V).Q(aVar2.Y).P(aVar2.X).R(aVar2.Z).G(aVar2.f421932e0).H(aVar2.f421934f0).s(aVar2.f421941j).E(aVar2.f421959x).F(aVar2.f421960y).d(aVar2.f421961z).S(aVar2.A).T(aVar2.B).n(aVar2.C).o(aVar2.D).p(aVar2.E).q(aVar2.F).r(aVar2.f421938h0, aVar2.f421940i0, aVar2.f421942j0, aVar2.f421944k0, aVar2.f421946l0);
        aVar.b(new g(aVar2, m(appActivity, aVar3.a(), aVar2, aVar), imageView2, imageView, appActivity, this.f288791a));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(int i3, SplashADView splashADView) {
        if (i3 == 2) {
            splashADView.K();
        } else if (i3 == 3) {
            splashADView.J();
        }
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean b(AppActivity appActivity, SplashWidget splashWidget, c.a aVar, com.tencent.mobileqq.splash.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appActivity, splashWidget, aVar, aVar2)).booleanValue();
        }
        try {
            if (aVar == null) {
                QLog.e("TianShuSplashProcessor", 1, "setupVasSplash but listener is null");
                return false;
            }
            boolean q16 = q(appActivity, splashWidget.b(), splashWidget.a(), aVar);
            if (q16 && aVar2 != null) {
                aVar2.a(true);
            }
            return q16;
        } catch (Exception e16) {
            QLog.e("TianShuSplashProcessor", 1, "show SplashAd initView error ", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f288791a = z16;
        }
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public Integer getBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TianShuSplashProcessor";
    }
}
