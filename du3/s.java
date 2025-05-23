package du3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.tencent.qqmini.container.core.aq;
import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.container.core.ba;
import com.tencent.qqmini.container.core.bb;
import com.tencent.qqmini.container.core.bd;
import com.tencent.qqmini.container.core.bn;
import com.tencent.qqmini.miniapp.util.V8Utils;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.utils.ContainerInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.smtt.sdk.X5JsCore;
import du3.s;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class s {

    /* renamed from: w, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static s f394902w;

    /* renamed from: a, reason: collision with root package name */
    private String f394903a;

    /* renamed from: b, reason: collision with root package name */
    private String f394904b;

    /* renamed from: c, reason: collision with root package name */
    private Context f394905c;

    /* renamed from: d, reason: collision with root package name */
    private ax f394906d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.qqmini.container.core.j f394907e;

    /* renamed from: f, reason: collision with root package name */
    private ApkgInfo f394908f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.qqmini.container.core.e f394909g;

    /* renamed from: h, reason: collision with root package name */
    private eu3.p f394910h;

    /* renamed from: k, reason: collision with root package name */
    private boolean f394913k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f394914l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f394915m;

    /* renamed from: q, reason: collision with root package name */
    private boolean f394919q;

    /* renamed from: r, reason: collision with root package name */
    private String f394920r;

    /* renamed from: u, reason: collision with root package name */
    private bb f394923u;

    /* renamed from: v, reason: collision with root package name */
    private MiniAppInfo f394924v;

    /* renamed from: j, reason: collision with root package name */
    private boolean f394912j = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f394916n = true;

    /* renamed from: o, reason: collision with root package name */
    private int f394917o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f394918p = 0;

    /* renamed from: s, reason: collision with root package name */
    private final aq f394921s = aq.e();

    /* renamed from: t, reason: collision with root package name */
    private final List<a> f394922t = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    private eu3.j f394911i = new eu3.b();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void a(boolean z16, String str);
    }

    s() {
    }

    private void A() {
        if (this.f394913k) {
            return;
        }
        QMLog.i("Mini-Container", "initAppEnv ");
        eu3.g.b("Mini-Container", "initAppEnv");
        Configuration build = new Configuration.Builder(this.f394905c).build();
        AppLoaderFactory.g().initFields(this.f394905c, build);
        MiniAppEnv.g().init(this.f394905c, build);
        this.f394913k = true;
        eu3.g.b("Mini-Container", "initAppEnv");
    }

    @WorkerThread
    private void B() {
        boolean z16;
        eu3.g.b("Mini-Container", "initJsService");
        QMLog.i("Mini-Container", "initJsService, isV8Enabled: " + this.f394914l + ", isX5Installed: " + this.f394915m);
        if (this.f394914l) {
            this.f394907e = new bd(this.f394906d);
            a0();
            return;
        }
        boolean z17 = true;
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !this.f394915m || !X5JsCore.canUseX5JsCore(this.f394905c)) {
            z17 = false;
        }
        QMLog.i("Mini-Container", "canUseX5JsService: " + z17);
        if (z17) {
            final bn bnVar = new bn(this.f394906d);
            bnVar.n(new bn.a() { // from class: du3.e
                @Override // com.tencent.qqmini.container.core.bn.a
                public final void a(boolean z18, String str) {
                    s.this.L(bnVar, z18, str);
                }
            });
        } else {
            eu3.f.i(new Runnable() { // from class: du3.f
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.M();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public BaselibLoader.BaselibContent C() {
        QMLog.i("Mini-Container", "initLibrary");
        eu3.g.b("Mini-Container", "initLibrary");
        BaselibLoader.BaselibContent b16 = eu3.c.b(this.f394905c, this.f394912j);
        eu3.g.b("Mini-Container", "initLibrary");
        BaseLibManager.g().updateBaseLib(new BaseLibManager.UpdateListener() { // from class: du3.d
            @Override // com.tencent.qqmini.sdk.manager.BaseLibManager.UpdateListener
            public final void onUpdateResult(int i3) {
                s.N(i3);
            }
        });
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public ax D() {
        QMLog.i("Mini-Container", "initRuntime");
        eu3.g.b("Mini-Container", "initRuntime");
        ax axVar = new ax(this.f394905c, this.f394909g, this.f394912j);
        axVar.Q(this.f394923u);
        axVar.D();
        eu3.g.b("Mini-Container", "initRuntime");
        return axVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        int i3;
        QMLog.i("Mini-Container", "initX5");
        eu3.g.b("Mini-Container", "initX5");
        eu3.j jVar = this.f394911i;
        if (jVar != null && this.f394915m) {
            Context context = this.f394905c;
            if (this.f394914l) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            jVar.initX5(context, i3);
        }
        eu3.g.b("Mini-Container", "initX5");
        return true;
    }

    private boolean F() {
        boolean z16;
        boolean z17 = false;
        if (this.f394905c != null && (this.f394903a != null || this.f394924v != null)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("base config is invalid, context is null :");
            if (this.f394905c == null) {
                z17 = true;
            }
            sb5.append(z17);
            sb5.append(",appId is ");
            sb5.append(this.f394903a);
            QMLog.w("Mini-Container", sb5.toString());
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        boolean z16;
        eu3.p pVar;
        boolean z17 = true;
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.f394916n || !z16 || !V8Utils.isEnabled()) {
            z17 = false;
        }
        this.f394914l = z17;
        this.f394915m = com.tencent.qqmini.sdk.utils.e.a(this.f394905c);
        final Future l3 = eu3.f.l(new Callable() { // from class: du3.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                boolean E;
                E = s.this.E();
                return Boolean.valueOf(E);
            }
        });
        final Future l16 = eu3.f.l(new Callable() { // from class: du3.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ax D;
                D = s.this.D();
                return D;
            }
        });
        final Future l17 = eu3.f.l(new Callable() { // from class: du3.r
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BaselibLoader.BaselibContent C;
                C = s.this.C();
                return C;
            }
        });
        eu3.f.h(new Runnable() { // from class: du3.b
            @Override // java.lang.Runnable
            public final void run() {
                s.this.P(l3, l16, l17);
            }
        });
        if (!this.f394915m && (pVar = this.f394910h) != null) {
            pVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(bn bnVar, boolean z16, String str) {
        if (z16) {
            this.f394907e = bnVar;
            a0();
        } else {
            eu3.f.i(new Runnable() { // from class: du3.i
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.U();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f394907e = new ba(this.f394906d);
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(int i3) {
        QMLog.i("Mini-Container", "updateBaseLib, ret=" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        QMLog.i("Mini-Container", "load package");
        aq.b bVar = new aq.b() { // from class: du3.o
            @Override // com.tencent.qqmini.container.core.aq.b
            public final void a(boolean z16, String str, ApkgInfo apkgInfo) {
                s.this.R(z16, str, apkgInfo);
            }
        };
        if (this.f394924v != null) {
            QMLog.d("Mini-Container", "load appInfo:" + this.f394924v.toString());
            this.f394924v.setIsLoadByContainer(((ConfigProxy) ProxyManager.get(ConfigProxy.class)).isloadByContainer());
            this.f394921s.k(this.f394924v, bVar);
            return;
        }
        QMLog.d("Mini-Container", "load appId:" + this.f394903a);
        this.f394921s.j(this.f394903a, this.f394904b, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(Future future, Future future2, Future future3) {
        try {
            boolean booleanValue = ((Boolean) future.get()).booleanValue();
            this.f394906d = (ax) future2.get();
            ((BaseRuntimeImpl.BaselibProvider) this.f394906d.getManager(BaseRuntimeImpl.BaselibProvider.class)).setBaseLib((BaselibLoader.BaselibContent) future3.get());
            QMLog.i("Mini-Container", "isX5Ready: " + booleanValue);
            B();
        } catch (Exception e16) {
            QMLog.i("Mini-Container", "initContainerException", e16);
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(String str, boolean z16) {
        int i3;
        this.f394920r = str;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        this.f394918p = i3;
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(final boolean z16, final String str, ApkgInfo apkgInfo) {
        QMLog.i("Mini-Container", "loadPackage finish, success: " + z16 + ", message: " + str);
        eu3.g.b("Mini-Container", "load");
        if (z16) {
            m0(apkgInfo);
        }
        eu3.f.f(new Runnable() { // from class: du3.c
            @Override // java.lang.Runnable
            public final void run() {
                s.this.Q(str, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S(a aVar) {
        if (aVar != null) {
            aVar.a(false, "context or appId is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(a aVar) {
        if (aVar != null) {
            aVar.a(true, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f394907e = new ba(this.f394906d);
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        this.f394917o = 2;
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(String str, String str2, Map map, boolean z16, String str3, MiniAppInfo miniAppInfo) {
        if (z16 && miniAppInfo != null) {
            PreCacheManager.g().fetchContainerPreFetchData(miniAppInfo, str, str2, map);
            return;
        }
        QMLog.i("Mini-Container", "prefetchDataWithPagePath loadContainerAppInfo error " + str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(final a aVar) {
        if (this.f394917o == 0 && this.f394918p == 0) {
            eu3.g.b("Mini-Container", "prepare");
        }
        if (F()) {
            QMLog.e("Mini-Container", "prepare fail because base config is invalid");
            eu3.f.i(new Runnable() { // from class: du3.k
                @Override // java.lang.Runnable
                public final void run() {
                    s.S(s.a.this);
                }
            });
        } else {
            if (this.f394919q) {
                eu3.f.i(new Runnable() { // from class: du3.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.T(s.a.this);
                    }
                });
                return;
            }
            QMLog.i("Mini-Container", "container prepare");
            if (aVar != null) {
                this.f394922t.add(aVar);
            }
            z();
            Z();
        }
    }

    private void Z() {
        int i3 = this.f394918p;
        if (i3 == 0 || i3 == 3) {
            this.f394918p = 1;
            this.f394920r = "";
            A();
            eu3.g.b("Mini-Container", "load");
            eu3.f.h(new Runnable() { // from class: du3.n
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.O();
                }
            });
        }
    }

    private void a0() {
        QMLog.i("Mini-Container", "onJsServiceCreated, service: " + this.f394907e);
        eu3.g.b("Mini-Container", "initJsService");
        this.f394906d.N(this.f394907e);
        this.f394906d.h();
        this.f394906d.i();
        eu3.g.b("Mini-Container", "init");
        eu3.f.f(new Runnable() { // from class: du3.g
            @Override // java.lang.Runnable
            public final void run() {
                s.this.V();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public synchronized void J(boolean z16) {
        ax axVar = this.f394906d;
        if (axVar == null) {
            return;
        }
        if (z16) {
            axVar.m();
        }
        Iterator<a> it = this.f394922t.iterator();
        while (it.hasNext()) {
            it.next().a(z16, this.f394920r);
        }
        this.f394922t.clear();
    }

    private void m0(ApkgInfo apkgInfo) {
        if (apkgInfo == null) {
            return;
        }
        this.f394908f = apkgInfo;
        if (apkgInfo.mMiniAppInfo == null) {
            apkgInfo.mMiniAppInfo = new MiniAppInfo();
            this.f394908f.mMiniAppInfo.appId = this.f394903a;
        }
        MiniAppInfo miniAppInfo = this.f394908f.mMiniAppInfo;
        miniAppInfo.apkgInfo = apkgInfo;
        try {
            AppBrandUtil.updateAppLaunchInfoForApkgInfo(miniAppInfo);
            PreCacheManager.g().fetchPreCacheData(miniAppInfo);
            PreCacheManager.g().fetchPreResourceIfNeed(miniAppInfo);
            PreCacheManager.g().fetchContainerPreFetchData(miniAppInfo, null, null, null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private synchronized void s() {
        int i3;
        final boolean z16;
        if (this.f394919q) {
            return;
        }
        QMLog.i("Mini-Container", "checkReady, initState: " + this.f394917o + ", loadState: " + this.f394918p + ", thread: " + Thread.currentThread());
        if (this.f394917o == 2 && ((i3 = this.f394918p) == 2 || i3 == 3)) {
            if (i3 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f394906d.P(this.f394908f);
                this.f394906d.onRuntimeCreate();
                this.f394906d.j();
                ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                if (channelProxy != null) {
                    channelProxy.onInitFinish();
                }
                eu3.g.b("Mini-Container", "prepare");
            }
            this.f394919q = z16;
            eu3.f.i(new Runnable() { // from class: du3.h
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.J(z16);
                }
            });
        }
    }

    public static synchronized s x() {
        s sVar;
        synchronized (s.class) {
            if (f394902w == null) {
                f394902w = new s();
            }
            sVar = f394902w;
        }
        return sVar;
    }

    private void z() {
        QMLog.i("Mini-Container", "initContainer, initState:" + this.f394917o);
        if (this.f394917o == 0) {
            this.f394917o = 1;
            A();
            eu3.g.b("Mini-Container", "init");
            eu3.f.h(new Runnable() { // from class: du3.m
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.K();
                }
            });
        }
    }

    public boolean G() {
        return this.f394912j;
    }

    public boolean H() {
        if (this.f394917o == 1 || this.f394918p == 1) {
            return true;
        }
        return false;
    }

    public boolean I() {
        return this.f394919q;
    }

    public void Y(Context context, String str) {
        if (F()) {
            QMLog.e("Mini-Container", "launchPage but base config invalid");
            return;
        }
        ax axVar = this.f394906d;
        if (axVar != null && axVar.v() != null) {
            this.f394906d.C(str);
            return;
        }
        com.tencent.qqmini.container.core.e eVar = this.f394909g;
        if (eVar != null) {
            eVar.launchPage(context, str);
        }
    }

    public void c0(final String str, final String str2, final Map<String, String> map) {
        QMLog.i("Mini-Container", "prefetchDataWithPagePath page path: " + str + " ,extraQuery: " + str2);
        if (this.f394924v != null) {
            PreCacheManager.g().fetchContainerPreFetchData(this.f394924v, str, str2, map);
        } else if (TextUtils.isEmpty(this.f394903a)) {
            QMLog.e("Mini-Container", "prefetchDataWithPagePath error, please set appId first!");
        } else {
            this.f394921s.i(this.f394903a, "", "release", new aq.a() { // from class: du3.j
                @Override // com.tencent.qqmini.container.core.aq.a
                public final void a(boolean z16, String str3, MiniAppInfo miniAppInfo) {
                    s.W(str, str2, map, z16, str3, miniAppInfo);
                }
            });
        }
    }

    public void d0() {
        e0(null);
    }

    public void e0(final a aVar) {
        eu3.f.f(new Runnable() { // from class: du3.a
            @Override // java.lang.Runnable
            public final void run() {
                s.this.X(aVar);
            }
        });
    }

    public synchronized s f0() {
        this.f394919q = false;
        this.f394903a = null;
        this.f394924v = null;
        this.f394904b = null;
        this.f394905c = null;
        this.f394907e = null;
        this.f394908f = null;
        this.f394917o = 0;
        this.f394918p = 0;
        this.f394920r = null;
        this.f394922t.clear();
        ax axVar = this.f394906d;
        if (axVar != null) {
            axVar.onRuntimeDestroy();
            this.f394906d = null;
        }
        ContainerInfo.appId = null;
        return this;
    }

    public s g0(String str) {
        ContainerInfo.appId = str;
        this.f394903a = str;
        return this;
    }

    public s h0(MiniAppInfo miniAppInfo) {
        this.f394924v = miniAppInfo;
        if (miniAppInfo != null) {
            ContainerInfo.appId = miniAppInfo.appId;
        }
        return this;
    }

    public s i0(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f394905c = applicationContext;
        this.f394910h = new eu3.p(applicationContext);
        com.tencent.qqmini.container.core.k.d().b(context);
        return this;
    }

    public s j0(boolean z16) {
        this.f394912j = z16;
        return this;
    }

    public s k0(com.tencent.qqmini.container.core.e eVar) {
        this.f394909g = eVar;
        return this;
    }

    public void l0(com.tencent.qqmini.container.core.d dVar) {
        ax axVar = this.f394906d;
        if (axVar == null) {
            QMLog.e("Mini-Container", "setNavigator error, runtime is null!");
        } else {
            axVar.O(dVar);
        }
    }

    public s n0(bb bbVar) {
        this.f394923u = bbVar;
        return this;
    }

    public s o0(eu3.j jVar) {
        this.f394911i = jVar;
        return this;
    }

    public void t() {
        ax axVar = this.f394906d;
        if (axVar == null) {
            QMLog.e("Mini-Container", "checkUpdate but runtime is not ready yet");
        } else {
            axVar.f();
        }
    }

    public void u(String str, Map<String, ?> map) {
        v(str, map, 0);
    }

    public void v(String str, Map<String, ?> map, int i3) {
        String str2;
        if (I()) {
            com.tencent.qqmini.container.core.j jVar = this.f394907e;
            if (map != null) {
                str2 = new JSONObject(map).toString();
            } else {
                str2 = "{}";
            }
            jVar.evaluateSubscribeJS(str, str2, i3);
        }
        if (this.f394917o != 0 && this.f394918p != 0) {
            QMLog.d("Mini-Container", "dispatchServiceEvent failed, initState:" + this.f394917o + ", loadState: " + this.f394918p);
        }
    }

    public void w() {
        com.tencent.qqmini.container.core.j jVar = this.f394907e;
        if (jVar != null) {
            jVar.f();
        }
    }

    public ax y() {
        return this.f394906d;
    }
}
