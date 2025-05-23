package com.tencent.luggage.wxa.d9;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    public static c f124149d;

    /* renamed from: a, reason: collision with root package name */
    public volatile ArrayList f124150a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public long f124151b = 50;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f124152c = 0;

    public static c a() {
        if (f124149d == null) {
            synchronized (c.class) {
                if (f124149d == null) {
                    f124149d = new c();
                }
            }
        }
        return f124149d;
    }

    public synchronized com.tencent.luggage.wxa.c9.c b() {
        if (this.f124150a.size() > 0) {
            return (com.tencent.luggage.wxa.c9.c) this.f124150a.remove(this.f124150a.size() - 1);
        }
        if (this.f124152c >= this.f124151b) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioOutputMixBufferPool", "size >= FIX_SIZE, size:%d", Integer.valueOf(this.f124152c));
            return null;
        }
        this.f124152c++;
        return new com.tencent.luggage.wxa.c9.c();
    }

    public void c() {
        for (int i3 = 0; i3 < this.f124150a.size(); i3++) {
            ((com.tencent.luggage.wxa.c9.c) this.f124150a.get(i3)).f123417d = null;
        }
        this.f124150a.clear();
    }

    public synchronized void a(com.tencent.luggage.wxa.c9.c cVar) {
        if (cVar != null) {
            if (cVar.f123417d != null) {
                cVar.f123415b = 0;
                cVar.f123414a = 0;
                cVar.f123418e.clear();
                byte[] bArr = cVar.f123417d;
                Arrays.fill(bArr, 0, bArr.length, (byte) 0);
                this.f124150a.add(0, cVar);
                this.f124152c--;
            }
        }
    }
}
