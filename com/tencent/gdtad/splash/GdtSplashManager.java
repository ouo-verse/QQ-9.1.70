package com.tencent.gdtad.splash;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import com.qq.e.tg.TangramUtil;
import com.qq.e.tg.splash.PreCacheSplashAd;
import com.qq.e.tg.splash.SplashOrder;
import com.qq.e.tg.splash.TGSplashAD;
import com.qq.e.tg.splash.TGSplashAdListenerV2;
import com.qq.e.tg.splash.TGSplashPreCacheResult;
import com.qq.e.tg.splash.TGSplashPreCacheUtil;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.IRealTimeConfigApi;
import com.tencent.gdtad.splash.GdtSplashPreloader;
import com.tencent.gdtad.splash.mcconfig.GdtSplashAdSwitchConfigParser;
import com.tencent.gdtad.splash.statistics.GdtSplashReporterUtil;
import com.tencent.gdtad.splash.view.GdtSplashAdViewBuilder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtSplashManager {

    /* renamed from: k, reason: collision with root package name */
    private static volatile GdtSplashManager f109325k;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.gdtad.splash.statistics.c f109326a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f109327b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<GdtSplashPreloader, d> f109328c;

    /* renamed from: d, reason: collision with root package name */
    private b f109329d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f109330e;

    /* renamed from: f, reason: collision with root package name */
    private GdtSplashAdViewBuilder f109331f;

    /* renamed from: g, reason: collision with root package name */
    private TGSplashAD f109332g;

    /* renamed from: h, reason: collision with root package name */
    private SplashOrder f109333h;

    /* renamed from: i, reason: collision with root package name */
    private TGSplashAD f109334i;

    /* renamed from: j, reason: collision with root package name */
    private c f109335j;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static final class a implements TGSplashAdListenerV2 {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<w> f109337a;

        public a(WeakReference<w> weakReference) {
            this.f109337a = weakReference;
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADClicked() {
            QLog.i("GdtSplashManager", 1, "[onADClicked]");
            GdtSplashManager.p().t(this.f109337a, 3, null);
            GdtSplashManager.p().D(u.f109448c, GdtSplashManager.p().f109326a.g(), false);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADDismissed() {
            QLog.i("GdtSplashManager", 1, "[onADDismissed]");
            GdtSplashManager.p().t(this.f109337a, 1, null);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADExposure() {
            QLog.i("GdtSplashManager", 1, "[onADExposure]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADFetch() {
            QLog.i("GdtSplashManager", 1, "[onADFetch]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListenerV2
        public void onADFetchWithResult(SplashOrder splashOrder) {
            QLog.i("GdtSplashManager", 1, "[onADFetchWithResult]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADPresent() {
            QLog.i("GdtSplashManager", 1, "[onADPresent]");
            GdtSplashManager.p().f109326a.s(System.currentTimeMillis());
            GdtSplashManager.p().x();
            GdtSplashDeviceInfoUtil.d();
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADSkip() {
            QLog.i("GdtSplashManager", 1, "[onADSkip]");
            GdtSplashManager.p().t(this.f109337a, 2, null);
            GdtSplashManager.p().D(u.f109449d, GdtSplashManager.p().f109326a.g(), false);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADTick(long j3) {
            QLog.i("GdtSplashManager", 1, "[onADTick]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onNoAD(AdError adError) {
            int i3;
            int i16 = Integer.MIN_VALUE;
            if (adError != null) {
                i3 = adError.getErrorCode();
            } else {
                i3 = Integer.MIN_VALUE;
            }
            if (adError != null) {
                i16 = adError.getSubErrorCode();
            }
            QLog.e("GdtSplashManager", 1, "[onNoAD] errorCode:" + i3 + " subErrorCode:" + i16);
            p pVar = new p(2000100, i3, i16);
            GdtSplashManager.p().f109326a.r(System.currentTimeMillis(), pVar);
            GdtSplashManager.p().t(this.f109337a, 4, pVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static final class b implements TGSplashPreCacheUtil.AdImageLoadListener {
        b() {
        }

        @Override // com.qq.e.tg.splash.TGSplashPreCacheUtil.AdImageLoadListener
        public void onLoadFailed(int i3) {
            QLog.e("GdtSplashManager", 1, "[GdtSplashAdLoadListener.onLoadFailed] error:" + i3);
            GdtSplashManager.p().f109326a.j(new p(2000100, i3));
        }

        @Override // com.qq.e.tg.splash.TGSplashPreCacheUtil.AdImageLoadListener
        public void onLoaded(Bitmap bitmap) {
            QLog.i("GdtSplashManager", 1, "[GdtSplashAdLoadListener.onLoaded]");
            GdtSplashManager.p().E(bitmap);
            if (bitmap != null) {
                GdtSplashManager.p().f109326a.l();
            } else {
                GdtSplashManager.p().f109326a.j(new p(2000001));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static final class c implements TGSplashAdListenerV2 {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<w> f109338a;

        c() {
        }

        void a(WeakReference<w> weakReference) {
            this.f109338a = weakReference;
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADClicked() {
            QLog.i("GdtSplashManager", 1, "[realTime order onADClicked]");
            GdtSplashManager.p().t(this.f109338a, 3, null);
            if (GdtSplashManager.p().f109333h != null) {
                GdtSplashManager.p().D(u.f109448c, GdtSplashManager.p().f109333h.getCl(), true);
            }
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADDismissed() {
            QLog.i("GdtSplashManager", 1, "[realTime order onADDismissed]");
            GdtSplashManager.p().t(this.f109338a, 1, null);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADExposure() {
            QLog.i("GdtSplashManager", 1, "[realTime order onADExposure]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADFetch() {
            QLog.i("GdtSplashManager", 1, "[realTime order onADFetch]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListenerV2
        public void onADFetchWithResult(SplashOrder splashOrder) {
            boolean z16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[realTime order onADFetchWithResult] ");
            if (splashOrder == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("GdtSplashManager", 1, sb5.toString());
            GdtSplashManager.p().f109333h = splashOrder;
            if (splashOrder != null) {
                QLog.i("GdtSplashManager", 1, "[realTime order onADFetchWithResult pre show] ");
                GdtSplashManager.p().f109326a.p(System.currentTimeMillis(), splashOrder.getCl());
                GdtSplashManager.p().u(this.f109338a);
                return;
            }
            GdtSplashManager.p().C(1316031);
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADPresent() {
            QLog.i("GdtSplashManager", 1, "[realTime order onADPresent]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADSkip() {
            QLog.i("GdtSplashManager", 1, "[realTime order onADSkip]");
            GdtSplashManager.p().t(this.f109338a, 2, null);
            if (GdtSplashManager.p().f109333h != null) {
                GdtSplashManager.p().D(u.f109449d, GdtSplashManager.p().f109333h.getCl(), true);
            }
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onADTick(long j3) {
            QLog.i("GdtSplashManager", 1, "[realTime order onADTick]");
        }

        @Override // com.qq.e.tg.splash.TGSplashAdListener
        public void onNoAD(AdError adError) {
            int i3;
            int i16 = Integer.MIN_VALUE;
            if (adError != null) {
                i3 = adError.getErrorCode();
            } else {
                i3 = Integer.MIN_VALUE;
            }
            if (adError != null) {
                i16 = adError.getSubErrorCode();
            }
            QLog.e("GdtSplashManager", 1, "[realTime order onNoAD] errorCode:" + i3 + " subErrorCode:" + i16);
            GdtSplashManager.p().f109333h = null;
            GdtSplashManager.p().C(1316032);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class d implements GdtSplashPreloader.f {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<GdtSplashPreloader> f109339a;

        public d(WeakReference<GdtSplashPreloader> weakReference) {
            this.f109339a = weakReference;
        }

        private void b() {
            GdtSplashPreloader gdtSplashPreloader;
            if (GdtSplashManager.p().f109328c.isEmpty()) {
                QLog.e("GdtSplashPreloaderListener", 1, "[GdtSplashPreloaderListener][removePreloader] error, mPreloadList is empty");
                return;
            }
            WeakReference<GdtSplashPreloader> weakReference = this.f109339a;
            if (weakReference != null) {
                gdtSplashPreloader = weakReference.get();
            } else {
                gdtSplashPreloader = null;
            }
            if (gdtSplashPreloader == null) {
                QLog.e("GdtSplashPreloaderListener", 1, "[GdtSplashPreloaderListener][removePreloader] error, preloader is null");
            } else if (!GdtSplashManager.p().f109328c.containsKey(gdtSplashPreloader)) {
                QLog.e("GdtSplashPreloaderListener", 1, "[GdtSplashPreloaderListener][removePreloader] error, not contains the preloader");
            } else {
                GdtSplashManager.p().f109328c.remove(gdtSplashPreloader);
                QLog.i("GdtSplashPreloaderListener", 1, "[GdtSplashPreloaderListener][removePreloader]");
            }
        }

        @Override // com.tencent.gdtad.splash.GdtSplashPreloader.f
        public void a(p pVar) {
            int i3;
            if (pVar != null) {
                i3 = pVar.a();
            } else {
                i3 = Integer.MIN_VALUE;
            }
            QLog.e("GdtSplashPreloaderListener", 1, "[GdtSplashPreloaderListener][onLoadFailed] errorCode:" + i3);
            b();
        }

        @Override // com.tencent.gdtad.splash.GdtSplashPreloader.f
        public void onLoadSuccess() {
            QLog.i("GdtSplashPreloaderListener", 1, "[GdtSplashPreloaderListener][onLoadSuccess]");
            b();
        }
    }

    GdtSplashManager() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f109326a = new com.tencent.gdtad.splash.statistics.c();
        this.f109327b = new AtomicInteger(0);
        this.f109328c = new ConcurrentHashMap<>();
        o.b();
        QLog.i("GdtSplashManager", 1, "[GdtSplashManager] costTime:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Bitmap bitmap) {
        this.f109330e = bitmap;
    }

    private p m(WeakReference<Activity> weakReference) {
        boolean z16;
        try {
            z16 = ((IGdtSplashQQLiteAPI) QRoute.api(IGdtSplashQQLiteAPI.class)).isStartFromLauncher(weakReference.get());
        } catch (Throwable th5) {
            QLog.e("GdtSplashManager", 1, "[canPrepare]", th5);
            z16 = false;
        }
        if (!z16) {
            QLog.e("GdtSplashManager", 1, "[canPrepare] error, not start from launcher");
            return new p(2000008);
        }
        if (!u.d(weakReference.get())) {
            QLog.e("GdtSplashManager", 1, "[canPrepare] error, orientation not supported");
            return new p(2000009);
        }
        return new p(0);
    }

    public static GdtSplashManager p() {
        if (f109325k == null) {
            synchronized (GdtSplashManager.class) {
                if (f109325k == null) {
                    f109325k = new GdtSplashManager();
                }
            }
        }
        return f109325k;
    }

    private void q(WeakReference<w> weakReference, int i3) {
        int i16;
        p pVar = new p(i3);
        this.f109326a.u(pVar);
        if (i3 == 2000011) {
            i16 = 1316030;
        } else {
            i16 = 1316028;
        }
        C(i16);
        s(weakReference, 0L);
        t(weakReference, 4, pVar);
    }

    private static boolean r(PreCacheSplashAd preCacheSplashAd) {
        if (preCacheSplashAd == null) {
            QLog.e("GdtSplashManager", 1, "[isValidOrder] null order");
            return false;
        }
        String aid = preCacheSplashAd.getAid();
        if (TextUtils.isEmpty(aid)) {
            QLog.e("GdtSplashManager", 1, "[isValidOrder] empty order id");
            return false;
        }
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        if (b16 == null) {
            b16 = new GdtSplashAdSwitchConfigParser.a();
        }
        Iterator it = new ArrayList(b16.f109389e).iterator();
        while (it.hasNext()) {
            if (aid.equals((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    private void s(WeakReference<w> weakReference, long j3) {
        w wVar;
        if (weakReference != null) {
            wVar = weakReference.get();
        } else {
            wVar = null;
        }
        if (wVar != null) {
            wVar.onDurationUpdate(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(WeakReference<w> weakReference, int i3, p pVar) {
        w wVar;
        this.f109326a.i(System.currentTimeMillis(), i3, pVar);
        if (weakReference != null) {
            wVar = weakReference.get();
        } else {
            wVar = null;
        }
        if (wVar != null) {
            wVar.a(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(WeakReference<w> weakReference) {
        w wVar;
        if (weakReference != null) {
            wVar = weakReference.get();
        } else {
            wVar = null;
        }
        if (wVar != null) {
            wVar.b(0L);
        }
    }

    private void w() {
        QLog.i("GdtSplashManager", 1, "[preloadAfterLoginAndMessageLoaded]");
        GdtSplashPreloader gdtSplashPreloader = new GdtSplashPreloader();
        d dVar = new d(new WeakReference(gdtSplashPreloader));
        this.f109328c.put(gdtSplashPreloader, dVar);
        gdtSplashPreloader.p(this.f109327b, new WeakReference<>(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        QLog.i("GdtSplashManager", 1, "[preloadWebProcess]");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.GdtSplashManager.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(39, null);
                } catch (Throwable th5) {
                    QLog.e("GdtSplashManager", 1, "[prepare] preloadWebProcess", th5);
                }
            }
        }, 128, null, true);
    }

    public void A(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3) {
        Activity activity;
        this.f109326a.t(System.currentTimeMillis());
        ViewGroup viewGroup = null;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity == null) {
            QLog.e("GdtSplashManager", 1, "[realTimeShow] error, activity is null");
            q(weakReference3, 2000001);
            return;
        }
        if (!u.d(activity)) {
            QLog.e("GdtSplashManager", 1, "[realTimeShow] error, orientation not supported");
            q(weakReference3, 2000009);
            return;
        }
        activity.setRequestedOrientation(1);
        if (weakReference2 != null) {
            viewGroup = weakReference2.get();
        }
        if (viewGroup == null) {
            QLog.e("GdtSplashManager", 1, "[realTimeShow] error, container is null");
            q(weakReference3, 2000001);
            return;
        }
        if (this.f109333h == null) {
            QLog.e("GdtSplashManager", 1, "[realTimeShow] error, mRealTimeSplashOrder is null");
            q(weakReference3, 2000012);
            return;
        }
        if (this.f109332g == null) {
            QLog.e("GdtSplashManager", 1, "[realTimeShow] error, mRealTimeSplash is null");
            q(weakReference3, 2000012);
            return;
        }
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        if (b16 == null) {
            b16 = new GdtSplashAdSwitchConfigParser.a();
        }
        QLog.i("GdtSplashManager", 1, "[realTimeShow] switchConfig.transitionPageDisplayMillis:" + b16.f109388d + ",showAd time=" + (this.f109333h.getExposureDelay() * 1000));
        s(weakReference3, (((long) this.f109333h.getExposureDelay()) * 1000) + ((long) b16.f109388d));
        GdtSplashAdViewBuilder gdtSplashAdViewBuilder = this.f109331f;
        if (gdtSplashAdViewBuilder == null) {
            QLog.e("GdtSplashManager", 1, "[realTimeShow] error, gdtSplashAdView is null");
            q(weakReference3, 2000001);
            return;
        }
        QLog.e("GdtSplashManager", 1, "[realTimeShow] type is " + this.f109333h.getInteractiveAdType());
        if (this.f109333h.isOlympicGallery()) {
            n.f109392a.n();
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateAmsSplashShowTime(true, false);
            C(1316027);
        } else if (((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).isAmsSplashExceedLimit(true)) {
            QLog.e("GdtSplashManager", 1, "[realTimeShow] error, splashLimit ExceedLimit");
            q(weakReference3, 2000011);
            return;
        } else {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).updateAmsSplashShowTime(true, true);
            C(1316029);
        }
        this.f109332g.setSkipView(gdtSplashAdViewBuilder.f());
        this.f109332g.setNeedUseCustomFloatViewPosition(true);
        this.f109332g.setFloatView(gdtSplashAdViewBuilder.e());
        this.f109335j.a(weakReference3);
        QLog.i("GdtSplashManager", 1, "[realTimeShow] container visibility" + viewGroup.getVisibility() + ", container shown:" + viewGroup.isShown() + "container window visibility:" + viewGroup.getWindowVisibility());
        TGSplashAD.SplashDisplayParams splashDisplayParams = new TGSplashAD.SplashDisplayParams();
        splashDisplayParams.container = viewGroup;
        splashDisplayParams.firstFrameTimeout = (long) b16.f109388d;
        this.f109332g.showAd(splashDisplayParams);
        this.f109326a.v();
        D(u.f109447b, this.f109333h.getCl(), true);
    }

    public void B(boolean z16, boolean z17, int i3) {
        u.f(z16, z17, i3);
    }

    public void C(int i3) {
        GdtSplashReporterUtil.e(new com.tencent.gdtad.splash.statistics.b(i3));
    }

    public void D(String str, String str2, boolean z16) {
        String str3;
        if (z16) {
            str3 = u.f109453h;
        } else {
            str3 = u.f109454i;
        }
        u.g(str, str2, str3);
    }

    public void F(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3, Object obj) {
        ViewGroup viewGroup;
        Activity activity;
        PreCacheSplashAd preCacheSplashAd;
        this.f109326a.t(System.currentTimeMillis());
        if (weakReference2 != null) {
            viewGroup = weakReference2.get();
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            QLog.e("GdtSplashManager", 1, "[show] error, container is null");
            p pVar = new p(2000001);
            this.f109326a.u(pVar);
            t(weakReference3, 4, pVar);
            return;
        }
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity == null) {
            QLog.e("GdtSplashManager", 1, "[show] error, activity is null");
            p pVar2 = new p(2000001);
            this.f109326a.u(pVar2);
            t(weakReference3, 4, pVar2);
            return;
        }
        if (!u.d(activity)) {
            QLog.e("GdtSplashManager", 1, "[show] error, orientation not supported");
            p pVar3 = new p(2000009);
            this.f109326a.u(pVar3);
            t(weakReference3, 4, pVar3);
            return;
        }
        activity.setRequestedOrientation(1);
        GdtSplashAdViewBuilder gdtSplashAdViewBuilder = this.f109331f;
        if (gdtSplashAdViewBuilder == null) {
            QLog.e("GdtSplashManager", 1, "[show] error, gdtSplashAdView is null");
            p pVar4 = new p(2000001);
            this.f109326a.u(pVar4);
            t(weakReference3, 4, pVar4);
            return;
        }
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        if (b16 == null) {
            b16 = new GdtSplashAdSwitchConfigParser.a();
        }
        GdtSplashAdSwitchConfigParser.a aVar = b16;
        this.f109334i = new TGSplashAD(activity, gdtSplashAdViewBuilder.f(), "1109803375", "9065538021425253", new a(weakReference3), Integer.MIN_VALUE, null);
        if (obj instanceof PreCacheSplashAd) {
            preCacheSplashAd = (PreCacheSplashAd) obj;
        } else {
            preCacheSplashAd = null;
        }
        if (preCacheSplashAd == null) {
            QLog.e("GdtSplashManager", 1, "[show] error, cachedSplashAd is null");
            p pVar5 = new p(2000001);
            this.f109326a.u(pVar5);
            t(weakReference3, 4, pVar5);
            return;
        }
        Bitmap bitmap = this.f109330e;
        if (bitmap == null) {
            QLog.e("GdtSplashManager", 1, "[show] error, bitmap is null");
            p pVar6 = new p(2000015);
            this.f109326a.u(pVar6);
            t(weakReference3, 4, pVar6);
            return;
        }
        QLog.i("GdtSplashManager", 1, "[show] switchConfig.transitionPageDisplayMillis:" + aVar.f109388d + ",showAd time=" + preCacheSplashAd.getTimeLife());
        s(weakReference3, (((long) preCacheSplashAd.getTimeLife()) * 1000) + ((long) aVar.f109388d));
        this.f109334i.setSkipView(gdtSplashAdViewBuilder.f());
        this.f109334i.setNeedUseCustomFloatViewPosition(true);
        this.f109334i.setFloatView(gdtSplashAdViewBuilder.e());
        QLog.i("GdtSplashManager", 1, "[show] container visibility" + viewGroup.getVisibility() + ", container shown:" + viewGroup.isShown() + "container window visibility:" + viewGroup.getWindowVisibility());
        TGSplashAD.SplashDisplayParams splashDisplayParams = new TGSplashAD.SplashDisplayParams();
        splashDisplayParams.bitmap = bitmap;
        splashDisplayParams.container = viewGroup;
        splashDisplayParams.firstFrameTimeout = (long) aVar.f109388d;
        splashDisplayParams.splashAd = preCacheSplashAd;
        this.f109334i.showAd(splashDisplayParams);
        this.f109326a.v();
        D(u.f109447b, this.f109326a.g(), false);
    }

    public void n() {
        QLog.i("GdtSplashManager", 1, "[clearCache]");
        GdtSplashPreloader.h();
        try {
            com.tencent.gdtad.splash.mcconfig.b.a();
        } catch (Throwable th5) {
            QLog.e("GdtSplashManager", 1, "[clearCache]", th5);
        }
        try {
            com.tencent.gdtad.splash.mcconfig.c.b();
        } catch (Throwable th6) {
            QLog.e("GdtSplashManager", 1, "[clearCache]", th6);
        }
        try {
            TGSplashPreCacheUtil.clearPreCacheData();
        } catch (Throwable th7) {
            QLog.e("GdtSplashManager", 1, "[clearCache]", th7);
        }
        try {
            TangramUtil.clearSplashCacheData(BaseApplication.getContext(), "9065538021425253");
        } catch (Throwable th8) {
            QLog.e("GdtSplashManager", 1, "[clearCache]", th8);
        }
        try {
            ((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).clearRealTimeSplashConfig();
        } catch (Throwable th9) {
            QLog.e("GdtSplashManager", 1, "[clearCache]", th9);
        }
    }

    public void o() {
        QLog.i("GdtSplashManager", 1, "[doAfterLoginAndMessageLoaded]");
        w();
        this.f109326a.a();
    }

    public void v() {
        QLog.i("GdtSplashManager", 1, "[onClosed]");
        this.f109326a.h();
        this.f109329d = null;
        this.f109330e = null;
        this.f109331f = null;
        TGSplashAD tGSplashAD = this.f109334i;
        if (tGSplashAD != null) {
            tGSplashAD.doRecycleBeforeSplashDismiss();
            this.f109334i = null;
        }
        TGSplashAD tGSplashAD2 = this.f109332g;
        if (tGSplashAD2 != null) {
            tGSplashAD2.doRecycleBeforeSplashDismiss();
            this.f109332g = null;
        }
        this.f109333h = null;
        this.f109335j = null;
        GlobalSetting.setiCustomAdDataGenerator(null);
    }

    public Object y(WeakReference<Activity> weakReference) {
        boolean z16;
        String str;
        p pVar;
        String str2;
        String str3;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        if (!com.tencent.gdtad.splash.mcconfig.a.e()) {
            QLog.e("GdtSplashManager", 1, "[prepare] error, not enabled");
            return null;
        }
        int a16 = u.a().a();
        if (a16 != 0) {
            QLog.e("GdtSplashManager", 1, "[prepare] error, canRun errorCode:" + a16);
            return null;
        }
        this.f109326a.o(currentTimeMillis);
        p m3 = m(weakReference);
        int a17 = m3.a();
        if (a17 != 0) {
            QLog.e("GdtSplashManager", 1, "[prepare] error, canPrepare errorCode:" + a17);
            this.f109326a.n(m3, false, null);
            return null;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        final TGSplashPreCacheResult preCacheOrderByCurrentTimeMinute = TGSplashPreCacheUtil.getPreCacheOrderByCurrentTimeMinute(BaseApplication.getContext(), "9065538021425253");
        com.tencent.gdtad.splash.statistics.c cVar = this.f109326a;
        if (preCacheOrderByCurrentTimeMinute != null && preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        cVar.m(z16, System.currentTimeMillis() - currentTimeMillis2);
        TGSplashPreCacheResult emptyOrderApUrlByDate = TGSplashPreCacheUtil.getEmptyOrderApUrlByDate("9065538021425253", TGSplashPreCacheUtil.getTodayDate());
        if (emptyOrderApUrlByDate.getPreCacheSplashAd() != null) {
            str = emptyOrderApUrlByDate.getPreCacheSplashAd().getApUrl();
        } else {
            str = null;
        }
        this.f109326a.A(str);
        if (emptyOrderApUrlByDate.getErrorCode() == 0) {
            pVar = new p(0);
        } else {
            pVar = new p(2000100, emptyOrderApUrlByDate.getErrorCode());
        }
        this.f109326a.q(pVar);
        if (preCacheOrderByCurrentTimeMinute != null && preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd() != null) {
            str2 = preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd().getAid();
        } else {
            str2 = null;
        }
        if (preCacheOrderByCurrentTimeMinute != null && preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd() != null) {
            str3 = preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd().getUoid();
        } else {
            str3 = null;
        }
        if (preCacheOrderByCurrentTimeMinute != null && preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd() != null && preCacheOrderByCurrentTimeMinute.getErrorCode() == 0) {
            int checkSrc = TGSplashPreCacheUtil.checkSrc(preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd());
            if (checkSrc != 0) {
                QLog.e("GdtSplashManager", 1, "[prepare] error, TGSplashPreCacheUtil.checkSrc failed, aid:" + str2 + " uoid:" + str3 + " emptyOrderReportUrl:" + str);
                this.f109326a.n(new p(2000013, checkSrc), true, str2);
                return null;
            }
            if (!r(preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd())) {
                QLog.e("GdtSplashManager", 1, "[prepare] error, invalid order, aid:" + str2 + " uoid:" + str3 + " emptyOrderReportUrl:" + str);
                this.f109326a.n(new p(2000014), true, str2);
                return null;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.GdtSplashManager.1
                @Override // java.lang.Runnable
                public void run() {
                    GdtSplashManager.this.f109326a.k(System.currentTimeMillis());
                    if (GdtSplashManager.this.f109329d == null) {
                        GdtSplashManager.this.f109329d = new b();
                    }
                    TGSplashPreCacheUtil.preloadAdImages(BaseApplication.getContext(), preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd(), new WeakReference(GdtSplashManager.this.f109329d));
                    GdtSplashManager.this.f109331f = new GdtSplashAdViewBuilder();
                    GdtSplashManager.this.f109331f.d();
                }
            }, 128, null, true);
            QLog.i("GdtSplashManager", 1, "[prepare] success, aid:" + str2 + " uoid:" + str3 + " emptyOrderReportUrl:" + str);
            this.f109326a.p(System.currentTimeMillis(), str2);
            u.h(System.currentTimeMillis());
            return preCacheOrderByCurrentTimeMinute.getPreCacheSplashAd();
        }
        QLog.e("GdtSplashManager", 1, "[prepare] error, has no valid order aid:" + str2 + " uoid:" + str3 + " emptyOrderReportUrl:" + str);
        com.tencent.gdtad.splash.statistics.c cVar2 = this.f109326a;
        if (preCacheOrderByCurrentTimeMinute != null) {
            i3 = preCacheOrderByCurrentTimeMinute.getErrorCode();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        cVar2.n(new p(2000012, i3), false, str2);
        return null;
    }

    public void z(WeakReference<Activity> weakReference, WeakReference<w> weakReference2) {
        Activity activity;
        long currentTimeMillis = System.currentTimeMillis();
        if (!com.tencent.gdtad.splash.mcconfig.a.e()) {
            QLog.e("GdtSplashManager", 1, "[realTimePrepare] error, not enabled");
            return;
        }
        int a16 = u.a().a();
        if (a16 != 0) {
            QLog.e("GdtSplashManager", 1, "[realTimePrepare] error, canRun errorCode:" + a16);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.GdtSplashManager.2
            @Override // java.lang.Runnable
            public void run() {
                GdtSplashManager.this.f109331f = new GdtSplashAdViewBuilder();
                GdtSplashManager.this.f109331f.d();
            }
        }, 128, null, true);
        this.f109326a.o(currentTimeMillis);
        p m3 = m(weakReference);
        int a17 = m3.a();
        if (a17 != 0) {
            QLog.e("GdtSplashManager", 1, "[realTimePrepare] error, canPrepare errorCode:" + a17);
            this.f109326a.n(m3, false, null);
            return;
        }
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity == null) {
            QLog.e("GdtSplashManager", 1, "[realTimePrepare] error, activity is null");
            this.f109326a.n(new p(2000001), false, null);
            return;
        }
        c cVar = new c();
        this.f109335j = cVar;
        cVar.f109338a = weakReference2;
        this.f109332g = new TGSplashAD(activity, null, "1109803375", "9065538021425253", cVar, (int) ((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashDelayTime(), null);
        GlobalSetting.setiCustomAdDataGenerator(new t(null));
        GdtSplashAdSwitchConfigParser.a b16 = com.tencent.gdtad.splash.mcconfig.a.b();
        if (b16 == null) {
            b16 = new GdtSplashAdSwitchConfigParser.a();
        }
        LoadAdParams loadAdParams = new LoadAdParams();
        loadAdParams.setBlackAidList(b16.f109389e);
        loadAdParams.setHotStart(false);
        loadAdParams.setCanDownloadSrcInRealtimeSelect(((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashDownloadRes());
        loadAdParams.setPassThroughInfo(u.c(true));
        this.f109332g.setLoadAdParams(loadAdParams);
        this.f109332g.fetchAdOnly();
        n nVar = n.f109392a;
        nVar.v();
        nVar.p();
        nVar.t();
        C(1316019);
        QLog.i("GdtSplashManager", 1, "[realTimePrepare] success:");
    }
}
