package com.tencent.mobileqq.together.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes9.dex */
public class TogetherPanelTouchController extends LinearLayout {
    private Scroller C;
    private AtPanelTouchController.a D;
    private int E;
    private boolean F;
    boolean G;
    private View H;

    /* renamed from: d, reason: collision with root package name */
    private float f293388d;

    /* renamed from: e, reason: collision with root package name */
    private float f293389e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f293390f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f293391h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f293392i;

    /* renamed from: m, reason: collision with root package name */
    private int f293393m;

    public TogetherPanelTouchController(@NonNull Context context) {
        super(context);
        this.f293388d = -3.4028235E38f;
        this.f293389e = 0.0f;
        this.f293390f = false;
        this.f293391h = true;
        this.f293392i = false;
        this.f293393m = 1;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = null;
        c();
    }

    private int b() {
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 0) {
                i3 += childAt.getHeight();
            }
        }
        this.E = i3;
        return i3 / 3;
    }

    private void c() {
        this.C = new Scroller(getContext());
    }

    private boolean d(View view, MotionEvent motionEvent) {
        if (this.f293390f) {
            return true;
        }
        if (this.f293391h && !e(view, motionEvent)) {
            return false;
        }
        this.f293390f = true;
        return true;
    }

    public static boolean e(View view, MotionEvent motionEvent) {
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
        float f17;
        if (this.G) {
            f17 = 0.0f;
        } else {
            f17 = 20.0f;
        }
        int f18 = BaseAIOUtils.f(f17, getContext().getResources());
        int scrollY = (int) (getScrollY() + f16);
        if (scrollY < f18) {
            return f16;
        }
        if (scrollY < f18) {
            return 0.0f;
        }
        AtPanelTouchController.a aVar = this.D;
        if (aVar != null) {
            aVar.scrollToTop();
        }
        return f18 - getScrollY();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.C;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.C.getCurrX(), this.C.getCurrY());
            invalidate();
        } else if (this.F) {
            this.F = false;
            AtPanelTouchController.a aVar = this.D;
            if (aVar != null) {
                aVar.b(this.f293393m);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r3 != 3) goto L59;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        View view = this.H;
        boolean z17 = false;
        if (view == null) {
            view = getChildAt(0);
        }
        if (!d(view, motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float y16 = motionEvent.getY();
        float x16 = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f16 = this.f293388d;
                    if (f16 == -3.4028235E38f) {
                        this.f293388d = y16;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    float f17 = x16 - f16;
                    float f18 = -(y16 - f16);
                    if (Math.abs(f17) > Math.abs(f18)) {
                        this.f293389e = x16;
                        super.dispatchTouchEvent(motionEvent);
                    }
                    float a16 = a(f18);
                    if (QLog.isColorLevel()) {
                        QLog.d("UUUU", 2, "NKSS=" + a16 + " differ=" + f18);
                    }
                    if (this.f293390f && a16 != 0.0f) {
                        scrollBy(0, (int) a16);
                    } else if (a16 > 0.0f) {
                        scrollBy(0, (int) a16);
                    }
                    if (Math.abs(f18) > 5.0f) {
                        this.f293392i = true;
                    }
                    AtPanelTouchController.a aVar = this.D;
                    if (aVar != null) {
                        if (getScrollY() > 0) {
                            z17 = true;
                        }
                        aVar.a(z17);
                    }
                    this.f293388d = y16;
                    this.f293389e = x16;
                    return true;
                }
            }
            this.f293390f = false;
            this.f293388d = -3.4028235E38f;
            if (!this.f293392i) {
                return super.dispatchTouchEvent(motionEvent);
            }
            motionEvent.setAction(3);
            super.dispatchTouchEvent(motionEvent);
            if ((-getScrollY()) < b()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                f(0);
            } else if (this.D != null) {
                this.F = true;
                f(-this.E);
            }
            return false;
        }
        this.f293392i = false;
        this.f293388d = motionEvent.getY();
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void f(int i3) {
        Scroller scroller = this.C;
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

    public void setAtPanelTouchListener(AtPanelTouchController.a aVar) {
        this.D = aVar;
    }

    public void setControlLitTongue(boolean z16) {
        this.f293391h = z16;
    }

    public void setDisableMinScrollY(boolean z16) {
        this.G = z16;
    }

    public void setHeadView(View view) {
        this.H = view;
    }

    public void setMode(int i3) {
        this.f293393m = i3;
    }

    public TogetherPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f293388d = -3.4028235E38f;
        this.f293389e = 0.0f;
        this.f293390f = false;
        this.f293391h = true;
        this.f293392i = false;
        this.f293393m = 1;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = null;
        c();
    }

    public TogetherPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f293388d = -3.4028235E38f;
        this.f293389e = 0.0f;
        this.f293390f = false;
        this.f293391h = true;
        this.f293392i = false;
        this.f293393m = 1;
        this.E = 0;
        this.F = false;
        this.G = false;
        this.H = null;
        c();
    }
}
