package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class OverScrollRecyclerView extends RecyclerView {

    /* renamed from: d, reason: collision with root package name */
    protected final i f315913d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Property<View, Float> f315914a;

        /* renamed from: b, reason: collision with root package name */
        public float f315915b;

        /* renamed from: c, reason: collision with root package name */
        public float f315916c;

        protected a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void d(c cVar);

        boolean handleMoveTouchEvent(MotionEvent motionEvent);

        boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void a(View view, a aVar);

        boolean b(View view, g gVar, MotionEvent motionEvent);

        boolean isInAbsoluteEnd(View view);

        boolean isInAbsoluteStart(View view);

        void setOrientation(int i3);

        void translateView(View view, float f16);

        void translateViewAndEvent(View view, float f16, MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class f implements d {

        /* renamed from: a, reason: collision with root package name */
        protected int f315924a = 1;

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public void a(View view, a aVar) {
            if (this.f315924a == 1) {
                aVar.f315914a = View.TRANSLATION_Y;
                aVar.f315915b = view.getTranslationY();
                aVar.f315916c = view.getHeight();
            } else {
                aVar.f315914a = View.TRANSLATION_X;
                aVar.f315915b = view.getTranslationX();
                aVar.f315916c = view.getWidth();
            }
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public boolean b(View view, g gVar, MotionEvent motionEvent) {
            boolean z16 = false;
            if (motionEvent.getHistorySize() == 0) {
                return false;
            }
            float y16 = motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0);
            float x16 = motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0);
            if (this.f315924a == 1) {
                if (Math.abs(y16) < Math.abs(x16)) {
                    return false;
                }
                gVar.f315925a = view.getTranslationY();
                gVar.f315926b = y16;
                if (y16 > 0.0f) {
                    z16 = true;
                }
                gVar.f315927c = z16;
            } else {
                if (Math.abs(x16) < Math.abs(y16)) {
                    return false;
                }
                gVar.f315925a = view.getTranslationX();
                gVar.f315926b = x16;
                if (x16 > 0.0f) {
                    z16 = true;
                }
                gVar.f315927c = z16;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public boolean isInAbsoluteEnd(View view) {
            if (this.f315924a == 1) {
                return !view.canScrollVertically(1);
            }
            return !view.canScrollHorizontally(1);
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public boolean isInAbsoluteStart(View view) {
            if (this.f315924a == 1) {
                return !view.canScrollVertically(-1);
            }
            return !view.canScrollHorizontally(-1);
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public void setOrientation(int i3) {
            this.f315924a = i3;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public void translateView(View view, float f16) {
            if (this.f315924a == 1) {
                view.setTranslationY(f16);
            } else {
                view.setTranslationX(f16);
            }
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.d
        public void translateViewAndEvent(View view, float f16, MotionEvent motionEvent) {
            if (this.f315924a == 1) {
                view.setTranslationY(f16);
                motionEvent.offsetLocation(0.0f, f16 - motionEvent.getY(0));
            } else {
                view.setTranslationX(f16);
                motionEvent.offsetLocation(f16 - motionEvent.getX(0), 0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public float f315925a;

        /* renamed from: b, reason: collision with root package name */
        public float f315926b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f315927c;

        protected g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        protected int f315928a;

        /* renamed from: b, reason: collision with root package name */
        protected float f315929b;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f315930c;

        protected h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class i implements View.OnTouchListener {
        protected b C;
        protected c D;

        /* renamed from: d, reason: collision with root package name */
        protected final RecyclerView f315931d;

        /* renamed from: e, reason: collision with root package name */
        protected d f315932e = new f();

        /* renamed from: f, reason: collision with root package name */
        protected final h f315933f = new h();

        /* renamed from: h, reason: collision with root package name */
        protected float f315934h;

        /* renamed from: i, reason: collision with root package name */
        protected e f315935i;

        /* renamed from: m, reason: collision with root package name */
        protected j f315936m;

        public i(RecyclerView recyclerView) {
            this.f315931d = recyclerView;
        }

        public void a() {
            this.f315931d.setOnTouchListener(this);
            this.f315931d.setOverScrollMode(2);
        }

        public void b() {
            this.f315931d.setOnTouchListener(null);
            this.f315931d.setOverScrollMode(0);
        }

        public View c() {
            return this.f315931d;
        }

        public void d() {
            this.C = new b(this, -2.0f);
            this.f315936m = new j(this, 3.0f, 1.0f);
            e eVar = new e(this);
            this.f315935i = eVar;
            this.D = eVar;
            a();
        }

        protected void e(c cVar) {
            c cVar2 = this.D;
            this.D = cVar;
            cVar.d(cVar2);
        }

        public void f(RecyclerView.LayoutManager layoutManager) {
            if (layoutManager instanceof LinearLayoutManager) {
                this.f315932e.setOrientation(((LinearLayoutManager) layoutManager).getOrientation());
            } else {
                this.f315932e.setOrientation(1);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    return this.D.handleMoveTouchEvent(motionEvent);
                }
            }
            return this.D.handleUpOrCancelTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class j implements c {

        /* renamed from: d, reason: collision with root package name */
        protected final i f315937d;

        /* renamed from: e, reason: collision with root package name */
        protected float f315938e;

        /* renamed from: f, reason: collision with root package name */
        protected float f315939f;

        /* renamed from: h, reason: collision with root package name */
        protected final g f315940h = new g();

        /* renamed from: i, reason: collision with root package name */
        protected int f315941i;

        public j(i iVar, float f16, float f17) {
            this.f315937d = iVar;
            this.f315938e = f16;
            this.f315939f = f17;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public void d(c cVar) {
            int i3;
            if (this.f315937d.f315933f.f315930c) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.f315941i = i3;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            float f16;
            h hVar = this.f315937d.f315933f;
            if (hVar.f315928a != motionEvent.getPointerId(0)) {
                i iVar = this.f315937d;
                iVar.e(iVar.C);
                return true;
            }
            View c16 = this.f315937d.c();
            d dVar = this.f315937d.f315932e;
            if (!dVar.b(c16, this.f315940h, motionEvent)) {
                return true;
            }
            g gVar = this.f315940h;
            float f17 = gVar.f315926b;
            boolean z16 = gVar.f315927c;
            boolean z17 = hVar.f315930c;
            if (z16 == z17) {
                f16 = this.f315938e;
            } else {
                f16 = this.f315939f;
            }
            float f18 = f17 / f16;
            float f19 = gVar.f315925a + f18;
            if ((z17 && !z16 && f19 <= hVar.f315929b) || (!z17 && z16 && f19 >= hVar.f315929b)) {
                dVar.translateViewAndEvent(c16, hVar.f315929b, motionEvent);
                i iVar2 = this.f315937d;
                iVar2.e(iVar2.f315935i);
                return true;
            }
            if (c16.getParent() != null) {
                c16.getParent().requestDisallowInterceptTouchEvent(true);
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
            if (eventTime > 0) {
                this.f315937d.f315934h = f18 / ((float) eventTime);
            }
            dVar.translateView(c16, f19);
            return true;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            i iVar = this.f315937d;
            iVar.e(iVar.C);
            return false;
        }
    }

    public OverScrollRecyclerView(Context context) {
        super(context);
        this.f315913d = new i(this);
        c();
    }

    private void c() {
        this.f315913d.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f315913d.b();
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.f315913d.f(layoutManager);
    }

    public void setTouchDragRatio(float f16, float f17) {
        j jVar = this.f315913d.f315936m;
        if (jVar != null) {
            jVar.f315938e = f16;
            jVar.f315939f = f17;
        }
    }

    public OverScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315913d = new i(this);
        c();
    }

    public OverScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315913d = new i(this);
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends com.tencent.mobileqq.widget.f implements c, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        protected final i f315917d;

        /* renamed from: f, reason: collision with root package name */
        protected final float f315919f;

        /* renamed from: h, reason: collision with root package name */
        protected final float f315920h;

        /* renamed from: e, reason: collision with root package name */
        protected final Interpolator f315918e = new DecelerateInterpolator();

        /* renamed from: i, reason: collision with root package name */
        protected final a f315921i = new a();

        public b(i iVar, float f16) {
            this.f315917d = iVar;
            this.f315919f = f16;
            this.f315920h = f16 * 2.0f;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public void d(c cVar) {
            Animator e16 = e();
            e16.addListener(this);
            e16.start();
        }

        protected Animator e() {
            View c16 = this.f315917d.c();
            i iVar = this.f315917d;
            d dVar = iVar.f315932e;
            h hVar = iVar.f315933f;
            float f16 = iVar.f315934h;
            dVar.a(c16, this.f315921i);
            float f17 = 0.0f;
            if (f16 != 0.0f && ((f16 >= 0.0f || !hVar.f315930c) && (f16 <= 0.0f || hVar.f315930c))) {
                float f18 = -f16;
                float f19 = f18 / this.f315919f;
                if (f19 >= 0.0f) {
                    f17 = f19;
                }
                float f26 = this.f315921i.f315915b + ((f18 * f16) / this.f315920h);
                ObjectAnimator g16 = g(c16, (int) f17, f26);
                ObjectAnimator f27 = f(f26);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(g16, f27);
                return animatorSet;
            }
            return f(this.f315921i.f315915b);
        }

        protected ObjectAnimator f(float f16) {
            View c16 = this.f315917d.c();
            h hVar = this.f315917d.f315933f;
            float abs = Math.abs(f16);
            a aVar = this.f315921i;
            float f17 = (abs / aVar.f315916c) * 800.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c16, aVar.f315914a, hVar.f315929b);
            ofFloat.setDuration(Math.max((int) f17, 200));
            ofFloat.setInterpolator(this.f315918e);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        protected ObjectAnimator g(View view, int i3, float f16) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f315921i.f315914a, f16);
            ofFloat.setDuration(i3);
            ofFloat.setInterpolator(this.f315918e);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i iVar = this.f315917d;
            iVar.e(iVar.f315935i);
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

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e implements c {

        /* renamed from: d, reason: collision with root package name */
        protected final i f315922d;

        /* renamed from: e, reason: collision with root package name */
        protected final g f315923e = new g();

        public e(i iVar) {
            this.f315922d = iVar;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            View c16 = this.f315922d.c();
            d dVar = this.f315922d.f315932e;
            if (!dVar.b(c16, this.f315923e, motionEvent)) {
                return false;
            }
            h hVar = this.f315922d.f315933f;
            if ((!dVar.isInAbsoluteStart(c16) || !this.f315923e.f315927c) && (!dVar.isInAbsoluteEnd(c16) || this.f315923e.f315927c)) {
                return false;
            }
            hVar.f315928a = motionEvent.getPointerId(0);
            g gVar = this.f315923e;
            hVar.f315929b = gVar.f315925a;
            hVar.f315930c = gVar.f315927c;
            i iVar = this.f315922d;
            iVar.e(iVar.f315936m);
            return this.f315922d.f315936m.handleMoveTouchEvent(motionEvent);
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.OverScrollRecyclerView.c
        public void d(c cVar) {
        }
    }
}
