package com.tencent.gathererga.tangram.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gathererga.core.AndroidInfoProvider;
import com.tencent.gathererga.core.AppInfoProvider;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.gathererga.core.TuringProvider;
import com.tencent.gathererga.core.UserInfoProvider;
import com.tencent.gathererga.core.f;
import com.tencent.gathererga.tangram.c;
import com.tencent.gathererga.tangram.d;
import com.tencent.gathererga.tangram.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class TangramServiceImpl implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static volatile TangramServiceImpl f108372g;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, c> f108373a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, d> f108374b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Object> f108375c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.gathererga.sdk.b f108376d;

    /* renamed from: e, reason: collision with root package name */
    private b f108377e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.gathererga.tangram.a f108378f;

    TangramServiceImpl(Context context, com.tencent.gathererga.tangram.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        if (!o(context, bVar)) {
            return;
        }
        this.f108373a = bVar.f();
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        ConcurrentHashMap<Integer, c> concurrentHashMap3 = this.f108373a;
        if (concurrentHashMap3 != null && !concurrentHashMap3.isEmpty()) {
            Iterator<Integer> it = this.f108373a.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                concurrentHashMap.put(Integer.valueOf(intValue), Boolean.valueOf(this.f108373a.get(Integer.valueOf(intValue)).e()));
                concurrentHashMap2.put(Integer.valueOf(intValue), Boolean.valueOf(this.f108373a.get(Integer.valueOf(intValue)).f()));
            }
        }
        this.f108376d = bVar.j();
        this.f108378f = bVar.h();
        this.f108377e = new b();
        com.tencent.gathererga.sdk.c.c(com.tencent.gathererga.sdk.a.n(context, 1).o(bVar.b()).n(bVar.a()).t(concurrentHashMap).q(bVar.c()).u(bVar.i()).r(bVar.d()).w(this.f108377e).v(bVar.g()).s(bVar.e()).p(), bVar.j());
    }

    public static TangramServiceImpl l(Context context, com.tencent.gathererga.tangram.b bVar) {
        if (f108372g == null) {
            synchronized (TangramServiceImpl.class) {
                if (f108372g == null) {
                    f108372g = new TangramServiceImpl(context, bVar);
                }
            }
        }
        return f108372g;
    }

    private com.tencent.gathererga.core.e m(int i3, boolean z16) {
        com.tencent.gathererga.core.e b16;
        com.tencent.gathererga.core.internal.provider.b f16 = com.tencent.gathererga.core.internal.provider.b.f().f();
        ConcurrentHashMap<Integer, c> concurrentHashMap = this.f108373a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0 && this.f108373a.containsKey(Integer.valueOf(i3))) {
            c cVar = this.f108373a.get(Integer.valueOf(i3));
            if (cVar == null) {
                return f16;
            }
            if (z16) {
                b16 = cVar.c();
            } else {
                b16 = cVar.b();
            }
            if (b16 == null) {
                return f16;
            }
            return b16;
        }
        return f16;
    }

    private synchronized void n(int i3, Object obj) {
        ul0.a aVar = (ul0.a) com.tencent.gathererga.sdk.c.b(ul0.a.class);
        String str = null;
        if ((obj instanceof f) && ((f) obj).c() && (((f) obj).b() instanceof String)) {
            f fVar = (f) obj;
            if (aVar != null) {
                str = aVar.a(Integer.valueOf(i3), String.valueOf(fVar.b()));
            }
        } else if (obj instanceof String) {
            String str2 = (String) obj;
            if (aVar != null) {
                str = aVar.a(Integer.valueOf(i3), str2);
            }
        }
        this.f108374b.put(Integer.valueOf(i3), new a(obj, str));
    }

    private boolean o(Context context, com.tencent.gathererga.tangram.b bVar) {
        if (context != null && bVar != null && !TextUtils.isEmpty(bVar.b()) && !TextUtils.isEmpty(bVar.a())) {
            return true;
        }
        return false;
    }

    private void p() {
        ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f108375c;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            Iterator<Integer> it = this.f108375c.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                n(intValue, this.f108375c.get(Integer.valueOf(intValue)));
            }
        }
    }

    private void q() {
        com.tencent.gathererga.core.internal.util.e.b().execute(new Runnable() { // from class: com.tencent.gathererga.tangram.internal.TangramServiceImpl.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TangramServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TangramServiceImpl.this.r(true);
                    if (TangramServiceImpl.this.f108378f != null) {
                        TangramServiceImpl.this.f108378f.a(new ConcurrentHashMap(TangramServiceImpl.this.f108374b));
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(boolean z16) {
        if (this.f108374b == null) {
            this.f108374b = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<Integer, c> concurrentHashMap = this.f108373a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            HardwareInfoProvider hardwareInfoProvider = (HardwareInfoProvider) com.tencent.gathererga.sdk.c.a(HardwareInfoProvider.class);
            AndroidInfoProvider androidInfoProvider = (AndroidInfoProvider) com.tencent.gathererga.sdk.c.a(AndroidInfoProvider.class);
            AppInfoProvider appInfoProvider = (AppInfoProvider) com.tencent.gathererga.sdk.c.a(AppInfoProvider.class);
            UserInfoProvider userInfoProvider = (UserInfoProvider) com.tencent.gathererga.sdk.c.a(UserInfoProvider.class);
            TuringProvider turingProvider = (TuringProvider) com.tencent.gathererga.sdk.c.a(TuringProvider.class);
            if (hardwareInfoProvider != null && androidInfoProvider != null && appInfoProvider != null && userInfoProvider != null) {
                com.tencent.gathererga.core.internal.util.d.b("updateDeviceInfo\uff1aisUpdate " + z16);
                n(110, hardwareInfoProvider.getDeviceId(m(110, z16)));
                n(111, hardwareInfoProvider.getDeviceId0(m(111, z16)));
                n(112, hardwareInfoProvider.getDeviceId1(m(112, z16)));
                n(101, hardwareInfoProvider.getImei(m(101, z16)));
                n(102, hardwareInfoProvider.getImei0(m(102, z16)));
                n(103, hardwareInfoProvider.getImei1(m(103, z16)));
                n(107, hardwareInfoProvider.getMeid(m(107, z16)));
                n(108, hardwareInfoProvider.getMeid0(m(108, z16)));
                n(109, hardwareInfoProvider.getMeid1(m(109, z16)));
                n(104, hardwareInfoProvider.getImsi(m(104, z16)));
                n(115, hardwareInfoProvider.getAndroidId(m(115, z16)));
                n(308, userInfoProvider.getUserAgent(m(308, z16)));
                n(307, userInfoProvider.getBssid(m(307, z16)));
                n(312, userInfoProvider.getNetworkType(m(312, z16)));
                n(313, userInfoProvider.getMobileNetworkType(m(313, z16)));
                n(304, userInfoProvider.getLanguage(m(304, z16)));
                n(306, userInfoProvider.getTimeZone(m(306, z16)));
                n(403, androidInfoProvider.getOsVersion(m(403, z16)));
                n(116, hardwareInfoProvider.getManufacturer(m(116, z16)));
                n(117, hardwareInfoProvider.getModel(m(117, z16)));
                n(118, hardwareInfoProvider.getBrand(m(118, z16)));
                n(119, hardwareInfoProvider.getDeviceHeightAndWidth(m(119, z16)));
                n(317, userInfoProvider.getScreenOrientation(m(317, z16)));
                n(501, appInfoProvider.getPackageName(m(501, z16)));
                n(502, appInfoProvider.getAppVersionName(m(502, z16)));
                n(124, hardwareInfoProvider.getHarmonyOsVersion(m(124, z16)));
                n(125, hardwareInfoProvider.getHarmonyPureMode(m(125, z16)));
                n(126, hardwareInfoProvider.getIsHarmonyOs(m(126, z16)));
                n(414, androidInfoProvider.getManufacturerOSVersion(m(414, z16)));
                c cVar = this.f108373a.get(305);
                if (cVar != null && cVar.a() != null) {
                    n(305, userInfoProvider.getCarrier(m(305, z16), cVar.a().c()));
                }
                c cVar2 = this.f108373a.get(408);
                if (cVar2 != null && cVar2.a() != null) {
                    n(408, androidInfoProvider.getChromeVersionName(m(408, z16), cVar2.a().b()));
                }
                n(409, androidInfoProvider.getVersionCodeName(m(409, z16)));
                n(410, androidInfoProvider.getBuildId(m(410, z16)));
                n(128, hardwareInfoProvider.getScreenWidthBucket(m(128, z16)));
                n(411, androidInfoProvider.getVersionReleaseOrCodename(m(411, z16)));
                n(413, androidInfoProvider.getVmVersion(m(413, z16)));
                n(412, androidInfoProvider.getVersionIncremental(m(412, z16)));
                n(318, userInfoProvider.getWebviewUa(m(318, z16)));
                c cVar3 = this.f108373a.get(319);
                if (cVar3 != null && cVar3.a() != null) {
                    int a16 = cVar3.a().a();
                    n(319, userInfoProvider.getCurrentVolume(m(319, z16), a16));
                    n(320, userInfoProvider.getMaxVolume(m(320, z16), a16));
                    n(321, userInfoProvider.getMinVolume(m(321, z16), a16));
                }
                if (turingProvider == null) {
                    com.tencent.gathererga.core.internal.util.d.a("turing provider is null");
                    return;
                } else {
                    n(1, turingProvider.getAIDTicket(m(1, z16)));
                    n(2, turingProvider.getTAIDTicket(m(2, z16)));
                    return;
                }
            }
            com.tencent.gathererga.core.internal.util.d.b("provider is null, check init process");
            return;
        }
        com.tencent.gathererga.core.internal.util.d.b("idSettingMap is null, check parameters");
    }

    private void s() {
        com.tencent.gathererga.core.internal.util.e.b().execute(new Runnable() { // from class: com.tencent.gathererga.tangram.internal.TangramServiceImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TangramServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (TangramServiceImpl.this.f108377e != null) {
                    TangramServiceImpl.this.f108377e.j(TangramServiceImpl.this.f108373a);
                    TangramServiceImpl.this.f108377e.p();
                    TangramServiceImpl.this.f108377e.o(2);
                }
            }
        });
    }

    @Override // com.tencent.gathererga.tangram.e
    public Map<Integer, d> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        r(false);
        p();
        q();
        s();
        return new ConcurrentHashMap(this.f108374b);
    }

    @Override // com.tencent.gathererga.tangram.e
    public void b(ConcurrentHashMap<Integer, String> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) concurrentHashMap);
            return;
        }
        if (this.f108377e == null) {
            com.tencent.gathererga.core.internal.util.d.a("update cache, storage is null");
            return;
        }
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<Integer, String> entry : concurrentHashMap.entrySet()) {
                this.f108377e.n(entry.getKey().toString(), entry.getValue(), true);
            }
            com.tencent.gathererga.core.internal.util.e.b().execute(new Runnable() { // from class: com.tencent.gathererga.tangram.internal.TangramServiceImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TangramServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TangramServiceImpl.this.f108377e.p();
                        TangramServiceImpl.this.f108377e.o(2);
                    }
                }
            });
            return;
        }
        com.tencent.gathererga.core.internal.util.d.a("update cache, cache is empty");
    }

    @Override // com.tencent.gathererga.tangram.e
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        b bVar = this.f108377e;
        if (bVar != null) {
            bVar.k();
        }
    }

    @Override // com.tencent.gathererga.tangram.e
    public void d(ConcurrentHashMap<Integer, Object> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) concurrentHashMap);
        } else {
            this.f108375c = concurrentHashMap;
            com.tencent.gathererga.sdk.c.e(concurrentHashMap);
        }
    }

    @Override // com.tencent.gathererga.tangram.e
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        b bVar = this.f108377e;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.tencent.gathererga.tangram.e
    public void f(ConcurrentHashMap<Integer, c> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) concurrentHashMap);
            return;
        }
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            Iterator<Integer> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                com.tencent.gathererga.sdk.b bVar = this.f108376d;
                if (bVar == null) {
                    concurrentHashMap2.put(Integer.valueOf(intValue), Boolean.FALSE);
                    com.tencent.gathererga.core.internal.util.d.a("privacyPolicy is null");
                } else if (!bVar.userAgreement() && concurrentHashMap.get(Integer.valueOf(intValue)) != null && !concurrentHashMap.get(Integer.valueOf(intValue)).n()) {
                    concurrentHashMap2.put(Integer.valueOf(intValue), Boolean.FALSE);
                } else {
                    ConcurrentHashMap<Integer, Object> concurrentHashMap4 = this.f108375c;
                    if (concurrentHashMap4 != null && concurrentHashMap4.containsKey(Integer.valueOf(intValue))) {
                        concurrentHashMap2.put(Integer.valueOf(intValue), Boolean.FALSE);
                    } else if (concurrentHashMap.get(Integer.valueOf(intValue)) != null) {
                        concurrentHashMap2.put(Integer.valueOf(intValue), Boolean.valueOf(concurrentHashMap.get(Integer.valueOf(intValue)).e()));
                        concurrentHashMap3.put(Integer.valueOf(intValue), Boolean.valueOf(concurrentHashMap.get(Integer.valueOf(intValue)).f()));
                    } else {
                        Integer valueOf = Integer.valueOf(intValue);
                        Boolean bool = Boolean.FALSE;
                        concurrentHashMap2.put(valueOf, bool);
                        concurrentHashMap3.put(Integer.valueOf(intValue), bool);
                    }
                }
            }
        }
        com.tencent.gathererga.sdk.c.d(concurrentHashMap2);
        com.tencent.gathererga.sdk.c.f(concurrentHashMap3);
        this.f108373a = concurrentHashMap;
    }
}
