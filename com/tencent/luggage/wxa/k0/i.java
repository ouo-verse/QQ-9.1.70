package com.tencent.luggage.wxa.k0;

import com.tencent.luggage.wxa.d0.o;
import com.tencent.luggage.wxa.m.t;
import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final o f131409a;

    /* renamed from: b, reason: collision with root package name */
    public final g f131410b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f131411c;

    /* renamed from: d, reason: collision with root package name */
    public final t[] f131412d;

    public i(o oVar, g gVar, Object obj, t[] tVarArr) {
        this.f131409a = oVar;
        this.f131410b = gVar;
        this.f131411c = obj;
        this.f131412d = tVarArr;
    }

    public boolean a(i iVar) {
        if (iVar == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.f131410b.f131405a; i3++) {
            if (!a(iVar, i3)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(i iVar, int i3) {
        return iVar != null && v.a(this.f131410b.a(i3), iVar.f131410b.a(i3)) && v.a(this.f131412d[i3], iVar.f131412d[i3]);
    }
}
