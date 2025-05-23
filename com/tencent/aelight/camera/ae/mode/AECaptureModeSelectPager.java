package com.tencent.aelight.camera.ae.mode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes32.dex */
public class AECaptureModeSelectPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name */
    private boolean f65601d;

    public AECaptureModeSelectPager(Context context) {
        super(context);
        this.f65601d = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f65601d && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.f65601d && super.onTouchEvent(motionEvent);
    }

    public void setDisableScroll(boolean z16) {
        this.f65601d = z16;
    }

    public AECaptureModeSelectPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f65601d = false;
    }
}
