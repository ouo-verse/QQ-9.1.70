package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.aelight.camera.ae.camera.ui.b;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView;
import com.tencent.aelight.camera.ae.camera.ui.bottom.d;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends RecyclerView.LayoutManager {
    private AEBottomListScrollView.b B;

    /* renamed from: d, reason: collision with root package name */
    protected int f62544d;

    /* renamed from: e, reason: collision with root package name */
    protected int f62545e;

    /* renamed from: f, reason: collision with root package name */
    protected int f62546f;

    /* renamed from: g, reason: collision with root package name */
    protected int f62547g;

    /* renamed from: h, reason: collision with root package name */
    protected int f62548h;

    /* renamed from: i, reason: collision with root package name */
    protected int f62549i;

    /* renamed from: j, reason: collision with root package name */
    protected int f62550j;

    /* renamed from: n, reason: collision with root package name */
    private d.a f62554n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f62555o;

    /* renamed from: p, reason: collision with root package name */
    private Context f62556p;

    /* renamed from: r, reason: collision with root package name */
    private int f62558r;

    /* renamed from: t, reason: collision with root package name */
    private boolean f62560t;

    /* renamed from: w, reason: collision with root package name */
    private int f62563w;

    /* renamed from: x, reason: collision with root package name */
    private int f62564x;

    /* renamed from: y, reason: collision with root package name */
    private final c f62565y;

    /* renamed from: z, reason: collision with root package name */
    private lf0.c f62566z;

    /* renamed from: q, reason: collision with root package name */
    private int f62557q = 100;

    /* renamed from: l, reason: collision with root package name */
    protected int f62552l = -1;

    /* renamed from: k, reason: collision with root package name */
    protected int f62551k = -1;

    /* renamed from: u, reason: collision with root package name */
    private int f62561u = 2100;

    /* renamed from: v, reason: collision with root package name */
    private boolean f62562v = false;

    /* renamed from: b, reason: collision with root package name */
    protected Point f62542b = new Point();

    /* renamed from: c, reason: collision with root package name */
    protected Point f62543c = new Point();

    /* renamed from: a, reason: collision with root package name */
    protected Point f62541a = new Point();

    /* renamed from: m, reason: collision with root package name */
    protected SparseArray<View> f62553m = new SparseArray<>();
    private lf0.a A = new lf0.a(this);

    /* renamed from: s, reason: collision with root package name */
    private int f62559s = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.bottom.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0540a extends LinearSmoothScroller {
        public C0540a(Context context) {
            super(context);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i3) {
            return a.this.f62554n.e(-a.this.f62550j);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i3) {
            return a.this.f62554n.d(-a.this.f62550j);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i3) {
            return (int) (Math.max(0.01f, Math.min(Math.abs(i3), a.this.f62547g) / a.this.f62547g) * a.this.f62557q);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public PointF computeScrollVectorForPosition(int i3) {
            return new PointF(a.this.f62554n.e(a.this.f62550j), a.this.f62554n.d(a.this.f62550j));
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        int a();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(float f16);

        void b();

        void c();

        void onScrollEnd();

        void onScrollStart();
    }

    public a(Context context, c cVar, d dVar) {
        this.f62556p = context;
        this.f62565y = cVar;
        this.f62554n = dVar.a();
    }

    private void L() {
        if (this.f62551k == -1) {
            return;
        }
        C0540a c0540a = new C0540a(this.f62556p);
        c0540a.setTargetPosition(this.f62551k);
        this.A.t(c0540a);
    }

    private void M(int i3) {
        this.f62550j = -this.f62549i;
        this.f62550j += com.tencent.aelight.camera.ae.camera.ui.b.b(i3 - this.f62551k).a(Math.abs(i3 - this.f62551k) * this.f62547g);
        this.f62552l = i3;
        L();
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getItemCount() == 0) {
            return 0;
        }
        return (int) (computeScrollRange(state) / getItemCount());
    }

    private int computeScrollOffset(RecyclerView.State state) {
        int computeScrollExtent = computeScrollExtent(state);
        return (this.f62551k * computeScrollExtent) + ((int) ((this.f62549i / this.f62547g) * computeScrollExtent));
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getItemCount() == 0) {
            return 0;
        }
        return this.f62547g * (getItemCount() - 1);
    }

    private int e(int i3) {
        int h16 = this.A.h();
        int i16 = this.f62551k;
        if (i16 != 0 && i3 < 0) {
            return 0;
        }
        int i17 = h16 - 1;
        return (i16 == i17 || i3 < h16) ? i3 : i17;
    }

    private void g(RecyclerView.State state) {
        int i3 = this.f62551k;
        if (i3 == -1 || i3 >= state.getItemCount()) {
            this.f62551k = 0;
        }
    }

    private float i(View view, int i3) {
        return Math.min(Math.max(-1.0f, this.f62554n.c(this.f62542b, getDecoratedLeft(view) + this.f62544d, getDecoratedTop(view) + this.f62545e) / i3), 1.0f);
    }

    private boolean p() {
        return ((float) Math.abs(this.f62549i)) >= ((float) this.f62547g) * 0.4f;
    }

    private boolean r(Point point, int i3) {
        return this.f62554n.f(point, this.f62544d, this.f62545e, i3, this.f62546f);
    }

    private void u() {
        int i3;
        if (this.f62552l != -1) {
            i3 = Math.abs(this.f62549i + this.f62550j);
        } else {
            i3 = this.f62547g;
        }
        this.f62565y.a(-Math.min(Math.max(-1.0f, this.f62549i / i3), 1.0f));
    }

    private void y(int i3) {
        if (this.f62551k != i3) {
            this.f62551k = i3;
            this.f62560t = true;
        }
    }

    private boolean z() {
        int i3;
        int a16;
        int i16 = this.f62552l;
        if (i16 != -1) {
            this.f62551k = i16;
            this.f62552l = -1;
            this.f62550j = 0;
            this.f62549i = 0;
            return true;
        }
        com.tencent.aelight.camera.ae.camera.ui.b b16 = com.tencent.aelight.camera.ae.camera.ui.b.b(this.f62549i);
        if (p()) {
            int abs = Math.abs(this.f62549i) % this.f62547g;
            int abs2 = Math.abs(this.f62549i);
            int i17 = this.f62547g;
            int i18 = abs2 / i17;
            if (abs < i17 * 0.4f) {
                i3 = this.f62551k;
                a16 = b16.a(i18);
            } else {
                i3 = this.f62551k;
                a16 = b16.a(i18 + 1);
            }
            int i19 = i3 + a16;
            if (i19 < 0) {
                i19 = 0;
            } else if (i19 > getItemCount() - 1) {
                i19 = getItemCount() - 1;
            }
            M(i19);
            return false;
        }
        int i26 = -this.f62549i;
        this.f62550j = i26;
        if (i26 == 0) {
            return true;
        }
        L();
        return false;
    }

    public void B() {
        int i3 = -this.f62549i;
        this.f62550j = i3;
        if (i3 != 0) {
            L();
        }
    }

    protected int C(int i3, RecyclerView.Recycler recycler) {
        if (this.A.f() == 0) {
            return 0;
        }
        this.f62549i += i3;
        int i16 = this.f62550j;
        if (i16 != 0) {
            this.f62550j = i16 - i3;
        }
        this.f62554n.b(-i3, this.A);
        if (this.f62554n.m(this)) {
            h(recycler);
        }
        u();
        c();
        return i3;
    }

    public void D(lf0.c cVar) {
        this.f62566z = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(AEBottomListScrollView.b bVar) {
        this.B = bVar;
    }

    public void F(int i3) {
        this.f62558r = i3;
        this.f62546f = this.f62547g * i3;
        this.A.s();
    }

    public void G(d dVar) {
        this.f62554n = dVar.a();
        this.A.q();
        this.A.s();
    }

    public void H(boolean z16) {
        this.f62562v = z16;
    }

    public void I(int i3) {
        this.f62561u = i3;
    }

    public void J(int i3) {
        this.f62557q = i3;
    }

    public void K(int i3) {
        this.f62559s = i3;
        c();
    }

    protected void N(RecyclerView.State state) {
        if ((state.isMeasuring() || (this.A.m() == this.f62563w && this.A.g() == this.f62564x)) ? false : true) {
            this.f62563w = this.A.m();
            this.f62564x = this.A.g();
            this.A.q();
        }
        this.f62542b.set(this.A.m() / 2, this.A.g() / 2);
    }

    protected void c() {
        if (this.f62566z != null) {
            int i3 = this.f62547g * this.f62559s;
            for (int i16 = 0; i16 < this.A.f(); i16++) {
                View e16 = this.A.e(i16);
                this.f62566z.a(e16, i(e16, i3));
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.f62554n.i();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.f62554n.l();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    protected void d() {
        this.f62553m.clear();
        for (int i3 = 0; i3 < this.A.f(); i3++) {
            View e16 = this.A.e(i3);
            this.f62553m.put(this.A.l(e16), e16);
        }
        for (int i16 = 0; i16 < this.f62553m.size(); i16++) {
            this.A.d(this.f62553m.valueAt(i16));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    protected void h(RecyclerView.Recycler recycler) {
        d();
        this.f62554n.j(this.f62542b, this.f62549i, this.f62543c);
        int a16 = this.f62554n.a(this.A.m(), this.A.g());
        if (r(this.f62543c, a16)) {
            s(recycler, this.f62551k, this.f62543c);
        }
        t(recycler, new b.C0538b(), a16);
        t(recycler, new b.a(), a16);
        A(recycler);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public int j() {
        return this.f62551k;
    }

    public int k() {
        return this.f62546f;
    }

    public View l() {
        return this.A.e(0);
    }

    public View m() {
        return this.A.e(r0.f() - 1);
    }

    public int n() {
        int i3 = this.f62549i;
        if (i3 == 0) {
            return this.f62551k;
        }
        int i16 = this.f62552l;
        return i16 != -1 ? i16 : this.f62551k + com.tencent.aelight.camera.ae.camera.ui.b.b(i3).a(1);
    }

    protected void o(RecyclerView.Recycler recycler) {
        View i3 = this.A.i(0, recycler);
        int k3 = this.A.k(i3);
        int j3 = this.A.j(i3);
        this.f62544d = k3 / 2;
        this.f62545e = j3 / 2;
        int k16 = this.f62554n.k(k3, j3);
        this.f62547g = k16;
        this.f62546f = k16 * this.f62558r;
        this.A.c(i3, recycler);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (this.A.f() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setFromIndex(getPosition(l()));
            asRecord.setToIndex(getPosition(m()));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i3, int i16) {
        int i17 = this.f62551k;
        if (i17 == -1) {
            i17 = 0;
        } else if (i17 >= i3) {
            i17 = Math.min(i17 + i16, this.A.h() - 1);
        }
        y(i17);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i3, int i16) {
        int i17 = this.f62551k;
        if (this.A.h() == 0) {
            i17 = -1;
        } else {
            int i18 = this.f62551k;
            if (i18 >= i3) {
                if (i18 < i3 + i16) {
                    this.f62551k = -1;
                }
                i17 = Math.max(0, this.f62551k - i16);
            }
        }
        y(i17);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() == 0) {
            this.A.r(recycler);
            this.f62552l = -1;
            this.f62551k = -1;
            this.f62550j = 0;
            this.f62549i = 0;
            return;
        }
        g(state);
        N(state);
        if (!this.f62555o) {
            boolean z16 = this.A.f() == 0;
            this.f62555o = z16;
            if (z16) {
                o(recycler);
            }
        }
        this.A.b(recycler);
        h(recycler);
        c();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.f62551k = ((Bundle) parcelable).getInt("extra_position");
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        int i3 = this.f62552l;
        if (i3 != -1) {
            this.f62551k = i3;
        }
        bundle.putInt("extra_position", this.f62551k);
        return bundle;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i3) {
        int i16 = this.f62548h;
        if (i16 == 0 && i16 != i3) {
            this.f62565y.onScrollStart();
        }
        if (i3 == 0) {
            if (!z()) {
                return;
            } else {
                this.f62565y.onScrollEnd();
            }
        } else if (i3 == 1) {
            v();
        }
        this.f62548h = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return C(i3, recycler);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i3) {
        if (this.f62551k == i3) {
            return;
        }
        this.f62551k = i3;
        this.A.s();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return C(i3, recycler);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        if (this.f62552l != -1) {
            return;
        }
        f(state, i3);
        if (this.f62551k == -1) {
            this.f62551k = i3;
        } else {
            M(i3);
        }
    }

    public void w(int i3, int i16) {
        int a16;
        int g16 = this.f62554n.g(i3, i16);
        if (!(this.f62549i * g16 >= 0)) {
            B();
            return;
        }
        int abs = this.f62562v ? Math.abs(g16 / this.f62561u) : 1;
        com.tencent.aelight.camera.ae.camera.ui.b b16 = com.tencent.aelight.camera.ae.camera.ui.b.b(this.f62549i);
        int i17 = this.f62551k;
        if (p() && this.f62547g != 0) {
            int abs2 = Math.abs(this.f62549i) % this.f62547g;
            int abs3 = Math.abs(this.f62549i);
            int i18 = this.f62547g;
            int i19 = abs3 / i18;
            if (abs2 < i18 * 0.4f) {
                a16 = b16.a(i19);
            } else {
                a16 = b16.a(i19 + 1);
            }
            i17 += a16;
        }
        int e16 = e(i17 + com.tencent.aelight.camera.ae.camera.ui.b.b(g16).a(abs));
        if (q(e16)) {
            M(e16);
        } else {
            B();
        }
    }

    public void x(RecyclerView.State state) {
        if (this.f62555o) {
            this.f62565y.b();
            this.f62555o = false;
        } else if (this.f62560t) {
            this.f62565y.c();
            this.f62560t = false;
            AEBottomListScrollView.b bVar = this.B;
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    private void t(RecyclerView.Recycler recycler, com.tencent.aelight.camera.ae.camera.ui.b bVar, int i3) {
        int a16 = bVar.a(1);
        int i16 = this.f62552l;
        boolean z16 = i16 == -1 || !bVar.c(i16 - this.f62551k);
        Point point = this.f62541a;
        Point point2 = this.f62543c;
        point.set(point2.x, point2.y);
        int i17 = this.f62551k;
        while (true) {
            i17 += a16;
            if (!q(i17)) {
                return;
            }
            if (i17 == this.f62552l) {
                z16 = true;
            }
            this.f62554n.h(bVar, this.f62547g, this.f62541a);
            if (r(this.f62541a, i3)) {
                s(recycler, i17, this.f62541a);
            } else if (z16) {
                return;
            }
        }
    }

    private void v() {
        this.f62552l = -1;
        this.f62550j = 0;
    }

    protected void A(RecyclerView.Recycler recycler) {
        for (int i3 = 0; i3 < this.f62553m.size(); i3++) {
            this.A.p(this.f62553m.valueAt(i3), recycler);
        }
        this.f62553m.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f62552l = -1;
        this.f62550j = 0;
        this.f62549i = 0;
        if (adapter2 instanceof b) {
            this.f62551k = ((b) adapter2).a();
        } else {
            this.f62551k = 0;
        }
        this.A.q();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f62551k = Math.min(Math.max(0, this.f62551k), this.A.h() - 1);
        this.f62560t = true;
    }

    private void f(RecyclerView.State state, int i3) {
        if (i3 < 0 || i3 >= state.getItemCount()) {
            throw new IllegalArgumentException(String.format(Locale.US, "target position out of bounds: position=%d, itemCount=%d", Integer.valueOf(i3), Integer.valueOf(state.getItemCount())));
        }
    }

    private boolean q(int i3) {
        return i3 >= 0 && i3 < this.A.h();
    }

    protected void s(RecyclerView.Recycler recycler, int i3, Point point) {
        if (i3 < 0 || i3 >= getItemCount()) {
            return;
        }
        View view = this.f62553m.get(i3);
        if (view == null) {
            View i16 = this.A.i(i3, recycler);
            lf0.a aVar = this.A;
            int i17 = point.x;
            int i18 = this.f62544d;
            int i19 = point.y;
            int i26 = this.f62545e;
            aVar.n(i16, i17 - i18, i19 - i26, i17 + i18, i19 + i26);
            return;
        }
        this.A.a(view);
        this.f62553m.remove(i3);
    }
}
