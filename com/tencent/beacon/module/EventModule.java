package com.tencent.beacon.module;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.b.i;
import com.tencent.beacon.a.c.j;
import com.tencent.beacon.base.net.b.e;
import com.tencent.beacon.d.c;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.b.a;
import com.tencent.beacon.event.b.b;
import com.tencent.beacon.event.c.g;
import com.tencent.beacon.event.h;
import com.tencent.beacon.event.immediate.IBeaconImmediateReport;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EventModule implements BeaconModule, d, e.a, c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Map<String, String>> f78054a = new ConcurrentHashMap(3);

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f78055b = new ConcurrentHashMap(3);

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f78056c = new ConcurrentHashMap(3);

    /* renamed from: d, reason: collision with root package name */
    private final List<com.tencent.beacon.event.b.c> f78057d = new ArrayList(3);

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f78058e = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f78059f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private AtomicInteger f78060g = new AtomicInteger(0);

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f78061h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<BeaconEvent>> f78062i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private StrategyModule f78063j;

    /* renamed from: k, reason: collision with root package name */
    private h f78064k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f78065l;

    private void b(BeaconEvent beaconEvent) {
        String appKey = beaconEvent.getAppKey();
        if (this.f78060g.addAndGet(1) > 1000) {
            String format = String.format("logid empty cache count over max , appKey: %s, event: %s", appKey, beaconEvent.getCode());
            com.tencent.beacon.base.util.c.a(format, new Object[0]);
            if (this.f78061h.compareAndSet(false, true)) {
                i.e().a("518", format);
                return;
            }
            return;
        }
        List<BeaconEvent> list = this.f78062i.get(appKey);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(beaconEvent);
        this.f78062i.put(appKey, list);
        com.tencent.beacon.base.util.c.a("logid empty and add to cache , appKey: %s, event: %s", appKey, beaconEvent.getCode());
    }

    private String d(String str) {
        return TextUtils.isEmpty(str) ? com.tencent.beacon.a.c.c.c().e() : str;
    }

    private void g() {
        this.f78057d.add(new b());
        this.f78057d.add(new a());
        for (int i3 = 1; i3 < this.f78057d.size(); i3++) {
            this.f78057d.get(i3 - 1).a(this.f78057d.get(i3));
        }
    }

    private void h() {
        if (com.tencent.beacon.d.b.a().g()) {
            com.tencent.beacon.event.d dVar = new com.tencent.beacon.event.d();
            this.f78064k = dVar;
            dVar.a();
        }
    }

    private void i() {
        com.tencent.beacon.a.a.b.a().a(3, this);
        com.tencent.beacon.a.a.b.a().a(4, this);
        com.tencent.beacon.a.a.b.a().a(5, this);
        com.tencent.beacon.a.a.b.a().a(6, this);
        com.tencent.beacon.a.a.b.a().a(1, this);
        com.tencent.beacon.a.a.b.a().a(7, this);
        com.tencent.beacon.a.a.b.a().a(14, this);
    }

    private void j() {
        com.tencent.beacon.a.b.a.a().a(3000).postAtFrontOfQueue(new Runnable() { // from class: com.tencent.beacon.module.EventModule.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.beacon.event.a.a a16 = com.tencent.beacon.event.a.a.a();
                    Map<String, Integer> b16 = a16.b("t_r_e");
                    EventModule.this.a(b16, a16.b("t_n_e"));
                } catch (Throwable th5) {
                    com.tencent.beacon.base.util.c.a(th5);
                    i.e().a(ThemeReporter.FROM_AUTH, "error while storageReport", th5);
                }
            }
        });
    }

    @NonNull
    public String c(String str) {
        String str2;
        String d16 = d(str);
        return (TextUtils.isEmpty(d16) || (str2 = f78055b.get(d16)) == null) ? MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN : str2;
    }

    public boolean e() {
        return this.f78065l;
    }

    public void f() {
        com.tencent.beacon.base.util.c.a("[EventModule]", "resume report by user.", new Object[0]);
        com.tencent.beacon.a.b.a.a().d();
        com.tencent.beacon.base.net.c.c().e();
    }

    @Override // com.tencent.beacon.module.BeaconModule
    public void a(Context context) {
        j();
        this.f78063j = (StrategyModule) BeaconModule.f78053a.get(ModuleName.STRATEGY);
        g();
        h();
        i();
        e.a(context, this);
        com.tencent.beacon.d.b.a().a(this);
        this.f78065l = true;
    }

    public h d() {
        return this.f78064k;
    }

    @Override // com.tencent.beacon.d.c
    public void c() {
        if (com.tencent.beacon.d.b.a().g()) {
            if (this.f78064k == null) {
                h();
                return;
            } else {
                f();
                return;
            }
        }
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Integer> map, Map<String, Integer> map2) {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(map.keySet());
        hashSet.addAll(map2.keySet());
        if (hashSet.isEmpty()) {
            com.tencent.beacon.a.b.h.e().a("702", String.format("real_logid_count=%s&normal_logid_count=%s&appkey=%s", 0, 0, com.tencent.beacon.a.c.c.c().e()));
            return;
        }
        for (String str : hashSet) {
            com.tencent.beacon.a.b.h.e().a("702", String.format("real_logid_count=%s&normal_logid_count=%s&appkey=%s", Integer.valueOf(map.containsKey(str) ? map.get(str).intValue() : 0), Integer.valueOf(map2.containsKey(str) ? map2.get(str).intValue() : 0), str));
        }
    }

    public void b(String str, String str2) {
        f78055b.put(d(str), com.tencent.beacon.event.c.d.e(str2));
    }

    @NonNull
    public String b(String str) {
        String str2;
        String d16 = d(str);
        return (TextUtils.isEmpty(d16) || (str2 = f78056c.get(d16)) == null) ? "" : str2;
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void b() {
        this.f78064k.c();
    }

    public void b(boolean z16) {
        com.tencent.beacon.base.util.c.a("[EventModule]", "pause report by user.", new Object[0]);
        com.tencent.beacon.a.b.a.a().a(z16);
        com.tencent.beacon.base.net.c.c().close();
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        List<BeaconEvent> list;
        int i3 = cVar.f77584a;
        if (i3 == 1) {
            com.tencent.beacon.a.a.b.a().a(12, this);
            return;
        }
        if (i3 == 12) {
            Object obj = cVar.f77585b.get("e_q_e_k");
            if (obj instanceof BeaconEvent) {
                BeaconEvent beaconEvent = (BeaconEvent) obj;
                beaconEvent.getParams().put("A93", "Y");
                com.tencent.beacon.base.util.c.a("qimei empty cache report , appKey: %s, event: %s", beaconEvent.getAppKey(), beaconEvent.getCode());
                a(beaconEvent);
                return;
            }
            return;
        }
        if (i3 == 14) {
            Object obj2 = cVar.f77585b.get("e_l_e_k");
            if (!(obj2 instanceof String) || (list = this.f78062i.get(obj2)) == null || list.isEmpty()) {
                return;
            }
            for (BeaconEvent beaconEvent2 : list) {
                com.tencent.beacon.base.util.c.a("logid empty cache report , appKey: %s, event: %s", obj2, beaconEvent2.getCode());
                a(beaconEvent2);
            }
            return;
        }
        if (i3 == 3) {
            a((String) cVar.f77585b.get("i_c_ak"), (HashMap) cVar.f77585b.get("i_c_ad"));
            return;
        }
        if (i3 == 4) {
            b((String) cVar.f77585b.get("i_c_ak"), (String) cVar.f77585b.get("i_c_u_i"));
            return;
        }
        if (i3 == 5) {
            a((String) cVar.f77585b.get("i_c_ak"), (String) cVar.f77585b.get("i_c_o_i"));
            return;
        }
        if (i3 != 6) {
            if (i3 != 7) {
                return;
            }
            com.tencent.beacon.d.b.a().a(((Boolean) cVar.f77585b.get("s_e_e")).booleanValue(), false);
        } else {
            Object obj3 = cVar.f77585b.get("b_e");
            if (obj3 instanceof BeaconEvent) {
                a((BeaconEvent) obj3);
            }
        }
    }

    public void a(boolean z16) {
        h hVar = this.f78064k;
        if (hVar != null) {
            hVar.a(z16);
        }
    }

    public EventResult a(@NonNull BeaconEvent beaconEvent) {
        StrategyModule strategyModule;
        com.tencent.beacon.base.util.c.a("[EventModule]", 0, "event: %s. go in EventModule", beaconEvent.getCode());
        if (!com.tencent.beacon.d.b.a().g()) {
            com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s. EventModule is not enable", beaconEvent.getCode());
            return EventResult.a.a(102);
        }
        beaconEvent.setAppKey(d(beaconEvent.getAppKey()));
        final g a16 = g.a(com.tencent.beacon.a.c.c.c().b(), beaconEvent.getAppKey());
        if (!a16.b()) {
            b(beaconEvent);
            com.tencent.beacon.a.b.a.a().a(new Runnable() { // from class: com.tencent.beacon.module.EventModule.2
                @Override // java.lang.Runnable
                public void run() {
                    a16.a();
                }
            });
            return EventResult.a.a(107);
        }
        com.tencent.beacon.base.util.e.a(beaconEvent.getParams());
        StrategyModule strategyModule2 = this.f78063j;
        if (strategyModule2 != null && strategyModule2.b().a(beaconEvent.getCode())) {
            com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s.  is not allowed in strategy (false)", beaconEvent.getCode());
            return EventResult.a.a(100);
        }
        if (beaconEvent.isSucceed() && (strategyModule = this.f78063j) != null && !strategyModule.b().b(beaconEvent.getCode())) {
            com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s. is sampled by svr rate (false)", beaconEvent.getCode());
            return EventResult.a.a(101);
        }
        StrategyModule strategyModule3 = this.f78063j;
        if (strategyModule3 != null && strategyModule3.b().a(beaconEvent.getAppKey(), beaconEvent.getCode())) {
            com.tencent.beacon.base.util.c.a("[EventModule]", 1, "appkey: %s, event: %s. is sampled by user", beaconEvent.getAppKey(), beaconEvent.getCode());
            return EventResult.a.a(108);
        }
        EventBean b16 = this.f78057d.get(0).b(beaconEvent);
        if (b16 == null) {
            return EventResult.a.a(105);
        }
        if (TextUtils.isEmpty(j.b()) && TextUtils.isEmpty(j.c())) {
            if (this.f78058e.addAndGet(1) > 64) {
                String format = String.format("qimei empty cache count over max , appKey: %s, event: %s", beaconEvent.getAppKey(), beaconEvent.getCode());
                com.tencent.beacon.base.util.c.a(format, new Object[0]);
                if (this.f78059f.compareAndSet(false, true)) {
                    i.e().a("510", format);
                }
            } else {
                com.tencent.beacon.base.util.c.a("qimei empty and add to cache , appKey: %s, event: %s", beaconEvent.getAppKey(), beaconEvent.getCode());
                BeaconEvent build = BeaconEvent.newBuilder(beaconEvent).build();
                HashMap hashMap = new HashMap();
                hashMap.put("e_q_e_k", build);
                com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(12, hashMap));
            }
        }
        int eventType = b16.getEventType();
        if (eventType == 2 || eventType == 3) {
            IBeaconImmediateReport immediateReport = BeaconReport.getInstance().getImmediateReport();
            com.tencent.beacon.base.util.e.a("immediateReport", immediateReport);
            if (immediateReport != null) {
                return this.f78064k.a(beaconEvent.getParams().get("A100"), b16);
            }
            com.tencent.beacon.base.util.c.a("immediateReport is null!", new Object[0]);
            i.e().a("515", "immediateReport is null!");
        }
        return this.f78064k.b(beaconEvent.getParams().get("A100"), b16);
    }

    public void a(String str, String str2) {
        f78056c.put(d(str), com.tencent.beacon.event.c.d.c(str2));
    }

    public void a(String str, Map<String, String> map) {
        if (map == null || map.isEmpty() || map.size() >= 50) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(map == null ? 0 : map.size());
            com.tencent.beacon.base.util.c.a("setAdditionalParams error , params.size: %s", objArr);
            return;
        }
        String d16 = d(str);
        Map<String, Map<String, String>> map2 = f78054a;
        Map<String, String> map3 = map2.get(d16);
        if (map3 != null) {
            if (map3.size() + map.size() >= 50) {
                com.tencent.beacon.base.util.c.a("setAdditionalParams error , params.size: can not more than 50", new Object[0]);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(map3);
            hashMap.putAll(map);
            map2.put(d16, hashMap);
            return;
        }
        map2.put(d16, new HashMap(map));
    }

    public Map<String, String> a(String str) {
        return f78054a.get(d(str));
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void a() {
        this.f78064k.b();
    }
}
