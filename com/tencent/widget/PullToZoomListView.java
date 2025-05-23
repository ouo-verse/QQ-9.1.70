package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes27.dex */
public class PullToZoomListView extends XListView {
    static IPatchRedirector $redirector_;
    private static final Interpolator I;
    protected float C;
    protected float D;
    protected float E;
    protected ScalingRunnalable F;
    protected int G;
    protected boolean H;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f384644d;

    /* renamed from: e, reason: collision with root package name */
    protected int f384645e;

    /* renamed from: f, reason: collision with root package name */
    protected FrameLayout f384646f;

    /* renamed from: h, reason: collision with root package name */
    protected View f384647h;

    /* renamed from: i, reason: collision with root package name */
    protected int f384648i;

    /* renamed from: m, reason: collision with root package name */
    protected int f384649m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class ScalingRunnalable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        long f384650d;

        /* renamed from: e, reason: collision with root package name */
        boolean f384651e;

        /* renamed from: f, reason: collision with root package name */
        float f384652f;

        /* renamed from: h, reason: collision with root package name */
        long f384653h;

        ScalingRunnalable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PullToZoomListView.this);
            } else {
                this.f384651e = true;
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f384651e = true;
            }
        }

        public void f(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
                return;
            }
            if (!PullToZoomListView.this.f384644d) {
                return;
            }
            this.f384653h = SystemClock.currentThreadTimeMillis();
            this.f384650d = j3;
            float bottom = PullToZoomListView.this.f384646f.getBottom();
            PullToZoomListView pullToZoomListView = PullToZoomListView.this;
            this.f384652f = bottom / pullToZoomListView.f384648i;
            this.f384651e = false;
            pullToZoomListView.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (PullToZoomListView.this.f384646f != null && !this.f384651e && this.f384652f > 1.0d) {
                float currentThreadTimeMillis = (((float) SystemClock.currentThreadTimeMillis()) - ((float) this.f384653h)) / ((float) this.f384650d);
                float f16 = this.f384652f;
                float interpolation = f16 - ((f16 - 1.0f) * PullToZoomListView.I.getInterpolation(currentThreadTimeMillis));
                ViewGroup.LayoutParams layoutParams = PullToZoomListView.this.f384646f.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = PullToZoomListView.this.f384647h.getLayoutParams();
                if (interpolation > 1.0f) {
                    PullToZoomListView pullToZoomListView = PullToZoomListView.this;
                    int i3 = pullToZoomListView.f384648i;
                    layoutParams.height = i3;
                    int i16 = pullToZoomListView.f384649m;
                    int i17 = (int) (interpolation * i3);
                    layoutParams.height = i17;
                    layoutParams2.height = i17 - i16;
                    pullToZoomListView.f384646f.setLayoutParams(layoutParams);
                    PullToZoomListView.this.f384647h.setLayoutParams(layoutParams2);
                    PullToZoomListView.this.post(this);
                    return;
                }
                this.f384651e = true;
            }
        }
    }

    /* loaded from: classes27.dex */
    class a implements Interpolator {
        static IPatchRedirector $redirector_;

        a() {
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
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            I = new a();
        }
    }

    public PullToZoomListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f384644d = false;
        this.f384645e = -1;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.H = true;
        init(context);
    }

    private void d0() {
        if (!this.f384644d) {
            return;
        }
        if (this.f384646f.getBottom() >= this.f384648i && QLog.isColorLevel()) {
            QLog.d("PullToZoomListView", 2, "endScraling");
        }
        this.F.f(200L);
    }

    private void e0(View view) {
        if (QLog.isColorLevel()) {
            QLog.d("PullToZoomListView", 2, "initHeaderView");
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f384646f = frameLayout;
        frameLayout.addView(view);
    }

    private void init(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.G = displayMetrics.heightPixels;
        this.F = new ScalingRunnalable();
    }

    private void reset() {
        this.f384645e = -1;
        this.C = -1.0f;
        this.E = -1.0f;
        this.D = -1.0f;
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            e0(view);
            super.addHeaderView(this.f384646f);
        }
    }

    public void c0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.H = z16;
        }
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f384644d) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            ScalingRunnalable scalingRunnalable = this.F;
            if (!scalingRunnalable.f384651e) {
                scalingRunnalable.e();
            }
            this.C = motionEvent.getY();
            this.f384645e = motionEvent.getPointerId(0);
            this.E = (this.G * 1.0f) / this.f384648i;
            this.D = this.f384646f.getBottom() / this.f384648i;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f384648i == 0 && (frameLayout = this.f384646f) != null && this.f384647h != null) {
            int height = frameLayout.getHeight();
            this.f384648i = height;
            this.f384649m = height - this.f384647h.getHeight();
            if (QLog.isColorLevel()) {
                QLog.d("PullToZoomListView", 2, "mHeaderHeight:" + this.f384648i + " mHeaderBottomHeight:" + this.f384649m);
            }
            if (this.f384648i > 0) {
                this.f384644d = true;
            }
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.f384644d && this.H) {
            int action = motionEvent.getAction() & 255;
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.C = motionEvent.getY(actionIndex);
                        this.f384645e = motionEvent.getPointerId(actionIndex);
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f384645e);
                    if (findPointerIndex == -1) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PullToZoomListView", 2, "Invalid pointerId=" + this.f384645e + " in onTouchEvent");
                        }
                    } else {
                        if (this.C == -1.0f) {
                            this.C = motionEvent.getY(findPointerIndex);
                        }
                        if (this.f384646f.getBottom() >= this.f384648i) {
                            ViewGroup.LayoutParams layoutParams = this.f384646f.getLayoutParams();
                            ViewGroup.LayoutParams layoutParams2 = this.f384647h.getLayoutParams();
                            float y16 = (motionEvent.getY(findPointerIndex) - this.C) + this.f384646f.getBottom();
                            int i3 = this.f384648i;
                            float f16 = this.D;
                            float f17 = (((y16 / i3) - f16) / 2.0f) + f16;
                            if (f16 <= 1.0d && f17 < f16) {
                                layoutParams.height = i3;
                                layoutParams2.height = i3 - this.f384649m;
                                this.f384646f.setLayoutParams(layoutParams);
                                this.f384647h.setLayoutParams(layoutParams2);
                                return super.onTouchEvent(motionEvent);
                            }
                            float min = Math.min(Math.max(f17, 1.0f), this.E);
                            this.D = min;
                            int i16 = (int) (this.f384648i * min);
                            layoutParams.height = i16;
                            layoutParams2.height = i16 - this.f384649m;
                            if (QLog.isColorLevel()) {
                                QLog.d("PullToZoomListView", 2, "new height:" + layoutParams.height + " imgHeight:" + layoutParams2.height + " mLastScale:" + this.D);
                            }
                            if (layoutParams.height < this.G) {
                                this.f384646f.setLayoutParams(layoutParams);
                                this.f384647h.setLayoutParams(layoutParams2);
                            }
                            this.C = motionEvent.getY(findPointerIndex);
                        } else {
                            this.C = motionEvent.getY(findPointerIndex);
                        }
                    }
                }
            } else {
                reset();
                d0();
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setHeaderImage(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            this.f384647h = view;
        }
    }

    @Override // com.tencent.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, obj, Boolean.valueOf(z16));
        } else {
            e0(view);
            super.addHeaderView(this.f384646f, obj, z16);
        }
    }

    public PullToZoomListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384644d = false;
        this.f384645e = -1;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.H = true;
        init(context);
    }

    public PullToZoomListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f384644d = false;
        this.f384645e = -1;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.H = true;
        init(context);
    }
}
