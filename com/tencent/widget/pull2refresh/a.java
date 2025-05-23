package com.tencent.widget.pull2refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIAppSetting;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

/* compiled from: P */
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private RecyclerViewCompat f384825a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayoutManager f384826b;

    /* renamed from: c, reason: collision with root package name */
    private e f384827c;

    /* renamed from: d, reason: collision with root package name */
    private f f384828d;

    /* renamed from: e, reason: collision with root package name */
    private c f384829e;

    /* renamed from: f, reason: collision with root package name */
    private d f384830f;

    /* renamed from: g, reason: collision with root package name */
    private OrientationHelper f384831g;

    /* renamed from: h, reason: collision with root package name */
    private OrientationHelper f384832h;

    /* renamed from: i, reason: collision with root package name */
    private int f384833i;

    /* renamed from: j, reason: collision with root package name */
    private int f384834j;

    /* renamed from: k, reason: collision with root package name */
    private int f384835k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f384836l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f384837m;

    /* renamed from: n, reason: collision with root package name */
    private int f384838n;

    /* renamed from: o, reason: collision with root package name */
    private int f384839o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f384840p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f384841q;

    /* renamed from: r, reason: collision with root package name */
    private float f384842r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f384843s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f384844t;

    /* renamed from: u, reason: collision with root package name */
    private int f384845u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.widget.pull2refresh.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public class C10045a extends RecyclerView.AdapterDataObserver {
        static IPatchRedirector $redirector_;

        C10045a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        private void a(int i3, int i16, boolean z16) {
            int i17;
            a aVar = a.this;
            View O = aVar.O(aVar.f384826b);
            if (O != null) {
                i17 = a.this.f384826b.getPosition(O);
            } else {
                i17 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PagerSnapHelper", 2, "onPagerDataChanged: positionStart=" + i3 + ", itemCount=" + i16 + ", centerPosition=" + a.this.f384835k + ", currentPosition=" + i17);
            }
            if (i3 <= i17 && (i3 + i16) - 1 >= i17) {
                a.this.f384829e.f384849d = z16;
                a.this.f384825a.addOnLayoutChangeListener(a.this.f384829e);
                a.this.f384825a.requestLayout();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a(0, a.this.f384826b.getItemCount(), true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), obj);
            } else if (obj == null) {
                onItemRangeChanged(i3, i16);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 <= a.this.f384835k) {
                a.this.f384835k += i16;
            }
            a(i3, i16, false);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (i3 == a.this.f384835k) {
                a.this.f384835k = i16;
            }
            a(i3, i17, false);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 <= a.this.f384835k) {
                a.this.f384835k -= i16;
            }
            a(i3, i16, false);
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                a(i3, i16, true);
            } else {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b extends LinearSmoothScroller {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f384847a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, LinearLayoutManager linearLayoutManager) {
            super(context);
            this.f384847a = linearLayoutManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, context, linearLayoutManager);
            }
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Float) iPatchRedirector.redirect((short) 5, (Object) this, (Object) displayMetrics)).floatValue();
            }
            return a.this.f384842r / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateTimeForDeceleration(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            return super.calculateTimeForDeceleration(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v7.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
            }
            return super.calculateTimeForScrolling(i3);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public PointF computeScrollVectorForPosition(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (PointF) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            return this.f384847a.computeScrollVectorForPosition(i3);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller, android.support.v7.widget.RecyclerView.SmoothScroller
        protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                int[] C = a.this.C(this.f384847a, view);
                int i3 = C[0];
                int i16 = C[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i3), Math.abs(i16)));
                if (calculateTimeForDeceleration <= 0) {
                    a.this.f384828d.onIdle();
                    return;
                } else {
                    action.update(i3, i16, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, this, view, state, action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class c implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f384849d;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            } else {
                this.f384849d = false;
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            a.this.f384825a.removeOnLayoutChangeListener(this);
            if (a.this.f384826b.getItemCount() > a.this.f384834j + a.this.f384833i) {
                if (QLog.isColorLevel()) {
                    QLog.d("PagerSnapHelper", 2, "onLayoutChange: ");
                }
                a aVar = a.this;
                View O = aVar.O(aVar.f384826b);
                if (!a.this.m0(O) || this.f384849d) {
                    a.this.K(O, this.f384849d);
                }
                this.f384849d = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class d implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f384851d;

        /* renamed from: e, reason: collision with root package name */
        private int f384852e;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            } else {
                this.f384851d = 0;
                this.f384852e = 0;
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            if (this.f384851d <= 0 || this.f384852e <= 0) {
                z16 = false;
            }
            if (z16 && !a.this.f384836l && (this.f384851d != view.getHeight() || this.f384852e != view.getWidth())) {
                a aVar = a.this;
                aVar.X(aVar.f384835k);
            }
            this.f384851d = view.getHeight();
            this.f384852e = view.getWidth();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface e {
        void b(RecyclerView.ViewHolder viewHolder);

        void onFooterRebound();

        void onPagerChanged(RecyclerView.ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class f extends RecyclerView.OnScrollListener implements RecyclerViewCompat.OnFlingListener, View.OnTouchListener {
        static IPatchRedirector $redirector_;
        private float C;
        private float D;
        private float E;

        /* renamed from: d, reason: collision with root package name */
        private boolean f384854d;

        /* renamed from: e, reason: collision with root package name */
        private int f384855e;

        /* renamed from: f, reason: collision with root package name */
        private int f384856f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f384857h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f384858i;

        /* renamed from: m, reason: collision with root package name */
        private float f384859m;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                return;
            }
            this.f384854d = false;
            this.f384855e = 0;
            this.f384856f = -1;
            this.f384857h = false;
            this.f384858i = false;
        }

        private void onDragging(int i3) {
            a.this.f384843s = false;
            if (i3 == 0 || i3 == 2) {
                a aVar = a.this;
                View O = aVar.O(aVar.f384826b);
                int i16 = -1;
                if (O != null) {
                    int position = a.this.f384826b.getPosition(O);
                    this.f384856f = position;
                    this.f384856f = a.this.A(position);
                } else {
                    this.f384856f = -1;
                }
                if (a.this.f384835k != -1 && a.this.f384826b.findViewByPosition(a.this.f384835k) == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: centerPosition has been recycler");
                    }
                    this.f384857h = true;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onScrollStateChanged: lastCenterView=");
                    if (O != null) {
                        i16 = a.this.f384826b.getPosition(O);
                    }
                    sb5.append(i16);
                    QLog.d("PagerSnapHelper", 2, sb5.toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onIdle() {
            int i3;
            a.this.f384843s = true;
            if (a.this.f384840p) {
                a.this.f384843s = !a.this.j0();
            }
            if (QLog.isColorLevel()) {
                QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: isRealIdle=" + a.this.f384843s);
            }
            if (a.this.f384843s) {
                a.this.f384836l = false;
            }
            a aVar = a.this;
            View O = aVar.O(aVar.f384826b);
            if (O != null) {
                i3 = a.this.f384826b.getPosition(O);
            } else {
                i3 = -1;
            }
            a aVar2 = a.this;
            if (!aVar2.D(i3, aVar2.f384826b)) {
                a.this.K(O, this.f384857h);
            } else if (!a.this.f384841q && !a.this.f384840p) {
                a aVar3 = a.this;
                if (i3 > aVar3.R(aVar3.f384826b)) {
                    a.this.I();
                } else if (i3 < a.this.T()) {
                    a.this.J();
                }
            }
            this.f384857h = false;
        }

        @Override // com.tencent.widget.pull2refresh.RecyclerViewCompat.OnFlingListener
        public boolean onFling(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (a.this.f384826b == null || a.this.f384825a.getAdapter() == null || !a.this.f384841q) {
                return false;
            }
            if (a.this.f384845u <= 0) {
                a aVar = a.this;
                aVar.f384845u = aVar.f384825a.getMinFlingVelocity();
            }
            int i3 = this.f384856f;
            if (Math.abs(f17) <= a.this.f384845u && Math.abs(f16) <= a.this.f384845u) {
                return false;
            }
            try {
                TraceCompat.beginSection("snapFromFling");
                a aVar2 = a.this;
                return aVar2.i0(aVar2.f384826b, this.D, this.E, f16, f17, i3);
            } finally {
                TraceCompat.endSection();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: state=" + i3);
            }
            int i16 = this.f384855e;
            this.f384855e = i3;
            if (i3 == 0) {
                TraceCompat.beginSection("snap onIdle");
                onIdle();
                TraceCompat.endSection();
            } else if (i3 == 1) {
                TraceCompat.beginSection("snap onDragging");
                onDragging(i16);
                TraceCompat.endSection();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (i3 != 0 || i16 != 0) {
                this.f384854d = true;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    this.f384858i = true;
                    if (this.f384859m <= 0.0f) {
                        this.f384859m = motionEvent.getX();
                    }
                    if (this.C <= 0.0f) {
                        this.C = motionEvent.getY();
                    }
                }
            } else {
                if (this.f384858i) {
                    this.D = this.f384859m - motionEvent.getX();
                    this.E = this.C - motionEvent.getY();
                } else {
                    this.D = 0.0f;
                    this.E = 0.0f;
                }
                this.f384859m = 0.0f;
                this.C = 0.0f;
                this.f384858i = false;
            }
            return false;
        }
    }

    public a(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16));
            return;
        }
        this.f384845u = -1;
        V();
        this.f384838n = i3;
        this.f384842r = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A(int i3) {
        int T = T();
        int R = R(this.f384826b);
        if (i3 < T) {
            return T;
        }
        if (i3 > R) {
            return R;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public int[] C(@NonNull LinearLayoutManager linearLayoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (linearLayoutManager.canScrollHorizontally()) {
            iArr[0] = L(linearLayoutManager, view, S(linearLayoutManager));
        } else {
            iArr[0] = 0;
        }
        if (linearLayoutManager.canScrollVertically()) {
            iArr[1] = L(linearLayoutManager, view, S(linearLayoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D(int i3, RecyclerView.LayoutManager layoutManager) {
        int R = R(layoutManager);
        if (i3 >= T() && i3 <= R) {
            return false;
        }
        return true;
    }

    private void E(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getAdapter() != null && recyclerView.getLayoutManager() != null) {
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                return;
            } else {
                throw new IllegalStateException("PagerSnapHelper can only attach to the RecyclerView with LinearLayoutManager");
            }
        }
        throw new IllegalStateException("PagerSnapHelper can't attach to the RecyclerView before setup Adapter or LayoutManager");
    }

    private int F() {
        return ViewConfiguration.get(this.f384825a.getContext()).getScaledTouchSlop();
    }

    private void H() {
        this.f384825a.removeOnScrollListener(this.f384828d);
        this.f384825a.setOnFlingListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        e eVar = this.f384827c;
        if (eVar != null) {
            eVar.onFooterRebound();
            if (QLog.isColorLevel()) {
                QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onFooterRebound");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (QLog.isColorLevel()) {
            QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: onHeaderRebound");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(View view, boolean z16) {
        RecyclerViewCompat recyclerViewCompat;
        if (view != null && (recyclerViewCompat = this.f384825a) != null && this.f384826b != null) {
            RecyclerView.ViewHolder childViewHolder = recyclerViewCompat.getChildViewHolder(view);
            int position = this.f384826b.getPosition(view);
            if (QLog.isColorLevel()) {
                QLog.d("PagerSnapHelper", 2, "dispatchPagerChanged: position=" + position + ", centerPosition=" + this.f384835k + ", reset=" + z16 + ", isRealIdle=" + this.f384843s + ", isNeedCallPageIdle=" + this.f384844t);
            }
            if (childViewHolder != null && position != -1) {
                if (position != this.f384835k || z16) {
                    if (D(position, this.f384826b)) {
                        if (QQUIAppSetting.isPublicVersion()) {
                            return;
                        } else {
                            throw new IllegalStateException("dispatchPagerChanged , position out of bound");
                        }
                    }
                    this.f384835k = position;
                    this.f384844t = true;
                    if (this.f384827c != null) {
                        TraceCompat.beginSection("onPagerChanged");
                        this.f384827c.onPagerChanged(childViewHolder);
                        TraceCompat.endSection();
                    }
                }
                if (this.f384843s && this.f384844t && this.f384827c != null) {
                    this.f384844t = false;
                    RecyclerView.ViewHolder childViewHolder2 = this.f384825a.getChildViewHolder(view);
                    TraceCompat.beginSection("onPagerIdle");
                    this.f384827c.b(childViewHolder2);
                    TraceCompat.endSection();
                }
            }
        }
    }

    private int L(@NonNull LinearLayoutManager linearLayoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        if (this.f384838n != 1) {
            return M(linearLayoutManager, view, orientationHelper);
        }
        return N(linearLayoutManager, view, orientationHelper);
    }

    private int M(@NonNull LinearLayoutManager linearLayoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - P(linearLayoutManager, orientationHelper);
    }

    private int N(@NonNull LinearLayoutManager linearLayoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        return orientationHelper.getDecoratedStart(view) - U(orientationHelper);
    }

    private int P(LinearLayoutManager linearLayoutManager, OrientationHelper orientationHelper) {
        int end;
        if (linearLayoutManager.getClipToPadding()) {
            end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            end = orientationHelper.getEnd() / 2;
        }
        return end + this.f384839o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int R(RecyclerView.LayoutManager layoutManager) {
        return (layoutManager.getItemCount() - this.f384833i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int T() {
        return this.f384834j;
    }

    private int U(OrientationHelper orientationHelper) {
        return orientationHelper.getStartAfterPadding() + this.f384839o;
    }

    private void V() {
        this.f384833i = 0;
        this.f384834j = 0;
        this.f384835k = -1;
        this.f384836l = false;
        this.f384837m = false;
        this.f384844t = false;
        this.f384843s = true;
        this.f384840p = true;
        this.f384841q = true;
    }

    private void h0() throws IllegalStateException {
        if (this.f384825a.getOnFlingListener() == null) {
            this.f384828d = new f();
            this.f384829e = new c();
            this.f384830f = new d();
            this.f384825a.setOnTouchListener(this.f384828d);
            this.f384825a.addOnScrollListener(this.f384828d);
            this.f384825a.setOnFlingListener(this.f384828d);
            this.f384825a.addOnLayoutChangeListener(this.f384829e);
            this.f384825a.addOnLayoutChangeListener(this.f384830f);
            this.f384825a.getAdapter().registerAdapterDataObserver(new C10045a());
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i0(@NonNull LinearLayoutManager linearLayoutManager, float f16, float f17, float f18, float f19, int i3) {
        View O;
        int position;
        if (linearLayoutManager.getItemCount() == 0 || (O = O(linearLayoutManager)) == null || (position = linearLayoutManager.getPosition(O)) == -1) {
            return false;
        }
        int A = A(position);
        int F = F();
        boolean z16 = true;
        if (!linearLayoutManager.canScrollHorizontally() ? Math.abs(f17) <= F ? f19 <= 0.0f : f17 <= 0.0f : Math.abs(f16) <= F ? f18 <= 0.0f : f16 <= 0.0f) {
            z16 = false;
        }
        if (i3 == -1 || A == i3) {
            if (z16) {
                A++;
            } else {
                A--;
            }
        }
        if (A == -1) {
            return false;
        }
        int A2 = A(A);
        if (QLog.isColorLevel()) {
            QLog.d("PagerSnapHelper", 2, "snapFromFling: position=" + A2);
        }
        return l0(A2);
    }

    public void B(@Nullable RecyclerViewCompat recyclerViewCompat) throws IllegalStateException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerViewCompat);
            return;
        }
        RecyclerViewCompat recyclerViewCompat2 = this.f384825a;
        if (recyclerViewCompat2 == recyclerViewCompat) {
            return;
        }
        if (recyclerViewCompat2 != null) {
            H();
        }
        this.f384825a = recyclerViewCompat;
        if (recyclerViewCompat != null) {
            E(recyclerViewCompat);
            this.f384826b = (LinearLayoutManager) this.f384825a.getLayoutManager();
            h0();
            j0();
        }
    }

    protected LinearSmoothScroller G(LinearLayoutManager linearLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (LinearSmoothScroller) iPatchRedirector.redirect((short) 25, (Object) this, (Object) linearLayoutManager);
        }
        return new b(this.f384825a.getContext(), linearLayoutManager);
    }

    @Nullable
    public View O(LinearLayoutManager linearLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this, (Object) linearLayoutManager);
        }
        int childCount = linearLayoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        OrientationHelper S = S(linearLayoutManager);
        int i3 = Integer.MAX_VALUE;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = linearLayoutManager.getChildAt(i16);
            int abs = Math.abs(L(linearLayoutManager, childAt, S));
            if (abs < i3) {
                view = childAt;
                i3 = abs;
            }
        }
        return view;
    }

    public int Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f384835k;
    }

    @NonNull
    protected OrientationHelper S(LinearLayoutManager linearLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (OrientationHelper) iPatchRedirector.redirect((short) 12, (Object) this, (Object) linearLayoutManager);
        }
        if (linearLayoutManager.canScrollVertically()) {
            if (this.f384831g == null) {
                this.f384831g = OrientationHelper.createOrientationHelper(linearLayoutManager, 1);
            }
            return this.f384831g;
        }
        if (this.f384832h == null) {
            this.f384832h = OrientationHelper.createOrientationHelper(linearLayoutManager, 0);
        }
        return this.f384832h;
    }

    public boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.f384836l;
    }

    public void X(int i3) {
        LinearLayoutManager linearLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else if (this.f384825a != null && (linearLayoutManager = this.f384826b) != null) {
            Y(linearLayoutManager.findViewByPosition(i3));
        }
    }

    public void Y(View view) {
        LinearLayoutManager linearLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
            return;
        }
        if (this.f384825a == null || (linearLayoutManager = this.f384826b) == null || view == null || D(linearLayoutManager.getPosition(view), this.f384826b)) {
            return;
        }
        int[] C = C(this.f384826b, view);
        int i3 = C[0];
        if (i3 != 0 || C[1] != 0) {
            this.f384825a.scrollBy(i3, C[1]);
        }
    }

    public void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f384825a.addOnLayoutChangeListener(this.f384829e);
        }
    }

    public void a0(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) eVar);
        } else {
            this.f384827c = eVar;
        }
    }

    public void b0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f384834j = i3;
        }
    }

    public void c0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.f384837m = z16;
        }
    }

    public void d0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f384833i = i3;
        }
    }

    public void e0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.f384839o = i3;
        }
    }

    public void f0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.f384841q = z16;
        }
    }

    public void g0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.f384840p = z16;
        }
    }

    public boolean j0() {
        LinearLayoutManager linearLayoutManager;
        View O;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f384825a == null || (linearLayoutManager = this.f384826b) == null || (O = O(linearLayoutManager)) == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PagerSnapHelper", 2, "snapToCenterPosition: findCenterView=" + this.f384826b.getPosition(O));
        }
        return m0(O);
    }

    public boolean k0() {
        LinearLayoutManager linearLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f384825a == null || (linearLayoutManager = this.f384826b) == null) {
            return false;
        }
        int i3 = this.f384835k + 1;
        if (D(i3, linearLayoutManager)) {
            return false;
        }
        l0(i3);
        return true;
    }

    public boolean l0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (D(i3, this.f384826b)) {
            return false;
        }
        View findViewByPosition = this.f384826b.findViewByPosition(i3);
        if (QLog.isColorLevel()) {
            QLog.d("PagerSnapHelper", 2, "snapToTargetPosition: position=" + i3 + ", view=" + findViewByPosition);
        }
        if (findViewByPosition == null) {
            this.f384825a.smoothScrollToPosition(i3);
            this.f384836l = true;
            return true;
        }
        int[] C = C(this.f384826b, findViewByPosition);
        int i16 = C[0];
        int i17 = C[1];
        if (i16 == 0 && i17 == 0) {
            return false;
        }
        LinearSmoothScroller G = G(this.f384826b);
        G.setTargetPosition(i3);
        this.f384826b.startSmoothScroll(G);
        this.f384836l = true;
        if (this.f384837m) {
            K(findViewByPosition, false);
        }
        if (i3 == R(this.f384826b) && (i16 < 0 || i17 < 0)) {
            I();
        } else if (i3 == T() && (i16 > 0 || i17 > 0)) {
            J();
        }
        return true;
    }

    public boolean m0(View view) {
        int position;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view)).booleanValue();
        }
        if (view == null || (position = this.f384826b.getPosition(view)) == -1) {
            return false;
        }
        return l0(A(position));
    }
}
