package com.tencent.luggage.wxa.hc;

import android.graphics.Typeface;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public WheelView f126992a;

    /* renamed from: b, reason: collision with root package name */
    public WheelView f126993b;

    /* renamed from: c, reason: collision with root package name */
    public List f126994c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f126995d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f126996e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fc.c f126997f;

    /* renamed from: g, reason: collision with root package name */
    public int f126998g;

    /* renamed from: h, reason: collision with root package name */
    public WheelView.c f126999h;

    /* renamed from: i, reason: collision with root package name */
    public float f127000i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.bc.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.bc.b
        public void a(int i3) {
            if (d.this.f126997f != null) {
                d.this.f126997f.onOptionsSelectChanged(d.this.f126993b.getCurrentItem());
            }
        }
    }

    public void a(Typeface typeface) {
    }

    public void c(int i3) {
        this.f126998g = i3;
        d();
    }

    public void d(int i3) {
    }

    public final void e() {
    }

    public WheelView b() {
        return this.f126992a;
    }

    public final void d() {
        this.f126993b.setDividerColor(this.f126998g);
    }

    public void e(int i3) {
    }

    public void a(WheelView wheelView) {
        this.f126992a = wheelView;
    }

    public void b(boolean z16) {
        this.f126993b.setCyclic(z16);
    }

    public WheelView c() {
        return this.f126993b;
    }

    public void a(WheelView wheelView, boolean z16) {
        this.f126996e = z16;
        if (this.f126992a == null) {
            this.f126992a = wheelView;
        }
        this.f126993b = this.f126992a;
    }

    public void b(int i3) {
        if (this.f126995d) {
            a(i3);
        } else {
            this.f126993b.setCurrentItem(i3);
        }
    }

    public void b(float f16) {
        this.f127000i = f16;
        f();
    }

    public void a(List list) {
        this.f126994c = list;
        this.f126993b.setAdapter(new com.tencent.luggage.wxa.zb.a(list));
        this.f126993b.setCurrentItem(0);
        this.f126993b.setIsOptions(true);
        a aVar = new a();
        if (list == null || !this.f126995d) {
            return;
        }
        this.f126993b.setOnItemSelectedListener(aVar);
    }

    public void a(String str) {
        if (str != null) {
            this.f126993b.setLabel(str);
        }
    }

    public int[] a() {
        return new int[]{this.f126993b.getCurrentItem()};
    }

    public final void a(int i3) {
        if (this.f126994c != null) {
            this.f126993b.setCurrentItem(i3);
        }
    }

    public void a(WheelView.c cVar) {
        this.f126999h = cVar;
        e();
    }

    public void a(boolean z16) {
        this.f126993b.a(z16);
    }

    public void a(com.tencent.luggage.wxa.fc.c cVar) {
        this.f126997f = cVar;
    }

    public final void f() {
    }

    public void a(float f16) {
        this.f126993b.setDividerHeight(f16);
    }

    public void a(int i3, int i16, int i17, int i18) {
        this.f126993b.setPadding(i3, i16, i17, i18);
    }
}
