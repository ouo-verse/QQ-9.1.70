package com.tencent.luggage.wxa.hc;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f126974a;

    /* renamed from: b, reason: collision with root package name */
    public ViewGroup f126975b;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f126976c;

    /* renamed from: d, reason: collision with root package name */
    public ViewGroup f126977d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.ec.a f126978e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f126979f;

    /* renamed from: g, reason: collision with root package name */
    public Animation f126980g;

    /* renamed from: h, reason: collision with root package name */
    public Animation f126981h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f126982i;

    /* renamed from: k, reason: collision with root package name */
    public Dialog f126984k;

    /* renamed from: j, reason: collision with root package name */
    public int f126983j = 80;

    /* renamed from: l, reason: collision with root package name */
    public boolean f126985l = true;

    /* renamed from: m, reason: collision with root package name */
    public View.OnKeyListener f126986m = new c();
    public final View.OnTouchListener C = new d();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f126978e.C.removeView(aVar.f126976c);
            a.this.f126982i = false;
            a.this.f126979f = false;
            a.b(a.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnKeyListener {
        public c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (i3 == 4 && keyEvent.getAction() == 0 && a.this.j()) {
                a.this.a();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.a();
                return false;
            }
            return false;
        }
    }

    public a(Context context) {
        this.f126974a = context;
    }

    public void c() {
        this.f126978e.C.post(new b());
    }

    public final Animation d() {
        return AnimationUtils.loadAnimation(this.f126974a, com.tencent.luggage.wxa.gc.a.a(this.f126983j, true));
    }

    public final Animation e() {
        return AnimationUtils.loadAnimation(this.f126974a, com.tencent.luggage.wxa.gc.a.a(this.f126983j, false));
    }

    public void f() {
        this.f126981h = d();
        this.f126980g = e();
    }

    public void h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f126974a).inflate(R.layout.fdw, this.f126978e.C, false);
        this.f126976c = viewGroup;
        viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        int i3 = this.f126978e.Q;
        if (i3 != -1) {
            this.f126976c.setBackgroundColor(i3);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f126976c.findViewById(R.id.b9t);
        this.f126975b = viewGroup2;
        viewGroup2.setLayoutParams(layoutParams);
        a(true);
    }

    public abstract boolean i();

    public boolean j() {
        if (i()) {
            return false;
        }
        if (this.f126976c.getParent() == null && !this.f126982i) {
            return false;
        }
        return true;
    }

    public void k() {
        Dialog dialog = this.f126984k;
        if (dialog != null) {
            dialog.setCancelable(this.f126978e.T);
        }
    }

    public static /* synthetic */ com.tencent.luggage.wxa.fc.b b(a aVar) {
        aVar.getClass();
        return null;
    }

    public void a() {
        if (i()) {
            b();
            return;
        }
        if (this.f126979f) {
            return;
        }
        if (this.f126985l) {
            this.f126980g.setAnimationListener(new AnimationAnimationListenerC6260a());
            this.f126975b.startAnimation(this.f126980g);
        } else {
            c();
        }
        this.f126979f = true;
    }

    public a b(boolean z16) {
        ViewGroup viewGroup = this.f126976c;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.f2180020);
            if (z16) {
                findViewById.setOnTouchListener(this.C);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public final void b() {
        Dialog dialog = this.f126984k;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void a(boolean z16) {
        ViewGroup viewGroup;
        if (i()) {
            viewGroup = this.f126977d;
        } else {
            viewGroup = this.f126976c;
        }
        viewGroup.setFocusable(z16);
        viewGroup.setFocusableInTouchMode(z16);
        if (z16) {
            viewGroup.setOnKeyListener(this.f126986m);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public View a(int i3) {
        return this.f126975b.findViewById(i3);
    }

    public void g() {
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.hc.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class AnimationAnimationListenerC6260a implements Animation.AnimationListener {
        public AnimationAnimationListenerC6260a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.c();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
