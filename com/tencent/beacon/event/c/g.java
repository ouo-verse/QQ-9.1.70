package com.tencent.beacon.event.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.beacon.a.b.h;
import com.tencent.beacon.event.open.EventType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, g> f77915a = new ConcurrentHashMap(5);

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f77916b;
    private volatile boolean B;

    /* renamed from: m, reason: collision with root package name */
    private final Context f77927m;

    /* renamed from: n, reason: collision with root package name */
    private final String f77928n;

    /* renamed from: p, reason: collision with root package name */
    private long f77930p;

    /* renamed from: t, reason: collision with root package name */
    private long f77934t;

    /* renamed from: u, reason: collision with root package name */
    private long f77935u;

    /* renamed from: v, reason: collision with root package name */
    private long f77936v;

    /* renamed from: w, reason: collision with root package name */
    private long f77937w;

    /* renamed from: x, reason: collision with root package name */
    private long f77938x;

    /* renamed from: y, reason: collision with root package name */
    private long f77939y;

    /* renamed from: z, reason: collision with root package name */
    private SharedPreferences f77940z;

    /* renamed from: c, reason: collision with root package name */
    private final String f77917c = "normal_log_id";

    /* renamed from: d, reason: collision with root package name */
    private final String f77918d = "realtime_log_id";

    /* renamed from: e, reason: collision with root package name */
    private final String f77919e = "immediate_log_id";

    /* renamed from: f, reason: collision with root package name */
    private final String f77920f = "normal_min_log_id";

    /* renamed from: g, reason: collision with root package name */
    private final String f77921g = "normal_max_log_id";

    /* renamed from: h, reason: collision with root package name */
    private final String f77922h = "realtime_min_log_id";

    /* renamed from: i, reason: collision with root package name */
    private final String f77923i = "realtime_max_log_id";

    /* renamed from: j, reason: collision with root package name */
    private final String f77924j = "immediate_min_log_id";

    /* renamed from: k, reason: collision with root package name */
    private final String f77925k = "immediate_max_log_id";

    /* renamed from: l, reason: collision with root package name */
    private final String f77926l = "on_date";

    /* renamed from: o, reason: collision with root package name */
    private final List<String> f77929o = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private AtomicLong f77931q = new AtomicLong(0);

    /* renamed from: r, reason: collision with root package name */
    private AtomicLong f77932r = new AtomicLong(0);

    /* renamed from: s, reason: collision with root package name */
    private AtomicLong f77933s = new AtomicLong(0);
    private final Runnable A = new e(this);

    g(Context context, String str) {
        this.f77927m = context;
        this.f77928n = str;
    }

    private void c() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (e()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f77930p);
            String str6 = "";
            sb5.append("");
            String sb6 = sb5.toString();
            String c16 = com.tencent.beacon.a.c.b.c(this.f77927m);
            String packageName = this.f77927m.getPackageName();
            if (this.f77934t == 0) {
                str = "";
            } else {
                str = (this.f77934t - 1) + "";
            }
            if (this.f77935u == 0) {
                str2 = "";
            } else {
                str2 = this.f77935u + "";
            }
            if (this.f77936v == 0) {
                str3 = "";
            } else {
                str3 = (this.f77936v - 1) + "";
            }
            if (this.f77937w == 0) {
                str4 = "";
            } else {
                str4 = this.f77937w + "";
            }
            if (this.f77938x == 0) {
                str5 = "";
            } else {
                str5 = (this.f77938x - 1) + "";
            }
            if (this.f77939y != 0) {
                str6 = this.f77939y + "";
            }
            h.e().a("701", "process_name=" + c16 + "&real_logid_min=" + str + "&real_logid_max=" + str2 + "&normal_logid_min=" + str3 + "&normal_logid_max=" + str4 + "&immediate_logid_min=" + str5 + "&immediate_logid_max=" + str6 + "&logid_day=" + sb6.substring(0, sb6.length() - 3) + "&appkey=" + this.f77928n + "&bundleid=" + packageName);
            g();
        }
    }

    private void d() {
        SharedPreferences a16 = a(this.f77927m);
        this.f77930p = a16.getLong("on_date", 0L);
        this.f77932r.set(a16.getLong("realtime_log_id", 0L));
        this.f77931q.set(a16.getLong("normal_log_id", 0L));
        this.f77933s.set(a16.getLong("immediate_log_id", 0L));
        this.f77934t = a16.getLong("realtime_min_log_id", 0L);
        this.f77935u = a16.getLong("realtime_max_log_id", 0L);
        this.f77936v = a16.getLong("normal_min_log_id", 0L);
        this.f77937w = a16.getLong("normal_max_log_id", 0L);
        this.f77938x = a16.getLong("immediate_min_log_id", 0L);
        this.f77939y = a16.getLong("immediate_max_log_id", 0L);
        com.tencent.beacon.base.util.c.a("[LogID " + this.f77928n + "]", " load LogID from sp, date: %s , realtime: %d, normal: %d, immediate: %d", Long.valueOf(this.f77930p), Long.valueOf(this.f77932r.get()), Long.valueOf(this.f77931q.get()), Long.valueOf(this.f77933s.get()));
    }

    private boolean e() {
        long c16 = com.tencent.beacon.base.util.b.c();
        long j3 = this.f77930p;
        return (j3 == 0 || com.tencent.beacon.base.util.b.a(c16, j3)) ? false : true;
    }

    private void f() {
        HashMap hashMap = new HashMap();
        hashMap.put("e_l_e_k", this.f77928n);
        com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(14, hashMap));
    }

    private void g() {
        this.f77934t = this.f77935u + 1;
        this.f77936v = this.f77937w + 1;
        this.f77938x = this.f77939y + 1;
    }

    public synchronized boolean b() {
        return this.B;
    }

    public static synchronized g a(Context context, @NonNull String str) {
        g gVar;
        synchronized (g.class) {
            Map<String, g> map = f77915a;
            gVar = map.get(str);
            if (gVar == null) {
                gVar = new g(context, str);
                map.put(str, gVar);
            }
        }
        return gVar;
    }

    public synchronized String a(String str, EventType eventType) {
        if (!this.B) {
            a();
            this.B = true;
        }
        if (this.f77929o.contains(str)) {
            return "";
        }
        long a16 = a(eventType);
        c();
        this.f77930p = com.tencent.beacon.base.util.b.c();
        a(a16, eventType);
        com.tencent.beacon.base.util.c.a("[stat " + this.f77928n + "]", "type: %s, code: %s, logID: %s.", eventType, str, Long.valueOf(a16));
        f77916b.post(this.A);
        return a16 + "";
    }

    private long a(EventType eventType) {
        switch (f.f77914a[eventType.ordinal()]) {
            case 1:
            case 2:
                return this.f77931q.incrementAndGet();
            case 3:
            case 4:
                return this.f77932r.incrementAndGet();
            case 5:
            case 6:
                return this.f77933s.incrementAndGet();
            default:
                return -1L;
        }
    }

    private void a(long j3, EventType eventType) {
        if (eventType != EventType.REALTIME && eventType != EventType.DT_REALTIME) {
            if (eventType != EventType.NORMAL && eventType != EventType.DT_NORMAL) {
                if (eventType == EventType.IMMEDIATE_MSF || eventType == EventType.IMMEDIATE_WNS) {
                    long j16 = this.f77939y;
                    this.f77939y = j16 == 0 ? j3 : Math.max(j3, j16);
                    long j17 = this.f77938x;
                    if (j17 != 0) {
                        j3 = Math.min(j3, j17);
                    }
                    this.f77938x = j3;
                    return;
                }
                return;
            }
            long j18 = this.f77937w;
            this.f77937w = j18 == 0 ? j3 : Math.max(j3, j18);
            long j19 = this.f77936v;
            if (j19 != 0) {
                j3 = Math.min(j3, j19);
            }
            this.f77936v = j3;
            return;
        }
        long j26 = this.f77935u;
        this.f77935u = j26 == 0 ? j3 : Math.max(j3, j26);
        long j27 = this.f77934t;
        if (j27 != 0) {
            j3 = Math.min(j3, j27);
        }
        this.f77934t = j3;
    }

    public synchronized void a() {
        if (this.B) {
            return;
        }
        com.tencent.beacon.base.util.c.a("LogIDGenerator init appkey = %s", this.f77928n);
        f77916b = com.tencent.beacon.a.b.a.a().a(113);
        this.f77929o.add("rqd_model");
        this.f77929o.add("rqd_appresumed");
        d();
        f();
        this.B = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences a(Context context) {
        if (this.f77940z == null) {
            this.f77940z = context.getSharedPreferences("new_b_log_ID_" + com.tencent.beacon.a.c.b.c(context) + "_" + this.f77928n, 0);
        }
        return this.f77940z;
    }
}
