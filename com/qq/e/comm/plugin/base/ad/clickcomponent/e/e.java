package com.qq.e.comm.plugin.base.ad.clickcomponent.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f38687a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f38688b;

    /* renamed from: c, reason: collision with root package name */
    private int f38689c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f38690d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f38691e;

    /* renamed from: f, reason: collision with root package name */
    private f f38692f;

    /* renamed from: g, reason: collision with root package name */
    private IInnerWebView f38693g;

    /* renamed from: h, reason: collision with root package name */
    private View f38694h;

    /* renamed from: i, reason: collision with root package name */
    private View f38695i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f38696j;

    /* renamed from: k, reason: collision with root package name */
    private float f38697k;

    /* renamed from: l, reason: collision with root package name */
    private float f38698l;

    /* renamed from: m, reason: collision with root package name */
    private float f38699m;

    /* renamed from: n, reason: collision with root package name */
    private float f38700n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f38701o;

    /* renamed from: p, reason: collision with root package name */
    private int f38702p;

    public e(Context context) {
        super(context);
        this.f38687a = 0;
        this.f38701o = false;
        this.f38702p = 0;
        this.f38689c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public static boolean a(float f16) {
        return f16 < 0.0f;
    }

    private boolean g() {
        View view;
        boolean z16 = this.f38696j;
        if (!z16 && this.f38693g != null) {
            GDTLogger.d("noCanvasViewScrollY mWebView.getWebScrollY() -> " + this.f38693g.getScrollY());
            if (Math.abs(this.f38693g.getScrollY()) >= 1) {
                return false;
            }
            return true;
        }
        if (z16 && this.f38694h != null && com.qq.e.comm.plugin.c.a.a()) {
            if (Math.abs(com.qq.e.comm.plugin.c.a.b().getPageViewScrollY(this.f38694h)) >= 1) {
                return false;
            }
            return true;
        }
        if (this.f38696j || (view = this.f38695i) == null || Math.abs(view.getScrollY()) >= 1) {
            return false;
        }
        return true;
    }

    public void b() {
        if (this.f38694h != null && com.qq.e.comm.plugin.c.a.a()) {
            com.qq.e.comm.plugin.c.a.b().onActivityResume(this.f38694h);
        }
    }

    public void c() {
        if (this.f38694h != null && com.qq.e.comm.plugin.c.a.a()) {
            com.qq.e.comm.plugin.c.a.b().onActivityPause(this.f38694h);
        }
    }

    public void d() {
        if (this.f38694h != null) {
            if (com.qq.e.comm.plugin.c.a.a()) {
                com.qq.e.comm.plugin.c.a.b().onActivityDestroy(this.f38694h);
            }
            this.f38694h = null;
        }
        IInnerWebView iInnerWebView = this.f38693g;
        if (iInnerWebView != null) {
            iInnerWebView.destroySafely();
            this.f38693g = null;
        }
        if (this.f38695i != null) {
            this.f38695i = null;
        }
    }

    public int e() {
        return this.f38702p;
    }

    public boolean f() {
        IInnerWebView iInnerWebView = this.f38693g;
        if (iInnerWebView != null && iInnerWebView.canGoBack()) {
            this.f38693g.goBack();
            return true;
        }
        IInnerWebView iInnerWebView2 = this.f38693g;
        if (iInnerWebView2 != null && !iInnerWebView2.canGoBack()) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        GDTLogger.d("onInterceptTouchEvent mIgnoreInterceptTouchEvent == " + this.f38690d);
        if (this.f38690d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        GDTLogger.d("onInterceptTouchEvent isAnimating =" + this.f38688b + "mBeingDrag ==" + this.f38701o);
        boolean z17 = true;
        if (this.f38688b || this.f38701o) {
            return true;
        }
        GDTLogger.d("onInterceptTouchEvent mState " + this.f38687a);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                } else {
                    GDTLogger.d("onInterceptTouchEvent ACTION_MOVE mBeingDrag " + this.f38701o);
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f16 = rawX - this.f38698l;
                    float f17 = rawY - this.f38697k;
                    if (Math.abs(f17) <= this.f38689c || Math.abs(f17) <= Math.abs(f16)) {
                        return false;
                    }
                    int i3 = this.f38687a;
                    if (i3 == 0) {
                        if (f17 <= 0.0f) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.f38701o = z16;
                        if (f17 > 0.0f) {
                            z17 = false;
                        }
                        GDTLogger.d("onInterceptTouchEvent ACTION_MOVE mState -> BOTTOM_STATE ");
                    } else {
                        if (i3 != 2) {
                            return false;
                        }
                        if (!this.f38701o && (!g() || a(f17))) {
                            z17 = false;
                        } else {
                            this.f38701o = true;
                        }
                        GDTLogger.d("onInterceptTouchEvent ACTION_MOVE mState -> TOP_STATE, result -> " + z17 + ", noCanvasViewScrollY -> " + g() + ", isScrollUp -> " + a(f17));
                    }
                    return z17;
                }
            }
            GDTLogger.d("onInterceptTouchEvent  ACTION_UP");
            this.f38698l = 0.0f;
            this.f38697k = 0.0f;
            this.f38701o = false;
            return false;
        }
        GDTLogger.d("onInterceptTouchEvent ACTION_DOWN mBeingDrag " + this.f38701o);
        this.f38698l = motionEvent.getRawX();
        this.f38697k = motionEvent.getRawY();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (r0 != 3) goto L34;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f38691e) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.f38688b) {
            return true;
        }
        if (this.f38700n == 0.0f || this.f38699m == 0.0f) {
            this.f38700n = motionEvent.getRawX();
            this.f38699m = motionEvent.getRawY();
            f fVar = this.f38692f;
            if (fVar != null) {
                fVar.a(this.f38687a);
            }
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    GDTLogger.w("onTouchEvent  ACTION_MOVE");
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f16 = rawY - this.f38699m;
                    if (Math.abs(f16) > Math.abs(rawX - this.f38700n)) {
                        if (this.f38692f != null) {
                            GDTLogger.w("onTouchEvent  onDrag");
                            this.f38692f.b((int) f16);
                        }
                        this.f38700n = rawX;
                        this.f38699m = rawY;
                    }
                }
            }
            GDTLogger.w("onTouchEvent  ACTION_UP");
            this.f38700n = 0.0f;
            this.f38699m = 0.0f;
            f fVar2 = this.f38692f;
            if (fVar2 != null) {
                fVar2.c(this.f38687a);
                this.f38701o = false;
            }
        } else {
            GDTLogger.w("onTouchEvent  ACTION_DOWN");
        }
        return true;
    }

    public void a(f fVar, IInnerWebView iInnerWebView) {
        this.f38692f = fVar;
        this.f38693g = iInnerWebView;
        this.f38696j = false;
        if (iInnerWebView == null || iInnerWebView.getView() == null) {
            return;
        }
        addView(this.f38693g.getView(), new RelativeLayout.LayoutParams(-1, -1));
        this.f38702p = 0;
    }

    public void a(f fVar, FrameLayout frameLayout) {
        this.f38692f = fVar;
        this.f38694h = frameLayout;
        this.f38696j = true;
        addView(frameLayout);
        this.f38702p = 1;
    }

    public void a(boolean z16) {
        this.f38690d = z16;
    }

    public IInnerWebView a() {
        return this.f38693g;
    }
}
