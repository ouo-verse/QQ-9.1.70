package com.tencent.mobileqq.gamecenter.yungame;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes12.dex */
public class DragFloatActionButton extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private int f213505d;

    /* renamed from: e, reason: collision with root package name */
    private int f213506e;

    /* renamed from: f, reason: collision with root package name */
    private int f213507f;

    /* renamed from: h, reason: collision with root package name */
    private int f213508h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f213509i;

    public DragFloatActionButton(Context context) {
        super(context);
    }

    private boolean a() {
        if (!this.f213509i && (getX() == 0.0f || getX() == this.f213506e - getWidth())) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            float f16 = 0.0f;
            if (action != 1) {
                if (action == 2) {
                    if (this.f213505d > 0 && this.f213506e != 0) {
                        this.f213509i = true;
                        int i3 = rawX - this.f213507f;
                        int i16 = rawY - this.f213508h;
                        if (((int) Math.sqrt((i3 * i3) + (i16 * i16))) == 0) {
                            this.f213509i = false;
                        } else {
                            float x16 = getX() + i3;
                            float y16 = getY() + i16;
                            if (x16 < 0.0f) {
                                x16 = 0.0f;
                            } else if (x16 > this.f213506e - getWidth()) {
                                x16 = this.f213506e - getWidth();
                            }
                            if (getY() >= 0.0f) {
                                float y17 = getY() + getHeight();
                                int i17 = this.f213505d;
                                if (y17 > i17) {
                                    f16 = i17 - getHeight();
                                } else {
                                    f16 = y16;
                                }
                            }
                            setX(x16);
                            setY(f16);
                            this.f213507f = rawX;
                            this.f213508h = rawY;
                            Log.i("aa", "isDrag=" + this.f213509i + "getX=" + getX() + ";getY=" + getY() + ";parentWidth=" + this.f213506e);
                        }
                    } else {
                        this.f213509i = false;
                    }
                }
            } else if (!a()) {
                setPressed(false);
                if (rawX >= this.f213506e / 2) {
                    animate().setInterpolator(new DecelerateInterpolator()).setDuration(500L).xBy((this.f213506e - getWidth()) - getX()).start();
                } else {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, HippyTKDListViewAdapter.X, getX(), 0.0f);
                    ofFloat.setInterpolator(new DecelerateInterpolator());
                    ofFloat.setDuration(500L);
                    ofFloat.start();
                }
            }
        } else {
            setPressed(true);
            this.f213509i = false;
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f213507f = rawX;
            this.f213508h = rawY;
            if (getParent() != null) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                this.f213505d = viewGroup.getHeight();
                this.f213506e = viewGroup.getWidth();
            }
        }
        if (a() && !super.onTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public DragFloatActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DragFloatActionButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
