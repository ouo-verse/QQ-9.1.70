package com.qzone.detail.ui.component;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes39.dex */
public class m {

    /* renamed from: w, reason: collision with root package name */
    private static final Interpolator f47066w = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f47067a;

    /* renamed from: b, reason: collision with root package name */
    private int f47068b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f47070d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f47071e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f47072f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f47073g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f47074h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f47075i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f47076j;

    /* renamed from: k, reason: collision with root package name */
    private int f47077k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f47078l;

    /* renamed from: m, reason: collision with root package name */
    private float f47079m;

    /* renamed from: n, reason: collision with root package name */
    private float f47080n;

    /* renamed from: o, reason: collision with root package name */
    private int f47081o;

    /* renamed from: p, reason: collision with root package name */
    private int f47082p;

    /* renamed from: q, reason: collision with root package name */
    private OverScroller f47083q;

    /* renamed from: r, reason: collision with root package name */
    private final b f47084r;

    /* renamed from: s, reason: collision with root package name */
    private View f47085s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f47086t;

    /* renamed from: u, reason: collision with root package name */
    private final ViewGroup f47087u;

    /* renamed from: c, reason: collision with root package name */
    private int f47069c = -1;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f47088v = new Runnable() { // from class: com.qzone.detail.ui.component.l
        @Override // java.lang.Runnable
        public final void run() {
            m.this.z();
        }
    };

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    m(Context context, ViewGroup viewGroup, b bVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (bVar != null) {
            this.f47087u = viewGroup;
            this.f47084r = bVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f47081o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f47068b = viewConfiguration.getScaledTouchSlop();
            this.f47079m = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f47080n = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f47083q = new OverScroller(context, f47066w);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    private void B() {
        this.f47078l.computeCurrentVelocity(1000, this.f47079m);
        o(f(this.f47078l.getXVelocity(this.f47069c), this.f47080n, this.f47079m), f(this.f47078l.getYVelocity(this.f47069c), this.f47080n, this.f47079m));
    }

    private void D(float f16, float f17, int i3) {
        r(i3);
        float[] fArr = this.f47070d;
        this.f47072f[i3] = f16;
        fArr[i3] = f16;
        float[] fArr2 = this.f47071e;
        this.f47073g[i3] = f17;
        fArr2[i3] = f17;
        this.f47074h[i3] = u((int) f16, (int) f17);
        this.f47077k |= 1 << i3;
    }

    private void E(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (x(pointerId)) {
                float x16 = motionEvent.getX(i3);
                float y16 = motionEvent.getY(i3);
                this.f47072f[pointerId] = x16;
                this.f47073g[pointerId] = y16;
            }
        }
    }

    private boolean d(float f16, float f17, int i3, int i16) {
        float abs = Math.abs(f16);
        float abs2 = Math.abs(f17);
        if ((this.f47074h[i3] & i16) != i16 || (this.f47082p & i16) == 0 || (this.f47076j[i3] & i16) == i16 || (this.f47075i[i3] & i16) == i16) {
            return false;
        }
        int i17 = this.f47068b;
        if (abs <= i17 && abs2 <= i17) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f47084r.g(i16)) {
            return (this.f47075i[i3] & i16) == 0 && abs > ((float) this.f47068b);
        }
        int[] iArr = this.f47076j;
        iArr[i3] = iArr[i3] | i16;
        return false;
    }

    private float f(float f16, float f17, float f18) {
        float abs = Math.abs(f16);
        if (abs < f17) {
            return 0.0f;
        }
        return abs > f18 ? f16 > 0.0f ? f18 : -f18 : f16;
    }

    private int g(int i3, int i16, int i17) {
        int abs = Math.abs(i3);
        if (abs < i16) {
            return 0;
        }
        return abs > i17 ? i3 > 0 ? i17 : -i17 : i3;
    }

    private void h() {
        float[] fArr = this.f47070d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f47071e, 0.0f);
        Arrays.fill(this.f47072f, 0.0f);
        Arrays.fill(this.f47073g, 0.0f);
        Arrays.fill(this.f47074h, 0);
        Arrays.fill(this.f47075i, 0);
        Arrays.fill(this.f47076j, 0);
        this.f47077k = 0;
    }

    private void i(int i3) {
        if (this.f47070d == null || !w(i3)) {
            return;
        }
        this.f47070d[i3] = 0.0f;
        this.f47071e[i3] = 0.0f;
        this.f47072f[i3] = 0.0f;
        this.f47073g[i3] = 0.0f;
        this.f47074h[i3] = 0;
        this.f47075i[i3] = 0;
        this.f47076j[i3] = 0;
        this.f47077k = (~(1 << i3)) & this.f47077k;
    }

    private int k(View view, int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18;
        float f19;
        int g16 = g(i17, (int) this.f47080n, (int) this.f47079m);
        int g17 = g(i18, (int) this.f47080n, (int) this.f47079m);
        int abs = Math.abs(i3);
        int abs2 = Math.abs(i16);
        int abs3 = Math.abs(g16);
        int abs4 = Math.abs(g17);
        int i19 = abs3 + abs4;
        int i26 = abs + abs2;
        if (g16 != 0) {
            f16 = abs3;
            f17 = i19;
        } else {
            f16 = abs;
            f17 = i26;
        }
        float f26 = f16 / f17;
        if (g17 != 0) {
            f18 = abs4;
            f19 = i19;
        } else {
            f18 = abs2;
            f19 = i26;
        }
        return (int) ((j(i3, g16, this.f47084r.d(view)) * f26) + (j(i16, g17, this.f47084r.e(view)) * (f18 / f19)));
    }

    public static m m(ViewGroup viewGroup, float f16, b bVar) {
        m n3 = n(viewGroup, bVar);
        n3.f47068b = (int) (n3.f47068b * (1.0f / f16));
        return n3;
    }

    public static m n(ViewGroup viewGroup, b bVar) {
        return new m(viewGroup.getContext(), viewGroup, bVar);
    }

    private void q(int i3, int i16, int i17, int i18) {
        int left = this.f47085s.getLeft();
        int top = this.f47085s.getTop();
        if (i17 != 0) {
            i3 = this.f47084r.a(this.f47085s, i3, i17);
            ViewCompat.offsetLeftAndRight(this.f47085s, i3 - left);
        }
        int i19 = i3;
        if (i18 != 0) {
            i16 = this.f47084r.b(this.f47085s, i16, i18);
            ViewCompat.offsetTopAndBottom(this.f47085s, i16 - top);
        }
        int i26 = i16;
        if (i17 == 0 && i18 == 0) {
            return;
        }
        this.f47084r.k(this.f47085s, i19, i26, i19 - left, i26 - top);
    }

    private void r(int i3) {
        float[] fArr = this.f47070d;
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
                float[] fArr6 = this.f47071e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f47072f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f47073g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f47074h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f47075i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f47076j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f47070d = fArr2;
            this.f47071e = fArr3;
            this.f47072f = fArr4;
            this.f47073g = fArr5;
            this.f47074h = iArr;
            this.f47075i = iArr2;
            this.f47076j = iArr3;
        }
    }

    private boolean t(int i3, int i16, int i17, int i18) {
        int left = this.f47085s.getLeft();
        int top = this.f47085s.getTop();
        int i19 = i3 - left;
        int i26 = i16 - top;
        if (i19 == 0 && i26 == 0) {
            this.f47083q.abortAnimation();
            F(0);
            return false;
        }
        this.f47083q.startScroll(left, top, i19, i26, k(this.f47085s, i19, i26, i17, i18));
        F(2);
        return true;
    }

    private int u(int i3, int i16) {
        int i17 = i3 < this.f47087u.getLeft() + this.f47081o ? 1 : 0;
        if (i16 < this.f47087u.getTop() + this.f47081o) {
            i17 |= 4;
        }
        if (i3 > this.f47087u.getRight() - this.f47081o) {
            i17 |= 2;
        }
        return i16 > this.f47087u.getBottom() - this.f47081o ? i17 | 8 : i17;
    }

    private boolean x(int i3) {
        return w(i3);
    }

    public void A(MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f47078l == null) {
            this.f47078l = VelocityTracker.obtain();
        }
        this.f47078l.addMovement(motionEvent);
        int i16 = 0;
        if (actionMasked == 0) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View s16 = s((int) x16, (int) y16);
            D(x16, y16, pointerId);
            I(s16, pointerId);
            int i17 = this.f47074h[pointerId];
            int i18 = this.f47082p;
            if ((i17 & i18) != 0) {
                this.f47084r.h(i17 & i18, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f47067a == 1) {
                B();
            }
            b();
            return;
        }
        if (actionMasked == 2) {
            if (this.f47067a == 1) {
                if (x(this.f47069c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f47069c);
                    float x17 = motionEvent.getX(findPointerIndex);
                    float y17 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f47072f;
                    int i19 = this.f47069c;
                    int i26 = (int) (x17 - fArr[i19]);
                    int i27 = (int) (y17 - this.f47073g[i19]);
                    q(this.f47085s.getLeft() + i26, this.f47085s.getTop() + i27, i26, i27);
                    E(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i16 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i16);
                if (x(pointerId2)) {
                    float x18 = motionEvent.getX(i16);
                    float y18 = motionEvent.getY(i16);
                    float f16 = x18 - this.f47070d[pointerId2];
                    float f17 = y18 - this.f47071e[pointerId2];
                    C(f16, f17, pointerId2);
                    if (this.f47067a != 1) {
                        View s17 = s((int) x18, (int) y18);
                        if (e(s17, f16, f17) && I(s17, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i16++;
            }
            E(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f47067a == 1) {
                o(0.0f, 0.0f);
            }
            b();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x19 = motionEvent.getX(actionIndex);
            float y19 = motionEvent.getY(actionIndex);
            D(x19, y19, pointerId3);
            if (this.f47067a == 0) {
                I(s((int) x19, (int) y19), pointerId3);
                int i28 = this.f47074h[pointerId3];
                int i29 = this.f47082p;
                if ((i28 & i29) != 0) {
                    this.f47084r.h(i28 & i29, pointerId3);
                    return;
                }
                return;
            }
            if (v((int) x19, (int) y19)) {
                I(this.f47085s, pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f47067a == 1 && pointerId4 == this.f47069c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i16 >= pointerCount2) {
                    i3 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i16);
                if (pointerId5 != this.f47069c) {
                    View s18 = s((int) motionEvent.getX(i16), (int) motionEvent.getY(i16));
                    View view = this.f47085s;
                    if (s18 == view && I(view, pointerId5)) {
                        i3 = this.f47069c;
                        break;
                    }
                }
                i16++;
            }
            if (i3 == -1) {
                B();
            }
        }
        i(pointerId4);
    }

    void F(int i3) {
        this.f47087u.removeCallbacks(this.f47088v);
        if (this.f47067a != i3) {
            this.f47067a = i3;
            this.f47084r.j(i3);
            if (this.f47067a == 0) {
                this.f47085s = null;
            }
        }
    }

    public boolean G(int i3, int i16) {
        if (this.f47086t) {
            return t(i3, i16, (int) this.f47078l.getXVelocity(this.f47069c), (int) this.f47078l.getYVelocity(this.f47069c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    boolean I(View view, int i3) {
        if (view == this.f47085s && this.f47069c == i3) {
            return true;
        }
        if (view == null || !this.f47084r.m(view, i3)) {
            return false;
        }
        this.f47069c = i3;
        c(view, i3);
        return true;
    }

    public void c(View view, int i3) {
        if (view.getParent() == this.f47087u) {
            this.f47085s = view;
            this.f47069c = i3;
            this.f47084r.i(view, i3);
            F(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f47087u + ")");
    }

    public boolean l(boolean z16) {
        if (this.f47067a == 2) {
            boolean computeScrollOffset = this.f47083q.computeScrollOffset();
            int currX = this.f47083q.getCurrX();
            int currY = this.f47083q.getCurrY();
            int left = currX - this.f47085s.getLeft();
            int top = currY - this.f47085s.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.f47085s, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.f47085s, top);
            }
            if (left != 0 || top != 0) {
                this.f47084r.k(this.f47085s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f47083q.getFinalX() && currY == this.f47083q.getFinalY()) {
                this.f47083q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z16) {
                    this.f47087u.post(this.f47088v);
                } else {
                    F(0);
                }
            }
        }
        return this.f47067a == 2;
    }

    public View s(int i3, int i16) {
        for (int childCount = this.f47087u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f47087u.getChildAt(this.f47084r.c(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i16 >= childAt.getTop() && i16 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public boolean v(int i3, int i16) {
        return y(this.f47085s, i3, i16);
    }

    public boolean w(int i3) {
        return ((1 << i3) & this.f47077k) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.qzone.detail.ui.component.m$b] */
    private void C(float f16, float f17, int i3) {
        boolean d16 = d(f16, f17, i3, 1);
        boolean z16 = d16;
        if (d(f17, f16, i3, 4)) {
            z16 = (d16 ? 1 : 0) | 4;
        }
        boolean z17 = z16;
        if (d(f16, f17, i3, 2)) {
            z17 = (z16 ? 1 : 0) | 2;
        }
        ?? r06 = z17;
        if (d(f17, f16, i3, 8)) {
            r06 = (z17 ? 1 : 0) | 8;
        }
        if (r06 != 0) {
            int[] iArr = this.f47075i;
            iArr[i3] = iArr[i3] | r06;
            this.f47084r.f(r06, i3);
        }
    }

    private void o(float f16, float f17) {
        this.f47086t = true;
        this.f47084r.l(this.f47085s, f16, f17);
        this.f47086t = false;
        if (this.f47067a == 1) {
            F(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        F(0);
    }

    public void b() {
        this.f47069c = -1;
        h();
        VelocityTracker velocityTracker = this.f47078l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f47078l = null;
        }
    }

    private boolean e(View view, float f16, float f17) {
        if (view == null) {
            return false;
        }
        boolean z16 = this.f47084r.d(view) > 0;
        boolean z17 = this.f47084r.e(view) > 0;
        if (!z16 || !z17) {
            return z16 ? Math.abs(f16) > ((float) this.f47068b) : z17 && Math.abs(f17) > ((float) this.f47068b);
        }
        float f18 = (f16 * f16) + (f17 * f17);
        int i3 = this.f47068b;
        return f18 > ((float) (i3 * i3));
    }

    private int j(int i3, int i16, int i17) {
        int abs;
        if (i3 == 0) {
            return 0;
        }
        int width = this.f47087u.getWidth();
        float f16 = width / 2;
        float p16 = f16 + (p(Math.min(1.0f, Math.abs(i3) / width)) * f16);
        int abs2 = Math.abs(i16);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(p16 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i3) / i17) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean H(MotionEvent motionEvent) {
        boolean z16;
        View s16;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f47078l == null) {
            this.f47078l = VelocityTracker.obtain();
        }
        this.f47078l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x16 = motionEvent.getX(actionIndex);
                            float y16 = motionEvent.getY(actionIndex);
                            D(x16, y16, pointerId);
                            int i3 = this.f47067a;
                            if (i3 == 0) {
                                int i16 = this.f47074h[pointerId];
                                int i17 = this.f47082p;
                                if ((i16 & i17) != 0) {
                                    this.f47084r.h(i16 & i17, pointerId);
                                }
                            } else if (i3 == 2 && (s16 = s((int) x16, (int) y16)) == this.f47085s) {
                                I(s16, pointerId);
                            }
                        } else if (actionMasked == 6) {
                            i(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (this.f47070d != null && this.f47071e != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i18 = 0; i18 < pointerCount; i18++) {
                        int pointerId2 = motionEvent.getPointerId(i18);
                        if (x(pointerId2)) {
                            float x17 = motionEvent.getX(i18);
                            float y17 = motionEvent.getY(i18);
                            float f16 = x17 - this.f47070d[pointerId2];
                            float f17 = y17 - this.f47071e[pointerId2];
                            View s17 = s((int) x17, (int) y17);
                            boolean z17 = s17 != null && e(s17, f16, f17);
                            if (z17) {
                                int left = s17.getLeft();
                                int i19 = (int) f16;
                                int a16 = this.f47084r.a(s17, left + i19, i19);
                                int top = s17.getTop();
                                int i26 = (int) f17;
                                int b16 = this.f47084r.b(s17, top + i26, i26);
                                int d16 = this.f47084r.d(s17);
                                int e16 = this.f47084r.e(s17);
                                if (d16 != 0) {
                                    if (d16 > 0) {
                                    }
                                }
                                if (e16 == 0) {
                                    break;
                                }
                                if (e16 > 0 && b16 == top) {
                                    break;
                                }
                            }
                            C(f16, f17, pointerId2);
                            if (this.f47067a == 1) {
                                break;
                            }
                            if (z17 && I(s17, pointerId2)) {
                                break;
                            }
                        }
                    }
                    E(motionEvent);
                }
                z16 = false;
            }
            b();
            z16 = false;
        } else {
            float x18 = motionEvent.getX();
            float y18 = motionEvent.getY();
            z16 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            D(x18, y18, pointerId3);
            View s18 = s((int) x18, (int) y18);
            if (s18 == this.f47085s && this.f47067a == 2) {
                I(s18, pointerId3);
            }
            int i27 = this.f47074h[pointerId3];
            int i28 = this.f47082p;
            if ((i27 & i28) != 0) {
                this.f47084r.h(i27 & i28, pointerId3);
            }
        }
        if (this.f47067a == 1) {
            return true;
        }
        return z16;
    }

    public boolean y(View view, int i3, int i16) {
        return view != null && i3 >= view.getLeft() && i3 < view.getRight() && i16 >= view.getTop() && i16 < view.getBottom();
    }

    private float p(float f16) {
        return (float) Math.sin((f16 - 0.5f) * 0.47123894f);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static abstract class b {
        public abstract int a(View view, int i3, int i16);

        public abstract int b(View view, int i3, int i16);

        public abstract int d(View view);

        public abstract int e(View view);

        public boolean g(int i3) {
            return false;
        }

        public abstract boolean m(View view, int i3);

        public int c(int i3) {
            return i3;
        }

        public void j(int i3) {
        }

        public void f(int i3, int i16) {
        }

        public void h(int i3, int i16) {
        }

        public void i(View view, int i3) {
        }

        public void l(View view, float f16, float f17) {
        }

        public void k(View view, int i3, int i16, int i17, int i18) {
        }
    }
}
