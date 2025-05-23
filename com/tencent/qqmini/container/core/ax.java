package com.tencent.qqmini.container.core;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManagerFaker;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.qqmini.sdk.task.MiniAppSoLoader;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ax extends BaseRuntime {
    private final Map<Integer, MiniView> C;
    private final Map<Integer, MiniWebView> D;
    private final Map<String, Set<MiniView>> E;
    private final Map<Integer, NativeContainer> F;
    private final k G;
    private final MiniAppWorkerManager H;
    private final bh I;
    private boolean J;
    private j K;
    private ApkgInfo L;
    private MiniWebView M;
    private bb N;
    private boolean P = false;
    private d Q;

    /* renamed from: d, reason: collision with root package name */
    private final Context f346067d;

    /* renamed from: e, reason: collision with root package name */
    private final e f346068e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f346069f;

    /* renamed from: h, reason: collision with root package name */
    private final c f346070h;

    /* renamed from: i, reason: collision with root package name */
    private final h f346071i;

    /* renamed from: m, reason: collision with root package name */
    private final Set<String> f346072m;

    public ax(Context context, e eVar, boolean z16) {
        this.f346067d = context;
        this.f346068e = eVar;
        this.f346069f = z16;
        MiniAppFileManager miniAppFileManager = new MiniAppFileManager();
        this.mManagerMap.put(MiniAppFileManager.class, miniAppFileManager);
        this.mManagerMap.put(IMiniAppFileManager.class, miniAppFileManager);
        this.mManagerMap.put(BaseRuntimeImpl.BaselibProvider.class, new BaseRuntimeImpl.BaselibProvider());
        this.mManagerMap.put(MiniAppRealTimeLogReporter.class, new MiniAppRealTimeLogReporter());
        this.mManagerMap.put(ObserverManager.class, new ObserverManager());
        this.mManagerMap.put(IActivityResultManager.class, new ActivityResultManagerFaker());
        this.G = k.d();
        this.f346071i = new h(context);
        this.H = new MiniAppWorkerManager(this);
        this.f346070h = new c(this);
        this.C = new ConcurrentHashMap();
        this.D = new ConcurrentHashMap();
        this.F = new ConcurrentHashMap();
        this.f346072m = new CopyOnWriteArraySet();
        this.I = new bh(this);
        this.E = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(boolean[] zArr, l lVar) {
        if (!zArr[0]) {
            zArr[0] = true;
            lVar.onLoaded(5, "timeout");
            QMLog.d("Mini-Runtime", "preloadWebView time out");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(boolean[] zArr, l lVar) {
        if (!zArr[0]) {
            zArr[0] = true;
            lVar.onLoaded(0, "");
            QMLog.d("Mini-Runtime", "preloadWebView on dom ready");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(final String str) {
        M(str, 300L, new l() { // from class: com.tencent.qqmini.container.core.at
            @Override // com.tencent.qqmini.container.core.l
            public final void onLoaded(int i3, String str2) {
                ax.this.y(str, i3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str, int i3, String str2) {
        QMLog.d("Mini-Runtime", "preloadWebView finish, code: " + i3 + ", message: " + str2);
        Context attachedActivity = getAttachedActivity();
        if (attachedActivity == null) {
            attachedActivity = getContext();
        }
        d dVar = this.Q;
        if (dVar != null && dVar.navigateTo(str)) {
            QMLog.d("Mini-Runtime", "navigate by business, path " + str);
            return;
        }
        e eVar = this.f346068e;
        if (eVar != null) {
            eVar.launchPage(attachedActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        MiniWebView miniWebView = this.M;
        if (miniWebView != null) {
            miniWebView.destroy();
        }
    }

    public void C(final String str) {
        QMLog.d("Mini-Runtime", "launchPage:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.ar
            @Override // java.lang.Runnable
            public final void run() {
                ax.this.x(str);
            }
        });
    }

    @WorkerThread
    public void D() {
        if (QUAUtil.isQQApp()) {
            return;
        }
        MiniAppSoLoader.g().loadAllMiniSo();
    }

    public boolean E() {
        d dVar = this.Q;
        if (dVar != null && dVar.navigateBack()) {
            QMLog.d("Mini-Runtime", "navigate back by business");
            return true;
        }
        return false;
    }

    public void F() {
        if (this.N == null) {
            QMLog.e("Mini-Runtime", "notifyApplyUpdate but no listener");
        } else {
            QMLog.i("Mini-Runtime", "notifyApplyUpdate");
            this.N.a();
        }
    }

    public void G(NativeContainer nativeContainer) {
        this.F.put(Integer.valueOf(nativeContainer.w()), nativeContainer);
    }

    public void H(NativeContainer nativeContainer) {
        this.F.remove(Integer.valueOf(nativeContainer.w()));
    }

    public void I(MiniView miniView) {
        this.C.put(Integer.valueOf(miniView.k()), miniView);
        Context context = miniView.getContext();
        if (context instanceof Activity) {
            this.G.e((Activity) context);
        }
        String rootPath = this.L.getRootPath(miniView.j());
        if (this.E.containsKey(rootPath)) {
            this.E.get(rootPath).add(miniView);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(miniView);
        this.E.put(rootPath, hashSet);
    }

    public void J(MiniView miniView) {
        this.C.remove(Integer.valueOf(miniView.k()));
        String rootPath = this.L.getRootPath(miniView.j());
        if (this.E.containsKey(rootPath)) {
            this.E.get(rootPath).remove(miniView);
        }
    }

    public void K(MiniWebView miniWebView) {
        this.D.put(Integer.valueOf(miniWebView.J()), miniWebView);
    }

    public void L(MiniWebView miniWebView) {
        this.D.remove(Integer.valueOf(miniWebView.J()));
    }

    @UiThread
    public void M(String str, long j3, final l lVar) {
        QMLog.d("Mini-Runtime", "preloadWebView");
        this.M = n();
        final boolean[] zArr = new boolean[1];
        Runnable runnable = new Runnable() { // from class: com.tencent.qqmini.container.core.au
            @Override // java.lang.Runnable
            public final void run() {
                ax.A(zArr, lVar);
            }
        };
        this.M.B(new MiniWebView.c() { // from class: com.tencent.qqmini.container.core.av
            @Override // com.tencent.qqmini.container.core.MiniWebView.c
            public final void a() {
                ax.B(zArr, lVar);
            }
        });
        eu3.f.e(runnable, j3);
        this.M.c0(str);
    }

    public void N(j jVar) {
        this.K = jVar;
        jVar.h(this.f346070h);
    }

    public void O(d dVar) {
        this.Q = dVar;
    }

    public void P(ApkgInfo apkgInfo) {
        this.L = apkgInfo;
        ((MiniAppFileManager) getManager(MiniAppFileManager.class)).initFileManager(apkgInfo, false);
    }

    public void Q(bb bbVar) {
        this.N = bbVar;
    }

    public void R(String str) {
        MiniAppInfo d16 = aq.e().d(getMiniAppInfo().appId, "");
        if (d16 == null) {
            return;
        }
        try {
            QMLog.i("Mini-Runtime", "updateAppjson:" + d16.appJson);
            if (!TextUtils.isEmpty(d16.appJson)) {
                ApkgInfo apkgInfo = this.L;
                apkgInfo.mAppConfigInfo = apkgInfo.parseConfig(d16.appJson);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        List<SubPkgInfo> list = d16.subpkgs;
        boolean z16 = false;
        SubPkgInfo subPkgInfo = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (TextUtils.equals(list.get(i3).subPkgName, str)) {
                subPkgInfo = list.get(i3);
            }
        }
        if (subPkgInfo == null) {
            return;
        }
        List<SubPkgInfo> list2 = getMiniAppInfo().subpkgs;
        if (list2 != null && list2.size() >= 0) {
            int i16 = 0;
            while (true) {
                if (i16 >= list2.size()) {
                    break;
                }
                if (TextUtils.equals(list2.get(i16).subPkgName, subPkgInfo.subPkgName)) {
                    list2.remove(i16);
                    list2.add(subPkgInfo);
                    z16 = true;
                    break;
                }
                i16++;
            }
            if (!z16) {
                list2.add(subPkgInfo);
            }
        }
        j();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public String dispatchEventToNativeView(NativeViewRequestEvent nativeViewRequestEvent) {
        NativeContainer u16 = u(nativeViewRequestEvent.webViewId);
        if (u16 != null) {
            return u16.E(nativeViewRequestEvent);
        }
        return "";
    }

    public void f() {
        bh bhVar = this.I;
        if (bhVar == null) {
            QMLog.e("Mini-Runtime", "checkUpdate but runtime is not ready yet");
        } else {
            bhVar.h();
        }
    }

    public void g(String str, String str2, int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                MiniWebView miniWebView = this.D.get(Integer.valueOf(i3));
                if (miniWebView != null) {
                    miniWebView.C(str, str2, i3);
                }
            }
            return;
        }
        for (MiniWebView miniWebView2 : this.D.values()) {
            miniWebView2.C(str, str2, miniWebView2.J());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IBaseAppContext
    public Activity getAttachedActivity() {
        return this.G.c();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public String getBaseLibVersion() {
        BaselibLoader.BaselibContent o16 = o();
        if (o16 != null) {
            return o16.version;
        }
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IBaseAppContext
    public Context getContext() {
        return this.f346067d;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IJsPluginEngine getJsPluginEngine() {
        return this.f346071i;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public MiniAppInfo getMiniAppInfo() {
        ApkgInfo apkgInfo = this.L;
        if (apkgInfo != null) {
            return apkgInfo.mMiniAppInfo;
        }
        return null;
    }

    public MiniAppWorkerManager getMiniAppWorkerManager() {
        return this.H;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IPage getPage() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public ShareState getShareState() {
        return new ShareState();
    }

    public void h() {
        if (this.K == null) {
            return;
        }
        QMLog.i("Mini-Runtime", "evaluateConfigScript");
        this.K.d(eu3.c.d(), "default-config.js");
    }

    public void i() {
        if (this.K == null) {
            return;
        }
        QMLog.i("Mini-Runtime", "evaluateLibraryScript");
        BaselibLoader.BaselibContent o16 = o();
        this.K.d(o16.waServiceJsStr, o16.waServicePath);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isContainer() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public boolean isForeground() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isMiniGame() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isOrientationLandscape() {
        return false;
    }

    public void j() {
        if (this.K == null) {
            return;
        }
        QMLog.i("Mini-Runtime", "evaluateMainAppServiceScript");
        this.K.d(eu3.c.a(this.L), "app-config.json");
        this.K.d(this.L.getAppServiceJsContent(), "app-service.js");
    }

    public void k(String str) {
        ApkgInfo apkgInfo;
        if (this.K == null) {
            return;
        }
        QMLog.i("Mini-Runtime", "evaluateSubAppServiceScript, path: " + str);
        if (!TextUtils.isEmpty(str) && (apkgInfo = this.L) != null) {
            String rootPath = apkgInfo.getRootPath(str);
            if (TextUtils.isEmpty(rootPath) || this.f346072m.contains(rootPath)) {
                return;
            }
            this.f346072m.add(rootPath);
            this.K.d(this.L.getAppServiceJsContent(rootPath), rootPath);
        }
    }

    public void l(boolean z16) {
        if (this.K != null && !this.P) {
            this.P = true;
            QMLog.i("Mini-Runtime", "evaluateXWebConfigScript");
            this.K.d(eu3.c.g(z16), "default-config.js");
        }
    }

    @UiThread
    public void m() {
        this.M = n();
    }

    @UiThread
    public MiniWebView n() {
        MiniWebView miniWebView = this.M;
        if (miniWebView == null) {
            MiniWebView miniWebView2 = new MiniWebView(this);
            miniWebView2.B(new MiniWebView.c() { // from class: com.tencent.qqmini.container.core.aw
                @Override // com.tencent.qqmini.container.core.MiniWebView.c
                public final void a() {
                    ax.this.f();
                }
            });
            return miniWebView2;
        }
        this.M = null;
        return miniWebView;
    }

    public BaselibLoader.BaselibContent o() {
        return ((BaseRuntimeImpl.BaselibProvider) getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void onRuntimeCreate() {
        if (!this.J) {
            this.J = true;
            this.f346071i.onCreate(this);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeDestroy() {
        h hVar;
        this.P = false;
        eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.as
            @Override // java.lang.Runnable
            public final void run() {
                ax.this.z();
            }
        });
        MiniAppWorkerManager miniAppWorkerManager = this.H;
        if (miniAppWorkerManager != null) {
            miniAppWorkerManager.stopWorker();
        }
        j jVar = this.K;
        if (jVar != null) {
            jVar.b();
        }
        if (this.J && (hVar = this.f346071i) != null) {
            hVar.onDestroy();
            return;
        }
        QMLog.d("Mini-Runtime", "pluginEngine onDestroy failed, isCreated:" + this.J);
    }

    public c p() {
        return this.f346070h;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public j getJsService() {
        return this.K;
    }

    public MiniView r(int i3) {
        return this.C.get(Integer.valueOf(i3));
    }

    public MiniWebView s(int i3) {
        return this.D.get(Integer.valueOf(i3));
    }

    public Set<MiniView> t(String str) {
        return this.E.get(str);
    }

    public NativeContainer u(int i3) {
        return this.F.get(Integer.valueOf(i3));
    }

    public ApkgInfo v() {
        return this.L;
    }

    public boolean w() {
        return this.f346069f;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IPage getPage(int i3) {
        return r(i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimePause() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeResume() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeStart() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeStop() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void loadMiniApp(MiniAppInfo miniAppInfo) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeDetachActivity(Activity activity) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeAttachActivity(Activity activity, ViewGroup viewGroup) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onLoadMiniAppInfo(MiniAppInfo miniAppInfo, boolean z16, String str) {
    }
}
