package com.tencent.luggage.wxa.u1;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.il.j;
import com.tencent.luggage.wxa.tn.y0;
import com.tencent.luggage.wxa.u1.g;
import com.tencent.luggage.wxa.uk.w;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.mobileqq.R;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    public static final String f142019i = "wagame://" + y0.a(R.string.f159111rf) + "/WAGameVConsole.html";

    /* renamed from: a, reason: collision with root package name */
    public g f142020a;

    /* renamed from: b, reason: collision with root package name */
    public i f142021b;

    /* renamed from: c, reason: collision with root package name */
    public Context f142022c;

    /* renamed from: e, reason: collision with root package name */
    public View f142024e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f142025f;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.magicbrush.b f142027h;

    /* renamed from: d, reason: collision with root package name */
    public boolean f142023d = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f142026g = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC6778a implements View.OnClickListener {
        public ViewOnClickListenerC6778a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public int f142030a;

        public c() {
            this.f142030a = a.this.d();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (((Float) valueAnimator.getAnimatedValue()).floatValue() == 1.0f) {
                a.this.f142020a.setVisibility(8);
            } else {
                a.this.f142020a.a(((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f142030a);
                a.this.f142020a.requestLayout();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public int f142032a;

        public d() {
            this.f142032a = a.this.d();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f142020a.a(((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f142032a);
            a.this.f142020a.requestLayout();
        }
    }

    public a(g gVar, com.tencent.magicbrush.b bVar, Context context, i iVar) {
        this.f142021b = iVar;
        this.f142020a = gVar;
        this.f142022c = context;
        this.f142027h = bVar;
        gVar.d(context);
        g();
    }

    public View e() {
        return this.f142020a.getView();
    }

    public final void f() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new c());
        ofFloat.start();
    }

    public final void g() {
        this.f142020a.o().setJavaScriptEnabled(true);
        j jVar = new j(this.f142022c);
        this.f142024e = jVar;
        jVar.setOnClickListener(new ViewOnClickListenerC6778a());
        this.f142020a.a(new b());
        this.f142020a.loadUrl(f142019i);
        this.f142020a.a(100000.0f);
        this.f142020a.setVisibility(8);
    }

    public final void h() {
        this.f142020a.a(d());
        this.f142020a.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(new d());
        ofFloat.start();
    }

    public void i() {
        if (this.f142023d) {
            f();
            this.f142023d = false;
        } else {
            h();
            this.f142023d = true;
        }
    }

    public final void b(String str) {
        String a16 = w.a(str);
        this.f142020a.g("console._log('" + a16 + "')");
    }

    public View c() {
        return this.f142024e;
    }

    public final int d() {
        return ((int) (this.f142027h.x().find(0).getWidth() * this.f142022c.getResources().getDisplayMetrics().density)) + 1;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends g.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.u1.g.b
        public void b() {
            a.this.f142026g = true;
            if (a.this.f142025f == null || a.this.f142025f.isEmpty()) {
                return;
            }
            Iterator it = a.this.f142025f.iterator();
            while (it.hasNext()) {
                a.this.b((String) it.next());
            }
        }

        @Override // com.tencent.luggage.wxa.u1.g.b
        public boolean c(String str) {
            return a.f142019i.equals(str);
        }

        @Override // com.tencent.luggage.wxa.u1.g.b
        public InputStream b(String str) {
            return a.this.f142021b.i().a(str);
        }
    }

    public void b() {
        this.f142020a.destroy();
    }

    public static a a(com.tencent.magicbrush.b bVar, Context context, i iVar) {
        return new a(com.tencent.luggage.wxa.s1.c.b().a(), bVar, context, iVar);
    }

    public void a(String str) {
        if (this.f142026g) {
            b(str);
            return;
        }
        if (this.f142025f == null) {
            this.f142025f = new LinkedList();
        }
        this.f142025f.add(str);
    }

    public void a(Runnable runnable) {
        this.f142020a.getView().post(runnable);
    }
}
