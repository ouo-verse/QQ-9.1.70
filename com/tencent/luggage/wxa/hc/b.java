package com.tencent.luggage.wxa.hc;

import android.content.Context;
import android.view.View;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends a implements View.OnClickListener {
    public d D;
    public Context E;

    public b(Context context) {
        super(context);
        this.D = new d();
        this.E = context;
    }

    public void a(com.tencent.luggage.wxa.ec.a aVar) {
        this.f126978e = aVar;
        a(this.E);
    }

    public void b(int i3) {
        this.D.d(i3);
    }

    @Override // com.tencent.luggage.wxa.hc.a
    public boolean i() {
        return this.f126978e.S;
    }

    public WheelView l() {
        if (this.D.b() == null) {
            this.D.a(new WheelView(this.E));
        }
        return this.D.b();
    }

    public final void m() {
        d dVar = this.D;
        if (dVar != null) {
            dVar.b(this.f126978e.f124623f);
        }
    }

    public void n() {
        if (this.f126978e.f124618a != null) {
            this.f126978e.f124618a.onOptionsSelect(this.D.a()[0]);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            n();
        }
        a();
    }

    public final void a(Context context) {
        k();
        h();
        f();
        g();
        this.D.a(new WheelView(context), this.f126978e.f124626i);
        com.tencent.luggage.wxa.fc.c cVar = this.f126978e.f124621d;
        if (cVar != null) {
            this.D.a(cVar);
        }
        this.D.a(this.f126978e.f124622e);
        this.D.e(this.f126978e.f124624g);
        this.D.b(this.f126978e.f124625h);
        this.D.a(this.f126978e.V);
        b(this.f126978e.T);
        this.D.c(this.f126978e.P);
        this.D.a(this.f126978e.W);
        this.D.b(this.f126978e.R);
        this.D.a(this.f126978e.U);
        this.D.b(this.f126978e.X);
        this.D.c(this.f126978e.P);
    }

    public void a(List list) {
        this.D.a(list);
        m();
    }

    public void a(com.tencent.luggage.wxa.fc.c cVar) {
        this.f126978e.f124621d = cVar;
        this.D.a(cVar);
    }

    public void a(float f16) {
        this.D.a(f16);
    }
}
