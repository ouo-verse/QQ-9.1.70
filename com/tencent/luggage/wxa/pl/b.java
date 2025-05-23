package com.tencent.luggage.wxa.pl;

import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Filter;
import android.widget.PopupWindow;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.q0;
import com.tencent.luggage.wxa.pl.i;
import com.tencent.luggage.wxa.tn.s;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final q0 f137633a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.pl.e f137634b;

    /* renamed from: c, reason: collision with root package name */
    public final Filter.FilterListener f137635c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.pl.c f137636d;

    /* renamed from: e, reason: collision with root package name */
    public final h f137637e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.pl.g f137638f = com.tencent.luggage.wxa.pl.g.VIEW;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.pl.a f137639g;

    /* renamed from: h, reason: collision with root package name */
    public int f137640h;

    /* renamed from: i, reason: collision with root package name */
    public int f137641i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements q0.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ol.q0.a
        public void onConfigurationChanged(Configuration configuration) {
            b.this.d();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pl.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6608b implements q0.c {
        public C6608b() {
        }

        @Override // com.tencent.luggage.wxa.ol.q0.c
        public void a(int i3, int i16) {
            b.this.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                b.this.e();
            } else {
                b.this.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Filter.FilterListener {
        public e() {
        }

        @Override // android.widget.Filter.FilterListener
        public void onFilterComplete(int i3) {
            if (i3 <= 0) {
                b.this.f137634b.c();
            } else if (b.this.f137634b.i()) {
                b.this.f137634b.k();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends h {
        public f() {
            super(null);
        }

        @Override // com.tencent.luggage.wxa.pl.b.h, com.tencent.luggage.wxa.pl.i
        public void a(String str, i.a aVar) {
            if (aVar == i.a.DELETE) {
                b bVar = b.this;
                bVar.a(bVar.f137633a.getText());
            }
            super.a(str, aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class g {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f137649a;

        static {
            int[] iArr = new int[com.tencent.luggage.wxa.pl.g.values().length];
            f137649a = iArr;
            try {
                iArr[com.tencent.luggage.wxa.pl.g.SCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f137649a[com.tencent.luggage.wxa.pl.g.VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class h implements i {

        /* renamed from: a, reason: collision with root package name */
        public i f137650a;

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.pl.i
        public void a(String str, i.a aVar) {
            i iVar = this.f137650a;
            if (iVar != null) {
                iVar.a(str, aVar);
            }
        }
    }

    public b(q0 q0Var) {
        this.f137633a = q0Var;
        com.tencent.luggage.wxa.pl.e eVar = new com.tencent.luggage.wxa.pl.e(q0Var.getContext());
        this.f137634b = eVar;
        this.f137636d = new com.tencent.luggage.wxa.pl.c(q0Var, eVar);
        q0Var.a(new a());
        q0Var.a(new C6608b());
        q0Var.b(new c());
        q0Var.addTextChangedListener(new d());
        this.f137635c = new e();
        this.f137637e = new f();
    }

    public final void d() {
        int i3 = g.f137649a[this.f137638f.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                this.f137634b.f(this.f137633a.getView().getMeasuredWidth());
            }
        } else {
            this.f137634b.f(s.f(this.f137633a.getContext())[0]);
        }
        int i16 = this.f137640h;
        if (i16 != 0) {
            this.f137634b.c(i16);
            com.tencent.luggage.wxa.pl.e eVar = this.f137634b;
            eVar.f(eVar.g() - this.f137640h);
        }
        if (this.f137641i != 0) {
            com.tencent.luggage.wxa.pl.e eVar2 = this.f137634b;
            eVar2.f(eVar2.g() - this.f137641i);
        }
    }

    public void e() {
        if (this.f137639g == null) {
            return;
        }
        CharSequence text = this.f137633a.getText();
        if (!w0.a(text)) {
            a(text);
        }
        this.f137634b.a(this.f137633a.getView());
        this.f137634b.k();
        ((com.tencent.luggage.wxa.pl.h) this.f137634b.e().getAdapter()).a(this);
        this.f137636d.a(text);
    }

    public void b(v vVar) {
        this.f137636d.b(vVar);
    }

    public void c() {
        if (this.f137634b.i()) {
            com.tencent.luggage.wxa.pl.h hVar = (com.tencent.luggage.wxa.pl.h) this.f137634b.e().getAdapter();
            this.f137634b.c();
            hVar.b(this);
        }
    }

    public void a(v vVar) {
        this.f137636d.a(vVar);
    }

    public void b() {
        this.f137636d.a();
        this.f137639g = null;
        this.f137634b.c();
    }

    public final void a(CharSequence charSequence) {
        com.tencent.luggage.wxa.pl.a aVar = this.f137639g;
        if (aVar == null) {
            return;
        }
        aVar.getFilter().filter(charSequence, this.f137635c);
    }

    public void a(ArrayList arrayList) {
        com.tencent.luggage.wxa.pl.a aVar = new com.tencent.luggage.wxa.pl.a(this.f137633a.getContext(), arrayList);
        this.f137639g = aVar;
        aVar.a(this.f137637e);
        this.f137634b.a(this.f137639g);
    }

    public void a(i iVar) {
        this.f137637e.f137650a = iVar;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f137634b.a(onDismissListener);
    }

    public void a(com.tencent.luggage.wxa.pl.g gVar) {
        if (gVar != null) {
            this.f137638f = gVar;
        }
        d();
    }

    public void a() {
        this.f137633a.getView().clearFocus();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public boolean f137645a = false;

        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (this.f137645a && !b.this.f137634b.i()) {
                return;
            }
            if (!b.this.f137634b.i()) {
                b.this.e();
            }
            b.this.a(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            this.f137645a = b.this.f137634b.i();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
