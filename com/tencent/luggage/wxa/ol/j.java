package com.tencent.luggage.wxa.ol;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.luggage.wxa.kj.g1;
import com.tencent.luggage.wxa.kj.s1;
import com.tencent.luggage.wxa.kj.z;
import com.tencent.luggage.wxa.ol.j;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends AbsoluteLayout implements com.tencent.luggage.wxa.kj.f0, com.tencent.luggage.wxa.ll.d, com.tencent.luggage.wxa.kj.g1, z.b, com.tencent.luggage.wxa.kj.d0, com.tencent.luggage.wxa.hp.a {

    /* renamed from: a, reason: collision with root package name */
    public final List f136788a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.ll.e f136789b;

    /* renamed from: c, reason: collision with root package name */
    public final AbsoluteLayout f136790c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.kj.v f136791d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f136792e;

    /* renamed from: f, reason: collision with root package name */
    public int f136793f;

    /* renamed from: g, reason: collision with root package name */
    public int f136794g;

    /* renamed from: h, reason: collision with root package name */
    public Runnable f136795h;

    public j(com.tencent.luggage.wxa.kj.v vVar) {
        super(vVar.getContext().getApplicationContext());
        this.f136788a = new LinkedList();
        super.setId(R.id.srh);
        this.f136791d = vVar;
        this.f136790c = this;
    }

    public boolean a(com.tencent.luggage.wxa.kj.o0 o0Var, View view, int i3, int i16, int i17, int i18) {
        return a(o0Var, view, i3, i16, i17, i18, true);
    }

    public final void b(com.tencent.luggage.wxa.kj.o0 o0Var) {
        View wrapperView = o0Var.getWrapperView();
        if (this.f136790c.getWidth() == wrapperView.getWidth() && this.f136790c.getHeight() == wrapperView.getHeight()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f136790c.getLayoutParams();
        layoutParams.width = wrapperView.getWidth();
        layoutParams.height = wrapperView.getHeight();
        this.f136790c.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.luggage.wxa.ll.c
    public boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        for (int i3 = 0; i3 <= getChildCount(); i3++) {
            if (AppBrandViewMotionCompat.d(getChildAt(i3))) {
                return true;
            }
        }
        return false;
    }

    public com.tencent.luggage.wxa.ll.e getDuplicateDispatch() {
        if (this.f136789b == null) {
            this.f136789b = new com.tencent.luggage.wxa.ll.e(this.f136790c);
        }
        return this.f136789b;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i3, int i16) {
        if (this.f136792e) {
            view.forceLayout();
        }
        super.measureChild(view, i3, i16);
    }

    @Override // android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        boolean z16;
        if (!isLayoutRequested() && i3 == this.f136793f && i16 == this.f136794g) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f136792e = z16;
        this.f136793f = i3;
        this.f136794g = i16;
        super.onMeasure(i3, i16);
        this.f136792e = false;
    }

    @Override // com.tencent.luggage.wxa.kj.f0
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        if (this.f136790c != null) {
            a(false, view.getWidth(), view.getHeight());
            this.f136790c.scrollTo(i3, i16);
        }
        Iterator it = this.f136788a.iterator();
        while (it.hasNext()) {
            ((g1.a) it.next()).a(this, i3, i16, i17, i18);
        }
    }

    @Override // android.widget.AbsoluteLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(com.tencent.luggage.wxa.kj.o0 o0Var, View view, int i3, int i16, int i17, int i18, boolean z16) {
        if (o0Var == null || o0Var.getWrapperView() == null || view == 0) {
            return false;
        }
        b(o0Var);
        this.f136790c.addView(view, new AbsoluteLayout.LayoutParams(i3, i16, i17, i18));
        if (!z16) {
            return true;
        }
        ((q0) view).b(this.f136791d);
        return true;
    }

    public final boolean a(View view) {
        if (view == null || this.f136790c == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.f136790c.getChildCount(); i3++) {
            if (view == this.f136790c.getChildAt(i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(com.tencent.luggage.wxa.kj.o0 o0Var, View view, int i3, int i16, int i17, int i18) {
        if (o0Var == null || o0Var.getWrapperView() == null || view == null || !a(view)) {
            return false;
        }
        b(o0Var);
        if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)) {
            if (view.getWidth() == i3 && view.getHeight() == i16 && view.getLeft() == i17 && view.getTop() == i18) {
                return true;
            }
            AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
            layoutParams.x = i17;
            layoutParams.y = i18;
            layoutParams.width = i3;
            layoutParams.height = i16;
            view.setLayoutParams(layoutParams);
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.z.b
    public void a(int i3) {
        setTranslationY(i3);
    }

    @Override // com.tencent.luggage.wxa.ll.d
    public boolean a(MotionEvent motionEvent) {
        com.tencent.luggage.wxa.ll.e eVar;
        if (motionEvent == null || motionEvent.getActionMasked() != 0 || (eVar = this.f136789b) == null) {
            return false;
        }
        return eVar.a(motionEvent);
    }

    @Override // com.tencent.luggage.wxa.kj.g1
    public void a(g1.a aVar) {
        if (aVar == null || this.f136788a.contains(aVar)) {
            return;
        }
        this.f136788a.add(aVar);
    }

    @Override // com.tencent.luggage.wxa.kj.d0
    public void a(boolean z16, int i3, int i16, int i17, int i18) {
        if (a(z16, i17 - i3, i18 - i16)) {
            a();
        }
    }

    public final boolean a(boolean z16, int i3, int i16) {
        AbsoluteLayout absoluteLayout = this.f136790c;
        if (absoluteLayout == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = absoluteLayout.getLayoutParams();
        if (layoutParams == null) {
            this.f136790c.setLayoutParams(new ViewGroup.LayoutParams(i3, i16));
            return true;
        }
        if (i3 == layoutParams.width && i16 == layoutParams.height) {
            return z16;
        }
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.f136790c.setLayoutParams(layoutParams);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(View view) {
        if (view == 0) {
            return;
        }
        view.setVisibility(8);
        com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", Boolean.valueOf(a1.b(this).isActive()));
        this.f136790c.removeView(view);
        ((q0) view).a(this.f136791d);
    }

    public final void a() {
        Runnable runnable = this.f136795h;
        if (runnable == null) {
            this.f136795h = new Runnable() { // from class: p31.a
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.requestLayout();
                }
            };
        } else {
            removeCallbacks(runnable);
        }
        post(this.f136795h);
    }

    @Override // com.tencent.luggage.wxa.kj.g1
    public void b(g1.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f136788a.remove(aVar);
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas canvas) {
        canvas.save();
        canvas.translate(-getScrollX(), -getScrollY());
        if (s1.a(this)) {
            s1.a(canvas, this, 0.0f, 0.0f);
        } else {
            draw(canvas);
        }
        canvas.restore();
        return true;
    }

    @Override // android.view.View
    public void setId(int i3) {
    }
}
