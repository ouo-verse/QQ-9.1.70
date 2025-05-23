package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private byte G;
    private a H;
    private VelocityTracker I;
    private Scroller J;
    private Handler K;
    private View L;
    private View M;
    private View N;
    private ListView P;
    private c Q;

    /* renamed from: d, reason: collision with root package name */
    private final int f302610d;

    /* renamed from: e, reason: collision with root package name */
    private int f302611e;

    /* renamed from: f, reason: collision with root package name */
    private int f302612f;

    /* renamed from: h, reason: collision with root package name */
    private int f302613h;

    /* renamed from: i, reason: collision with root package name */
    private int f302614i;

    /* renamed from: m, reason: collision with root package name */
    private int f302615m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(View view);

        void interceptTouchEvent(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b implements Interpolator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16))).floatValue();
            }
            return (float) (Math.pow(f16 - 1.0d, 5.0d) + 1.0d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        boolean c(MotionEvent motionEvent);

        boolean d(MotionEvent motionEvent);
    }

    public m(Context context, ListView listView, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, listView, cVar);
            return;
        }
        this.D = false;
        this.E = true;
        this.P = listView;
        this.Q = cVar;
        this.J = new Scroller(context, new b());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f302610d = viewConfiguration.getScaledTouchSlop();
        this.f302611e = viewConfiguration.getScaledMinimumFlingVelocity() * 4;
        this.f302613h = -1;
        this.f302615m = -1;
        this.f302614i = -1;
        this.C = -1;
        this.K = new Handler(Looper.getMainLooper(), this);
    }

    private void a(MotionEvent motionEvent) {
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
    }

    private void b() {
        this.K.removeMessages(1);
        this.K.removeMessages(0);
        this.N = null;
    }

    private void c() {
        int e16 = e();
        int scrollX = this.M.getScrollX();
        int i3 = this.f302611e;
        if (e16 > i3) {
            f(this.M);
            return;
        }
        if (e16 < (-i3)) {
            q(this.M);
            return;
        }
        if (e16 > 0 && scrollX < this.f302612f * 0.7f) {
            f(this.M);
            return;
        }
        if (e16 < 0 && scrollX > this.f302612f * 0.3f) {
            q(this.M);
            return;
        }
        if (this.F && scrollX < this.f302612f * 0.7f) {
            f(this.M);
        } else if (scrollX > this.f302612f * 0.3f) {
            q(this.M);
        } else {
            f(this.M);
        }
    }

    private int d(int i3, int i16) {
        if (i3 > 0) {
            return ((int) ((Math.abs(i16) / i3) * 300.0f)) + 50;
        }
        return 300;
    }

    private int e() {
        this.I.computeCurrentVelocity(1000);
        return (int) this.I.getXVelocity();
    }

    private void f(View view) {
        int i3;
        int i16;
        if (view != null) {
            i3 = view.getScrollX();
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            if (view.getTag(-3) instanceof Integer) {
                i16 = ((Integer) view.getTag(-3)).intValue();
            } else {
                i16 = 0;
            }
            View view2 = this.N;
            if (view2 != view && view2 != null) {
                view2.scrollTo(0, 0);
            }
            b();
            this.N = view;
            int i17 = -i3;
            this.J.startScroll(i3, 0, i17, 0, d(i16, i17));
            this.K.sendEmptyMessage(1);
        }
    }

    private boolean h(float f16) {
        if (f16 < this.P.getWidth() - this.f302612f) {
            return true;
        }
        return false;
    }

    private boolean i(View view) {
        if (view != null && view.getScrollX() >= this.f302610d) {
            return true;
        }
        return false;
    }

    private boolean j(float f16, float f17) {
        int i3 = this.f302610d;
        if (f16 <= i3 && f17 <= i3) {
            return false;
        }
        if (f16 > i3 && f17 / f16 < 0.6f) {
            this.G = (byte) 1;
        } else {
            this.G = (byte) 2;
        }
        return true;
    }

    private void m() {
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
    }

    private void o(int i3, int i16, View view, int i17) {
        int scrollX = view.getScrollX() - (i3 - this.f302615m);
        if (scrollX <= i17) {
            if (scrollX < 0) {
                i17 = 0;
            } else {
                i17 = scrollX;
            }
        }
        if (!this.D) {
            a aVar = this.H;
            if (aVar != null) {
                aVar.interceptTouchEvent(true);
            }
            this.D = true;
        }
        view.scrollTo(i17, 0);
    }

    private void q(View view) {
        if (view == null) {
            return;
        }
        int scrollX = view.getScrollX();
        int i3 = this.f302612f;
        if (i3 == 0 && (view.getTag(-3) instanceof Integer)) {
            i3 = ((Integer) view.getTag(-3)).intValue();
        }
        if (scrollX != i3) {
            View view2 = this.N;
            if (view2 != view && view2 != null) {
                view2.scrollTo(0, 0);
            }
            b();
            this.N = view;
            int i16 = i3 - scrollX;
            this.J.startScroll(scrollX, 0, i16, 0, d(i3, i16));
            this.K.sendEmptyMessage(0);
        }
        a aVar = this.H;
        if (aVar != null) {
            aVar.a(view);
        }
        if (AppSetting.f99565y && (view instanceof LinearLayout)) {
            View childAt = ((LinearLayout) view).getChildAt(r9.getChildCount() - 1);
            if (childAt != null) {
                childAt.sendAccessibilityEvent(8);
            }
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!i(this.M)) {
            int firstVisiblePosition = this.P.getFirstVisiblePosition() - this.P.getHeaderViewsCount();
            int lastVisiblePosition = this.P.getLastVisiblePosition();
            while (true) {
                if (firstVisiblePosition > lastVisiblePosition) {
                    break;
                }
                View childAt = this.P.getChildAt(firstVisiblePosition);
                if (i(childAt)) {
                    this.M = childAt;
                    break;
                }
                firstVisiblePosition++;
            }
        }
        f(this.M);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return false;
                }
            } else {
                boolean computeScrollOffset = this.J.computeScrollOffset();
                float currX = this.J.getCurrX();
                View view = this.N;
                if (view != null) {
                    view.scrollTo((int) currX, 0);
                    ListView listView = this.P;
                    if (listView != null) {
                        listView.invalidate();
                    }
                }
                if (computeScrollOffset) {
                    this.K.sendEmptyMessage(1);
                } else {
                    this.N = null;
                }
            }
        } else {
            boolean computeScrollOffset2 = this.J.computeScrollOffset();
            float currX2 = this.J.getCurrX();
            View view2 = this.N;
            if (view2 != null) {
                view2.scrollTo((int) currX2, 0);
                ListView listView2 = this.P;
                if (listView2 != null) {
                    listView2.invalidate();
                }
            }
            if (computeScrollOffset2) {
                this.K.sendEmptyMessage(0);
            } else {
                this.N = null;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        if (r2 != 3) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0062, code lost:
    
        if (r0 < r9.f302613h) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0112, code lost:
    
        if (h(r0) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k(MotionEvent motionEvent) {
        boolean z16;
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.E) {
            return this.Q.d(motionEvent);
        }
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f302612f > 0 && this.G == 0) {
                        j(Math.abs(x16 - this.f302613h), Math.abs(y16 - this.f302614i));
                    }
                    if (this.G == 1) {
                    }
                }
                z16 = false;
            }
            if (this.F) {
                f(this.L);
            }
            this.f302613h = -1;
            this.f302615m = -1;
            this.f302614i = -1;
            this.C = -1;
            z16 = false;
        } else {
            this.G = (byte) 0;
            this.f302613h = x16;
            this.f302615m = x16;
            this.f302614i = y16;
            this.C = y16;
            View view = this.M;
            this.L = view;
            boolean i3 = i(view);
            this.F = i3;
            if (!i3) {
                int firstVisiblePosition = this.P.getFirstVisiblePosition() - this.P.getHeaderViewsCount();
                int lastVisiblePosition = this.P.getLastVisiblePosition();
                while (true) {
                    if (lastVisiblePosition < firstVisiblePosition) {
                        break;
                    }
                    View childAt = this.P.getChildAt(lastVisiblePosition);
                    boolean i16 = i(childAt);
                    this.F = i16;
                    if (i16) {
                        this.L = childAt;
                        break;
                    }
                    lastVisiblePosition--;
                }
            }
            this.f302612f = 0;
            this.M = null;
            int i17 = this.f302614i;
            if (this.P.isOverscrollHeadVisiable()) {
                i17 = this.f302614i + this.P.getScrollY();
            }
            int pointToPosition = this.P.pointToPosition(this.f302613h, i17);
            if (pointToPosition >= 0) {
                ListView listView = this.P;
                View childAt2 = listView.getChildAt(pointToPosition - listView.getFirstVisiblePosition());
                this.M = childAt2;
                if (childAt2 != null && (childAt2.getTag(-3) instanceof Integer)) {
                    this.f302612f = ((Integer) this.M.getTag(-3)).intValue();
                }
            }
            if (this.F) {
                if (this.M == this.L) {
                }
                z16 = true;
            }
            z16 = false;
        }
        if (action == 0 && this.F) {
            a aVar2 = this.H;
            if (aVar2 != null) {
                aVar2.interceptTouchEvent(true);
            }
            b();
        } else if ((action == 1 || action == 3) && (aVar = this.H) != null) {
            aVar.interceptTouchEvent(false);
        }
        if (!z16) {
            return this.Q.d(motionEvent);
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (r2 != 3) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean l(MotionEvent motionEvent) {
        boolean z16;
        View view;
        a aVar;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.E) {
            return this.Q.c(motionEvent);
        }
        a(motionEvent);
        int x16 = (int) (motionEvent.getX() + 0.5f);
        int y16 = (int) (motionEvent.getY() + 0.5f);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.F) {
                        if (this.M == this.L && !h(x16)) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (this.M == this.L) {
                            if (this.G != 0 || j(Math.abs(x16 - this.f302613h), Math.abs(y16 - this.f302614i))) {
                                if (this.G == 1) {
                                    o(x16, y16, this.M, this.f302612f);
                                    z16 = true;
                                }
                            }
                        }
                        this.f302615m = x16;
                        this.C = y16;
                    } else {
                        if (this.f302612f != 0) {
                            if (this.G != 0 || j(Math.abs(x16 - this.f302613h), Math.abs(y16 - this.f302614i))) {
                                if (this.G == 1) {
                                    o(x16, y16, this.M, this.f302612f);
                                    z16 = true;
                                    this.f302615m = x16;
                                    this.C = y16;
                                }
                            }
                        }
                        z16 = false;
                        this.f302615m = x16;
                        this.C = y16;
                    }
                }
                z16 = false;
            }
            if (this.F) {
                if (this.M == this.L && !h(x16)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                View view2 = this.M;
                if (view2 == this.L) {
                    if (this.G == 1) {
                        c();
                        z16 = true;
                        m();
                        this.f302613h = -1;
                        this.f302615m = -1;
                        this.f302614i = -1;
                        this.C = -1;
                    } else {
                        f(view2);
                    }
                }
                z16 = z17;
                m();
                this.f302613h = -1;
                this.f302615m = -1;
                this.f302614i = -1;
                this.C = -1;
            } else if (this.f302612f != 0 && this.G == 1) {
                c();
                z16 = true;
                m();
                this.f302613h = -1;
                this.f302615m = -1;
                this.f302614i = -1;
                this.C = -1;
            } else {
                z16 = false;
                m();
                this.f302613h = -1;
                this.f302615m = -1;
                this.f302614i = -1;
                this.C = -1;
            }
        } else {
            if (this.F && (this.M != this.L || h(x16))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.F && (view = this.L) != this.M) {
                f(view);
            }
        }
        if (action == 0 && this.F) {
            a aVar2 = this.H;
            if (aVar2 != null) {
                aVar2.interceptTouchEvent(true);
            }
        } else if ((action == 1 || action == 3) && (aVar = this.H) != null) {
            aVar.interceptTouchEvent(false);
            this.D = false;
        }
        if (!z16) {
            return this.Q.c(motionEvent);
        }
        return z16;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.P = null;
            this.H = null;
        }
    }

    public void p(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.H = aVar;
        }
    }
}
