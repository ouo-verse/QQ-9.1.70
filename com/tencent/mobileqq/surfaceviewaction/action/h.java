package com.tencent.mobileqq.surfaceviewaction.action;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    private a f291184n;

    /* renamed from: o, reason: collision with root package name */
    private int f291185o;

    /* renamed from: p, reason: collision with root package name */
    private a[] f291186p;

    /* renamed from: q, reason: collision with root package name */
    private int[] f291187q;

    public h(a... aVarArr) {
        super(0, 0, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVarArr);
            return;
        }
        this.f291185o = 0;
        this.f291186p = aVarArr;
        this.f291187q = new int[aVarArr.length];
        int i3 = 0;
        for (int i16 = 0; i16 < aVarArr.length; i16++) {
            if (i16 == 0) {
                this.f291187q[i16] = 0;
            } else {
                this.f291187q[i16] = i3;
            }
            i3 += aVarArr[i16].f291161f;
        }
        this.f291161f = i3;
        if (aVarArr.length > 0) {
            this.f291184n = aVarArr[this.f291185o];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.surfaceviewaction.action.a
    public void a(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        int i16 = this.f291185o;
        if (i16 + 1 < this.f291186p.length && i3 > this.f291187q[i16 + 1]) {
            this.f291184n.g();
            a[] aVarArr = this.f291186p;
            int i17 = this.f291185o + 1;
            this.f291185o = i17;
            this.f291184n = aVarArr[i17];
        }
        a aVar = this.f291184n;
        this.f291162g = aVar.f291162g;
        int i18 = i3 - this.f291187q[this.f291185o];
        float f17 = i18;
        int i19 = aVar.f291161f;
        float f18 = f17 / i19;
        int i26 = aVar.f291163h;
        if (i26 == 1) {
            f18 = (i18 * i18) / (i19 * i19);
        } else if (i26 == 2) {
            float f19 = f17 / i19;
            f18 = f19 * (2.0f - f19);
        }
        aVar.a(i18, f18);
        a aVar2 = this.f291184n;
        int i27 = aVar2.f291162g;
        if ((i27 & 1) != 0) {
            this.f291156a = aVar2.f291156a;
            this.f291157b = aVar2.f291157b;
        }
        if ((i27 & 16) != 0) {
            this.f291157b = aVar2.f291157b;
        }
        if ((i27 & 2) != 0) {
            this.f291158c = aVar2.f291158c;
        }
        if ((i27 & 4) != 0) {
            this.f291159d = aVar2.f291159d;
        }
        if ((i27 & 8) != 0) {
            this.f291160e = aVar2.f291160e;
        }
        super.a(i3, f16);
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.action.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.c();
        for (int i3 = 0; i3 < this.f291186p.length; i3++) {
            this.f291187q[i3] = (int) (System.currentTimeMillis() - this.f291167l);
        }
    }

    @Override // com.tencent.mobileqq.surfaceviewaction.action.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.f();
        this.f291185o = 0;
        a[] aVarArr = this.f291186p;
        if (aVarArr.length > 0) {
            this.f291184n = aVarArr[0];
        }
    }
}
