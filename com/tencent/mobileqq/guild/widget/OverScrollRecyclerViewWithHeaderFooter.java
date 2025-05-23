package com.tencent.mobileqq.guild.widget;

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
/* loaded from: classes14.dex */
public class OverScrollRecyclerViewWithHeaderFooter extends RecyclerViewWithHeaderFooter {
    private List<i> C;
    private j D;
    private final j E;
    private final l F;
    private kv1.a G;
    private final i H;

    /* renamed from: i, reason: collision with root package name */
    private int f236082i;

    /* renamed from: m, reason: collision with root package name */
    private int f236083m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public enum ScrollState {
        NORMAL,
        OVER_SCROLL,
        BOUNCE_BACK
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements j {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.j
        public void a(ScrollState scrollState) {
            if (OverScrollRecyclerViewWithHeaderFooter.this.D != null) {
                OverScrollRecyclerViewWithHeaderFooter.this.D.a(scrollState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Property<View, Float> f236085a;

        /* renamed from: b, reason: collision with root package name */
        public float f236086b;

        /* renamed from: c, reason: collision with root package name */
        public float f236087c;

        protected b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void b(d dVar);

        boolean handleMoveTouchEvent(MotionEvent motionEvent);

        boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
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
    /* loaded from: classes14.dex */
    public static class g implements e {

        /* renamed from: a, reason: collision with root package name */
        protected final l f236095a;

        /* renamed from: b, reason: collision with root package name */
        protected int f236096b = 1;

        public g(l lVar) {
            this.f236095a = lVar;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.e
        public boolean a(View view, h hVar, MotionEvent motionEvent) {
            boolean z16 = false;
            if (motionEvent.getHistorySize() == 0) {
                return false;
            }
            float y16 = motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0);
            float x16 = motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0);
            if (this.f236096b == 1) {
                if (Math.abs(y16) < Math.abs(x16)) {
                    return false;
                }
                hVar.f236097a = view.getTranslationY();
                hVar.f236098b = y16;
                if (y16 > 0.0f) {
                    z16 = true;
                }
                hVar.f236099c = z16;
            } else {
                if (Math.abs(x16) < Math.abs(y16)) {
                    return false;
                }
                hVar.f236097a = view.getTranslationX();
                hVar.f236098b = x16;
                if (x16 > 0.0f) {
                    z16 = true;
                }
                hVar.f236099c = z16;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.e
        public void b(View view, b bVar) {
            if (this.f236096b == 1) {
                bVar.f236085a = View.TRANSLATION_Y;
                bVar.f236086b = view.getTranslationY();
                bVar.f236087c = view.getHeight();
            } else {
                bVar.f236085a = View.TRANSLATION_X;
                bVar.f236086b = view.getTranslationX();
                bVar.f236087c = view.getWidth();
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.e
        public int getOrientation() {
            return this.f236096b;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.e
        public boolean isInAbsoluteEnd(View view) {
            if (this.f236096b == 1) {
                return !view.canScrollVertically(1);
            }
            return !view.canScrollHorizontally(1);
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.e
        public boolean isInAbsoluteStart(View view) {
            if (this.f236096b == 1) {
                return !view.canScrollVertically(-1);
            }
            return !view.canScrollHorizontally(-1);
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.e
        public void setOrientation(int i3) {
            this.f236096b = i3;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.e
        public void translateView(View view, float f16) {
            float g16 = this.f236095a.g(f16);
            if (this.f236096b == 1) {
                view.setTranslationY(g16);
            } else {
                view.setTranslationX(g16);
            }
            this.f236095a.k((int) g16);
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.e
        public void translateViewAndEvent(View view, float f16, MotionEvent motionEvent) {
            float g16 = this.f236095a.g(f16);
            if (this.f236096b == 1) {
                view.setTranslationY(g16);
                motionEvent.offsetLocation(0.0f, g16 - motionEvent.getY(0));
            } else {
                view.setTranslationX(g16);
                motionEvent.offsetLocation(g16 - motionEvent.getX(0), 0.0f);
            }
            this.f236095a.k((int) g16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public float f236097a;

        /* renamed from: b, reason: collision with root package name */
        public float f236098b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f236099c;

        protected h() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface i {
        void a(RecyclerView recyclerView, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface j {
        void a(ScrollState scrollState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        protected int f236100a;

        /* renamed from: b, reason: collision with root package name */
        protected float f236101b;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f236102c;

        protected k() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
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
        protected final RecyclerView f236103d;

        /* renamed from: f, reason: collision with root package name */
        protected i f236105f;

        /* renamed from: h, reason: collision with root package name */
        protected j f236106h;

        /* renamed from: m, reason: collision with root package name */
        protected float f236108m;

        /* renamed from: e, reason: collision with root package name */
        protected e f236104e = new g(this);

        /* renamed from: i, reason: collision with root package name */
        protected final k f236107i = new k();
        private int G = -1;
        private int H = -1;

        public l(RecyclerView recyclerView) {
            this.f236103d = recyclerView;
        }

        public void c() {
            this.f236103d.setOnTouchListener(this);
            this.f236103d.setOverScrollMode(2);
        }

        public void d() {
            this.f236103d.setOnTouchListener(null);
            this.f236103d.setOverScrollMode(0);
        }

        public void e(boolean z16) {
            this.J = z16;
        }

        public void f(boolean z16) {
            this.K = z16;
        }

        public float g(float f16) {
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

        public RecyclerView h() {
            return this.f236103d;
        }

        public void i() {
            this.E = new c(this, -2.0f);
            this.D = new m(this, 3.0f, 1.0f);
            f fVar = new f(this);
            this.C = fVar;
            this.F = fVar;
            this.N = ViewConfiguration.get(this.f236103d.getContext()).getScaledTouchSlop();
            c();
        }

        protected void j(d dVar) {
            d dVar2 = this.F;
            this.F = dVar;
            dVar.b(dVar2);
            if (dVar instanceof f) {
                this.f236106h.a(ScrollState.NORMAL);
            } else if (dVar instanceof m) {
                this.f236106h.a(ScrollState.OVER_SCROLL);
            } else if (dVar instanceof c) {
                this.f236106h.a(ScrollState.BOUNCE_BACK);
            }
        }

        public void k(int i3) {
            if (this.f236105f != null) {
                if (this.f236104e.getOrientation() == 1) {
                    this.f236105f.a(this.f236103d, 0, i3);
                } else {
                    this.f236105f.a(this.f236103d, i3, 0);
                }
            }
        }

        public void l(int i3) {
            this.H = i3;
        }

        public void m(int i3) {
            this.G = i3;
        }

        public void n(i iVar) {
            this.f236105f = iVar;
        }

        public void o(j jVar) {
            this.f236106h = jVar;
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

        public void p(RecyclerView.LayoutManager layoutManager) {
            if (layoutManager instanceof LinearLayoutManager) {
                this.f236104e.setOrientation(((LinearLayoutManager) layoutManager).getOrientation());
            } else {
                this.f236104e.setOrientation(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class m implements d {

        /* renamed from: d, reason: collision with root package name */
        protected final l f236109d;

        /* renamed from: e, reason: collision with root package name */
        protected float f236110e;

        /* renamed from: f, reason: collision with root package name */
        protected float f236111f;

        /* renamed from: h, reason: collision with root package name */
        protected final h f236112h = new h();

        /* renamed from: i, reason: collision with root package name */
        protected int f236113i;

        public m(l lVar, float f16, float f17) {
            this.f236109d = lVar;
            this.f236110e = f16;
            this.f236111f = f17;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public void b(d dVar) {
            int i3;
            if (this.f236109d.f236107i.f236102c) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.f236113i = i3;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            float f16;
            k kVar = this.f236109d.f236107i;
            if (kVar.f236100a != motionEvent.getPointerId(0)) {
                l lVar = this.f236109d;
                lVar.j(lVar.E);
                return true;
            }
            RecyclerView h16 = this.f236109d.h();
            e eVar = this.f236109d.f236104e;
            if (!eVar.a(h16, this.f236112h, motionEvent)) {
                return true;
            }
            h hVar = this.f236112h;
            float f17 = hVar.f236098b;
            boolean z16 = hVar.f236099c;
            boolean z17 = kVar.f236102c;
            if (z16 == z17) {
                f16 = this.f236110e;
            } else {
                f16 = this.f236111f;
            }
            float f18 = f17 / f16;
            float f19 = hVar.f236097a + f18;
            if ((z17 && !z16 && f19 <= kVar.f236101b) || (!z17 && z16 && f19 >= kVar.f236101b)) {
                eVar.translateViewAndEvent(h16, kVar.f236101b, motionEvent);
                l lVar2 = this.f236109d;
                lVar2.j(lVar2.C);
                return true;
            }
            if (h16.getParent() != null) {
                h16.getParent().requestDisallowInterceptTouchEvent(true);
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
            if (eventTime > 0) {
                this.f236109d.f236108m = f18 / ((float) eventTime);
            }
            eVar.translateView(h16, f19);
            return true;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            l lVar = this.f236109d;
            lVar.j(lVar.E);
            return false;
        }
    }

    public OverScrollRecyclerViewWithHeaderFooter(Context context) {
        super(context);
        this.E = new a();
        this.F = new l(this);
        this.H = new i() { // from class: com.tencent.mobileqq.guild.widget.w
            @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.i
            public final void a(RecyclerView recyclerView, int i3, int i16) {
                OverScrollRecyclerViewWithHeaderFooter.this.L(recyclerView, i3, i16);
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(RecyclerView recyclerView, int i3, int i16) {
        this.f236082i = i3;
        this.f236083m = i16;
        List<i> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).a(recyclerView, i3, i16);
            }
        }
    }

    private void init() {
        this.F.i();
        this.F.n(this.H);
        this.F.o(this.E);
    }

    public void G(i iVar) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        this.C.add(iVar);
    }

    public void H() {
        setItemAnimator(null);
    }

    public void I(boolean z16) {
        this.F.e(z16);
    }

    public void K(boolean z16) {
        this.F.f(z16);
    }

    public void M() {
        this.F.d();
    }

    public void O() {
        this.G = null;
    }

    public void P() {
        this.F.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        kv1.a aVar = this.G;
        if (aVar != null) {
            aVar.a();
        }
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

    public void setDrawListener(kv1.a aVar) {
        this.G = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.F.p(layoutManager);
    }

    public void setMaxBottomOverScrollDis(int i3) {
        this.F.l(i3);
    }

    public void setMaxTopOverScrollDis(int i3) {
        this.F.m(i3);
    }

    public void setOnScrollStateListener(j jVar) {
        this.D = jVar;
    }

    public void setTouchDragRatio(float f16, float f17) {
        m mVar = this.F.D;
        if (mVar != null) {
            mVar.f236110e = f16;
            mVar.f236111f = f17;
        }
    }

    public OverScrollRecyclerViewWithHeaderFooter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = new a();
        this.F = new l(this);
        this.H = new i() { // from class: com.tencent.mobileqq.guild.widget.w
            @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.i
            public final void a(RecyclerView recyclerView, int i3, int i16) {
                OverScrollRecyclerViewWithHeaderFooter.this.L(recyclerView, i3, i16);
            }
        };
        init();
    }

    public OverScrollRecyclerViewWithHeaderFooter(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = new a();
        this.F = new l(this);
        this.H = new i() { // from class: com.tencent.mobileqq.guild.widget.w
            @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.i
            public final void a(RecyclerView recyclerView, int i36, int i16) {
                OverScrollRecyclerViewWithHeaderFooter.this.L(recyclerView, i36, i16);
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c extends com.tencent.mobileqq.widget.f implements d, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        protected final l f236088d;

        /* renamed from: f, reason: collision with root package name */
        protected final float f236090f;

        /* renamed from: h, reason: collision with root package name */
        protected final float f236091h;

        /* renamed from: e, reason: collision with root package name */
        protected final Interpolator f236089e = new DecelerateInterpolator();

        /* renamed from: i, reason: collision with root package name */
        protected final b f236092i = new b();

        public c(l lVar, float f16) {
            this.f236088d = lVar;
            this.f236090f = f16;
            this.f236091h = f16 * 2.0f;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public void b(d dVar) {
            Animator e16 = e();
            e16.addListener(this);
            e16.start();
        }

        protected Animator e() {
            RecyclerView h16 = this.f236088d.h();
            l lVar = this.f236088d;
            e eVar = lVar.f236104e;
            k kVar = lVar.f236107i;
            float f16 = lVar.f236108m;
            eVar.b(h16, this.f236092i);
            float f17 = 0.0f;
            if (f16 != 0.0f && ((f16 >= 0.0f || !kVar.f236102c) && (f16 <= 0.0f || kVar.f236102c))) {
                float f18 = -f16;
                float f19 = f18 / this.f236090f;
                if (f19 >= 0.0f) {
                    f17 = f19;
                }
                float g16 = this.f236088d.g(this.f236092i.f236086b + ((f18 * f16) / this.f236091h));
                ObjectAnimator g17 = g(h16, (int) f17, g16);
                ObjectAnimator f26 = f(g16);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(g17, f26);
                return animatorSet;
            }
            return f(this.f236092i.f236086b);
        }

        protected ObjectAnimator f(float f16) {
            RecyclerView h16 = this.f236088d.h();
            k kVar = this.f236088d.f236107i;
            float abs = Math.abs(f16);
            b bVar = this.f236092i;
            float f17 = (abs / bVar.f236087c) * 800.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(h16, (Property<RecyclerView, Float>) bVar.f236085a, kVar.f236101b);
            ofFloat.setDuration(Math.max((int) f17, 200));
            ofFloat.setInterpolator(this.f236089e);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        protected ObjectAnimator g(View view, int i3, float f16) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f236092i.f236085a, f16);
            ofFloat.setDuration(i3);
            ofFloat.setInterpolator(this.f236089e);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            l lVar = this.f236088d;
            lVar.j(lVar.C);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                this.f236088d.k((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
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
    /* loaded from: classes14.dex */
    public static class f implements d {

        /* renamed from: d, reason: collision with root package name */
        protected final l f236093d;

        /* renamed from: e, reason: collision with root package name */
        protected final h f236094e = new h();

        public f(l lVar) {
            this.f236093d = lVar;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            int x16;
            int i3;
            RecyclerView h16 = this.f236093d.h();
            e eVar = this.f236093d.f236104e;
            if (!eVar.a(h16, this.f236094e, motionEvent)) {
                return false;
            }
            k kVar = this.f236093d.f236107i;
            if ((eVar.isInAbsoluteStart(h16) && this.f236094e.f236099c && !this.f236093d.J) || (eVar.isInAbsoluteEnd(h16) && !this.f236094e.f236099c && !this.f236093d.K)) {
                kVar.f236100a = motionEvent.getPointerId(0);
                h hVar = this.f236094e;
                kVar.f236101b = hVar.f236097a;
                kVar.f236102c = hVar.f236099c;
                if (eVar.getOrientation() == 1) {
                    x16 = (int) (motionEvent.getY() + 0.5f);
                    i3 = this.f236093d.M;
                } else {
                    x16 = (int) (motionEvent.getX() + 0.5f);
                    i3 = this.f236093d.L;
                }
                int abs = Math.abs(x16 - i3);
                l lVar = this.f236093d;
                if (abs > lVar.N) {
                    lVar.j(lVar.D);
                    return this.f236093d.D.handleMoveTouchEvent(motionEvent);
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter.d
        public void b(d dVar) {
        }
    }
}
