package com.tencent.mobileqq.guild.widget.qqui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes14.dex */
public class QQViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private final int f236475d;

    /* renamed from: e, reason: collision with root package name */
    private byte f236476e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f236477f;

    /* renamed from: h, reason: collision with root package name */
    private int f236478h;

    /* renamed from: i, reason: collision with root package name */
    private int f236479i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f236480m;

    public QQViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236476e = (byte) 0;
        this.f236477f = false;
        this.f236480m = false;
        this.f236475d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void doInterceptTouchEvent(boolean z16) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQViewPager", 2, "doInterceptTouchEvent : " + z16);
            }
            viewGroup.requestDisallowInterceptTouchEvent(z16);
        }
    }

    private void handleEvent(MotionEvent motionEvent) {
        if (this.f236477f) {
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
                        if (this.f236476e == 0) {
                            judgeScrollDirection(Math.abs(rawX - this.f236478h), Math.abs(rawY - this.f236479i));
                        }
                        if (this.f236476e == 1) {
                            doInterceptTouchEvent(true);
                            return;
                        }
                        return;
                    }
                }
                this.f236476e = (byte) 0;
                doInterceptTouchEvent(false);
                return;
            }
            this.f236478h = rawX;
            this.f236479i = rawY;
        }
    }

    private void judgeScrollDirection(float f16, float f17) {
        int i3 = this.f236475d;
        if (f16 > i3 || f17 > i3) {
            if (f16 > i3 && f17 / f16 < 0.6f) {
                this.f236476e = (byte) 1;
            } else {
                this.f236476e = (byte) 2;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQViewPager", 2, "judgeScrollDirection : mSlideDir -> " + ((int) this.f236476e));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f236477f) {
            handleEvent(motionEvent);
        } else if (this.f236480m) {
            int action = motionEvent.getAction();
            if (action == 0) {
                doInterceptTouchEvent(true);
            } else if (action == 1 || action == 3) {
                doInterceptTouchEvent(false);
            }
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

    public QQViewPager(Context context) {
        super(context);
        this.f236476e = (byte) 0;
        this.f236477f = false;
        this.f236480m = false;
        this.f236475d = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
