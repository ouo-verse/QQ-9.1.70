package com.tencent.luggage.wxa.ol;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c1 implements com.tencent.luggage.wxa.kj.r0 {

    /* renamed from: c, reason: collision with root package name */
    public static View.OnTouchListener f136678c = new a();

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.kj.v f136679a;

    /* renamed from: b, reason: collision with root package name */
    public final j f136680b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f136681a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y0 f136682b;

        public b(j jVar, y0 y0Var) {
            this.f136681a = jVar;
            this.f136682b = y0Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                com.tencent.luggage.wxa.gh.e.a(this.f136681a, motionEvent);
            }
            if (this.f136682b.a(motionEvent)) {
                return true;
            }
            return false;
        }
    }

    public c1(com.tencent.luggage.wxa.kj.v vVar) {
        this.f136679a = vVar;
        this.f136680b = new j(vVar);
    }

    @Override // com.tencent.luggage.wxa.kj.r0
    public void a(com.tencent.luggage.wxa.kj.n0 n0Var) {
        if (n0Var == com.tencent.luggage.wxa.kj.n0.MODAL || n0Var == com.tencent.luggage.wxa.kj.n0.ACTION_SHEET) {
            r.b(this.f136679a);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.r0
    public ViewGroup getContainer() {
        return this.f136680b;
    }

    @Override // com.tencent.luggage.wxa.kj.f0
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        this.f136680b.onScrollChanged(i3, i16, i17, i18, view);
    }

    @Override // com.tencent.luggage.wxa.kj.r0
    public void setupWebViewTouchInterceptor(com.tencent.luggage.wxa.kj.o0 o0Var) {
        a((ViewGroup) o0Var.getContentView(), this.f136680b);
    }

    @Override // com.tencent.luggage.wxa.kj.z.b
    public void a(int i3) {
        this.f136680b.a(i3);
    }

    public final void a(ViewGroup viewGroup, j jVar) {
        viewGroup.setOnTouchListener(new b(jVar, new y0(jVar)));
    }

    @Override // com.tencent.luggage.wxa.kj.r0
    public void a(com.tencent.luggage.wxa.kj.o0 o0Var) {
        if (o0Var.getContentView() == null) {
            return;
        }
        ((ViewGroup) o0Var.getContentView()).setOnTouchListener(f136678c);
    }

    @Override // com.tencent.luggage.wxa.kj.d0
    public void a(boolean z16, int i3, int i16, int i17, int i18) {
        this.f136680b.a(z16, i3, i16, i17, i18);
    }
}
