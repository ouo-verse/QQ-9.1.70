package com.tencent.luggage.wxa.ol;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ol.a1;
import com.tencent.luggage.wxa.ol.t0;
import com.tencent.luggage.wxa.tl.c;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h0 extends LinearLayout implements r0 {

    /* renamed from: h, reason: collision with root package name */
    public static final int f136751h = 2131363114;

    /* renamed from: a, reason: collision with root package name */
    public boolean f136752a;

    /* renamed from: b, reason: collision with root package name */
    public b f136753b;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f136754c;

    /* renamed from: d, reason: collision with root package name */
    public EditText f136755d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fi.a f136756e;

    /* renamed from: f, reason: collision with root package name */
    public int f136757f;

    /* renamed from: g, reason: collision with root package name */
    public c.a f136758g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.a {
        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    public h0(Context context) {
        super(context);
        this.f136752a = false;
        this.f136756e = null;
        this.f136757f = -1;
        this.f136758g = new a();
        g();
    }

    public static h0 a(View view) {
        return (h0) view.getRootView().findViewById(f136751h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setInputReceiver(com.tencent.luggage.wxa.tl.b bVar) {
        t0 a16;
        if (bVar == 0) {
            return;
        }
        boolean z16 = bVar instanceof View;
        if (z16 && (a16 = t0.a.a(((View) bVar).getContext())) != null) {
            a16.d();
        }
        if (bVar instanceof EditText) {
            EditText editText = (EditText) bVar;
            a1.a.b(editText);
            a1.a.a(editText);
        }
        if (z16) {
            ((View) bVar).requestFocus();
        }
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.tl.c.class));
        throw null;
    }

    @Override // com.tencent.luggage.wxa.ol.r0
    public boolean e() {
        return ViewCompat.isLaidOut(this);
    }

    public void f() {
        this.f136754c.setVisibility(8);
        setVisibility(8);
        i();
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.tl.c.class));
        throw null;
    }

    public final void g() {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandWcPayNumberKeyboardPanel", "init");
        super.setId(f136751h);
        setOrientation(1);
        setBackgroundColor(-1);
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.tl.c.class));
        getContext();
        throw null;
    }

    public EditText getAttachedEditText() {
        return this.f136755d;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return 0;
    }

    public int getPanelHeight() {
        return com.tencent.luggage.wxa.kn.a.a(getContext(), 240);
    }

    public final void h() {
        b bVar;
        if (!this.f136752a && (bVar = this.f136753b) != null) {
            this.f136752a = true;
            bVar.a();
            this.f136752a = false;
        }
    }

    public final void i() {
        EditText editText = this.f136755d;
        if (editText != null) {
            editText.clearFocus();
            this.f136755d = null;
            this.f136753b = null;
            this.f136752a = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }

    public <_Input extends EditText & com.tencent.luggage.wxa.tl.b> void setInputEditText(_Input _input) {
        this.f136755d = _input;
        setInputReceiver(_input);
    }

    public <_InputEventReceiver extends com.tencent.luggage.wxa.tl.b> void setInputEventReceiver(_InputEventReceiver _inputeventreceiver) {
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.tl.c.class));
        throw null;
    }

    public void setOnDoneListener(b bVar) {
        this.f136753b = bVar;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        if (getVisibility() == i3 && (getVisibility() == 0 || getVisibility() == 8)) {
            return;
        }
        if (i3 != 0) {
            super.setVisibility(8);
            h();
        } else {
            super.setVisibility(i3);
        }
    }

    public static h0 a(View view, com.tencent.luggage.wxa.fi.a aVar) {
        h0 a16 = a(view);
        q b16 = q.b(view);
        if (b16 == null) {
            return null;
        }
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWcPayNumberKeyboardPanel", "set new AppBrandWcPayNumberKeyboardPanel");
            a16 = new h0(view.getContext());
        }
        b16.a((View) a16, false);
        if (aVar != null && aVar != a16.f136756e) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWcPayNumberKeyboardPanel", "set mComponentView %s", aVar.toString());
            a16.f136756e = aVar;
        }
        return a16;
    }

    public void a(EditText editText) {
        if (editText == null) {
            return;
        }
        if (this.f136755d != editText) {
            i();
        }
        setInputEditText(editText);
        this.f136754c.setVisibility(0);
        setVisibility(0);
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.tl.c.class));
        throw null;
    }

    public void a(com.tencent.luggage.wxa.tl.b bVar) {
        if (bVar == null) {
            return;
        }
        setInputEventReceiver(bVar);
        this.f136754c.setVisibility(0);
        setVisibility(0);
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.tl.c.class));
        throw null;
    }
}
