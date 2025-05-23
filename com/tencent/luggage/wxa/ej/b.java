package com.tencent.luggage.wxa.ej;

import com.tencent.luggage.wxa.xa.f;
import com.tencent.luggage.wxa.xa.h;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements com.tencent.luggage.wxa.ej.a {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(int i3, String str);
    }

    public String a(String str, c cVar) {
        try {
            a(new h(str), cVar);
            return null;
        } catch (f unused) {
            return cVar.a(2);
        }
    }

    public abstract void a(h hVar, c cVar);

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }
}
