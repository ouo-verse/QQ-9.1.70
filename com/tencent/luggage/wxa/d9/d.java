package com.tencent.luggage.wxa.d9;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    public static d f124153g;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f124154a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Object f124155b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public long f124156c = 10000000;

    /* renamed from: d, reason: collision with root package name */
    public int f124157d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f124158e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f124159f = 0;

    public static d a() {
        if (f124153g == null) {
            synchronized (e.class) {
                if (f124153g == null) {
                    f124153g = new d();
                }
            }
        }
        return f124153g;
    }

    public com.tencent.luggage.wxa.c9.e b() {
        synchronized (this.f124155b) {
            if (this.f124154a.size() > 0) {
                ArrayList arrayList = this.f124154a;
                return (com.tencent.luggage.wxa.c9.e) arrayList.remove(arrayList.size() - 1);
            }
            int i3 = this.f124157d;
            if (i3 >= this.f124156c) {
                int i16 = this.f124159f + 1;
                this.f124159f = i16;
                if (i16 % 100 == 0) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "size >= FIX_SIZE, size:%d", Integer.valueOf(i3));
                }
                return null;
            }
            int i17 = this.f124158e + 1;
            this.f124158e = i17;
            this.f124157d = i17 * 3536;
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "pool tract count:%d", Integer.valueOf(i17));
            if (this.f124159f > 0) {
                this.f124159f = 0;
            }
            com.tencent.luggage.wxa.c9.e eVar = new com.tencent.luggage.wxa.c9.e();
            eVar.a(true);
            return eVar;
        }
    }

    public void a(com.tencent.luggage.wxa.c9.e eVar) {
        if (eVar == null || eVar.f123439f == null || !eVar.a()) {
            return;
        }
        eVar.b();
        synchronized (this.f124155b) {
            this.f124154a.add(0, eVar);
        }
    }
}
