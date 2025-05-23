package com.google.android.vending.licensing;

import android.content.Context;
import android.util.Log;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class k implements h {

    /* renamed from: a, reason: collision with root package name */
    private long f34654a;

    /* renamed from: b, reason: collision with root package name */
    private long f34655b;

    /* renamed from: c, reason: collision with root package name */
    private long f34656c;

    /* renamed from: d, reason: collision with root package name */
    private long f34657d;

    /* renamed from: e, reason: collision with root package name */
    private long f34658e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f34659f;

    /* renamed from: g, reason: collision with root package name */
    private i f34660g;

    public k(Context context, g gVar) {
        i iVar = new i(context.getSharedPreferences("com.google.android.vending.licensing.ServerManagedPolicy", 0), gVar);
        this.f34660g = iVar;
        this.f34659f = Integer.parseInt(iVar.b("lastResponse", Integer.toString(291)));
        this.f34654a = Long.parseLong(this.f34660g.b("validityTimestamp", "0"));
        this.f34655b = Long.parseLong(this.f34660g.b("retryUntil", "0"));
        this.f34656c = Long.parseLong(this.f34660g.b("maxRetries", "0"));
        this.f34657d = Long.parseLong(this.f34660g.b("retryCount", "0"));
    }

    private Map<String, String> c(String str) {
        HashMap hashMap = new HashMap();
        try {
            o1.b.a(new URI(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str), hashMap);
        } catch (URISyntaxException unused) {
            Log.w("ServerManagedPolicy", "Invalid syntax error while decoding extras data from server.");
        }
        return hashMap;
    }

    private void d(int i3) {
        this.f34658e = System.currentTimeMillis();
        this.f34659f = i3;
        this.f34660g.c("lastResponse", Integer.toString(i3));
    }

    private void e(String str) {
        Long l3;
        try {
            l3 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("ServerManagedPolicy", "Licence retry count (GR) missing, grace period disabled");
            l3 = 0L;
            str = "0";
        }
        this.f34656c = l3.longValue();
        this.f34660g.c("maxRetries", str);
    }

    private void f(long j3) {
        this.f34657d = j3;
        this.f34660g.c("retryCount", Long.toString(j3));
    }

    private void g(String str) {
        Long l3;
        try {
            l3 = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("ServerManagedPolicy", "License retry timestamp (GT) missing, grace period disabled");
            l3 = 0L;
            str = "0";
        }
        this.f34655b = l3.longValue();
        this.f34660g.c("retryUntil", str);
    }

    private void h(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            Log.w("ServerManagedPolicy", "License validity timestamp (VT) missing, caching for a minute");
            valueOf = Long.valueOf(System.currentTimeMillis() + 60000);
            str = Long.toString(valueOf.longValue());
        }
        this.f34654a = valueOf.longValue();
        this.f34660g.c("validityTimestamp", str);
    }

    @Override // com.google.android.vending.licensing.h
    public void a(int i3, j jVar) {
        if (i3 != 291) {
            f(0L);
        } else {
            f(this.f34657d + 1);
        }
        if (i3 == 256) {
            Map<String, String> c16 = c(jVar.f34653g);
            this.f34659f = i3;
            h(c16.get("VT"));
            g(c16.get("GT"));
            e(c16.get("GR"));
        } else if (i3 == 561) {
            h("0");
            g("0");
            e("0");
        }
        d(i3);
        this.f34660g.a();
    }

    @Override // com.google.android.vending.licensing.h
    public boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = this.f34659f;
        if (i3 == 256) {
            if (currentTimeMillis <= this.f34654a) {
                return true;
            }
        } else if (i3 == 291 && currentTimeMillis < this.f34658e + 60000) {
            if (currentTimeMillis <= this.f34655b || this.f34657d <= this.f34656c) {
                return true;
            }
            return false;
        }
        return false;
    }
}
