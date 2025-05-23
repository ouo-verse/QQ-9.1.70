package f43;

import com.tencent.mobileqq.qqgift.data.service.d;
import java.util.List;
import sh2.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements c.InterfaceC11228c {

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.mobileqq.vasgift.mvvm.business.a f397824d;

    /* renamed from: e, reason: collision with root package name */
    public final c.f f397825e;

    public a(com.tencent.mobileqq.vasgift.mvvm.business.a aVar, c.f fVar) {
        this.f397824d = aVar;
        this.f397825e = fVar;
    }

    @Override // sh2.c.f
    public boolean D() {
        boolean z16;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z16 = fVar.D();
        } else {
            z16 = false;
        }
        if (a(z16)) {
            this.f397824d.R1();
        }
        return z16;
    }

    @Override // sh2.c.InterfaceC11228c
    public boolean H0(boolean z16, d dVar, int i3, List<String> list) {
        c.f fVar = this.f397825e;
        if (fVar instanceof c.InterfaceC11228c) {
            ((c.InterfaceC11228c) fVar).H0(z16, dVar, i3, list);
            return false;
        }
        return false;
    }

    @Override // sh2.c.f
    public boolean O(d dVar, int i3) {
        boolean z16;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z16 = fVar.O(dVar, i3);
        } else {
            z16 = false;
        }
        if (a(z16)) {
            this.f397824d.T1(dVar, i3);
        }
        return z16;
    }

    protected boolean a(boolean z16) {
        if (!z16 && this.f397824d != null) {
            return true;
        }
        return false;
    }

    @Override // sh2.c.f
    public boolean f() {
        boolean z16;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z16 = fVar.f();
        } else {
            z16 = false;
        }
        if (a(z16)) {
            this.f397824d.Q1();
        }
        return z16;
    }

    @Override // sh2.c.f
    public boolean h0(d dVar, int i3) {
        boolean z16;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z16 = fVar.h0(dVar, i3);
        } else {
            z16 = false;
        }
        if (a(z16)) {
            this.f397824d.M1(dVar, i3);
        }
        return z16;
    }

    @Override // sh2.c.f
    public boolean n1(boolean z16, d dVar, int i3, String str) {
        boolean z17;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z17 = fVar.n1(z16, dVar, i3, str);
        } else {
            z17 = false;
        }
        if (a(z17)) {
            this.f397824d.S1(z16, dVar, i3, str);
        }
        return z17;
    }

    @Override // sh2.c.f
    public void o1(d dVar, int i3, int i16) {
        this.f397825e.o1(dVar, i3, i3);
    }

    @Override // sh2.c.f
    public boolean r(d dVar, int i3) {
        boolean z16;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z16 = fVar.r(dVar, i3);
        } else {
            z16 = false;
        }
        if (a(z16)) {
            this.f397824d.P1(dVar, i3);
        }
        return z16;
    }

    @Override // sh2.c.f
    public boolean t() {
        boolean z16;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z16 = fVar.t();
        } else {
            z16 = false;
        }
        if (a(z16)) {
            this.f397824d.L1();
        }
        return z16;
    }

    @Override // sh2.c.f
    public boolean u0(d dVar, int i3) {
        boolean z16;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z16 = fVar.u0(dVar, i3);
        } else {
            z16 = false;
        }
        if (a(z16)) {
            this.f397824d.O1(dVar, i3);
        }
        return z16;
    }

    @Override // sh2.c.f
    public boolean w(d dVar, int i3) {
        boolean z16;
        c.f fVar = this.f397825e;
        if (fVar != null) {
            z16 = fVar.w(dVar, i3);
        } else {
            z16 = false;
        }
        if (a(z16)) {
            this.f397824d.N1(dVar, i3);
        }
        return z16;
    }
}
