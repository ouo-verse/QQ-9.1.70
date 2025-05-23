package com.tencent.ams.xsad.rewarded.dynamic;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKBaseCustomAbilityProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEngine;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.VideoPlayerMethodHandler;
import com.tencent.ams.xsad.rewarded.utils.OnActivityLifecycleChanged;
import com.tencent.ams.xsad.rewarded.utils.g;
import com.tencent.ams.xsad.rewarded.view.RewardedAdController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKRewardedAdController implements RewardedAdController {
    static IPatchRedirector $redirector_;
    private RewardedAdController.a C;
    private View D;
    private ViewGroup E;
    private RewardAdMethodHandler F;
    private AdCommonMethodHandler G;
    private VideoPlayerMethodHandler H;
    private final RewardedAd.c I;
    private final Runnable J;
    private final Handler K;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Activity> f71750d;

    /* renamed from: e, reason: collision with root package name */
    private volatile DKEngine f71751e;

    /* renamed from: f, reason: collision with root package name */
    private View f71752f;

    /* renamed from: h, reason: collision with root package name */
    private Application.ActivityLifecycleCallbacks f71753h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f71754i;

    /* renamed from: m, reason: collision with root package name */
    private RewardedAdData f71755m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements RewardAdMethodHandler.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                DKRewardedAdController.this.w();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements DKEngine.BackPressHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.BackPressHandler
        public void onBackPressed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (DKRewardedAdController.this.I != null) {
                DKRewardedAdController.this.I.jb(DKRewardedAdController.this.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements Application.ActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("DKRewardedController", "onActivityCreated, activity: " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("DKRewardedController", "onActivityDestroyed, activity: " + activity + ", ref: " + DKRewardedAdController.this.z());
            if (activity == DKRewardedAdController.this.z()) {
                DKRewardedAdController.this.w();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            DKEngine dKEngine;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("DKRewardedController", "onActivityPaused, activity: " + activity + ", ref: " + DKRewardedAdController.this.z());
            if (activity == DKRewardedAdController.this.z() && (dKEngine = DKRewardedAdController.this.f71751e) != null) {
                dKEngine.onStop();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            DKEngine dKEngine;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                Activity z16 = DKRewardedAdController.this.z();
                com.tencent.ams.xsad.rewarded.utils.c.a("DKRewardedController", "onActivityResumed, activity: " + activity + ", ref: " + z16);
                if (activity == z16 && (dKEngine = DKRewardedAdController.this.f71751e) != null) {
                    dKEngine.onResume();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) bundle);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("DKRewardedController", "onActivityStarted, activity: " + activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.a("DKRewardedController", "onActivityStopped, activity: " + activity + ", ref: " + DKRewardedAdController.this.z());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d extends DKBaseCustomAbilityProvider {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKBaseCustomAbilityProvider, com.tencent.ams.dsdk.core.DKCustomAbilityProvider
        public DKVideoPlayer getDKVideoPlayer(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DKVideoPlayer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            DKRewardedAdVideoPlayer dKRewardedAdVideoPlayer = new DKRewardedAdVideoPlayer(context);
            OnActivityLifecycleChanged.c(DKRewardedAdController.this.z(), dKRewardedAdVideoPlayer);
            return dKRewardedAdVideoPlayer;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements DKEngine.OnCreateEngineListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DKEngine[] f71765a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f71766b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f71767c;

        e(DKEngine[] dKEngineArr, CountDownLatch countDownLatch, Context context) {
            this.f71765a = dKEngineArr;
            this.f71766b = countDownLatch;
            this.f71767c = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DKRewardedAdController.this, dKEngineArr, countDownLatch, context);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitializeError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "onEngineInitializeError, errorCode: " + i3);
            DKRewardedAdController.this.f71751e = null;
            DKRewardedAdController.this.I();
            this.f71766b.countDown();
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "onEngineInitialized");
            DKRewardedAdController.this.f71751e = this.f71765a[0];
            DKRewardedAdController.this.C(this.f71767c);
            this.f71766b.countDown();
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onWillCreateEngine() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            DKEngine dKEngine = this.f71765a[0];
            if (dKEngine instanceof DKHippyEngine) {
                HippyEngine.EngineInitParams initParams = ((DKHippyEngine) dKEngine).getInitParams();
                initParams.imageLoader = com.tencent.ams.xsad.rewarded.dynamic.a.e().c();
                initParams.enableLog = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class f implements AdCommonMethodHandler.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", AdCommonMethodHandler.AdCommonEvent.HIPPY_INIT_FINISHED);
                DKRewardedAdController.this.B();
            }
        }
    }

    public DKRewardedAdController(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f71750d = null;
        this.f71751e = null;
        this.f71752f = null;
        this.f71753h = null;
        this.f71754i = new byte[0];
        this.f71755m = null;
        this.C = null;
        this.D = null;
        this.I = new RewardedAd.c();
        this.J = new Runnable() { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.ams.xsad.rewarded.utils.c.e("DKRewardedController", "init timeout.");
                    DKRewardedAdController.this.A();
                }
            }
        };
        this.K = new Handler(Looper.getMainLooper());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DKRewardedAdController, thread: ");
        sb5.append(Thread.currentThread());
        sb5.append(", isMainThread: ");
        sb5.append(Looper.getMainLooper() == Looper.myLooper());
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", sb5.toString());
        if (com.tencent.ams.xsad.rewarded.dynamic.a.e().f()) {
            DKEngine.setDebug(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "notifyShowFailure");
        this.K.removeCallbacks(this.J);
        DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (DKRewardedAdController.this.C != null) {
                    DKRewardedAdController.this.C.onFailure();
                    DKRewardedAdController.this.C = null;
                }
                DKRewardedAdController.this.w();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "notifyShowSuccess");
        this.K.removeCallbacks(this.J);
        RewardedAdData rewardedAdData = this.f71755m;
        if (rewardedAdData != null) {
            rewardedAdData.f71688b = !com.tencent.ams.xsad.rewarded.dynamic.b.e(rewardedAdData.f71689c);
        }
        E();
        DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (DKRewardedAdController.this.G != null) {
                    DKRewardedAdController.this.G.l(DKRewardedAdController.this.f71752f);
                }
                if (DKRewardedAdController.this.E != null && DKRewardedAdController.this.f71752f != null) {
                    ViewGroup viewGroup = (ViewGroup) DKRewardedAdController.this.f71752f.getParent();
                    if (viewGroup != null && viewGroup != DKRewardedAdController.this.E) {
                        viewGroup.removeView(DKRewardedAdController.this.f71752f);
                    }
                    if (viewGroup == null || viewGroup != DKRewardedAdController.this.E) {
                        DKRewardedAdController.this.E.addView(DKRewardedAdController.this.f71752f, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
                if (DKRewardedAdController.this.C != null) {
                    DKRewardedAdController.this.C.onSuccess();
                    DKRewardedAdController.this.C = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Context context) {
        Application application;
        com.tencent.ams.xsad.rewarded.utils.c.a("DKRewardedController", "registerActivityLifecycle");
        if (context == null) {
            application = null;
        } else {
            application = (Application) context.getApplicationContext();
        }
        if (application != null && this.f71753h == null) {
            c cVar = new c();
            this.f71753h = cVar;
            application.registerActivityLifecycleCallbacks(cVar);
        }
    }

    private void D(DKEngine dKEngine) {
        if (dKEngine != null) {
            this.G = new AdCommonMethodHandler(z(), this.I, new f());
            RewardAdMethodHandler rewardAdMethodHandler = new RewardAdMethodHandler(this.I, new a());
            this.F = rewardAdMethodHandler;
            rewardAdMethodHandler.k(this.f71755m);
            this.H = new VideoPlayerMethodHandler(this.I);
            dKEngine.registerMethodHandler(this.G);
            dKEngine.registerMethodHandler(this.F);
            dKEngine.registerMethodHandler(this.H);
        }
    }

    private void E() {
        if (this.D == null) {
            return;
        }
        DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController.13
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "removeLoadingView");
                if (DKRewardedAdController.this.D != null && (DKRewardedAdController.this.D.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) DKRewardedAdController.this.D.getParent()).removeView(DKRewardedAdController.this.D);
                }
                DKRewardedAdController.this.D = null;
            }
        });
    }

    private void F() {
        if (this.f71752f != null) {
            DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController.14
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (DKRewardedAdController.this.f71752f != null && DKRewardedAdController.this.f71752f.getParent() != null && (DKRewardedAdController.this.f71752f.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) DKRewardedAdController.this.f71752f.getParent()).removeView(DKRewardedAdController.this.f71752f);
                    }
                    DKRewardedAdController.this.f71752f = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(Context context, RewardedAdData rewardedAdData) {
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "showDynamicView");
        if (context != null && rewardedAdData != null) {
            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "bundlePath: " + DKEngine.getBundlePath(rewardedAdData.f71703q));
            this.f71751e = x(context);
            if (this.f71751e == null) {
                com.tencent.ams.xsad.rewarded.utils.c.e("DKRewardedController", "engine is null");
                A();
                return;
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put(DKEngine.PARAM_KEY_APP_NAME, rewardedAdData.f71703q);
                hashMap.put(DKEngine.PARAM_KEY_AD_TYPE, "1");
                DynamicUtils.runOnUiThread(new Runnable(context, hashMap) { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController.11
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Context f71756d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Map f71757e;

                    /* compiled from: P */
                    /* renamed from: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController$11$a */
                    /* loaded from: classes3.dex */
                    class a implements DKEngine.OnViewCreateListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this);
                            }
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
                        public boolean onInterceptViewCreate(View view, int i3, Runnable runnable) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                                return false;
                            }
                            return ((Boolean) iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), runnable)).booleanValue();
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
                        public void onViewCreate(View view, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, i3);
                                return;
                            }
                            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "onViewCreate, view: " + view + ", errorCode: " + i3);
                            if (i3 != 9000 || (!com.tencent.ams.xsad.rewarded.dynamic.a.e().f() && DKRewardedAdController.this.I.a() == null)) {
                                DKRewardedAdController.this.A();
                                return;
                            }
                            DKRewardedAdController.this.f71752f = view;
                            if (com.tencent.ams.xsad.rewarded.dynamic.a.e().f()) {
                                DKRewardedAdController.this.B();
                            }
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
                        public void onViewCreateStart() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATE_START);
                            }
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
                        public void onViewInitializeError(int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                                iPatchRedirector.redirect((short) 6, (Object) this, i3);
                                return;
                            }
                            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "onViewInitializeError, errorCode: " + i3);
                            DKRewardedAdController.this.A();
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
                        public void onViewInitialized() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                                iPatchRedirector.redirect((short) 7, (Object) this);
                            } else {
                                com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "onViewInitialized");
                                DKRewardedAdController.this.B();
                            }
                        }

                        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
                        public void onViewLoadComplete() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                                iPatchRedirector.redirect((short) 5, (Object) this);
                            } else {
                                com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "onViewLoadComplete");
                            }
                        }
                    }

                    {
                        this.f71756d = context;
                        this.f71757e = hashMap;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, DKRewardedAdController.this, context, hashMap);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            DKRewardedAdController.this.f71751e.createView(this.f71756d, this.f71757e, new a());
                        } catch (Throwable th5) {
                            com.tencent.ams.xsad.rewarded.utils.c.b("DKRewardedController", "create view error.", th5);
                            DKRewardedAdController.this.A();
                        }
                    }
                });
                return;
            }
        }
        com.tencent.ams.xsad.rewarded.utils.c.e("DKRewardedController", "activity is null or data is null");
        A();
    }

    private void H() {
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", UIJsPlugin.EVENT_SHOW_LOADING);
        if (z() == null) {
            return;
        }
        E();
        DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController.12
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKRewardedAdController.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DKRewardedAdController dKRewardedAdController = DKRewardedAdController.this;
                dKRewardedAdController.D = dKRewardedAdController.y();
                DKRewardedAdController.this.E.addView(DKRewardedAdController.this.D, new ViewGroup.LayoutParams(-1, -1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        Application application;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        com.tencent.ams.xsad.rewarded.utils.c.a("DKRewardedController", "unregisterActivityLifecycle");
        Activity z16 = z();
        if (z16 == null) {
            application = null;
        } else {
            application = z16.getApplication();
        }
        if (application != null && (activityLifecycleCallbacks = this.f71753h) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.f71753h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", QCircleLpReportDc05507.KEY_CLEAR);
        this.I.b(null);
        this.C = null;
        E();
        F();
        this.K.removeCallbacks(this.J);
        com.tencent.ams.xsad.rewarded.dynamic.a.e().a();
        I();
        DKEngine dKEngine = this.f71751e;
        if (dKEngine != null) {
            dKEngine.unregisterMethodHandler(this.G);
            dKEngine.unregisterMethodHandler(this.F);
            dKEngine.unregisterMethodHandler(this.H);
            dKEngine.onDestroy();
        }
        this.G = null;
        this.F = null;
        this.H = null;
        this.f71751e = null;
        this.f71752f = null;
        this.E = null;
    }

    private DKEngine x(Context context) {
        String str;
        String str2;
        if (context == null) {
            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "init engine error. activity is null");
            return null;
        }
        if (this.f71751e != null) {
            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "engine exits.");
            return this.f71751e;
        }
        synchronized (this.f71754i) {
            com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "initEngine");
            if (this.f71751e != null) {
                return this.f71751e;
            }
            boolean f16 = com.tencent.ams.xsad.rewarded.dynamic.a.e().f();
            RewardedAdData rewardedAdData = this.f71755m;
            if (rewardedAdData == null) {
                str = null;
            } else {
                str = rewardedAdData.f71703q;
            }
            DKHippyEngine dKHippyEngine = new DKHippyEngine();
            DKEngine[] dKEngineArr = {dKHippyEngine};
            dKHippyEngine.setCustomAbilityProvider(new d());
            dKEngineArr[0].addEventHandler(com.tencent.ams.xsad.rewarded.dynamic.a.e().b());
            D(dKEngineArr[0]);
            HashMap hashMap = new HashMap();
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "1");
            hashMap.put(DKEngine.PARAM_KEY_APP_NAME, str);
            if (f16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            hashMap.put(DKEngine.PARAM_KEY_IS_DEBUG_MODE, str2);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "create engine");
                dKEngineArr[0].createEngine(context, hashMap, new e(dKEngineArr, countDownLatch, context));
                countDownLatch.await(com.tencent.ams.xsad.rewarded.dynamic.a.e().d(), TimeUnit.MILLISECONDS);
            } catch (Throwable th5) {
                com.tencent.ams.xsad.rewarded.utils.c.b("DKRewardedController", "init engine error.", th5);
                this.f71751e = null;
            }
            return this.f71751e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View y() {
        Activity z16 = z();
        if (z16 == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(z16);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        View progressBar = new ProgressBar(z16);
        int b16 = g.b(z16, 34.0f);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(b16, b16));
        linearLayout.addView(progressBar);
        TextView textView = new TextView(z16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = g.b(z16, 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(-1);
        textView.setText("\u52aa\u529b\u52a0\u8f7d\u4e2d");
        linearLayout.addView(textView);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity z() {
        WeakReference<Activity> weakReference = this.f71750d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void b(Activity activity, ViewGroup viewGroup, RewardedAdData rewardedAdData, RewardedAdController.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, viewGroup, rewardedAdData, aVar);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("DKRewardedController", "show");
        this.C = aVar;
        this.f71750d = new WeakReference<>(activity);
        this.E = viewGroup;
        this.f71755m = rewardedAdData;
        if (activity != null && rewardedAdData != null) {
            Context applicationContext = activity.getApplicationContext();
            H();
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable(applicationContext, rewardedAdData) { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdController.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f71759d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ RewardedAdData f71760e;

                {
                    this.f71759d = applicationContext;
                    this.f71760e = rewardedAdData;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DKRewardedAdController.this, applicationContext, rewardedAdData);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKRewardedAdController.this.G(this.f71759d, this.f71760e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
            this.K.postDelayed(this.J, com.tencent.ams.xsad.rewarded.dynamic.a.e().d());
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.e("DKRewardedController", "activity is null or data is null");
        A();
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        VideoPlayerMethodHandler videoPlayerMethodHandler = this.H;
        if (videoPlayerMethodHandler != null) {
            return videoPlayerMethodHandler.b();
        }
        return 0L;
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void d(com.tencent.ams.xsad.rewarded.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
            return;
        }
        DKEngine dKEngine = this.f71751e;
        if (dKEngine != null) {
            HippyMap hippyMap = new HippyMap();
            if (aVar != null) {
                hippyMap.pushString("uniqueKey", aVar.f71725a);
                hippyMap.pushBoolean("isUnlock", aVar.f71726b);
                hippyMap.pushInt("rewardStage", aVar.f71727c);
                hippyMap.pushInt("stageRewardType", aVar.f71728d);
            }
            dKEngine.sendEvent("notifyUnlockStatus", hippyMap);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public int getDisplayType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f71752f;
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void onBackPressed() {
        RewardedAd.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f71751e != null) {
            if (!this.f71751e.onBackPressed(new b()) && (cVar = this.I) != null) {
                cVar.jb(c());
                return;
            }
            return;
        }
        RewardedAd.c cVar2 = this.I;
        if (cVar2 != null) {
            cVar2.jb(c());
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.view.RewardedAdController
    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) rewardedAdListener);
        } else {
            this.I.b(rewardedAdListener);
        }
    }
}
