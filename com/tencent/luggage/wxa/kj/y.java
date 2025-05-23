package com.tencent.luggage.wxa.kj;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class y extends FrameLayout {
    public ObjectAnimator C;

    /* renamed from: a, reason: collision with root package name */
    public View f132571a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f132572b;

    /* renamed from: c, reason: collision with root package name */
    public FrameLayout f132573c;

    /* renamed from: d, reason: collision with root package name */
    public final int f132574d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f132575e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f132576f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f132577g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f132578h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f132579i;

    /* renamed from: j, reason: collision with root package name */
    public int f132580j;

    /* renamed from: k, reason: collision with root package name */
    public int f132581k;

    /* renamed from: l, reason: collision with root package name */
    public int f132582l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f132583m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            y.this.c((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public y(Context context) {
        super(context);
        this.f132575e = true;
        this.f132576f = false;
        this.f132577g = false;
        this.f132578h = false;
        this.f132579i = false;
        this.f132583m = false;
        this.C = null;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f132574d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private int getMaxOverScrollDistance() {
        return getHeight();
    }

    public final int a(int i3) {
        int i16 = i3 >> 1;
        int maxOverScrollDistance = getMaxOverScrollDistance();
        if (i16 > maxOverScrollDistance) {
            return maxOverScrollDistance;
        }
        return i16;
    }

    public abstract boolean a();

    public final void b() {
        c();
        b(0);
        if (this.f132577g) {
            f();
        }
        this.f132578h = false;
        this.f132577g = false;
        this.f132579i = false;
    }

    public void c() {
    }

    public final void d() {
        if (this.f132572b == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.f132572b = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            addView(this.f132572b, getChildCount() > 0 ? 0 : -1);
        }
    }

    public boolean e() {
        return !this.f132575e;
    }

    public int getOpenHeight() {
        return this.f132571a.getHeight();
    }

    @ColorInt
    public int getPullDownBackgroundColor() {
        FrameLayout frameLayout = this.f132572b;
        if (frameLayout == null) {
            return 0;
        }
        Drawable background = frameLayout.getBackground();
        if (!(background instanceof ColorDrawable)) {
            return 0;
        }
        return ((ColorDrawable) background).getColor();
    }

    public int getStayHeight() {
        View view = this.f132571a;
        if (view == null) {
            return 0;
        }
        return view.getHeight();
    }

    public final void h() {
        c();
        b(getStayHeight());
        if (!this.f132577g) {
            g();
        }
        this.f132578h = true;
        this.f132577g = true;
        this.f132579i = true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f132575e) {
            return this.f132579i;
        }
        int action = motionEvent.getAction();
        if (action != 3 && action != 1) {
            if (action == 2 && this.f132578h) {
                return true;
            }
            if (action != 0) {
                if (action == 2 && a()) {
                    if (!this.f132583m) {
                        this.f132580j = (int) motionEvent.getX();
                        this.f132581k = (int) motionEvent.getY();
                        this.f132582l = (int) motionEvent.getY();
                        this.f132578h = false;
                        this.f132583m = true;
                        return false;
                    }
                    int x16 = (int) motionEvent.getX();
                    int y16 = (int) motionEvent.getY();
                    int i3 = x16 - this.f132580j;
                    int i16 = y16 - this.f132581k;
                    if (Math.abs(i16) > this.f132574d && Math.abs(i16) > Math.abs(i3) && i16 > 0) {
                        this.f132580j = x16;
                        this.f132581k = y16;
                        this.f132578h = true;
                        this.f132583m = false;
                        return true;
                    }
                }
            } else if (a()) {
                this.f132580j = (int) motionEvent.getX();
                this.f132581k = (int) motionEvent.getY();
                this.f132582l = (int) motionEvent.getY();
                this.f132578h = false;
                this.f132583m = true;
            }
            if (!this.f132578h && !this.f132579i) {
                return false;
            }
            return true;
        }
        this.f132578h = false;
        this.f132583m = false;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:
    
        if (r0 != 3) goto L52;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f132575e) {
            if (this.f132579i) {
                b();
            }
            return this.f132579i;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f132578h || this.f132579i) {
                        if (!this.f132583m) {
                            this.f132581k = (int) motionEvent.getY();
                            this.f132580j = (int) motionEvent.getX();
                            this.f132582l = (int) motionEvent.getY();
                            this.f132583m = true;
                            return true;
                        }
                        int y16 = ((int) motionEvent.getY()) - this.f132582l;
                        int a16 = a(y16);
                        if (this.f132577g) {
                            a16 += getStayHeight();
                        }
                        int max = Math.max(a16, 0);
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", Integer.valueOf(y16), Integer.valueOf(max));
                        d(max);
                        c(max);
                        return true;
                    }
                }
            }
            this.f132583m = false;
            if (this.f132573c.getTranslationY() > getOpenHeight() && this.f132576f) {
                h();
                return true;
            }
            if (this.f132578h || this.f132579i) {
                b();
                return true;
            }
        } else if (a() || this.f132579i) {
            this.f132581k = (int) motionEvent.getY();
            this.f132580j = (int) motionEvent.getX();
            this.f132582l = (int) motionEvent.getY();
            this.f132583m = true;
            return true;
        }
        return false;
    }

    public final void setBackgroundView(@NonNull View view) {
        this.f132571a = view;
        d();
        this.f132572b.addView(view);
    }

    public final void setContentView(@NonNull View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f132573c = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f132573c.addView(view);
        addView(this.f132573c);
    }

    public void setNeedStay(boolean z16) {
        this.f132576f = z16;
    }

    public void setPullDownBackgroundColor(int i3) {
        if (this.f132572b == null) {
            if (i3 == 0) {
                return;
            } else {
                d();
            }
        }
        this.f132572b.setBackgroundColor(i3);
    }

    public void setPullDownEnabled(boolean z16) {
        this.f132575e = !z16;
    }

    public void c(int i3) {
    }

    public final void d(int i3) {
        this.f132573c.setTranslationY(Math.min(getMaxOverScrollDistance(), i3));
    }

    public final void b(int i3) {
        int translationY = (int) this.f132573c.getTranslationY();
        if (translationY == i3) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", Integer.valueOf(translationY), Integer.valueOf(i3));
        ObjectAnimator objectAnimator = this.C;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        long abs = (Math.abs(translationY - i3) / getStayHeight()) * 250.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f132573c, "translationY", translationY, i3);
        ofFloat.setDuration(Math.min(abs, 250L));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
        ofFloat.addUpdateListener(new a());
        this.C = ofFloat;
    }

    public void f() {
    }

    public void g() {
    }
}
