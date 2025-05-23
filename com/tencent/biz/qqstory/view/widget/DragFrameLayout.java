package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DragFrameLayout extends FrameLayout {
    private int C;
    private int D;
    private a E;
    private int F;
    private TranslateAnimation G;
    private ScaleAnimation H;
    private AnimationSet I;
    protected boolean J;
    protected boolean K;

    /* renamed from: d, reason: collision with root package name */
    public int f94506d;

    /* renamed from: e, reason: collision with root package name */
    private View f94507e;

    /* renamed from: f, reason: collision with root package name */
    private float f94508f;

    /* renamed from: h, reason: collision with root package name */
    private float f94509h;

    /* renamed from: i, reason: collision with root package name */
    private float f94510i;

    /* renamed from: m, reason: collision with root package name */
    private float f94511m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        boolean C9();

        boolean bg();

        void jd(int i3, int i16, int i17, int i18, int i19, int i26);

        void sa(View view, int i3, int i16, int i17, int i18, int i19, int i26);

        boolean xa();
    }

    public DragFrameLayout(Context context) {
        super(context);
        this.f94508f = 0.0f;
        this.f94509h = 0.0f;
        this.f94510i = 0.0f;
        this.f94511m = 0.0f;
        this.C = 0;
        this.D = 0;
        this.F = 0;
        this.K = true;
    }

    public void b(int i3) {
        c(i3, new LinearInterpolator(), null);
    }

    public void c(int i3, Interpolator interpolator, Animation.AnimationListener animationListener) {
        float scaleX = ViewHelper.getScaleX(this.f94507e);
        float scaleY = ViewHelper.getScaleY(this.f94507e);
        TranslateAnimation translateAnimation = this.G;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0, ViewHelper.getX(this.f94507e), 0, 0.0f, 0, ViewHelper.getY(this.f94507e), 0, 0.0f);
        this.G = translateAnimation2;
        long j3 = i3;
        translateAnimation2.setDuration(j3);
        this.G.setFillAfter(true);
        if (animationListener != null) {
            this.G.setAnimationListener(animationListener);
        }
        ScaleAnimation scaleAnimation = this.H;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(scaleX, 1.0f, scaleY, 1.0f, 0.0f, 0.0f);
        this.H = scaleAnimation2;
        scaleAnimation2.setDuration(j3);
        this.H.setFillAfter(true);
        AnimationSet animationSet = this.I;
        if (animationSet != null) {
            animationSet.cancel();
        }
        AnimationSet animationSet2 = new AnimationSet(true);
        this.I = animationSet2;
        animationSet2.addAnimation(this.H);
        this.I.addAnimation(this.G);
        this.I.setInterpolator(interpolator);
        this.f94507e.startAnimation(this.I);
        this.J = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TranslateAnimation translateAnimation = this.G;
        if (translateAnimation != null) {
            translateAnimation.cancel();
            this.G = null;
        }
        ScaleAnimation scaleAnimation = this.H;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
            this.H = null;
        }
        AnimationSet animationSet = this.I;
        if (animationSet != null) {
            animationSet.cancel();
            this.I = null;
        }
        View view = this.f94507e;
        if (view != null) {
            view.clearAnimation();
            AnimatorProxy.wrap(this.f94507e).reset();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.K && this.f94507e != null) {
            if (motionEvent.getPointerCount() > 1) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (this.J) {
                return true;
            }
            int action = motionEvent.getAction();
            this.f94510i = motionEvent.getX();
            float y16 = motionEvent.getY();
            this.f94511m = y16;
            if (action == 0) {
                this.f94508f = this.f94510i;
                this.f94509h = y16;
                if (this.C == 0) {
                    this.C = super.getWidth();
                    this.D = super.getHeight();
                }
                this.f94507e.clearAnimation();
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (action == 2) {
                float abs = Math.abs(this.f94510i - this.f94508f) + Math.abs(this.f94511m - this.f94509h);
                if (this.F == 0 && abs < x.c(getContext(), 10.0f)) {
                    return false;
                }
                float f16 = this.f94510i - this.f94508f;
                float f17 = this.f94511m - this.f94509h;
                if (f17 < 0.0f && Math.abs(f17) > Math.abs(f16) && this.F == 0) {
                    this.f94508f = this.f94510i;
                    this.f94509h = this.f94511m;
                    return false;
                }
                if (Math.abs(f17) > Math.abs(f16) * 1.2d) {
                    if (this.F == 0) {
                        if (this.K && this.E.xa()) {
                            this.f94508f = this.f94510i;
                            this.f94509h = this.f94511m;
                            this.F = 1;
                            return true;
                        }
                        this.f94508f = this.f94510i;
                        this.f94509h = this.f94511m;
                        return false;
                    }
                } else if (f16 < 0.0f) {
                    if (this.F == 0) {
                        if (this.K && this.E.bg()) {
                            this.f94508f = this.f94510i;
                            this.f94509h = this.f94511m;
                            this.F = 2;
                            return true;
                        }
                        this.f94508f = this.f94510i;
                        this.f94509h = this.f94511m;
                        return false;
                    }
                } else if (f16 > 0.0f) {
                    if (this.F == 0) {
                        if (this.K && (aVar = this.E) != null && aVar.C9()) {
                            this.f94508f = this.f94510i;
                            this.f94509h = this.f94511m;
                            this.F = 4;
                            return true;
                        }
                        this.f94508f = this.f94510i;
                        this.f94509h = this.f94511m;
                        return false;
                    }
                } else {
                    this.f94508f = this.f94510i;
                    this.f94509h = this.f94511m;
                }
            }
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f16;
        float f17;
        int i3;
        float f18;
        int i16;
        int i17;
        int i18;
        if (!this.K) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.J) {
            return true;
        }
        int action = motionEvent.getAction();
        this.f94510i = motionEvent.getX();
        float y16 = motionEvent.getY();
        this.f94511m = y16;
        if (action == 0) {
            this.f94508f = this.f94510i;
            this.f94509h = y16;
        } else {
            if (action == 2) {
                float f19 = this.f94510i;
                float f26 = this.f94508f;
                float f27 = f19 - f26;
                float f28 = this.f94509h;
                float f29 = y16 - f28;
                int i19 = this.F;
                if (i19 == 1) {
                    if (f29 > 0.0f) {
                        i18 = (int) (this.D - (f29 * 1.1d));
                    } else {
                        i18 = this.D;
                    }
                    f16 = i18;
                    f17 = (this.C * f16) / this.D;
                } else {
                    if (i19 == 2) {
                        if (f27 < 0.0f) {
                            i17 = (int) (this.C + (f27 * 1.1d));
                        } else {
                            i17 = this.C;
                        }
                        f17 = i17;
                        f18 = this.D * f17;
                        i16 = this.C;
                    } else if (i19 == 4) {
                        if (f27 > 0.0f) {
                            i3 = (int) (this.C - (f27 * 1.1d));
                        } else {
                            i3 = this.C;
                        }
                        f17 = i3;
                        f18 = this.D * f17;
                        i16 = this.C;
                    } else {
                        f16 = 0.0f;
                        f17 = 0.0f;
                    }
                    f16 = f18 / i16;
                }
                int i26 = this.f94506d;
                if (f17 <= i26) {
                    f17 = i26;
                    f16 = (this.D * f17) / this.C;
                }
                if (i19 == 1) {
                    int i27 = this.C;
                    float f36 = f17 / i27;
                    int i28 = (int) ((f27 + f26) - ((f17 * f26) / i27));
                    if (f29 <= 0.0f) {
                        f29 /= 2.0f;
                    }
                    setSizeAndPosition(f36, i28, (int) f29);
                } else if (i19 == 2) {
                    int i29 = this.C;
                    float f37 = f17 / i29;
                    float f38 = i29 - f17;
                    if (f27 >= 0.0f) {
                        f27 /= 2.0f;
                    }
                    setSizeAndPosition(f37, (int) (f38 + f27), (int) ((f29 + f28) - ((f16 * f28) / this.D)));
                } else if (i19 == 4) {
                    float f39 = f17 / this.C;
                    if (f27 <= 0.0f) {
                        f27 /= 2.0f;
                    }
                    setSizeAndPosition(f39, (int) f27, (int) ((f29 + f28) - ((f16 * f28) / this.D)));
                }
                return true;
            }
            if (action == 1 || action == 3) {
                if (this.F != 0) {
                    this.J = true;
                    if (this.E != null) {
                        float scaleX = ViewHelper.getScaleX(this.f94507e);
                        float scaleY = ViewHelper.getScaleY(this.f94507e);
                        if (scaleX > 0.0f && scaleY > 0.0f) {
                            a aVar = this.E;
                            View view = this.f94507e;
                            int i36 = this.C;
                            int i37 = this.D;
                            aVar.sa(view, i36, i37, (int) (i36 * scaleX), (int) (i37 * scaleY), (int) ViewHelper.getX(view), (int) ViewHelper.getY(this.f94507e));
                        }
                    }
                }
                this.F = 0;
            }
        }
        return true;
    }

    public void setDraggableView(View view) {
        this.f94507e = view;
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        this.K = z16;
    }

    public void setOnDraggingListener(a aVar) {
        this.E = aVar;
    }

    public void setSizeAndPosition(float f16, int i3, int i16) {
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        ViewHelper.setPivotX(this.f94507e, 0.0f);
        ViewHelper.setPivotY(this.f94507e, 0.0f);
        ViewHelper.setScaleX(this.f94507e, f16);
        ViewHelper.setScaleY(this.f94507e, f16);
        ViewHelper.setX(this.f94507e, i3);
        ViewHelper.setY(this.f94507e, i16);
        a aVar = this.E;
        if (aVar != null) {
            int i17 = this.C;
            int i18 = this.D;
            aVar.jd(i3, i16, i17, i18, (int) (i17 * f16), (int) (i18 * f16));
        }
    }

    public void setDraggableView(View view, int i3, int i16) {
        this.f94507e = view;
        this.C = i3;
        this.D = i16;
    }

    public DragFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94508f = 0.0f;
        this.f94509h = 0.0f;
        this.f94510i = 0.0f;
        this.f94511m = 0.0f;
        this.C = 0;
        this.D = 0;
        this.F = 0;
        this.K = true;
    }

    @Deprecated
    public void a() {
    }
}
