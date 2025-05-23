package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import n25.i;
import n25.k;

/* loaded from: classes31.dex */
public final class NBPPublishServiceKt {
    public static final String desc(k kVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[poiId:");
        sb5.append(kVar.f418086d);
        sb5.append(", name:");
        sb5.append(kVar.f418087e);
        sb5.append(", poiType:");
        sb5.append(kVar.f418088f);
        sb5.append(", typeName:");
        sb5.append(kVar.f418089h);
        sb5.append(", address:");
        sb5.append(kVar.f418090i);
        sb5.append(", districtCode:");
        sb5.append(kVar.f418091m);
        sb5.append(", gps:");
        i iVar = kVar.C;
        sb5.append(iVar != null ? Long.valueOf(iVar.f418080e) : null);
        sb5.append('-');
        i iVar2 = kVar.C;
        sb5.append(iVar2 != null ? Long.valueOf(iVar2.f418079d) : null);
        sb5.append(",distance:");
        sb5.append(kVar.D);
        sb5.append(", hotValue:");
        sb5.append(kVar.E);
        sb5.append(", phone:");
        sb5.append(kVar.F);
        sb5.append(", country:");
        sb5.append(kVar.G);
        sb5.append(", province:");
        sb5.append(kVar.H);
        sb5.append(", city:");
        sb5.append(kVar.I);
        sb5.append(", poiNum:");
        sb5.append(kVar.J);
        sb5.append(", poiOrderType:");
        sb5.append(kVar.K);
        sb5.append(", defaultName:");
        sb5.append(kVar.L);
        sb5.append(", district:");
        sb5.append(kVar.M);
        sb5.append(", dianPingId:");
        sb5.append(kVar.N);
        sb5.append(", distanceText:");
        sb5.append(kVar.P);
        sb5.append(", displayName:");
        sb5.append(kVar.Q);
        sb5.append(']');
        return sb5.toString();
    }
}
