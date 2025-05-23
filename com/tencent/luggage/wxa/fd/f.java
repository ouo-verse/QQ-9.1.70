package com.tencent.luggage.wxa.fd;

import com.tencent.luggage.wxa.fd.h;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.hn.t6;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.n4.a;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.x0;
import com.tencent.luggage.wxa.tn.y0;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f125712a = y0.a(R.string.f159111rf);

    public static com.tencent.luggage.wxa.yi.a a(com.tencent.luggage.wxa.c5.e eVar, com.tencent.luggage.wxa.j4.g gVar, b bVar) {
        ArrayList arrayList;
        int i3;
        com.tencent.luggage.wxa.j4.d S = eVar.S();
        com.tencent.luggage.wxa.yi.a aVar = new com.tencent.luggage.wxa.yi.a();
        boolean z16 = false;
        aVar.f145791a = S.o() || S.l();
        aVar.f145792b = c(gVar);
        int i16 = bVar.g().f125643a;
        if (i16 > 0) {
            aVar.f145793c = i16;
        }
        int i17 = bVar.g().f125644b;
        if (i17 > 0) {
            aVar.f145794d = i17;
        }
        int i18 = bVar.g().f125645c;
        if (i18 > 0) {
            aVar.f145795e = i18;
        }
        int i19 = bVar.g().f125646d;
        if (i19 > 0) {
            aVar.f145796f = i19;
        }
        aVar.f145797g = gVar.O;
        aVar.f145798h = gVar.R;
        aVar.f145799i = gVar.P;
        aVar.f145800j = gVar.Q;
        aVar.f145801k = gVar.X;
        aVar.f145802l = gVar.Y;
        aVar.f145803m = gVar.Z;
        aVar.C = gVar.f130825a0;
        aVar.D = gVar.f130826b0;
        aVar.E = gVar.f130827c0;
        h.e eVar2 = gVar.f130831g0.f125751m;
        int i26 = eVar2.f125769a;
        if (i26 == 1) {
            ArrayList arrayList2 = eVar2.f125770b;
            if (arrayList2 != null) {
                aVar.F = arrayList2;
            }
        } else if (i26 == 2 && (arrayList = eVar2.f125771c) != null) {
            aVar.G = arrayList;
        }
        aVar.N = i26;
        aVar.H = a((com.tencent.luggage.wxa.ic.g) eVar);
        if (S.l()) {
            i3 = gVar.f130831g0.N;
        } else {
            i3 = gVar.f130831g0.f125735e;
        }
        aVar.I = i3;
        aVar.J = gVar.T;
        aVar.P = gVar.U;
        aVar.K = a();
        com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.AppBrandConfigAdapter", "runtime(%s).getNetworkConfig.userAgentString = [ %s ]", eVar.getAppId(), aVar.K);
        com.tencent.luggage.wxa.cg.a aVar2 = (com.tencent.luggage.wxa.cg.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.cg.a.class);
        if (aVar2 != null) {
            aVar.L = aVar2.e(bVar.U);
        } else {
            com.tencent.luggage.wxa.tn.w.f("", "getNetworkConfig, referrerHelper is null");
        }
        aVar.M = b(gVar);
        aVar.O = S.Q;
        a.b bVar2 = a.b.f135289a;
        if (bVar2.a() != null) {
            String b16 = bVar2.a().b("clicfg_appbrand_network_check_user_trust_ca");
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.AppBrandConfigAdapter", "exptCheckCA = %s", b16);
            if (!w0.c(b16) && b16.equalsIgnoreCase("false")) {
                aVar.R = false;
            }
        } else {
            com.tencent.luggage.wxa.tn.w.d("Luggage.FULL.AppBrandConfigAdapter", "exptCheckCA has no delegate");
        }
        boolean a16 = e.a.a(gVar.a());
        aVar.Q = a16;
        if (a16 || !w0.a((List) aVar.H)) {
            com.tencent.luggage.wxa.ic.l h06 = eVar.h0();
            com.tencent.luggage.wxa.ei.j jsRuntime = h06 == null ? null : h06.getJsRuntime();
            com.tencent.luggage.wxa.ei.q qVar = jsRuntime != null ? (com.tencent.luggage.wxa.ei.q) jsRuntime.a(com.tencent.luggage.wxa.ei.q.class) : null;
            if (qVar != null && qVar.g()) {
                z16 = true;
            }
            if (!z16) {
                com.tencent.luggage.wxa.yi.q.b(aVar);
            }
        }
        return aVar;
    }

    public static c0.a b() {
        c0.a aVar = new c0.a();
        aVar.f142666e = h.b().K;
        return aVar;
    }

    public static boolean c(com.tencent.luggage.wxa.j4.g gVar) {
        boolean z16;
        if (gVar.f125966l.f151861a != 1 && gVar.f125966l.f151861a != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (gVar.I) {
            if (z16 && gVar.H) {
                return false;
            }
            return true;
        }
        if (z16 && gVar.F) {
            return false;
        }
        return true;
    }

    public static String b(com.tencent.luggage.wxa.j4.g gVar) {
        h.e eVar;
        h hVar = gVar.f130831g0;
        String str = (hVar == null || (eVar = hVar.f125751m) == null) ? "" : eVar.f125776h;
        if (w0.c(str)) {
            str = f125712a;
        }
        return "https://" + str + "/" + gVar.f125956b + "/" + gVar.f125966l.pkgVersion + "/page-frame.html";
    }

    public static com.tencent.luggage.wxa.qc.a a(com.tencent.luggage.wxa.c5.e eVar) {
        com.tencent.luggage.wxa.j4.g j06 = eVar.j0();
        b E = eVar.E();
        com.tencent.luggage.wxa.qc.a aVar = new com.tencent.luggage.wxa.qc.a();
        if (j06 != null && E != null) {
            if (e.a.a(j06.a())) {
                aVar.f138598a = E.h().contains("audio");
                aVar.f138599b = E.h().contains("location");
                aVar.f138600c = E.h().contains(QQPermissionConstants.Permission.BLUE_TOOTH_GROUP);
            } else {
                aVar.f138598a = j06.f125959e;
                aVar.f138599b = j06.f125960f;
                aVar.f138600c = j06.f125961g;
            }
        }
        return aVar;
    }

    public static ArrayList a(com.tencent.luggage.wxa.ic.g gVar) {
        LinkedList linkedList;
        ArrayList arrayList = new ArrayList();
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        gVar.P().readFile("cer", iVar);
        if (iVar.f141499a == null) {
            return arrayList;
        }
        byte[] a16 = com.tencent.luggage.wxa.tk.c.a((ByteBuffer) iVar.f141499a);
        try {
            t6 t6Var = new t6();
            t6Var.a(a16);
            linkedList = t6Var.f128738d;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("", "readPkgCertificate, parse error: " + e16);
        }
        if (linkedList == null) {
            return arrayList;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.luggage.wxa.fn.c) it.next()).a());
        }
        return arrayList;
    }

    public static com.tencent.luggage.wxa.bf.a a(com.tencent.luggage.wxa.j4.d dVar) {
        n0.d.a aVar = dVar.f130789a0;
        h b16 = h.b();
        com.tencent.luggage.wxa.bf.a aVar2 = new com.tencent.luggage.wxa.bf.a();
        long j3 = b16.f125733d;
        aVar2.f122515b = j3;
        if (j3 <= 0) {
            aVar2.f122515b = 300L;
        }
        long j16 = aVar.f125908m;
        aVar2.f122514a = j16;
        if (j16 <= 0) {
            aVar2.f122514a = 10L;
        }
        long j17 = aVar.C;
        aVar2.f122516c = j17;
        if (j17 <= 0) {
            aVar2.f122516c = 300L;
        }
        long j18 = aVar.D;
        aVar2.f122517d = j18;
        if (j18 <= 0) {
            aVar2.f122517d = 100L;
        }
        long j19 = b16.X;
        aVar2.f122518e = j19;
        if (j19 <= 0) {
            aVar2.f122518e = 30L;
        }
        long j26 = aVar.V;
        aVar2.f122519f = j26;
        if (j26 <= 0) {
            aVar2.f122519f = 200L;
        }
        return aVar2;
    }

    public static com.tencent.luggage.wxa.qj.a a(com.tencent.luggage.wxa.j4.g gVar) {
        com.tencent.luggage.wxa.qj.a aVar = new com.tencent.luggage.wxa.qj.a();
        aVar.f138883a = gVar.G && (gVar.a() == 1 || gVar.a() == 2 || x0.a());
        aVar.f138884b = gVar.a() != 0;
        aVar.f138885c = gVar.F;
        return aVar;
    }

    public static String a() {
        return a0.a(com.tencent.luggage.wxa.tn.z.c(), o.d());
    }
}
