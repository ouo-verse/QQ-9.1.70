package com.tencent.mobileqq.wink.editor.music.lyric.interaction;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper;
import com.tencent.mobileqq.wink.j;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes21.dex */
public class WinkSlidingUpPanelLayout extends ViewGroup {

    /* renamed from: i0, reason: collision with root package name */
    private static PanelState f320943i0 = PanelState.COLLAPSED;

    /* renamed from: j0, reason: collision with root package name */
    private static final int[] f320944j0 = {R.attr.gravity};
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private View G;
    private int H;
    private View I;
    private int J;
    private com.tencent.mobileqq.wink.editor.music.lyric.interaction.b K;
    private View L;
    private View M;
    private PanelState N;
    private PanelState P;
    private float Q;
    private int R;
    private float S;
    private boolean T;
    private boolean U;
    private float V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private float f320945a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f320946b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f320947c0;

    /* renamed from: d, reason: collision with root package name */
    private int f320948d;

    /* renamed from: d0, reason: collision with root package name */
    private final List<d> f320949d0;

    /* renamed from: e, reason: collision with root package name */
    private int f320950e;

    /* renamed from: e0, reason: collision with root package name */
    private View.OnClickListener f320951e0;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f320952f;

    /* renamed from: f0, reason: collision with root package name */
    private final ViewDragHelper f320953f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f320954g0;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f320955h;

    /* renamed from: h0, reason: collision with root package name */
    private final Rect f320956h0;

    /* renamed from: i, reason: collision with root package name */
    private int f320957i;

    /* renamed from: m, reason: collision with root package name */
    private int f320958m;

    /* loaded from: classes21.dex */
    public enum PanelState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WinkSlidingUpPanelLayout.this.isEnabled() && WinkSlidingUpPanelLayout.this.y()) {
                PanelState panelState = WinkSlidingUpPanelLayout.this.N;
                PanelState panelState2 = PanelState.EXPANDED;
                if (panelState != panelState2) {
                    PanelState panelState3 = WinkSlidingUpPanelLayout.this.N;
                    PanelState panelState4 = PanelState.ANCHORED;
                    if (panelState3 != panelState4) {
                        if (WinkSlidingUpPanelLayout.this.S < 1.0f) {
                            WinkSlidingUpPanelLayout.this.setPanelState(panelState4);
                        } else {
                            WinkSlidingUpPanelLayout.this.setPanelState(panelState2);
                        }
                    }
                }
                WinkSlidingUpPanelLayout.this.setPanelState(PanelState.COLLAPSED);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f320962a;

        static {
            int[] iArr = new int[PanelState.values().length];
            f320962a = iArr;
            try {
                iArr[PanelState.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f320962a[PanelState.ANCHORED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f320962a[PanelState.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f320962a[PanelState.COLLAPSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes21.dex */
    private class c extends ViewDragHelper.b {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper.b
        public int b(View view, int i3, int i16) {
            int q16 = WinkSlidingUpPanelLayout.this.q(0.0f);
            int q17 = WinkSlidingUpPanelLayout.this.q(1.0f);
            if (WinkSlidingUpPanelLayout.this.D) {
                return Math.min(Math.max(i3, q17), q16);
            }
            return Math.min(Math.max(i3, q16), q17);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper.b
        public int e(View view) {
            return WinkSlidingUpPanelLayout.this.R;
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper.b
        public void i(View view, int i3) {
            WinkSlidingUpPanelLayout.this.B();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper.b
        public void j(int i3) {
            if (WinkSlidingUpPanelLayout.this.f320953f0 != null && WinkSlidingUpPanelLayout.this.f320953f0.w() == 0) {
                WinkSlidingUpPanelLayout winkSlidingUpPanelLayout = WinkSlidingUpPanelLayout.this;
                winkSlidingUpPanelLayout.Q = winkSlidingUpPanelLayout.r(winkSlidingUpPanelLayout.L.getTop());
                WinkSlidingUpPanelLayout.this.p();
                if (f73.a.a(WinkSlidingUpPanelLayout.this.Q, 1.0f)) {
                    WinkSlidingUpPanelLayout.this.F();
                    WinkSlidingUpPanelLayout.this.C(PanelState.EXPANDED);
                } else if (f73.a.a(WinkSlidingUpPanelLayout.this.Q, 0.0f)) {
                    WinkSlidingUpPanelLayout.this.C(PanelState.COLLAPSED);
                } else if (WinkSlidingUpPanelLayout.this.Q < 0.0f) {
                    WinkSlidingUpPanelLayout.this.C(PanelState.HIDDEN);
                    WinkSlidingUpPanelLayout.this.L.setVisibility(4);
                } else {
                    WinkSlidingUpPanelLayout.this.F();
                    WinkSlidingUpPanelLayout.this.C(PanelState.ANCHORED);
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper.b
        public void k(View view, int i3, int i16, int i17, int i18) {
            WinkSlidingUpPanelLayout.this.A(i16);
            WinkSlidingUpPanelLayout.this.invalidate();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper.b
        public void l(View view, float f16, float f17) {
            int q16;
            if (WinkSlidingUpPanelLayout.this.D) {
                f17 = -f17;
            }
            if (f17 > 0.0f && WinkSlidingUpPanelLayout.this.Q <= WinkSlidingUpPanelLayout.this.S) {
                WinkSlidingUpPanelLayout winkSlidingUpPanelLayout = WinkSlidingUpPanelLayout.this;
                q16 = winkSlidingUpPanelLayout.q(winkSlidingUpPanelLayout.S);
            } else if (f17 > 0.0f && WinkSlidingUpPanelLayout.this.Q > WinkSlidingUpPanelLayout.this.S) {
                q16 = WinkSlidingUpPanelLayout.this.q(1.0f);
            } else if (f17 < 0.0f && WinkSlidingUpPanelLayout.this.Q >= WinkSlidingUpPanelLayout.this.S) {
                WinkSlidingUpPanelLayout winkSlidingUpPanelLayout2 = WinkSlidingUpPanelLayout.this;
                q16 = winkSlidingUpPanelLayout2.q(winkSlidingUpPanelLayout2.S);
            } else if (f17 < 0.0f && WinkSlidingUpPanelLayout.this.Q < WinkSlidingUpPanelLayout.this.S) {
                q16 = WinkSlidingUpPanelLayout.this.q(0.0f);
            } else if (WinkSlidingUpPanelLayout.this.Q >= (WinkSlidingUpPanelLayout.this.S + 1.0f) / 2.0f) {
                q16 = WinkSlidingUpPanelLayout.this.q(1.0f);
            } else if (WinkSlidingUpPanelLayout.this.Q < WinkSlidingUpPanelLayout.this.S / 2.0f) {
                q16 = WinkSlidingUpPanelLayout.this.q(0.0f);
            } else {
                WinkSlidingUpPanelLayout winkSlidingUpPanelLayout3 = WinkSlidingUpPanelLayout.this;
                q16 = winkSlidingUpPanelLayout3.q(winkSlidingUpPanelLayout3.S);
            }
            if (WinkSlidingUpPanelLayout.this.f320953f0 != null) {
                WinkSlidingUpPanelLayout.this.f320953f0.O(view.getLeft(), q16);
            }
            WinkSlidingUpPanelLayout.this.invalidate();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.interaction.ViewDragHelper.b
        public boolean m(View view, int i3) {
            if (!WinkSlidingUpPanelLayout.this.T && view != null && view.equals(WinkSlidingUpPanelLayout.this.L)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes21.dex */
    public interface d {
        void b(View view, PanelState panelState, PanelState panelState2);

        void onPanelSlide(View view, float f16);
    }

    public WinkSlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i3) {
        LayoutParams layoutParams;
        int height;
        PanelState panelState = this.N;
        PanelState panelState2 = PanelState.DRAGGING;
        if (panelState != panelState2) {
            this.P = panelState;
        }
        C(panelState2);
        this.Q = r(i3);
        p();
        s(this.L);
        ViewGroup.LayoutParams layoutParams2 = this.M.getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            return;
        }
        int height2 = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.f320957i;
        if (this.Q <= 0.0f && !this.E) {
            if (this.D) {
                height = i3 - getPaddingBottom();
            } else {
                height = ((getHeight() - getPaddingBottom()) - this.L.getMeasuredHeight()) - i3;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).height = height;
            if (height == height2) {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
            }
            this.M.requestLayout();
            return;
        }
        if (((ViewGroup.MarginLayoutParams) layoutParams).height != -1 && !this.E) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
            this.M.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(PanelState panelState) {
        PanelState panelState2 = this.N;
        if (panelState2 == panelState) {
            return;
        }
        this.N = panelState;
        t(this, panelState2, panelState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void p() {
        if (this.C > 0) {
            ViewCompat.setTranslationY(this.M, u());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q(float f16) {
        int i3;
        View view = this.L;
        if (view != null) {
            i3 = view.getMeasuredHeight();
        } else {
            i3 = 0;
        }
        int i16 = (int) (f16 * this.R);
        if (this.D) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.f320957i) - i16;
        }
        return (getPaddingTop() - i3) + this.f320957i + i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float r(int i3) {
        float f16;
        int i16;
        int q16 = q(0.0f);
        if (this.D) {
            f16 = q16 - i3;
            i16 = this.R;
        } else {
            f16 = i3 - q16;
            i16 = this.R;
        }
        return f16 / i16;
    }

    private static boolean x(View view) {
        Drawable background = view.getBackground();
        if (background != null && background.getOpacity() == -1) {
            return true;
        }
        return false;
    }

    private boolean z(View view, int i3, int i16) {
        int i17;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i18 = iArr2[0] + i3;
        int i19 = iArr2[1] + i16;
        int i26 = iArr[0];
        if (i18 < i26 || i18 >= i26 + view.getWidth() || i19 < (i17 = iArr[1]) || i19 >= i17 + view.getHeight()) {
            return false;
        }
        return true;
    }

    void B() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    boolean D(float f16, int i3) {
        if (isEnabled() && this.L != null) {
            int q16 = q(f16);
            ViewDragHelper viewDragHelper = this.f320953f0;
            View view = this.L;
            if (viewDragHelper.Q(view, view.getLeft(), q16)) {
                B();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
        }
        return false;
    }

    protected void E() {
        D(0.0f, 0);
    }

    void F() {
        int i3;
        int i16;
        int i17;
        int i18;
        if (getChildCount() == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View view = this.L;
        int i19 = 0;
        if (view != null && x(view)) {
            i3 = this.L.getLeft();
            i16 = this.L.getRight();
            i17 = this.L.getTop();
            i18 = this.L.getBottom();
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
        }
        View childAt = getChildAt(0);
        int max = Math.max(paddingLeft, childAt.getLeft());
        int max2 = Math.max(paddingTop, childAt.getTop());
        int min = Math.min(width, childAt.getRight());
        int min2 = Math.min(height, childAt.getBottom());
        if (max >= i3 && max2 >= i17 && min <= i16 && min2 <= i18) {
            i19 = 4;
        }
        childAt.setVisibility(i19);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.f320953f0;
        if (viewDragHelper != null && viewDragHelper.l(true)) {
            if (!isEnabled()) {
                this.f320953f0.a();
            } else {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i3;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (isEnabled() && y() && (!this.T || actionMasked == 0)) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (actionMasked == 0) {
                this.f320947c0 = false;
                this.V = x16;
                this.W = y16;
            } else if (actionMasked == 2) {
                float f16 = x16 - this.V;
                float f17 = y16 - this.W;
                this.V = x16;
                this.W = y16;
                if (Math.abs(f16) > Math.abs(f17)) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (!z(this.I, (int) this.f320945a0, (int) this.f320946b0)) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                boolean z16 = this.D;
                int i16 = -1;
                if (z16) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                if (i3 * f17 > 0.0f) {
                    if (this.K.a(this.I, z16) > 0) {
                        this.f320947c0 = true;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.f320947c0) {
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction(3);
                        super.dispatchTouchEvent(obtain);
                        obtain.recycle();
                        motionEvent.setAction(0);
                    }
                    this.f320947c0 = false;
                    return onTouchEvent(motionEvent);
                }
                if (z16) {
                    i16 = 1;
                }
                if (f17 * i16 < 0.0f) {
                    if (this.Q < 1.0f) {
                        this.f320947c0 = false;
                        return onTouchEvent(motionEvent);
                    }
                    if (!this.f320947c0 && this.f320953f0.y()) {
                        this.f320953f0.b();
                        motionEvent.setAction(0);
                    }
                    this.f320947c0 = true;
                    return super.dispatchTouchEvent(motionEvent);
                }
            } else if (actionMasked == 1 && this.f320947c0) {
                this.f320953f0.M(0);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        this.f320953f0.a();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        View view;
        int bottom;
        int bottom2;
        super.draw(canvas);
        if (this.f320955h != null && (view = this.L) != null) {
            int right = view.getRight();
            if (this.D) {
                bottom = this.L.getTop() - this.f320958m;
                bottom2 = this.L.getTop();
            } else {
                bottom = this.L.getBottom();
                bottom2 = this.L.getBottom() + this.f320958m;
            }
            this.f320955h.setBounds(this.L.getLeft(), bottom, right, bottom2);
            this.f320955h.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        boolean drawChild;
        int save = canvas.save();
        View view2 = this.L;
        if (view2 != null && !view2.equals(view)) {
            canvas.getClipBounds(this.f320956h0);
            if (!this.E) {
                if (this.D) {
                    Rect rect = this.f320956h0;
                    rect.bottom = Math.min(rect.bottom, this.L.getTop());
                } else {
                    Rect rect2 = this.f320956h0;
                    rect2.top = Math.max(rect2.top, this.L.getBottom());
                }
            }
            if (this.F) {
                canvas.clipRect(this.f320956h0);
            }
            drawChild = super.drawChild(canvas, view, j3);
            int i3 = this.f320950e;
            if (i3 != 0) {
                float f16 = this.Q;
                if (f16 > 0.0f) {
                    this.f320952f.setColor((i3 & 16777215) | (((int) ((((-16777216) & i3) >>> 24) * f16)) << 24));
                    canvas.drawRect(this.f320956h0, this.f320952f);
                }
            }
        } else {
            drawChild = super.drawChild(canvas, view, j3);
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public void o(d dVar) {
        if (dVar != null) {
            this.f320949d0.add(dVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f320954g0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f320954g0 = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.H;
        if (i3 != -1) {
            setDragView(findViewById(i3));
        }
        int i16 = this.J;
        if (i16 != -1) {
            setScrollableView(findViewById(i16));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        if (r0 != 3) goto L41;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f320947c0 && y()) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            float abs = Math.abs(x16 - this.f320945a0);
            float abs2 = Math.abs(y16 - this.f320946b0);
            int v3 = this.f320953f0.v();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (abs2 > v3 && abs > abs2) {
                            this.f320953f0.b();
                            this.T = true;
                            return false;
                        }
                    }
                }
                if (this.f320953f0.y()) {
                    this.f320953f0.H(motionEvent);
                    return true;
                }
                float f16 = v3;
                if (abs2 <= f16 && abs <= f16 && this.Q > 0.0f && !z(this.L, (int) this.f320945a0, (int) this.f320946b0) && this.f320951e0 != null) {
                    playSoundEffect(0);
                    this.f320951e0.onClick(this);
                    return true;
                }
            } else {
                this.T = false;
                this.f320945a0 = x16;
                this.f320946b0 = y16;
                if (!z(this.G, (int) x16, (int) y16)) {
                    this.f320953f0.b();
                    this.T = true;
                    return false;
                }
            }
            return this.f320953f0.P(motionEvent);
        }
        this.f320953f0.a();
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        LayoutParams layoutParams;
        int i19;
        int i26;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f320954g0) {
            int i27 = b.f320962a[this.N.ordinal()];
            if (i27 != 1) {
                if (i27 != 2) {
                    if (i27 != 3) {
                        this.Q = 0.0f;
                    } else {
                        int q16 = q(0.0f);
                        if (this.D) {
                            i26 = this.f320957i;
                        } else {
                            i26 = -this.f320957i;
                        }
                        this.Q = r(q16 + i26);
                    }
                } else {
                    this.Q = this.S;
                }
            } else {
                this.Q = 1.0f;
            }
        }
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = getChildAt(i28);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                if (layoutParams2 instanceof LayoutParams) {
                    layoutParams = (LayoutParams) layoutParams2;
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null && (childAt.getVisibility() != 8 || (i28 != 0 && !this.f320954g0))) {
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (childAt.equals(this.L)) {
                        i19 = q(this.Q);
                    } else {
                        i19 = paddingTop;
                    }
                    if (!this.D && childAt.equals(this.M) && !this.E) {
                        i19 = q(this.Q) + this.L.getMeasuredHeight();
                    }
                    int i29 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                    childAt.layout(i29, i19, childAt.getMeasuredWidth() + i29, measuredHeight + i19);
                }
            }
        }
        if (this.f320954g0) {
            F();
        }
        p();
        this.f320954g0 = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        LayoutParams layoutParams;
        int i17;
        int i18;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (mode2 != 1073741824 && mode2 != Integer.MIN_VALUE) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int childCount = getChildCount();
        if (childCount == 2) {
            this.M = getChildAt(0);
            View childAt = getChildAt(1);
            this.L = childAt;
            if (this.G == null) {
                setDragView(childAt);
            }
            if (this.L.getVisibility() != 0) {
                this.N = PanelState.HIDDEN;
            }
            int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            for (int i19 = 0; i19 < childCount; i19++) {
                View childAt2 = getChildAt(i19);
                if (childAt2 != null && (layoutParams = (LayoutParams) childAt2.getLayoutParams()) != null && (childAt2.getVisibility() != 8 || i19 != 0)) {
                    if (childAt2.equals(this.M)) {
                        if (!this.E && this.N != PanelState.HIDDEN) {
                            i17 = paddingTop - this.f320957i;
                        } else {
                            i17 = paddingTop;
                        }
                        i18 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    } else {
                        if (childAt2.equals(this.L)) {
                            i17 = paddingTop - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        } else {
                            i17 = paddingTop;
                        }
                        i18 = paddingLeft;
                    }
                    int i26 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    if (i26 == -2) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, Integer.MIN_VALUE);
                    } else if (i26 == -1) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                    } else {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i26, 1073741824);
                    }
                    int i27 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    if (i27 == -2) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE);
                    } else {
                        float f16 = layoutParams.f320960a;
                        if (f16 > 0.0f && f16 < 1.0f) {
                            i17 = (int) (i17 * f16);
                        } else if (i27 != -1) {
                            i17 = i27;
                        }
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
                    }
                    childAt2.measure(makeMeasureSpec, makeMeasureSpec2);
                    if (childAt2.equals(this.L)) {
                        this.R = this.L.getMeasuredHeight() - this.f320957i;
                    }
                }
            }
            setMeasuredDimension(size, size2);
            return;
        }
        throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            PanelState panelState = (PanelState) bundle.getSerializable("sliding_state");
            this.N = panelState;
            if (panelState == null) {
                panelState = f320943i0;
            }
            this.N = panelState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        PanelState panelState = this.N;
        if (panelState == PanelState.DRAGGING) {
            panelState = this.P;
        }
        bundle.putSerializable("sliding_state", panelState);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i16 != i18) {
            this.f320954g0 = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && y()) {
            try {
                this.f320953f0.H(motionEvent);
                if (this.N == PanelState.COLLAPSED) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    void s(View view) {
        Iterator<d> it = this.f320949d0.iterator();
        while (it.hasNext()) {
            it.next().onPanelSlide(view, this.Q);
        }
    }

    public void setAnchorPoint(float f16) {
        if (f16 > 0.0f && f16 <= 1.0f) {
            this.S = f16;
            this.f320954g0 = true;
            requestLayout();
        }
    }

    public void setDragView(View view) {
        View view2 = this.G;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        this.G = view;
        if (view != null) {
            view.setClickable(true);
            this.G.setFocusable(false);
            this.G.setFocusableInTouchMode(false);
            this.G.setOnClickListener(new a());
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.f320951e0 = onClickListener;
    }

    public void setGravity(int i3) {
        boolean z16;
        if (i3 != 48 && i3 != 80) {
            throw new IllegalArgumentException("gravity must be set to either top or bottom");
        }
        if (i3 == 80) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.D = z16;
        if (!this.f320954g0) {
            requestLayout();
        }
    }

    public void setPanelHeight(int i3) {
        if (v() == i3) {
            return;
        }
        this.f320957i = i3;
        if (!this.f320954g0) {
            requestLayout();
        }
        if (w() == PanelState.COLLAPSED) {
            E();
            invalidate();
        }
    }

    public void setPanelState(PanelState panelState) {
        PanelState panelState2;
        PanelState panelState3;
        int i3;
        if (this.f320953f0.w() == 2) {
            Log.d("SlidingUpPanelLayout", "View is settling. Aborting animation.");
            this.f320953f0.a();
        }
        if (panelState != null && panelState != (panelState2 = PanelState.DRAGGING)) {
            if (isEnabled()) {
                boolean z16 = this.f320954g0;
                if ((z16 || this.L != null) && panelState != (panelState3 = this.N) && panelState3 != panelState2) {
                    if (z16) {
                        C(panelState);
                        return;
                    }
                    if (panelState3 == PanelState.HIDDEN) {
                        this.L.setVisibility(0);
                        requestLayout();
                    }
                    int i16 = b.f320962a[panelState.ordinal()];
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 == 4) {
                                    D(0.0f, 0);
                                    return;
                                }
                                return;
                            } else {
                                int q16 = q(0.0f);
                                if (this.D) {
                                    i3 = this.f320957i;
                                } else {
                                    i3 = -this.f320957i;
                                }
                                D(r(q16 + i3), 0);
                                return;
                            }
                        }
                        D(this.S, 0);
                        return;
                    }
                    D(1.0f, 0);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
    }

    public void setScrollableView(View view) {
        this.I = view;
    }

    public void setShadowHeight(int i3) {
        this.f320958m = i3;
        if (!this.f320954g0) {
            invalidate();
        }
    }

    void t(View view, PanelState panelState, PanelState panelState2) {
        Iterator<d> it = this.f320949d0.iterator();
        while (it.hasNext()) {
            it.next().b(view, panelState, panelState2);
        }
        sendAccessibilityEvent(32);
    }

    public int u() {
        int max = (int) (this.C * Math.max(this.Q, 0.0f));
        if (this.D) {
            return -max;
        }
        return max;
    }

    public int v() {
        return this.f320957i;
    }

    public PanelState w() {
        return this.N;
    }

    public boolean y() {
        if (this.U && this.L != null && this.N != PanelState.HIDDEN) {
            return true;
        }
        return false;
    }

    /* loaded from: classes21.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: b, reason: collision with root package name */
        private static final int[] f320959b = {R.attr.layout_weight};

        /* renamed from: a, reason: collision with root package name */
        public float f320960a;

        public LayoutParams() {
            super(-1, -1);
            this.f320960a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f320960a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f320960a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f320960a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f320959b);
            if (obtainStyledAttributes != null) {
                this.f320960a = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }

    public WinkSlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WinkSlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Interpolator interpolator;
        this.f320948d = 400;
        this.f320950e = 0;
        this.f320952f = new Paint();
        this.f320957i = -1;
        this.f320958m = -1;
        this.C = -1;
        this.E = false;
        this.F = true;
        this.H = -1;
        this.K = new com.tencent.mobileqq.wink.editor.music.lyric.interaction.b();
        PanelState panelState = f320943i0;
        this.N = panelState;
        this.P = panelState;
        this.S = 1.0f;
        this.f320947c0 = false;
        this.f320949d0 = new CopyOnWriteArrayList();
        this.f320954g0 = true;
        this.f320956h0 = new Rect();
        if (isInEditMode()) {
            this.f320955h = null;
            this.f320953f0 = null;
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f320944j0);
            if (obtainStyledAttributes != null) {
                setGravity(obtainStyledAttributes.getInt(0, 0));
                obtainStyledAttributes.recycle();
            }
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, j.Y9);
            if (obtainStyledAttributes2 != null) {
                try {
                    this.f320957i = obtainStyledAttributes2.getDimensionPixelSize(j.f323167ga, -1);
                    this.f320958m = obtainStyledAttributes2.getDimensionPixelSize(j.f323212ka, -1);
                    this.C = obtainStyledAttributes2.getDimensionPixelSize(j.f323179ha, -1);
                    this.f320948d = obtainStyledAttributes2.getInt(j.f323131da, 400);
                    this.f320950e = obtainStyledAttributes2.getColor(j.f323119ca, 0);
                    this.H = obtainStyledAttributes2.getResourceId(j.f323107ba, -1);
                    this.J = obtainStyledAttributes2.getResourceId(j.f323201ja, -1);
                    this.E = obtainStyledAttributes2.getBoolean(j.f323155fa, false);
                    this.F = obtainStyledAttributes2.getBoolean(j.f323095aa, true);
                    this.S = obtainStyledAttributes2.getFloat(j.Z9, 1.0f);
                    this.N = PanelState.values()[obtainStyledAttributes2.getInt(j.f323143ea, f320943i0.ordinal())];
                    int resourceId = obtainStyledAttributes2.getResourceId(j.f323190ia, -1);
                    interpolator = resourceId != -1 ? AnimationUtils.loadInterpolator(context, resourceId) : null;
                } catch (Throwable th5) {
                    try {
                        ms.a.e("SlidingUpPanelLayout", th5);
                        obtainStyledAttributes2.recycle();
                    } finally {
                        obtainStyledAttributes2.recycle();
                    }
                }
                float f16 = context.getResources().getDisplayMetrics().density;
                if (this.f320957i == -1) {
                    this.f320957i = (int) ((68.0f * f16) + 0.5f);
                }
                if (this.f320958m == -1) {
                    this.f320958m = (int) ((4.0f * f16) + 0.5f);
                }
                if (this.C == -1) {
                    this.C = (int) (0.0f * f16);
                }
                if (this.f320958m <= 0) {
                    if (this.D) {
                        this.f320955h = getResources().getDrawable(com.tencent.mobileqq.R.drawable.m3a);
                    } else {
                        this.f320955h = getResources().getDrawable(com.tencent.mobileqq.R.drawable.m3b);
                    }
                } else {
                    this.f320955h = null;
                }
                setWillNotDraw(false);
                ViewDragHelper m3 = ViewDragHelper.m(this, 0.5f, interpolator, new c());
                this.f320953f0 = m3;
                m3.N(this.f320948d * f16);
                this.U = true;
            }
        }
        interpolator = null;
        float f162 = context.getResources().getDisplayMetrics().density;
        if (this.f320957i == -1) {
        }
        if (this.f320958m == -1) {
        }
        if (this.C == -1) {
        }
        if (this.f320958m <= 0) {
        }
        setWillNotDraw(false);
        ViewDragHelper m36 = ViewDragHelper.m(this, 0.5f, interpolator, new c());
        this.f320953f0 = m36;
        m36.N(this.f320948d * f162);
        this.U = true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setDragView(int i3) {
        this.H = i3;
        setDragView(findViewById(i3));
    }
}
