package com.tencent.luggage.wxa.fr;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.fr.c;
import com.tencent.luggage.wxa.so.h;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends FrameLayout {
    public static final int[] O = {1, 2, 8, 11};
    public float C;
    public int D;
    public boolean E;
    public Rect F;
    public int G;
    public int H;
    public long I;
    public final b0 J;
    public Runnable K;
    public float L;
    public float M;
    public MotionEvent N;

    /* renamed from: a, reason: collision with root package name */
    public int f126269a;

    /* renamed from: b, reason: collision with root package name */
    public float f126270b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f126271c;

    /* renamed from: d, reason: collision with root package name */
    public View f126272d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fr.c f126273e;

    /* renamed from: f, reason: collision with root package name */
    public float f126274f;

    /* renamed from: g, reason: collision with root package name */
    public int f126275g;

    /* renamed from: h, reason: collision with root package name */
    public int f126276h;

    /* renamed from: i, reason: collision with root package name */
    public CopyOnWriteArrayList f126277i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f126278j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f126279k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f126280l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f126281m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (a.this.f126272d == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (a.this.f126277i != null && !a.this.f126277i.isEmpty()) {
                Iterator it = a.this.f126277i.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(a.this.f126272d, a.this.f126275g + ((int) floatValue), a.this.f126276h + ((int) a.this.M));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (a.this.f126272d == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (a.this.f126277i != null && !a.this.f126277i.isEmpty()) {
                Iterator it = a.this.f126277i.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(a.this.f126272d, a.this.f126275g + ((int) a.this.L), a.this.f126276h + ((int) floatValue));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        int a(boolean z16);

        void a(int i3);

        void a(int i3, float f16);

        void a(MotionEvent motionEvent);

        void a(View view, int i3, int i16);

        void b();

        boolean c();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e extends d {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f extends c.AbstractC6225c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f126285a;

        public f() {
        }

        @Override // com.tencent.luggage.wxa.fr.c.AbstractC6225c
        public int a(View view) {
            return a.this.f126269a & 3;
        }

        @Override // com.tencent.luggage.wxa.fr.c.AbstractC6225c
        public boolean b(View view, int i3) {
            boolean a16;
            boolean e16 = a.this.f126273e.e(a.this.f126269a, i3);
            boolean z16 = true;
            if (e16) {
                if (!a.this.f126273e.e(1, i3)) {
                    if (!a.this.f126273e.e(2, i3)) {
                        if (a.this.f126273e.e(8, i3)) {
                            a.this.G = 8;
                        }
                    } else {
                        a.this.G = 2;
                    }
                } else {
                    a.this.G = 1;
                }
                if (a.this.f126277i != null && !a.this.f126277i.isEmpty()) {
                    Iterator it = a.this.f126277i.iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).a(a.this.G);
                    }
                }
                this.f126285a = true;
            }
            if (a.this.f126269a == 1 || a.this.f126269a == 2) {
                a16 = a.this.f126273e.a(2, i3);
            } else {
                if (a.this.f126269a != 8) {
                    if (a.this.f126269a != 11) {
                        z16 = false;
                    }
                    return e16 & z16 & a.this.f126271c;
                }
                a16 = a.this.f126273e.a(1, i3);
            }
            z16 = true ^ a16;
            return e16 & z16 & a.this.f126271c;
        }

        @Override // com.tencent.luggage.wxa.fr.c.AbstractC6225c
        public void c(int i3) {
            super.c(i3);
            if (a.this.f126277i != null && !a.this.f126277i.isEmpty()) {
                Iterator it = a.this.f126277i.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(i3, a.this.f126274f);
                }
            }
        }

        public /* synthetic */ f(a aVar, C6224a c6224a) {
            this();
        }

        @Override // com.tencent.luggage.wxa.fr.c.AbstractC6225c
        public void a(View view, int i3, int i16, int i17, int i18) {
            super.a(view, i3, i16, i17, i18);
            if ((a.this.G & 1) == 0) {
                if ((a.this.G & 2) == 0) {
                    if ((a.this.G & 8) != 0) {
                        a.this.f126274f = Math.abs(i16 / (r5.f126272d.getHeight() + a.this.f126281m.getIntrinsicHeight()));
                    }
                } else {
                    a.this.f126274f = Math.abs(i3 / (r5.f126272d.getWidth() + a.this.f126280l.getIntrinsicWidth()));
                }
            } else {
                a.this.f126274f = Math.abs(i3 / (r5.f126272d.getWidth() + a.this.f126279k.getIntrinsicWidth()));
            }
            a.this.f126275g = i3;
            a.this.f126276h = i16;
            a.this.invalidate();
            if (a.this.f126274f < a.this.f126270b && !this.f126285a) {
                this.f126285a = true;
            }
            if (a.this.f126277i != null && !a.this.f126277i.isEmpty()) {
                Iterator it = a.this.f126277i.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a(a.this.f126273e.d(), a.this.f126274f);
                }
            }
            if (a.this.f126277i != null && !a.this.f126277i.isEmpty() && a.this.f126273e.d() == 1 && a.this.f126274f >= a.this.f126270b && this.f126285a) {
                this.f126285a = false;
                Iterator it5 = a.this.f126277i.iterator();
                while (it5.hasNext()) {
                    ((d) it5.next()).b();
                }
            }
            if (a.this.f126274f >= 1.0f) {
                if (a.this.H == 1) {
                    a.this.f126272d.setTranslationX(0.0f);
                    a.this.f126272d.setTranslationY(0.0f);
                }
                if (a.this.f126277i != null && !a.this.f126277i.isEmpty()) {
                    Iterator it6 = a.this.f126277i.iterator();
                    while (it6.hasNext()) {
                        d dVar = (d) it6.next();
                        if (dVar instanceof e) {
                            ((e) dVar).a();
                        }
                    }
                }
            }
            if (a.this.H == 1) {
                a.this.L = -i3;
                a.this.M = (i3 * r5.getHeight()) / a.this.getWidth();
            } else {
                a.this.L = 0.0f;
                a.this.M = 0.0f;
            }
            boolean z16 = SystemClock.uptimeMillis() < a.this.I;
            if (!z16) {
                if (a.this.K != null) {
                    w.d("SwipeBackLayout", "startFreezeResetAnim|onViewPositionChanged");
                    a.this.e();
                    a.this.f();
                }
                a.this.f126272d.setTranslationX(a.this.L);
                a.this.f126272d.setTranslationY(a.this.M);
            } else {
                h.a("SwipeBackLayout-Freeze");
                a.this.f126272d.setTranslationX(-i3);
                a.this.f126272d.setTranslationY(-i16);
                h.a();
            }
            if (a.this.f126277i == null || a.this.f126277i.isEmpty()) {
                return;
            }
            Iterator it7 = a.this.f126277i.iterator();
            while (it7.hasNext()) {
                d dVar2 = (d) it7.next();
                if (z16) {
                    dVar2.a(a.this.f126272d, 0, 0);
                } else {
                    dVar2.a(a.this.f126272d, a.this.f126275g + ((int) a.this.L), a.this.f126276h + ((int) a.this.M));
                }
            }
        }

        @Override // com.tencent.luggage.wxa.fr.c.AbstractC6225c
        public int b(View view) {
            return a.this.f126269a & 8;
        }

        @Override // com.tencent.luggage.wxa.fr.c.AbstractC6225c
        public int b(View view, int i3, int i16) {
            if ((a.this.G & 8) != 0) {
                return Math.min(0, Math.max(i3, -view.getHeight()));
            }
            return 0;
        }

        @Override // com.tencent.luggage.wxa.fr.c.AbstractC6225c
        public void a(View view, float f16, float f17) {
            int i3;
            int i16;
            int width = view.getWidth();
            int height = view.getHeight();
            if ((a.this.G & 1) != 0) {
                if (f16 > 0.0f || (f16 == 0.0f && a.this.f126274f > a.this.f126270b)) {
                    i16 = width + a.this.f126279k.getIntrinsicWidth() + 10;
                    i3 = 0;
                }
                i3 = 0;
                i16 = 0;
            } else {
                if ((a.this.G & 2) != 0) {
                    if (f16 < 0.0f || (f16 == 0.0f && a.this.f126274f > a.this.f126270b)) {
                        i16 = -(width + a.this.f126279k.getIntrinsicWidth() + 10);
                        i3 = 0;
                    }
                } else if ((a.this.G & 8) != 0 && (f17 < 0.0f || (f17 == 0.0f && a.this.f126274f > a.this.f126270b))) {
                    i3 = -(height + a.this.f126281m.getIntrinsicHeight() + 10);
                    i16 = 0;
                }
                i3 = 0;
                i16 = 0;
            }
            if (a.this.f126277i != null && !a.this.f126277i.isEmpty()) {
                Iterator it = a.this.f126277i.iterator();
                while (it.hasNext()) {
                    int a16 = ((d) it.next()).a(i16 != 0);
                    if (a16 == 2) {
                        i16 = 0;
                    } else if (a16 == 3) {
                        if (a.this.H == 1) {
                            a.this.f126272d.setTranslationX(0.0f);
                            a.this.f126272d.setTranslationY(0.0f);
                            return;
                        }
                        return;
                    }
                }
            }
            if (SystemClock.uptimeMillis() < a.this.I) {
                w.d("SwipeBackLayout", "isFreezeReleased");
                Iterator it5 = a.this.f126277i.iterator();
                while (it5.hasNext()) {
                    if (((d) it5.next()).c()) {
                        a.this.f();
                        return;
                    }
                }
            }
            w.d("SwipeBackLayout", "settleCapturedViewAt|left|" + i16 + "|top|" + i3);
            a.this.f126273e.f(i16, i3);
            a.this.invalidate();
        }

        @Override // com.tencent.luggage.wxa.fr.c.AbstractC6225c
        public int a(View view, int i3, int i16) {
            if ((a.this.G & 1) == 0) {
                if ((a.this.G & 2) != 0) {
                    return Math.min(0, Math.max(i3, -view.getWidth()));
                }
                return 0;
            }
            return Math.min(view.getWidth(), Math.max(i3, 0));
        }
    }

    public a(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.C = 1.0f - this.f126274f;
        if (this.f126273e.a(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f126271c) {
            return super.dispatchTouchEvent(motionEvent);
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f126277i;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator it = this.f126277i.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(motionEvent);
            }
        }
        if (this.f126273e.d() == 1) {
            if (this.N != null) {
                this.N = null;
            }
            this.f126273e.a(motionEvent);
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.N = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.N = null;
        }
        try {
            if (this.f126273e.c(motionEvent)) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | NullPointerException unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        boolean z16;
        if (view == this.f126272d) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean drawChild = super.drawChild(canvas, view, j3);
        if (this.C > 0.0f && z16 && this.f126273e.d() != 0) {
            b(canvas, view);
            a(canvas, view);
        }
        return drawChild;
    }

    public int getEdgeSize() {
        return this.f126273e.c();
    }

    public boolean getEnableGesture() {
        return this.f126271c;
    }

    public View getTargetView() {
        return this.f126272d;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.E = true;
        View view = this.f126272d;
        if (view != null) {
            int i19 = this.f126275g;
            view.layout(i19, this.f126276h, view.getMeasuredWidth() + i19, this.f126276h + this.f126272d.getMeasuredHeight());
        }
        this.E = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f126271c) {
            return false;
        }
        this.f126273e.a(motionEvent);
        return true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.E) {
            super.requestLayout();
        }
    }

    public void setContentView(View view) {
        this.f126272d = view;
    }

    public void setEdgeSize(int i3) {
        this.f126273e.e(i3);
    }

    public void setEdgeTrackingEnabled(int i3) {
        this.f126269a = i3;
        this.f126273e.f(i3);
    }

    public void setEnableGesture(boolean z16) {
        this.f126271c = z16;
    }

    public void setMaxVelocity(float f16) {
        this.f126273e.b(f16);
    }

    public void setMinVelocity(float f16) {
        this.f126273e.c(f16);
    }

    public void setOrientation(int i3) {
        this.H = i3;
    }

    public void setScrimColor(int i3) {
        this.D = i3;
        invalidate();
    }

    public void setScrollThresHold(float f16) {
        if (f16 < 1.0f && f16 > 0.0f) {
            this.f126270b = f16;
            return;
        }
        throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
    }

    @Deprecated
    public void setSwipeListener(d dVar) {
        a(dVar);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f4075i);
    }

    public void d() {
        this.f126274f = 0.0f;
        this.L = 0.0f;
        this.M = 0.0f;
        this.I = 0L;
        f();
        View view = this.f126272d;
        if (view != null) {
            view.setTranslationX(0.0f);
            this.f126272d.setTranslationY(0.0f);
        }
        this.f126273e.a();
        this.f126273e.d(0);
        if (this.f126275g == 0 && this.f126276h == 0) {
            return;
        }
        this.f126276h = 0;
        this.f126275g = 0;
        requestLayout();
    }

    public final void e() {
        if (this.f126272d == null) {
            return;
        }
        C6224a c6224a = new C6224a();
        int i3 = this.H;
        if (i3 == 0) {
            View view = this.f126272d;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), this.L);
            ofFloat.setDuration(150L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addListener(c6224a);
            ofFloat.addUpdateListener(new b());
            ofFloat.start();
            this.f126272d.setTranslationY(this.M);
            return;
        }
        if (i3 == 1) {
            View view2 = this.f126272d;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationY", view2.getTranslationY(), this.M);
            ofFloat2.setDuration(150L);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat2.addListener(c6224a);
            ofFloat2.addUpdateListener(new c());
            ofFloat2.start();
            this.f126272d.setTranslationX(this.L);
            return;
        }
        this.f126272d.setTranslationX(this.L);
        this.f126272d.setTranslationY(this.M);
        invalidate();
    }

    public final void f() {
        Runnable runnable = this.K;
        if (runnable != null) {
            this.J.b(runnable);
            this.K = null;
        }
    }

    public a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.f126270b = 0.3f;
        this.f126271c = true;
        this.D = -1728053248;
        this.F = new Rect();
        this.H = 0;
        this.J = new b0(Looper.getMainLooper());
        this.f126273e = com.tencent.luggage.wxa.fr.c.a(this, new f(this, null));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.SwipeBackLayout, i3, R.style.a9u);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.SwipeBackLayout_edge_size, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(O[obtainStyledAttributes.getInt(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.SwipeBackLayout_edge_flag, 0)]);
        int resourceId = obtainStyledAttributes.getResourceId(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.SwipeBackLayout_shadow_left, R.drawable.o1_);
        int resourceId2 = obtainStyledAttributes.getResourceId(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.SwipeBackLayout_shadow_top, R.drawable.o1b);
        int resourceId3 = obtainStyledAttributes.getResourceId(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.SwipeBackLayout_shadow_right, R.drawable.o1a);
        int resourceId4 = obtainStyledAttributes.getResourceId(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.SwipeBackLayout_shadow_bottom, R.drawable.o19);
        a(resourceId, 1);
        a(resourceId2, 4);
        a(resourceId3, 2);
        a(resourceId4, 8);
        obtainStyledAttributes.recycle();
        float f16 = getResources().getDisplayMetrics().density * 400.0f;
        this.f126273e.c(f16);
        this.f126273e.b(f16 * 2.0f);
    }

    public void a(d dVar) {
        if (this.f126277i == null) {
            this.f126277i = new CopyOnWriteArrayList();
        }
        this.f126277i.add(dVar);
    }

    public final void b(Canvas canvas, View view) {
        Rect rect = this.F;
        view.getHitRect(rect);
        if ((this.f126269a & 1) != 0) {
            if (this.H == 1) {
                Drawable drawable = this.f126278j;
                drawable.setBounds(rect.left, rect.top - drawable.getIntrinsicWidth(), rect.right, rect.top);
                this.f126278j.setAlpha((int) (this.C * 255.0f));
                this.f126278j.draw(canvas);
            } else {
                Drawable drawable2 = this.f126279k;
                drawable2.setBounds(rect.left - drawable2.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
                this.f126279k.setAlpha((int) (this.C * 255.0f));
                this.f126279k.draw(canvas);
            }
        }
        if ((this.f126269a & 2) != 0) {
            if (this.H != 1) {
                Drawable drawable3 = this.f126280l;
                int i3 = rect.right;
                drawable3.setBounds(i3, rect.top, drawable3.getIntrinsicWidth() + i3, rect.bottom);
                this.f126280l.setAlpha((int) (this.C * 255.0f));
                this.f126280l.draw(canvas);
            } else {
                throw new RuntimeException("Stub!");
            }
        }
        if ((this.f126269a & 8) != 0) {
            if (this.H != 1) {
                Drawable drawable4 = this.f126281m;
                int i16 = rect.left;
                int i17 = rect.bottom;
                drawable4.setBounds(i16, i17, rect.right, drawable4.getIntrinsicHeight() + i17);
                this.f126281m.setAlpha((int) (this.C * 255.0f));
                this.f126281m.draw(canvas);
                return;
            }
            throw new RuntimeException("Stub!");
        }
    }

    public void a(Drawable drawable, int i3) {
        if ((i3 & 1) != 0) {
            this.f126279k = drawable;
        } else if ((i3 & 4) != 0) {
            this.f126278j = drawable;
        } else if ((i3 & 2) != 0) {
            this.f126280l = drawable;
        } else if ((i3 & 8) != 0) {
            this.f126281m = drawable;
        }
        invalidate();
    }

    public void a(int i3, int i16) {
        a(getResources().getDrawable(i3), i16);
    }

    public final void a(Canvas canvas, View view) {
        int i3 = (this.D & 16777215) | (((int) ((((-16777216) & r0) >>> 24) * this.C)) << 24);
        int i16 = this.G;
        if ((i16 & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((i16 & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        } else if ((i16 & 8) != 0) {
            canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
        }
        canvas.drawColor(i3);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fr.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6224a implements Animator.AnimatorListener {
        public C6224a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.invalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
