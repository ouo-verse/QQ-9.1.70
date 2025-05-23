package com.tencent.luggage.wxa.ej;

import com.tencent.luggage.wxa.xa.f;
import com.tencent.luggage.wxa.xa.h;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d implements a {
    public abstract String a(h hVar, c cVar);

    public String a(String str, c cVar) {
        try {
            return a(new h(str), cVar);
        } catch (f unused) {
            return cVar.a(2);
        }
    }
}
