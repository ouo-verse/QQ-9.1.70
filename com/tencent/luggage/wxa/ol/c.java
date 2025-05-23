package com.tencent.luggage.wxa.ol;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.ol.s;
import com.tencent.luggage.wxa.ol.v0;
import com.tencent.luggage.wxa.qo.a;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends MMTextWatcherAdapter implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public v0 f136666a;

    /* renamed from: b, reason: collision with root package name */
    public u0 f136667b;

    /* renamed from: c, reason: collision with root package name */
    public final int f136668c;

    /* renamed from: d, reason: collision with root package name */
    public final String f136669d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f136670e;

    /* renamed from: f, reason: collision with root package name */
    public final View.OnFocusChangeListener f136671f = new a();

    /* renamed from: g, reason: collision with root package name */
    public final b.a f136672g = new b();

    /* renamed from: h, reason: collision with root package name */
    public s0 f136673h = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (c.this.a(z16) && z16) {
                r.b((com.tencent.luggage.wxa.kj.v) c.this.f136670e.get(), (q0) c.this.i());
                ((q0) c.this.i()).setInputId(c.this.getInputId());
                r.a((com.tencent.luggage.wxa.kj.v) c.this.f136670e.get(), c.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends s.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ro.b.a
        public void a(String str) {
            if (c.this.i() != null) {
                c cVar = c.this;
                cVar.a(cVar.i().getEditableText());
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ol.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6560c {
        ;


        /* renamed from: a, reason: collision with root package name */
        public static final ArraySet f136676a = new ArraySet();

        public static EnumC6560c valueOf(String str) {
            com.tencent.luggage.wxa.k0.d.a(Enum.valueOf(EnumC6560c.class, str));
            return null;
        }

        public static c a(String str, com.tencent.luggage.wxa.kj.v vVar, com.tencent.luggage.wxa.vl.f fVar) {
            Iterator it = f136676a.iterator();
            if (!it.hasNext()) {
                if (r.e(str)) {
                    return new d(str, vVar, fVar);
                }
                if ("safe-password".equalsIgnoreCase(str)) {
                    return new a0(str, vVar, fVar);
                }
                if (r.f(str)) {
                    return new e(str, vVar, fVar);
                }
                return null;
            }
            com.tencent.luggage.wxa.k0.d.a(it.next());
            throw null;
        }
    }

    public c(String str, com.tencent.luggage.wxa.kj.v vVar, int i3) {
        this.f136669d = str;
        this.f136670e = new WeakReference(vVar);
        this.f136668c = i3;
    }

    public abstract boolean a(String str);

    public abstract boolean a(boolean z16);

    @Override // com.tencent.mm.ui.widget.MMTextWatcherAdapter, android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        a(editable);
    }

    public abstract com.tencent.luggage.wxa.vl.i b(com.tencent.luggage.wxa.vl.i iVar);

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean b() {
        return l();
    }

    public Editable currentValue() {
        if (i() == null) {
            return null;
        }
        return i().getEditableText();
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public EditText d() {
        return i();
    }

    public final void f() {
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136670e.get();
        if (vVar != null && vVar.D0() != null) {
            k.a().b(vVar);
        }
    }

    public synchronized s0 g() {
        s0 s0Var;
        s0Var = this.f136673h;
        if (s0Var == null) {
            s0Var = new f(this.f136669d, this);
            this.f136673h = s0Var;
        }
        return s0Var;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public final int getInputId() {
        return this.f136668c;
    }

    public final com.tencent.luggage.wxa.kj.v h() {
        return (com.tencent.luggage.wxa.kj.v) this.f136670e.get();
    }

    public abstract EditText i();

    public abstract Rect j();

    public void k() {
        n.a(this.f136670e).b(getInputId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l() {
        j jVar;
        EditText i3 = i();
        if (i3 == 0) {
            return false;
        }
        q0 q0Var = (q0) i3;
        q0Var.a(this.f136671f);
        i3.removeTextChangedListener(this);
        q0Var.destroy();
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136670e.get();
        if (vVar == null || (jVar = (j) vVar.j0()) == null) {
            return false;
        }
        jVar.b(i3);
        r.a(vVar, q0Var);
        return true;
    }

    public void m() {
        com.tencent.luggage.wxa.kj.v vVar;
        j jVar;
        Rect j3;
        EditText i3 = i();
        if (i3 == null || (vVar = (com.tencent.luggage.wxa.kj.v) this.f136670e.get()) == null || vVar.D0() == null || (jVar = (j) vVar.j0()) == null || (j3 = j()) == null) {
            return;
        }
        jVar.b(vVar.D0(), i3, j3.width(), j3.height(), j3.left, j3.top);
    }

    public void n() {
        n.a(this.f136670e).a(getInputId());
    }

    public final void o() {
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136670e.get();
        if (vVar != null && vVar.D0() != null) {
            k.a().c(vVar);
        }
    }

    public void a(v0 v0Var) {
        this.f136666a = v0Var;
    }

    public final void b(Editable editable) {
        v0 v0Var = this.f136666a;
        if (v0Var != null) {
            v0Var.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), v0.a.COMPLETE);
        }
    }

    public void a(u0 u0Var) {
        this.f136667b = u0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(int i3, int i16, int i17, int i18) {
        EditText i19;
        j jVar;
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136670e.get();
        if (vVar == null || vVar.D0() == null || (i19 = i()) == 0 || (jVar = (j) vVar.j0()) == null) {
            return false;
        }
        boolean a16 = jVar.a(vVar.D0(), i19, i3, i16, i17, i18);
        if (a16) {
            ((q0) i19).b(this.f136671f);
            i19.addTextChangedListener(this);
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a(com.tencent.luggage.wxa.kj.v vVar) {
        return vVar != null && vVar == this.f136670e.get();
    }

    public final void a(Editable editable, String str, String str2) {
        v0 v0Var = this.f136666a;
        if (v0Var != null) {
            v0Var.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), str, str2);
        }
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public final void a(int i3) {
        u0 u0Var = this.f136667b;
        if (u0Var != null) {
            u0Var.a(i3);
        }
    }

    public final void a(Editable editable) {
        v0 v0Var = this.f136666a;
        if (v0Var != null) {
            v0Var.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), v0.a.CHANGED);
        }
    }

    public final boolean a(com.tencent.luggage.wxa.vl.i iVar) {
        com.tencent.luggage.wxa.vl.i b16 = b(iVar);
        if (b16 == null) {
            return false;
        }
        Integer num = b16.f143676n;
        if (num == null) {
            b16.f143676n = 140;
        } else if (num.intValue() <= 0) {
            b16.f143676n = Integer.MAX_VALUE;
        }
        if (i() == null) {
            return false;
        }
        s.a(i()).b(b16.f143676n.intValue()).a(false).a(a.EnumC6654a.MODE_CHINESE_AS_1).a(this.f136672g);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public final void a(String str, Integer num) {
        a(str);
        Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
        a(valueOf.intValue(), valueOf.intValue());
    }

    public final void a(com.tencent.luggage.wxa.vl.a aVar) {
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136670e.get();
        if (vVar == null || i() == null) {
            return;
        }
        com.tencent.luggage.wxa.pl.d.a(vVar, i(), aVar);
    }

    public final void a(int i3, int i16) {
        com.tencent.luggage.wxa.ol.b.a(i(), i3, i16);
    }
}
