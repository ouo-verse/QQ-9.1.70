package com.tencent.mobileqq.guild.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class OverScrollRecyclerView extends RecyclerView {
    private final OnOverScrollListener C;

    /* renamed from: f, reason: collision with root package name */
    protected final j f236048f;

    /* renamed from: h, reason: collision with root package name */
    private List<OnOverScrollListener> f236049h;

    /* renamed from: i, reason: collision with root package name */
    private int f236050i;

    /* renamed from: m, reason: collision with root package name */
    private int f236051m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface OnOverScrollListener {

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes14.dex */
        public @interface ScrollState {
        }

        void a(RecyclerView recyclerView, int i3, int i16);

        void b(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements OnOverScrollListener {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.OnOverScrollListener
        public void a(RecyclerView recyclerView, int i3, int i16) {
            OverScrollRecyclerView.this.f236050i = i3;
            OverScrollRecyclerView.this.f236051m = i16;
            if (OverScrollRecyclerView.this.f236049h != null) {
                for (int size = OverScrollRecyclerView.this.f236049h.size() - 1; size >= 0; size--) {
                    ((OnOverScrollListener) OverScrollRecyclerView.this.f236049h.get(size)).a(recyclerView, i3, i16);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.OnOverScrollListener
        public void b(int i3) {
            if (OverScrollRecyclerView.this.f236049h != null) {
                for (int size = OverScrollRecyclerView.this.f236049h.size() - 1; size >= 0; size--) {
                    ((OnOverScrollListener) OverScrollRecyclerView.this.f236049h.get(size)).b(i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Property<View, Float> f236053a;

        /* renamed from: b, reason: collision with root package name */
        public float f236054b;

        /* renamed from: c, reason: collision with root package name */
        public float f236055c;

        protected b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void c(d dVar);

        boolean handleMoveTouchEvent(MotionEvent motionEvent);

        boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface e {
        void a(View view, b bVar);

        boolean b(View view, h hVar, MotionEvent motionEvent);

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
        private final j f236063a;

        /* renamed from: b, reason: collision with root package name */
        protected int f236064b = 1;

        g(j jVar) {
            this.f236063a = jVar;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.e
        public void a(View view, b bVar) {
            if (this.f236064b == 1) {
                bVar.f236053a = View.TRANSLATION_Y;
                bVar.f236054b = view.getTranslationY();
                bVar.f236055c = view.getHeight();
            } else {
                bVar.f236053a = View.TRANSLATION_X;
                bVar.f236054b = view.getTranslationX();
                bVar.f236055c = view.getWidth();
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.e
        public boolean b(View view, h hVar, MotionEvent motionEvent) {
            boolean z16 = false;
            if (motionEvent.getHistorySize() == 0) {
                return false;
            }
            float y16 = motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0);
            float x16 = motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0);
            if (this.f236064b == 1) {
                if (Math.abs(y16) < Math.abs(x16)) {
                    return false;
                }
                hVar.f236065a = view.getTranslationY();
                hVar.f236066b = y16;
                if (y16 > 0.0f) {
                    z16 = true;
                }
                hVar.f236067c = z16;
            } else {
                if (Math.abs(x16) < Math.abs(y16)) {
                    return false;
                }
                hVar.f236065a = view.getTranslationX();
                hVar.f236066b = x16;
                if (x16 > 0.0f) {
                    z16 = true;
                }
                hVar.f236067c = z16;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.e
        public int getOrientation() {
            return this.f236064b;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.e
        public boolean isInAbsoluteEnd(View view) {
            if (this.f236064b == 1) {
                return !view.canScrollVertically(1);
            }
            return !view.canScrollHorizontally(1);
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.e
        public boolean isInAbsoluteStart(View view) {
            if (this.f236064b == 1) {
                return !view.canScrollVertically(-1);
            }
            return !view.canScrollHorizontally(-1);
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.e
        public void setOrientation(int i3) {
            this.f236064b = i3;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.e
        public void translateView(View view, float f16) {
            if (this.f236064b == 1) {
                view.setTranslationY(f16);
            } else {
                view.setTranslationX(f16);
            }
            this.f236063a.f((int) f16);
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.e
        public void translateViewAndEvent(View view, float f16, MotionEvent motionEvent) {
            if (this.f236064b == 1) {
                view.setTranslationY(f16);
                motionEvent.offsetLocation(0.0f, f16 - motionEvent.getY(0));
            } else {
                view.setTranslationX(f16);
                motionEvent.offsetLocation(f16 - motionEvent.getX(0), 0.0f);
            }
            this.f236063a.f((int) f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public float f236065a;

        /* renamed from: b, reason: collision with root package name */
        public float f236066b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f236067c;

        protected h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        protected int f236068a;

        /* renamed from: b, reason: collision with root package name */
        protected float f236069b;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f236070c;

        protected i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class j implements View.OnTouchListener {
        protected k C;
        protected c D;
        protected d E;

        /* renamed from: d, reason: collision with root package name */
        protected final RecyclerView f236071d;

        /* renamed from: f, reason: collision with root package name */
        private OnOverScrollListener f236073f;

        /* renamed from: i, reason: collision with root package name */
        protected float f236075i;

        /* renamed from: m, reason: collision with root package name */
        protected f f236076m;

        /* renamed from: e, reason: collision with root package name */
        protected e f236072e = new g(this);

        /* renamed from: h, reason: collision with root package name */
        protected final i f236074h = new i();

        public j(RecyclerView recyclerView) {
            this.f236071d = recyclerView;
        }

        public void a() {
            this.f236071d.setOnTouchListener(this);
            this.f236071d.setOverScrollMode(2);
        }

        public void b() {
            this.f236071d.setOnTouchListener(null);
            this.f236071d.setOverScrollMode(0);
        }

        public View c() {
            return this.f236071d;
        }

        public void d() {
            this.D = new c(this, -2.0f);
            this.C = new k(this, 3.0f, 1.0f);
            f fVar = new f(this);
            this.f236076m = fVar;
            this.E = fVar;
            a();
        }

        protected void e(d dVar) {
            d dVar2 = this.E;
            this.E = dVar;
            dVar.c(dVar2);
            if (dVar instanceof f) {
                this.f236073f.b(1);
            } else if (dVar instanceof k) {
                this.f236073f.b(2);
            } else if (dVar instanceof c) {
                this.f236073f.b(3);
            }
        }

        public void f(int i3) {
            if (this.f236073f != null) {
                if (this.f236072e.getOrientation() == 1) {
                    this.f236073f.a(this.f236071d, 0, i3);
                } else {
                    this.f236073f.a(this.f236071d, i3, 0);
                }
            }
        }

        public void g() {
            this.f236072e.translateView(this.f236071d, 0.0f);
        }

        public void h(OnOverScrollListener onOverScrollListener) {
            this.f236073f = onOverScrollListener;
        }

        public void i(RecyclerView.LayoutManager layoutManager) {
            if (layoutManager instanceof LinearLayoutManager) {
                this.f236072e.setOrientation(((LinearLayoutManager) layoutManager).getOrientation());
            } else {
                this.f236072e.setOrientation(1);
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
                    return this.E.handleMoveTouchEvent(motionEvent);
                }
            }
            return this.E.handleUpOrCancelTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class k implements d {

        /* renamed from: d, reason: collision with root package name */
        protected final j f236077d;

        /* renamed from: e, reason: collision with root package name */
        protected float f236078e;

        /* renamed from: f, reason: collision with root package name */
        protected float f236079f;

        /* renamed from: h, reason: collision with root package name */
        protected final h f236080h = new h();

        /* renamed from: i, reason: collision with root package name */
        protected int f236081i;

        public k(j jVar, float f16, float f17) {
            this.f236077d = jVar;
            this.f236078e = f16;
            this.f236079f = f17;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public void c(d dVar) {
            int i3;
            if (this.f236077d.f236074h.f236070c) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            this.f236081i = i3;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            float f16;
            i iVar = this.f236077d.f236074h;
            if (iVar.f236068a != motionEvent.getPointerId(0)) {
                j jVar = this.f236077d;
                jVar.e(jVar.D);
                return true;
            }
            View c16 = this.f236077d.c();
            e eVar = this.f236077d.f236072e;
            if (!eVar.b(c16, this.f236080h, motionEvent)) {
                return true;
            }
            h hVar = this.f236080h;
            float f17 = hVar.f236066b;
            boolean z16 = hVar.f236067c;
            boolean z17 = iVar.f236070c;
            if (z16 == z17) {
                f16 = this.f236078e;
            } else {
                f16 = this.f236079f;
            }
            float f18 = f17 / f16;
            float f19 = hVar.f236065a + f18;
            if ((z17 && !z16 && f19 <= iVar.f236069b) || (!z17 && z16 && f19 >= iVar.f236069b)) {
                eVar.translateViewAndEvent(c16, iVar.f236069b, motionEvent);
                j jVar2 = this.f236077d;
                jVar2.e(jVar2.f236076m);
                return true;
            }
            if (c16.getParent() != null) {
                c16.getParent().requestDisallowInterceptTouchEvent(true);
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
            if (eventTime > 0) {
                this.f236077d.f236075i = f18 / ((float) eventTime);
            }
            eVar.translateView(c16, f19);
            return true;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            j jVar = this.f236077d;
            jVar.e(jVar.D);
            return false;
        }
    }

    public OverScrollRecyclerView(Context context) {
        super(context);
        this.f236048f = new j(this);
        this.C = new a();
        init();
    }

    private void init() {
        this.f236048f.d();
        this.f236048f.h(this.C);
    }

    public void F(@NonNull OnOverScrollListener onOverScrollListener) {
        if (this.f236049h == null) {
            this.f236049h = new ArrayList();
        }
        this.f236049h.add(onOverScrollListener);
    }

    public int G() {
        return this.f236051m;
    }

    public void H() {
        this.f236048f.b();
    }

    public void I() {
        this.f236048f.g();
    }

    public void K() {
        this.f236048f.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f236048f.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.f236048f.i(layoutManager);
    }

    public void setTouchDragRatio(float f16, float f17) {
        k kVar = this.f236048f.C;
        if (kVar != null) {
            kVar.f236078e = f16;
            kVar.f236079f = f17;
        }
    }

    public OverScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236048f = new j(this);
        this.C = new a();
        init();
    }

    public OverScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236048f = new j(this);
        this.C = new a();
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c extends com.tencent.mobileqq.widget.f implements d, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        protected final j f236056d;

        /* renamed from: f, reason: collision with root package name */
        protected final float f236058f;

        /* renamed from: h, reason: collision with root package name */
        protected final float f236059h;

        /* renamed from: e, reason: collision with root package name */
        protected final Interpolator f236057e = new DecelerateInterpolator();

        /* renamed from: i, reason: collision with root package name */
        protected final b f236060i = new b();

        public c(j jVar, float f16) {
            this.f236056d = jVar;
            this.f236058f = f16;
            this.f236059h = f16 * 2.0f;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public void c(d dVar) {
            Animator e16 = e();
            e16.addListener(this);
            e16.start();
        }

        protected Animator e() {
            View c16 = this.f236056d.c();
            j jVar = this.f236056d;
            e eVar = jVar.f236072e;
            i iVar = jVar.f236074h;
            float f16 = jVar.f236075i;
            eVar.a(c16, this.f236060i);
            float f17 = 0.0f;
            if (f16 != 0.0f && ((f16 >= 0.0f || !iVar.f236070c) && (f16 <= 0.0f || iVar.f236070c))) {
                float f18 = -f16;
                float f19 = f18 / this.f236058f;
                if (f19 >= 0.0f) {
                    f17 = f19;
                }
                float f26 = this.f236060i.f236054b + ((f18 * f16) / this.f236059h);
                ObjectAnimator g16 = g(c16, (int) f17, f26);
                ObjectAnimator f27 = f(f26);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(g16, f27);
                return animatorSet;
            }
            return f(this.f236060i.f236054b);
        }

        protected ObjectAnimator f(float f16) {
            View c16 = this.f236056d.c();
            i iVar = this.f236056d.f236074h;
            float abs = Math.abs(f16);
            b bVar = this.f236060i;
            float f17 = (abs / bVar.f236055c) * 800.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c16, bVar.f236053a, iVar.f236069b);
            ofFloat.setDuration(Math.max((int) f17, 200));
            ofFloat.setInterpolator(this.f236057e);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        protected ObjectAnimator g(View view, int i3, float f16) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f236060i.f236053a, f16);
            ofFloat.setDuration(i3);
            ofFloat.setInterpolator(this.f236057e);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j jVar = this.f236056d;
            jVar.e(jVar.f236076m);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.getAnimatedValue() instanceof Float) {
                this.f236056d.f((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
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
        protected final j f236061d;

        /* renamed from: e, reason: collision with root package name */
        protected final h f236062e = new h();

        public f(j jVar) {
            this.f236061d = jVar;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
            View c16 = this.f236061d.c();
            e eVar = this.f236061d.f236072e;
            if (!eVar.b(c16, this.f236062e, motionEvent)) {
                return false;
            }
            i iVar = this.f236061d.f236074h;
            if ((!eVar.isInAbsoluteStart(c16) || !this.f236062e.f236067c) && (!eVar.isInAbsoluteEnd(c16) || this.f236062e.f236067c)) {
                return false;
            }
            iVar.f236068a = motionEvent.getPointerId(0);
            h hVar = this.f236062e;
            iVar.f236069b = hVar.f236065a;
            iVar.f236070c = hVar.f236067c;
            j jVar = this.f236061d;
            jVar.e(jVar.C);
            return this.f236061d.C.handleMoveTouchEvent(motionEvent);
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.d
        public void c(d dVar) {
        }
    }
}
