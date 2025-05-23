package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b implements h {

    /* renamed from: a, reason: collision with root package name */
    private long f34628a;

    /* renamed from: b, reason: collision with root package name */
    private long f34629b;

    /* renamed from: c, reason: collision with root package name */
    private long f34630c;

    /* renamed from: d, reason: collision with root package name */
    private long f34631d;

    /* renamed from: f, reason: collision with root package name */
    private int f34633f;

    /* renamed from: g, reason: collision with root package name */
    private i f34634g;

    /* renamed from: e, reason: collision with root package name */
    private long f34632e = 0;

    /* renamed from: h, reason: collision with root package name */
    private Vector<String> f34635h = new Vector<>();

    /* renamed from: i, reason: collision with root package name */
    private Vector<String> f34636i = new Vector<>();

    /* renamed from: j, reason: collision with root package name */
    private Vector<Long> f34637j = new Vector<>();

    public b(Context context, g gVar) {
        i iVar = new i(context.getSharedPreferences("com.google.android.vending.licensing.APKExpansionPolicy", 0), gVar);
        this.f34634g = iVar;
        this.f34633f = Integer.parseInt(iVar.b("lastResponse", Integer.toString(291)));
        this.f34628a = Long.parseLong(this.f34634g.b("validityTimestamp", "0"));
        this.f34629b = Long.parseLong(this.f34634g.b("retryUntil", "0"));
        this.f34630c = Long.parseLong(this.f34634g.b("maxRetries", "0"));
        this.f34631d = Long.parseLong(this.f34634g.b("retryCount", "0"));
    }

    private Map<String, String> c(String str) {
        HashMap hashMap = new HashMap();
        try {
            o1.b.a(new URI(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str), hashMap);
        } catch (URISyntaxException unused) {
            Log.w("APKExpansionPolicy", "Invalid syntax error while decoding extras data from server.");
        }
        return hashMap;
    }

    private void l(int i3) {
        this.f34632e = System.currentTimeMillis();
        this.f34633f = i3;
        this.f34634g.c("lastResponse", Integer.toString(i3));
    }

    private void m(String str) {
        Long l3;
        try {
            l3 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "Licence retry count (GR) missing, grace period disabled");
            l3 = 0L;
            str = "0";
        }
        this.f34630c = l3.longValue();
        this.f34634g.c("maxRetries", str);
    }

    private void n(long j3) {
        this.f34631d = j3;
        this.f34634g.c("retryCount", Long.toString(j3));
    }

    private void o(String str) {
        Long l3;
        try {
            l3 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "License retry timestamp (GT) missing, grace period disabled");
            l3 = 0L;
            str = "0";
        }
        this.f34629b = l3.longValue();
        this.f34634g.c("retryUntil", str);
    }

    private void p(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("APKExpansionPolicy", "License validity timestamp (VT) missing, caching for a minute");
            valueOf = Long.valueOf(System.currentTimeMillis() + 60000);
            str = Long.toString(valueOf.longValue());
        }
        this.f34628a = valueOf.longValue();
        this.f34634g.c("validityTimestamp", str);
    }

    @Override // com.google.android.vending.licensing.h
    public void a(int i3, j jVar) {
        if (i3 != 291) {
            n(0L);
        } else {
            n(this.f34631d + 1);
        }
        if (i3 == 256) {
            Map<String, String> c16 = c(jVar.f34653g);
            this.f34633f = i3;
            p(Long.toString(System.currentTimeMillis() + 60000));
            for (String str : c16.keySet()) {
                if (str.equals("VT")) {
                    p(c16.get(str));
                } else if (str.equals("GT")) {
                    o(c16.get(str));
                } else if (str.equals("GR")) {
                    m(c16.get(str));
                } else if (str.startsWith("FILE_URL")) {
                    k(Integer.parseInt(str.substring(8)) - 1, c16.get(str));
                } else if (str.startsWith("FILE_NAME")) {
                    i(Integer.parseInt(str.substring(9)) - 1, c16.get(str));
                } else if (str.startsWith("FILE_SIZE")) {
                    j(Integer.parseInt(str.substring(9)) - 1, Long.parseLong(c16.get(str)));
                }
            }
        } else if (i3 == 561) {
            p("0");
            o("0");
            m("0");
        }
        l(i3);
        this.f34634g.a();
    }

    @Override // com.google.android.vending.licensing.h
    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = this.f34633f;
        if (i3 == 256) {
            if (currentTimeMillis <= this.f34628a) {
                return true;
            }
        } else if (i3 == 291 && currentTimeMillis < this.f34632e + 60000) {
            if (currentTimeMillis <= this.f34629b || this.f34631d <= this.f34630c) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String d(int i3) {
        if (i3 < this.f34636i.size()) {
            return this.f34636i.elementAt(i3);
        }
        return null;
    }

    public long e(int i3) {
        if (i3 < this.f34637j.size()) {
            return this.f34637j.elementAt(i3).longValue();
        }
        return -1L;
    }

    public String f(int i3) {
        if (i3 < this.f34635h.size()) {
            return this.f34635h.elementAt(i3);
        }
        return null;
    }

    public int g() {
        return this.f34635h.size();
    }

    public void h() {
        this.f34634g.c("lastResponse", Integer.toString(291));
        o("0");
        m("0");
        n(Long.parseLong("0"));
        p("0");
        this.f34634g.a();
    }

    public void i(int i3, String str) {
        if (i3 >= this.f34636i.size()) {
            this.f34636i.setSize(i3 + 1);
        }
        this.f34636i.set(i3, str);
    }

    public void j(int i3, long j3) {
        if (i3 >= this.f34637j.size()) {
            this.f34637j.setSize(i3 + 1);
        }
        this.f34637j.set(i3, Long.valueOf(j3));
    }

    public void k(int i3, String str) {
        if (i3 >= this.f34635h.size()) {
            this.f34635h.setSize(i3 + 1);
        }
        this.f34635h.set(i3, str);
    }
}
