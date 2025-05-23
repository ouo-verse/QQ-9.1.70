package com.tencent.gdtad.basics.motivevideo.hippy;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ams.dsdk.core.DKBaseCustomAbilityProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEngine;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.dynamic.IDynamicApi;
import com.tencent.gdtad.basics.motivevideo.hippy.i;
import com.tencent.gdtad.basics.motivevideo.hippy.method.GdtMotiveHippyVideoHandler;
import com.tencent.gdtad.basics.motivevideo.hippy.method.b;
import com.tencent.gdtad.basics.motivevideo.hippy.video.GdtMotiveHippyVideoView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.gdtad.basics.motivevideo.hippy.method.b f108990c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.gdtad.basics.motivevideo.hippy.method.a f108991d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.gdtad.basics.motivevideo.hippy.method.c f108992e;

    /* renamed from: f, reason: collision with root package name */
    private GdtMotiveHippyVideoHandler f108993f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<om0.b> f108994g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<om0.a> f108995h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<om0.c> f108996i;

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<com.tencent.gdtad.basics.motivevideo.hippy.video.a> f108997j;

    /* renamed from: l, reason: collision with root package name */
    private volatile String f108999l;

    /* renamed from: a, reason: collision with root package name */
    private volatile DKHippyEngine f108988a = null;

    /* renamed from: b, reason: collision with root package name */
    private volatile View f108989b = null;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f108998k = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public final class a implements DKEngine.OnCreateEngineListener {

        /* renamed from: a, reason: collision with root package name */
        private DKHippyEngine f109000a;

        /* renamed from: b, reason: collision with root package name */
        private final c f109001b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.gdtad.basics.motivevideo.hippy.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1155a extends DKBaseCustomAbilityProvider {
            C1155a() {
            }

            @Override // com.tencent.ams.dsdk.core.DKBaseCustomAbilityProvider, com.tencent.ams.dsdk.core.DKCustomAbilityProvider
            public DKVideoPlayer getDKVideoPlayer(Context context) {
                QLog.i("GdtMotiveHippyEngine ", 1, "[DKEngineCreateEngineListener][onEngineInitialized] setCustomAbilityProvider.");
                return new GdtMotiveHippyVideoView(context, i.this.f108997j);
            }
        }

        a(DKHippyEngine dKHippyEngine, c cVar) {
            this.f109000a = dKHippyEngine;
            this.f109001b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Map map) {
            try {
                Activity activity = this.f109001b.f109005a.get();
                DKEngine.CreateViewInfo createViewInfo = new DKEngine.CreateViewInfo();
                createViewInfo.context = activity;
                createViewInfo.container = i.this.f108989b;
                createViewInfo.params = map;
                createViewInfo.onViewCreateListener = new b();
                i.this.f108988a.createView(createViewInfo);
            } catch (Throwable th5) {
                QLog.e("GdtMotiveHippyEngine ", 1, "[DKEngineCreateEngineListener][onEngineInitialized] create view", th5);
                i.this.d0(15, Integer.MIN_VALUE);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            final HashMap hashMap = new HashMap();
            hashMap.put(DKEngine.PARAM_KEY_APP_NAME, DKEngine.DKModuleID.PCAD_REWARD);
            hashMap.put(DKEngine.PARAM_KEY_AD_TYPE, "1");
            hashMap.put(DKEngine.PARAM_KEY_TEMPLATE_ID, this.f109001b.f109006b);
            DKHippyEngine dKHippyEngine = this.f109000a;
            if (dKHippyEngine != null) {
                dKHippyEngine.setCustomAbilityProvider(new C1155a());
            }
            i.this.f108988a = this.f109000a;
            this.f109000a = null;
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.a.this.c(hashMap);
                }
            }, 0);
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitializeError(int i3) {
            QLog.e("GdtMotiveHippyEngine ", 1, "[DKEngineCreateEngineListener][onEngineInitializeError] errorCode:" + i3);
            i.this.f0(i.J(i3), i3);
            i.this.f108988a = null;
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitialized() {
            c cVar = this.f109001b;
            if (cVar != null && cVar.a()) {
                QLog.i("GdtMotiveHippyEngine ", 1, "[DKEngineCreateEngineListener][onEngineInitialized]");
                i.this.g0();
                AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.a.this.d();
                    }
                }, 5);
            } else {
                QLog.e("GdtMotiveHippyEngine ", 1, "[DKEngineCreateEngineListener][onEngineInitialized] error, not valid");
                i.this.a0(4);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onWillCreateEngine() {
            if (this.f109000a == null) {
                QLog.e("GdtMotiveHippyEngine ", 1, "[DKEngineCreateEngineListener][onWillCreateEngine] error, mUninitializedEngine is null");
                return;
            }
            QLog.i("GdtMotiveHippyEngine ", 1, "[DKEngineCreateEngineListener][onWillCreateEngine]");
            try {
                i.this.f108999l = this.f109000a.getBundleVersion();
                HippyEngine.EngineInitParams initParams = this.f109000a.getInitParams();
                if (initParams != null) {
                    initParams.enableLog = false;
                    initParams.imageLoader = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createImageLoader();
                }
            } catch (Throwable th5) {
                QLog.e("GdtMotiveHippyEngine ", 1, "[DKEngineCreateEngineListener][onWillCreateEngine]", th5);
            }
            i.this.k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public final class b implements DKEngine.OnViewCreateListener {
        b() {
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public boolean onInterceptViewCreate(View view, int i3, Runnable runnable) {
            QLog.i("GdtMotiveHippyEngine ", 1, "[DKViewCreateListener][onInterceptViewCreate] errorCode:" + i3);
            return false;
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewCreate(View view, int i3) {
            QLog.i("GdtMotiveHippyEngine ", 1, "[DKViewCreateListener][onViewCreate] view: " + view + " errorCode: " + i3);
            if (i3 != 9000 || i.this.f108995h == null) {
                i.this.d0(i.I(i3), i3);
            } else {
                i.this.f108989b = view;
                i.this.e0(view);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewCreateStart() {
            GdtLog.i("GdtMotiveHippyEngine ", "[onViewCreateStart]");
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewInitializeError(int i3) {
            QLog.e("GdtMotiveHippyEngine ", 1, "[DKViewCreateListener][onViewInitializeError] errorCode: " + i3);
            i.this.h0(1, i3);
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewInitialized() {
            QLog.i("GdtMotiveHippyEngine ", 1, "[DKViewCreateListener][onViewInitialized]");
            i.this.i0();
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnViewCreateListener
        public void onViewLoadComplete() {
            QLog.i("GdtMotiveHippyEngine ", 1, "[DKViewCreateListener][onViewLoadComplete]");
            i.this.j0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<Activity> f109005a;

        /* renamed from: b, reason: collision with root package name */
        public String f109006b;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<om0.b> f109007c;

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<om0.a> f109008d;

        /* renamed from: e, reason: collision with root package name */
        public WeakReference<com.tencent.gdtad.basics.motivevideo.hippy.video.a> f109009e;

        public boolean a() {
            WeakReference<Activity> weakReference = this.f109005a;
            if (weakReference != null && weakReference.get() != null && !TextUtils.isEmpty(this.f109006b)) {
                return true;
            }
            return false;
        }
    }

    public i() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[constructor] thread: ");
        sb5.append(Thread.currentThread());
        sb5.append(", isMainThread: ");
        sb5.append(Looper.getMainLooper() == Looper.myLooper());
        QLog.i("GdtMotiveHippyEngine ", 1, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int I(int i3) {
        if (i3 == 9000) {
            return 0;
        }
        if (i3 != 9004 && i3 != 9003 && i3 != 9005) {
            if (i3 == 9006) {
                return 16;
            }
            if (i3 == 9007) {
                return 15;
            }
            return 1;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int J(int i3) {
        if (i3 != 0 && i3 != HippyEngine.EngineInitStatus.STATUS_OK.value()) {
            if (i3 == 1) {
                return 16;
            }
            if (i3 != 2 && i3 != HippyEngine.EngineInitStatus.STATUS_INIT_EXCEPTION.value()) {
                if (i3 != HippyEngine.EngineInitStatus.STATUS_ERR_BRIDGE.value() && i3 != HippyEngine.EngineInitStatus.STATUS_ERR_DEVSERVER.value()) {
                    HippyEngine.EngineInitStatus.STATUS_WRONG_STATE.value();
                }
                return 1;
            }
            return 15;
        }
        return 0;
    }

    public static String K() {
        com.tencent.gdtad.config.data.g h16 = wm0.b.m().h();
        if (h16 == null) {
            QLog.e("GdtMotiveHippyEngine ", 1, "[getJSBundleVersion] error, config is null");
            return null;
        }
        n0(h16.updateJsBundleIntervalSeconds);
        return pm0.b.c().b();
    }

    public static String L() {
        com.tencent.gdtad.config.data.g h16 = wm0.b.m().h();
        if (h16 == null) {
            QLog.e("GdtMotiveHippyEngine ", 1, "[getJsBundleInfo] error, config is null");
            return null;
        }
        n0(h16.updateJsBundleIntervalSeconds);
        String b16 = pm0.b.c().b();
        if (!TextUtils.isEmpty(b16)) {
            JSONObject newJSONObject = AdJSONUtil.newJSONObject();
            AdJSONUtil.put(newJSONObject, DKEngine.DKModuleID.PCAD_REWARD, b16);
            String adJSONUtil = AdJSONUtil.toString(newJSONObject);
            QLog.i("GdtMotiveHippyEngine ", 1, "[getJsBundleInfo] result:" + adJSONUtil);
            return adJSONUtil;
        }
        QLog.i("GdtMotiveHippyEngine ", 1, "[getJsBundleInfo] result is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(int i3) {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.a(i3);
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(int i3, int i16) {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.h(i3, i16);
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.c(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(int i3, int i16) {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.f(i3, i16);
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(int i3, int i16) {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.b(i3, i16);
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        om0.b bVar;
        WeakReference<om0.b> weakReference = this.f108994g;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.onWillCreateEngine();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.d
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.c0();
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(final int i3) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.p
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.N(i3);
            }
        }, 0);
    }

    private void b0() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.q
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.O();
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.j
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.P();
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(final int i3, final int i16) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.i
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.Q(i3, i16);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(final View view) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.n
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.R(view);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(final int i3, final int i16) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.h
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.S(i3, i16);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.f
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.T();
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(final int i3, final int i16) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.l
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.U(i3, i16);
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.k
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.V();
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.m
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.W();
            }
        }, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.g
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.gdtad.basics.motivevideo.hippy.i.this.X();
            }
        }, 0);
    }

    private void l0(DKHippyEngine dKHippyEngine) {
        if (dKHippyEngine != null) {
            this.f108991d = new com.tencent.gdtad.basics.motivevideo.hippy.method.a(this.f108995h);
            this.f108990c = new com.tencent.gdtad.basics.motivevideo.hippy.method.b(this.f108995h, new b.a() { // from class: mm0.e
                @Override // com.tencent.gdtad.basics.motivevideo.hippy.method.b.a
                public final void a() {
                    com.tencent.gdtad.basics.motivevideo.hippy.i.this.Y();
                }
            });
            this.f108992e = new com.tencent.gdtad.basics.motivevideo.hippy.method.c();
            this.f108993f = new GdtMotiveHippyVideoHandler(this.f108996i);
            dKHippyEngine.registerMethodHandler(this.f108991d);
            dKHippyEngine.registerMethodHandler(this.f108990c);
            dKHippyEngine.registerMethodHandler(this.f108992e);
            dKHippyEngine.registerMethodHandler(this.f108993f);
        }
    }

    private static void n0(int i3) {
        QLog.i("GdtMotiveHippyEngine ", 1, "[setUpdateIntervalSeconds] timeInterval:" + i3);
        pm0.b.c().e((long) i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void Z(c cVar) {
        if (cVar != null && cVar.a()) {
            if (this.f108988a != null) {
                QLog.i("GdtMotiveHippyEngine ", 1, "[showHippyView] do nothing, mEngine exits.");
                return;
            }
            b0();
            try {
                ((IDynamicApi) QRoute.api(IDynamicApi.class)).setGlobalParams();
            } catch (Throwable th5) {
                QLog.e("GdtMotiveHippyEngine ", 1, "[showHippyView]", th5);
            }
            QLog.i("GdtMotiveHippyEngine ", 1, "[showHippyView]");
            DKHippyEngine dKHippyEngine = new DKHippyEngine();
            l0(dKHippyEngine);
            HashMap hashMap = new HashMap();
            hashMap.put(DKEngine.PARAM_KEY_APP_NAME, DKEngine.DKModuleID.PCAD_REWARD);
            try {
                QLog.i("GdtMotiveHippyEngine ", 1, "[showHippyView] create engine");
                dKHippyEngine.createEngine(cVar.f109005a.get(), hashMap, new a(dKHippyEngine, cVar));
                return;
            } catch (Throwable th6) {
                QLog.e("GdtMotiveHippyEngine ", 1, "[showHippyView] create engine", th6);
                this.f108988a = null;
                return;
            }
        }
        QLog.e("GdtMotiveHippyEngine ", 1, "[showHippyView] error, activity is null or data is inValid");
        a0(4);
    }

    private void s0(DKHippyEngine dKHippyEngine) {
        if (dKHippyEngine != null) {
            dKHippyEngine.unregisterMethodHandler(this.f108992e);
            dKHippyEngine.unregisterMethodHandler(this.f108991d);
            dKHippyEngine.unregisterMethodHandler(this.f108990c);
            dKHippyEngine.unregisterMethodHandler(this.f108993f);
        }
    }

    public void G() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[destroy] mEngine:");
        if (this.f108988a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("GdtMotiveHippyEngine ", 1, sb5.toString());
        this.f108995h = null;
        this.f108994g = null;
        DKHippyEngine dKHippyEngine = this.f108988a;
        if (dKHippyEngine != null) {
            s0(dKHippyEngine);
            dKHippyEngine.onDestroy();
        }
        this.f108999l = null;
        this.f108988a = null;
        this.f108989b = null;
    }

    public String H() {
        return this.f108999l;
    }

    public View M() {
        return this.f108989b;
    }

    public void m0() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[resume] mEngine:");
        if (this.f108988a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("GdtMotiveHippyEngine ", 1, sb5.toString());
        DKHippyEngine dKHippyEngine = this.f108988a;
        if (dKHippyEngine != null) {
            dKHippyEngine.onResume();
        }
    }

    public void o0(WeakReference<om0.c> weakReference) {
        this.f108996i = weakReference;
    }

    public void p0(final c cVar) {
        if (cVar != null && cVar.a()) {
            if (this.f108998k) {
                QLog.e("GdtMotiveHippyEngine ", 1, "[show] error, too frequently");
                a0(2);
                return;
            }
            QLog.i("GdtMotiveHippyEngine ", 1, "[show]");
            this.f108998k = true;
            this.f108994g = cVar.f109007c;
            this.f108995h = cVar.f109008d;
            this.f108997j = cVar.f109009e;
            AdThreadManager.getInstance().post(new Runnable() { // from class: mm0.o
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.gdtad.basics.motivevideo.hippy.i.this.Z(cVar);
                }
            }, 5);
            return;
        }
        QLog.e("GdtMotiveHippyEngine ", 1, "[show] error, not valid");
        a0(4);
    }

    public void r0() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[stop] mEngine:");
        if (this.f108988a != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i("GdtMotiveHippyEngine ", 1, sb5.toString());
        DKHippyEngine dKHippyEngine = this.f108988a;
        if (dKHippyEngine != null) {
            dKHippyEngine.onStop();
        }
    }
}
