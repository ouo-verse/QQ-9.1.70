package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ZoomControls;
import com.tencent.mapsdk.internal.ew;
import com.tencent.mapsdk.internal.qa;
import com.tencent.mapsdk.internal.sj;
import com.tencent.mapsdk.internal.sl;
import com.tencent.mapsdk.internal.tk;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class bm implements am, be, fj, fp, ft {

    /* renamed from: a, reason: collision with root package name */
    public static final String f147892a = "key_change_style";

    /* renamed from: b, reason: collision with root package name */
    public tr f147893b;

    /* renamed from: c, reason: collision with root package name */
    public sl f147894c;

    /* renamed from: d, reason: collision with root package name */
    public sj f147895d;

    /* renamed from: e, reason: collision with root package name */
    pz f147896e;

    /* renamed from: f, reason: collision with root package name */
    qa.a f147897f;

    /* renamed from: g, reason: collision with root package name */
    Bundle f147898g;

    /* renamed from: m, reason: collision with root package name */
    private qs f147901m;

    /* renamed from: n, reason: collision with root package name */
    private int f147902n;

    /* renamed from: h, reason: collision with root package name */
    List<ew> f147899h = new CopyOnWriteArrayList();

    /* renamed from: o, reason: collision with root package name */
    private boolean f147903o = false;

    /* renamed from: i, reason: collision with root package name */
    public Handler f147900i = new Handler(kp.a("gesture")) { // from class: com.tencent.mapsdk.internal.bm.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            String str;
            ViewGroup ab5;
            String str2;
            if (message != null && (obj = message.obj) != null) {
                gc gcVar = (gc) obj;
                int i3 = gcVar.f148468f;
                if (i3 == 0) {
                    sl slVar = bm.this.f147894c;
                    if (slVar != null) {
                        boolean z16 = gcVar.f148469g;
                        boolean z17 = gcVar.f148470h;
                        if (slVar.f150308b != null) {
                            kp.a(new sl.AnonymousClass4(z16, z17));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i3 == 1) {
                    sj sjVar = bm.this.f147895d;
                    if (sjVar != null) {
                        int i16 = gcVar.f148471i;
                        double d16 = gcVar.f148472j;
                        sjVar.f150265k = i16;
                        sjVar.f150266l = d16;
                        int width = sjVar.f150248a.getWidth();
                        if (width <= 0) {
                            width = 1000;
                        }
                        int ceil = (int) Math.ceil(width / 4.0f);
                        int ceil2 = (int) (Math.ceil((sjVar.f150259d * 3.0f) / 8.0f) - (sjVar.f150264j * 6.0f));
                        float[] fArr = sj.f150247f;
                        int length = fArr.length;
                        int i17 = sjVar.f150265k - sjVar.f150270p;
                        if (i17 < 0) {
                            i17 = 0;
                        }
                        if (i17 >= length) {
                            i17 = length - 1;
                        }
                        float f16 = fArr[i17];
                        if (sjVar.f150261g != f16) {
                            sjVar.f150261g = f16;
                            kp.a(new sj.AnonymousClass5());
                        }
                        float f17 = ceil;
                        double d17 = sjVar.f150266l;
                        if (d17 != 0.0d) {
                            f17 = (float) (f16 / d17);
                        }
                        int round = Math.round(f17);
                        sjVar.f150263i = round;
                        if (round > ceil2) {
                            sjVar.f150263i = ceil2;
                        } else if (round < ceil) {
                            sjVar.f150263i = ceil;
                        }
                        if (f16 >= 1000.0f) {
                            f16 /= 1000.0f;
                            str2 = "\u516c\u91cc";
                        } else {
                            str2 = "\u7c73";
                        }
                        sjVar.f150262h = ((int) f16) + str2;
                        sjVar.f();
                        return;
                    }
                    return;
                }
                if (i3 == 3 && ho.f148706i == 1) {
                    if (TextUtils.equals(tf.f150436c, "wechat") || (ab5 = bm.this.f147893b.ab()) == null) {
                        return;
                    }
                    bm bmVar = bm.this;
                    if (bmVar.f147896e == null) {
                        bmVar.f147896e = new pz(ab5.getContext().getApplicationContext(), bm.this.f147893b.d_);
                        bm bmVar2 = bm.this;
                        bmVar2.f147896e.f149726b = bmVar2.f147897f;
                    }
                    bm.this.f147896e.a(ab5, null);
                    return;
                }
                if (i3 == 2 && bm.this.f147893b.R) {
                    boolean b16 = v.b(gcVar.f148474l);
                    VectorMap vectorMap = (VectorMap) bm.this.f147893b.e_;
                    if (b16) {
                        str = om.f149480b;
                    } else {
                        str = om.f149479a;
                    }
                    tk tkVar = vectorMap.f151351o.f149396i;
                    if (tkVar != null && 0 != tkVar.f150515e) {
                        tkVar.a(new tk.AnonymousClass151(str));
                    }
                }
            }
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.bm$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f147906a;

        static {
            int[] iArr = new int[ew.b.values().length];
            f147906a = iArr;
            try {
                iArr[ew.b.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f147906a[ew.b.LEFT_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f147906a[ew.b.RIGHT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f147906a[ew.b.RIGHT_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public bm(bf bfVar, ViewGroup viewGroup, bw bwVar) {
        if (bwVar != 0 && viewGroup != null) {
            tr trVar = (tr) bfVar.b();
            this.f147893b = trVar;
            ((VectorMap) trVar.e_).a(this);
            if (bwVar instanceof View) {
                View view = (View) bwVar;
                if (viewGroup.indexOfChild(view) < 0) {
                    viewGroup.addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
                    viewGroup.requestLayout();
                }
            }
            sj sjVar = new sj(bfVar.getContext(), this.f147893b, ((VectorMap) this.f147893b.e_).p());
            this.f147895d = sjVar;
            this.f147893b.f151056m = sjVar;
            qs qsVar = new qs(bfVar);
            this.f147901m = qsVar;
            this.f147895d.f150275u = qsVar;
            this.f147893b.f151057n = qsVar;
            this.f147894c = new sl(bfVar.getContext(), this.f147893b);
            this.f147899h.add(this.f147895d);
            this.f147899h.add(this.f147894c);
            this.f147899h.add(this.f147901m);
            this.f147893b.a((fj) this);
            tr trVar2 = this.f147893b;
            trVar2.f151039as.remove(this);
            trVar2.f151039as.add(this);
            this.f147893b.a((fp) this);
        }
    }

    private void k() {
        tr trVar = this.f147893b;
        if (trVar == null) {
            return;
        }
        Handler handler = this.f147900i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ((VectorMap) trVar.e_).f151351o.f149398k.b(this);
        trVar.f151039as.remove(this);
        trVar.b((fj) this);
        ViewGroup ab5 = trVar.ab();
        if (ab5 != null) {
            ab5.removeAllViews();
        }
        Iterator<ew> it = this.f147899h.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.f147899h.clear();
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void g(boolean z16) {
        this.f147893b.e(z16);
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void h(boolean z16) {
        this.f147893b.f(z16);
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void i(boolean z16) {
        this.f147893b.f151124av = z16;
        d(z16);
        f(z16);
        g(z16);
        h(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        kp.a(new Runnable() { // from class: com.tencent.mapsdk.internal.bm.2
            @Override // java.lang.Runnable
            public final void run() {
                bm bmVar = bm.this;
                Bundle bundle = bmVar.f147898g;
                ViewGroup ab5 = bmVar.f147893b.ab();
                Iterator<ew> it = bmVar.f147899h.iterator();
                while (it.hasNext()) {
                    it.next().a(ab5, bundle);
                }
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void l(boolean z16) {
        M m3;
        ne neVar;
        ae aeVar;
        tr trVar = this.f147893b;
        if (trVar != null && (m3 = trVar.e_) != 0 && (neVar = ((VectorMap) m3).f151351o) != null && (aeVar = neVar.f149398k) != null) {
            aeVar.L = z16;
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void m(boolean z16) {
        M m3;
        ne neVar;
        ae aeVar;
        tr trVar = this.f147893b;
        if (trVar != null && (m3 = trVar.e_) != 0 && (neVar = ((VectorMap) m3).f151351o) != null && (aeVar = neVar.f149398k) != null) {
            aeVar.M = z16;
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void n(boolean z16) {
        ac acVar;
        qs qsVar = this.f147901m;
        tr trVar = qsVar.f149918e;
        if (trVar != null) {
            if (z16) {
                qsVar.f149915b = true;
            } else {
                qsVar.f149915b = false;
            }
            boolean z17 = qsVar.f149915b;
            if (trVar != null) {
                if (qsVar.f149914a == null) {
                    if (z17) {
                        qsVar.e();
                    } else {
                        return;
                    }
                }
                VectorMap vectorMap = (VectorMap) qsVar.f149918e.e_;
                if (qsVar.f149915b && z17 && (acVar = qsVar.f149917d) != null && acVar.f147693f) {
                    qsVar.a(vectorMap.f151353q.u());
                    return;
                }
                qsVar.a((IndoorBuilding) null);
                if (qsVar.f149914a.getVisibility() != 8) {
                    qsVar.f149914a.setVisibility(8);
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void o(boolean z16) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.f150268n = !z16;
            sjVar.e();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void b(boolean z16) {
        tr trVar = this.f147893b;
        if (trVar.R != z16) {
            gc gcVar = new gc();
            gcVar.f148468f = 2;
            Iterator<fj> it = trVar.f151060q.iterator();
            while (it.hasNext()) {
                it.next().a(gcVar);
            }
        }
        trVar.R = z16;
        ae aeVar = ((VectorMap) trVar.e_).f151351o.f149398k;
        aeVar.G = z16;
        aeVar.f147743z.g().b(aeVar.G);
        ((VectorMap) trVar.e_).f151351o.f149412y = true;
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void c(boolean z16) {
        this.f147903o = z16;
        sl slVar = this.f147894c;
        slVar.f150312f = z16;
        if (z16 && slVar.f150309c == null) {
            slVar.b(slVar.f150307a);
        }
        sk skVar = slVar.f150309c;
        if (skVar != null) {
            skVar.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void d(boolean z16) {
        this.f147893b.b(z16);
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void e(boolean z16) {
        this.f147893b.c(z16);
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void f(boolean z16) {
        this.f147893b.d(z16);
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean g() {
        return this.f147893b.j();
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean h() {
        qs qsVar = this.f147901m;
        if (qsVar != null) {
            return qsVar.f149915b;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void j(boolean z16) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            if (sjVar.f150267m != z16) {
                sjVar.f150267m = z16;
                List<sj.c> list = sjVar.f150272r;
                if (list != null) {
                    Iterator<sj.c> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().b(sjVar.f150269o, new Rect(sjVar.f150273s, sjVar.f150274t, 0, 0), sjVar.f150267m);
                    }
                }
            }
            sjVar.e();
        }
    }

    private void a(a aVar) {
        sl slVar = this.f147894c;
        if (slVar != null) {
            slVar.f150310d = aVar;
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean d() {
        return this.f147893b.g();
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean e() {
        return this.f147893b.h();
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean f() {
        return this.f147893b.i();
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void g(int i3) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.f150260e = i3;
            sjVar.f150271q = Float.MIN_VALUE;
            sjVar.h();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void d(int i3) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.a(ew.a.BOTTOM, i3);
            this.f147895d.h();
            j();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void e(int i3) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.b(ew.b.a(i3));
            j();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void f(int i3) {
        tr trVar = this.f147893b;
        if (trVar != null) {
            trVar.a(i3);
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void h(int i3) {
        sl slVar = this.f147894c;
        if (slVar != null) {
            slVar.a(ew.b.a(i3));
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void a(boolean z16) {
        sl slVar = this.f147894c;
        slVar.f150313g = z16;
        if (z16 && slVar.f150308b == null) {
            slVar.a(slVar.f150307a);
        }
        ZoomControls zoomControls = slVar.f150308b;
        if (zoomControls != null) {
            zoomControls.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.tencent.mapsdk.internal.ft
    public final void i(int i3) {
        if (this.f147898g == null) {
            this.f147898g = new Bundle();
        }
        this.f147898g.putInt(f147892a, i3);
        j();
        gc gcVar = new gc();
        gcVar.f148468f = 2;
        gcVar.f148474l = i3;
        a(gcVar);
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean c() {
        return this.f147903o;
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void c(int i3) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.a(ew.a.LEFT, i3);
            this.f147895d.h();
            j();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean a() {
        ZoomControls zoomControls = this.f147894c.f150308b;
        return zoomControls != null && zoomControls.getVisibility() == 0;
    }

    private void a(Bundle bundle) {
        ViewGroup ab5 = this.f147893b.ab();
        Iterator<ew> it = this.f147899h.iterator();
        while (it.hasNext()) {
            it.next().a(ab5, bundle);
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean i() {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            return sjVar.f150267m;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void k(boolean z16) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.f150257b = z16;
            ImageView imageView = sjVar.f150248a;
            if (imageView != null) {
                imageView.setVisibility(z16 ? 0 : 4);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void a(int i3, float f16) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            ew.a a16 = ew.a.a(i3);
            if (f16 < 0.0f) {
                f16 = 0.0f;
            }
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            sjVar.f150258c[a16.f148329e] = f16;
            sjVar.h();
            j();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final boolean b() {
        return this.f147893b.R;
    }

    @Override // com.tencent.mapsdk.internal.fp
    public final void b(int i3, int i16) {
        this.f147902n = i16;
        Iterator<ew> it = this.f147899h.iterator();
        while (it.hasNext()) {
            it.next().b(i3, i16);
        }
        j();
    }

    @Override // com.tencent.mapsdk.internal.am
    public final float a(int i3) {
        sj sjVar = this.f147895d;
        if (sjVar == null) {
            return 0.0f;
        }
        return sjVar.f150258c[ew.a.a(i3).f148329e];
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void a(int i3, int i16, int i17, int i18, int i19) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.a(ew.b.a(i3));
            this.f147895d.a(ew.a.TOP, i16);
            this.f147895d.a(ew.a.BOTTOM, i17);
            this.f147895d.a(ew.a.LEFT, i18);
            this.f147895d.a(ew.a.RIGHT, i19);
            this.f147895d.h();
            j();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void b(int i3) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.a(ew.b.a(i3));
            j();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void b(int i3, int i16, int i17, int i18, int i19) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            sjVar.b(ew.b.a(i3));
            this.f147895d.b(ew.a.TOP, i16);
            this.f147895d.b(ew.a.BOTTOM, i17);
            this.f147895d.b(ew.a.LEFT, i18);
            this.f147895d.b(ew.a.RIGHT, i19);
            this.f147895d.i();
            j();
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void a(int i3, int[] iArr) {
        if (this.f147895d != null) {
            ew.b a16 = ew.b.a(i3);
            this.f147895d.a(a16);
            int i16 = AnonymousClass3.f147906a[a16.ordinal()];
            if (i16 == 1) {
                this.f147895d.a(ew.a.TOP, iArr[0]);
                this.f147895d.a(ew.a.LEFT, iArr[1]);
            } else if (i16 == 2) {
                this.f147895d.a(ew.a.BOTTOM, iArr[0]);
                this.f147895d.a(ew.a.LEFT, iArr[1]);
            } else if (i16 == 3) {
                this.f147895d.a(ew.a.BOTTOM, iArr[0]);
                this.f147895d.a(ew.a.RIGHT, iArr[1]);
            } else if (i16 == 4) {
                this.f147895d.a(ew.a.TOP, iArr[0]);
                this.f147895d.a(ew.a.RIGHT, iArr[1]);
            }
            this.f147895d.h();
            j();
        }
    }

    private void b(boolean z16, List<ss> list) {
        tr trVar;
        sj sjVar = this.f147895d;
        if (sjVar == null || (trVar = this.f147893b) == null || trVar.e_ == 0) {
            return;
        }
        sjVar.a(list);
        if (z16) {
            this.f147895d.g();
        }
        this.f147895d.a(this.f147893b.ae(), ((ne) this.f147893b.d_).m());
    }

    @Override // com.tencent.mapsdk.internal.fj
    public final void a(gc gcVar) {
        int i3 = gcVar.f148468f;
        if (i3 != -1) {
            this.f147900i.sendMessage(this.f147900i.obtainMessage(i3, gcVar));
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void a(int i3, int i16) {
        tr trVar = this.f147893b;
        if (trVar != null) {
            trVar.a(i3, i16);
        }
    }

    @Override // com.tencent.mapsdk.internal.am
    public final void a(float f16) {
        sj sjVar = this.f147895d;
        if (sjVar != null) {
            if (f16 > 1.3f) {
                f16 = 1.3f;
            }
            if (f16 < 0.7f) {
                f16 = 0.7f;
            }
            sjVar.f150260e = 0;
            sjVar.f150271q = f16;
            sjVar.h();
        }
    }

    private void a(sj.c cVar, TencentMapOptions tencentMapOptions) {
        sj sjVar;
        if (tencentMapOptions == null || tencentMapOptions.getExtSurface() == null || (sjVar = this.f147895d) == null) {
            return;
        }
        List<sj.c> list = sjVar.f150272r;
        if (list != null && cVar != null) {
            list.add(cVar);
        }
        int extSurfaceWidth = tencentMapOptions.getExtSurfaceWidth();
        int extSurfaceHeight = tencentMapOptions.getExtSurfaceHeight();
        ViewGroup ab5 = this.f147893b.ab();
        if (ab5 != null) {
            ab5.measure(View.MeasureSpec.makeMeasureSpec(extSurfaceWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(extSurfaceHeight, 1073741824));
        }
        b(extSurfaceWidth, extSurfaceHeight);
    }

    public final void a(qa.a aVar, TencentMapOptions tencentMapOptions) {
        if (tencentMapOptions == null || tencentMapOptions.getExtSurface() == null) {
            return;
        }
        this.f147897f = aVar;
        int extSurfaceWidth = tencentMapOptions.getExtSurfaceWidth();
        int extSurfaceHeight = tencentMapOptions.getExtSurfaceHeight();
        ViewGroup ab5 = this.f147893b.ab();
        if (ab5 != null) {
            ab5.measure(View.MeasureSpec.makeMeasureSpec(extSurfaceWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(extSurfaceHeight, 1073741824));
        }
        b(extSurfaceWidth, extSurfaceHeight);
    }

    @Override // com.tencent.mapsdk.internal.be
    public final void a(boolean z16, List<ss> list) {
        tr trVar;
        sj sjVar = this.f147895d;
        if (sjVar == null || (trVar = this.f147893b) == null || trVar.e_ == 0) {
            return;
        }
        sjVar.a(list);
        if (z16) {
            this.f147895d.g();
        }
        this.f147895d.a(this.f147893b.ae(), ((ne) this.f147893b.d_).m());
    }

    private static /* synthetic */ void a(bm bmVar, Bundle bundle) {
        ViewGroup ab5 = bmVar.f147893b.ab();
        Iterator<ew> it = bmVar.f147899h.iterator();
        while (it.hasNext()) {
            it.next().a(ab5, bundle);
        }
    }
}
