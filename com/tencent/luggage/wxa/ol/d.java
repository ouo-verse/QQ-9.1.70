package com.tencent.luggage.wxa.ol;

import android.graphics.Rect;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.tencent.luggage.wxa.ol.y;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends c {
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;

    /* renamed from: i, reason: collision with root package name */
    public final String f136684i;

    /* renamed from: j, reason: collision with root package name */
    public int f136685j;

    /* renamed from: k, reason: collision with root package name */
    public v f136686k;

    /* renamed from: l, reason: collision with root package name */
    public y f136687l;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.vl.i f136688m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends MMTextWatcherAdapter {
        public a() {
        }

        @Override // com.tencent.mm.ui.widget.MMTextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String trim;
            int length;
            boolean z16;
            boolean z17;
            int i3;
            if (editable == null || (length = (trim = editable.toString().trim()).length()) <= 0) {
                return;
            }
            int selectionEnd = d.this.f136686k.getSelectionEnd();
            if ('\b' == d.this.f136686k.getLastKeyPressed()) {
                z16 = true;
            } else {
                z16 = false;
            }
            StringBuilder sb5 = new StringBuilder(length);
            int i16 = 0;
            int i17 = -1;
            for (int i18 = 0; i18 < length; i18++) {
                char charAt = trim.charAt(i18);
                if (z16 && selectionEnd - 1 == i18) {
                    if (!Character.isDigit(charAt) || 3 != i16 || (i3 = i18 + 1) >= length || !Character.isDigit(trim.charAt(i3))) {
                        if (!Character.isDigit(charAt) && i16 == 0) {
                            i17 = sb5.length();
                        }
                    }
                } else if (-1 == i17 && selectionEnd == i18) {
                    i17 = sb5.length();
                }
                if (!Character.isDigit(charAt)) {
                    if (i16 == 0) {
                        sb5.append(charAt);
                    }
                } else {
                    sb5.append(charAt);
                    i16++;
                    if (4 == i16) {
                        int i19 = i18 + 1;
                        if (i19 < length && Character.isDigit(trim.charAt(i19))) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            sb5.append(TokenParser.SP);
                        }
                        i16 = 0;
                    }
                }
            }
            String sb6 = sb5.toString();
            if (-1 == i17) {
                i17 = sb6.length();
            }
            if (m0.f136873a.a()) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputComponentAsNumber", "afterTextChanged, s: %s, isAfterDelete: %b, originContent: %s, newContent: %s, originSelection: %d, newSelection: %d", editable, Boolean.valueOf(z16), trim, sb6, Integer.valueOf(selectionEnd), Integer.valueOf(i17));
            }
            d.this.f136686k.n();
            d.this.f136686k.setText(sb6);
            d.this.f136686k.setSelection(i17);
            d.this.f136686k.p();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements y.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ol.y.b
        public void a() {
            d.this.t();
            d.this.a(false);
        }
    }

    public d(String str, com.tencent.luggage.wxa.kj.v vVar, com.tencent.luggage.wxa.vl.f fVar) {
        super(str, vVar, fVar.Q);
        this.f136685j = 0;
        String str2 = fVar.R;
        this.f136684i = str2;
        this.f136686k = new v(vVar.getContext());
        this.f136685j = com.tencent.luggage.wxa.tn.w0.a((Integer) r.f136917a.get(str), 0);
        this.F = b(vVar);
        if (r.a(str2)) {
            this.f136686k.addTextChangedListener(new a());
        }
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public com.tencent.luggage.wxa.vl.i b(com.tencent.luggage.wxa.vl.i iVar) {
        v vVar;
        com.tencent.luggage.wxa.vl.i iVar2 = this.f136688m;
        if (iVar2 == null) {
            this.f136688m = iVar;
            if (a1.a(iVar.F) && (vVar = this.f136686k) != null) {
                vVar.setPasswordMode(true);
            }
        } else {
            iVar2.a(iVar);
            m0.a(this.f136688m, iVar);
        }
        v vVar2 = this.f136686k;
        if (vVar2 == null) {
            return null;
        }
        com.tencent.luggage.wxa.ol.b.a(vVar2, this.f136688m);
        return this.f136688m;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public int c() {
        Integer num;
        com.tencent.luggage.wxa.vl.i iVar = this.f136688m;
        if (iVar != null && (num = iVar.f143687y) != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean e() {
        com.tencent.luggage.wxa.vl.i iVar = this.f136688m;
        if (iVar != null && a1.a(iVar.B)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public View getInputPanel() {
        q();
        return this.f136687l;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public Rect j() {
        return new Rect(this.f136688m.f143667e.intValue(), this.f136688m.f143666d.intValue(), this.f136688m.f143667e.intValue() + this.f136688m.f143664b.intValue(), this.f136688m.f143666d.intValue() + this.f136688m.f143665c.intValue());
    }

    public final void p() {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", this.f136686k);
        v vVar = this.f136686k;
        if (vVar != null) {
            vVar.setFocusable(false);
            this.f136686k.setFocusableInTouchMode(false);
            this.f136686k.setEnabled(false);
        }
    }

    public final y q() {
        y yVar = this.f136687l;
        if (yVar != null) {
            return yVar;
        }
        y inputPanel = this.f136686k.getInputPanel();
        this.f136687l = inputPanel;
        return inputPanel;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public final v i() {
        return this.f136686k;
    }

    public boolean s() {
        v vVar = this.f136686k;
        if (vVar == null) {
            return false;
        }
        if (vVar.isFocused()) {
            return true;
        }
        if (q() == null || !q().isShown() || this.f136687l.getAttachedEditText() != this.f136686k) {
            return false;
        }
        return true;
    }

    public final void t() {
        String message;
        if (r.c(this.f136684i)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputComponentAsNumber", "onKeyboardComplete, do encrypt");
            String str = null;
            try {
                str = m0.a(g(), h(), this.f136688m);
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
        v vVar = this.f136686k;
        if (vVar == null) {
            return false;
        }
        vVar.a(str);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a(int i3, int i16, boolean z16) {
        if (this.f136686k == null) {
            return false;
        }
        y a16 = y.a(((com.tencent.luggage.wxa.kj.v) this.f136670e.get()).getContentView(), (this.f136670e.get() == null || !(this.f136670e.get() instanceof com.tencent.luggage.wxa.kj.v)) ? null : ((com.tencent.luggage.wxa.kj.v) this.f136670e.get()).z0());
        this.f136687l = a16;
        a16.setComponentView(this.f136688m.G.booleanValue());
        this.f136687l.l();
        y yVar = this.f136687l;
        if (yVar == null) {
            return false;
        }
        this.E = z16;
        if (z16) {
            yVar.g();
        }
        this.D = true;
        f();
        this.f136687l.setXMode(this.f136685j);
        this.f136687l.a((EditText) this.f136686k);
        this.f136687l.setOnDoneListener(new b());
        a(i3, i16);
        k();
        this.D = false;
        return true;
    }

    public final boolean b(com.tencent.luggage.wxa.kj.v vVar) {
        if (vVar != null && vVar.O()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputComponentAsNumber", "can send change event when hide");
            return true;
        }
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(vVar != null);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputComponentAsNumber", "pageView == null? :%b", objArr);
        return false;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a() {
        if (q() == null || !s()) {
            return false;
        }
        this.f136687l.h();
        p();
        o();
        n();
        if (!this.F) {
            return true;
        }
        a(0);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.c
    public boolean a(boolean z16) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", Boolean.valueOf(z16), Boolean.valueOf(s()));
        if (!z16) {
            if (this.C || !s()) {
                return true;
            }
            this.C = true;
            t();
            a();
            l();
            this.C = false;
            this.f136686k = null;
        } else {
            if (this.D || s()) {
                return true;
            }
            this.D = true;
            a(-2, -2, this.E);
            this.D = false;
        }
        return true;
    }
}
