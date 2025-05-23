package a43;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.sso.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vasgift.api.impl.service.QQGiftResDownloadModuleImpl;
import com.tencent.mobileqq.vasgift.api.impl.service.g;
import com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl;
import com.tencent.mobileqq.vasgift.mvvm.business.anim.SingleBannerGiftAnimationEngineImpl;
import com.tencent.mobileqq.vasgift.mvvm.business.banner.BannerResManager;
import com.tencent.qqlive.common.api.IQQLiveBeaconReportApi;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nh2.c;
import oh2.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<AppRuntime> f25493a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.qqgift.sdk.config.a f25494b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, nh2.a> f25495c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f25496d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f25497e = false;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.qqgift.sso.a f25498f = new e();

    /* renamed from: g, reason: collision with root package name */
    private b f25499g = new VasGiftServiceModuleImpl();

    /* renamed from: h, reason: collision with root package name */
    private ph2.a f25500h = new c43.a();

    /* renamed from: i, reason: collision with root package name */
    private oh2.a f25501i = new QQGiftResDownloadModuleImpl();

    /* renamed from: j, reason: collision with root package name */
    private IQQGiftRechargeModule f25502j = new com.tencent.mobileqq.vasgift.api.impl.service.b();

    /* renamed from: k, reason: collision with root package name */
    private oh2.c f25503k = new g();

    /* renamed from: l, reason: collision with root package name */
    private b43.a f25504l = new b43.a();

    @Override // nh2.c
    public b a() {
        return this.f25499g;
    }

    @Override // nh2.c
    public oh2.a b() {
        return this.f25501i;
    }

    @Override // nh2.c
    public void c(AppRuntime appRuntime, com.tencent.mobileqq.qqgift.sdk.config.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f25497e = true;
        this.f25493a = new WeakReference<>(appRuntime);
        this.f25494b = aVar;
        h("sso_module", this.f25498f, true);
        this.f25499g.N(this);
        this.f25500h.N(this);
        this.f25501i.N(this);
        this.f25502j.N(this);
        this.f25503k.N(this);
        this.f25504l.N(this);
        ((IQQLiveBeaconReportApi) QRoute.api(IQQLiveBeaconReportApi.class)).init();
        if (aVar != null) {
            VasLogReporter.getVasGift().report("sdk init:" + aVar, VasLogReportProxy.LEVEL.HIGHEST);
        }
        VasPerfReportUtils.report("init", VasPerfReportUtils.WITHIN_SDK, "", "", System.currentTimeMillis() - currentTimeMillis);
    }

    @Override // nh2.c
    public ph2.a d() {
        return this.f25500h;
    }

    @Override // nh2.c
    public void destroy() {
        int i3;
        if (this.f25496d) {
            return;
        }
        this.f25496d = true;
        com.tencent.mobileqq.qqgift.sdk.config.a aVar = this.f25494b;
        if (aVar == null) {
            i3 = -1;
        } else {
            i3 = aVar.f264972a;
        }
        ConcurrentHashMap<String, nh2.a> concurrentHashMap = this.f25495c;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            Iterator<Map.Entry<String, nh2.a>> it = this.f25495c.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().destroy();
            }
            this.f25495c.clear();
        }
        this.f25501i.destroy();
        this.f25503k.destroy();
        this.f25504l.destroy();
        this.f25500h.destroy();
        this.f25493a = null;
        this.f25494b = null;
        if (i3 != -1) {
            ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).removeSDKImpl(i3);
        }
        BannerResManager x16 = BannerResManager.x();
        if (x16 != null) {
            x16.L();
        }
        SingleBannerGiftAnimationEngineImpl.N.clear();
    }

    @Override // nh2.c
    public oh2.c e() {
        return this.f25503k;
    }

    @Override // nh2.c
    public IQQGiftRechargeModule f() {
        return this.f25502j;
    }

    @Override // nh2.c
    public IQQGiftCountDownModule g() {
        return this.f25504l;
    }

    @Override // nh2.c
    public AppRuntime getAppRuntime() {
        AppRuntime appRuntime = this.f25493a.get();
        if (appRuntime == null) {
            return MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        return appRuntime;
    }

    @Override // nh2.c
    public nh2.a getExtModule(String str) {
        return this.f25495c.get(str);
    }

    @Override // nh2.c
    public com.tencent.mobileqq.qqgift.sdk.config.a getSDKConfig() {
        return this.f25494b;
    }

    public void h(String str, nh2.a aVar, boolean z16) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            this.f25495c.put(str, aVar);
            if (z16) {
                aVar.N(this);
            }
        }
    }

    @Override // nh2.c
    public boolean isDestroyed() {
        return this.f25496d;
    }

    @Override // nh2.c
    public boolean isInited() {
        return this.f25497e;
    }
}
