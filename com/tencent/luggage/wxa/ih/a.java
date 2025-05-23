package com.tencent.luggage.wxa.ih;

import com.tencent.luggage.wxa.ih.d;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public Map f130360a = new ConcurrentHashMap();

    @Override // com.tencent.luggage.wxa.ih.d
    public void a(String str, d.c cVar) {
        this.f130360a.put(str, cVar);
    }

    public void b() {
        Iterator it = this.f130360a.values().iterator();
        while (it.hasNext()) {
            ((d.c) it.next()).onStart();
        }
    }

    @Override // com.tencent.luggage.wxa.ih.d
    public d.c c(String str) {
        return (d.c) this.f130360a.get(str);
    }

    @Override // com.tencent.luggage.wxa.ih.d
    public void i(String str) {
        this.f130360a.remove(str);
    }

    public void a(String str, int i3, int i16) {
        Iterator it = this.f130360a.values().iterator();
        while (it.hasNext()) {
            ((d.c) it.next()).a(str, i3, i16);
        }
    }

    public void a(byte[] bArr, boolean z16) {
        Iterator it = this.f130360a.values().iterator();
        while (it.hasNext()) {
            ((d.c) it.next()).a(bArr, z16);
        }
    }
}
