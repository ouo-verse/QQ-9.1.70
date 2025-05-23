package com.tencent.luggage.wxa.ol;

import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tk.h f136742a = new com.tencent.luggage.wxa.tk.h();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        boolean a(p0 p0Var);
    }

    public static void a(com.tencent.luggage.wxa.kj.v vVar, p0 p0Var) {
        f136742a.b(vVar, p0Var);
    }

    public static void a(com.tencent.luggage.wxa.kj.v vVar) {
        f136742a.b(vVar);
    }

    public static p0 a(com.tencent.luggage.wxa.kj.v vVar, a aVar) {
        Set<p0> a16;
        if (vVar != null && aVar != null && (a16 = f136742a.a(vVar)) != null) {
            for (p0 p0Var : a16) {
                if (p0Var != null && aVar.a(p0Var)) {
                    return p0Var;
                }
            }
        }
        return null;
    }
}
