package com.tencent.luggage.wxa.ji;

import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.hn.li;
import com.tencent.luggage.wxa.hn.vf;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static vf a(n nVar) {
        vf vfVar = null;
        if (nVar == null) {
            return null;
        }
        int i3 = nVar.f125847a;
        if (1 == i3 || 5 == i3 || 4 == i3 || 2 == i3) {
            vfVar = new vf();
            vfVar.f128919d = nVar.f125848b;
            vfVar.f128920e = nVar.f125854h;
            vfVar.f128921f = nVar.f125853g;
        }
        if (nVar.f125854h != 0) {
            if (vfVar == null) {
                vfVar = new vf();
            }
            vfVar.f128920e = nVar.f125854h;
        }
        return vfVar;
    }

    public static li b(n nVar) {
        if (nVar == null || 2 != nVar.f125847a) {
            return null;
        }
        li liVar = new li();
        liVar.f128097d = nVar.f125848b;
        liVar.f128098e = nVar.f125852f;
        return liVar;
    }
}
