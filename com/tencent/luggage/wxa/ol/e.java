package com.tencent.luggage.wxa.ol;

import android.graphics.Rect;
import android.view.View;
import android.widget.EditText;
import com.tencent.luggage.wxa.ol.h0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends c {
    public boolean C;
    public boolean D;

    /* renamed from: i, reason: collision with root package name */
    public final String f136697i;

    /* renamed from: j, reason: collision with root package name */
    public v f136698j;

    /* renamed from: k, reason: collision with root package name */
    public h0 f136699k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.vl.i f136700l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f136701m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements h0.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ol.h0.b
        public void a() {
            e.this.t();
            e.this.a(false);
        }
    }

    public e(String str, com.tencent.luggage.wxa.kj.v vVar, com.tencent.luggage.wxa.vl.f fVar) {
        super(str, vVar, fVar.Q);
        this.f136697i = fVar.R;
        this.f136698j = new v(vVar.getContext());
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public com.tencent.luggage.wxa.vl.i b(com.tencent.luggage.wxa.vl.i iVar) {
        v vVar;
        com.tencent.luggage.wxa.vl.i iVar2 = this.f136700l;
        if (iVar2 == null) {
            this.f136700l = iVar;
            if (a1.a(iVar.F) && (vVar = this.f136698j) != null) {
                vVar.setPasswordMode(true);
            }
        } else {
            iVar2.a(iVar);
            m0.a(this.f136700l, iVar);
        }
        v vVar2 = this.f136698j;
        if (vVar2 == null) {
            return null;
        }
        b.a(vVar2, this.f136700l);
        return this.f136700l;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public int c() {
        Integer num;
        com.tencent.luggage.wxa.vl.i iVar = this.f136700l;
        if (iVar != null && (num = iVar.f143687y) != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean e() {
        com.tencent.luggage.wxa.vl.i iVar = this.f136700l;
        if (iVar != null && a1.a(iVar.B)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public View getInputPanel() {
        q();
        return this.f136699k;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public Rect j() {
        return new Rect(this.f136700l.f143667e.intValue(), this.f136700l.f143666d.intValue(), this.f136700l.f143667e.intValue() + this.f136700l.f143664b.intValue(), this.f136700l.f143666d.intValue() + this.f136700l.f143665c.intValue());
    }

    public final void p() {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", this.f136698j);
        v vVar = this.f136698j;
        if (vVar != null) {
            vVar.setFocusable(false);
            this.f136698j.setFocusableInTouchMode(false);
            this.f136698j.setEnabled(false);
        }
    }

    public final h0 q() {
        h0 h0Var = this.f136699k;
        if (h0Var != null) {
            return h0Var;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final v i() {
        return this.f136698j;
    }

    public boolean s() {
        v vVar = this.f136698j;
        if (vVar == null) {
            return false;
        }
        if (vVar.isFocused()) {
            return true;
        }
        if (q() == null || !q().isShown() || this.f136699k.getAttachedEditText() != this.f136698j) {
            return false;
        }
        return true;
    }

    public final void t() {
        String message;
        if (r.c(this.f136697i)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputComponentAsNumber", "onKeyboardComplete, do encrypt");
            String str = null;
            try {
                str = m0.a(g(), h(), this.f136700l);
                message = null;
            } catch (l0 e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandInputComponentAsNumber", "onKeyboardComplete, encrypt fail since %s", e16);
                message = e16.getMessage();
            }
            a(currentValue(), str, message);
            return;
        }
        b(currentValue());
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public boolean a(String str) {
        v vVar = this.f136698j;
        if (vVar == null) {
            return false;
        }
        vVar.a(str);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a(int i3, int i16, boolean z16) {
        if (this.f136698j == null) {
            return false;
        }
        h0 a16 = h0.a(((com.tencent.luggage.wxa.kj.v) this.f136670e.get()).getContentView(), (this.f136670e.get() == null || !(this.f136670e.get() instanceof com.tencent.luggage.wxa.kj.v)) ? null : ((com.tencent.luggage.wxa.kj.v) this.f136670e.get()).z0());
        this.f136699k = a16;
        if (a16 == null) {
            return false;
        }
        a16.f136757f = this.f136668c;
        this.C = true;
        f();
        this.f136699k.a((EditText) this.f136698j);
        this.f136699k.setOnDoneListener(new a());
        a(i3, i16);
        k();
        this.C = false;
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a() {
        if (q() == null || !s()) {
            return false;
        }
        this.f136699k.f();
        p();
        o();
        n();
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public boolean a(boolean z16) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", Boolean.valueOf(z16), Boolean.valueOf(s()));
        if (!z16) {
            if (this.f136701m || !s()) {
                return true;
            }
            this.f136701m = true;
            t();
            a();
            l();
            this.f136701m = false;
            this.f136698j = null;
        } else {
            if (this.C || s()) {
                return true;
            }
            this.C = true;
            a(-2, -2, this.D);
            this.C = false;
        }
        return true;
    }
}
