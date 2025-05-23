package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.model;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> a(@NonNull c cVar) {
        ArrayList arrayList = new ArrayList();
        List<kq4.a> list = cVar.f270524a;
        if (list == null) {
            return arrayList;
        }
        for (kq4.a aVar : list) {
            if (aVar != null) {
                arrayList.add(d(aVar));
            }
        }
        return arrayList;
    }

    private static com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a b(@NonNull kq4.d dVar) {
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar = new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a(dVar.f412898u);
        aVar.f270491a = dVar.f412898u;
        aVar.f270492b = dVar.f412879b;
        aVar.f270493c = dVar.f412880c;
        aVar.f270494d = dVar.f412881d;
        aVar.f270495e = dVar.f412882e;
        aVar.f270496f = dVar.f412883f;
        aVar.f270497g = dVar.f412884g;
        aVar.f270498h = dVar.f412885h;
        aVar.f270499i = dVar.f412894q;
        aVar.f270500j = dVar.f412895r;
        aVar.f270501k = dVar.f412896s;
        aVar.f270502l = dVar.f412897t;
        aVar.f270503m = dVar.f412899v;
        return aVar;
    }

    private static List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a> c(kq4.d[] dVarArr) {
        ArrayList arrayList = new ArrayList();
        if (dVarArr == null) {
            return arrayList;
        }
        for (kq4.d dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(b(dVar));
            }
        }
        return arrayList;
    }

    private static com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b d(@NonNull kq4.a aVar) {
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar = new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b();
        bVar.f270507a = aVar.f412867a;
        bVar.f270508b = aVar.f412868b;
        bVar.f270509c = aVar.f412869c;
        bVar.f270510d = aVar.f412870d;
        bVar.f270511e = c(aVar.f412871e);
        return bVar;
    }
}
