package com.tencent.luggage.wxa.dm;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public void a(String str, e eVar) {
        w.a("IconLoadErrorHandler ", "setTabBarFail: " + str);
        if (eVar.b() != null) {
            eVar.b().b(eVar.d());
        }
    }
}
