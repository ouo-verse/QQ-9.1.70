package com.tencent.beacon.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements com.tencent.beacon.a.a.d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f77821a;

    /* renamed from: b, reason: collision with root package name */
    private static final Random f77822b = new Random();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, Map<String, Integer>> f77823c = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    protected Boolean f77828h;

    /* renamed from: j, reason: collision with root package name */
    protected c f77830j;

    /* renamed from: d, reason: collision with root package name */
    protected int f77824d = 48;

    /* renamed from: e, reason: collision with root package name */
    protected int f77825e = 2000;

    /* renamed from: f, reason: collision with root package name */
    protected int f77826f = 48;

    /* renamed from: g, reason: collision with root package name */
    protected int f77827g = 5000;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f77829i = true;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f77831k = true;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f77832l = true;

    /* renamed from: m, reason: collision with root package name */
    protected Set<String> f77833m = null;

    /* renamed from: n, reason: collision with root package name */
    protected Map<String, Float> f77834n = null;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f77835o = false;

    /* renamed from: p, reason: collision with root package name */
    protected boolean f77836p = false;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f77837q = false;

    /* renamed from: r, reason: collision with root package name */
    protected float f77838r = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f77839s = false;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f77840t = false;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f77841u = false;

    /* renamed from: v, reason: collision with root package name */
    protected int f77842v = 1;

    /* renamed from: w, reason: collision with root package name */
    protected long f77843w = 6400;

    /* renamed from: x, reason: collision with root package name */
    protected int f77844x = 20;

    /* renamed from: y, reason: collision with root package name */
    protected int f77845y = 300;

    /* renamed from: z, reason: collision with root package name */
    protected boolean f77846z = true;
    protected boolean A = true;
    protected boolean B = true;
    protected boolean C = true;
    protected boolean D = true;
    protected boolean E = true;
    protected int F = 10000;
    protected boolean G = true;
    protected boolean H = true;
    protected boolean I = false;
    protected int J = 1;

    protected b() {
        com.tencent.beacon.a.a.b.a().a(8, this);
    }

    public static b a() {
        if (f77821a == null) {
            synchronized (b.class) {
                if (f77821a == null) {
                    f77821a = new b();
                }
            }
        }
        return f77821a;
    }

    private void b(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("d_m", new HashMap(map));
        com.tencent.beacon.a.a.b.a().b(new com.tencent.beacon.a.a.c(2, hashMap));
    }

    private void o() {
        c cVar = this.f77830j;
        if (cVar != null) {
            cVar.c();
        }
    }

    public synchronized int c() {
        return this.f77826f;
    }

    public synchronized int d() {
        return this.f77824d;
    }

    public synchronized int e() {
        return this.J;
    }

    public boolean f() {
        return this.f77846z;
    }

    public boolean g() {
        Boolean bool = this.f77828h;
        if (bool == null) {
            return this.f77829i;
        }
        return bool.booleanValue();
    }

    public synchronized boolean h() {
        return this.f77836p;
    }

    public boolean i() {
        return this.D;
    }

    public boolean j() {
        return this.C;
    }

    public boolean k() {
        return this.f77831k;
    }

    public boolean l() {
        return this.E;
    }

    public boolean m() {
        return this.B;
    }

    public synchronized boolean n() {
        return this.I;
    }

    public void c(boolean z16) {
        this.E = z16;
    }

    public synchronized void b(Set<String> set) {
        if (this.f77834n == null) {
            this.f77834n = new HashMap();
        }
        if (set == null) {
            return;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String[] split = it.next().split(",");
            if (split.length == 3) {
                try {
                    this.f77834n.put(split[0].toLowerCase(), Float.valueOf(Float.valueOf(split[1]).floatValue() / Float.valueOf(split[2]).floatValue()));
                } catch (Exception e16) {
                    com.tencent.beacon.base.util.c.a(e16);
                }
            }
        }
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        if (cVar.f77584a != 8) {
            return;
        }
        this.A = cVar.f77585b.containsKey("u_c_a_e") ? ((Boolean) cVar.f77585b.get("u_c_a_e")).booleanValue() : this.A;
        this.f77846z = cVar.f77585b.containsKey("u_c_b_e") ? ((Boolean) cVar.f77585b.get("u_c_b_e")).booleanValue() : this.f77846z;
        this.F = cVar.f77585b.containsKey("u_c_d_s") ? ((Integer) cVar.f77585b.get("u_c_d_s")).intValue() : this.F;
        this.f77831k = cVar.f77585b.containsKey("u_c_p_s") ? ((Boolean) cVar.f77585b.get("u_c_p_s")).booleanValue() : this.f77831k;
        this.B = cVar.f77585b.containsKey("u_s_o_h") ? ((Boolean) cVar.f77585b.get("u_s_o_h")).booleanValue() : this.B;
    }

    public synchronized boolean b(String str) {
        Map<String, Float> map = this.f77834n;
        if (map != null && map.get(str.toLowerCase()) != null) {
            return f77822b.nextInt(1000) + 1 <= ((int) (this.f77834n.get(str.toLowerCase()).floatValue() * 1000.0f));
        }
        return true;
    }

    public int b() {
        return this.F;
    }

    public void b(boolean z16) {
        this.C = z16;
    }

    public void b(int i3) {
        if (i3 < 24 || i3 > 100) {
            return;
        }
        this.f77824d = i3;
    }

    public synchronized void a(Map<String, String> map) {
        if (map != null) {
            b(map);
            try {
                if (this.f77824d == 48) {
                    this.f77824d = com.tencent.beacon.base.util.b.a(map.get("realtimeUploadNum"), this.f77824d, 24, 100);
                }
                if (this.f77826f == 48) {
                    this.f77826f = com.tencent.beacon.base.util.b.a(map.get("normalUploadNum"), this.f77826f, 24, 100);
                }
                if (this.f77827g == 5000) {
                    this.f77827g = com.tencent.beacon.base.util.b.a(map.get("normalPollingTime"), this.f77827g, 2000, 3600000);
                }
                if (this.f77825e == 2000) {
                    this.f77825e = com.tencent.beacon.base.util.b.a(map.get("realtimePollingTime"), this.f77825e, 1000, 10000);
                }
                this.f77832l = com.tencent.beacon.base.util.b.a(map.get("heartOnOff"), this.f77832l);
                this.f77835o = com.tencent.beacon.base.util.b.a(map.get("tidyEF"), this.f77835o);
                this.f77836p = com.tencent.beacon.base.util.b.a(map.get("lauEveSim"), this.f77836p);
                this.f77837q = com.tencent.beacon.base.util.b.a(map.get("zeroPeakOnOff"), this.f77837q);
                String str = map.get("zeroPeakRate");
                if (str != null) {
                    String trim = str.trim();
                    if (trim.length() > 0) {
                        String[] split = trim.split(",");
                        if (split.length == 2) {
                            try {
                                this.f77838r = Float.valueOf(split[0]).floatValue() / Float.valueOf(split[1]).floatValue();
                            } catch (Exception e16) {
                                com.tencent.beacon.base.util.c.a(e16);
                            }
                        }
                    }
                }
                this.I = com.tencent.beacon.base.util.b.a(map.get("straOnOff"), this.I);
                this.J = com.tencent.beacon.base.util.b.a(map.get("straDayMaxCount"), this.J, 1, Integer.MAX_VALUE);
                this.f77839s = com.tencent.beacon.base.util.b.a(map.get("acceleEnable"), this.f77839s);
                this.f77840t = com.tencent.beacon.base.util.b.a(map.get("gyroEnable"), this.f77840t);
                this.f77841u = com.tencent.beacon.base.util.b.a(map.get("magneticEnable"), this.f77841u);
                this.f77842v = com.tencent.beacon.base.util.b.a(map.get("gatherCount"), this.f77842v, 1, 50);
                this.f77843w = com.tencent.beacon.base.util.b.a(map.get("gatherDur"), this.f77843w, 1000L, 20000L);
                this.f77844x = com.tencent.beacon.base.util.b.a(map.get("hertzCount"), this.f77844x, 20, 100);
                this.f77845y = com.tencent.beacon.base.util.b.a(map.get("consuming"), this.f77845y, 60, 86400);
                this.f77846z = com.tencent.beacon.base.util.b.a(map.get("bidEnable"), this.f77846z);
                this.A = com.tencent.beacon.base.util.b.a(map.get("auditEnable"), this.A);
                this.F = com.tencent.beacon.base.util.b.a(map.get("maxDBCount"), this.F, 10000, 100000);
                com.tencent.beacon.base.net.b.b.c(map.get("eventUrl"));
                com.tencent.beacon.base.net.b.b.e(map.get("strategyUrl"));
            } catch (Exception e17) {
                com.tencent.beacon.base.util.c.a(e17);
            }
        }
    }

    public synchronized void a(Set<String> set) {
        this.f77833m = set;
    }

    public synchronized boolean a(String str) {
        Set<String> set;
        set = this.f77833m;
        return (set == null || set.size() <= 0) ? false : this.f77833m.contains(str);
    }

    public synchronized void a(String str, Map<String, Integer> map) {
        f77823c.put(str, map);
    }

    public synchronized boolean a(String str, String str2) {
        Map<String, Integer> map = f77823c.get(str);
        if (map != null && map.get(str2) != null) {
            return f77822b.nextInt(10000) + 1 >= map.get(str2).intValue();
        }
        return false;
    }

    public void a(boolean z16) {
        this.D = z16;
    }

    public void a(int i3) {
        if (i3 < 24 || i3 > 100) {
            return;
        }
        this.f77826f = i3;
    }

    public void a(boolean z16, boolean z17) {
        com.tencent.beacon.base.util.c.a("event report state changed: " + z16, new Object[0]);
        boolean g16 = g();
        if (z17) {
            this.f77828h = Boolean.valueOf(z16);
        } else {
            this.f77829i = z16;
        }
        if (g16 != g()) {
            o();
        }
    }

    public void a(c cVar) {
        this.f77830j = cVar;
    }
}
