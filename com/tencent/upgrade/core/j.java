package com.tencent.upgrade.core;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.dependencyimpl.MmkvStorage;
import com.tencent.upgrade.bean.UpgradeConfig;
import com.tencent.upgrade.bean.UpgradeStrategy;
import com.tencent.upgrade.core.h;
import com.tencent.upgrade.monitor.ActivityLifeCycleMonitor;
import com.tencent.upgrade.util.HttpUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: x, reason: collision with root package name */
    private static volatile j f383842x;

    /* renamed from: a, reason: collision with root package name */
    private h f383843a;

    /* renamed from: b, reason: collision with root package name */
    private RDelivery f383844b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f383845c;

    /* renamed from: d, reason: collision with root package name */
    private Context f383846d;

    /* renamed from: e, reason: collision with root package name */
    private long f383847e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f383848f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f383849g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f383850h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.upgrade.storage.b<UpgradeStrategy> f383851i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.upgrade.storage.b<String> f383852j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.upgrade.storage.d f383853k;

    /* renamed from: l, reason: collision with root package name */
    private String f383854l;

    /* renamed from: m, reason: collision with root package name */
    private String f383855m;

    /* renamed from: n, reason: collision with root package name */
    private int f383856n;

    /* renamed from: o, reason: collision with root package name */
    private int f383857o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.upgrade.download.b f383858p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.upgrade.core.a f383859q;

    /* renamed from: r, reason: collision with root package name */
    private IBasePkgFile f383860r;

    /* renamed from: s, reason: collision with root package name */
    private pw4.b f383861s;

    /* renamed from: t, reason: collision with root package name */
    private Map<String, String> f383862t;

    /* renamed from: u, reason: collision with root package name */
    private h.f f383863u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f383864v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f383865w;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements h.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // com.tencent.upgrade.core.h.f
        public void a(UpgradeStrategy upgradeStrategy) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                j.this.z(upgradeStrategy);
                if (upgradeStrategy != null && upgradeStrategy.getUndisturbedDuration() > 0) {
                    c.f383819b.c();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) upgradeStrategy);
        }

        @Override // com.tencent.upgrade.core.h.f
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                com.tencent.upgrade.util.d.a("UpgradeManager", "onReceiveDeleteStrategyOperate");
                j.this.c();
            }
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383847e = 0L;
        this.f383848f = false;
        this.f383849g = true;
        this.f383850h = true;
        this.f383861s = new pw4.b() { // from class: com.tencent.upgrade.core.i
        };
        this.f383862t = new ConcurrentHashMap();
        this.f383863u = new a();
    }

    private String g(String str) {
        return "cached_strategy_" + str;
    }

    public static j l() {
        if (f383842x == null) {
            synchronized (j.class) {
                if (f383842x == null) {
                    f383842x = new j();
                }
            }
            return f383842x;
        }
        return f383842x;
    }

    private static void q(UpgradeConfig upgradeConfig, Context context) {
        if (upgradeConfig.isEnableBuglyQQCrashReport().booleanValue()) {
            com.tencent.upgrade.report.a.a(context);
        }
    }

    private void r(Context context, UpgradeConfig upgradeConfig) {
        this.f383846d = context;
        this.f383864v = upgradeConfig.isUseShiplyChannel();
        this.f383865w = upgradeConfig.isAllow32BitApkOn64BitDevice();
        this.f383855m = upgradeConfig.getAppId();
        this.f383857o = upgradeConfig.getCurrentBuildNo();
        this.f383854l = upgradeConfig.getUserId();
        this.f383848f = upgradeConfig.isDebugMode();
        this.f383847e = upgradeConfig.getCacheExpireTime();
        this.f383849g = upgradeConfig.isAllowDownloadOverMobile();
        Map<String, String> customParams = upgradeConfig.getCustomParams();
        if (customParams != null) {
            this.f383862t.putAll(customParams);
        }
        this.f383851i = new com.tencent.upgrade.storage.b<>(g(this.f383854l), UpgradeStrategy.getDefaultCache(), l().n());
        this.f383852j = new com.tencent.upgrade.storage.b<>("installed_apk_version", "", l().n());
        if (this.f383856n <= 0) {
            this.f383856n = (int) com.tencent.upgrade.util.a.e();
        }
        if (upgradeConfig.getCustomDownloader() == null) {
            this.f383858p = new com.tencent.upgrade.download.a();
        } else {
            this.f383858p = upgradeConfig.getCustomDownloader();
        }
        this.f383859q = upgradeConfig.getDiffPkgHandler();
        this.f383860r = upgradeConfig.getiBasePkgFileForDiffUpgrade();
        if (upgradeConfig.getCustomInstaller() != null) {
            this.f383861s = upgradeConfig.getCustomInstaller();
        }
        String f16 = com.tencent.upgrade.util.a.f();
        com.tencent.upgrade.util.d.a("UpgradeManager", "init current version code = " + this.f383856n + ",buildNo = " + this.f383857o + ",debugMode = " + this.f383848f + ",config = " + upgradeConfig);
        y(f16, this.f383856n, this.f383857o);
    }

    private void s(UpgradeConfig upgradeConfig, Context context) {
        if ((w() || !upgradeConfig.isUseSPStorage().booleanValue()) && upgradeConfig.isInternalInitMMKVForRDelivery().booleanValue()) {
            MMKV.T(context);
        }
        if (upgradeConfig.isUseSPStorage().booleanValue()) {
            this.f383853k = com.tencent.upgrade.storage.c.b();
            com.tencent.upgrade.storage.c.b().d(context);
        } else {
            this.f383853k = new com.tencent.upgrade.storage.a(new MmkvStorage.b().createIRStorage("shiply_upgrade_sdk_common_storage"));
        }
    }

    private void y(String str, int i3, int i16) {
        com.tencent.upgrade.util.d.a("UpgradeManager", "tryReportActive cachedStrategy: " + this.f383851i.toString());
        String a16 = this.f383852j.a();
        String b16 = com.tencent.upgrade.util.h.b(str, i3, i16);
        com.tencent.upgrade.util.d.a("UpgradeManager", "tryReportActive installedFullVersion = " + a16 + ",curFullVersion = " + b16);
        if (!TextUtils.isEmpty(a16) && com.tencent.upgrade.util.h.a(a16, b16)) {
            g.a();
            c();
            this.f383852j.b(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(UpgradeStrategy upgradeStrategy) {
        com.tencent.upgrade.util.d.a("UpgradeManager", "updateCache");
        if (upgradeStrategy == null) {
            com.tencent.upgrade.util.d.a("UpgradeManager", "updateCache return for null strategy");
            return;
        }
        if (new com.tencent.upgrade.checker.b().a(h(), upgradeStrategy)) {
            this.f383851i.b(upgradeStrategy);
            d.a().b();
            g.d();
            com.tencent.upgrade.util.d.a("UpgradeManager", "updateCache, update new strategy cache:" + upgradeStrategy.toString());
            return;
        }
        h().updateReceiveMoment();
        this.f383851i.b(h());
        com.tencent.upgrade.util.d.a("UpgradeManager", "updateCache, strategy cache needn't update");
    }

    public void b(boolean z16, boolean z17, boolean z18, Map<String, String> map, pw4.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), map, dVar);
            return;
        }
        if (dVar != null) {
            if (!this.f383845c) {
                dVar.onFail(1, "SDK_NOT_INIT");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.f383862t);
            if (map != null) {
                hashMap.putAll(map);
            }
            this.f383843a.e(z16, z17, z18, hashMap, dVar);
            return;
        }
        throw new IllegalArgumentException("checkUpgrade callback argument cannot be null!");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (!this.f383845c) {
            com.tencent.upgrade.util.d.c("UpgradeManager", "clearCache return for sdk not init");
            return;
        }
        com.tencent.upgrade.util.d.a("UpgradeManager", "clearCache cachedStrategy = " + this.f383851i);
        com.tencent.upgrade.storage.b<UpgradeStrategy> bVar = this.f383851i;
        if (bVar != null) {
            bVar.b(null);
        }
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f383855m;
    }

    public IBasePkgFile e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (IBasePkgFile) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.f383860r;
    }

    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.f383847e;
    }

    public UpgradeStrategy h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (UpgradeStrategy) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        com.tencent.upgrade.storage.b<UpgradeStrategy> bVar = this.f383851i;
        if (bVar == null) {
            return UpgradeStrategy.getDefaultCache();
        }
        return bVar.a();
    }

    public Context i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Context) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f383846d;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f383857o;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.f383856n;
    }

    public RDelivery m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RDelivery) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (!this.f383845c) {
            return null;
        }
        return this.f383844b;
    }

    public com.tencent.upgrade.storage.d n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.upgrade.storage.d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f383853k;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f383854l;
    }

    public synchronized void p(Context context, UpgradeConfig upgradeConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) upgradeConfig);
            return;
        }
        com.tencent.upgrade.util.d.a("UpgradeManager", "upgrade sdk init, hasInitialed = " + this.f383845c);
        if (upgradeConfig == null) {
            return;
        }
        if (this.f383845c) {
            return;
        }
        Boolean isMainProcess = upgradeConfig.isMainProcess();
        if (isMainProcess == null) {
            isMainProcess = Boolean.valueOf(com.tencent.upgrade.util.g.a(context));
        }
        if (!isMainProcess.booleanValue()) {
            com.tencent.upgrade.util.d.g("UpgradeManager", "init return for not main process");
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (upgradeConfig.getCustomLogger() != null) {
            com.tencent.upgrade.util.d.i(upgradeConfig.getCustomLogger());
        }
        if (upgradeConfig.getIrNetwork() != null) {
            HttpUtil.m(upgradeConfig.getIrNetwork());
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            com.tencent.upgrade.util.d.a("UpgradeManager", "upgrade sdk init, getApplicationContext return null");
        } else {
            context = applicationContext;
        }
        s(upgradeConfig, context);
        q(upgradeConfig, context);
        if (upgradeConfig.isMonitorLifecycle()) {
            ActivityLifeCycleMonitor.d().g();
        }
        r(context, upgradeConfig);
        if (w()) {
            try {
                this.f383844b = f.f383826b.e(context, upgradeConfig, null);
            } catch (Exception e16) {
                com.tencent.upgrade.util.d.d("UpgradeManager", "createRDeliveryInstance err", e16);
                com.tencent.upgrade.report.b.d(SystemClock.elapsedRealtime() - elapsedRealtime, 0);
                return;
            }
        }
        this.f383843a = new h(this.f383844b, u(), this.f383863u);
        com.tencent.upgrade.report.b.d(SystemClock.elapsedRealtime() - elapsedRealtime, 1);
        this.f383845c = true;
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.f383865w;
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f383848f;
    }

    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f383850h;
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (!this.f383864v) {
            return false;
        }
        return true;
    }

    public void x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
            return;
        }
        if (!this.f383845c) {
            com.tencent.upgrade.util.d.c("UpgradeManager", "switchUserId return for sdk not init");
            return;
        }
        if (str == null) {
            com.tencent.upgrade.util.d.c("UpgradeManager", "switchUserId return for userId is null");
            return;
        }
        if (!str.equals(this.f383854l)) {
            com.tencent.upgrade.util.d.a("UpgradeManager", "switchUserId rDelivery = " + this.f383844b);
            this.f383854l = str;
            this.f383851i = new com.tencent.upgrade.storage.b<>(g(str), UpgradeStrategy.getDefaultCache(), l().n());
            RDelivery rDelivery = this.f383844b;
            if (rDelivery != null) {
                rDelivery.L(str);
            }
        }
    }
}
