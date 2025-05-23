package com.tencent.mapsdk.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ub extends View implements bw {

    /* renamed from: a, reason: collision with root package name */
    private Context f151234a;

    /* renamed from: b, reason: collision with root package name */
    private tr f151235b;

    /* renamed from: c, reason: collision with root package name */
    private Object f151236c;

    /* renamed from: d, reason: collision with root package name */
    private int f151237d;

    /* renamed from: e, reason: collision with root package name */
    private int f151238e;

    /* renamed from: f, reason: collision with root package name */
    private tq f151239f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f151240g;

    public ub(bf bfVar) {
        super(bfVar.getContext());
        this.f151240g = true;
        Object j3 = bfVar.j();
        if (j3 == null) {
            return;
        }
        this.f151234a = bfVar.getContext();
        this.f151235b = (tr) bfVar.b();
        this.f151236c = j3;
        this.f151237d = bfVar.k();
        int l3 = bfVar.l();
        this.f151238e = l3;
        if (l3 <= 0 || this.f151237d <= 0) {
            this.f151237d = 0;
            this.f151238e = 0;
        }
        tq tqVar = new tq(this.f151235b);
        this.f151239f = tqVar;
        tqVar.a(this.f151236c);
        tq.a(bfVar.n());
        this.f151239f.f151003a = bfVar.p();
        this.f151239f.start();
    }

    private void f() {
        tr trVar = this.f151235b;
        if (trVar != null && this.f151240g) {
            trVar.a((GL10) null, (EGLConfig) null);
            this.f151235b.a((GL10) null, this.f151237d, this.f151238e);
            this.f151235b.e(this.f151237d, this.f151238e);
            this.f151240g = false;
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void a() {
        tq tqVar = this.f151239f;
        if (tqVar != null) {
            tqVar.b();
        }
        tr trVar = this.f151235b;
        if (trVar == null || !this.f151240g) {
            return;
        }
        trVar.a((GL10) null, (EGLConfig) null);
        this.f151235b.a((GL10) null, this.f151237d, this.f151238e);
        this.f151235b.e(this.f151237d, this.f151238e);
        this.f151240g = false;
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void b() {
        tq tqVar = this.f151239f;
        if (tqVar != null) {
            tqVar.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void c() {
        tq tqVar = this.f151239f;
        if (tqVar != null) {
            tqVar.c();
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void d() {
        tq tqVar = this.f151239f;
        if (tqVar != null) {
            synchronized (tqVar) {
                this.f151239f.notify();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final boolean e() {
        return false;
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.bw
    public final void onSizeChanged(int i3, int i16, int i17, int i18) {
        tr trVar = this.f151235b;
        if (trVar != null) {
            this.f151237d = i3;
            this.f151238e = i16;
            trVar.a((GL10) null, i3, i16);
            this.f151235b.e(i3, i16);
            this.f151235b.G();
            this.f151240g = true;
        }
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.bw
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void a(Object obj, int i3, int i16) {
        tq tqVar;
        if (this.f151235b == null || (tqVar = this.f151239f) == null || !tqVar.isAlive()) {
            return;
        }
        tq tqVar2 = this.f151239f;
        if (tqVar2 != null) {
            this.f151236c = obj;
            tqVar2.a(obj);
        }
        tr trVar = this.f151235b;
        if (trVar != null) {
            trVar.a((GL10) null, (EGLConfig) null);
            this.f151235b.a((GL10) null, i3, i16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void a(float f16) {
        if (this.f151239f != null) {
            tq.a(f16);
        }
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final View getView() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void setMapOpaque(boolean z16) {
    }

    @Override // com.tencent.mapsdk.internal.bw
    public final void setZOrderMediaOverlay(boolean z16) {
    }
}
