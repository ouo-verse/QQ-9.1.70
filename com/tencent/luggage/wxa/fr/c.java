package com.tencent.luggage.wxa.fr;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.widget.ScrollerCompat;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: w, reason: collision with root package name */
    public static final Interpolator f126287w = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f126288a;

    /* renamed from: b, reason: collision with root package name */
    public int f126289b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f126291d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f126292e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f126293f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f126294g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f126295h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f126296i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f126297j;

    /* renamed from: k, reason: collision with root package name */
    public int f126298k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f126299l;

    /* renamed from: m, reason: collision with root package name */
    public float f126300m;

    /* renamed from: n, reason: collision with root package name */
    public float f126301n;

    /* renamed from: o, reason: collision with root package name */
    public int f126302o;

    /* renamed from: p, reason: collision with root package name */
    public int f126303p;

    /* renamed from: q, reason: collision with root package name */
    public ScrollerCompat f126304q;

    /* renamed from: r, reason: collision with root package name */
    public final AbstractC6225c f126305r;

    /* renamed from: s, reason: collision with root package name */
    public View f126306s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f126307t;

    /* renamed from: u, reason: collision with root package name */
    public final ViewGroup f126308u;

    /* renamed from: c, reason: collision with root package name */
    public int f126290c = -1;

    /* renamed from: v, reason: collision with root package name */
    public final Runnable f126309v = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d(0);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fr.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC6225c {
        public int a(int i3) {
            return i3;
        }

        public abstract int a(View view);

        public abstract int a(View view, int i3, int i16);

        public abstract void a(View view, float f16, float f17);

        public abstract int b(View view);

        public abstract int b(View view, int i3, int i16);

        public void b(int i3, int i16) {
        }

        public abstract boolean b(View view, int i3);

        public void a(int i3, int i16) {
        }

        public boolean b(int i3) {
            return false;
        }

        public void a(View view, int i3) {
        }

        public void a(View view, int i3, int i16, int i17, int i18) {
        }

        public void c(int i3) {
        }
    }

    public c(Context context, ViewGroup viewGroup, AbstractC6225c abstractC6225c) {
        if (viewGroup != null) {
            if (abstractC6225c != null) {
                this.f126308u = viewGroup;
                this.f126305r = abstractC6225c;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.f126302o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.f126289b = viewConfiguration.getScaledTouchSlop();
                this.f126300m = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f126301n = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f126304q = ScrollerCompat.create(context, f126287w);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    public static c a(ViewGroup viewGroup, AbstractC6225c abstractC6225c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC6225c);
    }

    public void b(float f16) {
        this.f126300m = f16;
    }

    public void c(float f16) {
        this.f126301n = f16;
    }

    public int d() {
        return this.f126288a;
    }

    public void e(int i3) {
        this.f126302o = i3;
    }

    public void f(int i3) {
        this.f126303p = i3;
    }

    public void a(View view, int i3) {
        if (view.getParent() == this.f126308u) {
            this.f126306s = view;
            this.f126290c = i3;
            this.f126305r.a(view, i3);
            d(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f126308u + ")");
    }

    public final boolean b(int i3, int i16, int i17, int i18) {
        int left = this.f126306s.getLeft();
        int top = this.f126306s.getTop();
        int i19 = i3 - left;
        int i26 = i16 - top;
        if (i19 == 0 && i26 == 0) {
            this.f126304q.abortAnimation();
            d(0);
            return false;
        }
        this.f126304q.startScroll(left, top, i19, i26, a(this.f126306s, i19, i26, i17, i18));
        d(2);
        return true;
    }

    public int c() {
        return this.f126302o;
    }

    public void d(int i3) {
        if (this.f126288a != i3) {
            this.f126288a = i3;
            this.f126305r.c(i3);
            if (i3 == 0) {
                this.f126306s = null;
            }
        }
    }

    public boolean e(int i3, int i16) {
        return c(i16) && (i3 & this.f126295h[i16]) != 0;
    }

    public boolean f(int i3, int i16) {
        if (this.f126307t) {
            return b(i3, i16, (int) VelocityTrackerCompat.getXVelocity(this.f126299l, this.f126290c), (int) VelocityTrackerCompat.getYVelocity(this.f126299l, this.f126290c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean c(int i3) {
        return ((1 << i3) & this.f126298k) != 0;
    }

    public final void e() {
        this.f126299l.computeCurrentVelocity(1000, this.f126300m);
        a(a(VelocityTrackerCompat.getXVelocity(this.f126299l, this.f126290c), this.f126301n, this.f126300m), a(VelocityTrackerCompat.getYVelocity(this.f126299l, this.f126290c), this.f126301n, this.f126300m));
    }

    public boolean c(MotionEvent motionEvent) {
        View b16;
        View b17;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            a();
        }
        if (this.f126299l == null) {
            this.f126299l = VelocityTracker.obtain();
        }
        this.f126299l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    for (int i3 = 0; i3 < pointerCount; i3++) {
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, i3);
                        float x16 = MotionEventCompat.getX(motionEvent, i3);
                        float y16 = MotionEventCompat.getY(motionEvent, i3);
                        float f16 = x16 - this.f126291d[pointerId];
                        float f17 = y16 - this.f126292e[pointerId];
                        a(f16, f17, pointerId);
                        if (this.f126288a == 1 || ((b16 = b((int) x16, (int) y16)) != null && a(b16, f16, f17) && b(b16, pointerId))) {
                            break;
                        }
                    }
                    b(motionEvent);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        float x17 = MotionEventCompat.getX(motionEvent, actionIndex);
                        float y17 = MotionEventCompat.getY(motionEvent, actionIndex);
                        b(x17, y17, pointerId2);
                        int i16 = this.f126288a;
                        if (i16 == 0) {
                            int i17 = this.f126295h[pointerId2] & this.f126303p;
                            if (i17 != 0) {
                                this.f126305r.b(i17, pointerId2);
                            }
                        } else if (i16 == 2 && (b17 = b((int) x17, (int) y17)) == this.f126306s) {
                            b(b17, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        a(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                    }
                }
            }
            a();
        } else {
            float x18 = motionEvent.getX();
            float y18 = motionEvent.getY();
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, 0);
            b(x18, y18, pointerId3);
            View b18 = b((int) x18, (int) y18);
            if (b18 == this.f126306s && this.f126288a == 2) {
                b(b18, pointerId3);
            }
            int i18 = this.f126295h[pointerId3] & this.f126303p;
            if (i18 != 0) {
                this.f126305r.b(i18, pointerId3);
            }
        }
        return this.f126288a == 1;
    }

    public boolean d(int i3, int i16) {
        return a(this.f126306s, i3, i16);
    }

    public void a() {
        this.f126290c = -1;
        b();
        VelocityTracker velocityTracker = this.f126299l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f126299l = null;
        }
    }

    public final int b(int i3, int i16, int i17) {
        int abs;
        if (i3 == 0) {
            return 0;
        }
        int width = this.f126308u.getWidth();
        float f16 = width / 2;
        float a16 = f16 + (a(Math.min(1.0f, Math.abs(i3) / width)) * f16);
        int abs2 = Math.abs(i16);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a16 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i3) / i17) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    public final int a(View view, int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18;
        float f19;
        int a16 = a(i17, (int) this.f126301n, (int) this.f126300m);
        int a17 = a(i18, (int) this.f126301n, (int) this.f126300m);
        int abs = Math.abs(i3);
        int abs2 = Math.abs(i16);
        int abs3 = Math.abs(a16);
        int abs4 = Math.abs(a17);
        int i19 = abs3 + abs4;
        int i26 = abs + abs2;
        if (a16 != 0) {
            f16 = abs3;
            f17 = i19;
        } else {
            f16 = abs;
            f17 = i26;
        }
        float f26 = f16 / f17;
        if (a17 != 0) {
            f18 = abs4;
            f19 = i19;
        } else {
            f18 = abs2;
            f19 = i26;
        }
        return (int) ((b(i3, a16, this.f126305r.a(view)) * f26) + (b(i16, a17, this.f126305r.b(view)) * (f18 / f19)));
    }

    public final void b() {
        float[] fArr = this.f126291d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f126292e, 0.0f);
        Arrays.fill(this.f126293f, 0.0f);
        Arrays.fill(this.f126294g, 0.0f);
        Arrays.fill(this.f126295h, 0);
        Arrays.fill(this.f126296i, 0);
        Arrays.fill(this.f126297j, 0);
        this.f126298k = 0;
    }

    public final int a(int i3, int i16, int i17) {
        int abs = Math.abs(i3);
        if (abs < i16) {
            return 0;
        }
        return abs > i17 ? i3 > 0 ? i17 : -i17 : i3;
    }

    public final float a(float f16, float f17, float f18) {
        float abs = Math.abs(f16);
        if (abs < f17) {
            return 0.0f;
        }
        return abs > f18 ? f16 > 0.0f ? f18 : -f18 : f16;
    }

    public final float a(float f16) {
        return (float) Math.sin((float) ((f16 - 0.5f) * 0.4712389167638204d));
    }

    public boolean a(boolean z16) {
        if (this.f126288a == 2) {
            boolean computeScrollOffset = this.f126304q.computeScrollOffset();
            int currX = this.f126304q.getCurrX();
            int currY = this.f126304q.getCurrY();
            int left = currX - this.f126306s.getLeft();
            int top = currY - this.f126306s.getTop();
            if (left != 0) {
                this.f126306s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f126306s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f126305r.a(this.f126306s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f126304q.getFinalX() && currY == this.f126304q.getFinalY()) {
                this.f126304q.abortAnimation();
                computeScrollOffset = this.f126304q.isFinished();
            }
            if (!computeScrollOffset) {
                if (z16) {
                    this.f126308u.post(this.f126309v);
                } else {
                    d(0);
                }
            }
        }
        return this.f126288a == 2;
    }

    public final void b(int i3) {
        float[] fArr = this.f126291d;
        if (fArr == null || fArr.length <= i3) {
            int i16 = i3 + 1;
            float[] fArr2 = new float[i16];
            float[] fArr3 = new float[i16];
            float[] fArr4 = new float[i16];
            float[] fArr5 = new float[i16];
            int[] iArr = new int[i16];
            int[] iArr2 = new int[i16];
            int[] iArr3 = new int[i16];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f126292e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f126293f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f126294g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f126295h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f126296i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f126297j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f126291d = fArr2;
            this.f126292e = fArr3;
            this.f126293f = fArr4;
            this.f126294g = fArr5;
            this.f126295h = iArr;
            this.f126296i = iArr2;
            this.f126297j = iArr3;
        }
    }

    public final void a(float f16, float f17) {
        this.f126307t = true;
        this.f126305r.a(this.f126306s, f16, f17);
        this.f126307t = false;
        if (this.f126288a == 1) {
            d(0);
        }
    }

    public final void a(int i3) {
        float[] fArr = this.f126291d;
        if (fArr == null) {
            return;
        }
        fArr[i3] = 0.0f;
        this.f126292e[i3] = 0.0f;
        this.f126293f[i3] = 0.0f;
        this.f126294g[i3] = 0.0f;
        this.f126295h[i3] = 0;
        this.f126296i[i3] = 0;
        this.f126297j[i3] = 0;
        this.f126298k = (~(1 << i3)) & this.f126298k;
    }

    public final int c(int i3, int i16) {
        int i17 = i3 < this.f126308u.getLeft() + this.f126302o ? 1 : 0;
        if (i16 < this.f126308u.getTop() + this.f126302o) {
            i17 = 4;
        }
        if (i3 > this.f126308u.getRight() - this.f126302o) {
            i17 = 2;
        }
        if (i16 > this.f126308u.getBottom() - this.f126302o) {
            return 8;
        }
        return i17;
    }

    public final void b(float f16, float f17, int i3) {
        b(i3);
        float[] fArr = this.f126291d;
        this.f126293f[i3] = f16;
        fArr[i3] = f16;
        float[] fArr2 = this.f126292e;
        this.f126294g[i3] = f17;
        fArr2[i3] = f17;
        this.f126295h[i3] = c((int) f16, (int) f17);
        this.f126298k |= 1 << i3;
    }

    public void a(MotionEvent motionEvent) {
        int i3;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            a();
        }
        if (this.f126299l == null) {
            this.f126299l = VelocityTracker.obtain();
        }
        this.f126299l.addMovement(motionEvent);
        int i16 = 0;
        if (actionMasked == 0) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View b16 = b((int) x16, (int) y16);
            b(x16, y16, pointerId);
            b(b16, pointerId);
            int i17 = this.f126295h[pointerId] & this.f126303p;
            if (i17 != 0) {
                this.f126305r.b(i17, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f126288a == 1) {
                e();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f126288a == 1) {
                int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f126290c);
                float x17 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                float y17 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                float[] fArr = this.f126293f;
                int i18 = this.f126290c;
                int i19 = (int) (x17 - fArr[i18]);
                int i26 = (int) (y17 - this.f126294g[i18]);
                a(this.f126306s.getLeft() + i19, this.f126306s.getTop() + i26, i19, i26);
                b(motionEvent);
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i16 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i16);
                float x18 = MotionEventCompat.getX(motionEvent, i16);
                float y18 = MotionEventCompat.getY(motionEvent, i16);
                float f16 = x18 - this.f126291d[pointerId2];
                float f17 = y18 - this.f126292e[pointerId2];
                a(f16, f17, pointerId2);
                if (this.f126288a != 1) {
                    View b17 = b((int) x18, (int) y18);
                    if (a(b17, f16, f17) && b(b17, pointerId2)) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    break;
                }
            }
            b(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f126288a == 1) {
                a(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x19 = MotionEventCompat.getX(motionEvent, actionIndex);
            float y19 = MotionEventCompat.getY(motionEvent, actionIndex);
            b(x19, y19, pointerId3);
            if (this.f126288a == 0) {
                b(b((int) x19, (int) y19), pointerId3);
                int i27 = this.f126295h[pointerId3] & this.f126303p;
                if (i27 != 0) {
                    this.f126305r.b(i27, pointerId3);
                    return;
                }
                return;
            }
            if (d((int) x19, (int) y19)) {
                b(this.f126306s, pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
        if (this.f126288a == 1 && pointerId4 == this.f126290c) {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (true) {
                if (i16 >= pointerCount2) {
                    i3 = -1;
                    break;
                }
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i16);
                if (pointerId5 != this.f126290c) {
                    View b18 = b((int) MotionEventCompat.getX(motionEvent, i16), (int) MotionEventCompat.getY(motionEvent, i16));
                    View view = this.f126306s;
                    if (b18 == view && b(view, pointerId5)) {
                        i3 = this.f126290c;
                        break;
                    }
                }
                i16++;
            }
            if (i3 == -1) {
                e();
            }
        }
        a(pointerId4);
    }

    public final void b(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i3);
            float x16 = MotionEventCompat.getX(motionEvent, i3);
            float y16 = MotionEventCompat.getY(motionEvent, i3);
            this.f126293f[pointerId] = x16;
            this.f126294g[pointerId] = y16;
        }
    }

    public boolean b(View view, int i3) {
        if (view == this.f126306s && this.f126290c == i3) {
            return true;
        }
        if (view == null || !this.f126305r.b(view, i3)) {
            return false;
        }
        this.f126290c = i3;
        a(view, i3);
        return true;
    }

    public View b(int i3, int i16) {
        for (int childCount = this.f126308u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f126308u.getChildAt(this.f126305r.a(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i16 >= childAt.getTop() && i16 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.luggage.wxa.fr.c$c] */
    public final void a(float f16, float f17, int i3) {
        boolean a16 = a(f16, f17, i3, 1);
        boolean z16 = a16;
        if (a(f17, f16, i3, 4)) {
            z16 = (a16 ? 1 : 0) | 4;
        }
        boolean z17 = z16;
        if (a(f16, f17, i3, 2)) {
            z17 = (z16 ? 1 : 0) | 2;
        }
        ?? r06 = z17;
        if (a(f17, f16, i3, 8)) {
            r06 = (z17 ? 1 : 0) | 8;
        }
        if (r06 != 0) {
            int[] iArr = this.f126296i;
            iArr[i3] = iArr[i3] | r06;
            this.f126305r.a(r06, i3);
        }
    }

    public final boolean a(float f16, float f17, int i3, int i16) {
        float abs = Math.abs(f16);
        float abs2 = Math.abs(f17);
        if ((this.f126295h[i3] & i16) != i16 || (this.f126303p & i16) == 0 || (this.f126297j[i3] & i16) == i16 || (this.f126296i[i3] & i16) == i16) {
            return false;
        }
        float f18 = this.f126289b;
        if (abs <= f18 && abs2 <= f18) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f126305r.b(i16)) {
            return (this.f126296i[i3] & i16) == 0 && abs > ((float) this.f126289b);
        }
        int[] iArr = this.f126297j;
        iArr[i3] = iArr[i3] | i16;
        return false;
    }

    public final boolean a(View view, float f16, float f17) {
        if (view == null) {
            return false;
        }
        boolean z16 = this.f126305r.a(view) > 0;
        boolean z17 = this.f126305r.b(view) > 0;
        if (z16 && z17) {
            float f18 = (f16 * f16) + (f17 * f17);
            int i3 = this.f126289b;
            return f18 > ((float) (i3 * i3));
        }
        if (!z16) {
            return z17 && Math.abs(f17) > ((float) this.f126289b);
        }
        float abs = Math.abs(f16);
        return this.f126302o > 20 ? abs > ((float) this.f126289b) && Math.abs(f17) * 2.19f < abs : abs > ((float) this.f126289b);
    }

    public boolean a(int i3, int i16) {
        if (!c(i16)) {
            return false;
        }
        boolean z16 = (i3 & 1) == 1;
        boolean z17 = (i3 & 2) == 2;
        float f16 = this.f126293f[i16] - this.f126291d[i16];
        float f17 = this.f126294g[i16] - this.f126292e[i16];
        if (!z16 || !z17) {
            return z16 ? Math.abs(f16) > ((float) this.f126289b) : z17 && Math.abs(f17) > ((float) this.f126289b);
        }
        float f18 = (f16 * f16) + (f17 * f17);
        int i17 = this.f126289b;
        return f18 > ((float) (i17 * i17));
    }

    public final void a(int i3, int i16, int i17, int i18) {
        int left = this.f126306s.getLeft();
        int top = this.f126306s.getTop();
        if (i17 != 0) {
            i3 = this.f126305r.a(this.f126306s, i3, i17);
            this.f126306s.offsetLeftAndRight(i3 - left);
        }
        int i19 = i3;
        if (i18 != 0) {
            i16 = this.f126305r.b(this.f126306s, i16, i18);
            this.f126306s.offsetTopAndBottom(i16 - top);
        }
        int i26 = i16;
        if (i17 == 0 && i18 == 0) {
            return;
        }
        this.f126305r.a(this.f126306s, i19, i26, i19 - left, i26 - top);
    }

    public boolean a(View view, int i3, int i16) {
        return view != null && i3 >= view.getLeft() && i3 < view.getRight() && i16 >= view.getTop() && i16 < view.getBottom();
    }
}
