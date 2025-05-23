package com.tencent.luggage.wxa.ol;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ol.f0;
import com.tencent.luggage.wxa.ol.q0;
import com.tencent.luggage.wxa.ol.s;
import com.tencent.luggage.wxa.qo.a;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.ui.widget.MMTextWatcherAdapter;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l implements p0 {
    public long C;
    public int F;
    public int G;

    /* renamed from: b, reason: collision with root package name */
    public volatile v f136813b;

    /* renamed from: c, reason: collision with root package name */
    public volatile u f136814c;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.vl.f f136819h;

    /* renamed from: i, reason: collision with root package name */
    public WeakReference f136820i;

    /* renamed from: j, reason: collision with root package name */
    public int f136821j;

    /* renamed from: k, reason: collision with root package name */
    public i0 f136822k;

    /* renamed from: l, reason: collision with root package name */
    public f0 f136823l;

    /* renamed from: m, reason: collision with root package name */
    public y f136824m;

    /* renamed from: a, reason: collision with root package name */
    public s0 f136812a = null;

    /* renamed from: d, reason: collision with root package name */
    public final View.OnFocusChangeListener f136815d = new m();

    /* renamed from: e, reason: collision with root package name */
    public int f136816e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f136817f = -1;

    /* renamed from: g, reason: collision with root package name */
    public w f136818g = null;
    public final b.a D = new n();
    public final Runnable E = new o();
    public final com.tencent.luggage.wxa.sl.a H = new com.tencent.luggage.wxa.sl.a();
    public boolean I = false;
    public final Runnable J = new p();
    public final com.tencent.luggage.wxa.tn.b0 K = new com.tencent.luggage.wxa.tn.b0(Looper.getMainLooper());
    public final f0.l L = new f();
    public final f0.j M = new g();
    public final f0.m N = new h();
    public final f0.k O = new i();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.this.f136822k == null) {
                return;
            }
            if (l.this.f136822k.hasFocus()) {
                l.this.z();
            } else if (l.this.f136822k == view) {
                l.this.i();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f136826a;

        public b(com.tencent.luggage.wxa.dn.a aVar) {
            this.f136826a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.v vVar;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
            this.f136826a.f124395a = true;
            WeakReference weakReference = l.this.f136820i;
            if (weakReference == null) {
                vVar = null;
            } else {
                vVar = (com.tencent.luggage.wxa.kj.v) weakReference.get();
            }
            if (vVar == null || l.this.f136822k == null || com.tencent.luggage.wxa.ol.r.a(vVar) != l.this) {
                return;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
            com.tencent.luggage.wxa.ol.k.a().b(vVar);
            a1.a((View) l.this.f136822k);
            if (l.this.f136823l != null && l.this.f136823l.b((EditText) null)) {
                l.this.f136823l.b(l.this.O);
                l.this.f136823l.j();
            }
            l.this.f136822k.b(l.this.f136815d);
            l.this.f136822k.setFocusable(true);
            l.this.f136822k.setFocusableInTouchMode(true);
            l.this.f136823l.a((EditText) l.this.f136822k);
            l.this.f136822k.requestFocus();
            a1.a((View) l.this.f136822k);
            if (l.this.f136823l != null) {
                l.this.f136823l.a(l.this.O);
                l.this.f136823l.s();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements f0.m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f136828a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f136829b;

        public c(com.tencent.luggage.wxa.dn.a aVar, Runnable runnable) {
            this.f136828a = aVar;
            this.f136829b = runnable;
        }

        @Override // com.tencent.luggage.wxa.ol.f0.m
        public void a(int i3) {
            if (!this.f136828a.f124395a && i3 == 2) {
                this.f136829b.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f136831a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f136832b;

        public d(com.tencent.luggage.wxa.dn.a aVar, Runnable runnable) {
            this.f136831a = aVar;
            this.f136832b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f136831a.f124395a) {
                return;
            }
            this.f136832b.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f136834a;

        public e(com.tencent.luggage.wxa.kj.v vVar) {
            this.f136834a = vVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void invoke(Void r26) {
            com.tencent.luggage.wxa.ic.g runtime = this.f136834a.getRuntime();
            if (runtime == null) {
                return null;
            }
            runtime.q1();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements f0.l {
        public f() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements f0.j {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.ol.f0.j
        public void a(boolean z16) {
            if (z16) {
                l.this.f136818g = w.CONFIRM_BAR_CLICKED;
            }
            l.this.h();
            l.this.f136818g = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements f0.m {
        public h() {
        }

        @Override // com.tencent.luggage.wxa.ol.f0.m
        public void a(int i3) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", Integer.valueOf(i3));
            if (i3 == 2) {
                l.this.f136818g = w.PANEL_HIDDEN;
                l.this.h();
                l.this.f136818g = null;
                return;
            }
            if (i3 == 0 && l.this.f136822k != null) {
                l.this.f136822k.requestFocus();
            }
            l.this.n();
            WeakReference weakReference = l.this.f136820i;
            if (weakReference != null && weakReference.get() != null) {
                com.tencent.luggage.wxa.ol.r.b((com.tencent.luggage.wxa.kj.v) l.this.f136820i.get(), l.this.f136822k);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements View.OnKeyListener {
        public j() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            boolean z16;
            l lVar = l.this;
            if (67 == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            lVar.I = z16;
            if (l.this.I) {
                l.this.K.b(l.this.J);
                l.this.K.a(l.this.J, 1000L);
            } else {
                l.this.J.run();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.s();
            l.this.r();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ol.l$l, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6561l implements TextView.OnEditorActionListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f136843a;

        public C6561l(int i3) {
            this.f136843a = i3;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            if (i3 == this.f136843a) {
                l.this.f136818g = w.CONFIRM_KEYBOARD_CLICKED;
                l.this.h();
                l.this.f136818g = null;
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements View.OnFocusChangeListener {
        public m() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            boolean z17;
            if (z16) {
                com.tencent.luggage.wxa.ol.r.a((com.tencent.luggage.wxa.kj.v) l.this.f136820i.get(), l.this);
            }
            l.this.d(z16);
            if (z16 && (!l.this.f136819h.T || com.tencent.luggage.wxa.ok.g.a(l.this.f136822k))) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 && l.this.f136822k != null && l.this.f136823l != null) {
                l.this.f136822k.requestFocus();
                l.this.f136823l.a(l.this.O);
                l.this.f136823l.s();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n extends s.a {
        public n() {
        }

        @Override // com.tencent.luggage.wxa.ro.b.a
        public void a(String str) {
            if (l.this.f136822k != null) {
                try {
                    l.this.H.a(l.this.f136822k.getEditableText(), false);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.c(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.I = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q extends MMTextWatcherAdapter {
        public q() {
        }

        @Override // com.tencent.mm.ui.widget.MMTextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WeakReference weakReference = l.this.f136820i;
            if (weakReference != null && weakReference.get() != null && l.this.f136822k != null) {
                l.this.r();
                if (a1.b(editable)) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", editable);
                } else {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", editable);
                    l.this.H.a(l.this.f136822k.getEditableText(), l.this.I);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class r implements com.tencent.luggage.wxa.sl.b {
        public r() {
        }

        @Override // com.tencent.luggage.wxa.sl.b
        public void a() {
            if (l.this.f136822k == null) {
                return;
            }
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", l.this.f136822k.getEditableText());
            l.this.H.a(l.this.f136822k.getEditableText(), false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s implements q0.b {
        public s() {
        }

        @Override // com.tencent.luggage.wxa.ol.q0.b
        public boolean a(int i3, KeyEvent keyEvent) {
            if (i3 != 67 || a1.b(l.this.f136822k.getText())) {
                return false;
            }
            l lVar = l.this;
            lVar.a(lVar.f136822k.getText().toString());
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class t implements Runnable {
        public t() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.r();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface u {
        void a(p0 p0Var, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface v {
        void a(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum w {
        PANEL_HIDDEN,
        CONFIRM_KEYBOARD_CLICKED,
        CONFIRM_BAR_CLICKED
    }

    public final void A() {
        f0 f0Var = this.f136823l;
        if (f0Var == null) {
            return;
        }
        f0Var.setOnSmileyChosenListener(this.L);
        this.f136823l.setOnDoneListener(this.M);
        this.f136823l.setOnVisibilityChangedListener(this.N);
    }

    public abstract void a(String str);

    public abstract void a(String str, int i3, boolean z16, boolean z17);

    @Override // com.tencent.luggage.wxa.ol.p0
    public Editable currentValue() {
        i0 i0Var = this.f136822k;
        if (i0Var == null) {
            return null;
        }
        return i0Var.getText();
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public final int getInputId() {
        return this.f136821j;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public View getInputPanel() {
        return this.f136823l;
    }

    public final boolean p() {
        WeakReference weakReference = this.f136820i;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        Context context = ((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).getContext();
        if (!(context instanceof Activity) || ((Activity) context).getCurrentFocus() == null) {
            return false;
        }
        return true;
    }

    public boolean q() {
        i0 i0Var = this.f136822k;
        if (i0Var != null && (i0Var.isFocused() || (k() != null && k().getAttachedEditText() == this.f136822k))) {
            return true;
        }
        return false;
    }

    public final void r() {
        boolean z16;
        i0 i0Var = this.f136822k;
        if (i0Var == null) {
            return;
        }
        if (i0Var.getLineCount() == this.f136816e && this.f136822k.j() == this.f136817f) {
            return;
        }
        if (this.f136816e == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f136816e = this.f136822k.getLineCount();
        this.f136817f = this.f136822k.j();
        if (this.f136813b != null) {
            this.f136813b.a(this.f136816e, this.f136817f);
        }
        if (this.f136819h.f143683u.booleanValue() && !z16) {
            this.F = a1.a(this.f136819h.f143666d, 0) + a1.a(this.f136819h.f143665c, 0);
            s();
            this.G = a1.a(this.f136819h.f143666d, 0) + a1.a(this.f136819h.f143665c, 0);
            c(true);
        }
    }

    public final void s() {
        int i3;
        int i16;
        if (this.f136822k != null && a1.a(this.f136819h.f143685w) && a1.a(this.f136819h.f143683u)) {
            ((com.tencent.luggage.wxa.ol.t) this.f136822k).setAutoHeight(true);
            int lineHeight = this.f136822k.getLineHeight();
            int j3 = this.f136822k.j();
            Integer num = this.f136819h.f143668f;
            if (num != null && num.intValue() > 0) {
                i3 = this.f136819h.f143668f.intValue();
            } else {
                i3 = lineHeight;
            }
            Integer num2 = this.f136819h.f143669g;
            if (num2 != null && num2.intValue() > 0) {
                i16 = Math.max(this.f136819h.f143669g.intValue(), lineHeight);
            } else {
                i16 = Integer.MAX_VALUE;
            }
            this.f136822k.setMinHeight(i3);
            this.f136822k.setMaxHeight(i16);
            this.f136819h.f143665c = Integer.valueOf(Math.max(i3, Math.min(j3, i16)));
            b(this.f136822k, this.f136819h);
        }
    }

    public final void t() {
        this.f136822k = null;
        com.tencent.luggage.wxa.uk.j.a(this);
    }

    public abstract void u();

    public abstract void v();

    public final boolean w() {
        WeakReference weakReference;
        if (this.f136822k == null || (weakReference = this.f136820i) == null || weakReference.get() == null) {
            return false;
        }
        this.f136822k.destroy();
        com.tencent.luggage.wxa.ol.j jVar = (com.tencent.luggage.wxa.ol.j) ((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).j0();
        if (jVar == null) {
            return false;
        }
        if (this.f136822k.hasFocus()) {
            y yVar = this.f136824m;
            if (yVar != null) {
                yVar.setVisibility(8);
            }
            k();
            f0 f0Var = this.f136823l;
            if (f0Var != null) {
                f0Var.setVisibility(8);
            }
        }
        jVar.b(this.f136822k);
        com.tencent.luggage.wxa.ol.r.a((com.tencent.luggage.wxa.kj.v) this.f136820i.get(), this.f136822k);
        return true;
    }

    public final void x() {
        this.f136823l.b((EditText) this.f136822k);
        a(this.f136822k);
        this.f136822k.destroy();
        t();
    }

    public final void y() {
        com.tencent.luggage.wxa.ol.b.a(this.f136822k, this.f136819h);
        com.tencent.luggage.wxa.vl.f fVar = this.f136819h;
        Integer num = fVar.f143676n;
        if (num == null) {
            fVar.f143676n = 140;
        } else if (num.intValue() <= 0) {
            this.f136819h.f143676n = Integer.MAX_VALUE;
        }
        com.tencent.luggage.wxa.ol.s.a(this.f136822k).b(this.f136819h.f143676n.intValue()).a(false).a(a.EnumC6654a.MODE_CHINESE_AS_1).a(this.D);
        this.f136822k.setPasswordMode(this.f136819h.S);
        if (a1.a(this.f136819h.f143681s)) {
            this.f136822k.setEnabled(false);
            this.f136822k.setFocusable(false);
            this.f136822k.setFocusableInTouchMode(false);
            this.f136822k.setClickable(false);
        } else {
            this.f136822k.setEnabled(true);
            this.f136822k.setClickable(true);
        }
        i0 i0Var = this.f136822k;
        if (i0Var instanceof com.tencent.luggage.wxa.ol.t) {
            if (this.f136819h.D != null) {
                ((com.tencent.luggage.wxa.ol.t) i0Var).setLineSpace(r1.intValue());
            }
            if (this.f136819h.E != null) {
                ((com.tencent.luggage.wxa.ol.t) this.f136822k).setLineHeight(r0.intValue());
            }
        }
    }

    public final void z() {
        i0 i0Var;
        if (this.f136819h.f143683u.booleanValue()) {
            k();
        }
        f0 f0Var = this.f136823l;
        if (f0Var != null && (i0Var = this.f136822k) != null) {
            f0Var.a((EditText) i0Var);
            this.f136823l.setComponentView(this.f136819h.G.booleanValue());
            this.f136823l.x();
            this.f136823l.setShowDoneButton(a1.a(this.f136819h.f143684v));
            A();
            if (com.tencent.luggage.wxa.ok.g.a(this.f136822k) && this.f136822k.hasFocus()) {
                this.f136823l.a(this.O);
                this.f136823l.s();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements f0.k {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                WeakReference weakReference = l.this.f136820i;
                if (weakReference == null) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandInputInvokeHandler", "postDelayed scroll up found page is null");
                    return;
                }
                com.tencent.luggage.wxa.ol.n.a(weakReference).b(l.this.getInputId(), false);
                l.this.C = com.tencent.luggage.wxa.tn.w0.a();
            }
        }

        public i() {
        }

        @Override // com.tencent.luggage.wxa.ol.f0.k
        public void a(int i3) {
            if (com.tencent.luggage.wxa.tn.w0.e(l.this.C) > 50) {
                com.tencent.luggage.wxa.tn.c0.a(new a(), 50L);
            }
        }

        @Override // com.tencent.luggage.wxa.ol.f0.k
        public EditText a() {
            return l.this.f136822k;
        }
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean e() {
        com.tencent.luggage.wxa.vl.f fVar = this.f136819h;
        return fVar != null && a1.a(fVar.B);
    }

    public final void f() {
        if (!q() && p()) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
            return;
        }
        f0 k3 = k();
        if (k3 != null) {
            k3.setVisibility(8);
        }
    }

    public final void g() {
        WeakReference weakReference;
        if (this.f136822k == null || (weakReference = this.f136820i) == null || weakReference.get() == null) {
            return;
        }
        this.f136822k.performClick();
    }

    public final void h() {
        boolean z16 = this.f136818g == w.CONFIRM_KEYBOARD_CLICKED && a1.a(this.f136819h.A);
        if (!z16) {
            o();
        }
        i0 i0Var = this.f136822k;
        if (i0Var != null) {
            if (i0Var.hasFocus()) {
                a(z16);
            }
            if (z16) {
                return;
            }
            this.f136822k.a(this.f136815d);
            f0 f0Var = this.f136823l;
            if (f0Var != null && f0Var.b((EditText) this.f136822k)) {
                this.f136823l.b(this.O);
                this.f136823l.j();
            }
            this.f136822k.setFocusable(false);
            this.f136822k.setFocusableInTouchMode(false);
            if (this.f136819h.T) {
                x();
            }
        }
    }

    public final void i() {
        i0 i0Var;
        WeakReference weakReference = this.f136820i;
        com.tencent.luggage.wxa.kj.v vVar = weakReference == null ? null : (com.tencent.luggage.wxa.kj.v) weakReference.get();
        if (this.f136823l == null) {
            k();
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.f136822k == null);
        objArr[1] = Boolean.valueOf(vVar == null);
        objArr[2] = Boolean.valueOf(this.f136823l == null);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]", objArr);
        if (vVar == null || (i0Var = this.f136822k) == null || this.f136823l == null) {
            return;
        }
        com.tencent.luggage.wxa.ol.r.b(vVar, i0Var);
        com.tencent.luggage.wxa.dn.a aVar = new com.tencent.luggage.wxa.dn.a();
        aVar.f124395a = false;
        b bVar = new b(aVar);
        Activity h16 = com.tencent.luggage.wxa.po.b.h(vVar.getContext());
        if (h16 != null && h16.getCurrentFocus() != null) {
            View currentFocus = h16.getCurrentFocus();
            boolean isActive = a1.b(currentFocus).isActive(currentFocus);
            boolean a16 = a1.a(vVar.D0().getWrapperView(), currentFocus);
            if (isActive && a16) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
                this.f136823l.setOnVisibilityChangedListener(new c(aVar, bVar));
                com.tencent.luggage.wxa.zp.h.f146825d.c(new d(aVar, bVar), 100L);
                return;
            }
        }
        bVar.run();
    }

    public final y j() {
        com.tencent.luggage.wxa.kj.v vVar;
        y yVar = this.f136824m;
        if (yVar != null) {
            return yVar;
        }
        WeakReference weakReference = this.f136820i;
        if (weakReference == null || (vVar = (com.tencent.luggage.wxa.kj.v) weakReference.get()) == null || vVar.getContentView() == null || !ViewCompat.isAttachedToWindow(vVar.getContentView())) {
            return null;
        }
        y a16 = y.a(vVar.getContentView());
        this.f136824m = a16;
        return a16;
    }

    public final f0 k() {
        com.tencent.luggage.wxa.kj.v vVar;
        f0 f0Var = this.f136823l;
        if (f0Var != null) {
            return f0Var;
        }
        WeakReference weakReference = this.f136820i;
        if (weakReference == null || (vVar = (com.tencent.luggage.wxa.kj.v) weakReference.get()) == null) {
            return null;
        }
        f0 a16 = f0.a(vVar.getContentView());
        this.f136823l = a16;
        return a16;
    }

    public synchronized s0 l() {
        s0 s0Var;
        s0Var = this.f136812a;
        if (s0Var == null) {
            com.tencent.luggage.wxa.vl.f fVar = this.f136819h;
            com.tencent.luggage.wxa.ol.f fVar2 = new com.tencent.luggage.wxa.ol.f(fVar != null ? fVar.R : null, this);
            this.f136812a = fVar2;
            s0Var = fVar2;
        }
        return s0Var;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public i0 d() {
        return this.f136822k;
    }

    public final void n() {
        if (j() != null) {
            this.f136824m.setVisibility(8);
        }
    }

    public final void o() {
        if (k() != null) {
            this.f136823l.b(this.O);
            this.f136823l.j();
        } else {
            WeakReference weakReference = this.f136820i;
            if (weakReference != null) {
                com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) weakReference.get();
                if (vVar == null) {
                    return;
                }
                t0 k06 = vVar.k0();
                if (k06 != null) {
                    k06.d();
                }
            }
        }
        com.tencent.luggage.wxa.ol.n.a(this.f136820i).a(getInputId());
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean b() {
        if (!w()) {
            return false;
        }
        t();
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public int c() {
        Integer num;
        com.tencent.luggage.wxa.vl.f fVar = this.f136819h;
        if (fVar != null && (num = fVar.f143687y) != null) {
            return num.intValue();
        }
        i0 i0Var = this.f136822k;
        return (i0Var == null || !i0Var.h()) ? 0 : 5;
    }

    public final void d(boolean z16) {
        if (this.f136823l == null) {
            this.f136823l = k();
        }
        if (z16) {
            z();
            if (this.f136819h.f143683u.booleanValue()) {
                com.tencent.luggage.wxa.tn.c0.a(this.E, 100L);
                return;
            }
            return;
        }
        if (this.f136822k != null) {
            if (!this.f136819h.T) {
                if (this.f136818g == null) {
                    a(false);
                }
                this.f136822k.setFocusable(false);
                this.f136822k.setFocusableInTouchMode(false);
                this.f136823l.b((EditText) this.f136822k);
                return;
            }
            a(false);
            x();
        }
    }

    public void a(String str, int i3, boolean z16, boolean z17, String str2, String str3) {
        a(str, i3, z16, z17);
    }

    public final void b(int i3, int i16) {
        com.tencent.luggage.wxa.ol.b.a(this.f136822k, i3, i16);
        c(false);
    }

    public void a(com.tencent.luggage.wxa.sl.c cVar) {
        this.H.a(cVar);
    }

    public final void c(boolean z16) {
        f0 f0Var;
        i0 i0Var;
        int i3;
        if (this.f136819h.f143683u.booleanValue() && (f0Var = this.f136823l) != null && f0Var.isShown() && (i0Var = this.f136822k) != null && i0Var == this.f136823l.getAttachedEditText()) {
            if (z16) {
                WeakReference weakReference = this.f136820i;
                int measuredHeight = (weakReference == null || weakReference.get() == null || ((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).j0() == null) ? 0 : ((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).j0().getMeasuredHeight() + ((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).j0().getScrollY();
                int i16 = this.G;
                if ((i16 <= this.F || i16 - this.f136822k.getLineHeight() > measuredHeight) && (((i3 = this.G) > this.F || i3 + this.f136822k.getLineHeight() > measuredHeight) && this.f136822k.j() < measuredHeight)) {
                    return;
                }
                com.tencent.luggage.wxa.ol.n.a(this.f136820i).b(getInputId());
                return;
            }
            com.tencent.luggage.wxa.ol.n.a(this.f136820i).b(getInputId());
        }
    }

    public void a(v vVar) {
        this.f136813b = vVar;
    }

    public final boolean b(i0 i0Var) {
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136820i.get();
        if (vVar == null) {
            return false;
        }
        com.tencent.luggage.wxa.ic.g runtime = vVar.getRuntime();
        if (runtime != null && runtime.C()) {
            i0Var.setOnFocusTransferListener(new e(vVar));
            return true;
        }
        i0Var.setOnFocusTransferListener(null);
        return true;
    }

    public void a(u uVar) {
        this.f136814c = uVar;
    }

    public final void a(com.tencent.luggage.wxa.vl.f fVar, int i3, int i16) {
        this.f136819h = fVar;
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) fVar.W.get();
        if (vVar != null) {
            new com.tencent.luggage.wxa.ol.o(vVar);
        }
        a(i3, i16);
    }

    public boolean b(i0 i0Var, com.tencent.luggage.wxa.vl.f fVar) {
        WeakReference weakReference;
        com.tencent.luggage.wxa.ol.j jVar;
        return (i0Var == null || (weakReference = this.f136820i) == null || weakReference.get() == null || (jVar = (com.tencent.luggage.wxa.ol.j) ((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).j0()) == null || !jVar.b(((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).D0(), i0Var, fVar.f143664b.intValue(), fVar.f143665c.intValue(), fVar.f143667e.intValue(), fVar.f143666d.intValue())) ? false : true;
    }

    public final boolean a(com.tencent.luggage.wxa.vl.i iVar) {
        Integer num;
        com.tencent.luggage.wxa.vl.f fVar = this.f136819h;
        if (fVar == null || this.f136822k == null) {
            return false;
        }
        fVar.a(iVar);
        m0.a(this.f136819h, iVar);
        if (!this.f136819h.U && ((num = this.f136819h.f143665c) == null || num.intValue() <= 0)) {
            return false;
        }
        this.f136822k.setWillNotDraw(true);
        y();
        String str = this.f136819h.f143663a;
        if (str != null) {
            this.f136822k.a(com.tencent.luggage.wxa.tn.w0.d(str));
        }
        if (!a1.a(this.f136819h.f143685w)) {
            b(this.f136822k, this.f136819h);
        } else {
            k kVar = new k();
            if (this.f136822k.getLayout() == null) {
                this.f136822k.post(kVar);
            } else {
                kVar.run();
            }
        }
        this.f136822k.setWillNotDraw(false);
        this.f136822k.invalidate();
        return true;
    }

    public final void b(boolean z16) {
        int i3;
        com.tencent.luggage.wxa.kj.v vVar = (com.tencent.luggage.wxa.kj.v) this.f136820i.get();
        if (ViewCompat.isAttachedToWindow(vVar.getContentView())) {
            f0 a16 = f0.a(vVar.getContentView(), vVar.z0());
            this.f136823l = a16;
            a16.setComponentView(this.f136819h.G.booleanValue());
            this.f136823l.x();
            if (this.f136819h.T) {
                A();
                n();
            }
            this.f136822k.b(this.f136815d);
            this.f136822k.setOnKeyListener(new j());
            if (this.f136819h.T) {
                com.tencent.luggage.wxa.ol.r.b((com.tencent.luggage.wxa.kj.v) this.f136820i.get(), this.f136822k);
            }
            this.f136823l.setCanSmileyInput(!this.f136819h.S && z16);
            com.tencent.luggage.wxa.vl.f fVar = this.f136819h;
            if (fVar.f143688z == null) {
                i3 = com.tencent.luggage.wxa.vl.c.a(fVar.f143683u.booleanValue()).f143658a;
            } else {
                if (!fVar.f143683u.booleanValue()) {
                    com.tencent.luggage.wxa.vl.c cVar = com.tencent.luggage.wxa.vl.c.RETURN;
                    com.tencent.luggage.wxa.vl.f fVar2 = this.f136819h;
                    if (cVar == fVar2.f143688z) {
                        fVar2.f143688z = com.tencent.luggage.wxa.vl.c.a(false);
                    }
                }
                i3 = this.f136819h.f143688z.f143658a;
            }
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputInvokeHandler", "initSmileyPanelAndShow, myImeOption: " + i3);
            C6561l c6561l = (this.f136819h.f143683u.booleanValue() && i3 == 0) ? null : new C6561l(i3);
            this.f136822k.setImeOptions(i3);
            this.f136822k.setOnEditorActionListener(c6561l);
            this.f136823l.setShowDoneButton(this.f136819h.f143684v.booleanValue());
            this.f136823l.a((EditText) this.f136822k);
            if (this.f136819h.T) {
                i();
            } else {
                this.f136822k.setFocusable(false);
                this.f136822k.setFocusableInTouchMode(false);
                this.f136823l.b(this.O);
                this.f136823l.j();
            }
            if (this.f136819h.T) {
                com.tencent.luggage.wxa.ol.n.a(this.f136820i).b(getInputId());
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a(com.tencent.luggage.wxa.kj.v vVar) {
        WeakReference weakReference;
        return (vVar == null || (weakReference = this.f136820i) == null || vVar != weakReference.get()) ? false : true;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a(int i3, int i16, boolean z16) {
        g();
        b(i3, i16);
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public boolean a() {
        f();
        return true;
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public void a(String str, Integer num) {
        i0 i0Var = this.f136822k;
        if (i0Var == null) {
            return;
        }
        i0Var.a(str);
        Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
        b(valueOf.intValue(), valueOf.intValue());
        r();
    }

    @Override // com.tencent.luggage.wxa.ol.p0
    public final void a(int i3) {
        u uVar = this.f136814c;
        if (uVar != null) {
            uVar.a(this, i3);
        }
    }

    public final void a(int i3, int i16) {
        i0 wVar;
        WeakReference weakReference = this.f136819h.W;
        this.f136820i = weakReference;
        com.tencent.luggage.wxa.kj.v vVar = weakReference == null ? null : (com.tencent.luggage.wxa.kj.v) weakReference.get();
        if (vVar != null && vVar.D0() != null) {
            if (a1.a(this.f136819h.f143683u)) {
                wVar = new com.tencent.luggage.wxa.ol.t(vVar.getContext());
            } else {
                wVar = new com.tencent.luggage.wxa.ol.w(vVar.getContext());
            }
            this.f136822k = wVar;
            int i17 = this.f136819h.Q;
            this.f136821j = i17;
            wVar.setInputId(i17);
            com.tencent.luggage.wxa.ol.r.a(vVar, this);
            y();
            this.f136822k.setText(com.tencent.luggage.wxa.tn.w0.d(this.f136819h.f143663a));
            if (a1.a(this.f136819h.f143685w)) {
                r();
            }
            this.f136822k.addTextChangedListener(new q());
            this.f136822k.setOnComposingDismissedListener(new r());
            this.f136822k.setOnKeyUpPostImeListener(new s());
            if (!a(this.f136822k, this.f136819h)) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
                v();
                return;
            }
            com.tencent.luggage.wxa.vl.a aVar = this.f136819h.V;
            if (aVar != null && !com.tencent.luggage.wxa.tn.w0.a((List) aVar.f143647d)) {
                com.tencent.luggage.wxa.pl.d.a(vVar, this.f136822k, this.f136819h.V);
            }
            if (!a1.a(this.f136819h.f143683u)) {
                com.tencent.luggage.wxa.ol.b.a(this.f136822k, i3, i16);
            }
            if (a1.a(this.f136819h.f143683u)) {
                this.f136822k.post(new t());
            }
            if (a1.a(this.f136819h.f143683u)) {
                ((com.tencent.luggage.wxa.ol.t) this.f136822k).setAdjustKeyboardTo(this.f136819h.C);
            }
            if (!com.tencent.luggage.wxa.ol.r.j(this.f136819h.R) && !TuxQuestionType.QUESTION_TEXT_TEXTAREA.equalsIgnoreCase(this.f136819h.R)) {
                if ("emoji".equalsIgnoreCase(this.f136819h.R)) {
                    b(true);
                } else {
                    com.tencent.luggage.wxa.er.a.a(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", this.f136819h.R));
                }
            } else {
                b(false);
            }
            this.f136822k.setOnClickListener(new a());
            u();
            return;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
        v();
    }

    public boolean a(i0 i0Var, com.tencent.luggage.wxa.vl.f fVar) {
        WeakReference weakReference;
        com.tencent.luggage.wxa.ol.j jVar;
        return (i0Var == null || (weakReference = this.f136820i) == null || weakReference.get() == null || (jVar = (com.tencent.luggage.wxa.ol.j) ((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).j0()) == null || !jVar.a(((com.tencent.luggage.wxa.kj.v) this.f136820i.get()).D0(), i0Var, fVar.f143664b.intValue(), fVar.f143665c.intValue(), fVar.f143667e.intValue(), fVar.f143666d.intValue()) || !b(i0Var)) ? false : true;
    }

    public void a(i0 i0Var) {
        com.tencent.luggage.wxa.ol.j jVar;
        if (i0Var == null) {
            return;
        }
        i0Var.a(this.f136815d);
        WeakReference weakReference = this.f136820i;
        com.tencent.luggage.wxa.kj.v vVar = weakReference == null ? null : (com.tencent.luggage.wxa.kj.v) weakReference.get();
        if (vVar == null || (jVar = (com.tencent.luggage.wxa.ol.j) vVar.j0()) == null) {
            return;
        }
        jVar.b(i0Var);
    }

    public final void a(boolean z16) {
        String str;
        String message;
        i0 i0Var = this.f136822k;
        if (i0Var == null) {
            return;
        }
        com.tencent.luggage.wxa.vl.f fVar = this.f136819h;
        w wVar = w.CONFIRM_KEYBOARD_CLICKED;
        w wVar2 = this.f136818g;
        boolean z17 = wVar == wVar2 || w.CONFIRM_BAR_CLICKED == wVar2;
        String obj = i0Var.getText().toString();
        if (com.tencent.luggage.wxa.ol.r.d(fVar != null ? fVar.R : null)) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputInvokeHandler", "dispatchKeyboardComplete, do encrypt");
            try {
                message = null;
                str = m0.a(l(), (com.tencent.luggage.wxa.xd.d) this.f136820i.get(), fVar);
            } catch (l0 e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandInputInvokeHandler", "dispatchKeyboardComplete, encrypt fail since %s", e16);
                str = null;
                message = e16.getMessage();
            }
            a(obj, this.f136822k.getSelectionEnd(), z17, z16, str, message);
            return;
        }
        a(obj, this.f136822k.getSelectionEnd(), z17, z16);
    }
}
