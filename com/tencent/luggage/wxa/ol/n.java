package com.tencent.luggage.wxa.ol;

import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import java.lang.ref.Reference;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n implements g.c {

    /* renamed from: a, reason: collision with root package name */
    public final Map f136876a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.kj.v f136877b;

    /* renamed from: c, reason: collision with root package name */
    public final int f136878c;

    /* renamed from: d, reason: collision with root package name */
    public final int f136879d;

    /* renamed from: e, reason: collision with root package name */
    public int f136880e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f136881f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f136882g;

    /* renamed from: h, reason: collision with root package name */
    public int f136883h;

    /* renamed from: i, reason: collision with root package name */
    public Queue f136884i;

    /* renamed from: j, reason: collision with root package name */
    public int f136885j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f136886k;

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f136887l;

    /* renamed from: m, reason: collision with root package name */
    public static final n f136875m = new a();
    public static final ArrayMap C = new ArrayMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View i3;
            com.tencent.luggage.wxa.kj.o0 D0;
            View contentView;
            if (n.this.f136877b.isRunning() && (i3 = n.this.i()) != null) {
                i3.scrollTo(0, 0);
                if (n.this.f136885j != 0 && (D0 = n.this.f136877b.D0()) != null && (contentView = D0.getContentView()) != null) {
                    contentView.scrollBy(contentView.getScrollX(), -n.this.f136885j);
                }
                n.this.g();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f136893a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f136894b;

        public e(int i3, boolean z16) {
            this.f136893a = i3;
            this.f136894b = z16;
        }
    }

    public /* synthetic */ n(a aVar) {
        this();
    }

    public static /* synthetic */ int j(n nVar) {
        int i3 = nVar.f136880e + 1;
        nVar.f136880e = i3;
        return i3;
    }

    @Override // com.tencent.luggage.wxa.xd.g.c
    public void onDestroy() {
        this.f136877b.b(this);
        C.remove(this.f136877b);
    }

    public n() {
        this.f136876a = new ArrayMap();
        this.f136879d = 5;
        this.f136880e = 0;
        this.f136881f = false;
        this.f136882g = true;
        this.f136883h = -1;
        this.f136884i = new LinkedList();
        this.f136885j = 0;
        this.f136886k = new b();
        this.f136887l = new c();
        this.f136877b = null;
        this.f136878c = 0;
    }

    public final int d() {
        Display defaultDisplay = ((WindowManager) this.f136877b.getContentView().getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public final void f() {
        if (this.f136876a.size() <= 0) {
            return;
        }
        for (d dVar : (d[]) this.f136876a.keySet().toArray(new d[this.f136876a.size()])) {
            dVar.b();
        }
    }

    public final void g() {
        if (this.f136876a.size() <= 0) {
            return;
        }
        for (d dVar : (d[]) this.f136876a.keySet().toArray(new d[this.f136876a.size()])) {
            dVar.a();
        }
    }

    public final void h() {
        if (this.f136884i.isEmpty()) {
            return;
        }
        this.f136884i.poll();
        if (this.f136884i.isEmpty()) {
            return;
        }
        e eVar = (e) this.f136884i.peek();
        a(eVar.f136893a, eVar.f136894b, true);
    }

    public final View i() {
        if (this.f136877b.isRunning()) {
            return a(this.f136877b);
        }
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p0 f136890a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f136891b;

            public a(p0 p0Var, int i3) {
                this.f136890a = p0Var;
                this.f136891b = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f136890a.a(this.f136891b);
            }
        }

        public c() {
        }

        public final void a(p0 p0Var, int i3) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandInputPageOffsetHelper", "sendKeyboardEvent: %b", Boolean.valueOf(n.this.f136882g));
            if (n.this.f136882g) {
                com.tencent.luggage.wxa.tn.c0.a(new a(p0Var, i3));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(EditText editText, int i3) {
            View contentView;
            com.tencent.luggage.wxa.kj.o0 D0 = n.this.f136877b.D0();
            if (D0 != null && (contentView = D0.getContentView()) != null && editText != 0) {
                q0 q0Var = (q0) editText;
                if (q0Var.f()) {
                    a(i3 + a());
                    return;
                }
                int height = D0.getHeight();
                int webScrollY = D0.getWebScrollY();
                int a16 = com.tencent.luggage.wxa.tk.g.a(D0.getContentHeight());
                int height2 = editText.getHeight();
                editText.getTop();
                if (!q0Var.h() && (editText.getTop() + height2) - webScrollY <= height) {
                    a(i3 + a());
                    return;
                }
                int max = Math.max(0, Math.min((a16 - webScrollY) - height, i3));
                contentView.scrollBy(contentView.getScrollX(), max);
                n.this.f136885j = max;
                a((i3 - max) + a());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.e("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
            p0 a16 = r.a(n.this.f136877b);
            if (a16 == null) {
                n.this.h();
            } else if (!n.this.f136877b.isRunning()) {
                n.this.h();
            } else {
                n.this.f136885j = 0;
                a(a16);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(p0 p0Var) {
            if (n.this.f136877b.K0()) {
                return;
            }
            if (p0Var.getInputPanel() == null || p0Var.d() == null) {
                n.this.h();
                return;
            }
            EditText d16 = p0Var.d();
            View inputPanel = p0Var.getInputPanel();
            if (com.tencent.luggage.wxa.uk.n0.a(d16)) {
                a(p0Var, 0);
                n.this.h();
                return;
            }
            if (((r0) inputPanel).e()) {
                n.this.f136880e = 0;
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", Integer.valueOf(inputPanel.getHeight()));
            } else {
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", Integer.valueOf(inputPanel.getHeight()), Integer.valueOf(n.this.f136880e));
                if (n.j(n.this) < 5) {
                    n.this.a(false);
                    return;
                }
            }
            a(p0Var, inputPanel.getHeight());
            if (!p0Var.e()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", Integer.valueOf(inputPanel.getHeight()));
                n.this.h();
                return;
            }
            if ((n.this.f136877b.D() instanceof WindowAndroidActivityImpl) && n.this.f136877b.d()) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, in landscape skip adjust position, notify height %d", Integer.valueOf(inputPanel.getHeight()));
                n.this.h();
                return;
            }
            int[] iArr = new int[2];
            d16.getLocationOnScreen(iArr);
            int i3 = iArr[1];
            com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", Integer.valueOf(d16.getHeight()), Integer.valueOf(i3), Boolean.valueOf(ViewCompat.isAttachedToWindow(d16)));
            n.this.d();
            int height = d16.getHeight() + i3;
            inputPanel.getLocationOnScreen(iArr);
            int i16 = iArr[1];
            String adjustKeyboardTo = d16 instanceof t ? ((t) d16).getAdjustKeyboardTo() : null;
            q0 q0Var = (q0) d16;
            if (q0Var.h() && d16.getLayout() != null && !"bottom".equals(adjustKeyboardTo)) {
                int scrollY = d16.getScrollY();
                int a16 = (q0Var.a(d16.getLayout().getLineForOffset(d16.getSelectionStart())) + i3) - scrollY;
                int a17 = (q0Var.a(d16.getLayout().getLineForOffset(d16.getSelectionStart()) + 1) + i3) - scrollY;
                if (a16 - i3 >= d16.getHeight()) {
                    a16 = height - d16.getLineHeight();
                }
                if (a17 - i3 < d16.getHeight()) {
                    height = a17;
                }
                i3 = a16;
            }
            if (!n.this.f136877b.d()) {
                height += p0Var.c();
            }
            if (i16 == height) {
                n.this.h();
            } else if (i3 < n.this.f136878c) {
                a(d16, i3);
                n.this.h();
            } else {
                b(d16, Math.max(-a(), Math.min(height - i16, i3 - n.this.f136878c)));
                n.this.h();
            }
        }

        public final void a(EditText editText, int i3) {
            View contentView;
            com.tencent.luggage.wxa.kj.o0 D0 = n.this.f136877b.D0();
            if (D0 == null || (contentView = D0.getContentView()) == null || editText == null) {
                return;
            }
            contentView.scrollBy(contentView.getScrollX(), -(D0.getWebScrollY() - editText.getTop()));
        }

        public final int a() {
            View i3 = n.this.i();
            if (i3 != null) {
                return i3.getScrollY();
            }
            return 0;
        }

        public final void a(int i3) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", Integer.valueOf(i3));
            View i16 = n.this.i();
            if (i16 != null) {
                i16.scrollTo(0, i3);
                n.this.f();
            }
        }
    }

    public void b(d dVar) {
        if (dVar == null) {
            return;
        }
        this.f136876a.remove(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static n b(com.tencent.luggage.wxa.kj.v vVar) {
        if (vVar != null && vVar.isRunning()) {
            ArrayMap arrayMap = C;
            n nVar = (n) arrayMap.get(vVar);
            if (nVar != null) {
                return nVar;
            }
            n nVar2 = new n(vVar);
            arrayMap.put(vVar, nVar2);
            return nVar2;
        }
        com.tencent.luggage.wxa.tn.w.e("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page " + vVar, new Object[0]);
        return f136875m;
    }

    public void a(d dVar) {
        if (dVar == null || this.f136876a.containsKey(dVar)) {
            return;
        }
        this.f136876a.put(dVar, this);
    }

    public static n a(Reference reference) {
        return b(reference == null ? null : (com.tencent.luggage.wxa.kj.v) reference.get());
    }

    public static View a(com.tencent.luggage.wxa.kj.v vVar) {
        return vVar.q0();
    }

    public final void a(boolean z16) {
        if (z16) {
            this.f136880e = 0;
            this.f136881f = false;
        }
        com.tencent.luggage.wxa.kj.v vVar = this.f136877b;
        if (vVar != null && vVar.isRunning()) {
            if (this.f136881f) {
                this.f136880e = 0;
                h();
                return;
            } else if (this.f136880e == 0) {
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", Boolean.valueOf(ViewCompat.isAttachedToWindow(this.f136877b.getContentView())));
                this.f136877b.getContentView().post(this.f136887l);
                return;
            } else {
                com.tencent.luggage.wxa.tn.w.g("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", Boolean.valueOf(ViewCompat.isAttachedToWindow(this.f136877b.getContentView())));
                this.f136877b.getContentView().postOnAnimationDelayed(this.f136887l, 100L);
                return;
            }
        }
        h();
    }

    public void b(int i3) {
        b(i3, true);
    }

    public void b(int i3, boolean z16) {
        a(i3, z16, false);
    }

    public n(com.tencent.luggage.wxa.kj.v vVar) {
        this.f136876a = new ArrayMap();
        this.f136879d = 5;
        this.f136880e = 0;
        this.f136881f = false;
        this.f136882g = true;
        this.f136883h = -1;
        this.f136884i = new LinkedList();
        this.f136885j = 0;
        this.f136886k = new b();
        this.f136887l = new c();
        this.f136877b = vVar;
        vVar.a(this);
        this.f136878c = com.tencent.luggage.wxa.po.a.a(vVar.a0());
    }

    public final void a(int i3, boolean z16, boolean z17) {
        if (!z17) {
            this.f136884i.offer(new e(i3, z16));
        }
        if (this.f136884i.size() <= 1 || z17) {
            this.f136883h = i3;
            this.f136882g = z16;
            a(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends n {
        public a() {
            super((a) null);
        }

        public String toString() {
            return super.toString() + "|DUMMY";
        }

        @Override // com.tencent.luggage.wxa.ol.n, com.tencent.luggage.wxa.xd.g.c
        public void onDestroy() {
        }

        @Override // com.tencent.luggage.wxa.ol.n
        public void a(int i3) {
        }

        @Override // com.tencent.luggage.wxa.ol.n
        public void b(int i3) {
        }
    }

    public void a(int i3) {
        a(i3, true);
    }

    public void a(int i3, boolean z16) {
        if (this.f136877b.isRunning()) {
            int i16 = this.f136883h;
            if (i3 != i16) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandInputPageOffsetHelper", "requestScrollDown, skip last-ticket %d, pass-in-ticket %d", Integer.valueOf(i16), Integer.valueOf(i3));
                return;
            }
            this.f136881f = true;
            this.f136882g = z16;
            this.f136877b.getContentView().post(this.f136886k);
        }
    }
}
