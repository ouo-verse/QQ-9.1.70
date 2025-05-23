package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.R;

/* loaded from: classes16.dex */
public class AccountPanelRootLayout extends RelativeLayout {
    private int C;
    private boolean D;
    private View E;

    /* renamed from: d, reason: collision with root package name */
    private float f256386d;

    /* renamed from: e, reason: collision with root package name */
    private float f256387e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f256388f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f256389h;

    /* renamed from: i, reason: collision with root package name */
    private Scroller f256390i;

    /* renamed from: m, reason: collision with root package name */
    private a f256391m;

    /* loaded from: classes16.dex */
    public interface a {
        void a(boolean z16);

        void b();

        void scrollToTop();
    }

    public AccountPanelRootLayout(@NonNull Context context) {
        super(context);
        this.f256386d = 0.0f;
        this.f256387e = 0.0f;
        this.f256388f = false;
        this.f256389h = false;
        this.C = 0;
        this.D = false;
        d();
    }

    private int c() {
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 0) {
                i3 += childAt.getHeight();
            }
        }
        return i3 / 3;
    }

    private void d() {
        this.f256390i = new Scroller(getContext());
        this.C = getResources().getDisplayMetrics().heightPixels;
    }

    private void e() {
        if (this.E == null) {
            this.E = findViewById(R.id.b9j);
        }
    }

    private boolean f(View view, MotionEvent motionEvent) {
        if (this.f256388f) {
            return true;
        }
        if (g(view, motionEvent)) {
            this.f256388f = true;
            return true;
        }
        return false;
    }

    public static boolean g(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i16;
        if (rawY < i16 || rawY > measuredHeight || rawX < i3 || rawX > measuredWidth) {
            return false;
        }
        return true;
    }

    public float a(float f16) {
        int scrollY = (int) (getScrollY() + f16);
        if (scrollY < 0) {
            return f16;
        }
        if (scrollY >= 0) {
            a aVar = this.f256391m;
            if (aVar != null) {
                aVar.scrollToTop();
            }
            return 0 - getScrollY();
        }
        return 0.0f;
    }

    public boolean b(MotionEvent motionEvent) {
        this.f256388f = false;
        float y16 = motionEvent.getY();
        float x16 = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    if (Math.abs(x16 - this.f256387e) > 5.0f || Math.abs(y16 - this.f256386d) > 5.0f) {
                        this.f256389h = true;
                    }
                    this.f256387e = x16;
                    this.f256386d = y16;
                    return true;
                }
            }
            if (this.f256389h) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        this.f256389h = false;
        this.f256386d = y16;
        this.f256387e = x16;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f256390i;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.f256390i.getCurrX(), this.f256390i.getCurrY());
            invalidate();
        } else if (this.D) {
            this.D = false;
            a aVar = this.f256391m;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (r2 != 3) goto L56;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        e();
        if (!f(this.E, motionEvent)) {
            return b(motionEvent);
        }
        float y16 = motionEvent.getY();
        float x16 = motionEvent.getX();
        int action = motionEvent.getAction();
        boolean z17 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f16 = -(y16 - this.f256386d);
                    float f17 = x16 - this.f256387e;
                    this.f256386d = y16;
                    this.f256387e = x16;
                    if ((f16 <= 0.0f || getScrollY() < 0) && Math.abs(f17) <= Math.abs(f16) && this.E.getScrollY() <= 0) {
                        float a16 = a(f16);
                        if (this.f256388f && a16 != 0.0f) {
                            scrollBy(0, (int) a16);
                        } else if (a16 > 0.0f) {
                            scrollBy(0, (int) a16);
                        }
                        if (Math.abs(f16) > 5.0f) {
                            this.f256389h = true;
                        }
                        a aVar = this.f256391m;
                        if (aVar != null) {
                            if (getScrollY() > 0) {
                                z17 = true;
                            }
                            aVar.a(z17);
                        }
                        return true;
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            this.f256388f = false;
            if (!this.f256389h) {
                return super.dispatchTouchEvent(motionEvent);
            }
            motionEvent.setAction(3);
            super.dispatchTouchEvent(motionEvent);
            if ((-getScrollY()) < c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i(0);
            } else if (this.f256391m != null) {
                this.D = true;
                i(-this.C);
            }
            return false;
        }
        this.f256389h = false;
        this.f256386d = motionEvent.getY();
        this.f256387e = motionEvent.getX();
        return super.dispatchTouchEvent(motionEvent);
    }

    @RequiresApi(api = 14)
    public void h() {
        setScrollY(0);
    }

    public void i(int i3) {
        Scroller scroller = this.f256390i;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY());
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAccountPanelRootLayoutListener(a aVar) {
        this.f256391m = aVar;
    }

    public AccountPanelRootLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f256386d = 0.0f;
        this.f256387e = 0.0f;
        this.f256388f = false;
        this.f256389h = false;
        this.C = 0;
        this.D = false;
        d();
    }

    public AccountPanelRootLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f256386d = 0.0f;
        this.f256387e = 0.0f;
        this.f256388f = false;
        this.f256389h = false;
        this.C = 0;
        this.D = false;
        d();
    }
}
