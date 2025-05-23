package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class QQViewPager extends ViewPager {
    private static final byte SLIDE_DIR_DEFAULT = 0;
    private static final byte SLIDE_DIR_HORIZONTAL = 1;
    private static final byte SLIDE_DIR_VERTICAL = 2;
    private static final String TAG = "QQViewPager";
    private boolean disable;
    private boolean disableDrop;
    private int downX;
    private int downY;
    private byte mSlideDir;
    private boolean requestParentDisallowInterceptTouchEvent;
    private final int scaledTouchSlop;

    public QQViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSlideDir = (byte) 0;
        this.disable = false;
        this.disableDrop = false;
        this.requestParentDisallowInterceptTouchEvent = false;
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void doInterceptTouchEvent(boolean z16) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void handleEvent(MotionEvent motionEvent) {
        if (this.disable) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return;
                        }
                    } else {
                        if (this.mSlideDir == 0) {
                            judgeScrollDirection(Math.abs(rawX - this.downX), Math.abs(rawY - this.downY));
                        }
                        if (this.mSlideDir == 1) {
                            doInterceptTouchEvent(true);
                            return;
                        }
                        return;
                    }
                }
                this.mSlideDir = (byte) 0;
                doInterceptTouchEvent(false);
                return;
            }
            this.downX = rawX;
            this.downY = rawY;
        }
    }

    private void judgeScrollDirection(float f16, float f17) {
        int i3 = this.scaledTouchSlop;
        if (f16 > i3 || f17 > i3) {
            if (f16 > i3 && f17 / f16 < 0.6f) {
                this.mSlideDir = (byte) 1;
            } else {
                this.mSlideDir = (byte) 2;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "judgeScrollDirection : mSlideDir -> " + ((int) this.mSlideDir));
        }
    }

    public void disableDrop(boolean z16) {
        this.disableDrop = z16;
    }

    public void disableGesture(boolean z16) {
        this.disable = z16;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.disable) {
            handleEvent(motionEvent);
        } else if (this.requestParentDisallowInterceptTouchEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                doInterceptTouchEvent(true);
            } else if (action == 1 || action == 3) {
                doInterceptTouchEvent(false);
            }
        }
        if (this.disableDrop) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        handleEvent(motionEvent);
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void requestParentDisallowInterecptTouchEvent(boolean z16) {
        this.requestParentDisallowInterceptTouchEvent = z16;
    }

    public QQViewPager(Context context) {
        super(context);
        this.mSlideDir = (byte) 0;
        this.disable = false;
        this.disableDrop = false;
        this.requestParentDisallowInterceptTouchEvent = false;
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
