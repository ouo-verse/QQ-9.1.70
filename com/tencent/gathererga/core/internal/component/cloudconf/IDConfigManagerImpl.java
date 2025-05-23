package com.tencent.gathererga.core.internal.component.cloudconf;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gathererga.core.AppInfoProvider;
import com.tencent.gathererga.core.GathererCloudConfigItem;
import com.tencent.gathererga.core.GathererCloudReq;
import com.tencent.gathererga.core.GathererCloudResp;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.gathererga.core.TuringProvider;
import com.tencent.gathererga.core.internal.b;
import com.tencent.gathererga.core.internal.util.d;
import com.tencent.gathererga.core.internal.util.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class IDConfigManagerImpl implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static final a f108217g;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, Boolean> f108218a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, Boolean> f108219b;

    /* renamed from: c, reason: collision with root package name */
    private b f108220c;

    /* renamed from: d, reason: collision with root package name */
    private GathererCloudConfigItem f108221d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f108222e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f108223f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f108217g = new IDConfigManagerImpl();
        }
    }

    public IDConfigManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108218a = new HashMap();
            this.f108219b = new ConcurrentHashMap();
        }
    }

    private Map<String, String> i(b bVar) {
        if (this.f108222e == null) {
            HashMap hashMap = new HashMap();
            this.f108222e = hashMap;
            hashMap.put("platform", "2");
            this.f108222e.put("gathererSDKVersion", "1");
            this.f108222e.put("apiLevel", "" + com.tencent.gathererga.core.internal.util.b.b());
            this.f108222e.put(WadlProxyConsts.CHANNEL, "" + bVar.k());
            this.f108222e.put("adapterVersion", "" + bVar.a());
            this.f108222e.put("appid", "" + bVar.b());
            com.tencent.gathererga.core.internal.provider.b f16 = com.tencent.gathererga.core.internal.provider.b.f().j().f();
            HardwareInfoProvider hardwareInfoProvider = (HardwareInfoProvider) com.tencent.gathererga.core.b.f(HardwareInfoProvider.class);
            if (hardwareInfoProvider != null) {
                this.f108222e.put("brand", "" + hardwareInfoProvider.getBrand(f16).b());
                this.f108222e.put("model", "" + hardwareInfoProvider.getModel(f16).b());
            }
            AppInfoProvider appInfoProvider = (AppInfoProvider) com.tencent.gathererga.core.b.f(AppInfoProvider.class);
            if (appInfoProvider != null) {
                this.f108222e.put("pkg", "" + appInfoProvider.getPackageName(f16).b());
                this.f108222e.put("appVersionName", "" + appInfoProvider.getAppVersionName(f16).b());
            }
        }
        return this.f108222e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GathererCloudReq j(b bVar) {
        Map<String, String> i3 = i(bVar);
        GathererCloudConfigItem n3 = n();
        String str = "";
        try {
            com.tencent.gathererga.core.internal.provider.b f16 = com.tencent.gathererga.core.internal.provider.b.f().j().f();
            TuringProvider turingProvider = (TuringProvider) com.tencent.gathererga.core.b.f(TuringProvider.class);
            if (turingProvider != null) {
                str = (String) turingProvider.getTAIDTicket(f16).b();
            }
        } catch (Throwable th5) {
            d.b(th5.getMessage());
        }
        return new GathererCloudReq(i3, n3, str);
    }

    private void k(b bVar) {
        e.b().execute(new Runnable(bVar) { // from class: com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManagerImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f108224d;

            {
                this.f108224d = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) IDConfigManagerImpl.this, (Object) bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    String a16 = this.f108224d.f().a("https://gatherer.m.qq.com/gatherer_conf/GetConf", "application/json", IDConfigManagerImpl.this.j(this.f108224d).toJson().toString());
                    if (TextUtils.isEmpty(a16)) {
                        d.b("cloud conf error !!!");
                        return;
                    }
                    d.a("http resp : " + a16);
                    GathererCloudResp gathererCloudResp = new GathererCloudResp(a16);
                    if (gathererCloudResp.getRet() == 0 && gathererCloudResp.getConfig_item() != null) {
                        if (!gathererCloudResp.getConfig_item().isEffective()) {
                            return;
                        }
                        String jSONObject = gathererCloudResp.getConfig_item().toJson().toString();
                        d.a("gathererCloudConfigItem : " + jSONObject);
                        IDConfigManagerImpl.this.f108221d = gathererCloudResp.getConfig_item();
                        com.tencent.gathererga.core.internal.component.cache.a aVar = (com.tencent.gathererga.core.internal.component.cache.a) com.tencent.gathererga.core.internal.component.a.e(com.tencent.gathererga.core.internal.component.cache.a.class);
                        if (aVar != null) {
                            aVar.f(jSONObject);
                            aVar.e(System.currentTimeMillis());
                        }
                        IDConfigManagerImpl.this.m(gathererCloudResp.getConfig_item().getFeatureIdOps());
                        d.d("resp : " + gathererCloudResp.toString());
                        return;
                    }
                    d.b("cloud conf GathererCloudResp ret " + gathererCloudResp.getRet());
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    public static a l() {
        return f108217g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(Map<Integer, Integer> map) {
        boolean z16;
        for (Integer num : map.keySet()) {
            Map<Integer, Boolean> map2 = this.f108218a;
            if (map.get(num).intValue() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            map2.put(num, Boolean.valueOf(z16));
        }
        this.f108218a.putAll(this.f108220c.g());
    }

    private GathererCloudConfigItem n() {
        String str;
        com.tencent.gathererga.core.internal.component.cache.a aVar = (com.tencent.gathererga.core.internal.component.cache.a) com.tencent.gathererga.core.internal.component.a.e(com.tencent.gathererga.core.internal.component.cache.a.class);
        if (aVar != null) {
            str = aVar.c();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            d.a("readFromLocal : " + str);
            return new GathererCloudConfigItem(str);
        } catch (Throwable th5) {
            d.h(th5);
            return null;
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cloudconf.a
    public boolean a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (!this.f108223f) {
            return true;
        }
        Map<Integer, Boolean> map = this.f108219b;
        if (map == null) {
            return false;
        }
        Boolean bool = map.get(Integer.valueOf(i3));
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gathererga.core.internal.component.cloudconf.a
    public void b(ConcurrentHashMap<Integer, Boolean> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) concurrentHashMap);
            return;
        }
        try {
            b bVar = this.f108220c;
            if (bVar != null) {
                bVar.l(concurrentHashMap);
            }
            Map<Integer, Boolean> map = this.f108218a;
            if (map != null) {
                map.putAll(concurrentHashMap);
            }
        } catch (Throwable th5) {
            d.b(th5.getMessage());
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cloudconf.a
    public void c(ConcurrentHashMap<Integer, Boolean> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) concurrentHashMap);
            return;
        }
        try {
            b bVar = this.f108220c;
            if (bVar != null) {
                bVar.m(concurrentHashMap);
            }
            if (this.f108218a != null) {
                this.f108219b.putAll(concurrentHashMap);
            }
        } catch (Throwable th5) {
            d.b(th5.getMessage());
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cloudconf.a
    public void d(b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bVar, Boolean.valueOf(z16));
            return;
        }
        this.f108220c = bVar;
        this.f108223f = z16;
        if (z16) {
            this.f108218a.putAll(bVar.g());
            this.f108219b.putAll(this.f108220c.h());
        } else {
            o();
        }
    }

    @Override // com.tencent.gathererga.core.internal.component.cloudconf.a
    public boolean e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        Map<Integer, Boolean> map = this.f108218a;
        if (map == null) {
            return true;
        }
        Boolean bool = map.get(Integer.valueOf(i3));
        if (bool != null) {
            return bool.booleanValue();
        }
        return !this.f108223f;
    }

    public void o() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.gathererga.core.internal.component.cache.a aVar = (com.tencent.gathererga.core.internal.component.cache.a) com.tencent.gathererga.core.internal.component.a.e(com.tencent.gathererga.core.internal.component.cache.a.class);
        if (aVar != null) {
            j3 = aVar.b();
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            d.a("first time to pull conf , last pull time empty");
            k(this.f108220c);
            return;
        }
        if (this.f108221d == null) {
            this.f108221d = n();
        }
        if (this.f108221d == null) {
            d.a("first time to pull conf mGathererCloudResp null");
            k(this.f108220c);
        } else if (Math.abs(System.currentTimeMillis() - j3) >= this.f108221d.getLifeTime() * 3600) {
            d.a("time to re-pull conf");
            k(this.f108220c);
        } else {
            d.a("not need to pull cloud conf at init");
            m(this.f108221d.getFeatureIdOps());
        }
    }
}
