package com.tencent.beacon.event;

import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g implements Runnable, com.tencent.beacon.a.a.d {

    /* renamed from: a, reason: collision with root package name */
    private final String f77956a;

    /* renamed from: b, reason: collision with root package name */
    private final int f77957b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.beacon.event.a.a f77958c;

    /* renamed from: g, reason: collision with root package name */
    private final String f77962g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f77963h;

    /* renamed from: i, reason: collision with root package name */
    private int f77964i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f77965j;

    /* renamed from: l, reason: collision with root package name */
    private String f77967l;

    /* renamed from: d, reason: collision with root package name */
    private final Set<Long> f77959d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private final Set<Long> f77960e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private final List<Long> f77961f = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private boolean f77966k = false;

    public g(int i3, com.tencent.beacon.event.a.a aVar, boolean z16) {
        String str;
        int c16;
        this.f77957b = i3;
        this.f77958c = aVar;
        this.f77963h = z16;
        if (z16) {
            str = "t_r_e";
        } else {
            str = "t_n_e";
        }
        this.f77956a = str;
        if (z16) {
            c16 = com.tencent.beacon.d.b.a().d();
        } else {
            c16 = com.tencent.beacon.d.b.a().c();
        }
        this.f77964i = c16;
        this.f77962g = "[EventReport (" + str + ")]";
    }

    private void a(List<EventBean> list, Set<Long> set) {
        JceRequestEntity a16 = com.tencent.beacon.event.c.d.a(list, this.f77963h);
        com.tencent.beacon.base.util.c.a(this.f77962g, 2, "event request entity: %s", a16.toString());
        com.tencent.beacon.base.net.c.c().b(a16).a(new f(this, this.f77956a, this.f77958c, set, this.f77967l));
    }

    private List<EventBean> d() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        Iterator<Long> it = this.f77959d.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        if (sb5.length() > 0) {
            str = sb5.substring(0, sb5.lastIndexOf(","));
        } else {
            str = "";
        }
        return this.f77958c.a(this.f77956a, str, this.f77964i);
    }

    private void e() {
        com.tencent.beacon.a.a.b.a().a(2, this);
    }

    public int b() {
        return this.f77964i;
    }

    public synchronized void c() {
        int c16;
        if (this.f77966k) {
            if (this.f77963h) {
                c16 = com.tencent.beacon.d.b.a().d();
            } else {
                c16 = com.tencent.beacon.d.b.a().c();
            }
            this.f77964i = c16;
            this.f77966k = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f77965j) {
            e();
            this.f77965j = true;
        }
        if (com.tencent.beacon.a.c.e.l().G() && !com.tencent.beacon.base.net.c.c().d()) {
            synchronized (this.f77959d) {
                com.tencent.beacon.base.util.c.a(this.f77962g, 0, "start read EventBean from DB.", new Object[0]);
                List<EventBean> d16 = d();
                if (d16 != null && !d16.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    for (EventBean eventBean : d16) {
                        long cid = eventBean.getCid();
                        this.f77959d.add(Long.valueOf(cid));
                        this.f77960e.add(Long.valueOf(cid));
                        Map<String, String> eventValue = eventBean.getEventValue();
                        if (eventValue != null) {
                            String appKey = eventBean.getAppKey();
                            String str = (String) hashMap.get(appKey);
                            if (str == null) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(appKey);
                                sb5.append(MsgSummary.STR_COLON);
                                str = sb5.toString();
                            }
                            String str2 = eventValue.get("A100");
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(str);
                            sb6.append(str2);
                            sb6.append(", ");
                            hashMap.put(appKey, sb6.toString());
                        }
                    }
                    StringBuilder sb7 = new StringBuilder("--logID: \n");
                    Iterator it = hashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        sb7.append((String) ((Map.Entry) it.next()).getValue());
                        sb7.append("\n");
                    }
                    String sb8 = sb7.toString();
                    this.f77967l = sb8;
                    com.tencent.beacon.base.util.c.a(this.f77962g, 1, "send LogID: %s", sb8);
                    a(d16, this.f77960e);
                    d16.clear();
                    this.f77960e.clear();
                    return;
                }
                com.tencent.beacon.base.util.c.a(this.f77962g, 1, "EventBean List == null. Task end!", new Object[0]);
                com.tencent.beacon.a.b.a.a().a(this.f77957b, false);
                return;
            }
        }
        com.tencent.beacon.a.b.a.a().a(this.f77957b, false);
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        Map map;
        if (cVar.f77584a != 2 || (map = (Map) cVar.f77585b.get("d_m")) == null) {
            return;
        }
        if (this.f77963h) {
            this.f77964i = com.tencent.beacon.base.util.b.a((String) map.get("realtimeUploadNum"), this.f77964i, 24, 100);
        } else {
            this.f77964i = com.tencent.beacon.base.util.b.a((String) map.get("normalUploadNum"), this.f77964i, 24, 100);
        }
    }

    public void a(Set<Long> set) {
        synchronized (this.f77959d) {
            this.f77959d.removeAll(set);
            set.clear();
        }
    }

    public void a(long j3) {
        synchronized (this.f77961f) {
            this.f77961f.add(Long.valueOf(j3));
            if (this.f77961f.size() >= 10) {
                Iterator<Long> it = this.f77961f.iterator();
                long j16 = 0;
                while (it.hasNext()) {
                    j16 += it.next().longValue();
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j16 / this.f77961f.size());
                sb5.append("");
                com.tencent.beacon.a.b.h.e().a("703", sb5.toString());
                this.f77961f.clear();
            }
        }
    }

    public synchronized void a() {
        int i3 = this.f77964i;
        if (i3 >= 2) {
            this.f77964i = i3 >> 1;
            this.f77966k = true;
        }
    }
}
