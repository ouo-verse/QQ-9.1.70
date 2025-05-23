package com.tencent.mobileqq.search.searchdetail.searchbox.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OverScrollRecyclerViewWithHeaderFooter extends RecyclerViewWithHeaderFooter {
    private List<i> C;
    private j D;
    private final j E;
    private final l F;
    private final i G;

    /* renamed from: i, reason: collision with root package name */
    private int f284637i;

    /* renamed from: m, reason: collision with root package name */
    private int f284638m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public enum ScrollState {
        NORMAL,
        OVER_SCROLL,
        BOUNCE_BACK
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements j {
        a() {
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.j
        public void a(ScrollState scrollState) {
            if (OverScrollRecyclerViewWithHeaderFooter.this.D != null) {
                OverScrollRecyclerViewWithHeaderFooter.this.D.a(scrollState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Property<View, Float> f284640a;

        /* renamed from: b, reason: collision with root package name */
        public float f284641b;

        /* renamed from: c, reason: collision with root package name */
        public float f284642c;

        protected b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a(d dVar);

        boolean handleMoveTouchEvent(MotionEvent motionEvent);

        boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        boolean a(View view, h hVar, MotionEvent motionEvent);

        void b(View view, b bVar);

        int getOrientation();

        boolean isInAbsoluteEnd(View view);

        boolean isInAbsoluteStart(View view);

        void setOrientation(int i3);

        void translateView(View view, float f16);

        void translateViewAndEvent(View view, float f16, MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class g implements e {

        /* renamed from: a, reason: collision with root package name */
        protected final l f284650a;

        /* renamed from: b, reason: collision with root package name */
        protected int f284651b = 1;

        public g(l lVar) {
            this.f284650a = lVar;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.e
        public boolean a(View view, h hVar, MotionEvent motionEvent) {
            boolean z16 = false;
            if (motionEvent.getHistorySize() == 0) {
                return false;
            }
            float y16 = motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0);
            float x16 = motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0);
            if (this.f284651b == 1) {
                if (Math.abs(y16) < Math.abs(x16)) {
                    return false;
                }
                hVar.f284652a = view.getTranslationY();
                hVar.f284653b = y16;
                if (y16 > 0.0f) {
                    z16 = true;
                }
                hVar.f284654c = z16;
            } else {
                if (Math.abs(x16) < Math.abs(y16)) {
                    return false;
                }
                hVar.f284652a = view.getTranslationX();
                hVar.f284653b = x16;
                if (x16 > 0.0f) {
                    z16 = true;
                }
                hVar.f284654c = z16;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.e
        public void b(View view, b bVar) {
            if (this.f284651b == 1) {
                bVar.f284640a = View.TRANSLATION_Y;
                bVar.f284641b = view.getTranslationY();
                bVar.f284642c = view.getHeight();
            } else {
                bVar.f284640a = View.TRANSLATION_X;
                bVar.f284641b = view.getTranslationX();
                bVar.f284642c = view.getWidth();
            }
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.e
        public int getOrientation() {
            return this.f284651b;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.e
        public boolean isInAbsoluteEnd(View view) {
            if (this.f284651b == 1) {
                return !view.canScrollVertically(1);
            }
            return !view.canScrollHorizontally(1);
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.e
        public boolean isInAbsoluteStart(View view) {
            if (this.f284651b == 1) {
                return !view.canScrollVertically(-1);
            }
            return !view.canScrollHorizontally(-1);
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.e
        public void setOrientation(int i3) {
            this.f284651b = i3;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.e
        public void translateView(View view, float f16) {
            float d16 = this.f284650a.d(f16);
            if (this.f284651b == 1) {
                view.setTranslationY(d16);
            } else {
                view.setTranslationX(d16);
            }
            this.f284650a.h((int) d16);
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.e
        public void translateViewAndEvent(View view, float f16, MotionEvent motionEvent) {
            float d16 = this.f284650a.d(f16);
            if (this.f284651b == 1) {
                view.setTranslationY(d16);
                motionEvent.offsetLocation(0.0f, d16 - motionEvent.getY(0));
            } else {
                view.setTranslationX(d16);
                motionEvent.offsetLocation(d16 - motionEvent.getX(0), 0.0f);
            }
            this.f284650a.h((int) d16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public float f284652a;

        /* renamed from: b, reason: collision with root package name */
        public float f284653b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f284654c;

        protected h() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface i {
        void a(RecyclerView recyclerView, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface j {
        void a(ScrollState scrollState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        protected int f284655a;

        /* renamed from: b, reason: collision with root package name */
        protected float f284656b;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f284657c;

        protected k() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class l implements View.OnTouchListener {
        protected f C;
        protected m D;
        protected c E;
        protected d F;
        private boolean I;
        private boolean J;
        private boolean K;
        protected int L;
        protected int M;
        protected int N;

        /* renamed from: d, reason: collision with root package name */
        protected final RecyclerView f284658d;

        /* renamed from: f, reason: collision with root package name */
        protected i f284660f;

        /* renamed from: h, reason: collision with root package name */
        protected j f284661h;

        /* renamed from: m, reason: collision with root package name */
        protected float f284663m;

        /* renamed from: e, reason: collision with root package name */
        protected e f284659e = new g(this);

        /* renamed from: i, reason: collision with root package name */
        protected final k f284662i = new k();
        private int G = -1;
        private int H = -1;

        public l(RecyclerView recyclerView) {
            this.f284658d = recyclerView;
        }

        public void c() {
            this.f284658d.setOnTouchListener(this);
            this.f284658d.setOverScrollMode(2);
        }

        public float d(float f16) {
            if (f16 < 0.0f) {
                if (this.G >= 0) {
                    return Math.max(f16, -r0);
                }
                return f16;
            }
            int i3 = this.H;
            if (i3 >= 0) {
                return Math.min(f16, i3);
            }
            return f16;
        }

        public RecyclerView e() {
            return this.f284658d;
        }

        public void f() {
            this.E = new c(this, -2.0f);
            this.D = new m(this, 3.0f, 1.0f);
            f fVar = new f(this);
            this.C = fVar;
            this.F = fVar;
            this.N = ViewConfiguration.get(this.f284658d.getContext()).getScaledTouchSlop();
            c();
        }

        protected void g(d dVar) {
            d dVar2 = this.F;
            this.F = dVar;
            dVar.a(dVar2);
            if (dVar instanceof f) {
                this.f284661h.a(ScrollState.NORMAL);
            } else if (dVar instanceof m) {
                this.f284661h.a(ScrollState.OVER_SCROLL);
            } else if (dVar instanceof c) {
                this.f284661h.a(ScrollState.BOUNCE_BACK);
            }
        }

        public void h(int i3) {
            if (this.f284660f != null) {
                if (this.f284659e.getOrientation() == 1) {
                    this.f284660f.a(this.f284658d, 0, i3);
                } else {
                    this.f284660f.a(this.f284658d, i3, 0);
                }
            }
        }

        public void i(int i3) {
            this.H = i3;
        }

        public void j(int i3) {
            this.G = i3;
        }

        public void k(i iVar) {
            this.f284660f = iVar;
        }

        public void l(j jVar) {
            this.f284661h = jVar;
        }

        public void m(RecyclerView.LayoutManager layoutManager) {
            if (layoutManager instanceof LinearLayoutManager) {
                this.f284659e.setOrientation(((LinearLayoutManager) layoutManager).getOrientation());
            } else {
                this.f284659e.setOrientation(1);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
        
            if (r3 != 3) goto L19;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.I) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        return this.F.handleMoveTouchEvent(motionEvent);
                    }
                }
                return this.F.handleUpOrCancelTouchEvent(motionEvent);
            }
            this.L = (int) (motionEvent.getX() + 0.5f);
            this.M = (int) (motionEvent.getY() + 0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class m implements d {

        /* renamed from: d, reason: collision with root package name */
        protected final l f284664d;

        /* renamed from: e, reason: collision with root package name */
        protected float f284665e;

        /* renamed from: f, reason: collision with root package name */
        protected float f284666f;

        /* renamed from: h, reason: collision with root package name */
        protected final h f284667h = new h();

        /* renamed from: i, reason: collision with root package name */
        protected int f284668i;

        public m(l lVar, float f16, float f17) {
            this.f284664d = lVar;
            this.f284665e = f16;
            this.f284666f = f17;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public void a(d dVar) {
            int i3;
            if (this.f284664d.f284662i.f284657c) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.f284668i = i3;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            float f16;
            k kVar = this.f284664d.f284662i;
            if (kVar.f284655a != motionEvent.getPointerId(0)) {
                l lVar = this.f284664d;
                lVar.g(lVar.E);
                return true;
            }
            RecyclerView e16 = this.f284664d.e();
            e eVar = this.f284664d.f284659e;
            if (!eVar.a(e16, this.f284667h, motionEvent)) {
                return true;
            }
            h hVar = this.f284667h;
            float f17 = hVar.f284653b;
            boolean z16 = hVar.f284654c;
            boolean z17 = kVar.f284657c;
            if (z16 == z17) {
                f16 = this.f284665e;
            } else {
                f16 = this.f284666f;
            }
            float f18 = f17 / f16;
            float f19 = hVar.f284652a + f18;
            if ((z17 && !z16 && f19 <= kVar.f284656b) || (!z17 && z16 && f19 >= kVar.f284656b)) {
                eVar.translateViewAndEvent(e16, kVar.f284656b, motionEvent);
                l lVar2 = this.f284664d;
                lVar2.g(lVar2.C);
                return true;
            }
            if (e16.getParent() != null) {
                e16.getParent().requestDisallowInterceptTouchEvent(true);
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
            if (eventTime > 0) {
                this.f284664d.f284663m = f18 / ((float) eventTime);
            }
            eVar.translateView(e16, f19);
            return true;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            l lVar = this.f284664d;
            lVar.g(lVar.E);
            return false;
        }
    }

    public OverScrollRecyclerViewWithHeaderFooter(Context context) {
        super(context);
        this.E = new a();
        this.F = new l(this);
        this.G = new i() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.views.a
            @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.i
            public final void a(RecyclerView recyclerView, int i3, int i16) {
                OverScrollRecyclerViewWithHeaderFooter.this.F(recyclerView, i3, i16);
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(RecyclerView recyclerView, int i3, int i16) {
        this.f284637i = i3;
        this.f284638m = i16;
        List<i> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).a(recyclerView, i3, i16);
            }
        }
    }

    private void init() {
        this.F.f();
        this.F.k(this.G);
        this.F.l(this.E);
    }

    public void E(i iVar) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (QLog.isDebugVersion()) {
            super.onLayout(z16, i3, i16, i17, i18);
            return;
        }
        try {
            super.onLayout(z16, i3, i16, i17, i18);
        } catch (IllegalArgumentException | IllegalStateException | NullPointerException e16) {
            QLog.e("OverScrollRecyclerViewWithHeaderFooter", 1, "onLayout", e16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.F.m(layoutManager);
    }

    public void setMaxBottomOverScrollDis(int i3) {
        this.F.i(i3);
    }

    public void setMaxTopOverScrollDis(int i3) {
        this.F.j(i3);
    }

    public void setOnScrollStateListener(j jVar) {
        this.D = jVar;
    }

    public void setTouchDragRatio(float f16, float f17) {
        m mVar = this.F.D;
        if (mVar != null) {
            mVar.f284665e = f16;
            mVar.f284666f = f17;
        }
    }

    public OverScrollRecyclerViewWithHeaderFooter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = new a();
        this.F = new l(this);
        this.G = new i() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.views.a
            @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.i
            public final void a(RecyclerView recyclerView, int i3, int i16) {
                OverScrollRecyclerViewWithHeaderFooter.this.F(recyclerView, i3, i16);
            }
        };
        init();
    }

    public OverScrollRecyclerViewWithHeaderFooter(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = new a();
        this.F = new l(this);
        this.G = new i() { // from class: com.tencent.mobileqq.search.searchdetail.searchbox.views.a
            @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.i
            public final void a(RecyclerView recyclerView, int i36, int i16) {
                OverScrollRecyclerViewWithHeaderFooter.this.F(recyclerView, i36, i16);
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c extends com.tencent.mobileqq.widget.f implements d, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        protected final l f284643d;

        /* renamed from: f, reason: collision with root package name */
        protected final float f284645f;

        /* renamed from: h, reason: collision with root package name */
        protected final float f284646h;

        /* renamed from: e, reason: collision with root package name */
        protected final Interpolator f284644e = new DecelerateInterpolator();

        /* renamed from: i, reason: collision with root package name */
        protected final b f284647i = new b();

        public c(l lVar, float f16) {
            this.f284643d = lVar;
            this.f284645f = f16;
            this.f284646h = f16 * 2.0f;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public void a(d dVar) {
            Animator e16 = e();
            e16.addListener(this);
            e16.start();
        }

        protected Animator e() {
            RecyclerView e16 = this.f284643d.e();
            l lVar = this.f284643d;
            e eVar = lVar.f284659e;
            k kVar = lVar.f284662i;
            float f16 = lVar.f284663m;
            eVar.b(e16, this.f284647i);
            float f17 = 0.0f;
            if (f16 != 0.0f && ((f16 >= 0.0f || !kVar.f284657c) && (f16 <= 0.0f || kVar.f284657c))) {
                float f18 = -f16;
                float f19 = f18 / this.f284645f;
                if (f19 >= 0.0f) {
                    f17 = f19;
                }
                float d16 = this.f284643d.d(this.f284647i.f284641b + ((f18 * f16) / this.f284646h));
                ObjectAnimator g16 = g(e16, (int) f17, d16);
                ObjectAnimator f26 = f(d16);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(g16, f26);
                return animatorSet;
            }
            return f(this.f284647i.f284641b);
        }

        protected ObjectAnimator f(float f16) {
            RecyclerView e16 = this.f284643d.e();
            k kVar = this.f284643d.f284662i;
            float abs = Math.abs(f16);
            b bVar = this.f284647i;
            float f17 = (abs / bVar.f284642c) * 800.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(e16, (Property<RecyclerView, Float>) bVar.f284640a, kVar.f284656b);
            ofFloat.setDuration(Math.max((int) f17, 200));
            ofFloat.setInterpolator(this.f284644e);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        protected ObjectAnimator g(View view, int i3, float f16) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f284647i.f284640a, f16);
            ofFloat.setDuration(i3);
            ofFloat.setInterpolator(this.f284644e);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l lVar = this.f284643d;
            lVar.g(lVar.C);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                this.f284643d.h((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class f implements d {

        /* renamed from: d, reason: collision with root package name */
        protected final l f284648d;

        /* renamed from: e, reason: collision with root package name */
        protected final h f284649e = new h();

        public f(l lVar) {
            this.f284648d = lVar;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            int x16;
            int i3;
            RecyclerView e16 = this.f284648d.e();
            e eVar = this.f284648d.f284659e;
            if (!eVar.a(e16, this.f284649e, motionEvent)) {
                return false;
            }
            k kVar = this.f284648d.f284662i;
            if ((eVar.isInAbsoluteStart(e16) && this.f284649e.f284654c && !this.f284648d.J) || (eVar.isInAbsoluteEnd(e16) && !this.f284649e.f284654c && !this.f284648d.K)) {
                kVar.f284655a = motionEvent.getPointerId(0);
                h hVar = this.f284649e;
                kVar.f284656b = hVar.f284652a;
                kVar.f284657c = hVar.f284654c;
                if (eVar.getOrientation() == 1) {
                    x16 = (int) (motionEvent.getY() + 0.5f);
                    i3 = this.f284648d.M;
                } else {
                    x16 = (int) (motionEvent.getX() + 0.5f);
                    i3 = this.f284648d.L;
                }
                int abs = Math.abs(x16 - i3);
                l lVar = this.f284648d;
                if (abs > lVar.N) {
                    lVar.g(lVar.D);
                    return this.f284648d.D.handleMoveTouchEvent(motionEvent);
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.searchbox.views.OverScrollRecyclerViewWithHeaderFooter.d
        public void a(d dVar) {
        }
    }
}
