package pm0;

import com.tencent.ad.tangram.util.AdSafeUtil;
import com.tencent.ams.dsdk.core.DKBundleManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dynamic.IDynamicApi;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f426466d;

    /* renamed from: a, reason: collision with root package name */
    private volatile long f426467a = Long.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    private volatile long f426468b = 30000;

    /* renamed from: c, reason: collision with root package name */
    private volatile String f426469c;

    public static b c() {
        if (f426466d == null) {
            synchronized (b.class) {
                if (f426466d == null) {
                    f426466d = new b();
                }
            }
        }
        return f426466d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        ((IDynamicApi) QRoute.api(IDynamicApi.class)).setGlobalParams();
        this.f426469c = DKBundleManager.getModuleVersion(DKEngine.DKModuleID.PCAD_REWARD);
    }

    private void f() {
        if (this.f426467a != Long.MIN_VALUE && System.currentTimeMillis() - this.f426467a < this.f426468b) {
            GdtLog.i("GdtMotiveHippyModuleVersionManager", "[updateModuleInfo] too frequently and not first update");
            return;
        }
        GdtLog.i("GdtMotiveHippyModuleVersionManager", "[updateModuleInfo] update");
        this.f426467a = System.currentTimeMillis();
        AdSafeUtil.safeRun(new Runnable() { // from class: pm0.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.d();
            }
        }, "GdtMotiveHippyModuleVersionManager", "");
    }

    public String b() {
        f();
        return this.f426469c;
    }

    public void e(long j3) {
        this.f426468b = j3 * 1000;
    }
}
