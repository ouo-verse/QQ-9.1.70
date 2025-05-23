package com.tencent.centaur.host.loader.debug.base;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class CentaurDragFloatTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f99131d;

    /* renamed from: e, reason: collision with root package name */
    private int f99132e;

    /* renamed from: f, reason: collision with root package name */
    private int f99133f;

    /* renamed from: h, reason: collision with root package name */
    private int f99134h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f99135i;

    public CentaurDragFloatTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private boolean a() {
        if (!this.f99135i && (getX() == 0.0f || getX() == this.f99132e - getWidth())) {
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            float f16 = 0.0f;
            if (action != 1) {
                if (action == 2) {
                    if (this.f99131d > 0 && this.f99132e != 0) {
                        this.f99135i = true;
                        int i3 = rawX - this.f99133f;
                        int i16 = rawY - this.f99134h;
                        if (((int) Math.sqrt((i3 * i3) + (i16 * i16))) == 0) {
                            this.f99135i = false;
                        } else {
                            float x16 = getX() + i3;
                            float y16 = getY() + i16;
                            if (x16 < 0.0f) {
                                x16 = 0.0f;
                            } else if (x16 > this.f99132e - getWidth()) {
                                x16 = this.f99132e - getWidth();
                            }
                            if (getY() >= 0.0f) {
                                float y17 = getY() + getHeight();
                                int i17 = this.f99131d;
                                if (y17 > i17) {
                                    f16 = i17 - getHeight();
                                } else {
                                    f16 = y16;
                                }
                            }
                            setX(x16);
                            setY(f16);
                            this.f99133f = rawX;
                            this.f99134h = rawY;
                            Log.i("aa", "isDrag=" + this.f99135i + "getX=" + getX() + ";getY=" + getY() + ";parentWidth=" + this.f99132e);
                        }
                    } else {
                        this.f99135i = false;
                    }
                }
            } else if (!a()) {
                setPressed(false);
                if (rawX >= this.f99132e / 2) {
                    animate().setInterpolator(new DecelerateInterpolator()).setDuration(500L).xBy((this.f99132e - getWidth()) - getX()).start();
                } else {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, HippyTKDListViewAdapter.X, getX(), 0.0f);
                    ofFloat.setInterpolator(new DecelerateInterpolator());
                    ofFloat.setDuration(500L);
                    ofFloat.start();
                }
            }
        } else {
            setPressed(true);
            this.f99135i = false;
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f99133f = rawX;
            this.f99134h = rawY;
            if (getParent() != null) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                this.f99131d = viewGroup.getHeight();
                this.f99132e = viewGroup.getWidth();
            }
        }
        if (a() && !super.onTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    public CentaurDragFloatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public CentaurDragFloatTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
