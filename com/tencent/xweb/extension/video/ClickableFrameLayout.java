package com.tencent.xweb.extension.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ClickableFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public View.OnClickListener f385128a;

    /* renamed from: b, reason: collision with root package name */
    public GestureDetector f385129b;

    public ClickableFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f385128a != null) {
            return true;
        }
        return false;
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.f385129b = gestureDetector;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f385128a = onClickListener;
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @TargetApi(21)
    public ClickableFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
    }
}
