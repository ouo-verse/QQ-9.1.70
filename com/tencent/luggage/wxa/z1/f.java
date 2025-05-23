package com.tencent.luggage.wxa.z1;

import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kj.v;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f implements p.e0 {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f146180a;

        static {
            int[] iArr = new int[k1.values().length];
            f146180a = iArr;
            try {
                iArr[k1.APP_LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146180a[k1.AUTO_RE_LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public boolean a(v vVar, String str) {
        return vVar != null;
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public boolean a(String str) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public n a(String str, k1 k1Var, p pVar, Callable callable) {
        return new e(pVar.getContext(), pVar);
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public v a(p pVar, String str) {
        return new com.tencent.luggage.wxa.m4.b(i.class, null);
    }

    @Override // com.tencent.luggage.wxa.kj.p.e0
    public boolean a(String str, k1 k1Var, p pVar, p.h0 h0Var) {
        int i3 = a.f146180a[k1Var.ordinal()];
        if (i3 == 1) {
            h0Var.proceed();
        } else if (i3 == 2) {
            n currentPage = pVar.getCurrentPage();
            k1 k1Var2 = k1.AUTO_RE_LAUNCH;
            pVar.a((n) null, currentPage, k1Var2, str, false);
            pVar.getCurrentPage().a(0L, str, k1Var);
            pVar.a((n) null, pVar.getCurrentPage(), k1Var2);
        }
        return true;
    }
}
