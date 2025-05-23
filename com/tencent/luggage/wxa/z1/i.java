package com.tencent.luggage.wxa.z1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.kj.c0;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.o0;
import com.tencent.luggage.wxa.kj.p0;
import com.tencent.luggage.wxa.kj.r;
import com.tencent.luggage.wxa.kj.r0;
import com.tencent.luggage.wxa.kj.s0;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.lj.t;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.u1.e;
import com.tencent.luggage.wxa.z1.b;
import com.tencent.luggage.wxa.z1.i;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.b;
import com.tencent.magicbrush.ui.g;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends com.tencent.luggage.wxa.p4.a implements com.tencent.luggage.wxa.z1.d, b.c {
    public final ArrayList C;
    public final View.OnAttachStateChangeListener D;

    /* renamed from: c, reason: collision with root package name */
    public g f146196c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.magicbrush.ui.g f146197d;

    /* renamed from: e, reason: collision with root package name */
    public c0 f146198e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.z1.b f146199f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f146200g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f146201h;

    /* renamed from: i, reason: collision with root package name */
    public Bitmap f146202i;

    /* renamed from: j, reason: collision with root package name */
    public Bitmap f146203j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f146204k;

    /* renamed from: l, reason: collision with root package name */
    public final com.tencent.luggage.wxa.z1.a f146205l;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f146206m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements p0 {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.kj.p0
        public void a(r rVar) {
            if (rVar != null && rVar.getParent() == null) {
                i.this.f146196c.addView(rVar, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements s0 {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.kj.s0
        public void a(FrameLayout frameLayout) {
            if (frameLayout != null && frameLayout.getParent() == null) {
                i.this.f146196c.addView(frameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements e.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.w1.b f146212a;

        public d(com.tencent.luggage.wxa.w1.b bVar) {
            this.f146212a = bVar;
        }

        @Override // com.tencent.luggage.wxa.u1.e.d
        public void a(List list) {
            try {
                i.this.a(this.f146212a.n(), list);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f146204k == null) {
                return;
            }
            if (i.this.f146204k.getDrawable() instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) i.this.f146204k.getDrawable();
                i.this.f146204k.setImageDrawable(null);
                try {
                    bitmapDrawable.getBitmap().recycle();
                } catch (Exception e16) {
                    w.a("Luggage.Game.WAGamePageViewRenderer", e16, "hy: cleanupCoverScreenshot error!", new Object[0]);
                }
            }
            i.this.f146204k.setVisibility(8);
        }
    }

    public i(@NonNull com.tencent.luggage.wxa.m4.b bVar) {
        super(bVar);
        this.f146200g = new AtomicBoolean(false);
        this.f146201h = new AtomicBoolean(true);
        this.f146206m = new AtomicBoolean(false);
        this.C = new ArrayList(3);
        this.D = new a();
        this.f146205l = new com.tencent.luggage.wxa.z1.a();
        C();
        x();
        a(bVar.y0().g0());
    }

    public final void A() {
        if (this.f146203j != null) {
            try {
                w.d("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
                this.f146203j.recycle();
            } catch (Exception e16) {
                w.a("Luggage.Game.WAGamePageViewRenderer", e16, "hy: cleanupCanvasSecurityGuard error!", new Object[0]);
            }
            this.f146203j = null;
        }
    }

    public final void B() {
        if (this.f146204k != null) {
            e eVar = new e();
            if (Looper.getMainLooper() == Looper.myLooper()) {
                eVar.run();
            } else {
                try {
                    com.tencent.luggage.wxa.zp.h.f146825d.a(eVar).get();
                } catch (InterruptedException | ExecutionException e16) {
                    w.b("Luggage.Game.WAGamePageViewRenderer", "cleanupCoverScreenshot await ui get exception %s", e16);
                }
            }
        }
        Bitmap bitmap = this.f146202i;
        if (bitmap != null) {
            try {
                bitmap.recycle();
            } catch (Exception e17) {
                w.a("Luggage.Game.WAGamePageViewRenderer", e17, "hy: cleanupCoverScreenshot error!", new Object[0]);
            }
            this.f146202i = null;
        }
    }

    public void C() {
        a(com.tencent.luggage.wxa.z1.d.class, this);
    }

    public void D() {
        if (this.f146206m.compareAndSet(false, true)) {
            ((com.tencent.luggage.wxa.m4.b) t()).e("onFirstFrame");
            com.tencent.luggage.wxa.gi.b.b(u(), com.tencent.luggage.wxa.ik.a.Z);
            com.tencent.luggage.wxa.gi.b.b(u(), com.tencent.luggage.wxa.ik.a.U);
        }
    }

    public final void E() {
        if (t() != null && ((com.tencent.luggage.wxa.m4.b) t()).y0() != null && ((com.tencent.luggage.wxa.m4.b) t()).y0().h(com.tencent.luggage.wxa.w1.b.class) != null) {
            ((com.tencent.luggage.wxa.w1.b) ((com.tencent.luggage.wxa.m4.b) t()).y0().h(com.tencent.luggage.wxa.w1.b.class)).j().b();
        }
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public boolean a(String str, k1 k1Var) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public boolean d() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public boolean e() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public r0 g() {
        return this.f146199f;
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public c0 getCustomViewContainer() {
        return this.f146198e;
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void h() {
        super.h();
        this.f146197d.getMagicBrush().l();
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void m() {
        super.m();
        super.a(com.tencent.luggage.wxa.mj.i.class, new com.tencent.luggage.wxa.b2.b((v) t()));
        super.a(com.tencent.luggage.wxa.mj.e.class, new h((v) t(), w().E().a().f125641a));
        if (((com.tencent.luggage.wxa.m4.b) t()).D() instanceof WindowAndroidActivityImpl) {
            this.f146196c.a(((WindowAndroidActivityImpl) ((com.tencent.luggage.wxa.m4.b) t()).D()).j());
        }
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void o() {
        super.o();
        this.f146200g.set(false);
        if (this.f146201h.get()) {
            B();
        }
        A();
        this.f146197d.getMagicBrush().m();
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public Map q() {
        return Collections.emptyMap();
    }

    public final void x() {
        a((com.tencent.luggage.wxa.a2.a) new com.tencent.luggage.wxa.a2.b(), true);
    }

    public final void y() {
        boolean z16 = ((com.tencent.luggage.wxa.m4.b) t()).getRuntime().j0().F;
        boolean z17 = ((com.tencent.luggage.wxa.m4.b) t()).getRuntime().j0().F;
        if (z16 || z17) {
            com.tencent.luggage.wxa.w1.b bVar = (com.tencent.luggage.wxa.w1.b) ((com.tencent.luggage.wxa.m4.b) t()).y0().h(com.tencent.luggage.wxa.w1.b.class);
            if (bVar != null) {
                bVar.j().a(new e.c().a((com.tencent.luggage.wxa.xd.i) t()).a(bVar.n()).a(this.f146196c).b(z16).a(z17).a(new d(bVar)));
            } else {
                w.a("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.wxa.w1.d(), "hy: you're not on game service!", new Object[0]);
            }
        }
    }

    public final void z() {
        com.tencent.luggage.wxa.zp.i iVar = com.tencent.luggage.wxa.zp.h.f146825d;
        final ArrayList arrayList = this.C;
        Objects.requireNonNull(arrayList);
        iVar.a(new Runnable() { // from class: y41.a
            @Override // java.lang.Runnable
            public final void run() {
                arrayList.clear();
            }
        });
    }

    public com.tencent.magicbrush.ui.g b(Context context) {
        return new com.tencent.magicbrush.ui.g(context, g.h.f147523a);
    }

    @Override // com.tencent.luggage.wxa.z1.d
    public com.tencent.magicbrush.ui.g c() {
        return this.f146197d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i3) {
        D();
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public View a(LayoutInflater layoutInflater) {
        g gVar = new g(layoutInflater.getContext());
        this.f146196c = gVar;
        return gVar;
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public void a(View view) {
        com.tencent.luggage.wxa.w1.b bVar = (com.tencent.luggage.wxa.w1.b) a(com.tencent.luggage.wxa.w1.b.class);
        if (bVar == null) {
            w.a("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.wxa.w1.d(), "hy: not on game service!", new Object[0]);
            return;
        }
        Context c16 = z.c();
        com.tencent.magicbrush.ui.g b16 = b(c16);
        this.f146197d = b16;
        b16.setId(R.id.f164359sr1);
        com.tencent.magicbrush.b n3 = bVar.n();
        this.f146197d.setMagicBrush(n3);
        n3.v().a(new b.InterfaceC7010b() { // from class: y41.b
            @Override // com.tencent.magicbrush.b.InterfaceC7010b
            public final void a(int i3) {
                i.this.b(i3);
            }
        });
        this.f146196c.addView(this.f146197d, 0, new FrameLayout.LayoutParams(-1, -1));
        com.tencent.luggage.wxa.z1.b bVar2 = new com.tencent.luggage.wxa.z1.b(c16);
        this.f146199f = bVar2;
        bVar2.setNativeWidgetAddedCallback(this);
        this.f146196c.addView(this.f146199f, -1, new ViewGroup.LayoutParams(-1, -1));
        com.tencent.luggage.wxa.z1.c cVar = new com.tencent.luggage.wxa.z1.c(this.f146199f);
        this.f146198e = cVar;
        cVar.a(((com.tencent.luggage.wxa.m4.b) t()).h0());
        this.f146198e.a(new b());
        this.f146198e.a(new c());
        y();
        ImageView imageView = new ImageView(c16);
        this.f146204k = imageView;
        imageView.setVisibility(8);
        this.f146196c.addView(this.f146204k, new FrameLayout.LayoutParams(-1, -1));
        this.f146196c.addOnAttachStateChangeListener(this.D);
    }

    @Override // com.tencent.luggage.wxa.z1.b.c
    public void b(View view) {
        if (view.getVisibility() == 0 && this.f146206m.compareAndSet(false, true)) {
            ((com.tencent.luggage.wxa.m4.b) t()).e("onNativeWidgetViewAdded");
        }
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public RelativeLayout.LayoutParams a(View view, View view2) {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.z1.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC6967a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View.OnAttachStateChangeListener f146208a;

            public RunnableC6967a(View.OnAttachStateChangeListener onAttachStateChangeListener) {
                this.f146208a = onAttachStateChangeListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.f146196c.removeOnAttachStateChangeListener(this.f146208a);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            w.d("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
            i.this.f146197d.getMagicBrush().m();
            i.this.f146197d.post(new RunnableC6967a(this));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public void a(MBRuntime mBRuntime, List list) {
        if (mBRuntime == null) {
            w.b("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
            return;
        }
        com.tencent.luggage.wxa.o8.a d16 = mBRuntime.d();
        list.add(new com.tencent.luggage.wxa.u1.f("RT-FPS", "" + Math.round(d16.f136199a)));
        list.add(new com.tencent.luggage.wxa.u1.f("EX-FPS", "" + Math.round(d16.f136200b)));
        list.add(new com.tencent.luggage.wxa.u1.f("Jank", "" + d16.f136201c));
        list.add(new com.tencent.luggage.wxa.u1.f("BigJank", "" + d16.f136202d));
        list.add(new com.tencent.luggage.wxa.u1.f("Stutter", String.format(Locale.ENGLISH, "%.2f%%", Float.valueOf(d16.f136203e * 100.0f))));
    }

    @Override // com.tencent.luggage.wxa.kj.x
    public void p() {
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void a(com.tencent.luggage.wxa.kl.b bVar) {
        bVar.setFullscreenMode(true);
        t.b(bVar.getCapsuleView(), bVar.getContext());
        t.a(bVar);
    }

    @Override // com.tencent.luggage.wxa.p4.a, com.tencent.luggage.wxa.kj.x
    public void a() {
        super.a();
        B();
        A();
        z();
        E();
        g gVar = this.f146196c;
        if (gVar == null || gVar.f146182b == null) {
            return;
        }
        gVar.a();
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public boolean a(String str, String str2, int i3) {
        if (t() != null) {
            ((com.tencent.luggage.wxa.m4.b) t()).y0().a(str, str2, i3);
        } else {
            w.h("Luggage.Game.WAGamePageViewRenderer", "dispatch: component is null, event: %s src:%d", str, Integer.valueOf(i3));
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public boolean a(String str, String str2, int[] iArr) {
        if (t() != null) {
            ((com.tencent.luggage.wxa.m4.b) t()).y0().a(str, str2);
        } else {
            w.h("Luggage.Game.WAGamePageViewRenderer", "publish: component is null, event: %s", str);
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public boolean a(int i3, String str) {
        if (t() != null) {
            ((com.tencent.luggage.wxa.m4.b) t()).y0().a(i3, str);
        } else {
            w.h("Luggage.Game.WAGamePageViewRenderer", "callback: component is null, callbackId: %d", Integer.valueOf(i3));
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.mj.d
    public o0 a(Context context) {
        return this.f146205l;
    }

    @Override // com.tencent.luggage.wxa.z1.d
    public Bitmap a(int i3, boolean z16) {
        w.d("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap");
        if (i3 == -1) {
            w.b("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId is illegal");
            return null;
        }
        w.d("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId:%d,sync:%b", Integer.valueOf(i3), Boolean.valueOf(z16));
        Bitmap a16 = a(i3);
        w.d("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
        return a16;
    }

    public void a(com.tencent.luggage.wxa.a2.a aVar, boolean z16) {
        if (z16) {
            this.C.add(0, aVar);
        } else {
            this.C.add(aVar);
        }
    }

    public final Bitmap a(int i3) {
        com.tencent.magicbrush.ui.g gVar = this.f146197d;
        if (gVar != null) {
            return gVar.getMagicBrush().s().a(this.f146197d.getVirtualElementId(), i3, false);
        }
        w.b("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", Integer.valueOf(i3));
        return null;
    }
}
