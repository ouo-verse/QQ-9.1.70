package com.tencent.mobileqq.wink.editor.music.lyric.interaction;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ViewDragHelper {

    /* renamed from: w, reason: collision with root package name */
    private static final Interpolator f320920w = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f320921a;

    /* renamed from: b, reason: collision with root package name */
    private int f320922b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f320924d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f320925e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f320926f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f320927g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f320928h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f320929i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f320930j;

    /* renamed from: k, reason: collision with root package name */
    private int f320931k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f320932l;

    /* renamed from: m, reason: collision with root package name */
    private float f320933m;

    /* renamed from: n, reason: collision with root package name */
    private float f320934n;

    /* renamed from: o, reason: collision with root package name */
    private int f320935o;

    /* renamed from: p, reason: collision with root package name */
    private int f320936p;

    /* renamed from: q, reason: collision with root package name */
    private ScrollerCompat f320937q;

    /* renamed from: r, reason: collision with root package name */
    private final b f320938r;

    /* renamed from: s, reason: collision with root package name */
    private View f320939s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f320940t;

    /* renamed from: u, reason: collision with root package name */
    private final ViewGroup f320941u;

    /* renamed from: c, reason: collision with root package name */
    private int f320923c = -1;

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f320942v = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.M(0);
        }
    };

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    ViewDragHelper(Context context, ViewGroup viewGroup, Interpolator interpolator, b bVar) {
        if (viewGroup != null) {
            if (bVar != null) {
                this.f320941u = viewGroup;
                this.f320938r = bVar;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.f320935o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.f320922b = viewConfiguration.getScaledTouchSlop();
                this.f320933m = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f320934n = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f320937q = ScrollerCompat.create(context, interpolator == null ? f320920w : interpolator);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private void A(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        View s16 = s((int) x16, (int) y16);
        K(x16, y16, pointerId);
        R(s16, pointerId);
        int i3 = this.f320928h[pointerId];
        int i16 = this.f320936p;
        if ((i3 & i16) != 0) {
            this.f320938r.h(i3 & i16, pointerId);
        }
    }

    private void B(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        K(x16, y16, pointerId);
        View s16 = s((int) x16, (int) y16);
        if (s16 != null && s16.equals(this.f320939s) && this.f320921a == 2) {
            R(s16, pointerId);
        }
        int i3 = this.f320928h[pointerId];
        int i16 = this.f320936p;
        if ((i3 & i16) != 0) {
            this.f320938r.h(i3 & i16, pointerId);
        }
    }

    private void C(MotionEvent motionEvent) {
        if (this.f320921a == 1) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f320923c);
            float x16 = MotionEventCompat.getX(motionEvent, findPointerIndex);
            float y16 = MotionEventCompat.getY(motionEvent, findPointerIndex);
            float[] fArr = this.f320926f;
            int i3 = this.f320923c;
            int i16 = (int) (x16 - fArr[i3]);
            int i17 = (int) (y16 - this.f320927g[i3]);
            q(this.f320939s.getLeft() + i16, this.f320939s.getTop() + i17, i16, i17);
            L(motionEvent);
            return;
        }
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i18 = 0; i18 < pointerCount; i18++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i18);
            float x17 = MotionEventCompat.getX(motionEvent, i18);
            float y17 = MotionEventCompat.getY(motionEvent, i18);
            float f16 = x17 - this.f320924d[pointerId];
            float f17 = y17 - this.f320925e[pointerId];
            J(f16, f17, pointerId);
            if (this.f320921a == 1) {
                break;
            }
            View s16 = s((int) this.f320924d[pointerId], (int) this.f320925e[pointerId]);
            if (e(s16, f16, f17) && R(s16, pointerId)) {
                break;
            }
        }
        L(motionEvent);
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i3 = 0; i3 < pointerCount && this.f320924d != null && this.f320925e != null; i3++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i3);
            if (pointerId < this.f320924d.length && pointerId < this.f320925e.length) {
                float x16 = MotionEventCompat.getX(motionEvent, i3);
                float y16 = MotionEventCompat.getY(motionEvent, i3);
                float f16 = x16 - this.f320924d[pointerId];
                float f17 = y16 - this.f320925e[pointerId];
                J(f16, f17, pointerId);
                if (this.f320921a == 1) {
                    break;
                }
                View s16 = s((int) this.f320924d[pointerId], (int) this.f320925e[pointerId]);
                if (s16 != null && e(s16, f16, f17) && R(s16, pointerId)) {
                    break;
                }
            }
        }
        L(motionEvent);
    }

    private void E(MotionEvent motionEvent, int i3) {
        int pointerId = MotionEventCompat.getPointerId(motionEvent, i3);
        float x16 = MotionEventCompat.getX(motionEvent, i3);
        float y16 = MotionEventCompat.getY(motionEvent, i3);
        K(x16, y16, pointerId);
        if (this.f320921a == 0) {
            R(s((int) x16, (int) y16), pointerId);
            int i16 = this.f320928h[pointerId];
            int i17 = this.f320936p;
            if ((i16 & i17) != 0) {
                this.f320938r.h(i16 & i17, pointerId);
                return;
            }
            return;
        }
        if (x((int) x16, (int) y16)) {
            R(this.f320939s, pointerId);
        }
    }

    private void F(MotionEvent motionEvent, int i3) {
        View s16;
        int pointerId = MotionEventCompat.getPointerId(motionEvent, i3);
        float x16 = MotionEventCompat.getX(motionEvent, i3);
        float y16 = MotionEventCompat.getY(motionEvent, i3);
        K(x16, y16, pointerId);
        int i16 = this.f320921a;
        if (i16 == 0) {
            int i17 = this.f320928h[pointerId];
            int i18 = this.f320936p;
            if ((i17 & i18) != 0) {
                this.f320938r.h(i17 & i18, pointerId);
                return;
            }
            return;
        }
        if (i16 == 2 && (s16 = s((int) x16, (int) y16)) != null && s16.equals(this.f320939s)) {
            R(s16, pointerId);
        }
    }

    private void G(MotionEvent motionEvent, int i3) {
        int i16;
        int pointerId = MotionEventCompat.getPointerId(motionEvent, i3);
        if (this.f320921a == 1 && pointerId == this.f320923c) {
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            int i17 = 0;
            while (true) {
                if (i17 < pointerCount) {
                    int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i17);
                    if (pointerId2 != this.f320923c) {
                        float x16 = MotionEventCompat.getX(motionEvent, i17);
                        float y16 = MotionEventCompat.getY(motionEvent, i17);
                        View view = this.f320939s;
                        if (view != null && view.equals(s((int) x16, (int) y16)) && R(this.f320939s, pointerId2)) {
                            i16 = this.f320923c;
                            break;
                        }
                    }
                    i17++;
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 == -1) {
                I();
            }
        }
        i(pointerId);
    }

    private void I() {
        VelocityTracker velocityTracker = this.f320932l;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000, this.f320933m);
            o(f(VelocityTrackerCompat.getXVelocity(this.f320932l, this.f320923c), this.f320934n, this.f320933m), f(VelocityTrackerCompat.getYVelocity(this.f320932l, this.f320923c), this.f320934n, this.f320933m));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper$b] */
    private void J(float f16, float f17, int i3) {
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
            int[] iArr = this.f320929i;
            iArr[i3] = iArr[i3] | r06;
            this.f320938r.f(r06, i3);
        }
    }

    private void K(float f16, float f17, int i3) {
        r(i3);
        float[] fArr = this.f320924d;
        this.f320926f[i3] = f16;
        fArr[i3] = f16;
        float[] fArr2 = this.f320925e;
        this.f320927g[i3] = f17;
        fArr2[i3] = f17;
        this.f320928h[i3] = u((int) f16, (int) f17);
        this.f320931k |= 1 << i3;
    }

    private void L(MotionEvent motionEvent) {
        float[] fArr;
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i3);
            float x16 = MotionEventCompat.getX(motionEvent, i3);
            float y16 = MotionEventCompat.getY(motionEvent, i3);
            float[] fArr2 = this.f320926f;
            if (fArr2 != null && (fArr = this.f320927g) != null && fArr2.length > pointerId && fArr.length > pointerId) {
                fArr2[pointerId] = x16;
                fArr[pointerId] = y16;
            }
        }
    }

    private boolean d(float f16, float f17, int i3, int i16) {
        float abs = Math.abs(f16);
        float abs2 = Math.abs(f17);
        if ((this.f320928h[i3] & i16) != i16 || (this.f320936p & i16) == 0 || (this.f320930j[i3] & i16) == i16 || (this.f320929i[i3] & i16) == i16) {
            return false;
        }
        int i17 = this.f320922b;
        if (abs <= i17 && abs2 <= i17) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f320938r.g(i16)) {
            int[] iArr = this.f320930j;
            iArr[i3] = iArr[i3] | i16;
            return false;
        }
        if ((this.f320929i[i3] & i16) != 0 || abs <= this.f320922b) {
            return false;
        }
        return true;
    }

    private boolean e(View view, float f16, float f17) {
        boolean z16;
        boolean z17;
        if (view == null) {
            return false;
        }
        if (this.f320938r.d(view) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f320938r.e(view) > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && z17) {
            float f18 = (f16 * f16) + (f17 * f17);
            int i3 = this.f320922b;
            if (f18 <= i3 * i3) {
                return false;
            }
            return true;
        }
        if (z16) {
            if (Math.abs(f16) <= this.f320922b) {
                return false;
            }
            return true;
        }
        if (!z17 || Math.abs(f17) <= this.f320922b) {
            return false;
        }
        return true;
    }

    private float f(float f16, float f17, float f18) {
        float abs = Math.abs(f16);
        if (abs < f17) {
            return 0.0f;
        }
        if (abs > f18) {
            if (f16 <= 0.0f) {
                return -f18;
            }
            return f18;
        }
        return f16;
    }

    private int g(int i3, int i16, int i17) {
        int abs = Math.abs(i3);
        if (abs < i16) {
            return 0;
        }
        if (abs > i17) {
            if (i3 <= 0) {
                return -i17;
            }
            return i17;
        }
        return i3;
    }

    private void h() {
        float[] fArr = this.f320924d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f320925e, 0.0f);
        Arrays.fill(this.f320926f, 0.0f);
        Arrays.fill(this.f320927g, 0.0f);
        Arrays.fill(this.f320928h, 0);
        Arrays.fill(this.f320929i, 0);
        Arrays.fill(this.f320930j, 0);
        this.f320931k = 0;
    }

    private void i(int i3) {
        float[] fArr = this.f320924d;
        if (fArr != null && fArr.length > i3) {
            fArr[i3] = 0.0f;
            this.f320925e[i3] = 0.0f;
            this.f320926f[i3] = 0.0f;
            this.f320927g[i3] = 0.0f;
            this.f320928h[i3] = 0;
            this.f320929i[i3] = 0;
            this.f320930j[i3] = 0;
            this.f320931k = (~(1 << i3)) & this.f320931k;
        }
    }

    private int j(int i3, int i16, int i17) {
        int abs;
        if (i3 == 0) {
            return 0;
        }
        int width = this.f320941u.getWidth();
        float f16 = width / 2;
        float p16 = f16 + (p(Math.min(1.0f, Math.abs(i3) / width)) * f16);
        int abs2 = Math.abs(i16);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(p16 / abs2) * 1000.0f) * 4;
        } else {
            if (i17 == 0) {
                return 0;
            }
            abs = (int) (((Math.abs(i3) / i17) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int k(View view, int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18;
        float f19;
        int g16 = g(i17, (int) this.f320934n, (int) this.f320933m);
        int g17 = g(i18, (int) this.f320934n, (int) this.f320933m);
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
        return (int) ((j(i3, g16, this.f320938r.d(view)) * f26) + (j(i16, g17, this.f320938r.e(view)) * (f18 / f19)));
    }

    public static ViewDragHelper m(ViewGroup viewGroup, float f16, Interpolator interpolator, b bVar) {
        ViewDragHelper n3 = n(viewGroup, interpolator, bVar);
        n3.f320922b = (int) (n3.f320922b * (1.0f / f16));
        return n3;
    }

    public static ViewDragHelper n(ViewGroup viewGroup, Interpolator interpolator, b bVar) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, interpolator, bVar);
    }

    private void o(float f16, float f17) {
        View view;
        this.f320940t = true;
        b bVar = this.f320938r;
        if (bVar != null && (view = this.f320939s) != null) {
            bVar.l(view, f16, f17);
        }
        this.f320940t = false;
        if (this.f320921a == 1) {
            M(0);
        }
    }

    private float p(float f16) {
        return (float) Math.sin((float) ((f16 - 0.5f) * 0.4712389167638204d));
    }

    private void q(int i3, int i16, int i17, int i18) {
        int left = this.f320939s.getLeft();
        int top = this.f320939s.getTop();
        if (i17 != 0) {
            i3 = this.f320938r.a(this.f320939s, i3, i17);
            this.f320939s.offsetLeftAndRight(i3 - left);
        }
        int i19 = i3;
        if (i18 != 0) {
            i16 = this.f320938r.b(this.f320939s, i16, i18);
            this.f320939s.offsetTopAndBottom(i16 - top);
        }
        int i26 = i16;
        if (i17 != 0 || i18 != 0) {
            this.f320938r.k(this.f320939s, i19, i26, i19 - left, i26 - top);
        }
    }

    private void r(int i3) {
        float[] fArr = this.f320924d;
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
                float[] fArr6 = this.f320925e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f320926f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f320927g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f320928h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f320929i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f320930j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f320924d = fArr2;
            this.f320925e = fArr3;
            this.f320926f = fArr4;
            this.f320927g = fArr5;
            this.f320928h = iArr;
            this.f320929i = iArr2;
            this.f320930j = iArr3;
        }
    }

    private boolean t(int i3, int i16, int i17, int i18) {
        int left = this.f320939s.getLeft();
        int top = this.f320939s.getTop();
        int i19 = i3 - left;
        int i26 = i16 - top;
        if (i19 == 0 && i26 == 0) {
            this.f320937q.abortAnimation();
            M(0);
            return false;
        }
        this.f320937q.startScroll(left, top, i19, i26, k(this.f320939s, i19, i26, i17, i18));
        M(2);
        return true;
    }

    private int u(int i3, int i16) {
        int i17;
        if (i3 < this.f320941u.getLeft() + this.f320935o) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        if (i16 < this.f320941u.getTop() + this.f320935o) {
            i17 |= 4;
        }
        if (i3 > this.f320941u.getRight() - this.f320935o) {
            i17 |= 2;
        }
        if (i16 > this.f320941u.getBottom() - this.f320935o) {
            return i17 | 8;
        }
        return i17;
    }

    public void H(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            b();
        }
        if (this.f320932l == null) {
            this.f320932l = VelocityTracker.obtain();
        }
        this.f320932l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                G(motionEvent, actionIndex);
                                return;
                            }
                            return;
                        }
                        E(motionEvent, actionIndex);
                        return;
                    }
                    if (this.f320921a == 1) {
                        o(0.0f, 0.0f);
                    }
                    b();
                    return;
                }
                C(motionEvent);
                return;
            }
            if (this.f320921a == 1) {
                I();
            }
            b();
            return;
        }
        A(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(int i3) {
        if (this.f320921a != i3) {
            this.f320921a = i3;
            b bVar = this.f320938r;
            if (bVar != null) {
                bVar.j(i3);
            }
            if (this.f320921a == 0) {
                this.f320939s = null;
            }
        }
    }

    public void N(float f16) {
        this.f320934n = f16;
    }

    public boolean O(int i3, int i16) {
        if (this.f320940t) {
            return t(i3, i16, (int) VelocityTrackerCompat.getXVelocity(this.f320932l, this.f320923c), (int) VelocityTrackerCompat.getYVelocity(this.f320932l, this.f320923c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public boolean P(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            b();
        }
        if (this.f320932l == null) {
            this.f320932l = VelocityTracker.obtain();
        }
        this.f320932l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                i(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                            }
                        } else {
                            F(motionEvent, actionIndex);
                        }
                    }
                } else {
                    D(motionEvent);
                }
            }
            b();
        } else {
            B(motionEvent);
        }
        if (this.f320921a == 1) {
            return true;
        }
        return false;
    }

    public boolean Q(View view, int i3, int i16) {
        this.f320939s = view;
        this.f320923c = -1;
        return t(i3, i16, 0, 0);
    }

    boolean R(View view, int i3) {
        if (view != null && view.equals(this.f320939s) && this.f320923c == i3) {
            return true;
        }
        if (view != null && this.f320938r.m(view, i3)) {
            this.f320923c = i3;
            c(view, i3);
            return true;
        }
        return false;
    }

    public void a() {
        b();
        if (this.f320921a == 2) {
            int currX = this.f320937q.getCurrX();
            int currY = this.f320937q.getCurrY();
            this.f320937q.abortAnimation();
            int currX2 = this.f320937q.getCurrX();
            int currY2 = this.f320937q.getCurrY();
            this.f320938r.k(this.f320939s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        M(0);
    }

    public void b() {
        this.f320923c = -1;
        h();
        VelocityTracker velocityTracker = this.f320932l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f320932l = null;
        }
    }

    public void c(View view, int i3) {
        ViewParent parent;
        if (view == null) {
            parent = null;
        } else {
            parent = view.getParent();
        }
        if (parent != null && !parent.equals(this.f320941u)) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f320941u + ")");
        }
        this.f320939s = view;
        this.f320923c = i3;
        this.f320938r.i(view, i3);
        M(1);
    }

    public boolean l(boolean z16) {
        if (this.f320939s == null) {
            return false;
        }
        if (this.f320921a == 2) {
            boolean computeScrollOffset = this.f320937q.computeScrollOffset();
            int currX = this.f320937q.getCurrX();
            int currY = this.f320937q.getCurrY();
            int left = currX - this.f320939s.getLeft();
            int top = currY - this.f320939s.getTop();
            if (!computeScrollOffset && top != 0) {
                this.f320939s.setTop(0);
                return true;
            }
            if (left != 0) {
                this.f320939s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f320939s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f320938r.k(this.f320939s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f320937q.getFinalX() && currY == this.f320937q.getFinalY()) {
                this.f320937q.abortAnimation();
                computeScrollOffset = this.f320937q.isFinished();
            }
            if (!computeScrollOffset) {
                if (z16) {
                    this.f320941u.post(this.f320942v);
                } else {
                    M(0);
                }
            }
        }
        if (this.f320921a != 2) {
            return false;
        }
        return true;
    }

    public View s(int i3, int i16) {
        for (int childCount = this.f320941u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f320941u.getChildAt(this.f320938r.c(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i16 >= childAt.getTop() && i16 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int v() {
        return this.f320922b;
    }

    public int w() {
        return this.f320921a;
    }

    public boolean x(int i3, int i16) {
        return z(this.f320939s, i3, i16);
    }

    public boolean y() {
        if (this.f320921a == 1) {
            return true;
        }
        return false;
    }

    public boolean z(View view, int i3, int i16) {
        if (view == null || i3 < view.getLeft() || i3 >= view.getRight() || i16 < view.getTop() || i16 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class b {
        public int a(View view, int i3, int i16) {
            return 0;
        }

        public abstract int b(View view, int i3, int i16);

        public int d(View view) {
            return 0;
        }

        public abstract int e(View view);

        public boolean g(int i3) {
            return false;
        }

        public abstract void i(View view, int i3);

        public abstract void j(int i3);

        public abstract void k(View view, int i3, int i16, int i17, int i18);

        public abstract void l(View view, float f16, float f17);

        public abstract boolean m(View view, int i3);

        public int c(int i3) {
            return i3;
        }

        public void f(int i3, int i16) {
        }

        public void h(int i3, int i16) {
        }
    }
}
