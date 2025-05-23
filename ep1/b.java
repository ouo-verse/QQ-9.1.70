package ep1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewCallbackClient;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b implements NestedScrollingChild3, WebViewCallbackClient {
    private VelocityTracker F;
    private int G;
    private OverScroller I;
    private int J;
    private int K;
    private View L;
    private WebView M;

    /* renamed from: m, reason: collision with root package name */
    private NestedScrollingChildHelper f396929m;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f396924d = new int[2];

    /* renamed from: e, reason: collision with root package name */
    private final int[] f396925e = new int[2];

    /* renamed from: f, reason: collision with root package name */
    private final int[] f396926f = new int[2];

    /* renamed from: h, reason: collision with root package name */
    private final int[] f396927h = new int[2];

    /* renamed from: i, reason: collision with root package name */
    private final int[] f396928i = new int[2];
    private boolean C = false;
    private boolean D = true;
    private boolean E = true;
    private int H = -1;

    public b(View view, WebView webView) {
        this.L = view;
        this.M = webView;
        m();
    }

    private void a() {
        this.I.abortAnimation();
        stopNestedScroll(1);
    }

    private void c() {
        this.C = false;
        s();
        stopNestedScroll();
    }

    private void d(int i3, int i16) {
        int height = this.L.getHeight();
        this.I.fling(j(), k(), i3, i16, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, this.L.getWidth() / 2, height / 2);
        t(true);
    }

    private int h() {
        return this.L.getOverScrollMode();
    }

    private ViewParent i() {
        return this.M;
    }

    private int j() {
        return this.L.getScrollX();
    }

    private int k() {
        return this.L.getScrollY();
    }

    private void n() {
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker == null) {
            this.F = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void o() {
        this.I = new OverScroller(e());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(e());
        this.G = viewConfiguration.getScaledTouchSlop();
        this.J = viewConfiguration.getScaledMinimumFlingVelocity();
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void p() {
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
    }

    private void q(MotionEvent motionEvent) {
        int i3;
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.H) {
            if (action == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.f396926f[0] = (int) motionEvent.getX(i3);
            this.f396926f[1] = (int) motionEvent.getY(i3);
            this.H = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.F;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean r(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i29;
        int i36;
        boolean z27;
        boolean z28;
        int h16 = h();
        if (this.M.computeHorizontalScrollRange() > this.M.computeHorizontalScrollExtent()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.M.computeVerticalScrollRange() > this.M.computeVerticalScrollExtent()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (h16 != 0 && (h16 != 1 || !z17)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (h16 != 0 && (h16 != 1 || !z18)) {
            z26 = false;
        } else {
            z26 = true;
        }
        int i37 = i17 + i3;
        if (!z19) {
            i29 = 0;
        } else {
            i29 = i27;
        }
        int i38 = i18 + i16;
        if (!z26) {
            i36 = 0;
        } else {
            i36 = i28;
        }
        int i39 = -i29;
        int i46 = i29 + i19;
        int i47 = -i36;
        int i48 = i36 + i26;
        if (i37 > i46) {
            i37 = i46;
            z27 = true;
        } else if (i37 < i39) {
            z27 = true;
            i37 = i39;
        } else {
            z27 = false;
        }
        if (i38 > i48) {
            i38 = i48;
            z28 = true;
        } else if (i38 < i47) {
            z28 = true;
            i38 = i47;
        } else {
            z28 = false;
        }
        if (z28 && !hasNestedScrollingParent(1)) {
            this.I.springBack(i37, i38, 0, f(), 0, l());
        }
        this.M.super_onOverScrolled(i37, i38, z27, z28);
        if (!z27 && !z28) {
            return false;
        }
        return true;
    }

    private void s() {
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.F = null;
        }
    }

    private void t(boolean z16) {
        if (z16) {
            startNestedScroll(g(), 1);
        } else {
            stopNestedScroll(1);
        }
        this.f396927h[0] = this.L.getScrollX();
        this.f396927h[1] = this.L.getScrollY();
        ViewCompat.postInvalidateOnAnimation(this.L);
    }

    public void b() {
        if (this.I.isFinished()) {
            return;
        }
        this.I.computeScrollOffset();
        int currY = this.I.getCurrY();
        int currX = this.I.getCurrX();
        int[] iArr = this.f396927h;
        int i3 = currX - iArr[0];
        int i16 = currY - iArr[1];
        iArr[0] = currX;
        iArr[1] = currY;
        int[] iArr2 = this.f396925e;
        iArr2[0] = 0;
        iArr2[1] = 0;
        dispatchNestedPreScroll(i3, i16, iArr2, null, 1);
        int[] iArr3 = this.f396925e;
        int i17 = i16 - iArr3[1];
        int i18 = i3 - iArr3[0];
        if (i17 != 0 || i18 != 0) {
            int k3 = k();
            int j3 = j();
            r(i18, i17, j3, k3, f(), l(), 0, 0, false);
            int j16 = j() - j3;
            int k16 = i17 - (k() - k3);
            int i19 = i18 - j16;
            int[] iArr4 = this.f396925e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            dispatchNestedScroll(0, 0, i19, k16, this.f396924d, 1, iArr4);
            int[] iArr5 = this.f396925e;
            i18 = i19 - iArr5[0];
            i17 = k16 - iArr5[1];
        }
        if (i17 != 0 || i18 != 0) {
            a();
        }
        if (!this.I.isFinished()) {
            ViewCompat.postInvalidateOnAnimation(this.L);
        }
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void computeScroll(View view) {
        b();
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        return this.f396929m.dispatchNestedFling(f16, f17, false);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        return this.f396929m.dispatchNestedPreFling(f16, f17);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i3, i16, iArr, iArr2, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        return dispatchNestedScroll(i3, i16, i17, i18, iArr, 0);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        return this.M.super_dispatchTouchEvent(motionEvent);
    }

    Context e() {
        return this.L.getContext();
    }

    int f() {
        if (this.D) {
            return this.M.computeHorizontalScrollRange();
        }
        return 0;
    }

    public int g() {
        boolean z16 = this.D;
        if (this.E) {
            return (z16 ? 1 : 0) | 2;
        }
        return z16 ? 1 : 0;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i3) {
        return this.f396929m.hasNestedScrollingParent(i3);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f396929m.isNestedScrollingEnabled();
    }

    int l() {
        if (this.E) {
            return this.M.computeVerticalScrollRange();
        }
        return 0;
    }

    void m() {
        this.L.setOverScrollMode(2);
        o();
        this.f396929m = new NestedScrollingChildHelper(this.L);
        setNestedScrollingEnabled(true);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        int action = motionEvent.getAction();
        if (action == 2 && this.C) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 6) {
                            q(motionEvent);
                        }
                    }
                } else {
                    int i16 = this.H;
                    if (i16 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i16);
                        if (findPointerIndex == -1) {
                            QLog.e("NestedScrollX5CallBackClient", 1, "Invalid pointerId=" + i16 + " in onInterceptTouchEvent");
                        } else {
                            int x16 = (int) motionEvent.getX(findPointerIndex);
                            int y16 = (int) motionEvent.getY(findPointerIndex);
                            int abs = Math.abs(x16 - this.f396926f[0]);
                            int abs2 = Math.abs(y16 - this.f396926f[1]);
                            int i17 = this.G;
                            if (abs2 > i17 || abs > i17) {
                                this.C = true;
                                int[] iArr = this.f396926f;
                                iArr[0] = x16;
                                iArr[1] = y16;
                                p();
                                this.F.addMovement(motionEvent);
                                int[] iArr2 = this.f396928i;
                                iArr2[0] = 0;
                                iArr2[1] = 0;
                                ViewParent i18 = i();
                                if (i18 != null) {
                                    i18.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.C = false;
            this.H = -1;
            s();
            if (this.I.springBack(j(), k(), 0, f(), 0, l())) {
                ViewCompat.postInvalidateOnAnimation(view);
            }
            stopNestedScroll();
        } else {
            this.f396926f[0] = (int) motionEvent.getX();
            this.f396926f[1] = (int) motionEvent.getY();
            this.H = motionEvent.getPointerId(0);
            n();
            this.F.addMovement(motionEvent);
            this.I.computeScrollOffset();
            this.C = !this.I.isFinished();
            startNestedScroll(g());
        }
        return this.C;
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view) {
        this.M.super_onOverScrolled(i3, i16, z16, z17);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
        this.M.super_onScrollChanged(i3, i16, i17, i18);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        ViewParent parent;
        float f16;
        float f17;
        boolean z16;
        VelocityTracker velocityTracker;
        boolean z17;
        p();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        boolean z18 = true;
        if (actionMasked == 0) {
            int[] iArr = this.f396928i;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.f396928i;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                q(motionEvent);
                                this.f396926f[0] = (int) motionEvent.getX(motionEvent.findPointerIndex(this.H));
                                this.f396926f[1] = (int) motionEvent.getY(motionEvent.findPointerIndex(this.H));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.f396926f[0] = (int) motionEvent.getX(actionIndex);
                            this.f396926f[1] = (int) motionEvent.getY(actionIndex);
                            this.H = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        if (this.C && this.I.springBack(j(), k(), 0, f(), 0, l())) {
                            ViewCompat.postInvalidateOnAnimation(view);
                        }
                        this.H = -1;
                        c();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.H);
                    if (findPointerIndex < 0) {
                        QLog.e("NestedScrollX5CallBackClient", 1, "Invalid pointerId=" + this.H + " in onTouchEvent");
                        return false;
                    }
                    int x16 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y16 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    int[] iArr3 = this.f396926f;
                    int i3 = iArr3[0] - x16;
                    int i16 = iArr3[1] - y16;
                    if (Math.abs(i3) > this.G && Math.abs(i3) > Math.abs(i16)) {
                        i().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                    if (!this.C) {
                        if (this.D) {
                            if (i3 > 0) {
                                i3 = Math.max(0, i3 - this.G);
                            } else {
                                i3 = Math.min(0, i3 + this.G);
                            }
                            if (i3 != 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                        } else {
                            i3 = 0;
                            z17 = false;
                        }
                        if (this.E) {
                            if (i16 > 0) {
                                i16 = Math.max(0, i16 - this.G);
                            } else {
                                i16 = Math.min(0, i16 + this.G);
                            }
                            if (i16 != 0) {
                                z17 = true;
                            }
                        } else {
                            i16 = 0;
                        }
                        this.C = z17;
                    }
                    int i17 = i16;
                    int i18 = i3;
                    if (this.C) {
                        int[] iArr4 = this.f396925e;
                        iArr4[0] = 0;
                        iArr4[1] = 0;
                        if (dispatchNestedPreScroll(i18, i17, iArr4, this.f396924d, 0)) {
                            int[] iArr5 = this.f396925e;
                            i18 -= iArr5[0];
                            i17 -= iArr5[1];
                            int[] iArr6 = this.f396928i;
                            int i19 = iArr6[0];
                            int[] iArr7 = this.f396924d;
                            iArr6[0] = i19 + iArr7[0];
                            iArr6[1] = iArr6[1] + iArr7[1];
                            i().requestDisallowInterceptTouchEvent(true);
                        }
                        int i26 = i17;
                        int i27 = i18;
                        int[] iArr8 = this.f396926f;
                        int[] iArr9 = this.f396924d;
                        iArr8[0] = x16 - iArr9[0];
                        iArr8[1] = y16 - iArr9[1];
                        int k3 = k();
                        int j3 = j();
                        if (r(i27, i26, j3, k3, f(), l(), 0, 0, true) && !hasNestedScrollingParent(0) && (velocityTracker = this.F) != null) {
                            velocityTracker.clear();
                        }
                        int j16 = j() - j3;
                        int k16 = k() - k3;
                        int[] iArr10 = this.f396925e;
                        iArr10[0] = 0;
                        iArr10[1] = 0;
                        dispatchNestedScroll(j16, k16, i27 - j16, i26 - k16, this.f396924d, 0, iArr10);
                        int[] iArr11 = this.f396925e;
                        if (iArr11[0] == 0 && iArr11[1] == 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        int[] iArr12 = this.f396926f;
                        int i28 = iArr12[0];
                        int[] iArr13 = this.f396924d;
                        iArr12[0] = i28 - iArr13[0];
                        iArr12[1] = iArr12[1] - iArr13[1];
                        int[] iArr14 = this.f396928i;
                        iArr14[0] = iArr14[0] + iArr13[0];
                        iArr14[1] = iArr14[1] + iArr13[1];
                        if (z16 || j16 != 0 || k16 != 0) {
                            i().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            } else {
                this.F.computeCurrentVelocity(1000, this.K);
                if (this.D) {
                    f16 = -this.F.getXVelocity(this.H);
                } else {
                    f16 = 0.0f;
                }
                if (this.E) {
                    f17 = -this.F.getYVelocity(this.H);
                } else {
                    f17 = 0.0f;
                }
                if (!this.D || Math.abs(f16) < this.J) {
                    f16 = 0.0f;
                }
                if (!this.E || Math.abs(f17) < this.J) {
                    f17 = 0.0f;
                }
                if (f16 == 0.0f && f17 == 0.0f) {
                    if (this.I.springBack(j(), k(), 0, f(), 0, l())) {
                        ViewCompat.postInvalidateOnAnimation(view);
                    }
                } else if (!dispatchNestedPreFling(f16, f17)) {
                    if (!this.D && !this.E) {
                        z18 = false;
                    }
                    dispatchNestedFling(f16, f17, z18);
                    if (z18) {
                        d((int) Math.max(-r1, Math.min(f16, this.K)), (int) Math.max(-r1, Math.min(f17, this.K)));
                    }
                }
                this.H = -1;
                c();
            }
        } else {
            if (this.C == (!this.I.isFinished()) && (parent = view.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.I.isFinished()) {
                a();
            }
            this.f396926f[0] = (int) (motionEvent.getX() + 0.5f);
            this.f396926f[1] = (int) (motionEvent.getY() + 0.5f);
            this.H = motionEvent.getPointerId(0);
            startNestedScroll(g(), 0);
        }
        VelocityTracker velocityTracker2 = this.F;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return this.M.super_onTouchEvent(motionEvent);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view) {
        return r(i3, i16, i17, i18, i19, i26, i27, i28, z16);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        this.f396929m.setNestedScrollingEnabled(z16);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i3, int i16) {
        return this.f396929m.startNestedScroll(i3, i16);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        this.f396929m.stopNestedScroll(i3);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2, int i17) {
        return this.f396929m.dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        return this.f396929m.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i3) {
        return startNestedScroll(i3, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, @NonNull int[] iArr2) {
        this.f396929m.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19, iArr2);
    }

    @Override // com.tencent.smtt.sdk.WebViewCallbackClient
    public void invalidate() {
    }
}
