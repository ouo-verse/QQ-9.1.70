package com.tencent.mobileqq.ocr.view.gesture;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.ocr.view.gesture.state.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class GestureFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;
    private final float[] C;
    private MotionEvent D;
    private View E;

    /* renamed from: d, reason: collision with root package name */
    private final GestureProxy f254972d;

    /* renamed from: e, reason: collision with root package name */
    private final Matrix f254973e;

    /* renamed from: f, reason: collision with root package name */
    private final Matrix f254974f;

    /* renamed from: h, reason: collision with root package name */
    private final Matrix f254975h;

    /* renamed from: i, reason: collision with root package name */
    private final Matrix f254976i;

    /* renamed from: m, reason: collision with root package name */
    private final RectF f254977m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements GestureProxy.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GestureFrameLayout.this);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.gesture.GestureProxy.a
        public void a(c cVar, c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar, (Object) cVar2);
            } else {
                GestureFrameLayout.this.c(cVar2);
            }
        }

        @Override // com.tencent.mobileqq.ocr.view.gesture.GestureProxy.a
        public void b(c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            } else {
                GestureFrameLayout.this.c(cVar);
            }
        }
    }

    public GestureFrameLayout(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private MotionEvent a(MotionEvent motionEvent, Matrix matrix) {
        this.C[0] = motionEvent.getX();
        this.C[1] = motionEvent.getY();
        matrix.mapPoints(this.C);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        float[] fArr = this.C;
        obtain.setLocation(fArr[0], fArr[1]);
        return obtain;
    }

    private void b(Rect rect, Matrix matrix) {
        this.f254977m.set(rect.left, rect.top, rect.right, rect.bottom);
        matrix.mapRect(this.f254977m);
        rect.set(Math.round(this.f254977m.left), Math.round(this.f254977m.top), Math.round(this.f254977m.right), Math.round(this.f254977m.bottom));
    }

    protected static int d(int i3, int i16, int i17) {
        if (i17 == -2) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
        }
        return ViewGroup.getChildMeasureSpec(i3, i16, i17);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, view, Integer.valueOf(i3), layoutParams);
        } else {
            if (getChildCount() == 0) {
                super.addView(view, i3, layoutParams);
                return;
            }
            throw new IllegalArgumentException("GestureFrameLayout can contain only one child");
        }
    }

    @TargetApi(16)
    protected void c(c cVar) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) cVar);
            return;
        }
        if (isHardwareAccelerated() && (view = this.E) != null) {
            view.setPivotX(0.0f);
            this.E.setPivotY(0.0f);
            this.E.setScaleX(cVar.i());
            this.E.setScaleY(cVar.i());
            this.E.setTranslationX(cVar.g());
            this.E.setTranslationY(cVar.h());
            this.f254975h.set(cVar.e());
            this.f254975h.invert(this.f254976i);
            if (e().N() != null) {
                e().N().a(this.f254976i);
                return;
            }
            return;
        }
        this.f254973e.set(cVar.e());
        this.f254973e.invert(this.f254974f);
        if (e().N() != null) {
            e().N().a(this.f254974f);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) canvas);
            return;
        }
        canvas.save();
        canvas.concat(this.f254973e);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        this.D = motionEvent;
        MotionEvent a16 = a(motionEvent, this.f254974f);
        try {
            return super.dispatchTouchEvent(a16);
        } finally {
            a16.recycle();
        }
    }

    public GestureProxy e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GestureProxy) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f254972d;
    }

    public void f(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof ViewGroup) {
                f((ViewGroup) childAt);
            } else {
                childAt.invalidate();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewParent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) iArr, (Object) rect);
        }
        b(rect, this.f254973e);
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            view.measure(d(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i16, marginLayoutParams.width), d(i17, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i18, marginLayoutParams.height));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f254972d.t(this, this.D);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        View childAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        if (getChildCount() == 0) {
            childAt = null;
        } else {
            childAt = getChildAt(0);
        }
        this.E = childAt;
        if (childAt != null) {
            this.f254972d.O().G(this.E.getMeasuredWidth(), this.E.getMeasuredHeight());
            this.f254972d.S();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        this.f254972d.O().H((i3 - getPaddingLeft()) - getPaddingRight(), (i16 - getPaddingTop()) - getPaddingBottom());
        this.f254972d.S();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f254972d.F(this, this.D);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        super.requestDisallowInterceptTouchEvent(z16);
        if (z16) {
            MotionEvent obtain = MotionEvent.obtain(this.D);
            obtain.setAction(3);
            this.f254972d.t(this, obtain);
            obtain.recycle();
        }
    }

    public GestureFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public GestureFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f254973e = new Matrix();
        this.f254974f = new Matrix();
        this.f254975h = new Matrix();
        this.f254976i = new Matrix();
        this.f254977m = new RectF();
        this.C = new float[2];
        GestureProxy gestureProxy = new GestureProxy(this);
        this.f254972d = gestureProxy;
        gestureProxy.O().u(context, attributeSet);
        gestureProxy.M(new a());
    }
}
