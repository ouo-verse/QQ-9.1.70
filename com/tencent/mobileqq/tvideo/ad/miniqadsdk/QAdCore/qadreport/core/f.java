package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f304065c;

    /* renamed from: d, reason: collision with root package name */
    private int f304066d;

    /* renamed from: e, reason: collision with root package name */
    private String f304067e;

    /* renamed from: f, reason: collision with root package name */
    private int f304068f;

    /* renamed from: g, reason: collision with root package name */
    private String f304069g;

    /* renamed from: h, reason: collision with root package name */
    private String f304070h;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, String> f304072j;

    /* renamed from: a, reason: collision with root package name */
    private int f304063a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f304064b = 1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f304071i = true;

    f() {
    }

    public static synchronized f a(d dVar, int i3) {
        synchronized (f.class) {
            if (dVar != null) {
                if (pw2.i.m(dVar.q())) {
                    f fVar = new f();
                    fVar.f304064b = dVar.l();
                    fVar.f304063a = dVar.j();
                    fVar.f304065c = dVar.s();
                    fVar.f304067e = dVar.q();
                    fVar.f304069g = dVar.h();
                    fVar.f304066d = i3;
                    fVar.f304070h = pw2.b.a();
                    fVar.f304071i = dVar.f304058k;
                    fVar.f304072j = dVar.k();
                    return fVar;
                }
            }
            return null;
        }
    }

    public String b() {
        return this.f304069g;
    }

    public int c() {
        return this.f304068f;
    }

    public Map<String, String> d() {
        return this.f304072j;
    }

    public int e() {
        return this.f304066d;
    }

    public String f() {
        return this.f304067e;
    }

    public int g() {
        return this.f304064b;
    }

    public String h() {
        return this.f304070h;
    }

    public synchronized void i() {
        this.f304068f++;
    }

    public boolean j() {
        return this.f304071i;
    }

    public String toString() {
        return "ReportEvent{reportType=" + this.f304066d + ", requestMethod=" + this.f304064b + ", reportParams=" + this.f304065c + ", reportUrl='" + this.f304067e + "', failedCount=" + this.f304068f + ", body='" + this.f304069g + "', uuid='" + this.f304070h + "'}";
    }
}
