package com.tencent.sqshow.zootopia.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes34.dex */
public class AlphaClickableLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private float f373393d;

    public AlphaClickableLinearLayout(Context context) {
        super(context);
        this.f373393d = 0.6f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                setAlpha(this.f373393d);
            } else if (action == 1 || action == 3) {
                setAlpha(1.0f);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setClickAlpha(float f16) {
        this.f373393d = f16;
    }

    public AlphaClickableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f373393d = 0.6f;
    }

    public AlphaClickableLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f373393d = 0.6f;
    }
}
