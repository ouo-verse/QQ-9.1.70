package com.tencent.luggage.wxa.ic;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class t0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        Object newInstance();
    }

    public static com.tencent.luggage.wxa.j4.g a(a aVar, com.tencent.luggage.wxa.fd.n0 n0Var) {
        com.tencent.luggage.wxa.j4.g gVar = (com.tencent.luggage.wxa.j4.g) aVar.newInstance();
        a(gVar, n0Var);
        return gVar;
    }

    public static com.tencent.luggage.wxa.j4.g a(com.tencent.luggage.wxa.j4.g gVar, com.tencent.luggage.wxa.fd.n0 n0Var) {
        gVar.f125955a = n0Var.f138469h;
        gVar.f125957c = n0Var.f138479r;
        gVar.f125956b = n0Var.f138467f;
        gVar.f125958d = n0Var.g().f125894a.f125899d;
        gVar.N = n0Var.g().f125894a.f125900e;
        gVar.Q = n0Var.g().f125894a.f125903h;
        gVar.R = n0Var.g().f125894a.f125904i;
        gVar.S = n0Var.g().f125894a.f125905j;
        gVar.T = n0Var.g().f125894a.f125906k;
        gVar.U = n0Var.g().f125894a.f125907l;
        gVar.P = n0Var.g().f125894a.f125902g;
        gVar.O = n0Var.g().f125894a.f125901f;
        gVar.V = n0Var.g().f125894a.U;
        gVar.X = (ArrayList) com.tencent.luggage.wxa.h6.c.a(new ArrayList(), n0Var.f().f125869g);
        gVar.Y = (ArrayList) com.tencent.luggage.wxa.h6.c.a(new ArrayList(), n0Var.f().f125870h);
        gVar.f130825a0 = (ArrayList) com.tencent.luggage.wxa.h6.c.a(new ArrayList(), n0Var.f().f125872j);
        gVar.Z = (ArrayList) com.tencent.luggage.wxa.h6.c.a(new ArrayList(), n0Var.f().f125871i);
        gVar.f130826b0 = (ArrayList) com.tencent.luggage.wxa.h6.c.a(new ArrayList(), n0Var.f().f125873k);
        gVar.f130827c0 = (ArrayList) com.tencent.luggage.wxa.h6.c.a(new ArrayList(), n0Var.f().f125874l);
        gVar.f130833i0 = n0Var.f().f125863a;
        gVar.f125964j = n0Var.g().f125894a.F;
        gVar.f125965k = n0Var.g().f125894a.G;
        gVar.f130828d0 = n0Var.g().f125894a.H;
        gVar.f130832h0 = new String[]{n0Var.f138475n, n0Var.f138473l, n0Var.f138477p};
        gVar.F = com.tencent.luggage.wxa.fd.t.c(gVar.f125956b);
        return gVar;
    }
}
