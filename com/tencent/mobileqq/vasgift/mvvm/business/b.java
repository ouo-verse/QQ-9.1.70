package com.tencent.mobileqq.vasgift.mvvm.business;

import java.util.List;
import rh2.g;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends com.tencent.mobileqq.mvvm.a {
    public List<com.tencent.mobileqq.qqgift.data.service.e> j(nh2.c cVar) {
        if (cVar != null) {
            return cVar.a().H();
        }
        return null;
    }

    public void k(nh2.c cVar, com.tencent.mobileqq.qqgift.data.service.a aVar, g gVar) {
        if (cVar != null) {
            cVar.a().J(aVar, gVar);
        }
    }

    public void l(nh2.c cVar, List<Long> list, rh2.e eVar) {
        if (cVar != null) {
            cVar.a().o(list, eVar);
        }
    }

    public void m(nh2.c cVar, g gVar) {
        if (cVar != null) {
            cVar.a().V(gVar);
        }
    }

    public void n(nh2.c cVar, List<Long> list, rh2.e eVar) {
        if (cVar != null) {
            cVar.a().v(list, eVar);
        }
    }

    public boolean o(nh2.c cVar) {
        if (cVar != null) {
            return cVar.a().r();
        }
        return false;
    }
}
