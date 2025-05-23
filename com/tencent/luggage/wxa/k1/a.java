package com.tencent.luggage.wxa.k1;

import com.tencent.luggage.wxa.hd.a;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements a.InterfaceC6261a {
    public abstract void a(String str, a.c cVar);

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public void a(String str, Map map, a.c cVar) {
        a(str, cVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a.InterfaceC6261a)) {
            return false;
        }
        if (b().equalsIgnoreCase(((a.InterfaceC6261a) obj).b())) {
            return true;
        }
        return super.equals(obj);
    }
}
