package com.tencent.luggage.wxa.kj;

import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.kj.g1;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.xd.f;
import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c0 implements f.a {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ boolean f132086n = true;

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f132087a;

    /* renamed from: e, reason: collision with root package name */
    public float[] f132091e;

    /* renamed from: f, reason: collision with root package name */
    public View f132092f;

    /* renamed from: g, reason: collision with root package name */
    public f1 f132093g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.wj.d f132094h;

    /* renamed from: j, reason: collision with root package name */
    public p0 f132096j;

    /* renamed from: k, reason: collision with root package name */
    public r f132097k;

    /* renamed from: l, reason: collision with root package name */
    public FrameLayout f132098l;

    /* renamed from: m, reason: collision with root package name */
    public s0 f132099m;

    /* renamed from: d, reason: collision with root package name */
    public int f132090d = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f132095i = -1;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.tn.b0 f132088b = new com.tencent.luggage.wxa.tn.b0(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final Deque f132089c = new ConcurrentLinkedDeque();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.wj.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.wj.b
        public void j() {
            c0.this.l();
            if (c0.this.f132093g != null) {
                c0.this.f132093g.onExitFullscreen();
                c0.this.f132093g = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends com.tencent.luggage.wxa.tn.s0 {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ View f132101h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f132102i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f132103j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ float[] f132104k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ int f132105l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f132106m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f132107n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ boolean f132108o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j3, Boolean bool, View view, int i3, int i16, float[] fArr, int i17, boolean z16, boolean z17, boolean z18) {
            super(j3, bool);
            this.f132101h = view;
            this.f132102i = i3;
            this.f132103j = i16;
            this.f132104k = fArr;
            this.f132105l = i17;
            this.f132106m = z16;
            this.f132107n = z17;
            this.f132108o = z18;
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(c0.this.b(this.f132101h, this.f132102i, this.f132103j, this.f132104k, this.f132105l, this.f132106m, this.f132107n, this.f132108o));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends com.tencent.luggage.wxa.tn.s0 {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f132110h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(long j3, Boolean bool, int i3) {
            super(j3, bool);
            this.f132110h = i3;
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(c0.this.l(this.f132110h));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends com.tencent.luggage.wxa.tn.s0 {
        public d(long j3, Boolean bool) {
            super(j3, bool);
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            try {
                c0.this.k();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandWebViewCustomViewContainer", "removeAll error " + e16);
            }
            return Boolean.FALSE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends com.tencent.luggage.wxa.tn.s0 {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f132113h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ float[] f132114i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f132115j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Boolean f132116k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Boolean f132117l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j3, Boolean bool, int i3, float[] fArr, int i16, Boolean bool2, Boolean bool3) {
            super(j3, bool);
            this.f132113h = i3;
            this.f132114i = fArr;
            this.f132115j = i16;
            this.f132116k = bool2;
            this.f132117l = bool3;
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(c0.this.b(this.f132113h, this.f132114i, this.f132115j, this.f132116k, this.f132117l));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends com.tencent.luggage.wxa.tn.s0 {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f132119h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ f1 f132120i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f132121j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(long j3, Boolean bool, int i3, f1 f1Var, int i16) {
            super(j3, bool);
            this.f132119h = i3;
            this.f132120i = f1Var;
            this.f132121j = i16;
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(c0.this.b(this.f132119h, this.f132120i, this.f132121j));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g extends com.tencent.luggage.wxa.tn.s0 {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f132123h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(long j3, Boolean bool, int i3) {
            super(j3, bool);
            this.f132123h = i3;
        }

        @Override // com.tencent.luggage.wxa.tn.s0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(c0.this.j(this.f132123h));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements g1.a {

        /* renamed from: a, reason: collision with root package name */
        public View f132125a;

        /* renamed from: b, reason: collision with root package name */
        public float f132126b;

        /* renamed from: c, reason: collision with root package name */
        public float f132127c;

        /* renamed from: d, reason: collision with root package name */
        public float f132128d;

        /* renamed from: e, reason: collision with root package name */
        public float f132129e;

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.kj.g1.a
        public void a(View view, int i3, int i16, int i17, int i18) {
            float f16 = i3;
            this.f132128d = f16;
            float f17 = i16;
            this.f132129e = f17;
            this.f132125a.setX(this.f132126b + f16);
            this.f132125a.setY(this.f132127c + f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f132130a;

        /* renamed from: b, reason: collision with root package name */
        public int f132131b;

        /* renamed from: c, reason: collision with root package name */
        public int f132132c;

        /* renamed from: d, reason: collision with root package name */
        public int f132133d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f132134e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f132135f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f132136g;

        /* renamed from: h, reason: collision with root package name */
        public h f132137h;

        public i(View view, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
            this.f132130a = new WeakReference(view);
            this.f132131b = i3;
            this.f132132c = i16;
            this.f132133d = i17;
            this.f132134e = z16;
            this.f132135f = z17;
            this.f132136g = z18;
        }
    }

    public c0(ViewGroup viewGroup) {
        this.f132087a = viewGroup;
        this.f132092f = new View(viewGroup.getContext());
    }

    public void d() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "clear: ");
        Iterator it = this.f132089c.iterator();
        while (it.hasNext()) {
            a.c h16 = h(((i) it.next()).f132131b);
            if (h16 != null) {
                h16.b();
            }
        }
        this.f132089c.clear();
    }

    public ViewGroup e() {
        h();
        return this.f132097k;
    }

    public ViewGroup f() {
        return this.f132097k;
    }

    public ViewGroup g() {
        i();
        return this.f132098l;
    }

    public final void h() {
        if (this.f132097k == null) {
            r rVar = new r(this.f132087a.getContext());
            this.f132097k = rVar;
            p0 p0Var = this.f132096j;
            if (p0Var != null) {
                p0Var.a(rVar);
            }
        }
    }

    public final void i() {
        if (this.f132098l == null) {
            FrameLayout frameLayout = new FrameLayout(this.f132087a.getContext());
            this.f132098l = frameLayout;
            s0 s0Var = this.f132099m;
            if (s0Var != null) {
                s0Var.a(frameLayout);
            }
        }
    }

    public void j() {
        d dVar = new d(1000L, Boolean.FALSE);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            dVar.a((com.tencent.luggage.wxa.tn.b0) null);
        }
        dVar.a(this.f132088b);
    }

    public final void k() {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f132089c.iterator();
        while (it.hasNext()) {
            linkedList.add((i) it.next());
        }
        Iterator it5 = linkedList.iterator();
        while (it5.hasNext()) {
            l(((i) it5.next()).f132131b);
        }
        linkedList.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l(int i3) {
        i k3 = k(i3);
        if (k3 == null) {
            return false;
        }
        j(i3);
        e(k3);
        ViewGroup a16 = a(k3.f132132c, k3.f132135f, k3.f132136g);
        if (a16 == 0) {
            return false;
        }
        d(k3);
        a16.removeView((View) k3.f132130a.get());
        if (k3.f132132c != 0 || !(a16 instanceof g1) || !k3.f132134e) {
            return true;
        }
        ((g1) a16).b(k3.f132137h);
        return true;
    }

    public final List c(i iVar) {
        if (iVar.f132132c == iVar.f132131b) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (i iVar2 : this.f132089c) {
            if (iVar.f132131b == iVar2.f132132c && iVar.f132132c != iVar2.f132131b) {
                linkedList.addAll(c(iVar2));
            }
        }
        linkedList.add(iVar);
        return linkedList;
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public boolean f(int i3) {
        c cVar = new c(1000L, Boolean.FALSE, i3);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) cVar.a((com.tencent.luggage.wxa.tn.b0) null)).booleanValue();
        }
        return ((Boolean) cVar.a(this.f132088b)).booleanValue();
    }

    public void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setSource(4098);
        Iterator it = this.f132089c.iterator();
        while (it.hasNext()) {
            View view = (View) ((i) it.next()).f132130a.get();
            if (view != null) {
                view.dispatchTouchEvent(obtain);
            }
        }
        obtain.recycle();
    }

    public final void e(i iVar) {
        try {
            Iterator it = c(iVar).iterator();
            while (it.hasNext()) {
                d((i) it.next());
            }
        } catch (StackOverflowError unused) {
            b(iVar);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public boolean g(int i3) {
        return k(i3) != null;
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public a.c h(int i3) {
        return com.tencent.luggage.wxa.nb.a.a().d(hashCode() + "#" + i3);
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public int i(int i3) {
        i k3;
        int i16;
        if (i3 == 0 || (k3 = k(i3)) == null) {
            return -1;
        }
        View view = (View) k3.f132130a.get();
        if (view instanceof com.tencent.luggage.wxa.ye.b) {
            boolean c16 = ((com.tencent.luggage.wxa.ye.b) view).c();
            if (c16) {
                return k3.f132131b;
            }
            if (!c16 && (i16 = k3.f132132c) > 0) {
                return i(i16);
            }
        }
        return -1;
    }

    public final boolean j(int i3) {
        if (i3 != this.f132090d || k(i3) == null) {
            return false;
        }
        this.f132094h.c();
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public int d(int i3) {
        i k3 = k(i3);
        if (k3 == null) {
            return 0;
        }
        return k3.f132132c;
    }

    public void a(com.tencent.luggage.wxa.wj.d dVar) {
        this.f132094h = dVar;
        dVar.a(new a());
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public boolean e(int i3) {
        g gVar = new g(1000L, Boolean.FALSE, i3);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) gVar.a((com.tencent.luggage.wxa.tn.b0) null)).booleanValue();
        }
        return ((Boolean) gVar.a(this.f132088b)).booleanValue();
    }

    public final void d(i iVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "removeViewInfo: [%d, %d]", Integer.valueOf(iVar.f132131b), Integer.valueOf(iVar.f132132c));
        this.f132089c.remove(iVar);
    }

    public void a(p0 p0Var) {
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(p0Var != null);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "setFullScreenViewObtainer fullScreenViewAttacher:%b", objArr);
        this.f132096j = p0Var;
        r rVar = this.f132097k;
        if (rVar != null) {
            p0Var.a(rVar);
        }
    }

    public final i k(int i3) {
        for (i iVar : this.f132089c) {
            if (iVar.f132131b == i3) {
                return iVar;
            }
        }
        return null;
    }

    public final void l() {
        WeakReference weakReference;
        View view;
        i k3;
        WeakReference weakReference2;
        View view2;
        i k16 = k(this.f132095i);
        float[] fArr = this.f132091e;
        if (k16 == null || (weakReference = k16.f132130a) == null || fArr == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i3 = this.f132095i;
        int i16 = this.f132090d;
        if (i3 != i16 && (k3 = k(i16)) != null && (weakReference2 = k3.f132130a) != null && (view2 = (View) weakReference2.get()) != null) {
            b(this.f132090d, fArr, view2.getVisibility(), Boolean.valueOf(k16.f132134e), Boolean.FALSE);
        }
        int i17 = this.f132095i;
        this.f132090d = -1;
        this.f132095i = -1;
        b(i17, fArr, view.getVisibility(), Boolean.valueOf(k16.f132134e), Boolean.FALSE);
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public View c(int i3) {
        i k3 = k(i3);
        if (k3 == null) {
            return null;
        }
        return (View) k3.f132130a.get();
    }

    public final boolean b(View view, int i3, int i16, float[] fArr, int i17, boolean z16, boolean z17) {
        return b(view, i3, i16, fArr, i17, z16, z17, false);
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public View c() {
        return this.f132087a;
    }

    public void a(s0 s0Var) {
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(s0Var != null);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "setUnderViewAttacher notnull:%b", objArr);
        this.f132099m = s0Var;
        FrameLayout frameLayout = this.f132098l;
        if (frameLayout != null) {
            if (!f132086n && s0Var == null) {
                throw new AssertionError();
            }
            s0Var.a(frameLayout);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(View view, int i3, int i16, float[] fArr, int i17, boolean z16, boolean z17, boolean z18) {
        ViewGroup a16;
        int childCount;
        if (view == null || fArr == null || fArr.length < 5 || (a16 = a(i16, z17, z18)) == 0 || c(i3) != null) {
            return false;
        }
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        float f19 = fArr[3];
        int a17 = d1.a(fArr[4], 0);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) f18, (int) f19);
        int a18 = a(i16, a17);
        if (a18 < 0) {
            a18 = 0;
        }
        if (a16 instanceof com.tencent.luggage.wxa.ye.r) {
            childCount = ((com.tencent.luggage.wxa.ye.r) a16).getTargetViewChildCount();
        } else {
            childCount = a16.getChildCount();
        }
        if (a18 > childCount) {
            a18 = childCount;
        }
        if (i17 >= 0) {
            view.setVisibility(i17 != 0 ? 4 : 0);
        }
        a16.addView(view, a18, layoutParams);
        i a19 = a(view, i3, i16, a17, z16, z17, z18);
        if (i16 == 0 && (a16 instanceof g1) && z16) {
            h hVar = new h(null);
            hVar.f132125a = view;
            hVar.f132126b = f16;
            hVar.f132127c = f17;
            hVar.f132128d = this.f132087a.getScrollX();
            float scrollY = this.f132087a.getScrollY();
            hVar.f132129e = scrollY;
            f16 += hVar.f132128d;
            f17 += scrollY;
            ((g1) a16).a(hVar);
            a19.f132137h = hVar;
        }
        view.setX(f16);
        view.setY(f17);
        return true;
    }

    public boolean a(View view, int i3, int i16, float[] fArr, int i17, boolean z16) {
        return a(view, i3, i16, fArr, i17, z16, false);
    }

    public boolean a(View view, int i3, int i16, float[] fArr, int i17, boolean z16, boolean z17) {
        return a(view, i3, i16, fArr, i17, z16, z17, false);
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public boolean a(View view, int i3, int i16, float[] fArr, int i17, boolean z16, boolean z17, boolean z18) {
        b bVar = new b(1000L, Boolean.FALSE, view, i3, i16, fArr, i17, z16, z17, z18);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) bVar.a((com.tencent.luggage.wxa.tn.b0) null)).booleanValue();
        }
        return ((Boolean) bVar.a(this.f132088b)).booleanValue();
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public ViewGroup a() {
        return a(0, false, false);
    }

    public final ViewGroup a(int i3, boolean z16, boolean z17) {
        if (z17) {
            return g();
        }
        if (z16) {
            return e();
        }
        if (i3 == 0) {
            return this.f132087a;
        }
        i k3 = k(i3);
        if (k3 == null) {
            return null;
        }
        View view = (View) k3.f132130a.get();
        if ((view instanceof com.tencent.luggage.wxa.we.e) && (view instanceof com.tencent.luggage.wxa.ye.s) && (view instanceof ViewGroup)) {
            return (ViewGroup) ((com.tencent.luggage.wxa.we.e) view).a(com.tencent.luggage.wxa.we.a.class);
        }
        if ((view instanceof com.tencent.luggage.wxa.ye.s) && (view instanceof ViewGroup)) {
            return (ViewGroup) view;
        }
        return null;
    }

    public boolean a(int i3, float[] fArr, int i16, Boolean bool) {
        return a(i3, fArr, i16, bool, Boolean.FALSE);
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public boolean a(int i3, float[] fArr, int i16, Boolean bool, Boolean bool2) {
        e eVar = new e(1000L, Boolean.FALSE, i3, fArr, i16, bool, bool2);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) eVar.a((com.tencent.luggage.wxa.tn.b0) null)).booleanValue();
        }
        return ((Boolean) eVar.a(this.f132088b)).booleanValue();
    }

    public final int a(int i3, int i16) {
        int i17 = 0;
        for (i iVar : this.f132089c) {
            if (i3 == iVar.f132132c && i16 >= iVar.f132133d) {
                i17++;
            }
        }
        return i17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(int i3, float[] fArr, int i16, Boolean bool, Boolean bool2) {
        if (a(i3)) {
            return true;
        }
        i k3 = k(i3);
        if (k3 == null) {
            return false;
        }
        View view = (View) k3.f132130a.get();
        boolean booleanValue = bool2 != null ? bool2.booleanValue() : k3.f132135f;
        ViewGroup a16 = a(k3.f132132c, booleanValue, k3.f132136g);
        if (a16 == 0) {
            return false;
        }
        if (i16 >= 0) {
            view.setVisibility(i16 == 0 ? 0 : 4);
        }
        if (fArr == null || fArr.length < 5) {
            return true;
        }
        float f16 = fArr[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        float f19 = fArr[3];
        int a17 = d1.a(fArr[4], k3.f132133d);
        boolean booleanValue2 = bool != null ? bool.booleanValue() : k3.f132134e;
        if (k3.f132133d == a17 && k3.f132135f == booleanValue) {
            h hVar = k3.f132137h;
            if (k3.f132132c == 0 && (a16 instanceof g1) && booleanValue2 != k3.f132134e) {
                if (booleanValue2) {
                    if (hVar == null) {
                        hVar = new h(null);
                        hVar.f132125a = view;
                        k3.f132137h = hVar;
                    }
                    ((g1) a16).a(hVar);
                } else {
                    ((g1) a16).b(hVar);
                }
            }
            if (hVar != null) {
                hVar.f132126b = f16;
                hVar.f132127c = f17;
                hVar.f132128d = this.f132087a.getScrollX();
                float scrollY = this.f132087a.getScrollY();
                hVar.f132129e = scrollY;
                f16 += hVar.f132128d;
                f17 += scrollY;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = (int) f18;
            layoutParams.height = (int) f19;
            view.setX(f16);
            view.setY(f17);
            view.requestLayout();
            int indexOfChild = a16.indexOfChild(this.f132092f);
            if (a16.indexOfChild(view) == -1 && indexOfChild != -1) {
                a16.addView(view, indexOfChild);
                a16.removeView(this.f132092f);
            }
            return true;
        }
        d(k3);
        a16.removeView(view);
        if (view.getParent() != null) {
            if (k3.f132137h != null && (view.getParent() instanceof g1)) {
                ((g1) view.getParent()).b(k3.f132137h);
            }
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (b(view, i3, k3.f132132c, fArr, i16, booleanValue2, booleanValue)) {
            return true;
        }
        e(k3);
        return false;
    }

    public final i a(View view, int i3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        i iVar = new i(view, i3, i16, i17, z16, z17, z18);
        a(iVar);
        return iVar;
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public a.c a(int i3, boolean z16) {
        return com.tencent.luggage.wxa.nb.a.a().a(hashCode() + "#" + i3, z16);
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public boolean a(int i3) {
        return this.f132095i == i3 || this.f132090d == i3;
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public boolean a(int i3, f1 f1Var, int i16) {
        f fVar = new f(1000L, Boolean.FALSE, i3, f1Var, i16);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) fVar.a((com.tencent.luggage.wxa.tn.b0) null)).booleanValue();
        }
        return ((Boolean) fVar.a(this.f132088b)).booleanValue();
    }

    public View a(Class cls) {
        return a(this.f132087a, cls);
    }

    public final View a(ViewGroup viewGroup, Class cls) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof ViewGroup) {
                return a((ViewGroup) childAt, cls);
            }
            if (cls.isInstance(childAt)) {
                return (View) cls.cast(childAt);
            }
        }
        return null;
    }

    public final void a(i iVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "addViewInfo: [%d, %d]", Integer.valueOf(iVar.f132131b), Integer.valueOf(iVar.f132132c));
        this.f132089c.add(iVar);
    }

    public final void b(i iVar) {
        LinkedList linkedList = new LinkedList(this.f132089c);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: oops");
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: root: [id] = %d [parent] = %d", Integer.valueOf(iVar.f132131b), Integer.valueOf(iVar.f132132c));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "==================ViewInfoListBegin==================");
        Iterator it = linkedList.iterator();
        int i3 = -1;
        while (it.hasNext()) {
            i iVar2 = (i) it.next();
            i3++;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "dumpViewInfoBeforeCrash: vi#%d [id] = %d [parent] = %d", Integer.valueOf(i3), Integer.valueOf(iVar2.f132131b), Integer.valueOf(iVar2.f132132c));
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandWebViewCustomViewContainer", "==================ViewInfoListEnd==================");
        com.tencent.luggage.wxa.tn.w.c();
        throw new StackOverflowError();
    }

    public final boolean b(int i3, f1 f1Var, int i16) {
        i k3;
        WeakReference weakReference;
        View view;
        ViewGroup viewGroup;
        i k16;
        ViewGroup a16;
        if (i3 == this.f132090d || (k3 = k(i3)) == null || (weakReference = k3.f132130a) == null || (view = (View) weakReference.get()) == null) {
            return false;
        }
        this.f132095i = i3;
        ViewGroup a17 = a(k3.f132132c, false, false);
        if ((a17 instanceof com.tencent.luggage.wxa.we.a) && ((com.tencent.luggage.wxa.we.a) a17).a() && (k16 = k(k3.f132132c)) != null && (a16 = a(k16.f132132c, false, false)) != null) {
            View view2 = (View) k3.f132130a.get();
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                view2.setLayoutParams(layoutParams);
            }
            this.f132095i = k16.f132131b;
            k3 = k16;
            a17 = a16;
        }
        if (a17 != null) {
            view = (View) k3.f132130a.get();
            int indexOfChild = a17.indexOfChild(view);
            View view3 = this.f132092f;
            if (view3 != null && (viewGroup = (ViewGroup) view3.getParent()) != null) {
                viewGroup.removeView(this.f132092f);
            }
            a17.addView(this.f132092f, indexOfChild);
            a17.removeView(view);
        }
        this.f132091e = new float[]{view.getX(), view.getY(), view.getWidth(), view.getHeight(), k3.f132133d};
        this.f132094h.a(view, i16);
        this.f132090d = i3;
        this.f132093g = f1Var;
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.f.a
    public boolean b(int i3) {
        i k3;
        int i16;
        if (i3 == 0 || (k3 = k(i3)) == null) {
            return false;
        }
        View view = (View) k3.f132130a.get();
        if (view instanceof com.tencent.luggage.wxa.ye.b) {
            boolean c16 = ((com.tencent.luggage.wxa.ye.b) view).c();
            if (c16) {
                return true;
            }
            if (!c16 && (i16 = k3.f132132c) > 0) {
                return b(i16);
            }
        }
        return false;
    }
}
