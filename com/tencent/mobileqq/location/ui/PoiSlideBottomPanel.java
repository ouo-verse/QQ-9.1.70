package com.tencent.mobileqq.location.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.SlideBottomPanel;
import com.tencent.mobileqq.widget.r;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes15.dex */
public class PoiSlideBottomPanel extends SlideBottomPanel {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    private View f241539g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f241540h0;

    /* renamed from: i0, reason: collision with root package name */
    private View.OnLayoutChangeListener f241541i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f241542j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f241543d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f241544e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f241545f;

        a(View view, float f16, float f17) {
            this.f241543d = view;
            this.f241544e = f16;
            this.f241545f = f17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PoiSlideBottomPanel.this, view, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                Float f16 = (Float) animatedValue;
                this.f241543d.setY(f16.floatValue());
                if (QLog.isColorLevel()) {
                    QLog.d("PoiSlideBottomPanel", 2, "[panel] onAnimationUpdate: show invoked. mPanel:" + this.f241543d.getId() + " org: " + this.f241544e + " dest: " + this.f241545f + " value: " + this.f241543d.getY());
                }
                if (((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0 != null) {
                    ((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0.fadeBackground(1.0f - (f16.floatValue() / (((SlideBottomPanel) PoiSlideBottomPanel.this).G - ((SlideBottomPanel) PoiSlideBottomPanel.this).P)));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PoiSlideBottomPanel.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                ((SlideBottomPanel) PoiSlideBottomPanel.this).f316271f = false;
                if (((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0 != null) {
                    ((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0.displayPanelFinish();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ((SlideBottomPanel) PoiSlideBottomPanel.this).f316271f = false;
                if (((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0 != null) {
                    ((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0.displayPanelFinish();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ((SlideBottomPanel) PoiSlideBottomPanel.this).f316271f = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f241548d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f241549e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f241550f;

        c(View view, float f16, int i3) {
            this.f241548d = view;
            this.f241549e = f16;
            this.f241550f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PoiSlideBottomPanel.this, view, Float.valueOf(f16), Integer.valueOf(i3));
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                Float f16 = (Float) animatedValue;
                this.f241548d.setY(f16.floatValue());
                if (QLog.isColorLevel()) {
                    QLog.d("PoiSlideBottomPanel", 2, "[panel] onAnimationUpdate: hide invoked. org: " + this.f241549e + " dest: " + this.f241550f + " value: " + this.f241548d.getY());
                }
                if (((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0 != null) {
                    ((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0.fadeBackground(1.0f - (f16.floatValue() / this.f241550f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class d extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PoiSlideBottomPanel.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                ((SlideBottomPanel) PoiSlideBottomPanel.this).f316271f = false;
                ((SlideBottomPanel) PoiSlideBottomPanel.this).f316272h = false;
                ((SlideBottomPanel) PoiSlideBottomPanel.this).W = false;
                if (((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0 != null) {
                    ((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0.hidePanelFinish();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ((SlideBottomPanel) PoiSlideBottomPanel.this).f316271f = false;
                ((SlideBottomPanel) PoiSlideBottomPanel.this).f316272h = false;
                ((SlideBottomPanel) PoiSlideBottomPanel.this).W = false;
                if (((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0 != null) {
                    ((SlideBottomPanel) PoiSlideBottomPanel.this).f316270e0.hidePanelFinish();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ((SlideBottomPanel) PoiSlideBottomPanel.this).f316271f = true;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    public PoiSlideBottomPanel(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        view.setTop(i26);
        view.setBottom(i28);
        view.setLeft(i19);
        view.setRight(i27);
    }

    public int S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.f241542j0;
    }

    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        View findViewWithTag = findViewWithTag(1);
        if (findViewWithTag == null) {
            return;
        }
        if (this.f316272h) {
            findViewWithTag.setY(this.G - this.N);
        } else if (!this.W) {
            findViewWithTag.setY(this.G - this.P);
        }
    }

    @Override // com.tencent.mobileqq.widget.SlideBottomPanel
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!this.f316272h && !this.f316271f) {
            View findViewWithTag = findViewWithTag(1);
            float y16 = findViewWithTag.getY();
            float f16 = this.G - this.N;
            ValueAnimator duration = ValueAnimator.ofFloat(findViewWithTag.getY(), this.G - this.N).setDuration(this.R);
            duration.setTarget(findViewWithTag);
            duration.setInterpolator(this.f316264a0);
            duration.addUpdateListener(new a(findViewWithTag, y16, f16));
            duration.addListener(new b());
            duration.start();
            this.f316272h = true;
            this.W = false;
            r rVar = this.f316270e0;
            if (rVar != null) {
                rVar.displayPanel();
            }
        }
    }

    @Override // com.tencent.mobileqq.widget.SlideBottomPanel
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.T;
    }

    @Override // com.tencent.mobileqq.widget.SlideBottomPanel
    protected boolean f(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean z16 = false;
        if (System.currentTimeMillis() - this.L <= 500) {
            return false;
        }
        this.L = System.currentTimeMillis();
        this.H = motionEvent.getX();
        float y16 = motionEvent.getY();
        this.J = y16;
        this.I = y16;
        Rect rect = new Rect();
        this.f241539g0.getGlobalVisibleRect(rect);
        float f16 = this.J;
        if (f16 > rect.top && f16 < rect.bottom) {
            z16 = true;
        }
        this.S = z16;
        if (QLog.isColorLevel()) {
            QLog.d("PoiSlideBottomPanel", 2, "[panel] handleActionDown: invoked. firstDownY: " + this.I + " actionRect: " + rect + " isConsume: " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.widget.SlideBottomPanel
    protected void g(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent);
            return;
        }
        if (!this.S) {
            return;
        }
        a();
        if (this.f241540h0 == null) {
            this.f241540h0 = findViewWithTag(1);
        }
        if (!this.M && Math.abs(motionEvent.getY() - this.I) > this.C) {
            this.M = true;
            this.J = motionEvent.getY();
            if (this.f241541i0 == null) {
                this.f241541i0 = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.location.ui.l
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                        PoiSlideBottomPanel.T(view, i3, i16, i17, i18, i19, i26, i27, i28);
                    }
                };
            }
            this.f241540h0.addOnLayoutChangeListener(this.f241541i0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PoiSlideBottomPanel", 2, "[panel] handleActionDown: invoked. isDragging: " + this.M + " Math.abs(event.getY() - firstDownY): " + Math.abs(motionEvent.getY() - this.I) + " mTouchSlop: " + this.C);
        }
        if (this.M) {
            this.K = motionEvent.getY() - this.J;
            this.J = motionEvent.getY();
            float y16 = this.f241540h0.getY();
            if (this.f316270e0 != null) {
                int i3 = this.G;
                if (y16 > i3 - this.N && y16 < i3 - this.P) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PoiSlideBottomPanel", 2, "[panel] fadeBackground: invoked. touchingViewY: " + y16 + " mMeasureHeight: " + this.G + " mPanelHeight: " + this.N + " mTitleHeightNoDisplay: " + this.P + " mMeasureHeight - mPanelHeight: " + (this.G - this.N) + " mMeasureHeight - mTitleHeightNoDisplay: " + (this.G - this.P));
                    }
                    this.f316270e0.fadeBackground(1.0f - (y16 / (this.G - this.P)));
                }
            }
            float f16 = this.K;
            float f17 = y16 + f16;
            int i16 = this.G;
            float f18 = this.N;
            if (f17 <= i16 - f18) {
                this.f241540h0.offsetTopAndBottom((int) ((i16 - f18) - y16));
                return;
            }
            if (y16 + f16 >= e()) {
                if (this.W) {
                    return;
                }
                float f19 = this.K;
                int i17 = this.U;
                if (f19 > i17) {
                    this.K = i17;
                }
                this.f241540h0.offsetTopAndBottom((int) this.K);
                return;
            }
            this.f241540h0.offsetTopAndBottom((int) this.K);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.widget.SlideBottomPanel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void h(MotionEvent motionEvent) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent);
            return;
        }
        if (!this.S) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.L;
        a();
        if (this.f316272h || motionEvent.getY() - this.I >= 0.0f || Math.abs(motionEvent.getY() - this.I) <= this.Q) {
            float f16 = this.f316274m;
            if (f16 >= 0.0f || Math.abs(f16) <= Math.abs(this.f316273i) || Math.abs(this.f316274m) <= this.E) {
                if (currentTimeMillis < 300 && c(this.H, this.I, motionEvent.getX(), motionEvent.getY()) < SlideBottomPanel.f316263f0 + 5.0f) {
                    if (this.f316272h) {
                        j();
                    } else {
                        b();
                        this.f241542j0 = 1;
                    }
                } else if (!this.f316272h && this.M) {
                    int y16 = (int) (motionEvent.getY() - this.I);
                    boolean z16 = this.W;
                    if ((!z16 && y16 > this.V) || (z16 && y16 < 0 && Math.abs(y16) < this.Q)) {
                        o();
                    }
                    if (!this.W && y16 < 0 && Math.abs(y16) < this.Q) {
                        p();
                    }
                }
                if (this.f316272h) {
                    View findViewWithTag = findViewWithTag(1);
                    float y17 = findViewWithTag.getY();
                    int i3 = this.G;
                    float f17 = this.N;
                    if (y17 >= i3 - f17) {
                        float f18 = this.Q;
                        if (y17 >= (i3 - f17) + f18) {
                            if (y17 > (i3 - f17) + f18) {
                                j();
                            }
                        }
                    }
                    ObjectAnimator.ofFloat(findViewWithTag, "y", y17, i3 - f17).setDuration(this.R).start();
                }
                this.S = false;
                this.M = false;
                this.K = 0.0f;
                view = this.f241540h0;
                if (view == null) {
                    view.removeOnLayoutChangeListener(this.f241541i0);
                    return;
                }
                return;
            }
        }
        b();
        if (this.f316272h) {
        }
        this.S = false;
        this.M = false;
        this.K = 0.0f;
        view = this.f241540h0;
        if (view == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.SlideBottomPanel
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.f316271f) {
            return;
        }
        View findViewWithTag = findViewWithTag(1);
        int i3 = (int) (this.G - this.P);
        float y16 = findViewWithTag.getY();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(findViewWithTag.getY(), this.G - this.P);
        ofFloat.setInterpolator(this.f316265b0);
        ofFloat.setTarget(findViewWithTag);
        ofFloat.setDuration(500L);
        ofFloat.addUpdateListener(new c(findViewWithTag, y16, i3));
        ofFloat.addListener(new d());
        ofFloat.start();
        r rVar = this.f316270e0;
        if (rVar != null) {
            rVar.hidePanel();
        }
    }

    public void setBottomHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.T = i3;
        }
    }

    public void setDisplayFromType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f241542j0 = i3;
        }
    }

    public void setDragView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            this.f241539g0 = view;
        }
    }

    public void setTitleHeightNoDisplay(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.P = i3;
        }
    }

    public PoiSlideBottomPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PoiSlideBottomPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f241542j0 = 2;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
