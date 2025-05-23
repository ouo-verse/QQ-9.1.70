package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusController extends LinearLayout {
    boolean C;
    private int D;
    private boolean E;
    private a F;

    /* renamed from: d, reason: collision with root package name */
    private float f256427d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f256428e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f256429f;

    /* renamed from: h, reason: collision with root package name */
    private Scroller f256430h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f256431i;

    /* renamed from: m, reason: collision with root package name */
    private int f256432m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(boolean z16);

        void b(int i3);

        void scrollToTop();
    }

    public OnlineStatusController(Context context) {
        super(context);
        this.f256427d = -3.4028235E38f;
        this.f256428e = false;
        this.f256429f = true;
        this.f256431i = false;
        this.f256432m = 1;
        this.C = false;
        this.D = 0;
        this.E = false;
    }

    private int b() {
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 0) {
                i3 += childAt.getHeight();
            }
        }
        this.D = i3;
        return i3 / 3;
    }

    private void c() {
        this.f256430h = new Scroller(getContext());
    }

    private boolean d(View view, MotionEvent motionEvent) {
        if (this.f256428e) {
            return true;
        }
        if (this.f256429f && !e(view, motionEvent)) {
            return false;
        }
        this.f256428e = true;
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
        if (this.C) {
            f17 = 0.0f;
        } else {
            f17 = 20.0f;
        }
        int dpToPx = ViewUtils.dpToPx(f17);
        int scrollY = (int) (getScrollY() + f16);
        if (scrollY < dpToPx) {
            return f16;
        }
        if (scrollY < dpToPx) {
            return 0.0f;
        }
        a aVar = this.F;
        if (aVar != null) {
            aVar.scrollToTop();
        }
        return dpToPx - getScrollY();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.f256430h;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.f256430h.getCurrX(), this.f256430h.getCurrY());
            invalidate();
        } else if (this.f256431i) {
            this.f256431i = false;
            a aVar = this.F;
            if (aVar != null) {
                aVar.b(this.f256432m);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if (r2 != 3) goto L53;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17 = false;
        if (!d(getChildAt(0), motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f16 = this.f256427d;
                    if (f16 == -3.4028235E38f) {
                        this.f256427d = y16;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    float f17 = -(y16 - f16);
                    float a16 = a(f17);
                    if (QLog.isColorLevel()) {
                        QLog.d("UUUU", 2, "NKSS=" + a16 + " differ=" + f17);
                    }
                    if (this.f256428e && a16 != 0.0f) {
                        scrollBy(0, (int) a16);
                    } else if (a16 > 0.0f) {
                        scrollBy(0, (int) a16);
                    }
                    if (Math.abs(f17) > 5.0f) {
                        this.E = true;
                    }
                    a aVar = this.F;
                    if (aVar != null) {
                        if (getScrollY() > 0) {
                            z17 = true;
                        }
                        aVar.a(z17);
                    }
                    this.f256427d = y16;
                    return true;
                }
            }
            this.f256428e = false;
            this.f256427d = -3.4028235E38f;
            if (!this.E) {
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
            } else if (this.F != null) {
                this.f256431i = true;
                f(-this.D);
            }
            return false;
        }
        this.E = false;
        this.f256427d = motionEvent.getY();
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void f(int i3) {
        Scroller scroller = this.f256430h;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY());
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    public void setAtPanelTouchListener(a aVar) {
        this.F = aVar;
    }

    public void setDisableMinScrollY(boolean z16) {
        this.C = z16;
    }

    public void setMode(int i3) {
        this.f256432m = i3;
    }

    public OnlineStatusController(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f256427d = -3.4028235E38f;
        this.f256428e = false;
        this.f256429f = true;
        this.f256431i = false;
        this.f256432m = 1;
        this.C = false;
        this.D = 0;
        this.E = false;
        c();
    }

    public OnlineStatusController(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f256427d = -3.4028235E38f;
        this.f256428e = false;
        this.f256429f = true;
        this.f256431i = false;
        this.f256432m = 1;
        this.C = false;
        this.D = 0;
        this.E = false;
        c();
    }
}
