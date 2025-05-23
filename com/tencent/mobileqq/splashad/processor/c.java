package com.tencent.mobileqq.splashad.processor;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.gdtad.splash.IGdtSplashAPI;
import com.tencent.gdtad.splash.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splash.c;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.SplashWidget;
import com.tencent.mobileqq.splashad.o;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class c implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f288860a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static final class a implements w {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c.a> f288861a;

        public a(WeakReference<c.a> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
            } else {
                this.f288861a = weakReference;
            }
        }

        @Override // com.tencent.gdtad.splash.w
        public void a(long j3) {
            c.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            WeakReference<c.a> weakReference = this.f288861a;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            c.h(aVar, j3);
        }

        @Override // com.tencent.gdtad.splash.w
        public void b(long j3) {
            c.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
                return;
            }
            WeakReference<c.a> weakReference = this.f288861a;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            c.i(aVar, j3);
        }

        @Override // com.tencent.gdtad.splash.w
        public void onDurationUpdate(long j3) {
            c.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                return;
            }
            WeakReference<c.a> weakReference = this.f288861a;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            c.g(aVar, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static final class b extends com.tencent.mobileqq.splash.c {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        private final WeakReference<Activity> f288862c;

        /* renamed from: d, reason: collision with root package name */
        private a f288863d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f288864e;

        /* renamed from: f, reason: collision with root package name */
        private o f288865f;

        protected b(WeakReference<Activity> weakReference, Object obj, WeakReference<c.a> weakReference2, boolean z16) {
            super(obj);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, weakReference, obj, weakReference2, Boolean.valueOf(z16));
                return;
            }
            this.f288865f = null;
            this.f288862c = weakReference;
            this.f288863d = new a(weakReference2);
            this.f288864e = z16;
        }

        @Override // com.tencent.mobileqq.splash.c
        public void a(c.a aVar) {
            Activity activity;
            ViewGroup viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            WeakReference<Activity> weakReference = this.f288862c;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (activity != null) {
                viewGroup = (ViewGroup) activity.findViewById(R.id.j0l);
            } else {
                viewGroup = null;
            }
            try {
                if (this.f288864e) {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).showColdRealTimeSplash(this.f288862c, new WeakReference<>(viewGroup), new WeakReference<>(this.f288863d));
                } else {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).show(this.f288862c, new WeakReference<>(viewGroup), new WeakReference<>(this.f288863d), this.f288711b);
                }
                if (GuardManager.sInstance != null) {
                    o oVar = new o("ams", "", false);
                    this.f288865f = oVar;
                    GuardManager.sInstance.registerCallBack(oVar);
                }
            } catch (Throwable th5) {
                QLog.e("GdtSplashProcessor", 1, "[GdtSplashProcessorCallBack][bindView]", th5);
                c.h(aVar, 0L);
                this.f288863d = null;
            }
            QLog.i("GdtSplashProcessor", 1, "[GdtSplashProcessorCallBack][bindView] cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }

        @Override // com.tencent.mobileqq.splash.c
        public void b() {
            o oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.i("GdtSplashProcessor", 1, "[GdtSplashProcessorCallBack][end]");
            this.f288710a = true;
            try {
                ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).onClosed();
                GuardManager guardManager = GuardManager.sInstance;
                if (guardManager != null && (oVar = this.f288865f) != null) {
                    guardManager.unregisterCallback(oVar);
                    this.f288865f = null;
                }
            } catch (Throwable th5) {
                QLog.e("GdtSplashProcessor", 1, "[GdtSplashProcessorCallBack][end]", th5);
            }
            this.f288863d = null;
        }

        @Override // com.tencent.mobileqq.splash.c
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288860a = (!((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).canRealTimeOrderCold() || SplashADUtil.s() || SplashADUtil.t()) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(c.a aVar, long j3) {
        if (aVar == null) {
            QLog.e("GdtSplashProcessor", 1, "[onDurationUpdate] error, listener is null");
            return;
        }
        QLog.i("GdtSplashProcessor", 1, "[onDurationUpdate] durationMillis:" + j3);
        aVar.onDurationUpdate(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(c.a aVar, long j3) {
        if (aVar == null) {
            QLog.e("GdtSplashProcessor", 1, "[onSplashFinish] error, listener is null");
            return;
        }
        QLog.i("GdtSplashProcessor", 1, "[onSplashFinish] durationMillis:" + j3);
        aVar.a(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(c.a aVar, long j3) {
        if (aVar == null) {
            QLog.e("GdtSplashProcessor", 1, "[onSplashShow] error, listener is null");
            return;
        }
        QLog.i("GdtSplashProcessor", 1, "[onSplashShow] durationMillis:" + j3);
        aVar.c(j3);
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f288860a;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean b(AppActivity appActivity, SplashWidget splashWidget, c.a aVar, com.tencent.mobileqq.splash.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appActivity, splashWidget, aVar, aVar2)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar == null) {
            QLog.e("GdtSplashProcessor", 1, "[doProcess] error, listener is null cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return false;
        }
        Object obj = null;
        if (this.f288860a) {
            QLog.i("GdtSplashProcessor", 1, "[doProcess] return true, is RealTimeOrder cost:" + (System.currentTimeMillis() - currentTimeMillis));
            WeakReference<Activity> weakReference = new WeakReference<>(appActivity);
            b bVar = new b(weakReference, null, new WeakReference(aVar), true);
            ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).coldRealTimePrepare(weakReference, new WeakReference<>(bVar.f288863d));
            aVar.b(bVar);
            return true;
        }
        ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316020);
        try {
            obj = ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).prepare(new WeakReference<>(appActivity));
        } catch (Throwable th5) {
            QLog.e("GdtSplashProcessor", 1, "[doProcess]", th5);
        }
        if (obj == null) {
            QLog.i("GdtSplashProcessor", 1, "[doProcess] return false, order is null cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return false;
        }
        aVar.b(new b(new WeakReference(appActivity), obj, new WeakReference(aVar), false));
        QLog.i("GdtSplashProcessor", 1, "[doProcess] return true cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return true;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public Integer getBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "GdtSplashProcessor";
    }
}
