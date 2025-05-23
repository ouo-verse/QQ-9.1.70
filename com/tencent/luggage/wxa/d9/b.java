package com.tencent.luggage.wxa.d9;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static b f124147b;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f124148a = new ArrayList();

    public static b a() {
        if (f124147b == null) {
            synchronized (b.class) {
                if (f124147b == null) {
                    f124147b = new b();
                }
            }
        }
        return f124147b;
    }

    public synchronized com.tencent.luggage.wxa.c9.b b() {
        if (this.f124148a.size() > 0) {
            return (com.tencent.luggage.wxa.c9.b) this.f124148a.remove(r0.size() - 1);
        }
        return new com.tencent.luggage.wxa.c9.b();
    }

    public synchronized void a(com.tencent.luggage.wxa.c9.b bVar) {
        if (bVar != null) {
            if (bVar.f123417d != null) {
                bVar.f123415b = 0;
                bVar.f123414a = 0;
                bVar.f123418e.clear();
                byte[] bArr = bVar.f123417d;
                Arrays.fill(bArr, 0, bArr.length, (byte) 0);
                this.f124148a.add(0, bVar);
            }
        }
    }
}
