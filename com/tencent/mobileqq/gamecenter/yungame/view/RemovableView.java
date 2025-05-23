package com.tencent.mobileqq.gamecenter.yungame.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.gamecenter.yungame.a;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class RemovableView extends FrameLayout {
    protected int C;
    protected int D;
    protected int E;
    protected boolean F;

    /* renamed from: d, reason: collision with root package name */
    protected final Context f213593d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f213594e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f213595f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f213596h;

    /* renamed from: i, reason: collision with root package name */
    protected float f213597i;

    /* renamed from: m, reason: collision with root package name */
    protected float f213598m;

    public RemovableView(Context context) {
        this(context, null);
    }

    public abstract void a();

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float min;
        if (this.f213596h) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            boolean z16 = false;
            if (action != 0) {
                float f16 = 0.0f;
                if (action != 1) {
                    if (action == 2 && rawX >= 0.0f && rawX <= this.C) {
                        if (rawY >= this.E && rawY <= this.D + r3) {
                            float f17 = rawX - this.f213597i;
                            float f18 = rawY - this.f213598m;
                            if (!this.f213594e) {
                                if (Math.sqrt((f17 * f17) + (f18 * f18)) >= 2.0d) {
                                    z16 = true;
                                }
                                this.f213594e = z16;
                            }
                            float x16 = getX() + f17;
                            float y16 = getY() + f18;
                            float width = this.C - getWidth();
                            float height = this.D - getHeight();
                            if (x16 < 0.0f) {
                                min = 0.0f;
                            } else {
                                min = Math.min(x16, width);
                            }
                            if (y16 >= 0.0f) {
                                f16 = Math.min(y16, height);
                            }
                            if (this.F) {
                                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
                                Log.d("YunGame.RemovableView", "[onTouchEvent] X:" + layoutParams.x + ",Y:" + layoutParams.y + ",differenceValueX:" + f17 + ",differenceValueY:" + f18);
                                layoutParams.x = ((int) f17) + layoutParams.x;
                                layoutParams.y = ((int) f18) + layoutParams.y;
                                ((WindowManager) this.f213593d.getSystemService("window")).updateViewLayout(this, layoutParams);
                                Log.d("YunGame.RemovableView", "[onTouchEvent] endX:" + min + ",endY:" + f16 + ",differenceValueX:" + f17 + ",differenceValueY:" + f18);
                                Log.d("YunGame.RemovableView", "[onTouchEvent] X:" + layoutParams.x + ",Y:" + layoutParams.y + ",differenceValueX:" + f17 + ",differenceValueY:" + f18);
                            } else {
                                setX(min);
                                setY(f16);
                            }
                            this.f213597i = rawX;
                            this.f213598m = rawY;
                        }
                    }
                } else if (this.f213595f && this.f213594e) {
                    float f19 = this.C >> 1;
                    if (this.F) {
                        if (this.f213597i <= f19) {
                            this.f213597i = 0.0f;
                            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
                            layoutParams2.x = (int) this.f213597i;
                            ((WindowManager) this.f213593d.getSystemService("window")).updateViewLayout(this, layoutParams2);
                        } else {
                            this.f213597i = r1 - getWidth();
                            WindowManager.LayoutParams layoutParams3 = (WindowManager.LayoutParams) getLayoutParams();
                            layoutParams3.x = (int) this.f213597i;
                            ((WindowManager) this.f213593d.getSystemService("window")).updateViewLayout(this, layoutParams3);
                        }
                    } else if (this.f213597i <= f19) {
                        this.f213597i = 0.0f;
                        animate().setInterpolator(new DecelerateInterpolator()).setDuration(500L).x(this.f213597i).start();
                    } else {
                        this.f213597i = r1 - getWidth();
                        animate().setInterpolator(new DecelerateInterpolator()).setDuration(500L).x(this.f213597i).start();
                    }
                }
            } else {
                this.f213594e = false;
                this.f213597i = rawX;
                this.f213598m = rawY;
                if (!this.F) {
                    ViewGroup viewGroup = (ViewGroup) getParent();
                    if (viewGroup != null) {
                        int[] iArr = new int[2];
                        viewGroup.getLocationInWindow(iArr);
                        this.D = viewGroup.getMeasuredHeight();
                        this.C = viewGroup.getMeasuredWidth();
                        this.E = iArr[1];
                    }
                } else {
                    int[] e16 = a.e(getContext());
                    this.C = e16[0];
                    this.D = e16[1];
                    this.E = 0;
                }
                QLog.d("YunGame.RemovableView", 1, "[onTouchEvent] size:" + this.C + "," + this.D + "; topY:" + this.E);
            }
        }
        boolean z17 = this.f213594e;
        if (!z17) {
            return super.onTouchEvent(motionEvent);
        }
        return z17;
    }

    public void setIsAddToWindowManager(boolean z16) {
        this.F = z16;
    }

    public void setParentSize(int i3, int i16) {
        this.D = i16;
        this.C = i3;
    }

    public RemovableView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemovableView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f213594e = true;
        this.f213595f = true;
        this.f213596h = true;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.f213593d = context;
        a();
    }
}
